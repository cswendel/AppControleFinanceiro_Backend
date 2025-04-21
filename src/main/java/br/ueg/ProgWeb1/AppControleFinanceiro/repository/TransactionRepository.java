package br.ueg.ProgWeb1.AppControleFinanceiro.repository;

import br.ueg.ProgWeb1.AppControleFinanceiro.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
