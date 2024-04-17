package com.dgmf.service.impl;

import com.dgmf.entity.Payment;
import com.dgmf.repository.PaymentRepository;
import com.dgmf.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getPaymentById(String paymentId) {
        return paymentRepository.findById(paymentId).get();
    }

    @Override
    public List<Payment> getPaymentsByStudentCode(String studentCode) {
        return paymentRepository.findByStudentCode(studentCode);
    }
}
