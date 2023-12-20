package LDatabaseControllers.LDBTable;

import java.util.List;
import java.util.ArrayList;

public class LDBColumn {

    private String name;
    private List<String> cells = new ArrayList<>();

    public LDBColumn(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCells() {
        return cells;
    }

    
    
}
