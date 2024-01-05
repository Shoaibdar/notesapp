<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Notes API Documentation</title>
</head>

<body>

    <h1>Notes API</h1>

    <h2>Project Overview</h2>

    <p>This project involves the development of a secure and scalable RESTful API that enables users to manage notes. Users can create, read, update, and delete notes. Additionally, the application supports features such as sharing notes with other users and searching for notes based on keywords.</p>

    <h2>Technical Requirements</h2>

    <h3>Technologies Used</h3>

    <ul>
        <li><strong>Framework:</strong> Spring Boot</li>
        <li><strong>Database:</strong> MySQL</li>
        <li><strong>Authentication:</strong> JWT (JSON Web Tokens)</li>
        <li><strong>Rate Limiting and Throttling:</strong> Implemented</li>
        <li><strong>Search Functionality:</strong> Utilizes MySQL's Full-Text Search for text indexing</li>
    </ul>

    <h3>API Endpoints</h3>

    <h4>Authentication Endpoints</h4>

    <ol>
        <li><strong>POST /api/auth/signup:</strong> Create a new user account.</li>
        <li><strong>POST /api/auth/login:</strong> Log in to an existing user account and receive an access token.</li>
    </ol>

    <h4>Note Endpoints</h4>

    <ol start="3">
        <li><strong>GET /api/notes:</strong> Get a list of all notes for the authenticated user.</li>
        <li><strong>GET /api/notes/{id}:</strong> Get a note by ID for the authenticated user.</li>
        <li><strong>POST /api/notes:</strong> Create a new note for the authenticated user.</li>
        <li><strong>PUT /api/notes/{id}:</strong> Update an existing note by ID for the authenticated user.</li>
        <li><strong>DELETE /api/notes/{id}:</strong> Delete a note by ID for the authenticated user.</li>
        <li><strong>POST /api/notes/{id}/share:</strong> Share a note with another user for the authenticated user.</li>
        <li><strong>GET /api/search?q={query}:</strong> Search for notes based on keywords for the authenticated user.</li>
    </ol>

    <h3>Database Configuration</h3>

    <ul>
        <li><strong>Database Type:</strong> MySQL</li>
        <li><strong>Database Name:</strong> Replace with your preferred database name</li>
        <li><strong>Username:</strong> Replace with your MySQL username</li>
        <li><strong>Password:</strong> Replace with your MySQL password</li>
        <li><strong>Default Login Credentials:</strong></li>
        <ul>
            <li><strong>Username:</strong> admin</li>
            <li><strong>Password:</strong> admin</li>
        </ul>
    </ul>

    <h2>Getting Started</h2>

    <ol>
        <li>Clone the repository.</li>
        <pre><code>git clone https://github.com/your-username/notes-api.git</code></pre>
        <li>Configure your MySQL database settings in the application properties file.</li>
        <pre><code>
# src/main/resources/application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
        </code></pre>
        <li>Build and run the application.</li>
        <pre><code>./mvnw spring-boot:run</code></pre>
        <li>Access the API at <a href="http://localhost:8080">http://localhost:8080</a>.</li>
    </ol>

</body>

</html>
