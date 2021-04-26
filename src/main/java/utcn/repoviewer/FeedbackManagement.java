package utcn.repoviewer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author Ovidiu Ceoca
 */
public class FeedbackManagement {

    public static String getDataFromFile(String studentName) {
        String fileName = studentName + ".txt";
        try {
            return Files.readString(Paths.get("src\\main\\students files\\" + fileName), StandardCharsets.US_ASCII);
        } catch (IOException ex) {
            System.out.println("Could not create the message for the file");
            return null;
        }
    }

    public static void appendLineToFileForStudent(String studentName, String message) {
        String fileName = studentName + ".txt";
        File fileObject = new File("src\\main\\students files\\" + fileName);
        try {
            FileWriter fileWriter = new FileWriter(fileObject, true);
            fileObject.createNewFile();
            fileWriter.append("\n" + message);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException ex) {
            System.out.println("The file could not be created");
        }
    }

    public static CharSequence getEvaluatedFilePath(String baseString, String studentName) {
        CharSequence group = studentName.subSequence(studentName.length() - 5, studentName.length());
        int position = baseString.indexOf(group.toString());
        return baseString.subSequence(position + 6, baseString.length());
    }
}
