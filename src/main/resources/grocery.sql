CREATE SEQUENCE grocery_id_seq;
CREATE TABLE helloworld.grocery (
  isle INTEGER,
  price NUMERIC,
  name CHARACTER VARYING(26) NOT NULL,
  category CHARACTER VARYING(26),
  id BIGINT PRIMARY KEY NOT NULL DEFAULT nextval('grocery_id_seq'::regclass)
);