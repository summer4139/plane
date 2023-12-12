package com.text.plane;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class Hero extends Sprite {
    boolean up,down,left,right;
    public Hero()
    {
        this.width = 60;
        this.height = 76;
        x =(Map.MAP_WIDTH -width)/2;
        y = Map.MAP_HEIGTH -height;
        this.xStep = 5;
        this.yStep =5;
        try{
            img = ImageIO.read(Hero.class.getResourceAsStream("plane01.png"));
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void move(){
        if(up)
        {
            y -= yStep;
            if(y<0)
            {
                y = 0;
            }
        }
        if(down)
        {
            y += yStep;
            if(y>Map.MAP_HEIGTH - height)
            {
                y =Map.MAP_HEIGTH -height;
            }
        }
        if(left)
        {
            x -= xStep;
            if(x <0)
            {
                x =0;
            }
        }
        if(right)
        {
            x += xStep;
            if(x >Map.MAP_WIDTH-width)
            {
                x =Map.MAP_WIDTH-width;
            }
        }
    }

    public void paint(Graphics gTmp, GamePanel gp)
    {
        gTmp.drawImage(img,x,y,gp);
    }

    public void pressed(int KeyCode)
    {
        switch (KeyCode) {
            case KeyEvent.VK_W -> up = true;
            case KeyEvent.VK_S -> down = true;
            case KeyEvent.VK_A -> left = true;
            case KeyEvent.VK_D -> right = true;
        }

    }

    public void released(int KeyCode)
    {
        switch (KeyCode)
        {
            case KeyEvent.VK_W:
                up = false;
                break;
            case KeyEvent.VK_S:
                down  = false;
                break;
            case KeyEvent.VK_A:
                left = false;
                break;
            case KeyEvent.VK_D:
                right = false;
                break;
        }
    }

}
