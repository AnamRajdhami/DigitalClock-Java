package practice;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.lang.InterruptedException;

public class MyWindow extends JFrame{
    private JLabel heading;
    private JLabel clockLabel;
    private Font font = new Font("",Font.BOLD,35);
    MyWindow(){
        setTitle("Clock");
        setSize(400,400);
        setLocation(300,50);
        this.createGUI();
        this.startClock();
        setVisible(true);
    }
    public void createGUI(){
        heading = new JLabel("Nepal");
        clockLabel = new JLabel("clock");
        heading.setFont(font);
        clockLabel.setFont(font);

        this.setLayout(new GridLayout(2,1));
        this.add(heading);
        this.add(clockLabel);
    }
    public void startClock(){
//     Timer timer = new Timer(1000, new ActionListener() {
//         @Override
//         public void actionPerformed(ActionEvent e) {
////           String dateTime = new Date().toString();
//
//             Date d = new Date();
//             SimpleDateFormat sfd = new SimpleDateFormat("hh : mm : ss a");
//             String dateTime = sfd.format(d);
//           clockLabel.setText(dateTime);
//         }
//     });
//     timer.start();
        //Using thread
      Thread t = new Thread(){
          public void run(){
              try{
                  while(true){
                      Date d = new Date();
                      SimpleDateFormat sfd = new SimpleDateFormat("hh : mm : ss a");
                      String dateTime = sfd.format(d);
                      clockLabel.setText(dateTime);
//                      Thread.sleep(1000);
                      Thread.currentThread().sleep(1000);
                  }
              }catch (InterruptedException e){
                  e.printStackTrace();
              }
          }
      };
      t.start();
    }
}
