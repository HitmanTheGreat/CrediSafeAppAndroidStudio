package com.example.credisafe.model;
import java.time.LocalDate;
public class Individual {
    private String national_id ;
    private  String firstname ;
    private String fins_number ;
    private String surname ;
    private LocalDate dob ;
    private String forenames ;
    private String gender;
    private String marital_status ;
    private String address ;
    private String mobile;
    private String landline ;
    private String employer_name ;
    private String employer_email ;
    private String job_title ;
    private LocalDate date_of_employement ;
    private String risk_class ;
    private String fk_indentification_type ;
    private Boolean is_client_entry ;
    private Boolean is_deleted ;
    private Boolean is_validated ;
    private String company_name;
    private String status ;
    private String town ;
    private String district ;
    private String next_of_kin ;
    private String phone_number ;
    private String relationship ;

    public  Individual(String national_id ,  String firstname , String fins_number , String surname , LocalDate dob
            , String forenames , String gender, String marital_status , String address , String mobile, String landline
            , String employer_name , String employer_email , String job_title , LocalDate date_of_employement , String risk_class
            , String fk_indentification_type , Boolean is_client_entry , Boolean is_deleted , Boolean is_validated , String company_name,
                           String status , String town , String district , String next_of_kin , String phone_number , String relationship){

        this.national_id = national_id ;
        this.firstname = firstname ;
        this.fins_number =  fins_number;
        this.surname = surname ;
        this.dob =  dob;
        this.forenames = forenames ;
        this.gender =  gender;
        this.marital_status  =  marital_status;
        this.address =  address;
        this.mobile =  mobile;
        this.landline = landline;
        this.employer_name = employer_name;
        this.employer_email =  employer_email;
        this.job_title =  job_title;
        this.date_of_employement  = date_of_employement;
        this.risk_class = risk_class ;
        this.fk_indentification_type = fk_indentification_type;
        this.is_client_entry= is_client_entry ;
        this.is_deleted = is_deleted ;
        this.is_validated = is_validated;
        this.company_name =  company_name;
        this.status =  status;
        this.town =  town ;
        this.district =  district;
        this.next_of_kin = next_of_kin ;
        this.phone_number =  phone_number;
        this.relationship =  relationship;

    }

}
