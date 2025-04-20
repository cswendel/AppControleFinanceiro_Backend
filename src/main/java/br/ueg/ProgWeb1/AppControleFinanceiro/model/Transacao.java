package br.ueg.ProgWeb1.AppControleFinanceiro.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private Double Valor;

    @Column(nullable = false)
    private boolean Tipo; //Entrada=1 Saída=0

    @Column(nullable = false)
    private String Descricao;

    @Column(nullable = false)
    private String Categoria;

    @Column(nullable = false)
    private LocalDate Data;

    @Column(nullable = false)
    private String Status;
}
