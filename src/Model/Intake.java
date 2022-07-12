package Model;

import java.util.Date;

public class Intake {
    private String Iid;
    private Date Start_Date;
    private String Intake_Col;
    private String Description;
    private String CId;

    public Intake() {
    }

    public Intake(String iid, Date start_Date, String intake_Col, String description, String CId) {
        Iid = iid;
        Start_Date = start_Date;
        Intake_Col = intake_Col;
        Description = description;
        this.CId = CId;
    }

    public String getIid() {
        return Iid;
    }

    public void setIid(String iid) {
        Iid = iid;
    }

    public Date getStart_Date() {
        return Start_Date;
    }

    public void setStart_Date(Date start_Date) {
        Start_Date = start_Date;
    }

    public String getIntake_Col() {
        return Intake_Col;
    }

    public void setIntake_Col(String intake_Col) {
        Intake_Col = intake_Col;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCId() {
        return CId;
    }

    public void setCId(String CId) {
        this.CId = CId;
    }

    @Override
    public String toString() {
        return "Intake{" +
                "Iid='" + Iid + '\'' +
                ", Start_Date=" + Start_Date +
                ", Intake_Col='" + Intake_Col + '\'' +
                ", Description='" + Description + '\'' +
                ", CId='" + CId + '\'' +
                '}';
    }
}
