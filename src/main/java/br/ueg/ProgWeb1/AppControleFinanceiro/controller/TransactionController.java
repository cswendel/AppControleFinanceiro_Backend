package br.ueg.ProgWeb1.AppControleFinanceiro.controller;

import br.ueg.ProgWeb1.AppControleFinanceiro.model.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "/transaction")
@Controller
public class TransactionController {

    private Transaction transaction;
}
