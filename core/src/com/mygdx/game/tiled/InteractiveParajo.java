package com.mygdx.game.tiled;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.game.actors.Jugador;

import static com.mygdx.game.MyGdxGame.Pixels;

public abstract class InteractiveParajo extends Actor implements Disposable {
    protected World world;
    protected Body body;
    BodyDef bdef  = new BodyDef();
    FixtureDef fdef = new FixtureDef();
    PolygonShape shape = new PolygonShape();
    protected Fixture fixture,fixture2;
    Rectangle Cuerpo;
    float x,y;
    boolean isDangerous = false;
    Texture white;
    /***********animations*******/
    boolean derecha= false,izquierda = true;
    boolean volarDerecha= false , volarIzquierda = false;
    Animation<TextureRegion> StaticR;
    Animation<TextureRegion> StaticL;
    Animation<TextureRegion> FlyR;
    Animation<TextureRegion> FlyL;

    float time,time2,time3;
    int c = 2, r = 16;
    int c1 = 2, r1 = 16;
    int c2 = 2, r2 = 2;
    int c3 = 2, r3 = 2;

    int iterator = 0;

    /******************/


    public InteractiveParajo(World world,float x, float y, Texture a, Texture e, Texture it, Texture o)    {
        this.world = world;
        this.x = x;
        this.y = y;

        bdef.type = BodyDef.BodyType.KinematicBody;
        bdef.position.set((x + (12/2))/Pixels,( y+(12))/Pixels);
        body = world.createBody(bdef);
        shape.setAsBox(12/Pixels,12/Pixels);
        fdef.shape = shape;
        fixture = body.createFixture(fdef);
        fixture.setSensor(true);
        shape.dispose();
/**************Animations Create*/////////////
        Cuerpo = new Rectangle();

        ///////Static Dere////////
        TextureRegion[][] FramesStaticR = TextureRegion.split(a,a.getWidth()/c,a.getHeight()/r);
        TextureRegion[] TmpStaticR = new TextureRegion[c * r];
        int index = 0;
        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                TmpStaticR[index++] = FramesStaticR[i][j];
            }
        }
        StaticR = new Animation<TextureRegion>(.1f,TmpStaticR);
        /////////////////////////
        ////Static Izq///////////
        TextureRegion[][] FramesStaticL = TextureRegion.split(e,e.getWidth()/c1,e.getHeight()/r1);
        TextureRegion[] TmpStaticL = new TextureRegion[c1 * r1];
        int index1 = 0;
        for(int i = 0; i < r1; i++)
        {
            for(int j = 0; j < c1; j++)
            {
                TmpStaticL[index1++] = FramesStaticL[i][j];
            }
        }
        StaticL = new Animation<TextureRegion>(.1f,TmpStaticL);
        /////////////////////////
        ////Fly R//////////
        TextureRegion[][] FramesFlyR = TextureRegion.split(it,it.getWidth()/c2,it.getHeight()/r2);
        TextureRegion[] TmpFlyR = new TextureRegion[c2 * r2];
        int index2 = 0;
        for(int i = 0; i < r2; i++)
        {
            for(int j = 0; j < c2; j++)
            {
                TmpFlyR[index2++] = FramesFlyR[i][j];
            }
        }
        FlyR = new Animation<TextureRegion>(0.2f,TmpFlyR);
        /////////////////////////
        ////Fly L//////////
        TextureRegion[][] FramesFlyL = TextureRegion.split(o,o.getWidth()/c3,o.getHeight()/r3);
        TextureRegion[] TmpFlyL = new TextureRegion[c3 * r3];
        int index3 = 0;
        for(int i = 0; i < r3; i++)
        {
            for(int j = 0; j < c3; j++)
            {
                TmpFlyL[index3++] = FramesFlyL[i][j];
            }
        }
        FlyL = new Animation<TextureRegion>(0.2f,TmpFlyL);
        /////////////////////////
        white = new Texture("White.png");
        setSize(24/Pixels,24/Pixels);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        setPosition(body.getPosition().x-12/Pixels,body.getPosition().y-12/Pixels);
       // batch.draw(white,Cuerpo.getX(),Cuerpo.getY(),Cuerpo.getWidth(),Cuerpo.getHeight());


        TextureRegion VolarDerecha = FlyR.getKeyFrame(time3,true);
        TextureRegion VolarIzquierda = FlyL.getKeyFrame(time3,true);



        if(!isDangerous) {

            if (izquierda) {

                time2 += Gdx.graphics.getDeltaTime();

                TextureRegion Izquierda = StaticL.getKeyFrame(time2, false);
                batch.draw(Izquierda, getX(), getY(), getWidth(), getHeight());
                if (StaticL.isAnimationFinished(time2)) {
                 izquierda = false;
                 time = 0;
                }
            } else
            {
                time += Gdx.graphics.getDeltaTime();
                TextureRegion Derecha = StaticR.getKeyFrame(time, false);
                batch.draw(Derecha, getX(), getY(), getWidth(), getHeight());
                izquierda = false;
                if (StaticR.isAnimationFinished(time)) {
                    izquierda = true;
                     time2 = 0;
                }
            }


        }else {

            if(volarDerecha)
            {

                batch.draw(VolarDerecha,getX(),getY(),getWidth(),getHeight());
            }
            if(volarIzquierda)
            {
                batch.draw(VolarIzquierda,getX(),getY(),getWidth(),getHeight());
            }

        }
    }

    @Override
    public void act(float delta) {
        time3 += Gdx.graphics.getDeltaTime();
        Cuerpo.set(getX(),getY(),getWidth(),getHeight());

            if (isDangerous) {
                if(iterator == 0) {
                if (Jugador.dereD) {
                    volarDerecha = true;
                    volarIzquierda = false;
                }
                if (Jugador.izqD) {
                    volarIzquierda = true;
                    volarDerecha = false;
                }
                    iterator++;
            }

        }
        if(volarDerecha)
        {
            body.setLinearVelocity(1.5f, 1.5f);
        }
        if(volarIzquierda)
        {
            body.setLinearVelocity(-1.5f, 1.5f);
        }
    }

    public abstract void detectar();

    @Override
    public void dispose() {

        white.dispose();
        body.destroyFixture(fixture);
        world.destroyBody(body);
    }

}
