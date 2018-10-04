package com.example.fitri.conapps;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    static final int REQUEST_CODE_ADD = 1;
    static final int REQUEST_CODE_MAIN2 = 2;
    DBHelper mydb = new DBHelper(this);
    List<ContactInfo> contactInfoList;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        SearchView searchView = findViewById(R.id.search_bar);


        contactInfoList =(ArrayList<ContactInfo>) mydb.getAllCotacts();

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        final MyItemRecyclerViewAdapter adapter = getRecyclerAdapter(contactInfoList);
        recyclerView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {

                if(s.equals(""))
                {
                    iniDsplay();

                }
                else
                {
                    contactInfoList = mydb.getData(s);
                    if(contactInfoList.isEmpty())
                    {
                        Toast.makeText(getBaseContext(), s + " Not found",Toast.LENGTH_SHORT).show();
                        MyItemRecyclerViewAdapter adapter1 = getRecyclerAdapter(contactInfoList);
                        recyclerView.setAdapter(adapter1);
                    }
                    else
                    {
                        Log.d("SEARCH TEST", contactInfoList.get(0).getNAME());
                        MyItemRecyclerViewAdapter adapter1 = getRecyclerAdapter(contactInfoList);
                        recyclerView.setAdapter(adapter1);
                    }

                }

                 return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
               // if(s.equals(""))
                //{
                    recyclerView.setAdapter(adapter);
                //}

                return false;
            }


        });





        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                Intent intent = new Intent(MainActivity.this, AddPeopleActivity.class);
                startActivityForResult(intent,REQUEST_CODE_ADD);
                //startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        iniDsplay();
    }


    private void iniDsplay()
    {
        Intent refresh = new Intent(this, MainActivity.class);
        startActivity(refresh);//Start the same Activity
        finish(); //finish Activity.
    }




private MyItemRecyclerViewAdapter getRecyclerAdapter(final List<ContactInfo> contactInfoList)
{
    MyItemRecyclerViewAdapter adapter = new MyItemRecyclerViewAdapter(contactInfoList, MainActivity.this, new MyItemRecyclerViewAdapter.OnItemClicked() {
        @Override
        public void onItemClick(View view, int position) {
            Toast.makeText(MainActivity.this, contactInfoList.get(position).getNAME(), Toast.LENGTH_SHORT).show();

            Bundle bundle = new Bundle();
            bundle.putInt("ID",contactInfoList.get(position).getID());


            Intent intent = new Intent(MainActivity.this,Main2Activity.class);
            intent.putExtras(bundle);
            startActivity(intent);

        }
    });
    return  adapter;
}


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mydb.close();
    }


}
