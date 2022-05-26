package com.co.indra.coinmarketcap.users.exceptions;

import com.co.indra.coinmarketcap.users.config.ErrorCodes;

public class NotFoundException extends RuntimeException{
    private ErrorCodes code;
    public NotFoundException(String message) {
        super(message);
    }

}
