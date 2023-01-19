package com.example.credisafe.model;
import java.time.LocalDateTime;
import java.time.LocalDate;
public class Loan {
    private int id ;
    private Individual borrower ;
    private Individual lender ;
    private String related_name ;
    private Float total_amount  ;
    private LocalDate date_created ;
    private Boolean has_payment_plan  ;
    private String terms_and_conditions ;
    private LocalDateTime due_date ;
    private  int number_of_payment ;

    public Loan(int id ,
                Individual borrower ,
                Individual lender ,
                String related_name ,
                Float total_amount  ,
                LocalDate date_created ,
                Boolean has_payment_plan  ,
                String terms_and_conditions ,
                LocalDateTime due_date ,
                int number_of_payment
                ){
        this.id = id ;
        this.borrower =  borrower ;
        this.lender =  lender ;
        this.related_name = related_name ;
        this.total_amount = total_amount  ;
        this.date_created = date_created ;
        this.has_payment_plan  = has_payment_plan ;
        this.terms_and_conditions = terms_and_conditions ;
        this.due_date  =  due_date;
        this.number_of_payment = number_of_payment ;

    }
}
