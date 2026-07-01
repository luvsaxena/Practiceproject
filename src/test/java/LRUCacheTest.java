import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LRUCacheTest {

    private LRUCache lruCache;
    private static final long DEFAULT_TTL = 10000L;
    Logger logger = LoggerFactory.getLogger(LRUCacheTest.class);

    @BeforeEach
    public void setUp(){
        lruCache = new LRUCache(2);
    }

    @Test
    public void testLRUCache(){

        lruCache.put(1,1, System.currentTimeMillis()+1000L);
        lruCache.put(2,2, System.currentTimeMillis()+1000L);

        logger.info("Value = "+lruCache.get(2));

        lruCache.put(3,3, System.currentTimeMillis()+1000L);
        lruCache.put(4,4, System.currentTimeMillis()+1000L);

        logger.info("Value = "+lruCache.get(3));

    }

    @Test
    public void testLRUCacheWithTtl() throws InterruptedException {

        Long ttl = System.currentTimeMillis() + 1000L;

        lruCache.put(1,1,ttl);
        lruCache.put(2,2,ttl);

        Thread.sleep(2000);

        logger.info("Value = "+lruCache.get(2));

    }
}
