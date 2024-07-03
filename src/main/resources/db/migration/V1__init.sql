CREATE TABLE IF NOT EXISTS tariff (
    id          uuid    not null,
    name        text    not null,
    start_date  date    not null,
    end_date    date    not null,
    description text,
    rate        float8  not null    DEFAULT 0.0,
    version     int     not null    DEFAULT 0,
    PRIMARY KEY (id)
);