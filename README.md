# CodingAssignment_Spring
# Spring Boot Calculator API

A simple, extensible calculator API implemented in Java using Spring Boot. The calculator supports basic arithmetic operations (addition, subtraction, multiplication, and division) and allows for chaining multiple operations. The application also includes global exception handling to provide consistent error responses.

## Features

- **Basic Operations:** Supports Addition, Subtraction, Multiplication, and Division.
- **Chaining Operations:** Allows chaining of multiple operations in sequence.
- **Extensible Design:** New operations can be added without modifying existing code.
- **RESTful API:** Exposes endpoints for easy integration with front-end applications or other services.
- **Global Exception Handling:** Uses Spring Boot's `@ControllerAdvice` to handle exceptions consistently across the application.

## Assumptions

- The API only supports basic arithmetic operations. More complex operations (e.g., trigonometry, exponentiation) can be added by extending the `CalculatorOperation` interface.
- All numbers are processed as `Number` types (internally handled as `double`, 'bigdecimal', 'integer').
- Division by zero is treated as an error and is handled using a custom exception (`DivisionByZeroException`).

## Design Decisions

1. **Spring Boot Framework:**
   - The application is built using Spring Boot to leverage its auto-configuration, embedded web server, and dependency management features.
   - The `@SpringBootApplication` annotation is used to simplify the bootstrapping process.

2. **Global Exception Handling:**
   - A `GlobalExceptionHandler` class annotated with `@ControllerAdvice` is used to handle exceptions globally across the application.
   - Specific handlers are implemented for custom exceptions (`DivisionByZeroException` and `UnsupportedOperationException`) to provide meaningful error messages and HTTP status codes.

3. **Use of Spring Components:**
   - All operations are defined as Spring-managed beans (`@Component`), making them easy to manage and extend.
   - Dependency injection (`@Autowired`) is used to wire components together, promoting loose coupling and testability.

4. **RESTful API Design:**
   - The application exposes endpoints for performing calculations:
     - `/api/calculator/calculate`: Performs a single operation.
     - `/api/calculator/chainCalculate`: Performs a series of operations in sequence.
   - The API accepts JSON payloads for requests and returns results in JSON format.

## Setup and Usage

### Prerequisites

- Java 8 or higher
- Maven for building the project
