package com.example.madassignment;

import android.content.Context;
import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ReadXML implements Serializable {
    private CategoryModel[] data;
    Context context;

    public ReadXML(Context context){
        this.context = context;

        InputStream stream = null;
        DocumentBuilder builder = null;
        Document document = null;
        Log.e("ERROR", "in XML parsing");
        try {
            stream = this.context.getResources().openRawResource(R.raw.talentcen);
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            document = builder.parse(stream);
        } catch (Exception e) {
            Log.e("PARTH TEST", e.toString());
        }
        Log.e("ERROR", "Docment is made");
        NodeList nameList = document.getElementsByTagName("name");
        NodeList imageList = document.getElementsByTagName("image");
        NodeList totalList = document.getElementsByTagName("total_companies");
        NodeList sectionList = document.getElementsByTagName("section");
        Log.e("ERROR", "Slicing done");
        data = new CategoryModel[nameList.getLength()];
        for (int i=0;i<nameList.getLength();i++) {
            String name = nameList.item(i).getFirstChild().getNodeValue();
            String image = imageList.item(i).getFirstChild().getNodeValue();
            String total_companies = totalList.item(i).getFirstChild().getNodeValue();
            List<CompanyModel> companyList = new ArrayList<>();
            Node section = sectionList.item(i);
            Element sectionElement = (Element) section;
            NodeList companiesList = sectionElement.getElementsByTagName("company");
            for (int j=0;j<companiesList.getLength();j++) {

                Node companyNode = companiesList.item(j);
                if (companyNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element companyElement = (Element) companyNode;
                    String companyName = companyElement.getElementsByTagName("companyName").item(0).getTextContent();
                    String vision = companyElement.getElementsByTagName("vision").item(0).getTextContent();
                    String mission = companyElement.getElementsByTagName("mission").item(0).getTextContent();
                    String description = companyElement.getElementsByTagName("description").item(0).getTextContent();
                    String jobsAvailable = companyElement.getElementsByTagName("jobs_available").item(0).getTextContent();
                    String companyLogo = companyElement.getElementsByTagName("company_logo").item(0).getTextContent();
                    String careerPageLink = companyElement.getElementsByTagName("career_page_link").item(0).getTextContent();
                    String rating = companyElement.getElementsByTagName("rating").item(0).getTextContent();
                    String reviews = companyElement.getElementsByTagName("reviews").item(0).getTextContent();
                    Log.d("Company Details", "Name: " + companyName + ", Vision: " + vision + ", Mission: " + mission);
                    CompanyModel cm = new CompanyModel(companyName, vision, mission, description, jobsAvailable, companyLogo, careerPageLink, rating, reviews);
                    companyList.add (cm);
                }
            }
            data[i] = new CategoryModel(name, image, total_companies, companyList);
        }
    }

    public int getCount(){return data.length;}

    public CategoryModel getCategoryModel(int i){return data[i];}
    public String [] getCategoryNames(){
        String [] names = new String[getCount()];
        for(int i=0;i<getCount();i++)
            names[i] = data[i].getSectionName();
        return names;
    }

    public String [] getCompanyNames(int position){
        List<CompanyModel> cm = data[position].getCompanies();
        String companyNames[] = new String[cm.size()];
        int i=0;
        for (CompanyModel c : cm) {
            companyNames[i++] = c.getName();
        }
        return companyNames;
    }

    public int [] getCompanyLogo(int position){
        List<CompanyModel> cm = data[position].getCompanies();
        int companyLogos[] = new int[cm.size()];
        int i=0;
        for (CompanyModel c : cm) {
            String imageName = c.getCompanyLogo();
            imageName = imageName.substring(0,imageName.indexOf("."));
            companyLogos[i++] = context.getResources().getIdentifier(imageName,
                    "drawable", context.getPackageName());
        }
        return companyLogos;
    }

    public String [] getJobsAvailableInCompany(int position){
        List<CompanyModel> cm = data[position].getCompanies();
        String jobsAvailable[] = new String[cm.size()];
        int i=0;
        for (CompanyModel c : cm) {
            jobsAvailable[i++] = c.getJobsAvailable();
        }
        return jobsAvailable;
    }

    public String [] getReviewsAndRatings(int position){
        List<CompanyModel> cm = data[position].getCompanies();
        String ratingsReviews[] = new String[cm.size()];
        int i=0;
        for (CompanyModel c : cm) {
            ratingsReviews[i++] = c.getRating() + "  |  " + c.getReviews();
        }
        return ratingsReviews;
    }

    public CompanyModel getCompanyData (int sectionPosition, int companyPosition) {
        return data[sectionPosition].getCompanies().get(companyPosition);
    }
    public String [] getTotalCompanies(){
        String [] totalCompanies = new String[getCount()];
        for(int i=0;i<getCount();i++)
            totalCompanies[i] = data[i].getTotalCompanies();
        return totalCompanies;
    }

    public int [] getImageIds(){
        int [] imageIds = new int[getCount()];
        for(int i=0;i<getCount();i++){
            String imageName = data[i].getImage();
            imageName = imageName.substring(0,imageName.indexOf("."));
            imageIds[i] = context.getResources().getIdentifier(imageName,
                    "drawable", context.getPackageName());
        }
        return imageIds;
    }
}
