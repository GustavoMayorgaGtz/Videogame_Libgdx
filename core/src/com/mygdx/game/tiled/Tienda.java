package com.mygdx.game.tiled;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;

public class Tienda extends InteractiveTileObjectTienda{

    public Tienda(World world, Rectangle bounds, Texture Animation) {
        super(world, bounds,Animation);
        fixture.setUserData(this);
    }
}
