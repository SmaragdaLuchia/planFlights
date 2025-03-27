INSERT INTO seats (seatNr, byWindow, nearExit, moreLegRoom, flight_id, class, occupied)
VALUES
    (1, true, false, false, 1, 'ECONOMY', false),
    (2, false, true, false, 1, 'ECONOMY', false),
    (3, true, false, true, 1, 'BUSINESS', false),
    (4, false, false, true, 1, 'BUSINESS', false),
    (5, true, false, false, 2, 'ECONOMY', false),
    (6, false, true, false, 2, 'ECONOMY', true),
    (7, false, false, true, 2, 'BUSINESS', true),
    (8, true, false, false, 3, 'ECONOMY', false),
    (9, false, false, false, 3, 'BUSINESS', false),
    (10, true, true, true, 3, 'BUSINESS', false);
