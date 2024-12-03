import java.time.LocalDate;
import java.time.Period;

public class Employee extends Person {
    private String employeeId;
    private String position;
    private double salary;
    public LocalDate startDate;

    // Constructor
    public Employee() {}

    public Employee(String name, LocalDate birthDate, String email, String gender, Address address,
                    String employeeId, String position, double salary, LocalDate startDate) {
        super(name, birthDate, email, gender, address);
        this.employeeId = employeeId;
        this.position = position;
        this.salary = salary;
        this.startDate = startDate;
    }

    // Getters và Setters
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    public LocalDate getStartDate(){
        return startDate;
    }
    
    public void setFirstDate(LocalDate startDate){
        this.startDate=startDate;
    }

    // Tính số năm làm việc
    public int calculateYearsOfWork() {
        return Period.between(this.startDate, LocalDate.now()).getYears();
    }

    // Override nhập và xuất thông tin
    @Override
    public void inputInformation() {
        // Code nhập thông tin từ người dùng
    }

    @Override
    public void displayInformation() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Position: " + position);
        System.out.println("Years of Work: " + calculateYearsOfWork());
        System.out.println("Salary: " + salary);
        System.out.println("Address: " + address.toString());
    }
}
