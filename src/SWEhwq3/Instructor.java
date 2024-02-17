package SWEhwq3;

public class Instructor {
    private String firstName;
    private String lastName;
    private String OfficeNo;

    public Instructor(String firstName,String lastName,String OfficeNo){
        this.firstName = firstName;
        this.lastName = lastName;
        this.OfficeNo = OfficeNo;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setOfficeNo(String officeNo) {
        OfficeNo = officeNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getOfficeNo() {
        return OfficeNo;
    }
}
