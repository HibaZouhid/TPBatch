package ma.ensa.tpbatch.batch;

import ma.ensa.tpbatch.beans.Compte;
import ma.ensa.tpbatch.beans.Transaction;
import ma.ensa.tpbatch.beans.TransactionCompte;
import ma.ensa.tpbatch.dao.CompteRepo;
import ma.ensa.tpbatch.dao.TransactionRepo;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.text.SimpleDateFormat;

@Component
public class Processor implements ItemProcessor<TransactionCompte, Transaction> {

    private CompteRepo compteRepo;
    @Autowired TransactionRepo transactionRepo;

    public Processor(CompteRepo compteRepo){
        this.compteRepo=compteRepo;
    }

    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    @Override
    public Transaction process(TransactionCompte transactionCompte) throws Exception {
        System.out.println("process");
        Compte compte= compteRepo.findByIdCompte(transactionCompte.getIdCompte());
        System.out.println(compte.getSolde());
        Transaction transaction=new Transaction(transactionCompte);
        //transaction.setDateTransaction(dateFormat.parse(transaction.getStrTransactionDate()));
        transaction.setCompte(compte);
        return transaction;
    }
}
