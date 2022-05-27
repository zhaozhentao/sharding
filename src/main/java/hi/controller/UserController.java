package hi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import hi.entity.User;
import hi.service.UserServiceImpl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Resource
    private UserServiceImpl userService;

    List<User> userList = new ArrayList<>();

    @PostConstruct
    private void getData() {
        userList.add(new User(1L, "小小", "女", 3));
        userList.add(new User(2L, "爸爸", "男", 30));
        userList.add(new User(3L, "妈妈", "女", 28));
        userList.add(new User(4L, "爷爷", "男", 64));
        userList.add(new User(5L, "奶奶", "女", 62));
    }

    @GetMapping("save-user")
    public Object saveUser() {
        return userService.insertForeach(userList);
    }

    @GetMapping("list-user")
    public Object listUser() {
        return userService.list();
    }
}
