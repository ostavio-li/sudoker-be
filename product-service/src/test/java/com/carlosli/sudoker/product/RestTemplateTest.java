package com.carlosli.sudoker.product;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

/**
 * @author lijiancheng
 * @date 2021/8/11
 */

@SpringBootTest
public class RestTemplateTest {



    @Test
    public void test() {
        new RestTemplate().getForObject(
                "http://127.0.0.1:8101/test",
                Void.class
        );
    }

}
