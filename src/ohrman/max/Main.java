package ohrman.max;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        Player player = new Player("Bob Ross", 10, 10);
        Monster monster = new Monster("Demon", 10, 10);


        //Load saved player file if exists
        File playerFile = new File("player.txt");

        if (!playerFile.exists()) {
            System.out.println("\nPlayer file does not exist. Creating...");
            saveObject("player.txt", player);
        }
        System.out.println("Loading player file... ");
        player.read(readFile("player.txt"));


        //Load monster file if exists
        File monsterFile = new File("monster.txt");

        if (!monsterFile.exists()) {
            System.out.println("\nMonster file does not exist. Creating...");
            saveObject("monster.txt", monster);
        }
        System.out.println("\nLoading Monster file...");
        monster.read(readFile("monster.txt"));


        //Test case of player
        System.out.println("\nAltering values of player and saving.");
        player.setName("Max");
        player.setHitPoints(5);
        saveObject("player.txt", player);
        readFile("player.txt");

        //Test case of monster
        System.out.println("\nAltering values of Monster and saving.");
        monster.setName("Rat");
        monster.setHitPoints(5);
        monster.setStrength(1);
        saveObject("monster.txt", monster);
        readFile("monster.txt");

    }

    // Writes every element from the ISaveable object to passed String fileName
    public static void saveObject(String fileName, ISaveable objectToSave) throws IOException {
        BufferedWriter outputWriter = new BufferedWriter(new FileWriter(fileName));

        for (String element : objectToSave.write()) {
            outputWriter.write(element + "\n");
        }
        outputWriter.flush();
        outputWriter.close();
    }

    //Read every line of fileName and add to array + return it
    public static ArrayList<String> readFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        ArrayList<String> arrayList = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            arrayList.add(line);
        }
        reader.close();
        return arrayList;
    }
}
