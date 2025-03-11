package bcs_room_type_price;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class RoomTypePriceEditorUI extends JFrame {

    private IRoomTypePriceService roomPriceService;
    private JTable roomTable;
    private DefaultTableModel tableModel;

    // Form fields for editing
    private JTextField txtRoomType;
    private JTextField txtPrice;
    private JTextField txtDiscount;
    
    public RoomTypePriceEditorUI(IRoomTypePriceService roomPriceService) {
        this.roomPriceService = roomPriceService;
        setTitle("Room Type Price Editor");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
    }

    private void initUI() {
        setLayout(new BorderLayout());

        // Table setup with non-editable cells
        String[] columnNames = {"Room Type", "Price", "Discount"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make all cells non-editable
            }
        };
        
        roomTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(roomTable);

        // Load data into table
        loadRoomData();

        add(scrollPane, BorderLayout.CENTER);

        // Edit Form Panel
        JPanel editPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        txtRoomType = new JTextField();
        txtPrice = new JTextField();
        txtDiscount = new JTextField();

        editPanel.add(new JLabel("Room Type:"));
        editPanel.add(txtRoomType);
        editPanel.add(new JLabel("Price:"));
        editPanel.add(txtPrice);
        editPanel.add(new JLabel("Discount (%):"));
        editPanel.add(txtDiscount);

        JButton btnSave = new JButton("Save");
        editPanel.add(new JLabel()); // Empty space
        editPanel.add(btnSave);

        add(editPanel, BorderLayout.SOUTH);

        // Table row selection event
        roomTable.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = roomTable.getSelectedRow();
            if (selectedRow >= 0) {
                txtRoomType.setText((String) tableModel.getValueAt(selectedRow, 0));
                txtPrice.setText(String.valueOf(tableModel.getValueAt(selectedRow, 1)));
                txtDiscount.setText(String.valueOf(tableModel.getValueAt(selectedRow, 2)));
                txtRoomType.setEditable(false); // Room type should not be editable (acts as ID)
            }
        });

        // Save button action
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveRoomData();
            }
        });
    }

    private void loadRoomData() {
        tableModel.setRowCount(0); // Clear existing rows
        Map<String, RoomTypePrices> roomData = ((RoomTypePriceServiceImpl) roomPriceService).getRoomPriceDatabase();

        for (RoomTypePrices room : roomData.values()) {
            tableModel.addRow(new Object[]{room.Roomtype, room.price, room.discount});
        }
    }

    private void saveRoomData() {
        String roomType = txtRoomType.getText().trim();
        String priceText = txtPrice.getText().trim();
        String discountText = txtDiscount.getText().trim();

        if (roomType.isEmpty() || priceText.isEmpty() || discountText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            double price = Double.parseDouble(priceText);
            double discount = Double.parseDouble(discountText);

            RoomTypePrices updatedRoom = new RoomTypePrices(roomType, discount, price);
            roomPriceService.addRoomPriceWithTag(updatedRoom);

            loadRoomData(); // Refresh table data
            JOptionPane.showMessageDialog(this, "Room details updated successfully!");

            // Clear input fields after saving
            txtRoomType.setText("");
            txtPrice.setText("");
            txtDiscount.setText("");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Price and Discount must be valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
