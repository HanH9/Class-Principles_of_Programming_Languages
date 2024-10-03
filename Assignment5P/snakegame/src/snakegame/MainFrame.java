package snakegame;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

    //蛇
    private sanke sanke;
    private Timer timer;//定时器，在规定时间内调用蛇；
    private JPanel jPanel;//游戏棋盘；
    private Node food;//食物；
    public MainFrame(){
        //初始化窗体的参数

        initFrame();

        //初始化游戏棋盘；

        inintGamePanel();

        //初始化蛇；

        initsanke();

        //初始化食物；

        initfood();

        //初始化定时器

        initTimer();

        //设置键盘监听;

        setKeyListener();

    }

    private void initfood() {

        food = new Node();
        food.random();

    }

    private void setKeyListener() {

        addKeyListener(new KeyAdapter(){
            //当键盘按下时自动调用此方法
            @Override
            public void keyPressed(KeyEvent e){
                //键盘中每一个见都有一个编号

                switch(e.getKeyCode()){

                    case KeyEvent.VK_UP://上
                        //改变蛇的运动方向；
                        if(sanke.getDirecton()!=Directon.DOWN){
                            sanke.setDirecton(Directon.UP);
                        }
                        break;
                    case KeyEvent.VK_DOWN://XIA
                        if(sanke.getDirecton()!=Directon.UP){
                            sanke.setDirecton(Directon.DOWN);
                        }
                        break;
                    case KeyEvent.VK_LEFT://左
                        if(sanke.getDirecton()!=Directon.RIGHT){
                            sanke.setDirecton(Directon.LEFT);
                        }
                        break;
                    case KeyEvent.VK_RIGHT://右
                        if(sanke.getDirecton()!=Directon.LEFT){
                            sanke.setDirecton(Directon.RIGHT);
                        }
                        break;
                }

            }
        });


    }

    //初始化定时器
    private void initTimer() {
        //创建定时器对象；
        timer = new Timer();

        //初始化定时任务；

        TimerTask timertask = new TimerTask() {

            @Override
            public void run() {

                sanke.move();
                //判断是否迟到食物
                Node node = sanke.getBody().getFirst();
                if(node.getX()==food.getX()&&node.getY()==food.getY()){
                    sanke.eat(food);
                    food.random();

                }
                //重新绘制棋盘；

                jPanel.repaint();
            }
        };
        //100毫秒执行一次；
        timer.scheduleAtFixedRate(timertask,0,100);
    }
    private void initsanke() {

        sanke = new sanke();

    }
    //初始化游戏棋盘；
    private void inintGamePanel() {

        jPanel =  new JPanel(){
            //绘制游戏棋盘中的内容
            @Override
            public void paint(Graphics g) {

                //清空棋盘；

                g.clearRect(0, 0, 600, 600);

                //Graphics g看作是一个画笔提供了很多方法可以绘制一些基本的图形

                //绘制四十条横线；

                for(int i=0; i<=40; i++){
                    g.drawLine(0, i*15, 600, i*15);
                }
                //绘制四十条竖线；
                for(int i=0; i<=40; i++){
                    g.drawLine(i*15, 0,i*15, 600);
                }
                //绘制蛇；

                LinkedList<Node> body = sanke.getBody();

                for(Node node : body){

                    g.fillRect(node.getX()*15, node.getY()*15, 15, 15);
                }
                //绘制食物；

                g.fillRect(food.getX()*15, food.getY()*15, 15, 15);

            }

        };

        //棋盘添加到窗体中；
        add(jPanel);

    }

    private void initFrame() {
        //创建窗体宽和高

        setSize(610,640);

        //设置窗体的位置；

        setLocation(700,200);

        //设置关闭按钮的作用；

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //固定窗体大小

        setResizable(false);
    }


    public static void main(String[] args){
        //创建窗体对象并显示

        new MainFrame().setVisible(true);
    }

}