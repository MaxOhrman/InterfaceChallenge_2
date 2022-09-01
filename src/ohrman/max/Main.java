package ohrman.max;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        ISaveable player = new Player("Bob Ross", 10, 10);
        ISaveable monster = new Monster("Demon", 10, 10);


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
        //Because the type is set to ISaveable we must cast it to player or change the type to "Player" in order
        //to use its methods
        ((Player)player).setName("Max");
        ((Player)player).setHitPoints(5);
        saveObject("player.txt", player);
        readFile("player.txt");

        //Test case of monster
        System.out.println("\nAltering values of Monster and saving.");
        //Because the type is set to ISaveable we must cast it to Monster or change the type to "Monster" in order
        //to use its methods
        ((Monster)monster).setName("Rat");
        ((Monster)monster).setHitPoints(5);
        ((Monster)monster).setStrength(1);
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
