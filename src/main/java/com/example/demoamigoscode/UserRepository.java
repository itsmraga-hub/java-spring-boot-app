package com.example.demoamigoscode;

import com.example.demoamigoscode.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository
  extends JpaRepository<User, Integer> {
  
}
