#  ![Webp net-resizeimage (1)](https://user-images.githubusercontent.com/29524842/164079918-1aba1749-cd3a-4e95-9f06-ee94c0ff5e45.png) ChocoTown
>An Ecommerce web application built using Jsp, Jakarta Servlets and JPA as our second project at the Information Technology Institute. 
> It takes full advantage of Tailwind component to build our view in a simple way .
# 🏛 Architecture
This software project was built using a layered architecture. The following diagram demonstrates an example use case that goes through all the layers.

![image](https://user-images.githubusercontent.com/73137611/155808282-0a0ee1ab-9d35-4258-a953-c9ccad72f707.png)

# 🏛 Database Schema
![](C:/Users/marwa/OneDrive/Desktop/Ecommerce_Schem.png)

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

![Animation](https://user-images.githubusercontent.com/73137611/155806535-92e5a736-0b30-4e19-b5f1-371c91970736.gif)
![Animation2](https://user-images.githubusercontent.com/73137611/155806878-b4b497cd-5821-4420-9a9d-e95340aa4ff2.gif)

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
