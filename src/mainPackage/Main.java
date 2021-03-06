/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackage;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Eldeeb
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    
    private JFileChooser filechooser;
    private String filePath;
    private boolean combressable;
    
    public Main() {
        initComponents();
        filechooser = new JFileChooser();
        filechooser.setCurrentDirectory(new File("D:\\Java work-space\\std_huffman\\"));
        filechooser.setFileFilter(new FileNameExtensionFilter("text files", "txt"));
        combressable = false;
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
        load_btn = new javax.swing.JButton();
        loadFile_lb = new javax.swing.JLabel();
        compress_btn = new javax.swing.JButton();
        decompress_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Standard Huffman");

        load_btn.setText("load file...");
        load_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                load_btnActionPerformed(evt);
            }
        });

        loadFile_lb.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        loadFile_lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        compress_btn.setText("Compress");
        compress_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compress_btnActionPerformed(evt);
            }
        });

        decompress_btn.setText("Decopress");
        decompress_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decompress_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(compress_btn)
                            .addComponent(load_btn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(loadFile_lb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(decompress_btn, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loadFile_lb, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(load_btn))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(decompress_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(compress_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void load_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_load_btnActionPerformed
        // TODO add your handling code here:
        int returnval = filechooser.showOpenDialog(this);
        
        if(returnval == JFileChooser.APPROVE_OPTION){
            filePath = filechooser.getSelectedFile().toString();
            loadFile_lb.setText(filechooser.getSelectedFile().getName() + " file is successfully selected");
            combressable = true;
        }else{
            loadFile_lb.setText("no file loaded");
            combressable = false;
        }
    }//GEN-LAST:event_load_btnActionPerformed

    private void compress_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compress_btnActionPerformed
        // TODO add your handling code here:
        if(combressable){
            Encoder en = new Encoder(filePath);
            en.compress();
            combressable = false;
            loadFile_lb.setText("Done");
        }else{
            JOptionPane.showMessageDialog(null, "there is no file chossen", "Erorr", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_compress_btnActionPerformed

    private void decompress_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decompress_btnActionPerformed
        // TODO add your handling code here:
        if(combressable){
            Decoder d = new Decoder(filePath);
            //d.readCompressedData();
            d.decompress();
            //d.setCode();
            //d.displayCode();
            combressable = false;
            loadFile_lb.setText("Done");
        }else{
           JOptionPane.showMessageDialog(null, "there is no file chossen", "Erorr", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_decompress_btnActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton compress_btn;
    private javax.swing.JButton decompress_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel loadFile_lb;
    private javax.swing.JButton load_btn;
    // End of variables declaration//GEN-END:variables
}
