create table if not exists client_jn
(
    id                SERIAL PRIMARY KEY,
    name              varchar(128) NOT NULL,
    registration_date TIMESTAMP
);

create table if not exists loyalty_program_jn
(
    id           SERIAL PRIMARY KEY,
    client_id    INTEGER NOT NULL REFERENCES client_jn (id),
    bonus_points FLOAT   NOT NULL DEFAULT (0)
);

create table if not exists review_jn
(
    id          SERIAL PRIMARY KEY,
    client_id   INTEGER NOT NULL REFERENCES client_jn (id),
    rating      INTEGER NOT NULL CHECK ( rating >= 0 AND rating <= 5),
    review_text TEXT,
    date        TIMESTAMP
);

create table if not exists shop_ref
(
    id      SERIAL PRIMARY KEY,
    address VARCHAR(256) NOT NULL
);

create table if not exists cat_jn
(
    id        SERIAL PRIMARY KEY,
    age       INTEGER NOT NULL CHECK ( age >= 0 AND age <= 40),
    gender    BOOLEAN NOT NULL,
    shop_id   INTEGER NOT NULL REFERENCES shop_ref (id) ON DELETE CASCADE,
    photo_url TEXT
);

create table if not exists status_ref
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(128) NOT NULL
);

create table if not exists order_jn
(
    id        SERIAL PRIMARY KEY,
    client_id INTEGER      NOT NULL REFERENCES client_jn (id),
    address   VARCHAR(256) NOT NULL,
    date      TIMESTAMP    NOT NULL,
    price     FLOAT        NOT NULL,
    status_id INTEGER      NOT NULL REFERENCES status_ref (id)
);

create table if not exists milk_ref
(
    id    SERIAL PRIMARY KEY,
    name  VARCHAR(128) NOT NULL,
    price FLOAT        NOT NULL CHECK ( price >= 0 )
);

create table if not exists beans_ref
(
    id    SERIAL PRIMARY KEY,
    sort  VARCHAR(128) NOT NULL,
    price FLOAT        NOT NULL CHECK ( price >= 0 )
);

create table if not exists syrup_ref
(
    id    SERIAL PRIMARY KEY,
    name  VARCHAR(128) NOT NULL,
    price FLOAT        NOT NULL CHECK ( price >= 0 )
);

create table if not exists coffee_size_ref
(
    id     SERIAL PRIMARY KEY,
    name   VARCHAR(128) NOT NULL,
    volume INTEGER      NOT NULL CHECK ( volume > 0)
);

create table if not exists coffee_ref
(
    id             SERIAL PRIMARY KEY,
    beans_id       INTEGER NOT NULL REFERENCES beans_ref (id) ON DELETE CASCADE,
    milk_id        INTEGER NOT NULL REFERENCES milk_ref (id) ON DELETE CASCADE,
    syrup_id       INTEGER NOT NULL REFERENCES syrup_ref (id) ON DELETE CASCADE,
    coffee_size_id INTEGER NOT NULL REFERENCES coffee_size_ref (id) ON DELETE CASCADE
);

create table if not exists coffee_order_jn
(
    id        SERIAL PRIMARY KEY,
    order_id  INTEGER NOT NULL REFERENCES order_jn (id),
    coffee_id INTEGER NOT NULL REFERENCES coffee_ref (id)
);

create table if not exists pie_size_ref
(
    id     SERIAL PRIMARY KEY,
    name   varchar(128),
    volume INTEGER NOT NULL CHECK ( volume > 0)
);

create table if not exists pie_filling_ref
(
    id    SERIAL PRIMARY KEY,
    name  varchar(128),
    price FLOAT NOT NULL CHECK ( price >= 0 )
);

create table if not exists pie_ref
(
    id             SERIAL PRIMARY KEY,
    size_id        INTEGER NOT NULL REFERENCES pie_size_ref (id) ON DELETE CASCADE,
    pie_filling_id INTEGER NOT NULL REFERENCES pie_filling_ref (id) ON DELETE CASCADE
);

create table if not exists pie_order_jn
(
    id       SERIAL PRIMARY KEY,
    pie_id   INTEGER NOT NULL REFERENCES pie_ref (id),
    order_id INTEGER NOT NULL REFERENCES order_jn (id)
);

create table if not exists promotion_ref
(
    id              SERIAL PRIMARY KEY,
    start_date      TIMESTAMP NOT NULL,
    expiration_date TIMESTAMP NOT NULL
);

create table if not exists coffee_sale_ref
(
    id           SERIAL PRIMARY KEY,
    coffee_id    INTEGER NOT NULL REFERENCES coffee_ref (id) ON DELETE CASCADE,
    promotion_id INTEGER NOT NULL REFERENCES promotion_ref (id) ON DELETE CASCADE,
    multiplier   FLOAT   NOT NULL CHECK ( multiplier >= 0 AND multiplier <= 1 )
);

create table if not exists pie_sale_ref
(
    id           SERIAL PRIMARY KEY,
    pie_id       INTEGER NOT NULL REFERENCES pie_ref (id) ON DELETE CASCADE,
    promotion_id INTEGER NOT NULL REFERENCES promotion_ref (id) ON DELETE CASCADE,
    multiplier   FLOAT   NOT NULL CHECK ( multiplier >= 0 AND multiplier <= 1 )
);

create table if not exists allergen_ref
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(256) NOT NULL
);

create table if not exists filling_allergen_ref
(
    id          SERIAL PRIMARY KEY,
    filling_id  INTEGER NOT NULL REFERENCES pie_filling_ref (id) ON DELETE CASCADE,
    allergen_id INTEGER NOT NULL REFERENCES allergen_ref (id) ON DELETE CASCADE
);

create table if not exists milk_allergen_ref
(
    id          SERIAL PRIMARY KEY,
    milk_id     INTEGER NOT NULL REFERENCES milk_ref (id) ON DELETE CASCADE,
    allergen_id INTEGER NOT NULL REFERENCES allergen_ref (id) ON DELETE CASCADE
);

create table if not exists syrup_allergen_ref
(
    id          SERIAL PRIMARY KEY,
    syrup_id    INTEGER NOT NULL REFERENCES syrup_ref (id) ON DELETE CASCADE,
    allergen_id INTEGER NOT NULL REFERENCES allergen_ref (id) ON DELETE CASCADE
);

alter table client_jn
    add column favourite_shop INTEGER REFERENCES shop_ref (id) ON DELETE CASCADE;

alter table client_jn
    add column favourite_coffee INTEGER REFERENCES coffee_ref (id) ON DELETE CASCADE;

