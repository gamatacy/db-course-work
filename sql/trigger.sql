-- Добавить 10% от цены заказа к программе лояльности
CREATE TRIGGER update_bonus_trigger
    BEFORE INSERT
    ON order_jn
EXECUTE FUNCTION increase_bonus_points(order_jn.id, order_jn.price * 0.10);


-- Добавить 50 баллов к программе лояльности за отзыв
CREATE TRIGGER add_bonus_points_for_review
    BEFORE INSERT
    ON review_jn
EXECUTE FUNCTION increase_bonus_points(review_jn.client_id, 50);


-- Создать программу лояльности для нового клиента
CREATE OR REPLACE FUNCTION insert_new_loyalty_program(t_client_id integer)
    RETURNS TRIGGER AS
$$
BEGIN

    insert into loyalty_program_jn (client_id, bonus_points) values (t_client_id, 100);

END;
$$ LANGUAGE plpgsql;
CREATE TRIGGER create_loyalty_program_for_new_client
    after insert
    ON client_jn
EXECUTE FUNCTION update_order_date(client_jn.id);


-- Обновить дату заказа
CREATE OR REPLACE FUNCTION update_order_date(order_id integer)
    RETURNS TRIGGER AS
$$
BEGIN

    update order_jn
    set date = NOW()
    where order_jn.id = order_id;

END;
$$ LANGUAGE plpgsql;
CREATE TRIGGER update_order_date_trigger
    BEFORE UPDATE
    ON order_jn
EXECUTE FUNCTION update_order_date(order_jn.id);


-- Установить дату акции
CREATE OR REPLACE FUNCTION update_promotion_start_date(promotion_id integer)
    RETURNS TRIGGER AS
$$
BEGIN

    update promotion_ref
    set start_date = NOW()
    where promotion_ref.id = promotion_id;

END;
$$ LANGUAGE plpgsql;
CREATE TRIGGER update_promotion_start_date_trigger
    BEFORE insert
    ON promotion_ref
EXECUTE FUNCTION update_promotion_start_date(promotion_ref.id);


-- Установить дату регистрации
CREATE OR REPLACE FUNCTION set_registration_date(client_id integer)
    RETURNS TRIGGER AS
$$
BEGIN

    update client_jn
    set registration_date = NOW()
    where client_jn.id = client_id;

END;
$$ LANGUAGE plpgsql;
CREATE TRIGGER set_registration_date_trigger
    BEFORE UPDATE
    ON client_jn
EXECUTE FUNCTION update_order_date(client_jn.id);


-- Обновить дату акции
CREATE OR REPLACE FUNCTION update_promotion_start_date(promotion_id integer)
    RETURNS TRIGGER AS
$$
BEGIN

    update promotion_ref
    set start_date = NOW(),
        expiration_date = expiration_date + INTERVAL '1 day'
    where promotion_ref.id = promotion_id;

END;
$$ LANGUAGE plpgsql;
CREATE TRIGGER update_promotion_start_date_trigger
    BEFORE UPDATE
    ON promotion_ref
EXECUTE FUNCTION update_promotion_start_date(promotion_ref.id);






