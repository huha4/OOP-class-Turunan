/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uas_pbo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Bambang Sumadi
 */
@Entity
@Table(name = "skripsi")
@NamedQueries({
    @NamedQuery(name = "Skripsi.findAll", query = "SELECT s FROM Skripsi s"),
    @NamedQuery(name = "Skripsi.findByIdSkripsi", query = "SELECT s FROM Skripsi s WHERE s.idSkripsi = :idSkripsi"),
    @NamedQuery(name = "Skripsi.findByJudulSkripsi", query = "SELECT s FROM Skripsi s WHERE s.judulSkripsi = :judulSkripsi"),
    @NamedQuery(name = "Skripsi.findByPengarang", query = "SELECT s FROM Skripsi s WHERE s.pengarang = :pengarang"),
    @NamedQuery(name = "Skripsi.findByPenerbit", query = "SELECT s FROM Skripsi s WHERE s.penerbit = :penerbit"),
    @NamedQuery(name = "Skripsi.findByTahunTerbit", query = "SELECT s FROM Skripsi s WHERE s.tahunTerbit = :tahunTerbit"),
    @NamedQuery(name = "Skripsi.findByJumlahHalaman", query = "SELECT s FROM Skripsi s WHERE s.jumlahHalaman = :jumlahHalaman"),
    @NamedQuery(name = "Skripsi.findByJumlahSkripsi", query = "SELECT s FROM Skripsi s WHERE s.jumlahSkripsi = :jumlahSkripsi"),
    @NamedQuery(name = "Skripsi.findBySubJudul", query = "SELECT s FROM Skripsi s WHERE s.subJudul = :subJudul"),
    @NamedQuery(name = "Skripsi.findByKategori", query = "SELECT s FROM Skripsi s WHERE s.kategori = :kategori"),
    @NamedQuery(name = "Skripsi.findByAngkatan", query = "SELECT s FROM Skripsi s WHERE s.angkatan = :angkatan")})
public class Skripsi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_skripsi")
    private String idSkripsi;
    @Column(name = "judul_skripsi")
    private String judulSkripsi;
    @Column(name = "pengarang")
    private String pengarang;
    @Column(name = "penerbit")
    private String penerbit;
    @Column(name = "tahun_terbit")
    private String tahunTerbit;
    @Column(name = "jumlah_halaman")
    private String jumlahHalaman;
    @Column(name = "jumlah_skripsi")
    private String jumlahSkripsi;
    @Column(name = "sub_judul")
    private String subJudul;
    @Column(name = "kategori")
    private String kategori;
    @Column(name = "angkatan")
    private String angkatan;
    @JoinColumn(name = "id_skripsi", referencedColumnName = "id_skripsi", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Peminjaman peminjaman;

    public Skripsi() {
    }

    public Skripsi(String idSkripsi) {
        this.idSkripsi = idSkripsi;
    }

    public String getIdSkripsi() {
        return idSkripsi;
    }

    public void setIdSkripsi(String idSkripsi) {
        this.idSkripsi = idSkripsi;
    }

    public String getJudulSkripsi() {
        return judulSkripsi;
    }

    public void setJudulSkripsi(String judulSkripsi) {
        this.judulSkripsi = judulSkripsi;
    }

    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public String getTahunTerbit() {
        return tahunTerbit;
    }

    public void setTahunTerbit(String tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }

    public String getJumlahHalaman() {
        return jumlahHalaman;
    }

    public void setJumlahHalaman(String jumlahHalaman) {
        this.jumlahHalaman = jumlahHalaman;
    }

    public String getJumlahSkripsi() {
        return jumlahSkripsi;
    }

    public void setJumlahSkripsi(String jumlahSkripsi) {
        this.jumlahSkripsi = jumlahSkripsi;
    }

    public String getSubJudul() {
        return subJudul;
    }

    public void setSubJudul(String subJudul) {
        this.subJudul = subJudul;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getAngkatan() {
        return angkatan;
    }

    public void setAngkatan(String angkatan) {
        this.angkatan = angkatan;
    }

    public Peminjaman getPeminjaman() {
        return peminjaman;
    }

    public void setPeminjaman(Peminjaman peminjaman) {
        this.peminjaman = peminjaman;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSkripsi != null ? idSkripsi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Skripsi)) {
            return false;
        }
        Skripsi other = (Skripsi) object;
        if ((this.idSkripsi == null && other.idSkripsi != null) || (this.idSkripsi != null && !this.idSkripsi.equals(other.idSkripsi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uas_pbo.Skripsi[ idSkripsi=" + idSkripsi + " ]";
    }
    
}
