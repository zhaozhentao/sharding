package hi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import hi.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    List<String> loadTables();
}
