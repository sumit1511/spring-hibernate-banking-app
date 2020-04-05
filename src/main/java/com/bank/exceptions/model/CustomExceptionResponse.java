package com.bank.exceptions.model;

public class CustomExceptionResponse
{
    private String status;
    private String massage;
    private String timeStamp;

    public CustomExceptionResponse()
    {

    }

    public CustomExceptionResponse(String status, String massage, String timeStamp)
    {
        this.status = status;
        this.massage = massage;
        this.timeStamp = timeStamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
