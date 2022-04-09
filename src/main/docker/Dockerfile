FROM tomcat:10.0.18-jdk11-temurin
WORKDIR /usr/local/tomcat

COPY maven/e-commerce-app-1.0-SNAPSHOT.war ./webapps/ROOT.war

COPY res/bla.txt .

# COPY ecommerce ./ecommerce

# COPY server.xml ./conf/

VOLUME [ "./ecommerce" ]

# EC2: ec2-54-75-15-163.eu-west-1.compute.amazonaws.com

#  docker container run -p 80:8080 -v //c/users/mahmoud/my_ecommerce_stuff:/usr/local/tomcat/ecommerce mahmoudfawzykhalil/ecommerce

# sudo docker container run -p 80:8080 -v /usr/local/my_ecommerce_stuff:/usr/local/tomcat/ecommerce mahmoudfawzykhalil/ecommerce

# docker image build -t my-tomcat

# -v //c/users/my_ecommerce_stuff:/var/lib/mysql

# Documentation of what port inside the container you should expose e.g. Tomcat exposes 8080, so you should map some port

# on your machine to 8080 e.g. -p 80:8080

#mysql-test-db.cavhbzv4t52u.eu-west-1.rds.amazonaws.com
# ec2-54-75-15-163.eu-west-1.compute.amazonaws.com

EXPOSE 8080

#Setting an environment variable
# ENV JAVA_OPTS="bla"
# Already inherited from base tomcat image but is written for clarity or to override the base image's CMD

CMD ["catalina.sh", "run"]