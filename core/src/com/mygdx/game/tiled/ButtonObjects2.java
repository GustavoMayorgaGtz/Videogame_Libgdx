package com.mygdx.game.tiled;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;

public class ButtonObjects2 extends InteractiveTileObjectButtons {

    public ButtonObjects2(World world, TiledMap map, Rectangle bounds, Texture ObjectsButtonTexture,Texture texture2) {

             super(world, map,bounds,ObjectsButtonTexture,texture2);
isButton1 = false;
    }

}


