package ORDER;

import java.io.FileWriter;
// import java.io.writeFile;

public class cart_detail {

    private String cart_detailID;
    private String customerID;
    private String employeeId;
    private String bill;
    private String payment_method;
    private int number_cart;
    private String date_cart;

    cart cartsArray[];

    public cart_detail() {
        cartsArray = new cart[100];
        number_cart = 0;
    }

    public cart_detail(String cart_detailID, String customerID, String employeeId, String bill, String payment_method, String date_cart){
        this.cart_detailID = cart_detailID;
        this.customerID = customerID;
        this.employeeId = employeeId;
        this.bill = bill;
        this.payment_method = payment_method;
        this.date_cart = date_cart;
        this.number_cart = 0;
        cartsArray = new cart[100];
    }

    public cart_detail(cart_detail cd){
        this.cart_detailID = cd.cart_detailID;
        this.customerID = cd.customerID;
        this.employeeId = cd.employeeId;
        this.bill = cd.bill;
        this.payment_method = cd.payment_method;
        this.number_cart = cd.number_cart;
        this.date_cart = cd.date_cart;
        this.cartsArray = new cart[100];
        this.number_cart = 0;
    }

    public cart_detail(String cart_detailID, String customerID, String employeeId, String bill,
            String payment_method, int number_cart, String date_cart) {
        this.cart_detailID = cart_detailID;
        this.customerID = customerID;
        this.employeeId = employeeId;
        this.bill = bill;
        this.payment_method = payment_method;
        this.number_cart = number_cart;
        this.date_cart = date_cart;
        this.cartsArray = new cart[100];
        this.number_cart = 0;
    }

    public void setCartDetailID(String cart_detailID) {
        this.cart_detailID = cart_detailID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setBill(String bill) {
        this.bill = bill;
    }

    public void setPaymentMethod(String payment_method) {
        this.payment_method = payment_method;
    }

    public void setNumberCart(int number_cart) {
        this.number_cart = number_cart;
    }

    public void setDateCart(String date_cart) {
        this.date_cart = date_cart;
    }

    public String getCartDetailID() {
        return cart_detailID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getBill() {
        return bill;
    }

    public String getPaymentMethod() {
        return payment_method;
    }

    public int getNumberCart() {
        return number_cart;
    }

    public String getDateCart() {
        return date_cart;
    }

    public void addCart(cart Cart) {
        if (number_cart < 100) {
            cartsArray[number_cart] = Cart;
            number_cart++;
        }
    }

    public void getifor() {
        for (int i = 0; i < number_cart; i++) {
            cartsArray[i].setCartID(getCartDetailID());
            // ...
        }
    }

    public double tongHoaDon() {
        double total = 0;
        for (int i = 0; i < number_cart; i++) {
            total += cartsArray[i].getTotalPrice();
        }
        return total;
    }

    public void getCartDetail() {
        for (int i = 0; i < number_cart; i++) {
            System.out.println("Cart ID: " + cartsArray[i].getCartID());
            System.out.println("Product ID: " + cartsArray[i].getProduceID());
            System.out.println("Product Name: " + cartsArray[i].getProduceName());
            System.out.println("Price: " + cartsArray[i].getPrice());
            System.out.println("Quantity: " + cartsArray[i].getQuantity());
            System.out.println("Total Price: " + cartsArray[i].getTotalPrice());
            System.out.println("------------------------------");
        }
    }

    public void printCartDetail() {
        System.out.println("Cart Detail ID: " + cart_detailID);
        System.out.println("Customer ID: " + customerID);
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Bill: " + bill);
        System.out.println("Payment Method: " + payment_method);
        System.out.println("Date: " + date_cart);
        System.out.println("Number Cart: " + number_cart);
        System.out.println("Cart Items:");
        for (int i = 0; i < number_cart; i++) {
            System.out.println("  - Cart ID: " + cartsArray[i].getCartID() + ", Product ID: " + cartsArray[i].getProduceID() +
            ", Product Name: " + cartsArray[i].getProduceName() + ", Price: " + cartsArray[i].getPrice() +
            ", Quantity: " + cartsArray[i].getQuantity() + ", Total Price: " + cartsArray[i].getTotalPrice());
        }
        System.out.println("Total Amout: " + tongHoaDon());
    }

    public void writeFile() {
        try {
            FileWriter fw = new FileWriter("cartdetail.txt");
            for (int i = 0; i < number_cart; i++) {
                fw.write("Cart ID: " + cartsArray[i].getCartID());
                fw.write("Product ID: " + cartsArray[i].getProduceID());
                fw.write("Product Name: " + cartsArray[i].getProduceName());
                fw.write("Price: " + cartsArray[i].getPrice());
                fw.write("Quantity: " + cartsArray[i].getQuantity());
                fw.write("Total Price: " + cartsArray[i].getTotalPrice());
                fw.write("------------------------------");
            }
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


