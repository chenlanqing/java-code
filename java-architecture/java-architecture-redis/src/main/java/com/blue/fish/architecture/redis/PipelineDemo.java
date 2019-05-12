package com.blue.fish.architecture.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

/**
 * @author bluefish 2019-05-09
 * @version 1.0.0
 */
public class PipelineDemo {

    private static int command_num = 10000;

    private static String redis_host = "127.0.0.1";

    public static void main(String[] args) {
        Jedis jedis = new Jedis(redis_host, 6379);

        withoutPipeline(jedis);

        withPipeline(jedis);
    }

    private static void withPipeline(Jedis jedis) {
        Pipeline pipelined = jedis.pipelined();
        long start = System.currentTimeMillis();
        for (int i = 0; i < command_num; i++) {
            pipelined.set("pipe_" + String.valueOf(i), String.valueOf(i));
        }
        pipelined.sync();

        System.out.println("withPipeline cost: " + (System.currentTimeMillis() - start) + "ms");
    }

    private static void withoutPipeline(Jedis jedis) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < command_num; i++) {
            jedis.set("no_pipe_" + String.valueOf(i), String.valueOf(i));
        }

        System.out.println("withoutPipeline cost: " + (System.currentTimeMillis() - start) + "ms");
    }

}
