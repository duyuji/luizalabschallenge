# Luizalabs challenge

## Para rodar localmente é necessário ter o docker instalado com uma instalção padrão do postgres

`docker run --network=host --name postgres -e POSTGRES_PASSWORD=postgres -d postgres`

## Para rodar os testes

`./gradlew test`

## Para rodar a aplicação

`./gradlew run`

## Para buildar o pacote aplicação

`./gradlew build `

Vai gerar um jar challenge-0.1-all.jar dentro do diretório /build/libs/ dentro do projeto

Para executar o jar bastar executar o comando abaixo

` java -jar build/libs/challenge-0.1-all.jar
`

## Para criar um agendamento

`POST localhost:8080/announcements`

Body da requisição

```json
{
  "destinatary": "eduardo.custodio@gmail.com",
  "message": "Teste message",
  "type": "EMAIL",
  "dateTimeToSend": "2021-01-22T08:00:00"
}
```

## Para carregar os dados de um agendamento

Passar id retornando na criação

`GET localhost:8080/announcements/{id}`

## Para remover um agendamento

Passar id retornando na criação

`DEL localhost:8080/announcements/{id}`

## Licença

The MIT License (MIT)

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit
persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
