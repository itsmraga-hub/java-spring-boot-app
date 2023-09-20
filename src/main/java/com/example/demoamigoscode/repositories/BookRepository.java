package com.example.demoamigoscode;

import com.example.demoamigoscode.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByLibraryId(Long libraryId);
}
