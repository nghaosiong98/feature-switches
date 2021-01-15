CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(250) NOT NULL
);

CREATE TABLE feature (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(250) NOT NULL
);

CREATE TABLE user_access (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    feature_id INT NOT NULL,
    has_access BOOLEAN NOT NULL,
    foreign key (user_id) references user(id),
    foreign key (feature_id) references feature(id)
);