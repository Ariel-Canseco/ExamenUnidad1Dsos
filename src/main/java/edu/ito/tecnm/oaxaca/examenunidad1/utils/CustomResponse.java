package edu.ito.tecnm.oaxaca.examenunidad1.utils;

import java.util.LinkedList;

/**
 *
 * @author Jester
 */
public class CustomResponse {
    private Integer httpCode;
    private Object data;
    private String message;

    public CustomResponse() {
        this.httpCode = 200;
        this.data = new LinkedList();
        this.message = "OK";
    }

    public Integer getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(Integer httpCode) {
        this.httpCode = httpCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
