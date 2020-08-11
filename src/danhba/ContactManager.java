package danhba;

import doc_ghi_file.ReadAndWhite;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactManager {
    private static final String TOBI = "DATA/contact.txt";
    public static Scanner sc = new Scanner(System.in);
    private List<Contact> listContact;
    private ReadAndWhite<Contact> readAndWhite;

    public ContactManager() {
        readAndWhite = new ReadAndWhite<>();
        listContact = readAndWhite.readFile(TOBI);
    }

    public void add() {
        System.out.println("Nhap stt : ");
        int stt = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap so dien thoai : ");
        String phoneNumber = sc.nextLine();
        System.out.println("Nhap nhom : ");
        String crew = sc.nextLine();
        System.out.println("Nhap ten : ");
        String name = sc.nextLine();
        System.out.println("Nhap gioi tinh : ");
        String gender = sc.nextLine();
        System.out.println("Nhap dia chi : ");
        String address = sc.nextLine();
        System.out.println("Nhap ngay sinh : ");
        String birthday = sc.nextLine();
        System.out.println("Nhap dia chi email : ");
        String email = sc.nextLine();

        Contact contact = new Contact(stt,phoneNumber,crew,name,gender,address,email);
        listContact.add(contact);
        readAndWhite.writeFile(TOBI,listContact);
    }

    public void remove(int stt) {
        Contact contact = null;
        for (int i = 0; i < listContact.size(); i++) {
            if (listContact.get(i).getStt() == stt) {
                contact = listContact.get(i);
                break;
            }
        }
        if (contact != null) {
            System.out.println("Da xoa : " + contact.getName());
            listContact.remove(contact);
            readAndWhite.writeFile(TOBI,listContact);
        } else {
            System.out.printf("Stt = %d khong tim thay .\n", stt);
        }
    }

    public void display(Contact contactList) {
        System.out.printf("| %3s", "");
        System.out.printf("%-3d  | ",contactList.getStt());
        System.out.printf("%-3d  | ",contactList.getPhoneNumber());
        System.out.printf("%-3d  | ",contactList.getCrew());
        System.out.printf("%-3d  | ",contactList.getName());
        System.out.printf("%-3d  | ",contactList.getGender());
        System.out.printf("%-3d  | ",contactList.getAddress());
        System.out.printf("%-3d  | ",contactList.getBirthday());
        System.out.printf("%-3d  | ",contactList.getEmail());
    }

    public void edit(int stt) {
        boolean isExit = false;
        for (int i = 0; i < listContact.size();i++) {
            if (stt ==(listContact.get(i).getStt())){
                isExit = true;
                System.out.println("Lua chon : ");
                System.out.println("1. Sua so dien thoai :");
                System.out.println("2. Sua nhom : ");
                System.out.println("3. Sua ho va ten : ");
                System.out.println("4. Sua gioi tinh : ");
                System.out.println("5. Sua dia chi : ");
                System.out.println("6 . Hoan thanh");
                System.out.println("0. Ket thuc");

                int choice;
                boolean check = true;
                while (check) {
                    choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("Sua so dien thoai " + listContact.get(i).getPhoneNumber() + " thanh ");
                            sc.nextLine();
                            String sdtMoi = sc.nextLine();
                            listContact.get(i).setPhoneNumber(sdtMoi);
                            System.out.println("So dien thoai sau khi sua ");
                            display(listContact.get(i));
                            break;
                        case 2:
                            System.out.println("Sua nhom "+ listContact.get(i).getCrew() + " thanh ");
                            sc.nextLine();
                            String nhomMoi = sc.nextLine();
                            listContact.get(i).setCrew(nhomMoi);
                            System.out.println("Nhom da sua ");
                            display(listContact.get(i));
                            break;
                        case 3:
                            System.out.println("Sua ho va ten : " + listContact.get(i).getName() + " thanh ");
                            sc.nextLine();
                            String tenMoi = sc.nextLine();
                            listContact.get(i).setName(tenMoi);
                            System.out.println("Ten da sua ");
                            display(listContact.get(i));
                            break;
                        case 4:
                            System.out.println("Sua gioi tinh : " + listContact.get(i).getGender() + " thanh ");
                            sc.nextLine();
                            String gioiTinhMoi = sc.nextLine();
                            listContact.get(i).setGender(gioiTinhMoi);
                            System.out.println("Gioi tinh da sua ");
                            display(listContact.get(i));
                            break;
                        case 5:
                            System.out.println("Sua dia chi : " + listContact.get(i).getAddress() + " thanh ");
                            sc.nextLine();
                            String diaChiMoi = sc.nextLine();
                            listContact.get(i).setAddress(diaChiMoi);
                            System.out.println("Dia chi da sua ");
                            display(listContact.get(i));
                            break;
                        case 6:
                            System.out.println(" hoan thanh !");
                            System.out.println();
                            sc.nextLine();
                            check = false;
                        case 0:
                            System.exit(0);
                        default:
                    }
                }
            }
        }
        if (!isExit) {
            System.out.printf("Stt =%d khong tim thay .\n", stt);
        } else {
            readAndWhite.writeFile(TOBI,listContact);
        }
    }

    public boolean checkKey(String key , String input) {
        key = key.toUpperCase();
        String regex = ".*" + key + ".*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input.toUpperCase());
        return  matcher.matches();
    }

    public void search(String key) {
        List<Contact> searchContact = new ArrayList<>();
        Iterator<Contact> iterator = listContact.iterator();
        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            if (checkKey(key,contact.getName())) {
                searchContact.add(contact);
            }
        }
        show2(searchContact);
    }

    public void show2(List<Contact> searchContact) {
        System.out.printf("| %1s", "");
        System.out.printf("%-4s  |  ", "Stt");
        System.out.printf("%20s", "");
        System.out.printf("%-30s  |  ", "So dien thoai");
        System.out.printf("%2s", "");
        System.out.printf("%-8s  |  ", "Nhom");
        System.out.printf("%6s", "");
        System.out.printf("%-12s  |  ", "Ho va ten");
        System.out.printf("%3s", "");
        System.out.printf("%-7s |  ", "Gioi tinh");
        System.out.printf("%3s", "");
        System.out.printf("%-7s |  ", "Dia chi");
        System.out.printf("%3s", "");
        System.out.printf("%-7s |  ", "Ngay sinh");
        System.out.printf("%3s", "");
        System.out.printf("%-7s |  ", "Email");
        System.out.println();



        for (Contact contactList : searchContact) {
            System.out.printf("%-3d  | ", contactList.getStt());
            System.out.printf("%-3d  | ", contactList.getPhoneNumber());
            System.out.printf("%-3d  | ", contactList.getCrew());
            System.out.printf("%-3d  | ", contactList.getName());
            System.out.printf("%-3d  | ", contactList.getGender());
            System.out.printf("%-3d  | ", contactList.getAddress());
            System.out.printf("%-3d  | ", contactList.getBirthday());
            System.out.printf("%-3d  | ", contactList.getEmail());
            System.out.println();
        }
    }

    public void show() {
        System.out.printf("| %1s", "");
        System.out.printf("%-4s  |  ", "Stt");
        System.out.printf("%20s", "");
        System.out.printf("%-30s  |  ", "So dien thoai");
        System.out.printf("%2s", "");
        System.out.printf("%-8s  |  ", "Nhom");
        System.out.printf("%6s", "");
        System.out.printf("%-12s  |  ", "Ho va ten");
        System.out.printf("%3s", "");
        System.out.printf("%-7s |  ", "Gioi tinh");
        System.out.printf("%3s", "");
        System.out.printf("%-7s |  ", "Dia chi");
        System.out.printf("%3s", "");
        System.out.printf("%-7s |  ", "Ngay sinh");
        System.out.printf("%3s", "");
        System.out.printf("%-7s |  ", "Email");
        System.out.println();

        for (Contact list1 : listContact) {
            System.out.printf("|%3s", "");
            System.out.printf("%-3d  |  ", list1.getStt());
            System.out.printf("%-50s  |  ", list1.getPhoneNumber());
            System.out.printf("%-10s  |  ", list1.getCrew());
            System.out.printf("%-18s  |  ", list1.getName());
            System.out.printf("%3s", "");
            System.out.printf("%-7s  |  ", list1.getGender());
            System.out.printf("%-7s  |  ", list1.getAddress());
            System.out.printf("%-7s  |  ", list1.getBirthday());
            System.out.printf("%-7s  |  ", list1.getEmail());
            System.out.println();
        }
    }
}
