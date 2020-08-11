package doc_ghi_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWhite<E> {
    public void writeFile(String TOBI, List<E> list) {
        try {
            FileOutputStream fos = new FileOutputStream(TOBI);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<E> readFile(String TOBI) {
        List<E> list = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(TOBI);
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (List<E> )ois.readObject();
             ois.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}
