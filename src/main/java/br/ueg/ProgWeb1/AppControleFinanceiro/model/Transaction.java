package br.ueg.ProgWeb1.AppControleFinanceiro.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private Double Value;

    @Column(nullable = false)
    private Boolean Type; //Entrada=1 Saída=0

    @Column(nullable = false)
    private String Description;

    @Column(nullable = false)
    private String Category;

    @Column(nullable = false)
    private String Status;

    @Column(nullable = false)
    private LocalDate DateTransaction;

    @Column(nullable = false)
    private LocalDateTime DateCreate;

    @Column
    private LocalDateTime DateUpdate;
}
