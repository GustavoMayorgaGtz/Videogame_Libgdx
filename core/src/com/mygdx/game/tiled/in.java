package com.mygdx.game.tiled;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.Menu;
import com.mygdx.game.actors.Jugador;

import static com.mygdx.game.MyGdxGame.Pixels;
import static com.mygdx.game.tiled.AddActors.*;


public class in extends InteractiveTilePortal {



    public in(World world, TiledMap map, Rectangle bounds, Texture texture) {
        super(world, map, bounds,texture);
        fdef.isSensor = true;
        fixture.setSensor(true);
        fixture.setUserData(this);

        iterator = i;
        i = i + 1;
    }

    @Override
    public void Sierra() {

    }

    @Override
    public void PlataformaEnMovimiento() {

    }

    @Override
    public void In() {
        Menu.id = 0;
        isPortalActive = true;
        Gdx.input.vibrate(1000);

    }


}
