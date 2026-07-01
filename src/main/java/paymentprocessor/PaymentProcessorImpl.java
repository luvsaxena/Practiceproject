package paymentprocessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import paymentprocessor.enums.PaymentMethod;
import paymentprocessor.service.ExternalPaymentGatewayService;
import paymentprocessor.service.IdempotencyService;
import paymentprocessor.service.PaymentService;

public class PaymentProcessorImpl implements IPaymentProcessor {

    private IdempotencyService idempotencyService;
    private PaymentService paymentService;
    private ExternalPaymentGatewayService externalPaymentGatewayService;
    private final Logger logger = LoggerFactory.getLogger(PaymentProcessorImpl.class);

    @Override
    public void processPayment(String userId, Double amount, PaymentMethod method, String requestUniqueId) {

        if(idempotencyService.isDuplicate(requestUniqueId)) {
            logger.error("Duplicate request for userId: {}, amount: {}, method: {}, requestUniqueId: {}", userId, amount, method, requestUniqueId);
            return;
        }

        logger.info("Processing payment for userId: {}, amount: {}, method: {}, requestUniqueId: {}", userId, amount, method, requestUniqueId);
        idempotencyService.addRequest(requestUniqueId);

        paymentService.createPayment(userId,amount,method);

        externalPaymentGatewayService.processPayment(userId,amount,method);

    }
}
