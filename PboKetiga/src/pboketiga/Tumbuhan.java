/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pboketiga;

public class Tumbuhan {

    /**
     * @return the spesies
     */
    public String getSpesies() {
        return spesies;
    }

    /**
     * @param spesies the spesies to set
     */
    public void setSpesies(String spesies) {
        this.spesies = spesies;
    }

    /**
     * @return the habitat
     */
    public String getHabitat() {
        return habitat;
    }

    /**
     * @param habitat the habitat to set
     */
    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    /**
     * @return the berbiji
     */
    public String getBerbiji() {
        return berbiji;
    }

    /**
     * @param berbiji the berbiji to set
     */
    public void setBerbiji(String berbiji) {
        this.berbiji = berbiji;
    }

    /**
     * @return the makanan
     */
    public String getMakanan() {
        return makanan;
    }

    /**
     * @param makanan the makanan to set
     */
    public void setMakanan(String makanan) {
        this.makanan = makanan;
    }
    private String spesies;
    private String habitat = "darat";
    private String berbiji;
    private String makanan = "cahaya matahari";

    public String tumbuh() {
        return "dapat tumbuh sepanjang ";
    }

    public String tumbuh(String meter) {
        return "dapat tumbuh sepanjang " + meter;
    }

    public String tumbuh(int meter) {
        return "dapat tumbuh sepanjang " + String.valueOf(meter);
    }

    public String tumbuh(double meter) {
        return "dapat tumbuh sepanjang " + String.valueOf(meter);
    }

}
