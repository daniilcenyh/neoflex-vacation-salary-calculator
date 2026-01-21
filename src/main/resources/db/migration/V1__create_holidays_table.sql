CREATE TABLE IF NOT EXISTS holidays (
    id BIGSERIAL PRIMARY KEY,
    date DATE NOT NULL UNIQUE,
    name VARCHAR(255) NOT NULL,
    is_day_off BOOLEAN NOT NULL DEFAULT true,
    year INTEGER NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);

CREATE INDEX idx_holidays_date ON holidays(date);
CREATE INDEX idx_holidays_year ON holidays(year);