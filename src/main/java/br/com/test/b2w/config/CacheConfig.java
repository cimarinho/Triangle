package br.com.test.b2w.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@Configuration
@Profile("prod")
public class CacheConfig  {

    public static final String CACHE_TRIANGLE = "triangle";

    @Autowired
    RedisTemplate redisTemplate;

    @Primary
    @Bean
    public RedisCacheManager cacheManager() {

        RedisCacheManager cache = new RedisCacheManager(redisTemplate);
        cache.setDefaultExpiration(TimeUnit.DAYS.toSeconds(30L));
        cache.setExpires(new HashMap<String,Long>() {{
            put(CACHE_TRIANGLE, TimeUnit.DAYS.toSeconds(30L));
        }});

        cache.setUsePrefix(true);
        return cache;

    }
    @Bean
    public ConcurrentMapCacheManager memoryCacheManager() {
        return new ConcurrentMapCacheManager();
    }
}

