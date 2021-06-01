package com.mygdx.game.tiled;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;

public class ParedesButton2 extends InteractiveTileObjectButton2Activate{

    public ParedesButton2(World world, TiledMap map, Rectangle bounds) {
        super(world, map, bounds);
        fixture.setDensity(0);
        fixture.setFriction(0);

        fixture.setUserData("desMov");
    }

    @Override
    public void Sierra() {

    }

    @Override
    public void PlataformaEnMovimiento() {

    }




}
