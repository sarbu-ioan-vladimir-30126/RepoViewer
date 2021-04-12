package utcn.repoviewer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;

/**
 *
 * @author Ovidiu Ceoca
 */
public class FeedbackManagement {

    private static List<JButton> goodButtonsList = new ArrayList<>();
    private static List<JButton> averageButtonsList = new ArrayList<>();
    private static List<JButton> wrongButtonsList = new ArrayList<>();
    private static List<JButton> emailButtonsList = new ArrayList<>();

    public void addButton(FeedbackEnum type, JButton button) {
        switch (type) {
            case GOOD:
                goodButtonsList.add(button);
                break;
            case AVERAGE:
                averageButtonsList.add(button);
                break;
            case WRONG:
                wrongButtonsList.add(button);
                break;
            default:
                System.out.println("The type you entered is not recognised");
                break;
        }
    }

    public static void createFile(String studentName) {
        String fileName = studentName + ".txt";
        File fileObject = new File(fileName);
        try {
            if (fileObject.createNewFile()) {
                System.out.println("File created for student : " + fileObject.getName().substring(0, fileObject.getName().length() - 4));
            } else {
                System.out.println("The file already exist for student : " + fileObject.getName().substring(0, fileObject.getName().length() - 4));
            }
        } catch (IOException ex) {
            System.out.println("The file could not be created");
        }
    }

    public static String getDataFromFile(String studentName) {

        String fileName = studentName + ".txt";

        try {
            return Files.readString(Paths.get(fileName), StandardCharsets.US_ASCII);
        } catch (IOException ex) {
            System.out.println("Could not create the message for the file");
            return null;
        }

    }

    public static void writeToFile(String studentName, String currentData, String message) {

        String fileName = studentName + ".txt";
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            String messageToWrite = currentData + "\n" + message;
            fileWriter.write(messageToWrite);
            fileWriter.close();
        } catch (IOException ex) {
            System.out.println("The message could not be written to file");
        }

    }

    public static void createAndWriteFile(String studentName, String message) {

        FeedbackManagement.createFile(studentName);
        String currentData = FeedbackManagement.getDataFromFile(studentName);
        FeedbackManagement.writeToFile(studentName, currentData, message);

    }

    public static CharSequence getEvaluatedFilePath(String baseString) {

        int position = 0;
        for (int i = 1; i <= 14; i++) {
            if (baseString.contains("isp-lab-" + i + "-master")) {
                position = baseString.indexOf("isp-lab-" + i + "-master");
            }
        }

        return baseString.subSequence(position, baseString.length());

    }

    public static List<JButton> getGoodButtonsList() {
        return goodButtonsList;
    }

    public static List<JButton> getAverageButtonsList() {
        return averageButtonsList;
    }

    public static List<JButton> getWrongButtonsList() {
        return wrongButtonsList;
    }

    public static List<JButton> getEmailButtonsList() {
        return emailButtonsList;
    }
}
