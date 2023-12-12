package com.text.plane;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.concurrent.BlockingDeque;

public class GamePanel extends Panel implements Runnable,KeyListener
{
   Hero hero =new Hero();
   Map map =new Map();
   Bullet bullet;
   ArrayList<Bullet> bullets =new ArrayList<>();
   int addBullet =5;
   int addBulletCound =0;

    @Override
    public void run()
    {
        while (true)
        {
            addBullet();
            map.move();
            hero.move();
            for(int i=bullets.size()-1;i>=0;i--)
            {
                bullet =bullets.get(i);
                bullet.move(bullets);
            }
            repaint();

            try
            {
                Thread.sleep(40L);
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void update(Graphics g)
    {
        Image tmp =createImage(Map.MAP_WIDTH,Map.MAP_HEIGTH);
        Graphics gTmp = tmp.getGraphics();
        map.paint(gTmp,this);
        hero.paint(gTmp,this);
        for(int i=0;i<bullets.size();i++)
        {
            bullet =bullets.get(i);
            bullet.paint(gTmp,this);
        }
        g.drawImage(tmp,0,0,this);
        super.paint(g);
    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
       hero.pressed(e.getKeyCode());

    }

    @Override
    public void keyReleased(KeyEvent e) {
        hero.released(e.getKeyCode());
    }
    private void addBullet()
    {
        addBulletCound++;
        if(addBulletCound == addBullet)
        {
            bullet=new Bullet(hero,-2);
            bullets.add(bullet);
            bullet=new Bullet(hero,0);
            bullets.add(bullet);
            bullet=new Bullet(hero,2);
            bullets.add(bullet);
            bullet=new Bullet(hero,4);
            bullets.add(bullet);
            bullet=new Bullet(hero,-4);
            bullets.add(bullet);
            addBulletCound =0;
        }
    }
}
