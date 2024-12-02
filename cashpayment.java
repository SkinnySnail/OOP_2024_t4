import java.util.Scanner;

public class cashpayment extends payment {
    private String tenthungan;
    private double sotiennhan;
    private double sotientl;
    public cashpayment(){
        super();
        this.tenthungan = "";
        this.sotiennhan = 0;
        this.sotientl = 0;
    }

    public cashpayment(double sotientt, String trangthaitt, String tenthungan, double sotiennhan){
        super(sotientt, "Tien mat", trangthaitt);
        this.tenthungan = tenthungan;
        this.sotiennhan = sotiennhan;
        this.sotientl = sotiennhan - sotientt;
    }

    public String getTenthungan(){
        return tenthungan;
    }

    public void setTenthungan(String tenthungan){
        this.tenthungan = tenthungan;
    }

    public double getSotiennhan(){
        return sotiennhan;
    }

    public void setSotiennhan(double sotiennhan){
        this.sotiennhan = sotiennhan;
        this.sotientl = sotiennhan - getSotientt();
    }

    public double getSotientl(){
        return sotientl;
    }

    @Override
    public void nhap(){
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten thu ngan : ");
        this.tenthungan = sc.nextLine();
        do{
            System.out.print("Nhap so tien khach tra : ");
            this.sotiennhan = sc.nextDouble();
            if (this.sotiennhan < getSotientt()){
                System.out.println("Khong du tien de thanh toan, hay nhap lai");
            }
        } while (this.sotiennhan < getSotientt());
        this.sotientl = this.sotiennhan - getSotientt();
    }

    @Override
    public String toString(){
        return super.toString() + "\nTen thu ngan : " + tenthungan + "\nSo tien khach tra : " + sotiennhan + "\nTien tra lai : " + sotientl;
    }
}
