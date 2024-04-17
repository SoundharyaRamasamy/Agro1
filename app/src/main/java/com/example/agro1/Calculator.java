package com.example.agro1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Calculator extends AppCompatActivity {

    private EditText expenditureEditText;
    private EditText gainEditText;
    private Button calculateButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        expenditureEditText = findViewById(R.id.expenditureEditText);
        gainEditText = findViewById(R.id.gainEditText);
        calculateButton = findViewById(R.id.cal_btn);
        resultTextView = findViewById(R.id.resultTextView);

        calculateButton.setOnClickListener(v -> calculateProfitOrLoss());
    }

    private void calculateProfitOrLoss() {
        try {
            double expenditure = Double.parseDouble(expenditureEditText.getText().toString());
            double gain = Double.parseDouble(gainEditText.getText().toString());

            double profitOrLoss = gain - expenditure;

            if (profitOrLoss > 0) {
                resultTextView.setText("Profit: " + profitOrLoss);
            } else if (profitOrLoss < 0) {
                resultTextView.setText("Loss: " + (-profitOrLoss));
            } else {
                resultTextView.setText("No Profit, No Loss");
            }
        } catch (NumberFormatException e) {
            resultTextView.setText("Invalid input. Please enter numbers.");
        }
    }
}
