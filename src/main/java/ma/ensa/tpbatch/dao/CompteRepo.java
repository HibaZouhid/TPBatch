package ma.ensa.tpbatch.dao;

import ma.ensa.tpbatch.beans.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CompteRepo extends JpaRepository<Compte,Integer> {
    public Compte findByIdCompte(int id);
}
