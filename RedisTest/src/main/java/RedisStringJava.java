import redis.clients.jedis.Jedis;
 
public class RedisStringJava {
    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("10.211.55.5");
        //设置 redis 字符串数据
        jedis.set("key02", "banana");
        // 获取存储的数据并输出
        System.out.println("redis 存储的字符串为: "+ jedis.get("key02"));
    }
}
