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

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JPanel;

import me.lins.dropdabomb.client.io.Resource;

/**
 * Shows the splash screen and the login window.
 * 
 * @author Kai Ritterbusch
 * @author Christian Lins
 */
@SuppressWarnings("serial")
public class StartPanel extends JPanel {

    private Image            background = null;
    private final LoginPanel loginPanel = new LoginPanel();

    public StartPanel() {
        this.background = Resource.getImage("res/gfx/splash.png").getImage();

        setLayout(null);
        add(loginPanel);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent event) {
                int x = getWidth() / 2 - 200;
                int y = getHeight() - 150;
                loginPanel.setBounds(x, y, 400, 130);
            }
        });
    }

    /**
     * Shows the Background for the Panel
     * 
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(background, 0, 0, null);
    }
}
