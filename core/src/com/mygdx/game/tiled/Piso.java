package com.mygdx.game.tiled;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.actors.Tierra1;

public class Piso extends InteractiveTileObject{

    public Piso(World world, TiledMap map, Rectangle bounds)
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
