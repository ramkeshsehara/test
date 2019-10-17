package testing;

import com.opencsv.CSVReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Market {
    private static final String SAMPLE_CSV_FILE_PATH = "/home/ramkeshmeena/Downloads/data2013-2019.csv";

    public static void main(String[] args) throws IOException {
        try (
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            CSVReader csvReader = new CSVReader(reader);
        ) {
            String[] nextRecord;
            int count=0;
            int bearish=0;
            int bullish=0;
            
            while ((nextRecord = csvReader.readNext()) != null) {
            	if(count>0) { 
                    String input_date=nextRecord[0];
                    SimpleDateFormat format1=new SimpleDateFormat("dd-MMM-yyyy");
                    Date dt1 = null;
            		try {
            			dt1 = format1.parse(input_date);
            			Calendar c = Calendar.getInstance();
            			c.setTime(dt1);
            			int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
            			if(dayOfWeek==6){
            				int open = (int) Float.parseFloat(nextRecord[1]);
            				int close = (int) Float.parseFloat(nextRecord[4]);
            				if(open-close>0){
            					bearish++;
            				}else {
            					bullish++;
            				}
            			}
            			
            		} catch (ParseException e) {
            			e.printStackTrace();
            		}
            		
            	}
            	count++;
            }
        
            System.out.println("Count " + count);
            float bep=((float)bearish/((float)bearish+(float)bullish))*100;
            float bup=((float)bullish/((float)bearish+(float)bullish))*100;
            System.out.println("Market Bearish : " + bearish + " Percentage: " + bep);
            System.out.println("Market Bullish : " + bullish + " Percentage: " + bup);   
        }
    }
}