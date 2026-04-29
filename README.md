# Task Management App
### Project Introduction: Task Management App
### Technical Stack
- Spring Boot
- MySQL
- MyBatis
- Redis
- JWT
- Apifox
- Docker 
### Start Method
- Execute in the project root directory
```bash
mvn spring-boot:run
```
 or
```bash
mvn clean package
java -jar target/*.jar
```
- Click the the triangle on the direct graphical interface in TaskManagementApplication.java
### Directory Structure
Task Management App/
├── LICENSE
├── README.md
├── pom.xml
├── env/
├── sql/
│   └── init.sql
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── t21/
│       │           └── taskmanagement/
│       │               ├── TaskManagementApplication.java
│       │               ├── common/
│       │               │   └── ApiResponse.java
│       │               ├── controller/
│       │               │   └── UserController.java
│       │               ├── dto/
│       │               │   └── user/
│       │               │       ├── request/
│       │               │       │   └── UserRegisterRequest.java
│       │               │       └── response/
│       │               │           └── UserRegisterResponse.java
│       │               └── service/
│       │                   ├── UserService.java
│       │                   └── impl/
│       │                       └── UserServiceImpl.java
│       └── resources/
│           ├── appliacation-dev.yml
│           ├── application-local.yml
│           ├── application-prod.yml
│           └── application.yml
└── target/
### Interface Documentation Address
https://s.apifox.cn/f01fb7a0-0d2b-4202-a8da-bfb72a1d3d9c