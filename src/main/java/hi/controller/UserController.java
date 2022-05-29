package hi.controller;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import hi.entity.User;
import hi.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    List<User> userList = new ArrayList<>();

    @PostConstruct
    private void getData() {
        userList.add(new User( "29号", DateUtil.parseDate("2022-05-29 00:00:00")));
        userList.add(new User( "30号", DateUtil.parseDate("2022-05-30 00:00:00")));
        userList.add(new User( "31号", DateUtil.parseDate("2022-05-31 00:00:00")));
    }

    @GetMapping("save-user")
    public Object saveUser() {
        return userService.saveBatch(userList);
    }

    @GetMapping("list-user")
    public Object listUser() {
        return userService.page(
            new Page<>(1, 1),
            new QueryWrapper<User>().lt("created_at", "2022-05-31 00:00:00")
        );
    }
}
