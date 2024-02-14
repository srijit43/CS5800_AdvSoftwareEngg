public class Employee {
    private String FirstName;      /* variable declarations*/
    private String LastName;
    private String SSN;

    public Employee(String FirstName, String LastName, String SSN) {   /*constructor for the class Employee)*/
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.SSN = SSN;

    }

    public Employee(){

    }

    public void setFirstName(String FirstName){            /*setters and getters*/
        this.FirstName = FirstName;

    }

    public void setLastName(String LastName){
        this.LastName = LastName;
    }

    public void setSSN(String SSN){
        this.SSN = SSN;
    }

    public String getFirstName(String FirstName){
        return FirstName;
    }

    public String getLastName(String LastName){
        return FirstName;
    }

    public String getSSN(String SSN){
        return SSN;
    }


}


