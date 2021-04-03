/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utcn.repoviewer;

import java.awt.Component;
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
import javax.swing.JTextArea;

/**
 *
 * @author ocuibus
 */
public class FileView extends JPanel{
    String pathToFileAbsolute;
    JTextArea textAreaCode;
    public FileView(String studentName, String pathToFileAbsolute){
        this.setLayout(new BoxLayout (this, BoxLayout.Y_AXIS));
        JLabel labelStudentName = new JLabel(studentName);
        labelStudentName.setAlignmentX( Component.CENTER_ALIGNMENT );
        this.add(labelStudentName);
        
        this.pathToFileAbsolute = pathToFileAbsolute;
        String fileContent = getFileContents(pathToFileAbsolute);
        this.textAreaCode = new JTextArea(fileContent);
        textAreaCode.setAlignmentX( Component.CENTER_ALIGNMENT );
        if (fileContent.isEmpty()){
            textAreaCode.setEnabled(false);
        }
        this.add(textAreaCode);
    }
    
    public String modifyPath(String absolutePath){
        
        //The part to be corrected starts at \[ ...
        int indexOfFirstElelement = absolutePath.indexOf('[');
        String partOfPathToModify = absolutePath.substring(indexOfFirstElelement);
        absolutePath = absolutePath.replace(partOfPathToModify, "");
        
        //Delete not needed part of the path.
        int indexToDelete = partOfPathToModify.indexOf(", ");
        partOfPathToModify = partOfPathToModify.substring(indexToDelete + "' ".length());
        
        //Correct path so File and Scanner classes can reach the specific file.
        partOfPathToModify = partOfPathToModify.replace(", ", "\\");
        partOfPathToModify = partOfPathToModify.replace(" / ", "\\");
        partOfPathToModify = partOfPathToModify.replace("]", "");
        
        //Add correct path to absolutePath
        absolutePath += partOfPathToModify;

        return absolutePath;
    }
    public String getFileContents(String absolutePath){

        String fileContent = "";
        absolutePath = modifyPath(absolutePath);
                   
        try {
            File fileToRead = new File(absolutePath);
            Scanner fileScanner;
            fileScanner = new Scanner(fileToRead);
            while(fileScanner.hasNextLine()){
                fileContent += fileScanner.nextLine() + "\n";
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileView.class.getName()).log(Level.SEVERE, null, ex);
        }

        return fileContent;
    }
    // student name
    // code area
    // thumbsup/thumbsdown buttons
}
