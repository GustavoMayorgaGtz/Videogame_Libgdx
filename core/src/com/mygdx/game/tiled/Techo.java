package com.mygdx.game.tiled;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;

public class Techo extends InteractiveTileObject{

    public Techo(World world, TiledMap map, Rectangle bounds) {
        super(world, map, bounds);
        fixture.setUserData("techo");
    }
    @Override
    public void Sierra() {
    }

    @Override
    public void PlataformaEnMovimiento() {

    }

}
