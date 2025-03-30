create table airlines (
                          id   bigint auto_increment,
                          name varchar(255) not null,
                          constraint airlines_pk primary key (id)
);

create table destinations (
                              id   bigint auto_increment,
                              name varchar(255) not null,
                              region varchar(255) not null,
                              constraint destinations_pk primary key (id)
);

create table departure_location (
                                    id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                    name varchar(255) not null,
                                    region varchar(255) not null
);

create table flights (
                         id             bigint auto_increment,
                         duration       int            not null comment 'in minutes',
                         price          decimal(10, 2) not null,
                         date           date           not null,
                         destination_id bigint         not null,
                         airline_id     bigint         not null,
                         dep_time       TIME           not null default '00:00:00',
                         dep_loc_id     BIGINT         null,
                         constraint flights_pk primary key (id)
);

create table seats (
                       seatNr      int not null,
                       byWindow    boolean default false not null,
                       nearExit    boolean default false not null,
                       moreLegRoom boolean default false not null,
                       id          bigint auto_increment,
                       class       varchar(255) not null default 'ECONOMY',
                       occupied    boolean not null default false,
                       flight_id   BIGINT NOT NULL,
                       constraint seats_pk primary key (id)
);