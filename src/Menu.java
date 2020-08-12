import java.io.IOException;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    ContactManager contactManager = new ContactManager();

    public void menu() {
        try {
            do {
                System.out.println("---CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ---");
                System.out.println("Chọn chức năng theo số để tiếp tục");
                System.out.println("1. Xem danh sách");
                System.out.println("2. Thêm mới");
                System.out.println("3. Cập nhật");
                System.out.println("4. Xóa");
                System.out.println("5. Tìm kiếm");
                System.out.println("6. Đọc từ file");
                System.out.println("7. Ghi vào file");
                System.out.println("8. Thoát");
                System.out.println("Chọn chức năng: ");

                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        contactManager.display();
                        break;
                    case 2:
                        contactManager.addContact();
                        break;
                    case 3:
                       if (contactManager.updateContact()) {
                           System.out.println("Sửa thành công");
                       } else {
                           System.out.println("Không có trong danh bạ");
                       }
                       break;
                    case 4:
                        if (contactManager.removeContact()) {
                            System.out.println("Xóa thành công");
                        } else {
                            System.out.println("Không có trong danh bạ");
                        }
                        break;
                    case 5:
                        contactManager.searchContact();
                        break;
                    case 6:
                        contactManager.readContact();
                        break;
                    case 7:
                        break;
                    case 8:
                        System.exit(0);
                    default:

                }
            }while (true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
