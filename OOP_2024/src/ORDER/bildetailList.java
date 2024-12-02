package ORDER;

import java.io.FileWriter;

public class bildetailList {
    private cart_detail cartDetailsArray[];
    private int sizecartDetailsArray;

    public bildetailList(){
        sizecartDetailsArray = 0;
        cartDetailsArray = new cart_detail[100];
    }

    public int getsizecartDetailsArray(){
        return sizecartDetailsArray;
    }

    public cart_detail getcartDetailsArray(int index){
        return cartDetailsArray[index];
    }

    public void addCartDetail(cart_detail cartdetail){
        if(sizecartDetailsArray < 100){
            cartDetailsArray[sizecartDetailsArray] = cartdetail;
            sizecartDetailsArray++;
        }
    }

    public void deleteCartDetailByID(String ID){
        for(int i = 0; i < sizecartDetailsArray; i++){
            if(cartDetailsArray[i].getCartDetailID().equals(ID)){
                for(int j = i; j < sizecartDetailsArray - 1; j++){
                    cartDetailsArray[j] = cartDetailsArray[j + 1];
                }
                cartDetailsArray[sizecartDetailsArray - 1] = null;
                sizecartDetailsArray--;
                break;
            }
        }
    }


    public cart_detail findCartDetailByID(String ID){
        for(int i = 0; i < sizecartDetailsArray; i++){
            if(cartDetailsArray[i].getCartDetailID().equals(ID)){
                return cartDetailsArray[i];
            }
        }
        return null;
    }

    public void printBilDetailList() {
        for (int i = 0; i < sizecartDetailsArray; i++) {
            cartDetailsArray[i].printCartDetail();
            System.out.println("---------------------------");
        }
    }

    public void addCartDetailFromOrder(order Order){
        for(int i = 0; i < Order.getProductCount(); i++){
            cart_detail newCartdeteil = new cart_detail();
            newCartdeteil.setCartDetailID("CartDetail" + sizecartDetailsArray + 1);
            newCartdeteil.setCustomerID(Order.get_customerID());
            newCartdeteil.setEmployeeId(Order.getEmployeeID());
            newCartdeteil.setPaymentMethod("Online");
            newCartdeteil.setDateCart(Order.getOrderDate());
            addCartDetail(newCartdeteil);
        }
    }

    public void writeFile(){
        for(int i = 0; i < sizecartDetailsArray; i++){
            cartDetailsArray[i].writeFile();
        }
    }
}

