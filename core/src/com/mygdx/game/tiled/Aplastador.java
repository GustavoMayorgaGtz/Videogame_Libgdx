package com.mygdx.game.tiled;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.actors.Button1;

public class Aplastador extends InteractiveAplastador{


    public Aplastador(World world, Rectangle bounds, Texture WalkLeft) {
        super(world, bounds,WalkLeft);

        fixture.setUserData(this);

    }


    @Override
    public void Arriba() {
      arriba = true;
      abajo = false;
    }

    @Override
    public void Abajo() {
      arriba = false;
      abajo = true;
    }

    @Override
    public void Button() {
        Button1.isTouch = true;
    }

    @Override
    public void Death() {

    }

}
