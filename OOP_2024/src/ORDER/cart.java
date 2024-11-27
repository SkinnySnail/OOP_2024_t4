package ORDER;

public class cart {
    int cart_id;
    int produce_id;
    String produce_name;
    double price;
    int cart_quantity;

    public cart(){}
    public cart(int cart_id, int produce_id, String product_name, double price, int cart_quantity){
        this.cart_id = cart_id;
        this.produce_id = produce_id;
        this.produce_name = product_name;
        this.price = price;
        this.cart_quantity = cart_quantity;
    }

    public double tongGia(){
        return price*cart_quantity;
    }

    public void setCartID(int cart_id){
        this.cart_id = cart_id;
    }

    public void setProduceID(int produce_id){
        this.produce_id = produce_id;
    }

    public void setProduceName(String produce_name){
        this.produce_name = produce_name;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void setCart_Quantity(int cart_quantity){
        this.cart_quantity = cart_quantity;
    }

    public int getCartID(){
        return cart_id;
    }

    public int getProduceID(){
        return produce_id;
    }

    public String getProduceName(){
        return produce_name;
    }

    public double getPrice(){
        return price;
    }

    public int getCart_Quantity(){
        return cart_quantity;
    }
}
