package com.mygdx.game.tiled;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;

public class NPC extends CinematicaNPC{


    public NPC(World world, Rectangle bounds, Texture WalkLeft1, Texture WalkRight1, Texture WalkLeft2, Texture WalkRight2, Texture WalkLeft3, Texture WalkRight3, Texture WalkLeft4, Texture WalkRight4, int iterator) {
        super( world,  bounds,  WalkLeft1,  WalkRight1,  WalkLeft2,  WalkRight2,  WalkLeft3,  WalkRight3,  WalkLeft4,  WalkRight4,  iterator);
        fixture.setUserData(this);
    }

    @Override
    public void Reverse() {
        if(Right) {
            Right = false;
        }else {
            Right = true;
        }
    }


}
