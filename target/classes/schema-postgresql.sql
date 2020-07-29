DROP TABLE IF EXISTS quotes;

DROP TABLE IF EXISTS quotes_user;

CREATE TABLE quotes
(
    downvotes integer,
    id bigint NOT NULL DEFAULT nextval('quotes_id_seq'::regclass),
    title text COLLATE pg_catalog."default" NOT NULL,
    upvotes integer,
    creator text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT quotes_pkey PRIMARY KEY (id)
);

CREATE TABLE quotes_user
(
    id text COLLATE pg_catalog."default" NOT NULL,
    password text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT quotes_user_pkey PRIMARY KEY (id)
);
