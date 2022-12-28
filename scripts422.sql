CREATE TABLE human
(
    id      bigserial PRIMARY KEY,
    name    varchar(255),
    age     integer,
    license boolean,
    car_id  bigint,
    FOREIGN KEY (car_id) REFERENCES (car);
);


CREATE TABLE car
(
    id    bigserial PRIMARY KEY,
    brand VARCHAR(255),
    model varchar(255),
    price decimal
);

