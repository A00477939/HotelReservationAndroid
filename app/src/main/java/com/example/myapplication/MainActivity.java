package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import Fragment.hotelsearchFragment;
import Function.DatePickerHelper;

public class MainActivity extends AppCompatActivity {
    private Button startDateButton;
    private Button endDateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Begin the transaction
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        // Replace the contents of the container with the new fragment
        hotelsearchFragment fragment = new hotelsearchFragment();
        fragmentTransaction.replace(R.id.check, fragment);

        // Complete the changes added above
        fragmentTransaction.commit();

    }
}



