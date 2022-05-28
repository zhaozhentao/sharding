package hi.sharding.algorithm;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;

@Component
public class DateShardingAlgorithm implements PreciseShardingAlgorithm<Long>, RangeShardingAlgorithm<Long> {

    public static Integer interval;

    @Value("${spring.shardingsphere.sharding.tables.user.interval}")
    public void setInterval(Integer interval) {
        DateShardingAlgorithm.interval = interval;
    }

    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
        System.out.println("这里啦 " + interval);
        System.out.println(availableTargetNames);
        System.out.println("shardingValue");
        System.out.println(shardingValue);
        return "user12";
    }

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<Long> shardingValue) {
        return Collections.singleton("user12");
    }
}
