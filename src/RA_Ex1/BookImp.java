package RA_Ex1;

import RA_Ex1.entity_ex1.Book;

import java.util.Scanner;

public class BookImp {
    //khoi tao mang
    Book[] arrBooks = new Book[100];
    int indexBook = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookImp book = new BookImp();
        do {
            System.out.println("************ MENU ************");
            System.out.println("1. Nhập thông tin n sách");
            System.out.println("2. Tính lợi nhuận các sách");
            System.out.println("3. Hiển thị thông tin sách");
            System.out.println("4. Sắp xếp sách theo giá bán tăng dần");
            System.out.println("5. Sắp xếp sách theo lợi nhuận giảm dần");
            System.out.println("6. Tìm sách theo tên sách");
            System.out.println("7. Thống kê số lượng sách theo năm xuất bản");
            System.out.println("8. Thống kê số lượng sách theo tác giả");
            System.out.println("9. Thoát");
            System.out.println("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    book.inputMenu(scanner);
                    break;
                case 2:
                    book.interest();
                    break;
                case 3:
                    book.displayMenu();
                    break;
                case 4:
                    book.sortBookByExportPrice();
                    break;
                case 5:
                    book.sortBookByInterest();
                    break;
                case 6:
                    book.findForBookByName(scanner);
                    break;
                case 7:
                    book.findBookByYear(scanner);
                    break;
                case 8:
                    book.findBookByAuthor(scanner);
                    break;
                case 9:
                    System.out.println("Chương trình kết thúc. Xin tạm biệt!");
                    System.exit(0);
                default:
                    System.err.println("Lựa chọn không phù hợp. Vui lòng nhập lại!");
            }
        } while (true);
    }

    public void inputMenu(Scanner scanner) {
        System.out.println("Nhập số sách cần nhập thông tin:");
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < number; i++) {
            arrBooks[indexBook] = new Book();
            arrBooks[indexBook].inputData(scanner, arrBooks, indexBook);
            indexBook++;
        }
    }

    public void displayMenu() {
        System.out.println("Thông tin sách: ");
        for (int i = 0; i < indexBook; i++) {
            arrBooks[i].displayData();
        }
    }

    public void interest() {
        System.out.println("Lợi nhuận của các sách: ");
        for (int i = 0; i < indexBook; i++) {
            arrBooks[i].interest();
        }
    }

    public void sortBookByExportPrice() {
        Book temp;
        System.out.println("Sắp xếp sách theo giá bán tăng dần:");
        for (int i = 0; i < indexBook - 1; i++) {
            for (int j = i + 1; j < indexBook; j++) {
                if (arrBooks[i].getExportPrice() > arrBooks[j].getExportPrice()) {
                    temp = arrBooks[i];
                    arrBooks[i] = arrBooks[j];
                    arrBooks[j] = temp;
                }
            }
        }
        System.out.println("Sắp xếp thành công!");
    }

    public void sortBookByInterest() {
        Book temp;
        System.out.println("Sắp xếp sách theo lợi nhuận giảm dần:");
        for (int i = 0; i < indexBook - 1; i++) {
            for (int j = i + 1; j < indexBook; j++) {
                if (arrBooks[i].getInterest() < arrBooks[j].getInterest()) {
                    temp = arrBooks[i];
                    arrBooks[i] = arrBooks[j];
                    arrBooks[j] = temp;
                }
            }
        }
        System.out.println("Sắp xếp thành công!");
    }

    public void findForBookByName(Scanner scanner) {
        System.out.print("Nhập sách bạn muốn tìm theo tên: ");
        String nameBookFindFor = scanner.nextLine();
        System.out.println("Sách có tên bạn tìm:");
        boolean checkFindForBook = false;
        for (int i = 0; i < indexBook; i++) {
            if (arrBooks[i].getBookName().contains(nameBookFindFor)) {
                checkFindForBook = true;
                arrBooks[i].displayData();
            }
        }
        if (!checkFindForBook) {
            System.out.print("Không có sách có tên bạn cần tìm!");
        }
    }

    public void findBookByYear(Scanner scanner) {
        System.out.println("Nhập năm xuất bản muốn thống kê số lượng sách: ");
        int yearFindBook = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < indexBook; i++) {
            if (arrBooks[i].getYear() == yearFindBook) {
                arrBooks[i].displayData();
            }
        }
    }

    public void findBookByAuthor(Scanner scanner) {
        System.out.println("Nhập tên tác giả muốn thống kê số lượng sách: ");
        String authorFindBook = scanner.nextLine();
        for (int i = 0; i < indexBook; i++) {
            if (arrBooks[i].getAuthor().equals(authorFindBook)) {
                arrBooks[i].displayData();
            }
        }
    }
}
