package com.itcast.exptions;

/**
 * @author hftang
 * @date 2019-01-04 14:55
 * @desc
 */
public class SysException extends Exception {
    private String message;

    public SysException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
