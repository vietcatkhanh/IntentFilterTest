package com.vietit.intentfiltertest;
// Bui Quoc Viet - 15110362 - Lop sang thu 4 - 26/03/2018
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    private EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit = (EditText) findViewById(R.id.recipient);

        // Use ACTION_SENDTO action with correct data
        Button sms1 = (Button) findViewById(R.id.sendto_sms);
        sms1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String uri = "smsto:" +  edit.getText().toString();
                Intent i = new Intent(android.content.Intent.ACTION_SENDTO,
                        Uri.parse(uri));
                startActivity(i);
            }
        });

        // Use our custom SMS_INTENT intent with correct data
        Button sms2 = (Button) findViewById(R.id.smsintent_sms);
        sms2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String uri = "smsto:" + edit.getText().toString();
                Intent i = new Intent("com.example.vietit.SMS_INTENT",
                        Uri.parse(uri));
                // put extra field
                i.putExtra("from", "vietit");
                startActivity(i);
            }
        });

        // Use our custom SMS_INTENT intent with incorrect data
        Button exception = (Button) findViewById(R.id.exception);
        exception.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String uri = "mailto:" + edit.getText().toString();
                Intent i = new Intent("com.example.vietit.SMS_INTENT",
                        Uri.parse(uri));
                i.putExtra("from", "vietit");
                startActivity(i);

            }
        });

    }

}