# Ficticius Clean

# Objetivo
API Rest desenvolvida para auxiliar a empresa "Ficticius Clean" no problema de previsão de gastos com combustíveis de seus veículos na utilização das entregas

# Tecnologias utilizadas
- API desenvolvida em JAVA
- Banco de Dados em SQL Server
- Testes em Postman

# Como utilizar
Para a utilização do projeto em ambiente de desenvolvimento, deve seguir os seguintes passos:
1. Acessar o Banco de Dados SQL Server e aplicar o script contido na pasta "banco de dados"
2. Importar a API no eclipse
3. Alterar o arquivo "application.properties" com as credenciais do SQL Server
4. Executar a aplicação
5. Importar a collection do Postman ("Ficticius Clean.postman_collection.json")

# Features para o futuro
- Inclusão de uma ferramenta de log
- Alterar o local do arquivo de propriedade para fora do projeto, possibilitando melhor configuração de ambiente em novos releases, com controle de acesso ao arquivo ou criptografia
- Melhoria nos tratamentos de erros
- Desenvolvimento de uma documentação para os serviços disponíveis (swagger)
