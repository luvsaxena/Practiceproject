import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LRUCache {

    DoublyLinkedList dLL = new DoublyLinkedList();
    Map<Integer,Node> map = new ConcurrentHashMap<>();
    DataSource dataSource = new DataSource();
    private int capacity;
    private static final Logger logger = LoggerFactory.getLogger(LRUCache.class);
    private static final long DEFAULT_TTL = 10000L;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(Integer key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            if(node.ttlEpoch >= System.currentTimeMillis()) {
                dLL.removeNode(node);
                dLL.addNode(node);
                logger.info("element retrieved from cache: key: {}, value: {}", key, node.value);
                return node.value;
            }
            else{
                //remove from cache
                logger.info("ttl expired, removing from cache: key: {}, value: {}", key, node.value);
                map.remove(key);
                dLL.removeNode(node);
            }
        }

        //get from data source
        int value = dataSource.getValue(key);
        logger.info("element retrieved from datasource: key: {}, value: {}",key, value);

        //add to cache
        if(map.keySet().size() == capacity){
            //remove tail element from cache
            removeTailElementFromCache();
        }
        addNewElementToCache(key,value,System.currentTimeMillis() + DEFAULT_TTL);
        return value;

    }

    public void put(int key, int value, long ttlEpoch) {
        if(map.keySet().size() == capacity){
            //remove from cache
            removeTailElementFromCache();
        }
        addNewElementToCache(key,value,ttlEpoch);
    }

    private void removeTailElementFromCache() {
        Node node = dLL.tail.prev;
        dLL.removeNode(node);
        map.remove(node.key);
    }

    private void addNewElementToCache(int key, int value, long ttlEpoch){
        Node node = new Node(key,value,ttlEpoch);
        map.put(key, node);
        dLL.addNode(node);
        logger.info("new element added to cache: key: {}, value: {}",key, value);
    }


    private static class Node {
        Node prev, next;
        int key,value;
        long ttlEpoch;

        public Node(int key, int value, long ttlEpoch) {
            this.key = key;
            this.value = value;
            this.ttlEpoch = ttlEpoch;
        }
    }

    private static class DoublyLinkedList  {
        Node head;
        Node tail;

        public DoublyLinkedList() {
            head = new Node(0,0,-1);
            tail = new Node(0,0,-1);
            head.next = tail;//dummy node
            tail.prev = head;
        }

//        public void addNode(int key, int value) {
//            Node node = new Node(key, value);
//            addNode(node);
//        }

        public void addNode(Node node) {
            node.next = head.next;
            head.next = node;
            node.prev = head;
            node.next.prev = node;
        }

        public void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public void removeFromTail() {
            Node node = tail.prev;
            removeNode(node);
        }

    }

}
