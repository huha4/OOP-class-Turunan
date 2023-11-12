/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uas_pbo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author Bambang Sumadi
 */
public class inputSkripsi extends javax.swing.JFrame {

    public void peringatan(String pesan) {
        JOptionPane.showMessageDialog(rootPane, pesan);
    }
    ArrayList<Skripsi> inputSkripsi;

    private void kosongkan_form() {
        isiISBN.setEditable(true);
        isiISBN.setText(null);
        isiJudul.setText(null);
        isiPengarang.setText(null);
        isiPenerbit.setText(null);
        isiTahun.setText(null);
        isiJumlah.setText(null);
        isiJumlahSkripsi.setText(null);
        isiSub.setText(null);
    }

    private int masukkanData(Connection conn, String idSkripsi, String judulSkripsi, String pengarang, String penerbit, String tahunTerbit, String jumlahHalaman, String jumlahSkripsi, String subJudul) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("INSERT INTO skripsi (id_skripsi, judul_buku, judul_skripsi, pengarang, penerbit, tahun_terbit, jumlah_halaman, jumlah_skripsi, sub_judul) VALUES(?,?,?,?,?,?,?,?)");
        pst.setString(1, idSkripsi);
        pst.setString(2, judulSkripsi);
        pst.setString(3, pengarang);
        pst.setString(4, penerbit);
        pst.setString(5, tahunTerbit);
        pst.setString(6, jumlahHalaman);
        pst.setString(7, jumlahSkripsi);
        pst.setString(8, subJudul);
        return pst.executeUpdate();
    }

    private int updateData(Connection conn, String idSkripsi, String judulSkripsi, String pengarang, String penerbit, String tahunTerbit, String jumlahHalaman, String jumlahSkripsi, String subJudul) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("update skripsi set id_skripsi = ? , judul_skripsi = ?, pengarang = ?, penerbit = ?, tahun_terbit = ?, jumlah_halaman = ?, jumlah_skripsi = ?, sub_judul = ? where id_skripsi = ?");
        pst.setString(1, idSkripsi);
        pst.setString(2, judulSkripsi);
        pst.setString(3, pengarang);
        pst.setString(4, penerbit);
        pst.setString(5, tahunTerbit);
        pst.setString(6, jumlahHalaman);
        pst.setString(7, jumlahSkripsi);
        pst.setString(8, subJudul);
        return pst.executeUpdate();
    }

    private int deleteData(Connection conn, String idSkripsi) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("delete from skripsi where id_skripsi = ?");
        pst.setString(1, idSkripsi);
        return pst.executeUpdate();
    }

    private void Tampilan(Connection conn) {
        inputSkripsi.clear();
        try {
            String sql = "select * from skripsi";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Skripsi data = new Skripsi();
                data.setIdSkripsi(String.valueOf(rs.getObject(1)));
                data.setJudulSkripsi(String.valueOf(rs.getObject(2)));
                data.setPengarang(String.valueOf(rs.getObject(3)));
                data.setPenerbit(String.valueOf(rs.getObject(4)));
                data.setTahunTerbit(String.valueOf(rs.getObject(5)));
                data.setJumlahHalaman(String.valueOf(rs.getObject(6)));
                data.setJumlahSkripsi(String.valueOf(rs.getObject(7)));
                data.setSubJudul(String.valueOf(rs.getObject(8)));
                inputSkripsi.add(data);
            }

        } catch (SQLException ex) {
            Logger.getLogger(inputSkripsi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        profile2 = new javax.swing.JButton();
        need1 = new javax.swing.JButton();
        need2 = new javax.swing.JButton();
        help2 = new javax.swing.JButton();
        logout2 = new javax.swing.JButton();
        home2 = new javax.swing.JButton();
        isiISBN = new javax.swing.JTextField();
        isiJudul = new javax.swing.JTextField();
        isiPengarang = new javax.swing.JTextField();
        isiPenerbit = new javax.swing.JTextField();
        isiSub = new javax.swing.JTextField();
        isiTahun = new javax.swing.JTextField();
        isiJumlah = new javax.swing.JTextField();
        isiJumlahSkripsi = new javax.swing.JTextField();
        save = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        input = new javax.swing.JButton();
        print = new javax.swing.JButton();

        jTextField2.setBackground(new java.awt.Color(30, 55, 123));
        jTextField2.setFont(new java.awt.Font("Helvetica", 1, 12)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setText("jTextField1");
        jTextField2.setBorder(null);

        jTextField3.setBackground(new java.awt.Color(30, 55, 123));
        jTextField3.setFont(new java.awt.Font("Helvetica", 1, 12)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(255, 255, 255));
        jTextField3.setBorder(null);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jTextField12.setBackground(new java.awt.Color(30, 55, 123));
        jTextField12.setFont(new java.awt.Font("Helvetica", 1, 12)); // NOI18N
        jTextField12.setForeground(new java.awt.Color(255, 255, 255));
        jTextField12.setBorder(null);
        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(560, 586));

        jPanel1.setBackground(new java.awt.Color(0, 8, 29));

        jPanel7.setBackground(new java.awt.Color(0, 8, 29));

        jLabel14.setFont(new java.awt.Font("Bebas", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("university");
        jLabel14.setToolTipText("");

        jLabel15.setFont(new java.awt.Font("Bebas", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Bibliography");

        jLabel17.setFont(new java.awt.Font("Bebas", 0, 36)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Skripsi");

        jLabel19.setFont(new java.awt.Font("Helvetica", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("ISBN");

        jLabel20.setFont(new java.awt.Font("Helvetica", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Judul");

        jLabel21.setFont(new java.awt.Font("Helvetica", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Pengarang");

        jLabel22.setFont(new java.awt.Font("Helvetica", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Penerbit");

        jLabel23.setFont(new java.awt.Font("Helvetica", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Tahun terbit");

        jLabel24.setFont(new java.awt.Font("Helvetica", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Jumlah halaman");

        jLabel25.setFont(new java.awt.Font("Helvetica", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Jumlah ");

        jLabel2.setFont(new java.awt.Font("Helvetica", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText(":");

        jLabel4.setFont(new java.awt.Font("Helvetica", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText(":");

        jLabel5.setFont(new java.awt.Font("Helvetica", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText(":");

        jLabel6.setFont(new java.awt.Font("Helvetica", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText(":");

        jLabel7.setFont(new java.awt.Font("Helvetica", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText(":");

        jLabel9.setFont(new java.awt.Font("Helvetica", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText(":");

        jLabel10.setFont(new java.awt.Font("Helvetica", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText(":");

        jLabel26.setFont(new java.awt.Font("Helvetica", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Sub judul");

        jLabel11.setFont(new java.awt.Font("Helvetica", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText(":");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(jLabel22)
                            .addComponent(jLabel24)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21)
                            .addComponent(jLabel23)
                            .addComponent(jLabel25))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel7))
                .addGap(12, 12, 12)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel10))
                .addContainerGap(504, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(0, 8, 29));

        profile2.setBackground(new java.awt.Color(0, 8, 29));
        profile2.setFont(new java.awt.Font("Helvetica", 1, 12)); // NOI18N
        profile2.setForeground(new java.awt.Color(255, 255, 255));
        profile2.setText("Profile");
        profile2.setBorder(null);
        profile2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profile2ActionPerformed(evt);
            }
        });

        need1.setBackground(new java.awt.Color(0, 8, 29));
        need1.setFont(new java.awt.Font("Helvetica", 1, 12)); // NOI18N
        need1.setForeground(new java.awt.Color(255, 255, 255));
        need1.setText("Skripsi");
        need1.setBorder(null);
        need1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                need1ActionPerformed(evt);
            }
        });

        need2.setBackground(new java.awt.Color(0, 8, 29));
        need2.setFont(new java.awt.Font("Helvetica", 1, 12)); // NOI18N
        need2.setForeground(new java.awt.Color(255, 255, 255));
        need2.setText("Buku");
        need2.setBorder(null);
        need2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                need2ActionPerformed(evt);
            }
        });

        help2.setBackground(new java.awt.Color(0, 8, 29));
        help2.setFont(new java.awt.Font("Helvetica", 1, 12)); // NOI18N
        help2.setForeground(new java.awt.Color(255, 255, 255));
        help2.setText("Help");
        help2.setBorder(null);
        help2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                help2ActionPerformed(evt);
            }
        });

        logout2.setBackground(new java.awt.Color(0, 8, 29));
        logout2.setFont(new java.awt.Font("Helvetica", 1, 12)); // NOI18N
        logout2.setForeground(new java.awt.Color(255, 255, 255));
        logout2.setText("Logout");
        logout2.setBorder(null);
        logout2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout2ActionPerformed(evt);
            }
        });

        home2.setBackground(new java.awt.Color(0, 8, 29));
        home2.setFont(new java.awt.Font("Helvetica", 1, 12)); // NOI18N
        home2.setForeground(new java.awt.Color(255, 255, 255));
        home2.setText("Home");
        home2.setBorder(null);
        home2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                home2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(home2)
                        .addGap(36, 36, 36)
                        .addComponent(profile2)
                        .addGap(35, 35, 35)
                        .addComponent(need1)
                        .addGap(31, 31, 31)
                        .addComponent(need2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(help2)
                        .addGap(32, 32, 32)
                        .addComponent(logout2)))
                .addGap(31, 31, 31))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(home2)
                    .addComponent(profile2)
                    .addComponent(need2)
                    .addComponent(help2)
                    .addComponent(logout2)
                    .addComponent(need1))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        isiISBN.setBackground(new java.awt.Color(2, 21, 70));
        isiISBN.setFont(new java.awt.Font("Helvetica", 1, 12)); // NOI18N
        isiISBN.setForeground(new java.awt.Color(255, 255, 255));
        isiISBN.setBorder(null);
        isiISBN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isiISBNActionPerformed(evt);
            }
        });

        isiJudul.setBackground(new java.awt.Color(2, 21, 70));
        isiJudul.setFont(new java.awt.Font("Helvetica", 1, 12)); // NOI18N
        isiJudul.setForeground(new java.awt.Color(255, 255, 255));
        isiJudul.setBorder(null);
        isiJudul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isiJudulActionPerformed(evt);
            }
        });

        isiPengarang.setBackground(new java.awt.Color(2, 21, 70));
        isiPengarang.setFont(new java.awt.Font("Helvetica", 1, 12)); // NOI18N
        isiPengarang.setForeground(new java.awt.Color(255, 255, 255));
        isiPengarang.setBorder(null);
        isiPengarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isiPengarangActionPerformed(evt);
            }
        });

        isiPenerbit.setBackground(new java.awt.Color(2, 21, 70));
        isiPenerbit.setFont(new java.awt.Font("Helvetica", 1, 12)); // NOI18N
        isiPenerbit.setForeground(new java.awt.Color(255, 255, 255));
        isiPenerbit.setBorder(null);
        isiPenerbit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isiPenerbitActionPerformed(evt);
            }
        });

        isiSub.setBackground(new java.awt.Color(2, 21, 70));
        isiSub.setFont(new java.awt.Font("Helvetica", 1, 12)); // NOI18N
        isiSub.setForeground(new java.awt.Color(255, 255, 255));
        isiSub.setBorder(null);
        isiSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isiSubActionPerformed(evt);
            }
        });

        isiTahun.setBackground(new java.awt.Color(2, 21, 70));
        isiTahun.setFont(new java.awt.Font("Helvetica", 1, 12)); // NOI18N
        isiTahun.setForeground(new java.awt.Color(255, 255, 255));
        isiTahun.setBorder(null);
        isiTahun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isiTahunActionPerformed(evt);
            }
        });

        isiJumlah.setBackground(new java.awt.Color(2, 21, 70));
        isiJumlah.setFont(new java.awt.Font("Helvetica", 1, 12)); // NOI18N
        isiJumlah.setForeground(new java.awt.Color(255, 255, 255));
        isiJumlah.setBorder(null);
        isiJumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isiJumlahActionPerformed(evt);
            }
        });

        isiJumlahSkripsi.setBackground(new java.awt.Color(2, 21, 70));
        isiJumlahSkripsi.setFont(new java.awt.Font("Helvetica", 1, 12)); // NOI18N
        isiJumlahSkripsi.setForeground(new java.awt.Color(255, 255, 255));
        isiJumlahSkripsi.setBorder(null);
        isiJumlahSkripsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isiJumlahSkripsiActionPerformed(evt);
            }
        });

        save.setBackground(new java.awt.Color(0, 70, 251));
        save.setFont(new java.awt.Font("Helvetica", 1, 12)); // NOI18N
        save.setForeground(new java.awt.Color(255, 255, 255));
        save.setText("Save");
        save.setBorder(null);
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        update.setBackground(new java.awt.Color(0, 70, 251));
        update.setFont(new java.awt.Font("Helvetica", 1, 12)); // NOI18N
        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setText("Update");
        update.setBorder(null);
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(0, 70, 251));
        delete.setFont(new java.awt.Font("Helvetica", 1, 12)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setText("Delete");
        delete.setBorder(null);
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        input.setBackground(new java.awt.Color(0, 70, 251));
        input.setFont(new java.awt.Font("Helvetica", 1, 12)); // NOI18N
        input.setForeground(new java.awt.Color(255, 255, 255));
        input.setText("Input");
        input.setBorder(null);
        input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputActionPerformed(evt);
            }
        });

        print.setBackground(new java.awt.Color(0, 70, 251));
        print.setFont(new java.awt.Font("Helvetica", 1, 12)); // NOI18N
        print.setForeground(new java.awt.Color(255, 255, 255));
        print.setText("Print");
        print.setBorder(null);
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(isiSub, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(isiJumlahSkripsi, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(isiJumlah, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(isiTahun, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(isiPenerbit, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(isiPengarang, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(isiJudul, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(isiISBN, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 634, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(91, 91, 91))
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(isiISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(isiJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(isiPengarang, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(isiPenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(isiTahun, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(isiJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(isiJumlahSkripsi, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(isiSub, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 680, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void need1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_need1ActionPerformed
        new inputSkripsi().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_need1ActionPerformed

    private void isiISBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isiISBNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isiISBNActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void isiJudulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isiJudulActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isiJudulActionPerformed

    private void isiPengarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isiPengarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isiPengarangActionPerformed

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12ActionPerformed

    private void isiPenerbitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isiPenerbitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isiPenerbitActionPerformed

    private void isiSubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isiSubActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isiSubActionPerformed

    private void isiTahunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isiTahunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isiTahunActionPerformed

    private void isiJumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isiJumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isiJumlahActionPerformed

    private void isiJumlahSkripsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isiJumlahSkripsiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isiJumlahSkripsiActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        String idSkripsi = isiISBN.getText();
        String judulSkripsi = isiJudul.getText();
        String pengarang = isiPengarang.getText();
        String penerbit = isiPenerbit.getText();
        String tahunTerbit = isiTahun.getText();
        String jumlahHalaman = isiJumlah.getText();
        String jumlahSkripsi = isiJumlahSkripsi.getText();
        String subJudul = isiSub.getText();
        if (!idSkripsi.isEmpty() && !judulSkripsi.isEmpty() && !pengarang.isEmpty() && !penerbit.isEmpty() && !tahunTerbit.isEmpty() && !jumlahHalaman.isEmpty() && !jumlahSkripsi.isEmpty() && !subJudul.isEmpty()) {
            EntityManager entityManager = Persistence.createEntityManagerFactory("uas_pbo").createEntityManager();
            entityManager.getTransaction().begin();
            Skripsi s = new Skripsi();
            s.setIdSkripsi(idSkripsi);
            s.setJudulSkripsi(judulSkripsi);
            s.setPengarang(pengarang);
            s.setPenerbit(penerbit);
            s.setTahunTerbit(tahunTerbit);
            s.setJumlahHalaman(jumlahHalaman);
            s.setJumlahSkripsi(jumlahSkripsi);
            s.setSubJudul(subJudul);
            entityManager.persist(s);
            entityManager.getTransaction().commit();
            isiISBN.setText("");
            isiJudul.setText("");
            isiPengarang.setText("");
            isiPenerbit.setText("");
            isiTahun.setText("");
            isiJumlah.setText("");
            isiJumlahSkripsi.setText("");
            isiSub.setText("");

        }
        boolean berhasil = true;
        if (berhasil) {
            System.out.println("Saved successful");
        } else {
            System.out.println("Failed to save");
        }
    }//GEN-LAST:event_saveActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        String idSkripsi = isiISBN.getText();
        String judulSkripsi = isiJudul.getText();
        String pengarang = isiPengarang.getText();
        String penerbit = isiPenerbit.getText();
        String tahunTerbit = isiTahun.getText();
        String jumlahHalaman = isiJumlah.getText();
        String jumlahSkripsi = isiJumlahSkripsi.getText();
        String subJudul = isiSub.getText();
        if (!idSkripsi.isEmpty() && !judulSkripsi.isEmpty() && !pengarang.isEmpty() && !penerbit.isEmpty() && !tahunTerbit.isEmpty() && !jumlahHalaman.isEmpty() && !jumlahSkripsi.isEmpty() && !subJudul.isEmpty()) {
            EntityManager entityManager = Persistence.createEntityManagerFactory("uas_pbo").createEntityManager();
            entityManager.getTransaction().begin();
            Skripsi s = new Skripsi();
            s.setIdSkripsi(idSkripsi);
            s.setJudulSkripsi(judulSkripsi);
            s.setPengarang(pengarang);
            s.setPenerbit(penerbit);
            s.setTahunTerbit(tahunTerbit);
            s.setJumlahHalaman(jumlahHalaman);
            s.setJumlahSkripsi(jumlahSkripsi);
            s.setSubJudul(subJudul);
            entityManager.persist(s);
            entityManager.getTransaction().commit();
            isiISBN.setText("");
            isiJudul.setText("");
            isiPengarang.setText("");
            isiPenerbit.setText("");
            isiTahun.setText("");
            isiJumlah.setText("");
            isiJumlahSkripsi.setText("");
            isiSub.setText("");

        }
        boolean berhasil = true;
        if (berhasil) {
            System.out.println("Update successful");
        } else {
            System.out.println("Failed to update");
        }
    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        String idSkripsi = (isiISBN.getText().trim());
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("uas_pbo");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Skripsi s = em.find(Skripsi.class, idSkripsi);
        em.remove(s);
        em.getTransaction().commit();
        isiISBN.setText("");
        kosongkan_form();
        boolean berhasil = true;
        if (berhasil) {
            System.out.println("Delete successful");
        } else {
            System.out.println("Failed to delete");
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputActionPerformed
        JFileChooser filechooser = new JFileChooser();
        int i = filechooser.showOpenDialog(null);
        if (i == JFileChooser.APPROVE_OPTION) {
            EntityManager entityManager = Persistence.createEntityManagerFactory("uas_pbo").createEntityManager();
            entityManager.getTransaction().begin();
            File f = filechooser.getSelectedFile();
            String filepath = f.getPath();
            //Parsing CSV Data
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filepath));
                org.apache.commons.csv.CSVParser csvParser = CSVFormat.DEFAULT.parse(inputStreamReader);
                for (CSVRecord csvRecord : csvParser) {
                    Skripsi s = new Skripsi();
                    s.setIdSkripsi(csvRecord.get(0));
                    s.setJudulSkripsi(csvRecord.get(1));
                    s.setPengarang(csvRecord.get(2));
                    s.setPenerbit(csvRecord.get(3));
                    s.setTahunTerbit(csvRecord.get(4));
                    s.setJumlahHalaman(csvRecord.get(5));
                    s.setJumlahSkripsi(csvRecord.get(6));
                    s.setSubJudul(csvRecord.get(7));
                    entityManager.persist(s);
                }
            } catch (IOException ex) {
                System.out.println("Error in Parsing CSV File");
            }
            entityManager.getTransaction().commit();
        }
    }//GEN-LAST:event_inputActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        try {
            EntityManager entityManager = Persistence.createEntityManagerFactory("uas_pbo").createEntityManager();
            entityManager.getTransaction().begin();
            TypedQuery<Skripsi> querySelectAll = entityManager.createNamedQuery("Skripsi.findAll", Skripsi.class);
            List<Skripsi> results = querySelectAll.getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();

            String jrxmlFile = "src/UtsPbo/Cetakk.jrxml";
            JasperReport jr = JasperCompileManager.compileReport(jrxmlFile);
//            JasperPrint jp = JasperFillManager.fillReport(jr, null, conn);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, new JRBeanCollectionDataSource(results));
            JasperViewer.viewReport(jp, false);
        } catch (JRException ex) {
            Logger.getLogger(inputSkripsi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            Logger.getLogger(inputSkripsi.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_printActionPerformed

    private void logout2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout2ActionPerformed

        // Memanggil metode logoutUser dan menangani hasilnya
        boolean logoutSuccessful = logoutUser();

        if (logoutSuccessful) {
            System.out.println("You made it out");
        } else {
            System.out.println("logout failed");
        }
    }

    private static boolean logoutUser() {
        // Logika logout user
        // Isi dengan kode yang sesuai, seperti membersihkan sesi, menghapus token akses, dll.
        // Contoh:
        // session.clear();
        // accessToken.delete();
        // Mengembalikan status logout berhasil atau gagal
        return true; // Ganti dengan false jika logout gagal

    }//GEN-LAST:event_logout2ActionPerformed

    private void home2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_home2ActionPerformed
        new dashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_home2ActionPerformed

    private void profile2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profile2ActionPerformed
        new profile().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_profile2ActionPerformed

    private void need2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_need2ActionPerformed
        new inputBuku().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_need2ActionPerformed

    private void help2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_help2ActionPerformed
        new help().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_help2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(inputSkripsi.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(inputSkripsi.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(inputSkripsi.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inputSkripsi.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new inputSkripsi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton delete;
    private javax.swing.JButton help2;
    private javax.swing.JButton home2;
    private javax.swing.JButton input;
    private javax.swing.JTextField isiISBN;
    private javax.swing.JTextField isiJudul;
    private javax.swing.JTextField isiJumlah;
    private javax.swing.JTextField isiJumlahSkripsi;
    private javax.swing.JTextField isiPenerbit;
    private javax.swing.JTextField isiPengarang;
    private javax.swing.JTextField isiSub;
    private javax.swing.JTextField isiTahun;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JButton logout2;
    private javax.swing.JButton need1;
    private javax.swing.JButton need2;
    private javax.swing.JButton print;
    private javax.swing.JButton profile2;
    private javax.swing.JButton save;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
