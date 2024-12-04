package ORDER;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class order {
    private String orderID;
    private String customerID;
    private String EmployeeId;
    private String orderDate;
    private orderItem orderItemsArray[];

    private int productCount;
    private double totalValue;
    public boolean isPayment;
    public boolean isOrderConfirm;
    
    public order(){
        productCount = 0;
        orderItemsArray = new orderItem[100];
        isPayment = false;
        isOrderConfirm = false;
    }

    public order(String orderID, String customerID, String EmployeeId, String orderDate){
        this.orderID = orderID;
        this.customerID = customerID;
        this.EmployeeId = EmployeeId;
        this.orderDate = orderDate;
        productCount = 0;
        orderItemsArray = new orderItem[100];
        isPayment = false;
        isOrderConfirm = false;
    }

    public void setOrderID(String orderID){
        this.orderID = orderID;
    }

    public void set_customerID(String customerID){
        this.customerID = customerID;
    }

    public void setEmployeeId(String employeeID){
        this.EmployeeId = employeeID;
    }

    public void setOrderDate(String orderDate){
        this.orderDate = orderDate;
    }

    public String getOrderID(){
        return orderID;
    }

    public String get_customerID(){
        return customerID;
    }

    public String getEmployeeID(){
        return EmployeeId;
    }

    public String getOrderDate(){
        return orderDate;
    }

    public int getProductCount(){
        return productCount;
    }

    public double getTotalValue(){
        return totalValue;
    }

    public orderItem getOrderItem(int index){
        return orderItemsArray[index];
    }

    public void tonggiatri(){
        totalValue = 0;
        for(int i = 0; i < productCount; i++){
            totalValue += orderItemsArray[i].totalValueProduct();
        }
    }

    public void addProduct(orderItem orderitem){
        if(productCount < 100){
            orderItemsArray[productCount] = orderitem;
            productCount++;
        }
    }

    public void deleteProduct(String productName){
        for(int i = 0; i < getProductCount(); i++){
            if(orderItemsArray[i].getproductName().equals(productName)){
                for(int j = i; j < getProductCount() - 1; j++){
                    orderItemsArray[j] = orderItemsArray[j + 1];
                }
            }
            orderItemsArray[productCount - 1] = null;
            productCount--;
            break;
        }
    }

    public void inputOrder() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap OrderID: ");
        String _orderID =  sc.nextLine();
        setOrderID(_orderID);
        System.out.print("Nhap CustomerID: ");
        String _customerID = sc.nextLine();
        set_customerID(_customerID);
        System.out.print("Nhap EmployeeID: ");
        String _EmployeeId = sc.nextLine();
        setEmployeeId(_EmployeeId);
        System.out.print("Nhap OrderDate: ");
        String _orderDate = sc.nextLine();
        setOrderDate(_orderDate);
    }


    public boolean isConfirmOrder(){
        return isOrderConfirm;
    }

    public boolean isConfirmPayment(){
        return isPayment;
    }

    public void printOrder(){
        System.out.println("OrderID: " + orderID);
        System.out.println("CustomerID: " + customerID);
        System.out.println("EmployeeID: " + EmployeeId);
        System.out.println("OrderDate: " + orderDate);
        System.out.print("Product: ");
        for(int i = 0; i < productCount; i++){
            System.out.println(orderItemsArray[i].getproductName() + " Quantity: " + orderItemsArray[i].getquanTiTy() + "Price: " + orderItemsArray[i].getPrice() + "Total: " + orderItemsArray[i].totalValueProduct());
        }
        System.out.println("Total Value Product: " + totalValue);
    }

    public String toString() {
        return "Order = [ orderID = " + getOrderID() + 
                ", customerID = " + get_customerID() + 
                ", EmployeeId = " + getEmployeeID() + 
                ", orderDate = " + getOrderDate() + 
                ", productCount = " + getProductCount() +
                ", totalValue = " + getTotalValue() +
                "]";
    }
    public void giamSoLuongSanPham() {
        String dataSanPhamFile = "dataProduct.txt";
        String danhSachSpDaDatFile = "danhsachspdadat.txt";

        try {
            // Đọc nội dung từ file dataProduct.txt
            BufferedReader brDataSanPham = new BufferedReader(new FileReader(dataSanPhamFile));
            StringBuilder sbDataSanPham = new StringBuilder();
            String lineDataSanPham;
            while ((lineDataSanPham = brDataSanPham.readLine()) != null) {
                sbDataSanPham.append(lineDataSanPham);
                sbDataSanPham.append(System.lineSeparator());
            }
            brDataSanPham.close();
            String dataSanPhamContent = sbDataSanPham.toString();

            // Đọc nội dung từ file danhsachspdadat.txt
            BufferedReader brDanhSachSpDaDat = new BufferedReader(new FileReader(danhSachSpDaDatFile));
            String lineDanhSachSpDaDat;
            while ((lineDanhSachSpDaDat = brDanhSachSpDaDat.readLine()) != null) {
                // Phân tích cú pháp của dòng trong file danhSachSpDaDat.txt
                String[] spDaDatInfo = lineDanhSachSpDaDat.split("\\|");
                if (spDaDatInfo.length >= 3) {
                    String tenSpDaDat = spDaDatInfo[0].trim();
                    int soLuongSpDaDat = Integer.parseInt(spDaDatInfo[2].trim());

                    // Tìm kiếm tên sản phẩm trong dataSanPhamContent
                    int index = dataSanPhamContent.indexOf(tenSpDaDat);

                    if (index != -1) {
                        // Giảm số lượng sản phẩm
                        int start = dataSanPhamContent.lastIndexOf("\n", index) + 1;
                        int end = dataSanPhamContent.indexOf("\n", index);
                        String spInfo = dataSanPhamContent.substring(start, end);
                        String[] spInfoParts = spInfo.split(",");
                        int soLuongSpTrongDataSanPham = Integer.parseInt(spInfoParts[4].trim());
                        int soLuongMoi = soLuongSpTrongDataSanPham - soLuongSpDaDat;
                        spInfoParts[4] = Integer.toString(soLuongMoi);
                        String newSpInfo = String.join(", ", spInfoParts);
                        dataSanPhamContent = dataSanPhamContent.replace(spInfo, newSpInfo);
                    }
                }
            }
            brDanhSachSpDaDat.close();

            // Ghi lại nội dung đã thay đổi vào file dataSanPham.txt
            BufferedWriter bwDataSanPham = new BufferedWriter(new FileWriter(dataSanPhamFile));
            bwDataSanPham.write(dataSanPhamContent);
            bwDataSanPham.close();

            System.out.println("Đã cập nhật số lượng sản phẩm thành công!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

