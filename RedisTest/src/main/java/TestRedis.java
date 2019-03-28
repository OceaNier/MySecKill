import java.util.ArrayList;  
import java.util.HashMap;  
import java.util.List;  
import java.util.Map;  
  
  
import org.springframework.context.ApplicationContext;  
import org.springframework.context.support.ClassPathXmlApplicationContext;  
  
  
 
  
  
public class TestRedis {  
      
    public static void main(String[] args) throws Exception {  
        @SuppressWarnings("resource")  
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:applicationContext-redis.xml");  
        RedisUtil redisUtil=(RedisUtil) context.getBean("redisUtil");  
          
        //=====================testString======================  
        redisUtil.set("name", "С��");  
        redisUtil.set("age", 26);  
        redisUtil.set("address", "�ӱ�����");  
          
        //System.out.println(redisUtil.set("address", "�ӱ�����", 50));  
        
        System.out.println(redisUtil.get("age"));  
          
        User user = new User("xiaobai", 56, "�Ϻ�", null,null);
        redisUtil.set("user", user);
        //redisUtil.set("age", 1000);  
          
        Object object = redisUtil.get("user");  
          
        System.out.println(object);  
          
        //redisUtil.del("address");  
        //redisUtil.set("class", 15);  
        //long incr = redisUtil.incr("a", 1);  
        //System.out.println(incr);  
          
        //Thread.sleep(5000);  
        /*Map<String,Object> map=new HashMap<>(); 
        map.put("name", "С��"); 
        map.put("age", 24); 
        map.put("address", "�ӱ�����666"); 
        redisUtil.hmset("15532002725", map,1000);*/  
          
        //redisUtil.del("15532002725");  
        //redisUtil.hset("15532002725","address","�ӱ�����",1000);  
        //redisUtil.hdel("15532002725", "name");  
        //System.out.println(redisUtil.sSetAndTime("15532002727",1000,"haha"));  
        //System.out.println(redisUtil.sGet("15532002727"));  
        //System.out.println(redisUtil.sHasKey("15532002727","name"));  
//        System.out.println(redisUtil.lRemove("15532002728",1,2));  
//        System.out.println(redisUtil.lGet("15532002728",0,-1));  
//        System.out.println(redisUtil.lGetListSize("15532002728"));  
//        System.out.println(redisUtil.lGetIndex("15532002728",1));  
          
          
        //System.out.println(redisUtil.getExpire("15532002725"));  
          
        //System.out.println(redisUtil.hget("15532002725","name"));  
        //System.out.println(redisUtil.hmget("15532002725"));  
          
    }  
      
      
      
}  
class User{  
    private String name;  
    private Integer age;  
    private String address;  
    private Double classz;  
    private Float classz2;  
    public User() {  
        super();  
    }  
    public User(String name, Integer age, String address, Double classz,  
            Float classz2) {  
        super();  
        this.name = name;  
        this.age = age;  
        this.address = address;  
        this.classz = classz;  
        this.classz2 = classz2;  
    }  
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
    public Integer getAge() {  
        return age;  
    }  
    public void setAge(Integer age) {  
        this.age = age;  
    }  
    public String getAddress() {  
        return address;  
    }  
    public void setAddress(String address) {  
        this.address = address;  
    }  
    public Double getClassz() {  
        return classz;  
    }  
    public void setClassz(Double classz) {  
        this.classz = classz;  
    }  
    public Float getClassz2() {  
        return classz2;  
    }  
    public void setClassz2(Float classz2) {  
        this.classz2 = classz2;  
    }
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", address=" + address + ", classz=" + classz + ", classz2="
				+ classz2 + "]";
	}  
    
    
}
