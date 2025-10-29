/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package pertemuankesebelas;

import javax.swing.*;
import java.awt.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class InsertDialog extends javax.swing.JDialog {

    private final EntityManagerFactory emf;

    // tambahkan di atas biar bisa dipakai seluruh kelas
    public InsertDialog(Frame parent, EntityManagerFactory emf) {
        super(parent, "Insert Komik", true);
        this.emf = emf;
        initComponents();
       

        setLocationRelativeTo(parent);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfjudul = new javax.swing.JTextField();
        tfpengarang = new javax.swing.JTextField();
        tftahun = new javax.swing.JTextField();
        tfgenre = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btsave = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Stencil", 2, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 0));
        jLabel1.setText("INPUT DATA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 6, -1, 32));

        jLabel3.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 204, 0));
        jLabel3.setText("JUDUL");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 80, -1));

        jLabel4.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 204, 0));
        jLabel4.setText("PENGARANG");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 80, -1));

        jLabel5.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 204, 0));
        jLabel5.setText("TAHUN");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 92, -1));

        jLabel6.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 204, 0));
        jLabel6.setText("GENRE");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 92, -1));

        tfjudul.setBackground(new java.awt.Color(0, 102, 255));
        tfjudul.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tfjudul.setForeground(new java.awt.Color(255, 204, 0));
        jPanel1.add(tfjudul, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 203, -1));

        tfpengarang.setBackground(new java.awt.Color(0, 102, 255));
        tfpengarang.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tfpengarang.setForeground(new java.awt.Color(255, 204, 0));
        tfpengarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfpengarangActionPerformed(evt);
            }
        });
        jPanel1.add(tfpengarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 203, -1));

        tftahun.setBackground(new java.awt.Color(0, 102, 255));
        tftahun.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tftahun.setForeground(new java.awt.Color(255, 204, 0));
        jPanel1.add(tftahun, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 203, -1));

        tfgenre.setBackground(new java.awt.Color(0, 102, 255));
        tfgenre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tfgenre.setForeground(new java.awt.Color(255, 204, 0));
        tfgenre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfgenreActionPerformed(evt);
            }
        });
        jPanel1.add(tfgenre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 203, -1));

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Bernard MT Condensed", 0, 14)); // NOI18N
        jButton1.setText("CANCEL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 94, 36));

        btsave.setBackground(new java.awt.Color(0, 255, 0));
        btsave.setFont(new java.awt.Font("Bernard MT Condensed", 0, 14)); // NOI18N
        btsave.setText("SAVE");
        btsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsaveActionPerformed(evt);
            }
        });
        jPanel1.add(btsave, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 94, 36));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pertemuankesebelas/Gemini_Generated_Image_31xxep31xxep31xx.png"))); // NOI18N
        jLabel7.setText("jLabel7");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 310));

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

    private void tfpengarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfpengarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfpengarangActionPerformed

    private void tfgenreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfgenreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfgenreActionPerformed

    private void btsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsaveActionPerformed
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            TokoKomikJadoel komik = new TokoKomikJadoel();
            komik.setJudul(tfjudul.getText());
            komik.setPengarang(tfpengarang.getText());
            komik.setTahun(Integer.valueOf(tftahun.getText()));

            em.persist(komik);
            em.getTransaction().commit();

            JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan!");
            ((DataKomik) getParent()).showTable();
            dispose();
        } catch (HeadlessException | NumberFormatException e) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(this, "Gagal menambah data: " + e.getMessage());
        } finally {
            em.close();
        }
    }//GEN-LAST:event_btsaveActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btsave;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tfgenre;
    private javax.swing.JTextField tfjudul;
    private javax.swing.JTextField tfpengarang;
    private javax.swing.JTextField tftahun;
    // End of variables declaration//GEN-END:variables
}
