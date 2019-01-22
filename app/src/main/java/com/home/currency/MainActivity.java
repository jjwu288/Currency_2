package com.home.currency;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edNTD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private  void findViews(){
        edNTD = findViewById(R.id.ntd);
    }

    public void go (View view){
        String strNTD = edNTD.getText().toString();
        if(strNTD.equals("")) {
            new AlertDialog.Builder(this)
                    .setTitle("Problem")
                    .setMessage("Please enter your NTD amount")
                    .setPositiveButton("OK",null)
                    .show();
        }else {
            float toUSD = Float.parseFloat(strNTD);
            new AlertDialog.Builder(this)
                    .setTitle("Result")
                    .setMessage("USD is" + toUSD / 30.9f)
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            edNTD.setText("");
                        }
                    })
                    .show();

        }
    }
}

