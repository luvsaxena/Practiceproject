package paymentprocessor.service;

import paymentprocessor.enums.RequestStatus;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class IdempotencyService {

    private final Map<String, RequestStatus> requestIdStatusMap = new ConcurrentHashMap<>();

    public void addRequest(String requestUniqueId){
        requestIdStatusMap.put(requestUniqueId,RequestStatus.IN_PROCESS);
    }

    public boolean isDuplicate(String requestUniqueId){
        return requestIdStatusMap.containsKey(requestUniqueId) && requestIdStatusMap.get(requestUniqueId).equals(RequestStatus.PROCESSED);
    }
}
