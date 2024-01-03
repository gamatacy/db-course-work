-- Drop triggers
DROP TRIGGER IF EXISTS update_bonus_trigger ON order_jn;
DROP TRIGGER IF EXISTS add_bonus_points_for_review ON review_jn;
DROP TRIGGER IF EXISTS create_loyalty_program_for_new_client ON client_jn;
DROP TRIGGER IF EXISTS update_order_date_trigger ON order_jn;
DROP TRIGGER IF EXISTS update_promotion_start_date_trigger ON promotion_ref;
DROP TRIGGER IF EXISTS t_set_registration_date_trigger ON client_jn;

-- Drop functions
DROP FUNCTION IF EXISTS tu_increase_bonus_points();
DROP FUNCTION IF EXISTS ti_increase_bonus_points();
DROP FUNCTION IF EXISTS insert_new_loyalty_program();
DROP FUNCTION IF EXISTS update_order_date();
DROP FUNCTION IF EXISTS update_promotion_start_date();
DROP FUNCTION IF EXISTS t_set_registration_date();

