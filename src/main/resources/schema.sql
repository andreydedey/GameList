CREATE TABLE IF NOT EXISTS TB_GAME_LIST (
                              id BIGSERIAL PRIMARY KEY, -- Alterado de INT AUTO_INCREMENT para BIGSERIAL para PostgreSQL
                              name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS TB_GAME (
                         id BIGSERIAL PRIMARY KEY, -- Alterado de INT AUTO_INCREMENT para BIGSERIAL para PostgreSQL
                         title VARCHAR(255) NOT NULL,
                         score DECIMAL(3, 1),
                         game_year INT,
                         genre VARCHAR(255),
                         platforms VARCHAR(255),
                         img_url VARCHAR(255),
                         short_description TEXT,
                         long_description TEXT
);

CREATE TABLE IF NOT EXISTS TB_BELONGING (
                              list_id BIGINT NOT NULL, -- BIGINT para corresponder ao BIGSERIAL da tabela TB_GAME_LIST
                              game_id BIGINT NOT NULL, -- BIGINT para corresponder ao BIGSERIAL da tabela TB_GAME
                              position INT NOT NULL,
                              PRIMARY KEY (list_id, game_id),
                              FOREIGN KEY (list_id) REFERENCES TB_GAME_LIST(id),
                              FOREIGN KEY (game_id) REFERENCES TB_GAME(id)
);
