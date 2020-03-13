Projeto Desafio MV Sistemas Versão 1.0

Este projeto é parte integrante do conjunto de avaliações realizadas com os profissionais de TI, que irão compor o time de desenvolvedores JAVA, a ser contratado após o processo de seleção. Os requisitos foram enviados por e-mail pela equipe de RH, descrevendo a fonte de dados a ser utilizada, metodologia, boas práticas e prazos de entrega do produto.

Pré-requisitos

A aplicação foi desenvolvida em JAVA Enterprise Edition, utilizando a IDE ECLIPSE 2019-12 e a Framework Primefaces 7.0. 
A persistência dos dados foi realizada através do Hibernate.
A ferramenta de Banco de Dados escolhida foi o PostgreSQL Versão 12, cujo dump encontra-se disponível para Restauração.
Será necessária configuração do APACHE Tomcat 9.0 ou superior;

Guia de instalação

Após a instalação dos Pré-requisitos, será necessária a execução das seguintes atividades:

- Instalação do JBoss Tools no Eclipse Market Place
- Download do Repositório DesafioMV na pasta local C:\MV;
- Importação do Projeto para a IDE Eclipse a partir da pasta C:\MV\DesafioMV
- Atualizar Dependências do Projeto através da opção Maven->Update Project
- Criar o Banco de Dados com usuário postgres e senha FC#201921 para o DATABASE dbdesafiomv
- O arquivo de DUMP do banco de dados a ser restaurado será 
  C:\MV\DesafioMV\BancodeDados\DUMP_POSTGRESQL_CNESATIVOS_13032020.backup
- O script de restore será SCRIPT RESTORE BANCO DE DADOS dbdesafiomv.txt

Descrição da Aplicação

- A aplicação foi desenvolvida na arquitetura MVC, cujas classes estão distribuídas com a seguinte organização:

- br.com.mvsistemas.desafiomv.domain - Pacote das Classes de Definição dos Dados 
- br.com.mvsistemas.desafiomv.dao    - Pacote das Classes de Acesso aos Dados
- br.com.mvsistemas.desafiomv.bean   - Pacote das Classes de Modelo
- br.com.mvsistemas.desafiomv.Util   - Pacote das Classes de Configuração

Para exibição da consulta, foi elaborada a seguinte classe :

- /src/main/webapp/CNESAtivos.xhtml

- Funcionalidades Previstas

- Seleção por SeleItemMenu das Unidades da Federação para filtrar base de Estabelecimentos de Saúde Ativos;
- Seleção por SeleItemMenu dos Tipos de Estabelecimento de Saúde para filtrar base de Estabelecimentos Ativos;
- Geração da Base Total para consulta em vídeo, através de navegação em tela a cada 10 estabelecimentos;
- Filtragem por unidade da federação através de campo existente na coluna e ordenação opcional;
- Filtragem por tipo de estabelecimento através de campo existente na coluna e ordenação opcional;
- Geração de arquivo no padrão CSV da base total a ser gravado na pasta C:\temp - opção de execução prolongada;


