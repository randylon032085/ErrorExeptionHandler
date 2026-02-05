CREATE TABLE user (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    role_id BIGINT,
    firstname varchar(100),
    lastname  varchar(100),
    username varchar(100),
    password varchar(100),
    FOREIGN KEY(role_id) REFERENCES role(id)

)