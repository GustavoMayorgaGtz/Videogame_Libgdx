package com.mygdx.game.tiled;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;

public class CamaraY extends InteractiveTileCameraY{

    public CamaraY(World world, TiledMap map, Rectangle bounds, int iterator) {
        super(world, map, bounds,iterator);
    }
}
