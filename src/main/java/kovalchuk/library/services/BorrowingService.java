package kovalchuk.library.services;

import kovalchuk.library.models.Borrowing;
import kovalchuk.library.repositories.BorrowingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowingService {

    private final BorrowingRepository borrowingRepository;

    @Autowired
    public BorrowingService(BorrowingRepository borrowingRepository) {
        this.borrowingRepository = borrowingRepository;
    }

    public List<Borrowing> getActiveBorrowings() {
        return borrowingRepository.findByReturned(false);
    }

    public Borrowing createBorrowing(Borrowing borrowing) {
        return borrowingRepository.save(borrowing);
    }

    public Borrowing returnBook(Long id) {
        Optional<Borrowing> borrowing = borrowingRepository.findById(id);
        if (borrowing.isPresent()) {
            Borrowing existingBorrowing = borrowing.get();
            existingBorrowing.setReturned(true);
            return borrowingRepository.save(existingBorrowing);
        }
        return null;
    }
}
