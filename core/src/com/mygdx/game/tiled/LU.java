package com.mygdx.game.tiled;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;


public class LU extends InteractiveTileObject{

    public LU(World world, TiledMap map, Rectangle bounds) {
        super(world, map, bounds);

        fixture.setSensor(true);
        fixture.setUserData(this);
        fixture2.setUserData("LU");
    }

    @Override
    public void Sierra() {
        switch(WorldContactListener.name)
        {
            case 0:
            {
                AddActors.s1.setLU(true);
                break;
            }
            case 1:
            {
                AddActors.s2.setLU(true);
                break;
            }
            case 2:
            {
                AddActors.s3.setLU(true);
                break;
            }
            case 3:
            {
                AddActors.s4.setLU(true);
                break;
            }

            case 4:
            {
                AddActors.s5.setLU(true);
                break;
            }
        }
       // Gdx.input.vibrate(1000);
    //    Gdx.app.log("LU","colision");
    }

    @Override
    public void PlataformaEnMovimiento() {

    }



}
