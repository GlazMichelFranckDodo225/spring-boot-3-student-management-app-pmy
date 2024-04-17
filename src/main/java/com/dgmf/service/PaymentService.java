package com.dgmf.service;

import com.dgmf.entity.Payment;

import java.util.List;

public interface PaymentService {
    List<Payment> getAllPayments();
    Payment getPaymentById(String paymentId);
    List<Payment> getPaymentsByStudentCode(String studentCode);
}
