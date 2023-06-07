# Electronic Repair Service Provider
This is a Spring Boot application that serves as an electronic repair service provider, allowing customers to request repair services for their electronic devices. The application provides RESTful API endpoints for managing repair requests.

### Features
* Create a repair request by providing customer details, device information, and the issue description.
* Retrieve a list of all repair requests.
* Filter repair requests by customer name, device, and status.
* Mark a repair request as complete or incomplete.
### Technologies Used
* Java
* Spring Boot
* Spring Data JPA
* MySQL (or your preferred database)
* HTML/CSS/JavaScript (for the frontend interface)
### Getting Started
Follow the instructions below to set up and run the application:

* Clone the repository to your local machine.
* Set up a MySQL database and configure the database connection in the application.properties file.
* Run the application using your preferred IDE or by executing mvn spring-boot:run in the project root directory.
* Access the application by opening http://localhost:8080 in your web browser.
### API Endpoints
* GET /api/repairs: Retrieve all repair requests.
* GET /api/repairs/{id}: Retrieve a specific repair request by ID.
* POST /api/repairs: Create a new repair request.
* PUT /api/repairs/{id}: Update the status of a repair request.
* DELETE /api/repairs/{id}: Delete a repair request.

Refer to the API documentation or code for detailed request and response formats.

### Frontend Interface
The application provides a simple frontend interface built with HTML, CSS, and JavaScript. It allows users to create repair requests, view the list of repair requests, and mark repair requests as complete or incomplete.

To access the frontend interface, open http://localhost:8080 in your web browser after running the application.

### Contributing
Contributions to this project are welcome. Feel free to open issues or submit pull requests to suggest improvements, report bugs, or add new features.