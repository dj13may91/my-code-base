package dynamic_programming;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cacheable<K, V> {

  private int EXPIRY;
  private int PURGE_CYCLE_DURATION = 60000; //1 min cycle to checking for expired items
  private Map<K, Node<V>> cacheMap = new ConcurrentHashMap<>();

  public Cacheable() {
    EXPIRY = 1800000;  //1 min default for now
    setUpPurging();
  }

  public Cacheable(int ageImMS) {
    this.EXPIRY = ageImMS;
    setUpPurging();
  }

  public V serve(K k) {
    return cacheMap.get(k) == null ? null : cacheMap.get(k).getValue();
  }

  public void put(K k, V v) {
    put(k, v, EXPIRY);
  }

  public void put(K k, V v, int expiryInMS) {
    Node<V> n = new Node<>(v, expiryInMS);
    cacheMap.put(k, n);
  }

  public void clearCache() {
    cacheMap.clear();
  }

  public void remove(K k) {
    cacheMap.remove(k);
  }

  private void setUpPurging() {
    Thread cleanUpCaching = new Thread(
        () -> {
          while (true) {
            try {
              Thread.sleep(PURGE_CYCLE_DURATION);
              for (K key : cacheMap.keySet()) {
                if (cacheMap.get(key).isExpired()) {
                  System.out.println("Purging from cache <k,v>: " + key + "->" + cacheMap.get(key));
                  cacheMap.remove(key);
                }
              }
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
        }
    );
    cleanUpCaching.start();
  }
}

class Node<V> {

  protected final int expireTime;
  private final Date age = new Date();
  private V value;

  Node(V v, int expireTime) {
    this.value = v;
    this.expireTime = expireTime;
  }

  boolean isExpired() {
    return (new Date()).getTime() - age.getTime() > expireTime;
  }

  public V getValue() {
    return value;
  }
}
