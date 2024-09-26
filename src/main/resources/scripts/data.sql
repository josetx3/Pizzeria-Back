INSERT INTO main.customer (id_customer, name, address, email, phone_number)
VALUES
    ('d8288f6e-8fdd-4887-955e-e7c715ec34db', 'Drake Theory', 'P.O. Box 136, 4534 Lacinia St.', 'draketheory@hotmail.com', '(826) 607-2278'),
    ('4c72a389-2437-496a-b86a-b114841129ed', 'Alexa Morgan', 'Ap #732-8087 Dui. Road', 'aleximorgan@hotmail.com', '(830) 212-2247'),
    ('2f46bc1c-25d4-46e8-a10b-3a47f199d0f3', 'Johanna Reigns', '925-3988 Purus. St.', 'johareigns@outlook.com', '(801) 370-4041'),
    ('a08dd09f-91ef-40b5-874a-f8822481af67', 'Becky Alford', 'P.O. Box 341, 7572 Odio Rd.', 'beckytwobelts@icloud.com', '(559) 398-7689'),
    ('7e6fa24d-24b5-4eae-a51c-7c39fd982ff2', 'Brock Alford', '9063 Aliquam, Road', 'brockalford595@platzi.com', '(732) 218-4844'),
    ('7369d235-f155-4043-8c1a-996b61b2dfbb', 'Clarke Wyatt', '461-4278 Dignissim Av.', 'wyattplay@google.co', '(443) 263-8555'),
    ('b91a8b0d-21f9-4d3d-a83a-43ccfda0b681', 'Cody Rollins', '177-1125 Consequat Ave', 'codyforchamp@google.com', '(740) 271-3631'),
    ('f73825ad-d115-40c0-b285-73e603c10094', 'Bianca Neal', 'Ap #937-4424 Vestibulum. Street', 'bianca0402@platzi.com', '(792) 406-8858'),
    ('f00890d4-0731-4a60-94a2-2c473fa6b1cb', 'Drew Watson', '705-6031 Aliquam Street', 'wangwatson@icloud.com', '(362) 881-5943'),
    ('de11e6f5-55b1-4665-9ca1-4b7f99e0a2d6', 'Mercedes Balor', 'Ap #720-1833 Curabitur Av.', 'mercedesbalorclub@hotmail.com', '(688) 944-6619'),
    ('7d4e246f-8e4f-4e24-a1ae-d5483c0e503b', 'Karl Austin', '241-9121 Fames St.', 'stonecold@icloud.com', '(559) 596-3381'),
    ('11d72e84-3342-40ef-b810-485925c0a97f', 'Sami Rollins', 'Ap #308-4700 Mollis Av.', 'elgenerico@outlook.com', '(508) 518-2967'),
    ('2dd5a93c-4fd0-4cd2-9476-65b5f163ab6b', 'Charlotte Riddle', 'Ap #696-6846 Ullamcorper Avenue', 'amityrogers@outlook.com', '(744) 344-7768'),
    ('e84f059d-79f3-4661-bdff-c4a7db7383fe', 'Matthew Heyman', 'Ap #268-1749 Id St.', 'heymanboss@hotmail.com', '(185) 738-9267'),
    ('7744f439-06dc-4c4d-b10e-72f77d41fcb9', 'Shelton Owens', 'Ap #206-5413 Vivamus St.', 'figthowens@platzi.com', '(821) 880-6661');


-- INSERT PIZZAS
INSERT INTO main.pizza (id_pizza, name, description, price, vegetarian, vegan, available)
VALUES
    ('ff7f86e6-e755-42f5-8726-34a2c3a2f3c8', 'Pepperoni', 'Pepperoni, Homemade Tomato Sauce & Mozzarella.', 23.0, false, false, true),
    ('90f4afeb-5bc2-487a-b27f-e0cfa9722a67', 'Margherita', 'Fior de Latte, Homemade Tomato Sauce, Extra Virgin Olive Oil & Basil.', 18.5, true, false, true),
    ('34097f61-dc88-4571-8379-92c55e26e80a', 'Vegan Margherita', 'Fior de Latte, Homemade Tomato Sauce, Extra Virgin Olive Oil & Basil.', 22.0, true, true, true),
    ('9db63797-f2d0-4186-b774-c5f024e74827', 'Avocado Festival', 'Hass Avocado, House Red Sauce, Sundried Tomatoes, Basil & Lemon Zest.', 19.95, true, false, true),
    ('0330c83c-05a9-4dcb-995d-5d4d462a1305', 'Hawaiian', 'Homemade Tomato Sauce, Mozzarella, Pineapple & Ham.', 20.5, false, false, false),
    ('5825df6e-7a9b-4c1f-a383-41e3a2929f98', 'Goat Cheese', 'Portobello Mushrooms, Mozzarella, Parmesan & Goat Cheeses with Alfredo Sauce.', 24.0, false, false, true),
    ('2b61725d-6b7d-4e29-a801-040d689c151e', 'Mother Earth', 'Artichokes, Roasted Peppers, Rapini, Sundried Tomatoes, Onion, Shaved Green Bell Peppers & Sunny Seasoning.', 19.5, true, false, true),
    ('5c53aa10-d9b4-4049-8dd3-2a03b1b87013', 'Meat Lovers', 'Mild Italian Sausage, Pepperoni, Bacon, Homemade Tomato Sauce & Mozzarella.', 21.0, false, false, true),
    ('3d136897-62aa-4954-a3a7-25257f5b832f', 'Marinated BBQ Chicken', 'Marinated Chicken with Cilantro, Red Onions, Gouda, Parmesan & Mozzarella Cheeses.', 20.95, false, false, false),
    ('95fe15e4-78b1-4f4f-816a-bcc826e2254b', 'Truffle Cashew Cream', 'Wild mushrooms, Baby Kale, Shiitake Bacon & Lemon Vinaigrette. Soy free.', 22.0, true, true, true),
    ('291362af-e587-44ba-84e3-f9903d9475f2', 'Rico Mor', 'Beef Chorizo, Sundried Tomatoes, Salsa Verde, Pepper, Jalapeno & pistachios', 23.0, false, false, true),
    ('ff85340f-2aeb-4968-8fd9-94c92d5d2822', 'Spinach Artichoke', 'Fresh Spinach, Marinated Artichoke Hearts, Garlic, Fior de Latte, Mozzarella & Parmesan.', 18.95, true, false, true);


-- INSERT ORDERS
INSERT INTO main.pizza_order (id_order, id_customer, date, total, method, additional_notes)
VALUES
    ('99f5b194-93fc-4d5c-bd50-0ed7e74f6e3f', 'f00890d4-0731-4a60-94a2-2c473fa6b1cb', NOW() - INTERVAL '5 days', 42.95, 'D', 'Don''t be late pls.'),
    ('b77b106b-90a8-4a4b-b53a-14869f31a0e7', '2f46bc1c-25d4-46e8-a10b-3a47f199d0f3', NOW() - INTERVAL '4 days', 62.0, 'S', NULL),
    ('e2b1f8d9-b497-45b8-8527-b346c2d2e41b', 'e84f059d-79f3-4661-bdff-c4a7db7383fe', NOW() - INTERVAL '3 days', 22.0, 'C', NULL),
    ('95f83129-2806-41d0-a71a-9ef343db7cb3', '4c72a389-2437-496a-b86a-b114841129ed', NOW() - INTERVAL '2 days', 42.0, 'S', NULL),
    ('f0489057-364b-4bc9-87b3-9f4fa09a3675', 'f00890d4-0731-4a60-94a2-2c473fa6b1cb', NOW() - INTERVAL '1 day', 20.5, 'D', 'Please bring the jalapeños separately.'),
    ('11524d97-1a63-41a0-9e09-f191b6e3ccac', '2dd5a93c-4fd0-4cd2-9476-65b5f163ab6b', NOW(), 23.0, 'D', NULL);


-- INSERT ORDER ITEMS
INSERT INTO main.order_item (id_order, id_item, id_pizza, quantity, price)
VALUES
    ('99f5b194-93fc-4d5c-bd50-0ed7e74f6e3f', 'ba274a3a-bc32-44a9-a7c5-94b9f1f284ab', 'ff7f86e6-e755-42f5-8726-34a2c3a2f3c8', 1, 23.0),
    ('99f5b194-93fc-4d5c-bd50-0ed7e74f6e3f', '0d84df58-260f-4e6a-9913-d0f511fbd815', '9db63797-f2d0-4186-b774-c5f024e74827', 1, 19.95),
    ('b77b106b-90a8-4a4b-b53a-14869f31a0e7', 'dedb4f93-bdb6-43f0-a02a-802baf9e70b3', '90f4afeb-5bc2-487a-b27f-e0cfa9722a67', 1, 18.5),
    ('b77b106b-90a8-4a4b-b53a-14869f31a0e7', '53a23275-dcdf-4230-bb45-1fd34e6ba5ab', '5825df6e-7a9b-4c1f-a383-41e3a2929f98', 1, 24.0),
    ('b77b106b-90a8-4a4b-b53a-14869f31a0e7', '87a5ac4c-00f3-48a4-9143-fb2fd5d21485', '2b61725d-6b7d-4e29-a801-040d689c151e', 1, 19.5),
    ('e2b1f8d9-b497-45b8-8527-b346c2d2e41b', '6b08d79b-e47c-4d18-b82e-b3a0056fe4f0', '34097f61-dc88-4571-8379-92c55e26e80a', 1, 22.0),
    ('95f83129-2806-41d0-a71a-9ef343db7cb3', '0f40d14d-7f3b-48b0-84da-6848e47d7b4b', '5c53aa10-d9b4-4049-8dd3-2a03b1b87013', 2, 42.0),
    ('f0489057-364b-4bc9-87b3-9f4fa09a3675', '9b5b933f-6cf8-4a90-aaf5-4bc1df5afda6', '95fe15e4-78b1-4f4f-816a-bcc826e2254b', 0.5, 11.0),
    ('f0489057-364b-4bc9-87b3-9f4fa09a3675', '15c04a9a-bc82-4634-8335-5e87f4f6a4a2', 'ff85340f-2aeb-4968-8fd9-94c92d5d2822', 0.5, 9.5),
    ('11524d97-1a63-41a0-9e09-f191b6e3ccac', 'b90eb4be-8281-4c3c-a5b9-4c501e2f7d82', '291362af-e587-44ba-84e3-f9903d9475f2', 1, 23.0);

