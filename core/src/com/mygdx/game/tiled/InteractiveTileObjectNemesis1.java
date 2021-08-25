package com.mygdx.game.tiled;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
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
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.game.actors.Jugador;

import java.util.ArrayList;

import static com.mygdx.game.MyGdxGame.Pixels;

public abstract class InteractiveTileObjectNemesis1 extends Actor implements Disposable {
    protected World world;
    protected TiledMap map;
    protected Rectangle bounds;
    protected Body body;

    BodyDef bdef  = new BodyDef();
    FixtureDef fdef = new FixtureDef();
    PolygonShape shape = new PolygonShape();

    boolean izquierda = true,derecha = false;



    protected Fixture fixture,fixture2;

    float MaxVelX = 1.5f;
    float MinVelX = -1.5f;

    Texture Left,Right,AttackL,AttackR;
    int c1=1,r1=4;
    int c2=1, r2=4;
    int c3=1,r3=8;
    int c4=1, r4=8;
    int c5 = 1,r5 = 18;
    int c6 = 1, r6 = 18;
    Texture DeadL,DeadR;
    Animation<TextureRegion> Dead1,Dead2;


    int vidas = 3;
    int iterator;
    float time,time2;
    float timeAttack;
    public static Rectangle Enemies;
    Rectangle ProximidadIzq,ProximidadDere;
    Rectangle PI,PD;
    boolean CercaDere,CercaIzq;
    boolean Attack;
    Rectangle Muerte;
    float timeMuerte;
    /*********Probar**********/
    boolean reverse;
    Texture negro,rojo;
    Sprite Dano;
    boolean dano;
    float timedano;
    int iteratorDano;

    public static ArrayList<Rectangle> r = new ArrayList<Rectangle>();
    Rectangle enemigo;
    Animation<TextureRegion> WalkLeftA,WalkRightA;
    Animation<TextureRegion> AttackLeft,AttackRight;
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

    boolean esperar;
    float esperaTime;

    Texture Contorno,Relleno;
    Texture BarrasNegras;
    boolean Active = false;
    Fixture fix1,fix2;
    Body pared1,pared2;
    BodyDef pared1def,pared2def;

    public InteractiveTileObjectNemesis1(World world, TiledMap map, Rectangle bounds, Texture WalkLeft, Texture WalkRight, Texture AttackL, Texture AttackR,Texture deadL,Texture deadR,int iterator)    {
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
        this.AttackL = AttackL;
        this.AttackL = AttackR;
        this.DeadL = deadL;
        this.DeadR = deadR;
        negro = new Texture("White.png");
        rojo = new Texture("Rojo.png");
        sound = Gdx.audio.newMusic(Gdx.files.internal("Fuego.mp3"));
        //sound.play();
        sound.setLooping(true);
        /************Animaciones*****************/
        ProximidadIzq = new Rectangle();
        ProximidadDere = new Rectangle();
        PI = new Rectangle();
        PD = new Rectangle();
        ////////////////////////////////////////////////////////
        TextureRegion[][] TmpLeft = TextureRegion.split(Left,Left.getWidth()/c1,Left.getHeight()/r1);
        TextureRegion[] FramesLeft = new TextureRegion[c1 * r1];
        int index1 = 0;
        for(int i = 0; i < r1; i++)
        {
            for(int j = 0; j < c1; j++)
            {
                FramesLeft[index1++] = TmpLeft[i][j];
            }
        }
        WalkLeftA = new Animation<TextureRegion>(0.2f,FramesLeft);
        ////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////
        TextureRegion[][] TmpRight = TextureRegion.split(Right,Right.getWidth()/c2,Right.getHeight()/r2);
        TextureRegion[] FramesRight= new TextureRegion[c2 * r2];
        int index2 = 0;
        for(int i = 0; i < r2; i++)
        {
            for(int j = 0; j < c2; j++)
            {
                FramesRight[index2++] = TmpRight[i][j];
            }
        }
        WalkRightA = new Animation<TextureRegion>(0.2f,FramesRight);
        ////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////
        TextureRegion[][] TmpAttackRight = TextureRegion.split(AttackR,AttackR.getWidth()/c3,AttackR.getHeight()/r3);
        TextureRegion[] FramesAttackRight= new TextureRegion[c3 * r3];
        int index3 = 0;
        for(int i = 0; i < r3; i++)
        {
            for(int j = 0; j < c3; j++)
            {
                FramesAttackRight[index3++] = TmpAttackRight[i][j];
            }
        }
        AttackRight = new Animation<TextureRegion>(0.2f,FramesAttackRight);
        ////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////
        TextureRegion[][] TmpAttackLeft = TextureRegion.split(AttackL,AttackL.getWidth()/c4,AttackL.getHeight()/r4);
        TextureRegion[] FramesAttackLeft = new TextureRegion[c4 * r4];
        int index4 = 0;
        for(int i = 0; i < r4; i++)
        {
            for(int j = 0; j < c4; j++)
            {
                FramesAttackLeft[index4++] = TmpAttackLeft[i][j];
            }
        }
        AttackLeft = new Animation<TextureRegion>(0.2f,FramesAttackLeft);
        ////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////
        TextureRegion[][] TmpMuerteLeft = TextureRegion.split(DeadL,DeadL.getWidth()/c5,DeadL.getHeight()/r5);
        TextureRegion[] FramesMuerteLeft = new TextureRegion[c5 * r5];
        int index5 = 0;
        for(int i = 0; i < r5; i++)
        {
            for(int j = 0; j < c5; j++)
            {
                FramesMuerteLeft[index5++] = TmpMuerteLeft[i][j];
            }
        }
        Dead1 = new Animation<TextureRegion>(0.05f,FramesMuerteLeft);
        ////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////
        TextureRegion[][] TmpMuerteRight = TextureRegion.split(DeadR,DeadR.getWidth()/c6,DeadR.getHeight()/r6);
        TextureRegion[] FramesMuerteRight = new TextureRegion[c6 * r6];
        int index6 = 0;
        for(int i = 0; i < r6; i++)
        {
            for(int j = 0; j < c6; j++)
            {
                FramesMuerteRight[index6++] = TmpMuerteRight[i][j];
            }
        }
        Dead2 = new Animation<TextureRegion>(0.05f,FramesMuerteRight);
        ////////////////////////////////////////////////////////
        /************Animaciones*****************/
        setSize((bounds.getWidth()+30)/Pixels,(bounds.getHeight()+10)/Pixels);
        setPosition(body.getPosition().x-(((bounds.getWidth()+30)/2)/Pixels),body.getPosition().y-((bounds.getHeight()/2)/Pixels));
        Enemies = new Rectangle();
        r.add( new Rectangle(getX(), getY(), getWidth(), getHeight()));
        pop = Gdx.audio.newSound(Gdx.files.internal("Pop.mp3"));
        Dano = new Sprite();
        Muerte = new Rectangle();
        /********************************/
        Contorno = new Texture("cuboP.png");
        Relleno = new Texture("Cubo.png");
        pared1def = new BodyDef();
        pared1def.type = BodyDef.BodyType.KinematicBody;
        pared1def.position.set((((bounds.getX() + bounds.getWidth()/2))/Pixels)-(150/Pixels),( bounds.getY()+bounds.getHeight()/2)/Pixels);
        pared1 = world.createBody(pared1def);

        PolygonShape pared1Shape = new PolygonShape();
        pared1Shape.setAsBox(.25f,3);
        FixtureDef sh = new FixtureDef();
        sh.shape = pared1Shape;
        fix1 = pared1.createFixture(sh);
        fix1.setFriction(0);
        fix1.setRestitution(0);
        fix1.setDensity(0);
        fix1.setUserData("desMov");
        pared1Shape.dispose();
        pared1.setActive(false);
/**********/
        pared2def = new BodyDef();
        pared2def.type = BodyDef.BodyType.KinematicBody;
        pared2def.position.set((((bounds.getX() + bounds.getWidth()/2))/Pixels)+(100/Pixels),( bounds.getY()+bounds.getHeight()/2)/Pixels);
        pared2 = world.createBody(pared2def);

        PolygonShape pared2Shape = new PolygonShape();
        pared2Shape.setAsBox(.25f,3);
        FixtureDef sh2= new FixtureDef();
        sh2.shape = pared1Shape;
        fix2 = pared2.createFixture(sh2);
        fix2.setFriction(0);
        fix2.setRestitution(0);
        fix2.setDensity(0);
        fix2.setUserData("desMov");
        pared2Shape.dispose();
        pared2.setActive(false);
        /********************************/
            }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        setPosition(body.getPosition().x-(((bounds.getWidth()+30)/2)/Pixels),body.getPosition().y-((bounds.getHeight()/2)/Pixels));
        /*batch.draw(negro,r.get(iterator).x,r.get(iterator).y,r.get(iterator).width,r.get(iterator).height);
        batch.draw(negro,ProximidadDere.x,ProximidadDere.y,ProximidadDere.width,ProximidadDere.height);
        batch.draw(negro,ProximidadIzq.x,ProximidadIzq.y,ProximidadIzq.width,ProximidadIzq.height);
        batch.draw(rojo,PI.x,PI.y,PI.width,PI.height);
        batch.draw(rojo,PD.x,PD.y,PD.width,PD.height);
        batch.draw(negro,Muerte.x,Muerte.y,Muerte.width,Muerte.height);*/
       if(Active)
        {
            pared1.setActive(true);
            pared2.setActive(true);
            batch.draw(Relleno,pared1.getPosition().x-.25f,pared1.getPosition().y-1,.5f,1.3f);
            batch.draw(Relleno,pared1.getPosition().x-.25f,pared1.getPosition().y-1+(1.3f),.5f,1.3f);
            batch.draw(Contorno,pared1.getPosition().x-.25f,pared1.getPosition().y-1,.5f,1.3f);
            batch.draw(Contorno,pared1.getPosition().x-.25f,pared1.getPosition().y-1+(1.3f),.5f,1.3f);

            batch.draw(Relleno,pared2.getPosition().x-.25f,pared2.getPosition().y-1,.5f,1.3f);
            batch.draw(Relleno,pared2.getPosition().x-.25f,pared2.getPosition().y-1+(1.3f),.5f,1.3f);
            batch.draw(Contorno,pared2.getPosition().x-.25f,pared2.getPosition().y-1,.5f,1.3f);
            batch.draw(Contorno,pared2.getPosition().x-.25f,pared2.getPosition().y-1+(1.3f),.5f,1.3f);

        }else
        {
            pared1.setActive(false);
            pared2.setActive(false);
            batch.draw(Contorno,pared1.getPosition().x-.25f,pared1.getPosition().y-1,.5f,1.3f);
            batch.draw(Contorno,pared1.getPosition().x-.25f,pared1.getPosition().y+.3f,.5f,1.3f);
            batch.draw(Contorno,pared2.getPosition().x-.25f,pared2.getPosition().y-1,.5f,1.3f);
            batch.draw(Contorno,pared2.getPosition().x-.25f,pared2.getPosition().y+.3f,.5f,1.3f);
        }
          if(body.isActive()) {

              Gdx.app.log("Vidas",""+vidas);
              TextureRegion WL = WalkLeftA.getKeyFrame(time, true);
              TextureRegion WR = WalkRightA.getKeyFrame(time, true);
              TextureRegion attackLeft = AttackLeft.getKeyFrame(timeAttack, true);
              TextureRegion attackRight = AttackRight.getKeyFrame(timeAttack, true);


              if(Attack)
              {
                  timeAttack += Gdx.graphics.getDeltaTime();
                  timeMuerte += 1 * Gdx.graphics.getDeltaTime();
                  if (derecha) {
                  if(AttackRight.isAnimationFinished(timeAttack))
                  {
                      Attack = false;
                      esperar = true;
                  }
                  }
                  if(izquierda)
                  {
                      if(AttackLeft.isAnimationFinished(timeAttack))
                      {
                          Attack = false;
                          esperar = true;
                      }
                  }
              }else
              {
                  timeMuerte = 0;
                  timeAttack = 0;
              }
              if (derecha) {
                  if(Attack)
                  {
                      Dano = new Sprite(attackRight);
                      Dano.setBounds(getX(), getY(), getWidth(), getHeight());
                      if(dano)
                      {
                          Dano.setColor(Color.RED);
                          timedano += 1 * Gdx.graphics.getDeltaTime();
                          if(timedano > 1)
                          {
                              timedano = 0;
                              dano = false;
                          }
                      }
                      Dano.draw(batch);
                    //  batch.draw(attackRight, getX(), getY(), getWidth(), getHeight());
                  }else
                  {
                      Dano = new Sprite(WR);
                      Dano.setBounds(getX(), getY(), getWidth(), getHeight());
                      if(dano)
                      {
                          Dano.setColor(Color.RED);
                          timedano += 1 * Gdx.graphics.getDeltaTime();
                          if(timedano >  1)
                          {
                              timedano = 0;
                              dano = false;
                          }
                      }
                      Dano.draw(batch);
                      //batch.draw(WR, getX(), getY(), getWidth(), getHeight());
                  }

              }
              if (izquierda) {
                  if(Attack)
                  {
                      Dano = new Sprite(attackLeft);
                      Dano.setBounds(getX(), getY(), getWidth(), getHeight());
                      if(dano)
                      {
                          Dano.setColor(Color.RED);
                          timedano += 1 * Gdx.graphics.getDeltaTime();
                          if(timedano > 1)
                          {
                              timedano = 0;
                              dano = false;
                          }
                      }
                      Dano.draw(batch);
                      //batch.draw(attackLeft, getX(), getY(), getWidth(), getHeight());
                  }else
                  {
                      Dano = new Sprite(WL);
                      Dano.setBounds(getX(), getY(), getWidth(), getHeight());
                      if(dano)
                      {
                          Dano.setColor(Color.RED);
                          timedano += 1 * Gdx.graphics.getDeltaTime();
                          if(timedano >  1)
                          {
                              timedano = 0;
                              dano = false;
                          }
                      }
                      Dano.draw(batch);
                      //batch.draw(WL, getX(), getY(), getWidth(), getHeight());
                  }
              }
              if(!Attack) {
                  if (ProximidadIzq.overlaps(Jugador.jugador)) {
                      izquierda = true;
                      derecha = false;
                      Active = true;
                  }
                  if (ProximidadDere.overlaps(Jugador.jugador)) {
                      derecha = true;
                      izquierda = false;
                      Active = true;
                  }
              }
            /*  if(!ProximidadIzq.overlaps(Jugador.jugador)&&!ProximidadIzq.overlaps(Jugador.jugador))
              {
                  batch.draw(WR, getX(), getY(), getWidth(), getHeight());
              }*/

          }else
          {
              TextureRegion izq = Dead1.getKeyFrame(time,false);
              TextureRegion dere = Dead2.getKeyFrame(time,false);
              if(!Dead1.isAnimationFinished(time))
              {
                  if(izquierda)
                  {
                      batch.draw(izq,getX(),getY(),getWidth(),getHeight());
                  }
              }
              if(!Dead2.isAnimationFinished(time)) {
                  if (derecha) {
                      batch.draw(dere, getX(), getY(), getWidth(), getHeight());
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
        //sonido();
        if(body.isActive()) {
            ProximidadIzq.set(getX()+(15/Pixels)-(100/Pixels),getY(),100/Pixels,getHeight());
            ProximidadDere.set(getX()+(15/Pixels)+(getWidth()-(30/Pixels)),getY(),100/Pixels,getHeight());
            PD.set(getX()+(15/Pixels)+(getWidth()-(30/Pixels)),getY(),20/Pixels,getHeight());
            PI.set(getX()+(15/Pixels)-(20/Pixels),getY(),20/Pixels,getHeight());
            r.get(iterator).set(getX()+(20/Pixels), getY(), getWidth()-(40/Pixels) ,getHeight());
            if(timeMuerte > .8f&& timeMuerte < 1) {
                if (derecha) {
               Muerte.set(getX()+(15/Pixels)+(getWidth()-(30/Pixels)),getY(),20/Pixels,getHeight()-(10/Pixels));
                }else if(izquierda)
                {
                    Muerte.set(getX()+(15/Pixels)-(20/Pixels),getY(),20/Pixels,getHeight()-(10/Pixels));
                }
            }else
            {
                Muerte.set(0,0,0,0);
            }
            if(Muerte.overlaps(Jugador.jugador))
            {
                Jugador.Muerto = true;
            }
            if(enemigo.overlaps(AddActors.player.espadaRec)) {

                if (AddActors.player.Espadazo) {
                    if(iteratorDano == 0) {
                        dano = true;
                        iteratorDano++;
                        if (vidas != 0) {
                            vidas--;
                        } else {
                            time = 0;
                            body.setActive(false);
                            Active = false;
                        }
                    }

                }else
                {
                    iteratorDano=0;
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
            if (velocidad.x < -1.5f) {
                body.setLinearVelocity(MinVelX,velocidad.y);
            }
        }else if(derecha)
        {
            if (velocidad.x > 1.5f) {
                body.setLinearVelocity(MaxVelX,velocidad.y);
            }
        }

      }

    public void Movimientos()
    {
        if(!esperar) {
            if (!Attack) {
                if (ProximidadIzq.overlaps(Jugador.jugador) || ProximidadDere.overlaps(Jugador.jugador)) {


                    if (izquierda) {
                        body.applyLinearImpulse(-1f, 0, body.getPosition().x, body.getPosition().y, true);
                    }
                    if (derecha) {
                        body.applyLinearImpulse(1f, 0, body.getPosition().x, body.getPosition().y, true);
                    }
                } else {
                    body.setLinearVelocity(0, 0);
                }

            } else {
                body.setLinearVelocity(0, 0);
            }
            if (PI.overlaps(Jugador.jugador) || PD.overlaps(Jugador.jugador)) {
                Attack = true;
            }
        }else
        {
            body.setLinearVelocity(0, 0);
            esperaTime += 1 * Gdx.graphics.getDeltaTime();
            if(esperaTime > 2)
            {
                esperaTime = 0;
                esperar = false;
            }
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


     }


    public abstract  void Death();




    @Override
    public void dispose() {
        sound.dispose();
        Contorno.dispose();
        Relleno.dispose();
        negro.dispose();
        rojo.dispose();
        Right.dispose();
        Left.dispose();
        AttackL.dispose();
        AttackR.dispose();
        map.dispose();
        body.destroyFixture(fixture);
        body.destroyFixture(fixture2);
        world.destroyBody(body);
        pop.dispose();
    }

}
