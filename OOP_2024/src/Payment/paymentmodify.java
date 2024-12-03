import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class paymentmodify{
    public static void suathongtin(){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> danhSachHoaDon = new ArrayList<>();
        try (BufferedReader doc = new BufferedReader(new FileReader("incart.txt"))){
            String dong;
            ArrayList<String> tempList = new ArrayList<>();
            while ((dong = doc.readLine()) != null){
                if (!dong.equals("----------------------")){
                    tempList.add(dong);
                } else{
                    danhSachHoaDon.addAll(tempList);
                    tempList.clear();
                }
            }
            if (!tempList.isEmpty()){
                danhSachHoaDon.addAll(tempList);
            }
        } catch (Exception e){
            System.out.println("Loi doc file");
            return;
        }
        
        if (danhSachHoaDon.isEmpty()){
            System.out.println("Khong co hoa don de sua");
            return;
        }
        System.out.println("Danh sach hoa don:");
        int soLuongHoaDon = danhSachHoaDon.size()/6;
        for (int i = 0;i < soLuongHoaDon;i++){
            System.out.println("Hoa don "+(i+1) +":");
            for (int j = 0;j < 6;j++){
                System.out.println((j+1)+". "+danhSachHoaDon.get(i*6+j));
            }
            System.out.println("----------------------");
        }
        System.out.print("Chon so thu tu hoa don can sua : ");
        int thuTu = sc.nextInt();
        sc.nextLine();
        if (thuTu < 1 || thuTu > soLuongHoaDon){
            System.out.println("Lua chon khong hop le");
            return;
        }
        int vitri = (thuTu -1)*6;
        String phuongThucTT = danhSachHoaDon.get(vitri).split(" : ")[1];
        payment hoaDonSua;
        if (phuongThucTT.equals("Tien mat")){
            hoaDonSua = new cashpayment();
            hoaDonSua.setPhuongthuctt("Tien mat");
            ((cashpayment)hoaDonSua).setTenthungan(danhSachHoaDon.get(vitri+3).split(" : ")[1]);
        } else if (phuongThucTT.equals("The ngan hang")){
            hoaDonSua = new cardpayment();
            hoaDonSua.setPhuongthuctt("The ngan hang");
            ((cardpayment)hoaDonSua).setSothe(danhSachHoaDon.get(vitri+3).split(" : ")[1]);
            ((cardpayment)hoaDonSua).setLoaithe(danhSachHoaDon.get(vitri+4).split(" : ")[1]);
            ((cardpayment)hoaDonSua).setTenchuthe(danhSachHoaDon.get(vitri+5).split(" : ")[1]);
        } else{
            System.out.println("Khong the sua hoa don");
            return;
        }
        hoaDonSua.setSotientt(Double.parseDouble(danhSachHoaDon.get(vitri+1).split(" : ")[1]));
        hoaDonSua.setTrangthaitt(danhSachHoaDon.get(vitri+2).split(" : ")[1]);
        hoaDonSua.nhap();
        for (int i = 0;i < 6;i++){
            danhSachHoaDon.remove(vitri);
        } 
        String[] thaythe = hoaDonSua.toString().split("\n");
        for (int i = 0;i < thaythe.length;i++){
            danhSachHoaDon.add(vitri+i, thaythe[i]);
        } 
        if (hoaDonSua instanceof cashpayment){
            cashpayment cashPayment = (cashpayment) hoaDonSua;
            danhSachHoaDon.add(vitri+thaythe.length, "So tien khach tra : "+cashPayment.getSotiennhan());
            danhSachHoaDon.add(vitri+thaythe.length+1, "So tien tra lai : "+cashPayment.getSotientl());
        } else if (hoaDonSua instanceof cardpayment){
            cardpayment cardPayment = (cardpayment) hoaDonSua;
            danhSachHoaDon.add(vitri+thaythe.length, "So tien khach tra : "+cardPayment.getsotiennhan());
            danhSachHoaDon.add(vitri+thaythe.length+1, "So tien tra lai : "+cardPayment.getSotientl());
        }
        try (BufferedWriter ghi = new BufferedWriter(new FileWriter("incart.txt"))){
            for (int i = 0;i < danhSachHoaDon.size();i++){
                ghi.write(danhSachHoaDon.get(i));
                ghi.newLine();
                if ((i+1) % (hoaDonSua instanceof cashpayment || hoaDonSua instanceof cardpayment ? 8 : 6) == 0){
                    ghi.write("----------------------");
                    ghi.newLine();
                }
            }
            System.out.println("Da sua thong tin hoa don");
        } catch (Exception e){
            System.out.println("Loi ghi file");
        }
    }
}
