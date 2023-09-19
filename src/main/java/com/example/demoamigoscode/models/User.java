package com.example.demoamigoscode;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "app_user")
public class User {

  @Id
  @SequenceGenerator(
    name = "user_id_sequence",
    sequenceName = "user_id_sequence",
    allocationSize = 1
  )
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "user_id_sequence"
  )

  private Integer id;
  private String name;
  private String email;
  private Integer age;
  private String password;

  public User(Integer id, String name, String email, Integer age) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.age =age;
  }

  public User() {

  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Integer getAge() {
    return age;
  }

  public void setEmail(String emailString) {
    this.email = emailString;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return Objects.equals(id, user.id) && Objects.equals(name, user.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, email, age);
  }

  @Override
  public String toString() {
    return "User { " +
            "id: " + id +
            " name: " + name +
            " email: " + email +
            " age: " + age +
            "}";
  }
}