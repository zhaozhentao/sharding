package hi;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.alibaba.druid.spring.boot.autoconfigure.properties.DruidStatProperties;
import com.alibaba.druid.spring.boot.autoconfigure.stat.DruidFilterConfiguration;
import com.alibaba.druid.spring.boot.autoconfigure.stat.DruidStatViewServletConfiguration;
import hi.mapper.UserMapper;
import hi.sharding.algorithm.DateShardingAlgorithm;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Import;

@EnableConfigurationProperties({DruidStatProperties.class})
@Import({
    DruidStatViewServletConfiguration.class,
    DruidFilterConfiguration.class
})
@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class})
public class Application implements ApplicationContextAware {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        String key = "spring.shardingsphere.sharding.tables.user.interval";
        DateShardingAlgorithm.interval = context.getEnvironment().getProperty(key, Integer.class, 5000);
        DateShardingAlgorithm.tables = context.getBean(UserMapper.class).loadTables();
    }
}
