package pointsex;

import java.awt.EventQueue;// This is platform independant class that queue events both from underlaying class and trust application classes
import java.awt.Graphics;// this is an abstract base class for all graphics contects that allow an application to draw into components that realized on various deviices.
import java.awt.Graphics2D;// this calass is extends the grapgic class to provide more sophisticated controll over geometry, coordinate transformation -- read more.
import javax.swing.JFrame;
import javax.swing.JPanel;

class Surface1 extends JPanel{ // suface1 class is extend from Jpanel class

    //doDrawing Methoad initiate drawing lines
    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;//Graphic object varible type cast to Graphic 2d 

        //drawline method is consume 4 parameter wich are stating x and and ending x,y.
        g2d.drawLine(30, 30, 200, 30);
        g2d.drawLine(200, 30, 30, 200);
        g2d.drawLine(30, 200, 200, 200);
        g2d.drawLine(200, 200, 30, 30);
    }

    //override Method in JComponent 
    @Override
    public void paintComponent(Graphics g) {// delegate's paint methoad if non null it pass copy of graphic object

        super.paintComponent(g);
        doDrawing(g);//call doDrawing methoad
    }
}

public class LinesEx extends JFrame {

    public LinesEx() {// main class constructor

        initUI();// initiate function
    }

    private void initUI() {

        add(new Surface1());

        setTitle("Lines");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {// evenet que invoke
            @Override
            public void run() {//override a running thread 
                
                LinesEx ex = new LinesEx();// create object from LineEx class which extend from Jframe
                ex.setVisible(true);//set jframe set visible true.
            }
        });
    }
}
