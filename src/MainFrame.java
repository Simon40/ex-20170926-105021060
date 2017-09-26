import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MainFrame extends Frame{
    private Button bt=new Button("Add");
    private Button bt1=new Button("Exit");
    private Button bt2=new Button("Sub");
    private Label la=new Label("^-^");
    private javax.swing.Timer ti;

    private int x=0,lbx=100,lby=100;
    public MainFrame(){
        initComp();
    }
    private void initComp(){
        this.setBounds(100,100,500,400);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
        this.add(la);
        this.la.setBounds(lbx,lby,500,400);
        this.add(bt);
        this.bt.setBounds(120,70,80,30);
        this.bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x++;
                //la.setText(Integer.toString(x));
                //MainFrame.this.setTitle(Integer.toString(x));
                ti.start();
            }
        });
        this.add(bt1);
        this.bt1.setBounds(210,70,80,30);
        this.bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        MainFrame.this.setTitle("QaQ");
        this.add(bt2);
        this.bt2.setBounds(280,70,80,30);
        this.bt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x--;
                la.setText(Integer.toString(--x));
                MainFrame.this.setTitle(Integer.toString(x));
            }
        });
        this.setLayout(null);

        ti=new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lbx+= 5;
                la.setLocation(lbx,lby);
            }
        });

    }
}
