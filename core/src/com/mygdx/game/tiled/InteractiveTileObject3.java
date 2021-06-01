package com.mygdx.game.tiled;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Disposable;

import static com.mygdx.game.MyGdxGame.Pixels;

public abstract class InteractiveTileObject3 implements Disposable {
    protected World world;
    protected TiledMap map;
    protected Rectangle bounds;
    protected Body body;
    BodyDef bdef  = new BodyDef();
    FixtureDef fdef = new FixtureDef();
    PolygonShape shape = new PolygonShape();
    protected Fixture fixture;

    public InteractiveTileObject3(World world, TiledMap map, Rectangle bounds)    {
        this.world = world;
        this.map = map;
        this.bounds = bounds;
        bdef.type = BodyDef.BodyType.KinematicBody;
        bdef.position.set((bounds.getX() + bounds.getWidth()/2)/Pixels,( bounds.getY()+bounds.getHeight()/2)/Pixels);
        body = world.createBody(bdef);

        shape.setAsBox((bounds.getWidth()/2)/Pixels,(bounds.getHeight()/2)/Pixels);
        fdef.shape = shape;
        fdef.friction = 10;
        //fdef.density = 100;
        fixture = body.createFixture(fdef);
        shape.dispose();
    }

    public abstract void ParedED();
    public abstract  void ParedEI();


    @Override
    public void dispose() {
        map.dispose();
        body.destroyFixture(fixture);
        world.destroyBody(body);
    }

}
