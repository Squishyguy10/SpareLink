/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package SpareLinkPackage;

import SwingComponents.DataSearch;
import SwingComponents.EventClick;
import SwingComponents.PanelSearch;
import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;

import org.apache.poi.EncryptedDocumentException;

/**
 *
 * @author avih2
 */
public class MainMenu extends javax.swing.JFrame {
    static File file = new File("");
    
    
    /**
     * Creates new form MainMenu
     */
    
    ArrayList<String> history = new ArrayList<>();
    static ArrayList<Student> dataList = new ArrayList<>();

    private JPopupMenu menu;
    private PanelSearch search;
    
    public MainMenu() throws EncryptedDocumentException, IOException {
        initComponents();

        this.setTitle("SpareLink");
        File dir = new File(System.getProperty("user.dir"));
        for(int i=0;i<dir.list().length;i++){
            if(dir.list()[i].endsWith(".xlsx")){
                file = new File(dir.list()[i]);
            }
        }

        SearchSheet(file);
        menu = new JPopupMenu();
        search = new PanelSearch();
        menu.setBorder(BorderFactory.createLineBorder(new Color(164, 164, 164)));
        menu.add(search);
        menu.setFocusable(false);
        search.addEventClick(new EventClick() {
            @Override
            public void itemClick(DataSearch data) {
                // When item clicked
                
                menu.setVisible(false);
                textSearch.setText(data.getText());
                history.add(data.getText());
                System.out.println("Click Item : " + data.getText());
                SchedulePage schedule = new SchedulePage(data.getText());
                close();
                schedule.setVisible(true);
            }

            @Override
            public void itemRemove(Component com, DataSearch data) {
                if(textSearch.getText().equals(data.getText())){
                    textSearch.setText("");
                }
                search.remove(com);
                removeHistory(data.getText());
                menu.setPopupSize(menu.getWidth(), (search.getItemSize() * 35));
                if (search.getItemSize() == 0) {
                    menu.setVisible(false);
                }
                System.out.println("Remove Item: " + data.getText());
            }

        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        importButton = new javax.swing.JButton();
        textSearch = new SwingComponents.MyTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        importButton.setBackground(new java.awt.Color(255, 255, 254));
        importButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        importButton.setText("Import");
        importButton.setBorder(null);
        importButton.setFocusPainted(false);
        importButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    importButtonActionPerformed(evt);
                } catch (EncryptedDocumentException | IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        textSearch.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textSearch.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Search.png"))); // NOI18N
        textSearch.setSelectionColor(new java.awt.Color(255, 255, 255));
        textSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textSearchMouseClicked(evt);
            }
        });
        textSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSearchActionPerformed(evt);
            }
        });
        textSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textSearchKeyReleased(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Logo.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(262, 262, 262))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(230, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(importButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(193, 193, 193))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(importButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 258, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(36, 36, 36))
        );

        setSize(new java.awt.Dimension(1437, 968));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void textSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textSearchMouseClicked
        // TODO add your handling code here:
        if(search.getItemSize()>0){
            menu.show(textSearch, 0, textSearch.getHeight());
        }
    }//GEN-LAST:event_textSearchMouseClicked

    private void textSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textSearchKeyReleased
        // TODO add your handling code here:
        String text = textSearch.getText().trim().toLowerCase();
        search.setData(search(text));
        if(search.getItemSize()>0){
            menu.show(textSearch, 0, textSearch.getHeight());
            menu.setPopupSize(menu.getWidth(), (search.getItemSize()*35));
        }else{
            menu.setVisible(false);
        }
    }//GEN-LAST:event_textSearchKeyReleased

    private void textSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSearchActionPerformed
    }//GEN-LAST:event_textSearchActionPerformed

    private void importButtonActionPerformed(java.awt.event.ActionEvent evt) throws EncryptedDocumentException, IOException {//GEN-FIRST:event_importButtonActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        file = chooser.getSelectedFile();
        if(file!=null){
            SearchSheet(file);
        }
    }//GEN-LAST:event_importButtonActionPerformed
    
    // search bar
    private ArrayList<DataSearch> search(String search){
        int dataLimit = 7;
        ArrayList<DataSearch> list = new ArrayList<>();
        for(Student s: dataList){
            if(s.getName().toLowerCase().contains(search)){
                boolean story = isStory(s.getName());
                if(story){
                    list.add(0, new DataSearch(s.getName(), story));
                }else{
                    list.add(new DataSearch(s.getName(), story));
                if(list.size()== dataLimit){
                    break;
                }
            }
        }
        
    }
    return list;
    }
    
    // history (does not work anymore though)
    private void removeHistory(String text){
        for(int i=0; i<history.size();i++){
            String d=history.get(i);
            if(d.toLowerCase().equals(text.toLowerCase())){
                    history.set(i, "");
                }
            }
    }
    private boolean isStory(String text){
        
        for(String d: history){
            if(d.toLowerCase().equals(text.toLowerCase())){
                    return true;
                }
            }
        return false;
        }
   
    // getting the file
    public static File getFile(){
        return file;
    }
    // closing window
    public void close(){
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }

    // get spreadsheet data
    public void SearchSheet(File file) throws EncryptedDocumentException, IOException{
        dataList = SpreadsheetReader.getStudentList(file.getName());
    }

    // display student name and get student
    public static Student getData(String name){
        for(Student s : dataList){
            if(s.getName().equals(name)){
                return(s);
            }
        }
        return null;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[])  {
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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainMenu().setVisible(true);
                } catch (EncryptedDocumentException | IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton importButton;
    private javax.swing.JLabel jLabel1;
    private SwingComponents.MyTextField textSearch;
    // End of variables declaration//GEN-END:variables
}
