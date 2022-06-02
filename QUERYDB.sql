-- Database: todosistemastest

-- DROP DATABASE todosistemastest;

CREATE DATABASE todosistemastest2
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Colombia.1252'
    LC_CTYPE = 'Spanish_Colombia.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

CREATE TABLE public.employee
(
    id bigint NOT NULL DEFAULT nextval('employee_id_seq'::regclass),
    name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT employee_pkey PRIMARY KEY (id)
)

CREATE TABLE public.activity
(
    id bigint NOT NULL DEFAULT nextval('activity_id_seq'::regclass),
    description character varying(255) COLLATE pg_catalog."default",
    estimation_date timestamp without time zone,
    status character varying(255) COLLATE pg_catalog."default",
    employee_id bigint,
    CONSTRAINT activity_pkey PRIMARY KEY (id),
    CONSTRAINT fkm67enjapuo2hd7irnv1k2fx7t FOREIGN KEY (employee_id)
        REFERENCES public.employee (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
    
