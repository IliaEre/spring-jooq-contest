DROP TABLE IF EXISTS "product";
DROP SEQUENCE IF EXISTS product_id_seq;
CREATE SEQUENCE product_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1;

CREATE TABLE "public"."product" (
                                    "id" integer DEFAULT nextval('product_id_seq') NOT NULL,
                                    "name" text NOT NULL,
                                    "price" numeric,
                                    "category_id" integer NOT NULL,
                                    "vendor" text,
                                    "sn" text,
                                    "owner" text,
                                    CONSTRAINT "product_pkey" PRIMARY KEY ("id"),
                                    CONSTRAINT "vendor_index" UNIQUE ("name"),
                                    CONSTRAINT "vendor_name" UNIQUE ("name")
) WITH (oids = false);