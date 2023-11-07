package com.example.madassignment;

import java.io.Serializable;
import java.util.List;

public class CategoryModel implements Serializable {
    String sectionName, image, totalCompanies;

    public List<CompanyModel> getCompanies() {
        return companies;
    }

    public void setCompanies(List<CompanyModel> companies) {
        this.companies = companies;
    }

    List<CompanyModel> companies;

    public CategoryModel(String sectionName, String image, String totalCompanies, List<CompanyModel> companies) {
        this.sectionName = sectionName;
        this.image = image;
        this.totalCompanies = totalCompanies;
        this.companies = companies;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTotalCompanies() {
        return totalCompanies;
    }

    public void setTotalCompanies(String totalCompanies) {
        this.totalCompanies = totalCompanies;
    }
}
