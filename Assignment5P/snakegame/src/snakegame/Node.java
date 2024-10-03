package snakegame;

import java.util.Random;

//节点类每一条蛇有由若干个节点组成的
public class Node {

    private int x;
    private int y;

    public Node(){

    }

    public Node(int x,int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public void setX(int x){
        this.x = x;
    }

    public int getY(){
        return y;
    }

    public void setY(int y){
        this.y = y;
    }

    //随机生成位置（食物）；
    public void random(){
        //创建random对象；

        Random r = new Random();

        //随机生成横坐标；

        this.x = r.nextInt(40);

        //随机生成纵坐标

        this.y = r.nextInt(40);
    }
}