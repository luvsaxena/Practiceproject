package paymentprocessor;

import paymentprocessor.enums.PaymentMethod;

public interface IPaymentProcessor {

    void processPayment(String userId, Double amount, PaymentMethod method, String requestUniqueId);
}
