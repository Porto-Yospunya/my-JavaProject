import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;

public class Home extends JFrame implements MouseListener, ActionListener
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

    private JLabel iconImg;

    private JLabel searchLabelButton;

    // Button variable setup.
    private JButton calculButton;
    private JButton warningButton;

    // Text Field variable setup.
    private JTextField weiTextInput;
    private JTextField heiTextInput;

    private JTextField searchfoodText;

    // Separator variable setup.
    private JSeparator titSeparator;
    private JSeparator menuSeparator;

    // Tabbed variable setup.
    private JTabbedPane jTabbed;

    // Table variable setup.
    private JTable foodTable;

    private JScrollPane scrollPane;

    private DefaultTableModel model;

    private DefaultTableCellRenderer renderer;

    private DBConnection db;

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
        // Panel.
        titlebar = new JPanel();
        titlebar.setBounds(0, 0, 1200, 40);
        titlebar.setBackground(new Color(0, 100, 0));
        titlebar.setLayout(null);
        add(titlebar);

        // Exit Button.
        exitLabelButton = new JLabel();
        exitLabelButton.setText("x");
        exitLabelButton.setForeground(new Color(255, 255, 255));
        exitLabelButton.setFont(new Font("", Font.BOLD, 30));
        exitLabelButton.setBounds(1165, -3, 50, 40);
        exitLabelButton.addMouseListener((MouseListener) this);

        // Minimize Button.
        minimizeLabelButton = new JLabel();
        minimizeLabelButton.setText("_");
        minimizeLabelButton.setForeground(new Color(255, 255, 255));
        minimizeLabelButton.setFont(new Font("", Font.BOLD, 30));
        minimizeLabelButton.setBounds(1130, -15, 50, 40);
        minimizeLabelButton.addMouseListener((MouseListener) this);

        // Line.
        titSeparator = new JSeparator();
        titSeparator.setBackground(new Color(255, 255, 255));
        titSeparator.setForeground(null);
        titSeparator.setBounds(0, 40, 1200, 4);
        titSeparator.setOpaque(true);
        //add(jSeparator);

        // Title Text.
        titLabel = new JLabel();
        titLabel.setText("GOP GRAB");
        titLabel.setForeground(new Color(255, 255, 255));
        titLabel.setFont(new Font("", Font.BOLD, 26));
        titLabel.setBounds(10, 0, 250, 40);

        // Add zone.
        titlebar.add(exitLabelButton);
        titlebar.add(minimizeLabelButton);
        titlebar.add(titLabel);
    }

    // Form Background Panel setup.
    private void tabPanel()
    {
        // Tab.
        jTabbed = new JTabbedPane();
        jTabbed.setBounds(250, 36, 1004, 767);
        jTabbed.setTabPlacement(JTabbedPane.RIGHT);

        // Tab Panel-1: Home.
        tab1 = new JPanel();
        tab1.setBounds(250, 40, 950, 760);
        tab1.setBackground(new Color(255, 255, 255));
        tab1.setLayout(null);
        homeInfoPanel();

        // Tab Panel-2: Menu.
        tab2 = new JPanel();
        tab2.setBounds(250, 40, 950, 760);
        tab2.setBackground(new Color(255, 255, 255));
        tab2.setLayout(null);
        menuInfoPanel();

        // Tab Panel-3: BMI.
        tab3 = new JPanel();
        tab3.setBounds(250, 40, 950, 760);
        tab3.setBackground(new Color(255, 255, 255));
        tab3.setLayout(null);
        bmiInfoPanel();

        // Add Tab zone.
        jTabbed.add("1", tab1);
        jTabbed.add("2", tab2);
        jTabbed.add("3", tab3);
        add(jTabbed);
    }

    // Menu Panel setup.
    private void menuPanel()
    {
        // Panel.
        bgPanel2 = new JPanel();
        bgPanel2.setBounds(0, 40, 250, 760);
        bgPanel2.setBackground(new Color(255, 255, 255));
        bgPanel2.setLayout(null);
        add(bgPanel2);

        // Home Button.
        menuLabelButton1 = new JLabel();
        menuLabelButton1.setText("HOME");
        menuLabelButton1.setForeground(new Color(0, 0, 0));
        menuLabelButton1.setFont(new Font("", Font.BOLD, 25));
        menuLabelButton1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        menuLabelButton1.setBounds(20, 10, 200, 40);
        menuLabelButton1.setHorizontalAlignment(JLabel.CENTER);
        menuLabelButton1.addMouseListener(this);

        // Menu Button.
        menuLabelButton2 = new JLabel();
        menuLabelButton2.setText("MENU");
        menuLabelButton2.setForeground(new Color(0, 0, 0));
        menuLabelButton2.setFont(new Font("", Font.BOLD, 25));
        menuLabelButton2.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        menuLabelButton2.setBounds(20, 60, 200, 40);
        menuLabelButton2.setHorizontalAlignment(JLabel.CENTER);
        menuLabelButton2.addMouseListener(this);

        // BMI Button.
        menuLabelButton3 = new JLabel();
        menuLabelButton3.setText("BMI");
        menuLabelButton3.setForeground(new Color(0, 0, 0));
        menuLabelButton3.setFont(new Font("", Font.BOLD, 25));
        menuLabelButton3.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        menuLabelButton3.setBounds(20, 110, 200, 40);
        menuLabelButton3.setHorizontalAlignment(JLabel.CENTER);
        menuLabelButton3.addMouseListener(this);

        // Line.
        menuSeparator = new JSeparator();
        menuSeparator.setBackground(new Color(0, 100, 0));
        menuSeparator.setForeground(new Color(0, 100, 0));
        menuSeparator.setBounds(240, 0, 10, 760);
        menuSeparator.setOpaque(true);

        // Add zone.
        bgPanel2.add(menuLabelButton1);
        bgPanel2.add(menuLabelButton2);
        bgPanel2.add(menuLabelButton3);
        bgPanel2.add(menuSeparator);
    }

    // Text in Tab Panel-1
    private void homeInfoPanel()
    {
        // Text Welcom.
        textmenuLabel1 = new JLabel();
        textmenuLabel1.setText("Welcome");
        textmenuLabel1.setBounds(20, 205, 200, 50);
        textmenuLabel1.setFont(new Font("", Font.PLAIN, 20));
        textmenuLabel1.setForeground(new Color(0, 0, 0));

        // Image icon.
        iconImg = new JLabel();
        iconImg.setIcon(new ImageIcon("src\\image\\firstlog200px.png"));
        iconImg.setBounds(350, 20, 200, 200);
        iconImg.setHorizontalTextPosition(JLabel.CENTER);
        
        // Add zone
        tab1.add(textmenuLabel1);
        tab1.add(iconImg);
    }
    
    // Text in Tab Panel-2
    private void menuInfoPanel()
    {
        // Text Menu.
        textmenuLabel2 = new JLabel();
        textmenuLabel2.setText("Menu");
        textmenuLabel2.setBounds(430, 30, 200, 50);
        textmenuLabel2.setHorizontalTextPosition(JLabel.CENTER);
        textmenuLabel2.setFont(new Font("", Font.BOLD, 40));
        textmenuLabel2.setForeground(new Color(0, 0, 0));

        // Text Field Search.
        searchfoodText = new JTextField();
        searchfoodText.setBounds(40, 100, 750, 30);
        searchfoodText.setFont(new Font("", Font.PLAIN, 16));
        searchfoodText.setBackground(new Color(255, 255, 255));
        searchfoodText.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));

        // Text Search.
        searchLabelButton = new JLabel();
        searchLabelButton.setText("Search");
        searchLabelButton.setBounds(799, 100, 110, 30);
        searchLabelButton.setFont(new Font("", Font.BOLD, 18));
        searchLabelButton.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        searchLabelButton.setHorizontalAlignment(JLabel.CENTER);
        searchLabelButton.addMouseListener(this);

        // Table setup.
        String[] colname = {"Menu", "Calories", "Protein", "Carbohydrate", "Fat", "Codium"};
        foodTable = new JTable();
        model = new DefaultTableModel(colname, 0) 
        {
            public boolean isCellEditable(int row, int column) 
            {
               return false;
            }
        };

        // Connection Database MySQL
        try {
            db = new DBConnection(); // Connection MySQL.
            ResultSet resultSet = db.getConnect("select * from dbfood.food"); // Pull Database

            while (resultSet.next())
            {
                String name = resultSet.getString("name");
                String cal = resultSet.getString("calories");
                String pt = resultSet.getString("protein");
                String carbo = resultSet.getString("carbohydrate");
                String fat  = resultSet.getString("fat");
                String cd = resultSet.getString("codium");
                String[] row = {name, cal, pt, carbo, fat, cd};
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Table edit.
        foodTable.setModel(model);
        foodTable.setRowHeight(30);
        foodTable.setFont(new Font("TH SarabunPSK", Font.BOLD, 28));
        foodTable.setSelectionBackground(new Color(0, 100, 0));
        foodTable.setSelectionForeground(new Color(255, 255, 255));

        foodTable.getTableHeader().setFont(new Font(null, Font.BOLD, 16));
        foodTable.getTableHeader().setReorderingAllowed(false);
        foodTable.getTableHeader().setEnabled(false);
 
        // Edit colunm.
        foodTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        foodTable.getColumnModel().getColumn(0).setPreferredWidth(407); // Name
        foodTable.getColumnModel().getColumn(1).setPreferredWidth(80); // Calories
        foodTable.getColumnModel().getColumn(2).setPreferredWidth(80); // Protein
        foodTable.getColumnModel().getColumn(3).setPreferredWidth(140); // Carbo
        foodTable.getColumnModel().getColumn(4).setPreferredWidth(80); // fat
        foodTable.getColumnModel().getColumn(5).setPreferredWidth(80); // codium
        
        // Edit Header Horizontal Alignment
        renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 1; i < colname.length; i++) 
        {
            foodTable.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }

        scrollPane = new JScrollPane(foodTable);
        scrollPane.setBounds(40, 140, 870, 600);

        // Add zone.
        tab2.add(textmenuLabel2);
        tab2.add(searchfoodText);
        tab2.add(searchLabelButton);
        tab2.add(scrollPane, BorderLayout.CENTER);
    }

    // Text in Tab Panel-3
    private void bmiInfoPanel()
    {
        // Panel.
        calculPanel = new JPanel();
        calculPanel.setBounds(20, 20, 910, 300);
        calculPanel.setBackground(new Color(152, 251, 152));
        calculPanel.setLayout(null);

        // Weigth Label.
        textweiLabel = new JLabel();
        textweiLabel.setText("Weight:");
        textweiLabel.setFont(new Font("", Font.BOLD, 30));
        textweiLabel.setForeground(new Color(0, 0, 0));
        textweiLabel.setBounds(40, 50, 120, 40);
        textweiLabel.setHorizontalAlignment(JLabel.LEFT);

        // Weight Unit Label.
        textweiunitLabel = new JLabel();
        textweiunitLabel.setText("kg.");
        textweiunitLabel.setFont(new Font("", Font.BOLD, 30));
        textweiunitLabel.setForeground(new Color(0, 0, 0));
        textweiunitLabel.setBounds(680, 50, 120, 40);
        textweiunitLabel.setHorizontalAlignment(JLabel.LEFT);

        // Height Label.
        textheiLabel = new JLabel();
        textheiLabel.setText("Height:");
        textheiLabel.setFont(new Font("", Font.BOLD, 30));
        textheiLabel.setForeground(new Color(0, 0, 0));
        textheiLabel.setBounds(40, 150, 120, 40);
        textheiLabel.setHorizontalAlignment(JLabel.LEFT);

        // Height Unit Label.
        textheiunitLabel = new JLabel();
        textheiunitLabel.setText("cm.");
        textheiunitLabel.setFont(new Font("", Font.BOLD, 30));
        textheiunitLabel.setForeground(new Color(0, 0, 0));
        textheiunitLabel.setBounds(680, 150, 120, 40);
        textheiunitLabel.setHorizontalAlignment(JLabel.LEFT);

        // Weight Input value.
        weiTextInput = new JTextField();
        weiTextInput.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0, 0, 0)));
        weiTextInput.setBackground(calculPanel.getBackground());
        weiTextInput.setFont(new Font("", Font.PLAIN, 30));
        weiTextInput.setBounds(160, 50, 500, 40);

        // Height Input value.
        heiTextInput = new JTextField();
        heiTextInput.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0, 0, 0)));
        heiTextInput.setBackground(calculPanel.getBackground());
        heiTextInput.setFont(new Font("", Font.PLAIN, 30));
        heiTextInput.setBounds(160, 150, 500, 40);

        // Button.
        calculButton = new JButton();
        calculButton.setText("Enter");
        calculButton.setFont(new Font("", Font.PLAIN, 20));
        calculButton.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        calculButton.setBackground(calculPanel.getBackground());
        calculButton.setForeground(new Color(0, 0, 0));
        calculButton.setBounds(40, 250, 100, 40);
        calculButton.addActionListener(this);

        // Answer Label.
        textBMILabel = new JLabel();
        textBMILabel.setText("BMI: 0");
        textBMILabel.setFont(new Font("", Font.BOLD, 30));
        textBMILabel.setForeground(new Color(0, 0, 0));
        textBMILabel.setBounds(200, 250, 200, 40);
        textBMILabel.setHorizontalAlignment(JLabel.LEFT);

        // Add zone.
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
    
    // Mouse Pressed.
    public void mousePressed(MouseEvent evt) 
    {
        if (evt.getSource() == menuLabelButton1) {
            menuLabelButton1.setForeground(new Color(255, 255, 255)); // Text-Button-1
        } else if (evt.getSource() == menuLabelButton2) {
            menuLabelButton2.setForeground(new Color(255, 255, 255)); // Text-Button-2
        } else if (evt.getSource() == menuLabelButton3) {
            menuLabelButton3.setForeground(new Color(255, 255, 255)); // Text-Button-3
        } else if (evt.getSource() == searchLabelButton) {
            searchLabelButton.setForeground(new Color(255, 255, 255)); // Search Food Button
        }
    }

    // Mouse Released.
    public void mouseReleased(MouseEvent evt) 
    {
        if (evt.getSource() == menuLabelButton1) {
            menuLabelButton1.setForeground(new Color(0, 100, 0)); // Text-Button-1
        } else if (evt.getSource() == menuLabelButton2) {
            menuLabelButton2.setForeground(new Color(0, 100, 0)); // Text-Button-2
        } else if (evt.getSource() == menuLabelButton3) {
            menuLabelButton3.setForeground(new Color(0, 100, 0)); // Text-Button-3
        } else if (evt.getSource() == searchLabelButton) {
            searchLabelButton.setForeground(new Color(0, 100, 0)); // Search Food Button
        }
    } 

    // Mouse Click Action.
    public void mouseClicked(MouseEvent evt)
    {
        if (evt.getSource() == exitLabelButton) {
            System.exit(0); // Exit Button.
        } else if (evt.getSource() == minimizeLabelButton) {
            setState(Frame.ICONIFIED); // Minimize Button.
        } else if (evt.getSource() == menuLabelButton1) {
            jTabbed.setSelectedIndex(0); // Tab-Home.
        } else if (evt.getSource() == menuLabelButton2) {
            jTabbed.setSelectedIndex(1); // Tab-Menu.
        } else if (evt.getSource() == menuLabelButton3) {
            jTabbed.setSelectedIndex(2); // Tab-BMI.
        } else if (evt.getSource() == searchLabelButton) {
            // Codind here // Search Food. 
        }
    }

    // Mouse Entered Action.
    public void mouseEntered(MouseEvent evt)
    {
        // Exit Button change color
        if (evt.getSource() == exitLabelButton) {
            exitLabelButton.setForeground(new Color(250, 50, 10));

        // Menu Text change color
        } else if (evt.getSource() == menuLabelButton1) {
            menuLabelButton1.setForeground(new Color(0, 100, 0)); // Text-Button-1
            menuLabelButton1.setBorder(BorderFactory.createLineBorder(new Color(0, 100, 0), 2)); // Border-Button-1
        } else if (evt.getSource() == menuLabelButton2) {
            menuLabelButton2.setForeground(new Color(0, 100, 0)); // Text-Button-2
            menuLabelButton2.setBorder(BorderFactory.createLineBorder(new Color(0, 100, 0), 2)); // Border-Button-2
        } else if (evt.getSource() == menuLabelButton3) {
            menuLabelButton3.setForeground(new Color(0, 100, 0)); // Text-Button-3
            menuLabelButton3.setBorder(BorderFactory.createLineBorder(new Color(0, 100, 0), 2)); // Border-Button-3
        } else if (evt.getSource() == searchLabelButton) {
            searchLabelButton.setForeground(new Color(0, 100, 0)); // Text Search.
            searchLabelButton.setBorder(BorderFactory.createLineBorder(new Color(0, 100, 0), 2)); // Boder Search.
        }
    }

    // Mouse Exited Action.
    public void mouseExited(MouseEvent evt) 
    {
        if (evt.getSource() == exitLabelButton) {
            exitLabelButton.setForeground(new Color(255, 255, 255)); //Exit Button change color
        } else if (evt.getSource() == menuLabelButton1) {
            menuLabelButton1.setForeground(new Color(0, 0, 0)); // Text-Button-1
            menuLabelButton1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2)); // Border-Button-1
        } else if (evt.getSource() == menuLabelButton2) {
            menuLabelButton2.setForeground(new Color(0, 0, 0)); // Text-Button-2
            menuLabelButton2.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2)); // Border-Button-2
        } else if (evt.getSource() == menuLabelButton3) {
            menuLabelButton3.setForeground(new Color(0, 0, 0)); // Text-Button-3
            menuLabelButton3.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2)); // Border-Button-3
        } else if (evt.getSource() == searchLabelButton) {
            searchLabelButton.setForeground(new Color(0, 0, 0)); // Text Search.
            searchLabelButton.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2)); // Boder Search.
        }
    }

    // Button Action.
    public void actionPerformed(ActionEvent evt)
    {
        // Calculator BMI Button.
        if (evt.getSource() == calculButton) {
            try {
                double wei = Double.parseDouble(weiTextInput.getText());
                double hei = Double.parseDouble(heiTextInput.getText());
                textBMILabel.setText("BMI: " + Calculator.calculatorBMI(wei, hei));
            } catch (Exception e) {
                warningTextOption();
            }

        // Warning Button.
        } else if (evt.getSource() == warningButton) {
            JOptionPane.getRootFrame().dispose();
        }
        
    }

    // Warning Option Panel.
    private void warningTextOption()
    {
        warningButton = new JButton();
        warningButton.setText("OK");
        warningButton.setBackground(new Color(255, 255, 255));
        warningButton.setForeground(new Color(0, 0, 0));
        warningButton.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        warningButton.addActionListener(this);
        warningButton.setPreferredSize(new Dimension(50, 25));
        warningButton.setFont(new Font(null, Font.BOLD, 14));
        JButton[] buttons = {warningButton};

        UIManager.put("OptionPane.background",new ColorUIResource(255, 255, 255));
        UIManager.put("Panel.background",new ColorUIResource(255,255, 255));
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Arial", Font.BOLD, 18)));
        UIManager.put("OptionPane.warningDialog.titlePane.shadow", new Color(0, 0, 0));
        UIManager.put("OptionPane.messageForeground", new Color(200, 0, 0));
        JOptionPane.showOptionDialog(
            null,
            "Invalid Input!", 
            "WARNING",
            JOptionPane.OK_OPTION,
            JOptionPane.WARNING_MESSAGE, 
            new ImageIcon("src\\image\\warning.png"),
            buttons,
            buttons[0]);
    }

    // Main Run program.
    public static void main(String[] args)
    {
        try {
            EventQueue.invokeLater(new Runnable() 
            {
                public void run() 
                {
                    new Home().setVisible(true);
                }    
            });
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Your Program is not working.", "ERROR!", JOptionPane.WARNING_MESSAGE);
        }
    }
}