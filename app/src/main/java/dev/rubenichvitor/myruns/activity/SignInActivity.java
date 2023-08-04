package dev.rubenichvitor.myruns.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import dev.rubenichvitor.myruns.MainActivity;
import dev.rubenichvitor.myruns.databinding.ActivitySignInBinding;

public class SignInActivity extends AppCompatActivity {

    private ActivitySignInBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        insertListeners();
    }

    private void insertListeners() {
        binding.btnRegister.setOnClickListener(v -> callRegisterActivity());
        binding.btnSignIn.setOnClickListener(v ->  callMainActivity()); //validate login
    }

    private void callRegisterActivity() {
        startActivity(new Intent(this, ProfileActivity.class));
    }

    private void callMainActivity(){
        if(validateLogin()){
            startActivity(new Intent(this,MainActivity.class));
        }
        startActivity(new Intent(this,MainActivity.class));
    }

    private boolean validateLogin(){
        return false;
    }
}
