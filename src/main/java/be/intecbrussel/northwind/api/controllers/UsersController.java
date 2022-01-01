package be.intecbrussel.northwind.api.controllers;

import be.intecbrussel.northwind.business.abstacts.UserService;
import be.intecbrussel.northwind.core.entities.User;
import be.intecbrussel.northwind.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/users")
public class UsersController {

    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@RequestBody User user){
        return ResponseEntity.ok(this.userService.add(user));
    }
}
