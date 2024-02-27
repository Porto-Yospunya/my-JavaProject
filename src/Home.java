import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
    private JPanel tab4;
    private JPanel tab5;
    
    // Label variable setup.
    private JLabel titLabel;
    private JLabel textmenuLabel1; // Tab Home
    private JLabel textmenuLabel2; // Tab Information food
    private JLabel textweiLabel;
    private JLabel textheiLabel;
    private JLabel textweiunitLabel;
    private JLabel textheiunitLabel;
    private JLabel textBMILabel;

    private JLabel exitLabelButton;
    private JLabel minimizeLabelButton;
    private JLabel menuLabelButton1; // Home
    private JLabel menuLabelButton2; // Information food
    private JLabel menuLabelButton3; // BMI
    private JLabel menuLabelButton4; // BMR
    private JLabel menuLabelButton5; // Calorie burning activities
    private JLabel clearLabelButton;
    private JLabel calculBMILabelButton;

    private JLabel iconImg;

    // Button variable setup.
    private JButton warningButton;

    // Text Field variable setup.
    private JTextField weiTextInput;
    private JTextField heiTextInput;

    private JTextField searchText;

    // Separator variable setup.
    private JSeparator titSeparator;
    private JSeparator menuSeparator;

    // Tabbed variable setup.
    private JTabbedPane jTabbed;

    // Table variable setup.
    private JTable foodTable;

    // Scroll variable setup.
    private JScrollPane scrollPane;

    // Table Model variable setup.
    private DefaultTableModel model;

    // Renderer variable setup.
    private DefaultTableCellRenderer renderer;

    // Connection Database variable setup.
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

        tab4 = new JPanel();
        tab4.setBounds(250, 40, 950, 760);
        tab4.setBackground(new Color(255, 255, 255));
        tab4.setLayout(null);

        tab5 = new JPanel();
        tab5.setBounds(250, 40, 950, 760);
        tab5.setBackground(new Color(255, 255, 255));
        tab5.setLayout(null);

        // Add Tab zone.
        jTabbed.add("1", tab1);
        jTabbed.add("2", tab2);
        jTabbed.add("3", tab3);
        jTabbed.add("4", tab4);
        jTabbed.add("5", tab5);
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

        // Info food Button.
        menuLabelButton2 = new JLabel();
        menuLabelButton2.setText("NUTRITION INFO");
        menuLabelButton2.setForeground(new Color(0, 0, 0));
        menuLabelButton2.setFont(new Font("", Font.BOLD, 20));
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

        menuLabelButton4 = new JLabel();
        menuLabelButton4.setText("BMR");
        menuLabelButton4.setForeground(new Color(0, 0, 0));
        menuLabelButton4.setFont(new Font("", Font.BOLD, 25));
        menuLabelButton4.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        menuLabelButton4.setBounds(20, 160, 200, 40);
        menuLabelButton4.setHorizontalAlignment(JLabel.CENTER);
        menuLabelButton4.addMouseListener(this);

        menuLabelButton5 = new JLabel();
        menuLabelButton5.setText("CALORIE BURNING");
        menuLabelButton5.setForeground(new Color(0, 0, 0));
        menuLabelButton5.setFont(new Font("", Font.BOLD, 20));
        menuLabelButton5.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        menuLabelButton5.setBounds(20, 210, 200, 40);
        menuLabelButton5.setHorizontalAlignment(JLabel.CENTER);
        menuLabelButton5.addMouseListener(this);

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
        bgPanel2.add(menuLabelButton4);
        bgPanel2.add(menuLabelButton5);
        bgPanel2.add(menuSeparator);
    }

    // Tab Panel-1 Home.
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
        iconImg.setBounds(0, 20, 950, 200);
        iconImg.setHorizontalAlignment(JLabel.CENTER);
        
        // Add zone
        tab1.add(textmenuLabel1);
        tab1.add(iconImg);
    }
    
    // Tab Panel-2 Info Food.
    private void menuInfoPanel()
    {
        // Text Menu.
        textmenuLabel2 = new JLabel();
        textmenuLabel2.setText("Nutrition Information");
        textmenuLabel2.setBounds(0, 30, 950, 50);
        textmenuLabel2.setHorizontalAlignment(JLabel.CENTER);
        textmenuLabel2.setFont(new Font("", Font.BOLD, 40));
        textmenuLabel2.setForeground(new Color(0, 0, 0));

        // Text Field Search.
        searchText = new JTextField();
        searchText.setBounds(40, 100, 750, 30);
        searchText.setFont(new Font("TH SarabunPSK", Font.PLAIN, 28));
        searchText.setBackground(new Color(255, 255, 255));
        searchText.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        searchText.addKeyListener(new KeyAdapter() 
        {
            public void keyPressed(KeyEvent evt)
            {
                searchFoodInput(evt);
            }
        });
        createTable("select * from dbfood.food");

        // Text clear Button.
        clearLabelButton = new JLabel();
        clearLabelButton.setText("Clear");
        clearLabelButton.setBounds(799, 100, 110, 30);
        clearLabelButton.setFont(new Font("", Font.BOLD, 18));
        clearLabelButton.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        clearLabelButton.setHorizontalAlignment(JLabel.CENTER);
        clearLabelButton.addMouseListener(this);

        // Add zone.
        tab2.add(textmenuLabel2);
        tab2.add(searchText);
        tab2.add(clearLabelButton);
        tab2.add(scrollPane, BorderLayout.CENTER);
    }

    // Tab Panel-3 BMI.
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

        // Answer Label.
        textBMILabel = new JLabel();
        textBMILabel.setText("BMI: 0");
        textBMILabel.setFont(new Font("", Font.BOLD, 30));
        textBMILabel.setForeground(new Color(0, 0, 0));
        textBMILabel.setBounds(200, 230, 200, 40);
        textBMILabel.setHorizontalAlignment(JLabel.LEFT);

        // Calculator BMI Button.
        calculBMILabelButton = new JLabel();
        calculBMILabelButton.setText("Enter");
        calculBMILabelButton.setFont(new Font("", Font.PLAIN, 20));
        calculBMILabelButton.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        calculBMILabelButton.setBounds(40, 230, 100, 40);
        calculBMILabelButton.setHorizontalAlignment(JLabel.CENTER);
        calculBMILabelButton.addMouseListener(this);

        // Add zone.
        calculPanel.add(textweiLabel);
        calculPanel.add(textheiLabel);
        calculPanel.add(textweiunitLabel);
        calculPanel.add(textheiunitLabel);
        calculPanel.add(textBMILabel);
        calculPanel.add(weiTextInput);
        calculPanel.add(heiTextInput);
        calculPanel.add(calculBMILabelButton);
        
        tab3.add(calculPanel);
    }
    
    // Create Table Database by MySQL.
    private void createTable(String sql)
    {
        // Table setup.
        String[] colname = {"Menu", "Unit" , "Calories (kcal.)", "Protein (g.)", "Carbohydrate (g.)", "Fat (g.)", "Codium (g.)"};
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
            ResultSet resultSet = db.getConnect(sql); // Pull Database

            while (resultSet.next())
            {
                String name = resultSet.getString("name");
                String un = resultSet.getString("unit");
                String cal = resultSet.getString("calories");
                String pt = resultSet.getString("protein");
                String carbo = resultSet.getString("carbohydrate");
                String fat  = resultSet.getString("fat");
                String cd = resultSet.getString("codium");
                String[] row = {name, un, cal, pt, carbo, fat, cd};
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
        foodTable.setEnabled(false);

        foodTable.getTableHeader().setFont(new Font(null, Font.BOLD, 16));
        foodTable.getTableHeader().setReorderingAllowed(false);
        foodTable.getTableHeader().setEnabled(false);
 
        // Edit colunm.
        foodTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        foodTable.getColumnModel().getColumn(0).setPreferredWidth(252); // Name
        foodTable.getColumnModel().getColumn(1).setPreferredWidth(70); // unit
        foodTable.getColumnModel().getColumn(2).setPreferredWidth(125); // Calories
        foodTable.getColumnModel().getColumn(3).setPreferredWidth(100); // Protein
        foodTable.getColumnModel().getColumn(4).setPreferredWidth(150); // Carbo
        foodTable.getColumnModel().getColumn(5).setPreferredWidth(70); // fat
        foodTable.getColumnModel().getColumn(6).setPreferredWidth(100); // codium
        
        // Edit Header Horizontal Alignment
        renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 1; i < colname.length; i++) 
        {
            foodTable.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }

        // Add Table in ScrollPane
        scrollPane = new JScrollPane(foodTable);
        scrollPane.setBounds(40, 140, 870, 600);
        tab2.add(scrollPane, BorderLayout.CENTER);
    }

    // Search Food method.
    private void searchFoodInput(KeyEvent evt)
    {
        DefaultTableModel table = (DefaultTableModel)foodTable.getModel();
        String search = searchText.getText().toLowerCase();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        foodTable.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
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
        } else if (evt.getSource() == menuLabelButton4) {
            menuLabelButton4.setForeground(new Color(255, 255, 255)); // Text-Button-4
        } else if (evt.getSource() == menuLabelButton5) {
            menuLabelButton5.setForeground(new Color(255, 255, 255)); // Text-Button-5
        } else if (evt.getSource() == clearLabelButton) {
            clearLabelButton.setForeground(new Color(255, 255, 255)); // Search Food Button
        } else if (evt.getSource() == calculBMILabelButton) {
            calculBMILabelButton.setForeground(new Color(152, 251, 152)); // 
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
        } else if (evt.getSource() == menuLabelButton4) {
            menuLabelButton4.setForeground(new Color(0, 100, 0)); // Text-Button-4
        } else if (evt.getSource() == menuLabelButton5) {
            menuLabelButton5.setForeground(new Color(0, 100, 0)); // Text-Button-5
        } else if (evt.getSource() == clearLabelButton) {
            clearLabelButton.setForeground(new Color(0, 100, 0)); // Search Food Button
        } else if (evt.getSource() == calculBMILabelButton) {
            calculBMILabelButton.setForeground(new Color(0, 100, 0)); // 
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
        } else if (evt.getSource() == menuLabelButton4) {
            jTabbed.setSelectedIndex(3); // Tab-BMR.
        } else if (evt.getSource() == menuLabelButton5) {
            jTabbed.setSelectedIndex(4); // Tab-Burn.
        } else if (evt.getSource() == clearLabelButton) {
            searchText.setText("");
            createTable("SELECT * FROM dbfood.food"); // Clear and default Table
            db.disconnect();
        } else if (evt.getSource() == calculBMILabelButton) {
            try {
                double wei = Double.parseDouble(weiTextInput.getText());
                double hei = Double.parseDouble(heiTextInput.getText());
                textBMILabel.setText("BMI: " + Calculator.calculatorBMI(wei, hei));
            } catch (Exception e) {
                warningTextOption();
            }
        }
    }

    // Mouse Entered Action.
    public void mouseEntered(MouseEvent evt)
    {
        if (evt.getSource() == exitLabelButton) {
            exitLabelButton.setForeground(new Color(250, 50, 10)); // Exit Button.
        } else if (evt.getSource() == menuLabelButton1) {
            menuLabelButton1.setForeground(new Color(0, 100, 0)); // Text-Button-1
            menuLabelButton1.setBorder(BorderFactory.createLineBorder(new Color(0, 100, 0), 2)); // Border-Button-1
        } else if (evt.getSource() == menuLabelButton2) {
            menuLabelButton2.setForeground(new Color(0, 100, 0)); // Text-Button-2
            menuLabelButton2.setBorder(BorderFactory.createLineBorder(new Color(0, 100, 0), 2)); // Border-Button-2
        } else if (evt.getSource() == menuLabelButton3) {
            menuLabelButton3.setForeground(new Color(0, 100, 0)); // Text-Button-3
            menuLabelButton3.setBorder(BorderFactory.createLineBorder(new Color(0, 100, 0), 2)); // Border-Button-3
        } else if (evt.getSource() == menuLabelButton4) {
            menuLabelButton4.setForeground(new Color(0, 100, 0)); // Text-Button-4
            menuLabelButton4.setBorder(BorderFactory.createLineBorder(new Color(0, 100, 0), 2)); // Border-Button-4
        } else if (evt.getSource() == menuLabelButton5) {
            menuLabelButton5.setForeground(new Color(0, 100, 0)); // Text-Button-5
            menuLabelButton5.setBorder(BorderFactory.createLineBorder(new Color(0, 100, 0), 2)); // Border-Button-5
        } else if (evt.getSource() == clearLabelButton) {
            clearLabelButton.setForeground(new Color(0, 100, 0)); // Text Search.
            clearLabelButton.setBorder(BorderFactory.createLineBorder(new Color(0, 100, 0), 2)); // Boder Search.
        } else if (evt.getSource() == calculBMILabelButton) {
            calculBMILabelButton.setForeground(new Color(0, 100, 0)); // Text Calculate BMI Button
            calculBMILabelButton.setBorder(BorderFactory.createLineBorder(new Color(0, 100, 0), 2)); // Border Calculate BMI Button.
        }
    }

    // Mouse Exited Action.
    public void mouseExited(MouseEvent evt) 
    {
        if (evt.getSource() == exitLabelButton) {
            exitLabelButton.setForeground(new Color(255, 255, 255)); //Exit Button.
        } else if (evt.getSource() == menuLabelButton1) {
            menuLabelButton1.setForeground(new Color(0, 0, 0)); // Text-Button-1
            menuLabelButton1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2)); // Border-Button-1
        } else if (evt.getSource() == menuLabelButton2) {
            menuLabelButton2.setForeground(new Color(0, 0, 0)); // Text-Button-2
            menuLabelButton2.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2)); // Border-Button-2
        } else if (evt.getSource() == menuLabelButton3) {
            menuLabelButton3.setForeground(new Color(0, 0, 0)); // Text-Button-3
            menuLabelButton3.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2)); // Border-Button-3
        } else if (evt.getSource() == menuLabelButton4) {
            menuLabelButton4.setForeground(new Color(0, 0, 0)); // Text-Button-4
            menuLabelButton4.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2)); // Border-Button-4
        } else if (evt.getSource() == menuLabelButton5) {
            menuLabelButton5.setForeground(new Color(0, 0, 0)); // Text-Button-5
            menuLabelButton5.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2)); // Border-Button-5
        } else if (evt.getSource() == clearLabelButton) {
            clearLabelButton.setForeground(new Color(0, 0, 0)); // Text Search.
            clearLabelButton.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2)); // Boder Search.
        } else if (evt.getSource() == calculBMILabelButton) {
            calculBMILabelButton.setForeground(new Color(0, 0, 0)); // Text Calculate BMI Button
            calculBMILabelButton.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2)); // Border Calculate BMI Button.
        }
    }

    public void actionPerformed(ActionEvent evt)
    {
        if (evt.getSource() == warningButton) {
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
        warningButton.setPreferredSize(new Dimension(50, 25));
        warningButton.setFont(new Font(null, Font.BOLD, 14));
        warningButton.addActionListener(this);
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