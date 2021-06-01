package com.mygdx.game.tiled;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;


public class RU extends InteractiveTileObject{
    //Sierra s;
    public RU(World world, TiledMap map, Rectangle bounds) {
        super(world, map, bounds);

        fdef.isSensor = true;
        fixture.setUserData(this);
        fixture.setSensor(true);
        fixture2.setUserData("RU");


    }
    @Override
    public void Sierra() {

        //Niveo1T.sierra.setRU(true);
        switch(WorldContactListener.name)
        {
            case 0:
            {
                AddActors.s1.setRU(true);
                break;
            }
            case 1:
            {
                AddActors.s2.setRU(true);
                break;
            }
            case 2:
            {
                AddActors.s3.setRU(true);
                break;
            }
            case 3:
            {
                AddActors.s4.setRU(true);
                break;
            }

            case 4:
            {
                AddActors.s5.setRU(true);
                break;
            }
        }
        Gdx.app.log("RU","colision");
    }

    @Override
    public void PlataformaEnMovimiento() {

    }

}
