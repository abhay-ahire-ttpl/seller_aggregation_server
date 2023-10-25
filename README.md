## Local Setup

To run this application locally, you'll need to configure the database connection in the `application.properties` file. 
Here are the steps:

1. Clone the repository to your local machine:
   ```bash
   git clone https://github.com/abhay-ahire-ttpl/seller_aggregation_server.git
   ```

   Navigate to the project directory:

   ```
   cd seller_aggregation_server
   ```

2. Open the src/main/resources/application.properties file and configure the database settings. You may need to set the URL, username, and password for your database.

   ```
    spring.datasource.url=jdbc:postgresql://localhost:5432/your_db_name
    spring.datasource.username=your_username
    spring.datasource.password=your_password
   ```

3. Save the changes.


4. Build and run the application:

   ``` bash
   ./mvnw spring-boot:run
   ```

5. Your Spring Boot application should now be running locally. Access it in your web browser at http://localhost:8087.