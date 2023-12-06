package RA_Ex2.entity_ex2;

import java.util.Scanner;

public class Product {
    //Cac thuoc tinh cua product
    private String productId;
    private String productName;
    private float importPrice;
    private float exportPrice;
    private float profit;
    private int quantity;
    private String descriptions;
    private Boolean status;

    //Constructor không tham so
    public Product() {
    }

    //Constructor có tham số
    public Product(String productId, String productName, float importPrice, float exportPrice,
                   float profit, int quantity, String descriptions, Boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.profit = profit;
        this.quantity = quantity;
        this.descriptions = descriptions;
        this.status = status;
    }

    //Getter/Setter
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getProfit() {
        return profit;
    }

    public void setProfit(float profit) {
        this.profit = profit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    //Các phương thức
    public void inputData(Scanner scanner, Product[] arrProduct, int indexProduct) {
        this.productId = inputProductId(scanner, arrProduct, indexProduct);
        this.productName = inputProductName(scanner, arrProduct, indexProduct);
        this.importPrice = inputImportPrice(scanner);
        this.exportPrice = inputExportPrice(scanner);
        this.quantity = inputQuality(scanner);
        System.out.println("Nhập mô tả sản phẩm: ");
        this.descriptions = scanner.nextLine();
        this.status = inputProductStatus(scanner);
    }

    public void calProfit() {
        this.profit = exportPrice - importPrice;
        System.out.printf("%.2f\n", profit);
    }

    public void displayData() {
        System.out.printf("\nMã sản phẩm: %s - Tên sản phẩm: %s - Giá nhập: %.2f - Giá xuất: %.2f - Lợi nhuận: %.2f\n"
                , this.productId, this.productName, this.importPrice, this.exportPrice, this.profit);
        System.out.printf("Số lượng sản phẩm có giá trị lớn hơn 0: %d - Mô tả sản phẩm: %s - Trạng thái sản phẩm: %s\n"
                , this.quantity, this.descriptions, (this.status = true) ? "Đang bán" : "Không bán");
    }

    public String inputProductId(Scanner scanner, Product[] arrProduct, int indexProduct) {
        System.out.println("Nhập mã sản phẩm: ");
        do {
            String productId = scanner.nextLine();
            if (productId.length() == 4) {
                if (productId.charAt(0) == 'P') {
                    //kiem tra trung lap
                    boolean isExist = false;
                    for (int i = 0; i < indexProduct; i++) {
                        if (arrProduct[i].getProductId().equals(this.productId)) {
                            isExist = true;
                            break;
                        }
                    }
                    if (isExist) {
                        System.err.println("Mã sản phẩm đã tồn tại, vui lòng nhập lại!");
                    } else {
                        return productId;
                    }
                } else {
                    System.err.println("Mã sản phẩm bắt đầu là P, vui lòng nhập lại!");
                }
            } else {
                System.err.println("Mã sản phẩm phải gồm 4 ký tự, vui lòng nhập lại!");
            }
        } while (true);
    }

    public String inputProductName(Scanner scanner, Product[] arrProduct, int indexProduct) {
        System.out.println("Nhập tên sản phẩm: ");
        do {
            String productName = scanner.nextLine();
            if (productName.length() >= 6 && productName.length() <= 50) {
                //kiem tra trung lap
                boolean isExist = false;
                for (int i = 0; i < indexProduct; i++) {
                    if (arrProduct[i].getProductName().equals(productName)) {
                        isExist = true;
                        break;
                    }
                }
                if (isExist) {
                    System.err.println("Tên sản phẩm đã tồn tại, vui lòng nhập lại!");
                } else {
                    return productName;
                }
            } else {
                System.err.println("Tên phải có từ 6-50 ký tự, vui lòng nhập lại!");
            }
        } while (true);
    }

    public float inputImportPrice(Scanner scanner) {
        //Giá nhập của sản phẩm
        System.out.println("Nhập vào giá nhập của sản phẩm: ");
        do {
            float importPrice = Float.parseFloat(scanner.nextLine());
            if (importPrice > 0) {
                return importPrice;
            } else {
                System.err.println("Giá nhập phải lớn hơn 0, vui lòng nhập lại!");
            }
        } while (true);
    }

    public float inputExportPrice(Scanner scanner) {
        //Giá xuất của sản phẩm
        System.out.println("Nhập vào giá xuất của sản phẩm: ");
        do {
            float exportPrice = Float.parseFloat(scanner.nextLine());
            if (exportPrice >= 1.2 * importPrice) {
                return exportPrice;
            } else {
                System.err.println("Giá xuất phải có giá trị lớn hơn 20% giá nhập, vui lòng nhập lại!");
            }
        } while (true);
    }

    public int inputQuality(Scanner scanner) {
        System.out.println("Nhập vào số lượng sản phẩm: ");
        do {
            int quantity = Integer.parseInt(scanner.nextLine());
            if (quantity > 0) {
                return quantity;
            } else {
                System.err.println("Số lượng sản phẩm phải lớn hơn 0, vui lòng nhập lại!");
            }
        } while (true);
    }

    public boolean inputProductStatus(Scanner scanner) {
        //Nhập trạng thái sản phẩm
        System.out.println("Nhập trạng thái sản phẩm: ");
        do {
            String status = scanner.nextLine();
            if (status.equals("true") || status.equals("false")) {
                return Boolean.parseBoolean(status);
            } else {
                System.err.println("Trạng thái sản phẩm chỉ nhận giá trị true hoặc false, vui lòng nhập lại!");
            }
        } while (true);
    }
}
