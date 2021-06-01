package com.mygdx.game.tiled;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;

public class CamaraNoY extends InteractiveTileCameraNOY{

    public CamaraNoY(World world, TiledMap map, Rectangle bounds, int iterator) {
        super(world, map, bounds,iterator);
    }
}
