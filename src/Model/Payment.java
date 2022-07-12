package Model;

import java.util.Date;

public class Payment {
    private String PId;
    private Date date;
    private double PCost;
    private String Rid;

    public Payment() {
    }

    public Payment(String PId, Date date, double PCost, String rid) {
        this.PId = PId;
        this.date = date;
        this.PCost = PCost;
        Rid = rid;
    }

    public String getPId() {
        return PId;
    }

    public void setPId(String PId) {
        this.PId = PId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPCost() {
        return PCost;
    }

    public void setPCost(double PCost) {
        this.PCost = PCost;
    }

    public String getRid() {
        return Rid;
    }

    public void setRid(String rid) {
        Rid = rid;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "PId='" + PId + '\'' +
                ", date=" + date +
                ", PCost=" + PCost +
                ", Rid='" + Rid + '\'' +
                '}';
    }
}
