INSERT INTO users (username, age, email, phone_number, password, roles, created_at, removed_at, created_user, removed_user) VALUES
('Alex1', 25, 'user1@example.com', '1234567890', '12345', 'ROLE_USER', NOW(), NULL, 1, NULL),
('Alex', 30, 'user2@example.com', '0987654321', '123', 'ROLE_ADMIN', NOW(), NULL, 1, NULL),
('User3', 35, 'user3@example.com', '1122334455', '1234', 'ROLE_USER', NOW(), NULL, 1, NULL);