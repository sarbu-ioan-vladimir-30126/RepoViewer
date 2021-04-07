/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utcn.repoviewer;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.fife.ui.rsyntaxtextarea.*;
import org.fife.ui.rtextarea.RTextScrollPane;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author ocuibus
 */
public class FileView extends JPanel{
    String pathToFileAbsolute;
    RSyntaxTextArea textAreaCode;
    String fileExtension;
    
    public FileView(String studentName, String pathToFileAbsolute){
        this.setLayout(new BoxLayout (this, BoxLayout.Y_AXIS));
        JLabel labelStudentName = new JLabel(studentName);
        labelStudentName.setAlignmentX( Component.CENTER_ALIGNMENT );
        this.add(labelStudentName);
        this.fileExtension = FilenameUtils.getExtension(pathToFileAbsolute);
        this.pathToFileAbsolute = pathToFileAbsolute;
        String fileContent = getFileContents(pathToFileAbsolute);
        this.textAreaCode = new RSyntaxTextArea(fileContent);
        RTextScrollPane sp = new RTextScrollPane(textAreaCode);  //for scroll
        textAreaCode.setAlignmentX( Component.CENTER_ALIGNMENT );
        if (fileContent.isEmpty()){
            textAreaCode.setEnabled(false);
        }
        customizeFileView();
        this.add(sp);
}
    public void customizeFileView(){
        if(fileExtension.equals("java]")){  //check if the file is .java
            textAreaCode.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA); //set style java
        }
        else if(fileExtension.equals("xml]")){ //if is .xml
            textAreaCode.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_XML);  //set style xml
        }
        textAreaCode.setAnimateBracketMatching(true); 
        textAreaCode.setAntiAliasingEnabled(true);
        textAreaCode.setCodeFoldingEnabled(true);
        textAreaCode.setMarkOccurrences(true);
        textAreaCode.setAutoIndentEnabled(true);
        textAreaCode.setEditable(false);
        textAreaCode.setFont(new Font("Consolas", Font.PLAIN, 13)); //set font style: Consolas, plain, size 13
    }
    
    public String getFileContents(String absolutePath){
        String fileContent = "";
        try {
            File fileToRead = new File(absolutePath);
            Scanner fileScanner;
            fileScanner = new Scanner(fileToRead);
            while(fileScanner.hasNextLine()){
                fileContent += fileScanner.nextLine() + "\n";
            }
            fileScanner.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileView.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fileContent;
    }
    // student name
    // code area
    // thumbsup/thumbsdown buttons
}
