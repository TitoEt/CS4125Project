package com.castletroymedical.dto;

public class InstalmentPlanDTO {
    private double total;
    private int numberInstalments;
    private int breakPeriod;
    private final static int minInstalments = 2;
    private final static int minBreakPeriod = 30;

    public InstalmentPlanDTO() {
    }

    public InstalmentPlanDTO(double total) {
        this.total = total;
    }

    public InstalmentPlanDTO(double total, int numberInstalments, int breakPeriod) {
        this.total = total;
        this.numberInstalments = numberInstalments;
        this.breakPeriod = breakPeriod;
    }

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getNumberInstalments() {
        return this.numberInstalments;
    }

    public void setNumberInstalments(int numberInstalments) {
        if(numberInstalments <= minInstalments) {
            this.numberInstalments = minInstalments;
        }
        else {
            this.numberInstalments = numberInstalments;
        }        
    }

    public int getBreakPeriod() {
        return this.breakPeriod;
    }

    public void setBreakPeriod(int breakPeriod) {
        if(breakPeriod <= minBreakPeriod) {
            this.breakPeriod = minBreakPeriod;
        }
        else {
            this.breakPeriod = breakPeriod;
        }        
    }

    public int getMinInstalments() {
        return this.minInstalments;
    }

    public int getMinBreakPeriod() {
        return this.minBreakPeriod;
    }

}
