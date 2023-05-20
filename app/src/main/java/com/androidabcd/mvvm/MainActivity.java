package com.androidabcd.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.androidabcd.mvvm.viewmodel.CounterViewModel;

public class MainActivity extends AppCompatActivity {

    private CounterViewModel counterViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counterViewModel = new ViewModelProvider(this).get(CounterViewModel.class);

        final TextView counterTextView = findViewById(R.id.counterTextView);
        Button incrementButton = findViewById(R.id.incrementButton);
        Button decrementButton = findViewById(R.id.decrementButton);

        counterViewModel.getCounter().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer counter) {
                counterTextView.setText(String.valueOf(counter));
            }
        });

        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterViewModel.incrementCounter();
            }
        });

        decrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterViewModel.decrementCounter();
            }
        });
    }
}