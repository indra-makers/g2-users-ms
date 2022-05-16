package com.co.indra.coinmarketcap.users.services;

import com.co.indra.coinmarketcap.users.config.ErrorCodes;
import com.co.indra.coinmarketcap.users.exceptions.BusinessException;
import com.co.indra.coinmarketcap.users.model.entities.User;
import com.co.indra.coinmarketcap.users.repositories.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRespository userRespository;

    public void createUser(User user){
        if(!userRespository.findUserByMail(user.getMail()).isEmpty()){
            throw new BusinessException(ErrorCodes.USER_MAIL_UNIQUE);
        }
        else if(!userRespository.findUserByUsername(user.getUsername()).isEmpty()){
            throw new BusinessException(ErrorCodes.USERNAME_UNIQUE);
        }
        userRespository.createUser(user);
    }
}
