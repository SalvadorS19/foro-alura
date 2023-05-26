CREATE TABLE topicos (
  id BIGINT NOT NULL auto_increment,
  titulo VARCHAR(100) NOT NULL UNIQUE,
  mensaje VARCHAR(500) NOT NULL UNIQUE,
  fecha_creacion DATE NOT NULL,
  estatus VARCHAR(50) NOT NULL,
  autor VARCHAR(50) NOT NULL,
  curso VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
);
