package com.mygdx.game.tiled;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.game.actors.Jugador;

import static com.mygdx.game.MyGdxGame.Pixels;

public abstract class InteractivePisoAgarradera extends Actor implements Disposable {
    protected World world;
    protected TiledMap map;
    protected Rectangle bounds;
    protected Body body;
    BodyDef bdef  = new BodyDef();
    FixtureDef fdef = new FixtureDef();
    PolygonShape shape = new PolygonShape();
    protected Fixture fixture;

    float x,xfin,y,width;


    public InteractivePisoAgarradera(World world, TiledMap map, Rectangle bounds)    {
        this.world = world;
        this.map = map;
        this.bounds = bounds;
        this.x = bounds.x;
        this.y = bounds.y+bounds.height;
        this.xfin = bounds.x+bounds.width;

        bdef.type = BodyDef.BodyType.StaticBody;
        bdef.position.set((bounds.getX() + bounds.getWidth()/2)/Pixels,( bounds.getY()+bounds.getHeight()/2)/Pixels);
        body = world.createBody(bdef);
        body.setGravityScale(0.0f);
        shape.setAsBox((bounds.getWidth()/2)/Pixels,(bounds.getHeight()/2)/Pixels);
        fdef.shape = shape;
        fixture = body.createFixture(fdef);
        shape.dispose();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {

    }

    @Override
    public void act(float delta) {
      //  AddActors.player;
        if(body.getPosition().y  <=  Jugador.body.getPosition().y-(8/Pixels) )
        {
             body.setActive(true);
        }else
        {
            body.setActive(false);
        }
    }

    public abstract void pisoAgarraderaTouch();


    @Override
    public void dispose() {
        map.dispose();
        body.destroyFixture(fixture);
        world.destroyBody(body);
    }

}
