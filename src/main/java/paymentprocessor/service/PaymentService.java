package paymentprocessor.service;

import paymentprocessor.enums.PaymentMethod;
import paymentprocessor.model.Payment;

import java.util.HashMap;
import java.util.Map;

public class PaymentService {

    //there would be a payment repository here
    Map<String, Payment> userPayments = new HashMap<>();

    public Payment createPayment(String userId, Double amount, PaymentMethod method){
        Payment payment = Payment.buildPayment(userId,amount,method);
        userPayments.put(userId,payment);
        return payment;
    }
}
