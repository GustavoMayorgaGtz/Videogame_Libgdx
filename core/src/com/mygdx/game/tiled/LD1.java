package com.mygdx.game.tiled;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;


public class LD1 extends InteractiveTileObject2 {

    public LD1(World world, TiledMap map, Rectangle bounds) {
        super(world, map, bounds);
     //   setCategoryFilter(LD_Bit);

        fixture.setSensor(true);
        fixture.setUserData(this);
        fixture2.setUserData("LD");
        fixture2.setSensor(true);
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
/*switch(WorldContactListener.nameMov)
{
    case 1:
    {
        AddActors.pm1.setLD(true);
        break;
    }
    case 2:
    {
        AddActors.pm2.setLD(true);
        break;
    }
    case 3:
    {
        AddActors.pm3.setLD(true);
        break;
    }
    case 4:
    {
        AddActors.pm4.setLD(true);
        break;
    }
    case 5:
    {
        AddActors.pm5.setLD(true);
        break;
    }
}*/
    }

    @Override
    public void In() {

    }


}
