package infra;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataManager {

    private static char csvDelimiter = '|';

    private static List<Map<String, String>> testData = new ArrayList<>();

    public static List<Map<String, String>> readCSV(String file) {


        try {
            Reader reader = new InputStreamReader(new FileInputStream(file));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.newFormat(csvDelimiter));
            List<CSVRecord> records = csvParser.getRecords();
            CSVRecord header = records.get(0);
            for (int i = 1; i < records.size(); i++) {
                CSVRecord record = records.get(i);
                Map<String, String> m = new HashMap<>();
                for (int j = 0; j < header.size(); j++) {
                    m.put(header.get(j).trim(), record.get(j).trim());
                }
                testData.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return testData;
    }

    public static List<Map<String, String>> getTestData() {
        return testData;
    }
}
