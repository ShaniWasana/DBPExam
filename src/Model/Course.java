package Model;

import java.util.Date;

public class Course {
    private String CId;
    private String CName;
    private double Cost;
    private String Duration;
    private String SubId;

    public Course(String CId, String CName, double cost, String duration, String subId) {
        this.CId = CId;
        this.CName = CName;
        Cost = cost;
        Duration = duration;
        SubId = subId;
    }

    public Course() {
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

    public String getSubId() {
        return SubId;
    }

    public void setSubId(String subId) {
        SubId = subId;
    }

    @Override
    public String toString() {
        return "Course{" +
                "CId='" + CId + '\'' +
                ", CName='" + CName + '\'' +
                ", Cost=" + Cost +
                ", Duration='" + Duration + '\'' +
                ", SubId='" + SubId + '\'' +
                '}';
    }
}