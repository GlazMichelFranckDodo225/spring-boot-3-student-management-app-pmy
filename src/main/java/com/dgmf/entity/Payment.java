package com.dgmf.entity;

import com.dgmf.utils.PaymentStatus;
import com.dgmf.utils.PaymentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_payments")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private double amount;
    private PaymentType paymentType;
    private PaymentStatus paymentStatus = PaymentStatus.CREATED;
    private String paymentReceipt;
    @ManyToOne
    private Student student;
}
