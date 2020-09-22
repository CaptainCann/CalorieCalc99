package com.example.caloriecalculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CheckBox checkBox;
    TextView textView;
    SeekBar seekBar;
    Button finalCalories;
    Burger burger;
    RadioGroup pattyType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        burger = new Burger();
        finalCalories = (Button)findViewById((R.id.button));
        pattyType = (RadioGroup)findViewById(R.id.patties);
        textView = (TextView)findViewById(R.id.textView);
        checkBox = (CheckBox)findViewById(R.id.checkBox);
        seekBar = (SeekBar)findViewById(R.id.seekBar);

        pattyType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                switch (id)
                {
                    case R.id.single_patty_radio:
                        burger.meatNum(1);
                        break;
                    case R.id.double_patty_radio:
                        burger.meatNum(2);
                        break;
                    case R.id.veggie_patty_radio:
                        burger.meatNum(3);
                        break;
                }
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int bbq = (int) (seekBar.getProgress() * 0.1 * 5);
                burger.bbqCalGetter(bbq);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void checked(View view)
    {
        if(checkBox.isChecked())
        {
            burger.setCheese(true);
        }
        else
        {
            burger.setCheese(false);
        }


    }
    public void button(View view)
    {
        String burgerCalories = String.valueOf(burger.totalBurgerCal());
        burgerCalories += " Calories";
        textView.setText(burgerCalories);
    }
}