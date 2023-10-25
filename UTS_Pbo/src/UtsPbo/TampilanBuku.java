/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UtsPbo;

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class TampilanBuku extends javax.swing.JPanel {

    private Component rootPane;

    public void peringatan(String pesan) {
        JOptionPane.showMessageDialog(rootPane, pesan);
    }
    ArrayList<Buku> TampilanBuku;

    private int masukkanData(Connection conn, String isbn, String judulBuku, String tahunTerbit, String penerbit) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("INSERT INTO buku (ISBN, judul_buku, tahun_terbit, penerbit) VALUES(?,?,?,?)");
        pst.setString(1, isbn);
        pst.setString(2, judulBuku);
        pst.setString(3, tahunTerbit);
        pst.setString(4, penerbit);
        return pst.executeUpdate();
    }

    private int updateData(Connection conn, String isbn, String judulBuku, String tahunTerbit, String penerbit) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("update buku set judul_buku = ? , tahun_terbit = ?, penerbit = ? where ISBN = ?");
        pst.setString(1, judulBuku);
        pst.setString(2, tahunTerbit);
        pst.setString(3, penerbit);
        pst.setString(4, isbn);
        return pst.executeUpdate();
    }

    private int deleteData(Connection conn, String isbn) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("delete from buku where ISBN = ?");
        pst.setString(1, isbn);
        return pst.executeUpdate();
    }

    private void Tampilan(Connection conn) {
        TampilanBuku.clear();
        try {
            String sql = "select * from buku";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Buku data = new Buku();
                data.setIsbn(String.valueOf(rs.getObject(1)));
                data.setJudulBuku(String.valueOf(rs.getObject(2)));
                data.setTahunTerbit(String.valueOf(rs.getObject(3)));
                data.setPenerbit(String.valueOf(rs.getObject(4)));
                TampilanBuku.add(data);
            }
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();
            model.setRowCount(0);
            for (Buku data : TampilanBuku) {

                Object[] baris = new Object[4];
                baris[0] = data.getIsbn();
                baris[1] = data.getJudulBuku();
                baris[2] = data.getTahunTerbit();
                baris[3] = data.getPenerbit();

                model.addRow(baris);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TampilanBuku.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public TampilanBuku() {
        try {
            TampilanBuku = new ArrayList<>();
            initComponents();
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/UTS_Pbo", "postgres", "5432");
            Tampilan(conn);
        } catch (SQLException ex) {
            Logger.getLogger(TampilanBuku.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        isiIsbn = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        isiJudul = new javax.swing.JTextField();
        isiTahun = new javax.swing.JTextField();
        isiPenerbit = new javax.swing.JTextField();
        jButtonSimpan = new javax.swing.JButton();
        jButtonPerbarui = new javax.swing.JButton();
        jButtonHapus = new javax.swing.JButton();
        jButtonCetak = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(157, 197, 123));

        jLabel1.setFont(new java.awt.Font("Helvetica", 1, 24)); // NOI18N
        jLabel1.setText("Inventaris Buku");

        jLabel2.setFont(new java.awt.Font("Helvetica", 1, 24)); // NOI18N
        jLabel2.setText("Perpustakaan Kota");

        isiIsbn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isiIsbnActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        jLabel3.setText("ISBN");

        jLabel4.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        jLabel4.setText("Judul buku");

        jLabel5.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        jLabel5.setText("Tahun terbit");

        jLabel6.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        jLabel6.setText("Penerbit");

        isiJudul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isiJudulActionPerformed(evt);
            }
        });

        isiTahun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isiTahunActionPerformed(evt);
            }
        });

        isiPenerbit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isiPenerbitActionPerformed(evt);
            }
        });

        jButtonSimpan.setBackground(new java.awt.Color(34, 111, 49));
        jButtonSimpan.setFont(new java.awt.Font("Helvetica", 1, 12)); // NOI18N
        jButtonSimpan.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSimpan.setText("Simpan");
        jButtonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSimpanActionPerformed(evt);
            }
        });

        jButtonPerbarui.setBackground(new java.awt.Color(34, 111, 49));
        jButtonPerbarui.setFont(new java.awt.Font("Helvetica", 1, 12)); // NOI18N
        jButtonPerbarui.setForeground(new java.awt.Color(255, 255, 255));
        jButtonPerbarui.setText("Perbarui");
        jButtonPerbarui.setToolTipText("");
        jButtonPerbarui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPerbaruiActionPerformed(evt);
            }
        });

        jButtonHapus.setBackground(new java.awt.Color(34, 111, 49));
        jButtonHapus.setFont(new java.awt.Font("Helvetica", 1, 12)); // NOI18N
        jButtonHapus.setForeground(new java.awt.Color(255, 255, 255));
        jButtonHapus.setText("Hapus");
        jButtonHapus.setToolTipText("");
        jButtonHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHapusActionPerformed(evt);
            }
        });

        jButtonCetak.setBackground(new java.awt.Color(34, 111, 49));
        jButtonCetak.setFont(new java.awt.Font("Helvetica", 1, 12)); // NOI18N
        jButtonCetak.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCetak.setText("Cetak");
        jButtonCetak.setToolTipText("");
        jButtonCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCetakActionPerformed(evt);
            }
        });

        jTable.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ISBN", "Judul buku", "Tahun terbit", "Penerbit"
            }
        ));
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked1(evt);
            }
        });
        jScrollPane2.setViewportView(jTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(253, 253, 253)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4))
                                        .addGap(26, 26, 26)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(isiIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(isiJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(isiPenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(isiTahun, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButtonPerbarui, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonSimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonCetak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(isiIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(isiJudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(isiTahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(isiPenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonPerbarui, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void isiIsbnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isiIsbnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isiIsbnActionPerformed

    private void isiJudulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isiJudulActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isiJudulActionPerformed

    private void isiTahunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isiTahunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isiTahunActionPerformed

    private void isiPenerbitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isiPenerbitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isiPenerbitActionPerformed

    private void jButtonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSimpanActionPerformed
        // TODO add your handling code here:
        String isbn = isiIsbn.getText();
        String judulBuku = isiJudul.getText();
        String tahunTerbit = isiTahun.getText();
        String penerbit = isiPenerbit.getText();
        if (!isbn.isEmpty() && !judulBuku.isEmpty() && !tahunTerbit.isEmpty() && !penerbit.isEmpty()) {
            try {
                // TODO add your handling code here:
                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/UTS_Pbo", "postgres", "5432");
                int k = masukkanData(conn, isbn, judulBuku, tahunTerbit, penerbit);
                if (k > 0) {
                    Tampilan(conn);
                    this.peringatan("BERHASIL MENYIMPAN");
                } else {
                    this.peringatan("GAGAL MENYIMPAN");
                }
            } catch (SQLException ex) {
                Logger.getLogger(TampilanBuku.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            this.peringatan("INPUT DATA ANDA GAGAL");
        }
        isiIsbn.setText("");
        isiJudul.setText("");
        isiTahun.setText("");
        isiPenerbit.setText("");
    }//GEN-LAST:event_jButtonSimpanActionPerformed

    private void jButtonPerbaruiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPerbaruiActionPerformed
        // TODO add your handling code here:
        String isbn = isiIsbn.getText();
        String judulBuku = isiJudul.getText();
        String tahunTerbit = isiTahun.getText();
        String penerbit = isiPenerbit.getText();
        if (!isbn.isEmpty() && !judulBuku.isEmpty() && !tahunTerbit.isEmpty() && !penerbit.isEmpty()) {
            try {
                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/UTS_Pbo", "postgres", "5432");
                int k = updateData(conn, isbn, judulBuku, tahunTerbit, penerbit);
                if (k > 0) {
                    Tampilan(conn);
                    this.peringatan("BERHASIL MEMPERBARUI");
                } else {
                    this.peringatan("GAGAL MEMPERBARUI");
                }
            } catch (SQLException ex) {
                Logger.getLogger(TampilanBuku.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            this.peringatan("INPUT DATA ANDA GAGAL");
        }
        isiIsbn.setText("");
        isiJudul.setText("");
        isiTahun.setText("");
        isiPenerbit.setText("");
    }//GEN-LAST:event_jButtonPerbaruiActionPerformed

    private void jButtonHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHapusActionPerformed
        // TODO add your handling code here:
        String isbn = (isiIsbn.getText().trim());
        if (!isbn.isEmpty()) {
            try {
                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/UTS_Pbo", "postgres", "5432");
                int k = deleteData(conn, isbn);
                if (k > 0) {
                    Tampilan(conn);
                    this.peringatan("BERHASIL MENGHAPUS");
                } else {
                    this.peringatan("GAGAL MENGHAPUS");
                }
            } catch (SQLException ex) {
                Logger.getLogger(TampilanBuku.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            this.peringatan("DATA ANDA GAGAL DI HAPUS");
        }
        isiIsbn.setText("");
    }//GEN-LAST:event_jButtonHapusActionPerformed

    private void jButtonCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCetakActionPerformed
        // TODO add your handling code here:
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/UTS_Pbo", "postgres", "5432");
            //File jasperFile = new File("src/Pbokelima/Mahasiswa.jasper");
            //JasperPrint jp = JasperFillManager.fillReport(jasperFile.getPath(), null, conn);
            String jrxmlFile = new String("src/UtsPbo/Cetak.jrxml");
            JasperReport jr = JasperCompileManager.compileReport(jrxmlFile);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, conn);
            JasperViewer.viewReport(jp, false);
        } catch (JRException ex) {
            Logger.getLogger(TampilanBuku.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TampilanBuku.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonCetakActionPerformed


    private void jTableMouseClicked1(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked1
        // TODO add your handling code here:
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/UTS_Pbo", "postgres", "5432");
            int row = jTable.getSelectedRow();
            String tabel_klik = (jTable.getModel().getValueAt(row, 0).toString());
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet sql = stm.executeQuery("SELECT * FROM buku WHERE ISBN='" + tabel_klik + "'");
            if (sql.next()) {
                String isbn = sql.getString("ISBN");
                isiIsbn.setText("" + isbn);
                String judulBuku = sql.getString("judul_buku");
                isiJudul.setText(judulBuku);
                String tahunTerbit = sql.getString("tahun_terbit");
                isiTahun.setText(tahunTerbit);
                String penerbit = sql.getString("penerbit");
                isiPenerbit.setText("penerbit");
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jTableMouseClicked1
    public static void main(String args[]) {
        System.out.println("hello world!");
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
            java.util.logging.Logger.getLogger(TampilanBuku.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TampilanBuku.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TampilanBuku.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TampilanBuku.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TampilanBuku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField isiIsbn;
    private javax.swing.JTextField isiJudul;
    private javax.swing.JTextField isiPenerbit;
    private javax.swing.JTextField isiTahun;
    private javax.swing.JButton jButtonCetak;
    private javax.swing.JButton jButtonHapus;
    private javax.swing.JButton jButtonPerbarui;
    private javax.swing.JButton jButtonSimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}
