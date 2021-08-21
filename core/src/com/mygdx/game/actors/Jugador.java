package com.mygdx.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.joints.DistanceJoint;
import com.badlogic.gdx.physics.box2d.joints.DistanceJointDef;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.Casa;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Nivel0;
import com.mygdx.game.Nivel1;
import com.mygdx.game.Nivel1Progresion;
import com.mygdx.game.Nivel2;
import com.mygdx.game.Nivel5;
import com.mygdx.game.Nivel6;
import com.mygdx.game.Nivel7;
import com.mygdx.game.Niveo1T;
import com.mygdx.game.tiled.AddActors;
import com.mygdx.game.tiled.AddResources;
import com.mygdx.game.tiled.AddResourcesOfMenu;
import com.mygdx.game.tiled.Cajas;
import com.mygdx.game.tiled.EnemigoWalk;
import com.mygdx.game.tiled.InteractivePlataformaMov;
import com.mygdx.game.tiled.InteractiveTileCoins;
import com.mygdx.game.tiled.InteractiveTileObjectEnemies;
import com.mygdx.game.tiled.InteractiveTilePortal;
import com.mygdx.game.tiled.Niveles;



import java.io.Console;
import java.util.ArrayList;

import static com.mygdx.game.MyGdxGame.Pixels;

public class Jugador extends Actor {

   public static Body body;
    Fixture fixture;
    FixtureDef espada;

    World world;
    Texture dere,izq;
    BodyDef def;
    //
    Animation<TextureRegion> EspadazoEffect;
    Animation<TextureRegion> EspadazoEffectI;
    Animation<TextureRegion> estaticoDerecha;
    Animation<TextureRegion> estaticoIzquierda;
    Animation<TextureRegion> caminarDerecha;
    Animation<TextureRegion> caminarIzq;
    Animation<TextureRegion> SaltoDerecha;
    Animation<TextureRegion> SaltoIzquierda;
    Animation<TextureRegion> EspadazoDereAnimation;
    Animation<TextureRegion> EspadazoIzqAnimation;
    Animation<TextureRegion> mimidoAnimation;
    Animation<TextureRegion> EmpujarDerecha;
    Animation<TextureRegion> EmpujarIzquierda;
    Texture EmpujarD;
    Texture EmpujarI;
    Texture dormir;
    Texture EspadazoDerecho;
    Texture EspadazoIzquierdo;
    Texture SaltoDere,SaltoIzq,StaticDere1,StaticIzq;
    Texture Sword;
    Texture Sword2;
  boolean dormirtime;


    Sound espadazoSound;
    Sound sound;
    float gravity;
    int iteratorMusicWalk = 0;

    int c = 3, r = 4;//caminar dere
    int c2 = 3, r2 = 4;//caminar izq
    int c3 = 5, r3 = 4;
    int c4 = 5, r4 = 4;
    int c5 = 5, r5 = 1;
    int c6 = 5, r6 = 1;
    int c7 = 11, r7 = 1;
    int c8 = 11, r8 = 1;
    int c9 = 1,r9 = 5;
    int c10 = 2, r10 = 1;
    int c11 = 2, r11 = 1;
    int c12 = 1, r12 = 6;
    int c13 = 1, r13 = 6;
    int iterator;

    float time;
  public static float time1;
  public static float time3;
    float time4 = 0;
    float timeEspadazoEffect;
    float timeEspadazoEffect2;
    //
    public static boolean dereD,izqD;//se mandan a la clase parajo
    public static boolean derecha = true, izquierda;
   public static boolean saltar = true;
   public static boolean Movimiento = false;
   public static boolean desMov;
   public static boolean SpiderRight, SpiderLeft;
   public static boolean Espadazo = false;
    int jumpDouble = 0;
    float timeJump = 0;
    public static  boolean rightActive = false;
    public static  boolean leftActive = false;
    public static boolean SaltoUp = false;
    boolean active1 = false, active2 = false;
    boolean impulsoEspadaDere = false, impulsoEspadaIzq  = false;
    public static boolean SpeedButton;
    public static boolean AttackButton;

    public static boolean istouchTienda;
    public static boolean istouchTienda2;
    public static boolean istouchTienda3;
    public static boolean istouchTienda4;
Texture BotonA;

    private Vector2 velocidades;
    private float maxVelocidadY = 5.808105f;

    float time2 = 0;
    int density = 1;
    int vibrateiterator = 0;
    float velocidadY;
    float tempo;
    float tempoSalto;
    float tempoSalto2;
    float timeduration,timeduration2;
    float timeMuerte;
    public static float tempoLateral = 0;

    public static Rectangle jugador;
    //Particulas//
    ParticleEffect impulsoIzq;
    ParticleEffect particulaSalto;
    ParticleEffect particulaSalto2;
    boolean activarParticulas = false;
    boolean activarParticulas2 = false;
    public static boolean Muerto = false;
    Texture Kill;
    MyGdxGame game;
    AddActors add;
    public static boolean muerteimpulso = false;

 
/*********Probar**********/
boolean speedactive;
    float var1,var2,var3,var4;
    Texture negro;
    public static Rectangle espadaRec;

    ///////////////////////
    boolean teletrans = false;
    float Tx,Ty;
public static boolean isTouchPlataformaMov1;
public static boolean isTouchPlataformaMov2;
 public static boolean isCajaTouch = false;
    public static ArrayList<Rectangle> plataformaMovRectangles = new ArrayList<Rectangle>();


    /************MENU*************/
    public static boolean isMenu;
    Texture fondo;
    public static Sprite fondoMenu;
    Texture CostoMoneda;

ShaderProgram shader;
    ShaderProgram shader2;


    
    public Jugador(World world,Texture dere,Texture izq,Texture SaltoDere,Texture SaltoIzq,Texture StaticDere, Texture StaticIzq,Texture EspadazoDerecho,Texture EspadazoIzquierdo,Texture Kill,Texture dormir,Texture sword,Texture sword2,float x, float y)
    {
        this.world = world;
        this.dere = dere;
        this.izq = izq;
        this.SaltoDere= SaltoDere;
        this.SaltoIzq= SaltoIzq;
        this.StaticDere1= StaticDere;
        this.StaticIzq= StaticIzq;
        this.EspadazoDerecho = EspadazoDerecho;
        this.EspadazoIzquierdo = EspadazoIzquierdo;
        this.Kill = Kill;
        this.dormir = dormir;
        this.Sword = sword;
        this.Sword2 = sword2;
        shader = new ShaderProgram(Gdx.files.internal("Shaders/vertex.glsl"),Gdx.files.internal("Shaders/fragment.glsl"));
        shader2 = new ShaderProgram(Gdx.files.internal("Shaders/vertex2.glsl"),Gdx.files.internal("Shaders/fragment2.glsl"));

        negro = new Texture("White.png");

        def = new BodyDef();
        def.fixedRotation = true;
        def.position.set((x + 1f)/Pixels, (y - 1f)/Pixels);
        def.type = BodyDef.BodyType.DynamicBody;

        body = world.createBody(def);
        gravity = body.getGravityScale();
        PolygonShape box = new PolygonShape();
        box.setAsBox(3/Pixels,8/Pixels);//3,8

        fixture = body.createFixture(box,density);
        fixture.setFriction(1);
        fixture.setUserData("Jugador");
        box.dispose();
       // espadazo.dispose();
        setSize(25f/Pixels,25f/Pixels);

        impulsoIzq = new ParticleEffect();
        impulsoIzq.load(Gdx.files.internal("particles/correr.p"),Gdx.files.internal("images"));
        impulsoIzq.scaleEffect(.15f/Pixels);

        particulaSalto = new ParticleEffect();
        particulaSalto.load(Gdx.files.internal("particles/Salto.p"),Gdx.files.internal("images"));
        particulaSalto.scaleEffect(.2f/Pixels);
        particulaSalto2 = new ParticleEffect();
        particulaSalto2.load(Gdx.files.internal("particles/Salto.p"),Gdx.files.internal("images"));
        particulaSalto2.scaleEffect(.2f/Pixels);
        ////////////////Espadazo Effect////////////////
        TextureRegion[][] staticSwordI = TextureRegion.split(Sword2,Sword2.getWidth()/c13,Sword2.getHeight()/r13);
        TextureRegion[] tmpSwordI = new TextureRegion[c13*r13];
        int index0 = 0;
        for(int i=0; i < r13; i++)
        {
            for(int j =0; j < c13; j++)
            {
                tmpSwordI[index0++] = staticSwordI[i][j];
            }
        }
        EspadazoEffectI = new Animation<TextureRegion>(0.1f,tmpSwordI);

        ////////////////Espadazo Effect////////////////
        TextureRegion[][] staticSword = TextureRegion.split(Sword,Sword.getWidth()/c12,Sword.getHeight()/r12);
        TextureRegion[] tmpSword = new TextureRegion[c12*r12];
        int index = 0;
        for(int i=0; i < r12; i++)
        {
            for(int j =0; j < c12; j++)
            {
                tmpSword[index++] = staticSword[i][j];
            }
        }
        EspadazoEffect = new Animation<TextureRegion>(0.1f,tmpSword);

        ////////////////Estatico Derecha////////////////
        TextureRegion[][] StaticDerecha = TextureRegion.split(StaticDere,StaticDere.getWidth()/c3,StaticDere.getHeight()/r3);
        TextureRegion[] tmpStaticDerecha = new TextureRegion[c3 * r3];
        int index2 = 0;
        for(int i = 0; i < r3; i++)
        {
            for(int j = 0; j < c3; j++)
                tmpStaticDerecha[index2++] = StaticDerecha[i][j];
        }
         estaticoDerecha = new Animation<TextureRegion>(0.1f,tmpStaticDerecha);
        ///////////////////estatico Izquierda////////////////////
        TextureRegion[][] StaticIzquierda = TextureRegion.split(StaticIzq,StaticIzq.getWidth()/c4,StaticIzq.getHeight()/r4);
        TextureRegion[] tmpStaticIzquierda = new TextureRegion[c4 * r4];
        int index3 = 0;
        for(int i = 0; i < r4; i++)
        {
            for(int j = 0; j < c4; j++)
            {
                tmpStaticIzquierda[index3++] = StaticIzquierda[i][j];
            }
        }
        estaticoIzquierda = new Animation<TextureRegion>(0.1f,tmpStaticIzquierda);
        /////////////////Caminar derecha/////////////////
        TextureRegion[][] framesDerecha = TextureRegion.split(dere,dere.getWidth()/c,dere.getHeight()/r);
        TextureRegion[] tmpDerecha = new TextureRegion[c * r];
        int index11 = 0;
        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                tmpDerecha[index11++] = framesDerecha[i][j];
            }
        }

        caminarDerecha = new Animation<TextureRegion>(0.1f,tmpDerecha);
        /////////////////Caminar izquierda/////////////
        TextureRegion[][] framesIzquierda = TextureRegion.split(izq,izq.getWidth()/c2,izq.getHeight()/r2);
        TextureRegion[] tmpIzquierda = new TextureRegion[c2* r2];
        int index1 = 0;
        for(int i = 0; i < r2; i++)
        {
            for(int j = 0; j < c2; j++)
            {
                tmpIzquierda[index1++] = framesIzquierda[i][j];
            }
        }

        caminarIzq = new Animation<TextureRegion>(0.1f,tmpIzquierda);
        /////////////////Salto Derecha/////////////
        TextureRegion[][] FSD = TextureRegion.split(SaltoDere,SaltoDere.getWidth()/c5,SaltoDere.getHeight()/r5);
        TextureRegion[] TSD = new TextureRegion[c5* r5];

        int index4 = 0;
        for(int i = 0; i < r5; i++)
        {
            for(int j = 0; j < c5; j++)
            {
                TSD[index4++] = FSD[i][j];
            }
        }

        SaltoDerecha = new Animation<TextureRegion>(0.03f,TSD);
        /////////////////Salto Izquierda/////////////
        TextureRegion[][] FSL = TextureRegion.split(SaltoIzq,SaltoIzq.getWidth()/c6,SaltoIzq.getHeight()/r6);
        TextureRegion[] TSL = new TextureRegion[c6* r6];

        int index5 = 0;
        for(int i = 0; i < r6; i++)
        {
            for(int j = 0; j < c6; j++)
            {
                TSL[index5++] = FSL[i][j];
            }
        }

        SaltoIzquierda = new Animation<TextureRegion>(0.03f,TSL);
        ///////////////EspadazoDerecho/////////////////////////
        TextureRegion[][] tmpEspadazoDere= TextureRegion.split(EspadazoDerecho,EspadazoDerecho.getWidth()/c7,EspadazoDerecho.getHeight()/r7);
        TextureRegion[] FramesEspadazoDere = new TextureRegion[c7 * r7];
        int index6 = 0;
        for(int i = 0; i  < r7; i++)
        {
            for(int j = 0; j < c7; j++)
            {
                FramesEspadazoDere[index6++] = tmpEspadazoDere[i][j];
            }
        }
        EspadazoDereAnimation = new Animation<TextureRegion>(0.05f,FramesEspadazoDere);

    ///////////////EspadazoIzquierdo/////////////////////////
    TextureRegion[][] tmpEspadazoIzq= TextureRegion.split(EspadazoIzquierdo,EspadazoIzquierdo.getWidth()/c8,EspadazoIzquierdo.getHeight()/r8);
    TextureRegion[] FramesEspadazoIzquierdo = new TextureRegion[c8 * r8];
    int index7 = 0;
        for(int i = 0; i  < r8 ; i++)
    {
        for(int j = 0; j < c8; j++)
        {
            FramesEspadazoIzquierdo[index7++] = tmpEspadazoIzq[i][j];
        }
    }
    EspadazoIzqAnimation = new Animation<TextureRegion>(0.05f,FramesEspadazoIzquierdo);
///////////////Dormir/////////////////////////
        TextureRegion[][] tmpDormir= TextureRegion.split(dormir,dormir.getWidth()/c9,dormir.getHeight()/r9);
        TextureRegion[] FramesDormir = new TextureRegion[c9 * r9];
        int index8 = 0;
        for(int i = 0; i  < r9 ; i++)
        {
            for(int j = 0; j < c9; j++)
            {
                FramesDormir[index8++] = tmpDormir[i][j];
            }
        }
        mimidoAnimation = new Animation<TextureRegion>(0.2f,FramesDormir);
        //////////////////////////////////////
        ////////////EmpujarD///////////
        EmpujarD = new Texture("EmpujarR.png");
        TextureRegion[][] framesER = TextureRegion.split(EmpujarD,EmpujarD.getWidth()/c10,EmpujarD.getHeight()/r10);
        TextureRegion[] tmpER = new TextureRegion[c10 * r10];
        int index9 = 0;
        for(int i = 0; i < r10; i++)
        {
            for(int j = 0; j < c10; j++)
            {
                tmpER[index9++]= framesER[i][j];
            }
        }
        EmpujarDerecha = new Animation<TextureRegion>(0.5f,tmpER);
        ///////////////////////////////
        ////////////EmpujarL///////////
        EmpujarI = new Texture("EmpujarL.png");
        TextureRegion[][] framesEL = TextureRegion.split(EmpujarI,EmpujarI.getWidth()/c11,EmpujarI.getHeight()/r11);
        TextureRegion[] tmpEL = new TextureRegion[c11* r11];
        int index10 = 0;
        for(int i = 0; i < r11; i++)
        {
            for(int j = 0; j < c11; j++)
            {
                tmpEL[index10++]= framesEL[i][j];
            }
        }
        EmpujarIzquierda = new Animation<TextureRegion>(0.5f,tmpEL);
        ///////////////////////////////

        ////SONIDOS////
        espadazoSound = Gdx.audio.newSound(Gdx.files.internal("EspadazoSong.mp3"));
        jugador = new Rectangle();
        sound = Gdx.audio.newSound(Gdx.files.internal("muerte.mp3"));
        espadaRec = new Rectangle();

/***************************************************************/
BotonA = new Texture("A.png");

/***********Menu***************/
        fondo = new Texture("PantallaNegro.png");
        fondoMenu = new Sprite(fondo);
        CostoMoneda = new Texture("9Fertilizante.png");
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        impulsoIzq.update(tempo);
        tempo = Gdx.graphics.getDeltaTime();
        setPosition(body.getPosition().x-(10.5f)/Pixels,body.getPosition().y-(8)/Pixels);
      
        TextureRegion StaticDere = estaticoDerecha.getKeyFrame(time,true);
        TextureRegion StaticIzq = estaticoIzquierda.getKeyFrame(time,true);
        TextureRegion dere = caminarDerecha.getKeyFrame(time,true);
        TextureRegion izq = caminarIzq.getKeyFrame(time,true);
        TextureRegion SaltoDere = SaltoDerecha.getKeyFrame(time2,false);
        TextureRegion SaltoIzq = SaltoIzquierda.getKeyFrame(time2,false);

        TextureRegion EspadaIzquierda= EspadazoIzqAnimation.getKeyFrame(time4,true);
        TextureRegion Dormir = mimidoAnimation.getKeyFrame(time,true);
        TextureRegion EmpujarDere = EmpujarDerecha.getKeyFrame(time,true);
        TextureRegion EmpujarIzq = EmpujarIzquierda.getKeyFrame(time,true);

        if(saltar)
        {
            if(SaltoDerecha.isAnimationFinished(time2))
            {
                time2 = 0;
            }
            if(SaltoIzquierda.isAnimationFinished(time2))
            {
                time2 = 0;
            }
        }

////////////////////////////Dibujar///////////////////////////////////
       // batch.draw(negro,espadaRec.x,espadaRec.y,espadaRec.width,espadaRec.height);
       /* if(Espadazo) {
            batch.setShader(shader);
        }else
        {
            batch.setShader(shader2);
        }*/
        if(MyGdxGame.Cinematica.getInteger("Cinematica") == 1) {
            if (!Muerto) {


                if(istouchTienda)
                {
                    batch.draw(BotonA, getX()+.5f, getY()+1, getWidth()*.5f, getHeight()*.5f);
                }
                /******************************************************/
                if(istouchTienda2)
                {
                    batch.draw(BotonA, getX()+.5f, getY()+1, getWidth()*.5f, getHeight()*.5f);
                    batch.draw(CostoMoneda, getX()+1f, getY()+1, getWidth()*.8f, getHeight()*.5f);
                }
                if(istouchTienda3)
                {
                    batch.draw(BotonA, getX()+.5f, getY()+1, getWidth()*.5f, getHeight()*.5f);
                    batch.draw(CostoMoneda, getX()+1f, getY()+1, getWidth()*.8f, getHeight()*.5f);
                }
                /******************************************************/
                if(istouchTienda4)
                {
                    batch.draw(BotonA, getX()+.5f, getY()+1, getWidth()*.5f, getHeight()*.5f);
                    batch.draw(CostoMoneda, getX()+1f, getY()+1, getWidth()*.8f, getHeight()*.5f);
                }


                if (!Espadazo) { /***/
                    if (saltar) {
                        if (Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT) || rightActive) {

                            if (Gdx.input.isKeyPressed(Input.Keys.DPAD_UP) || Gdx.input.isKeyPressed(Input.Keys.BUTTON_A) || SaltoUp) {
                                if (derecha) {
                                    batch.draw(SaltoDere, getX(), getY(), getWidth(), getHeight());

                                } else if (izquierda) {
                                    batch.draw(SaltoIzq, getX(), getY(), getWidth(), getHeight());

                                }
                            } else {
                                if(!isCajaTouch) {

                                        batch.draw(dere, getX(), getY(), getWidth()+.08f, getHeight()+.08f);

                                }else
                                {
                                 //   Walk.stop();
                                    if (Gdx.input.isKeyPressed(Input.Keys.BUTTON_R2) ||  SpeedButton) {
                                        Cajas.maxV = 2;
                                    }else
                                    {
                                        Cajas.maxV = 0.5f;
                                    }
                                    /*************************/
                                    /*************************/   /*************************/
                                    /*************************/
                                    /*************************/
                                    /*************************/
                                    /*************************/
                                    /*************************/
                                    batch.draw(EmpujarDere, getX(), getY(), getWidth(), getHeight());
                                }
                            }
                        } else if (Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT) || leftActive) {

                            if (Gdx.input.isKeyPressed(Input.Keys.DPAD_UP) || Gdx.input.isKeyPressed(Input.Keys.BUTTON_A) || SaltoUp) {
                                if (derecha) {
                                    time2 += Gdx.graphics.getDeltaTime();
                                    batch.draw(SaltoDere, getX(), getY(), getWidth(), getHeight());
                                } else if (izquierda) {
                                    time2 += Gdx.graphics.getDeltaTime();
                                    batch.draw(SaltoIzq, getX(), getY(), getWidth(), getHeight());

                                }
                            } else {
                                if(!isCajaTouch) {
                                    batch.draw(izq, getX(), getY(),getWidth()+.08f, getHeight()+.08f);

                                }else
                                {
                                    if (Gdx.input.isKeyPressed(Input.Keys.BUTTON_R2) ||  SpeedButton) {
                                        Cajas.minV = -2;
                                    }else
                                    {
                                        Cajas.minV = -0.5f;
                                    }
                                    batch.draw(EmpujarIzq, getX(), getY(), getWidth(), getHeight());
                                }
                            }
                        } else {
                            if (!saltar) {
                                if (derecha) {
                                    time2 += Gdx.graphics.getDeltaTime();
                                    batch.draw(SaltoDere, getX(), getY(), getWidth(), getHeight());
                                } else if (izquierda) {
                                    time2 += Gdx.graphics.getDeltaTime();
                                    batch.draw(SaltoIzq, getX(), getY(), getWidth(), getHeight());
                                }
                            } else {
                                if (derecha) {
                                    batch.draw(StaticDere, getX(), getY(), getWidth(), getHeight());

                                } else if (izquierda) {
                                    batch.draw(StaticIzq, getX(), getY(), getWidth(), getHeight());

                                }
                            }
                        }

                    } else {

                        if (!saltar) {
                            if (derecha) {
                                time2 += Gdx.graphics.getDeltaTime();
                                batch.draw(SaltoDere, getX(), getY(), getWidth(), getHeight());
                            } else if (izquierda) {
                                time2 += Gdx.graphics.getDeltaTime();
                                batch.draw(SaltoIzq, getX(), getY(), getWidth(), getHeight());
                            }
                        }
                    }
                    if (time1 > 3) {
                        if (Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT) && Gdx.input.isKeyPressed(Input.Keys.BUTTON_R2) || leftActive && Gdx.input.isKeyPressed(Input.Keys.BUTTON_R2) || leftActive && SpeedButton) {
                            impulsoIzq.setFlip(false, false);

                            // tempo = Gdx.graphics.getDeltaTime();
                            Gdx.input.vibrate(100);
                            impulsoIzq.setPosition(getX() + .6f, getY() + .1f);
                            impulsoIzq.draw(batch, tempo);
                        } else if (Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT) && Gdx.input.isKeyPressed(Input.Keys.BUTTON_R2) || rightActive && Gdx.input.isKeyPressed(Input.Keys.BUTTON_R2) || rightActive && SpeedButton) {
                            impulsoIzq.setFlip(true, false);

                            //tempo = Gdx.graphics.getDeltaTime();
                            Gdx.input.vibrate(100);
                            impulsoIzq.setPosition(getX() + .1f, getY() + .1f);
                            impulsoIzq.draw(batch, tempo);
                        }
                    } else {
                    }
                } else /***/ //espadazo
                {

                    if (derecha) {
                        impulsoEspadaDere = true;
                        if (iterator == 1) {
                            espadazoSound.play(0.5f);
                        }
                        iterator++;
                        TextureRegion EspadaDerecha = EspadazoDereAnimation.getKeyFrame(time4,true);
                        TextureRegion current = EspadazoEffect.getKeyFrame(timeEspadazoEffect,false);
                        timeEspadazoEffect += Gdx.graphics.getDeltaTime();
                        batch.draw(EspadaDerecha, getX(), getY(), getWidth(), getHeight());
                        batch.draw(current, getX()-(60/Pixels), getY(), getWidth()+(64/Pixels), getHeight());

                        if (EspadazoDereAnimation.isAnimationFinished(time4)&&EspadazoEffect.isAnimationFinished(timeEspadazoEffect)) {

                            iterator = 0;
                            time4 = 0;
                            timeEspadazoEffect = 0;
                            impulsoEspadaDere = false;
                            Espadazo = false;

                        }
                    }
                    if (izquierda) {
                        impulsoEspadaIzq = true;
                        if (iterator == 1) {

                            espadazoSound.play(0.5f);
                        }
                        iterator++;
                        TextureRegion current = EspadazoEffectI.getKeyFrame(timeEspadazoEffect2,false);
                        timeEspadazoEffect2 += Gdx.graphics.getDeltaTime();
                        batch.draw(EspadaIzquierda, getX(), getY(), getWidth(), getHeight());
                        batch.draw(current, getX()-(4.5f/Pixels), getY(), getWidth()+(64/Pixels), getHeight());
                        if (EspadazoIzqAnimation.isAnimationFinished(time4)) {
                            iterator = 0;
                            time4 = 0;
                            timeEspadazoEffect2 = 0;
                            impulsoEspadaIzq = false;
                            Espadazo = false;
                        }
                    }

                }
            } else {
                batch.draw(Kill, getX(), getY(), getWidth(), getHeight());
            }
            //   batch.draw(negro,var1,var2,var3,var4);
        }else
        {
            if(Casa.alpha == 0) {
                dormirtime = true;
            }else
            {
                dormirtime = false;
            }
            batch.draw(Dormir, getX(), getY(), getWidth(), getHeight());
            if(dormirtime)
            {
                MyGdxGame.Cinematica.putInteger("Cinematica",1);
                MyGdxGame.Cinematica.flush();
            }else
            {
                MyGdxGame.Cinematica.putInteger("Cinematica",0);
                MyGdxGame.Cinematica.flush();
            }
        }

//////////////////////////////////////////Acabar de dibujar////////////////////////////////////

        if(tempoSalto != 0) {
            particulaSalto.draw(batch, tempoSalto);
        }else
        {
            particulaSalto.reset();
            particulaSalto.scaleEffect(.2f/Pixels);

        }

        if(tempoSalto2 != 0) {
            particulaSalto2.draw(batch, tempoSalto2);
        }else
        {
            particulaSalto2.reset();
            particulaSalto2.scaleEffect(.2f/Pixels);
        }
/***********************************menu*****************************************************/

        if(Jugador.istouchTienda  && SaltoUp)
        {
            isMenu = true;
        }
        /**********************************************************************************/
 //      batch.draw(negro,var1,var2,var3,var4);
    }

    @Override
    public void act(float delta) {

        AddResources.CamaraY = false;
        if(teletrans)
        {
            InteractiveTilePortal.wait = 0;
          //  InteractiveTilePortal.iterator2 = 0;
            body.setTransform(Tx/Pixels,Ty/Pixels,0);
            teletrans = false;
        }

        dereD = derecha;
        izqD = izquierda;

        /*********Probar rectangle**************/
        var1 = body.getPosition().x-(10f)/Pixels;
        var2 = body.getPosition().y-(1.5f)/Pixels;
        var3 = 20/Pixels;
        var4 = 10/Pixels;
        espadaRec.set(var1,var2,var3,var4);

        jugador.set((getX()+(getWidth()/4))-(1/Pixels),getY(),(getWidth()/2)+(1/Pixels),getHeight());
        /**************************************/
        /////////////////detecta movimiento//////////////

if(!Muerto) {

    if (Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT) || rightActive || Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT) || leftActive || Gdx.input.isKeyPressed(Input.Keys.DPAD_UP) || Gdx.input.isKeyPressed(Input.Keys.BUTTON_A) || SaltoUp || SpeedButton || AttackButton) {
        Movimiento = true;
        vibrateiterator++;
        if (vibrateiterator == 1) {
            Gdx.input.vibrate(50);
        }

    } else {
        vibrateiterator = 0;
        Movimiento = false;
    }
    time4 += Gdx.graphics.getDeltaTime();

    particulaSalto.update(delta);
    particulaSalto2.update(delta);


    if(!istouchTienda2&&!istouchTienda&&!istouchTienda3&&!istouchTienda4) {
        if (saltar) {
            if (Gdx.input.isKeyPressed(Input.Keys.BUTTON_A) || SaltoUp) {
                particulaSalto.setPosition(getX() + .4f, getY() + .08f);
                activarParticulas = true;
            }
        }
        if (!saltar) {
            if (Gdx.input.isKeyPressed(Input.Keys.BUTTON_A) || SaltoUp) {
                if (timeJump < .65f) {
                    if (jumpDouble == 1) {
                        particulaSalto2.setPosition(getX() + .4f, getY() + .08f);
                        activarParticulas2 = true;
                    }
                }
            }
        }
    }

    if (timeduration < .3f) {
        tempoSalto = Gdx.graphics.getDeltaTime();
    } else {
        tempoSalto = 0;
    }

    if (timeduration2 < .3f) {
        tempoSalto2 = Gdx.graphics.getDeltaTime();
    } else {
        tempoSalto2 = 0;
    }

    velocidadY = body.getLinearVelocity().y;
    ////////////////////////////////////////
    time += Gdx.graphics.getDeltaTime();
    time1 += 1 * Gdx.graphics.getDeltaTime();
    timeduration += 1f * Gdx.graphics.getDeltaTime();
    timeduration2  += 1f * Gdx.graphics.getDeltaTime();
    if (activarParticulas) {
        timeduration = 0;
        activarParticulas = false;
    }
    if (activarParticulas2) {
        timeduration2 = 0;
        activarParticulas2 = false;
    }

////////////////Mecanicas///////////////////////////////////////
    ////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////
    /*********************************************/

    if (!Espadazo) {
        if (!SpiderRight && !SpiderLeft) {
            if (Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT) || rightActive) {
                derecha = true;
                izquierda = false;
                body.setLinearVelocity(2.8f, velocidadY);//2.5

            } else if (Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT) || leftActive) {
                derecha = false;
                izquierda = true;
                body.setLinearVelocity(-2.8f, velocidadY);//2.5

            } else {
if(!isTouchPlataformaMov1&&!isTouchPlataformaMov2) {
        body.setLinearVelocity(0f, velocidadY);
}
            }
            if(!istouchTienda2&&!istouchTienda&&!istouchTienda3&&!istouchTienda4) {
                if (saltar)
                    if (Gdx.input.isKeyPressed(Input.Keys.DPAD_UP) || Gdx.input.isKeyPressed(Input.Keys.BUTTON_A) || SaltoUp) {// && body.getLinearVelocity().y == 0
                        Vector2 position = body.getPosition();
                        body.applyLinearImpulse(0, .80f/*65*/, position.x, position.y, true);
                        jumpDouble = 0;
                        timeJump = 0;
                        saltar = false;
                    }
                if (!saltar) {
                    timeJump += 1 * Gdx.graphics.getDeltaTime();
                    if (Gdx.input.isKeyPressed(Input.Keys.DPAD_UP) || Gdx.input.isKeyPressed(Input.Keys.BUTTON_A) || SaltoUp) {// && body.getLinearVelocity().y == 0
                        Vector2 position = body.getPosition();
                        if (timeJump > .5f) {
                            if (jumpDouble == 0) {
                          //      Gdx.app.log("JumpDouble", "Salto Aire");
                                body.applyLinearImpulse(0, 5.80f/*65*/, position.x, position.y, true);
                                jumpDouble++;
                          //      Gdx.app.log("JumpDouble", " " + jumpDouble);
                            }
                        }

                    }
                }
            }
            ////////////////Impulso//////////
            /////////////////////////////////////////
            /////////////////////////////////////////
            boolean impuls = false;

            if (time1 > 3) {
                if (Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT) && Gdx.input.isKeyPressed(Input.Keys.BUTTON_R2) || rightActive && Gdx.input.isKeyPressed(Input.Keys.BUTTON_R2) || rightActive && SpeedButton) {
                    derecha = true;
                    izquierda = false;
                    impuls = true;
                    speedactive = true;
                    body.setLinearVelocity(body.getLinearVelocity().x+3, body.getLinearVelocity().y);

                } else if (Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT) && Gdx.input.isKeyPressed(Input.Keys.BUTTON_R2) || leftActive && Gdx.input.isKeyPressed(Input.Keys.BUTTON_R2) || leftActive && SpeedButton) {

                    derecha = false;
                    izquierda = true;
                    impuls = true;
                    speedactive = true;
                    body.setLinearVelocity(body.getLinearVelocity().x-3, body.getLinearVelocity().y);

                }
                else
                {
                    speedactive = false;
                }
            }else {
                speedactive = false;
            }

            if (impuls) {
                time3 += 1 * Gdx.graphics.getDeltaTime();
                if (time3 >= 1) {
                    time1 = 0;
                    time3 = 0;
                }
            }
            /*****/
        } else {

            if (SpiderRight) {
                //  SpiderLeft = false;
                //Gdx.app.log("Activado", "Derecho");
                //if (Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT) || rightActive||Gdx.input.isKeyJustPressed(Input.Keys.DPAD_RIGHT)  ) {
                derecha = false;
                izquierda = true;
                if (Gdx.input.isKeyPressed(Input.Keys.DPAD_UP) || Gdx.input.isKeyPressed(Input.Keys.BUTTON_A) || SaltoUp || Gdx.input.isKeyJustPressed(Input.Keys.BUTTON_A)) {
                    active2 = true;
                }
                // }
            }

            if (SpiderLeft) {
                // SpiderRight = false;
              //  Gdx.app.log("Activado", "Izquierdo");
                //     if (Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT) || leftActive || Gdx.input.isKeyJustPressed(Input.Keys.DPAD_LEFT)) {
                derecha = true;
                izquierda = false;
                if (Gdx.input.isKeyPressed(Input.Keys.DPAD_UP) || Gdx.input.isKeyPressed(Input.Keys.BUTTON_A) || SaltoUp || Gdx.input.isKeyJustPressed(Input.Keys.BUTTON_A)) {
                    active1 = true;
                }
                //  }
            }


            /**********************************************/
        }

        /********************************************
         *******************************************
         ********************************************/
        //  Vector2 velocidad = body.getLinearVelocity();
        if (active1) {
            Vector2 position = body.getPosition();

            tempoLateral += 1 * Gdx.graphics.getDeltaTime();
            if (tempoLateral <= .13f) {//.17f
                body.applyLinearImpulse(.20f, .40f, position.x, position.y, true);
            } else {
                //  body.setLinearVelocity(velocidad);
                active1 = false;
                tempoLateral = 0;
                SpiderLeft = false;
            }
        }
        if (active2) {
            Vector2 position = body.getPosition();
            tempoLateral += 1 * Gdx.graphics.getDeltaTime();
            if (tempoLateral <= .13f) {//.17f
                body.applyLinearImpulse(-.20f, .40f, position.x, position.y, true);
            } else {
                // body.setLinearVelocity(velocidad);
                active2 = false;
                tempoLateral = 0;
                SpiderRight = false;
            }
        }

        /********************************************
         *******************************************
         ********************************************/
        /////////////////////////////////////////
        /////////////////////////////////////////
    }
    if (!Espadazo&& time1 >= 3) {
        if (Gdx.input.isKeyPressed(Input.Keys.BUTTON_B) || AttackButton) {
                body.setLinearVelocity(0,body.getLinearVelocity().y);
            Espadazo = true;

        }
    }
    ///////////ESTABLECE VELOCIDAD Y MAXIMA
    velocidades = body.getLinearVelocity();
    if (velocidadY > 5.808105f || velocidades.y > 5.808105) {
        Gdx.input.vibrate(100);
        body.setLinearVelocity(velocidades.x, maxVelocidadY);
    }
    if (velocidadY < -5.808105f || velocidades.y < - 5.808105) {
        Gdx.input.vibrate(100);
        body.setLinearVelocity(velocidades.x, maxVelocidadY*-1);
    }
    for(Rectangle r : InteractivePlataformaMov.r) {
        if (velocidades.y < -0.5f && !r.overlaps(Jugador.jugador)) {
            saltar = false;
        } else if (isTouchPlataformaMov1 || isTouchPlataformaMov2) {
            saltar = true;
            SaltoUp = false;
        }
    }
    if(!Espadazo) {
        body.setGravityScale(gravity);
        if (speedactive) {
           // Gdx.app.log("Velocidad", "" + Jugador.body.getLinearVelocity().x);
            if (body.getLinearVelocity().x > 5f) {//3.8
                body.setLinearVelocity(5f, body.getLinearVelocity().y);
            }
            if (body.getLinearVelocity().x < -5f) {
                body.setLinearVelocity(-5f, body.getLinearVelocity().y);
            }
        } else {
            if (body.getLinearVelocity().x > 2.8f) {
                body.setLinearVelocity(2.8f, body.getLinearVelocity().y);
            }
            if (body.getLinearVelocity().x < -2.8f) {
                body.setLinearVelocity(-2.8f, body.getLinearVelocity().y);
            }
        }
    }else
    {
        body.setGravityScale(gravity-.5f);
     /*   if(impulsoEspadaDere)
        {

        }
        if(impulsoEspadaIzq)
        {

        }*/
    }


    //////////////////////
    try {
        if (jugador.overlaps(Button1.rect)) {
            Gdx.input.vibrate(100);
        }
    } catch (Exception e) {
    }

}else {
/****************************MUERTE**************/
/******************************************/
/*************************************/
/********************************/
/****************************/
/************************/
/******************/
//    MyGdxGame.ApagarMusica = true;

    InteractiveTileObjectEnemies.stop = true;
    timeMuerte = timeMuerte + 1 * Gdx.graphics.getDeltaTime();
    Vector2 position = body.getPosition();
    fixture.setSensor(true);
    if (timeMuerte < 1f) {
        AddResources.isScreenUp = true;
        if (!muerteimpulso) {
            sound.play();
            if (izquierda) {
                //  body.setLinearVelocity(1f, 1f);
                body.applyLinearImpulse(.1f, .65f, position.x, position.y, true);
            } else if (derecha) {
                body.applyLinearImpulse(-.1f, .65f, position.x, position.y, true);
            }
            muerteimpulso = true;
        }
    } else if (AddResources.isScreenUp == false) {
        AddActors.button.activeCaja = false;
        AddActors.button2.isTouch2 = false;

        muerteimpulso = false;
        Muerto = false;
        add.i = 0;
        try {

            switch (AddResourcesOfMenu.SelectLevel) {
                case 1: {
                    add.game.setScreen(new Nivel0(add.game));
                    break;
                }
                case 2: {
                    add.game.setScreen(new Nivel1(add.game));
                    break;
                }
                case 3: {
                    add.game.setScreen(new Nivel2(add.game));
                    break;
                }
                case 4: {
                    add.game.setScreen(new Nivel5(add.game));
                    break;
                }
                case 5: {
                    add.game.setScreen(new Nivel6(add.game));
                    break;
                }
                case 6:
                {
                    add.game.setScreen(new Nivel7(add.game));
                    break;
                }
                default:
                {
                    add.game.setScreen(new Nivel1Progresion(add.game));
                }
            }


        } catch (Exception e) {
            //   Gdx.app.log("ERROR", "Mensaje:" + e.getMessage());
        }
        ;
    }
/******************/
/************************/
/***************************/
/*******************************/
/*************************************/
/******************************************/
/****************************MUERTE**************/

}
    }

    public void setDesMov(boolean desMov)
    {
        this.desMov = desMov;
    }
    public void setSaltar(boolean saltar) {
        this.saltar = saltar;
    }
    public void setRightActive(boolean rightActive)
    {
        this.rightActive = rightActive;
    }
    public void setLeftActive(boolean leftActive)
    {
        this.leftActive = leftActive;
    }
    public void setSaltoUp(boolean SaltoUp)
    {
        this.SaltoUp = SaltoUp;
    }
    public void setSpiderRight(boolean SpiderRight)
    {
        this.SpiderRight = SpiderRight;
    }
    public void setSpiderLeft(boolean SpiderLeft)
    {
        this.SpiderLeft = SpiderLeft;
    }

    public void setTelePosition(float positionx, float positiony,boolean active)
    {
        Tx = positionx;
        Ty = positiony;
        teletrans = active;
    }
    public void callar()
    {
        InteractiveTileObjectEnemies.stop = true;
        Fuego.sound.setLooping(false);

        Fuego.sound.stop();
    }


    public void setSpeedButton(boolean SpeedButton) {
        this.SpeedButton = SpeedButton;
    }
    public void setAttackButton(boolean AttackButton)
    {
        this.AttackButton = AttackButton;
    }

    public void detach()
    {
        fondo.dispose();
        BotonA.dispose();
        EmpujarD.dispose();
        EmpujarI.dispose();
        negro.dispose();
        sound.dispose();
        Kill.dispose();
        espadazoSound.dispose();
        particulaSalto.dispose();
        particulaSalto2.dispose();
        impulsoIzq.dispose();
        SaltoDere.dispose();
        SaltoIzq.dispose();
        StaticDere1.dispose();
        StaticIzq.dispose();
        body.destroyFixture(fixture);
        world.destroyBody(body);
        shader.dispose();
        shader2.dispose();
        CostoMoneda.dispose();
    }


}
