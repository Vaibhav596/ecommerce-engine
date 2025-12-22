-- ========================
-- CATEGORY
-- ========================
CREATE TABLE category (
                          id BIGINT NOT NULL,
                          name VARCHAR(255),
                          description VARCHAR(255),
                          subcategory_id BIGINT,
                          is_deleted BIT,
                          created_at DATETIME(6),
                          last_updated_at DATETIME(6),
                          PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE category_seq (
                              next_val BIGINT
) ENGINE=InnoDB;

INSERT INTO category_seq VALUES (1);

-- ========================
-- PRODUCT
-- ========================
CREATE TABLE product (
                         id BIGINT NOT NULL,
                         title VARCHAR(255),
                         description VARCHAR(255),
                         image_url VARCHAR(255),
                         price DOUBLE,
                         category_id BIGINT,
                         is_deleted BIT,
                         created_at DATETIME(6),
                         last_updated_at DATETIME(6),
                         PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE product_seq (
                             next_val BIGINT
) ENGINE=InnoDB;

INSERT INTO product_seq VALUES (1);

-- ========================
-- SUBCATEGORY
-- ========================
CREATE TABLE subcategory (
                             id BIGINT NOT NULL,
                             surname VARCHAR(255),
                             is_deleted BIT,
                             created_at DATETIME(6),
                             last_updated_at DATETIME(6),
                             PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE subcategory_seq (
                                 next_val BIGINT
) ENGINE=InnoDB;

INSERT INTO subcategory_seq VALUES (1);

-- ========================
-- CONSTRAINTS
-- ========================
ALTER TABLE category
    ADD CONSTRAINT UK_category_subcategory UNIQUE (subcategory_id);

ALTER TABLE category
    ADD CONSTRAINT FK_category_subcategory
        FOREIGN KEY (subcategory_id)
            REFERENCES subcategory (id);

ALTER TABLE product
    ADD CONSTRAINT FK_product_category
        FOREIGN KEY (category_id)
            REFERENCES category (id);
