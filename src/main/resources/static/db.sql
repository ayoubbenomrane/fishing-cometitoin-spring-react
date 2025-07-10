    -- Table: joueur
    CREATE TABLE IF NOT EXISTS player (
        id SERIAL PRIMARY KEY ,
        first_name TEXT NOT NULL,
        last_name TEXT NOT NULL,
        profile_picture TEXT,
        phone_number TEXT,
        cin INTEGER

    );

    -- Table: journee
    CREATE TABLE IF NOT EXISTS round (
        id SERIAL PRIMARY KEY ,
        name TEXT DEFAULT 'Journee X',
        date DATE DEFAULT CURRENT_DATE,
        place TEXT DEFAULT 'Tunisia',
        duration TIME DEFAULT '05:00:00'
    );

    -- Table: record
    CREATE TABLE IF NOT EXISTS record (
        id SERIAL PRIMARY KEY ,
        round_id INTEGER NOT NULL,
        player_id INTEGER NOT NULL,
        absent BOOLEAN NOT NULL DEFAULT FALSE,
        fish_count INTEGER NOT NULL,
        total_weight FLOAT NOT NULL,
        FOREIGN KEY (round_id) REFERENCES round (id) ON DELETE CASCADE ON UPDATE CASCADE,
        FOREIGN KEY (player_id) REFERENCES player (id) ON DELETE CASCADE ON UPDATE CASCADE
    );