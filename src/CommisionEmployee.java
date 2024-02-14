public class CommisionEmployee extends Employee{
    public float comissionRate;
    public double grossSales;

    public CommisionEmployee(String FirstName, String LastName, String SSN,float comissionRate,double grossSales){
        super(FirstName,LastName,SSN);
        this.comissionRate = comissionRate;
        this.grossSales = grossSales;

    }

    public void setComissionRate(float comissionRate){
        this.comissionRate = comissionRate;
    }

    public void setGrossSales(double grossSales){
        this.grossSales = grossSales;
    }

    public float getComissionRate(){
        return comissionRate;
    }

    public double getGrossSales(){
        return grossSales;
    }


}



