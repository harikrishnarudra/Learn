package Interviews.Twillio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GetRequestsForGIFImages {

    private static final Scanner scan = new Scanner(System.in);

    public static void processLogsOfFile(String fileName) throws Exception{
        try{
            String outFileName = "gifs_"+"hosts_access_log_00.txt";
            File file = new File("/Users/harikrishnarudra/IdeaProjects/Learn/src/Interviews.Twillio/hosts_access_log_00.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outFileName));

            String logLine;
            while ((logLine = bufferedReader.readLine()) != null) {
                String out = processLine(logLine);
                if(out!="") {
                    bufferedWriter.write(out);
                }
            }
            bufferedWriter.flush();
            bufferedReader.close();
            bufferedWriter.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }

    public static String processLine(String line) {
        String[] words = line.split(" ");
        if(words[5].contains("GET") && words[8].equals("200")) {
            String fullGifName = words[6];
            String gifName = fullGifName.substring(fullGifName.lastIndexOf("/")+1);
            if(gifName!=null && gifName.toLowerCase().endsWith(".gif")){
                return gifName;
            }
        }
        return "";
    }

    public static void main(String args[]) throws Exception {
        // read the string filename
        String filename="/Users/harikrishnarudra/IdeaProjects/Learn/src/Interviews.Twillio/hosts_access_log_00.txt";
//        filename = scan.nextLine();
        processLogsOfFile(filename);
        /*System.out.println(processLine("unicomp6.unicomp.net - - [01/Jul/1995:00:00:06 -0400] \"GET /shuttle/countdown/ HTTP/1.0\" 200 3985"));
        System.out.println(processLine("burger.letters.com - - [01/Jul/1995:00:00:11 -0400] \"GET /shuttle/countdown/liftoff.html HTTP/1.0\" 304 0"));
        System.out.println(processLine("burger.letters.com - - [01/Jul/1995:00:00:11 -0400] \"GET /shuttle/countdown/liftoff.html HTTP/1.0\" 200 0"));
        System.out.println(processLine("burger.letters.com - - [01/Jul/1995:00:00:11 -0400] \"GET /shuttle/countdown/liftoff.gif HTTP/1.0\" 200 0"));
        System.out.println(processLine("burger.letters.com - - [01/Jul/1995:00:00:11 -0400] \"GET /shuttle/countdown/ HTTP/1.0\" 200 0"));*/
    }
}
