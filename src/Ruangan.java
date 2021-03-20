import java.util.ArrayList;
import java.util.Scanner;

public class Ruangan {

    private Pintu objPintu;
    private Item  objKunci;
    private Item  objRoti;
    private ArrayList<Item> arrItem = new ArrayList<>();
    private String deskripsi;
    private GameInfo objGameInfo;
    private Scanner sc = new Scanner(System.in);


    //objgame juga diset pada pintu dan item2
    public void setObjGameInfo(GameInfo objGameInfo) {
        this.objGameInfo = objGameInfo;
        objPintu.setObjGameInfo(objGameInfo);
        for (Item objItem:arrItem) {
            objItem.setObjGameInfo(objGameInfo);
        }
    }

    public Ruangan() {
        // init ruangan
        // init pintu, kunci dan roti.
        objPintu = new Pintu();

        objKunci = new Item("Kunci");
        objKunci.setDeskripsi("Sebuah kunci kecil yang sudah agak berkarat");
        objKunci.setObjRuangan(this);

        objRoti  = new Item("Roti");
        objRoti.setDeskripsi("Roti rasa coklat dalam bungkusan plastik");
        objRoti.setObjRuangan(this);

        //tambah item ke array
        arrItem.add(objKunci);
        arrItem.add(objRoti);

    }

    //aksi yang dapat dilakukan di ruangan
    //agak kompleks tapi jadi fleksibel, logic aksi ada di masing2 item (bukan di game engine)
    //hardcode menu dikurangi
    public void pilihanAksi() {

        System.out.println("==== Pilihan Aksi pada Ruangan ===");
        int urutPil = 0;  //item, pintu
        int subPil = 0;   //aksinya

        //aksi2 item
        System.out.println("Item di ruangan");
        for (Item objItem:arrItem) {
            urutPil++;
            subPil = 0;   //sistem penomorannya 11  12  13 dst
            System.out.println(objItem.getNama());
            //ambil pilihannya
            ArrayList <String> arrPil = objItem.getAksi();
            //print pilihan
            for (String strPil:arrPil) {
                subPil++;
                System.out.println(String.format("%d%d. %s ", urutPil, subPil, strPil));
            }
        }


        // aksi2 PINTU
        //belum menggunakan inheritance, jadi masih perlu penanganan terpisah untuk item spesifik seperti pintu
        urutPil++;
        subPil = 0;
        int pilPintu  = urutPil; //catat untuk pintu
        System.out.println("Pintu");
        for (String strPil:objPintu.getAksi()) {
            subPil++;
            System.out.println(String.format("%d%d. %s ", urutPil, subPil, strPil));
        }

        System.out.print("Pilihan anda?");
        String strPil = sc.next();
        System.out.println("--");

        //split pilihan dan subpilihan
        int pil    =  Integer.parseInt(strPil.substring(0,1)); //ambil digit pertama, asumsikan jumlah tidak lebih dari 10
        subPil     =  Integer.parseInt(strPil.substring(1,2)); //ambil digit kedua, asumsikan jumlah tidak lebih dari 10
        if (pil ==pilPintu)  {
            objPintu.prosesAksi(subPil);  //aksi pintu
        } else {
            //item
            Item objItemPilih = arrItem.get(pil-1);
            objItemPilih.prosesAksi(subPil); //aksi item
        }

    }

    // hapus item di ruangan berdasarkan namanya
    // digunakan saat suatu item diambil oleh player misalnya
    public void hapusItem(Item objItem) {
        arrItem.remove(objItem);  //buang item
    }


    public String getDeskripsi() {
        return deskripsi;
    }
    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

}
