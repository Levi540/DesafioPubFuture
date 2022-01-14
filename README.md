Instalar Docker

Foi utilizado IDE IntelliJ IDEA Community Edition 2021.2.2

Dentro do IntelliJ abrir arquivo pom.xml na pasta raiz do projeto.

Abrir terminal e executar comando: docker run --name mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -d mysql:latest

Abrir aba Maven no canto superior direito e clicar install (finances/Lifecycle/install).
