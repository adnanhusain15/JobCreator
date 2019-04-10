package com.example.user.jobcreator;

import android.Manifest;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.service.carrier.CarrierMessagingService;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bb=(Button) findViewById(R.id.sub);
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String c,i,b,t;
                EditText e1,e2,e3,e4;
                e1 = (EditText)findViewById(R.id.cgpa);
                e2 = (EditText)findViewById(R.id.insp);
                e3 = (EditText)findViewById(R.id.blog);
                e4 = (EditText)findViewById(R.id.tie);
                c=e1.getText().toString();
                i=e2.getText().toString();
                b=e3.getText().toString();
                t=e4.getText().toString();
                String AUTHORITY = "com.example.user.jobcreator.Directory";
                String PATH = "/details";
                Uri CONTENT_URI = Uri.parse("content://"+AUTHORITY+PATH);
                Cursor mcu = getContentResolver().query(CONTENT_URI,null,null,null,null,null);
                if(mcu.moveToFirst()){
                    int count=0;
                    do {
                        if((Float.parseFloat(mcu.getString(2))>Float.parseFloat(c)) && Integer.parseInt(mcu.getString(3))>Integer.parseInt(i) && Integer.parseInt(mcu.getString(4))<Integer.parseInt(b)) {

                            String n1 = mcu.getString(0);
                            Long numm = Long.parseLong(mcu.getString(1).toString());
                            String message = "Congratulations!\nDear "+n1+" you are eligible for a "+t+" in our Company.\n Sent by Amazing Job Portal";
                            System.out.println(message);
                            SmsManager sms = SmsManager.getDefault();
                           sms.sendTextMessage(numm.toString(), null, message, null, null);
                           count++;
                        }
                    }while (mcu.moveToNext());
                    Toast.makeText(getApplicationContext(),"Messages sent to "+count+" Applicants",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
