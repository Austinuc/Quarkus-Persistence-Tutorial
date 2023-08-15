# Quarkus demo-persistence tutorial
This project uses Quarkus, the Supersonic Subatomic Java Framework.

```

To simplify the development of microservices requiring storage, 
Quarkus created Hibernate ORM with Panache (Panache), 
an opinionated means of storing and retrieving state from a database, 
heavily inspired by the Play framework, Ruby on Rails, and JPA experience. 
Panache offers two different paths, depending on developer preference: 
active record and data repository. 
The data repository approach will be familiar to those with experience in Spring Data JPA.

```

Before delving into the Panache implementations, lets first consider the JPA approach.
The figure below illustrates the JPA approach; it uses an Entity Manager to interface between the Entity class in Quarkus
and the Database.

![jpa-approach.png](src%2Fmain%2Fresources%2Fjpa-approach.png)

To use JPA the following dependencies need to be added.

```java
<dependency>
    <groupId>io.quarkus</groupId>
    <artifactId>quarkus-hibernate-orm</artifactId>
</dependency>
<dependency>
    <groupId>io.quarkus</groupId>
    <artifactId>quarkus-jdbc-postgresql</artifactId> 
</dependency>

        'quarkus-hibernate-orm' adds the Hibernate implementation of JPA to the project, 
        and 'quarkus-jdbc-postgresql' adds the JDBC driver for PostgreSQL
```
Next is to define a JPA Entity as shown in the 'EntityJpa.class' and then we can use the EntityManager to interact 
with the database on behalf of the JPA Entity as shown in the 'JpaService.class'.

## Simplifying database development
Using JPA for accessing a database is only one approach of many. 
Quarkus also includes the ability to choose the active record or data repository approaches to managing state. 
Both of these approaches are part of the Panache extensions to Quarkus. 
Panache seeks to make writing entities trivial and fun with Quarkus.

### Active record approach
In the active record approach as opposed to the JPA approach, all interactions occur through the entity itself.
The active record approach puts the data access logic into the domain object directly. 
This approach rose to popularity with Ruby on Rails and the Play framework.
![panache-active-record-approach.png](src%2Fmain%2Fresources%2Fpanache-active-record-approach.png)

For this, we need a different dependency, the Panache version of the Hibernate ORM

```java
<dependency>
    <groupId>io.quarkus</groupId>
    <artifactId>quarkus-hibernate-orm-panache</artifactId> 
</dependency>
```
#### Note the following difference:
 - @Entity is still used to indicate the class is a JPA entity.
 - Getter and setter methods for the fields are not required. During build time,
Panache generates the necessary getter and setter methods, replacing field
access in code to use the generated getter and setter methods.
 - Definition of id, the primary key, is handled by PanacheEntity. If there was a need
to customize the id configuration, we could do it with the usual JPA annotations.
   
## Data repository approach

![panache-direct-repository-approach.png](src%2Fmain%2Fresources%2Fpanache-direct-repository-approach.png)