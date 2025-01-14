package main.java.com.jonah.vttp5_paf_day5lpm.config;

import java.beans.BeanProperty;

@Configuration
public class RedisConfig {

    @Value("${spring.data.redis.host}")
    private String redisHost;

    @Value("${spring.data.redis.port}")
    private int redisPort;

    @Value("${spring.data.redis.username}")
    private String redisUserName;

    @Value("${spring.data.redis.password}")
    private String redisPassword;

    @Autowired
    SubscriberService subscriberService;

    public RedisConnectionFactory createConnectionFactory(){
        final RedisStandaloneConfiguration config = new RedisStandaloneConfiguration(redisHost, redisPort);
        config.setDatabase(0);

        if(!redisUserName.equals("") && redisPassword.equals("")){
            config.setUsername(redisUserName);
            congig.setPassword(redisPassword);
        }

        final JedisClientConfiguration jedisClient = JedisClientConfiguration.builder().build();
        JedisConnectionFactory JedisConnectionFactory = new JedisConnectionFactory(config, jedisClient);
        JedisConnectionFactory.afterPropertiesSet();
        return JedisConnectionFactory;
    }


    @Bean("myredis")
    public RedisTemplate<String,String> redisTemplate(){
        RedisConnectionFactory redisConnectionFactory = createConnectionFactory();
        RedisTemplate<String,String> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new StringRedisSerializer());
        
        return redisTemplate;
    }

    

    @Bean
    public RedisMessageListenerContainer createMessageListenerContainer(){
        RedisConnectionFactory redisConnectionFactory = createConnectionFactory();
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory);

        return container;

    }
    
}
