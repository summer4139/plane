package com.text.plane;
import javax.swing.*;

public class Main {
    public static void main(String[] args)
    {
        JFrame window = new JFrame();
        window.setBounds(100,100,Map.MAP_WIDTH+16,Map.MAP_HEIGTH+36);
        window.setTitle("飞机大战");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GamePanel gp = new GamePanel();
        window.add(gp);
        window.setVisible(true);
        gp.addKeyListener(gp);
        new Thread(gp).start();
    }
}