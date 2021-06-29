package com.mygdx.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.tiled.AddResources;

import java.awt.Frame;

import static com.mygdx.game.MyGdxGame.Pixels;

public class ArbolVerde extends Actor implements Disposable{
    private Body body;
    private Texture texture;
    private World world;
    private Fixture fixture;
    private BodyDef def;
    public static Rectangle rectangle;

    private BodyDef def1,def2;
    private Body body1,body2;
    private Fixture fixture1, fixture2;
    /**********Animation************/
    float timeA2;
    Animation<TextureRegion> animation1;
    int c1 = 1, r1 = 4;
    float time1;
    Texture animationTexture1;

    Animation<TextureRegion> animation2;
    int c2 = 1, r2 = 4;
    float time2;
    Texture animationTexture2;
    /******************************/
    ParticleEffect particula;
    float timeiterator;
    boolean activarParticula;
    float tempo;
    Texture HojaRosa;
    Rectangle HojaRosaRec;
    int iteratorRosa = 0;
    public ArbolVerde(World world, Texture texture, float x, float y)
    {
        this.world = world;


        this.texture = texture;

        def = new BodyDef();
        def.position.set(x/Pixels, y/Pixels);
        def.fixedRotation = true;
        def.type = BodyDef.BodyType.KinematicBody;

        body = world.createBody(def);
        PolygonShape box = new PolygonShape();
        box.setAsBox(12/Pixels,12/Pixels);
        fixture = body.createFixture(box,20);
        fixture.setUserData("ArbolVerde");
        fixture.setSensor(true);
        box.dispose();
        setSize(24/Pixels,24/Pixels);
        rectangle = new Rectangle();

        /********Plataformas**********/
        def1 = new BodyDef();
        def1.position.set((x/Pixels)-1.3f,(y+65)/Pixels);
        def1.type = BodyDef.BodyType.KinematicBody;

        body1 = world.createBody(def1);
        body1.setGravityScale(0);
        PolygonShape box1 = new PolygonShape();
        box1.setAsBox(.5f,2/Pixels);
        fixture1 = body1.createFixture(box1,0);
        fixture1.setUserData("PisoBase");
        box1.dispose();

        def2 = new BodyDef();
        def2.position.set((x-10)/Pixels,(y+40)/Pixels);
        def2.type = BodyDef.BodyType.KinematicBody;

        body2 = world.createBody(def2);
        body2.setGravityScale(0);
        PolygonShape box2 = new PolygonShape();
        box2.setAsBox(.5f,2/Pixels);
        fixture2 = body2.createFixture(box2,0);
        fixture2.setUserData("PisoBase");
        box2.dispose();

        particula = new ParticleEffect();
        particula.load(Gdx.files.internal("particles/fertilizer2.p"),Gdx.files.internal("images"));
        particula.scaleEffect(.2f/Pixels);

        /******Animation***********/
        animationTexture1 = new Texture("AnimationArbolV(1).png");
        TextureRegion[][]TmpAnimation1 = TextureRegion.split(animationTexture1,animationTexture1.getWidth()/c1,animationTexture1.getHeight()/r1);
        TextureRegion[] FramesAnimation1 = new TextureRegion[c1 * r1];
        int index1 = 0;
        for(int i = 0; i < r1; i++)
        {
            for(int j = 0; j < c1; j++)
            {
                FramesAnimation1[index1++]=TmpAnimation1[i][j];
            }
        }
        animation1 = new Animation<TextureRegion>(0.2f,FramesAnimation1);
        /**************************/
        /******Animation***********/
        animationTexture2 = new Texture("AnimationArbolV(2).png");
        TextureRegion[][]TmpAnimation2 = TextureRegion.split(animationTexture2,animationTexture2.getWidth()/c2,animationTexture2.getHeight()/r2);
        TextureRegion[] FramesAnimation2 = new TextureRegion[c2 * r2];
        int index2 = 0;
        for(int i = 0; i < r2; i++)
        {
            for(int j = 0; j < c2; j++)
            {
                FramesAnimation2[index2++]=TmpAnimation2[i][j];
            }
        }
        animation2 = new Animation<TextureRegion>(0.2f,FramesAnimation2);
        /**************************/
        HojaRosa = new Texture("HojaRosa.png");
        HojaRosaRec = new Rectangle();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        setPosition(body.getPosition().x-(12/Pixels),body.getPosition().y);
        if(iteratorRosa == 0 &&   MyGdxGame.HojaRosa.getInteger("HojaRosa") < 1){
            batch.draw(HojaRosa, getX() - 3, getY() + 5, 25 / Pixels, 25 / Pixels);
            HojaRosaRec.set(getX() - 3, getY() + 5, 25 / Pixels, 25 / Pixels);
            if (HojaRosaRec.overlaps(Jugador.jugador)) {
                MyGdxGame.HojaRosa.putInteger("HojaRosa", 1);
                MyGdxGame.HojaRosa.flush();
                iteratorRosa++;
            }

        }
        batch.draw(texture, getX(),getY(),getWidth(),getHeight());
        if(MyGdxGame.HojaVerde.getInteger("HojaVerdeA1") != 2) {
            rectangle.set(getX(), getY(), getWidth(), getHeight());
        }
        if(rectangle.overlaps(Jugador.jugador)&&MyGdxGame.HojaVerde.getInteger("HojaVerde")==1)
        {

            if (Gdx.input.isKeyPressed(Input.Keys.BUTTON_A) || Jugador.SaltoUp) {
                MyGdxGame.HojaVerde.putInteger("HojaVerdeA1",1);
                MyGdxGame.HojaVerde.flush();
                activarParticula = true;
                MyGdxGame.HojaVerde.putInteger("HojaVerde",2);
                MyGdxGame.HojaVerde.flush();
            }
        }
        if(rectangle.overlaps(Jugador.jugador)&&MyGdxGame.HojaVerde.getInteger("HojaVerde")==1||rectangle.overlaps(Jugador.jugador)&&MyGdxGame.HojaVerde.getInteger("HojaVerde")==2)
        {
            Jugador.istouchTienda2 = true;
        }else
        {
            Jugador.istouchTienda2 = false;
        }

/*******animation2**********/


if(timeA2 >= 1) {
    if (rectangle.overlaps(Jugador.jugador) && MyGdxGame.HojaVerde.getInteger("HojaVerdeA1") == 1 && MyGdxGame.Fertilizantes.getInteger("Fertilizantes") >= 9) {

        if (Gdx.input.isKeyPressed(Input.Keys.BUTTON_A) || Jugador.SaltoUp) {
            MyGdxGame.HojaVerde.putInteger("HojaVerdeA1", 2);
            MyGdxGame.HojaVerde.flush();

activarParticula = true;

            int fertilizantes = MyGdxGame.Fertilizantes.getInteger("Fertilizantes");
            fertilizantes -= 9;
            MyGdxGame.Fertilizantes.putInteger("Fertilizantes", fertilizantes);
            MyGdxGame.Fertilizantes.flush();

        }
    }
}
        /****************/
        animaciones(batch);

       if(activarParticula) {
           particula.draw(batch, tempo);

       }else
       {
           particula.reset();
           particula.scaleEffect(.4f/Pixels);
       }


    }

    public void animaciones(Batch batch)
    {

        switch (MyGdxGame.HojaVerde.getInteger("HojaVerdeA1"))
        {
            case  1:
            {
                time1 += Gdx.graphics.getDeltaTime();
                TextureRegion current = animation1.getKeyFrame(time1 ,false);
                batch.draw(current,getX()-5f,getY(),10,16);
                if(animation1.isAnimationFinished(time1))
                {
                    timeA2 += 1* Gdx.graphics.getDeltaTime();
                }

                break;
            }
            case 2:
            {
                rectangle.set(0,0,0,0);
                time2 += Gdx.graphics.getDeltaTime();
                TextureRegion current = animation2.getKeyFrame(time2 ,false);
                batch.draw(current,getX()-5f,getY(),10,16);
                break;
            }
        }

    }

    @Override
    public void act(float delta) {

        if(activarParticula) {
            tempo = Gdx.graphics.getDeltaTime();
            timeiterator += .5f * Gdx.graphics.getDeltaTime();
            if( timeiterator > 1)
            {
                activarParticula = false;
                timeiterator = 0;
            }
        }
        particula.update(delta);

        particula.setPosition(getX()-.5f,getY()+.1f);
//Jugador.body.getPosition().x,Jugador.body.getPosition().y
        if(MyGdxGame.HojaVerde.getInteger("HojaVerdeA1") == 2) {
            if (body1.getPosition().y <= Jugador.body.getPosition().y - (8 / Pixels)) {
                body1.setActive(true);
            } else {
                body1.setActive(false);
            }

            if (body2.getPosition().y <= Jugador.body.getPosition().y - (8 / Pixels)) {
                body2.setActive(true);
            } else {
                body2.setActive(false);
            }
        }else
        {
            body1.setActive(false);
            body2.setActive(false);
        }
    }

    @Override
    public void dispose() {
        animationTexture1.dispose();
        animationTexture2.dispose();
       body.destroyFixture(fixture);
       world.destroyBody(body);
        body1.destroyFixture(fixture1);
        world.destroyBody(body1);
        body2.destroyFixture(fixture2);
        world.destroyBody(body2);
        HojaRosa.dispose();
        particula.dispose();
    }
}
