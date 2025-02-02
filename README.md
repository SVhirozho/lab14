# Lab 14 - Security in Java Web Applications

**Student:** Simbarashe Vhirozho  
**Student Number:** 47147

This project implements a secure web application using Spring Boot. The application includes JWT (JSON Web Token) based authentication and authorization mechanisms.

## Features

- JWT based authentication
- User registration and login operations
- Role based authorization (USER, ADMIN)
- Secure password storage (BCrypt)
- SQLite database integration
- RESTful API endpoints

## Technologies

- Java 17
- Spring Boot 3.2.2
- Spring Security
- JWT (JSON Web Token)
- SQLite
- Maven
- Lombok
- Hibernate

## Installation

1. Clone the project:
```bash
git clone [repository-url]
```

2. Navigate to project directory:
```bash
cd [project-directory]
```

3. Build with Maven:
```bash
mvn clean install
```

4. Run the application:
```bash
mvn spring-boot:run
```

The application will run on port 8090 by default.

## API Endpoints

### Authentication

#### User Registration
```http
POST /api/auth/register
Content-Type: application/json

{
    "username": "testuser",
    "email": "test@example.com",
    "password": "Test@password123456"
}
```

#### Login
```http
POST /api/auth/login
Content-Type: application/json

{
    "username": "testuser",
    "password": "Test@password123456"
}
```

### Security Features

1. **Password Policy**
   - Minimum 14 characters
   - At least 1 uppercase letter
   - At least 1 lowercase letter
   - At least 1 number
   - At least 1 special character

2. **JWT Features**
   - 24 hours validity period
   - Role-based authorization
   - Secure token signing

## Database

SQLite database is used. The database file will be created as `bookstore.db` in the project folder.

## Notes

- Database will be created automatically on first run
- Default port is 8090
- JWT token required for all API requests (except register and login)
- Send token in HTTP requests with `Authorization` header using `Bearer` prefix

## Security Measures

1. XSS Protection
2. CSRF Protection
3. SQL Injection Protection
4. Secure Password Storage
5. Rate Limiting
6. Input Validation
