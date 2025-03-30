create table seats
(
    seatNr      int not null,
    byWindow    boolean default false not null,
    nearExit    boolean default false not null,
    moreLegRoom boolean default false not null,
    id          bigint auto_increment,
    constraint seats_pk
        primary key (id)
);