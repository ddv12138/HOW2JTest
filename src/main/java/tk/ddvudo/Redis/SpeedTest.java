package tk.ddvudo.Redis;

import redis.clients.jedis.Jedis;

public class SpeedTest {
    public static void main(String... args) throws InterruptedException {
        Jedis jedis = new Jedis("188.131.157.4", 6379);
        jedis.auth("liukang951006");

        while (true) {
            Long start = jedis.hlen("Enterprise");
            Thread.sleep(1000);
            Long end = jedis.hlen("Enterprise");
            if (end - start == 0) {
//                System.out.println(end - start + "条/秒，已插入" + end + "条");
                continue;
            }
            System.out.println(end - start + "条/秒，已插入" + end + "条，预计还需要" + 5880000 / ((end - start) * 60) + "分钟");
        }
    }
}
