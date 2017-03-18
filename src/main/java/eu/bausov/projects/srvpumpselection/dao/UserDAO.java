package eu.bausov.projects.srvpumpselection.dao;

import eu.bausov.projects.srvpumpselection.bo.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by GreenNun on 18.03.17.
 */
public interface UserDAO extends CrudRepository<User, Long> {
}
