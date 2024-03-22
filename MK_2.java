import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class MK_2 {
    
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();

        int returnVal = fileChooser.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                java.io.File selectedFile = fileChooser.getSelectedFile();

                readFromFile(selectedFile.getAbsolutePath());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error reading file: " + e.getMessage());
            }
        } else {
            System.out.println("User canceled file selection");
        }
    }

    public static void readFromFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

}
