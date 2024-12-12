package com.ravali.springboot.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ErrorResponse {

    private String reason;
    private String message;

    public ErrorResponse(String reason, String message){
        super();
        this.reason = reason;
        this.message = message;
    }
}
