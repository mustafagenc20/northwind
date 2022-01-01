package be.intecbrussel.northwind.business.abstacts;

import be.intecbrussel.northwind.core.entities.User;
import be.intecbrussel.northwind.core.utilities.results.DataResult;
import be.intecbrussel.northwind.core.utilities.results.Result;

public interface UserService {

    Result add(User user);
    DataResult<User> findByEmail(String productName);
}
