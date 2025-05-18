package kovalchuk.library.repositories;

import kovalchuk.library.models.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BorrowingRepository extends JpaRepository<Borrowing, Long> {
    List<Borrowing> findByReturned(boolean returned);
}
