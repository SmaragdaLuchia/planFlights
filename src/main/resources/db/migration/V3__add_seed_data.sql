-- 1. First insert the departure location
INSERT INTO departure_location (id, name, region) VALUES
    (1, 'JFK Airport', 'USA');

-- 2. Insert airlines
INSERT INTO airlines (name) VALUES
                                ('Delta Airlines'),
                                ('United Airlines'),
                                ('Lufthansa'),
                                ('British Airways'),
                                ('Air France'),
                                ('KLM'),
                                ('American Airlines'),
                                ('Emirates'),
                                ('Qatar Airways'),
                                ('Turkish Airlines');

-- 3. Insert destinations
INSERT INTO destinations (name, region) VALUES
                                            ('New York', 'USA'),
                                            ('London', 'UK'),
                                            ('Paris', 'France'),
                                            ('Berlin', 'Germany'),
                                            ('Rome', 'Italy'),
                                            ('Madrid', 'Spain'),
                                            ('Tokyo', 'Japan'),
                                            ('Dubai', 'UAE'),
                                            ('Sydney', 'Australia'),
                                            ('Toronto', 'Canada');

-- 4. Insert flights (with dep_loc_id = 1 for all flights)
INSERT INTO flights (duration, price, date, destination_id, airline_id, dep_time, dep_loc_id) VALUES
-- New York flights
-- New York flights (shorter duration, lower price)
(90, 199.99, '2025-06-15', 1, 1, '08:00:00', 1),
(95, 179.99, '2025-06-15', 1, 7, '12:30:00', 1),
(85, 189.99, '2025-06-16', 1, 2, '09:15:00', 1),

-- London flights
(420, 499.99, '2025-06-15', 2, 4, '18:00:00', 1),
(430, 549.99, '2025-06-16', 2, 4, '20:30:00', 1),
(410, 479.99, '2025-06-17', 2, 3, '14:45:00', 1),

-- Paris flights
(450, 429.99, '2025-06-15', 3, 5, '16:15:00', 1),
(440, 399.99, '2025-06-16', 3, 5, '10:00:00', 1),
(460, 449.99, '2025-06-17', 3, 6, '13:30:00', 1),

-- Berlin flights
(480, 459.99, '2025-06-16', 4, 3, '11:45:00', 1),
(470, 439.99, '2025-06-17', 4, 3, '15:15:00', 1),
(490, 479.99, '2025-06-18', 4, 10, '19:00:00', 1),

-- Rome flights
(520, 529.99, '2025-06-17', 5, 10, '08:30:00', 1),
(510, 549.99, '2025-06-18', 5, 4, '12:00:00', 1),
(530, 499.99, '2025-06-19', 5, 5, '17:45:00', 1),

-- Madrid flights
(500, 489.99, '2025-06-18', 6, 6, '09:15:00', 1),
(510, 469.99, '2025-06-19', 6, 5, '14:30:00', 1),
(490, 479.99, '2025-06-20', 6, 10, '18:15:00', 1),

-- Tokyo flights (longest duration, highest price)
(840, 1299.99, '2025-06-19', 7, 8, '10:00:00', 1),
(850, 1399.99, '2025-06-20', 7, 9, '13:45:00', 1),
(830, 1199.99, '2025-06-21', 7, 7, '16:30:00', 1),

-- Dubai flights
(780, 899.99, '2025-06-20', 8, 8, '11:15:00', 1),
(770, 849.99, '2025-06-21', 8, 9, '15:45:00', 1),
(790, 929.99, '2025-06-22', 8, 10, '20:00:00', 1),

-- Sydney flights (longest, most expensive)
(960, 1599.99, '2025-06-21', 9, 8, '09:30:00', 1),
(950, 1499.99, '2025-06-22', 9, 9, '14:15:00', 1),
(970, 1699.99, '2025-06-23', 9, 4, '18:45:00', 1),

-- Toronto flights (short international)
(120, 249.99, '2025-06-22', 10, 1, '07:45:00', 1),
(125, 229.99, '2025-06-23', 10, 2, '11:30:00', 1),
(115, 259.99, '2025-06-24', 10, 7, '16:00:00', 1),

-- Additional flights to fill up to 50
(90, 199.99, '2025-06-25', 1, 1, '08:30:00', 1),
(420, 529.99, '2025-06-25', 2, 4, '19:15:00', 1),
(450, 449.99, '2025-06-26', 3, 5, '17:00:00', 1),
(480, 469.99, '2025-06-26', 4, 3, '12:45:00', 1),
(520, 539.99, '2025-06-27', 5, 10, '09:30:00', 1),
(500, 499.99, '2025-06-27', 6, 6, '15:15:00', 1),
(840, 1349.99, '2025-06-28', 7, 8, '11:45:00', 1),
(780, 879.99, '2025-06-28', 8, 9, '14:30:00', 1),
(960, 1549.99, '2025-06-29', 9, 4, '10:15:00', 1),
(120, 239.99, '2025-06-29', 10, 2, '13:00:00', 1),
(95, 189.99, '2025-06-30', 1, 7, '10:45:00', 1),
(430, 559.99, '2025-06-30', 2, 4, '21:00:00', 1),
(440, 419.99, '2025-07-01', 3, 5, '08:15:00', 1),
(470, 449.99, '2025-07-01', 4, 3, '16:45:00', 1),
(510, 529.99, '2025-07-02', 5, 10, '11:30:00', 1),
(490, 489.99, '2025-07-02', 6, 5, '19:15:00', 1);
;

-- 5. Insert seats using a procedure
DELIMITER //
CREATE PROCEDURE GenerateSeatsForAllFlights()
BEGIN
    DECLARE flight_count INT;
    DECLARE i INT DEFAULT 1;

SELECT COUNT(*) INTO flight_count FROM flights;

WHILE i <= flight_count DO
        INSERT INTO seats (seatNr, byWindow, nearExit, moreLegRoom, class, occupied, flight_id) VALUES
        (1, TRUE, TRUE, TRUE, 'ECONOMY', IF(RAND() < 0.2, TRUE, FALSE), i),
        (2, FALSE, TRUE, TRUE, 'ECONOMY', IF(RAND() < 0.2, TRUE, FALSE), i),
        (3, TRUE, TRUE, FALSE, 'ECONOMY', IF(RAND() < 0.2, TRUE, FALSE), i),
        -- Row 2
        (4, TRUE, TRUE, FALSE, 'ECONOMY', IF(RAND() < 0.2, TRUE, FALSE), i),
        (5, FALSE, TRUE, FALSE, 'ECONOMY', IF(RAND() < 0.2, TRUE, FALSE), i),
        (6, TRUE, TRUE, FALSE, 'ECONOMY', IF(RAND() < 0.2, TRUE, FALSE), i),
        -- Row 3
        (7, TRUE, FALSE, TRUE, 'ECONOMY', IF(RAND() < 0.2, TRUE, FALSE), i),
        (8, FALSE, FALSE, TRUE, 'ECONOMY', IF(RAND() < 0.2, TRUE, FALSE), i),
        (9, TRUE, FALSE, FALSE, 'ECONOMY', IF(RAND() < 0.2, TRUE, FALSE), i),
        -- Row 4
        (10, TRUE, FALSE, FALSE, 'ECONOMY', IF(RAND() < 0.2, TRUE, FALSE), i),
        (11, FALSE, FALSE, FALSE, 'ECONOMY', IF(RAND() < 0.2, TRUE, FALSE), i),
        (12, TRUE, FALSE, FALSE, 'ECONOMY', IF(RAND() < 0.2, TRUE, FALSE), i),
        -- Row 5
        (13, TRUE, FALSE, TRUE, 'ECONOMY', IF(RAND() < 0.2, TRUE, FALSE), i),
        (14, FALSE, FALSE, TRUE, 'ECONOMY', IF(RAND() < 0.2, TRUE, FALSE), i),
        (15, TRUE, FALSE, FALSE, 'ECONOMY', IF(RAND() < 0.2, TRUE, FALSE), i),
        -- Row 6
        (16, TRUE, FALSE, FALSE, 'ECONOMY', IF(RAND() < 0.2, TRUE, FALSE), i),
        (17, FALSE, FALSE, FALSE, 'ECONOMY', IF(RAND() < 0.2, TRUE, FALSE), i),
        (18, TRUE, FALSE, FALSE, 'ECONOMY', IF(RAND() < 0.2, TRUE, FALSE), i),
        -- Row 7
        (19, TRUE, FALSE, TRUE, 'ECONOMY', IF(RAND() < 0.2, TRUE, FALSE), i),
        (20, FALSE, FALSE, TRUE, 'ECONOMY', IF(RAND() < 0.2, TRUE, FALSE), i),
        (21, TRUE, FALSE, FALSE, 'ECONOMY', IF(RAND() < 0.2, TRUE, FALSE), i);


        SET i = i + 1;
END WHILE;
END //
DELIMITER ;

CALL GenerateSeatsForAllFlights();
DROP PROCEDURE GenerateSeatsForAllFlights;