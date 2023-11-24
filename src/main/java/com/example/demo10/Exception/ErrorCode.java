package com.example.demo5.Exception;

import lombok.Getter;

@Getter
public enum ErrorCode {


    MEMBER_NOT_FOUND(404, "MEMBER NOT FOUND"),
    ORDER_NOT_FOUND(404, "ORDER NOT FOUND"),
    DELIVERY_NOT_FOUND(404, "DELIVERY NOT FOUND"),
    ORDER_ITEM_NOT_FOUND(404, "ORDER ITEM NOT FOUND"),
    ITEM_INSUFFICIENT(404, "ITEM INSUFFICIENT"),
    ITEM_NOT_FOUND(404, "ITEM NOT FOUND");


    private int status;
    private String message;

    ErrorCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
