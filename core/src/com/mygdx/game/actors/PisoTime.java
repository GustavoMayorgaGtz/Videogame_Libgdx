package com.mygdx.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.tiled.AddActors;

import java.awt.image.PixelInterleavedSampleModel;

import static com.mygdx.game.MyGdxGame.Pixels;

public class PisoTime extends Actor {
    private Body body;
    private Texture texture,texture2;
    private World world;
    private Fixture fixture;
    private BodyDef def;
    public boolean Deshacer = false;
    float time1 = 0f, time2 = 0f;
    Music music1;
    MyGdxGame game;
    float getMiddle;
    float getInicio;
    float getFin;
    float getPX;
    float x;
    float pan;
    AddActors add;
    float volumen;
    Sound sound1;
    float iterator = 0;
    public PisoTime(World world, Texture texture,Texture texture2, float x, float y)
    {
        this.world = world;
        this.body = body;

        this.texture = texture;
        this.texture2 = texture2;


        def = new BodyDef();
        def.position.set(x/Pixels, y/Pixels);
        def.type = BodyDef.BodyType.StaticBody;
        body = world.createBody(def);
        body.setAwake(true);
        PolygonShape box = new PolygonShape();
        box.setAsBox(18/Pixels, 12/ Pixels);
        fixture = body.createFixture(box,1);
        fixture.setUserData("PisoTime");
        box.dispose();

        setPosition((x-18)/Pixels,(y-12)/Pixels);
        setSize(36/Pixels, 24/Pixels);//3

       /* music1 =Gdx.audio.newMusic(Gdx.files.internal("PisoTime.mp3"));
        music1.setLooping(true);
        music1.play();*/

        sound1 = Gdx.audio.newSound(Gdx.files.internal("PisoTime.mp3"));
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if(body.isActive()) {
            if (Deshacer == false) {
                batch.draw(texture, getX(), getY(), getWidth(), getHeight());
            } else {
                batch.draw(texture2, getX(), getY(), getWidth(), getHeight());
            }
        }

    }

    @Override
    public void act(float delta) {

contacto();
        if(Deshacer == true)
        {
            time1 = time1 + 1 * Gdx.graphics.getDeltaTime();
            if(time1 >= 1)
            {
                body.setActive(false);

                if(time1 >= 5) {


                    Deshacer = false;
                    time1 = 0;
                }
            }
        }else
        {
            body.setActive(true);
            iterator = 0;
        }
    }
    public void contacto()
    {
       Vector2 position = Jugador.body.getPosition();
       if(position.x-3f/Pixels >= body.getPosition().x-18/Pixels&&position.x-3f/Pixels <= (body.getPosition().x+18/Pixels)
               &&  position.y-8/Pixels <= body.getPosition().y+13/Pixels  &&position.y-8/Pixels >= body.getPosition().y) {
           Gdx.input.vibrate(100);
           if(iterator == 1)
           {
               sound1.play();
           }
           iterator++;
           Deshacer = true;
       }

    }


    public void detach()
    {

        sound1.dispose();
        body.destroyFixture(fixture);
        world.destroyBody(body);

    }

}
