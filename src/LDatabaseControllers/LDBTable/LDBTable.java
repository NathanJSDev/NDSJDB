package LDatabaseControllers.LDBTable;

public class LDBTable {

    String[][] items = new String[0][];

    public void addRow(){
        String[][] newItemsArray = new String[items.length+1][];
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < items[i].length; j++) {
                newItemsArray[i][j] = items[i][j];
            }
        }
    }

    public void addRows(int amount){
        String[][] newItemsArray = new String[items.length+amount][];
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < items[i].length; j++) {
                newItemsArray[i][j] = items[i][j];
            }
        }
    }

}
