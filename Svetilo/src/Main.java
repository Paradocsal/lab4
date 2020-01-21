import entities.*;
import items.BirchFirewood;
import items.*;
//import mapping.LightMapp;
import mapping.Prostranstvo;

import java.util.ArrayList;
import java.util.function.Supplier;
//import mapping.Prostranstvo;


public class Main {
    public static void main(String[] args){
        Action act = new Action(){
            public int actions(Supplier<Integer> f){
                return f.get();
            }
            //private ArrayList<Object> Changeable_vars = new ArrayList<Object>();
            private ArrayList<DepletableLightSource> Light_sources = new ArrayList<DepletableLightSource>();
            @Override
            public void addLightToList(DepletableLightSource dls){
                Light_sources.add(dls);
            }
            @Override
            public void refreshEnvironment(){
                for (DepletableLightSource i : Light_sources){
                    i.burn_fuel();
                }
        /*
        for (map i : MAP){
            i.do_fall();
        }
         */
            }
        };



        Karlson karl = new Karlson(1,10,"Karl");
        Entity mal = new Entity(22,1,"Malish");
        Entity.Possessions karlPossessions = karl.new Possessions();
        Entity.Possessions juniorPossessions = mal.new Possessions();

        AlarmClock alarm = new AlarmClock(2,2,false,"Kogsvort");
        Wire wire = new Wire(5,10,3,3,"Provoloka");
        Apple apple1 = new Apple(13,6,1,"apple1");
        Apple apple2 = new Apple(10,6,2,"apple2");
        Apple apple3 = new Apple(14,3,3,"apple3");
        Fireplace fireplace = new Fireplace(1,1,true,2);
        act.addLightToList(fireplace);

        BirchFirewood birch1 = new BirchFirewood(15,11,2);
        BirchFirewood birch2 = new BirchFirewood(16,12,2);
        KerosineLamp lamp = new KerosineLamp(48,22,false,0);

        Workbench workbench = new Workbench(29,49,1,7,"Verstak"); //learn to map big objects

        Tool hammer = new Tool(2,4,"hammer","To provide strong blunt force");
        Tool scissors = new Tool( 1,5,"scissors","To cut through surfaces");
        Prostranstvo map = new Prostranstvo(50,50);

        map.addItemOnWorkbench(hammer,workbench,3);
        map.addItemOnWorkbench(scissors,workbench,5);
        map.addItemOnWorkbench(alarm,workbench,4);



        try {
            map.addOnMap(apple1);
            map.addOnMap(apple2);
            map.addOnMap(apple3);
            map.addOnMap(birch1);
            map.addOnMap(birch2);
            map.addOnMap(mal);
            map.addMultlObjOnMap(wire);
            map.addOnMap(karl);
            map.addMultlObjOnMap(workbench);
        }
        catch (NotEnoughSpaceException ex){
            System.err.println("Место уже занятой!");
        }
        catch (ArrayIndexOutOfBoundsException  e){
            System.err.println("Объект размещён за пределами карты!");
        }


        map.showMap();
        map.addIstSveta(fireplace, 5);





        System.out.println();

            map.addOnWire(apple1, wire);
            map.addOnWire(apple2, wire);
            map.showMap();
            map.addOnWire(apple3, wire);

        mal.eatApple(apple1);
        karl.bake(apple1);
        karl.bake(apple2);
        karl.bake(apple3);
        mal.eatApple(apple1);
        mal.eatApple(apple1);
        mal.eatApple(apple1);
        map.deleteObj(apple1);
        karl.eatApple(apple2);
        map.deleteObj(apple2);
        act.refreshEnvironment();
        //karl.go;
        mal.talk("Как хорошо, когда трещат поленья! -- Дни стали холодными. По всему видно, что пришла осень");

        fireplace.refuel(birch1,1);
        map.deleteObj(birch1);
        map.showLightMap();
        act.refreshEnvironment();
        fireplace.refuel(birch1);
        map.deleteObj(birch2);
        map.showLightMap();
        act.refreshEnvironment();

        while(fireplace.isActive()){
            map.showLightMap();
            act.refreshEnvironment();
            //fireplace.emitLight(Light_map);

        }
        System.out.println("Камин прогорел");

        lamp.activate();
        act.addLightToList(lamp);

        map.leaveLightFrom(lamp);

        map.addIstSveta(lamp, 3);

        act.refreshEnvironment();
        map.showLightMap();
        mal.talk("Карлсон, не хочешь поиграть в трейдеров?");
        karl.talk("Всегда Готов!");

        act.refreshEnvironment();

        for (Matter i : workbench.getItemlist()){
            //junior.askFor(i)
            if (i.getName() == "Kogsvort") {
                juniorPossessions.trade(karlPossessions,i);
            }
        }
        karl.repairAlarm(alarm);
        System.out.println(juniorPossessions.getPossessions());
        System.out.println("This is very fun!");


}

}
