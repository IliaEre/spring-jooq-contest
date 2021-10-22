DROP TABLE IF EXISTS "description";
DROP SEQUENCE IF EXISTS description_id_seq;
CREATE SEQUENCE description_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;

CREATE TABLE "public"."description" (
                                        "id" bigint DEFAULT nextval('description_id_seq') NOT NULL,
                                        "product_id" integer NOT NULL,
                                        "descr" integer NOT NULL,
                                        CONSTRAINT "description_pkey" PRIMARY KEY ("id")
) WITH (oids = false);