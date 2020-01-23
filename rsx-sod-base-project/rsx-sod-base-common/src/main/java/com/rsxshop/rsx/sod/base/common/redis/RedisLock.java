package com.rsxshop.rsx.sod.base.common.redis;

import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Random;

/**
 * @className: RedisLock.java
 * @author: raysonxin
 * @date: 2020/1/22 11:17 下午
 * @email: raysonxin@163.com
 * @description: TODO
 **/
public class RedisLock {
    private RedisConnectionFactory factory;
    private String lockKey;
    private long expireMilliseconds;
    private boolean locked = false;
    private static final Random random = new Random();

    public RedisLock(RedisConnectionFactory factory, String lockKey, long expireMilliseconds) {
        this.factory = factory;
        this.lockKey = lockKey;
        this.expireMilliseconds = expireMilliseconds;
    }

    /**
     * 申请加锁，最多等待waitTime毫秒。为了防止多个线程同时触发加锁操作，sleep时间进行了随机。
     *
     * @param waitTime 等待时间，单位毫秒
     */
    public boolean lock(long waitTime) throws InterruptedException {
        long timeout = System.currentTimeMillis() + waitTime;
        while (System.currentTimeMillis() <= timeout && !tryLock()) {
            //随机sleep
            Thread.sleep(50 + random.nextInt(10), random.nextInt(500));
        }
        return this.locked;
    }

    private boolean tryLock() {
        RedisConnection connection = this.factory.getConnection();

        try {
            //计算锁过期的时间戳=当前时间戳+占用锁时间戳
            long expireTimestamp = System.currentTimeMillis() + this.expireMilliseconds;
            String expireTimestampStr = String.valueOf(expireTimestamp);

            //进行一次加锁尝试。如果获取成功，则返回。
            boolean done = this.setNX(this.lockKey, expireTimestampStr);
            if (done) {
                this.locked = true;
                return true;
            }

            //第一次加锁失败后，读取当前锁内存储的数据内容
            byte[] bytes = connection.stringCommands().get(this.lockKey.getBytes());
            if (bytes == null || StringUtils.isEmpty(new String(bytes))) {
                //如果为空，说明刚刚的锁过期了，可以再次尝试加锁。
                if (this.setNX(this.lockKey, expireTimestampStr)) {
                    this.locked = true;
                    return true;
                }
                return false;
            }

            //检查已经获取锁的线程是否占用超时，若超时则剥夺锁。
            String oldTimestamp = new String(bytes);
            if (Long.parseLong(oldTimestamp) < System.currentTimeMillis()) {
                //通过getSet加锁，同时返回锁内数据。
                byte[] toCompareBytes = connection.stringCommands().getSet(this.lockKey.getBytes(), expireTimestampStr.getBytes());
                if (toCompareBytes == null) {
                    this.locked = true;
                    return true;
                }

                //检查是否存在同时剥夺锁的情况，防止加锁冲突
                String toCompareStr = new String(toCompareBytes);
                if (toCompareStr.equals(oldTimestamp)) {
                    this.locked = true;
                    return true;
                }
            }
            return false;
        } finally {
            connection.close();
        }
    }

    private boolean setNX(String lockKey, String expireTimestampStr) {
        RedisConnection connection = this.factory.getConnection();
        Boolean result = connection.stringCommands().setNX(lockKey.getBytes(), expireTimestampStr.getBytes());
        return result == null ? false : result;
    }
}
