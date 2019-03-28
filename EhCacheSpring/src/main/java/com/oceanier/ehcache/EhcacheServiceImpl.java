package com.oceanier.ehcache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EhcacheServiceImpl implements EhcacheService {

    //value的值和ehcache.xml中的配置保持一致
    @Cacheable(value = "HelloWorldCache", key = "#param")
    public String getTimestamp(String param) {
        Long timestamp = System.currentTimeMillis();
        return timestamp.toString();
    }

    @Cacheable(value = "HelloWorldCache", key = "#key")
    public String getDataFromDB(String key) {
        System.out.println("从数据库中获取数据...");
        return key + ":" + String.valueOf(Math.round(Math.random() * 1000000));
    }

    @CacheEvict(value = "HelloWorldCache", key = "#key")
    public void removeDataAtDB(String key) {
        System.out.println("从数据库中删除数据");
    }

    @CachePut(value = "HelloWorldCache", key = "#key")
    public String refreshData(String key) {
        System.out.println("模拟从数据库中加载数据");
        return key + "::" + String.valueOf(Math.round(Math.random() * 1000000));
    }

    // ------------------------------------------------------------------------
    @Cacheable(value = "UserCache", key = "'user:' + #userId")
    public User findById(String userId) {
        System.out.println("模拟从数据库中查询数据");
        return (User) new User(1, "zx");
    }

    //condition过滤条件 只缓存满足condition条件的数据
    @Cacheable(value = "UserCache", condition = "#userId.length()<5")
    public boolean isReserved(String userId) {
        System.out.println("UserCache:" + userId);
        return false;
    }

    //清除掉UserCache中某个指定key的缓存    
    @CacheEvict(value = "UserCache", key = "'user:' + #userId")
    public void removeUser(String userId) {
        System.out.println("UserCache remove:" + userId);
    }

    //清除掉UserCache中全部的缓存    
    @CacheEvict(value = "UserCache", allEntries = true)
    public void removeAllUser() {
        System.out.println("UserCache delete all");
    }
}
