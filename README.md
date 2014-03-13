My Very Sign
============

##Installation

Copy db-config.xml.dist to db-config.xml

```bash
$ mv src/main/webapp/WEB-INF/db-config.xml.dist mv src/main/webapp/WEB-INF/db-config.xml
```
Change database credidentials on config-db.xml

```xml
<bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
    <property name="driverClassName" value="com.mysql.jdbc.Driver" />
    <property name="url" value="jdbc:mysql://localhost:3306/MyVerySign" />
    <property name="username" value="root" />
    <property name="password" value="mhor" />
</bean>
```
