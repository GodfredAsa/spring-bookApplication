package io.degreat.bookApplication.Service.serviceImp;
import io.degreat.bookApplication.Model.Book;
import io.degreat.bookApplication.Repository.BookRepository;
import io.degreat.bookApplication.Service.Iservice.BookService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookServiceImplemetation implements BookService {

    private BookRepository bookRepository;

    public BookServiceImplemetation(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public Book saveBook(Book book){
        book.setCreatedTime(LocalDateTime.now());
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findAllBooks(){
        return bookRepository.findAll();
    }

    @Override
    public void deleteBook(Long bookId){
        bookRepository.deleteById(bookId);
    }


//    just implemented
    @Override
    public Book updateBook(Book book){
        book.setCreatedTime(LocalDateTime.now());
        book.setAuthor(book.getAuthor());
        book.setDesc(book.getDesc());
        book.setCreatedTime(book.getCreatedTime());
        book.setPrice(book.getPrice());
       return bookRepository.save(book);
    }
}
