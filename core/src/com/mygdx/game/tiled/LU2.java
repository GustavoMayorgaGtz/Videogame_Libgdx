package com.mygdx.game.tiled;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;


public class LU2 extends InteractiveTileObject2ButtonActive {

    public LU2(World world, TiledMap map, Rectangle bounds) {
        super(world, map, bounds);
     //   setCategoryFilter(LD_Bit);

        fixture.setSensor(true);
        fixture.setUserData(this);
        fixture2.setUserData("LU");

    }
    @Override
    public void Sierra()
    {
        switch(WorldContactListener.name)
        {
            case 0:
            {
                AddActors.s1.setLD(true);
                break;
            }
            case 1:
            {
                AddActors.s2.setLD(true);
                break;
            }
            case 2:
            {
                AddActors.s3.setLD(true);
                break;
            }
            case 3:
            {
                AddActors.s4.setLD(true);
                break;
            }

            case 4:
            {
                AddActors.s5.setLD(true);
                break;
            }
        }
       // Gdx.app.log("LD","colision");
    }

    @Override
    public void PlataformaEnMovimiento() {

    }

    @Override
    public void In() {

    }


}
