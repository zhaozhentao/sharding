package hi.sharding.algorithm;

import cn.hutool.core.date.DateUtil;
import hi.Application;
import hi.mapper.UserMapper;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.sql.Timestamp;
import java.util.*;

public class DateShardingAlgorithm implements PreciseShardingAlgorithm<Long>, RangeShardingAlgorithm<String> {

    public static Integer interval;

    public static Set<String> tables;

    private static synchronized void createTable(String tableName) {
        try {
            Application.context.getBean(UserMapper.class).createTable(tableName);
            tables.add(tableName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
        String value = shardingValue.getValue() + "";

        Date date = DateUtil.parse(value, "yyyy-MM-dd HH:mm:ss");

        String tableName = "user" + (date.getTime() / (interval * 1000));

        if (!tables.contains(tableName)) createTable(tableName);

        return tableName;
    }

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<String> shardingValue) {
        return Collections.singleton("user12");
    }
}
