-- Table: public.users

-- DROP TABLE public.users;

CREATE TABLE public.users
(
    id integer NOT NULL DEFAULT nextval('users_id_seq'::regclass),
    login text COLLATE pg_catalog."default",
    password text COLLATE pg_catalog."default",
    nome text COLLATE pg_catalog."default",
    sobrenome text COLLATE pg_catalog."default",
    CONSTRAINT users_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.users
    OWNER to postgres;