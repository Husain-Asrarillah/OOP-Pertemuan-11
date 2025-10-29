/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package pertemuankesebelas;

/**
 *
 * @author Husain
 */
import javax.swing.*;
import java.awt.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class UpdateDialog extends JDialog {

    private final EntityManagerFactory emf;
    private final int komikId;
    private TokoKomikJadoel currentKomik;

    public UpdateDialog(Frame parent, EntityManagerFactory emf, int komikId) {
        super(parent, "Update Komik", true);
        this.emf = emf; // Simpan EMF
        this.komikId = komikId;
        initComponents();
        loadData(); // Load data menggunakan JPA

        if (parent != null) {
            setLocationRelativeTo(parent);
        } else {
            setLocationRelativeTo(null);
        }
    }

    private void loadData() {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();

            // Mencari objek TokoKomikJadoel berdasarkan Primary Key (ID)
            currentKomik = em.find(TokoKomikJadoel.class, komikId);

            if (currentKomik != null) {
                // Tampilkan data dari objek entitas ke JTextFields
                tfid.setText(String.valueOf(currentKomik.getId()));
                tfjudul.setText(currentKomik.getJudul());
                tfpengarang.setText(currentKomik.getPengarang());
                tftahun.setText(String.valueOf(currentKomik.getTahun()));
                tfgenre.setText(currentKomik.getGenre());

                // ID tidak boleh diubah setelah dimuat
                tfid.setEditable(false);
            } else {
                JOptionPane.showMessageDialog(this, "Data komik tidak ditemukan!", "Error", JOptionPane.ERROR_MESSAGE);
                dispose();
            }
        } catch (HeadlessException ex) {
            JOptionPane.showMessageDialog(this, "Error load data: " + ex.getMessage(), "Error JPA", JOptionPane.ERROR_MESSAGE);
            dispose();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Metode updateData() menggunakan JPA merge()
    private void updateData() {
        // 1. VALIDASI
        if (tfjudul.getText().isEmpty() || tfpengarang.getText().isEmpty()
                || tftahun.getText().isEmpty() || tfgenre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field harus diisi!", "Validasi Gagal", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Apakah Anda yakin ingin mengupdate data ini?",
                "Konfirmasi Update",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (confirm == JOptionPane.YES_OPTION) {
            EntityManager em = null;
            try {
                // 2. AMBIL DAN KONVERSI TAHUN
                int tahun = Integer.parseInt(tftahun.getText());

                em = emf.createEntityManager();
                em.getTransaction().begin();

                // 3. AMBIL OBJEK PERSISTEN (jika objek sudah dimuat tapi EM berbeda)
                // Jika loadData() sudah memuat currentKomik, kita bisa langsung menggunakannya
                // Tetapi untuk update yang aman, kita cari ulang atau merge objek yang dimodifikasi.
                TokoKomikJadoel mergedKomik = em.find(TokoKomikJadoel.class, komikId);

                if (mergedKomik != null) {
                    // 4. SET NILAI BARU KE OBJEK ENTITAS
                    mergedKomik.setJudul(tfjudul.getText());
                    mergedKomik.setPengarang(tfpengarang.getText());
                    mergedKomik.setTahun(tahun);
                    mergedKomik.setGenre(tfgenre.getText());

                    // merge() memastikan perubahan disimpan ke database
                    em.merge(mergedKomik);
                }

                em.getTransaction().commit();

                JOptionPane.showMessageDialog(this, "Data berhasil diupdate!", "Sukses", JOptionPane.INFORMATION_MESSAGE);

                // Refresh tabel di DataKomik
                ((DataKomik) getParent()).showTable();
                dispose();

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Tahun harus berupa angka yang valid.", "Format Data Salah", JOptionPane.ERROR_MESSAGE);
            } catch (HeadlessException ex) {
                if (em != null && em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                JOptionPane.showMessageDialog(this, "Error update: " + ex.getMessage(), "Error JPA", JOptionPane.ERROR_MESSAGE);
            } finally {
                if (em != null) {
                    em.close();
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfid = new javax.swing.JTextField();
        tfjudul = new javax.swing.JTextField();
        tfpengarang = new javax.swing.JTextField();
        tftahun = new javax.swing.JTextField();
        tfgenre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tfid.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tfid.setForeground(new java.awt.Color(255, 204, 0));
        tfid.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        tfid.setEnabled(false);

        tfjudul.setBackground(new java.awt.Color(51, 51, 255));
        tfjudul.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tfjudul.setForeground(new java.awt.Color(255, 204, 0));

        tfpengarang.setBackground(new java.awt.Color(51, 51, 255));
        tfpengarang.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tfpengarang.setForeground(new java.awt.Color(255, 204, 0));
        tfpengarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfpengarangActionPerformed(evt);
            }
        });

        tftahun.setBackground(new java.awt.Color(51, 51, 255));
        tftahun.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tftahun.setForeground(new java.awt.Color(255, 204, 0));

        tfgenre.setBackground(new java.awt.Color(51, 51, 255));
        tfgenre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tfgenre.setForeground(new java.awt.Color(255, 204, 0));
        tfgenre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfgenreActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Stencil", 2, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 0));
        jLabel1.setText("UPdate DATA");

        jLabel2.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 204, 0));
        jLabel2.setText("ID");

        jLabel3.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 204, 0));
        jLabel3.setText("JUDUL");

        jLabel4.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 204, 0));
        jLabel4.setText("PENGARANG");

        jLabel5.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 204, 0));
        jLabel5.setText("TAHUN");

        jLabel6.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 204, 0));
        jLabel6.setText("GENRE");

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Bernard MT Condensed", 0, 14)); // NOI18N
        jButton1.setText("CANCEL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 255, 0));
        jButton2.setFont(new java.awt.Font("Bernard MT Condensed", 0, 14)); // NOI18N
        jButton2.setText("UPDATE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pertemuankesebelas/Gemini_Generated_Image_31xxep31xxep31xx.png"))); // NOI18N
        jLabel7.setText("jLabel7");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(48, 48, 48)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(tfid, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(255, 255, 255)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(48, 48, 48)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(146, 146, 146)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(48, 48, 48)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(146, 146, 146)
                            .addComponent(tfgenre, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(48, 48, 48)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(48, 48, 48)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(146, 146, 146)
                            .addComponent(tftahun, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(146, 146, 146)
                            .addComponent(tfjudul, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(146, 146, 146)
                            .addComponent(tfpengarang, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(149, 149, 149)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(56, 56, 56)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(3, 3, 3)
                                    .addComponent(jLabel2))
                                .addComponent(tfid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(182, 182, 182)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(179, 179, 179)
                            .addComponent(jLabel5))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(96, 96, 96)
                            .addComponent(jLabel3))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(216, 216, 216)
                            .addComponent(tfgenre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(219, 219, 219)
                            .addComponent(jLabel6))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(139, 139, 139)
                            .addComponent(jLabel4))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(176, 176, 176)
                            .addComponent(tftahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(96, 96, 96)
                            .addComponent(tfjudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(136, 136, 136)
                            .addComponent(tfpengarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(260, 260, 260)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfpengarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfpengarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfpengarangActionPerformed

    private void tfgenreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfgenreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfgenreActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        updateData();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        JOptionPane.showMessageDialog(null, """
//                                            Kelas InsertDialog tidak bisa dijalankan langsung.
//                                            Silakan jalankan lewat DataKomik.""",
//                "Peringatan",
//                JOptionPane.WARNING_MESSAGE);
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField tfgenre;
    private javax.swing.JTextField tfid;
    private javax.swing.JTextField tfjudul;
    private javax.swing.JTextField tfpengarang;
    private javax.swing.JTextField tftahun;
    // End of variables declaration//GEN-END:variables
}
