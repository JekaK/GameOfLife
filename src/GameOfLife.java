import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;


/**
 * Created by kruku on 12.04.2016.
 */
public class GameOfLife extends JFrame {
    final int width = 200, height = 100;
    boolean[][] currentMove = new boolean[height][width], nextMove = new boolean[height][width];
    boolean play;
    Image offScrImg;
    Graphics offScrGraph;
    private JPanel mainPanel;
    private JButton playButton;
    private JButton resetButton;
    private JPanel gamePanel;
    private JButton button1;

    public GameOfLife() {
        super("GameOfLife");
        setContentPane(mainPanel);
        setSize(400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        offScrImg = createImage(mainPanel.getWidth(), gamePanel.getHeight());
        offScrGraph = offScrImg.getGraphics();
        myRepaint();
        Timer time = new Timer();
        TimerTask timer = new TimerTask() {
            @Override
            public void run() {
                if(play){
                    for (int i = 0; i <height ; i++) {
                        for (int j = 0; j <width ; j++) {
                            nextMove[i][j] = decide(i,j);
                        }
                    }
                    for (int i = 0; i <height ; i++) {
                        for (int j = 0; j <width ; j++) {
                            currentMove[i][j] = nextMove[i][j];
                        }
                    }
                    myRepaint();
                }

            }
        };
        time.scheduleAtFixedRate(timer,0,100);
        gamePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int j = width * e.getX() / gamePanel.getWidth();
                int i = height * e.getY() / gamePanel.getHeight();
                currentMove[i][j] = !currentMove[i][j];
                myRepaint();
            }
        });
        gamePanel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                offScrImg = createImage(mainPanel.getWidth(), gamePanel.getHeight());
                offScrGraph = offScrImg.getGraphics();

                myRepaint();
            }
        });

        playButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                play =!play;
                if(play)playButton.setText("Pause");
                else playButton.setText("Play");
            }
        });
        resetButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                currentMove = new boolean[height][width];
            }
        });
        gamePanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int j = width * e.getX() / gamePanel.getWidth();
                int i = height * e.getY() / gamePanel.getHeight();
                if(SwingUtilities.isLeftMouseButton(e)) {
                    currentMove[i][j] = true;
                }else {
                    currentMove[i][j] = false;
                }
                myRepaint();
            }
        });
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                generateRandom();
                myRepaint();
            }
        });
    }



    public void generateRandom(){
        for (int i = 0; i <height ; i++) {
            for (int j = 0; j <width ; j++) {
                currentMove[i][j] = Math.random()<0.5;
            }
        }
    }

    public boolean decide(int i,int j){
        int neighbors = 0;
        if(j>0){
            if(currentMove[i][j-1])neighbors++;
            if(i>0)if(currentMove[i-1][j-1]) neighbors++;
            if(i<height-1)if(currentMove[i+1][j-1])neighbors++;
        }
        if(j<width-1){
            if(currentMove[i][j+1])neighbors++;
            if(i>0)if(currentMove[i-1][j+1]) neighbors++;
            if(i<height-1)if(currentMove[i+1][j+1])neighbors++;

        }
        if(i>0) if(currentMove[i-1][j])neighbors++;
        if(i<height-1) if(currentMove[i+1][j])neighbors++;
        if(neighbors==3)return true;
        if(currentMove[i][j]&&neighbors==2)return true;
        return false;
    }
    public void myRepaint() {
        offScrGraph.setColor(gamePanel.getBackground());
        offScrGraph.fillRect(0, 0, gamePanel.getWidth(), gamePanel.getHeight());
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (currentMove[i][j]) {
                    offScrGraph.setColor(Color.YELLOW);
                    int x =  j * gamePanel.getWidth()/ width;
                    int y =  i * gamePanel.getHeight()/height;
                    offScrGraph.fillRect(x, y, gamePanel.getWidth() / width, gamePanel.getHeight() / height);
                }
            }
        }
        offScrGraph.setColor(Color.BLACK);
        for (int i = 1; i < height; i++) {
            int y = i * gamePanel.getHeight() / height;
            offScrGraph.drawLine(0, y, gamePanel.getWidth(), y);
        }
        for (int i = 1; i < width; i++) {
            int x = i * gamePanel.getWidth() / width;
            offScrGraph.drawLine(x, 0, x, gamePanel.getHeight());
        }
        gamePanel.getGraphics().drawImage(offScrImg, 0, 0, gamePanel);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameOfLife();
            }
        });
    }
}
