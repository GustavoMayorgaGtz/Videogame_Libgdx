package com.mygdx.game.tiled;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;

public class ParedEI extends InteractiveTileObject3{
    AddActors add;
    public ParedEI(World world, TiledMap map, Rectangle bounds) {
        super(world, map, bounds);
        fixture.setUserData(this);
    }


    @Override
    public void ParedED() {

    }

    @Override
    public void ParedEI() {
        add.player.tempoLateral = 0;
        add.player.setSpiderRight(false);
        add.player.setSpiderLeft(true);
    }
}
