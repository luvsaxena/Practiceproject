package paymentprocessor.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import paymentprocessor.PaymentClient;
import paymentprocessor.enums.PaymentMethod;
import paymentprocessor.errorhandling.PaymentGatewayException;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

public class ExternalPaymentGatewayService {

    PaymentClient paymentClient;
    Logger logger = LoggerFactory.getLogger(ExternalPaymentGatewayService.class);

    public void processPayment(String userId, Double amount, PaymentMethod method){
        logger.info("Making call to payment client for userId: {}, amount: {}, method: {}", userId, amount, method);

        try {
            paymentClient.makePayment(userId, amount, method);
            PriorityQueue<Map.Entry<Integer,Integer>> priorityQueue = new PriorityQueue(Map.Entry.comparingByValue());
//            priorityQueue.offer()
            String s;
//            priorityQueue.entr
        }
        catch (Exception e){
            logger.error("Error making payment call", e);
            e.printStackTrace();
            throw new PaymentGatewayException("Error making payment call");
        }

    }



}
