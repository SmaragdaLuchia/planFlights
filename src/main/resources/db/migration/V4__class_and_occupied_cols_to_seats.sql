alter table seats
    add column class varchar(255) not null default 'ECONOMY',
    add column occupied boolean not null default false;