package com.example.credisafe.model;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

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
    private String token;


    public Individual(EditText edreg_national_id, EditText edreg_firstname, EditText edreg_fins_number, EditText edreg_email, EditText edreg_pin, EditText edreg_surname, EditText edreg_dob, EditText edreg_forenames, Spinner spreg_gender, Spinner edreg_marital_status, TextView edreg_address, EditText edreg_mobile, EditText edreg_landline, EditText edreg_employer_name, EditText company_name, EditText edreg_employer_email, EditText edreg_job_title, EditText edreg_date_of_employement, EditText edreg_risk_class, Spinner edreg_fk_indentification_type, Boolean is_client_entry, Boolean is_deleted, Boolean is_validated, String status, EditText edreg_town, EditText edreg_district, EditText edreg_next_of_kin, EditText edreg_phone_number, EditText edreg_relationship) {


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
        this.status =  status;
        this.town =  town ;
        this.district =  district;
        this.next_of_kin = next_of_kin ;
        this.phone_number =  phone_number;
        this.relationship =  relationship;

    }

    public String getId(){
        return national_id;
    }

    public void setId(int id){
        this.national_id = national_id;
    }

    public String getToken(){
        return token;
    }


}
