package br.ueg.ProgWeb1.AppControleFinanceiro.service;

import br.ueg.ProgWeb1.AppControleFinanceiro.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransactionService {
    Transaction Create(Transaction transaction);
    List<Transaction> ListAll();
    Transaction GetById(Long id);
    Transaction Update(Transaction transaction);
    void Delete(Transaction transaction);
}
