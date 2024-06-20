/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package SpareLinkPackage;

import java.awt.event.WindowEvent;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import org.apache.poi.EncryptedDocumentException;

import java.awt.*;
/**
 *
 * @author aviare
 */
public class SchedulePage extends javax.swing.JFrame implements Runnable {
    Student studentData;
    ArrayList<JPanel> blockA = new ArrayList<JPanel>();
    ArrayList<JPanel> blockB = new ArrayList<JPanel>();
    ArrayList<JPanel> blockC = new ArrayList<JPanel>();
    ArrayList<JPanel> blockD = new ArrayList<JPanel>();

    boolean isSem2=false;

    /**
     * Creates new form SchedulePage
     * @param name
     */
    public SchedulePage(String name) {
        initComponents();
        // title
        this.setTitle("SpareLink - "+name);
        studentData = MainMenu.getData(name);
        System.out.println(studentData);
        
        titleText.setText(name);
        Thread t = new Thread(this);
        t.start();
        
        // blocks
        blockA.add(blockAPanel);
        blockA.add(blockAPanel1);
        blockB.add(blockBPanel);
        blockB.add(blockBPanel1);
        blockC.add(blockCPanel);
        blockC.add(blockCPanel1);
        blockD.add(blockDPanel);
        blockD.add(blockDPanel1);

        
        setCourses(blockA, 0);
        setCourses(blockB, 1);
        setCourses(blockC, 2);
        setCourses(blockD, 3);

        spareCheck();
        writeDayNum();
        
    }
    // displaying the day and semester based on current time
    public void writeDayNum(){
        String s ="";
        LocalDate currentDate = LocalDate.now();
        int dayOfMonth = currentDate.getDayOfMonth();
        if(dayOfMonth % 2!=0){
            s = "Day 1";
        } else {
            s = "Day 2";
        }
        if(isSem2){
            s+=", S2";
        } else {
            s+=", S1";
        }
        dayText.setText(s);
    }
    
    public void setCourses(ArrayList<JPanel> block, int index){
        // commented out code is for test cases
        
        //Sem2
        LocalDate currentDate = LocalDate.now();
        //Sem1
        //LocalDate currentDate = LocalDate.of(2024, 12, 19);
        // to calculate semester 2
        LocalDate febFirst = LocalDate.of(currentDate.getYear(), 2, 1);
        LocalDate julyFirst = LocalDate.of(currentDate.getYear(), 7, 1);
        if (currentDate.isAfter(febFirst) && currentDate.isBefore(julyFirst)) {
            isSem2=true;
            index+=4; // this is how the courses are stored
        } else{
            isSem2=false;
        }
        // display text in the blocks
        for(JPanel panel : block){  
            for(int i=0;i<panel.getComponents().length;i++){
                JLabel label = (JLabel) panel.getComponent(i);
                switch (i) {
                    case 2:
                        label.setText(studentData.getCourse(index).getName());
                        break;
                    case 1:
                        label.setText(studentData.getCourse(index).getTeacher());
                        break;
                    case 0:
                        label.setText(studentData.getCourse(index).getRoom());
                        break;
                }
            }
        }
    }
    
    public void spareCheck(){
        // test cases
        LocalDate currentDate = LocalDate.now();
        //Day 1 
        //int dayOfMonth = (currentDate.getDayOfMonth())%2;
        //Day 2 
        int dayOfMonth = (currentDate.getDayOfMonth()+1)%2;
        Border redBorder = BorderFactory.createLineBorder(Color.RED, 3);
        Border greenBorder = BorderFactory.createLineBorder(Color.GREEN, 3);
        //LocalTime currentTime = LocalTime.now();
        //9:30
        //LocalTime currentTime = LocalTime.of(9,30);
        //10:30
        //LocalTime currentTime = LocalTime.of(10,30);
        // During Lunch
        //LocalTime currentTime = LocalTime.of(11,40);
        // 2:30
        LocalTime currentTime = LocalTime.of(13,00);
        int currentBlock = CheckTime.getBlock(currentTime,dayOfMonth);
        int spareBlock = studentData.spareIndex(isSem2)%4; // mod 4 so it says within blocks A-D (0-3 because 0-indexed)
        dayOfMonth = dayOfMonth-1;
        // changing the border colour
        if(dayOfMonth==-1){
            dayOfMonth=1;
        }
        if(currentBlock==-1){
        } else if(currentBlock != spareBlock){
            switch(currentBlock){
                case 0:
                    blockA.get(dayOfMonth).setBorder(redBorder);
                    break;
                case 1:
                    blockB.get(dayOfMonth).setBorder(redBorder);
                    break;
                case 2:
                    blockC.get(dayOfMonth).setBorder(redBorder);
                    break;
                case 3:
                    blockD.get(dayOfMonth).setBorder(redBorder);
                    break;
            }
        } else if(currentBlock == spareBlock){
            switch(currentBlock){
                case 0:
                    blockA.get(dayOfMonth).setBorder(greenBorder);
                    break;
                case 1:
                    blockB.get(dayOfMonth).setBorder(greenBorder);
                    break;
                case 2:
                    blockC.get(dayOfMonth).setBorder(greenBorder);
                    break;
                case 3:
                    blockD.get(dayOfMonth).setBorder(greenBorder);
                    break;
            }
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        // initializing every button
        returnButton = new javax.swing.JButton();
        titleText = new javax.swing.JLabel();
        timeText = new javax.swing.JLabel();
        dayText = new javax.swing.JLabel();
        blockAPanel = new javax.swing.JPanel();
        classCode9 = new javax.swing.JLabel();
        classTeacher9 = new javax.swing.JLabel();
        classRoomNum9 = new javax.swing.JLabel();
        blockCPanel = new javax.swing.JPanel();
        classCode2 = new javax.swing.JLabel();
        classTeacher2 = new javax.swing.JLabel();
        classRoomNum2 = new javax.swing.JLabel();
        blockDPanel = new javax.swing.JPanel();
        classCode3 = new javax.swing.JLabel();
        classTeacher3 = new javax.swing.JLabel();
        classRoomNum3 = new javax.swing.JLabel();
        blockAPanel1 = new javax.swing.JPanel();
        classCode5 = new javax.swing.JLabel();
        classTeacher5 = new javax.swing.JLabel();
        classRoomNum5 = new javax.swing.JLabel();
        blockDPanel1 = new javax.swing.JPanel();
        classCode6 = new javax.swing.JLabel();
        classTeacher6 = new javax.swing.JLabel();
        classRoomNum6 = new javax.swing.JLabel();
        blockCPanel1 = new javax.swing.JPanel();
        classCode7 = new javax.swing.JLabel();
        classTeacher7 = new javax.swing.JLabel();
        classRoomNum7 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        blockBPanel1 = new javax.swing.JPanel();
        classCode8 = new javax.swing.JLabel();
        classTeacher8 = new javax.swing.JLabel();
        classRoomNum8 = new javax.swing.JLabel();
        blockBPanel = new javax.swing.JPanel();
        classCode1 = new javax.swing.JLabel();
        classTeacher1 = new javax.swing.JLabel();
        classRoomNum1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        timeText1 = new javax.swing.JLabel();
        timeText2 = new javax.swing.JLabel();
        timeText3 = new javax.swing.JLabel();
        timeText4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        returnButton.setBackground(new java.awt.Color(255, 255, 254));
        returnButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        returnButton.setText("Return");
        returnButton.setBorder(null);
        returnButton.setFocusPainted(false);
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    returnButtonActionPerformed(evt);
                } catch (EncryptedDocumentException | IOException e) {
                    e.printStackTrace();
                }
            }
        });
        // changing text positioning, size, and font
        titleText.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        titleText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleText.setText("STUDENT NAME");

        timeText.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        timeText.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        timeText.setText("00:00 AM");

        dayText.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        dayText.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dayText.setText("Day X");

        blockAPanel.setBackground(new java.awt.Color(255, 255, 255));
        blockAPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        blockAPanel.setPreferredSize(new java.awt.Dimension(300, 150));

        classCode9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        classCode9.setText("Class Code");

        classTeacher9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        classTeacher9.setText("Class Teacher");

        classRoomNum9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        classRoomNum9.setText("Class Room #");

        // block positioning 
        javax.swing.GroupLayout blockAPanelLayout = new javax.swing.GroupLayout(blockAPanel);
        blockAPanel.setLayout(blockAPanelLayout);
        blockAPanelLayout.setHorizontalGroup(
            blockAPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(blockAPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(blockAPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(classRoomNum9)
                    .addComponent(classTeacher9)
                    .addComponent(classCode9))
                .addContainerGap(172, Short.MAX_VALUE))
        );
        blockAPanelLayout.setVerticalGroup(
            blockAPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(blockAPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(classCode9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(classTeacher9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(classRoomNum9)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        // background colour
        blockCPanel.setBackground(new java.awt.Color(255, 255, 255));
        blockCPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        blockCPanel.setPreferredSize(new java.awt.Dimension(300, 150));

        classCode2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        classCode2.setText("Class Code");

        classTeacher2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        classTeacher2.setText("Class Teacher");

        classRoomNum2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        classRoomNum2.setText("Class Room #");

        javax.swing.GroupLayout blockCPanelLayout = new javax.swing.GroupLayout(blockCPanel);
        blockCPanel.setLayout(blockCPanelLayout);
        blockCPanelLayout.setHorizontalGroup(
            blockCPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(blockCPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(blockCPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(classRoomNum2)
                    .addComponent(classTeacher2)
                    .addComponent(classCode2))
                .addContainerGap(171, Short.MAX_VALUE))
        );
        blockCPanelLayout.setVerticalGroup(
            blockCPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(blockCPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(classCode2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(classTeacher2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(classRoomNum2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        blockDPanel.setBackground(new java.awt.Color(255, 255, 255));
        blockDPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        blockDPanel.setPreferredSize(new java.awt.Dimension(300, 150));

        classCode3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        classCode3.setText("Class Code");

        classTeacher3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        classTeacher3.setText("Class Teacher");

        classRoomNum3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        classRoomNum3.setText("Class Room #");

        javax.swing.GroupLayout blockDPanelLayout = new javax.swing.GroupLayout(blockDPanel);
        blockDPanel.setLayout(blockDPanelLayout);
        blockDPanelLayout.setHorizontalGroup(
            blockDPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(blockDPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(blockDPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(classRoomNum3)
                    .addComponent(classTeacher3)
                    .addComponent(classCode3))
                .addContainerGap(171, Short.MAX_VALUE))
        );
        blockDPanelLayout.setVerticalGroup(
            blockDPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(blockDPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(classCode3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(classTeacher3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(classRoomNum3)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        blockAPanel1.setBackground(new java.awt.Color(255, 255, 255));
        blockAPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        blockAPanel1.setPreferredSize(new java.awt.Dimension(300, 150));

        classCode5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        classCode5.setText("Class Code");

        classTeacher5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        classTeacher5.setText("Class Teacher");

        classRoomNum5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        classRoomNum5.setText("Class Room #");

        javax.swing.GroupLayout blockAPanel1Layout = new javax.swing.GroupLayout(blockAPanel1);
        blockAPanel1.setLayout(blockAPanel1Layout);
        blockAPanel1Layout.setHorizontalGroup(
            blockAPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(blockAPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(blockAPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(classRoomNum5)
                    .addComponent(classTeacher5)
                    .addComponent(classCode5))
                .addContainerGap(172, Short.MAX_VALUE))
        );
        blockAPanel1Layout.setVerticalGroup(
            blockAPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, blockAPanel1Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(classCode5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(classTeacher5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(classRoomNum5)
                .addGap(23, 23, 23))
        );

        blockDPanel1.setBackground(new java.awt.Color(255, 255, 255));
        blockDPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        blockDPanel1.setPreferredSize(new java.awt.Dimension(300, 150));

        classCode6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        classCode6.setText("Class Code");

        classTeacher6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        classTeacher6.setText("Class Teacher");

        classRoomNum6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        classRoomNum6.setText("Class Room #");

        javax.swing.GroupLayout blockDPanel1Layout = new javax.swing.GroupLayout(blockDPanel1);
        blockDPanel1.setLayout(blockDPanel1Layout);
        blockDPanel1Layout.setHorizontalGroup(
            blockDPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(blockDPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(blockDPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(classRoomNum6)
                    .addComponent(classTeacher6)
                    .addComponent(classCode6))
                .addContainerGap(172, Short.MAX_VALUE))
        );
        blockDPanel1Layout.setVerticalGroup(
            blockDPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, blockDPanel1Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(classCode6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(classTeacher6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(classRoomNum6)
                .addGap(20, 20, 20))
        );

        blockCPanel1.setBackground(new java.awt.Color(255, 255, 255));
        blockCPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        blockCPanel1.setPreferredSize(new java.awt.Dimension(300, 150));

        classCode7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        classCode7.setText("Class Code");

        classTeacher7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        classTeacher7.setText("Class Teacher");

        classRoomNum7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        classRoomNum7.setText("Class Room #");

        javax.swing.GroupLayout blockCPanel1Layout = new javax.swing.GroupLayout(blockCPanel1);
        blockCPanel1.setLayout(blockCPanel1Layout);
        blockCPanel1Layout.setHorizontalGroup(
            blockCPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(blockCPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(blockCPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(classRoomNum7)
                    .addComponent(classTeacher7)
                    .addComponent(classCode7))
                .addContainerGap(171, Short.MAX_VALUE))
        );
        blockCPanel1Layout.setVerticalGroup(
            blockCPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(blockCPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(classCode7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(classTeacher7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(classRoomNum7)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Day 1 ");

        blockBPanel1.setBackground(new java.awt.Color(255, 255, 255));
        blockBPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        blockBPanel1.setPreferredSize(new java.awt.Dimension(300, 150));

        classCode8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        classCode8.setText("Class Code");

        classTeacher8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        classTeacher8.setText("Class Teacher");

        classRoomNum8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        classRoomNum8.setText("Class Room #");

        javax.swing.GroupLayout blockBPanel1Layout = new javax.swing.GroupLayout(blockBPanel1);
        blockBPanel1.setLayout(blockBPanel1Layout);
        blockBPanel1Layout.setHorizontalGroup(
            blockBPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(blockBPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(blockBPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(classRoomNum8)
                    .addComponent(classTeacher8)
                    .addComponent(classCode8))
                .addContainerGap(170, Short.MAX_VALUE))
        );
        blockBPanel1Layout.setVerticalGroup(
            blockBPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(blockBPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(classCode8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(classTeacher8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(classRoomNum8)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        blockBPanel.setBackground(new java.awt.Color(255, 255, 255));
        blockBPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        blockBPanel.setPreferredSize(new java.awt.Dimension(300, 150));

        classCode1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        classCode1.setText("Class Code");

        classTeacher1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        classTeacher1.setText("Class Teacher");

        classRoomNum1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        classRoomNum1.setText("Class Room #");

        javax.swing.GroupLayout blockBPanelLayout = new javax.swing.GroupLayout(blockBPanel);
        blockBPanel.setLayout(blockBPanelLayout);
        blockBPanelLayout.setHorizontalGroup(
            blockBPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(blockBPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(blockBPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(classRoomNum1)
                    .addComponent(classTeacher1)
                    .addComponent(classCode1))
                .addContainerGap(172, Short.MAX_VALUE))
        );
        blockBPanelLayout.setVerticalGroup(
            blockBPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(blockBPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(classCode1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(classTeacher1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(classRoomNum1)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Day 2 ");
        // display time blocks
        timeText1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        timeText1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeText1.setText("8:55-10:10");

        timeText2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        timeText2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeText2.setText("10:15-11:30");

        timeText3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        timeText3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeText3.setText("12:20-1:35");

        timeText4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        timeText4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeText4.setText("1:40-2:55");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Logo_Small.png"))); // NOI18N
        
        // adding the blocks created to the panel
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(jLabel7)
                .addGap(144, 144, 144)
                .addComponent(titleText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(137, 137, 137)
                .addComponent(jLabel8)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(timeText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dayText, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(blockAPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(blockDPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(blockBPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(blockCPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(timeText1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(timeText2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(timeText3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(timeText4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1))
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(blockAPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(blockDPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(blockCPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(blockBPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(titleText))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(timeText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dayText))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(blockAPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(blockBPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(blockCPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(blockDPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(blockBPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(timeText1)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(blockAPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(timeText2)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(blockDPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(timeText3)
                                .addGap(63, 63, 63)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(timeText4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(blockCPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );

        setSize(new java.awt.Dimension(1000, 849));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // return button to go back to previous page
    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) throws EncryptedDocumentException, IOException {//GEN-FIRST:event_returnButtonActionPerformed
        close();
        MainMenu menu = new MainMenu();
        menu.setVisible(true);
    }//GEN-LAST:event_returnButtonActionPerformed
    // close window button
    public void close(){
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
    /**
     * @param args the command line arguments
     */
    // main program
    public static void main(String args[]) {
        // try and catch for errors of buttons, spreadsheet, and displaying
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SchedulePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SchedulePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SchedulePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SchedulePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SchedulePage("").setVisible(true);
            }
        });
    }

    // Variables declaration
    private javax.swing.JPanel blockAPanel;
    private javax.swing.JPanel blockAPanel1;
    private javax.swing.JPanel blockBPanel;
    private javax.swing.JPanel blockBPanel1;
    private javax.swing.JPanel blockCPanel;
    private javax.swing.JPanel blockCPanel1;
    private javax.swing.JPanel blockDPanel;
    private javax.swing.JPanel blockDPanel1;
    private javax.swing.JLabel classCode1;
    private javax.swing.JLabel classCode2;
    private javax.swing.JLabel classCode3;
    private javax.swing.JLabel classCode5;
    private javax.swing.JLabel classCode6;
    private javax.swing.JLabel classCode7;
    private javax.swing.JLabel classCode8;
    private javax.swing.JLabel classCode9;
    private javax.swing.JLabel classRoomNum1;
    private javax.swing.JLabel classRoomNum2;
    private javax.swing.JLabel classRoomNum3;
    private javax.swing.JLabel classRoomNum5;
    private javax.swing.JLabel classRoomNum6;
    private javax.swing.JLabel classRoomNum7;
    private javax.swing.JLabel classRoomNum8;
    private javax.swing.JLabel classRoomNum9;
    private javax.swing.JLabel classTeacher1;
    private javax.swing.JLabel classTeacher2;
    private javax.swing.JLabel classTeacher3;
    private javax.swing.JLabel classTeacher5;
    private javax.swing.JLabel classTeacher6;
    private javax.swing.JLabel classTeacher7;
    private javax.swing.JLabel classTeacher8;
    private javax.swing.JLabel classTeacher9;
    private javax.swing.JLabel dayText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton returnButton;
    private javax.swing.JLabel timeText;
    private javax.swing.JLabel timeText1;
    private javax.swing.JLabel timeText2;
    private javax.swing.JLabel timeText3;
    private javax.swing.JLabel timeText4;
    private javax.swing.JLabel titleText;

    // to update the time accordingly
    @Override
    public void run() {
        while(true){
            LocalTime currentTime = LocalTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a", Locale.ENGLISH);
            String formattedTime = currentTime.format(formatter);
            timeText.setText(formattedTime.toUpperCase());
        }
    }
}
