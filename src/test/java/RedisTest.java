import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * @author: Robben.Hu
 * @Description:
 * @Date: Created in 2017-11-17 20:51
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-redis.xml")
public class RedisTest {
    @Autowired
    ShardedJedisPool ShardedJedisPool;
    @Test
    public void redisConnTest(){
        ShardedJedis resource = ShardedJedisPool.getResource();
        resource.set("hufan1","11111");
        resource.set("hufan2","1112111");
        resource.set("hufan3","11123111");
        resource.set("hufan4","11111321");
        resource.set("hufan5","11132123111");
    }
}
