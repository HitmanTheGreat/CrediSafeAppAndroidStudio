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
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.credisafe.R;
import com.example.credisafe.authentification.ProfileLogin;
import com.example.rest_connector_blog.model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ProfileRegister extends Fragment implements View.OnClickListener {


    EditText Edreg_national_id;
    EditText Edreg_firstname ;
    EditText Edreg_fins_number ;
    EditText Edreg_surname ;
    EditText Edreg_dob ;
    EditText Edreg_forenames ;
    Spinner Spreg_gender;
    Spinner Edreg_marital_status ;
    EditText Edreg_address ;
    String mobile;
    String landline ;
    String employer_name ;
    String employer_email ;
    String job_title ;
    LocalDate date_of_employement ;
    String risk_class ;
    String fk_indentification_type ;
    Boolean is_client_entry ;
    Boolean is_deleted ;
    Boolean is_validated ;
    String company_name;
    String status ;
    String town ;
    String district ;
    String next_of_kin ;
    String phone_number ;
    String relationship ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        View rootView = inflater.inflate(R.layout.activity_register, container, false);


        //spinner Gender
        Spinner spinnerGenders=rootView.findViewById(R.id.spinner_gender);
        ArrayAdapter<CharSequence> genderAdapter=ArrayAdapter.createFromResource(this, R.array.genders, android.R.layout.simple_spinner_item);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerGenders.setAdapter(genderAdapter);

        //Spinner Marital Status
        Spinner spinnerMaritalStatus=rootView.findViewById(R.id.spinner_marital_status);
        ArrayAdapter<CharSequence> maritalStatusAdapter=ArrayAdapter.createFromResource(this, R.array.marital_status, android.R.layout.simple_spinner_item);
        maritalStatusAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerGenders.setAdapter(maritalStatusAdapter);


        Button regBtn = (Button) rootView.findViewById(R.id.sign_up_btn);
        Button logBtn = (Button) rootView.findViewById(R.id.to_login_button);

        Edreg_national_id = (EditText) rootView.findViewById(R.id.reg_username);
        Edreg_password = (EditText) rootView.findViewById(R.id.reg_password);
        Edreg_email = (EditText) rootView.findViewById(R.id.reg_email);


        regBtn.setOnClickListener(this);
        logBtn.setOnClickListener(this);

        return rootView;


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.registration_button:
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


        String str_reg_username = Edreg_username.getText().toString();
        String str_reg_password = Edreg_password.getText().toString();
        String str_reg_email = Edreg_email.getText().toString();


        User userModel = new User(
                1,
                str_reg_email,
                str_reg_username,
                str_reg_password,
                "sadasdasd"
        );



        if (!IsEmptyEditTextLogin()){

            if ( InternetUtil.isInternetOnline(getActivity()) ){
                RegisterInServer(userModel);
            }

        }


    }


    public void LogButtonClick()
    {

        Fragment fragment = null;
        fragment = new ProfileLogin();
        replaceFragment(fragment);


    }


    public void RegisterInServer(User userModel) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PostApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostApi postApi= retrofit.create(PostApi.class);
        Call<User> call = postApi.registrationUser(userModel);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

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
            public void onFailure(Call<User> call, Throwable t) {
                Log.d("fail", "fail");
            }
        });

    }



    private Boolean IsEmptyEditTextLogin(){


        if(Edreg_password.getText().toString().isEmpty() || Edreg_username.getText().toString().isEmpty()|| Edreg_email.getText().toString().isEmpty()){

            Toast toast = Toast.makeText(getActivity(),"Empty EditText", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();


            return true;
        }else{
            return false;
        }

    }



}