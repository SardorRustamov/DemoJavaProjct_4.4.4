package com.example.demojavaprojct;

import java.io.Serializable;

public class Member implements Serializable {
    private String object;
    private String text;

    public Member(String object, String text) {
        this.object = object;
        this.text = text;
    }
    public String toString(){
        return object + "  " + text;
    }
}
