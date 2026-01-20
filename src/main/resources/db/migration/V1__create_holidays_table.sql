CREATE TABLE holidays (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    date DATE NOT NULL UNIQUE,
    name VARCHAR(255) NOT NULL,
    is_transferable BOOLEAN DEFAULT FALSE, -- является ли перенесенным выходным
    year INTEGER NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_holidays_date ON holidays(date);
CREATE INDEX idx_holidays_year ON holidays(year);