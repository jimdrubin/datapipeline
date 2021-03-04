package com.jdr.statedata;

public class State {

    String stateAbbrev;
    String district;
    String totalPossibleVoters;
    double percentVoted;
    String color;

    public void setColor() {
        // Hex values of colors lightest to darkest  "#6d66ff", "#3c33ff", "#0b00ff",  "#0900cc", "#070099",

        if(percentVoted <= .1){
            this.color = "#070099";
        }else if(percentVoted > .1 && percentVoted <= .25){
            this.color = "#0900cc";
        }else if(percentVoted > .25 && percentVoted <= .4){
            this.color = "#0b00ff";
        }else if(percentVoted > .4 && percentVoted <= .5){
            this.color = "#3c33ff";
        }else{
            this.color = "#6d66ff";
        }

    }

    public State(){}

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


}
