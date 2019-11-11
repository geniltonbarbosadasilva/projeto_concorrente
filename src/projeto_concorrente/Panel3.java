package projeto_concorrente;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author genilton
 */
public class Panel3 extends javax.swing.JFrame {

    private String path;

    public Panel3() {
        path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        initComponents();
        refresh();
    }

    private void deleteFiles(String folder) {
        File dir = new File(this.path + folder);
        if (!dir.exists()) {
            dir.mkdirs();
            return;
        }
        File[] files = dir.listFiles();
        for (File f : files) {
            f.delete();
        }
        this.refresh();
    }

    private void refresh() {
        //Centraliza texto na coluna
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        //Limpa a tabela Source
        DefaultTableModel table = (DefaultTableModel) this.Source.getModel();
        table.setNumRows(0);
        table.setColumnCount(0);

        //Preenche a tabela Source
        File dir = new File(this.path + "Source");
        if (!dir.exists()) {
            dir.mkdirs();
            return;
        }

        File[] files = dir.listFiles();
        ArrayList<Files> list = new ArrayList<>();
        String[] names = new String[files.length];
        String[] sizes = new String[files.length];
        int i = 0;

        for (File f : files) {
            String name = f.getName();
            String kb = "" + f.length() / 1000;
            list.add(new Files(name, kb));
            i++;
        }

        Collections.sort(list);

        i = 0;
        for (Files f : list) {
            names[i] = f.getName();
            sizes[i] = f.getSize();
            i++;
        }

        table.addColumn("Arquivos", names);
        table.addColumn("KB", sizes);

        Source.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        Source.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

//        //Preenche a tabela Backup
        table = (DefaultTableModel) this.Target.getModel();
        table.setNumRows(0);
        table.setColumnCount(0);

        dir = new File(this.path + "Backup");
        if (!dir.exists()) {
            dir.mkdirs();
            return;
        }
        files = dir.listFiles();

        names = new String[files.length];
        sizes = new String[files.length];
        list = new ArrayList<>();

        for (File f : files) {
            String name = f.getName();
            String kb = "" + f.length() / 1000;
            list.add(new Files(name, kb));
            i++;
        }

        Collections.sort(list);

        i = 0;
        for (Files f : list) {
            names[i] = f.getName();
            sizes[i] = f.getSize();
            i++;
        }
        table.addColumn("Arquivos", names);
        table.addColumn("KB", sizes);

        Target.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        Target.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
    }

    public void copy(File src, File dst) throws IOException {
        try {
            InputStream in = new FileInputStream(src);
            OutputStream out = new FileOutputStream(dst);           // Transferindo bytes de entrada para saída
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        Menu = new javax.swing.JButton();
        setPath = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        generate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Target = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        Source = new javax.swing.JTable();
        qtdFiles = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        kbs = new javax.swing.JTextField();
        clearSource = new javax.swing.JButton();
        clearTarget = new javax.swing.JButton();
        BackupSerial = new javax.swing.JButton();
        BackupParallel = new javax.swing.JButton();
        time2 = new javax.swing.JLabel();
        time1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        Menu.setText("Menu");
        Menu.setFocusable(false);
        Menu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Menu.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuActionPerformed(evt);
            }
        });
        jToolBar1.add(Menu);

        setPath.setText("Altera Path");
        setPath.setFocusable(false);
        setPath.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        setPath.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        setPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setPathActionPerformed(evt);
            }
        });
        jToolBar1.add(setPath);

        jLabel1.setText("Quantos arquivos: ");

        generate.setText("Gerar");
        generate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateActionPerformed(evt);
            }
        });

        Target.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Arquivos"
            }
        ));
        jScrollPane1.setViewportView(Target);

        Source.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Arquivos"
            }
        ));
        jScrollPane2.setViewportView(Source);

        qtdFiles.setText("1");
        qtdFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qtdFilesActionPerformed(evt);
            }
        });

        jLabel2.setText("de");

        jLabel3.setText("KB");

        jLabel4.setText("Origem");

        jLabel5.setText("Destino");

        kbs.setText("1");

        clearSource.setText("Limpar");
        clearSource.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearSourceActionPerformed(evt);
            }
        });

        clearTarget.setText("Limpar");
        clearTarget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearTargetActionPerformed(evt);
            }
        });

        BackupSerial.setText("Backup Sequencial");
        BackupSerial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackupSerialActionPerformed(evt);
            }
        });

        BackupParallel.setText("Backup com Threads");
        BackupParallel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackupParallelActionPerformed(evt);
            }
        });

        time2.setText("Tempo:");

        time1.setText("Tempo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(qtdFiles, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearSource))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(kbs, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(generate))
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BackupParallel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BackupSerial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(time1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(time2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(clearTarget)))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qtdFiles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(kbs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(generate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BackupSerial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(time1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BackupParallel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(time2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(clearSource, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clearTarget, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuActionPerformed
        new Menu().setVisible(true);
        dispose();
    }//GEN-LAST:event_MenuActionPerformed

    private void qtdFilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qtdFilesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qtdFilesActionPerformed

    private void generateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateActionPerformed
        try {
            int qtd = Convert.converteInt(this.qtdFiles.getText());
            int kb = Convert.converteInt(this.kbs.getText()) * 1000;
            if (qtd <= 0 || kb <= 0) {
                return;
            }
            String text = "";
            for (int i = 0; i < kb; i++) {
                text += "A";
            }
            File dir = new File(this.path + "Source");
            if (!dir.exists()) {
                dir.mkdirs();
            }

            for (int i = 0; i < qtd; i++) {
                File file = new File(dir.getAbsolutePath() + File.separator + i + ".txt");
                if (file.exists()) {
                    qtd++;
                    continue;
                }
                file.createNewFile();
                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                fw.write(text);
                fw.close();
            }
        } catch (IOException ex) {
            System.err.println("ERRO: " + ex.getMessage());
        }
        this.refresh();
    }//GEN-LAST:event_generateActionPerformed

    private void clearSourceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearSourceActionPerformed
        deleteFiles("Source");
    }//GEN-LAST:event_clearSourceActionPerformed

    private void clearTargetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearTargetActionPerformed
        deleteFiles("Backup");
    }//GEN-LAST:event_clearTargetActionPerformed

    private void setPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setPathActionPerformed
        String temp = JOptionPane.showInputDialog(
                rootPane, "<html>Qual a nova pasta de teste?<br><li>Atual: " + this.path);
        if (temp != null) {
            if (!temp.isEmpty()) {
                this.path = temp;
            }
        }
    }//GEN-LAST:event_setPathActionPerformed

    private void BackupSerialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackupSerialActionPerformed
        double startTime, endTime;
        //Limpar a pasta de backup
        deleteFiles("Backup");

        //Copiar os arquivos de source       
        File dirSource = new File(this.path + "Source");
        File dirBackup = new File(this.path + "Backup");

        if (!dirSource.exists()) {
            dirSource.mkdirs();
            return;
        }
        if (!dirBackup.exists()) {
            dirSource.mkdirs();
        }

        File[] files = dirSource.listFiles();
        
        //Cola em Backup
        startTime = System.currentTimeMillis();
        for (File fileSource : files) {
            try {
                File fileDest = new File(dirBackup.getAbsolutePath() + File.separator + fileSource.getName());
                fileDest.createNewFile();
                this.copy(fileSource, fileDest);

            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }
        endTime = System.currentTimeMillis();
        
        this.time1.setText("Tempo: " + (endTime-startTime) + "ms");
        System.out.println("Tempo Sequencial: " + (endTime-startTime) + "ms");        
        this.refresh();
    }//GEN-LAST:event_BackupSerialActionPerformed

    private void BackupParallelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackupParallelActionPerformed

    }//GEN-LAST:event_BackupParallelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackupParallel;
    private javax.swing.JButton BackupSerial;
    private javax.swing.JButton Menu;
    private javax.swing.JTable Source;
    private javax.swing.JTable Target;
    private javax.swing.JButton clearSource;
    private javax.swing.JButton clearTarget;
    private javax.swing.JButton generate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField kbs;
    private javax.swing.JTextField qtdFiles;
    private javax.swing.JButton setPath;
    private javax.swing.JLabel time1;
    private javax.swing.JLabel time2;
    // End of variables declaration//GEN-END:variables
}