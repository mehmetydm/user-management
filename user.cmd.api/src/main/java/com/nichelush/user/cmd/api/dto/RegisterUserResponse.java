package com.nichelush.user.cmd.api.dto;

import com.nichelush.user.cmd.api.commands.RegisterUserCommand;

public class RegisterUserResponse extends BaseResponse {
    private String id;
    public RegisterUserResponse(String message){
        super(message);
    }
}
