/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Connection.java
 *
 * Created on Apr 29, 2011, 1:21:59 PM
 */

import com.mot.rfid.api3.LoginInfo;
import com.mot.rfid.api3.READER_ID_TYPE;
import com.mot.rfid.api3.READER_TYPE;
import com.mot.rfid.api3.SECURE_MODE;

/**
 *
 * @author CFRN78
 */
public class LoginDlg extends javax.swing.JDialog {

    LoginInfo loginInfo = null;
    /** Creates new form Connection */
    public LoginDlg(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        loginInfo = RFIDMainDlg.rfidBase.loginInfo;

        if (RFIDMainDlg.rfidBase.isRmConnected == true)
        {
             jComboBoxReaderType.setSelectedIndex(RFIDMainDlg.rfidBase.readerTypeIndex);
             jTextFieldIP.setText(loginInfo.getHostName());
             jTextFieldUserName.setText(loginInfo.getUserName());
             jPasswordField.setText(loginInfo.getPassword());
             jComboBoxReaderType.setEnabled(false);
             jTextFieldIP.setEnabled(false);
             jTextFieldUserName.setEnabled(false);
             jPasswordField.setEnabled(false);
             jButtonConnect.setText("Logout");
        }
        else
        {
             jComboBoxReaderType.setSelectedIndex(RFIDMainDlg.rfidBase.readerTypeIndex);
             jTextFieldIP.setText(loginInfo.getHostName());
             jTextFieldUserName.setText(loginInfo.getUserName());

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
        jTextFieldIP = new javax.swing.JTextField();
        jButtonConnect = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldUserName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxReaderType = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jPasswordField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setModal(true);
        setResizable(false);

        jLabel1.setText("Host Name/IP:");

        jButtonConnect.setText("Login");
        jButtonConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConnectActionPerformed(evt);
            }
        });

        jLabel2.setText("User Name:");

        jLabel3.setText("Reader Type:");

        jComboBoxReaderType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "XR", "FX", "MC" }));
        jComboBoxReaderType.setSelectedIndex(1);

        jLabel4.setText("Password:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonConnect))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPasswordField, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(jComboBoxReaderType, 0, 143, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldIP)
                                .addComponent(jTextFieldUserName, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)))))
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxReaderType, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jButtonConnect)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConnectActionPerformed
        int readerTypeIndex = 0;
        if (jButtonConnect.getText().equals("Login"))
        {
            loginInfo.setHostName(jTextFieldIP.getText());
            loginInfo.setUserName(jTextFieldUserName.getText());
            loginInfo.setPassword(jPasswordField.getText());
            loginInfo.setSecureMode(SECURE_MODE.HTTP);
            loginInfo.setForceLogin(true);
            
            readerTypeIndex = jComboBoxReaderType.getSelectedIndex();

            if (RFIDMainDlg.rfidBase.logIn(getReaderType(readerTypeIndex)))
            {
                RFIDMainDlg.rfidBase.readerTypeIndex = readerTypeIndex;
                jButtonConnect.setText("Logout");
                this.dispose();
            }
            else
            {
                jTextFieldIP.requestFocusInWindow();
            }
        }
        else
        {
            RFIDMainDlg.rfidBase.logOut();
            jButtonConnect.setText("Login");

            jComboBoxReaderType.setEnabled(true);
            jTextFieldIP.setEnabled(true);
            jTextFieldUserName.setEnabled(true);
            jPasswordField.setEnabled(true);

            jTextFieldIP.requestFocusInWindow();
        }
    }//GEN-LAST:event_jButtonConnectActionPerformed

    READER_TYPE getReaderType(int index)
    {
        READER_TYPE readerType = READER_TYPE.FX;

        switch (index)
        {
            case 0:
                readerType = READER_TYPE.XR;
                break;
            case 1:
                readerType = READER_TYPE.FX;
                break;
            case 2:
                readerType = READER_TYPE.MC;
                break;
        }
        return readerType;
    }
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginDlg dialog = new LoginDlg(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonConnect;
    private javax.swing.JComboBox jComboBoxReaderType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JTextField jTextFieldIP;
    private javax.swing.JTextField jTextFieldUserName;
    // End of variables declaration//GEN-END:variables

}
