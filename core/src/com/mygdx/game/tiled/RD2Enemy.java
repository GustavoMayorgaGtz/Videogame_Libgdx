package com.mygdx.game.tiled;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;


public class RD2Enemy extends InteractiveTileObject2{
    //Sierra s;
    public RD2Enemy(World world, TiledMap map, Rectangle bounds) {

        super(world, map, bounds);

        fdef.isSensor = true;
        fixture.setUserData("right");
        fixture.setSensor(true);

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
