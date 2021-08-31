package com.mygdx.game.tiled;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.World;

public class PlataformaMovimiento extends InteractivePlataformaMov {
    public PlataformaMovimiento(World world, Texture texture, float x, float y,int iterator) {
        super(world, texture, x, y,iterator);
        fixture.setUserData(this);
    }

    @Override
    public void setRD() {
        RD = true;
        LD = false;
        RU = false;
        LU = false;
    }

    @Override
    public void setLD() {
        LD = true;
        RD = false;
        RU = false;
        LU = false;
    }

    @Override
    public void setRU() {
        i1 = -3;
        i2 =  -3;
        RU = true;
        LU = false;
        RD = false;
        LD = false;
    }

    @Override
    public void setLU() {
        i1 =  -3;
        i2 =  -3;
        LU = true;
        RU = false;
        RD = false;
        LD = false;
    }

}
