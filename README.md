#  ![Webp net-resizeimage (1)](https://user-images.githubusercontent.com/29524842/164079918-1aba1749-cd3a-4e95-9f06-ee94c0ff5e45.png) ChocoTown
>An Ecommerce web application built using Jsp, Jakarta Servlets and JPA as our second project at the Information Technology Institute. 
> It takes full advantage of Tailwind component to build our view in a simple way .
# 🏛 Architecture
This software project was built using a layered architecture. The following diagram demonstrates an example use case that goes through all the layers.

![Screenshot (21)](https://user-images.githubusercontent.com/29524842/164091047-a8e9b7bd-e8c8-4a75-b1af-ad28fd1b9d33.png)


# 🏛 Database Schema

![image](https://user-images.githubusercontent.com/29524842/164091236-69ffa8f7-7bc1-4c36-a362-673d6c3c28ef.png)


# ⚙ Features
* Registration and login
* Email confirmation
* Forget password
* Add product `admin`
* Edit product `admin` 
* Delete product `admin`
* View all customers `admin`
* view orders' history `admin`
* View homepage `customer`
* View product details `customer`
* Add product to cart `customer`
* View shopping cart `customer`
* Search by category `customer`
* checkout `customer`
* logout `customer and admin`

# Demo

# ⚙ Technologies used
* Maven
* JPA
* MySQL
* JSP
* Jakarta Servlet
* Tailwind
* Ajax 
* Bean Validation (Hibernate Validator)
* HikariCP
* MySQL
* Spring Security Encoder
* Strip 

# ⚙ Docker


# 🛠 How to run
**Maven**

* Change the configuration of tomcat in `pom.xml`.
* Deploy the application using the following maven command:
```
mvn clean compile tomcat7:redeploy
```


**MySQL**
* Create a database user using MySQL Commandline 8.0 using the following commands:
```sql
CREATE USER 'manager'@'localhost' IDENTIFIED BY 'manager';
GRANT ALL PRIVILEGES ON ecommerce . * TO 'manager'@'localhost';
FLUSH PRIVILEGES;
```
* Go to `resources/META-INF/persistence.xml` and make the value of `hibernate.hbm2ddl.auto` property equal `create`. 
* Run DatabasePopulator.java file
```
mvn clean compile exec:java -Dexec.mainClass=gov.iti.jets.repository.util.DatabasePopulator
```
* Go back to `resources/META-INF/persistence.xml` and make the value of `hibernate.hbm2ddl.auto` property equal `update`.

# 👷‍♀️ Contributors
* [Abdelrahman Samy](https://github.com/A-Samyy) `LEADER`
* [Mahmoud Fawzy](https://github.com/MahmoudFawzyKhalil)
* [Mariam Mohamed](https://github.com/Mariemfakhreldein)
* [Marwa Adel Youssef](https://github.com/marwaayosiif)
