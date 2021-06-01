package com.mygdx.game.tiled;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;


public class LD2Enemy extends InteractiveTileObject2 {

    public LD2Enemy(World world, TiledMap map, Rectangle bounds) {
        super(world, map, bounds);
        fdef.isSensor = true;
        fixture.setSensor(true);
        fixture.setUserData("left");

    }

    @Override
    public void Sierra() {

    }

    @Override
    public void PlataformaEnMovimiento() {

    }

    @Override
    public void In() {

    }

}
