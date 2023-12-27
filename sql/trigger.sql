CREATE TRIGGER update_bonus_trigger
    BEFORE INSERT
    ON order_jn
EXECUTE FUNCTION increase_bonus_points(order_jn.id, order_jn.price * 0.10);



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









