-- Add all foreign key constraints after all tables exist
ALTER TABLE flights
    ADD CONSTRAINT flights_airlines_id_fk FOREIGN KEY (airline_id) REFERENCES airlines(id),
    ADD CONSTRAINT flights_destinations_id_fk FOREIGN KEY (destination_id) REFERENCES destinations(id),
    ADD CONSTRAINT flights_depLoc_id_fk FOREIGN KEY (dep_loc_id) REFERENCES departure_location(id);

ALTER TABLE seats
    ADD CONSTRAINT fk_flight FOREIGN KEY (flight_id) REFERENCES flights(id) ON DELETE CASCADE;