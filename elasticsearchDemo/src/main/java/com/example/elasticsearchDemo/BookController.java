package com.example.elasticsearchDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.example.elasticsearchDemo.Book;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookDao bookDao;

    @Autowired
    public BookController(BookDao bookDao) {
        this.bookDao = bookDao;
    }
//    @GetMapping("/{id}")
//    public Map<String, Object> getBookById(@PathVariable String id){
//        return bookDao.getBookById(id);
//    }
    @PostMapping
    public Book insertBook(@RequestBody Book book) throws Exception {
        return bookDao.insertBook(book);
    }

    @PutMapping("/{id}")
    public Map<String, Object> updateBookById(@RequestBody Book book, @PathVariable String id) {
        return bookDao.updateBookById(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable String id) {
        bookDao.deleteBookById(id);
    }

    @GetMapping("/{author}")
    public List<Book> findByname(@PathVariable String author){
        return bookDao.searchByName(author);

    }
}
