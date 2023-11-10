package chapter18Problems;
import java.util.*;
import java.awt.*;

import sierpenskiTriangles.DrawingPanel;

public class DrawingPanelExample {
    public static final int SIZE = 512;
    
    public static void main(String[] args) {
        
        DrawingPanel panel = createBoard();

    }
    
    public static DrawingPanel createBoard() {
        
        // initializes the drawing panel
        DrawingPanel panel = new DrawingPanel(SIZE, SIZE);
        panel.setBackground(Color.WHITE);
        Graphics g = panel.getGraphics();
        
        for (int count = 7; count > 0; count--) {
            g.drawLine(0, (count * 64), 512, (count * 64));
            g.drawLine((count * 64), 0, (count * 64), 512);
        }
        
        return panel;
    }//end createBoard
    
}
