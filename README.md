# Cadastro de Pessoas utilizando CRUD em Java

## Objetivo

Este projeto foi desenvolvido como parte da disciplina de Técnicas de Programação em Java, com o objetivo de aplicar os conhecimentos adquiridos sobre operações de entrada e saída de dados. O trabalho consiste em desenvolver uma aplicação de console que implemente um sistema CRUD (Create, Read, Update, Delete) para o cadastro de pessoas.

## Descrição do Projeto

A aplicação permite realizar o cadastro, consulta, atualização e exclusão de registros de pessoas. As informações são armazenadas em um arquivo de texto, garantindo a persistência dos dados entre as execuções do programa.

## Funcionalidades

1. **Adicionar Pessoa (Create)**
   - Solicitar ao usuário as informações de uma pessoa: nome, idade, e-mail e telefone.
   - Armazenar essas informações em um arquivo de texto.

2. **Consultar Pessoa (Read)**
   - Permitir a consulta de uma pessoa pelo nome.
   - Exibir todas as informações cadastradas dessa pessoa.

3. **Atualizar Pessoa (Update)**
   - Permitir a atualização das informações de uma pessoa.
   - Solicitar ao usuário o nome da pessoa a ser atualizada e as novas informações.

4. **Excluir Pessoa (Delete)**
   - Permitir a exclusão de uma pessoa pelo nome.
   - Remover as informações dessa pessoa do arquivo de texto.

## Requisitos Técnicos

- A aplicação deve ser desenvolvida em Java.
- Utilizar coleções adequadas para armazenar temporariamente as informações durante a execução do programa.
- Implementar manipulação de arquivos para leitura e escrita dos dados de forma persistente.
- O código deve ser bem documentado, com comentários explicativos.
- Seguir as boas práticas de programação orientada a objetos.

## Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/daniel-SM/Cadastro-de-Pessoas.git
   ```
1. Navegue até o diretório do projeto:
   ```bash
   cd Cadastro-de-Pessoas
   ```
1. Compile seu código:
   ```bash
   javac src/*.java
   ```
1. Execute a aplicação:
   ```bash
   java src.Main
   ```
