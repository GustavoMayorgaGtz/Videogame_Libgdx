package com.mygdx.game.tiled;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;

import java.util.ArrayList;

import static com.mygdx.game.MyGdxGame.Pixels;

public abstract class InteractiveAplastador extends Actor implements Disposable {

    protected World world;
    protected TiledMap map;
    protected Rectangle bounds;
    protected Body body;
    BodyDef bdef  = new BodyDef();
    FixtureDef fdef = new FixtureDef();
    PolygonShape shape = new PolygonShape();
    boolean arriba = false,abajo = true;
    protected boolean EnemigoWalk,Aplastador;
    protected Fixture fixture;
    float MaxVelX = 1f;
    float MinVelX = -1f;
    Texture texture;


    public InteractiveAplastador(World world, Rectangle bounds, Texture texture)    {
        this.world = world;
        this.map = map;
        this.bounds = bounds;
        this.texture = texture;
        bdef.type = BodyDef.BodyType.KinematicBody;
        bdef.position.set((bounds.getX() + bounds.getWidth()/2)/Pixels,( bounds.getY()+bounds.getHeight()/2)/Pixels);
        body = world.createBody(bdef);
        shape.setAsBox((bounds.getWidth()/2)/Pixels,(bounds.getHeight()/2)/Pixels);
        fdef.shape = shape;
        fdef.density=1;
        fdef.friction = 0;
        fixture = body.createFixture(fdef);
        EdgeShape LineaDeMuerte = new EdgeShape();
        LineaDeMuerte.set(new Vector2((body.getPosition().x-bounds.getWidth()-4)/Pixels,(body.getPosition().y-bounds.getHeight()+20)/Pixels), new Vector2((body.getPosition().x-8f)/Pixels,(body.getPosition().y-bounds.getHeight()+20)/Pixels));

        body.createFixture(fdef).setUserData("ZonaSegura");
        fdef.shape = LineaDeMuerte;
        fdef.isSensor = true;
        body.createFixture(fdef).setUserData("spike");
        shape.dispose();
        ////
        ////////////////////////////////
        setSize((bounds.getWidth()+2)/Pixels,(bounds.getHeight()+2)/Pixels);
        setPosition(body.getPosition().x-(((bounds.getWidth()-1)/2)/Pixels),body.getPosition().y-((bounds.getHeight()/2)/Pixels));
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        setPosition(body.getPosition().x-(((bounds.getWidth()-1)/2)/Pixels),body.getPosition().y-((bounds.getHeight()/2)/Pixels));
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
}

    @Override
    public void act(float delta) {
        Movimientos();
        Vector2 velocidad = body.getLinearVelocity();
        if(arriba)
        {
            if (velocidad.y > 1f) {
                body.setLinearVelocity(velocidad.x,MaxVelX);
            }
        }else if(abajo)
        {
            if (velocidad.y < -1f) {
                body.setLinearVelocity(velocidad.x,MinVelX);
            }
        }
    }

    public void Movimientos()
    {
            if (arriba) {
                abajo = false;
                body.setLinearVelocity(0,1f);
               // body.applyLinearImpulse(0, +1f, body.getPosition().x, body.getPosition().y, true);
             //   body.applyForce(0, 1f, body.getPosition().x, body.getPosition().y, true);
            } else if (abajo) {
             //   body.applyLinearImpulse(0, -1f, body.getPosition().x, body.getPosition().y, true);
          //      body.applyForce(0, -1f, body.getPosition().x, body.getPosition().y, true);
                body.setLinearVelocity(0,-1f);
                arriba = false;
            }
    }


    public abstract  void Arriba();
    public abstract  void Abajo();
    public abstract void Button();
    public abstract  void Death();


    @Override
    public void dispose() {
        texture.dispose();
        map.dispose();
        body.destroyFixture(fixture);
        world.destroyBody(body);
    }

}
