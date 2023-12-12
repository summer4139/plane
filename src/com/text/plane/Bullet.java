package com.text.plane;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.time.chrono.ThaiBuddhistEra;
import java.util.ArrayList;

public class Bullet extends Sprite
{
    public Bullet (Hero hero,int xStep)
    {
        this.width = 6;
        this.height = 14;
        this.xStep = xStep;
        this.yStep =-7;
        this.x = hero.x+hero.width/2-width/2;
        this.y = hero.y- this.height;
        try
        {
            img = ImageIO.read(Hero.class.getResourceAsStream("bullet.png"));
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void move(ArrayList bullets)
    {
        this.x+=xStep;
        this.y+=yStep;
        if(this.y<0)
        {
            bullets.remove(this);
        }
    }
    public void paint(Graphics gTmp,GamePanel gp)
    {
        gTmp.drawImage(img,x,y,gp);
    }
}
