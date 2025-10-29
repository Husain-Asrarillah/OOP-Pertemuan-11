/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pertemuankesebelas;

/**
 *
 * @author Husain
 */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.io.BufferedReader;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.util.HashMap;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JFileChooser;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public final class DataKomik extends javax.swing.JFrame {

    // Koneksi JDBC (Hanya digunakan untuk JasperReports)
    String koneksi = "jdbc:postgresql://localhost:5432/KuliahPBO";
    String user = "postgres";
    String password = "170206";

    // Objek utama JPA
    private final EntityManagerFactory emf;

    public DataKomik() {
        this.emf = Persistence.createEntityManagerFactory("PertemuanKesebelasPU");
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        initComponents();
        showTable();
        setLocationRelativeTo(null); // Muncul di tengah layar

        // Menutup EMF saat window ditutup
        addWindowListener(
                new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                if (emf != null && emf.isOpen()) {
                    emf.close();
                    System.out.println("EntityManagerFactory ditutup.");
                }
            }
        }
        );
    }

    public void showTable() {
        EntityManager em = null;

        try {
            em = emf.createEntityManager();

            // Query data menggunakan NamedQuery JPA
            TypedQuery<TokoKomikJadoel> q = em.createNamedQuery("TokoKomikJadoel.findAll", TokoKomikJadoel.class);
            List<TokoKomikJadoel> hasil = q.getResultList();

            // Konversi List Entitas ke TableModel
            DefaultTableModel model = new DefaultTableModel(
                    new String[]{"ID", "JUDUL", "PENGARANG", "TAHUN", "GENRE"}, 0);

            for (TokoKomikJadoel data : hasil) {
                Object[] baris = new Object[5];
                baris[0] = data.getId();
                baris[1] = data.getJudul();
                baris[2] = data.getPengarang();
                baris[3] = data.getTahun();
                baris[4] = data.getGenre();

                model.addRow(baris);
            }

            jTable1.setModel(model);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Gagal memuat data (JPA): " + ex.getMessage(),
                    "Error Database", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new DataKomik().setVisible(true);
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setBackground(new java.awt.Color(0, 153, 204));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 204, 0));
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 80, 40));

        jTable1.setBackground(new java.awt.Color(255, 204, 0));
        jTable1.setForeground(new java.awt.Color(0, 153, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Judul", "Pengarang", "Tahun", "Genre"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 260));

        jButton1.setBackground(new java.awt.Color(0, 153, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 204, 0));
        jButton1.setText("Insert");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 80, 40));

        jButton3.setBackground(new java.awt.Color(0, 153, 204));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 204, 0));
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 80, 40));

        jButton4.setBackground(new java.awt.Color(0, 153, 204));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 204, 0));
        jButton4.setText("Cetak");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 330, 90, 40));

        jButton5.setBackground(new java.awt.Color(0, 153, 204));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 204, 0));
        jButton5.setText("Upload");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 330, 80, 40));

        jLabel6.setBackground(new java.awt.Color(255, 102, 0));
        jLabel6.setFont(new java.awt.Font("Algerian", 3, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 204, 255));
        jLabel6.setText("TOKO KOMIK JADOEL");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 250, 40));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pertemuankesebelas/Gemini_Generated_Image_31xxep31xxep31xx.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int row = jTable1.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang mau diupdate dulu!");
            return;
        }

        int komikId = (int) jTable1.getValueAt(row, 0);

        try {
            UpdateDialog dialog = new UpdateDialog(this, emf, komikId);
            dialog.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            InsertDialog d = new InsertDialog(this, emf);
            d.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int row = jTable1.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data dulu!");
            return;
        }

        int id = (int) jTable1.getValueAt(row, 0);
        String judul = jTable1.getValueAt(row, 1).toString();
        String pengarang = jTable1.getValueAt(row, 2).toString();
        int tahun = (int) jTable1.getValueAt(row, 3);
        String genre = jTable1.getValueAt(row, 4).toString();

        try {
            DeleteDialog d = new DeleteDialog(this, emf, id, judul, pengarang, tahun, genre);
            d.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try (Connection conn = DriverManager.getConnection(koneksi, user, password)) {

            InputStream reportStream = getClass().getResourceAsStream("/pertemuankesebelas/LaporanTokoKomik.jrxml");
            JasperReport jasperReport;

            if (reportStream != null) {
                JasperDesign jasperDesign = JRXmlLoader.load(reportStream);
                jasperReport = JasperCompileManager.compileReport(jasperDesign);
                reportStream.close();
            } else {
                String reportPath = "src/pertemuankesebelas/LaporanTokoKomik.jrxml";
                File f = new File(reportPath);
                if (!f.exists()) {
                    throw new java.io.FileNotFoundException("File laporan tidak ditemukan: " + reportPath);
                }
                jasperReport = JasperCompileManager.compileReport(reportPath);
            }

            HashMap<String, Object> parameters = new HashMap<>();
            parameters.put("TanggalCetak", new java.util.Date());
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);
            JasperViewer.viewReport(jasperPrint, false);

        } catch (JRException | SQLException | java.io.FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error cetak laporan: " + ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getClass().getSimpleName() + " - " + ex.getMessage());
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            int berhasilDiunggah = 0;
            int gagalDiunggah = 0;
            final int BATCH_SIZE = 50;

            EntityManager em = null;
            BufferedReader br = null;

            try {
                em = emf.createEntityManager();
                br = new BufferedReader(new FileReader(file));
                em.getTransaction().begin();

                String line;
                int counter = 0;

                while ((line = br.readLine()) != null) {
                    if (line.trim().isEmpty()) {
                        continue;
                    }

                    String[] data = line.split(";");

                    if (data.length == 5) {
                        try {
                            int id = Integer.parseInt(data[0].trim());
                            String judul = data[1].trim();
                            String pengarang = data[2].trim();
                            int tahun = Integer.parseInt(data[3].trim());
                            String genre = data[4].trim();

                            TokoKomikJadoel komik = new TokoKomikJadoel();
                            komik.setId(id);
                            komik.setJudul(judul);
                            komik.setPengarang(pengarang);
                            komik.setTahun(tahun);
                            komik.setGenre(genre);

                            em.persist(komik);
                            berhasilDiunggah++;
                            counter++;

                            if (counter % BATCH_SIZE == 0) {
                                em.flush();
                                em.clear();
                            }

                        } catch (NumberFormatException e) {
                            System.out.println("Data dilewati (Format Angka Salah): " + line);
                            gagalDiunggah++;
                        }
                    } else {
                        System.out.println("Baris dilewati (Kolom tidak 5): " + line);
                        gagalDiunggah++;
                    }
                } // Akhir while loop

                em.getTransaction().commit();
                em.clear();

                showTable();

                JOptionPane.showMessageDialog(this,
                        "File berhasil diupload!\nTotal: " + (berhasilDiunggah + gagalDiunggah)
                        + "\nBerhasil: " + berhasilDiunggah + "\nGagal: " + gagalDiunggah,
                        "Sukses Upload", JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception e) {
                if (em != null && em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }

                String errorMessage = "Error saat upload: " + e.getMessage();
                if (e.getCause() instanceof SQLException) {
                    errorMessage = "Kesalahan Database (PK/Unique): " + e.getCause().getMessage();
                }

                JOptionPane.showMessageDialog(this, errorMessage, "Error Upload", JOptionPane.ERROR_MESSAGE);

            } finally {
                if (em != null) {
                    em.close();
                }
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException ignored) {
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Upload dibatalkan.", "Informasi", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
