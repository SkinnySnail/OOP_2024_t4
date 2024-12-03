package Product;

import java.util.Scanner;

public class Tool extends Product {
    
    Scanner sc = new Scanner(System.in);
    

    public Tool(String product_id, String product_name, int price) {
        super(product_id, product_name, price);
    }

    public Tool(String maSP, String tenSP, int donGia,int num) {
        super(maSP, tenSP, donGia,num);
        this.category = "Tool";
    }

    public Tool(String product_id, String product_name, int price, String category, int itemnum) {
        super(product_id, product_name, price, category, itemnum);
    }
    public Tool() {
        this.category = "Tool";
    }

    

    @Override
    public void nhap() {
        System.out.print("Nhap vao ma san pham: ");
        String maSP = sc.nextLine();
        setProduct_id(maSP); 
        System.out.print("Nhap vao ten san pham: ");
        String tenSP = sc.nextLine();
        setProduct_name(tenSP);
        System.out.print("Nhap vao gia cua san pham: ");
        int gia = Integer.parseInt(sc.nextLine());
        setPrice(gia);
    }


    public void xuat(){
        System.out.printf("%-25s%-25s%-21s%-26d%-13d\n", this.category , getProduct_id() , getProduct_name() , getPrice(),getItemnum());
    }
    
}
