/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uas_pbo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Bambang Sumadi
 */
@Entity
@Table(name = "peminjaman")
@NamedQueries({
    @NamedQuery(name = "Peminjaman.findAll", query = "SELECT p FROM Peminjaman p"),
    @NamedQuery(name = "Peminjaman.findById", query = "SELECT p FROM Peminjaman p WHERE p.id = :id"),
    @NamedQuery(name = "Peminjaman.findByNama", query = "SELECT p FROM Peminjaman p WHERE p.nama = :nama"),
    @NamedQuery(name = "Peminjaman.findByIdSkripsi", query = "SELECT p FROM Peminjaman p WHERE p.idSkripsi = :idSkripsi"),
    @NamedQuery(name = "Peminjaman.findByJudulSkripsi", query = "SELECT p FROM Peminjaman p WHERE p.judulSkripsi = :judulSkripsi"),
    @NamedQuery(name = "Peminjaman.findByTanggal", query = "SELECT p FROM Peminjaman p WHERE p.tanggal = :tanggal"),
    @NamedQuery(name = "Peminjaman.findByJumlah", query = "SELECT p FROM Peminjaman p WHERE p.jumlah = :jumlah"),
    @NamedQuery(name = "Peminjaman.findByStatus", query = "SELECT p FROM Peminjaman p WHERE p.status = :status")})
public class Peminjaman implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "id")
    private String id;
    @Column(name = "nama")
    private String nama;
    @Id
    @Basic(optional = false)
    @Column(name = "id_skripsi")
    private String idSkripsi;
    @Column(name = "judul_skripsi")
    private String judulSkripsi;
    @Column(name = "tanggal")
    @Temporal(TemporalType.DATE)
    private Date tanggal;
    @Column(name = "jumlah")
    private String jumlah;
    @Column(name = "status")
    private String status;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "peminjaman")
    private Skripsi skripsi;

    public Peminjaman() {
    }

    public Peminjaman(String idSkripsi) {
        this.idSkripsi = idSkripsi;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
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

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Skripsi getSkripsi() {
        return skripsi;
    }

    public void setSkripsi(Skripsi skripsi) {
        this.skripsi = skripsi;
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
        if (!(object instanceof Peminjaman)) {
            return false;
        }
        Peminjaman other = (Peminjaman) object;
        if ((this.idSkripsi == null && other.idSkripsi != null) || (this.idSkripsi != null && !this.idSkripsi.equals(other.idSkripsi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uas_pbo.Peminjaman[ idSkripsi=" + idSkripsi + " ]";
    }
    
}
