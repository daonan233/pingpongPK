package pingpongPK_Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.Frame;

import java.net.MalformedURLException;

import java.net.URL;

public class pingpongPK {

        private Frame frame = new Frame("弹球游戏");
        //球桌
        private final int TABLE_WIDTH=400;
        private final int TABLE_HEIGHT=600;

        //球拍
        private final int RACKET_WIDTH = 100;
        private final int RACKET_HEIGHT = 20;

        //小球
        private final int BALL_SIZE = 16;

        //定义变量，记录小球的坐标；
        private int ballx=120;
        private int bally=200;

        //定义变量，记录小球在x和y上分别移动的速度
        private int speedy=10;
        private int speedx=10;

        //定义变量，记录球拍1的坐标
        private int racketx1 = 150;
        private final int rackety1 = 525;

        //定义变量，记录球拍12的坐标
        private int racketx2 = 150;
        private final int rackety2 = 50;

        //定义变量，标识游戏是否结束
        private boolean isOver = false;

        //声明一个定时器
        private Timer timer;

        //自定义一个类，继承Canvas，充当画布

         private int whoLose =0;

        private class MyCanvas extends Canvas{
            @Override
            public void paint(Graphics g) {
                //TODO 在这里绘制内容

                if(isOver)
                {//游戏结束
                    //粉方寄了
                    if(whoLose ==1) {
                        g.setColor(Color.PINK);
                        g.setFont(new Font("Times", Font.BOLD, 60));
                        g.drawString(" 粉方寄了！", 55, 300);
                    }
                    //绿方寄了
                    else if(whoLose ==2){
                        g.setColor(Color.GREEN);
                        g.setFont(new Font("Times", Font.BOLD, 60));
                        g.drawString(" 绿方寄了！", 55, 300);
                    }

                }else
                    //游戏中
                    //绘制小球
                    g.setColor(Color.RED);
                    g.fillOval(ballx,bally,BALL_SIZE,BALL_SIZE);

                    //绘制球拍
                    g.setColor(Color.PINK);
                    g.fillRect(racketx1,rackety1,RACKET_WIDTH,RACKET_HEIGHT);

                    g.setColor(Color.GREEN);
                    g.fillRect(racketx2,rackety2,RACKET_WIDTH,RACKET_HEIGHT);

                }

            }


        //创建绘画区域
        MyCanvas drawArea = new MyCanvas();

        public void player(){
            //组装视图，以及游戏逻辑设置

            //完成球拍坐标的变化
            KeyListener listener1 =new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    int keyCode = e.getKeyCode();
                    if(keyCode==KeyEvent.VK_LEFT){
                        //向左移动
                        if(racketx1>0)
                            racketx1-=25;
                    }
                    if(keyCode==KeyEvent.VK_RIGHT){
                        //向右移动
                        if(racketx1<TABLE_WIDTH-RACKET_WIDTH)
                            racketx1+=25;
                    }

                }
            };

            KeyListener listener2 =new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    int keyCode = e.getKeyCode();
                    if(keyCode==KeyEvent.VK_A){
                        //向左移动
                        if(racketx2>0)
                            racketx2-=25;
                    }
                    if(keyCode==KeyEvent.VK_D){
                        //向右移动
                        if(racketx2<TABLE_WIDTH-RACKET_WIDTH)
                            racketx2+=25;
                    }

                }
            };
            //注册监听
            frame.addKeyListener(listener1);
            drawArea.addKeyListener(listener1);

            frame.addKeyListener(listener2);
            drawArea.addKeyListener(listener2);

            //小球坐标的控制
            ActionListener task =new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //更新小球的坐标，重新给界面
                    ballx += speedx;
                    bally += speedy;
                    //重给页面
                    drawArea.repaint();
                    if (ballx <= 0 || ballx >= (TABLE_WIDTH - BALL_SIZE)) {
                        speedx = -speedx;
                    }
                    if ((bally <= rackety2+RACKET_HEIGHT && ballx < racketx2+ RACKET_WIDTH && ballx > racketx2)|| (bally > rackety1-BALL_SIZE&& ballx < racketx1+ RACKET_WIDTH && ballx > racketx1))
                    {
                        speedy = -speedy;
                    }

                    if (bally > rackety1 - BALL_SIZE && (ballx < racketx1 || ballx > racketx1 + RACKET_WIDTH)) {
                        //当前校区超出了球拍的范围，游戏结束

                        //停止计时器
                        timer.stop();
                        //修改游戏是否结束的标记
                        isOver = true;
                        whoLose =1;//粉色输了
                        //重绘界面
                        drawArea.repaint();
                    }

                    if (bally < rackety2 + BALL_SIZE && (ballx < racketx2 || ballx > racketx2 + RACKET_WIDTH)) {
                        //当前校区超出了球拍的范围，游戏结束

                        //停止计时器
                        timer.stop();
                        //修改游戏是否结束的标记
                        isOver = true;
                        whoLose =2;//绿色输了
                        //重绘界面
                        drawArea.repaint();
                    }
                    //更新小球的坐标，重新给界面
                    ballx+=speedx;
                    bally+=speedy;

                    //重给界面
                    drawArea.repaint();
                }
            };
            timer= new Timer(100,task);
            timer.start();

            drawArea.setPreferredSize(new Dimension(TABLE_WIDTH,TABLE_HEIGHT));
            frame.add(drawArea);

            frame.pack();
            frame.setVisible(true);
        }

        public static void main(String[] args) {
            new pingpongPK().player();
        }
}