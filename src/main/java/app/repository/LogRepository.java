package app.repository;

import app.model.user.LoggerItem;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author vasil
 */
public interface LogRepository extends CrudRepository<LoggerItem, Long> {

}
