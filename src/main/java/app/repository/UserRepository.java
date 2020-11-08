package app.repository;

import app.model.user.UserModel;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author vasil
 */
public interface UserRepository extends CrudRepository<UserModel, Long>{
    public UserModel findByUsername(String username);
}
