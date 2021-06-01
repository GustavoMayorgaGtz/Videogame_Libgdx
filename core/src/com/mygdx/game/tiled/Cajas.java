package com.mygdx.game.tiled;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.World;

public  class Cajas extends InteractiveTileObjectCajas {

    public Cajas(World world, Texture texture, float x, float y,int iterator) {
        super(world, texture, x, y,iterator);
    }

    @Override
    public void mover() {

    }
}
