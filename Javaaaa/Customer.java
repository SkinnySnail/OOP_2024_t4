import java.time.LocalDate;


public class Customer extends Person {
    private String customerId;
    private String membershipType;
    private int loyaltyPoints;

    // Constructor
    public Customer() {}

    public Customer(String name, LocalDate birthDate, String email, String gender, Address address, 
                    String customerId, String membershipType, int loyaltyPoints) {
        super(name, birthDate, email, gender, address);
        this.customerId = customerId;
        this.membershipType = membershipType;
        this.loyaltyPoints = loyaltyPoints;
    }

    // Getters và Setters
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    // Tăng điểm tích lũy
    public void addLoyaltyPoints(int points) {
        this.loyaltyPoints += points;
    }

    // Override nhập và xuất thông tin
    @Override
    public void inputInformation() {
        // Code nhập thông tin từ người dùng
    }

    @Override
    public void displayInformation() {
        System.out.println("Customer ID: " + customerId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + calculateAge());
        System.out.println("Membership Type: " + membershipType);
        System.out.println("Loyalty Points: " + loyaltyPoints);
        System.out.println("Address: " + address.toString());
    }
}
