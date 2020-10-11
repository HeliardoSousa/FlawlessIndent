-- Table: public.produtos

-- DROP TABLE public.produtos;

CREATE TABLE public.produtos
(
    id integer NOT NULL DEFAULT nextval('produtos_id_seq'::regclass),
    titulo text COLLATE pg_catalog."default",
    descricao text COLLATE pg_catalog."default",
    categoria text COLLATE pg_catalog."default",
    valor integer,
    CONSTRAINT produtos_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.produtos
    OWNER to postgres;