package com.dgmf.repository;

import com.dgmf.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository
        extends JpaRepository<Payment, String> {
    List<Payment> findByStudentCode(String studentCode);
    List<Payment> findByPaymentStatus(String paymentStatus);
}
