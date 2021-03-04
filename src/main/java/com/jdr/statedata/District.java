package com.jdr.statedata;

public class District {

    String stateAbbrev;
    String district;
    String totalPossibleVoters;
    double percentVoted;
    String color;

    public void setColor() {
        // Hex values of colors lightest to darkest  "#6d66ff", "#3c33ff", "#0b00ff",  "#0900cc", "#070099",

        if(percentVoted <= 2){
            this.color = "#b6d6cd";
        }else if(percentVoted > 2 && percentVoted <= 8){
            this.color = "#8cb9af";
        }else if(percentVoted > 8 && percentVoted <= 15){
            this.color = "#5a9587";
        }else if(percentVoted > 15 && percentVoted <= 30){
            this.color = "#2e7265";
        }else{
            this.color = "#15483e";
        }

    }

    public District(){}

    public String getStateAbbrev() {
        return stateAbbrev;
    }

    public void setStateAbbrev(String stateAbbrev) {
        this.stateAbbrev = stateAbbrev;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getTotalPossibleVoters() {
        return totalPossibleVoters;
    }

    public void setTotalPossibleVoters(String totalPossibleVoters) {
        this.totalPossibleVoters = totalPossibleVoters;
    }

    public Double getPercentVoted() {
        return percentVoted;
    }

    public void setPercentVoted(Double percentVoted) {
        this.percentVoted = percentVoted;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString(){
      return  "State:" + this.stateAbbrev + "  District:" + this.district + "  " + this.percentVoted
              + "  " + this.color;
    }
}
