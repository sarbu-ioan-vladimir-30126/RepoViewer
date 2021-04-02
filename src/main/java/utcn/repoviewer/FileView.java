/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utcn.repoviewer;

import java.awt.Component;
import java.awt.GridLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
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
        this.textAreaCode = new JTextArea(getFileContents(pathToFileAbsolute));
        textAreaCode.setAlignmentX( Component.CENTER_ALIGNMENT );
        this.add(textAreaCode);
    }
    
    public String getFileContents(String absolutePath){
        // TODO: implement this
        return "this is an example \n of a file content \n by a certain student \n ......";
    }
    // student name
    // code area
    // thumbsup/thumbsdown buttons
}
