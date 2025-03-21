-- Insert sample airlines
INSERT INTO airlines (name) VALUES
                                ('American Airlines'),
                                ('Delta Airlines'),
                                ('United Airlines'),
                                ('Lufthansa'),
                                ('Emirates');

-- Insert sample destinations
INSERT INTO destinations (name, region) VALUES
                                            ('New York', 'USA'),
                                            ('Los Angeles', 'USA'),
                                            ('London', 'UK'),
                                            ('Paris', 'France'),
                                            ('Tokyo', 'Japan'),
                                            ('Dubai', 'UAE');

-- Insert 50 sample flights
INSERT INTO flights (duration, price, date, destination_id, airline_id) VALUES
                                                                            (180, 299.99, '2025-04-10', 1, 1),
                                                                            (240, 350.00, '2025-04-11', 2, 2),
                                                                            (360, 450.50, '2025-04-12', 3, 3),
                                                                            (420, 500.00, '2025-04-13', 4, 4),
                                                                            (540, 750.00, '2025-04-14', 5, 5),
                                                                            (150, 199.99, '2025-04-15', 6, 1),
                                                                            (200, 250.00, '2025-04-16', 1, 2),
                                                                            (300, 330.00, '2025-04-17', 2, 3),
                                                                            (360, 400.00, '2025-04-18', 3, 4),
                                                                            (480, 550.00, '2025-04-19', 4, 5),
                                                                            (600, 800.00, '2025-04-20', 5, 1),
                                                                            (210, 299.50, '2025-04-21', 6, 2),
                                                                            (180, 310.00, '2025-04-22', 1, 3),
                                                                            (240, 350.00, '2025-04-23', 2, 4),
                                                                            (300, 450.00, '2025-04-24', 3, 5),
                                                                            (360, 500.00, '2025-04-25', 4, 1),
                                                                            (420, 600.00, '2025-04-26', 5, 2),
                                                                            (480, 650.00, '2025-04-27', 6, 3),
                                                                            (540, 700.00, '2025-04-28', 1, 4),
                                                                            (600, 750.00, '2025-04-29', 2, 5),
                                                                            (210, 320.00, '2025-04-30', 3, 1),
                                                                            (180, 280.00, '2025-05-01', 4, 2),
                                                                            (240, 340.00, '2025-05-02', 5, 3),
                                                                            (300, 420.00, '2025-05-03', 6, 4),
                                                                            (360, 480.00, '2025-05-04', 1, 5),
                                                                            (420, 530.00, '2025-05-05', 2, 1),
                                                                            (480, 600.00, '2025-05-06', 3, 2),
                                                                            (540, 670.00, '2025-05-07', 4, 3),
                                                                            (600, 750.00, '2025-05-08', 5, 4),
                                                                            (210, 320.00, '2025-05-09', 6, 5),
                                                                            (180, 290.00, '2025-05-10', 1, 1),
                                                                            (240, 350.00, '2025-05-11', 2, 2),
                                                                            (300, 410.00, '2025-05-12', 3, 3),
                                                                            (360, 470.00, '2025-05-13', 4, 4),
                                                                            (420, 530.00, '2025-05-14', 5, 5),
                                                                            (480, 590.00, '2025-05-15', 6, 1),
                                                                            (540, 650.00, '2025-05-16', 1, 2),
                                                                            (600, 710.00, '2025-05-17', 2, 3),
                                                                            (210, 330.00, '2025-05-18', 3, 4),
                                                                            (180, 300.00, '2025-05-19', 4, 5),
                                                                            (240, 360.00, '2025-05-20', 5, 1),
                                                                            (300, 420.00, '2025-05-21', 6, 2),
                                                                            (360, 480.00, '2025-05-22', 1, 3),
                                                                            (420, 540.00, '2025-05-23', 2, 4),
                                                                            (480, 600.00, '2025-05-24', 3, 5),
                                                                            (540, 660.00, '2025-05-25', 4, 1),
                                                                            (600, 720.00, '2025-05-26', 5, 2),
                                                                            (210, 330.00, '2025-05-27', 6, 3),
                                                                            (180, 310.00, '2025-05-28', 1, 4),
                                                                            (240, 370.00, '2025-05-29', 2, 5);

