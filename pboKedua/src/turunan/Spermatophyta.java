/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package turunan;

/**
 *
 * @author Bambang Sumadi
 */
public class Spermatophyta extends tumbuhan {

    /**
     * @param warna the warna to set
     */
    public void setWarna(String warna) {
        this.warna = warna;
    }

    /**
     * @param jumlahDaun the jumlahDaun to set
     */
    public void setJumlahDaun(int jumlahDaun) {
        this.jumlahDaun = jumlahDaun;
    }

    /**
     * @return the warna
     */
    public String getWarna() {
        return warna;
    }

    /**
     * @return the jumlahDaun
     */
    public int getJumlahDaun() {
        return jumlahDaun;
    }

 
    public Spermatophyta (String warna, int jumlahDaun){
        this.warna = warna;
        this.jumlahDaun = jumlahDaun;
    } 

    private String warna;
    private int jumlahDaun;

}
