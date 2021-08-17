package com.login.restConroller;


import com.login.model.User;
import com.login.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
public class SpecificUser {

    @Autowired
    UserServiceImp userServiceImp;



   @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
    public User view(@PathVariable("id") int id)
   {
       User user = userServiceImp.getUserById(id);
//       ArrayList<String> list = new ArrayList<>();
//       list.add("Ahmad");
//       list.add("Raza");
////       return "Ahmad Raza";
            return user;
   }

}
