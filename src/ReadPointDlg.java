/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ReadPointDlg.java
 *
 * Created on Jun 2, 2011, 7:06:52 PM
 */

import com.mot.rfid.api3.InvalidUsageException;
import com.mot.rfid.api3.OperationFailureException;
import com.mot.rfid.api3.READPOINT_STATUS;
import java.awt.event.ItemEvent;

/**
 *
 * @author CFRN78
 */
public class ReadPointDlg extends javax.swing.JDialog {
    
private Object makeObj(final String item)  {
     return new Object() { public String toString() { return item; } };
}
    /** Creates new form ReadPointDlg */
    public ReadPointDlg(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        if(RFIDMainDlg.rfidBase.isConnected)
        {
            // If connected via LLRP interface, we can populate the number of antennas correctly.
            // else, let it show a default list of 1 - 8.
            int numAntenna = RFIDMainDlg.rfidBase.getMyReader().ReaderCapabilities.getNumAntennaSupported();
            jComboBoxAntennaID.removeAllItems();
            for(int nIndex = 0; nIndex < numAntenna; nIndex++)
            {
                String antennaString = Integer.toString(nIndex+1);
                 jComboBoxAntennaID.addItem(makeObj(antennaString));
            }
        }
        try {
            READPOINT_STATUS readPointStatus = RFIDMainDlg.rfidBase.rm.ReadPoint.getReadPointStatus((short) 1);
            if (readPointStatus == READPOINT_STATUS.ENABLE)
                jComboBoxStatus.setSelectedIndex(0);
            else
                jComboBoxStatus.setSelectedIndex(1);

        } catch (InvalidUsageException ex) {
            //ex.printStackTrace();
        } catch (OperationFailureException ex) {
            //ex.printStackTrace();
        }

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBoxAntennaID = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxStatus = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Read Point");
        setResizable(false);

        jLabel1.setText("Antenna ID");

        jComboBoxAntennaID.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8" }));
        jComboBoxAntennaID.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                jComboBoxAntennaIDItemStateChanged(evt);
            }
        });

        jLabel2.setText("Status");

        jComboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enable", "Disable" }));

        jButton1.setText("Apply");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxAntennaID, 0, 101, Short.MAX_VALUE))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxAntennaID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         if (RFIDMainDlg.rfidBase.rm.isLoggedIn())
            {
                short antennaID = (short)(jComboBoxAntennaID.getSelectedIndex() + 1);
                try {
                    if (jComboBoxStatus.getSelectedIndex() == 0)
                        RFIDMainDlg.rfidBase.rm.ReadPoint.setReadPointStatus(antennaID, READPOINT_STATUS.ENABLE);
                    else
                        RFIDMainDlg.rfidBase.rm.ReadPoint.setReadPointStatus(antennaID, READPOINT_STATUS.DISABLE);

                    RFIDMainDlg.rfidBase.postStatusNotification(RFIDBase.API_SUCCESS, null);

                } catch (InvalidUsageException ex) {
                    RFIDMainDlg.rfidBase.postStatusNotification(RFIDBase.PARAM_ERROR, ex.getVendorMessage());
                } catch (OperationFailureException ex) {
                    RFIDMainDlg.rfidBase.postStatusNotification(ex.getStatusDescription(), ex.getVendorMessage());
                }
            }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBoxAntennaIDItemStateChanged(ItemEvent evt) {//GEN-FIRST:event_jComboBoxAntennaIDItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED)
        {
            if (RFIDMainDlg.rfidBase.rm.isLoggedIn())
            {
                short antennaID = (short)(jComboBoxAntennaID.getSelectedIndex() + 1);
                try {
                    READPOINT_STATUS readPointStatus = RFIDMainDlg.rfidBase.rm.ReadPoint.getReadPointStatus(antennaID);
                    
                    if (readPointStatus == READPOINT_STATUS.ENABLE)
                        jComboBoxStatus.setSelectedIndex(0);
                    else
                        jComboBoxStatus.setSelectedIndex(1);

                    RFIDMainDlg.rfidBase.postStatusNotification(RFIDBase.API_SUCCESS, null);
                    
                } catch (InvalidUsageException ex) {
                    //ex.printStackTrace();
                } catch (OperationFailureException ex) {
                    RFIDMainDlg.rfidBase.postStatusNotification(ex.getStatusDescription(), ex.getVendorMessage());
                }

            }
        }
    }//GEN-LAST:event_jComboBoxAntennaIDItemStateChanged

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ReadPointDlg dialog = new ReadPointDlg(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBoxAntennaID;
    private javax.swing.JComboBox jComboBoxStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

}
