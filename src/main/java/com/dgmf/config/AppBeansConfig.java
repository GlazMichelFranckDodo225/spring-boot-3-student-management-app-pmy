package com.dgmf.config;

import com.dgmf.entity.Payment;
import com.dgmf.entity.Student;
import com.dgmf.repository.PaymentRepository;
import com.dgmf.repository.StudentRepository;
import com.dgmf.utils.PaymentType;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

@Configuration
public class AppBeansConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            StudentRepository studentRepository,
            PaymentRepository paymentRepository
    ) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                studentRepository.save(
                        Student.builder()
                                .id(UUID.randomUUID().toString())
                                .firstName("John")
                                .lastName("Doe")
                                .studentCode("112233")
                                .build()
                );
                studentRepository.save(
                        Student.builder()
                                .id(UUID.randomUUID().toString())
                                .firstName("Malone")
                                .lastName("Donovan")
                                .studentCode("112244")
                                .build()
                );
                studentRepository.save(
                        Student.builder()
                                .id(UUID.randomUUID().toString())
                                .firstName("Rebecca")
                                .lastName("Hammond")
                                .studentCode("112255")
                                .build()
                );

                PaymentType[] paymentTypes = PaymentType.values();
                Random random = new Random();

                studentRepository.findAll().forEach(student -> {
                    for(int i = 0; i < 10; i++) {
                        int index = random.nextInt(paymentTypes.length);

                        Payment payment = Payment.builder()
                                .amount(1000 + (int)(Math.random() * 10000))
                                .date(LocalDate.now())
                                .paymentType(paymentTypes[index])
                                .paymentReceipt(UUID.randomUUID().toString())
                                .student(student)
                                .build();

                        paymentRepository.save(payment);
                    }
                });
            }
        };

    }
}
