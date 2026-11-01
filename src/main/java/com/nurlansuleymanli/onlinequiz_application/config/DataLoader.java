package com.nurlansuleymanli.onlinequiz_application.config;

import com.nurlansuleymanli.onlinequiz_application.entity.OptionEntity;
import com.nurlansuleymanli.onlinequiz_application.entity.QuestionEntity;
import com.nurlansuleymanli.onlinequiz_application.entity.QuizEntity;
import com.nurlansuleymanli.onlinequiz_application.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final QuizRepository quizRepository;

    @Override
    public void run(String... args) {
        if (quizRepository.count() > 0) {
            return;
        }

        loadJavaBeginnerQuiz();
        loadJavaAdvancedQuiz();
        loadOopQuiz();
        loadSpringBootQuiz();
        loadSqlQuiz();
    }

    private void loadJavaBeginnerQuiz() {
        QuizEntity quiz = QuizEntity.builder()
                .name("Java Fundamentals (Beginner)")
                .quizDescription("Master the basics of Java syntax, data types, control flow, loops, and methods.")
                .build();

        List<QuestionEntity> questions = new ArrayList<>();
        questions.add(createQuestion(quiz, "What is the default value of a boolean instance variable in Java?", 1, "false", "true", "null", "0"));
        questions.add(createQuestion(quiz, "Which primitive data type is used to store a single 16-bit Unicode character in Java?", 2, "byte", "char", "short", "String"));
        questions.add(createQuestion(quiz, "What is the size of an int data type in Java?", 3, "16 bits", "64 bits", "32 bits", "8 bits"));
        questions.add(createQuestion(quiz, "Which operator is used to compare two values for primitive equality in Java?", 3, "=", "equals()", "==", "==="));
        questions.add(createQuestion(quiz, "What will be the output of 5 / 2 in Java when both operands are integers?", 2, "2.5", "2", "3", "ArithmeticException"));
        questions.add(createQuestion(quiz, "Which keyword is used to prevent a method from being overridden in Java?", 3, "static", "abstract", "final", "const"));
        questions.add(createQuestion(quiz, "Which loop structure is guaranteed to execute its code block at least once?", 2, "for loop", "do-while loop", "while loop", "enhanced for loop"));
        questions.add(createQuestion(quiz, "What is the index of the first element in a standard Java array?", 2, "1", "0", "-1", "undefined"));
        questions.add(createQuestion(quiz, "Which of the following is NOT a reserved keyword in Java?", 3, "goto", "volatile", "program", "transient"));
        questions.add(createQuestion(quiz, "What does JVM stand for?", 1, "Java Virtual Machine", "Java Variable Method", "Java Visual Model", "Java Verified Module"));
        questions.add(createQuestion(quiz, "Which method signature serves as the entry point for a standalone Java application?", 2, "public void start()", "public static void main(String[] args)", "public void main()", "static void run(String[] args)"));
        questions.add(createQuestion(quiz, "How do you obtain the number of elements in an array named 'arr' in Java?", 3, "arr.length()", "arr.size()", "arr.length", "arr.count"));
        questions.add(createQuestion(quiz, "Which statement is used to immediately exit from a loop or switch structure?", 3, "continue", "exit", "break", "return"));
        questions.add(createQuestion(quiz, "What occurs when an integer variable exceeds its maximum value (Integer.MAX_VALUE + 1)?", 2, "ArithmeticException", "Wraps around to the minimum negative value", "Remains at maximum value", "Becomes zero"));
        questions.add(createQuestion(quiz, "Which core package is automatically imported into every Java source file?", 3, "java.util", "java.io", "java.lang", "java.net"));
        questions.add(createQuestion(quiz, "What is the correct syntax for creating a single-line comment in Java?", 2, "# comment", "// comment", "/* comment */", "<!-- comment -->"));
        questions.add(createQuestion(quiz, "What is the return type of the hashCode() method defined in java.lang.Object?", 3, "long", "String", "int", "boolean"));
        questions.add(createQuestion(quiz, "Which keyword is used to instantiate an object in Java?", 2, "create", "new", "instantiate", "alloc"));
        questions.add(createQuestion(quiz, "What is the result of the modulus operation 10 % 3 in Java?", 2, "3", "1", "0", "0.33"));
        questions.add(createQuestion(quiz, "Which wrapper class corresponds to the primitive type 'int'?", 3, "Int", "Number", "Integer", "Numeric"));

        quiz.setQuestions(questions);
        quizRepository.save(quiz);
    }

    private void loadJavaAdvancedQuiz() {
        QuizEntity quiz = QuizEntity.builder()
                .name("Java Core & Advanced")
                .quizDescription("Deep dive into Collections, Generics, Stream API, Concurrency, and Memory Management.")
                .build();

        List<QuestionEntity> questions = new ArrayList<>();
        questions.add(createQuestion(quiz, "Where are object instances stored in Java memory during execution?", 2, "Stack memory", "Heap memory", "Metaspace", "Program Counter register"));
        questions.add(createQuestion(quiz, "What is the average time complexity of get() in a HashMap with evenly distributed hash codes?", 3, "O(n)", "O(log n)", "O(1)", "O(n log n)"));
        questions.add(createQuestion(quiz, "Which method in Object class must be overridden whenever equals() is overridden?", 3, "toString()", "clone()", "hashCode()", "finalize()"));
        questions.add(createQuestion(quiz, "What happens to a HashMap bucket in Java 8+ when the number of colliding entries exceeds 8?", 1, "The linked list converts to a Red-Black Tree", "The hash table doubles in capacity", "A CollisionException is thrown", "The oldest entry is evicted"));
        questions.add(createQuestion(quiz, "Which interface does NOT extend the java.util.Collection interface?", 3, "List", "Set", "Map", "Queue"));
        questions.add(createQuestion(quiz, "Which keyword ensures a variable's value is always read directly from and written to main memory?", 1, "volatile", "synchronized", "transient", "atomic"));
        questions.add(createQuestion(quiz, "What is the fundamental difference between Callable and Runnable in Java concurrency?", 1, "Callable can return a result and throw checked exceptions", "Runnable can return a result but cannot throw exceptions", "Callable cannot be submitted to an ExecutorService", "There is no functional difference"));
        questions.add(createQuestion(quiz, "Which Stream API operation is intermediate and evaluated lazily?", 3, "forEach()", "collect()", "filter()", "count()"));
        questions.add(createQuestion(quiz, "What exception is thrown when modifying a collection directly while iterating over it with a for-each loop?", 2, "IndexOutOfBoundsException", "ConcurrentModificationException", "UnsupportedOperationException", "IllegalStateException"));
        questions.add(createQuestion(quiz, "Which Garbage Collector is the default in modern LTS releases (Java 17 & Java 21)?", 3, "Parallel GC", "Serial GC", "G1 (Garbage-First) GC", "ZGC"));
        questions.add(createQuestion(quiz, "Which exception is a checked exception in Java?", 2, "NullPointerException", "IOException", "IllegalArgumentException", "ArrayIndexOutOfBoundsException"));
        questions.add(createQuestion(quiz, "What is the primary purpose of the 'transient' keyword in Java?", 1, "Prevents a field from being serialized", "Makes a field thread-safe", "Prevents a field from being modified", "Marks a field for immediate garbage collection"));
        questions.add(createQuestion(quiz, "Which functional interface from java.util.function accepts one argument and returns a boolean?", 3, "Function<T, R>", "Consumer<T>", "Predicate<T>", "Supplier<T>"));
        questions.add(createQuestion(quiz, "What interface must resources implement to be used within a try-with-resources statement?", 2, "Serializable", "AutoCloseable", "Cloneable", "Comparable"));
        questions.add(createQuestion(quiz, "What is the purpose of the upper-bounded wildcard '? extends Number' in Java Generics?", 2, "Accepts any superclass of Number", "Accepts Number and any of its subtypes", "Accepts only exact type Number", "Accepts any type without restriction"));
        questions.add(createQuestion(quiz, "In modern JVM memory architecture, what does Metaspace store?", 2, "Object instances", "Class metadata and loaded bytecode", "Thread stack frames and local variables", "Garbage collection logs"));
        questions.add(createQuestion(quiz, "What will Optional.ofNullable(null).orElse(\"Default\") return?", 2, "Throws NullPointerException", "\"Default\"", "null", "An empty Optional instance"));
        questions.add(createQuestion(quiz, "Which Set implementation maintains insertion order while guaranteeing element uniqueness?", 3, "HashSet", "TreeSet", "LinkedHashSet", "PriorityQueue"));
        questions.add(createQuestion(quiz, "What is a thread deadlock in Java?", 2, "A thread terminating due to an unhandled exception", "Two or more threads blocked forever, each waiting on a lock held by the other", "A thread consuming 100% CPU in an infinite loop", "A thread running out of allocated stack space"));
        questions.add(createQuestion(quiz, "In Java 16+, what is the primary role of a 'record'?", 2, "A mutable data transfer class with setters", "An immutable data carrier with compiler-generated constructor, getters, equals, and hashCode", "An interface supporting default implementations", "A dynamic proxy for database operations"));

        quiz.setQuestions(questions);
        quizRepository.save(quiz);
    }

    private void loadOopQuiz() {
        QuizEntity quiz = QuizEntity.builder()
                .name("OOP Concepts & Design Principles")
                .quizDescription("Examine Encapsulation, Inheritance, Polymorphism, Abstraction, SOLID principles, and Design Patterns.")
                .build();

        List<QuestionEntity> questions = new ArrayList<>();
        questions.add(createQuestion(quiz, "Which OOP pillar bundles state and behavior together and hides internal object details?", 3, "Polymorphism", "Inheritance", "Encapsulation", "Abstraction"));
        questions.add(createQuestion(quiz, "Method overloading is an example of which type of polymorphism?", 2, "Runtime polymorphism", "Compile-time (Static) polymorphism", "Dynamic dispatch", "Parametric polymorphism"));
        questions.add(createQuestion(quiz, "Can an abstract class in Java have constructors?", 2, "No, abstract classes cannot declare constructors", "Yes, and they are invoked when a subclass is instantiated", "Only if every method is abstract", "Only private constructors are permitted"));
        questions.add(createQuestion(quiz, "What does the 'L' in SOLID design principles stand for?", 2, "Lazy Loading Principle", "Liskov Substitution Principle", "Logical Separation Principle", "Layered System Principle"));
        questions.add(createQuestion(quiz, "Which relationship is modeled by class inheritance (e.g. Dog extends Animal)?", 2, "HAS-A", "IS-A", "USES-A", "PART-OF"));
        questions.add(createQuestion(quiz, "Which design pattern restricts a class to a single instance and provides a global access point?", 3, "Factory Pattern", "Prototype Pattern", "Singleton Pattern", "Builder Pattern"));
        questions.add(createQuestion(quiz, "What is the key structural difference between interfaces and abstract classes in Java?", 2, "Abstract classes cannot contain any implemented methods", "A class can implement multiple interfaces but can only extend one abstract class", "Interfaces can declare instance fields", "Abstract classes cannot declare static methods"));
        questions.add(createQuestion(quiz, "What does the Single Responsibility Principle (SRP) dictate?", 2, "A class must have only one method", "A class should have one, and only one, reason to change", "A class must implement only one interface", "A project should have only one main class"));
        questions.add(createQuestion(quiz, "In the Gang of Four (GoF) catalog, which category does the Observer pattern belong to?", 3, "Creational", "Structural", "Behavioral", "Architectural"));
        questions.add(createQuestion(quiz, "What does the principle 'Favor composition over inheritance' advocate?", 2, "Never use inheritance anywhere in code", "Use object composition (HAS-A) to achieve reuse with looser coupling", "Make all parent classes final", "Replace all interfaces with abstract classes"));
        questions.add(createQuestion(quiz, "What is a covariant return type in method overriding?", 2, "An overriding method returning void", "An overriding method returning a subtype of the return type declared in the superclass", "Changing the return type to any primitive type", "Returning multiple values simultaneously"));
        questions.add(createQuestion(quiz, "Which access modifier restricts member visibility strictly to within the declaring class?", 3, "default (package-private)", "protected", "private", "public"));
        questions.add(createQuestion(quiz, "Which design pattern constructs complex objects step-by-step to avoid telescoping constructors?", 1, "Builder Pattern", "Factory Method Pattern", "Singleton Pattern", "Adapter Pattern"));
        questions.add(createQuestion(quiz, "What characterizes loose coupling in software architecture?", 2, "Classes having strong direct dependencies on concrete implementations", "Components interacting through well-defined abstractions with minimal direct dependencies", "Writing all application code in a single file", "Avoiding interfaces altogether"));
        questions.add(createQuestion(quiz, "What does the Open/Closed Principle (OCP) establish?", 2, "Software entities should be open for modification and closed for extension", "Software entities should be open for extension, but closed for modification", "Database connections must be opened before writing and closed afterwards", "All classes must be public and open for inheritance"));
        questions.add(createQuestion(quiz, "Which design pattern converts the interface of a class into another interface clients expect?", 3, "Facade Pattern", "Decorator Pattern", "Adapter Pattern", "Proxy Pattern"));
        questions.add(createQuestion(quiz, "What happens if an overriding method reduces the visibility of a public superclass method?", 2, "It compiles and overrides successfully", "Compile-time error: attempting to assign weaker access privileges", "A runtime AccessControlException is thrown", "A compiler warning is generated"));
        questions.add(createQuestion(quiz, "What distinguishes a Deep Copy from a Shallow Copy?", 2, "Shallow copy creates new instances for all referenced objects", "Deep copy creates a new object and recursively duplicates all referenced child objects", "Shallow copy is inherently thread-safe", "Deep copy only duplicates primitive fields"));
        questions.add(createQuestion(quiz, "Which design pattern encapsulates interchangeable algorithms and selects them at runtime?", 1, "Strategy Pattern", "Template Method Pattern", "State Pattern", "Chain of Responsibility Pattern"));
        questions.add(createQuestion(quiz, "What does the Dependency Inversion Principle (DIP) state?", 2, "Low-level modules should dictate high-level module contracts", "High-level modules should not depend on low-level modules; both should depend on abstractions", "All dependencies must be injected via private fields", "Classes must instantiate their own dependencies directly"));

        quiz.setQuestions(questions);
        quizRepository.save(quiz);
    }

    private void loadSpringBootQuiz() {
        QuizEntity quiz = QuizEntity.builder()
                .name("Spring Boot Essentials & Architecture")
                .quizDescription("Test your knowledge on Inversion of Control, Bean Scopes, JPA, Transactions, and REST controllers.")
                .build();

        List<QuestionEntity> questions = new ArrayList<>();
        questions.add(createQuestion(quiz, "What is Inversion of Control (IoC) in the Spring Framework?", 2, "Controlling user authentication in REST controllers", "Transferring the control of object creation and lifecycle management to the Spring Container", "Inverting database relationships at runtime", "Executing controller methods in reverse order"));
        questions.add(createQuestion(quiz, "Which dependency injection style is officially recommended as best practice by the Spring team?", 3, "Field Injection with @Autowired", "Setter Injection", "Constructor Injection", "Method Injection"));
        questions.add(createQuestion(quiz, "What is the default bean scope in Spring?", 2, "Prototype", "Singleton", "Request", "Session"));
        questions.add(createQuestion(quiz, "Which annotation combines @Controller and @ResponseBody to return JSON responses automatically?", 3, "@Controller", "@Service", "@RestController", "@Endpoint"));
        questions.add(createQuestion(quiz, "What three core annotations does @SpringBootApplication encapsulate?", 1, "@Configuration, @EnableAutoConfiguration, and @ComponentScan", "@Controller, @Service, and @Repository", "@Bean, @Autowired, and @Value", "@Component, @Entity, and @Table"));
        questions.add(createQuestion(quiz, "How does Spring Boot configure beans automatically upon startup?", 2, "Manual parsing of XML configuration files", "Auto-configuration classes evaluated against conditional annotations (@ConditionalOnClass)", "Compiling Java classes dynamically in memory", "Querying remote discovery registries"));
        questions.add(createQuestion(quiz, "What is the purpose of the @Qualifier annotation in Spring?", 2, "Qualifies a class as a JPA entity", "Resolves ambiguity when multiple beans of the same type exist in the context", "Validates request payload fields", "Configures transaction propagation levels"));
        questions.add(createQuestion(quiz, "Which HTTP status code should be returned when a resource is successfully created via POST?", 2, "200 OK", "201 Created", "204 No Content", "202 Accepted"));
        questions.add(createQuestion(quiz, "In Spring Data JPA, what behavior does FetchType.LAZY enforce on associations?", 2, "Loads associated records immediately upon parent query", "Defers loading of associated records until they are explicitly accessed in code", "Never loads associated records from the database", "Throws an exception if associated records exist"));
        questions.add(createQuestion(quiz, "What is the 'N+1 Select Problem' in Hibernate / JPA?", 1, "Executing 1 initial query for parent entities followed by N separate queries for their associations", "Maintaining N+1 active database connection pools", "Inserting N+1 records in a single batch", "A memory leak occurring when N+1 entities are cached"));
        questions.add(createQuestion(quiz, "Which annotation automatically manages transaction boundaries and rolls back on unchecked exceptions?", 2, "@RollbackOnly", "@Transactional", "@DatabaseTransaction", "@AtomicOperation"));
        questions.add(createQuestion(quiz, "What is the primary role of @ControllerAdvice in Spring Boot?", 2, "Advises controllers on URI path routing", "Provides centralized, global exception handling across all controllers", "Validates security tokens on incoming requests", "Configures CORS cross-origin policies"));
        questions.add(createQuestion(quiz, "What is the default embedded HTTP server port in Spring Boot?", 3, "80", "8000", "8080", "5432"));
        questions.add(createQuestion(quiz, "Which annotation maps an HTTP GET request to a controller handler method?", 3, "@PostMapping", "@PutMapping", "@GetMapping", "@PatchMapping"));
        questions.add(createQuestion(quiz, "What does @PathVariable extract in a Spring MVC controller method?", 2, "URL query parameters after the '?' symbol", "Values embedded directly within the URI path template", "HTTP request header values", "The JSON request body"));
        questions.add(createQuestion(quiz, "In the Spring Bean lifecycle, which annotation marks a method to run immediately after dependency injection?", 3, "@PreDestroy", "@OnInit", "@PostConstruct", "@Startup"));
        questions.add(createQuestion(quiz, "What is the purpose of the CommandLineRunner interface in Spring Boot?", 1, "Executes a block of code once after the application context has fully loaded", "Runs unit tests from the command terminal", "Packages the application into an executable JAR file", "Starts the embedded servlet container"));
        questions.add(createQuestion(quiz, "What is the default transaction propagation behavior in @Transactional?", 3, "PROPAGATION_REQUIRES_NEW", "PROPAGATION_SUPPORTS", "PROPAGATION_REQUIRED", "PROPAGATION_MANDATORY"));
        questions.add(createQuestion(quiz, "How do you bind external configuration properties (e.g. from yaml) to a strongly-typed class?", 2, "@Value(\"${app.*}\")", "@ConfigurationProperties(prefix = \"...\")", "@PropertySource(\"...\")", "@AutoConfigureProperties"));
        questions.add(createQuestion(quiz, "Which Spring Data JPA repository interface provides CRUD operations, pagination, and sorting out of the box?", 3, "CrudRepository", "Repository", "JpaRepository", "PagingAndSortingRepository"));

        quiz.setQuestions(questions);
        quizRepository.save(quiz);
    }

    private void loadSqlQuiz() {
        QuizEntity quiz = QuizEntity.builder()
                .name("SQL & Relational Database Fundamentals")
                .quizDescription("Covering DDL, DML, JOINs, Indexing, Transactions (ACID), Normalization, and Grouping.")
                .build();

        List<QuestionEntity> questions = new ArrayList<>();
        questions.add(createQuestion(quiz, "Which SQL sub-language category do CREATE, ALTER, and DROP statements belong to?", 2, "DML (Data Manipulation Language)", "DDL (Data Definition Language)", "DCL (Data Control Language)", "TCL (Transaction Control Language)"));
        questions.add(createQuestion(quiz, "What is the primary difference between a PRIMARY KEY and a UNIQUE constraint?", 2, "A table can declare multiple Primary Keys", "A Primary Key column cannot accept NULL values whereas a UNIQUE column can accept NULL", "A UNIQUE constraint automatically creates a clustered index", "There is no difference in relational databases"));
        questions.add(createQuestion(quiz, "Which JOIN returns all records from the left table and matched records from the right table?", 3, "INNER JOIN", "FULL JOIN", "LEFT JOIN", "CROSS JOIN"));
        questions.add(createQuestion(quiz, "What is the functional difference between WHERE and HAVING clauses in SQL?", 1, "WHERE filters rows before aggregation; HAVING filters aggregated groups", "WHERE can only be used with GROUP BY; HAVING cannot", "HAVING filters individual rows before grouping occurs", "WHERE can directly evaluate aggregate functions like SUM()"));
        questions.add(createQuestion(quiz, "Which aggregate function computes the total number of non-NULL values in a column?", 3, "SUM()", "TOTAL()", "COUNT()", "AVG()"));
        questions.add(createQuestion(quiz, "What does the 'A' in ACID transaction properties guarantee?", 3, "Availability of data across nodes", "Accuracy of calculations", "Atomicity: all operations succeed or all are rolled back", "Authentication of database clients"));
        questions.add(createQuestion(quiz, "Which concurrency anomaly occurs when a transaction reads uncommitted changes made by another transaction?", 3, "Non-repeatable Read", "Phantom Read", "Dirty Read", "Lost Update"));
        questions.add(createQuestion(quiz, "What is the primary performance benefit of creating an index on a table column?", 2, "Enforces referential foreign key constraints", "Significantly accelerates data retrieval (SELECT queries)", "Speeds up bulk INSERT and UPDATE operations", "Compresses table disk storage"));
        questions.add(createQuestion(quiz, "Which SQL keyword eliminates duplicate rows from a query result set?", 3, "UNIQUE", "DIFFERENT", "DISTINCT", "DEDUPLICATE"));
        questions.add(createQuestion(quiz, "What does the 'ON DELETE CASCADE' clause on a foreign key enforce?", 2, "Prevents deletion of the referenced parent row", "Automatically deletes matching child records when the referenced parent record is deleted", "Sets the child foreign key value to NULL upon parent deletion", "Logs a warning message to the database audit table"));
        questions.add(createQuestion(quiz, "Which SQL operator searches for specified text patterns using wildcards (% and _)?", 3, "IN", "BETWEEN", "LIKE", "MATCH"));
        questions.add(createQuestion(quiz, "What is the core rule of Third Normal Form (3NF)?", 1, "The table must be in 2NF and contain no transitive dependencies among non-key attributes", "The table must only contain atomic, indivisible values in each column", "All multi-valued dependencies must be isolated into separate tables", "All foreign key constraints must be eliminated"));
        questions.add(createQuestion(quiz, "Which command permanently applies all transaction modifications to the database?", 3, "SAVEPOINT", "ROLLBACK", "COMMIT", "FLUSH"));
        questions.add(createQuestion(quiz, "What is the difference between UNION and UNION ALL?", 2, "UNION preserves duplicate rows while UNION ALL removes duplicates", "UNION removes duplicate rows while UNION ALL retains all duplicates", "UNION can combine queries with differing column counts", "UNION ALL automatically sorts results alphabetically"));
        questions.add(createQuestion(quiz, "In standard SQL, what does comparing any value with NULL using '=' (e.g. column = NULL) evaluate to?", 3, "TRUE", "FALSE", "UNKNOWN / NULL", "0"));
        questions.add(createQuestion(quiz, "Which SQL function returns the first non-NULL expression from its list of arguments?", 3, "ISNULL()", "IFNULL()", "COALESCE()", "NULLIF()"));
        questions.add(createQuestion(quiz, "What is a Database View?", 2, "A physical copy of table data stored in memory", "A virtual table defined by a stored SELECT query", "A stored procedure that alters table structures", "A composite index spanning multiple tables"));
        questions.add(createQuestion(quiz, "Which command removes all rows from a table rapidly without logging individual row deletions?", 3, "DELETE FROM table", "DROP TABLE table", "TRUNCATE TABLE table", "CLEAR TABLE table"));
        questions.add(createQuestion(quiz, "Which window function assigns an unbroken sequential integer (1, 2, 3...) to rows without ties?", 3, "RANK()", "DENSE_RANK()", "ROW_NUMBER()", "NTILE()"));
        questions.add(createQuestion(quiz, "Which transaction isolation level provides the highest consistency by preventing all concurrency phenomena?", 3, "Read Committed", "Repeatable Read", "Serializable", "Snapshot Isolation"));

        quiz.setQuestions(questions);
        quizRepository.save(quiz);
    }

    private QuestionEntity createQuestion(QuizEntity quiz, String text, int correctIndex, String opt1, String opt2, String opt3, String opt4) {
        QuestionEntity question = QuestionEntity.builder()
                .questionText(text)
                .quiz(quiz)
                .build();

        OptionEntity o1 = OptionEntity.builder().optionText(opt1).correct(correctIndex == 1).question(question).build();
        OptionEntity o2 = OptionEntity.builder().optionText(opt2).correct(correctIndex == 2).question(question).build();
        OptionEntity o3 = OptionEntity.builder().optionText(opt3).correct(correctIndex == 3).question(question).build();
        OptionEntity o4 = OptionEntity.builder().optionText(opt4).correct(correctIndex == 4).question(question).build();

        question.setOptions(List.of(o1, o2, o3, o4));
        return question;
    }
}
