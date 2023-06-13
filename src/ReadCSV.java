import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

class ReadCSV {
    /**
     * Returns an ArrayList of all data in a column of a csv file
     * 
     * @param col the column of the csv file to be stored
     * @param filepath the filepath of the csv file to be read
     * @param delimiter the delimiter used to separate data in the csv file
     * @param numOfColumns the number of columns in the csv file
     * @return
     */
    public static ArrayList<String> readCol(int col, String filepath, String delimiter, int numOfColumns){
        String[] data = new String[numOfColumns];
        String currentLine;
        ArrayList<String> colData = new ArrayList<String>();

        try{
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);

            br.readLine();
            br.readLine();

            while((currentLine = br.readLine()) != null){
                data = currentLine.split(delimiter);

                colData.add(data[col]);
            }

            br.close();
            return colData;
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
}