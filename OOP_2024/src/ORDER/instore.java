package ORDER;
public class instore extends order {
    private double cashPayment;

    public instore(){
        super();
    }

    public instore(String orderID, String customerID, String EmployeeId, String orderDate, double cashPayment){
        super(orderID, customerID, EmployeeId, orderDate);
        this.cashPayment = cashPayment;
    }

    public void setCashPayment(double cashPayment){
        this.cashPayment = cashPayment;
    }

    public double getCashPayment(){
        return cashPayment;
    }

    public double tienNhan(){
        return cashPayment;
    }

    public double tienThoi(){
        return cashPayment - getTotalValue();
    }

    @Override
    public void printOrder(){
        super.printOrder();
        System.out.println("Tien nhan: " + cashPayment);
        System.out.println("Tien thoi: " + tienThoi());
    }

}
