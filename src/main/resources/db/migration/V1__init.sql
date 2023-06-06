CREATE TABLE IF NOT EXISTS orders (
                                      id          BIGINT PRIMARY KEY,
                                      sum DECIMAL,
                                      title       VARCHAR(255),
    creation_date TIMESTAMP,
    status      VARCHAR(255)
    );