--
-- PostgreSQL database dump
--

-- Dumped from database version 9.2.1
-- Dumped by pg_dump version 9.2.1
-- Started on 2014-02-07 20:31:04

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 6 (class 2615 OID 24753)
-- Name: cont_de_clientes; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA cont_de_clientes;


ALTER SCHEMA cont_de_clientes OWNER TO postgres;

--
-- TOC entry 172 (class 3079 OID 11727)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 1944 (class 0 OID 0)
-- Dependencies: 172
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = cont_de_clientes, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 168 (class 1259 OID 24754)
-- Name: cliente; Type: TABLE; Schema: cont_de_clientes; Owner: postgres; Tablespace: 
--

CREATE TABLE cliente (
    id integer NOT NULL,
    nome character varying(35) NOT NULL,
    nascimento date,
    rg character varying(20),
    cpf character(14),
    telefone character(14),
    celular character(14),
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
-- TOC entry 169 (class 1259 OID 24758)
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
-- TOC entry 1945 (class 0 OID 0)
-- Dependencies: 169
-- Name: cliente_id_seq; Type: SEQUENCE OWNED BY; Schema: cont_de_clientes; Owner: postgres
--

ALTER SEQUENCE cliente_id_seq OWNED BY cliente.id;


--
-- TOC entry 1946 (class 0 OID 0)
-- Dependencies: 169
-- Name: cliente_id_seq; Type: SEQUENCE SET; Schema: cont_de_clientes; Owner: postgres
--

SELECT pg_catalog.setval('cliente_id_seq', 2, true);


--
-- TOC entry 170 (class 1259 OID 24760)
-- Name: venda; Type: TABLE; Schema: cont_de_clientes; Owner: postgres; Tablespace: 
--

CREATE TABLE venda (
    id integer NOT NULL,
    id_cliente integer NOT NULL,
    produto character varying NOT NULL,
    data character varying,
    descricao character varying,
    valor double precision
);


ALTER TABLE cont_de_clientes.venda OWNER TO postgres;

--
-- TOC entry 171 (class 1259 OID 24767)
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
-- TOC entry 1947 (class 0 OID 0)
-- Dependencies: 171
-- Name: venda_id_seq; Type: SEQUENCE OWNED BY; Schema: cont_de_clientes; Owner: postgres
--

ALTER SEQUENCE venda_id_seq OWNED BY venda.id;


--
-- TOC entry 1948 (class 0 OID 0)
-- Dependencies: 171
-- Name: venda_id_seq; Type: SEQUENCE SET; Schema: cont_de_clientes; Owner: postgres
--

SELECT pg_catalog.setval('venda_id_seq', 1, false);


--
-- TOC entry 1924 (class 2604 OID 24769)
-- Name: id; Type: DEFAULT; Schema: cont_de_clientes; Owner: postgres
--

ALTER TABLE ONLY cliente ALTER COLUMN id SET DEFAULT nextval('cliente_id_seq'::regclass);


--
-- TOC entry 1925 (class 2604 OID 24770)
-- Name: id; Type: DEFAULT; Schema: cont_de_clientes; Owner: postgres
--

ALTER TABLE ONLY venda ALTER COLUMN id SET DEFAULT nextval('venda_id_seq'::regclass);


--
-- TOC entry 1927 (class 2606 OID 24772)
-- Name: paciente_cpf_key; Type: CONSTRAINT; Schema: cont_de_clientes; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cliente
    ADD CONSTRAINT paciente_cpf_key UNIQUE (cpf);


--
-- TOC entry 1929 (class 2606 OID 24774)
-- Name: paciente_nome_key; Type: CONSTRAINT; Schema: cont_de_clientes; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cliente
    ADD CONSTRAINT paciente_nome_key UNIQUE (nome);


--
-- TOC entry 1931 (class 2606 OID 24776)
-- Name: paciente_pkey; Type: CONSTRAINT; Schema: cont_de_clientes; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cliente
    ADD CONSTRAINT paciente_pkey PRIMARY KEY (id);


--
-- TOC entry 1933 (class 2606 OID 24778)
-- Name: paciente_rg_key; Type: CONSTRAINT; Schema: cont_de_clientes; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cliente
    ADD CONSTRAINT paciente_rg_key UNIQUE (rg);


--
-- TOC entry 1935 (class 2606 OID 24780)
-- Name: venda_pkey; Type: CONSTRAINT; Schema: cont_de_clientes; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY venda
    ADD CONSTRAINT venda_pkey PRIMARY KEY (id);


--
-- TOC entry 1936 (class 2606 OID 24786)
-- Name: venda_id_cliente_fkey; Type: FK CONSTRAINT; Schema: cont_de_clientes; Owner: postgres
--

ALTER TABLE ONLY venda
    ADD CONSTRAINT venda_id_cliente_fkey FOREIGN KEY (id_cliente) REFERENCES cliente(id);


ALTER SEQUENCE cliente_id_seq RESTART WITH 1;
ALTER SEQUENCE venda_id_seq RESTART WITH 1;


-- Completed on 2014-02-07 20:31:04

--
-- PostgreSQL database dump complete
--

