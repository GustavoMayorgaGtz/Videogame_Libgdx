package com.mygdx.game.tiled;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
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

public abstract class InteractiveTileObjectButtons extends Actor implements Disposable {
    protected World world;
    protected TiledMap map;
    protected Rectangle bounds;
    protected Body body;

    BodyDef bdef  = new BodyDef();
    FixtureDef fdef = new FixtureDef();
    PolygonShape shape = new PolygonShape();
    protected Fixture fixture;
    Texture texture,texture2;
    boolean isButton1;




    public InteractiveTileObjectButtons(World world, TiledMap map, Rectangle bounds,Texture texture,Texture texture2)    {
        this.world = world;
        this.map = map;
        this.bounds = bounds;
        this.texture = texture;
        this.texture2 = texture2;
        bdef.type = BodyDef.BodyType.KinematicBody;
        bdef.position.set((bounds.getX() + bounds.getWidth()/2)/Pixels,( bounds.getY()+bounds.getHeight()/2)/Pixels);
        body = world.createBody(bdef);
        shape.setAsBox((bounds.getWidth()/2)/Pixels,(bounds.getHeight()/2)/Pixels);
        fdef.shape = shape;
        fdef.friction = 0;
        fdef.density = 0;
        fixture = body.createFixture(fdef);
        fixture.setUserData("PisoBase");
        shape.dispose();
        ////
        setSize((bounds.getWidth())/Pixels,(bounds.getHeight())/Pixels);


    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        setPosition(body.getPosition().x-(((bounds.getWidth())/2)/Pixels),body.getPosition().y-((bounds.getHeight()/2)/Pixels));
        if(isButton1) {
            if (Button1.isTouch) {

            } else {
                batch.draw(texture, getX(), getY(), getWidth(), getHeight());

            }
        }
        else
        {
            if (Button2.isTouch) {
            } else {

                batch.draw(texture2, getX(), getY(), getWidth(), getHeight());
            }
        }
    }

    @Override
    public void act(float delta) {
        if(isButton1) {
            if (Button1.isTouch) {
                body.setActive(false);
            } else {
                body.setActive(true);
            }
        }else
        {
            if (Button2.isTouch) {
                body.setActive(false);
            } else {
                body.setActive(true);
            }
        }
    }

    @Override
    public void dispose() {
        texture.dispose();
        texture2.dispose();
        map.dispose();
        body.destroyFixture(fixture);
        world.destroyBody(body);

    }

}
