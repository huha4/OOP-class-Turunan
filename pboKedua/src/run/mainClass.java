/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package run;

import turunan.MakhlukHidup;
import turunan.hewan;
import turunan.tumbuhan;
import turunan.Avertebrata;
import turunan.Spermatophyta;

public class mainClass {

    public static void main(String[] args) {
        // TODO code application logic here
        hewan zebra = new hewan();
        zebra.setNama("zebra");
        zebra.setJumlahKaki(4);
        hewan bebek = new hewan();
        bebek.setNama("bebek");
        bebek.setJumlahKaki(2);
        tumbuhan anggrek = new tumbuhan();
        anggrek.setNama("anggrek");
        anggrek.setHabitat("di darat");
        anggrek.setJenisTumbuhan("anggota jenis terbanyak");
        

        System.out.println("Nama saya " + zebra.getNama() + " , kaki saya " + zebra.getJumlahKaki());
        System.out.println("Nama saya " + bebek.getNama() + " , kaki saya " + bebek.getJumlahKaki());
        System.out.println("Nama saya " + anggrek.getNama() + " , asal saya " + anggrek.getHabitat());

    }
}

