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

        Contact contact = new Contact(phoneNumber,crew,name,gender,address,email);
        listContact.add(contact);
        readAndWhite.writeFile(TOBI,listContact);
    }

    public void remove(String phoneNumber) {
        Contact contact = null;
        for (int i = 0; i < listContact.size(); i++) {
            if (phoneNumber.equals(listContact.get(i).getPhoneNumber())) {
                contact = listContact.get(i);
                break;
            }
        }
        if (contact != null) {
            System.out.println("Da xoa : " + contact.getName());
            listContact.remove(contact);
            readAndWhite.writeFile(TOBI,listContact);
        } else {
            System.out.printf("khong ton tai");
        }
    }

    public void display(Contact contactList) {
        System.out.printf("| %3s", "");
        System.out.printf("%-3d  | ",contactList.getPhoneNumber());
        System.out.printf("%-3d  | ",contactList.getCrew());
        System.out.printf("%-3d  | ",contactList.getName());
        System.out.printf("%-3d  | ",contactList.getGender());
        System.out.printf("%-3d  | ",contactList.getAddress());
        System.out.printf("%-3d  | ",contactList.getBirthday());
        System.out.printf("%-3d  | ",contactList.getEmail());
    }

    public void edit() {
        boolean isExit = false;
        while (isExit) {
            String number = sc.nextLine();
            if (number.equals("")) {
                break;
            } else {
                for (Contact contact : listContact ) {
                    if (number.equals(contact.getPhoneNumber())) {
                        isExit = false;
                        System.out.println("Sua so dien thoai" + contact.getPhoneNumber() + "thanh");
                        String phoneNumber = sc.nextLine();
                        contact.setCrew(phoneNumber);

                        System.out.println("Sua ho va ten" + contact.getName() + "thanh");
                        String name = sc.nextLine();
                        contact.setName(name);

                        System.out.println("Sua gioi tinh" + contact.getGender() + "thanh");
                        String gender = sc.nextLine();
                        contact.setGender(gender);

                        System.out.println("Sua nhom" + contact.getCrew() + "thanh");
                        String crew = sc.nextLine();
                        contact.setCrew(crew);

                        System.out.println("Sua dia chi" + contact.getAddress() + "thanh");
                        String address = sc.nextLine();
                        contact.setAddress(address);

                    }
                }
            }
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
