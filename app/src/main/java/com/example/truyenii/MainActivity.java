package com.example.truyenii;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;
    Toolbar toolbar;
    ListView listView;
    String[] title;
    String[] ten;
    int[] icon;
    ArrayList<Model> arrayList = new ArrayList<Model>();
    ViewFlipper viewFlipper;
    String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry",
            "WebOS","Ubuntu","Windows7","Max OS X"};
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.listview,mobileArray);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                Bundle bundle = new Bundle();
                bundle.putInt("pos", position);
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("data",bundle);
                startActivity(intent);
            }
        });

        dl = (DrawerLayout)findViewById(R.id.dl);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("TruyenQQ");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.menu);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //finish();
                dl.openDrawer(GravityCompat.START);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);

        //Lấy search view
        MenuItem menuItem = menu.findItem(R.id.menuSearch);
        SearchView searchView = (SearchView) menuItem.getActionView();

        //Set search view
        searchView.setQueryHint("Tìm kiếm  ...");
        searchView.setMaxWidth(Integer.MAX_VALUE);

        //Bắt sự kiện search view
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                Log.d("Tag", s);
                return false;
            }
        });
        return true;
    }
    //    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        return abdt.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
//    }
}
