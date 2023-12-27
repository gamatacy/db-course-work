-- Получить кофе или создать если такого еще не существует
CREATE OR REPLACE FUNCTION create_or_get_coffee(
    p_beans_id INTEGER,
    p_milk_id INTEGER,
    p_syrup_id INTEGER,
    p_coffee_size_id INTEGER
)
    RETURNS coffee_ref AS
$$
DECLARE
    coffee_result coffee_ref;
BEGIN
    -- Пытаемся выбрать запись с указанными параметрами
    SELECT *
    INTO coffee_result
    FROM coffee_ref
    WHERE beans_id = p_beans_id
      AND milk_id = p_milk_id
      AND syrup_id = p_syrup_id
      AND coffee_size_id = p_coffee_size_id;

    -- Если запись существует, возвращаем ее
    IF FOUND THEN
        RETURN coffee_result;
    ELSE
        -- Запись не существует, создаем новую
        INSERT INTO coffee_ref (beans_id, milk_id, syrup_id, coffee_size_id)
        VALUES (p_beans_id, p_milk_id, p_syrup_id, p_coffee_size_id)
        RETURNING * INTO coffee_result;

        RETURN coffee_result;
    END IF;
END;
$$ LANGUAGE plpgsql;



-- Получить пирожок или создать если такого еще не существует
CREATE OR REPLACE FUNCTION create_or_get_pie(
    p_size_id INTEGER,
    p_pie_filling_id INTEGER
)
    RETURNS pie_ref AS
$$
DECLARE
    pie_result pie_ref;
BEGIN
    -- Пытаемся выбрать запись с указанными параметрами
    SELECT *
    INTO pie_result
    FROM pie_ref
    WHERE size_id = p_size_id
      AND pie_filling_id = p_pie_filling_id;

    -- Если запись существует, возвращаем ее
    IF FOUND THEN
        RETURN pie_result;
    ELSE
        -- Запись не существует, создаем новую
        INSERT INTO pie_ref (size_id, pie_filling_id)
        VALUES (p_size_id, p_pie_filling_id)
        RETURNING * INTO pie_result;

        RETURN pie_result;
    END IF;
END;
$$ LANGUAGE plpgsql;



-- Посчитать цену кофе
CREATE OR REPLACE FUNCTION calculate_coffee_price(coffee_id INTEGER)
    RETURNS FLOAT AS
$$
DECLARE
    total_price FLOAT := 0;
BEGIN
    total_price := (SELECT ((COALESCE(milk_ref.price, 0) + COALESCE(beans_ref.price, 0) + COALESCE(syrup_ref.price, 0) +
                             COALESCE(coffee_size_ref.price, 0)))
                    FROM coffee_ref
                             JOIN beans_ref ON coffee_ref.beans_id = beans_ref.id
                             JOIN coffee_size_ref ON coffee_ref.coffee_size_id = coffee_size_ref.id
                             LEFT JOIN milk_ref ON coffee_ref.milk_id = milk_ref.id
                             LEFT JOIN syrup_ref ON coffee_ref.syrup_id = syrup_ref.id
                    WHERE coffee_ref.id = coffee_id);

    RETURN total_price;
END;


$$ LANGUAGE plpgsql;



-- Посчитать цену пирожка
CREATE OR REPLACE FUNCTION calculate_pie_price(pie_id INTEGER)
    RETURNS FLOAT AS
$$
DECLARE
    total_price FLOAT := 0;
BEGIN
    total_price := (SELECT ((COALESCE(pie_size_ref.volume, 0) + COALESCE(pie_filling_ref.price, 0)))
                    FROM pie_ref
                             JOIN pie_filling_ref ON pie_ref.pie_filling_id = pie_filling_ref.id
                             JOIN pie_size_ref ON pie_ref.size_id = pie_size_ref.id
                    WHERE pie_ref.id = pie_id);

    RETURN total_price;
END;
$$ LANGUAGE plpgsql;



-- Добавить любимый кофе
CREATE OR REPLACE FUNCTION add_to_favorite_coffee(
    p_client_id INTEGER,
    p_beans_id INTEGER,
    p_milk_id INTEGER,
    p_syrup_id INTEGER,
    p_coffee_size_id INTEGER
)
    RETURNS VOID AS
$$
DECLARE
    coffee_result coffee_ref;
BEGIN
    coffee_result := create_or_get_coffee(p_beans_id, p_milk_id, p_syrup_id, p_coffee_size_id);

    UPDATE client_jn
    SET favourite_coffee = coffee_result.id
    WHERE id = p_client_id;

END;
$$ LANGUAGE plpgsql;



-- Потратить баллы
CREATE OR REPLACE FUNCTION decrease_bonus_points(p_client_id INTEGER, p_value FLOAT)
    RETURNS VOID AS
$$
BEGIN
    UPDATE loyalty_program_jn
    SET bonus_points = bonus_points - p_value
    WHERE client_id = p_client_id;
END;
$$ LANGUAGE plpgsql;



-- Зачислить баллы
CREATE OR REPLACE FUNCTION increase_bonus_points(p_client_id INTEGER, p_value FLOAT)
    RETURNS VOID AS
$$
BEGIN
    UPDATE loyalty_program_jn
    SET bonus_points = bonus_points + p_value
    WHERE client_id = p_client_id;
END;
$$ LANGUAGE plpgsql;


-- Посчитать цену заказа
CREATE OR REPLACE FUNCTION calculate_order_total_price(in_order_id INTEGER)
    RETURNS FLOAT AS
$$
DECLARE
    v_total_price FLOAT := 0.0;
BEGIN
    SELECT COALESCE(SUM(calculate_pie_price(pie_id)), 0)
    INTO v_total_price
    FROM pie_order_jn
    WHERE order_id = in_order_id;

    SELECT COALESCE(SUM(calculate_coffee_price(coffee_id)), 0)
    INTO v_total_price
    FROM coffee_order_jn
    WHERE order_id = in_order_id;

    RETURN v_total_price;
END;
$$ LANGUAGE plpgsql;



-- Создать заказ
CREATE OR REPLACE FUNCTION create_order(
    in_client_id INTEGER,
    address varchar(256)
)
    RETURNS INTEGER AS
$$
DECLARE
    v_status_id            INTEGER;
    v_order_id             INTEGER;
    v_order_total_price_id FLOAT;
BEGIN
    SELECT id INTO v_status_id FROM status_ref WHERE name = 'Pending';

    INSERT INTO order_jn (client_id, address, date, price, status_id)
    VALUES (in_client_id, create_order.address, CURRENT_TIMESTAMP, 0.0, v_status_id)
    RETURNING id INTO v_order_id;

    v_order_total_price_id := calculate_order_total_price(v_order_id);

    UPDATE order_jn
    SET price = v_order_total_price_id
    WHERE id = v_order_id;

    RETURN v_order_id;
END;
$$ LANGUAGE plpgsql;

