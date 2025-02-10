import org.junit.Test;
import pers.lilpen.algorithm.codetop.LRUCache;

/**
 * @author : penghuaishun
 * @version : 1.0
 * @date : 2024-10-22 10:57
 **/
public class Test_LRUCache {
    @Test
    public void test_LRUCache() {
        //[[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
        LRUCache lruCache = new LRUCache(2);
        lruCache.get(2);
        lruCache.put(2, 6);
        lruCache.get(1);
        lruCache.put(1, 5);
        lruCache.put(1, 2);
        lruCache.get(1);
        lruCache.get(2);
        int i = lruCache.get(2);
    }
}
