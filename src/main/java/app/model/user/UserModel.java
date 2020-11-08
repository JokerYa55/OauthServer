package app.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author vasil
 */
@Entity
@Data
@Table(name = "t_users")
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String username;
    @Column(name = "first_name")
    @JsonProperty("first_name")
    String firstName;
    @Column(name = "last_name")
    @JsonProperty("last_name")
    String lastName;
    @Column(name = "email")
    @JsonProperty("email")
    String email;
    @Column(name = "password_hash")
    @JsonProperty("password")
    String password;
    @JsonProperty("salt")
    String salt;

    public UserModel(Long id, String username, String email, String password, String salt) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.salt = salt;
    }

}
