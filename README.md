# Task Management API

RESTful API for managing tasks, developed with **Java and Spring Boot**.

The API provides basic operations to create, retrieve, update, and delete tasks, as well as pagination and sorting capabilities.

## Technologies

- Java
- Spring Boot
- Spring Data JPA
- Lombok
- PostgreSQL
- Maven
- Swagger / OpenAPI

## Features

- Create, retrieve, update, and delete tasks
- Task status management
- Pagination
- Sorting
- Data validation
- RESTful API design
- API documentation with Swagger/OpenAPI

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/tasks` | Get all tasks |
| GET | `/api/tasks/{id}` | Get task by ID |
| POST | `/api/tasks` | Create a new task |
| PUT | `/api/tasks/{id}` | Update a task |
| DELETE | `/api/tasks/{id}` | Delete a task |

## Version

| Version | Description |
|---|---|
| 1.0.0 | Initial version with basic CRUD operations |


### Requirements

- Java 17+
- Maven
- PostgreSQL
