package hi.mapper;


import org.apache.ibatis.annotations.Mapper;
import hi.entity.User;

import java.util.List;

/**
 * @Description: 用户mapper
 *
 * @author xub
 * @date 2019/10/10 下午8:52
 */
@Mapper
public interface UserMapper {

    /**
     * 批量插入
     *
     * @param list 插入集合
     * @return 插入数量
     */
    int insertForeach(List<User> list);

    /**
     * 获取所有用户
     */
    List<User> selectAll();

    /**
     * 插入一条记录
     *
     * @param record 实体对象
     * @return 更新条目数
     */
    int insert(User record);

}
