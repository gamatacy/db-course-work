-- Insert data into client_jn
INSERT INTO client_jn (name, registration_date)
VALUES
    ('John Doe', '2023-01-01'),
    ('Jane Smith', '2023-02-15'),
    ('Bob Johnson', '2023-03-20');

-- Insert data into loyalty_program_jn
INSERT INTO loyalty_program_jn (client_id, bonus_points)
VALUES
    (1, 100),
    (2, 50),
    (3, 75);

-- Insert data into review_jn
INSERT INTO review_jn (client_id, rating, review_text, date)
VALUES
    (1, 4, 'Great service!', '2023-01-05'),
    (2, 5, 'Love their coffee!', '2023-02-18'),
    (3, 3, 'Could improve the variety.', '2023-03-25');

-- Insert data into shop_ref
INSERT INTO shop_ref (address)
VALUES
    ('123 Main St'),
    ('456 Oak Ave'),
    ('789 Pine Blvd');

-- Insert data into cat_jn
INSERT INTO cat_jn (age, gender, shop_id, photo_url)
VALUES
    (2, true, 1, 'cat1.jpg'),
    (3, false, 2, 'cat2.jpg'),
    (1, true, 3, 'cat3.jpg');

-- Insert data into status_ref
INSERT INTO status_ref (name)
VALUES
    ('Pending'),
    ('Processing'),
    ('Delivered');

-- Insert data into order_jn
INSERT INTO order_jn (client_id, address, date, price, status_id)
VALUES
    (1, '789 Elm St', '2023-04-01', 25.50, 1),
    (2, '101 Maple Ave', '2023-04-02', 18.75, 2),
    (3, '555 Birch Blvd', '2023-04-03', 30.20, 3);

-- Insert data into milk_ref
INSERT INTO milk_ref (name, price)
VALUES
    ('Whole Milk', 2.50),
    ('Almond Milk', 3.00),
    ('Soy Milk', 2.75);

-- Insert data into beans_ref
INSERT INTO beans_ref (sort, price)
VALUES
    ('Arabica', 8.50),
    ('Robusta', 6.75),
    ('Ethiopian', 9.00);

-- Insert data into syrup_ref
INSERT INTO syrup_ref (name, price)
VALUES
    ('Vanilla', 1.50),
    ('Caramel', 1.75),
    ('Hazelnut', 2.00);

-- Insert data into coffee_size_ref
INSERT INTO coffee_size_ref (name, volume)
VALUES
    ('Small', 12),
    ('Medium', 16),
    ('Large', 20);

-- Insert data into coffee_ref
INSERT INTO coffee_ref (beans_id, milk_id, syrup_id, coffee_size_id)
VALUES
    (1, 2, 3, 1),
    (2, 1, 2, 2),
    (3, 3, 1, 3);

-- Insert data into coffee_order_jn
INSERT INTO coffee_order_jn (order_id, coffee_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 3);

-- Insert data into pie_size_ref
INSERT INTO pie_size_ref (name, volume)
VALUES
    ('Small', 8),
    ('Medium', 10),
    ('Large', 12);

-- Insert data into pie_filling_ref
INSERT INTO pie_filling_ref (name, price)
VALUES
    ('Apple', 10.50),
    ('Cherry', 12.75),
    ('Blueberry', 14.00);

-- Insert data into pie_ref
INSERT INTO pie_ref (size_id, pie_filling_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 3);

-- Insert data into pie_order_jn
INSERT INTO pie_order_jn (order_id, pie_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 3);

-- Insert data into promotion_ref
INSERT INTO promotion_ref (start_date, expiration_date)
VALUES
    ('2023-04-01', '2023-04-15'),
    ('2023-04-10', '2023-04-30');

-- Insert data into coffee_sale_ref
INSERT INTO coffee_sale_ref (coffee_id, promotion_id, multiplier)
VALUES
    (1, 1, 0.8),
    (2, 2, 0.75),
    (3, 1, 0.9);

-- Insert data into pie_sale_ref
INSERT INTO pie_sale_ref (pie_id, promotion_id, multiplier)
VALUES
    (1, 2, 0.85),
    (2, 1, 0.8),
    (3, 2, 0.95);

-- Insert data into allergen_ref
INSERT INTO allergen_ref (name)
VALUES
    ('Peanuts'),
    ('Gluten'),
    ('Soy');

-- Insert data into filling_allergen_ref
INSERT INTO filling_allergen_ref (filling_id, allergen_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 3);

-- Insert data into milk_allergen_ref
INSERT INTO milk_allergen_ref (milk_id, allergen_id)
VALUES
    (1, 2),
    (2, 1),
    (3, 3);

-- Insert data into syrup_allergen_ref
INSERT INTO syrup_allergen_ref (syrup_id, allergen_id)
VALUES
    (1, 3),
    (2, 2),
    (3, 1);

-- Update client_jn with favourite_shop and favourite_coffee
UPDATE client_jn
SET favourite_shop = 1, favourite_coffee = 1
WHERE id = 1;

UPDATE client_jn
SET favourite_shop = 2, favourite_coffee = 2
WHERE id = 2;

UPDATE client_jn
SET favourite_shop = 3, favourite_coffee = 3
WHERE id = 3;
