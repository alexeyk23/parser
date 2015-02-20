-- Table: articles

-- DROP TABLE articles;

CREATE TABLE articles
(
  id serial NOT NULL,
  title text,
  content text,
  date_article date,
  CONSTRAINT articles_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE articles
  OWNER TO postgres;
