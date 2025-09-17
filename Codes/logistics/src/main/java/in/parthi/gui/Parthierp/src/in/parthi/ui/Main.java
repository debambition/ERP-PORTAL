package in.parthi.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

public class Main {

    private JFrame frame;
    private JTextArea statusArea;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main window = new Main();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Main() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Garment Shop ERP System");
        frame.setBounds(100, 100, 450, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        // Title Label
        JLabel titleLabel = new JLabel("Garment Shop ERP Menu");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(10, 20, 414, 30);
        frame.getContentPane().add(titleLabel);

        // Buttons
        JButton addProductBtn = new JButton("1] Add Product");
        addProductBtn.setBounds(100, 80, 250, 30);
        frame.getContentPane().add(addProductBtn);
        
        JButton addVendorProductsBtn = new JButton("2] Add Products (Vendor)");
        addVendorProductsBtn.setBounds(100, 120, 250, 30);
        frame.getContentPane().add(addVendorProductsBtn);

        JButton getProductBtn = new JButton("3] Get Product");
        getProductBtn.setBounds(100, 160, 250, 30);
        frame.getContentPane().add(getProductBtn);

        JButton returnProductBtn = new JButton("4] Return Product");
        returnProductBtn.setBounds(100, 200, 250, 30);
        frame.getContentPane().add(returnProductBtn);

        JButton addTransactionBtn = new JButton("5] Add Transaction");
        addTransactionBtn.setBounds(100, 240, 250, 30);
        frame.getContentPane().add(addTransactionBtn);

        JButton getTransactionBtn = new JButton("6] Get Transaction");
        getTransactionBtn.setBounds(100, 280, 250, 30);
        frame.getContentPane().add(getTransactionBtn);

        JButton addInvoiceBtn = new JButton("7] Add Invoice");
        addInvoiceBtn.setBounds(100, 320, 250, 30);
        frame.getContentPane().add(addInvoiceBtn);

        JButton exitBtn = new JButton("8] Exit the App");
        exitBtn.setBounds(100, 360, 250, 30);
        frame.getContentPane().add(exitBtn);

        // Status Area
        statusArea = new JTextArea();
        statusArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(statusArea);
        scrollPane.setBounds(20, 400, 400, 100);
        frame.getContentPane().add(scrollPane);

        // Action Listeners
        addProductBtn.addActionListener(e -> statusArea.append("Add product feature is not yet implemented.\n"));
        addVendorProductsBtn.addActionListener(e -> statusArea.append("Add products (Vendor) feature is not yet implemented.\n"));
        getProductBtn.addActionListener(e -> statusArea.append("Get Product feature is not yet implemented.\n"));
        returnProductBtn.addActionListener(e -> statusArea.append("Return product feature is not yet implemented.\n"));
        addTransactionBtn.addActionListener(e -> statusArea.append("Add Transaction feature is not yet implemented.\n"));
        getTransactionBtn.addActionListener(e -> statusArea.append("Get Transaction feature is not yet implemented.\n"));
        addInvoiceBtn.addActionListener(e -> statusArea.append("Add Invoice feature is not yet implemented.\n"));
        exitBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Exiting the application. Goodbye!", "Exit", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        });
    }
}
