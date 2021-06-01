package com.mygdx.game.tiled;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;

public class ParedED extends InteractiveTileObject3{
    AddActors add;
    public ParedED(World world, TiledMap map, Rectangle bounds) {
        super(world, map, bounds);
        fixture.setUserData(this);
    }


    @Override
    public void ParedED() {
        add.player.tempoLateral = 0;
        add.player.setSpiderLeft(false);
        add.player.setSpiderRight(true);
    }

    @Override
    public void ParedEI() {
    }
}
