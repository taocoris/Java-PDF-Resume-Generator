# Java PDF Resume Generator

This project is a console application developed in Java following Object-Oriented Programming (OOP) principles to dynamically generate a professional resume (CV) in PDF format. The **iText** library is utilized for all PDF generation and manipulation processes.

## Components, Objects, and Classes Used

The application is designed with a modular architecture to enhance code readability and maintainability. Instead of stacking all operations inside a single `main` method, responsibilities are distributed across different classes and objects:

-   **`Main` Class:** The entry point of the application. It acts as the controller class where personal details and work experiences are defined, objects are instantiated in memory (using the `new` keyword), and the application is triggered.
-   **`Experience` Class (Data Class / POJO):** This class models work experiences. It encapsulates details such as company name, position, duration, and job description into a single object.
-   **`ResumeGenerator` Class:** The core processing class responsible for physically writing the PDF file to disk, applying font settings, and embedding the profile image into the document. It encapsulates iText library objects such as `Document`, `PdfWriter`, `Paragraph`, `Font`, and `Image`.

## Why Were These Components and Objects Used?

-   **Encapsulation and Data Security:** The fields within the `Experience` class are defined with `private final` access modifiers. This ensures immutability, preventing unauthorized or accidental modifications to the data once an experience object is created.
-   **Single Responsibility Principle:** PDF generation algorithms and data retention operations are strictly separated. This keeps the `Main` class clean and ensures that data is seamlessly transferred to the `ResumeGenerator` via a `List<Experience>` object.
-   **iText Library:** iText was chosen and integrated via `build.gradle` because it is an industry-standard, robust solution for programmatic PDF manipulation and creation in Java.

## The Role of AI (Language Models) in the Project

During the development process, an AI assistant (LLM) was utilized not to generate the entire code directly, but rather as a "pair programmer" and architectural consultant in the following ways:

1.  **Library Research:** Since Java lacks a native PDF generator, the differences between iText and Apache PDFBox were analyzed with the help of AI, leading to the selection of iText as the most suitable library for this scope.
2.  **Class Architecture (OOP Design):** AI guidance was utilized to structure the application according to SOLID principles, successfully splitting the logic into the `ResumeGenerator` and `Experience` classes instead of writing spaghetti code in the `Main` method.
3.  **Debugging and Optimization:** AI support was received for resolving IDE warnings (e.g., "Field can be final" suggestions and image extension mismatches) and for effectively handling exceptions such as `IOException` and `DocumentException`.

## Setup and Execution

1. Clone this repository to your local machine.
2. Ensure you have the Java Development Kit (JDK) and Gradle installed on your system.
3. Add a profile photo named `profile.png` or `profile.jpg` to the root directory of the project.
4. Synchronize the Gradle dependencies via your IDE (e.g., VS Code) to download the iText library configured in `build.gradle`.
5. Run the `Main.java` file. Upon a "Build Successful" message, your generated PDF resume will automatically appear in the root directory.

bunu unutma kalsın burda readme
