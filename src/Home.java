import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home extends JFrame
{
    // Panel variable setup.
    private JPanel bgPanel1;
    private JPanel bgPanel2;
    private JPanel tabPanel1;
    private JPanel tabPanel2;
    
    // Label variable setup.
    private JLabel exitLabelButton;
    private JLabel minimizeLabelButton;
    private JLabel titLabel;
    private JLabel menuLabel1;
    private JLabel menuLabel2;

    // Button variable setup.
    private JButton menuButton1;
    private JButton menuButton2;

    // Separator variable setup.
    private JSeparator titSeparator;

    private JTabbedPane jTab;

    // Show display
    public Home()
    {
        setup();
        titlePanel(bgPanel1, exitLabelButton, minimizeLabelButton, titLabel, titSeparator);
        formBackgroundPanel(menuLabel1, menuLabel2);
        menuPanel(bgPanel2);
    }

    // Setup display.
    private void setup()
    {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(1200, 800));
        setResizable(false);
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
    private void formBackgroundPanel(JLabel jLabel1, JLabel jLabel2)
    {
        jTab = new JTabbedPane();
        jTab.setBounds(250, 40, 1002, 760);
        jTab.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        jTab.setTabPlacement(JTabbedPane.RIGHT);

        tabPanel1 = new JPanel();
        tabPanel1.setBounds(250, 40, 950, 760);
        tabPanel1.setBackground(new Color(61, 61 ,61));
        tabPanel1.setLayout(null);
        add(tabPanel1);

        jLabel1 = new JLabel();
        jLabel1.setText("Welcome");
        jLabel1.setBounds(20, 5, 200, 50);
        jLabel1.setFont(new Font("", Font.PLAIN, 20));
        jLabel1.setForeground(new Color(255, 255, 255));
        add(jLabel1);

        tabPanel1.add(jLabel1);

        tabPanel2 = new JPanel();
        tabPanel2.setBounds(250, 40, 950, 760);
        tabPanel2.setBackground(new Color(61, 61 ,61));
        tabPanel2.setLayout(null);
        add(tabPanel2);

        jLabel2 = new JLabel();
        jLabel2.setText("Hello");
        jLabel2.setBounds(20, 5, 200, 50);
        jLabel2.setFont(new Font("", Font.PLAIN, 20));
        jLabel2.setForeground(new Color(255, 255, 255));
        add(jLabel2);

        tabPanel2.add(jLabel2);

        jTab.addTab("Tab1", tabPanel1);
        jTab.addTab("Tab2", tabPanel2);

        add(jTab);
    }

    // Menu Panel setup.
    private void menuPanel(JPanel jPanel)
    {
        jPanel = new JPanel();
        jPanel.setBounds(0, 40, 250, 760);
        jPanel.setBackground(new Color(200, 200 ,200));
        jPanel.setLayout(null);
        add(jPanel);

        menuButton1 = new JButton();
        menuButton1.setText("SI base units");
        menuButton1.setBackground(new Color(200, 200, 200));
        menuButton1.setFont(new Font("", Font.BOLD, 25));
        menuButton1.setBounds(20, 10, 200, 40);
        menuButton1.setBorder(null);
        menuButton1.setBorderPainted(false);
        menuButton1.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent evt)
            {
                menuButton1Performed(evt);
            }
        });
        menuButton1.addMouseListener(new MouseAdapter() 
        {
            public void mouseEntered(MouseEvent evt)
            {
                menuButton1.setForeground(new Color(255, 87, 51));
            }
        
            public void mouseExited(MouseEvent evt)
            {
                menuButton1.setForeground(new Color(0, 0, 0));
            }
        });
        add(menuButton1);

        menuButton2 = new JButton();
        menuButton2.setText("Derived SI units");
        menuButton2.setBackground(new Color(200, 200, 200));
        menuButton2.setFont(new Font("", Font.BOLD, 25));
        menuButton2.setBounds(20, 60, 200, 40);
        menuButton2.setBorder(null);
        menuButton2.setBorderPainted(false);
        menuButton2.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent evt)
            {
                menuButton2Performed(evt);
            }
        });
        menuButton2.addMouseListener(new MouseAdapter() 
        {
            public void mouseEntered(MouseEvent evt)
            {
                menuButton2.setForeground(new Color(255, 87, 51));
            }
        
            public void mouseExited(MouseEvent evt)
            {
                menuButton2.setForeground(new Color(0, 0, 0));
            }
        });
        add(menuButton2);

        jPanel.add(menuButton1);
        jPanel.add(menuButton2);
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

    private void menuButton1Performed(ActionEvent evt)
    {
        jTab.setSelectedIndex(0);
    }

    private void menuButton2Performed(ActionEvent evt)
    {
        jTab.setSelectedIndex(1);
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
