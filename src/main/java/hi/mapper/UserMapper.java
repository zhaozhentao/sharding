package hi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import hi.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
