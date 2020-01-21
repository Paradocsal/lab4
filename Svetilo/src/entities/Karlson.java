package entities;

import items.AlarmClock;
import items.Apple;

public class Karlson extends Entity {
    public Karlson(int x,int y,String name){
        super(x,y,name);
    }
    public void move(int x,int y){

    }
    public void bake(Apple apple){
        apple.setBaked(true);
    }
    public void repairAlarm(AlarmClock alarm){ alarm.setBroken(true);}
    public void breakAlarm(AlarmClock alarm){  alarm.setBroken(false);}
    /* functions
    подкинуть полено - передать параметры полена
    зажечь лампу - передать колво топлива
    погасить
    ходить
    садиться
    вставать
    взять со стола
    поставить на стол
     */

}
