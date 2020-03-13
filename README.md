Projeto Desafio MV Sistemas Versão 1.0

Este projeto é parte integrante do conjunto de avaliações realizadas com os profissionais de TI, que irão compor o time de desenvolvedores JAVA, a ser contratado após o processo de seleção. Os requisitos foram enviados por e-mail pela equipe de RH, descrevendo a fonte de dados a ser utilizada, metodologia, boas práticas e prazos de entrega do produto.

Pré-requisitos

A aplicação foi desenvolvida em JAVA Enterprise Edition, utilizando a IDE ECLIPSE 2019-12 e a Framework Primefaces 7.0. 
A persistência dos dados foi realizada através do Hibernate.
A ferramenta de Banco de Dados utilizada foi o PostgreSQL Versão 12, cujo dump encontra-se disponível para Restauração.
Será necessária configuração do APACHE Tomcat 9.0 ou superior;

Guia de instalação

Após a instalação dos Pré-requisitos, serão necessários a execução das seguintes atividades:

- Instalação do JBoss Tools do Eclipse Market Place
- Download do Repositório DesafioMV na pasta local C:\MV;
- Importação do Projeto para a IDE Eclipse a partir da pasta C:\MV\DesafioMV
- Atualizar Dependências do Projeto através da opção Mave->Update Project
- Criar o Banco de Dados com usuário postgres e senha FC#201921 com o nome dbdesafiomv
- O arquivo de DUMP do banco de dados será C:\MV\DesafioMV\BancodeDados\DUMP_POSTGRESQL_CNESATIVOS_13032020
- O script de restore será SCRIPT RESTORE BANCO DE DADOS dbdesafiomv

