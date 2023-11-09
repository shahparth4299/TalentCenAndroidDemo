package com.example.madassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {
    String [] sections = null;
    int    [] imageIds  = null;
    String[] totalCompanies = null;
    RecyclerView list = null;
    SectionRecycleAdapter adapter = null;
    ReadXML data = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar t = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(t);

        list = findViewById(R.id.sectionView);
        list.setLayoutManager(new LinearLayoutManager(this));
        data = new ReadXML(this);

        sections = data.getCategoryNames();
        imageIds = data.getImageIds();
        totalCompanies = data.getTotalCompanies();

        adapter = new SectionRecycleAdapter(getApplicationContext(), R.layout.card_view, sections, imageIds, totalCompanies, this);
        list.setAdapter(adapter);
    }
    @Override
    public void onItemClick(int position) {
        Toast.makeText(this, "selected "+sections[position], Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, AvailableCompaniesActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("sectionPosition", position);
        bundle.putSerializable("section", data.getCategoryModel(position));
        bundle.putStringArray("companyNames", data.getCompanyNames(position));
        bundle.putStringArray("companyRatingAndReviews", data.getReviewsAndRatings(position));
        bundle.putIntArray("companyLogos", data.getCompanyLogo(position));
        bundle.putStringArray("jobsAvailable", data.getJobsAvailableInCompany(position));
        intent.putExtras(bundle);
        startActivity(intent);
    }
}