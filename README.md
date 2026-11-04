# Spring Framework: Automatic Bean Management & Annotations

Welcome to this Spring Framework repository! This guide explores how Spring simplifies enterprise Java development through **Inversion of Control (IoC)**, **Dependency Injection (DI)**, the **Application Context**, and core component annotations.

---

## 1. Core Concepts: IoC and DI

### Inversion of Control (IoC)
In traditional Java applications, your custom code controls the creation and lifecycle of objects using the `new` keyword. With **Inversion of Control (IoC)**, this control is "inverted" and handed over to the framework (Spring). Instead of your code instantiating objects, Spring creates, configures, and manages them.

### Dependency Injection (DI)
Dependency Injection is the design pattern used by Spring to implement IoC. Instead of a class building or fetching the dependencies it needs (like a database service or a logging utility), Spring **injects** those dependencies at runtime. This leads to loosely coupled code that is much easier to test and maintain.

---

## 2. How the Application Context Works

The **Application Context** (`ApplicationContext`) is the central heart of the Spring container. It is responsible for instantiating, configuring, and assembling beans.

1. **Configuration Scanning:** When the application starts, Spring scans your specified package paths (using configuration classes or component scanning) looking for classes annotated with Spring stereotypes (`@Component`, `@Service`, etc.).
2. **Bean Definition Loading:** Spring reads these classes and creates internal metadata representations called **Bean Definitions**.
3. **Instantiation & Dependency Resolution:** Spring analyzes how beans depend on one another. It instantiates the required objects, resolves dependencies, and injects them (via constructor, setter, or field injection).
4. **Lifecycle Management:** The container manages the bean from initialization to destruction, keeping them ready for use inside the application runtime.

---

## 3. Essential Annotations and Their Purposes

Spring uses annotations to automatically detect, configure, and wire beans without heavy XML configuration files.

### Component Scanning & Stereotypes

* **`@Component`**
  * **Purpose:** A generic stereotype annotation indicating that a class is a Spring-managed component (bean). Spring will automatically detect it during component scanning.
* **`@Service`**
  * **Purpose:** A specialized version of `@Component` used for classes residing in the service layer (business logic). It improves semantic readability.
* **`@Repository`**
  * **Purpose:** A specialized version of `@Component` for the persistence layer (data access). Beyond marking the class as a bean, it automatically translates database-specific exceptions into Spring's unified data access exceptions.
* **`@Controller` / `@RestController`**
  * **Purpose:** Used in the presentation/web layer. `@Controller` handles web requests (often returning views), while `@RestController` combines `@Controller` and `@ResponseBody` for building RESTful web services that return JSON or XML directly.

### Dependency Injection Annotations

* **`@Autowired`**
  * **Purpose:** Marks a constructor, field, or setter method to be automatically injected by Spring's dependency injection facility. (Constructor injection is recommended for mandatory dependencies).
* **`@Primary`**
  * **Purpose:** When multiple beans of the same type are available, `@Primary` gives high priority to a specific bean, telling Spring to inject it by default if no qualifier is specified.
* **`@Qualifier`**
  * **Purpose:** Used alongside `@Autowired` to resolve ambiguity when multiple beans of the same type exist. You explicitly specify the exact bean name you want to inject.

### Configuration & Bean Definition

* **`@Configuration`**
  * **Purpose:** Indicates that a class declares one or more `@Bean` methods and may be processed by the Spring container to generate bean definitions and service requests at runtime.
* **`@Bean`**
  * **Purpose:** Placed on a method within a `@Configuration` class to tell Spring that the object returned by that method should be registered as a bean in the Spring IoC container. Useful for integrating third-party libraries.
* **`@ComponentScan`**
  * **Purpose:** Configures component scanning directives for use with `@Configuration` classes, letting Spring know which packages to search for annotated beans.

