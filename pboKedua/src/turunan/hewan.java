/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package turunan;

public class hewan extends MakhlukHidup {

    /**
     * @param jumlahKaki the jumlahKaki to set
     */
    public void setJumlahKaki(int jumlahKaki) {
        this.jumlahKaki = jumlahKaki;
    }

    /**
     * @return the jumlahKaki
     */
    public int getJumlahKaki() {
        return jumlahKaki;
    }

    /**
     * @return the alatGerak
     */
    public String getAlatGerak() {
        return alatGerak;
    }

    public hewan() {
        super("paru-paru", "generatif");
    }
    public hewan (String alatGerak, int jumlahKaki) {
        this.alatGerak = alatGerak;
        this.jumlahKaki = jumlahKaki;
    }
            
    private int jumlahKaki;
    private String alatGerak;


}