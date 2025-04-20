package br.ueg.ProgWeb1.AppControleFinanceiro.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transacao {
    private Long Id;
    private Double Valor;
    private boolean Tipo; //Entrada=1 Saída=0
    private String Descricao;
    private String Categoria;
    private LocalDate Data;
    private String Status;
}
