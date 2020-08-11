import danhba.ContactManager;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ContactManager contactManager = new ContactManager();
        boolean check = true;
        while (check) {
            System.out.println("--- CHUONG TRINH QUAN LI DANH BA ---");
            System.out.println("Chon chuc nang theo so(de tiep tuc): ");
            System.out.println("1. Xem danh sach");
            System.out.println("2. Them moi");
            System.out.println("3. Cap nhat");
            System.out.println("4. Xoa");
            System.out.println("5. Tim kiem");
            System.out.println("6. Doc tu file");
            System.out.println("7. Ghi vao file");
            System.out.println("8. Thoat");

            try {
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Danh ba");
                        contactManager.show();
                        break;
                    case 2:
                    contactManager.add();
                        System.out.println("them thanh cong");
                        break;
                    case 3:
                        System.out.println("Nhap so dien thoai muon sua");
                        contactManager.edit();
                        break;
                    case 4:
                        System.out.println("Nhap so dien thoai muon xoa");
                        sc.nextLine();
                        String phoneNumber = sc.nextLine();
                        if (phoneNumber.equals("")) {
                            break;
                        } else {
                            contactManager.remove(phoneNumber);
                        }
                        break;
                    case 5:
                        sc.nextLine();
                        System.out.println("Nhap tu tim kiem");
                        String key = sc.nextLine();
                        contactManager.search(key);
                        break;
                    case 8:
                        System.exit(8);
                    default:
                }
            }catch (InputMismatchException e) {
                System.err.println("Nhap so");
                Main.sc.nextLine();
            }

        }
    }
}
