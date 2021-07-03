package com.mygdx.game.tiled;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Disposable;

import org.w3c.dom.css.Rect;

import java.util.ArrayList;

import static com.mygdx.game.MyGdxGame.Pixels;

public abstract class InteractiveTileObjectPiso implements Disposable {
    protected World world;
    protected TiledMap map;
    protected TiledMapTile tile;
    protected Rectangle bounds;
    protected Body body;
    boolean isSensor  = false;
    BodyDef bdef  = new BodyDef();
    FixtureDef fdef = new FixtureDef();
    PolygonShape shape = new PolygonShape();
    protected Fixture fixture,fixture2;
    public static ArrayList<Rectangle> pisosRec;

    public InteractiveTileObjectPiso(World world, TiledMap map, Rectangle bounds,int iterator)    {
        this.world = world;
        this.map = map;
        this.bounds = bounds;

        bdef.type = BodyDef.BodyType.KinematicBody;
        bdef.position.set((bounds.getX() + bounds.getWidth()/2)/Pixels,( bounds.getY()+bounds.getHeight()/2)/Pixels);
        body = world.createBody(bdef);
        shape.setAsBox((bounds.getWidth()/2)/Pixels,(bounds.getHeight()/2)/Pixels);
        fdef.shape = shape;
        fixture = body.createFixture(fdef);
        fixture2 = body.createFixture(fdef);
        fixture2.setSensor(true);
        shape.dispose();
        pisosRec = new ArrayList<Rectangle>();
        pisosRec.add(iterator,new Rectangle(bounds.x/Pixels,bounds.y/Pixels,bounds.width/Pixels,bounds.height/Pixels));

    }


    public abstract void Sierra( );
    public abstract void PlataformaEnMovimiento();




    @Override
    public void dispose() {
        map.dispose();
        body.destroyFixture(fixture);
        body.destroyFixture(fixture2);
        world.destroyBody(body);
    }

}
