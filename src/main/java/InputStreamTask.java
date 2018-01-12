import java.io.*;
import java.nio.charset.Charset;

import org.apache.commons.io.input.ReversedLinesFileReader;
public class InputStreamTask {

    public static void main(String[] args) throws IOException {
        File source = new File("C:\\Users\\Evgeniia_Ershova\\homework2\\ten-strings");
        File target = new File("C:\\Users\\Evgeniia_Ershova\\homework2\\ten-strings-output");

//        BufferedReader reader = new BufferedReader(new InputStreamReader(new ReverseLineInputStream(source)));

      ReversedLinesFileReader reader = new ReversedLinesFileReader(source, Charset.defaultCharset());

      BufferedWriter outputStream = new BufferedWriter(new FileWriter(target));
        while(true) {
            String line = reader.readLine();
            if (line == null) {
                break;
            }
            outputStream.write(line);
            outputStream.write("\n");
        }
        reader.close();
        outputStream.close();

    }


}
