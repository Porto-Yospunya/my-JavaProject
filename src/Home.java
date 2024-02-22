import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home extends JFrame
{
    // Panel variable setup.
    private JPanel bgPanel1;
    private JPanel bgPanel2;
    
    // Label variable setup.
    private JLabel exitLabelButton;
    private JLabel minimizeLabelButton;
    private JLabel titLabel;

    // Separator variable setup.
    private JSeparator titSeparator;

    // Show display
    public Home()
    {
        setup();
        titlePanel(bgPanel1, exitLabelButton, minimizeLabelButton, titLabel, titSeparator);
        formBackgroundPanel(bgPanel2);
    }

    // Setup display.
    private void setup()
    {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(1200, 800));
        setMinimumSize(new Dimension(1200, 800));
        setLayout(null);
        setLocation(400, 100);
        setTitle("Clock Store");
    }

    // Title Panel setup.
    private void titlePanel(JPanel jPanel, JLabel jLabel1, JLabel jLabel2, JLabel jLabel3, JSeparator jSeparator)
    {
        jPanel = new JPanel();
        jPanel.setBounds(0, 0, 1200, 40);
        jPanel.setBackground(new Color(51, 51, 51));
        jPanel.setLayout(null);
        add(jPanel);

        jLabel1 = new JLabel();
        jLabel1.setText("x");
        jLabel1.setForeground(new Color(255, 87, 51));
        jLabel1.setFont(new Font("", Font.BOLD, 30));
        jLabel1.setBounds(1165, -3, 50, 40);
        jLabel1.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent evt)
            {
                exitLabelButtonPerformed(evt);
            }    
        });
        add(jLabel1);

        jLabel2 = new JLabel();
        jLabel2.setText("_");
        jLabel2.setForeground(new Color(255, 87, 51));
        jLabel2.setFont(new Font("", Font.BOLD, 30));
        jLabel2.setBounds(1130, -15, 50, 40);
        jLabel2.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent evt)
            {
                minimizeLabelButtonPerformed(evt);
            }    
        });
        add(jLabel2);

        jSeparator = new JSeparator();
        jSeparator.setBackground(new Color(255, 95, 31));
        jSeparator.setForeground(new Color(255, 95, 31));
        jSeparator.setBounds(0, 40, 1200, 20);
        add(jSeparator);

        jLabel3 = new JLabel();
        jLabel3.setText("Unit Conversion");
        jLabel3.setForeground(new Color(255, 87, 51));
        jLabel3.setFont(new Font("", Font.BOLD, 26));
        jLabel3.setBounds(10, 0, 250, 40);

        jPanel.add(jLabel1);
        jPanel.add(jLabel2);
        jPanel.add(jLabel3);
    }

    // Form Background Panel setup.
    private void formBackgroundPanel(JPanel jPanel)
    {
        jPanel = new JPanel();
        jPanel.setBounds(0, 40, 1200, 760);
        jPanel.setBackground(new Color(61, 61 ,61));
        jPanel.setLayout(null);
        add(jPanel);
    }

    // Exit Button setup.
    private void exitLabelButtonPerformed(MouseEvent evt)
    {
        System.exit(0);
    }

    // Minimize Button setup.
    private void minimizeLabelButtonPerformed(MouseEvent evt)
    {
        setState(Frame.ICONIFIED);
    }

    // Main Run program.
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new Home().setVisible(true);
            }
        });
    }
}
