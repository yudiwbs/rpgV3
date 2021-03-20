import java.util.ArrayList;

public class Item {
    private String deskripsi;
    private String nama;
    private ArrayList<String> arrAksi = new ArrayList<>(); //pilihan aksi untuk item
    private Ruangan objRuangan;  //ruangan tempat item
    private GameInfo objGameInfo;

    //constructor
    public Item(String nama) {
        this.nama = nama;
        arrAksi.add("Deskripsi Item");
        arrAksi.add("Ambil item");
    }

    public void prosesAksi(int pil) {
        //pilihan user untuk aksi yang akan diambil
        //urutan harus sama dengan isi arrAksi
        if (pil==1) {
            System.out.println(deskripsi);
        } else  if (pil==2) {
            diambil();
        }
    }

    //pindahkan item dari ruangan ke player
    private void diambil() {
        System.out.println("Item diambil player");
        objGameInfo.getObjPlayer().addItem(this);     //tambahkan  objek ini (this) pada player
        objRuangan.hapusItem(this);  //hapus dari ruangan
        objRuangan = null;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void printItem() {
        //print deskripsi item
        System.out.println(deskripsi);
    }

    public ArrayList<String> getAksi() {
         return(arrAksi);
    }

    public void setObjGameInfo(GameInfo objGameInfo) {
        this.objGameInfo = objGameInfo;
    }

    public void setObjRuangan(Ruangan objRuangan) {
        this.objRuangan = objRuangan;
    }
    public String getDeskripsi() {
        return deskripsi;
    }
    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }


}
