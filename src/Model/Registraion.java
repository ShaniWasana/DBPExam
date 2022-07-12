package Model;

import java.util.Date;

public class Registraion {
    private String Rid;
    private Date RDate;
    private String SId;
    private String Iid;

    public Registraion() {
    }

    public Registraion(String rid, Date RDate, String SId, String iid) {
        Rid = rid;
        this.RDate = RDate;
        this.SId = SId;
        Iid = iid;
    }

    public String getRid() {
        return Rid;
    }

    public void setRid(String rid) {
        Rid = rid;
    }

    public Date getRDate() {
        return RDate;
    }

    public void setRDate(Date RDate) {
        this.RDate = RDate;
    }

    public String getSId() {
        return SId;
    }

    public void setSId(String SId) {
        this.SId = SId;
    }

    public String getIid() {
        return Iid;
    }

    public void setIid(String iid) {
        Iid = iid;
    }

    @Override
    public String toString() {
        return "Registraion{" +
                "Rid='" + Rid + '\'' +
                ", RDate=" + RDate +
                ", SId='" + SId + '\'' +
                ", Iid='" + Iid + '\'' +
                '}';
    }
}
