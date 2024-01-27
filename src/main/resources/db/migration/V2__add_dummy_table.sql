CREATE TABLE dummy
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    create_at      datetime NULL,
    last_update_at datetime NULL,
    is_deleted     BIT(1) NOT NULL,
    CONSTRAINT pk_dummy PRIMARY KEY (id)
);
