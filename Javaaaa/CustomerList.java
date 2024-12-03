import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class CustomerList {
    public List<Customer> customers;

    // Constructor
    public CustomerList() {
        customers = new ArrayList<>();
    }

    // Thêm khách hàng vào danh sách
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    // Hiển thị thông tin khách hàng từ danh sách
    public void displayCustomers() {
        if (customers.isEmpty()) {
            System.out.println("Danh sách khách hàng trống.");
        } else {
            for (Customer customer : customers) {
                customer.displayInformation();
                System.out.println("----------------------------");
            }
        }
    }

    // Tạo dữ liệu mẫu nếu danh sách trống
    public void createSampleData() {
        if (customers.isEmpty()) {
            Address address = new Address("123", "Lê Lợi", "Quận 1", "TP.HCM");
            customers.add(new Customer("Nguyễn Văn A", LocalDate.of(1990, 1, 15), "a@gmail.com", "Nam", address,
                    "KH001", "VIP", 1000));
            customers.add(new Customer("Trần Thị B", LocalDate.of(1995, 5, 20), "b@gmail.com", "Nữ", address,
                    "KH002", "Thường", 500));
        }
    }

    // Đọc dữ liệu khách hàng từ file
    public void loadFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Address address = new Address(data[4], data[5], data[6], data[7]);
                Customer customer = new Customer(data[0], LocalDate.parse(data[1]), data[2], data[3], address,
                        data[8], data[9], Integer.parseInt(data[10]));
                customers.add(customer);
            }
        } catch (IOException e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
    }

    // Ghi thông tin khách hàng vào file
    public void saveToFile(String filePath){
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Customer customer : customers) {
                Address address = customer.getAddress();
                bw.write(String.join(",",
                        customer.getName(),
                        customer.getBirthDate().toString(),
                        customer.getEmail(),
                        customer.getGender(),
                        address.getStreetNumber(),
                        address.getStreetName(),
                        address.getDistrict(),
                        address.getCity(),
                        customer.getCustomerId(),
                        customer.getMembershipType(),
                        String.valueOf(customer.getLoyaltyPoints())));
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }
    }

    // Lấy danh sách khách hàng
    public List<Customer> getListCustomer() {
        return customers;
    }
}

