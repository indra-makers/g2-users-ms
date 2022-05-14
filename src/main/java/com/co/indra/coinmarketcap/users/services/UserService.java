package com.co.indra.coinmarketcap.users.services;

import com.co.indra.coinmarketcap.users.repositories.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRespository userRespository;
}
