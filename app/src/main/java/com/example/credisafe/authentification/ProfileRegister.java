package com.example.credisafe.authentification;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.credisafe.R;
import com.example.credisafe.api.InternetUtil;
import com.example.credisafe.api.PostApi;
import com.example.credisafe.authentification.ProfileLogin;
import com.example.credisafe.model.Individual;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ProfileRegister extends Fragment implements View.OnClickListener {

    EditText Edreg_national_id;
    EditText Edreg_firstname ;
    EditText Edreg_fins_number ;
    EditText Edreg_email ;
    EditText Edreg_pin ;
    EditText Edreg_surname ;
    EditText Edreg_dob ;
    EditText Edreg_forenames ;
    Spinner Spreg_gender;
    Spinner Edreg_marital_status ;
    TextView Edreg_address ;
    EditText Edreg_mobile;
    EditText Edreg_landline ;
    EditText Edreg_employer_name ;
    EditText company_name ;
    EditText Edreg_employer_email ;
    EditText Edreg_job_title ;
    EditText Edreg_date_of_employement ;
    EditText Edreg_risk_class ;
    Spinner Edreg_fk_indentification_type ;
    Boolean is_client_entry ;
    Boolean is_deleted ;
    Boolean is_validated ;
    String status ;
    EditText Edreg_town ;
    EditText Edreg_district ;
    EditText Edreg_next_of_kin ;
    EditText Edreg_phone_number ;
    EditText Edreg_relationship ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        View rootView = inflater.inflate(R.layout.activity_register, container, false);


        //Spinner Identification Type
        Spinner spinnerIdentificationType =rootView.findViewById(R.id.spinner_identification_type);
        ArrayAdapter<CharSequence> spinnerAdapter=ArrayAdapter.createFromResource(rootView.getContext(), R.array.identification_list, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerIdentificationType.setAdapter(spinnerAdapter);


        //spinner Gender
        Spinner spinnerGenders=rootView.findViewById(R.id.spinner_gender);
        ArrayAdapter<CharSequence> genderAdapter=ArrayAdapter.createFromResource(rootView.getContext(), R.array.gender_list, android.R.layout.simple_spinner_item);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerGenders.setAdapter(genderAdapter);

        //Spinner Marital Status
        Spinner spinnerMaritalStatus=rootView.findViewById(R.id.spinner_marital_status);
        ArrayAdapter<CharSequence> maritalStatusAdapter=ArrayAdapter.createFromResource(rootView.getContext(), R.array.marital_status_list, android.R.layout.simple_spinner_item);
        maritalStatusAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerMaritalStatus.setAdapter(maritalStatusAdapter);




        Button regBtn = (Button) rootView.findViewById(R.id.sign_up_btn);
        Button logBtn = (Button) rootView.findViewById(R.id.to_login_button);

        Edreg_national_id = (EditText) rootView.findViewById(R.id.national_id);
        Edreg_pin = (EditText) rootView.findViewById(R.id.pin);
        Edreg_email = (EditText) rootView.findViewById(R.id.email);
        Edreg_firstname = (EditText) rootView.findViewById(R.id.firstname);
        EditText Edreg_fins_number = (EditText) rootView.findViewById(R.id.firstname) ;
        EditText Edreg_surname =  (EditText) rootView.findViewById(R.id.firstname) ;
        EditText Edreg_dob = (EditText) rootView.findViewById(R.id.firstname);
        EditText Edreg_forenames = (EditText) rootView.findViewById(R.id.firstname);
        Spreg_gender = (Spinner) rootView.findViewById(R.id.spinner_gender);
        Edreg_marital_status = (Spinner) rootView.findViewById(R.id.spinner_marital_status);
        TextView Edreg_address = (EditText) rootView.findViewById(R.id.firstname);
        EditText Edreg_mobile = (EditText) rootView.findViewById(R.id.firstname);
        EditText Edreg_landline = (EditText) rootView.findViewById(R.id.firstname);
        EditText Edreg_employer_name = (EditText) rootView.findViewById(R.id.firstname);
        EditText company_name = (EditText) rootView.findViewById(R.id.firstname);
        EditText Edreg_employer_email = (EditText) rootView.findViewById(R.id.firstname);
        EditText Edreg_job_title = (EditText) rootView.findViewById(R.id.firstname);
        EditText Edreg_date_of_employement = (EditText) rootView.findViewById(R.id.firstname);
        EditText Edreg_risk_class ;
        Spinner Edreg_fk_indentification_type = (Spinner) rootView.findViewById(R.id.spinner_identification_type);
        Boolean is_client_entry ;
        Boolean is_deleted ;
        Boolean is_validated ;
        String status ;
        Edreg_town = (EditText) rootView.findViewById(R.id.town);
        Edreg_district = (EditText) rootView.findViewById(R.id.firstname);
        Edreg_next_of_kin = (EditText) rootView.findViewById(R.id.district);
        Edreg_phone_number = (EditText) rootView.findViewById(R.id.phone_number);
        Edreg_relationship = (EditText) rootView.findViewById(R.id.next_of_kin_relationship);


        regBtn.setOnClickListener(this);
        logBtn.setOnClickListener(this);

        return rootView;


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sign_up_btn:
                RegButtonClick();
                break;
            case R.id.to_login_button:
                LogButtonClick();
                break;
        }
    }



    public void replaceFragment(Fragment someFragment) {

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }


    public void RegButtonClick()
    {


        String str_reg_individualname = Edreg_national_id.getText().toString();
        String str_reg_password = Edreg_pin.getText().toString();
        String str_reg_email = Edreg_email.getText().toString();

        Individual individualModel = new Individual(Edreg_national_id,Edreg_firstname ,Edreg_fins_number , Edreg_email ,
                Edreg_pin ,  Edreg_surname ,  Edreg_dob , Edreg_forenames , Spreg_gender , Edreg_marital_status ,Edreg_address ,Edreg_mobile,Edreg_landline,Edreg_employer_name
                ,company_name,Edreg_employer_email ,Edreg_job_title ,Edreg_date_of_employement  ,Edreg_risk_class  ,Edreg_fk_indentification_type
                ,is_client_entry ,is_deleted   ,is_validated ,status ,Edreg_town,Edreg_district ,Edreg_next_of_kin ,Edreg_phone_number ,Edreg_relationship
        );



        if (!IsEmptyEditTextLogin()){

            if ( InternetUtil.isInternetOnline(getActivity()) ){
                RegisterInServer(individualModel);
            }

        }


    }


    public void LogButtonClick()
    {

        Fragment fragment = null;
        fragment = new ProfileLogin();
        replaceFragment(fragment);


    }


    public void RegisterInServer(Individual individualModel) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PostApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostApi postApi= retrofit.create(PostApi.class);
        Call<Individual> call = postApi.registrationIndividual(individualModel);

        call.enqueue(new Callback<Individual>() {
            @Override
            public void onResponse(Call<Individual> call, Response<Individual> response) {

                if(response.isSuccessful()){
                    if (response.body() != null) {

                        SharedPreferences preferences = getActivity().getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor prefLoginEdit = preferences.edit();
                        prefLoginEdit.putBoolean("registration",true);
                        prefLoginEdit.commit();


//                        Fragment fragment = new ProfileLogin();
//                        replaceFragment(fragment);

                    }
                }else {
                    Log.d("fail", "fail");
                }

            }
            @Override
            public void onFailure(Call<Individual> call, Throwable t) {
                Log.d("fail", "fail");
            }
        });

    }



    private Boolean IsEmptyEditTextLogin(){


        if(Edreg_pin.getText().toString().isEmpty() || Edreg_national_id.getText().toString().isEmpty()|| Edreg_email.getText().toString().isEmpty()){

            Toast toast = Toast.makeText(getActivity(),"Empty EditText", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();


            return true;
        }else{
            return false;
        }

    }



}