## 🚀 Como executar o projeto
### 1️⃣ Clone o repositório
```bash
git clone https://github.com/Dani2003G/cartorio.git
```

### 2️⃣ Instale o PostgreSQL <br>
Se ainda não tiver o PostgreSQL instalado, baixe através do site oficial:<br>
#### 🔗 https://www.postgresql.org/download/

## 🛠️ Configuração do banco de dados
### 1. Crie um banco de dados (por exemplo: cartorio_db)
Você pode criar com o seguinte comando no PostgreSQL:
```bash
 CREATE DATABASE cartorio;
 ```

### 2. Crie as tabelas necessárias
   Execute os comandos abaixo no banco de dados criado:
```bash
CREATE TABLE cartorio (
id SERIAL PRIMARY KEY,
nome VARCHAR(255) NOT NULL,
email VARCHAR(255) NOT NULL
);
```
```bash
CREATE TABLE cartorio_certidoes (
cartorio_id INTEGER NOT NULL,
certidao VARCHAR(255) NOT NULL,
CONSTRAINT fk_cartorio
FOREIGN KEY (cartorio_id)
REFERENCES cartorio(id)
ON DELETE CASCADE
);
```
```bash
ALTER TABLE cartorio_certidoes
ADD CONSTRAINT pk_cartorio_certidao PRIMARY KEY (cartorio_id, certidao);
```

### ⚙️ Configuração do Spring Boot
No arquivo src/main/resources/application.properties, adicione as configurações do seu banco:
```bash
spring.datasource.url=jdbc:postgresql://localhost:5432/cartorio
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=false
```

### ▶️ Executando o projeto
No terminal, na raiz do projeto, execute:
```bash
./mvnw spring-boot:run
```
Ou, se estiver usando uma IDE como IntelliJ ou Eclipse, execute a classe CartorioApplication.

✅ Pronto!
A aplicação estará disponível em:
```bash
http://localhost:8080
```