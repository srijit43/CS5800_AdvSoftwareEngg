public class Main {
    public static void main(String[] args) {
        SalariedEmployee salariedEmployee = new SalariedEmployee("Joe", "Jones", "111-11-1111", 2500.0);
        SalariedEmployee salariedEmployee1 = new SalariedEmployee("Renwa","Chanel", "555-55-5555",1750.0);

        HourlyEmployee hourlyEmployee = new HourlyEmployee("Stephanie","Smith","222-22-2222",25,32);
        HourlyEmployee hourlyEmployee1 = new HourlyEmployee("Mary","Quinn","333-33-3333",19,47);

        CommissionEmployee commissionEmployee = new CommissionEmployee("Nicole","Dior","444-44-4444",15.0,50000.0);
        CommissionEmployee commissionEmployee1 = new CommissionEmployee("Mahnaz","Vaziri", "777-77-7777",22.0, 40000.0);


        BaseEmployee baseEmployee = new BaseEmployee("Mike","Davenport", "666-66-6666",95000.0);

        printSalariedEmployee(salariedEmployee);
        printSalariedEmployee(salariedEmployee1);

        printHourlyEmployee(hourlyEmployee);
        printHourlyEmployee(hourlyEmployee1);

        printCommissionEmployee(commissionEmployee);
        printCommissionEmployee(commissionEmployee1);

        printBaseEmployee(baseEmployee);
    }

    public static void printSalariedEmployee(SalariedEmployee salariedEmployee){
        System.out.println("--- Salaried Employee ---");
        printEmployeeBasicInfo(salariedEmployee);
        System.out.println("Weekly Salary : " + salariedEmployee.getWeeklySalary());
    }

    public static void printEmployeeBasicInfo(Employee employee){
        System.out.println("First Name : " + employee.getFirstName());
        System.out.println("Last Name : " + employee.getLastName());
        System.out.println("Social Security Number : " + employee.getSSN());
    }

    public static void printHourlyEmployee(HourlyEmployee hourlyEmployee){
        System.out.println("--- Hourly Employee ---");
        printEmployeeBasicInfo(hourlyEmployee);
        System.out.println("Wage : $" + hourlyEmployee.getWage());
        System.out.println("Number of Hours Worked : " + hourlyEmployee.getHoursWorked());
    }

    public static void printCommissionEmployee(CommissionEmployee commissionEmployee){
        System.out.println("--- Commission Employee ---");
        printEmployeeBasicInfo(commissionEmployee);
        System.out.println("Commission Rate : " + commissionEmployee.getCommissionRate() +"%");
        System.out.println("Gross Sales: $" + commissionEmployee.getGrossSales());
    }

    public static void printBaseEmployee(BaseEmployee baseEmployee){
        System.out.println("--- Base Employee ---");
        printEmployeeBasicInfo(baseEmployee);
        System.out.println("Weekly Salary : $" + baseEmployee.getBaseSalary());
    }






}