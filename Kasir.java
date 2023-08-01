import java.util.ArrayList;

import javax.swing.JOptionPane;

class Benda {
    public String nama;
    public int harga;

    public Benda(String nama, int harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return harga;
    }

    public void setNama(String nama) {
        nama = this.nama;
    }
    public void setharga(int harga) {
        harga = this.harga;
    }
}

public class Kasir {
    private ArrayList<Benda> menuBarang;
    private ArrayList<Benda> menuToping;
    private ArrayList<Integer> hargaPesanan;
    private static int noMinuman, jumlahMinuman, totalHargaMinuman, uang;
    private static int noToping, jumlahToping, totalHargaToping, totalHargaSemua;

    public Kasir() {
        menuBarang = new ArrayList<>();
        menuToping = new ArrayList<>();
        hargaPesanan = new ArrayList<>();

        // Inisialisasi menu minuman
        menuBarang.add(new Benda("Chocolate                      ", 10000));
        menuBarang.add(new Benda("Strawberry                    ", 10000));
        menuBarang.add(new Benda("Taro                                ", 10000));
        menuBarang.add(new Benda("Oreo                                ", 10000));
        menuBarang.add(new Benda("Bubblegum                      ", 11000));
        menuBarang.add(new Benda("Vanilla                           ", 9000));
        menuBarang.add(new Benda("Matcha                            ", 11000));
        menuBarang.add(new Benda("Greentea                        ", 10000));
        menuBarang.add(new Benda("Red Velvet                    ", 10000));
        menuBarang.add(new Benda("Mango                           ", 9000));

        // Inisialisasi menu toping
        menuToping.add(new Benda("Cheese Cream                ", 3000));
        menuToping.add(new Benda("Chocolate                  ", 3000));
        menuToping.add(new Benda("Boba                        ", 3000));
        
    }

    public void prosesPembelianMinuman() {
        String tampilan="";

        tampilan += "Menu Minuman: \n";
        for (int i = 0; i < menuBarang.size(); i++) {
            Benda barang = menuBarang.get(i);
            tampilan += (i + 1) + ". " + barang.getNama() + " = Rp" + barang.getHarga()+"\n";

            // Mengatur tampilan harga rata kanan
        // String formatHarga = String.format("%1$-30s", " = Rp" + totalHargaMinuman);
        // tampilan += (i + 1) + ". " + noMinuman + formatHarga + "\n";
        }
        noMinuman = Integer.parseInt(JOptionPane.showInputDialog(tampilan+"\nMasukkan nomor menu yang ingin dipilih:"));
        jumlahMinuman = Integer.parseInt(JOptionPane.showInputDialog("Masukkan jumlah barang:"));
        System.out.println("jumlah minuman: " + jumlahMinuman);
    }

    public void prosesPembelianToping() {
        String tampilan = "";

        tampilan += "Menu Toping: \n";
        for (int i = 0; i < menuToping.size(); i++) {
            Benda toping = menuToping.get(i);
            tampilan += (i + 1) + ". " + toping.getNama() + " = Rp" + toping.getHarga() + "\n";
        }
         
        String beliToping = JOptionPane.showInputDialog(tampilan + "\nIngin membeli toping? (ya/tidak)");
        if (beliToping.equalsIgnoreCase("ya") || beliToping.equalsIgnoreCase("iya")) {
            noToping = Integer.parseInt(JOptionPane.showInputDialog("Masukkan nomor toping:"));
            jumlahToping = Integer.parseInt(JOptionPane.showInputDialog("Masukkan jumlah toping:"));
        }
    }

    
    public void tanya() {
        String ulang;
        do {
            Kasir tanya = new Kasir();
            tanya.prosesPembelianMinuman();
            tanya.prosesPembelianToping();

            ulang = JOptionPane.showInputDialog("Ingin tambah minuman?");
        } while (ulang.equalsIgnoreCase("ya") || ulang.equalsIgnoreCase("iya"));
    }

    public void bayar() {
        // System.out.println(noToping);
        int hargaMinuman = menuBarang.get(noMinuman).getHarga() * jumlahMinuman;
        hargaPesanan.add(hargaMinuman);
        int hargaToping = menuToping.get(noToping).getHarga() * jumlahToping;
        hargaPesanan.add(hargaToping);
        for (int i = 0; i < hargaPesanan.size(); i++) {
            System.out.println(hargaMinuman);
            System.out.println(hargaToping);
            totalHargaSemua += hargaMinuman + hargaToping;
            
        }

        uang = Integer.parseInt(JOptionPane.showInputDialog("Total harga: Rp" + totalHargaSemua + "\nMasukkan jumlah uang:"));

        if (uang >= totalHargaSemua) {
            int kembalian = uang - totalHargaSemua;
            JOptionPane.showMessageDialog(null, "Pembayaran berhasil.\nKembalian: Rp" + kembalian);
        } else {
            JOptionPane.showMessageDialog(null, "Jumlah uang tidak mencukupi.");
        }
    }


    public static void main(String[] args) {
        Kasir kasir = new Kasir();
        kasir.tanya();
        kasir.bayar();
    }
}