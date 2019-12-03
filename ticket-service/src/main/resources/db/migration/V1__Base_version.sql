CREATE TABLE ticket(
    ticket_id VARCHAR(36) PRIMARY KEY NOT NULL,
    ticket_title VARCHAR(200),
    ticket_created_by VARCHAR(36) NOT NULL,
    ticket_is_deleted BIT
)