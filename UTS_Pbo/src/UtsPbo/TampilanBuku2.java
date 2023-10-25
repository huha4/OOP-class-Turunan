/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UtsPbo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
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

public class TampilanBuku2 extends javax.swing.JFrame {

    public void peringatan(String pesan) {
        JOptionPane.showMessageDialog(rootPane, pesan);
    }
    ArrayList<Buku> TampilanBuku;

    private void kosongkan_form() {
        isiISBN.setEditable(true);
        isiISBN.setText(null);
        isiJudul.setText(null);
        isiTahun.setText(null);
        isiPenerbit.setText(null);
    }

    private int masukkanData(Connection conn, String isbn, String judulBuku, String tahunTerbit, String penerbit) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("INSERT INTO buku (isbn, judul_buku, tahun_terbit, penerbit) VALUES(?,?,?,?)");
        pst.setString(1, isbn);
        pst.setString(2, judulBuku);
        pst.setString(3, tahunTerbit);
        pst.setString(4, penerbit);
        return pst.executeUpdate();
    }

    private int updateData(Connection conn, String isbn, String judulBuku, String tahunTerbit, String penerbit) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("update buku set judul_buku = ? , tahun_terbit = ?, penerbit = ? where isbn = ?");
        pst.setString(1, judulBuku);
        pst.setString(2, tahunTerbit);
        pst.setString(3, penerbit);
        pst.setString(4, isbn);
        return pst.executeUpdate();
    }

    private int deleteData(Connection conn, String isbn) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("delete from buku where isbn = ?");
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
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
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

    public TampilanBuku2() {
        try {
            TampilanBuku = new ArrayList<>();
            initComponents();
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/UTS_Pbo", "postgres", "5432");
            Tampilan(conn);

            // Membuat dan mengatur timer untuk auto-refresh setiap 5 detik (5000 milidetik)
            Timer refreshTimer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Tampilan(conn);
                }
            });
            refreshTimer.start();
        } catch (SQLException ex) {
            Logger.getLogger(TampilanBuku2.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        isiISBN = new javax.swing.JTextField();
        isiJudul = new javax.swing.JTextField();
        isiTahun = new javax.swing.JTextField();
        isiPenerbit = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Simpan = new javax.swing.JButton();
        Perbarui = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        isiInput = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 204, 0));

        jLabel1.setFont(new java.awt.Font("Helvetica", 1, 24)); // NOI18N
        jLabel1.setText("Inventaris Buku");

        jLabel2.setFont(new java.awt.Font("Helvetica", 1, 24)); // NOI18N
        jLabel2.setText("Perpustakaan Kota");

        jLabel3.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        jLabel3.setText("ISBN");

        jLabel4.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        jLabel4.setText("Judul Buku");

        jLabel5.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        jLabel5.setText("Tahun Terbit");

        jLabel6.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        jLabel6.setText("Penerbit");

        isiISBN.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        isiISBN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isiISBNActionPerformed(evt);
            }
        });

        isiJudul.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N

        isiTahun.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N

        isiPenerbit.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        isiPenerbit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isiPenerbitActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ISBN", "Judul Buku", "Tahun Terbit", "Penerbit"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        Simpan.setBackground(new java.awt.Color(24, 81, 7));
        Simpan.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        Simpan.setForeground(new java.awt.Color(255, 255, 255));
        Simpan.setText("Simpan");
        Simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SimpanActionPerformed(evt);
            }
        });

        Perbarui.setBackground(new java.awt.Color(24, 81, 7));
        Perbarui.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        Perbarui.setForeground(new java.awt.Color(255, 255, 255));
        Perbarui.setText("Perbarui");
        Perbarui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PerbaruiActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(24, 81, 7));
        jButton3.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Hapus");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(24, 81, 7));
        jButton4.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Cetak");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        isiInput.setBackground(new java.awt.Color(24, 81, 7));
        isiInput.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        isiInput.setForeground(new java.awt.Color(255, 255, 255));
        isiInput.setText("Input");
        isiInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isiInputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(75, 75, 75)
                                .addComponent(isiISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(isiTahun, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                                    .addComponent(isiJudul)
                                    .addComponent(isiPenerbit)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Simpan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Perbarui, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(isiInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(205, 205, 205)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1))
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(isiISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                            .addComponent(isiJudul, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(isiTahun, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(isiPenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(Simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Perbarui, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(isiInput, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void isiISBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isiISBNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isiISBNActionPerformed

    private void SimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SimpanActionPerformed
        String isbn = isiISBN.getText();
        String judulBuku = isiJudul.getText();
        String tahunTerbit = isiTahun.getText();
        String penerbit = isiPenerbit.getText();
        if (!isbn.isEmpty() && !judulBuku.isEmpty() && !tahunTerbit.isEmpty() && !penerbit.isEmpty()) {
            EntityManager entityManager = Persistence.createEntityManagerFactory("UtsPboPU").createEntityManager();
            entityManager.getTransaction().begin();
            BukuPOJO b = new BukuPOJO();
            b.setIsbn(isbn);
            b.setJudulBuku(judulBuku);
            b.setTahunTerbit(tahunTerbit);
            b.setPenerbit(penerbit);
            entityManager.persist(b);
            entityManager.getTransaction().commit();
            isiISBN.setText("");
            isiJudul.setText("");
            isiTahun.setText("");
            isiPenerbit.setText("");
        }
    }//GEN-LAST:event_SimpanActionPerformed

    private void PerbaruiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PerbaruiActionPerformed
        String isbn = isiISBN.getText();
        String judulBuku = isiJudul.getText();
        String tahunTerbit = isiTahun.getText();
        String penerbit = isiPenerbit.getText();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UtsPboPU");
        EntityManager em = emf.createEntityManager();
        BukuPOJO b = new BukuPOJO();
        b.setIsbn(isbn);
        b.setJudulBuku(judulBuku);
        b.setTahunTerbit(tahunTerbit);
        b.setPenerbit(penerbit);
        em.getTransaction().begin();
        em.merge(b);
        em.getTransaction().commit();
        isiISBN.setText("");
        isiJudul.setText("");
        isiTahun.setText("");
        isiPenerbit.setText("");
    }//GEN-LAST:event_PerbaruiActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String isbn = (isiISBN.getText().trim());
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UtsPboPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        BukuPOJO b = em.find(BukuPOJO.class, isbn);
        em.remove(b);
        em.getTransaction().commit();
        isiISBN.setText("");
        kosongkan_form();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            EntityManager entityManager = Persistence.createEntityManagerFactory("UtsPboPU").createEntityManager();
            entityManager.getTransaction().begin();
            TypedQuery<BukuPOJO> querySelectAll = entityManager.createNamedQuery("BukuPOJO.findAll", BukuPOJO.class);
            List<BukuPOJO> results = querySelectAll.getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();

            String jrxmlFile = "src/UtsPbo/Cetakk.jrxml";
            JasperReport jr = JasperCompileManager.compileReport(jrxmlFile);
//            JasperPrint jp = JasperFillManager.fillReport(jr, null, conn);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, new JRBeanCollectionDataSource(results));
            JasperViewer.viewReport(jp, false);
        } catch (JRException ex) {
            Logger.getLogger(TampilanBuku2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            Logger.getLogger(TampilanBuku2.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void isiPenerbitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isiPenerbitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isiPenerbitActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int baris = jTable1.rowAtPoint(evt.getPoint());
        String ISBN = jTable1.getValueAt(baris, 0).toString();
        isiISBN.setText(ISBN);

        String judulBuku = jTable1.getValueAt(baris, 1).toString();
        isiJudul.setText(judulBuku);

        String tahunTerbit = jTable1.getValueAt(baris, 2).toString();
        isiTahun.setText(tahunTerbit);

        String penerbit = jTable1.getValueAt(baris, 3).toString();
        isiPenerbit.setText(penerbit);
    }//GEN-LAST:event_jTable1MouseClicked

    private void isiInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isiInputActionPerformed
        JFileChooser filechooser = new JFileChooser();

        int i = filechooser.showOpenDialog(null);
        if (i == JFileChooser.APPROVE_OPTION) {

            EntityManager entityManager = Persistence.createEntityManagerFactory("UtsPboPU").createEntityManager();
            entityManager.getTransaction().begin();

            File f = filechooser.getSelectedFile();
            String filepath = f.getPath();
            //Parsing CSV Data

            try {

                InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filepath));
                org.apache.commons.csv.CSVParser csvParser = CSVFormat.DEFAULT.parse(inputStreamReader);
                for (CSVRecord csvRecord : csvParser) {

                    BukuPOJO b = new BukuPOJO();
//            b.setIsbn(isbn);
//            b.setJudulBuku(judulBuku);
//            b.setTahunTerbit(tahunTerbit);
//            b.setPenerbit(penerbit);
                    b.setIsbn(csvRecord.get(0));
                    b.setJudulBuku(csvRecord.get(1));
                    b.setTahunTerbit(csvRecord.get(2));
                    b.setPenerbit(csvRecord.get(3));
                    entityManager.persist(b);
                }

            } catch (IOException ex) {
                System.out.println("Error in Parsing CSV File");
            }

            entityManager.getTransaction().commit();
        }
    }//GEN-LAST:event_isiInputActionPerformed

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
            java.util.logging.Logger.getLogger(TampilanBuku2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TampilanBuku2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TampilanBuku2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TampilanBuku2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TampilanBuku2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Perbarui;
    private javax.swing.JButton Simpan;
    private javax.swing.JTextField isiISBN;
    private javax.swing.JButton isiInput;
    private javax.swing.JTextField isiJudul;
    private javax.swing.JTextField isiPenerbit;
    private javax.swing.JTextField isiTahun;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
