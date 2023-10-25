/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pbokelima;

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
//import pbokelima.Mahasiswa;

public class Tampilan extends javax.swing.JFrame {

    public void peringatan(String pesan) {
        JOptionPane.showMessageDialog(rootPane, pesan);
    }
    ArrayList<Mahasiswa> dataMahasiswa;

    private int masukkanData(Connection conn, int nim, String nama, String prodi, int semester) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("INSERT INTO mahasiswa (nim_mahasiswa,nama_mahasiswa,program_studi,semester) VALUES(?,?,?,?)");
        pst.setInt(1, nim);
        pst.setString(2, nama);
        pst.setString(3, prodi);
        pst.setInt(4, semester);
        return pst.executeUpdate();
    }

    private int updateData(Connection conn, int nim, String nama, String prodi, int semester) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("update mahasiswa set nama_mahasiswa = ? ,program_studi = ?,semester = ? where nim_mahasiswa = ?");
        pst.setString(1, nama);
        pst.setString(2, prodi);
        pst.setInt(3, semester);
        pst.setInt(4, nim);
        return pst.executeUpdate();
    }

    private int deleteData(Connection conn, int nim) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("delete from mahasiswa where nim_mahasiswa = ?");
        pst.setInt(1, nim);
        return pst.executeUpdate();
    }

    private void Tampilan(Connection conn) {
        dataMahasiswa.clear();
        try {
            String sql = "select * from mahasiswa";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Mahasiswa data = new Mahasiswa();
                data.setNim(rs.getInt(1));
                data.setNama(String.valueOf(rs.getObject(2)));
                data.setProdi(String.valueOf(rs.getObject(3)));
                data.setSemester(rs.getInt(4));
                dataMahasiswa.add(data);
            }
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();
            model.setRowCount(0);
            for (Mahasiswa data : dataMahasiswa) {

                Object[] baris = new Object[4];
                baris[0] = data.getNim();
                baris[1] = data.getNama();
                baris[2] = data.getProdi();
                baris[3] = data.getSemester();

                model.addRow(baris);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tampilan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Tampilan() {
        try {
            dataMahasiswa = new ArrayList<>();
            initComponents();
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Pbo_keempat_laprak", "postgres", "5432");
            Tampilan(conn);
        } catch (SQLException ex) {
            Logger.getLogger(Tampilan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        IsiNIM = new javax.swing.JTextField();
        IsiNama = new javax.swing.JTextField();
        IsiProdi = new javax.swing.JTextField();
        IsiSemester = new javax.swing.JTextField();
        jButtonSave = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButtonPrint = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        IsiNIM.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        IsiNIM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IsiNIMActionPerformed(evt);
            }
        });

        IsiNama.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        IsiNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IsiNamaActionPerformed(evt);
            }
        });

        IsiProdi.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        IsiProdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IsiProdiActionPerformed(evt);
            }
        });

        IsiSemester.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        IsiSemester.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IsiSemesterActionPerformed(evt);
            }
        });

        jButtonSave.setText("Save");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButtonUpdate.setText("Update");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NIM", "Nama", "Program Studi", "Semester"
            }
        ));
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable);

        jLabel1.setFont(new java.awt.Font("Helvetica", 1, 12)); // NOI18N
        jLabel1.setText("NIM");

        jLabel2.setFont(new java.awt.Font("Helvetica", 1, 12)); // NOI18N
        jLabel2.setText("Nama");

        jLabel3.setFont(new java.awt.Font("Helvetica", 1, 12)); // NOI18N
        jLabel3.setText("Program Studi");

        jLabel4.setFont(new java.awt.Font("Helvetica", 1, 12)); // NOI18N
        jLabel4.setText("Semester");

        jLabel5.setFont(new java.awt.Font("Helvetica", 1, 18)); // NOI18N
        jLabel5.setText("DAFTAR MAHASISWA");

        jButtonPrint.setText("Print");
        jButtonPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonSave)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonPrint)
                                .addGap(6, 6, 6))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel4))
                            .addComponent(jLabel2))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(IsiNIM, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IsiNama, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IsiProdi, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IsiSemester, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(43, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(173, 173, 173))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel5)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IsiNIM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(IsiNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IsiProdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IsiSemester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSave)
                    .addComponent(jButtonUpdate)
                    .addComponent(jButtonDelete)
                    .addComponent(jButtonPrint))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(137, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IsiNIMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IsiNIMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IsiNIMActionPerformed

    private void IsiNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IsiNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IsiNamaActionPerformed

    private void IsiProdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IsiProdiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IsiProdiActionPerformed

    private void IsiSemesterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IsiSemesterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IsiSemesterActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        int nim = Integer.parseInt(IsiNIM.getText().trim());
        String nama = IsiNama.getText();
        String prodi = IsiProdi.getText();
        int semester = Integer.parseInt(IsiSemester.getText());
        if (nim > 0 && !nama.isEmpty() && !prodi.isEmpty() && semester > 0) {
            try {
                // TODO add your handling code here:
                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Pbo_keempat_laprak", "postgres", "5432");
                int k = masukkanData(conn, nim, nama, prodi, semester);
                if (k > 0) {
                    Tampilan(conn);
                    this.peringatan("Simpan Berhasil");
                } else {
                    this.peringatan("Simpan Gagal");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Tampilan.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            this.peringatan("Input Data Mahasiswa Gagal");
        }
        IsiNIM.setText("");
        IsiNama.setText("");
        IsiProdi.setText("");
        IsiSemester.setText("");
    }

    private void tampilan(Connection conn) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        int nim = Integer.parseInt(IsiNIM.getText().trim());
        String nama = IsiNama.getText();
        String prodi = IsiProdi.getText();
        int semester = Integer.parseInt(IsiSemester.getText());
        if (nim > 0 && !nama.isEmpty() && !prodi.isEmpty() && semester > 0) {
            try {
                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Pbo_keempat_laprak", "postgres", "5432");
                int k = updateData(conn, nim, nama, prodi, semester);
                if (k > 0) {
                    Tampilan(conn);
                    this.peringatan("Update Berhasil");
                } else {
                    this.peringatan("Update Gagal");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Tampilan.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            this.peringatan("Input Data Mahasiswa Gagal");
        }
        IsiNIM.setText("");
        IsiNama.setText("");
        IsiProdi.setText("");
        IsiSemester.setText("");
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        int nim = Integer.parseInt(IsiNIM.getText().trim());
        if (nim > 0) {
            try {
                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Pbo_keempat_laprak", "postgres", "5432");
                int k = deleteData(conn, nim);
                if (k > 0) {
                    Tampilan(conn);
                    this.peringatan("Delete Berhasil");
                } else {
                    this.peringatan("Delete Gagal");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Tampilan.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            this.peringatan("Delete Data Mahasiswa Gagal");
        }
        IsiNIM.setText("");
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Pbo_keempat_laprak", "postgres", "5432");
            int row = jTable.getSelectedRow();
            String tabel_klik = (jTable.getModel().getValueAt(row, 0).toString());
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet sql = stm.executeQuery("SELECT * FROM mahasiswa WHERE nim_mahasiswa='" + tabel_klik + "'");
            if (sql.next()) {
                int nim = sql.getInt("nim_mahasiswa");
                IsiNIM.setText("" + nim);
                String nama = sql.getString("nama_mahasiswa");
                IsiNama.setText(nama);
                String prodi = sql.getString("program_studi");
                IsiProdi.setText(prodi);
                int semester = sql.getInt("semester");
                IsiSemester.setText("" + semester);
            }
        } catch (Exception e) {
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTableMouseClicked

    private void jButtonPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrintActionPerformed
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Pbo_keempat_laprak", "postgres", "5432");
            //File jasperFile = new File("src/Pbokelima/Mahasiswa.jasper");
            //JasperPrint jp = JasperFillManager.fillReport(jasperFile.getPath(), null, conn);
            String jrxmlFile = new String("src/pbokelima/DataMahasiswa.jrxml");
            JasperReport jr = JasperCompileManager.compileReport(jrxmlFile);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, conn);
            JasperViewer.viewReport(jp, false);
        } catch (JRException ex) {
            Logger.getLogger(Tampilan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Tampilan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonPrintActionPerformed

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
            java.util.logging.Logger.getLogger(Tampilan.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

} catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tampilan.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

} catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tampilan.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

} catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tampilan.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tampilan().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IsiNIM;
    private javax.swing.JTextField IsiNama;
    private javax.swing.JTextField IsiProdi;
    private javax.swing.JTextField IsiSemester;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonPrint;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
