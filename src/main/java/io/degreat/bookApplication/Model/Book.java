package io.degreat.bookApplication.Model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;
@NoArgsConstructor
@Entity
@Data
@Table(name  = "books")

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    @Column(name = "title", nullable = false, length =100)
    private String title;
    @Column(name = "description", nullable = false, length = 500)
    private String desc;
    @Column(name = "author", nullable = false, length = 100)
    private String author;
    @Column(name = "price", nullable = false)
    private Double price;
    @Column(name = "created_time", nullable = false)
    private LocalDateTime createdTime;

}
