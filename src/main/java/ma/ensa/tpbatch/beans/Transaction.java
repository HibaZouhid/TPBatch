package ma.ensa.tpbatch.beans;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Transaction {
    @Id
    private int idTransaction;
    private double montant;
    private Date dateTransaction;
    private Date dateDebit;
    @Transient
    private String strTransactionDate;
    @ManyToOne
    private Compte compte;

    public Transaction(TransactionCompte transactionClient) {
        this.idTransaction = transactionClient.getIdTransaction();
        this.montant = transactionClient.getMontant();
        this.dateTransaction = transactionClient.getDateTransaction();
        this.dateDebit =new Date();

    }


}
