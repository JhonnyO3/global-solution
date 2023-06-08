# global-solution
#AgroSonic

ATENÇÃO: EXISTE UMA COLLECTION ANEXADO NO PROJETO!!!

O AgroSonic é um serviço que identifica os sinais de saúde das plantas com base no som que elas emitem. Esta é uma API desenvolvida em Spring Boot, que integra o aplicativo e o banco de dados Oracle. O projeto também utiliza o Swagger para documentação da API e o Spring Security para autenticação e autorização. Pré-requisitos

Java Development Kit (JDK) 11 ou superior
Maven
Banco de Dados Oracle
Postman

Certifique-se de ter todas as dependências instaladas corretamente antes de prosseguir. Configuração do Banco de Dados

Crie um banco de dados Oracle vazio para o AgroSonic.

Configure as informações de conexão com o banco de dados no arquivo application.properties localizado em src/main/resources. Substitua os valores entre <...> pelas suas informações de conexão:

properties

spring.datasource.url=jdbc:oracle:thin:@<host>:<port>/<database>
spring.datasource.username=<username>
spring.datasource.password=<password>

Executando a API

Clone este repositório para o seu ambiente local.

Navegue até o diretório raiz do projeto.

Execute o seguinte comando para construir o projeto e baixar as dependências:

shell

mvn clean install

Após a conclusão da construção, execute o seguinte comando para iniciar a API:

shell

mvn spring-boot:run

A API será iniciada na porta 8080 por padrão. Certifique-se de que a porta esteja disponível antes de executar o comando acima.

Documentação da API

A documentação da API é fornecida pelo Swagger. Depois de executar a API localmente, você pode acessar a documentação por meio do seguinte URL:

bash

http://localhost:8080/swagger-ui.html

Aqui você encontrará detalhes sobre todos os endpoints disponíveis, bem como exemplos de solicitações e respostas. Autenticação e Autorização

A segurança da API é implementada com o Spring Security. Para acessar os endpoints protegidos, você precisará de credenciais válidas. O AgroSonic usa autenticação baseada em tokens JWT (JSON Web Token). Os tokens JWT devem ser incluídos no cabeçalho Authorization das solicitações HTTP da seguinte maneira:

Você pode usar a coleção do Postman fornecida para testar os endpoints da API. A coleção do Postman contém exemplos de solicitações para cada endpoint, incluindo solicitações autenticadas.

Certifique-se de ter o Postman instalado em seu computador.
Importe o arquivo AgroSonic.postman_collection.json fornecido neste repositório para o Postman.
A coleção agora estará disponível no Postman, e você poderá executar as solicitações individualmente.

Contribuindo

Se você deseja contribuir para o projeto AgroSonic, siga as etapas abaixo:

Faça um fork deste repositório.
Crie uma branch para a sua nova funcionalidade (git checkout -b minha-nova-funcionalidade).
Faça as alterações necessárias no código.
Commit suas alterações (git commit -am 'Adicionando uma nova funcionalidade').
Faça push para a branch (git push origin minha-nova-funcionalidade).
Crie um novo Pull Request.

Por favor, certifique-se de testar completamente suas alterações antes de fazer o Pull Request. Licença
