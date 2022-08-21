package ohrman.max;

import java.util.ArrayList;

public interface ISaveable {
    //Write fields of object into array and return it
    ArrayList<String> write();

    //Read elements from passed array into fields
    void read(ArrayList<String> savedValues);
}
