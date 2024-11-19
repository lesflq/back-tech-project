CREATE TABLE customer (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(255)
);
CREATE TABLE category (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(255),
                          type VARCHAR(255),
                          owner_id BIGINT,
                          FOREIGN KEY (owner_id) REFERENCES customer(id)
);
CREATE TABLE record (
                        id SERIAL PRIMARY KEY,
                        user_id BIGINT,
                        category_id BIGINT,
                        timestamp TIMESTAMP,
                        amount NUMERIC,
                        FOREIGN KEY (user_id) REFERENCES customer(id),
                        FOREIGN KEY (category_id) REFERENCES category(id)
);