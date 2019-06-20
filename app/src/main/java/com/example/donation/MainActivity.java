package com.example.donation;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    private RadioGroup paymentmode;
    private ProgressBar progressbar;
    private NumberPicker numberPicker;
    private EditText donationamount;
    private RadioButton paypal;
    private RadioButton direct;
    private  RadioButton SelectedItem;
    private TextView total;
    private Button donate;

int dontotal=0;
    ArrayList<Donation> ArrayListDonation =  new ArrayList<>();
    Donation donation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        paymentmode = findViewById(R.id.radioGroup);
        progressbar= findViewById(R.id.progressBar);
        numberPicker=findViewById(R.id.numberpicker);
        donationamount= findViewById(R.id.editText2);
        paypal= findViewById(R.id.radioButton4);
        direct = findViewById(R.id.radioButton3);
        total=findViewById(R.id.textView4);
        donate=findViewById(R.id.button);

        numberPicker.setMaxValue(1000);
        numberPicker.setMinValue(0);
        progressbar.setMax(10000);




        // SelectedItem = (RadioButton)findViewById(methodid);
       // CharSequence SelectedMethod = SelectedItem.getText();



        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


donate.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        String method = paymentmode.getCheckedRadioButtonId()== R.id.radioGroup ? "Direct" : "Paypal";


       int  amount= numberPicker.getValue();
        if (amount == 0) {
            String text = donationamount.getText().toString();
            if (!text.equals(""))
                amount = Integer.parseInt(text);


        }
    donation = new Donation(method, amount);

        if(amount>0)
        {
            ArrayListDonation.add(donation);
          dontotal+=amount;
          progressbar.setProgress(dontotal);
          String DonTot ="$"+dontotal;
          total.setText(DonTot);
          numberPicker.setValue(0);
          donationamount.setText("0");
        //  Toast.makeText(this,"Donation Success",Toast.LENGTH_LONG).show();
        }
        else {
           // Toast.makeText(this, "please donate ", Toast.LENGTH_LONG).show;

        }

        }

//NumberPicker.OnValueChangeListener OnValueChangeListener= (numberPicker)

});

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        if (!ArrayListDonation.isEmpty())
        {
            Bundle b=new Bundle();
            b.putParcelableArrayList("key",ArrayListDonation);
            Intent i=new Intent(MainActivity.this,ViewDonations.class);
            i.putExtras(b);
            startActivity(i);

        }
        else
        {


        }



        return super.onOptionsItemSelected(item);
    }
}
