package br.ueg.ProgWeb1.AppControleFinanceiro.controller;

import br.ueg.ProgWeb1.AppControleFinanceiro.dto.TransactionDTO;
import br.ueg.ProgWeb1.AppControleFinanceiro.model.Transaction;
import br.ueg.ProgWeb1.AppControleFinanceiro.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/transaction")
@RestController
public class TransactionController {

    @Autowired
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Transaction> create(@RequestBody TransactionDTO TransactionDTO){
        Transaction transaction = DtoToModel(TransactionDTO);
        return ResponseEntity.ok(transactionService.Create(transaction));
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.ListAll();
    }

    @GetMapping(path = "/{id}")
    public Transaction getById(@PathVariable Long id) {
        return this.transactionService.GetById(id);
    }

    @GetMapping(path = "/{id}/delete")
    public Transaction DeleteById(@PathVariable Long id) {
        return this.transactionService.Delete(id);
    }

    private Transaction DtoToModel(TransactionDTO Dto) {
        Transaction transaction = new Transaction();
        transaction.setDescription(Dto.getDescription());
        transaction.setValue(Dto.getValue());
        transaction.setCategory(Dto.getCategory());
        transaction.setStatus(Dto.getStatus());
        transaction.setType(Dto.getType());
        transaction.setDateTransaction(Dto.getDateTransaction());
        return transaction;
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<Transaction> update(@PathVariable Long id, @RequestBody TransactionDTO TransactionDto) {
        Transaction transaction = DtoToModel(TransactionDto);
        Transaction updated = transactionService.Update(id, transaction);
        return ResponseEntity.ok(updated);
    }
}
