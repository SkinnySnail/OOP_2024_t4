package ORDER;
import ORDER.cart;
import java.io.FileWriter;

public class cart_detail {

    int cart_detailID;
    int userID;
    int personnelID;
    String bill;
    String payment_method;
    int number_cart;
    String date_cart;

    int n = 0;
    cart[] arrCarts = new cart[n];

    public cart_detail(){}
    public cart_detail(int cart_detailID, int userID, int personnelID, String bill, String payment_method, int number_cart, String date_cart){
        this.cart_detailID = cart_detailID;
        this.userID = userID;
        this.personnelID = personnelID;
        this.bill = bill;
        this.payment_method = payment_method;
        this.number_cart = number_cart;
        this.date_cart = date_cart;
    }

    public void setCartDetailID(int cart_detailID) {
        this.cart_detailID = cart_detailID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setPersonnelID(int personnelID) {
        this.personnelID = personnelID;
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

    public int getCartDetailID() {
        return cart_detailID;
    }

    public int getUserID() {
        return userID;
    }

    public int getPersonnelID() {
        return personnelID;
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

    public void getifor() {
        arrCarts[n].cart_detailID = getCartDetailID();
        arrCarts[n].userID = getUserID();
        arrCarts[n].personnelID = getPersonnelID();
        arrCarts[n].bill = getBill();
        arrCarts[n].payment_method = getPaymentMethod();
        arrCarts[n].number_cart = getNumberCart();
        arrCarts[n].date_cart = getDateCart();
        n++;
    }

    public void getCartDetail() {
        System.out.println("----------CHI TIET HOA DON----------");
        System.out.println(getCartDetailID());
        System.out.println(getUserID());
        System.out.println(getPersonnelID());
        System.out.println(getBill());
        System.out.println(getPaymentMethod());
        System.out.println(getNumberCart());
        System.out.println(getDateCart());
        System.out.println("-----------------------------------");
    }

    public double sumPrice(){
        double sum = 0;
        // chua biet ???
        return sum;
    }
    
    // ghi vao file
    public void writeFile() {
        try {
            FileWriter fw = new FileWriter("cartdetail.txt");
            fw.write("Welcome to java."); // chua biet ghi gi
            fw.close();
        } catch (Exception e) {
        System.out.println(e);
        }   
    }
}