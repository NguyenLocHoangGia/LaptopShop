package vn.Laptopshop.laptopshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.Laptopshop.laptopshop.domain.Role;
import vn.Laptopshop.laptopshop.domain.User;
import vn.Laptopshop.laptopshop.repository.RoleRepository;
import vn.Laptopshop.laptopshop.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public List<User> getAllUsersbyEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    public User handleSaveUser(User user) {
        return this.userRepository.save(user);
    }

    public User findUserById(long id) {
        return this.userRepository.findById(id);
    }

    public void deleteById(long id) {
        this.userRepository.deleteById(id);
    }

    public Role getRoleName(String name) {
        return this.roleRepository.findByName(name);
    }
}
