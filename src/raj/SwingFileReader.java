package raj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Raj Sachdev
 */
public class SwingFileReader {
    
    /**
     * Reads the latestSwing.csv file into the data structure.
     * @param filePath
     * @return SwingData (all the data is stored in this structure).
     */
    public static SwingData readSwingFile(String filePath) {
        SwingData data = new SwingData();
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
            String line;
            String tokens[];
            while((line = br.readLine())!= null) {
                tokens = line.split(",");
                data.insertEntry(Double.parseDouble(tokens[0]), Double.parseDouble(tokens[1]),
                        Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]), Double.parseDouble(tokens[4]), 
                                Double.parseDouble(tokens[5]), Double.parseDouble(tokens[6]));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SwingFileReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SwingFileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
}
