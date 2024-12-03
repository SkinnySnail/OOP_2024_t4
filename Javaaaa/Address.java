
public class Address {
    private String streetNumber;
    private String streetName;
    private String district;
    private String city;

    // Constructor
    public Address() {}

    public Address(String streetNumber, String streetName, String district, String city) {
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.district = district;
        this.city = city;
    }

    // Getters và Setters
    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    // Override toString
    @Override
    public String toString() {
        return streetNumber + " " + streetName + ", " + district + ", " + city;
    }
}
