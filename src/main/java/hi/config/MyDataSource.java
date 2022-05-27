package hi.config;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.SQLException;

public class MyDataSource extends DruidDataSource {

    public MyDataSource() throws SQLException {
        setFilters("stat, wall");
    }
}
