package com.mygdx.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.tiled.AddActors;

import static com.mygdx.game.MyGdxGame.Pixels;

public class Agarradera extends Actor {
    private Body body;
    private Texture texture;
    private World world;
    private Fixture fixture;
    private BodyDef def;
    AddActors add;
    public static boolean Activo = true;
    private float time = 0;

    public Agarradera(World world, Texture texture, float x, float y)
    {
        this.world = world;


        this.texture = texture;

        def = new BodyDef();
        def.position.set(x/Pixels, y/Pixels);
        def.fixedRotation = true;
        def.type = BodyDef.BodyType.KinematicBody;

        body = world.createBody(def);
        PolygonShape box = new PolygonShape();
        box.setAsBox(12/Pixels, 1f/Pixels);
        fixture = body.createFixture(box,20);
        fixture.setUserData("PisoBase");
        box.dispose();
        setSize(24/Pixels, 15f/Pixels);//3

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        setPosition(body.getPosition().x-(12f)/Pixels,body.getPosition().y-(13f)/Pixels);
            batch.draw(texture, getX(),getY(),getWidth(),getHeight());
    }

    @Override
    public void act(float delta) {
        if(body.getPosition().y <= Jugador.body.getPosition().y-(8/Pixels))        {
            body.setActive(true);
            Activo = true;
        }else
        {

            time = 0;
            body.setActive(false);
            Activo = false;
        }
    }

    public void detach()
    {
        body.destroyFixture(fixture);
        world.destroyBody(body);
    }

}


