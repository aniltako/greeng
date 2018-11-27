DROP TABLE IF EXISTS account;
DROP TABLE IF EXISTS user;

CREATE TABLE user(
   user_id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
   user_name VARCHAR(255) NOT NULL,
   first_name VARCHAR(255) NOT NULL,
   last_name VARCHAR(255) NOT NULL,
   email VARCHAR(255)
);

CREATE TABLE account(
   account_id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
   account_number varchar(255) NOT NULL,
   amount DOUBLE,
   account_type varchar(32) NOT NULL,
   user_id INTEGER,
   FOREIGN KEY(user_id) REFERENCES user(user_id)
);