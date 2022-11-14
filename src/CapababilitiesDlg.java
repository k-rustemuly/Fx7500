/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CapababilitiesDlg.java
 *
 * Created on May 2, 2011, 2:18:54 PM
 */

import com.mot.rfid.api3.ReaderCapabilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author CFRN78
 */
public class CapababilitiesDlg extends javax.swing.JDialog {

    /** Creates new form CapababilitiesDlg */
    public CapababilitiesDlg(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        // Get the table
        TableModel tableModel = jTableCapabilities.getModel();
        int rowId = 0;
        // Get Reader Capabilities
        ReaderCapabilities readerCaps = RFIDMainDlg.rfidBase.getMyReader().ReaderCapabilities;

        ((DefaultTableModel)tableModel).insertRow(rowId++, new Object[] {"ReaderID", readerCaps.ReaderID.getID()});
        ((DefaultTableModel)tableModel).insertRow(rowId++, new Object[] {"Firmware Version", readerCaps.getFirwareVersion() });
        ((DefaultTableModel)tableModel).insertRow(rowId++, new Object[] {"Model Name", readerCaps.getModelName() });
        ((DefaultTableModel)tableModel).insertRow(rowId++, new Object[] {"Number of Antennas", String.valueOf(readerCaps.getNumAntennaSupported())});
        ((DefaultTableModel)tableModel).insertRow(rowId++, new Object[] {"Number of GPI", String.valueOf(readerCaps.getNumGPIPorts())});
        ((DefaultTableModel)tableModel).insertRow(rowId++, new Object[] {"Number of GPO", String.valueOf(readerCaps.getNumGPOPorts())});
        ((DefaultTableModel)tableModel).insertRow(rowId++, new Object[] {"Max Ops in Access Sequence", String.valueOf(readerCaps.getMaxNumOperationsInAccessSequence())});
        ((DefaultTableModel)tableModel).insertRow(rowId++, new Object[] {"Max No. of Pre-Filters", String.valueOf(readerCaps.getMaxNumPreFilters())});
        ((DefaultTableModel)tableModel).insertRow(rowId++, new Object[] {"Country Code", String.valueOf(readerCaps.getCountryCode())});
        ((DefaultTableModel)tableModel).insertRow(rowId++, new Object[] {"Communication Standard", readerCaps.getCommunicationStandard().toString()});
        ((DefaultTableModel)tableModel).insertRow(rowId++, new Object[] {"UTC Clock", readerCaps.isUTCClockSupported() ? "Yes" : "No"});
        ((DefaultTableModel)tableModel).insertRow(rowId++, new Object[] {"Block Erase", readerCaps.isBlockEraseSupported() ? "Yes" : "No"});
        ((DefaultTableModel)tableModel).insertRow(rowId++, new Object[] {"Block Write", readerCaps.isBlockWriteSupported() ? "Yes" : "No"});
        ((DefaultTableModel)tableModel).insertRow(rowId++, new Object[] {"Block Permalock", readerCaps.isBlockPermalockSupported() ? "Yes" : "No"});
        ((DefaultTableModel)tableModel).insertRow(rowId++, new Object[] {"Recommission", readerCaps.isRecommisionSupported() ? "Yes" : "No"});
        ((DefaultTableModel)tableModel).insertRow(rowId++, new Object[] {"Write UMI", readerCaps.isWriteUMISupported() ? "Yes" : "No"});
        ((DefaultTableModel)tableModel).insertRow(rowId++, new Object[] {"State-aware Singulation", readerCaps.isTagInventoryStateAwareSingulationSupported() ? "Yes" : "No"});
        ((DefaultTableModel)tableModel).insertRow(rowId++, new Object[] {"Tag Event Reporting Supported", readerCaps.isTagEventReportingSupported() ? "Yes" : "No"});
        ((DefaultTableModel)tableModel).insertRow(rowId++, new Object[] {"RSSI Filter Supported", readerCaps.isRSSIFilterSupported() ? "Yes" : "No"});
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCapabilities = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Capabilities");
        setResizable(false);

        jTableCapabilities.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Capability", "Value"
            }
        ));
        jTableCapabilities.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableCapabilities.setShowHorizontalLines(false);
        jTableCapabilities.setShowVerticalLines(false);
        jScrollPane1.setViewportView(jTableCapabilities);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CapababilitiesDlg dialog = new CapababilitiesDlg(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCapabilities;
    // End of variables declaration//GEN-END:variables

}