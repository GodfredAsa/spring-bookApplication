package io.degreat.bookApplication.Service;
import io.degreat.bookApplication.Model.Book;
import io.degreat.bookApplication.Repository.BookRepository;
import io.degreat.bookApplication.Service.serviceImp.BookServiceImplemetation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceImplemetationTest {
    @Mock
    private BookRepository repository;
    @Mock
    private BookServiceImplemetation underTest;

    @BeforeEach
    void setUp() {
        this.underTest = new BookServiceImplemetation(repository);
    }

    @Test
    void saveBook() {
        Book book =  new Book();
        book.setCreatedTime(LocalDateTime.now());

        when(underTest.saveBook(book)).thenReturn(new Book());

        Book expectedBook  = new Book();
        Book actualBook = underTest.saveBook(book);

        assertEquals(expectedBook, actualBook);
    }

    @Test
    void findAllBooks() {
        List<Book> books = Arrays.asList(new Book(), new Book());

        when(underTest.findAllBooks()).thenReturn(books);

        List<Book> expectedBooks = Arrays.asList(new Book(), new Book());
        List<Book> actualBooks = underTest.findAllBooks();

        System.out.println( "expected: "+ actualBooks.size() + ", actual " +  expectedBooks.size());

        assertEquals(expectedBooks, actualBooks);
    }

    @Test
    void updateBook() {
        Book book =  new Book();
        book.setCreatedTime(LocalDateTime.now());
        when(underTest.updateBook(book)).thenReturn(any(Book.class));

        Book expectedBook = new Book();
        Book actualBook = underTest.updateBook(expectedBook);

        assertEquals(expectedBook, actualBook);
    }
}