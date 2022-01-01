package be.intecbrussel.northwind.business.concretes;

import be.intecbrussel.northwind.business.abstacts.UserService;
import be.intecbrussel.northwind.core.dataAccess.UserDao;
import be.intecbrussel.northwind.core.entities.User;
import be.intecbrussel.northwind.core.utilities.results.DataResult;
import be.intecbrussel.northwind.core.utilities.results.Result;
import be.intecbrussel.northwind.core.utilities.results.SuccessDataResult;
import be.intecbrussel.northwind.core.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {

    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Result add(User user) {
        this.userDao.save(user);
        return new SuccessResult("User added");
    }

    @Override
    public DataResult<User> findByEmail(String email) {
        return new SuccessDataResult<User>(this.userDao.findByEmail(email), "User found");
    }
}
