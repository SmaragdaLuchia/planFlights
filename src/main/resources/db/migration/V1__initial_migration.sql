create table airlines
(
    id   bigint auto_increment,
    name varchar(255) not null,
    constraint airlines_pk
        primary key (id)
);

create table destinations
(
    id   bigint auto_increment,
    name varchar(255) not null,
    region varchar(255) not null,
    constraint destinations_pk
        primary key (id)
);

create table flights
(
    id             bigint auto_increment,
    duration       int            not null comment 'in minutes',
    price          decimal(10, 2) not null,
    date           date           not null,
    destination_id bigint         not null,
    airline_id     bigint         not null,
    constraint flights_pk
        primary key (id),
    constraint flights_airlines_id_fk
        foreign key (airline_id) references airlines (id),
    constraint flights_destinations_id_fk
        foreign key (destination_id) references destinations (id)
);
