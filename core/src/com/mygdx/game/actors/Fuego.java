package com.mygdx.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.tiled.AddActors;

import static com.mygdx.game.MyGdxGame.Pixels;

public class Fuego extends Actor {

    private Body body,bodyLeft;
    private Texture texture;
    private World world;
    private Fixture fixture,fixLeft;
    private BodyDef def,defLeft;
    private FixtureDef fdef;
    public static Music sound;
    MyGdxGame game;
    float getMiddle;
    float getInicio;
    float getFin;
    float getPX;
    float x;
    float pan;
AddActors add;
    long id;
    ///Animacion//
    private Animation<TextureRegion> fuegoAnimation;
    private int c = 2, r = 5;
    private float tempo;
    private float volumen;
    public Fuego(World world, Texture texture, float x, float y)
    {
        this.world = world;
        this.texture = texture;
        this.x = x;
        def = new BodyDef();
        def.position.set((x-(12/2))/Pixels,( y-(12/2))/Pixels);
        def.fixedRotation = true;
        def.type = BodyDef.BodyType.DynamicBody;
        body = world.createBody(def);

        PolygonShape box = new PolygonShape();
        box.setAsBox((12)/Pixels,(12)/Pixels);
        fdef = new FixtureDef();

        PolygonShape Abajo = new PolygonShape();
        Abajo.setAsBox(48/Pixels,24/Pixels);
        fdef.shape = Abajo;
        fdef.isSensor = true;
        fdef.density= 100/Pixels;
        body.createFixture(fdef).setUserData("Abajo");
        fdef.shape = box;
        fdef.isSensor = false;
        fdef.density= 0;
        fdef.friction = 0;
        body.createFixture(fdef).setUserData("Fuego");
        box.dispose();
        setSize(32/Pixels, 32/Pixels);//3

        sound = Gdx.audio.newMusic(Gdx.files.internal("Fuego.mp3"));
        sound.play();
   //     sound.setVolume(volumen);
        sound.setLooping(true);

        TextureRegion[][] TmpFuego = TextureRegion.split(texture,texture.getWidth()/c,texture.getHeight()/r);
        TextureRegion[] Frames = new TextureRegion[c * r];
        int index = 0;
        for(int i = 0 ; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                Frames[index++] = TmpFuego[i][j];
            }
        }
        fuegoAnimation = new Animation<TextureRegion>(0.2f,Frames);
        body.setActive(false);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        TextureRegion animacionFuego = fuegoAnimation.getKeyFrame(tempo,true);
        setPosition(body.getPosition().x-(16)/Pixels,body.getPosition().y-(12)/Pixels);
        batch.draw(animacionFuego, getX(),getY(),getWidth(),getHeight());

    }

    @Override
    public void act(float delta) {

        tempo += Gdx.graphics.getDeltaTime();
        getInicio = (x-100)/Pixels;
        getMiddle = (x-(12/2))/Pixels;
        getFin = (x+80)/Pixels;
        getPX = add.player.getX();
        if(getPX > getInicio && getPX < getFin) {
            if (getPX < getMiddle) {
                float width1 = getMiddle - getInicio;
                float width2 = getMiddle - getPX;
                pan = (width2 * 100) / width1;
                pan = pan / 100;
                if(pan > .5f)
                {
                    volumen = 0.3f;
                }else
                {
                    volumen = 0.8f;
                }
            }
            if (getPX > getMiddle) {
                float width1 = getFin - getMiddle;
                float width2 = getFin - getPX;
                pan = (width2 * 100) / width1;
                pan = pan / 100;
                pan = 1 - pan;
                pan = pan * -1;

                if(pan < -.5f)
                {
                    volumen = 0.3f;
                }else
                {
                    volumen = 0.8f;
                }
            }

            sound.setPan(pan,volumen);

        }else
        {
            sound.setVolume(0);
            //volumen = 0.0f;
        }
       /* Gdx.app.log("Volumen", "" + volumen);
        if(Gdx.input.isKeyPressed(Input.Keys.BUTTON_R2)) {
            Gdx.app.log("Personaje X", "" + getPX);
            Gdx.app.log("Inicio", "" + getInicio);
            Gdx.app.log("Final", "" + getFin);
            Gdx.app.log("Medio", "" + getMiddle);
            Gdx.app.log("Pan", "" + pan);
        }*/
    }

    public void detach()
    {
        sound.dispose();
        body.destroyFixture(fixture);
        world.destroyBody(body);
        bodyLeft.destroyFixture(fixLeft);
        world.destroyBody(bodyLeft);

    }

}

