# Task 6 - Online Quiz Application 📝

## 📖 Description

A **Java & Spring Boot-based Online Quiz Application** developed as a robust Multiple-Choice Question (MCQ) evaluation system with automated scoring, result persistence, and comprehensive test management.

The system allows users to log in with their email, browse available technical quizzes across various domains (Java Fundamentals, Advanced Java, OOP, Spring Boot, SQL), participate in quizzes by answering multiple-choice questions, and submit their responses. The service layer evaluates the answers in real-time, calculates the total score and percentage, and securely persists the attempt tied to both the user and the quiz in a PostgreSQL database.

Built following a clean, layered architectural pattern (`Controller` ➔ `Service` ➔ `Repository` ➔ `Entity`), the project incorporates custom DTOs, dedicated Spring `@Component` mappers, and a centralized `GlobalExceptionHandler` without unnecessary external dependencies.

---

## ✨ Features

* 🔐 **Simple Email-Based Authentication**: Seamless user onboarding and login via email and full name.
* 📋 **Multiple-Choice Question (MCQ) System**: Structured questions with 4 distinct options per question.
* 🛡️ **Secure Quiz Presentation**: Correct answers (`isCorrect`) are completely stripped from client-facing DTOs to eliminate client-side cheating.
* ⚡ **Real-Time Score Calculation**: In-memory evaluation comparing submitted option IDs against database-backed questions to calculate accuracy and percentage scores.
* 📊 **Quiz Result Persistence**: User attempts, correct counts, total questions, score percentages, and timestamps are persisted in `quiz_results`.
* 📜 **User History Tracking**: Users can view their full historical quiz performance and past scores at any time.
* 🚀 **Pre-loaded Comprehensive Quizzes (100 Questions)**: Automatic initialization via `DataLoader` containing 5 technical quizzes (20 questions each) covering:
  * *Java Fundamentals (Beginner)*
  * *Java Core & Advanced*
  * *OOP Concepts & Design Principles*
  * *Spring Boot Essentials & Architecture*
  * *SQL & Relational Database Fundamentals*
* ⚠️ **Centralized Global Exception Handling**: Handled via `@RestControllerAdvice` returning clean, uniform JSON error structures with HTTP status codes (404, 400, 500) and field-level validation errors without boilerplate response wrapper classes.
* 🐳 **Containerized Database Setup**: Production-ready PostgreSQL container configuration using `docker-compose.yml`.

---

## 🛠️ Technologies Used

* **Java 21** (Modern LTS release)
* **Spring Boot 4.x / 3.x**
* **Spring Data JPA** & **Hibernate ORM**
* **PostgreSQL 16** (Relational Database)
* **Docker & Docker Compose**
* **Lombok** (`@Data`, `@Builder`, `@RequiredArgsConstructor`, `@FieldDefaults`)
* **Jakarta Bean Validation** (`@Valid`, `@NotBlank`, `@Email`, `@NotNull`)
* **Layered Architecture** (Controller, Service, Repository, Entity, DTO, Mapper, Exception)
* **Postman** (API Testing & Verification)

---

## 🔄 Task Workflow

The application implements the required 5-step task workflow:

```text
[Step 1: Create Question & Answer Structure]
                 ⬇️
[Step 2: Display Multiple-Choice Questions]
                 ⬇️
[Step 3: Capture User Answers (QuizSubmitRequest)]
                 ⬇️
[Step 4: Calculate Score & Evaluate Results (Service Layer)]
                 ⬇️
[Step 5: Show Final Result & Persist to Database (QuizResultResponseDto)]
```

---

## 🚀 How It Works & API Endpoints

### API Summary Table

| HTTP Method | Endpoint | Description | Request Body / Parameters | Response Status |
|---|---|---|---|---|
| **POST** | `/api/auth/login` | Authenticate or auto-register user by email | `LoginRequest` (email, fullName) | `200 OK` |
| **GET** | `/api/quizzes` | List all available quizzes with total question count | *None* | `200 OK` |
| **GET** | `/api/quizzes/{id}` | Get full quiz details, questions, and options (safe MCQ view) | Path variable: `id` | `200 OK` |
| **POST** | `/api/quizzes/{id}/submit` | Submit user answers, evaluate score, and save result | Path variable: `id`, Body: `QuizSubmitRequest` | `200 OK` |
| **GET** | `/api/quizzes/{id}/results` | Get all submitted results for a specific quiz | Path variable: `id` | `200 OK` |
| **GET** | `/api/users/{id}` | Get user profile by ID | Path variable: `id` | `200 OK` |
| **GET** | `/api/users/{id}/results` | Get full quiz result history for a user | Path variable: `id` | `200 OK` |

---

### 1️⃣ User Login / Registration

**Request:**  
`POST http://localhost:8080/api/auth/login`
```json
{
  "email": "nurlan@gmail.com",
  "fullName": "Nurlan Suleymanli"
}
```

**Response (`200 OK`):**
```json
{
  "id": 1,
  "email": "nurlan@gmail.com",
  "fullName": "Nurlan Suleymanli",
  "createdAt": "2026-11-01T18:38:00"
}
```

---

### 2️⃣ List All Quizzes

**Request:**  
`GET http://localhost:8080/api/quizzes`

**Response (`200 OK`):**
```json
[
  {
    "id": 1,
    "name": "Java Fundamentals (Beginner)",
    "quizDescription": "Master the basics of Java syntax, data types, control flow, loops, and methods.",
    "totalQuestions": 20
  },
  {
    "id": 2,
    "name": "Java Core & Advanced",
    "quizDescription": "Deep dive into Collections, Generics, Stream API, Concurrency, and Memory Management.",
    "totalQuestions": 20
  },
  {
    "id": 3,
    "name": "OOP Concepts & Design Principles",
    "quizDescription": "Examine Encapsulation, Inheritance, Polymorphism, Abstraction, SOLID principles, and Design Patterns.",
    "totalQuestions": 20
  },
  {
    "id": 4,
    "name": "Spring Boot Essentials & Architecture",
    "quizDescription": "Test your knowledge on Inversion of Control, Bean Scopes, JPA, Transactions, and REST controllers.",
    "totalQuestions": 20
  },
  {
    "id": 5,
    "name": "SQL & Relational Database Fundamentals",
    "quizDescription": "Covering DDL, DML, JOINs, Indexing, Transactions (ACID), Normalization, and Grouping.",
    "totalQuestions": 20
  }
]
```

---

### 3️⃣ View Quiz Questions & Options (MCQ View)

**Request:**  
`GET http://localhost:8080/api/quizzes/3`

**Response (`200 OK`):**
```json
{
  "id": 3,
  "name": "OOP Concepts & Design Principles",
  "quizDescription": "Examine Encapsulation, Inheritance, Polymorphism, Abstraction, SOLID principles, and Design Patterns.",
  "totalQuestions": 20,
  "questions": [
    {
      "id": 41,
      "questionText": "Which OOP pillar bundles state and behavior together and hides internal object details?",
      "options": [
        { "id": 161, "optionText": "Polymorphism" },
        { "id": 162, "optionText": "Inheritance" },
        { "id": 163, "optionText": "Encapsulation" },
        { "id": 164, "optionText": "Abstraction" }
      ]
    }
  ]
}
```

---

### 4️⃣ Submit Quiz & Score Calculation

**Request:**  
`POST http://localhost:8080/api/quizzes/3/submit`
```json
{
  "userId": 1,
  "answers": [
    { "questionId": 41, "selectedOptionId": 163 },
    { "questionId": 42, "selectedOptionId": 166 },
    { "questionId": 43, "selectedOptionId": 170 }
  ]
}
```

**Response (`200 OK`):**
```json
{
  "id": 1,
  "userId": 1,
  "userEmail": "nurlan@gmail.com",
  "quizId": 3,
  "quizName": "OOP Concepts & Design Principles",
  "totalQuestions": 20,
  "correctAnswers": 3,
  "score": 15.0,
  "submittedAt": "2026-11-01T19:16:00"
}
```

---

### 5️⃣ View User Quiz History

**Request:**  
`GET http://localhost:8080/api/users/1/results`

**Response (`200 OK`):**
```json
[
  {
    "id": 1,
    "userId": 1,
    "userEmail": "nurlan@gmail.com",
    "quizId": 3,
    "quizName": "OOP Concepts & Design Principles",
    "totalQuestions": 20,
    "correctAnswers": 20,
    "score": 100.0,
    "submittedAt": "2026-11-01T19:16:00"
  }
]
```

---

## 🗄️ Database & Entity Architecture

The relational schema is configured with automated schema generation (`hibernate.ddl-auto: update`):

### 1. `UserEntity` (`users` table)
| Field | Type | Constraint | Description |
|---|---|---|---|
| `id` | `Long` | PRIMARY KEY, AUTO_INCREMENT | Unique user identifier |
| `email` | `String` | UNIQUE, NOT NULL | User's email address |
| `fullName` | `String` | NOT NULL | User's display name |
| `createdAt` | `LocalDateTime` | NOT NULL, UP-TO-DATE | Account creation timestamp |

### 2. `QuizEntity` (`quiz` table)
| Field | Type | Constraint | Description |
|---|---|---|---|
| `id` | `Long` | PRIMARY KEY, AUTO_INCREMENT | Unique quiz identifier |
| `name` | `String` | UNIQUE, NOT NULL | Name/Title of the quiz |
| `quizDescription` | `String` | NULLABLE | Detailed description |
| `questions` | `List<QuestionEntity>` | ONE-TO-MANY | Associated questions list |
| `createdAt` | `LocalDateTime` | NOT NULL | Creation timestamp |

### 3. `QuestionEntity` (`questions` table)
| Field | Type | Constraint | Description |
|---|---|---|---|
| `id` | `Long` | PRIMARY KEY, AUTO_INCREMENT | Unique question identifier |
| `questionText` | `String` | NOT NULL | The text of the question |
| `quiz` | `QuizEntity` | MANY-TO-ONE, FOREIGN KEY | Parent quiz reference |
| `options` | `List<OptionEntity>` | ONE-TO-MANY | 4 multiple choice options |
| `createdAt` | `LocalDateTime` | NOT NULL | Creation timestamp |

### 4. `OptionEntity` (`options` table)
| Field | Type | Constraint | Description |
|---|---|---|---|
| `id` | `Long` | PRIMARY KEY, AUTO_INCREMENT | Unique option identifier |
| `optionText` | `String` | NOT NULL | Option choice text |
| `correct` | `boolean` | NOT NULL | Indicates if choice is correct |
| `question` | `QuestionEntity` | MANY-TO-ONE, FOREIGN KEY | Parent question reference |
| `createdAt` | `LocalDateTime` | NOT NULL | Creation timestamp |

### 5. `QuizResultEntity` (`quiz_results` table)
| Field | Type | Constraint | Description |
|---|---|---|---|
| `id` | `Long` | PRIMARY KEY, AUTO_INCREMENT | Unique result identifier |
| `user` | `UserEntity` | MANY-TO-ONE, FOREIGN KEY | User who took the quiz |
| `quiz` | `QuizEntity` | MANY-TO-ONE, FOREIGN KEY | Quiz that was taken |
| `totalQuestions` | `int` | NOT NULL | Total question count |
| `correctAnswers` | `int` | NOT NULL | Number of correct answers |
| `score` | `double` | NOT NULL | Percentage score achieved |
| `submittedAt` | `LocalDateTime` | NOT NULL | Submission timestamp |

---

## 📁 Project Structure

```text
Task_6/
├── Online-Quiz_Application/
│   ├── .idea/
│   ├── gradle/
│   │   └── wrapper/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/nurlansuleymanli/onlinequiz_application/
│   │   │   │       ├── config/
│   │   │   │       │   └── DataLoader.java
│   │   │   │       ├── controller/
│   │   │   │       │   ├── AuthController.java
│   │   │   │       │   ├── QuizController.java
│   │   │   │       │   └── UserController.java
│   │   │   │       ├── dto/
│   │   │   │       │   ├── AnswerDto.java
│   │   │   │       │   ├── LoginRequest.java
│   │   │   │       │   ├── OptionResponseDto.java
│   │   │   │       │   ├── QuestionResponseDto.java
│   │   │   │       │   ├── QuizDetailResponseDto.java
│   │   │   │       │   ├── QuizResponseDto.java
│   │   │   │       │   ├── QuizResultResponseDto.java
│   │   │   │       │   ├── QuizSubmitRequest.java
│   │   │   │       │   └── UserResponseDto.java
│   │   │   │       ├── entity/
│   │   │   │       │   ├── OptionEntity.java
│   │   │   │       │   ├── QuestionEntity.java
│   │   │   │       │   ├── QuizEntity.java
│   │   │   │       │   ├── QuizResultEntity.java
│   │   │   │       │   └── UserEntity.java
│   │   │   │       ├── exception/
│   │   │   │       │   ├── BadRequestException.java
│   │   │   │       │   ├── GlobalExceptionHandler.java
│   │   │   │       │   └── ResourceNotFoundException.java
│   │   │   │       ├── mapper/
│   │   │   │       │   ├── QuizMapper.java
│   │   │   │       │   ├── QuizResultMapper.java
│   │   │   │       │   └── UserMapper.java
│   │   │   │       ├── repository/
│   │   │   │       │   ├── OptionRepository.java
│   │   │   │       │   ├── QuestionRepository.java
│   │   │   │       │   ├── QuizRepository.java
│   │   │   │       │   ├── QuizResultRepository.java
│   │   │   │       │   └── UserRepository.java
│   │   │   │       ├── service/
│   │   │   │       │   ├── QuizResultService.java
│   │   │   │       │   ├── QuizService.java
│   │   │   │       │   └── UserService.java
│   │   │   │       └── OnlineQuizApplication.java
│   │   │   └── resources/
│   │   │       └── application.yaml
│   │   └── test/
│   │       └── java/
│   │           └── com/nurlansuleymanli/onlinequiz_application/
│   │               └── OnlineQuizApplicationTests.java
│   ├── build.gradle
│   ├── docker-compose.yml
│   └── settings.gradle
├── screenshots/
└── README.md
```

---

## 💡 Key Concepts

This project demonstrates practical usage of:

* **Separation of Concerns (SoC)**: Strict division of duties across Controller, Service, Repository, DTO, Mapper, and Entity layers.
* **In-Memory MCQ Evaluation**: Fast, non-blocking evaluation of submitted answers in service memory without repeated N+1 database roundtrips.
* **Information Hiding & Security**: Keeping `isCorrect` internal to the database and never serializing it to the quiz-taking client.
* **DTO & Mapper Pattern**: Preventing entity leakage and cyclic JSON serialization by maintaining dedicated transfer contracts and Spring `@Component` mappers.
* **Global Error Handling**: Using `@RestControllerAdvice` and `@ExceptionHandler` to return consistent, user-friendly error payloads.
* **Automated Data Seeding**: Initializing production-like datasets on application boot with Spring's `CommandLineRunner`.
* **Idempotent Submission & Historical Records**: Updating existing scores or creating new result entries cleanly per user and quiz.

---

## 🎯 Skills Demonstrated

* Designing and developing a production-ready Spring Boot REST API from scratch.
* Creating normalized relational database schemas with JPA/Hibernate entity relationships (`@OneToMany`, `@ManyToOne`).
* Managing Docker containerization for persistent PostgreSQL storage.
* Crafting clean, robust business logic for MCQ answer validation and score calculation.
* Implementing comprehensive exception handling with accurate HTTP status codes.
* Writing clean, professional, and well-structured code adhering to SOLID principles.

---

## 📸 Screenshots

<p>
  <img src="screenshots/Screenshot 2026-11-01 193001.png" width="49%" />
  <img src="screenshots/Screenshot 2026-11-01 193002.png" width="49%" />
</p>
<p>
  <img src="screenshots/Screenshot 2026-11-01 193003.png" width="49%" />
  <img src="screenshots/Screenshot 2026-11-01 193004.png" width="49%" />
</p>
<p>
  <img src="screenshots/Screenshot 2026-11-01 193005.png" width="49%" />
</p>

---

## 👨‍💻 Author

**Nurlan Suleymanli**

Java Backend Developer
