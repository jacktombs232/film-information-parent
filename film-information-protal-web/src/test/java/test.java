import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class test {
    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public  void test() {
        System.out.println(redisTemplate.boundValueOps("email").get());
    }
}
