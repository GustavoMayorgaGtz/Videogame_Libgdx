package com.mygdx.game.tiled;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;


public class RU2 extends InteractiveTileObject2ButtonActive{
    //Sierra s;
    public RU2(World world, TiledMap map, Rectangle bounds) {
        super(world, map, bounds);

        fdef.isSensor = true;
        fixture.setUserData(this);
        fixture.setSensor(true);
        fixture2.setUserData("RU");

    }
    @Override
    public void Sierra() {

        fixture.setSensor(true);

    }

    @Override
    public void PlataformaEnMovimiento() {

    }

    @Override
    public void In() {

    }


}
