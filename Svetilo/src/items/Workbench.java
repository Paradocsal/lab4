package items;

import java.util.ArrayList;

public class Workbench extends ItemMultiplied {
    //items on it? !LIST! add/remove
    // SIZE??
    private static String name = "Workbench";
    private ArrayList<Matter> ItemList = new ArrayList<Matter>();
    public Workbench(int x1,int x2,int y1,int y2,String name){
        super(x1,x2,y1,y2,name);

    }

    public ArrayList<Matter> getItemlist(){
        return ItemList;
    }
    public void removeItem(Matter Item){
        ItemList.remove(Item);
        System.out.println(Item.getName() + "was removed from the workbench !");
    }

}
