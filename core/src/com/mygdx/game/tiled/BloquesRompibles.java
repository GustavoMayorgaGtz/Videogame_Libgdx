package com.mygdx.game.tiled;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.World;

public  class BloquesRompibles extends InteractiveTilesBloqueRompible {

    public BloquesRompibles(World world, Texture staticB, Texture Animation, int iterator,float x, float y) {
        super(world,staticB,Animation,iterator,x,y);
    }
}
