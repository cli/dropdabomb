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
package me.lins.dropdabomb.client.gui;

import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.text.Document;

import me.lins.dropdabomb.client.ClientThread;
import me.lins.dropdabomb.net.Event;
import me.lins.dropdabomb.server.api.Session;

import org.jdesktop.layout.GroupLayout;
import org.jdesktop.layout.LayoutStyle;

/**
 * Lobby for all player where you can start games and chat
 * 
 * @author Kai Ritterbusch
 * @author Christian Lins
 */
@SuppressWarnings("serial")
public class LobbyPanel extends javax.swing.JPanel {

    private int activeCol = 0; // last sorted Column

    public LobbyPanel() {
        initComponents();

        txtChatInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER)
                    btnChatActionPerformed(null);
            }
        });

        tblGamelist.getTableHeader().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                activeCol = tblGamelist.columnAtPoint(evt.getPoint());
                ((GameListTableModel) tblGamelist.getModel())
                        .sortByColumn(tblGamelist.columnAtPoint(evt.getPoint()));

                ((GameListTableModel) tblGamelist.getModel())
                        .fireTableDataChanged();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed"
    // desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLobbyTitle = new javax.swing.JLabel();
        lblLobbyInfo = new javax.swing.JLabel();
        lblGamelist = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGamelist = new javax.swing.JTable();
        lblChatWindow = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtChat = new javax.swing.JTextPane();
        txtChatInput = new javax.swing.JTextField();
        btnChat = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstUser = new javax.swing.JList();
        lblUserlist = new javax.swing.JLabel();
        btnCreateGame = new javax.swing.JButton();
        btnJoinGame = new javax.swing.JButton();
        btnSpectateGame = new javax.swing.JButton();

        lblLobbyTitle.setFont(new java.awt.Font("DejaVu Sans", 0, 24));
        lblLobbyTitle.setText("Lobby");

        lblLobbyInfo
                .setText("Hier kannst Du mit anderen Spielern chatten, ein Spiel erstellen oder einem Spiel beitreten");

        lblGamelist.setText("Spielliste");

        tblGamelist.setModel(new GameListTableModel());
        jScrollPane1.setViewportView(tblGamelist);

        lblChatWindow.setText("Chatfenster");

        txtChat.setEditable(false);
        jScrollPane2.setViewportView(txtChat);

        btnChat.setText("Chat");
        btnChat.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChatActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(lstUser);

        lblUserlist.setText("Userliste");

        btnCreateGame.setText("Neues Spiel");
        btnCreateGame.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateGameActionPerformed(evt);
            }
        });

        btnJoinGame.setText("Beitreten");
        btnJoinGame.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJoinGameActionPerformed(evt);
            }
        });

        btnSpectateGame.setText("Beobachter");
        btnSpectateGame.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSpectateGameActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout
                .createParallelGroup(GroupLayout.LEADING)
                .add(layout
                        .createSequentialGroup()
                        .addContainerGap()
                        .add(layout
                                .createParallelGroup(GroupLayout.LEADING)
                                .add(layout
                                        .createParallelGroup(
                                                GroupLayout.TRAILING, false)
                                        .add(GroupLayout.LEADING, lblLobbyTitle)
                                        .add(GroupLayout.LEADING, lblLobbyInfo,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                        .add(GroupLayout.LEADING, lblGamelist))
                                .add(layout
                                        .createSequentialGroup()
                                        .add(layout
                                                .createParallelGroup(
                                                        GroupLayout.LEADING)
                                                .add(layout
                                                        .createSequentialGroup()
                                                        .add(txtChatInput,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                424,
                                                                Short.MAX_VALUE)
                                                        .addPreferredGap(
                                                                LayoutStyle.UNRELATED)
                                                        .add(btnChat))
                                                .add(lblChatWindow)
                                                .add(jScrollPane2,
                                                        org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                        475, Short.MAX_VALUE))
                                        .addPreferredGap(
                                                org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(layout
                                                .createParallelGroup(
                                                        org.jdesktop.layout.GroupLayout.LEADING)
                                                .add(lblUserlist)
                                                .add(jScrollPane3,
                                                        org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                                                        141,
                                                        org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                .add(org.jdesktop.layout.GroupLayout.TRAILING,
                                        layout.createSequentialGroup()
                                                .add(jScrollPane1,
                                                        org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                        532, Short.MAX_VALUE)
                                                .addPreferredGap(
                                                        org.jdesktop.layout.LayoutStyle.UNRELATED)
                                                .add(layout
                                                        .createParallelGroup(
                                                                org.jdesktop.layout.GroupLayout.LEADING,
                                                                false)
                                                        .add(btnSpectateGame,
                                                                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                        .add(btnJoinGame,
                                                                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                        .add(btnCreateGame,
                                                                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE))))
                        .addContainerGap()));
        layout.setVerticalGroup(layout
                .createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(layout
                        .createSequentialGroup()
                        .addContainerGap()
                        .add(lblLobbyTitle)
                        .addPreferredGap(
                                org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(lblLobbyInfo)
                        .add(18, 18, 18)
                        .add(lblGamelist)
                        .addPreferredGap(
                                org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout
                                .createParallelGroup(
                                        org.jdesktop.layout.GroupLayout.LEADING)
                                .add(layout
                                        .createSequentialGroup()
                                        .add(jScrollPane1,
                                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                                                93,
                                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(18, 18, 18)
                                        .add(layout
                                                .createParallelGroup(
                                                        org.jdesktop.layout.GroupLayout.BASELINE)
                                                .add(lblChatWindow)
                                                .add(lblUserlist)))
                                .add(layout
                                        .createSequentialGroup()
                                        .add(btnCreateGame)
                                        .addPreferredGap(
                                                org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(btnJoinGame)
                                        .addPreferredGap(
                                                org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(btnSpectateGame)))
                        .addPreferredGap(
                                org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout
                                .createParallelGroup(
                                        org.jdesktop.layout.GroupLayout.LEADING)
                                .add(org.jdesktop.layout.GroupLayout.TRAILING,
                                        layout.createSequentialGroup()
                                                .add(jScrollPane2,
                                                        org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                        120, Short.MAX_VALUE)
                                                .addPreferredGap(
                                                        org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(layout
                                                        .createParallelGroup(
                                                                org.jdesktop.layout.GroupLayout.BASELINE)
                                                        .add(btnChat)
                                                        .add(txtChatInput,
                                                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                                                                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                .add(jScrollPane3,
                                        org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                        151, Short.MAX_VALUE))
                        .addContainerGap()));
    }// </editor-fold>//GEN-END:initComponents

    private void btnChatActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnChatActionPerformed
        String text = this.txtChatInput.getText();
        try {
            ClientThread.getInstance().Server.sendChatMessage(new Event(
                    new Object[] { ClientThread.getInstance().Session, text }));
            this.txtChatInput.setText("");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }// GEN-LAST:event_btnChatActionPerformed

    private void btnCreateGameActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCreateGameActionPerformed
        try {
            String[] msg = { "Bitte geben Sie einen Namen f\u00FCr das Spiel an!" };
            String gameName = JOptionPane.showInputDialog(msg, "Neues Spiel");
            if (gameName != null) {
                Session session = ClientThread.getInstance().Session;
                ClientThread.getInstance().Server.createGame(new Event(
                        new Object[] { session, gameName }));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }// GEN-LAST:event_btnCreateGameActionPerformed

    private void btnJoinGameActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnJoinGameActionPerformed
        try {
            int row = tblGamelist.getSelectedRow();
            if (row >= 0) {
                String name = (String) ((GameListTableModel) tblGamelist
                        .getModel()).getValueAt(row, 0);
                ClientThread.getInstance().Server
                        .joinGame(new Event(new Object[] {
                                ClientThread.getInstance().Session, name }));
            } else {
                JOptionPane.showMessageDialog(this,
                        "Bitte waehle erst ein Spiel!", "Bomberman",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }// GEN-LAST:event_btnJoinGameActionPerformed

    private void btnSpectateGameActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSpectateGameActionPerformed
        try {
            int row = tblGamelist.getSelectedRow();
            if (row >= 0) {
                String name = (String) ((GameListTableModel) tblGamelist
                        .getModel()).getValueAt(row, 0);
                ClientThread.getInstance().Server
                        .joinViewGame(new Event(new Object[] {
                                ClientThread.getInstance().Session, name }));
            } else {
                JOptionPane.showMessageDialog(this,
                        "Bitte waehle erst ein Spiel!", "Bomberman",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }// GEN-LAST:event_btnSpectateGameActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton     btnChat;
    private javax.swing.JButton     btnCreateGame;
    private javax.swing.JButton     btnJoinGame;
    private javax.swing.JButton     btnSpectateGame;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel      lblChatWindow;
    private javax.swing.JLabel      lblGamelist;
    private javax.swing.JLabel      lblLobbyInfo;
    private javax.swing.JLabel      lblLobbyTitle;
    private javax.swing.JLabel      lblUserlist;
    private javax.swing.JList       lstUser;
    private javax.swing.JTable      tblGamelist;
    private javax.swing.JTextPane   txtChat;
    private javax.swing.JTextField  txtChatInput;

    // End of variables declaration//GEN-END:variables

    /**
     * Adds new Chat message to LobbyPanel textfield
     * 
     * @param line
     */
    public void addChatMessage(String line) {
        try {
            Document doc = txtChat.getDocument();

            // Insert the line and a newline into the document
            doc.insertString(doc.getLength(), line + "\n", null);

            // Scroll to the end of the textpane
            txtChat.scrollRectToVisible(new Rectangle(0, txtChat.getHeight()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Sets the UserList in the LobbyPanel
     * 
     * @param users
     */
    public void setUserList(List<String> users) {
        lstUser.setListData(new Vector<Object>(users));
    }

    /**
     * Adds new GameInfo for the game-table
     * 
     * @param data
     */
    public void setGameInfo(List<List<Object>> data) {
        ((GameListTableModel) tblGamelist.getModel()).setData(data);
    }
}
