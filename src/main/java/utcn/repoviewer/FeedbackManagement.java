package utcn.repoviewer;

import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Ovidiu Ceoca
 */
public class FeedbackManagement {

    private static final String studentsFilesDirectoryPath = "src\\main\\students files";

    public static String getDataFromFile(String studentName) {
        try {
            return Files.readString(Paths.get(getStudentFilePath(studentName)), StandardCharsets.US_ASCII);
        } catch (IOException ex) {
            System.out.println("Could not create the message for the file");
            return null;
        }
    }

    public static void appendLineToFileForStudent(String studentName, String message) {
        File fileObject = new File(getStudentFilePath(studentName));
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

    public static String getStudentFilePath(String studentName) {
        return studentsFilesDirectoryPath + "\\" + getFilenameForStudent(studentName);
    }

    public static String getFilenameForStudent(String studentName) {
        return studentName + ".txt";
    }

    public static List<File> getAllTxtFeedbackFiles() {
        FilenameFilter textFilter = (File dir, String fileName) -> fileName.toLowerCase().endsWith(".txt");
        File[] files = new File(studentsFilesDirectoryPath).listFiles(textFilter);
        return Arrays.asList(files);
    }

    public static boolean checkIfStudentHasFeedbackFile(String studentName) {
        for (File file : getAllTxtFeedbackFiles()) {
            if (file.getName().equals(getFilenameForStudent(studentName))) {
                return true;
            }
        }
        return false;
    }

}
