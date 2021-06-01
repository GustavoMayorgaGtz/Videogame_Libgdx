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
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.game.actors.Button2;

import static com.mygdx.game.MyGdxGame.Pixels;

public abstract class InteractiveTileObjectButton2Activate extends Actor implements Disposable {
    protected World world;
    protected TiledMap map;
    protected TiledMapTile tile;
    protected Rectangle bounds;
    protected Body body;
    BodyDef bdef  = new BodyDef();
    FixtureDef fdef = new FixtureDef();
    PolygonShape shape = new PolygonShape();
    protected Fixture fixture,fixture2;

    public InteractiveTileObjectButton2Activate(World world, TiledMap map, Rectangle bounds)    {
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

    }

    @Override
    public void act(float delta) {
        if(!Button2.isTouch)
        {
            body.setActive(true);
        }else
        {
            body.setActive(false);
        }
    }

    public abstract void Sierra();
    public abstract void PlataformaEnMovimiento();




    @Override
    public void dispose() {
        map.dispose();
        body.destroyFixture(fixture);
        body.destroyFixture(fixture2);
        world.destroyBody(body);
    }

}
