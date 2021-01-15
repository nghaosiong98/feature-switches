INSERT INTO user (email) VALUES ('user1@gmail.com');
INSERT INTO user (email) VALUES ('user2@gmail.com');
INSERT INTO user (email) VALUES ('user3@gmail.com');

INSERT INTO feature (name) VALUES ('f1');
INSERT INTO feature (name) VALUES ('f2');
INSERT INTO feature (name) VALUES ('f3');

INSERT INTO user_access (user_id, feature_id, has_access) VALUES (1, 1, TRUE);
INSERT INTO user_access (user_id, feature_id, has_access) VALUES (1, 2, TRUE);
INSERT INTO user_access (user_id, feature_id, has_access) VALUES (1, 3, TRUE);