-- Crear tabla client
CREATE TABLE IF NOT EXISTS clients.client (
    id SERIAL PRIMARY KEY,
    identification_type VARCHAR(10) NOT NULL,
    identification_number VARCHAR(20) UNIQUE NOT NULL,
    names VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL,
    cell_phone VARCHAR(20) NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITHOUT TIME ZONE
    );

-- Crear tabla address
CREATE TABLE IF NOT EXISTS clients.address (
    id SERIAL PRIMARY KEY,
    province VARCHAR(100) NOT NULL,
    city VARCHAR(100) NOT NULL,
    address VARCHAR(255) NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITHOUT TIME ZONE
    );

-- Crear tabla client_address
CREATE TABLE IF NOT EXISTS clients.client_address (
                                                      id SERIAL PRIMARY KEY,
    client_id INTEGER NOT NULL,
    address_id INTEGER NOT NULL,
    is_main_address BOOLEAN NOT NULL DEFAULT FALSE,
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT fk_client FOREIGN KEY (client_id) REFERENCES clients.client (id) ON DELETE CASCADE,
    CONSTRAINT fk_address FOREIGN KEY (address_id) REFERENCES clients.address (id) ON DELETE CASCADE
    );

-- Crear índice único para asegurar solo una dirección principal por cliente
CREATE UNIQUE INDEX IF NOT EXISTS idx_client_main_address
    ON clients.client_address (client_id)
    WHERE is_main_address = true;