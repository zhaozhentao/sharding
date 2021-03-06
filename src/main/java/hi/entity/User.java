package hi.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class User extends Model<User> {

    private Long id;

    private String name;

    private Date createdAt;

    public User(String name, Date date) {
        this.name = name;
        this.createdAt = date;
    }
}
