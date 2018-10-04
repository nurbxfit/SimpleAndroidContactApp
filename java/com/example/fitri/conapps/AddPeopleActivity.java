package com.example.fitri.conapps;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.app.PendingIntent.getActivity;

public class AddPeopleActivity extends AppCompatActivity {
    DBHelper mydb = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_people);

        final Button submit = (Button) findViewById(R.id.addButton);
        final EditText newName = (EditText) findViewById(R.id.newName);
        final EditText newEmail = (EditText) findViewById(R.id.newemail);
        final EditText newPhone = (EditText) findViewById(R.id.newPhone);
        final EditText newAddress = (EditText) findViewById(R.id.newAddress);

        final Bundle editbundle = getIntent().getExtras();
        //check if the user intent to edit or to add new contact
        if(editbundle != null)
        {
            //if != null then user are want to edit existing contact
            //load the current contact info into the view
            ContactInfo contactInfo = mydb.getDataByID(editbundle.getInt("ID"));
            newName.setText(contactInfo.getNAME());
            newEmail.setText(contactInfo.getEMAIL());
            newAddress.setText(contactInfo.getADDRESS());
            newPhone.setText(contactInfo.getNUMBER());
            //change the existing add new text button to edit
            submit.setText("Edit");
        }

        //create a listener to listen to when the button clicked
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //check if the field entered is empty or not
                if(newName.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Name cannot be Empty",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(!(newPhone.getText().toString().equals("")))
                    {
                        //if all field are ok, check if the user want to add new of edit

                        //this is for add new contact
                        if(editbundle == null)
                        {
                            Toast.makeText(getApplicationContext(),"Add to Contact",Toast.LENGTH_SHORT).show();
                            mydb.insertContact(newName.getText().toString(),newPhone.getText().toString(),newEmail.getText().toString(),newAddress.getText().toString());
                            mydb.close();
                            finish();
                        }
                        //this is for edit current contact
                        else
                        {
                            Toast.makeText(getApplicationContext(),"Contact edited",Toast.LENGTH_SHORT).show();
                            mydb.updateContact(editbundle.getInt("ID"),newName.getText().toString(),newPhone.getText().toString(),newEmail.getText().toString(),newAddress.getText().toString());
                            Intent refresh = new Intent(AddPeopleActivity.this, MainActivity.class);
                            startActivity(refresh);//Start the MainActivity
                            finish(); //finish current Activity.

                        }


                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Phone Number is Empty",Toast.LENGTH_SHORT).show();
                    }
                }
            }


        });




    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //when user exit this activity the database will close to avoid leaked
        mydb.close();
    }
}
