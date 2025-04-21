package br.ueg.ProgWeb1.AppControleFinanceiro.service.impl;

import br.ueg.ProgWeb1.AppControleFinanceiro.repository.TransactionRepository;
import br.ueg.ProgWeb1.AppControleFinanceiro.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository TransactionRepository;
}
