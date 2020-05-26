# StarWarsRestAPI
Desafio Star Wars

Objetivo: Desenvolvimento de uma API do tipo REST para manipulação de dados dos planetas do StarWars.

* ## Ferramentas utilizadas:
   · [Spring Boot](https://spring.io/tools)  
   · [Java 8](https://www.java.com/pt_BR/download/)  
   · [MongoDB](https://www.mongodb.com/download-center)  
   · API pública do [StarWars](https://swapi.dev/about)    
   · [Eclipse](https://www.eclipse.org/downloads/)  
   · [Git](https://git-scm.com/downloads)  
   · [Docker](https://docs.docker.com/)  
   · [Postman](https://www.postman.com/downloads/)
  

* ## Cada planeta obtém do banco de dados MongoDB os dados que serão inseridos manualmente:

   · Nome  
   · Clima  
   · Terreno  
   · Amostra da quantidade de aparições em filmes (obtidas da API pública do [StarWars](https://swapi.dev/about))



* ## Funcionalidades da API:
(Os teste de requisições na API foram realizados com o auxílio do [Postman](https://www.postman.com/downloads/))
* #### Adicionar um planeta (nome, clima e terreno):

Ex-> `POST: http://localhost:8081/api/planetas`

    {
	    "nome": "Naboo",
	    "clima": "temperate",
	    "terreno": "grassy hills, swamps, forests, mountains"
    }
    Resposta:
    {
            "id": "5eccb3966344590001905ddb",
            "nome": "Naboo",
            "clima": "temperate",
            "terreno": "grassy hills, swamps, forests, mountains",
            "quantidadeDeAparicoes": 4
     }

* #### Listar todos os planetas:
Ex-> `GET: http://localhost:8081/api/planetas`

* #### Buscar um planeta por nome;
Ex-> `GET: http://localhost:8081/api/planetas/?nome=Naboo`

* #### Buscar um planeta pelo ID;
Ex-> `GET: http://localhost:8081/api/planetas/5eccb3966344590001905ddb`

* #### Remover um planeta (remove pelo ID);
Ex-> `DELETE: http://localhost:8081/api/planetas/5eccb3966344590001905ddb`


* ## Instruções para execução:
  · Com o [Git](https://git-scm.com/downloads) instalado, clonar o projeto:
  
	      git clone https://github.com/cryslene/StarWarsRestAPI.git
        
  · Com o [Docker](https://docs.docker.com/) instalado e na pasta do projeto usar o comando:
  
	      docker-compose up
        
  · Se quiser iniciar o projeto em background (segundo plano) é só utilizar o comando:
  
      	docker-compose up -d
        
  · Se desejar ver os serviços que estão rodando:
  
	      docker-compose ps
        
  · Realizar o teste:
  
	      http://localhost:8081/api/planetas
        


# MAY THE FORCE BE WITH YOU!


Referências:  
    · [Criar APIREST](https://www.youtube.com/watch?v=dkMSHEpJGYQ)  
    · [Docker Compose](https://cursos.alura.com.br/forum/topico-docker-compose-com-spring-boot-e-monngodb-61196)  
    · [Docker na Prática](https://www.youtube.com/watch?v=4mC7JcSKeU4&t=529s).
