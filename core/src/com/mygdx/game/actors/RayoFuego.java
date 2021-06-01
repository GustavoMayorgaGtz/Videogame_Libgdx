package com.mygdx.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.MyGdxGame;

import static com.mygdx.game.MyGdxGame.Pixels;

public class RayoFuego extends Actor {
    public static Body body;
    Fixture fixture;
    World world;
    BodyDef def;
    private ParticleEffect p;
    private float tempo,time;



    public RayoFuego(World world,float x, float y) {
        this.world = world;
        def = new BodyDef();
        def.fixedRotation = true;
        def.position.set(x/Pixels, (y+20)/Pixels);
        def.type = BodyDef.BodyType.KinematicBody;
        body = world.createBody(def);
        PolygonShape box = new PolygonShape();
        box.setAsBox(3/Pixels,20/Pixels);
        fixture = body.createFixture(box, 1);
        fixture.setSensor(true);
        box.dispose();
        p = new ParticleEffect();
        p.load(Gdx.files.internal( "particles/RayoFuego.p"),Gdx.files.internal("images"));
        p.setPosition(x/Pixels,y/Pixels);
        p.scaleEffect(0.50f/Pixels);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {

            p.draw(batch, tempo);

    }
    @Override
    public void act(float delta) {

        time += 1 * Gdx.graphics.getDeltaTime();
        if(time > 4 && time < 8) {
            tempo =  Gdx.graphics.getDeltaTime();
            fixture.setUserData("spike");
        }
        if(time > 8)
        {
            fixture.setUserData("none");
            time = 0;
        }
        if(time < 5)
        {

        }  tempo = tempo + .5f * Gdx.graphics.getDeltaTime();

    }


    public void detach()
    {
        body.destroyFixture(fixture);
        world.destroyBody(body);
        p.dispose();
    }

}
