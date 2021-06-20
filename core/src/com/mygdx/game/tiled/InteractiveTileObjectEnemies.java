package com.mygdx.game.tiled;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
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
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.actors.Jugador;

import java.rmi.server.ExportException;
import java.util.ArrayList;

import javax.sound.sampled.Line;

import static com.mygdx.game.MyGdxGame.Pixels;

public abstract class InteractiveTileObjectEnemies extends Actor implements Disposable {
    protected World world;
    protected TiledMap map;
    protected Rectangle bounds;
    protected Body body;

    BodyDef bdef  = new BodyDef();
    FixtureDef fdef = new FixtureDef();
    PolygonShape shape = new PolygonShape();

    boolean izquierda = true,derecha = false;
    boolean isJump;
    boolean espadazo = false;
    boolean Salto = true;


    protected Fixture fixture,fixture2;

    float MaxVelX = 1f;
    float MinVelX = -1f;

    Texture Left,Right,Left2,Right2;
    int c1=1,r1=2;
    int c2=1, r2=2;
    int c3=1,r3=2;
    int c4=1, r4=2;

    int c5  = 1, r5 = 8;
    int c6  = 1, r6 = 8;
    int c7  = 1, r7 = 8;
    int c8  = 1, r8 = 8;

    int iterator;
    float time,timeSalto,time2;
    public static Rectangle Enemies;
    /*********Probar**********/
    boolean reverse;
    Texture negro;

    public static ArrayList<Rectangle> r = new ArrayList<Rectangle>();
    Rectangle enemigo;
    Animation<TextureRegion> WalkLeftA,WalkRightA;
    Animation<TextureRegion> WalkLeftB,WalkRightB;
    Animation<TextureRegion> KillLeftA,KillRightA;
    Animation<TextureRegion> KillLeftB,KillRightB;

    int iterator2 = 0;
    Sound pop;

    /*************SONIDO 3D*************/
    private float volumen;
    public static boolean stop;
    private Music sound;
    float getMiddle;
    float getInicio;
    float getFin;
    float getPX;
    float x;
    float pan;

    public InteractiveTileObjectEnemies(World world, TiledMap map, Rectangle bounds,Texture WalkLeft,Texture WalkRight,Texture WalkLeft2,Texture WalkRight2,Texture Kill1L,Texture Kill1R,Texture Kill2L,Texture Kill2R,int iterator)    {
        this.world = world;
        this.map = map;
        this.bounds = bounds;
        bdef.type = BodyDef.BodyType.DynamicBody;
        bdef.position.set((bounds.getX() + bounds.getWidth()/2)/Pixels,( bounds.getY()+bounds.getHeight()/2)/Pixels);
        body = world.createBody(bdef);
        body.setActive(true);
        shape.setAsBox((bounds.getWidth()/2)/Pixels,(bounds.getHeight()/2)/Pixels);
        fdef.shape = shape;
        fixture = body.createFixture(fdef);
        fixture.setSensor(true);
        fixture2 = body.createFixture(fdef);
        fixture.setSensor(true);
        fixture2.setUserData("Enemigo");
        EdgeShape LineaDeMuerte = new EdgeShape();
        LineaDeMuerte.set(new Vector2(bounds.getX(),bounds.getY()),new Vector2(bounds.getX()+bounds.getWidth(),bounds.getY()+bounds.getHeight()));
        fdef.shape = LineaDeMuerte;
        this.iterator = iterator;
        //body.createFixture(fdef).setUserData("spike");
        shape.dispose();
        enemigo = new Rectangle();
        ////
        this.Left = WalkLeft;
        this.Right = WalkRight;
        this.Left2 = WalkLeft2;
        this.Right2 = WalkRight2;
        negro = new Texture("White.png");
        sound = Gdx.audio.newMusic(Gdx.files.internal("Fuego.mp3"));
        sound.play();
        sound.setLooping(true);


////////////////////////////////////////////////////////

            TextureRegion[][] LeftTmp = TextureRegion.split(Left, Left.getWidth() / c1, Left.getHeight() / r1);
            TextureRegion[] LeftFrames = new TextureRegion[c1 * r1];
            int index1 = 0;
            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c1; j++) {
                    LeftFrames[index1++] = LeftTmp[i][j];
                }
            }
            WalkLeftA = new Animation<TextureRegion>(0.3f, LeftFrames);
            ///////////////////////////////////

            TextureRegion[][] RightTmp = TextureRegion.split(Right, Right.getWidth() / c2, Right.getHeight() / r2);
            TextureRegion[] RightFrames = new TextureRegion[c2 * r2];
            int index2 = 0;
            for (int i = 0; i < r2; i++) {
                for (int j = 0; j < c2; j++) {
                    RightFrames[index2++] = RightTmp[i][j];
                }
            }
            WalkRightA = new Animation<TextureRegion>(0.3f, RightFrames);

        ////////////////////////////////
        TextureRegion[][] Left2Tmp = TextureRegion.split(Left2, Left2.getWidth() / c3, Left2.getHeight() / r3);
        TextureRegion[] Left2Frames = new TextureRegion[c3 * r3];
        int index3= 0;
        for (int i = 0; i < r3; i++) {
            for (int j = 0; j < c3; j++) {
                Left2Frames[index3++] = Left2Tmp[i][j];
            }
        }
        WalkLeftB = new Animation<TextureRegion>(0.3f, Left2Frames);

        ///////////////////////////////////

        TextureRegion[][] Right2Tmp = TextureRegion.split(Right2, Right2.getWidth() / c4, Right2.getHeight() / r4);
        TextureRegion[] Right2Frames = new TextureRegion[c4 * r4];
        int index4 = 0;
        for (int i = 0; i < r4; i++) {
            for (int j = 0; j < c4; j++) {
                Right2Frames[index4++] = Right2Tmp[i][j];
            }
        }
        WalkRightB = new Animation<TextureRegion>(0.3f, Right2Frames);

        //////////////////////////////
        /*************************/
        /*********************/
        /*****************/
        /********/

        TextureRegion[][] KLeftTmp1 = TextureRegion.split(Kill1L, Kill1L.getWidth() / c5, Kill1L.getHeight() / r5);
        TextureRegion[] KLeftFrames1 = new TextureRegion[c5 * r5];
        int index5 = 0;
        for (int i = 0; i < r5; i++) {
            for (int j = 0; j < c5; j++) {
                KLeftFrames1[index5++] = KLeftTmp1[i][j];
            }
        }
        KillLeftA = new Animation<TextureRegion>(0.08f, KLeftFrames1);
        ///////////////////////////////////
        /**********/

        TextureRegion[][] KRightTmp1 = TextureRegion.split(Kill1R, Kill1R.getWidth() / c6, Kill1R.getHeight() / r6);
        TextureRegion[] KRightFrames1 = new TextureRegion[c6 * r6];
        int index6 = 0;
        for (int i = 0; i < r6; i++) {
            for (int j = 0; j < c6; j++) {
                KRightFrames1[index6++] = KRightTmp1[i][j];
            }
        }
        KillRightA = new Animation<TextureRegion>(0.08f, KRightFrames1);
        /**********/
        ////////////////////////////////
        TextureRegion[][] KLeft2Tmp = TextureRegion.split(Kill2L, Kill2L.getWidth() / c7, Kill2L.getHeight() / r7);
        TextureRegion[] KLeft2Frames = new TextureRegion[c7* r7];
        int index7= 0;
        for (int i = 0; i < r7; i++) {
            for (int j = 0; j < c7; j++) {
                KLeft2Frames[index7++] = KLeft2Tmp[i][j];
            }
        }
        KillLeftB = new Animation<TextureRegion>(0.08f, KLeft2Frames);
        /**********/
        ///////////////////////////////////

        TextureRegion[][] KRight2Tmp = TextureRegion.split(Kill2R, Kill2R.getWidth() / c8, Kill2R.getHeight() / r8);
        TextureRegion[] KRight2Frames = new TextureRegion[c8 * r8];
        int index8 = 0;
        for (int i = 0; i < r8; i++) {
            for (int j = 0; j < c8; j++) {
                KRight2Frames[index8++] = KRight2Tmp[i][j];
            }
        }
        KillRightB = new Animation<TextureRegion>(0.1f, KRight2Frames);

        //////////////////////////////
        /********/
        /*****************/
        /*********************/
        /*************************/

        setSize((bounds.getWidth()+2)/Pixels,(bounds.getHeight()+2)/Pixels);
        setPosition(body.getPosition().x-(((bounds.getWidth()-1)/2)/Pixels),body.getPosition().y-((bounds.getHeight()/2)/Pixels));
        Enemies = new Rectangle();
        r.add( new Rectangle(getX(), getY(), getWidth(), getHeight()));
        pop = Gdx.audio.newSound(Gdx.files.internal("Pop.mp3"));
            }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        setPosition(body.getPosition().x-(((bounds.getWidth()-1)/2)/Pixels),body.getPosition().y-((bounds.getHeight()/2)/Pixels));
          if(body.isActive()) {
              TextureRegion WL = WalkLeftA.getKeyFrame(time, true);
              TextureRegion WR = WalkRightA.getKeyFrame(time, true);
              TextureRegion WL2 = WalkLeftB.getKeyFrame(time, true);
              TextureRegion WR2 = WalkRightB.getKeyFrame(time, true);
              if (!isJump) {
                  if (derecha) {
                      batch.draw(WL, getX(), getY(), getWidth(), getHeight());
                  } else if (izquierda) {
                      batch.draw(WR, getX(), getY(), getWidth(), getHeight());
                  }
              } else {
                  if (derecha) {
                      batch.draw(WR2, getX(), getY(), getWidth(), getHeight());
                  } else if (izquierda) {
                      batch.draw(WL2, getX(), getY(), getWidth(), getHeight());

                  }
              }
          }else {
              TextureRegion KL1 = KillLeftA.getKeyFrame(time2, false);
              TextureRegion KR1 = KillRightA.getKeyFrame(time2, false);
              TextureRegion KL2 = KillLeftB.getKeyFrame(time2, false);
              TextureRegion KR2 = KillRightB.getKeyFrame(time2, false);
if(iterator2 ==  0)
{
    pop.play(.5f);
    iterator2++;
}

              if (!isJump) {
                  if (derecha) {
                      batch.draw(KR1, getX(), getY(), getWidth(), getHeight());
                  } else if (izquierda) {
                      batch.draw(KL1, getX(), getY(), getWidth(), getHeight());
                  }
              } else {
                  if (derecha) {
                      batch.draw(KR2, getX(), getY(), getWidth(), getHeight());
                  } else if (izquierda) {
                      batch.draw(KL2, getX(), getY(), getWidth(), getHeight());

                  }
              }
          }
       /*   batch.draw(negro,getPX,AddActors.player.getY(),10/Pixels,10/Pixels);
        batch.draw(negro,getInicio,AddActors.player.getY(),10/Pixels,10/Pixels);
        batch.draw(negro,getMiddle,AddActors.player.getY(),10/Pixels,10/Pixels);
        batch.draw(negro,getFin,AddActors.player.getY(),10/Pixels,10/Pixels);*/
}



    @Override
    public void act(float delta) {
        sonido();
        if(body.isActive()) {
            r.get(iterator).set(getX(), getY(), getWidth(), getHeight());
            if(enemigo.overlaps(AddActors.player.espadaRec))
            {

                if(AddActors.player.Espadazo)
                {
                   // AddResources.ScreenWhite = true;
                    body.setActive(false);

                }
            }
        }else
        {
            time2 += Gdx.graphics.getDeltaTime();
            r.get(iterator).set(0,0,1,1);
        }
        enemigo.set(getX(),getY(),getWidth(),getHeight());



        time += Gdx.graphics.getDeltaTime();
        Movimientos();
        Vector2 velocidad = body.getLinearVelocity();
        if(izquierda) {
            if (velocidad.x < -1f) {
                body.setLinearVelocity(MinVelX,velocidad.y);
            }
        }else if(derecha)
        {
            if (velocidad.x > 1f) {
                body.setLinearVelocity(MaxVelX,velocidad.y);
            }
        }
        if(isJump)
        {
            Jump();
        }
      }

    public void Movimientos()
    {
        if(reverse)
        {
            if(izquierda)
            {
                izquierda = false;
                derecha = true;
            }else
            {
                izquierda = true;
                derecha = false;
            }
            reverse = false;
        }

            if (izquierda) {
                body.applyLinearImpulse(-.1f, 0, body.getPosition().x, body.getPosition().y, true);
            } else {
                derecha = true;
            }
            if (derecha) {
                body.applyLinearImpulse(.1f, 0, body.getPosition().x, body.getPosition().y, true);
            } else {
                izquierda = true;
            }
    }
     public void Jump()
     {
         if(!Salto)
         {
             timeSalto = timeSalto + 1 * Gdx.graphics.getDeltaTime();
         }
         if(timeSalto >= 2)
         {
             Salto = true;
         }
         Vector2 position = body.getPosition();
         if(Salto) {
             body.applyLinearImpulse(0, 5f, position.x, position.y, true);
             Salto = false;
             timeSalto = 0;
         }
     }

     public void sonido()
     {
         if(stop||!body.isActive())
         {
             sound.setLooping(false);
             sound.stop();
         }
         getInicio = body.getPosition().x-3-(5/Pixels);
         getMiddle = body.getPosition().x-(5/Pixels);
         getFin = body.getPosition().x+3-(5/Pixels);
         getPX = Jugador.body.getPosition().x;
         if(getPX > getInicio && getPX < getFin) {
             if (getPX < getMiddle&&getPX >= getInicio) {
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
             if (getPX > getMiddle && getPX <= getFin) {
                 float width1 = getFin - getMiddle;
                 float width2 = getFin - getPX;
                 pan = (width2 * 100) / width1;
                 pan = pan / 100;
                 pan = 1 - pan;
                 pan = pan * -1;
if(pan < -.8f)
{
    pan = -.8f;
}
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
         volumen = 0;
             sound.setVolume(volumen);
         }

        /* if(Gdx.input.isTouched(1)) {
             Gdx.app.log("Volumen", "" + volumen);
             Gdx.app.log("Personaje X", "" + getPX);
             Gdx.app.log("Inicio", "" + getInicio);
             Gdx.app.log("Final", "" + getFin);
             Gdx.app.log("Medio", "" + getMiddle);
             Gdx.app.log("Pan", "" + pan);
         }*/
     }

         public abstract void Izquierda();
    public abstract  void Derecha();
    public abstract  void Death();
    public abstract void  reverse();
    public abstract void  Morir();



    @Override
    public void dispose() {
        negro.dispose();
        Right.dispose();
        Left.dispose();
        Right2.dispose();
        Left2.dispose();
        map.dispose();
        body.destroyFixture(fixture);
        body.destroyFixture(fixture2);
        world.destroyBody(body);
        pop.dispose();
    }

}
