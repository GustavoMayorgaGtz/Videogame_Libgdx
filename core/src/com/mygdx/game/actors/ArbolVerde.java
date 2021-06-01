package com.mygdx.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
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
        animation1 = new Animation<TextureRegion>(0.5f,FramesAnimation1);
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
        animation2 = new Animation<TextureRegion>(0.5f,FramesAnimation2);
        /**************************/
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        setPosition(body.getPosition().x-(12/Pixels),body.getPosition().y);
        batch.draw(texture, getX(),getY(),getWidth(),getHeight());
        rectangle.set( getX(),getY(),getWidth(),getHeight());
        if(rectangle.overlaps(Jugador.jugador)&&MyGdxGame.HojaVerde.getInteger("HojaVerde")==1)
        {
            Jugador.istouchTienda2 = true;
            if (Gdx.input.isKeyPressed(Input.Keys.BUTTON_A) || Jugador.SaltoUp) {
                MyGdxGame.HojaVerde.putInteger("HojaVerdeA1",1);
                MyGdxGame.HojaVerde.flush();
                timeA2 += 1* Gdx.graphics.getDeltaTime();
            }
        }else
        {
            Jugador.istouchTienda2 = false;
        }
/*******animation2**********/
if(timeA2 >= 3) {
    if (rectangle.overlaps(Jugador.jugador) && MyGdxGame.HojaVerde.getInteger("HojaVerdeA1") == 1 && MyGdxGame.Fertilizantes.getInteger("Fertilizantes") >= 9) {
        int fertilizantes = MyGdxGame.Fertilizantes.getInteger("Fertilizantes");
        fertilizantes -= 9;
        MyGdxGame.Fertilizantes.putInteger("Fertilizantes", fertilizantes);
        MyGdxGame.Fertilizantes.flush();

        if (Gdx.input.isKeyPressed(Input.Keys.BUTTON_A) || Jugador.SaltoUp) {
            MyGdxGame.HojaVerde.putInteger("HojaVerdeA2", 1);
            MyGdxGame.HojaVerde.flush();
        }
    }
}
        /****************/
        animaciones(batch);

    }

    public void animaciones(Batch batch)
    {
        if(MyGdxGame.HojaVerde.getInteger("HojaVerdeA1")==1)
        {

             time1 += Gdx.graphics.getDeltaTime();
             TextureRegion current = animation1.getKeyFrame(time1 ,false);
             batch.draw(current,getX()-2.5f,getY(),5,10);
        }
        if(MyGdxGame.HojaVerde.getInteger("HojaVerdeA2")==1)
        {
            time2 += Gdx.graphics.getDeltaTime();
            TextureRegion current = animation2.getKeyFrame(time2 ,false);
            batch.draw(current,getX()-2.5f,getY(),5,10);
        }

    }


    @Override
    public void dispose() {
        animationTexture1.dispose();
        animationTexture2.dispose();
       body.destroyFixture(fixture);
       world.destroyBody(body);
    }
}
