Create table departure_location (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name varchar(255) not null,
    region varchar(255) not null
);

INSERT INTO departure_location (id, name, region)
VALUES (1, 'JFK Airport', 'New York');


alter TABLE flights
    add column dep_time TIME not null,
    add column dep_loc_id BIGINT null,
    add constraint flights_depLoc_id_fk
    foreign key (dep_loc_id) references departure_location(id);



