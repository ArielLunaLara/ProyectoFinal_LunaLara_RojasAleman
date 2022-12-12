import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.FileWriter;
import java.io.BufferedReader;
//import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;

//import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * Write a description of class Record here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Record extends World
{

    /**
     * Constructor for objects of class Record.
     * 
     */
    
    private int points;
    private String line;
    private String [] allRecords;
    private FileWriter recordsFile;
    private BufferedReader lector;
    private File file = new File("Records.txt"); //Important
   
    
    /*public Record()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 375, 1);
        prepare();
        addObject(new Continue(), 310, 200);
    }
   void prepare(){
        getStringOfRecords();       
        showText(allRecords[0] + ": " + allRecords [1], 280, 165);
        showText(allRecords[2] + ": " + allRecords [3], 230, 315);
        showText(allRecords[4]  + ": " + allRecords [5], 190, 465);
    }
    public void getStringOfRecords(){
        allRecords = Files.readString(Path.of(file));
    }
    public void setRecord(int points){
        
    }
    public void writeCSV(String[] Record){
        int i = 0;
        try(FileWriter fw = new FileWriter(file);){
            while(i < 6){
                fw.write(Record[i] + "," + Record[i+1] + "\n");
                i+=2;
            }
        }catch(Exception e){
            
        }
    }*/
    private String recordsFile;
    private int maxRecordsInFile;

    final static Charset ENCODING = StandardCharsets.UTF_8;

    public Record(String recordsFile, int maxRecordsInFile){
        this.recordsFile = recordsFile;
        this.maxRecordsInFile = maxRecordsInFile;
    }

    public void save(GameRecord record) {
        List<GameRecord> records = getRecords();
        List<String> lines = new LinkedList<>();

        records.add(record);

        records.sort(Comparator.comparingInt(GameRecord::getScore).reversed());

        int counter = 0;
        for(GameRecord orderedRecord: records){
            lines.add(orderedRecord.getPlayerName() + "," + orderedRecord.getScore());
            counter++;
            if(counter >= maxRecordsInFile){
                break;
            }
        }

        try {
            Files.write(Path.of(recordsFile), lines, ENCODING);
        } catch (IOException e) {
            System.err.println("Error guardando archivo");
        }
    }

    public List<GameRecord> getRecords() {
        Path path = Paths.get(recordsFile);
        List<GameRecord> records = new LinkedList<>();

        try (Scanner scanner =  new Scanner(path, ENCODING.name())){
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] recordInfo = line.split(",");

                records.add(new GameRecord(recordInfo[0], Integer.parseInt(recordInfo[1])));
            }
        } catch (IOException e) {
            System.err.println("No se pudo leer el archivo");
        }

        return records;
    }
}
