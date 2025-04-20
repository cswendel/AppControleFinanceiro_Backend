package br.ueg.ProgWeb1.AppControleFinanceiro.controller;

import br.ueg.ProgWeb1.AppControleFinanceiro.model.Transacao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "/transacao")
@Controller
public class TransacaoController {

    private Transacao transacao;
}
