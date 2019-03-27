import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class CacheTest {

    public static void main(String[] args) {

        // 1. 创建缓存管理器
        CacheManager cacheManager = CacheManager.create("/Users/zhangxi/MS_SYSTEM/EhCacheTest/src/main/resources/ehcache.xml");

        // 2. 获取缓存对象
        Cache cache = cacheManager.getCache("HelloWorldCache");

        // 3. 创建元素
        Element element = new Element("key1", "value1");

        // 4. 将元素添加到缓存
        cache.put(element);

        // 5. 获取缓存
        Element value = cache.get("key1");
        System.out.println(value);
        System.out.println(value.getObjectValue());

        // 6. 删除元素
        cache.remove("key1");

        Person person = new Person();
        person.setId(1);
        person.setName("xiaobai");
        
//        /**
//         * 测试没有进行缓存的时候，是否可以取到值
//         */
//        Element testvalue = cache.get("person1");
//        Person testperson1 =  (Person) testvalue.getObjectValue();
//        System.out.println(testperson1);
       
        
        // 3. 创建元素
        Element element1 = new Element("person1", person);
        cache.put(element1);
        
        Element value1 = cache.get("person1");
        Person person1 =  (Person) value1.getObjectValue();

        System.out.println(value1);
        System.out.println(person1);
        
        // 7. 刷新缓存
        cache.flush();

        // 8. 关闭缓存管理器
        cacheManager.shutdown();
    }
}
