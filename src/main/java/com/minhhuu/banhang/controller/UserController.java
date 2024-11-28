package com.minhhuu.banhang.controller;

import com.minhhuu.banhang.model.LoginRequest;
import com.minhhuu.banhang.model.Message;
import com.minhhuu.banhang.model.Test;
import com.minhhuu.banhang.model.User;
import com.minhhuu.banhang.repo.TestRepo;
import com.minhhuu.banhang.repo.UserRepo;
import com.minhhuu.banhang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/user")

public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/all")
    public ResponseEntity<List<User>>getAll(){
           List<User>u=userService.findAll();
           return new ResponseEntity<>(u,HttpStatus.OK);
    }
    @PostMapping("/login")
    public  ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        User u= userService.findByAccountname(loginRequest.getAccountname());
       if(u==null){
           return new ResponseEntity<>(new Message("User not found"),HttpStatus.NOT_FOUND);
       }
        return new ResponseEntity<>(u,HttpStatus.OK);
    }
   @PostMapping("")
   public ResponseEntity<Message> save(@RequestBody User u){
        if(userService.findByName(u.getAccountname())){
            return  new ResponseEntity<>(new Message("username đã tồn tại"),HttpStatus.BAD_REQUEST);
        }else{
            userService.save(u);
            return  new ResponseEntity<>(new Message("thêm thành công"),HttpStatus.CREATED);
        }
   }
   @DeleteMapping("/{id}")
   public  ResponseEntity<Message> delete(@PathVariable Long id){

           userService.deleteById(id);
           return  new ResponseEntity<>(new Message("xóa thành công"),HttpStatus.OK);
    }
    @PutMapping()
    public ResponseEntity<Message> update(@RequestBody User u ){

            userService.update(u);
            return  new ResponseEntity<>(new Message("sửa thành công"),HttpStatus.ACCEPTED);

    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
            User u=userService.findById(id);
            return  new ResponseEntity<>(u,HttpStatus.OK);
    }
}
