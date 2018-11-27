INSERT INTO user (user_id, user_name, first_name, last_name, email)
VALUES
(1,'aniltako', 'anil', 'tako', 'takoanil@gmail.com'),
(2,'account_1', 'real', 'madrid', 'realmadrid@gmail.com'),
(3,'account_2', 'manu', 'united', 'manu@gmail.com'),
(4,'account_3', 'chelsea', 'fc', 'chelsea@gmail.com');


INSERT INTO account (account_id, account_number, amount, account_type, user_id)
VALUES
(1, 1, 0, 1, 1),
(2, 2, 0, 1, 2),
(3, 3, 0, 1, 3),
(4, 4, 0, 1, 4);