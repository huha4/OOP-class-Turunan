/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Run;
import pboketiga.Tumbuhan;
import pboketiga.TumbuhanDikotil;
import pboketiga.TumbuhanMonokotil;

public class MainClass {
    public static void main(String[] args) {
        
        TumbuhanMonokotil kurma = new TumbuhanMonokotil();
        System.out.println("Pohon kurma membutuhkan " + kurma.getMakanan() + " untuk makan");
        System.out.println("Pohon kurma " + kurma.tumbuh("25 meter"));
        System.out.println("Pohon kurma tumbuh di " + kurma.getHabitat());
        System.out.println("____________________________________");
        System.out.println("____________________________________");
        TumbuhanDikotil anggur = new TumbuhanDikotil();
        System.out.println("Pohon anggur membutuhkan " + anggur.getMakanan() + " untuk makan");
        System.out.println("Pohon anggur " + anggur.tumbuh(25.00) + " meter");
        System.out.println("Pohon anggur tumbuh di " + anggur.getHabitat());
        anggur.berbuah();
        anggur.berfotosintesis();
        anggur.manfaat();
        System.out.println("____________________________________");
        System.out.println("____________________________________");
        Tumbuhan tanaman = new Tumbuhan();
        System.out.println("Makanan dari tumbuhan adalah " + tanaman.getMakanan());
        System.out.println("Tumbuhan ini " + tanaman.tumbuh(25) + " meter");
    }
}
