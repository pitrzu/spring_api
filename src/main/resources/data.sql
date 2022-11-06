INSERT INTO categories (category_name)
VALUES ('Pizza'), ('Fast Food'), ('Sosy');

INSERT INTO items (item_description, "item_img-path", item_name, category_id)
VALUES ('sos, ser, szynka, pierczarki', 'img.jpg', 'Capriciosa', 1),
       ('sos, ser, salami, pieczarki', 'pizza.jpg', 'Salami', 1),
       (null, 'burger.jpg', 'Hamburger', '2');

INSERT INTO prices (item_size, item_price, item_id, "item_price-update-time")
VALUES (0, 20, 1, '2022-11-06 00:35:23.000000'),
       (1, 30, 1, '2022-11-06 00:35:23.000000'),
       (2, 40, 1, '2022-11-06 00:35:23.000000'),
       (0, 22, 2, '2022-11-06 00:35:23.000000'),
       (1, 32, 2, '2022-11-06 00:35:23.000000'),
       (2, 42, 2, '2022-11-06 00:35:23.000000'),
       (0, 8, 3, '2022-11-06 00:35:23.000000'),
       (2, 12, 3, '2022-11-06 00:35:23.000000');
