package com.example.credisafe.model;
import java.time.LocalDateTime;
public class PaymentPlan {
    private int   id;
    private String terms_and_conditions ;
    private  Loan loan ;
    LocalDateTime duedate ;

    public PaymentPlan(int id , String terms_and_conditions , Loan loan , LocalDateTime duedate){
        this.id = id ;
        this.terms_and_conditions = terms_and_conditions ;
        this.loan = loan ;
        this.duedate = duedate ;
    }

    public int getId() {
        return id;
    }
}
