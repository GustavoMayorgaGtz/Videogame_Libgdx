package com.mygdx.game.tiled;

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
import com.mygdx.game.actors.Button1;
import com.mygdx.game.actors.Button2;

import static com.mygdx.game.MyGdxGame.Pixels;

public abstract class InteractiveTileObject2ButtonActive extends Actor implements Disposable {
    protected World world;
    protected TiledMap map;
    protected Rectangle bounds;
    protected Body body;
    BodyDef bdef  = new BodyDef();
    FixtureDef fdef = new FixtureDef();
    PolygonShape shape = new PolygonShape();
    protected Fixture fixture,fixture2;
    boolean isIn = false;
    int getID;

    public InteractiveTileObject2ButtonActive(World world, TiledMap map, Rectangle bounds)    {
        this.world = world;
        this.map = map;
        this.bounds = bounds;
        bdef.type = BodyDef.BodyType.DynamicBody;
        bdef.position.set((bounds.getX() + bounds.getWidth()/2)/Pixels,( bounds.getY()+bounds.getHeight()/2)/Pixels);
        body = world.createBody(bdef);
        body.setGravityScale(0.0f);
        shape.setAsBox((bounds.getWidth()/2)/Pixels,(bounds.getHeight()/2)/Pixels);
        fdef.shape = shape;
        fixture = body.createFixture(fdef);
        fixture2 = body.createFixture(fdef);
        fixture2.setSensor(true);
        shape.dispose();
    }

    @Override
    public void act(float delta) {

   if(!Button1.isTouch)
   {
       body.setActive(false);
   }else
   {
       body.setActive(true);
   }

    }

    public abstract void Sierra( );
    public abstract void PlataformaEnMovimiento();
    public abstract  void In();


    @Override
    public void dispose() {
        map.dispose();
        body.destroyFixture(fixture);
        world.destroyBody(body);
    }

}
