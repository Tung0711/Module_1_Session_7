package RA_Ex1.entity_ex1;

import java.util.Scanner;

public class Book {
    //Cac thuoc tinh
    private String bookId;
    private String bookName;
    private float importPrice;
    private float exportPrice;
    private String author;
    private float interest;
    private int year;

    //Constructor ko tham so
    public Book() {
    }

    //Constructor co tham so
    public Book(String bookId, String bookName, float importPrice, float exportPrice, String author, float interest, int year) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.author = author;
        this.interest = interest;
        this.year = year;
    }

    //Set get
    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    //Cac phuong thuc khac
    public void inputData(Scanner scanner, Book[] arrBooks, int indexBooks) {
        this.bookId = inputBookId(scanner, arrBooks, indexBooks);
        this.bookName = inputBookName(scanner, arrBooks, indexBooks);
        this.importPrice = inputImportPrice(scanner);
        this.exportPrice = inputExportPrice(scanner);
        this.author = inputAuthor(scanner);
        this.year = inputYear(scanner);
    }

    public void interest() {
        this.interest = exportPrice - importPrice;
        System.out.printf("%.2f\n", this.interest);
    }

    public void displayData() {
        System.out.printf("\nMã sách: %s - Tên sách: %s - Giá nhập của sách: %.2f\n", this.bookId, this.bookName, this.importPrice);
        System.out.printf("Giá xuất của sách: %.2f - Tác giả: %s - Lợi nhuận: %.2f - Năm xuất bản: %d\n"
                , this.exportPrice, this.author, this.interest, this.year);
    }

    public String inputBookId(Scanner scanner, Book[] arrBook, int indexBook) {
        //nhap ma sach
        System.out.println("Nhập mã sách: ");
        do {
            String bookId = scanner.nextLine();
            //kiem tra trung lap
            boolean isExist = false;
            for (int i = 0; i < indexBook; i++) {
                if (arrBook[i].getBookId().equals(bookId)) {
                    isExist = true;
                    break;
                }
            }
            if (isExist) {
                System.err.println("Mã danh mục đã tồn tại, vui lòng nhập lại!");
            } else {
                return bookId;
            }
        } while (true);
    }

    public String inputBookName(Scanner scanner, Book[] arrBook, int indexBook) {
        //Nhap ten sach
        System.out.println("Nhap ten sach: ");
        do {
            String bookName = scanner.nextLine();
            if (bookName.length() == 4) {
                if (bookName.charAt(0) == 'B') {
                    //kiem tra trung lap
                    boolean isExist = false;
                    for (int i = 0; i < indexBook; i++) {
                        if (arrBook[i].getBookName().equals(this.bookName)) {
                            isExist = true;
                            break;
                        }
                    }
                    if (isExist) {
                        System.err.println("Tên sách đã tồn tại, vui lòng nhập lại!");
                    } else {
                        return bookName;
                    }
                } else {
                    System.err.println("Tên sách bắt đầu là B, vui lòng nhập lại!");
                }
            } else {
                System.err.println("Tên phải gồm 4 ký tự, vui lòng nhập lại!");
            }
        } while (true);
    }

    public float inputImportPrice(Scanner scanner) {
        //Giá nhập
        System.out.println("Nhập vào giá nhập của sách: ");
        do {
            float importPrice = Float.parseFloat(scanner.nextLine());
            if (importPrice > 0) {
                return importPrice;
            } else {
                System.err.println("Giá nhập phải có giá trị lớn hơn 0, vui lòng nhập lại!");
            }
        } while (true);
    }

    public float inputExportPrice(Scanner scanner) {
        //Giá xuất
        System.out.println("Nhập vào giá xuất của sách: ");
        do {
            float exportpPrice = Float.parseFloat(scanner.nextLine());
            if (exportpPrice * 1.3 >= importPrice) {
                return exportpPrice;
            } else {
                System.err.println("Giá xuất phải có giá trị lớn hơn 30% giá nhập, vui lòng nhập lại!");
            }
        } while (true);
    }

    public String inputAuthor(Scanner scanner) {
        //tac gia
        System.out.println("Nhap ten tac gia: ");
        do {
            String author = scanner.nextLine();
            if (author.length() >= 6 && author.length() <= 50) {
                return author;
            } else {
                System.err.println("Tên tác giả có từ 6-50 ký tự, vui lòng nhập lại!");
            }
        } while (true);
    }

    public int inputYear(Scanner scanner) {
        //nam xuat ban
        System.out.println("Nhập năm xuất bản: ");
        do {
            int year = Integer.parseInt(scanner.nextLine());
            if (year > 2000) {
                return year;
            } else {
                System.err.println("Năm xuất bản phải sau 2000");
            }
        } while (true);
    }
}
