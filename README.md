# What is an entity and How does it look like?

The word "entity" varies from different contexts. For instance, It means an object, when we talk about JAVA. However, we use table instead of entity for SQL.

There is not any spesific way to create or design an entity but the fundamentals do not change. They define a blueprint of a thing. It demonstrates the features so it gains a meaning. 

In this example, I want to show how it looks in different perspectives, such as Java and SQL.

### Purpose

The main purpose is to examine how a database works in practice. Since this is an example, we do not focus on the design decision.

```
          List of tables
 Schema |   Name   | Type  | Owner 
--------+----------+-------+-------
 public | customer | table | kaan
(1 row)
```
This is an example of a table. Since we are working with Spring Boot, I used PostgreSQL. In the first step, we should create a table to use it with an API.

```Bash
CREATE TABLE customer(
    ID SERIAL PRIMARY KEY,
    name text,
    customer_street text,
    customer_city text
)
```

As mentioned before, this is a blueprint of a customer, whihc means: A customer is defined by some specific attributes, such as name, customer_street, and customer_city.

As given before, we can add customers one by one. In order to do that, we use API to manage this process efficiently. So I codded very simple API to add a new customer to the table. `Entity` class is the most important one in this context becuase we are trying to compare how the process is handeled in two different language.

To create an entity, we should code a class for customer.

```Java
@Entity
public class Customer {
    @ID
    @GeneratedValue(strategy=GenerationType.Identity)
    private long id;

    @Column
    private String name;

    @Column(name="customer_street")
    private String customerStreet;

    @COlumn(name="customer_city")
    private String customerCity;

    // Getters and Setters...
}
```
As seen in the code block, it is highly similar to SQL. However, we use objects for tables.

After adding some new customers, the database lokks like following.

```
1	Kaan	\N	\N
2	Kaan	71 Egham Hill The Pad	Surrey
3	Kaan	71 Egham Hill The Pad	Surrey
```
