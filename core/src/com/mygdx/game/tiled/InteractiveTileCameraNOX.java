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

import static com.mygdx.game.MyGdxGame.Pixels;

public abstract class InteractiveTileCameraNOX extends Actor implements Disposable {
    protected World world;
    protected TiledMap map;
    protected Rectangle bounds;
    protected Body body;
    protected Fixture fixture;
    AddResources r;

    BodyDef bdef  = new BodyDef();
    FixtureDef fdef = new FixtureDef();
    PolygonShape shape = new PolygonShape();


    public InteractiveTileCameraNOX(World world, TiledMap map, Rectangle bounds, int iterator)    {
        this.world = world;
        this.map = map;
        this.bounds = bounds;
        bdef.type = BodyDef.BodyType.DynamicBody;
        bdef.position.set((bounds.getX() + bounds.getWidth()/2)/Pixels,( bounds.getY()+bounds.getHeight()/2)/Pixels);
        body = world.createBody(bdef);
        body.setActive(true);
        body.setGravityScale(0f);
        shape.setAsBox((bounds.getWidth()/2)/Pixels,(bounds.getHeight()/2)/Pixels);
        fdef.shape = shape;
        fixture = body.createFixture(fdef);
        fixture.setUserData("CamaraX");
        fixture.setSensor(true);
        shape.dispose();


        setSize((bounds.getWidth())/Pixels,(bounds.getHeight())/Pixels);
        setPosition(body.getPosition().x-(((bounds.getWidth())/2)/Pixels),body.getPosition().y-((bounds.getHeight()/2)/Pixels));
        r.rectangulosNoX.add(iterator,new Rectangle(getX(),getY(),getWidth(),getHeight()));
            }

    @Override
    public void draw(Batch batch, float parentAlpha) {
       // batch.draw(r.white,getX(),getY(),getWidth(),getHeight());
}



    @Override
    public void act(float delta) {

      }

    @Override
    public void dispose() {
        map.dispose();
        body.destroyFixture(fixture);
        world.destroyBody(body);
    }

}
