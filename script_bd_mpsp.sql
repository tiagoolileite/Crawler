DROP TABLE TB_PF CASCADE CONSTRAINTS PURGE;
DROP TABLE TB_PJ CASCADE CONSTRAINTS PURGE;
DROP TABLE TB_ARISP CASCADE CONSTRAINTS PURGE;
DROP TABLE TB_ARPENSP CASCADE CONSTRAINTS PURGE;
DROP TABLE TB_CADESP CASCADE CONSTRAINTS PURGE;
DROP TABLE TB_CAGED CASCADE CONSTRAINTS PURGE;
DROP TABLE TB_CENSEC CASCADE CONSTRAINTS PURGE;
DROP TABLE TB_CONTATO_CENSEC CASCADE CONSTRAINTS PURGE;
DROP TABLE TB_PARTE_CENSEC CASCADE CONSTRAINTS PURGE;
DROP TABLE TB_DETRAN CASCADE CONSTRAINTS PURGE;
DROP TABLE TB_INFOCRIM CASCADE CONSTRAINTS PURGE;
DROP TABLE TB_JUCESP CASCADE CONSTRAINTS PURGE;
DROP TABLE TB_SIEL CASCADE CONSTRAINTS PURGE;
DROP TABLE TB_SIVEC CASCADE CONSTRAINTS PURGE;
DROP SEQUENCE PROCESSO_SEQ;
DROP SEQUENCE REGISTRO_ARPENSP_SEQ;
DROP SEQUENCE CADESP_SEQ;
DROP SEQUENCE CAGED_SEQ;
DROP SEQUENCE CENSEC_SEQ;
DROP SEQUENCE CONTATO_CENSEC_SEQ;
DROP SEQUENCE PARTE_CENSEC_SEQ;
DROP SEQUENCE DETRAN_SEQ;
DROP SEQUENCE INFOCRIM_SEQ;
DROP SEQUENCE JUCESP_SEQ;
DROP SEQUENCE SIEL_SEQ;
DROP SEQUENCE SIVEC_SEQ;

CREATE TABLE TB_PF(
    ID_PF NUMBER(8) NOT NULL,
    CPF VARCHAR2(18),
    RG VARCHAR2(15),
    NOME VARCHAR2(50),
    DT_NASCIMENTO DATE,
    DT_CONSULTA DATE,
    STATUS VARCHAR2(50),
    NR_PROCESSO_ARPENSP VARCHAR2(12),
    NR_PROCESSO_SIEL VARCHAR2(12),
    PIS_PASEP VARCHAR2(15),
    PLACA VARCHAR2(10),
    MATRICULA_SAP VARCHAR2(15),
    PRIMARY KEY (ID_PF)
);

CREATE TABLE TB_PJ (
    ID_PJ NUMBER(8) NOT NULL,
    CNPJ VARCHAR2(18),
    RAZAO_SOCIAL VARCHAR2(50),
    NOME_FANTASIA VARCHAR2(50),
    MATRICULA_ARISP VARCHAR2(50),
    DT_CONSULTA DATE,
    STATUS VARCHAR2(50),
    PRIMARY KEY (ID_PJ)
);

CREATE TABLE TB_ARISP(
    ID_PROCESSO NUMBER(8) NOT NULL,
    CIDADE VARCHAR2(25),
    CARTORIO VARCHAR2(50),
    MATRICULA VARCHAR2(25),
    ID_PF NUMBER(8),
    ID_PJ NUMBER(8),
    PRIMARY KEY(ID_PROCESSO)
);

CREATE TABLE TB_ARPENSP(
    ID_REGISTRO NUMBER(8) NOT NULL,
    CARTORIO_REGISTRO VARCHAR2(100),
    NR_CNS VARCHAR2(100),
    UF VARCHAR2(100),
    NOME_CONJUGE1 VARCHAR2(100),
    NOME_CONJUGE2 VARCHAR2(100),
    NV_NOME_CONJUGE2 VARCHAR2(100),
    DT_CASAMENTO VARCHAR2(20),
    MATRICULA VARCHAR2(50),
    DT_ENTRADA VARCHAR2(100),
    DT_REGISTRO VARCHAR2(100),
    ACERVO VARCHAR2(100),
    NR_LIVRO VARCHAR2(100),
    NR_FOLHA VARCHAR2(100),
    NR_REGISTRO VARCHAR2(100),
    TIPO_LIVRO VARCHAR2(100),
    ID_PF NUMBER(8),
    PRIMARY KEY(ID_REGISTRO)
);

CREATE TABLE TB_CADESP(
    ID_CADESP NUMBER(8) NOT NULL,
    IE VARCHAR2(50),
    SITUACAO_CADESP VARCHAR2(50),
    DT_INSCRICAO_ESTADO VARCHAR2(50),
    NOME_EMPRESARIAL VARCHAR2(50),
    REGIME_ESTADUAL VARCHAR2(50),
    DRT VARCHAR2(50),
    POSTO_FISCAL VARCHAR2(50),
    NIRE VARCHAR2(50),
    OCORRENCIA_FISCAL VARCHAR2(50),
    TIPO_UNIDADE VARCHAR2(50),
    DT_INICIO_IE VARCHAR2(50),
    FOMRAS_ATUACAO VARCHAR2(50),
    ID_PJ NUMBER(8),
    PRIMARY KEY(ID_CADESP)
);

CREATE TABLE TB_CAGED(
    ID_CAGED NUMBER(8) NOT NULL,
    LOGRADOURO VARCHAR2(60),
    BAIRRO_DISTRITO VARCHAR2(60),
    MUNICIPIO VARCHAR2(60),
    UF VARCHAR2(60),
    CEP VARCHAR2(60),
    NOME_CONTATO VARCHAR2(60),
    CPF_CONTATO VARCHAR2(60),
    TEL_CONTATO VARCHAR2(60),
    EMAIL_CONTATO VARCHAR2(60),
    RAMAL_CONTATO VARCHAR2(60),
    NR_FILIAIS VARCHAR2(60),
    ADMISSOES VARCHAR2(60),
    VARIACAO_ABSOLUTA VARCHAR2(60),
    TOTAL_VINCULOS VARCHAR2(60),
    DESLIGAMENTOS VARCHAR2(60),
    PRIMEIRO_DIA VARCHAR2(60),
    ULTIMO_DIA VARCHAR2(60),
    PIS_BASE  VARCHAR2(60),
    CTPS_SERIE VARCHAR2(60),
    SITUACAO_PIS VARCHAR2(60),
    NACIONALIDADE VARCHAR2(60),
    GRAU_INSTRUCAO VARCHAR2(60),
    DEFICIENTE VARCHAR2(60),
    SEXO VARCHAR2(60),
    RACA_COR VARCHAR2(60),
    TEMPO_TRABALHO VARCHAR2(60),
    RAIS VARCHAR2(60),
    ID_PF NUMBER(8),
    ID_PJ NUMBER(8),
    PRIMARY KEY(ID_CAGED)
);

CREATE TABLE TB_CENSEC(
    ID_CENSEC NUMBER(8) NOT NULL,
    NOME_EMPRESA VARCHAR2(100),
    CPF_CNPJ VARCHAR2(100),
    IDENTIDADE VARCHAR2(100),
    CARTORIO VARCHAR2(100),
    TIPO_ATO VARCHAR2(100),
    LIVRO VARCHAR2(100),
    FOLHA VARCHAR2(100),
    DT_ATO VARCHAR2(100),
    CARGA VARCHAR2(100),
    ATO_CARGA VARCHAR2(100),
    DT_ATO_CARGA VARCHAR2(100),
    LIVRO_CARGA VARCHAR2(100),
    COMP_LIVRO_CARGA VARCHAR2(100),
    FOLHA_CARGA VARCHAR2(100),
    COMP_FOLHA_CARGA VARCHAR2(100),
    ID_PF NUMBER(8),
    ID_PJ NUMBER(8),
    PRIMARY KEY(ID_CENSEC)
);

CREATE TABLE TB_CONTATO_CENSEC(
    ID_CONTATO_CENSEC NUMBER(8)NOT NULL,
    TELEFONE VARCHAR2(100),
    TIPO VARCHAR2(100),
    RAMAL VARCHAR2(100),
    CONTATO VARCHAR2(100),
    STATUS VARCHAR2(100),
    ID_CENSEC NUMBER(8),
    ID_PF NUMBER(8),
    ID_PJ NUMBER(8),
    PRIMARY KEY(ID_CONTATO_CENSEC)
);

CREATE TABLE TB_PARTE_CENSEC(
    ID_PARTE_CENSEC NUMBER(8)NOT NULL,
    NOME VARCHAR2(100),
    CPF_CNPJ VARCHAR2(100),
    QUALIDADE VARCHAR2(100),
    ID_CENSEC NUMBER(8),
    ID_PF NUMBER(8),
    ID_PJ NUMBER(8),
    PRIMARY KEY(ID_PARTE_CENSEC)
);

CREATE TABLE TB_DETRAN(
    ID_DETRAN NUMBER(8)NOT NULL,
    RENACH VARCHAR2(100),
    CATEGORIA VARCHAR2(100),
    EMISSAO VARCHAR2(100),
    DT_NASCIMENTO VARCHAR2(100),
    NOME_CONDUTOR VARCHAR2(100),
    NOME_PAI VARCHAR2(100),
    NOME_MAE VARCHAR2(100),
    REGISTRO VARCHAR2(100),
    TIPOGRAFICO VARCHAR2(100),
    IDENTIDADE VARCHAR2(100),
    CPF VARCHAR2(100),
    ID_PF NUMBER(8),
    ID_PJ NUMBER(8),
    PRIMARY KEY(ID_DETRAN)
);

CREATE TABLE TB_INFOCRIM(
    ID_INFOCRIM NUMBER(8)NOT NULL,
    ID_PF NUMBER(8),
    PRIMARY KEY(ID_INFOCRIM)
);

CREATE TABLE TB_JUCESP(
    ID_JUCESP NUMBER(8)NOT NULL,
    RAZAO_SOCIAL VARCHAR2(100),
    NIRE_MATRIZ VARCHAR2(100),
    TIPO_EMPRESA VARCHAR2(100),
    DT_CONSTITUICAO VARCHAR2(100),
    INICIO_ATIVIDADE VARCHAR2(100),
    CNPJ VARCHAR2(100),
    OBJETIVO VARCHAR2(1000),
    CAPITAL VARCHAR2(250),
    LOGRADOURO VARCHAR2(100),
    NR VARCHAR2(100),
    BAIRRO VARCHAR2(100),
    MUNICIPIO VARCHAR2(100),
    COMPLEMENTO VARCHAR2(100),
    CEP VARCHAR2(100),
    UF VARCHAR2(100),
    ID_PJ NUMBER(8),
    PRIMARY KEY(ID_JUCESP)
);

CREATE TABLE TB_SIEL(
    ID_SIEL NUMBER(8)NOT NULL,
    NOME VARCHAR2(100),
    TITULO VARCHAR2(100),
    DT_NASCIMENTO VARCHAR2(100),
    ZONA VARCHAR2(100),
    ENDERECO VARCHAR2(100),
    MUNICIPIO VARCHAR2(100),
    UF VARCHAR2(100),
    DT_DOMICILIO VARCHAR2(100),
    NOME_PAI VARCHAR2(100),
    NOME_MAE VARCHAR2(100),
    NATURALIDADE VARCHAR2(100),
    COD_VALIDACAO VARCHAR2(100),
    ID_PF NUMBER(8),
    PRIMARY KEY(ID_SIEL)
);

CREATE TABLE TB_SIVEC(
    ID_SIVEC NUMBER(8)NOT NULL,
    NOME VARCHAR2(100),
    SEXO VARCHAR2(100),
    DT_NASCIMENTO VARCHAR2(100),
    RG VARCHAR2(100),
    TIPO_RG VARCHAR2(100),
    DT_EMISSAO_RG VARCHAR2(100),
    ESTADO_CIVIL VARCHAR2(100),
    NATURALIZADO VARCHAR2(100),
    GRAU_INSTRUCAO VARCHAR2(100),
    NOME_PAI VARCHAR2(100),
    NOME_MAE VARCHAR2(100),
    COR_PELE VARCHAR2(100),
    ALCUNHA VARCHAR2(100),
    NATURALIDADE VARCHAR2(100),
    POSTO_IDENTIFICACAO VARCHAR2(100),
    FORMULA_FUNDAMENTAL VARCHAR2(100),
    COR_OLHOS VARCHAR2(100),
    CABELO VARCHAR2(100),
    PROFISSAO VARCHAR2(100),
    ENDERECO_RESIDENCIAL VARCHAR2(100),
    ENDERECO_TRABALHO VARCHAR2(100),
    ID_PF NUMBER(8),
    PRIMARY KEY(ID_SIVEC)
);

ALTER TABLE TB_ARISP
ADD CONSTRAINT FK_PROCESSO_PF
FOREIGN KEY(ID_PF)
REFERENCES TB_PF(ID_PF);

ALTER TABLE TB_ARISP
ADD CONSTRAINT FK_PROCESSO_PJ
FOREIGN KEY(ID_PJ)
REFERENCES TB_PJ(ID_PJ);

ALTER TABLE TB_ARPENSP
ADD CONSTRAINT FK_REGISTRO_PF
FOREIGN KEY(ID_PF)
REFERENCES TB_PF(ID_PF);

ALTER TABLE TB_CADESP
ADD CONSTRAINT FK_CADESP_PJ
FOREIGN KEY(ID_PJ)
REFERENCES TB_PJ(ID_PJ);

ALTER TABLE TB_CAGED
ADD CONSTRAINT FK_CAGED_PF
FOREIGN KEY(ID_PF)
REFERENCES TB_PF(ID_PF);

ALTER TABLE TB_CAGED
ADD CONSTRAINT FK_CAGED_PJ
FOREIGN KEY(ID_PJ)
REFERENCES TB_PJ(ID_PJ);

ALTER TABLE TB_CENSEC
ADD CONSTRAINT FK_CESNEC_PF
FOREIGN KEY(ID_PF)
REFERENCES TB_PF(ID_PF);

ALTER TABLE TB_CENSEC
ADD CONSTRAINT FK_CENSEC_PJ
FOREIGN KEY(ID_PJ)
REFERENCES TB_PJ(ID_PJ);

ALTER TABLE TB_CONTATO_CENSEC
ADD CONSTRAINT FK_CONTATOCESNEC_PF
FOREIGN KEY(ID_PF)
REFERENCES TB_PF(ID_PF);

ALTER TABLE TB_CONTATO_CENSEC
ADD CONSTRAINT FK_CONTATOCENSEC_PJ
FOREIGN KEY(ID_PJ)
REFERENCES TB_PJ(ID_PJ);

ALTER TABLE TB_CONTATO_CENSEC
ADD CONSTRAINT FK_CONTATOCENSEC_CEN
FOREIGN KEY(ID_CENSEC)
REFERENCES TB_CENSEC(ID_CENSEC);

ALTER TABLE TB_PARTE_CENSEC
ADD CONSTRAINT FK_PARTECESNEC_PF
FOREIGN KEY(ID_PF)
REFERENCES TB_PF(ID_PF);

ALTER TABLE TB_PARTE_CENSEC
ADD CONSTRAINT FK_PARTECENSEC_PJ
FOREIGN KEY(ID_PJ)
REFERENCES TB_PJ(ID_PJ);

ALTER TABLE TB_PARTE_CENSEC
ADD CONSTRAINT FK_PARTECENSEC_CEN
FOREIGN KEY(ID_CENSEC)
REFERENCES TB_CENSEC(ID_CENSEC);

ALTER TABLE TB_DETRAN
ADD CONSTRAINT FK_DETRAN_PF
FOREIGN KEY(ID_PF)
REFERENCES TB_PF(ID_PF);

ALTER TABLE TB_DETRAN
ADD CONSTRAINT FK_DETRAN_PJ
FOREIGN KEY(ID_PJ)
REFERENCES TB_PJ(ID_PJ);

ALTER TABLE TB_INFOCRIM
ADD CONSTRAINT FK_INFOCRIM_PF
FOREIGN KEY(ID_PF)
REFERENCES TB_PF(ID_PF);

ALTER TABLE TB_JUCESP
ADD CONSTRAINT FK_JUCESP_PJ
FOREIGN KEY(ID_PJ)
REFERENCES TB_PJ(ID_PJ);

ALTER TABLE TB_SIEL
ADD CONSTRAINT FK_SIEL_PF
FOREIGN KEY(ID_PF)
REFERENCES TB_PF(ID_PF);

ALTER TABLE TB_SIVEC
ADD CONSTRAINT FK_SIVEC_PF
FOREIGN KEY(ID_PF)
REFERENCES TB_PF(ID_PF);

CREATE SEQUENCE PROCESSO_SEQ START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE REGISTRO_ARPENSP_SEQ START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE CADESP_SEQ START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE CAGED_SEQ START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE CENSEC_SEQ START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE CONTATO_CENSEC_SEQ START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE PARTE_CENSEC_SEQ START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE DETRAN_SEQ START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE INFOCRIM_SEQ START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE JUCESP_SEQ START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE SIEL_SEQ START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE SIVEC_SEQ START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;