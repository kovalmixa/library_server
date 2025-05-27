package kovalchuk.library.controllers;

import kovalchuk.library.models.Borrowing;
import kovalchuk.library.services.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrowings")
public class BorrowingController {
    private BorrowingService borrowingService;

    @Autowired
    public BorrowingController(BorrowingService borrowingService) {
        this.borrowingService = borrowingService;
    }

    @GetMapping("/active")
    public List<Borrowing> getActiveBorrowings() {
        return borrowingService.getActiveBorrowings();
    }

    @PostMapping
    public ResponseEntity<Borrowing> createBorrowing(@RequestBody Borrowing borrowing) {
        Borrowing savedBorrowing = borrowingService.createBorrowing(borrowing);
        return new ResponseEntity<>(savedBorrowing, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/return")
    public ResponseEntity<Borrowing> returnBook(@PathVariable Long id) {
        Borrowing updatedBorrowing = borrowingService.returnBook(id);
        if (updatedBorrowing != null) {
            return new ResponseEntity<>(updatedBorrowing, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
