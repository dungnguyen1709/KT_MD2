import java.io.*;
import java.util.ArrayList;

import java.util.Scanner;

public class ContactManager {
    Scanner sc = new Scanner(System.in);
    public ArrayList<Contact> arrayList;

    public void display() throws IOException {
        arrayList = readContact();
        for (Contact contact : arrayList) {
            System.out.println(contact);
        }
    }

    public void addContact() throws IOException {

        System.out.println("Nhập thông tin");
        System.out.println("Nhập số điện thoại : ");
        String phoneNumber = sc.nextLine();
        System.out.println("Nhập nhóm : ");
        String crew = sc.nextLine();
        System.out.println("Nhập họ tên :");
        String name = sc.nextLine();
        System.out.println("Nhập giới tính : ");
        String gender = sc.nextLine();
        System.out.println("Nhập địa chỉ : ");
        String address = sc.nextLine();
        System.out.println("Nhập ngày sinh : ");
        String dateOfBirth = sc.nextLine();
        System.out.println("Nhập email : ");
        String email = sc.nextLine();

        Contact contact = new Contact(phoneNumber, crew, name, gender, address, dateOfBirth, email);
        arrayList = readContact();
        arrayList.add(contact);
        clearContact();

        for (Contact contact1 : arrayList) {
            writeContact(contact1);
        }
        System.out.println("Thêm thành công ");
    }

    public boolean updateContact() throws IOException {

        boolean check = false;
        System.out.println("Nhập số điện thoại : ");
        String phoneNumber = sc.nextLine();
        arrayList = readContact();
        clearContact();
        for (Contact contact : arrayList) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                editContact(contact);
                check = true;
            }
            writeContact(contact);
        }
        return check;
    }

    public void editContact(Contact contact) throws IOException {

        System.out.println("Nhập thông tin");
        System.out.println("Nhập nhóm : ");
        String crew = sc.nextLine();
        System.out.println("Nhập họ tên : ");
        String name = sc.nextLine();
        System.out.println("Nhập giới tính : ");
        String gender = sc.nextLine();
        System.out.println("Nhập địa chỉ :");
        String address = sc.nextLine();
        System.out.println("Nhập ngày sinh : ");
        String dateOfBirth = sc.nextLine();
        System.out.println("Nhập email : ");
        String email = sc.nextLine();

        contact.setCrew(crew);
        contact.setName(name);
        contact.setGender(gender);
        contact.setAddress(address);
        contact.setDateOfBirth(dateOfBirth);
        contact.setEmail(email);
    }

    public boolean removeContact() throws IOException {

        boolean checked = false;
        System.out.println("Nhập số điện thoại : ");
        String phoneNumber = sc.nextLine();
        arrayList = readContact();
        ArrayList<Contact> arrayList1 = new ArrayList<>();
        clearContact();
        for (Contact contact : arrayList) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                checked = true;
            } else {
                arrayList1.add(contact);
            }
        }
        for (Contact contact : arrayList1) {
            writeContact(contact);
        }
        return checked;
    }

    public void searchContact() throws IOException {
        boolean isExit = false;
        System.out.println("Nhập số điện thoại: ");
        String phoneNumber = sc.nextLine();
        arrayList = readContact();
        for (Contact contact : arrayList) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                System.out.println(contact);
                isExit = true;
            }
        }
        if (!isExit) {
            System.out.println("Không tìm thấy ");
        }
    }

    public ArrayList<Contact> readContact() throws IOException {
        FileReader fileReader = new FileReader(new File("contact.csv"));
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String contact;
        ArrayList<Contact> arrayList = new ArrayList<>();
        while ((contact = bufferedReader.readLine()) != null) {
            String[] str = contact.split("-");
            Contact contact1 = new Contact(str[0], str[1], str[2], str[3], str[4], str[5], str[6]);
            arrayList.add(contact1);
        }
        return arrayList;
    }

    public void writeContact(Contact contact) throws IOException {
        FileWriter fileWriter = new FileWriter("contact.csv", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String str1 = contact.getPhoneNumber() + "-" + contact.getCrew() + "-" + contact.getName()
                + "-" + contact.getGender() + "-" + contact.getAddress() + "-" + contact.getDateOfBirth()
                + "-" + contact.getEmail() + "\n";
        bufferedWriter.write(str1);
        bufferedWriter.close();
    }

    public void clearContact() throws IOException {
        FileWriter fileWriter = new FileWriter("contact.csv");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String st2 = "";
        bufferedWriter.write(st2);
        bufferedWriter.close();
    }
}

