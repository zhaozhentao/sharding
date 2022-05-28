package hi.mapper;

import hi.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    int insertForeach(List<User> list);

    List<User> selectAll();

    int insert(User record);
}
