public class HourlyEmployee extends Employee{
    public float wage;
    public float hoursWorked;

    public HourlyEmployee(String FirstName, String LastName, String SSN,float wage,float hoursWorked){
        super(FirstName,LastName,SSN);
        this.wage = wage;
        this.hoursWorked = hoursWorked;
    }

    public void setWage(float wage){
        this.wage = wage;
    }

    public void setHoursWorked(float hoursWorked){
        this.hoursWorked = hoursWorked;
    }

    public float getWage(){
        return wage;
    }

    public float getHoursWorked(){
        return hoursWorked;
    }
}
