CREATE TABLE person.person
(
    id       UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    nombre   VARCHAR(60),
    apellido VARCHAR(60),
    telefono VARCHAR(60)
);
