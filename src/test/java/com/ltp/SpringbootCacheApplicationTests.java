package com.ltp;

import com.ltp.entities.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootCacheApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void contextLoads() {
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        //stringStringValueOperations.set("msg","hello");
        String msg = stringStringValueOperations.get("msg");
        System.out.println(msg);
    }

}
