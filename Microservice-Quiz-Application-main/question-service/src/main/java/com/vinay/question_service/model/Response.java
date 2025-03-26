package com.vinay.question_service.model;

public class Response {
    private Integer id;
    private String response;

    // Constructor
    public Response() {
    }

    // Getter and Setter for id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // Getter and Setter for response
    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
