package hi.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
public class User extends Model<User> {
    private Long id;

    private String name;

    private Date createdAt;

    public User(String name) {
        this.name = name;
        this.createdAt = new Date();
    }
}
