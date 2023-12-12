package com.text.plane;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Map extends Sprite
{
    public static final int MAP_WIDTH =480;
    public static final int MAP_HEIGTH =652;

    public Map()
    {
        this.yStep =7;
        try{
            img = ImageIO.read(Hero.class.getResourceAsStream("background.png"));
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void move()
    {
        y+=yStep;
        if(y>MAP_HEIGTH)
        {
            y=0;
        }
    }
    public void paint(Graphics gTmp,GamePanel gp)
    {
        gTmp.drawImage(img,x,y,gp);
        gTmp.drawImage(img,x,y,gp);
        gTmp.drawImage(img,x,y-MAP_HEIGTH,gp);
    }
}
