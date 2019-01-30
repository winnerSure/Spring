package springboot;

import redis.clients.jedis.Jedis;

public class Test {
    @org.junit.Test
    public void testRedis(){
        Jedis jedis = new Jedis("localhost");
        System.out.println(jedis.ping());
    }
}
