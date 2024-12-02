package ORDER;

public class orderItem {
    private String productname;
    private int quanTiTy;
    private double Price;

    public orderItem(){}
    public orderItem(String productname, int quanTiTy, double Price){
        this.productname = productname;
        this.quanTiTy = quanTiTy;
        this.Price = Price;
    }

    public void setproductName(String productname){
        this.productname = productname;
    }

    public void setquanTiTy(int quanTiTy){
        this.quanTiTy = quanTiTy;
    }

    public void setPrice(double Price){
        this.Price = Price;
    }

    public String getproductName(){
        return productname;
    }

    public int getquanTiTy(){
        return quanTiTy;
    }

    public double getPrice(){
        return Price;
    }

    public double totalValueProduct(){
        return Price * quanTiTy ;
    }
}
