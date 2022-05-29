package hi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import hi.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.SortedSet;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    SortedSet<String> loadTables();

    int createTable(@Param("table_name") String tableName);
}
