package com.lawencon.demo.dto;

public class BaseSingleRes<T> {

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
