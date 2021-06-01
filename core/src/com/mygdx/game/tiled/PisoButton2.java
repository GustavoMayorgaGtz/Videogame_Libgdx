package com.mygdx.game.tiled;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;

public class PisoButton2 extends InteractiveTileObjectButton2Activate{

    public PisoButton2(World world, TiledMap map, Rectangle bounds)
    {
        super(world,map,bounds);
        fixture.setUserData("PisoBase");
    }

    @Override
    public void Sierra() {

    }

    @Override
    public void PlataformaEnMovimiento() {

    }




}
