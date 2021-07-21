/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package utcn.repoviewer;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

/**
 *
 * @author ocuibus
 */
public class MainWindow extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public MainWindow() {
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

        tabbedPaneOptions = new javax.swing.JTabbedPane();
        panelChooseFolder = new javax.swing.JPanel();
        textFieldRootFolder = new javax.swing.JTextField();
        labelCurrentFolder = new javax.swing.JLabel();
        buttonChooseRootFolder = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListStudents = new javax.swing.JList<>();
        textFieldSearchFilter = new javax.swing.JTextField();
        jLabelClearSelection = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaEmailBody = new javax.swing.JTextArea();
        buttonSendAllEmails = new javax.swing.JButton();
        buttonSendEmail = new javax.swing.JButton();
        jLabelEmailBody = new javax.swing.JLabel();
        panelView = new javax.swing.JPanel();
        scrollPaneFolderSelect = new javax.swing.JScrollPane();
        treeFolders = new javax.swing.JTree();
        panelViewCode = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Repo Viewer");

        tabbedPaneOptions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabbedPaneOptionsMouseClicked(evt);
            }
        });

        textFieldRootFolder.setEditable(false);
        textFieldRootFolder.setText("select folder");
        textFieldRootFolder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textFieldRootFolderMouseClicked(evt);
            }
        });

        labelCurrentFolder.setText("current folder");

        buttonChooseRootFolder.setText("...");
        buttonChooseRootFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonChooseRootFolderActionPerformed(evt);
            }
        });

        jListStudents.setModel(studentsList);
        jListStudents.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListStudentsValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(jListStudents);

        textFieldSearchFilter.setText("Search...");
        textFieldSearchFilter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textFieldSearchFilterMouseClicked(evt);
            }
        });
        textFieldSearchFilter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textFieldSearchFilterKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldSearchFilterKeyReleased(evt);
            }
        });

        jLabelClearSelection.setForeground(new java.awt.Color(0, 0, 204));
        jLabelClearSelection.setText("Clear Selection");
        jLabelClearSelection.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelClearSelection.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelClearSelectionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelClearSelectionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelClearSelectionMouseExited(evt);
            }
        });

        jTextAreaEmailBody.setColumns(20);
        jTextAreaEmailBody.setRows(5);
        jScrollPane3.setViewportView(jTextAreaEmailBody);
        jTextAreaEmailBody.getAccessibleContext().setAccessibleName("");
        jTextAreaEmailBody.getAccessibleContext().setAccessibleDescription("");

        buttonSendAllEmails.setText("send all emails");
        buttonSendAllEmails.setEnabled(false);
        buttonSendAllEmails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSendAllEmailsActionPerformed(evt);
            }
        });

        buttonSendEmail.setText("send email");
        buttonSendEmail.setEnabled(false);
        buttonSendEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSendEmailActionPerformed(evt);
            }
        });

        jLabelEmailBody.setText("email body :");

        javax.swing.GroupLayout panelChooseFolderLayout = new javax.swing.GroupLayout(panelChooseFolder);
        panelChooseFolder.setLayout(panelChooseFolderLayout);
        panelChooseFolderLayout.setHorizontalGroup(
            panelChooseFolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelChooseFolderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelChooseFolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelChooseFolderLayout.createSequentialGroup()
                        .addComponent(labelCurrentFolder)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textFieldRootFolder, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonChooseRootFolder, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(textFieldSearchFilter, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelChooseFolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelChooseFolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabelClearSelection)
                        .addGroup(panelChooseFolderLayout.createSequentialGroup()
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(panelChooseFolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(buttonSendAllEmails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonSendEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jLabelEmailBody))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelChooseFolderLayout.setVerticalGroup(
            panelChooseFolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelChooseFolderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelChooseFolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelChooseFolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonChooseRootFolder, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelClearSelection))
                    .addGroup(panelChooseFolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelCurrentFolder)
                        .addComponent(textFieldRootFolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addGroup(panelChooseFolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textFieldSearchFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEmailBody))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelChooseFolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                    .addGroup(panelChooseFolderLayout.createSequentialGroup()
                        .addGroup(panelChooseFolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(panelChooseFolderLayout.createSequentialGroup()
                                .addComponent(buttonSendAllEmails)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonSendEmail))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(0, 91, Short.MAX_VALUE))
        );

        textFieldRootFolder.getAccessibleContext().setAccessibleName("");
        labelCurrentFolder.getAccessibleContext().setAccessibleName("labelFolder");
        buttonChooseRootFolder.getAccessibleContext().setAccessibleName("buttonChooseFolder");

        tabbedPaneOptions.addTab("choose folder", panelChooseFolder);

        panelView.setLayout(new java.awt.BorderLayout());

        treeFolders.setModel(treeModelFoldersStructure);
        treeFolders.setRootVisible(false);
        treeFolders.addTreeExpansionListener(new javax.swing.event.TreeExpansionListener() {
            public void treeCollapsed(javax.swing.event.TreeExpansionEvent evt) {
                treeFoldersTreeCollapsed(evt);
            }
            public void treeExpanded(javax.swing.event.TreeExpansionEvent evt) {
                treeFoldersTreeExpanded(evt);
            }
        });
        treeFolders.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                treeFoldersValueChanged(evt);
            }
        });
        scrollPaneFolderSelect.setViewportView(treeFolders);

        panelView.add(scrollPaneFolderSelect, java.awt.BorderLayout.WEST);

        panelViewCode.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout panelViewCodeLayout = new javax.swing.GroupLayout(panelViewCode);
        panelViewCode.setLayout(panelViewCodeLayout);
        panelViewCodeLayout.setHorizontalGroup(
            panelViewCodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 677, Short.MAX_VALUE)
        );
        panelViewCodeLayout.setVerticalGroup(
            panelViewCodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelView.add(panelViewCode, java.awt.BorderLayout.CENTER);

        tabbedPaneOptions.addTab("view", panelView);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPaneOptions)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabbedPaneOptions)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabbedPaneOptionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabbedPaneOptionsMouseClicked
        studentsToView.clear();
        studentsToView.addAll(jListStudents.getSelectedValuesList());
        if (studentsToView.size() > 0) {
            String defaultStudentForFolderStructure = studentsToView.get(0);
            String absolutePathToStudentFolder = getAbsolutePathToStudent(defaultStudentForFolderStructure);
            //System.out.println("this folder was selected" + absolutePathToStudentFolder);
            // TODO: change here to get an "average" of folders structure
            File rootDirectory = new File(absolutePathToStudentFolder);
            treePopulator.populate(rootDirectory); //Here is problem, too many calls -> tree resets after some events
            treeFolders.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        }
    }//GEN-LAST:event_tabbedPaneOptionsMouseClicked

    private void treeFoldersValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_treeFoldersValueChanged
        //System.out.println("this path was selected: " + treeFolders.getSelectionPath());
        panelViewCode.removeAll();
        if (treeFolders.getSelectionPath() != null) {
            Object[] incapsulatedPath = treeFolders.getSelectionPath().getPath();
            String relativePathToFile = incapsulatedPath[1].toString();
            for (int i = 2; i < incapsulatedPath.length; i++) {
               relativePathToFile = Paths.get(relativePathToFile, incapsulatedPath[i].toString()).toString();
            }
            panelViewCode.setLayout(new GridLayout(1, studentsToView.size()));
            // add all fileviews to the panel, but only if selection is a file!
            if (((FileNode) treeFolders.getLastSelectedPathComponent()).isViewableFile) {
                for (String student : studentsToView) {
                    FileView studentFileView = new FileView(student, getAbsolutePathToFile(student, relativePathToFile), studentsToView.size());
                    panelViewCode.add(studentFileView);
                }
            }
        }
        panelViewCode.revalidate();
        panelViewCode.repaint();
    }//GEN-LAST:event_treeFoldersValueChanged

    private void treeFoldersTreeExpanded(javax.swing.event.TreeExpansionEvent evt) {//GEN-FIRST:event_treeFoldersTreeExpanded
        panelView.revalidate();

    }//GEN-LAST:event_treeFoldersTreeExpanded

    private void treeFoldersTreeCollapsed(javax.swing.event.TreeExpansionEvent evt) {//GEN-FIRST:event_treeFoldersTreeCollapsed
        panelView.revalidate();

    }//GEN-LAST:event_treeFoldersTreeCollapsed

    private void jLabelClearSelectionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelClearSelectionMouseExited
        jLabelClearSelection.setText("Clear Selection");
    }//GEN-LAST:event_jLabelClearSelectionMouseExited

    private void jLabelClearSelectionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelClearSelectionMouseEntered
        jLabelClearSelection.setText("<html><a href=''>Clear Selection</a></html>");
    }//GEN-LAST:event_jLabelClearSelectionMouseEntered

    private void jLabelClearSelectionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelClearSelectionMouseClicked
        jListStudents.clearSelection();
    }//GEN-LAST:event_jLabelClearSelectionMouseClicked

    private void textFieldSearchFilterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldSearchFilterKeyReleased
        jListStudents.setModel(studentsList);

        DefaultListModel<String> newModel = new DefaultListModel<>();
        for (int i = 0; i < jListStudents.getModel().getSize(); i++) {
            if (studentsList.get(i).toLowerCase().contains(textFieldSearchFilter.getText().toLowerCase())) {
                newModel.addElement(studentsList.getElementAt(i));
            }
        }
        jListStudents.setModel(newModel);
    }//GEN-LAST:event_textFieldSearchFilterKeyReleased

    private void textFieldSearchFilterKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldSearchFilterKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            textFieldSearchFilter.setText("");
        }
    }//GEN-LAST:event_textFieldSearchFilterKeyPressed

    private void textFieldSearchFilterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textFieldSearchFilterMouseClicked
        if (textFieldSearchFilter.getText().equals("Search...")) {
            textFieldSearchFilter.setText("");
        }
    }//GEN-LAST:event_textFieldSearchFilterMouseClicked

    private void buttonChooseRootFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonChooseRootFolderActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Please choose root folder");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            this.loadStudents(chooser.getSelectedFile());
            textFieldRootFolder.setText(chooser.getSelectedFile().toString());
        }
        jListStudents.setModel(studentsList);
    }//GEN-LAST:event_buttonChooseRootFolderActionPerformed

    private void textFieldRootFolderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textFieldRootFolderMouseClicked
        buttonChooseRootFolderActionPerformed(null);
    }//GEN-LAST:event_textFieldRootFolderMouseClicked

    private void jListStudentsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListStudentsValueChanged
        List<String> strings = jListStudents.getSelectedValuesList();
        if (strings.size() > 1) {
            buttonSendEmail.setEnabled(false);
            buttonSendAllEmails.setEnabled(true);
        } else if (strings.size() == 1) {
            buttonSendEmail.setEnabled(true);
            buttonSendAllEmails.setEnabled(false);
        } else {
            buttonSendEmail.setEnabled(false);
            buttonSendAllEmails.setEnabled(false);
        }
    }//GEN-LAST:event_jListStudentsValueChanged

    private void buttonSendAllEmailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSendAllEmailsActionPerformed
        List<String> selectedStudents = jListStudents.getSelectedValuesList();
        List<String> studentsThatDoNotHaveAFeedbackFile = new ArrayList<>();
        List<String> studentsThatHaveAFeedbackFile = new ArrayList<>();
        for (String student : selectedStudents) {
            if (FeedbackManagement.checkIfStudentHasFeedbackFile(student)) {
                studentsThatHaveAFeedbackFile.add(student);
            } else {
                studentsThatDoNotHaveAFeedbackFile.add(student);
            }
        }
        int result;
        if (studentsThatDoNotHaveAFeedbackFile.isEmpty()) {
            result = JOptionPane.showConfirmDialog(null, "Are you sure you want to send an email to all selected students ?", "SEND MAIL TO ALL SELECTED STUDENTS", JOptionPane.YES_NO_OPTION);
        } else if (studentsThatDoNotHaveAFeedbackFile.size() == selectedStudents.size()) {
            displayOneButtonOptionPane("COULD NOT SEND MAIL TO STUDENTS", "The students you selected do not have a feedback file so they will not receive any mail", "OK");
            result = 10;
        } else {
            String studentsThatNotHaveAFile = "";
            StringBuilder stringBuilder = new StringBuilder(studentsThatNotHaveAFile);
            for (String string : studentsThatDoNotHaveAFeedbackFile) {
                stringBuilder.append("\n" + string);
            }
            result = JOptionPane.showConfirmDialog(null, "Students that do not have a file : " + stringBuilder.toString() + "\n\n These students will not receive this mail.\nDo you want to continue ?", "SEND MAIL TO ALL SELECTED STUDENTS", JOptionPane.YES_NO_OPTION);
        }
        if (result == JOptionPane.YES_OPTION) {
            for (String student : studentsThatHaveAFeedbackFile) {
                try {
                    StudentManager.sendEmail(fromEmail, password, StudentManager.getEmailForRepo(student), jTextAreaEmailBody.getText(), FeedbackManagement.getStudentFilePath(student));
                } catch (MessagingException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
                //System.out.println("Sent email to : " + StudentManager.getEmailForRepo(student) + "\nFrom : " + fromEmail + "\nPassword : " + password + "\nAttachment : " + FeedbackManagement.getStudentFilePath(student) + "\nEmail body : " + jTextAreaEmailBody.getText());
                //System.out.println("Sent email to : " + StudentManager.getEmailForRepo(student) + "\nFrom : " + fromEmail + "\nPassword : " + password + "\nAttachment : " + FeedbackManagement.getStudentFilePath(student) + "\nEmail body : " + jTextAreaEmailBody.getText());
            }
        }
    }//GEN-LAST:event_buttonSendAllEmailsActionPerformed

    private void buttonSendEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSendEmailActionPerformed
        String selectedStudent = jListStudents.getSelectedValuesList().get(0);
        if (!FeedbackManagement.checkIfStudentHasFeedbackFile(selectedStudent)) {
            displayOneButtonOptionPane("SEND MAIL TO " + selectedStudent, "This student does not have a file to be attached to the email.", "OK");
        } else {
            try {
                StudentManager.sendEmail(fromEmail, password, StudentManager.getEmailForRepo(selectedStudent), jTextAreaEmailBody.getText(), FeedbackManagement.getStudentFilePath(selectedStudent));
            } catch (MessagingException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
            //System.out.println("Sent email to : " + StudentManager.getEmailForRepo(selectedStudent) + "\nFrom : " + fromEmail + "\nPassword : " + password + "\nAttachment : " + FeedbackManagement.getStudentFilePath(selectedStudent) + "\nEmail body : " + jTextAreaEmailBody.getText());
            //System.out.println("Sent email to : " + StudentManager.getEmailForRepo(selectedStudent) + "\nFrom : " + fromEmail + "\nPassword : " + password + "\nAttachment : " + FeedbackManagement.getStudentFilePath(selectedStudent) + "\nEmail body : " + jTextAreaEmailBody.getText());
        }
    }//GEN-LAST:event_buttonSendEmailActionPerformed

    private void displayOneButtonOptionPane(String title, String message, String buttonText) {
        Object[] options = {buttonText};
        JOptionPane.showOptionDialog(null, message, title, JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
    }

    private String getAbsolutePathToStudent(String studentName) {
        return Paths.get(textFieldRootFolder.getText(), studentName).toString();
    }

    private String getAbsolutePathToFile(String studentName, String filePath) {
        return Paths.get(textFieldRootFolder.getText(),Paths.get(studentName,filePath).toString()).toString();
    }

    private void loadStudents(File rootFolder) {
        studentsList.clear();
        for (File studentFolder : rootFolder.listFiles()) {
            //TODO: parse student name from folder name
            //TODO: only display folders that match the pattern isp-main-name-surname-group
            if (studentFolder.isDirectory()) {
                studentsList.addElement(studentFolder.getName());
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void openMainWindow() {
        StudentManager studentManager = new StudentManager();
        try {
            studentManager.sendEmail("petru.ciubus@utcluj.didatec.ro", "password", "abc@abc.com", "This is your feedback", null);
        } catch (javax.mail.MessagingException ex) {
            System.err.println("Some problem occured with sending email. Most probably authentication issue. You may not use this feature");
        }
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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonChooseRootFolder;
    private javax.swing.JButton buttonSendAllEmails;
    private javax.swing.JButton buttonSendEmail;
    private javax.swing.JLabel jLabelClearSelection;
    private javax.swing.JLabel jLabelEmailBody;
    private javax.swing.JList<String> jListStudents;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextAreaEmailBody;
    private javax.swing.JLabel labelCurrentFolder;
    private javax.swing.JPanel panelChooseFolder;
    private javax.swing.JPanel panelView;
    private javax.swing.JPanel panelViewCode;
    private javax.swing.JScrollPane scrollPaneFolderSelect;
    private javax.swing.JTabbedPane tabbedPaneOptions;
    private javax.swing.JTextField textFieldRootFolder;
    private javax.swing.JTextField textFieldSearchFilter;
    private javax.swing.JTree treeFolders;
    // End of variables declaration//GEN-END:variables
    private DefaultListModel<String> studentsList = new DefaultListModel<String>();
    private DefaultTreeModel treeModelFoldersStructure = new DefaultTreeModel(null);
    private TreePopulator treePopulator = new TreePopulator(treeModelFoldersStructure);
    private ArrayList<String> studentsToView = new ArrayList<String>();
    private String fromEmail = "";
    private String password = "";
}
