package paymentprocessor.model;

import paymentprocessor.enums.PaymentMethod;
import paymentprocessor.enums.PaymentStatus;

public class Payment {
    String userId;
    Double amount;
    PaymentMethod method;
    PaymentStatus paymentStatus = PaymentStatus.IN_PROCESS;

    public static Payment buildPayment(String userId, Double amount, PaymentMethod method) {
        Payment payment = new Payment();
        payment.userId = userId;
        payment.amount = payment.amount;
        payment.method = method;
        return payment
    }
}
