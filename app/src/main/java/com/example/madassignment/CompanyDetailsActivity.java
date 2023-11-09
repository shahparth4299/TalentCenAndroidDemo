package com.example.madassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class CompanyDetailsActivity extends AppCompatActivity {
    TextView cName, visionData, missionData, descriptionData, availableJObs, reviews;

    ImageView cImage;

    Button applyNow;

    RatingBar ratingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_details);

        Toolbar t = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(t);

        cName = (TextView) findViewById(R.id.cName);
        visionData = (TextView) findViewById(R.id.visionData);
        missionData = (TextView) findViewById(R.id.missionData);
        descriptionData = (TextView) findViewById(R.id.descriptionData);
        availableJObs = (TextView) findViewById(R.id.availableJobs);
        reviews = (TextView) findViewById(R.id.reviews);
        cImage = (ImageView) findViewById(R.id.cImage);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);

        applyNow = (Button) findViewById(R.id.applyNow);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        CompanyModel cm = (CompanyModel) bundle.getSerializable("companyDetails");

        cName.setText(cm.getName());
        visionData.setText(cm.getVision());
        missionData.setText(cm.getMission());
        descriptionData.setText(cm.getDescription());
        availableJObs.setText(cm.getJobsAvailable());
        reviews.setText(cm.getReviews());

        String imageName = cm.getCompanyLogo();
        imageName = "@drawable/" + imageName.substring(0,imageName.indexOf("."));
        int imageResource = getResources().getIdentifier(imageName, null, getPackageName());
        Drawable res = getResources().getDrawable(imageResource);
        cImage.setImageDrawable(res);
        ratingBar.setRating(Float.parseFloat(cm.getRating()));
        applyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = cm.getCareerPageLink();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }
}