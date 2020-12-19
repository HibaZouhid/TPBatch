package ma.ensa.tpbatch.batch;

import ma.ensa.tpbatch.beans.Compte;
import ma.ensa.tpbatch.beans.Transaction;
import ma.ensa.tpbatch.beans.TransactionCompte;
import ma.ensa.tpbatch.dao.CompteRepo;
import ma.ensa.tpbatch.dao.TransactionRepo;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransactionCompteWriter implements ItemWriter<Transaction> {

    @Autowired
    private TransactionRepo transactionRepo;
    @Autowired
    private CompteRepo compteRepo;

    @Override
    public void write(List<? extends Transaction> list) throws Exception {
    for(Transaction transaction:list){
        Compte compte=transaction.getCompte();
        compte.setSolde(compte.getSolde()-transaction.getMontant());
        this.compteRepo.save(transaction.getCompte());
        transaction.setCompte(transaction.getCompte());
        transactionRepo.save(transaction);
    }
        System.out.println("WRRITING DONE");
    }
}
