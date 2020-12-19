package ma.ensa.tpbatch.dao;

import ma.ensa.tpbatch.beans.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface TransactionRepo extends JpaRepository<Transaction,Integer> {
}
