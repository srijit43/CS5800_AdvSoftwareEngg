public class CommissionEmployee extends  Employee{
    private Double commissionRate;
    private Double grossSales;


    public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, Double commissionRate, Double grossSales) {
        super(firstName, lastName, socialSecurityNumber);
        this.commissionRate = commissionRate;
        this.grossSales = grossSales;
    }

    public Double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(Double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public Double getGrossSales() {
        return grossSales;
    }

    public void setGrossSales(Double grossSales) {
        this.grossSales = grossSales;
    }
}
