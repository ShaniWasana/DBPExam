package Model;

public class Teacher {
    private String TId;
    private String TName;
    private String T_NIC;
    private String TCNo;
    private String TAddress;

    public Teacher() {
    }

    public Teacher(String TId, String TName, String t_NIC, String TCNo, String TAddress) {
        this.TId = TId;
        this.TName = TName;
        T_NIC = t_NIC;
        this.TCNo = TCNo;
        this.TAddress = TAddress;
    }

    public String getTId() {
        return TId;
    }

    public void setTId(String TId) {
        this.TId = TId;
    }

    public String getTName() {
        return TName;
    }

    public void setTName(String TName) {
        this.TName = TName;
    }

    public String getT_NIC() {
        return T_NIC;
    }

    public void setT_NIC(String t_NIC) {
        T_NIC = t_NIC;
    }

    public String getTCNo() {
        return TCNo;
    }

    public void setTCNo(String TCNo) {
        this.TCNo = TCNo;
    }

    public String getTAddress() {
        return TAddress;
    }

    public void setTAddress(String TAddress) {
        this.TAddress = TAddress;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "TId='" + TId + '\'' +
                ", TName='" + TName + '\'' +
                ", T_NIC='" + T_NIC + '\'' +
                ", TCNo='" + TCNo + '\'' +
                ", TAddress='" + TAddress + '\'' +
                '}';
    }
}
