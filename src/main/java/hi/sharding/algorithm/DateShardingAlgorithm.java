package hi.sharding.algorithm;

import cn.hutool.core.date.DateUtil;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class DateShardingAlgorithm implements PreciseShardingAlgorithm<String>, RangeShardingAlgorithm<String> {

    public static Integer interval;

    public static List<String> tables;

    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<String> shardingValue) {
        Date date = DateUtil.parse(shardingValue.getValue(), "yyyy-MM-dd HH:mm:ss");
        long index = date.getTime() / (interval * 24 * 3600);
        System.out.println("index " + index);
        return "user12";
    }

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<String> shardingValue) {
        return Collections.singleton("user12");
    }
}
