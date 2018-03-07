package cn.test.redis;

import com.iris.redis.RedisPool;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Created by jiangcaijun on 2017/5/23.
 */
public class redisTest {

    private static final Logger LOG = Logger.getLogger(redisTest.class);

    private RedisPool redisUtil;

    @Test
    public void queryByRedis() {
        String key = "redis";
        // 1.从缓存中命中
        try {
            String redisJson = redisUtil.get(key);
            if (StringUtils.isNotBlank(redisJson)) {
                LOG.info("从缓存中命中");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 2.如果没被命中，执行原有逻辑，从数据库中获取数据
        // 未实现，从数据库中获取数据
        LOG.info("没被命中");
        String json = "getFromDB()";

        // 3.将查询出来的结果加入缓存
        try {
            this.redisUtil.set(key, json);
            this.redisUtil.expire(key, 60 * 60 * 24);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
