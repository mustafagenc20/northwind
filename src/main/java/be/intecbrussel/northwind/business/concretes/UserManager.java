package be.intecbrussel.northwind.business.concretes;

import be.intecbrussel.northwind.business.abstacts.UserService;
import be.intecbrussel.northwind.core.dataAccess.UserDao;
import be.intecbrussel.northwind.core.entities.User;
import be.intecbrussel.northwind.core.utilities.results.DataResult;
import be.intecbrussel.northwind.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;

public class UserManager implements UserService {

    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Result add(User user) {
        return null;
    }

    @Override
    public DataResult<User> findByEmail(String productName) {
        return null;
    }
}
