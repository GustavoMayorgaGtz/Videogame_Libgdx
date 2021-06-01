package com.mygdx.game.tiled;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.Menu;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.actors.Fuego;


public class ScreenSend extends InteractivsetScreeen{
    public ScreenSend(World world, Rectangle rect2) {
        super(world,rect2);
fixture.setUserData(this);
    }

    @Override
    public void menuSend() {
        Send = true;

    }
}
