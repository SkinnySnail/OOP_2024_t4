package Person;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeList {
    public List<Employee> employees;

    // Constructor
    public EmployeeList() {
        employees = new ArrayList<>();
    }

    // Thêm nhân viên vào danh sách
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    // Hiển thị thông tin nhân viên từ danh sách
    public void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("Danh sách nhân viên trống.");
        } else {
            for (Employee employee : employees) {
                employee.displayInformation();
                System.out.println("----------------------------");
            }
        }
    }

    // Tạo dữ liệu mẫu nếu danh sách trống
    public void createSampleData() {
        if (employees.isEmpty()) {
            Address address = new Address("456", "Nguyễn Huệ", "Quận 3", "TP.HCM");
            employees.add(new Employee("Lê Văn C", LocalDate.of(1985, 3, 10), "c@gmail.com", "Nam", address,
                    "NV001", "Quản lý", 15000000, LocalDate.of(2015, 6, 1)));
            employees.add(new Employee("Hoàng Thị D", LocalDate.of(1992, 7, 25), "d@gmail.com", "Nữ", address,
                    "NV002", "Nhân viên", 10000000, LocalDate.of(2020, 8, 15)));
        }
    }

    // Đọc dữ liệu nhân viên từ file
    public void loadFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Address address = new Address(data[4], data[5], data[6], data[7]);
                Employee employee = new Employee(data[0], LocalDate.parse(data[1]), data[2], data[3], address, data[8], data[9], Double.parseDouble(data[10]), LocalDate.parse(data[11]));
                employees.add(employee);
            }
        } catch (IOException e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
    }

    // Ghi thông tin nhân viên vào file
    public void saveToFile(String filePath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Employee employee : employees) {
                Address address = employee.getAddress();
                bw.write(String.join(",",
                        employee.getName(),
                        employee.getBirthDate().toString(),
                        employee.getEmail(),
                        employee.getGender(),
                        address.getStreetNumber(),
                        address.getStreetName(),
                        address.getDistrict(),
                        address.getCity(),
                        employee.getEmployeeId(),
                        employee.getPosition(),
                        String.valueOf(employee.getSalary()),
                        employee.getStartDate().toString()));
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }
    }

    // Lấy danh sách nhân viên
    public List<Employee> getListEmployee() {
        return employees;
    }
}

