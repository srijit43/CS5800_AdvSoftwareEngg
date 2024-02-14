public class BaseEmployee extends Employee{
    public double baseSalary;

    public BaseEmployee(String FirstName, String LastName, String SSN,double baseSalary){
        super(FirstName,LastName,SSN);
        this.baseSalary = baseSalary;
    }

    public void setBaseSalary(int baseSalary){
        this.baseSalary = baseSalary;

    }

    public double getBaseSalary(){
        return baseSalary;
    }
}
