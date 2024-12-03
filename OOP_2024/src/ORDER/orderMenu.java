package ORDER;

import java.util.Scanner;

public class orderMenu {
    private order Order1 = new order();
    private bildetailList detailList = new bildetailList();

    public void OrderMenu() {
        int choice;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("--------------ORDER MENU------------+");
            System.out.println("1. Them san pham.                     |");
            System.out.println("2. Xoa san pham.                      |");
            System.out.println("3. Xoa gio hang theo ID.              |");
            System.out.println("4. Tim kiem gio hang theo ID.         |");
            System.out.println("5. In toan bo gio hang.               |");
            System.out.println("6. Them gio hang tu Order.            |");
            System.out.println("7. Ghi gio hang xuong file.           |");
            System.out.println("0. Thoat                              |");
            System.out.println("--------------------------------------+");
            System.out.print("Nhap lua chon: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhap ten san pham: ");
                    String productName = sc.nextLine();
                    System.out.print("Nhap so luong: ");
                    int quantity = sc.nextInt();
                    System.out.print("Nhap gia: ");
                    double price = sc.nextDouble();
                    sc.nextLine();
                    orderItem newItem = new orderItem(productName, quantity, price);
                    Order1.addProduct(newItem);
                    System.out.println("San pham da duoc them vao don hang");
                    break;
                case 2:
                    System.out.print("Nhap ten san pham can xoa: ");
                    String productname = sc.nextLine();
                    Order1.deleteProduct(productname);
                    System.out.println("San pham da duoc xoa khoi don hang");
                    break;
                case 3:
                    System.out.print("Nhap ID gio hang can xoa: ");
                    String cartDetailID = sc.nextLine();
                    detailList.deleteCartDetailByID(cartDetailID);
                    System.out.println("Gio hang da duoc xoa");
                    break;
                case 4:
                    System.out.print("Nhap ID giỏ hàng cần tìm: ");
                    String cartdetailID = sc.nextLine();
                    cart_detail foundDetail = detailList.findCartDetailByID(cartdetailID);
                    if (foundDetail != null) {
                        foundDetail.printCartDetail();
                    } else {
                        System.out.println("Gio hang khong ton tai");
                    }
                    break;
                case 5:
                    detailList.printBilDetailList();
                    break;
                case 6:
                    System.out.print("Nhap ID Order: ");
                    String orderID = sc.nextLine();
                    System.out.print("Nhap ID khach hang: ");
                    String customerID = sc.nextLine();
                    System.out.print("Nhap ID nhan vien: ");
                    String employeeID = sc.nextLine();
                    System.out.print("Nhap ngay order: ");
                    String orderDate = sc.nextLine();

                    order newOrder = new order(orderID, customerID, employeeID, orderDate);
                    System.out.print("Nhap so luong san pham: ");
                    int numProducts = sc.nextInt();
                    sc.nextLine();
                    for (int i = 0; i < numProducts; i++) {
                        System.out.print("Nhap ten san pham: ");
                        String ProductName = sc.nextLine();
                        System.out.print("Nhap so luong: ");
                        int Quantity = sc.nextInt();
                        System.out.print("Nhap gia: ");
                        double Price = sc.nextDouble();
                        sc.nextLine();

                        orderItem item = new orderItem(ProductName, Quantity, Price);
                        newOrder.addProduct(item);
                    }

                    detailList.addCartDetailFromOrder(newOrder);
                    System.out.println("Gio hang da duoc them tu Order");
                    break;
                case 7:
                    detailList.writeFile();
                    System.out.println("Gio hang da duoc ghi xuong file");
                    break;
                case 0:
                    System.out.println("Thoat khoi menu");
                    return;
                default:
                    System.out.println("Lua chon khong hop le. Vui long nhap lai");
            }
        }
    }

    public static void main(String[] args){
        orderMenu ordermenu = new orderMenu();
        ordermenu.OrderMenu();
    }
}
