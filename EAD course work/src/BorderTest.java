import java.awt.*;
import java.awt.image.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.border.*;

public class BorderTest {

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                JPanel gui = new JPanel(new GridLayout(2,0,5,5));
                gui.setBorder(new EmptyBorder(10,10,10,10));
                gui.setBackground(Color.RED);

                AbstractBorder brdrLeft = new TextBubbleBorder(Color.BLACK,2,16,16);
                AbstractBorder brdrRight = new TextBubbleBorder(Color.BLACK,2,16,16,false);

                JLabel l1 = new JLabel("Label 1");
                l1.setBorder(brdrRight);
                gui.add(l1);

                JLabel l2 = new JLabel("Label 2");
                l2.setBorder(brdrLeft);
                l2.setBackground(Color.YELLOW);
                l2.setOpaque(true);
                gui.add(l2);

                JPanel p1 = new JPanel();
                p1.add(new JLabel("Panel 1"));
                p1.setBorder(brdrRight);
                p1.setOpaque(false);
                gui.add(p1);

                JPanel p2 = new JPanel();
                p2.add(new JLabel("Panel 2"));
                p2.setBorder(brdrLeft);
                gui.add(p2);

                JOptionPane.showMessageDialog(null, gui);
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency/initial.html
        SwingUtilities.invokeLater(r);
    }

}

class TextBubbleBorder extends AbstractBorder {

    private Color color;
    private int thickness = 4;
    private int radii = 8;
    private int pointerSize = 7;
    private Insets insets = null;
    private BasicStroke stroke = null;
    private int strokePad;
    private int pointerPad = 4;
    private boolean left = true;
    RenderingHints hints;

    TextBubbleBorder(
            Color color) {
        this(color, 4, 8, 7);
    }

    TextBubbleBorder(
            Color color, int thickness, int radii, int pointerSize) {
        this.thickness = thickness;
        this.radii = radii;
        this.pointerSize = pointerSize;
        this.color = color;

        stroke = new BasicStroke(thickness);
        strokePad = thickness / 2;

        hints = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        int pad = radii + strokePad;
        int bottomPad = pad + pointerSize + strokePad;
        insets = new Insets(pad, pad, bottomPad, pad);
    }

    TextBubbleBorder(
            Color color, int thickness, int radii, int pointerSize, boolean left) {
        this(color, thickness, radii, pointerSize);
        this.left = left;
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return insets;
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        return getBorderInsets(c);
    }

    @Override
    public void paintBorder(
            Component c,
            Graphics g,
            int x, int y,
            int width, int height) {

        Graphics2D g2 = (Graphics2D) g;

        int bottomLineY = height - thickness - pointerSize;

        RoundRectangle2D.Double bubble = new RoundRectangle2D.Double(
                0 + strokePad,
                0 + strokePad,
                width - thickness,
                bottomLineY,
                radii,
                radii);

        Polygon pointer = new Polygon();

        if (left) {
            // left point
            pointer.addPoint(
                    strokePad + radii + pointerPad,
                    bottomLineY);
            // right point
            pointer.addPoint(
                    strokePad + radii + pointerPad + pointerSize,
                    bottomLineY);
            // bottom point
            pointer.addPoint(
                    strokePad + radii + pointerPad + (pointerSize / 2),
                    height - strokePad);
        } else {
            // left point
            pointer.addPoint(
                    width - (strokePad + radii + pointerPad),
                    bottomLineY);
            // right point
            pointer.addPoint(
                    width - (strokePad + radii + pointerPad + pointerSize),
                    bottomLineY);
            // bottom point
            pointer.addPoint(
                    width - (strokePad + radii + pointerPad + (pointerSize / 2)),
                    height - strokePad);
        }

        Area area = new Area(bubble);
        area.add(new Area(pointer));

        g2.setRenderingHints(hints);

        // Paint the BG color of the parent, everywhere outside the clip
        // of the text bubble.
        Component parent  = c.getParent();
        if (parent!=null) {
            Color bg = parent.getBackground();
            Rectangle rect = new Rectangle(0,0,width, height);
            Area borderRegion = new Area(rect);
            borderRegion.subtract(area);
            g2.setClip(borderRegion);
            g2.setColor(bg);
            g2.fillRect(0, 0, width, height);
            g2.setClip(null);
        }

        g2.setColor(color);
        g2.setStroke(stroke);
        g2.draw(area);
    }
}