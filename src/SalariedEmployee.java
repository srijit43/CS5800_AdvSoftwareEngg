public class SalariedEmployee extends Employee{
    public double WeeklySalary;

    /*public WeeklySalary(int WeeklySalary){
        this.WeeklySalary = WeeklySalary;
    }*/

    public SalariedEmployee(String FirstName, String LastName, String SSN,double WeeklySalary){
        super(FirstName,LastName,SSN);
        this.WeeklySalary = WeeklySalary;
    }

    public void setWeeklySalary(double WeeklySalary){
        this.WeeklySalary = WeeklySalary;
    }

    public double getWeeklySalary(){
        return WeeklySalary;
    }

    /*@Override
    public String toString() {
        return "SalariedEmployee \n" +
                "First Name    : " + getFirstName() + "\n" +
                "Last Name     : " + getLastName() + "\n" +
                "SSN           : " + getSSN() + "\n" +
                "Weekly Salary : $" + this.WeeklySalary;
    }*/


}
