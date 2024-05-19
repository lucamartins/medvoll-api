CREATE TABLE doctors
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    name         VARCHAR(100) NOT NULL,
    email        VARCHAR(100) NOT NULL UNIQUE,
    crm          VARCHAR(6)   NOT NULL UNIQUE,
    specialty    VARCHAR(100) NOT NULL,
    street       VARCHAR(100) NOT NULL,
    number       VARCHAR(20)  NOT NULL,
    complement   VARCHAR(100),
    neighborhood VARCHAR(100) NOT NULL,
    city         VARCHAR(100) NOT NULL,
    state        CHAR(100)    NOT NULL,
    zip_code     VARCHAR(100) NOT NULL
);