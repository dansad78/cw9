package com.example.currencywebserver.model;

public class Rate {
    String code;
    Double value;
    String created_at;

    public Rate() {
        super();
    }

    public Rate(String code, Double value, String created_at) {
        this.code = code;
        this.value = value;
        this.created_at = created_at;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
