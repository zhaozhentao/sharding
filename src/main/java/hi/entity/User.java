package hi.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class User extends Model<User> {
    private Long id;

    private String name;

    public User(String name) {
        this.name = name;
    }
}
