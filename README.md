# (TASK 1) Java_REST_API 

# Java Application with REST API for Server Management
This Java application provides a REST API for managing server objects, including searching, creating, and deleting servers. The server objects are stored in a MongoDB database and the API endpoints can be accessed using any HTTP client such as Postman or cURL.

## API Endpoints
The REST API has the following endpoints:

- GET /servers - Returns all the servers if no parameters are passed. When server id is passed as a parameter, it returns a single server or 404 if there’s no such a server.
- PUT /servers - Creates a server object using a json-encoded message body. The message body should include the following properties: name, id, language, and framework.
- DELETE /servers/{id} - Deletes the server object with the given id parameter.
- GET /servers/search?name={name} - Searches for servers by name. It returns one or more servers that contain the specified name in their server name. It returns 404 if nothing is found.

GET servers. Should return all the servers if no parameters are passed. When server id is passed as a parameter
 - return a single server or 404 if there’s no such a server.
● PUT a server. The server object is passed as a json-encoded message body. Like Below
example:
{
“name”: ”my centos”,
“id”: “123”,
“language”:”java”,
“framework”:”django”
}
● DELETE a server. The parameter is a server ID.
● GET (find) servers by name. The parameter is a string. Must check if a server name
contains this string and return one or more servers found. Return 404 if nothing is found.

#### MongoDB Database
The server objects are stored in a MongoDB database. The database configuration is defined in the application.properties file. Please ensure that MongoDB is installed and running before running the application.

##### Running the Application
 To run the application, follow these steps:

  1. Clone the repository.
  2. Open the project in your preferred Java IDE  (I used Intellij).
  3. Build the project using Maven.
  4. Run the application.
 Once the application is running, you can test the API endpoints using any HTTP client such as Postman or cURL.

###### Conclusion
This Java application provides a REST API for managing server objects. By utilizing MongoDB to store the server objects, this application allows for efficient and effective management of servers. With the provided API endpoints, users can easily search, create, and delete server objects.


## Screenshots
- PUT request
![image](https://user-images.githubusercontent.com/51507434/228626936-b7d26266-c8e1-4aad-be7a-4416ba7d9db3.png)

- POST request
![image](https://user-images.githubusercontent.com/51507434/228627203-52d45c74-3aab-465f-8c22-33eae2eb9028.png)

