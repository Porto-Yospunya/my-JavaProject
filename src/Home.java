import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home extends JFrame
{
    // Panel variable setup.
    private JPanel titlebar;
    private JPanel bgPanel2;
    private JPanel calculPanel;
    private JPanel tab1;
    private JPanel tab2;
    private JPanel tab3;
    
    // Label variable setup.
    private JLabel exitLabelButton;
    private JLabel minimizeLabelButton;
    private JLabel titLabel;
    private JLabel textmenuLabel1;
    private JLabel textmenuLabel2;
    private JLabel menuLabelButton1;
    private JLabel menuLabelButton2;
    private JLabel menuLabelButton3;

    private JLabel textweiLabel;
    private JLabel textheiLabel;
    private JLabel textweiunitLabel;
    private JLabel textheiunitLabel;
    private JLabel textBMILabel;

    // Button variable setup.
    private JButton calculButton;

    // Text Field variable setup.
    private JTextField weiTextInput;
    private JTextField heiTextInput;

    // Separator variable setup.
    private JSeparator titSeparator;
    private JSeparator menuSeparator;

    // Tabbed variable setup.
    private JTabbedPane jTabbed;

    // Show display
    public Home()
    {
        setup();
        titlePanel();
        tabPanel();
        menuPanel();
    }

    // Setup display.
    private void setup()
    {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(1200, 800));
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
    }

    // Title Panel setup.
    private void titlePanel()
    {
        titlebar = new JPanel();
        titlebar.setBounds(0, 0, 1200, 40);
        titlebar.setBackground(new Color(0, 100, 0));
        titlebar.setLayout(null);
        add(titlebar);

        exitLabelButton = new JLabel();
        exitLabelButton.setText("x");
        exitLabelButton.setForeground(new Color(255, 255, 255));
        exitLabelButton.setFont(new Font("", Font.BOLD, 30));
        exitLabelButton.setBounds(1165, -3, 50, 40);
        exitLabelButton.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent evt)
            {
                exitLabelButtonPerformed(evt);
            }    

            public void mouseEntered(MouseEvent evt)
            {
                exitLabelButton.setForeground(new Color(250, 50, 10));
            }

            public void mouseExited(MouseEvent evt)
            {
                exitLabelButton.setForeground(new Color(255, 255, 255));
            }
        });

        minimizeLabelButton = new JLabel();
        minimizeLabelButton.setText("_");
        minimizeLabelButton.setForeground(new Color(255, 255, 255));
        minimizeLabelButton.setFont(new Font("", Font.BOLD, 30));
        minimizeLabelButton.setBounds(1130, -15, 50, 40);
        minimizeLabelButton.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent evt)
            {
                minimizeLabelButtonPerformed(evt);
            }
        });

        titSeparator = new JSeparator();
        titSeparator.setBackground(new Color(255, 255, 255));
        titSeparator.setForeground(null);
        titSeparator.setBounds(0, 40, 1200, 4);
        titSeparator.setOpaque(true);
        //add(jSeparator);

        titLabel = new JLabel();
        titLabel.setText("GOP GRAB");
        titLabel.setForeground(new Color(255, 255, 255));
        titLabel.setFont(new Font("", Font.BOLD, 26));
        titLabel.setBounds(10, 0, 250, 40);

        titlebar.add(exitLabelButton);
        titlebar.add(minimizeLabelButton);
        titlebar.add(titLabel);
    }

    // Form Background Panel setup.
    private void tabPanel()
    {
        jTabbed = new JTabbedPane();
        jTabbed.setBounds(250, 36, 1004, 767);
        jTabbed.setTabPlacement(JTabbedPane.RIGHT);

        tab1 = new JPanel();
        tab1.setBounds(250, 40, 950, 760);
        tab1.setBackground(new Color(255, 255, 255));
        tab1.setLayout(null);

        textmenuLabel1 = new JLabel();
        textmenuLabel1.setText("Welcome");
        textmenuLabel1.setBounds(20, 5, 200, 50);
        textmenuLabel1.setFont(new Font("", Font.PLAIN, 20));
        textmenuLabel1.setForeground(new Color(0, 0, 0));
        tab1.add(textmenuLabel1);

        tab2 = new JPanel();
        tab2.setBounds(250, 40, 950, 760);
        tab2.setBackground(new Color(255, 255, 255));
        tab2.setLayout(null);

        textmenuLabel2 = new JLabel();
        textmenuLabel2.setText("Hello");
        textmenuLabel2.setBounds(20, 5, 200, 50);
        textmenuLabel2.setFont(new Font("", Font.PLAIN, 20));
        textmenuLabel2.setForeground(new Color(0, 0, 0));
        tab2.add(textmenuLabel2);

        tab3 = new JPanel();
        tab3.setBounds(250, 40, 950, 760);
        tab3.setBackground(new Color(255, 255, 255));
        tab3.setLayout(null);
        calculBMIPanel();

        jTabbed.addTab("1", tab1);
        jTabbed.addTab("2", tab2);
        jTabbed.addTab("3", tab3);
        add(jTabbed);
    }

    // Menu Panel setup.
    private void menuPanel()
    {
        bgPanel2 = new JPanel();
        bgPanel2.setBounds(0, 40, 250, 760);
        bgPanel2.setBackground(new Color(255, 255, 255));
        bgPanel2.setLayout(null);
        add(bgPanel2);

        menuLabelButton1 = new JLabel();
        menuLabelButton1.setText("HOME");
        menuLabelButton1.setForeground(new Color(0, 0, 0));
        menuLabelButton1.setFont(new Font("", Font.BOLD, 25));
        menuLabelButton1.setBounds(20, 10, 200, 40);
        menuLabelButton1.setHorizontalAlignment(JLabel.LEFT);
        menuLabelButton1.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent evt)
            {
                menuLabelButton1Performed(evt);
            }

            public void mouseEntered(MouseEvent evt)
            {
                menuLabelButton1.setForeground(new Color(0, 100, 0));
            }
        
            public void mouseExited(MouseEvent evt)
            {
                menuLabelButton1.setForeground(new Color(0, 0, 0));
            }
        });

        menuLabelButton2 = new JLabel();
        menuLabelButton2.setText("MENU");
        menuLabelButton2.setForeground(new Color(0, 0, 0));
        menuLabelButton2.setFont(new Font("", Font.BOLD, 25));
        menuLabelButton2.setBounds(20, 60, 200, 40);
        menuLabelButton2.setHorizontalAlignment(JLabel.LEFT);
        menuLabelButton2.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent evt)
            {
                menuLabelButton2Performed(evt);
            }
            
            public void mouseEntered(MouseEvent evt)
            {
                menuLabelButton2.setForeground(new Color(0, 100, 0));
            }
        
            public void mouseExited(MouseEvent evt)
            {
                menuLabelButton2.setForeground(new Color(0, 0, 0));
            }
        });

        menuLabelButton3 = new JLabel();
        menuLabelButton3.setText("BMI");
        menuLabelButton3.setForeground(new Color(0, 0, 0));
        menuLabelButton3.setFont(new Font("", Font.BOLD, 25));
        menuLabelButton3.setBounds(20, 110, 200, 40);
        menuLabelButton3.setHorizontalAlignment(JLabel.LEFT);
        menuLabelButton3.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent evt)
            {
                menuLabelButton3Performed(evt);
            }
            
            public void mouseEntered(MouseEvent evt)
            {
                menuLabelButton3.setForeground(new Color(0, 100, 0));
            }
        
            public void mouseExited(MouseEvent evt)
            {
                menuLabelButton3.setForeground(new Color(0, 0, 0));
            }
        });

        menuSeparator = new JSeparator();
        menuSeparator.setBackground(new Color(0, 100, 0));
        menuSeparator.setForeground(new Color(0, 100, 0));
        menuSeparator.setBounds(240, 0, 10, 760);
        menuSeparator.setOpaque(true);

        bgPanel2.add(menuLabelButton1);
        bgPanel2.add(menuLabelButton2);
        bgPanel2.add(menuLabelButton3);
        bgPanel2.add(menuSeparator);
    }

    // Calculator BMI Panel.
    private void calculBMIPanel()
    {
        calculPanel = new JPanel();
        calculPanel.setBounds(20, 20, 910, 300);
        calculPanel.setBackground(new Color(152, 251, 152));
        calculPanel.setLayout(null);

        textweiLabel = new JLabel();
        textweiLabel.setText("Weight:");
        textweiLabel.setFont(new Font("", Font.BOLD, 30));
        textweiLabel.setForeground(new Color(0, 0, 0));
        textweiLabel.setBounds(40, 50, 120, 40);
        textweiLabel.setHorizontalAlignment(JLabel.LEFT);

        textweiunitLabel = new JLabel();
        textweiunitLabel.setText("kg.");
        textweiunitLabel.setFont(new Font("", Font.BOLD, 30));
        textweiunitLabel.setForeground(new Color(0, 0, 0));
        textweiunitLabel.setBounds(680, 50, 120, 40);
        textweiunitLabel.setHorizontalAlignment(JLabel.LEFT);

        textheiLabel = new JLabel();
        textheiLabel.setText("Height:");
        textheiLabel.setFont(new Font("", Font.BOLD, 30));
        textheiLabel.setForeground(new Color(0, 0, 0));
        textheiLabel.setBounds(40, 150, 120, 40);
        textheiLabel.setHorizontalAlignment(JLabel.LEFT);

        textheiunitLabel = new JLabel();
        textheiunitLabel.setText("cm.");
        textheiunitLabel.setFont(new Font("", Font.BOLD, 30));
        textheiunitLabel.setForeground(new Color(0, 0, 0));
        textheiunitLabel.setBounds(680, 150, 120, 40);
        textheiunitLabel.setHorizontalAlignment(JLabel.LEFT);

        weiTextInput = new JTextField();
        weiTextInput.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0, 0, 0)));
        weiTextInput.setBackground(calculPanel.getBackground());
        weiTextInput.setFont(new Font("", Font.PLAIN, 30));
        weiTextInput.setBounds(160, 50, 500, 40);

        heiTextInput = new JTextField();
        heiTextInput.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0, 0, 0)));
        heiTextInput.setBackground(calculPanel.getBackground());
        heiTextInput.setFont(new Font("", Font.PLAIN, 30));
        heiTextInput.setBounds(160, 150, 500, 40);

        calculButton = new JButton();
        calculButton.setText("Enter");
        calculButton.setFont(new Font("", Font.PLAIN, 20));
        calculButton.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        calculButton.setBackground(calculPanel.getBackground());
        calculButton.setForeground(new Color(0, 0, 0));
        calculButton.setBounds(40, 250, 100, 40);
        calculButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent evt)
            {
                double wei = Double.parseDouble(weiTextInput.getText());
                double hei = Double.parseDouble(heiTextInput.getText());
                textBMILabel.setText(CalculatorBMI.calculatorBMI(wei, hei));
            }    
        });

        textBMILabel = new JLabel();
        textBMILabel.setText("BMI");
        textBMILabel.setFont(new Font("", Font.BOLD, 30));
        textBMILabel.setForeground(new Color(0, 0, 0));
        textBMILabel.setBounds(200, 250, 200, 40);
        textBMILabel.setHorizontalAlignment(JLabel.LEFT);

        tab3.add(textweiLabel);
        tab3.add(textheiLabel);
        tab3.add(textweiunitLabel);
        tab3.add(textheiunitLabel);
        tab3.add(textBMILabel);
        tab3.add(weiTextInput);
        tab3.add(heiTextInput);
        tab3.add(calculButton);

        tab3.add(calculPanel);
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

    // Moving Tab.
    private void menuLabelButton1Performed(MouseEvent evt)
    {
        jTabbed.setSelectedIndex(0);
    }

    // Moving Tab.
    private void menuLabelButton2Performed(MouseEvent evt)
    {
        jTabbed.setSelectedIndex(1);
    }

    // Moving Tab.
    private void menuLabelButton3Performed(MouseEvent evt)
    {
        jTabbed.setSelectedIndex(2);
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