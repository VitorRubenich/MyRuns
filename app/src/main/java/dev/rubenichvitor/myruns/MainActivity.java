package dev.rubenichvitor.myruns;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import dev.rubenichvitor.myruns.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    protected void onResume() {
        super.onResume();
        setAdapters();
    }

    private void setAdapters(){
        String[] input_type = getResources().getStringArray(R.array.input_type);
        String[] activity_type = getResources().getStringArray(R.array.activity_type);
        ArrayAdapter adapterInputType = new ArrayAdapter(getBaseContext(), R.layout.dropdown_item, input_type);
        ArrayAdapter adapterActivityType = new ArrayAdapter(getBaseContext(), R.layout.dropdown_item, activity_type);
        binding.inputType.setAdapter(adapterInputType);
        binding.activityType.setAdapter(adapterActivityType);
    }
}