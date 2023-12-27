create index order_client_id_idx on order_jn using btree (client_id);
create index loyalty_program_client_id_idx on loyalty_program_jn using btree (client_id);

-- Чаще всего клиенты будут создавать заказы и получать за них бонусные баллы.
-- Таблицы часто обновляются, не затрагивая при этом индексированные атрибуты.
-- Значит, работу с таблицами заказов и программой лояльности полезнее всего оптимизировать с помощью индексов.
