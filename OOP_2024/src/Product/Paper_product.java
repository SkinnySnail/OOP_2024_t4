package Product;

import java.util.Scanner;

public class Paper_product extends Product {
    private String ptype;
    Scanner sc = new Scanner(System.in);
    public Paper_product() {
        this.category = "Paper_product";
    }

    public Paper_product(String product_id, String product_name, int price) {
        super(product_id, product_name, price);
    }

    public Paper_product(String maSP, String tenSP, int donGia, String type) {
        super(maSP, tenSP, donGia);
        this.category = "Paper_product";
        this.ptype = type;
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
        System.out.print("Nhap vao loai cua giay: ");
        this.ptype = sc.nextLine();
    }

    @Override
    public String toString() {
        return "Paper_product [category=" + this.category + ", id="+ getProduct_id() + ", name="+ getProduct_name() + ", price="+ getPrice() 
        +"ptype=" + this.ptype + "]";
    }

    public void xuat(){
        System.out.print("Paper_product [ptype=" + this.ptype + ", category=" + this.category + ", id="+ getProduct_id() + ", name="+ getProduct_name() + ", price="+ getPrice()  + "]");
    }
    
}
