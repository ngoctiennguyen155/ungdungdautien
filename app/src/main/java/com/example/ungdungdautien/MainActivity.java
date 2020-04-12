package com.example.ungdungdautien;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int b1,b2;
    int dems=0,demd=0;
    CountDownTimer countDownTime;
    public void unit()
    {
        TextView t= findViewById(R.id.dung);
        t.setText("Đúng: "+String.valueOf(demd));
        TextView tt=findViewById(R.id.sai);
        tt.setText("Sai: "+String.valueOf(dems));
        Random rd = new Random();
        b1 = rd.nextInt(50);
        b2 = rd.nextInt(50);
        TextView tw= findViewById(R.id.de);
        tw.setText(b1 + " + " + b2);

        RadioButton rb = findViewById(R.id.radioButton1);
        //int randnum = rd.nextInt(100);
        rb.setText("   "+rd.nextInt(100));
        rb=findViewById(R.id.radioButton2);
        rb.setText("   "+rd.nextInt(100));
        rb=findViewById(R.id.radioButton3);
        rb.setText("   "+rd.nextInt(100));
        rb=findViewById(R.id.radioButton4);
        rb.setText("   "+rd.nextInt(100));

        final int res = rd.nextInt(4);
        if(res==0)
        {
            rb=findViewById(R.id.radioButton1);
            rb.setText("   "+(b1+b2));
        }else if (res==1)
        {
            rb=findViewById(R.id.radioButton2);
            rb.setText("   "+(b1+b2));
        }else if(res==2)
        {
            rb=findViewById(R.id.radioButton3);
            rb.setText("   "+(b1+b2));
        }else {
            rb=findViewById(R.id.radioButton4);
            rb.setText("   "+(b1+b2));
        }

        final TextView txttime = findViewById(R.id.timer);

        countDownTime = new CountDownTimer(60000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                txttime.setText(String.valueOf(millisUntilFinished/1000));

            }

            @Override
            public void onFinish() {
                //Intent in = new Intent(MainActivity.this, newclass.class);
                //startActivity(in);
                txttime.setText("Hết giờ");
                dems++;
                cancel();
                unit();
                reset();
            }
        }.start();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unit();
    }
    public void reset()
    {
        RadioButton rb = findViewById(R.id.radioButton1);
        rb.setChecked(false);
        rb = findViewById(R.id.radioButton2);
        rb.setChecked(false);
        rb = findViewById(R.id.radioButton3);
        rb.setChecked(false);
        rb = findViewById(R.id.radioButton4);
        rb.setChecked(false);
    }
    public boolean isChecked()
    {
        RadioButton rb1 = findViewById(R.id.radioButton1);
        RadioButton rb2 = findViewById(R.id.radioButton2);
        RadioButton rb3 = findViewById(R.id.radioButton3);
        RadioButton rb4 = findViewById(R.id.radioButton4);
        if(rb1.isChecked()==false && rb2.isChecked()==false && rb3.isChecked()==false && rb4.isChecked()==false)
        {
            return false;
        }
        return true;
    }
    public void onlicked(View view) {
        if (isChecked() == false) {
            Toast.makeText(this, "Vui long chon dap an cua ban !!!", Toast.LENGTH_SHORT).show();
        } else
        {
            RadioGroup rg;
            rg = findViewById(R.id.radioGroup);
            int sl = rg.getCheckedRadioButtonId();
            RadioButton rb =findViewById(sl);
            CharSequence rr="";
            int tamp=b1+b2;
            rr="   "+String.valueOf(tamp);
            String ss=rb.getText().toString();
            boolean flag = (ss.equals(rr))?true:false;
            if(flag)
            {
                demd++;
                Toast.makeText(this,"Dung", Toast.LENGTH_SHORT).show();

            }else {
                dems++;
                Toast.makeText(this,"Sai", Toast.LENGTH_SHORT).show();
            }
            countDownTime.cancel();
            unit();
            reset();
        }
    }

}
