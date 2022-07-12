package Model;

import java.util.Date;

public class Course {
    private String CId;
    private String CName;
    private double Cost;
    private String Duration;
    private String SId;

    public Course() {
    }

    public Course(String CId, String CName, double cost, String duration, String SId) {
        this.CId = CId;
        this.CName = CName;
        Cost = cost;
        Duration = duration;
        this.SId = SId;
    }

    public String getCId() {
        return CId;
    }

    public void setCId(String CId) {
        this.CId = CId;
    }

    public String getCName() {
        return CName;
    }

    public void setCName(String CName) {
        this.CName = CName;
    }

    public double getCost() {
        return Cost;
    }

    public void setCost(double cost) {
        Cost = cost;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public String getSId() {
        return SId;
    }

    public void setSId(String SId) {
        this.SId = SId;
    }

    @Override
    public String toString() {
        return "Course{" +
                "CId='" + CId + '\'' +
                ", CName='" + CName + '\'' +
                ", Cost=" + Cost +
                ", Duration='" + Duration + '\'' +
                ", SId='" + SId + '\'' +
                '}';
    }
}
