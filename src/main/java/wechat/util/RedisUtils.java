package wechat.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/** redis缓存操作工具类
 * className: RedisUtils
 * author: peishuai.li
 * dateTime: 2019/5/20 16:32
 * version: 1.0
 */
@Component
public class RedisUtils {

    @Resource
    private RedisTemplate redisTemplate;

    private static RedisUtils redisUtils;

    @PostConstruct
    public void init() {
        redisUtils = this;
        this.redisTemplate.setKeySerializer(new StringRedisSerializer());
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        this.redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisUtils.redisTemplate = this.redisTemplate;
    }

    /**
     * 设置缓存
     * @param key 键
     * @param value 值
     * @return
     */
    public static boolean set(String key, Object value) {
        try {
            redisUtils.redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取缓存
     * @param key 键
     * @return 值
     */
    public static Object get(String key) {
        return redisUtils.redisTemplate.opsForValue().get(key);
    }

    /**
     * 获取缓存并转换成对象
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getObj(String key, Class<T> clazz) {
        try {
            String s = JsonUtils.obj2Str(redisUtils.redisTemplate.opsForValue().get(key));
            T t = JsonUtils.str2Obj(s, clazz);
            return t;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 删除一个key
     */
    public void del(String key) {
        redisUtils.redisTemplate.delete(key);
    }

}
