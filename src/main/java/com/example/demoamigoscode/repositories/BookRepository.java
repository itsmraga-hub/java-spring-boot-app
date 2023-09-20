package com.example.demoamigoscode.repositories;

import com.example.demoamigoscode.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
//    @Query(value = "SELECT * FROM book WHERE library_id = ?1", nativeQuery = true)
//    List<Book> findLibraryByBooksId(@Param("libraryId") Integer id);
//    List<Book> findByLibraryId(Integer library_id);

    List<Book> findBooksByLibrary_Id(Integer id);
}
