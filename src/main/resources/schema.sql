create table coffee
(
    id               serial
        constraint coffee_pkey primary key,
    create_date_time timestamp,
    aroma            varchar(255),
    name             varchar(255),
    price            varchar(255)
);

alter table coffee owner to postgres;
