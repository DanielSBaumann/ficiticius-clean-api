# ficiticius-clean-api
<h1 align="center">Api de cadastro de carros da empresa Ficticius Clean</h1>

## 💬 Sobre o projeto

<br>

<p>
API feita para cadastro de carro , e rankear carros pelos parâmetros : preço da gasolina , distância percorrida cidade e distância percorrida rodovia
</p>

## 🚀 Como testar o projeto

<br>

<p>
Acesso a documentção da api na seguinte URL : https://ficticius-clean-teste.herokuapp.com/swagger-ui/
</p>

<p>
Para cadastrar um carro , faça uma requisição POST para a seguinte URL : https://ficticius-clean-teste.herokuapp.com/api/carros/salvar como o exemplo a seguir :
  
  ```
  {
    "nome":"nome",
    "marca":"marca",
    "modelo":"modelo",
    "dataFabricacao":"dd/mm/aaaa",
    "consumoMedioCidade":11.11,
    "consumoMedioRodovia":11.11
}
```
  
</p>

<p>
Para acessar o consumo por carros , enviar uma requisição GET para a seguinte URL 
    https://ficticius-clean-teste.herokuapp.com/api/api/carros/consumosPorCarro/precoGasolina/{precoGasolina}/kmCidade/{kmCidade}/kmRodovia/{kmRodovia}
  com os respectivos valores.
  
  O retorno será como o exemplo a seguir:
  
  ```
  {
    "precoGasolina": 7.57,
    "kmCidade": 112.0,
    "kmRodovia": 214.0,
    "consumosPorCarro": [
        {
            "carro": {
                "id": 1,
                "nome": "Palio 1.0",
                "marca": "Fiat",
                "modelo": "Palio",
                "dataFabricacao": "2021-02-01",
                "consumoMedioCidade": 12.1,
                "consumoMedioRodovia": 11.5
            },
            "valorConsumoCidade": 70.07,
            "valorConsumoRodovia": 140.87
        }
    ]
}
```
  
</p>

## 🤖 Autor

<a href="https://github.com/DanielSBaumann">
 <img style="border-radius: 50%;" src="https://github.com/DanielSBaumann/java-markteplace/blob/main/WebContent/readme/think.jpg" width="100px;" alt=""/>
 <br />
 <sub><b>💥Daniel Baumann💥</b></sub></a> <a href="https://github.com/DanielSBaumann" title="Daniel Baumann"></a>
 <br />

 [![Linkedin Badge](https://img.shields.io/badge/-Daniel-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/daniel-baumann-6054a437/)](https://www.linkedin.com/in/daniel-baumann-6054a437/) 
[![Gmail Badge](https://img.shields.io/badge/-dr4wone@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:dr4wone@gmail.com)](mailto:dr4wone@gmail.com)

---

## 📝 Licença

Este projeto esta sobe a licença [MIT](./LICENSE).

---
