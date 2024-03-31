CREATE TABLE usuario (
    id SERIAL PRIMARY KEY,
    primeiro_nome TEXT NOT NULL,
    segundo_nome TEXT NOT NULL,
    login TEXT NOT NULL UNIQUE,
    password TEXT NOT NULL,
    role TEXT NOT NULL,
    data_criacao TIMESTAMP NOT NULL,
    flag_ativo BOOLEAN DEFAULT TRUE
);

CREATE TABLE musica (
    id SERIAL PRIMARY KEY,
    titulo TEXT NOT NULL,
    tonalidade TEXT NOT NULL,
    cantor TEXT,
    link_versao TEXT NOT NULL,
    data_criacao TIMESTAMP NOT NULL,
    flag_ativo BOOLEAN DEFAULT TRUE,
    cifrador_fk INTEGER NOT NULL,
    FOREIGN KEY (cifrador_fk) REFERENCES usuario(id)
);

CREATE TABLE estrofe (
    id SERIAL PRIMARY KEY,
    ordenacao INTEGER NOT NULL,
    musica_fk INTEGER NOT NULL,
    FOREIGN KEY (musica_fk) REFERENCES musica(id)
);

CREATE TABLE verso (
    id SERIAL PRIMARY KEY,
    texto TEXT NOT NULL,
    ordenacao INTEGER NOT NULL,
    estrofe_fk INTEGER NOT NULL,
    FOREIGN KEY (estrofe_fk) REFERENCES estrofe(id)
);

CREATE TABLE solo (
    id SERIAL PRIMARY KEY,
    ordenacao INTEGER NOT NULL,
    musica_fk INTEGER NOT NULL,
    FOREIGN KEY (musica_fk) REFERENCES musica(id)
);

CREATE TABLE acorde (
    id SERIAL PRIMARY KEY,
    tipo TEXT NOT NULL,
    cifra TEXT NOT NULL,
    espacamento_direito REAL,
    espacamento_esquerdo REAL,
    ordenacao INTEGER NOT NULL,
    verso_fk INTEGER,
    FOREIGN KEY (verso_fk) REFERENCES verso(id),
    solo_fk INTEGER,
    FOREIGN KEY (solo_fk) REFERENCES solo(id)
);
