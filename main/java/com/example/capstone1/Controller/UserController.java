package com.example.capstone1.Controller;


import com.example.capstone1.Model.User;
import com.example.capstone1.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getUsers(){
        List<User> users = userService.getUsers();
        return ResponseEntity.status(200).body(users);
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user, Errors errors){
        if(errors.hasErrors()){
            String errorMessage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(errorMessage);
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body("user added");
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity updateUser(@PathVariable Integer userId, @Valid @RequestBody User user, Errors errors){
        if(errors.hasErrors()){
            String errorMessage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(errorMessage);
        }
        boolean isUpdated = userService.updateUser(userId, user);
       if(isUpdated){
           return ResponseEntity.status(200).body("user updated");
       }
       return ResponseEntity.status(404).body("User with id " + userId + " not found");
    }

    @DeleteMapping("/delete/id")
    public ResponseEntity deleteUser(@PathVariable int id){
        boolean isDeleted = userService.deleteUser(id);
        if(isDeleted){
            return ResponseEntity.status(200).body("user deleted");
        }
        return ResponseEntity.status(404).body("User with id " + id + " not found");
    }

    @PutMapping("/cart/{userId}/{productId}")
    public ResponseEntity addToShoppingCart(@PathVariable Integer userId, @PathVariable Integer productId){
        userService.addToShoppingCart(userId, productId);
        return ResponseEntity.status(200).body("product added to shopping cart");
    }

    @DeleteMapping("/cart/delete/{userId}/{productId}")
    public ResponseEntity removeFromShoppingCart(@PathVariable Integer userId, @PathVariable Integer productId) {
         userService.removeFromShoppingCart(userId, productId);
         return ResponseEntity.status(200).body("product removed from shopping cart");
    }

    @GetMapping("/discount/{userId}")
    public ResponseEntity getStudentDiscount(@PathVariable Integer userId) {
         userService.getStudentDiscount(userId);
         return ResponseEntity.status(200).body("student discount");
    }

    @PutMapping("/buy/{userId}/{merchantId}/{productId}")
    public ResponseEntity buyProduct(@PathVariable Integer userId,
                                             @PathVariable Integer productId,
                                             @PathVariable Integer merchantId) {
        userService.buyProduct(userId, productId, merchantId);
        return ResponseEntity.status(200).body("purchased product " + productId + " for user " + userId);
    }
}
