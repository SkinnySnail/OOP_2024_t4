package Product;

import java.util.Scanner;

public class Tool extends SanPham {
    private String usage, description;
    Scanner sc = new Scanner(System.in);
    public Tool() {
        this.category = "Tool";
    }

    public Tool(String product_id, String product_name, int price) {
        super(product_id, product_name, price);
    }

    public Tool(String maSP, String tenSP, int donGia, String us, String des) {
        super(maSP, tenSP, donGia);
        this.category = "Tool";
        this.usage = us;
        this.description = des;
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

    }
    
}
