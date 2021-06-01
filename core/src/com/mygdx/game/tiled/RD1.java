package com.mygdx.game.tiled;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;


public class RD1 extends InteractiveTileObject2{
    //Sierra s;
    public RD1(World world, TiledMap map, Rectangle bounds) {
        super(world, map, bounds);
        //setCategoryFilter(RD_Bit);
        fdef.isSensor = true;
        fixture.setUserData(this);
        fixture.setSensor(true);
        fixture2.setUserData("RD");
        fixture2.setSensor(true);
    }
    @Override
    public void Sierra() {
   /*     switch(WorldContactListener.name)
        {
            case 1:
            {
                AddActors.pm1.setRD(true);
                break;
            }
            case 2:
            {
                AddActors.pm2.setRD(true);
                break;
            }
            case 3:
            {
                AddActors.pm3.setRD(true);
                break;
            }
            case 4:
            {
                AddActors.pm4.setRD(true);
                break;
            }
            case 5:
            {
                AddActors.pm5.setRD(true);
                break;
            }
        }*/
        //Niveo1T.sierra.setRD(true);
        fixture.setSensor(true);
       // Gdx.app.log("RD","colision");
    }

    @Override
    public void PlataformaEnMovimiento() {
      /*  switch(WorldContactListener.nameMov)
        {
            case 1:
            {
                AddActors.pm1.setRD(true);
                break;
            }
            case 2:
            {
                AddActors.pm2.setRD(true);
                break;
            }
            case 3:
            {
                AddActors.pm3.setRD(true);
                break;
            }
            case 4:
            {
                AddActors.pm4.setRD(true);
                break;
            }

            case 5:
            {
                AddActors.pm5.setRD(true);
                break;
            }
        }*/
    }

    @Override
    public void In() {

    }


}
