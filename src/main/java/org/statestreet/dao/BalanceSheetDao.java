package org.statestreet.dao;

import org.statestreet.util.ExtractImage;
import org.statestreet.util.FolderUtil;
import org.statestreet.util.WaitUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BalanceSheetDao {

    public static void insertDataInDb(String imagePath, String textPath) throws SQLException {

        Map<String, Boolean> imageData = ExtractImage.extractTextFromImage(imagePath, textPath);
        WaitUtil.sleepFor(10000);
        insertProcessDataInDb(imageData);
        System.out.println("Data added in db successfully for Processes....");



        List<String> extractedTextFiles = getAllTextExtractedFileNames(imagePath, textPath);
        for (String textFileName : extractedTextFiles) {
            Map<String, Map<String, String>> balanceSheetData = ExtractImage.readDataFromTextFile(textPath + "\\" + textFileName);
            insertBalanceSheetDataInDb(textFileName.replace("_processed.txt", ".jpg"), balanceSheetData);
        }
        System.out.println("Data added in db successfully for BalanceSheet....");
    }

    private static List<String> getAllImageFileNames(String filePath) {
        List<String> imageFileNames = new ArrayList<>();
        List<String> allFilesInFolder = FolderUtil.getListOfFilesInFolder(filePath);
        if (allFilesInFolder != null) {
            for (String fileName : allFilesInFolder) {
                if (fileName.contains(".jpg"))
                    imageFileNames.add(fileName);
            }
        }
        return imageFileNames;
    }

    private static List<String> getAllTextExtractedFileNames(String imagePath, String filePath) {

        List<String> imageFileNames = getAllImageFileNames(imagePath);
        List<String> textFileNames = new ArrayList<>();
        List<String> allFilesInFolder = FolderUtil.getListOfFilesInFolder(filePath);
        if (allFilesInFolder != null) {
            for (String fileName : imageFileNames) {
                for (String textFileName : allFilesInFolder) {
                    if (textFileName.equals(fileName.replace(".jpg", "") + "_processed.txt"))
                        textFileNames.add(textFileName);
                }
            }
        }
        return textFileNames;
    }

    private static int insertProcessDataInDb(Map<String, Boolean> processData) {
        int status = 0;
        for (Map.Entry<String, Boolean> entry : processData.entrySet())
            status = DBConnection.executeUpdateQuery("Insert into process(process_name) values ('" + entry.getKey() + "')");

        return status;
    }

    private static int insertBalanceSheetDataInDb(String processName, Map<String, Map<String, String>> balanceSheetData) throws SQLException {

        ResultSet rs = DBConnection.getQueryData("Select id from process where process_name='" + processName + "'");
        rs.next();
        int processId = rs.getInt("id");
        int status = 0;
        Map<String, String> assetData = balanceSheetData.get("Liabilities");
        Map<String, String> liabilityData = balanceSheetData.get("Asset");
        for (Map.Entry<String, String> entry : assetData.entrySet()) {
            status = DBConnection.executeUpdateQuery("Insert into balance_sheet(process_id,product_name,amount,product_type) " +
                    "values ('" + processId + "','" + entry.getKey() + "'," + Double.parseDouble(entry.getValue().replace("$","")) + ",'Asset')");
        }
        for (Map.Entry<String, String> entry : liabilityData.entrySet()) {
            status = DBConnection.executeUpdateQuery("Insert into balance_sheet(process_id,product_name,amount,product_type) " +
                    "values ('" + processId + "','" + entry.getKey() + "','" + Double.parseDouble(entry.getValue().replace("$","")) + "','Liabilities')");
        }
        return status;
    }

    public static void main(String[] args) {
        String imagePath = System.getProperty("user.dir") + "\\src\\main\\resources\\";
        String textPath = System.getProperty("user.dir") + "\\src\\main\\resources\\";

        try {
            insertDataInDb(imagePath,textPath);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
