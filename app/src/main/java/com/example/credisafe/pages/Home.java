package com.example.credisafe.pages;
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


public class Home extends Fragment implements View.OnClickListener {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        View rootView = inflater.inflate(R.layout.activity_home, container, false);
        return rootView;


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sign_up_btn:
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





    public void LogButtonClick()
    {

        Fragment fragment = null;
        fragment = new ProfileLogin();
        replaceFragment(fragment);


    }






}