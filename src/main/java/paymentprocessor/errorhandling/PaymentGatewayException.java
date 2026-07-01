package paymentprocessor.errorhandling;

public class PaymentGatewayException extends RuntimeException{
    String message;
    public PaymentGatewayException(String message) {
        super(message);
    }
}
