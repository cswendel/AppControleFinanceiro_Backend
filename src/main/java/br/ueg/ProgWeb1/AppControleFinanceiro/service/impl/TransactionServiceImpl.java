package br.ueg.ProgWeb1.AppControleFinanceiro.service.impl;

import br.ueg.ProgWeb1.AppControleFinanceiro.model.Transaction;
import br.ueg.ProgWeb1.AppControleFinanceiro.repository.TransactionRepository;
import br.ueg.ProgWeb1.AppControleFinanceiro.service.TransactionService;
import br.ueg.ProgWeb1.AppControleFinanceiro.service.exceptions.BusinessException;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository TransactionRepository;

    @Override
    public Transaction Create(Transaction transaction) {
        Validations(transaction);
        PrepareToCreate(transaction);
        return TransactionRepository.save(transaction);
    }

    private void Validations(Transaction transaction) {
        if(transaction.getValue() == null || transaction.getValue() == 0.0) {
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

    private void PrepareToCreate (Transaction transaction) {
        transaction.setDateCreate(LocalDateTime.now());

        if (!transaction.isType()) {
            transaction.setValue(-transaction.getValue());
        }
    }

    //Abaixo ainda será implementado, apenas ar
    @Override
    public List<Transaction> ListAll(){
        return TransactionRepository.findAll();
    }

    @Override
    public Transaction GetById(Long Id) {
        return TransactionRepository.findById(Id)
                .orElseThrow(() -> new BusinessException("Transação não encontrada", 404));
    }

    @Override
    public Transaction Update(Long Id, Transaction TransactionUpdate){
        Transaction CurrentTransaction = TransactionRepository.findById(Id)
                .orElseThrow(() -> new BusinessException("Transação não encontrada", 404));

        Validations(TransactionUpdate);
        PrepareUpdate(CurrentTransaction, TransactionUpdate);
        CurrentTransaction.setDescription(TransactionUpdate.getDescription());
        CurrentTransaction.setStatus(TransactionUpdate.getStatus());
        CurrentTransaction.setCategory(TransactionUpdate.getCategory());
        CurrentTransaction.setDateTransaction(TransactionUpdate.getDateTransaction());
        return TransactionRepository.save(CurrentTransaction);
    }

    private static void PrepareUpdate (Transaction CurrentTransaction, Transaction TransactionUpdate) {
        CurrentTransaction.setDateUpdate(LocalDateTime.now());

        if(TransactionUpdate.isType()){
            CurrentTransaction.setValue(TransactionUpdate.getValue());
        } else {
            CurrentTransaction.setValue(-TransactionUpdate.getValue());
        }
    }

    @Override
    public Transaction Delete(Long Id){
        Transaction transaction = this.GetById(Id);

        try {
            TransactionRepository.delete(transaction);
        }catch (DataIntegrityViolationException e){
            throw new BusinessException("Não pode ser removido por questões de integridade");
        }

        return transaction;
    }

}
