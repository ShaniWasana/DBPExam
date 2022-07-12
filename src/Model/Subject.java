package Model;

public class Subject {
    private String SubId;
    private String SubName;
    private double Credit;
    private String TId;

    public Subject() {
    }

    public Subject(String subId, String subName, double credit, String TId) {
        SubId = subId;
        SubName = subName;
        Credit = credit;
        this.TId = TId;
    }

    public String getSubId() {
        return SubId;
    }

    public void setSubId(String subId) {
        SubId = subId;
    }

    public String getSubName() {
        return SubName;
    }

    public void setSubName(String subName) {
        SubName = subName;
    }

    public double getCredit() {
        return Credit;
    }

    public void setCredit(double credit) {
        Credit = credit;
    }

    public String getTId() {
        return TId;
    }

    public void setTId(String TId) {
        this.TId = TId;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "SubId='" + SubId + '\'' +
                ", SubName='" + SubName + '\'' +
                ", Credit=" + Credit +
                ", TId='" + TId + '\'' +
                '}';
    }
}
