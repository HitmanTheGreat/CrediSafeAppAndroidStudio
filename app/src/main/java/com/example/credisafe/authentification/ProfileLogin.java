
package com.example.credisafe.authentification;

import static android.view.Gravity.CENTER;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.credisafe.R;
import com.example.credisafe.api.InternetUtil;
import com.example.credisafe.api.PostApi;
import com.example.credisafe.pages.Home;
import com.example.credisafe.model.Login;
import com.example.credisafe.model.Individual;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ProfileLogin extends Fragment implements View.OnClickListener {


    EditText Edreg_username;
    EditText Edreg_password;
    EditText Edreg_email;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        View rootView = inflater.inflate(R.layout.activity_login, container, false);


        Button logBtn = (Button) rootView.findViewById(R.id.login_button);
        Button to_reg_Btn = (Button) rootView.findViewById(R.id.to_register_button);


        Edreg_username = (EditText) rootView.findViewById(R.id.national_id);
        Edreg_password = (EditText) rootView.findViewById(R.id.pin);
//        Edreg_email = (EditText) rootView.findViewById(R.id.reg_email);




        logBtn.setOnClickListener(this);
        to_reg_Btn.setOnClickListener(this);

        return rootView;


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_button:
                LogButtonClick();
                break;
            case R.id.to_register_button:
                RegButtonClick();
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

        Fragment fragment = null;
        fragment = new Home();
        replaceFragment(fragment);

    }


    public void LogButtonClick()
    {

        if (!IsEmptyEditTextLogin()){

            if ( InternetUtil.isInternetOnline(getActivity()) ){
                login();
            }

        }



    }


    private void login(){


        //bridge login
        Fragment fragment = null;
        fragment = new Home();
        replaceFragment(fragment);

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(PostApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();

        PostApi postApi = retrofit.create(PostApi.class);




        String add1      =  Edreg_username.getText().toString();
        String add2      =  Edreg_password.getText().toString();

        Login login = new Login(add1, add2);

        Call<Individual> call = postApi.login(login);
        call.enqueue(new Callback<Individual>() {

            @Override
            public void onResponse(Call<Individual> call, Response<Individual> response) {
                if(response.isSuccessful()){


                    if (response.body() != null) {

                        String token = response.body().getToken();


                        SharedPreferences preferences = getActivity().getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor prefLoginEdit = preferences.edit();
                        prefLoginEdit.putBoolean("loggedin", true);
                        prefLoginEdit.putString("token", token);
                        prefLoginEdit.commit();



                        Toast.makeText(getContext(), token, Toast.LENGTH_SHORT).show();

//                        Fragment fragment = null;
//                        fragment = new Home();
//                        replaceFragment(fragment);

                    }

                }else {
                    Toast.makeText(getContext(), "login no correct :(", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Individual> call, Throwable t) {
                Toast.makeText(getActivity(), "error :(", Toast.LENGTH_SHORT).show();
            }
        });
    }



    private Boolean IsEmptyEditTextLogin(){



        if(Edreg_password.getText().toString().isEmpty() || Edreg_username.getText().toString().isEmpty()){

            Toast toast = Toast.makeText(getActivity(),"Empty EditText", Toast.LENGTH_LONG);
            toast.setGravity(CENTER|Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();


            return true;
        }else{
            return false;
        }

    }







}