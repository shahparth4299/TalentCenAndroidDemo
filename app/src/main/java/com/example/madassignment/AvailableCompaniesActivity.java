package com.example.madassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AvailableCompaniesActivity extends AppCompatActivity implements RecyclerViewInterface{
    String [] companyNames = null;
    int [] companyLogos  = null;
    String[] companyVision = null;
    RecyclerView list = null;
    CompanyRecycleAdapter adapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_companies);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        CategoryModel cm = (CategoryModel) bundle.getSerializable("section");
        companyNames = bundle.getStringArray("companyNames");
        companyLogos = bundle.getIntArray("companyLogos");
        companyVision = bundle.getStringArray("companyNames");

        list = findViewById(R.id.listOfCompanies);
        list.setLayoutManager(new LinearLayoutManager(this));

        adapter = new CompanyRecycleAdapter(getApplicationContext(), R.layout.companies_list, companyNames, companyLogos, companyVision, this);
        list.setAdapter(adapter);
    }

    public void onItemClick(int position) {
        Toast.makeText(this, "selected "+companyNames[position], Toast.LENGTH_SHORT).show();

    }
}