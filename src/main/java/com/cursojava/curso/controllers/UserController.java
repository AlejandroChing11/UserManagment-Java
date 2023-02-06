package com.cursojava.curso.controllers;

import com.cursojava.curso.dao.UserDAO;
import com.cursojava.curso.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserDAO usuarioDao;

    @RequestMapping(value = "api/users/{id}", method = RequestMethod.GET)
    public User getUser (@PathVariable Long id) {
        User user = new User(); //Creacion del objeto
        user.setId(id);
        user.setName("Mei Li"); //Seteamos el name
        user.setLastName("Ching"); //Seteamos last name OJO TODO AL OBJETO
        user.setEmail("MeiChill@hotmail.com"); //Seteamos el email
        user.setPhoneNumber("24567343"); //Seteamos el phone number
        return user; //Retornamos en formato JSON el objeto user
    }

    @RequestMapping(value = "api/users", method = RequestMethod.GET)
    public List<User> getUsers () {
        return usuarioDao.getUsers();
    }

    @RequestMapping(value = "api/users", method = RequestMethod.POST)
    public void registrarUsuario (@RequestBody User usuario) {
         usuarioDao.register(usuario);
    }

    @RequestMapping(value = "api/users/{id}", method = RequestMethod.DELETE)
    public void eliminar (@PathVariable Long id) {
        usuarioDao.eliminar(id);
    }

}
