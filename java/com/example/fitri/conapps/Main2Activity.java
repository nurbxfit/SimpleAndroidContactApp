package com.example.fitri.conapps;

import android.app.SearchManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class Main2Activity extends AppCompatActivity {
    DBHelper mydatabase = new DBHelper(this);

   Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        CardView card1 = (CardView) findViewById(R.id.Card1);
        CardView card2 = (CardView) findViewById(R.id.Card2);
        CardView card3 = (CardView) findViewById(R.id.Card3);


        bundle = getIntent().getExtras();
        TextView detailsName = (TextView) findViewById(R.id.detail_name);
        TextView detailsEmail = (TextView) findViewById(R.id.emailAddress);
        TextView detailsPhone = (TextView) findViewById(R.id.phonenumber);
        TextView detailsAddress = (TextView) findViewById(R.id.HomeAddress);

        Log.d("BUNDLE TEST", String.valueOf(bundle.getInt("ID")));
        final ContactInfo contactInfo = mydatabase.getDataByID(bundle.getInt("ID"));

        Log.d("AFTER BUNDLE TEST", "AFter get from db " + String.valueOf(bundle.getInt("ID")));
        detailsName.setText(contactInfo.getNAME());
        detailsAddress.setText(contactInfo.getADDRESS());
        detailsPhone.setText(contactInfo.getNUMBER());
        detailsEmail.setText(contactInfo.getEMAIL());

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "Phone call", Toast.LENGTH_SHORT).show();
                Intent callIntent = new Intent(Intent.ACTION_DIAL);

                callIntent.setData(Uri.parse("tel:" + contactInfo.getNUMBER()));
                callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(callIntent);
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(),"Email",Toast.LENGTH_SHORT).show();
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setType("message/rfc822");
                emailIntent.setData(Uri.parse("mailto: "+ contactInfo.getEMAIL()));
                startActivity(Intent.createChooser(emailIntent, "Choose an email client from..."));
            }
        });
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(),"Address",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH );
                intent.putExtra(SearchManager.QUERY, contactInfo.getADDRESS());
                startActivity(intent);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabMessage);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent messageIntent = new Intent(Intent.ACTION_VIEW);
                messageIntent.setData(Uri.parse("sms:"+contactInfo.getNUMBER()));

                startActivity(messageIntent);
            }
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

        if (id == R.id.action_delete) {

            android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(this);
            builder.setMessage(R.string.deleteContact)
                    .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                            mydatabase.deleteContact(bundle.getInt("ID"));
                            Toast.makeText(getApplicationContext(), "Deleted Successfully",
                                    Toast.LENGTH_SHORT).show();
                            mydatabase.close();
                            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(intent);
                        }
                    })
                    .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // User cancelled the dialog
                        }
                    });

            android.support.v7.app.AlertDialog d = builder.create();
            d.setTitle("Are you sure");
            d.show();


            return true;
        } if (id == R.id.action_edit)
        {

            Toast.makeText(getBaseContext(),"Edit Contact",Toast.LENGTH_SHORT).show();
            Intent editIntent = new Intent(Main2Activity.this,AddPeopleActivity.class);
            editIntent.putExtras(bundle);
            startActivity(editIntent);
            finish();
        }
        ;

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mydatabase.close();
    }
}
