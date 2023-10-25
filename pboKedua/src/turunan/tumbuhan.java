/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package turunan;

public class tumbuhan extends MakhlukHidup {

    /**
     * @param jenisTumbuhan the jenisTumbuhan to set
     */
    public void setJenisTumbuhan(String jenisTumbuhan) {
        this.jenisTumbuhan = jenisTumbuhan;
    }

    /**
     * @param habitat the habitat to set
     */
    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    /**
     * @return the habitat
     */
    public String getHabitat() {
        return habitat;
    }

    /**
     * @return the jenisTumbuhan
     */
    public String getJenisTumbuhan() {
        return jenisTumbuhan;
    }

    public tumbuhan() {
        super("daun", "putik");
    }
    
    public tumbuhan(String habitat, String jenisTumbuhan){
        this.habitat = habitat;
        this.jenisTumbuhan = jenisTumbuhan;
    }
    protected String habitat;
    private String jenisTumbuhan;

}

