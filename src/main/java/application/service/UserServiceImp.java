package application.service;

import application.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import application.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImp(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> index() {
        return userDAO.index();
    }

    @Override
    public User show(int id) {
        return userDAO.show(id);
    }

    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    public void update(User updatedUser) {
        userDAO.update(updatedUser);
    }

    @Override
    public void delete(int id) {
        try {
            userDAO.delete(id);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

}
