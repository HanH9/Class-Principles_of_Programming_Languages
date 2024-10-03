package snakegame;

import java.util.LinkedList;
import java.util.Random;

public class sanke {

    //蛇的身体

    private LinkedList<Node> body;

    //蛇的运动方向；
    //默认向左
    private Directon directon = Directon.LEFT;
    //蛇是否活着；
    private boolean isLiving = true;

    //构造方法在sanke对象是时执行；

    public sanke(){
        //初始化射身体；

        initSanke();
    }

    private void initSanke() {

        //创建集合

        body = new LinkedList<>();

        //创建六个节点放到集合中
        Random random = new Random();
        body.add(new Node(16,10));
        body.add(new Node(17,10));
        body.add(new Node(18,10));
        body.add(new Node(19,10));
        body.add(new Node(20,10));
        body.add(new Node(21,10));
    }

    //蛇随着蛇头的方向移动
    //控制蛇移动
    public void move(){
        if(isLiving){
            //获取蛇头；

            Node head = body.getFirst();

            switch(directon){

                case UP:

                    //在蛇头上方添加一个节点；

                    body.addFirst(new Node(head.getX(),head.getY()-1));

                    break;
                case DOWN:

                    body.addFirst(new Node(head.getX(),head.getY()+1));

                    break;
                case LEFT:

                    body.addFirst(new Node(head.getX()-1,head.getY()));

                    break;
                case RIGHT:

                    body.addFirst(new Node(head.getX()+1,head.getY()));

                    break;
            }
            //删除最后的节点；

            body.removeLast();

            //判断蛇是否活着；
            head = body.getFirst();
            if(head.getX()<0||head.getY()<0||head.getX()>=40||head.getY()>=40){
                isLiving = false;
            }

            //判断蛇是否碰到自己；
            for(int i=0;i<body.size();i++){
                Node node = body.get(i);
			/*if(head.getX()==node.getX()&&head.getY()==node.getY()){
				isLiving = false;
			}*/
            }

            //判断是否迟到食物
        }
    }

    public LinkedList<Node> getBody(){
        return body;
    }

    public void setBody(LinkedList<Node> body){

    }

    public Directon getDirecton(){
        return directon;
    }

    public void setDirecton(Directon directon){
        this.directon = directon;
    }

    public void eat(Node food) {
        // 吃食物；
        Node head = body.getFirst();

        switch(directon){

            case UP:

                //在蛇头上方添加一个节点；

                body.addFirst(new Node(head.getX(),head.getY()-1));

                break;
            case DOWN:

                body.addFirst(new Node(head.getX(),head.getY()+1));

                break;
            case LEFT:

                body.addFirst(new Node(head.getX()-1,head.getY()));

                break;
            case RIGHT:

                body.addFirst(new Node(head.getX()+1,head.getY()));

                break;
        }


    }
}