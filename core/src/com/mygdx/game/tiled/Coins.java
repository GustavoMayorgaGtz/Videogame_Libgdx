package com.mygdx.game.tiled;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;



public class Coins extends InteractiveTileCoins{



    public Coins(World world, TiledMap map, Rectangle bounds, Texture texture) {
        super(world, map, bounds,texture);
        fdef.isSensor = true;
        fixture.setSensor(true);
        fixture.setUserData(this);

    }

    @Override
    public void Coin() {
       isCoinAcive = false;
    }



}
