package br.ueg.ProgWeb1.AppControleFinanceiro.service.impl;

import br.ueg.ProgWeb1.AppControleFinanceiro.model.Transaction;
import br.ueg.ProgWeb1.AppControleFinanceiro.repository.TransactionRepository;
import br.ueg.ProgWeb1.AppControleFinanceiro.service.TransactionService;
import br.ueg.ProgWeb1.AppControleFinanceiro.service.exceptions.BusinessException;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository TransactionRepository;

    @Override
    public Transaction Create(Transaction transaction) {
        CreateValidation(transaction);
        PrepareToCreate(transaction);
        return TransactionRepository.save(transaction);
    }

    private void CreateValidation (Transaction transaction) {
        if(transaction.getValue() == null || transaction.getValue() == 0) {
            throw new BusinessException("Valor não pode ser zero ou vazio");
        }

        if(Strings.isEmpty(transaction.getDescription())) {
            throw new BusinessException("Descrição não pode ser vazia!");
        }

        if(Strings.isEmpty((transaction.getCategory()))){
            throw new BusinessException("Categoria não pode ser vazia!");
        }

        if(transaction.getDateTransaction() == null) {
            throw new BusinessException("Data da transação não pode ser vazia!");
        }

        if (Strings.isEmpty(transaction.getStatus())) {
            throw new BusinessException("Status não pode ser vazio!");
        }
    }

    private Transaction PrepareToCreate (Transaction transaction) {
        transaction.setDateCreate(LocalDateTime.now());

        if (!transaction.isType()) {
            transaction.setValue(-transaction.getValue());
        }

        return transaction;
    }

    //Abaixo ainda será implementado, apenas ar
    @Override
    public List<Transaction> ListAll(){
        return null;
    }

    @Override
    public Transaction GetById(Long id){
        return null;
    }

    @Override
    public Transaction Update(Transaction transaction){
        return null;
    }

    @Override
    public void Delete(Transaction transaction){
    }

}
