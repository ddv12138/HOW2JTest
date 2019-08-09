package tk.ddvudo.Redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;

import java.util.List;

public class redisHashSet {
    private static String redisServer = "188.131.157.4";
    private static int redisPort = 6379;
    private static String redisAuth = "liukang951006";

    public static void main(String... args) {
        Jedis jedis = new Jedis(redisServer, redisPort);
        jedis.auth(redisAuth);
        ScanResult res = jedis.hscan("Enterprise", "", new ScanParams().match("*上海*").count(jedis.hlen("Enterprise").intValue()));
        String cursor = res.getCursor();
        List res1 = res.getResult();
        System.out.println(1);
    }
}
