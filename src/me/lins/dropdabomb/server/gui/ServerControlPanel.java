/*
 *  DropDaBomb
 *  Copyright (C) 2008-2013 Christian Lins <christian@lins.me>
 *  Copyright (C) 2008 Kai Ritterbusch <kai.ritterbusch@googlemail.com>
 * 
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package me.lins.dropdabomb.server.gui;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JScrollBar;

import me.lins.dropdabomb.server.Database;
import me.lins.dropdabomb.server.Game;
import me.lins.dropdabomb.server.Highscore;
import me.lins.dropdabomb.server.Server;
import me.lins.dropdabomb.server.ServerThread;

/**
 * Main control panel of the Server.
 * 
 * @author Christian Lins
 * @author Kai Ritterbusch
 */
@SuppressWarnings("serial")
public class ServerControlPanel extends javax.swing.JPanel {
    private static ServerControlPanel instance = null;

    /**
     * @return The created instance of this.
     */
    public static ServerControlPanel getInstance() {
        return instance;
    }

    private ServerThread serverThread;

    /**
     * Creates new form ServerControlPanel.
     */
    public ServerControlPanel(ServerThread thread) {
        initComponents();
        setThread(thread);
        instance = this;

        Database db = Server.getInstance().getDatabase();
        for (String user : db.getUsers()) {
            ArrayList<Object> data = new ArrayList<Object>();
            data.add(user);
            data.add("offline");
            ((UserListTableModel) getTblUserList().getModel()).addRow(data);
        }
    }

    /**
     * Adds a new log message to the log view.
     */
    public void addLogMessages(String txt) {
        // Creates actual Date
        Calendar cal = new GregorianCalendar(TimeZone.getTimeZone("ECT"));
        SimpleDateFormat formater = new SimpleDateFormat();
        String date = formater.format(cal.getTime());

        // Adds logsmessage to textarea
        txtLog.setText("(" + date + "): " + txt + "\n" + txtLog.getText());

        // Sets Scrollposition to 0
        JScrollBar vbar = scrPane.getVerticalScrollBar();
        vbar.setValue(vbar.getMinimum());
    }

    /**
     * Adds game to List.
     */
    public void addGame(Game game) {
        ((DefaultListModel<Game>) liGames.getModel()).addElement(game);
    }

    /**
     * Removes Game from list.
     */
    public void removeGame(Game game) {
        ((DefaultListModel<Game>) liGames.getModel()).removeElement(game);
    }

    /**
     * Sets the ServerThread this panel can control.
     * 
     * @param thread
     */
    private void setThread(ServerThread thread) {
        this.serverThread = thread;
        if (thread == null || !thread.isAlive()) {
            btnStartServer.setEnabled(true);
            btnStopServer.setEnabled(false);
        } else {
            btnStartServer.setEnabled(false);
            btnStopServer.setEnabled(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed"
    // desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCaption = new javax.swing.JLabel();
        btnStartServer = new javax.swing.JButton();
        btnStopServer = new javax.swing.JButton();
        lblStartServer = new javax.swing.JLabel();
        lblStopServer = new javax.swing.JLabel();
        tabbedPane = new javax.swing.JTabbedPane();
        tabLog = new javax.swing.JPanel();
        scrPane = new javax.swing.JScrollPane();
        txtLog = new javax.swing.JTextArea();
        tabGames = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        liGames = new javax.swing.JList<Game>();
        btnCloseGame = new javax.swing.JButton();
        tabUsers = new javax.swing.JPanel();
        btnKick = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUserList = new javax.swing.JTable();
        btnCreateUser = new javax.swing.JButton();
        btnRemoveUser = new javax.swing.JButton();
        btnHighscoreExport = new javax.swing.JButton();
        lblExportHighscore = new javax.swing.JLabel();

        lblCaption.setText("Here you can administrate the DropDaBomb server:");

        btnStartServer.setText("Start server");
        btnStartServer.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartServerActionPerformed(evt);
            }
        });

        btnStopServer.setText("Stop server");
        btnStopServer.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopServerActionPerformed(evt);
            }
        });

        lblStartServer.setText("Server is started on local host");

        lblStopServer.setText("Stop server and all games");

        txtLog.setColumns(20);
        txtLog.setRows(5);
        scrPane.setViewportView(txtLog);

        org.jdesktop.layout.GroupLayout tabLogLayout = new org.jdesktop.layout.GroupLayout(
                tabLog);
        tabLog.setLayout(tabLogLayout);
        tabLogLayout.setHorizontalGroup(tabLogLayout.createParallelGroup(
                org.jdesktop.layout.GroupLayout.LEADING).add(scrPane,
                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 430,
                Short.MAX_VALUE));
        tabLogLayout.setVerticalGroup(tabLogLayout.createParallelGroup(
                org.jdesktop.layout.GroupLayout.LEADING).add(scrPane,
                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 176,
                Short.MAX_VALUE));

        tabbedPane.addTab("Log", tabLog);

        liGames.setModel(new DefaultListModel<Game>());
        jScrollPane2.setViewportView(liGames);

        btnCloseGame.setText("End game");
        btnCloseGame.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseGameActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout tabGamesLayout = new org.jdesktop.layout.GroupLayout(
                tabGames);
        tabGames.setLayout(tabGamesLayout);
        tabGamesLayout.setHorizontalGroup(tabGamesLayout.createParallelGroup(
                org.jdesktop.layout.GroupLayout.LEADING).add(
                org.jdesktop.layout.GroupLayout.TRAILING,
                tabGamesLayout
                        .createSequentialGroup()
                        .addContainerGap()
                        .add(jScrollPane2,
                                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                322, Short.MAX_VALUE).add(18, 18, 18)
                        .add(btnCloseGame).addContainerGap()));
        tabGamesLayout
                .setVerticalGroup(tabGamesLayout
                        .createParallelGroup(
                                org.jdesktop.layout.GroupLayout.LEADING)
                        .add(tabGamesLayout
                                .createSequentialGroup()
                                .addContainerGap()
                                .add(tabGamesLayout
                                        .createParallelGroup(
                                                org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(jScrollPane2,
                                                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                152, Short.MAX_VALUE)
                                        .add(btnCloseGame)).addContainerGap()));

        tabbedPane.addTab("Spiele", tabGames);

        btnKick.setText("Kick user");
        btnKick.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKickActionPerformed(evt);
            }
        });

        tblUserList.setModel(new UserListTableModel());
        jScrollPane1.setViewportView(tblUserList);

        btnCreateUser.setText("New user");
        btnCreateUser.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateUserActionPerformed(evt);
            }
        });

        btnRemoveUser.setText("Remove user");
        btnRemoveUser.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveUserActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout tabUsersLayout = new org.jdesktop.layout.GroupLayout(
                tabUsers);
        tabUsers.setLayout(tabUsersLayout);
        tabUsersLayout
                .setHorizontalGroup(tabUsersLayout
                        .createParallelGroup(
                                org.jdesktop.layout.GroupLayout.LEADING)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING,
                                tabUsersLayout
                                        .createSequentialGroup()
                                        .addContainerGap()
                                        .add(jScrollPane1,
                                                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                305, Short.MAX_VALUE)
                                        .addPreferredGap(
                                                org.jdesktop.layout.LayoutStyle.UNRELATED)
                                        .add(tabUsersLayout
                                                .createParallelGroup(
                                                        org.jdesktop.layout.GroupLayout.TRAILING,
                                                        false)
                                                .add(org.jdesktop.layout.GroupLayout.LEADING,
                                                        btnRemoveUser,
                                                        org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                        89, Short.MAX_VALUE)
                                                .add(org.jdesktop.layout.GroupLayout.LEADING,
                                                        btnCreateUser,
                                                        org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                        89, Short.MAX_VALUE)
                                                .add(org.jdesktop.layout.GroupLayout.LEADING,
                                                        btnKick,
                                                        org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                        org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                        Short.MAX_VALUE))
                                        .addContainerGap()));
        tabUsersLayout
                .setVerticalGroup(tabUsersLayout
                        .createParallelGroup(
                                org.jdesktop.layout.GroupLayout.LEADING)
                        .add(tabUsersLayout
                                .createSequentialGroup()
                                .addContainerGap()
                                .add(tabUsersLayout
                                        .createParallelGroup(
                                                org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(jScrollPane1,
                                                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                152, Short.MAX_VALUE)
                                        .add(tabUsersLayout
                                                .createSequentialGroup()
                                                .add(btnCreateUser)
                                                .addPreferredGap(
                                                        org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(btnRemoveUser)
                                                .addPreferredGap(
                                                        org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(btnKick)))
                                .addContainerGap()));

        tabbedPane.addTab("User", tabUsers);

        btnHighscoreExport.setText("Highs. export");
        btnHighscoreExport
                .addActionListener(new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnHighscoreExportActionPerformed(evt);
                    }
                });

        lblExportHighscore.setText("Export highscore to file");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(
                this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout
                .createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(layout
                        .createSequentialGroup()
                        .addContainerGap()
                        .add(layout
                                .createParallelGroup(
                                        org.jdesktop.layout.GroupLayout.LEADING)
                                .add(lblCaption)
                                .add(layout
                                        .createSequentialGroup()
                                        .add(layout
                                                .createParallelGroup(
                                                        org.jdesktop.layout.GroupLayout.TRAILING,
                                                        false)
                                                .add(org.jdesktop.layout.GroupLayout.LEADING,
                                                        btnHighscoreExport,
                                                        org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                        org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                        Short.MAX_VALUE)
                                                .add(org.jdesktop.layout.GroupLayout.LEADING,
                                                        btnStartServer,
                                                        org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                        org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                        Short.MAX_VALUE)
                                                .add(org.jdesktop.layout.GroupLayout.LEADING,
                                                        btnStopServer,
                                                        org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                        org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                        Short.MAX_VALUE))
                                        .addPreferredGap(
                                                org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(layout
                                                .createParallelGroup(
                                                        org.jdesktop.layout.GroupLayout.LEADING)
                                                .add(lblExportHighscore)
                                                .add(lblStopServer)
                                                .add(lblStartServer)))
                                .add(org.jdesktop.layout.GroupLayout.TRAILING,
                                        tabbedPane,
                                        org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                        434, Short.MAX_VALUE))
                        .addContainerGap()));
        layout.setVerticalGroup(layout
                .createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(layout
                        .createSequentialGroup()
                        .addContainerGap()
                        .add(lblCaption)
                        .addPreferredGap(
                                org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(layout
                                .createParallelGroup(
                                        org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(btnStartServer).add(lblStartServer))
                        .addPreferredGap(
                                org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout
                                .createParallelGroup(
                                        org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(btnStopServer).add(lblStopServer))
                        .addPreferredGap(
                                org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout
                                .createParallelGroup(
                                        org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(btnHighscoreExport)
                                .add(lblExportHighscore))
                        .add(18, 18, 18)
                        .add(tabbedPane,
                                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                205, Short.MAX_VALUE).add(12, 12, 12)));
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Is called on start server button click.
     * 
     * @param evt
     */
    private void btnStartServerActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnStartServerActionPerformed
        if (this.getServerThread() != null) {
            this.getServerThread().stopThread();
        }

        try {
            this.serverThread = new ServerThread(true);
            this.getServerThread().start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        setThread(this.getServerThread());
        ServerControlPanel.getInstance().addLogMessages("Server ready...");
    }// GEN-LAST:event_btnStartServerActionPerformed

    /**
     * Is called on server stop button click.
     * 
     * @param evt
     */
    private void btnStopServerActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnStopServerActionPerformed
        try {
            if (this.getServerThread() != null) {
                Server.getInstance().logoutAll();
                this.serverThread.stopThread();
                setThread(null);

                // Userlist update
                for (int i = 0; i < ((UserListTableModel) tblUserList
                        .getModel()).getRowCount(); i++)
                    ((UserListTableModel) tblUserList.getModel()).setValueAt(
                            "offline", i, 1);

                // Clear Game list
                ((DefaultListModel<Game>) liGames.getModel()).clear();

                ServerControlPanel.getInstance().addLogMessages(
                        "Server stopped.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }// GEN-LAST:event_btnStopServerActionPerformed

    /**
     * Is called on click to user kick button.
     * 
     * @param evt
     */
    private void btnKickActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnKickActionPerformed
        try {
            int i = tblUserList.getSelectedRow();

            String username = tblUserList.getModel().getValueAt(i, 0)
                    .toString();
            Server.getInstance().logout(username);
            ((UserListTableModel) tblUserList.getModel()).setValueAt("offline",
                    i, 1);
            addLogMessages(username + " was kicked");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }// GEN-LAST:event_btnKickActionPerformed

    /**
     * Is called on close game button click.
     * 
     * @param evt
     */
    private void btnCloseGameActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCloseGameActionPerformed
        try {
            if (liGames.getSelectedValue() == null)
                return;
            Server.getInstance()
                    .stopGame(liGames.getSelectedValue().toString());
            ((DefaultListModel<Game>) liGames.getModel()).removeElement(liGames
                    .getSelectedValue());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }// GEN-LAST:event_btnCloseGameActionPerformed

    /**
     * Is called on add user button click. Shows up a new UserFrame dialog.
     * 
     * @param evt
     */
    private void btnCreateUserActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCreateUserActionPerformed
        UserFrame uf = new UserFrame(this);
        uf.setVisible(true);
    }// GEN-LAST:event_btnCreateUserActionPerformed

    /**
     * Is called on a click to "Remove User" button.
     * 
     * @param evt
     */
    private void btnRemoveUserActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnRemoveUserActionPerformed
        Server.getInstance()
                .getDatabase()
                .removeUser(
                        ((UserListTableModel) tblUserList.getModel())
                                .getValueAt(tblUserList.getSelectedRow(), 0)
                                .toString());
        ((UserListTableModel) tblUserList.getModel()).deleteRow(tblUserList
                .getSelectedRow());
    }// GEN-LAST:event_btnRemoveUserActionPerformed

    /**
     * Is called on a click to "Export Highscore" button. Shows up a file
     * chooser dialog that let the user select an export target.
     * 
     * @param evt
     */
    private void btnHighscoreExportActionPerformed(
            java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnHighscoreExportActionPerformed
        try {
            JFileChooser fc = new JFileChooser();

            if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                Highscore highscore = Server.getInstance().getHighscore();
                HighscoreHtmlExporter.export(highscore,
                        new FileOutputStream(fc.getSelectedFile()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }// GEN-LAST:event_btnHighscoreExportActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton     btnCloseGame;
    private javax.swing.JButton     btnCreateUser;
    private javax.swing.JButton     btnHighscoreExport;
    private javax.swing.JButton     btnKick;
    private javax.swing.JButton     btnRemoveUser;
    private javax.swing.JButton     btnStartServer;
    private javax.swing.JButton     btnStopServer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel      lblCaption;
    private javax.swing.JLabel      lblExportHighscore;
    private javax.swing.JLabel      lblStartServer;
    private javax.swing.JLabel      lblStopServer;
    private javax.swing.JList<Game> liGames;
    private javax.swing.JScrollPane scrPane;
    private javax.swing.JPanel      tabGames;
    private javax.swing.JPanel      tabLog;
    private javax.swing.JPanel      tabUsers;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JTable      tblUserList;
    private javax.swing.JTextArea   txtLog;

    // End of variables declaration//GEN-END:variables

    /**
     * @return Instance to the user table.
     */
    public javax.swing.JTable getTblUserList() {
        return tblUserList;
    }

    /**
     * @return Instance to the ServerThread.
     */
    public ServerThread getServerThread() {
        return serverThread;
    }
}
