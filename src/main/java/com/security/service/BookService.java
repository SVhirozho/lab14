package com.security.service;

import com.security.model.Book;
import com.security.model.User;
import com.security.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> getAllBooksForCurrentUser() {
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return bookRepository.findByUserId(currentUser.getId());
    }

    public Book createBook(Book book) {
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        book.setUser(currentUser);
        return bookRepository.save(book);
    }

    public Book getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!book.getUser().getId().equals(currentUser.getId())) {
            throw new AccessDeniedException("You don't have permission to access this book");
        }
        
        return book;
    }

    public Book updateBook(Long id, Book bookDetails) {
        Book book = getBookById(id); // This will check permissions
        book.setTitle(bookDetails.getTitle());
        book.setDescription(bookDetails.getDescription());
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        Book book = getBookById(id); // This will check permissions
        bookRepository.delete(book);
    }
}
