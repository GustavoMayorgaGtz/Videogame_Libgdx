package com.mygdx.game.tiled;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.World;

public  class Parajo extends InteractiveParajo{
    public Parajo(World world, float x, float y, Texture a, Texture e, Texture i, Texture o) {
        super(world, x, y,a,e,i,o);
        fixture.setUserData(this);
    }

    @Override
    public void detectar() {
        isDangerous = true;
    }
}
