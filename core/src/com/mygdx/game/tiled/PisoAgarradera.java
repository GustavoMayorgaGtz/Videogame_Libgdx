package com.mygdx.game.tiled;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;

public  class PisoAgarradera extends InteractivePisoAgarradera{

    public PisoAgarradera(World world, TiledMap map, Rectangle bounds) {
        super(world, map, bounds);
        fixture.setUserData(this);
    }

    @Override
    public void pisoAgarraderaTouch() {

    }


}
