package eu.bausov.projects.srvpumpselection.service.impl;

import eu.bausov.projects.srvpumpselection.repository.UserRepository;
import eu.bausov.projects.srvpumpselection.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by GreenNun on 21.03.17.
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
