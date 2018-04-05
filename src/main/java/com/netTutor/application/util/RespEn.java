package com.netTutor.application.util;

import org.springframework.http.*;

public class RespEn extends ResponseEntity {
    private String message;
    private boolean success;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public RespEn(Object body, HttpStatus status) {
        super(body, status);
    }

    public RespEn(Object body,String nessage, HttpStatus status,boolean success) {
        super(body,status);
        this.message  =message;
        this.success = success;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
