package com.mygdx.game.tiled;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.actors.Button1;

public class PinchosGravity extends InteractivePinchos{


    public PinchosGravity(World world, Rectangle bounds, Texture WalkLeft) {
        super(world, bounds,WalkLeft);
        fixture.setUserData(this);

    }


    @Override
    public void Abajo() {
      abajo = true;
      body.setGravityScale(1);
    }


    @Override
    public void Death() {
    }

}
