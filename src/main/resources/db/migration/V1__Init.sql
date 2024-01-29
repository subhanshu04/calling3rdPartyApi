CREATE TABLE category
(
    id             BIGINT NOT NULL,
    create_at      datetime NULL,
    last_update_at datetime NULL,
    is_deleted     BIT(1) NOT NULL,
    name           VARCHAR(255) NULL,
    `description`  VARCHAR(255) NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE joined_instructor
(
    user_id    BIGINT NOT NULL,
    batch_name VARCHAR(255) NULL,
    CONSTRAINT pk_joined_instructor PRIMARY KEY (user_id)
);

CREATE TABLE joined_mentor
(
    user_id     BIGINT NOT NULL,
    mentee_list INT    NOT NULL,
    CONSTRAINT pk_joined_mentor PRIMARY KEY (user_id)
);

CREATE TABLE joined_ta
(
    user_id BIGINT NOT NULL,
    rating  INT    NOT NULL,
    CONSTRAINT pk_joined_ta PRIMARY KEY (user_id)
);

CREATE TABLE joined_user
(
    id    BIGINT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    CONSTRAINT pk_joined_user PRIMARY KEY (id)
);

CREATE TABLE msc_instructor
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    name       VARCHAR(255) NULL,
    email      VARCHAR(255) NULL,
    batch_name VARCHAR(255) NULL,
    CONSTRAINT pk_msc_instructor PRIMARY KEY (id)
);

CREATE TABLE msc_mentor
(
    id          BIGINT AUTO_INCREMENT NOT NULL,
    name        VARCHAR(255) NULL,
    email       VARCHAR(255) NULL,
    mentee_list INT NOT NULL,
    CONSTRAINT pk_msc_mentor PRIMARY KEY (id)
);

CREATE TABLE msc_ta
(
    id     BIGINT AUTO_INCREMENT NOT NULL,
    name   VARCHAR(255) NULL,
    email  VARCHAR(255) NULL,
    rating INT NOT NULL,
    CONSTRAINT pk_msc_ta PRIMARY KEY (id)
);

CREATE TABLE product
(
    id             BIGINT NOT NULL,
    create_at      datetime NULL,
    last_update_at datetime NULL,
    is_deleted     BIT(1) NOT NULL,
    title          VARCHAR(255) NULL,
    price DOUBLE NOT NULL,
    `description`  VARCHAR(255) NULL,
    category_id    BIGINT NULL,
    image_url      VARCHAR(255) NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE single_user
(
    id          BIGINT AUTO_INCREMENT NOT NULL,
    user_type   INT NULL,
    name        VARCHAR(255) NULL,
    email       VARCHAR(255) NULL,
    rating      INT NOT NULL,
    batch_name  VARCHAR(255) NULL,
    mentee_list INT NOT NULL,
    CONSTRAINT pk_single_user PRIMARY KEY (id)
);

CREATE TABLE tbc_instructor
(
    id         BIGINT NOT NULL,
    name       VARCHAR(255) NULL,
    email      VARCHAR(255) NULL,
    batch_name VARCHAR(255) NULL,
    CONSTRAINT pk_tbc_instructor PRIMARY KEY (id)
);

CREATE TABLE tbc_mentor
(
    id          BIGINT NOT NULL,
    name        VARCHAR(255) NULL,
    email       VARCHAR(255) NULL,
    mentee_list INT    NOT NULL,
    CONSTRAINT pk_tbc_mentor PRIMARY KEY (id)
);

CREATE TABLE tbc_ta
(
    id     BIGINT NOT NULL,
    name   VARCHAR(255) NULL,
    email  VARCHAR(255) NULL,
    rating INT    NOT NULL,
    CONSTRAINT pk_tbc_ta PRIMARY KEY (id)
);

CREATE TABLE tbc_user
(
    id    BIGINT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    CONSTRAINT pk_tbc_user PRIMARY KEY (id)
);

ALTER TABLE joined_instructor
    ADD CONSTRAINT FK_JOINED_INSTRUCTOR_ON_USER FOREIGN KEY (user_id) REFERENCES joined_user (id);

ALTER TABLE joined_mentor
    ADD CONSTRAINT FK_JOINED_MENTOR_ON_USER FOREIGN KEY (user_id) REFERENCES joined_user (id);

ALTER TABLE joined_ta
    ADD CONSTRAINT FK_JOINED_TA_ON_USER FOREIGN KEY (user_id) REFERENCES joined_user (id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);