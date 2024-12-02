package ORDER;

public class cart {
    private String cart_id;
    private String produce_id;
    private String produce_name;
    private double price;
    private int quantity;
    private double totalPrice;

    public cart(){}

    public cart(String cart_id, String produce_id, String produce_name, double price, int quantity) {
        this.cart_id = cart_id;
        this.produce_id = produce_id;
        this.produce_name = produce_name;
        this.price = price;
        this.quantity = quantity;
        this.totalPrice = quantity * price;
    }

    
    public void setCartID(String cart_id){
        this.cart_id = cart_id;
    }
    
    public void setProduceID(String produce_id){
        this.produce_id = produce_id;
    }
    
    public void setProduceName(String produce_name){
        this.produce_name = produce_name;
    }
    
    public void setPrice(double price){
        this.price = price;
    }
    
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public void setTotalPrice(double totalPrice){
        this.totalPrice = totalPrice;
    }
    
    public String getCartID(){
        return cart_id;
    }
    
    public String getProduceID(){
        return produce_id;
    }
    
    public String getProduceName(){
        return produce_name;
    }
    
    public double getPrice(){
        return price;
    }
    
    public int getQuantity(){
        return quantity;
    }

    public double getTotalPrice(){
        return totalPrice;
    }
}


// package ORDER;

// public class cart {
//     private String cartID;
//     private String productID;
//     private String productName;
//     private double price;
//     private int quantity;

//     // Constructor mặc định
//     public cart(String cartID, String productID, String productName, double price, int quantity) {
//         this.cartID = cartID;
//         this.productID = productID;
//         this.productName = productName;
//         this.price = price;
//         this.quantity = quantity;
//     }

//     // Getter và Setter
//     public String getCartID() {
//         return cartID;
//     }

//     public void setCartID(String cartID) {
//         this.cartID = cartID;
//     }

//     public String getProductID() {
//         return productID;
//     }

//     public void setProductID(String productID) {
//         this.productID = productID;
//     }

//     public String getProductName() {
//         return productName;
//     }

//     public void setProductName(String productName) {
//         this.productName = productName;
//     }

//     public double getPrice() {
//         return price;
//     }

//     public void setPrice(double price) {
//         this.price = price;
//     }

//     public int getQuantity() {
//         return quantity;
//     }

//     public void setQuantity(int quantity) {
//         this.quantity = quantity;
//     }

//     // Tính tổng giá trị của sản phẩm trong giỏ hàng
//     public double totalPrice() {
//         return price * quantity;
//     }
// }
