package eu.bausov.projects.srvpumpselection.repository;

import eu.bausov.projects.srvpumpselection.bo.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by GreenNun on 18.03.17.
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
