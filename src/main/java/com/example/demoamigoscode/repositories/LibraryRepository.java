package com.example.demoamigoscode;

import com.example.demoamigoscode.models.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library, Long> {

}
