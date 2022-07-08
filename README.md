<h1 align="center">🚀 Desafio Spring - Wave 6 🚀</h1>
<p align="center">Repositório criado para hospedar o código do primeiro Touchpoint do Bootcamp IT Java.</p>

<p align="center">
  <img align="" alt="mascoteJava" src="https://github.com/gabiazevedo/java-codes/blob/main/java_gif.gif" height="200px" width="100%" />
</p>

<p align="center">
 <a href="#objetivo">Sobre o Projeto</a> •
 <a href="#Requisitos">Requisitos</a> • 
 <a href="#Tecnologias">Tecnologias</a> • 
 <a href="#Pré-requisitos">Pré-requisitos</a> • 
 <a href="#Rodando o Servidor">Rodando o Servidor</a> • 
 <a href="#Dependências">Dependências</a> • 
 <a href="#Coleção-de-Requisições">Coleção de Requisições</a> •
 <a href="#Autores">Autores</a>
</p>

## 🖊 Sobre o Projeto
<p> 
O objetivo do projeto é desenvolver uma API Rest, escrita na linguagem Java. Esta API está voltada ao contexto de vendas. O programa possui as funcionalidades de cadastro e recuperação de produto, cliente e pedido, incluindo a gestão de estoque. 
</p>

___

## 📄 Requisitos
- Obrigatórios (RO)
  - Cadastro de uma lista de produtos (RO-01);
  - Busca de lista de produtos disponíveis (RO-02);
  - Busca de lista de produtos filtrados por categoria (RO-03);
  - Busca de lista de produtos filtrados por categoria + frete grátis (RO-03);
  - Busca de lista de produtos filtrados por frete grátis + avaliação (RO-04);
  - Retorno das listas de forma ordenada (RO-05, RO-06, RO-07);
  - Possibilidade de envio de pedido de compra retornando preço total da requisição (RO-08);
  - Tratamento de exceção no envio de produto caso não exista o produto solicitado (RO-08.1);
  - Tratamento de exceção no envio de produto caso haja problema no servidor (RO-08.2);
  
- Bônus (RB)
  - Implantação de controle de estoque com tratamento de exceção quando o pedido de compra for maior que o existente (RB-09);
  - Implantação de um cadastro de clientes (RB-11);
  - Busca de lista de todos clientes (RB-12);
  - Busca de lista de clientes filtrados por categoria (RO-13);

- Melhorias implementadas (SM)
  - Aplicação de regex para validação de CPF e Nome (SM-01);
  - Validação dos campos de cadastro de clientes (SM-02);
  - Verificação de cadastro de clientes já existente por CPF com tratamento de exceção (SM-03);
  - Implantação de filtros dinâmicos por combinação de quaisquer filtros (SM-04);
  - Implantação de um insertProduto que faz a verificação de produtos, caso já exista, atualiza a quantidade (SM-05);
  - Cadastro de um único produto (SM-06);

___

## 🛠 Tecnologias

A API foi construída utilizando a linguagem Java, com o framework Spring Boot.

___

## ✅ Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
[Git](https://git-scm.com), [Java](https://www.java.com/pt-BR/) e um editor de código a sua escolha. Sugere-se o uso do Intelij Idea, disponível [aqui](https://www.jetbrains.com/pt-br/idea/).

___

## 🎲 Rodando o Servidor

- Clone este repositório na sua máquina:
    
      git clone https://github.com/diovanavalim/desafio_spring.git

- Acesse a pasta do projeto no terminal:

      cd desafio_spring

- Instale as dependências do projeto:

      mvn clean install
  
- Execute o servidor:

      mvn spring-boot:run

O servidor estará sendo escutado na porta indicada na IDE. Geralmente, trata-se da porta 8080.

___

## 🏁 Dependências  

Foram utilizadas no projeto as seguintes dependências:

- 🍃 Spring Boot Dev Tools;

- 🍃 Spring Boot Web;

- 🌶️ Lombok;

___

## 🌙 Coleção de Requisições 

A coleção de requisições utilizadas para testar os endpoints estão na pasta `src/main/resource`. O arquivo `Desafio-spring.postman_collection.json` pode ser importado em algum cliente HTTP, como o Postman ou o Insomnia.

___
## 📝 Autores ##

Desenvolvido com 💛 por Amanda, Diovana, Gabriela, Rafael, Thiago Frozzi e Thiago Almeida. 

