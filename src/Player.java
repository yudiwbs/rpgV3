import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    //item yang dimiliki player
    private ArrayList<Item> arrItem = new ArrayList<>();
    private Ruangan ruanganAktif;  //ruangan tempat player saat ini berada
    private int kesehatan = 100;
    private String nama = "budiwati";
    private Scanner sc = new Scanner(System.in);

    public int getKesehatan() {
        return kesehatan;
    }

    public void setKesehatan(int kesehatan) {
        this.kesehatan = kesehatan;
    }

    public Player() {
        arrItem = new ArrayList<>();
    }

    public void addItem(Item objItem) {
        arrItem.add(objItem);
    }

    //cari item yang dimiliki oleh player, return TRUE jika ada
    //salah satu yg menggunakan: pintu untuk mengecek apakah player sudah punya kunci
    public boolean cariItem(String namaItem) {
        for (Item objItem:arrItem) {
             if (namaItem.equals(objItem.getNama())) {
                 return (true);
            }
        }
        return(false); //tidak ketemu
    }

    public void printPlayer() {
        System.out.println("Nama Player:"+nama);
        System.out.println("Kesehatan Player:"+kesehatan);
    }

    public void printItem() {
        System.out.println("Item milik player");
        int cc = 0;
        for (Item objItem:arrItem) {
            cc++;
            System.out.println(String.format("%d. %s",cc,objItem.getNama()));
            System.out.println(objItem.getDeskripsi());
        }
    }


    public void pilihanAksi() {
        System.out.println("**** Pilihan Aksi pada Player *** ");
        System.out.println("1. Info player");
        //bisa saja untuk item diperlakukan sama spt Ruangan.pilihanAksi, sehingga item punya aksi
        System.out.println("2. Item milik player");
        System.out.print("Pilihan anda?");
        int pil = sc.nextInt();
        System.out.println("--");
        if (pil==1) {
            printPlayer();
        } else if (pil==2) {
            printItem();
        }
    }

    public void setRuanganAktif(Ruangan ruanganAktif) {
        this.ruanganAktif = ruanganAktif;
    }
    public Ruangan getRuanganAktif() {
        return ruanganAktif;
    }

}
