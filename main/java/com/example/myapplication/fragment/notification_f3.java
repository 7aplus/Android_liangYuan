package com.example.myapplication.fragment;

public class notification_f3 {

    private String fragment3_item_date_input;
    private String fragment3_item_name_input;
    private String fragment3_item_feedback_input;
    private int fragment3_item_image;
    private String fragment3_item_feedback;

    public notification_f3(String fragment3_item_date_input, String fragment3_item_name_input, String fragment3_item_feedback_input, int fragment3_item_image, String fragment3_item_feedback){
        this.fragment3_item_date_input = fragment3_item_date_input;
        this.fragment3_item_name_input = fragment3_item_name_input;
        this.fragment3_item_feedback_input = fragment3_item_feedback_input;
        this.fragment3_item_image = fragment3_item_image;
        this.fragment3_item_feedback = fragment3_item_feedback;
    }

    public String getFragment3_item_date_input() {
        return  fragment3_item_date_input;
    }

    public void setFragment3_item_date_input(String fragment3_item_date_input){
        this.fragment3_item_date_input = fragment3_item_date_input;
    }

    public String getFragment3_item_name_input() {
        return  fragment3_item_name_input;
    }

    public void setFragment3_item_name_input(String fragment3_item_name_input){
        this.fragment3_item_name_input = fragment3_item_name_input;
    }

    public String getFragment3_item_feedback_input(){
        return  fragment3_item_feedback_input;
    }

    public void setFragment3_item_feedback_input(String fragment3_item_feedback_input){
        this.fragment3_item_feedback_input = fragment3_item_feedback_input;
    }

    public int getFragment3_item_image(){
        return fragment3_item_image;
    }

    public void setFragment3_item_image(int fragment3_item_image){
        this.fragment3_item_image = fragment3_item_image;
    }

    public String getFragment3_item_feedback(){
        return fragment3_item_feedback;
    }

    public void setFragment3_item_feedback(String fragment3_item_feedback){
        this.fragment3_item_feedback = fragment3_item_feedback;
    }

}
