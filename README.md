# Spring security 
---
>learning spring security using postgress as my data base

## setting up the model
>model is used to define the entities that we are having on our sql table
> we need some annotations to use them  in our model
> 
***Annotations***
---

```java
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "yourTableName")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
```

# logic 
1.  create a user class as a model which  resembles our table in the database
1.  then create a user repository interface which  extends a jpaRepository
2.  create our own custom Query in the repository interface
3.  create a  service for users in the service function which is an interface 
4. create an implementation of the user service the class implements the userService interface
5. overide all the implimenttions
