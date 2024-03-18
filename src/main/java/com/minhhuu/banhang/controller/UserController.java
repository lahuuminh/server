package com.minhhuu.banhang.controller;

import com.minhhuu.banhang.model.LoginRequest;
import com.minhhuu.banhang.model.Message;
import com.minhhuu.banhang.model.Test;
import com.minhhuu.banhang.model.User;
import com.minhhuu.banhang.repo.TestRepo;
import com.minhhuu.banhang.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = {"http://127.0.0.1:5503"})
public class UserController {
    @Autowired
    private UserRepo userRepo;
    @GetMapping("/all")
    public ResponseEntity<List<User>>getAll(){
           List<User>u=userRepo.findAll();
           return new ResponseEntity<>(u,HttpStatus.OK);
    }
    @PostMapping("/login")
    public  ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        System.out.println(loginRequest.getAccountname());
        User u= userRepo.findName(loginRequest.getAccountname());
       if(u==null){
           return new ResponseEntity<>(new Message("User not found"),HttpStatus.NOT_FOUND);
       }
        return new ResponseEntity<>(u,HttpStatus.OK);
    }
   @PostMapping("")
   public ResponseEntity<Message> save(@RequestBody User u){
        if(userRepo.findByName(u.getAccountname())){
            return  new ResponseEntity<>(new Message("username đã tồn tại"),HttpStatus.BAD_REQUEST);
        }else{
            userRepo.save(u);
            return  new ResponseEntity<>(new Message("thêm thành công"),HttpStatus.CREATED);
        }
   }
   @DeleteMapping("/{id}")
   public  ResponseEntity<Message> delete(@PathVariable Long id){

           userRepo.deleteById(id);
           return  new ResponseEntity<>(new Message("xóa thành công"),HttpStatus.OK);
    }
    @PutMapping()
    public ResponseEntity<Message> update(@RequestBody User u ){

            userRepo.update(u);
            return  new ResponseEntity<>(new Message("sửa thành công"),HttpStatus.ACCEPTED);

    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
            User u=userRepo.findById(id);
            return  new ResponseEntity<>(u,HttpStatus.OK);
    }
}
