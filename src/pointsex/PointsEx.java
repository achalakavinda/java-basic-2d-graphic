package pointsex;

import java.awt.Color;
import java.awt.EventQueue;// this manage event queue
import java.awt.Graphics;// graphic classa
import java.awt.Graphics2D;//this extend from graphic class
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


// java suwing timer use to create animation it fire action events at the specific interval
// action are when some trigger occure
class Surface extends JPanel implements ActionListener {

    private final int DELAY = 150; //set the delay in mili sec 
    private Timer timer;// creating varible 

    //constructor
    public Surface() {

        initTimer();// call init timer function
    }

    private void initTimer() {

        timer = new Timer(DELAY, this);// time set with delay to current context
        timer.start();// start timer
    }
    
    //get method to get timer  object variable
    public Timer getTimer() {
        
        return timer;
    }

    private void doDrawing(Graphics g) { // method to initiate dots animation

        Graphics2D g2d = (Graphics2D) g; // type casting to graphic object to 2d graphic

        g2d.setPaint(Color.blue);// set the color of the points

        int w = getWidth();// this return current width of the componet
        int h = getHeight();//this returnt current hight of the componet

        Random r = new Random();

        for (int i = 0; i < 2000; i++) { // we genrate 2000 dots

            //we get width and hight random withing  the compont size domain
            int x = Math.abs(r.nextInt()) % w;
            int y = Math.abs(r.nextInt()) % h;
            
            //drawling method draw a line but  here w send same parameter it appears as a dot
            g2d.drawLine(x, y, x, y);
            
        }
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();//this redrawn all client area
    }
}

public class PointsEx extends JFrame {

    public PointsEx() {

        initUI();
    }

    private void initUI() {

        final Surface surface = new Surface();
        add(surface);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Timer timer = surface.getTimer();
                timer.stop();
            }
        });

        setTitle("Points");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                PointsEx ex = new PointsEx();
                ex.setVisible(true);
            }
        });
    }
}
