package com.mygdx.game.tiled;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation;

public class AldeanoListAnimation {


    public Animation<TextureRegion> animation(Texture Texture,int c, int r, Animation<TextureRegion>  a)
    {
        TextureRegion[][] tmp = TextureRegion.split(Texture,Texture.getWidth()/c,Texture.getHeight()/r);
        TextureRegion[] current = new TextureRegion[c*r];
        int index = 0;
        for(int i = 0 ; i < r; i++)
        {
            for(int j = 0 ; j < c; j++)
            {
                current[index++]= tmp[i][j];
            }
        }
        a = new Animation<TextureRegion>(0.3f,current);
        return a;
    }
}
