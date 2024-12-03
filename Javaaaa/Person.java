
import java.time.LocalDate;
import java.time.Period;

public abstract class Person {
    protected String name;
    protected LocalDate birthDate;
    protected String email;
    protected String gender;
    protected Address address;

    // Constructor
    public Person() {}

    public Person(String name, LocalDate birthDate, String email, String gender, Address address) {
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
        this.gender = gender;
        this.address = address;
    }

    // Getters và Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    // Tính tuổi
    public int calculateAge() {
        return Period.between(this.birthDate, LocalDate.now()).getYears();
    }

    // Hàm trừu tượng nhập và xuất thông tin
    public abstract void inputInformation();

    public abstract void displayInformation();
}
