package Model;

public class Student {
    private String SId;
    private String SName;
    private String Email;
    private String CNo;
    private String Address;
    private String NIC;

    public Student() {
    }

    public Student(String SId, String SName, String email, String CNo, String address, String NIC) {
        this.SId = SId;
        this.SName = SName;
        Email = email;
        this.CNo = CNo;
        Address = address;
        this.NIC = NIC;
    }

    public String getSId() {
        return SId;
    }

    public void setSId(String SId) {
        this.SId = SId;
    }

    public String getSName() {
        return SName;
    }

    public void setSName(String SName) {
        this.SName = SName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getCNo() {
        return CNo;
    }

    public void setCNo(String CNo) {
        this.CNo = CNo;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    @Override
    public String toString() {
        return "Student{" +
                "SId='" + SId + '\'' +
                ", SName='" + SName + '\'' +
                ", Email='" + Email + '\'' +
                ", CNo='" + CNo + '\'' +
                ", Address='" + Address + '\'' +
                ", NIC='" + NIC + '\'' +
                '}';
    }
}
