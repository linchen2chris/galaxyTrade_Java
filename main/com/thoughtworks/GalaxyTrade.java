package main.com.thoughtworks;

import main.com.thoughtworks.exception.InputException;

import java.io.*;
/**
 * Created by chris on 15-8-9.
 */
public class GalaxyTrade {

    public String processLine(String line) throws InputException {
        Parser parser;
        if (line.matches("\\w+ is [IVXLCDM]{1}")) {
            parser = new MappingParser();
        } else if ( line.matches("[a-zA-Z ]+ is \\d+ Credits$")) {
            parser = new GoodsInfoParser();
        } else if (line.matches("^how much is [a-zA-Z ]+ \\?$")) {
            parser = new NumberQuestionParser();
        } else if (line.matches("^how many Credits is [a-zA-Z ]+ \\?$")) {
            parser = new PriceQuestionParser();
        } else {
            return "I have no idea what you are talking about\n";
        }
        return parser.parse(line);
    }

    public void processFile(String inputFileName, String outputFileName) throws IOException {
        BufferedReader br = null;
        BufferedWriter bw = null;
        String line = "";
        String answer = "";
        try {
            br = new BufferedReader(new FileReader(inputFileName));
            bw = new BufferedWriter(new FileWriter(outputFileName));
            int lineNo = 0;
            while ((line = br.readLine()) != null) {
                lineNo++;
                System.out.println(lineNo + ": " + line);
                try {
                    answer = processLine(line);
                } catch (InputException e) {
                    answer = "Input Errors in "+ lineNo +": " + e.getMessage() +"\n";
                }
                bw.write(answer);
            }
        } catch(IOException e){
            e.getMessage();
        } finally {
            try {
                br.close();
                bw.close();
            }catch (IOException e){
                e.getMessage();
            }
        }
    }
    public static void main(String[] argv) throws IOException {
        GalaxyTrade galaxyTrade = new GalaxyTrade();
        galaxyTrade.processFile(argv[0], argv[1]); //the argv[0] is the input file argv[1] is the output file.
    }
}
