/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package turunan;

public class Avertebrata extends hewan {

    /**
     * @param makanan the makanan to set
     */
    public void setMakanan(String makanan) {
        this.makanan = makanan;
    }


    /**
     * @param jenisHewan the jenisHewan to set
     */
    public void setJenisHewan(String jenisHewan) {
        this.jenisHewan = jenisHewan;
    }

    /**
     * @param spesies the spesies to set
     */
    public void setSpesies(String spesies) {
        this.spesies = spesies;
    }

    /**
     * @return the makanan
     */
    public String getMakanan() {
        return makanan;
    }

    /**
     * @return the jenisHewan
     */
    public String getJenisHewan() {
        return jenisHewan;
    }

    /**
     * @return the spesies
     */
    public String getSpesies() {
        return spesies;
    }

    public Avertebrata (String makanan, String jenisHewan, String spesies){
        this.makanan = makanan;
        this.jenisHewan = jenisHewan;
        this.spesies = spesies;
    }

    
    private String makanan;
    private String jenisHewan;
    private String spesies;
}
