--
-- PostgreSQL database dump
--

-- Dumped from database version 9.1.2
-- Dumped by pg_dump version 9.1.2
-- Started on 2014-02-08 10:07:39


SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 6 (class 2615 OID 16509)
-- Name: cont_de_clientes; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA cont_de_clientes;


ALTER SCHEMA cont_de_clientes OWNER TO postgres;

--
-- TOC entry 165 (class 3079 OID 11639)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 1876 (class 0 OID 0)
-- Dependencies: 165
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = cont_de_clientes, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 162 (class 1259 OID 16545)
-- Dependencies: 1856 6
-- Name: cliente; Type: TABLE; Schema: cont_de_clientes; Owner: postgres; Tablespace: 
--

CREATE TABLE cliente (
    id integer NOT NULL,
    nome character varying(35) NOT NULL,
    nascimento date,
    rg character varying(20),
    cpf character(14),
    telefone character(15),
    celular character(15),
    rua character varying(20),
    numrua character varying(10),
    complemento character varying(15),
    cidade character varying(20),
    sexo character(1) NOT NULL,
    profissao character varying(25),
    ecivil character varying(20),
    nficha integer DEFAULT 0 NOT NULL,
    clidesde character varying(12)
);


ALTER TABLE cont_de_clientes.cliente OWNER TO postgres;

--
-- TOC entry 161 (class 1259 OID 16543)
-- Dependencies: 162 6
-- Name: cliente_id_seq; Type: SEQUENCE; Schema: cont_de_clientes; Owner: postgres
--

CREATE SEQUENCE cliente_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE cont_de_clientes.cliente_id_seq OWNER TO postgres;

--
-- TOC entry 1877 (class 0 OID 0)
-- Dependencies: 161
-- Name: cliente_id_seq; Type: SEQUENCE OWNED BY; Schema: cont_de_clientes; Owner: postgres
--

ALTER SEQUENCE cliente_id_seq OWNED BY cliente.id;


--
-- TOC entry 1878 (class 0 OID 0)
-- Dependencies: 161
-- Name: cliente_id_seq; Type: SEQUENCE SET; Schema: cont_de_clientes; Owner: postgres
--

SELECT pg_catalog.setval('cliente_id_seq', 1, false);


--
-- TOC entry 164 (class 1259 OID 16573)
-- Dependencies: 6
-- Name: venda; Type: TABLE; Schema: cont_de_clientes; Owner: postgres; Tablespace: 
--

CREATE TABLE venda (
    id integer NOT NULL,
    id_cliente integer NOT NULL,
    produto character varying NOT NULL,
    data character varying NOT NULL,
    descricao character varying,
    valor double precision NOT NULL
);


ALTER TABLE cont_de_clientes.venda OWNER TO postgres;

--
-- TOC entry 163 (class 1259 OID 16571)
-- Dependencies: 6 164
-- Name: venda_id_seq; Type: SEQUENCE; Schema: cont_de_clientes; Owner: postgres
--

CREATE SEQUENCE venda_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE cont_de_clientes.venda_id_seq OWNER TO postgres;

--
-- TOC entry 1879 (class 0 OID 0)
-- Dependencies: 163
-- Name: venda_id_seq; Type: SEQUENCE OWNED BY; Schema: cont_de_clientes; Owner: postgres
--

ALTER SEQUENCE venda_id_seq OWNED BY venda.id;


--
-- TOC entry 1880 (class 0 OID 0)
-- Dependencies: 163
-- Name: venda_id_seq; Type: SEQUENCE SET; Schema: cont_de_clientes; Owner: postgres
--

SELECT pg_catalog.setval('venda_id_seq', 1, false);


--
-- TOC entry 1855 (class 2604 OID 16548)
-- Dependencies: 162 161 162
-- Name: id; Type: DEFAULT; Schema: cont_de_clientes; Owner: postgres
--

ALTER TABLE cliente ALTER COLUMN id SET DEFAULT nextval('cliente_id_seq'::regclass);


--
-- TOC entry 1857 (class 2604 OID 16576)
-- Dependencies: 164 163 164
-- Name: id; Type: DEFAULT; Schema: cont_de_clientes; Owner: postgres
--

ALTER TABLE venda ALTER COLUMN id SET DEFAULT nextval('venda_id_seq'::regclass);


--
-- TOC entry 1859 (class 2606 OID 16555)
-- Dependencies: 162 162
-- Name: cliente_cpf_key; Type: CONSTRAINT; Schema: cont_de_clientes; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cliente
    ADD CONSTRAINT cliente_cpf_key UNIQUE (cpf);


--
-- TOC entry 1861 (class 2606 OID 16553)
-- Dependencies: 162 162
-- Name: cliente_nficha_key; Type: CONSTRAINT; Schema: cont_de_clientes; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cliente
    ADD CONSTRAINT cliente_nficha_key UNIQUE (nficha);


--
-- TOC entry 1863 (class 2606 OID 16557)
-- Dependencies: 162 162
-- Name: cliente_nome_key; Type: CONSTRAINT; Schema: cont_de_clientes; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cliente
    ADD CONSTRAINT cliente_nome_key UNIQUE (nome);


--
-- TOC entry 1865 (class 2606 OID 16551)
-- Dependencies: 162 162
-- Name: cliente_pkey; Type: CONSTRAINT; Schema: cont_de_clientes; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (id);


--
-- TOC entry 1867 (class 2606 OID 16559)
-- Dependencies: 162 162
-- Name: cliente_rg_key; Type: CONSTRAINT; Schema: cont_de_clientes; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cliente
    ADD CONSTRAINT cliente_rg_key UNIQUE (rg);


--
-- TOC entry 1869 (class 2606 OID 16581)
-- Dependencies: 164 164
-- Name: venda_pkey; Type: CONSTRAINT; Schema: cont_de_clientes; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY venda
    ADD CONSTRAINT venda_pkey PRIMARY KEY (id);


--
-- TOC entry 1870 (class 2606 OID 16582)
-- Dependencies: 1864 164 162
-- Name: venda_id_cliente_fkey; Type: FK CONSTRAINT; Schema: cont_de_clientes; Owner: postgres
--

ALTER TABLE ONLY venda
    ADD CONSTRAINT venda_id_cliente_fkey FOREIGN KEY (id_cliente) REFERENCES cliente(id);


-- Completed on 2014-02-08 10:07:40

--
-- PostgreSQL database dump complete
--

