package raj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Raj Sachdev
 */
public class SwingFileReader {

    /**
     * Reads the latestSwing.csv file into the data structure.
     *
     * @param filePath
     * @return SwingData (all the data is stored in this structure).
     */
    public static SwingData readSwingFile(String filePath) {
        SwingData data = new SwingData();
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
            String line;
            String tokens[];
            while ((line = br.readLine()) != null) {
                tokens = line.split(",");
                data.insertEntry(Long.parseLong(tokens[0]), Double.parseDouble(tokens[1]),
                        Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]), Double.parseDouble(tokens[4]), 
                                Double.parseDouble(tokens[5]), Double.parseDouble(tokens[6]));
            }
        } catch (IOException ex) {
            System.out.println("Exception occured while reading the file"+ex);
        }
        return data;
    }

}
