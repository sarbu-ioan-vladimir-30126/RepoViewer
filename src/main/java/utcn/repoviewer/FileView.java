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
import java.util.ArrayList;
import java.util.Scanner;
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
        this.textAreaCode = new RSyntaxTextArea(getFileContents(pathToFileAbsolute));
        customizeFileView();
        RTextScrollPane sp = new RTextScrollPane(textAreaCode);  //for scroll
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
        textAreaCode.setFont(new Font("Consolas", Font.PLAIN, 13)); //set font style: Consolas, plain, size 13
    }
    
    public String getFileContents(String absolutePath){
        // TODO: implement this
        return "package isp.lab3.exercise3;\n" +
"import java.util.Objects;\n" +
"\n" +
"public class Vehicle {\n" +
"    private String model, type;\n" +
"    private int speed;\n" +
"    private char fuelType = 'D';\n" +
"    static int count = 0;\n" +
"//    {\n" +
"//        count += 1;\n" +
"//    }\n" +
"    \n" +
"    public Vehicle(String model, String type, int speed, char ft){\n" +
"        count++;\n" +
"        this.model = model;\n" +
"        this.type = type;\n" +
"        this.speed = speed;\n" +
"        this.fuelType = ft;\n" +
"    }\n" +
"    public void setModel(String model) {\n" +
"        this.model = model;\n" +
"    }\n" +
"    public void setType(String type){\n" +
"        this.type = type;\n" +
"    }\n" +
"    public void setSpeed(int speed){\n" +
"        this.speed = speed;\n" +
"    }\n" +
"    public void setFuelType(char ft){\n" +
"        this.fuelType = ft;\n" +
"    }\n" +
"    public String getModel(){\n" +
"        return this.model;\n" +
"    }\n" +
"    public String getType(){\n" +
"        return this.type;\n" +
"    }\n" +
"    public int getSpeed(){\n" +
"        return this.speed;\n" +
"    }\n" +
"    public char getFuelType(){\n" +
"        return this.fuelType;\n" +
"    }\n" +
"    public String toString(){\n" +
"        return this.model + \" (\" + this.type + \") speed \" + this.speed+\"\" +  \" fuel type \" + this.fuelType+\"\";\n" +
"    }\n" +
"            \n" +
"    public boolean equals(Vehicle v){\n" +
"        Vehicle other = (Vehicle)v;\n" +
"        return (other.model.equals(this.model) && other.type.equals(this.type) && this.speed == other.speed && this.fuelType == other.fuelType);\n" +
"    }\n" +
"    public static void DisplayNoObjects(){\n" +
"        System.out.println(\"Number of objects in main: \" + Vehicle.count);\n" +
"    }\n" +
"    \n" +
"    \n" +
"    public static void main(String[] args){\n" +
"        Vehicle v1 = new Vehicle(\"Dacia\", \"Loga\", 150, 'B');\n" +
"        Vehicle v2 = new Vehicle(\"abbn\", \"nm\", 3022, 'A');\n" +
"        v2.setModel(\"ab\");\n" +
"        v2.setType(\"mm\");\n" +
"        v2.setSpeed(12);\n" +
"        v2.setFuelType('T');\n" +
"//        v1.setModel(\"ab\");\n" +
"//        v1.setType(\"mm\");\n" +
"//        v1.setSpeed(12);\n" +
"//        v1.setFuelType('T');\n" +
"        System.out.println(\"V1=> model: \" + v1.getModel() + \", type: \" + v1.getType() + \", speed: \" + v1.getSpeed() + \", fuelType: \" + v1.getFuelType());\n" +
"        System.out.println(\"V2=> model: \" + v2.getModel() + \", type: \" + v2.getType() + \", speed: \" + v2.getSpeed() + \", fuelType: \" + v2.getFuelType());\n" +
"        if(v1.equals(v2)){ \n" +
"            System.out.println(\"Equals\");\n" +
"         }else{\n" +
"            System.out.println(\"Not equals\");\n" +
"        }\n" +
"        //System.out.println(v1);\n" +
"        DisplayNoObjects();\n" +
"        \n" +
"    }\n" +
"}";
    }
    // student name
    // code area
    // thumbsup/thumbsdown buttons
}
