package com.lkjc.consumablesmanager.entity;

public class Result {
    private String isSuccess;
    private String message;

    public String getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(String isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class Builder{
        private String isSuccess;
        private String message;

        public Builder success(){
            this.isSuccess = "Y";
            return this;
        }
        public Builder faile(){
            this.isSuccess = "N";
            return this;
        }

        public Builder message(String message){
            this.message = message;
            return this;
        }

        public Result build(){
            Result result = new Result();
            result.setIsSuccess(this.isSuccess);
            result.setMessage(this.message);
            return result;
        }




    }
}
