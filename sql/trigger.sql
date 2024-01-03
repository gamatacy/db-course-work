-- Добавить 10% от цены заказа к программе лояльности
CREATE OR REPLACE FUNCTION tu_increase_bonus_points()
    RETURNS TRIGGER AS
$$
BEGIN
    UPDATE loyalty_program_jn
    SET bonus_points = bonus_points + bonus_points * 0.10
    WHERE client_id = NEW.client_id;

    RETURN NULL;
END;
$$ LANGUAGE plpgsql;
CREATE TRIGGER update_bonus_trigger
    BEFORE INSERT
    ON order_jn
    FOR EACH ROW
EXECUTE FUNCTION tu_increase_bonus_points();


-- Добавить 50 баллов к программе лояльности за отзыв
CREATE OR REPLACE FUNCTION ti_increase_bonus_points()
    RETURNS TRIGGER AS
$$
BEGIN
    UPDATE loyalty_program_jn
    SET bonus_points = bonus_points + 100
    WHERE client_id = NEW.client_id;
    RETURN NULL;
END;
$$ LANGUAGE plpgsql;
CREATE TRIGGER add_bonus_points_for_review
    BEFORE INSERT
    ON review_jn
    FOR EACH ROW
EXECUTE FUNCTION ti_increase_bonus_points();


-- Создать программу лояльности для нового клиента
CREATE OR REPLACE FUNCTION insert_new_loyalty_program()
    RETURNS TRIGGER AS
$$
BEGIN

    insert into loyalty_program_jn (client_id, bonus_points) values (new.id, 100);
    RETURN NULL;
END;
$$ LANGUAGE plpgsql;
CREATE TRIGGER create_loyalty_program_for_new_client
    after insert
    ON client_jn
    FOR EACH ROW
EXECUTE FUNCTION insert_new_loyalty_program();


-- Обновить дату заказа
CREATE OR REPLACE FUNCTION update_order_date()
    RETURNS TRIGGER AS
$$
BEGIN

    update order_jn
    set date = NOW()
    where order_jn.id = NEW.id;
    RETURN NULL;
END;
$$ LANGUAGE plpgsql;
CREATE TRIGGER update_order_date_trigger
    BEFORE UPDATE
    ON order_jn
    FOR EACH ROW
EXECUTE FUNCTION update_order_date();


-- Установить дату акции
CREATE OR REPLACE FUNCTION update_promotion_start_date()
    RETURNS TRIGGER AS
$$
BEGIN

    update promotion_ref
    set start_date = NOW()
    where promotion_ref.id = NEW.id;
    RETURN NULL;
END;
$$ LANGUAGE plpgsql;
CREATE TRIGGER update_promotion_start_date_trigger
    after insert
    ON promotion_ref
    FOR EACH ROW
EXECUTE FUNCTION update_promotion_start_date();


-- Установить дату регистрации
CREATE OR REPLACE FUNCTION t_set_registration_date()
    RETURNS TRIGGER AS
$$
BEGIN

    update client_jn
    set registration_date = NOW()
    where client_jn.id = NEW.id;

    RETURN NULL;

END;
$$ LANGUAGE plpgsql;
CREATE TRIGGER t_set_registration_date_trigger
    after insert
    ON client_jn
    FOR EACH ROW
EXECUTE FUNCTION t_set_registration_date();


-- Установить дату регистрации
CREATE OR REPLACE FUNCTION t_set_review_date()
    RETURNS TRIGGER AS
$$
BEGIN

    update review_jn
    set date = NOW()
    where review_jn.id = NEW.id;

    RETURN NULL;

END;
$$ LANGUAGE plpgsql;
CREATE TRIGGER t_set_review_date_trigger
    after insert
    ON review_jn
    FOR EACH ROW
EXECUTE FUNCTION t_set_review_date();


-- Обновить дату акции
CREATE OR REPLACE FUNCTION update_promotion_start_date()
    RETURNS TRIGGER AS
$$
BEGIN

    update promotion_ref
    set start_date      = NOW(),
        expiration_date = expiration_date + INTERVAL '1 day'
    where promotion_ref.id = NEW.id;

    RETURN NULL;
END;
$$ LANGUAGE plpgsql;
CREATE TRIGGER update_promotion_start_date_trigger
    BEFORE UPDATE
    ON promotion_ref
    FOR EACH ROW
EXECUTE FUNCTION update_promotion_start_date();






