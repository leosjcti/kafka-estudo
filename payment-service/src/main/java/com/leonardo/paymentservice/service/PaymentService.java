package com.leonardo.paymentservice.service;

import com.leonardo.paymentservice.model.Payment;

public interface PaymentService {

    void sendPayment(Payment payment);
}
