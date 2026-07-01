package paymentprocessor;

import paymentprocessor.enums.PaymentMethod;
import paymentprocessor.errorhandling.PgRetry;

public class PaymentClient {


    @CircuitBreaker() //there would be another aspect for this
    @PgRetry()
    public boolean makePayment(String userId, Double amount, PaymentMethod method) {
        //this call is stubbed
        //if call is successful
        //return true
        //if call fails even after retry
        //throw exception
    }
}
