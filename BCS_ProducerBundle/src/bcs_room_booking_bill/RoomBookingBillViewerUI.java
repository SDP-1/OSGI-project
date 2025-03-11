package bcs_room_booking_bill;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoomBookingBillViewerUI extends JFrame {
    private RoomBookingBill bill;

    public RoomBookingBillViewerUI(RoomBookingBill bill) {
        this.bill = bill;
        setTitle("Room Booking Bill Viewer");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
    }

    private void initUI() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Bill Information Output Area
        JTextArea outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        panel.add(scrollPane, BorderLayout.CENTER);

        // Display the bill information in the text area
        if (bill != null) {
            outputArea.setText(
            		"Bill ID: \t\t" + bill.billId + "\n"
                    + "Room ID: \t\t" + bill.roomId + "\n"
                    + "Room Type: \t\t" + bill.RoomType + "\n"
                    + "Days: \t\t" + bill.dates + "\n" 
                    + "Discount precentage : \t" + bill.descount + "%\n"
                    + "Total Price: \t\t" + bill.TotalPricce + "\n"
                    
                    );
        } else {
            outputArea.setText("No bill information available.");
        }

        add(panel);
    }
}
