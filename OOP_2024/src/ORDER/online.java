package ORDER;

import java.io.FileWriter;

public class online extends order {
    private String address;

    public online(){
        super();
    }

    public online(String orderID, String customerID, String EmployeeId, String orderDate, String address){
        super(orderID, customerID, EmployeeId, orderDate);
        this.address = address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void confirmOnlineOrder() {
        super.isPayment = true;
        super.isOrderConfirm = true;
        System.out.println("Da xac nhan");
    }

    public void cancelOnlineOrder() {
        super.isPayment = false;
        super.isOrderConfirm = false;
        System.out.println("Da huy");
    }

    public void writeFile() {
        try {
            FileWriter fw = new FileWriter("online.txt", true);
            fw.write("OrderID: " + super.getOrderID());
            fw.write("CustomerID: " + super.get_customerID());
            fw.write("EmployeeID: " + super.getEmployeeID());
            fw.write("OrderDate: " + super.getOrderDate());
            fw.write("ProductCount: " + super.getProductCount());
            fw.write("TotalValue: " + super.getTotalValue());
            fw.write("Phuong thuc thanh toan: " + (isOrderConfirm ? "Yes" : "No") );
            fw.write("Xac nhan don hang: " + (isPayment ? "Yes" : "No"));
            fw.write("Dia chi giao hang: " + getAddress());
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

