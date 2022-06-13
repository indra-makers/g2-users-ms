package com.co.indra.coinmarketcap.users.services;

import com.co.indra.coinmarketcap.users.config.ErrorCodes;
import com.co.indra.coinmarketcap.users.exceptions.BusinessException;
import com.co.indra.coinmarketcap.users.exceptions.NotFoundException;
import com.co.indra.coinmarketcap.users.messaging.UsersProducer;
import com.co.indra.coinmarketcap.users.model.entities.User;
import com.co.indra.coinmarketcap.users.repositories.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRespository userRespository;

    @Autowired
    private UsersProducer usersProducer;

    public void createUser(User user){
        usersProducer.sendUserNotificationData(user);
        saveUser(user);
    }

    public void saveUser(User user){
        if(!userRespository.findUserByMail(user.getMail()).isEmpty()){
            throw new BusinessException(ErrorCodes.USER_MAIL_UNIQUE);
        }
        if(!userRespository.findUserByUsername(user.getUsername()).isEmpty()){
            throw new BusinessException(ErrorCodes.USERNAME_UNIQUE);
        }
        userRespository.createUser(user);
    }

    public User findUser(String username){
        if(userRespository.findUserByUsername(username).isEmpty()){
            throw new NotFoundException(ErrorCodes.USERNAME_NOT_FOUND.getMessage());
        }
        List<User> user = userRespository.findUserByUsername(username);
        return  user.get(0);
    }
}
