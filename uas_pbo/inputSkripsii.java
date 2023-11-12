/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uas_pbo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
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
public class inputSkripsii extends javax.swing.JFrame {
public void peringatan(String pesan) {
        JOptionPane.showMessageDialog(rootPane, pesan);
    }
    ArrayList<Skripsi> inputSkripsii;

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
        inputSkripsii.clear();
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
                inputSkripsii.add(data);
            }

        } catch (SQLException ex) {
            Logger.getLogger(inputSkripsi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public inputSkripsii() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        profile2 = new javax.swing.JButton();
        need1 = new javax.swing.JButton();
        need2 = new javax.swing.JButton();
        help2 = new javax.swing.JButton();
        logout2 = new javax.swing.JButton();
        home2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
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
        jPanel8 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 8, 29));
        jPanel1.setPreferredSize(new java.awt.Dimension(1300, 680));

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
                .addContainerGap(593, Short.MAX_VALUE)
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

        jPanel2.setBackground(new java.awt.Color(0, 8, 29));

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(isiSub, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(isiJumlahSkripsi, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(isiJumlah, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(isiTahun, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(isiPenerbit, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(isiPengarang, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(isiJudul, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(isiISBN, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 616, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(0, 8, 29));

        jLabel16.setFont(new java.awt.Font("Bebas", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("university");
        jLabel16.setToolTipText("");

        jLabel18.setFont(new java.awt.Font("Bebas", 0, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Bibliography");

        jLabel27.setFont(new java.awt.Font("Bebas", 0, 36)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Skripsi");

        jLabel28.setFont(new java.awt.Font("Helvetica", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("ISBN");

        jLabel29.setFont(new java.awt.Font("Helvetica", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Judul");

        jLabel30.setFont(new java.awt.Font("Helvetica", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Pengarang");

        jLabel31.setFont(new java.awt.Font("Helvetica", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Penerbit");

        jLabel32.setFont(new java.awt.Font("Helvetica", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Tahun terbit");

        jLabel33.setFont(new java.awt.Font("Helvetica", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Jumlah halaman");

        jLabel34.setFont(new java.awt.Font("Helvetica", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Jumlah ");

        jLabel3.setFont(new java.awt.Font("Helvetica", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText(":");

        jLabel8.setFont(new java.awt.Font("Helvetica", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText(":");

        jLabel12.setFont(new java.awt.Font("Helvetica", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText(":");

        jLabel13.setFont(new java.awt.Font("Helvetica", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText(":");

        jLabel35.setFont(new java.awt.Font("Helvetica", 1, 16)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText(":");

        jLabel36.setFont(new java.awt.Font("Helvetica", 1, 16)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText(":");

        jLabel37.setFont(new java.awt.Font("Helvetica", 1, 16)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText(":");

        jLabel38.setFont(new java.awt.Font("Helvetica", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Sub judul");

        jLabel39.setFont(new java.awt.Font("Helvetica", 1, 16)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText(":");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel16))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel38)
                            .addComponent(jLabel31)
                            .addComponent(jLabel33)
                            .addComponent(jLabel28)
                            .addComponent(jLabel29)
                            .addComponent(jLabel30)
                            .addComponent(jLabel32)
                            .addComponent(jLabel34))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(jLabel35))
                .addGap(12, 12, 12)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jLabel36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(jLabel39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jLabel37))
                .addContainerGap(264, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 47, Short.MAX_VALUE)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void profile2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profile2ActionPerformed
        new profile().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_profile2ActionPerformed

    private void need1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_need1ActionPerformed
        new inputSkripsi().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_need1ActionPerformed

    private void need2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_need2ActionPerformed
        new inputBuku().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_need2ActionPerformed

    private void help2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_help2ActionPerformed
        new help().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_help2ActionPerformed

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

    private void isiISBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isiISBNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isiISBNActionPerformed

    private void isiJudulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isiJudulActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isiJudulActionPerformed

    private void isiPengarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isiPengarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isiPengarangActionPerformed

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
            EntityManager entityManager = Persistence.createEntityManagerFactory("Uas_PboPU").createEntityManager();
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
            EntityManager entityManager = Persistence.createEntityManagerFactory("Uas_PboPU").createEntityManager();
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
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Uas_PboPU");
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
            EntityManager entityManager = Persistence.createEntityManagerFactory("Uas_PboPU").createEntityManager();
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
            EntityManager entityManager = Persistence.createEntityManagerFactory("Uas_PboPU").createEntityManager();
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
            java.util.logging.Logger.getLogger(inputSkripsii.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(inputSkripsii.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(inputSkripsii.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inputSkripsii.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new inputSkripsii().setVisible(true);
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
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JButton logout2;
    private javax.swing.JButton need1;
    private javax.swing.JButton need2;
    private javax.swing.JButton print;
    private javax.swing.JButton profile2;
    private javax.swing.JButton save;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
