import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
public class MainFrame extends JFrame implements  ActionListener,MouseListener,MouseMotionListener,KeyListener{
    private BallThread greenBallThread;
    //控制小球的线程
    private Boolean xUp,yUp,bouncing;
    private int x,y,xDx,yDy;
    //小球坐标,增量
    private final int MAX_X=300,MAX_Y=500;
    private Boolean renew;
    private JLabel label;
    private int Rx,Ry;
    //横板坐标
    private Brick brick[]=new Brick[18];
    //砖块
    private Ball ball;
    //小球
    public MainFrame(){
        super("打磚塊");
        Container pane=getContentPane();
        //设置空白面板容器
        label=new JLabel("按上鍵開始");
        //标签
        label.setHorizontalAlignment(JLabel.CENTER);
        //水平
        label.setVerticalAlignment(JLabel.BOTTOM);
        //垂直
        pane.add(label);
        //向面板里添加标签
        xUp=true;
        //横坐标可以移动
        yUp=false;
        //纵坐标不可以移动
        xDx=1;
        yDy=1;
        x=150;
        //小球坐标
        y=450;
        Rx=120;
        //横板坐标
        Ry=460;
        renew=true;
        bouncing=false;
       // addKeyListener(this);
        addMouseMotionListener(this);
        //键盘监听器
        brick[0]=new Brick(0,60,50,20);
        //砖块坐标
        brick[1]=new Brick(50,60,50,20);
        brick[2]=new Brick(100,60,50,20);
        brick[3]=new Brick(150,60,50,20);
        brick[4]=new Brick(200,60,50,20);
        brick[5]=new Brick(250,60,50,20);
        brick[6]=new Brick(0,90,50,20);
        brick[7]=new Brick(50,110,50,20);
        brick[8]=new Brick(100,130,50,20);
        brick[9]=new Brick(150,130,50,20);
        brick[10]=new Brick(200,110,50,20);
        brick[11]=new Brick(250,90,50,20);
        brick[12]=new Brick(0,160,50,20);
        brick[13]=new Brick(50,160,50,20);
        brick[14]=new Brick(100,160,50,20);
        brick[15]=new Brick(150,160,50,20);
        brick[16]=new Brick(200,160,50,20);
        brick[17]=new Brick(250,160,50,20);
        ball=new Ball(150,450,10,10);
        //球的坐标
        setSize(MAX_X,MAX_Y);
        //窗口大小
        setResizable(false);
        setVisible( true );
        //可视化
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        Timer t = new Timer(15, this);
    }
    public void keyPressed(KeyEvent e) {
//        if (e.getKeyCode() ==e.VK_UP) {
//            if(renew){
//                greenBallThread=new BallThread(this);
//                bouncing = true;
//                greenBallThread.start();
//                label.setVisible(false);
//            }
//            renew=false;
//        }
//        if(e.getKeyCode()==e.VK_LEFT){
//            Rx=Rx-20;
//            if(bouncing){
//                if(Rx<0){
//                    Rx=0;
//                }
//            } else{
//                if(Rx<0){
//                    Rx=0;
//                } else{
//                    x=x-20;
//                    ball.ball_x=x;
//                }
//            }
//            repaint();
//        }
//        if(e.getKeyCode()==e.VK_RIGHT){
//            Rx=Rx+20;
//            if(bouncing){
//                if(Rx+80>300){
//                    Rx=220;
//                }
//            } else{
//                if(Rx+80>300){
//                    Rx=220;
//                } else{
//                    x=x+20;
//                    ball.ball_x=x;
//                }
//            }
//            repaint();
//        }
    }
    public void keyReleased (KeyEvent e) {
    }
    public void keyTyped (KeyEvent e){
    }
    public void paint(Graphics g){
        super.paint(g);
        ball.rect.setLocation(x,y);
        if(bouncing){
            for (int i=0;i<=17;i++){
                if(brick[i].visible==true){
                    g.setColor(Color.RED);

//                                        switch(i){
//                        case 0 :g.setColor(Color.blue);
//                            break;
//                        case 1 :g.setColor(Color.cyan);
//                            break;
//                        case 2 :g.setColor(Color.gray);
//                            break;
//                        case 3 :g.setColor(Color.green);
//                            break;
//                        case 4 :g.setColor(Color.magenta);
//                            break;
//                        case 5 :g.setColor(Color.yellow);
//                            break;
//                        case 6 :g.setColor(Color.white);
//                            break;
//                        case 7 :g.setColor(Color.black);
//                            break;
//                        case 8 :g.setColor(Color.orange);
//                            break;
//                        case 9 :g.setColor(Color.pink);
//                            break;
//                        case 10 :g.setColor(Color.darkGray);
//                            break;
//                        case 11 :g.setColor(Color.red);
//                            break;
//                        case 12 :g.setColor(Color.blue);
//                            break;
//                        case 13 :g.setColor(Color.cyan);
//                            break;
//                        case 14 :g.setColor(Color.gray);
//                            break;
//                        case 15 :g.setColor(Color.green);
//                            break;
//                        case 16 :g.setColor(Color.magenta);
//                            break;
//                        case 17 :g.setColor(Color.yellow);
//                            break;
//                    }
                    g.fill3DRect(brick[i].brick_x,brick[i].brick_y,brick[i].brick_width,brick[i].brick_height,true);
                }
            }
            g.setColor(Color.red);
            g.fillOval(x, y, 10, 10);
            g.setColor(Color.blue);
            g.fillRect(Rx,Ry,80,20);
        } else{
            for (int i=0;i<=17;i++){
                g.setColor(Color.RED);
                                switch(i){
//                    case 0 :g.setColor(Color.blue);
//                        break;
//                    case 1 :g.setColor(Color.cyan);
//                        break;
//                    case 2 :g.setColor(Color.gray);
//                        break;
//                    case 3 :g.setColor(Color.green);
//                        break;
//                    case 4 :g.setColor(Color.magenta);
//                        break;
//                    case 5 :g.setColor(Color.yellow);
//                        break;
//                    case 6 :g.setColor(Color.white);
//                        break;
//                    case 7 :g.setColor(Color.black);
//                        break;
//                    case 8 :g.setColor(Color.orange);
//                        break;
//                    case 9 :g.setColor(Color.pink);
//                        break;
//                    case 10 :g.setColor(Color.darkGray);
//                        break;
//                    case 11 :g.setColor(Color.red);
//                        break;
//                    case 12 :g.setColor(Color.blue);
//                        break;
//                    case 13 :g.setColor(Color.cyan);
//                        break;
//                    case 14 :g.setColor(Color.gray);
//                        break;
//                    case 15 :g.setColor(Color.green);
//                        break;
//                    case 16 :g.setColor(Color.magenta);
//                        break;
//                    case 17 :g.setColor(Color.yellow);
//                        break;
                }
                g.fill3DRect(brick[i].brick_x,brick[i].brick_y,brick[i].brick_width,brick[i].brick_height,true);
            }
            g.setColor(Color.red);
            g.fillOval(x, y, 10, 10);
            g.setColor(Color.blue);
            g.fillRect(Rx, Ry, 80, 20);
        }
    }
    public void move(){
        while(true){
            try{
                Thread.currentThread().sleep(25);
            }
            catch(InterruptedException exception){
                System.err.println(exception.toString());
            }
            for (int i=0;i<=17;i++){
                if(ball.rect.intersects(brick[i].rect)&&brick[i].visible){
                    brick[i].visible=false;
                    yUp=!yUp;
                    //打到球不見
                }
            }
            if(x+5>Rx&&x+5<Rx+80&&y+10>=Ry){
                yUp=false;
                xDx=(int)(Math.random()*5+2);
                //小球座標增量
                yDy=(int)(Math.random()*5+2);
            }
            if(xUp==true){
                x+=xDx;
                //小球左右移動座標改變
            } else{
                x-=xDx;
            }
            if(yUp==true){
                y+=yDy;
            } else{
                y-=yDy;
            }
            if(y<=0){
                y=0;
                ball.ball_y=y;
                yUp=true;
                xDx=(int)(Math.random()*5+2);
                yDy=(int)(Math.random()*5+2);
            } else if(y>=MAX_Y-15){
                yDy=(int)(Math.random()*5+2);
                break;
            }
            if(x<=0){
                x=0;
                ball.ball_x=x;
                xUp=true;
                xDx=(int)(Math.random()*5+2);
                yDy=(int)(Math.random()*5+2);
            } else if(x>=MAX_X-10){
                x=MAX_X-10;
                ball.ball_x=x;
                xDx=(int)(Math.random()*5+2);
                yDy=(int)(Math.random()*5+2);
                xUp=false;
            }
            ball.rect.setLocation(ball.ball_x,ball.ball_y);
            repaint();
            int i;
            //如果所有磚塊都不見
            for (i=0;i<=17&&brick[i].visible==false;i++){
                //重新開始
            }
            if(i==18){
                break;
            }
            //
        }
        renew=true;
        //初始化
        bouncing=false;
        for (int i=0;i<=17;i++){
            brick[i].visible=true;
        }
        xUp=true;
        yUp=false;
        xDx=1;
        yDy=1;
        x=150;
        y=450;
        Rx=120;
        Ry=460;
        //
        repaint();
        repaint();
        label.setVisible(true);
    }
    public static void main(String[] args) {
        MainFrame mar=new MainFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
class BallThread extends Thread{
    private MainFrame m;
    BallThread(MainFrame a){
        //super();
        m=a;
    }
    public void run(){
        m.move();
        m.repaint();
    }
}
class Brick{
    Rectangle rect=null;
    int brick_x,brick_y;
    int brick_width,brick_height;
    Boolean visible;
    public Brick(int x,int y,int w,int h)
    {
        brick_x=x;
        brick_y=y;
        brick_width=w;
        brick_height=h;
        visible=true;
        rect=new Rectangle(x,y,w,h);
    }
}
class Ball{
    Rectangle rect=null;
    int ball_x,ball_y;
    int ball_width,ball_height;
    public Ball(int x,int y,int w,int h){
        ball_x=x;
        ball_y=y;
        ball_width=w;
        ball_height=h;
        rect=new Rectangle(x,y,w,h);


    }
}