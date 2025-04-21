package br.ueg.ProgWeb1.AppControleFinanceiro.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TransactionDTO {
    private String Description;
    private Double Value;
    private String Category;
    private String Status;
    private Boolean Type;
    private LocalDate DateTransaction;
}
