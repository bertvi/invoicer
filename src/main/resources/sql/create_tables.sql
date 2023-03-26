\connect invoicer;

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

CREATE TABLE IF NOT EXISTS activity (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    name TEXT NOT NULL,
    created TIMESTAMP WITH TIME ZONE NOT NULL,
    changed TIMESTAMP WITH TIME ZONE NOT NULL,
    removed TIMESTAMP WITH TIME ZONE
);

CREATE TABLE IF NOT EXISTS company (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    reg_no TEXT NOT NULL,
    company_form TEXT,
    name TEXT NOT NULL,
    vat_no TEXT NOT NULL,
    email TEXT NOT NULL,
    phone TEXT NOT NULL,
    address TEXT NOT NULL,
    country TEXT NOT NULL,
    bank_account TEXT NOT NULL,
    created TIMESTAMP WITH TIME ZONE NOT NULL,
    changed TIMESTAMP WITH TIME ZONE NOT NULL,
    removed TIMESTAMP WITH TIME ZONE
);

CREATE TABLE IF NOT EXISTS currency (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    name TEXT NOT NULL,
    created TIMESTAMP WITH TIME ZONE NOT NULL,
    changed TIMESTAMP WITH TIME ZONE NOT NULL,
    removed TIMESTAMP WITH TIME ZONE
);

CREATE TABLE IF NOT EXISTS customer (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    reg_no TEXT NOT NULL,
    company_form TEXT,
    name TEXT NOT NULL,
    vat_no TEXT NOT NULL,
    email TEXT NOT NULL,
    phone TEXT NOT NULL,
    address TEXT NOT NULL,
    country TEXT NOT NULL,
    bank_account TEXT NOT NULL,
    created TIMESTAMP WITH TIME ZONE NOT NULL,
    changed TIMESTAMP WITH TIME ZONE NOT NULL,
    removed TIMESTAMP WITH TIME ZONE
);

CREATE TABLE IF NOT EXISTS unit (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    name TEXT NOT NULL,
    created TIMESTAMP WITH TIME ZONE NOT NULL,
    changed TIMESTAMP WITH TIME ZONE NOT NULL,
    removed TIMESTAMP WITH TIME ZONE
);

CREATE TABLE IF NOT EXISTS price (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    value NUMERIC NOT NULL,
    unit_id BIGSERIAL NOT NULL REFERENCES unit(id),
    activity_id BIGSERIAL NOT NULL REFERENCES activity(id),
    currency_id BIGSERIAL NOT NULL REFERENCES currency(id),
    created TIMESTAMP WITH TIME ZONE NOT NULL,
    changed TIMESTAMP WITH TIME ZONE NOT NULL,
    removed TIMESTAMP WITH TIME ZONE
);

CREATE TABLE IF NOT EXISTS invoice (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    name TEXT NOT NULL,
    invoice_no TEXT NOT NULL,
    due_date TIMESTAMP WITH TIME ZONE NOT NULL,
    interest_rate NUMERIC NOT NULL,
    quantity INTEGER NOT NULL,
    amount NUMERIC NOT NULL,
    vat_percent NUMERIC NOT NULL,
    vat_amount NUMERIC NOT NULL,
    invoice_total NUMERIC NOT NULL,
    unit_id BIGSERIAL NOT NULL REFERENCES unit(id),
    price_id BIGSERIAL NOT NULL REFERENCES price(id),
    customer_id BIGSERIAL NOT NULL REFERENCES customer(id),
    company_id BIGSERIAL NOT NULL REFERENCES company(id),
    activity_id BIGSERIAL NOT NULL REFERENCES activity(id),
    created TIMESTAMP WITH TIME ZONE NOT NULL,
    changed TIMESTAMP WITH TIME ZONE NOT NULL,
    removed TIMESTAMP WITH TIME ZONE
);

ALTER TABLE activity OWNER TO invoicer;
ALTER TABLE company OWNER TO invoicer;
ALTER TABLE currency OWNER TO invoicer;
ALTER TABLE customer OWNER TO invoicer;
ALTER TABLE invoice OWNER TO invoicer;
ALTER TABLE price OWNER TO invoicer;
ALTER TABLE unit OWNER TO invoicer;