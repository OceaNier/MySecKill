import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class CacheTest {

    public static void main(String[] args) {

        // 1. �������������
        CacheManager cacheManager = CacheManager.create("/Users/zhangxi/MS_SYSTEM/EhCacheTest/src/main/resources/ehcache.xml");

        // 2. ��ȡ�������
        Cache cache = cacheManager.getCache("HelloWorldCache");

        // 3. ����Ԫ��
        Element element = new Element("key1", "value1");

        // 4. ��Ԫ����ӵ�����
        cache.put(element);

        // 5. ��ȡ����
        Element value = cache.get("key1");
        System.out.println(value);
        System.out.println(value.getObjectValue());

        // 6. ɾ��Ԫ��
        cache.remove("key1");

        Person person = new Person();
        person.setId(1);
        person.setName("xiaobai");
        
//        /**
//         * ����û�н��л����ʱ���Ƿ����ȡ��ֵ
//         */
//        Element testvalue = cache.get("person1");
//        Person testperson1 =  (Person) testvalue.getObjectValue();
//        System.out.println(testperson1);
       
        
        // 3. ����Ԫ��
        Element element1 = new Element("person1", person);
        cache.put(element1);
        
        Element value1 = cache.get("person1");
        Person person1 =  (Person) value1.getObjectValue();

        System.out.println(value1);
        System.out.println(person1);
        
        // 7. ˢ�»���
        cache.flush();

        // 8. �رջ��������
        cacheManager.shutdown();
    }
}
