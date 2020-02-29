package com.blue.fish.limite;

import com.google.common.util.concurrent.RateLimiter;
import org.junit.Test;

/**
 * @author bluefish 2020-02-20
 * @version 1.0.0
 */
public class GuavaLimiterTest {

    @Test
    public void testSmoothBursty() {
        RateLimiter r = RateLimiter.create(5);
        while (true) {
            System.out.println("get 1 tokens: " + r.acquire() + "s");
        }
        /**
         * output: 基本上都是0.2s执行一次，符合一秒发放5个令牌的设定。
         * get 1 tokens: 0.0s
         * get 1 tokens: 0.182014s
         * get 1 tokens: 0.188464s
         * get 1 tokens: 0.198072s
         * get 1 tokens: 0.196048s
         * get 1 tokens: 0.197538s
         * get 1 tokens: 0.196049s
         */
    }


    @Test
    public void testSmoothBursty3() {
        RateLimiter r = RateLimiter.create(5);
        while (true)
        {
            System.out.println("get 5 tokens: " + r.acquire(5) + "s");
            System.out.println("get 1 tokens: " + r.acquire(1) + "s");
            System.out.println("get 1 tokens: " + r.acquire(1) + "s");
            System.out.println("get 1 tokens: " + r.acquire(1) + "s");
            System.out.println("end");
            /**
             * output:
             * get 5 tokens: 0.0s
             * get 1 tokens: 0.996766s 滞后效应，需要替前一个请求进行等待
             * get 1 tokens: 0.194007s
             * get 1 tokens: 0.196267s
             * end
             * get 5 tokens: 0.195756s
             * get 1 tokens: 0.995625s 滞后效应，需要替前一个请求进行等待
             * get 1 tokens: 0.194603s
             * get 1 tokens: 0.196866s
             */
        }
    }
}
