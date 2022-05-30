# Api Agrotis

## Desafio técnico - Agrotis



### Este projeto consiste no desenvolvimento de uma Api que será consumida em um formulário de cadastro. A API deve realizar as validações necessárias para garantir a integridade dos dados e expor os serviços necessários para a listagem, busca, insersão, atualização e deleção dos dados (CRUD).

<img src="https://github.com/Vitor-Hugo-Dev/Desafio-Backend-Agrotis/blob/main/image/formulario_agrotis.jpeg?raw=true" width="auto">

## Requisitos

- Desenvolver com Java e Spring Boot.
- Utilizar alguma forma de persistencia de dados.


## Instruções para o uso da api:


### Requisitos: 
- Apache Maven 3.8.5 
- openjdk 11.0.14.1

### Instalação:
- clone este repositório  ` git clone git@github.com:Vitor-Hugo-Dev/Desafio-Backend-Agrotis.git`
- navegue do diretório cadastro e instale as dependências: ` cd cadastro && mvn install`
- execute a aplicação:  `mvn spring-boot:run`

### Rotas:
- GET - /laboratorios - retorna a lista de laboratórios.
- GET - /propriedades - retorna a lista de propriedades.
- GET - /servicos - retorna a lista de serviços.
- GET - /servicos/ID - retorna um serviço especifico por id.
- POST - /servicos - adiciona um novo serviço a lista.
- PUT - /servicos/ID - edita um serviço especifico.
- DELETE - /servico/ID - apaga um serviço especifico.

### Exemplo de Body para adicionar um novo serviço:

```
{
	"description": "novo serviço",
	"initialDate": "2022-02-02T17:41:44Z",
	"finalDate": "2022-02-02T17:41:44Z",
	"laboratorio": {
		"id": 5
	},
	"propriedade": {
		"id": 4
	},
	"usuario": "Rogerinho plantador"
}
```
