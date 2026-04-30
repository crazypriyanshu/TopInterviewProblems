package org.pdas.arrays.mostAskedProblems.inventoryManagement;

import javax.swing.*;

public class PopUpAlertListener implements InventoryListener{
    @Override
    public void onThresholdBreach(String itemName, int currStock) {
        SwingUtilities.invokeLater(() -> {
            JOptionPane.showMessageDialog(null, "Critical Stock Alert: "+itemName+" has only "+currStock+" quantity left in inventory", "Inventory Management", JOptionPane.WARNING_MESSAGE);
        });
    }
}
