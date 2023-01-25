import com.config.cConfig;
import com.view.cView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        while (true){
            System.out.print("Menu :\n" +
                    "1. Lihat semua data\n" +
                    "2. Detail data barang\n" +
                    "3. Cari data barang\n" +
                    "4. Tambah data barang\n" +
                    "5. Update data baranng\n" +
                    "0. Exit\n" +
                    "Pilih [1/2/3/4/5] : ");
            Scanner userInput = new Scanner(System.in);
            String pilihanUser = userInput.next();

            if (pilihanUser.equalsIgnoreCase("0")){
                break;
            }

            switch (pilihanUser){
                case "1":
                    cView.getAllData();
                    break;
                case "2":
                    System.out.println("Detail data barang\n");
                    break;
                case "3":
                    System.out.println("Cari data barang\n");
                    break;
                case "4":
                    System.out.println("Tambah data barang\n");
                    break;
                case "5":
                    System.out.println("Hapus data barang\n");
                    break;
                default:
                    System.out.println("Pilihan salah!\n");
                    break;
            }
        }

    }
}
