/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package turunan;

public class MakhlukHidup {

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the spesies
     */

    /**
     * @return the alatPernapasan
     */
    public String getAlatPernapasan() {
        return alatPernapasan;
    }

    /**
     * @return the reproduksi
     */
    public String getReproduksi() {
        return reproduksi;
    }


    public MakhlukHidup() {
        this.alatPernapasan = "";
        this.reproduksi =  "";
    }
    
    public MakhlukHidup (String alatPernapasan, String reproduksi){
        this.reproduksi = reproduksi;
        this.alatPernapasan = alatPernapasan;
    }
    private String nama;
    protected String alatPernapasan;
    protected String reproduksi;
   
}