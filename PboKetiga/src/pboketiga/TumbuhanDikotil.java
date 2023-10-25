/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pboketiga;

public class TumbuhanDikotil extends Tumbuhan implements Buah, Fotosintesis, Kegunaan{
     @Override
    public void berbuah() {
        System.out.println("Saya menghasilkan buah yaitu anggur");
    }
    @Override
    public void berfotosintesis() {
        System.out.println("Saya berfotosintesis dengan daun");
    }
   @Override
    public void manfaat() {
        System.out.println("Saya bisa mempercantik taman rumah");
    }
    public void setMakanan() {
        super.setMakanan("Cahaya matahari dan CO2");
    }
    public TumbuhanDikotil() {
        this.setMakanan();
    }
}
