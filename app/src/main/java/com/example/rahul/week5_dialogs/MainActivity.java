package com.example.rahul.week5_dialogs;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    Configuration configuration;

    @BindView(R.id.btn_date)
    Button dateButton;

    @BindView(R.id.txt_view)
    TextView txtView;

    @BindView(R.id.activity_main)  LinearLayout rootLayout;

    int numOfViews=10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        configuration=getResources().getConfiguration();

        dateButton.setOnClickListener(new MyLstr());
        //to amke scrollable
        ScrollView scrollView=new ScrollView(this);

        LinearLayout subLayer=new LinearLayout(this);

        //It will check device is in landscape mode or not
        if(configuration.orientation==Configuration.ORIENTATION_LANDSCAPE)
            subLayer.setOrientation(LinearLayout.HORIZONTAL);
        else
            subLayer.setOrientation(LinearLayout.VERTICAL);

        for (int i=0;i<numOfViews;i++){
            Button btn=new Button(this);
            btn.setText("BTN "+i);
            btn.setWidth(20);
            btn.setHeight(10);
            subLayer.addView(btn);
        }
        scrollView.addView(subLayer);
        rootLayout.addView(scrollView);


    }

    class MyLstr implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            DatePickerDialog datePicker=new DatePickerDialog(MainActivity.this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            //You can directly set here;
                                txtView.setText(month+"/"+dayOfMonth+"/"+year);
                            }
                    },2017,2,20);
            //txtView.setText(datePicker.getDatePicker().getMonth()+"/"+datePicker.getDatePicker().getDayOfMonth()+"/"+
              //      datePicker.getDatePicker().getYear());
            datePicker.show();

        }
    }

    public void showAlert(View view) {
        AlertDialog.Builder alertBuilder=new AlertDialog.Builder(this);
        alertBuilder.setTitle("The title")
        .setMessage("Message inside Body..");
        alertBuilder.setPositiveButton("Agree", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertBuilder.show();
    }
}
