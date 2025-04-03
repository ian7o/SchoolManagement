package com.school20.school2.exceptions;

import java.util.Date;


public class Error {
    private String message;
    private String path;
    private String method;
    private Date timeStamp;

    public Error(String message, String path, String method, Date timeStamp) {
        this.message = message;
        this.path = path;
        this.method = method;
        this.timeStamp = timeStamp;
    }

    public Error() {

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}
