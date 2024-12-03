package Payment;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class payment {
    private double sotientt;
    private String phuongthuctt;
    private String trangthaitt;
    public payment(){
        this.sotientt = 0;
        this.phuongthuctt = "";
        this.trangthaitt = "";
    }
    public payment(double sotientt, String phuongthuctt, String trangthaitt){
        this.sotientt = sotientt;
        this.phuongthuctt = phuongthuctt;
        this.trangthaitt = trangthaitt;
    }
    public double getSotientt(){
        return sotientt;
    }
    public void setSotientt(double sotientt){
        this.sotientt = sotientt;
    }
    public String getPhuongthuctt(){
        return phuongthuctt;
    }
    public void setPhuongthuctt(String phuongthuctt){
        this.phuongthuctt = phuongthuctt;
    }
    public String getTrangthaitt(){
        return trangthaitt;
    }
    public void setTrangthaitt(String trangthaitt){
        this.trangthaitt = trangthaitt;
    }
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so tien thanh toan : ");
        this.sotientt = sc.nextDouble();
        sc.nextLine();
        System.out.print("Nhap trang thai thanh toan : ");
        this.trangthaitt = sc.nextLine();
        if (this.trangthaitt.isEmpty()){
            this.trangthaitt = "Chua thanh toan";
        }
    }

    public String toString(){
        return "Phuong thuc thanh toan : " + phuongthuctt + "\nSo tien thanh toan : " + sotientt + "\nTrang thai thanh toan : " + trangthaitt;
    }

    public static void ghifile(ArrayList<payment> hoadon, boolean append){
        try (BufferedWriter ghi = new BufferedWriter(new FileWriter("incart.txt", append))){
            if (!append){
                ghi.write("");
            }
            else{
                for (int i = 0; i < hoadon.size(); i++){
                    ghi.write(hoadon.get(i).toString());
                    ghi.newLine();
                    ghi.write("----------------------");
                    ghi.newLine();//them dong moi
                }
                System.out.println("Da ghi vao file");
            }
        } 
        catch (Exception e){
            System.out.println("Loi khong ghi duoc vao tep");
        }
    }    

    public static void docFile(String tenfile){
        try (BufferedReader doc = new BufferedReader(new FileReader(tenfile))){
            String dong;
            boolean filetrong = true;
            while ((dong = doc.readLine()) != null){
                filetrong = false;
                System.out.println(dong);
            }
            if (filetrong){
                System.out.println("Khong co lich su thanh toan");
            }
        } catch (Exception e){
            System.out.println("Loi khong doc duoc file");
        }
    }    
}
