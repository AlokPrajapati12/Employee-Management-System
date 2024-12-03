package Employee_Managment_System;

import javax.swing.*;
import java.awt.*;

public class Splesh {
    JFrame frame;
    Splesh(){
      frame=new JFrame();
      frame.setLayout(null);
      frame.setLocation(200,50);
      frame.setUndecorated(true);
      frame.setSize(1170,650);

      ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("icons/front.gif"));
      Image Img=img.getImage().getScaledInstance(1170,650,Image.SCALE_DEFAULT);
      ImageIcon img2=new ImageIcon(Img);
      JLabel label=new JLabel(img2);
      label.setBounds(0,0,1170,650);
      frame.add(label);

      frame.setVisible(true);

      try {
          Thread.sleep(4000);
          frame.setVisible(false);
          new Login();

      } catch (Exception e) {
          e.printStackTrace();
      }

    }
    public static void main(String[] args){
        new Splesh();
    }
}
