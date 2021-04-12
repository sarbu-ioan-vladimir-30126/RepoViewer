/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utcn.repoviewer;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.apache.commons.io.FilenameUtils;
import org.fife.ui.rsyntaxtextarea.*;
import org.fife.ui.rtextarea.RTextScrollPane;

/**
 *
 * @author ocuibus
 */
public class FileView extends JPanel {

    String pathToFileAbsolute;
    RSyntaxTextArea textAreaCode;
    JLabel imageArea;
    String fileExtension;

    static String[] allowedImageTypes = new String[]{"jpg", "png"};

    public FileView(String studentName, String pathToFileAbsolute, int numberOfStudents) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel labelStudentName = new JLabel(studentName);
        labelStudentName.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(labelStudentName);
        this.fileExtension = FilenameUtils.getExtension(pathToFileAbsolute);
        this.pathToFileAbsolute = pathToFileAbsolute;

        // MY CODE
        JPanel panelFeedBack = new JPanel();
        panelFeedBack.setLayout(new FlowLayout());

        JButton buttonGood = createButton("", Color.decode("#52b788"), new ImageIcon("D:\\RepoViewer\\RepoViewer\\src\\res\\like.png"), "goodButton" + studentName, goodButtonActionListener(studentName));
        JButton buttonAverage = createButton("", Color.decode("#ffd819"), new ImageIcon("D:\\RepoViewer\\RepoViewer\\src\\res\\remove.png"), "averageButton" + studentName, averageButtonActionListener(studentName));
        JButton buttonWrong = createButton("", Color.decode("#ef233c"), new ImageIcon("D:\\RepoViewer\\RepoViewer\\src\\res\\dislike.png"), "wrongButton" + studentName, wrongButtonActionListener(studentName));

        panelFeedBack.add(buttonGood);
        panelFeedBack.add(buttonAverage);
        panelFeedBack.add(buttonWrong);

        this.add(panelFeedBack);

        /////////
        if (isImage(fileExtension)) {

            this.imageArea = new JLabel();
            System.out.println(pathToFileAbsolute);
            Image image = getImage(pathToFileAbsolute);
            int height = (image.getHeight(this)) / numberOfStudents;
            int width = (image.getWidth(this)) / numberOfStudents;
            Icon icon = new ImageIcon(image.getScaledInstance(width, height, (java.awt.Image.SCALE_SMOOTH)));
            imageArea.setIcon(icon);
            imageArea.setAlignmentX(Component.CENTER_ALIGNMENT);
            this.add(imageArea);

        } else {
            String fileContent = getFileContents(pathToFileAbsolute);
            this.textAreaCode = new RSyntaxTextArea(fileContent);
            RTextScrollPane sp = new RTextScrollPane(textAreaCode);  //for scroll
            textAreaCode.setAlignmentX(Component.CENTER_ALIGNMENT);
            if (fileContent.isEmpty()) {
                textAreaCode.setEnabled(false);
            }
            customizeCodeFileView();
            //Display the scroll bars only when needed -> It's (more) free real estate
            sp.setHorizontalScrollBarPolicy(RTextScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            sp.setVerticalScrollBarPolicy(RTextScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

            this.add(sp);
        }

    }

    public void customizeCodeFileView() {
        if (fileExtension.equals("java")) {  //check if the file is .java
            textAreaCode.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA); //set style java
        } else if (fileExtension.equals("xml")) { //if is .xml
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

    public String getFileContents(String absolutePath) {
        String fileContent = "";
        try {
            File fileToRead = new File(absolutePath);
            Scanner fileScanner;
            fileScanner = new Scanner(fileToRead);
            while (fileScanner.hasNextLine()) {
                fileContent += fileScanner.nextLine() + "\n";
            }
            fileScanner.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileView.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fileContent;
    }

    public Image getImage(String absolutePath) {
        File f = new File(absolutePath);
        BufferedImage image = null;
        try {
            image = ImageIO.read(f);
        } catch (IOException ex) {
            Logger.getLogger(FileView.class.getName()).log(Level.SEVERE, null, ex);
        }
        return image;
    }

    private boolean isImage(String path) {
        boolean isImage = false;
        for (String types : allowedImageTypes) {
            if (path.equals(types)) {
                isImage = true;
            }
        }
        return isImage;
    }

    public ActionListener goodButtonActionListener(String studentName) {

        ActionListener buttonActionListener = (ActionEvent e) -> {
            CharSequence evaluatedFilePath = FeedbackManagement.getEvaluatedFilePath(pathToFileAbsolute);
            FeedbackManagement.createAndWriteFile(studentName, evaluatedFilePath + " - GOOD");
        };
        return buttonActionListener;
    }

    public ActionListener averageButtonActionListener(String studentName) {

        ActionListener buttonActionListener = (ActionEvent e) -> {
            CharSequence evaluatedFilePath = FeedbackManagement.getEvaluatedFilePath(pathToFileAbsolute);
            FeedbackManagement.createAndWriteFile(studentName, evaluatedFilePath + " - AVERAGE");
        };

        return buttonActionListener;
    }

    public ActionListener wrongButtonActionListener(String studentName) {

        ActionListener buttonActionListener = (ActionEvent e) -> {
            CharSequence evaluatedFilePath = FeedbackManagement.getEvaluatedFilePath(pathToFileAbsolute);
            FeedbackManagement.createAndWriteFile(studentName, evaluatedFilePath + " - WRONG");
        };

        return buttonActionListener;
    }

    public JButton createButton(String buttonText, Color color, ImageIcon image, String buttonName, ActionListener action) {
        JButton button = new JButton(buttonText, image);
        button.setBackground(color);
        button.setName(buttonName);
        button.addActionListener(action);
        return button;
    }

    // student name
    // code area
    // thumbsup/thumbsdown buttons
}
