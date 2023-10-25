/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainClass;

import pbofirst.generative;
import pbofirst.subclassWarna;

public class run {
    public static void main(String[] args) {
        generative jeruk = new generative();
        jeruk.setNama("Jeruk Citrus Sinensis");
        jeruk.setJenis("Jeruk manis");
        jeruk.setAlat_reproduksi("benang sari dan putik");
        jeruk.setMakanan("unsur hara");
        jeruk.setHabitat("daerah yang beriklim tropis");
        jeruk.setKembang_biak("generative");
        jeruk.setRasa("manis");
        System.out.println("Buah ini bernama "+jeruk.getNama());
        System.out.println("Termasuk kedalam jenis "+jeruk.getJenis());
        System.out.println("Rasa jeruk ini yaitu "+jeruk.getRasa());
        System.out.println("Bereproduksi dengan "+jeruk.getAlat_reproduksi());
        System.out.println("Sumber makanannya yaitu "+jeruk.getMakanan());
        System.out.println("Jeruk ini dapat tumbuh di "+jeruk.getHabitat());
        System.out.println("Jeruk termasuk kedalam tumbuhan "+jeruk.getKembang_biak());
    }
}
