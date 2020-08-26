package com.test.learn;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FindStatementsInFile {

    public static void main(String[] args) throws Exception{

        File outFile = new File("/Users/harikrishnarudra/Downloads/PriceSetup/queries_log_remove_duplicates.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outFile));

        List<String> statementsList = new ArrayList<String>();

        File file = new File("/Users/harikrishnarudra/Downloads/PriceSetup/log_bdds_full.log");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String statement = null;
        while ((statement = bufferedReader.readLine()) != null){
            String fetchStatement = fetchSelectQuery(statement);
            if (isNotADuplicate(fetchStatement,statementsList)){
                statementsList.add(statement);
                bufferedWriter.write(statement);
                bufferedWriter.newLine();
            }
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static String fetchSelectQuery(String statement){
        String fromSelect = "";
        if (statement!=null && statement.contains("Executing N1QL query")) {
            String upperCase = statement.toUpperCase();
            fromSelect = upperCase.substring(upperCase.indexOf("SELECT"));
        }
        return fromSelect;
    }

    private static boolean isNotADuplicate(String statement, List<String> statementList){
        if (statement!=null){
            if (statementList!=null && statementList.contains(statement)){
                return false;
            }
        }
        return true;
    }
}
