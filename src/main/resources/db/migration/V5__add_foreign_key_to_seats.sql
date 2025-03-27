alter TABLE seats
add column flight_id BIGINT NOT NULL;

ALTER TABLE seats
ADD CONSTRAINT fk_flight
FOREIGN KEY (flight_id)
REFERENCES flights(id)
ON DELETE CASCADE;
