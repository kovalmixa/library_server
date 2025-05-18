package kovalchuk.library.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Borrowing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private Long bookId;
    private String borrowerName;
    private String borrowedDate;
    private boolean returned;

    public Borrowing() {}
    public Borrowing(Long bookId, String borrowerName, String borrowedDate, boolean returned) {
        this.bookId = bookId;
        this.borrowerName = borrowerName;
        this.borrowedDate = borrowedDate;
        this.returned = returned;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public Long getBookId() {return bookId;}
    public void setBookId(Long bookId) {this.bookId = bookId;}

    public String getBorrowerName() {return borrowerName;}
    public void setBorrowerName(String borrowerName) {this.borrowerName = borrowerName;}

    public String getBorrowedDate() {return borrowedDate;}
    public void setBorrowedDate(String borrowedDate) {this.borrowedDate = borrowedDate;}

    public boolean isReturned() {return returned;}
    public void setReturned(boolean returned) {this.returned = returned;}
}
