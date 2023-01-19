package com.example.credisafe.model;

import java.time.LocalDate;

public class Request {
    private int id ;
    private String description ;
    private String status ;
    private  String sender ;
    private String related_name;
    private String receiver ;
    private String realated_name;
    private LocalDate datetime ;

    public Request(int id , String description , String status ,
                   String sender , String related_name , String receiver , LocalDate datetime){
        this.id = id ;
        this.description =  description ;
        this.status = status ;
        this.sender = sender ;
        this.related_name = related_name ;
        this.receiver = receiver ;
        this.datetime = datetime;

    }

    public int getId() {
        return id;
    }
}
