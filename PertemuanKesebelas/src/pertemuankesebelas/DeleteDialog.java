/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package pertemuankesebelas;

import javax.swing.*;
import java.awt.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class DeleteDialog extends JDialog {

    private final EntityManagerFactory emf; // Ganti Connection dengan EMF
    private final int idToDelete;

    public DeleteDialog(Frame parent, EntityManagerFactory emf, int id, String judul, String pengarang, int tahun, String genre) {
        super(parent, "Konfirmasi Hapus", true);
        this.emf = emf; // Simpan EMF
        this.idToDelete = id; // Simpan ID yang akan dihapus
        initComponents();

        jTextField1.setText(String.valueOf(id));
        jTextField2.setText(judul);
        jTextField3.setText(pengarang);
        jTextField4.setText(String.valueOf(tahun));
        jTextField5.setText(genre);

        // bikin read-only
        jTextField1.setEditable(false);
        jTextField2.setEditable(false);
        jTextField3.setEditable(false);
        jTextField4.setEditable(false);
        jTextField5.setEditable(false);

        // pakai warna default non-editable
        jTextField1.setBackground(UIManager.getColor("TextField.inactiveBackground"));
        jTextField2.setBackground(UIManager.getColor("TextField.inactiveBackground"));
        jTextField3.setBackground(UIManager.getColor("TextField.inactiveBackground"));
        jTextField4.setBackground(UIManager.getColor("TextField.inactiveBackground"));
        jTextField5.setBackground(UIManager.getColor("TextField.inactiveBackground"));

        if (parent != null) {
            setLocationRelativeTo(parent);  // muncul di tengah parent
        } else {
            setLocationRelativeTo(null);    // muncul di tengah layar
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Stencil", 2, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 0));
        jLabel1.setText("DELEte data");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 130, 37));

        jLabel2.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 204, 0));
        jLabel2.setText("ID");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 64, 103, -1));

        jLabel3.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 204, 0));
        jLabel3.setText("JUDUL");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 104, 103, -1));

        jLabel4.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 204, 0));
        jLabel4.setText("PENGARANG");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 147, 103, -1));

        jLabel5.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 204, 0));
        jLabel5.setText("TAHUN");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 187, 103, -1));

        jLabel6.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 204, 0));
        jLabel6.setText("GENRE");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 227, 103, -1));

        jTextField1.setBackground(new java.awt.Color(0, 102, 255));
        jTextField1.setForeground(new java.awt.Color(204, 102, 0));
        jTextField1.setText(" ");
        jTextField1.setEnabled(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 61, 241, -1));

        jTextField2.setBackground(new java.awt.Color(0, 102, 255));
        jTextField2.setForeground(new java.awt.Color(204, 102, 0));
        jTextField2.setText(" ");
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 101, 241, -1));

        jTextField3.setBackground(new java.awt.Color(0, 102, 255));
        jTextField3.setForeground(new java.awt.Color(204, 102, 0));
        jTextField3.setText(" ");
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 144, 241, -1));

        jTextField4.setBackground(new java.awt.Color(0, 102, 255));
        jTextField4.setForeground(new java.awt.Color(204, 102, 0));
        jTextField4.setText(" ");
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 184, 241, -1));

        jTextField5.setBackground(new java.awt.Color(0, 102, 255));
        jTextField5.setForeground(new java.awt.Color(204, 102, 0));
        jTextField5.setText(" ");
        jPanel1.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 224, 241, -1));

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Bernard MT Condensed", 0, 14)); // NOI18N
        jButton1.setText("DELETE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 264, 92, 38));

        jButton2.setBackground(new java.awt.Color(0, 255, 0));
        jButton2.setFont(new java.awt.Font("Bernard MT Condensed", 0, 14)); // NOI18N
        jButton2.setText("CANCEL");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 264, 92, 38));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pertemuankesebelas/Gemini_Generated_Image_31xxep31xxep31xx.png"))); // NOI18N
        jLabel7.setText("jLabel7");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 330));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        EntityManager em = null;
        try {
            // 1. INISIALISASI JPA DAN TRANSAKSI
            em = emf.createEntityManager();
            em.getTransaction().begin();

            // 2. FIND (Cari entitas yang akan dihapus)
            // Kita cari entitas TokoKomikJadoel berdasarkan ID yang disimpan
            TokoKomikJadoel komik = em.find(TokoKomikJadoel.class, idToDelete);

            if (komik != null) {
                // 3. REMOVE (Hapus entitas)
                em.remove(komik);

                // 4. COMMIT
                em.getTransaction().commit();

                JOptionPane.showMessageDialog(this, "Data berhasil dihapus!", "Sukses", JOptionPane.INFORMATION_MESSAGE);

                // Panggil showTable() dari DataKomik untuk refresh tabel
                ((DataKomik) getParent()).showTable();
                dispose();
            } else {
                // Jika ID tidak ditemukan (walaupun seharusnya sudah ada karena dipilih dari tabel)
                JOptionPane.showMessageDialog(this, "Data tidak ditemukan di database.", "Error", JOptionPane.ERROR_MESSAGE);
                dispose();
            }

        } catch (Exception ex) {
            // Rollback jika terjadi error
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            JOptionPane.showMessageDialog(this, "Error saat menghapus data: " + ex.getMessage(),
                    "Error Database/JPA", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Pastikan EntityManager ditutup
            if (em != null) {
                em.close();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(DeleteDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(DeleteDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(DeleteDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(DeleteDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
