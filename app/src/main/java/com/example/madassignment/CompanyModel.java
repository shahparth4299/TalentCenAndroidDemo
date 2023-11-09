package com.example.madassignment;

import java.io.Serializable;

public class CompanyModel implements Serializable {
    String name, vision, mission, description, jobsAvailable, companyLogo, careerPageLink, rating, reviews;

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVision() {
        return vision;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getJobsAvailable() {
        return jobsAvailable;
    }

    public void setJobsAvailable(String jobsAvailable) {
        this.jobsAvailable = jobsAvailable;
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }

    public String getCareerPageLink() {
        return careerPageLink;
    }

    public void setCareerPageLink(String careerPageLink) {
        this.careerPageLink = careerPageLink;
    }

    public CompanyModel(String name, String vision, String mission, String description, String jobsAvailable, String companyLogo, String careerPageLink, String rating, String reviews) {
        this.name = name;
        this.vision = vision;
        this.mission = mission;
        this.description = description;
        this.jobsAvailable = jobsAvailable;
        this.companyLogo = companyLogo;
        this.careerPageLink = careerPageLink;
        this.rating = rating;
        this.reviews = reviews;
    }
}
