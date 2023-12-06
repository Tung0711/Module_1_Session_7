package RA_Ex2;

import RA_Ex2.entity_ex2.Product;

import java.util.Scanner;

public class ProductImp {
    //Khởi tạo mảng
    Product[] arrProduct = new Product[100];
    int indexProduct = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductImp pro = new ProductImp();

        do {
            System.out.println("************ MENU ************");
            System.out.println("1. Nhập thông tin n sản phẩm");
            System.out.println("2. Hiển thị thông tin các sản phẩm");
            System.out.println("3. Tính lợi nhuận các sản phẩm");
            System.out.println("4. Sắp xếp các sản phẩm theo lợi nhuận giảm dần");
            System.out.println("5. Thống kê các sản phẩm theo giá");
            System.out.println("6. Tìm các sản phẩm theo tên sản phẩm");
            System.out.println("7. Nhập sản phẩm");//
            System.out.println("8. Bán sản phẩm");//
            System.out.println("9. Cập nhật trạng thái sản phẩm");
            System.out.println("10. Thoát");
            System.out.println("Lựa chọn của bạn là: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    pro.inputProduct(scanner);
                    break;
                case 2:
                    pro.displayProduct();
                    break;
                case 3:
                    pro.calProfit();
                    break;
                case 4:
                    pro.sortProductByProfit();
                    break;
                case 5:
                    pro.findProductByExPrice(scanner,pro.indexProduct);
                    break;
                case 6:
                    pro.findForProductByName(scanner,pro.indexProduct);
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    pro.updateProductStatus(scanner);
                    break;
                case 10:
                    System.out.println("Chương trình kết thúc. Xin tạm biệt!");
                    System.exit(0);
                default:
                    System.err.println("Lựa chọn không phù hợp. Vui lòng nhập lại!");
            }
        } while (true);
    }

    public void inputProduct(Scanner scanner) {
        System.out.println("Nhập vào số sản phẩm cần nhập thông tin: ");
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < number; i++) {
            arrProduct[indexProduct] = new Product();
            arrProduct[indexProduct].inputData(scanner, arrProduct, indexProduct);
            indexProduct++;
        }
    }

    public void calProfit() {
        System.out.println("Lợi nhuận các sản phẩm: ");
        for (int i = 0; i < indexProduct; i++) {
            arrProduct[i].calProfit();
        }
    }

    public void displayProduct() {
        System.out.println("Thông tin sản phẩm: ");
        for (int i = 0; i < indexProduct; i++) {
            arrProduct[i].displayData();
        }
    }

    public void sortProductByProfit() {
        Product temp;
        System.out.println("Sắp xếp sản phẩm theo lợi nhuận giảm dần:");
        for (int i = 0; i < indexProduct - 1; i++) {
            for (int j = i + 1; j < indexProduct; j++) {
                if (arrProduct[i].getProfit() < arrProduct[j].getProfit()) {
                    temp = arrProduct[i];
                    arrProduct[i] = arrProduct[j];
                    arrProduct[j] = temp;
                }
            }
        }
        System.out.println("Sắp xếp thành công!");
    }

    public void findProductByExPrice(Scanner scanner, int indexProduct) {
        System.out.println("Nhập giá sản phẩm muốn thống kê số lượng: ");
        float exPriceFindByProduct = Float.parseFloat(scanner.nextLine());
        for (int i = 0; i < indexProduct; i++) {
            if (arrProduct[i].getExportPrice() == exPriceFindByProduct) {
                arrProduct[i].displayData();
            }
        }
    }

    public void findForProductByName(Scanner scanner, int indexProduct) {
        System.out.print("Nhập sản phẩm bạn muốn tìm theo tên: ");
        String nameProductFindFor = scanner.nextLine();
        System.out.println("Sản phẩm có tên bạn tìm:");
        boolean checkFindForProduct = false;
        for (int i = 0; i < indexProduct; i++) {
            if (arrProduct[i].getProductName().contains(nameProductFindFor)) {
                checkFindForProduct = true;
                arrProduct[i].displayData();
            }
        }
        if (!checkFindForProduct) {
            System.out.print("Không có sản phẩm có tên bạn cần tìm!");
        }
    }

    public int getIndexById(String productId, int indexProduct) {
        for (int i = 0; i < indexProduct; i++) {
            if (arrProduct[i].getProductId().equals(productId)) {
                return i;
            }
        }
        return -1;
    }

    public void updateProductStatus(Scanner scanner) {
        System.out.println("Nhập vào mã sản phẩm cần cập nhật trạng thái:");
        String productId = scanner.nextLine();
        int indexUpdateStatus = getIndexById(productId,indexProduct);
        if (indexUpdateStatus >= 0) {
            arrProduct[indexUpdateStatus].setStatus(!arrProduct[indexUpdateStatus].getStatus());
        } else {
            System.err.println("Mã danh mục không tồn tại");
        }
    }
}
