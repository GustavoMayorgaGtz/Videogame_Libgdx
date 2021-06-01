package Cinematicas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Menu;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.tiled.WorldContactListener;

import javax.xml.soap.Text;

import box2dLight.RayHandler;
import static com.mygdx.game.MyGdxGame.Pixels;

public class AddResourcesCinematica1 {

    public static SpriteBatch batch;
    public static OrthographicCamera cam;
    public static Stage stage;
    public static World world;
    private Box2DDebugRenderer render;
    TiledMap map;
    private RayHandler ray;
    private Viewport viewport;
    public static MyGdxGame game;
    public static float camX = 3.5555568f,camY = 54.3f;
    float timeOficial = 0,time,time1,time2,time3,time4,time5,time6,time7,time8,time9;
/*******Load Cinematicas********/
boolean iswake = false;
    Texture arbol,casa,dormir,staticd,walk,viento,trampa,caida,woman,womanpoint,statici,pensamiento;
    Animation<TextureRegion> Aarbol,Acasa,Adormir,Astatic,Awalk,Aviento,ATrampa,Awoman,Astatici;
    int c = 1, r = 5; //arbol
    int c1 = 1, r1 = 3;//casa
    int c2 = 1, r2 = 32;//mimir
    int c3 = 5, r3 = 4;//static
    int c4 = 3 ,r4 = 2;//walk
    int c5 = 1, r5 = 6;//viento
    int c6 = 1 , r6 = 5;//Trampa
    int c7 = 1, r7 = 4;//woman
    int c8 = 5,r8 = 4;//staticLeft
/*******************************/
/*************Pantalla De Nombre(Bienvenida)*******************/
Sprite Ikuno;
Texture ikunotexture;
float alpha = 1;
    float tiempoScreen = 0;
/**********************************/
/**************Posiciones**************/
float PersonajeSize = 35;
float womanX,womanY;
float Tx,Ty;
float casaX= 0,casaY= 0;
float personajeX= 0,personajeY= 0;
float arbolX,arbolY;
float vientoX,vientoY;
/*********************************/
/*****Musica*********/
Music music;
/*********************/
/*********Nubes ************/
Texture nube1, nube2;
Sprite snube1, snube2;
float nube1X,nube2X;
float nube1Y,nube2Y;
    float velocidad = 0;
/***************************/
Texture negro;
int iterator = 0;
boolean Pantalla38 = false;
boolean pn;
boolean parar = false;
Sprite n;
float alpha2 = 0;
float tiempoCaida = 0;
boolean womanllego;
boolean girarPersonajeIzq;
/**********Simbolos***************/
Texture ts1,ts2,ts3,ts4,ts5;
Sprite s1,s2,s3,s4,s5;
float w1,w2,w3,w4,w5;
float rotacion;

    public AddResourcesCinematica1(MyGdxGame game , TiledMap map) {
        this.map = map;
        this.game = game;
        batch = new SpriteBatch();
        cam = new OrthographicCamera();
        viewport = new FitViewport(300 / Pixels, 150 / Pixels, cam);//240,140
        stage = new Stage(viewport, batch);//65
        world = new World(new Vector2(0, -12), true);
        world.setContactListener(new WorldContactListener());
        render = new Box2DDebugRenderer();
        ray = new RayHandler(world);
        ray.setAmbientLight(1f);

        music = Gdx.audio.newMusic(Gdx.files.internal("prueba.mp3"));
        music.play();

        negro = new Texture("PantallaNegro.png");
        caida = new Texture("caida.png");
        pensamiento = new Texture("Pensamiento.png");
        n = new Sprite(negro);

        ts1 = new Texture("Simbolo1.png");
        s1 = new Sprite(ts1);
        ts2 = new Texture("Simbolo2.png");
        s2 = new Sprite(ts2);
        ts3 = new Texture("Simbolo3.png");
        s3 = new Sprite(ts3);
        ts4 = new Texture("Simbolo4.png");
        s4 = new Sprite(ts4);
        ts5 = new Texture("Simbolo5.png");
        s5 = new Sprite(ts5);

        womanpoint = new Texture("womanpoint.png");
/**********************CARGAR ANIMACIONES*******************/
                     /*****ARBOL******/
                     arbol = new Texture("ArbolViento.png");
                     TextureRegion[][]TmpArbol = TextureRegion.split(arbol,arbol.getWidth()/c,arbol.getHeight()/r);
                     TextureRegion[] FramesArbol = new TextureRegion[ c * r];
                     int index = 0;
                     for(int i = 0; i < r; i++)
                     {
                         for(int j = 0; j < c; j++)
                         {
                             FramesArbol[index++] = TmpArbol[i][j];
                         }
                     }
                     Aarbol = new Animation<TextureRegion>(0.2f,FramesArbol);
                     /****************/
                     /*****CASA*******/
                     casa = new Texture("Casita.png");
                     TextureRegion[][] TmpCasa = TextureRegion.split(casa, casa.getWidth()/c1, casa.getHeight()/r1);
                     TextureRegion[] FramesCasa = new TextureRegion[c1 * r1];
                     int index1 = 0;
                     for(int i = 0; i < r1; i++)
                     {
                         for(int j = 0; j < c1; j++)
                         {
                             FramesCasa[index1++] = TmpCasa[i][j];
                         }
                     }
                     Acasa = new Animation<TextureRegion>(0.8f, FramesCasa);
                     /****************/
                     /*****DORMIR*******/
                     dormir = new Texture("mimido.png");
                     TextureRegion[][] TmpDormir = TextureRegion.split(dormir,dormir.getWidth()/c2, dormir.getHeight()/r2);
                     TextureRegion[] FramesDormir = new TextureRegion[c2 * r2];
                     int index2 = 0;
                     for(int i = 0; i < r2; i++)
                     {
                         for(int j = 0; j < c2; j++)
                         {
                             FramesDormir[index2++] = TmpDormir[i][j];
                         }
                     }
                     Adormir = new Animation<TextureRegion>(0.2f,FramesDormir);
                     /****************/
                     /*****PERSONAJE ESTATICO*******/
                     staticd = new Texture("PSD.png");
                     TextureRegion[][]Tmpstaticd = TextureRegion.split(staticd, staticd.getWidth()/c3, staticd.getHeight()/r3);
                     TextureRegion[]Framesstaticd = new TextureRegion[c3 * r3];
                     int index3 = 0;
                     for(int i = 0; i < r3; i++)
                     {
                         for(int j = 0; j < c3; j++)
                         {
                             Framesstaticd[index3++] = Tmpstaticd[i][j];
                         }
                     }
                     Astatic = new Animation<TextureRegion>(0.2f,Framesstaticd);
                     /****************/
                     /*****PERSONAJE WALK*******/
                     walk = new Texture("WalkRight.png");
                     TextureRegion[][] framesDerecha = TextureRegion.split(walk,walk.getWidth()/c4,walk.getHeight()/r4);
                     TextureRegion[] tmpDerecha = new TextureRegion[c4* r4];
                     int index4 = 0;
                     for(int i = 0; i < r4; i++)
                     {
                       for(int j = 0; j < c4; j++)
                       {
                          tmpDerecha[index4++] = framesDerecha[i][j];
                       }
                     }

                     Awalk = new Animation<TextureRegion>(0.1f,tmpDerecha);
                     /****************/
                     /*****PERSONAJE WALK*******/
                     viento = new Texture("viento2.png");
                     TextureRegion[][] TmpViento = TextureRegion.split(viento,viento.getWidth()/c5, viento.getHeight()/r5);
                     TextureRegion[] FramesViento = new TextureRegion[c5 * r5];
                     int index5 = 0;
                     for(int i = 0; i < r5; i++)
                     {
                         for(int j = 0; j < c5; j++)
                         {
                             FramesViento[index5++] = TmpViento[i][j];
                         }
                     }
                     Aviento = new Animation<TextureRegion>(0.2f,FramesViento);
                     /********************************************/
                     /*****TRAMPA*******/
                     trampa = new Texture("trampa.png");
                     TextureRegion[][] TmpTrampa = TextureRegion.split(trampa, trampa.getWidth()/c6,trampa.getHeight()/r6);
                     TextureRegion[] FramesTrampa = new TextureRegion[c6 * r6];
                     int index6 = 0;
                     for(int  i = 0; i < r6; i++)
                     {
                         for(int j = 0; j < c6; j++)
                         {
                             FramesTrampa[index6++]= TmpTrampa[i][j];
                         }
                     }
                     ATrampa = new Animation<TextureRegion>(0.08f,FramesTrampa);

                     /********************************************/
                     /******************woman***********************/
                     woman = new Texture("woman.png");
                     TextureRegion[][] TmpWoman = TextureRegion.split(woman,woman.getWidth()/c7, woman.getHeight()/r7);
                     TextureRegion[]FramesWoman = new TextureRegion[c7*r7];
                     int index7 = 0;
                     for(int i = 0; i < r7; i++)
                     {
                         for(int j = 0; j < c7; j++)
                         {
                             FramesWoman[index7++] = TmpWoman[i][j];
                         }
                     }
                     Awoman = new Animation<TextureRegion>(0.3f,FramesWoman);
                     /****************StaticLeft************/
                     statici = new Texture("PSL.png");
                     TextureRegion[][]TmpStaticLeft = TextureRegion.split(statici,statici.getWidth()/c8,statici.getHeight()/r8);
                     TextureRegion[] FramesStaticLeft = new TextureRegion[c8 * r8];
                     int index8 = 0;
                     for(int i =0 ; i < r8; i++)
                     {
                         for(int j = 0 ; j < c8; j++)
                         {
                             FramesStaticLeft[index8++]= TmpStaticLeft[i][j];
                         }
                     }
                     Astatici = new Animation<TextureRegion>(0.2f,FramesStaticLeft);
                     /*********Coordenadas Camara*************/
                     for (MapObject object : map.getLayers().get(1).getObjects().getByType(RectangleMapObject.class)) {
                          Rectangle rect = ((RectangleMapObject) object).getRectangle();
                          camX = rect.x/Pixels;
                          camY = rect.y/Pixels;
                    }
                    /********************************************/
                    /*********Pantalla Bienvenida Ikuno*************/
                    ikunotexture = new Texture("Ikuno.png");
                    Ikuno = new Sprite(ikunotexture);
                    /**********************/
                    /************Nubes**********/
                    nube1 = new Texture("nube.png");
                    nube2 = new Texture("nube1.png");
                    snube1 = new Sprite(nube1);
                    snube1.setAlpha(0.5f);
                    snube2 = new Sprite(nube2);
                    snube2.setAlpha(0.5f);
                    /*****************************/

    }

    public void addRender(float delta) {

        batch.enableBlending();
        cam.update();
        stage.act(delta);
        cam.position.x = camX;
        cam.position.y = camY;
        cam.update();
        Gdx.input.setInputProcessor(stage);
        world.step(delta, 6, 2);
        stage.draw();
        ray.update();
        ray.setCombinedMatrix(cam.combined);
        ray.render();
        render.render(world, cam.combined);
        batch.begin();
            nubes();
            Cinematica_Principal();
            IkunoScreen();
        batch.end();
    }

    public void nubes()
    {

        velocidad -= (15/Pixels) * Gdx.graphics.getDeltaTime();
        for (MapObject object : map.getLayers().get(6).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            nube1X = rect.x/Pixels;
            nube1Y = rect.y/Pixels;
        }
        for (MapObject object : map.getLayers().get(7).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            nube2X = rect.x/Pixels;
            nube2Y = rect.y/Pixels;
        }
       snube1.setBounds(nube1X+velocidad,nube1Y,64/Pixels,64/Pixels);
        snube2.setBounds(nube2X+velocidad,nube2Y,64/Pixels,64/Pixels);
        snube1.draw(batch);
        snube2.draw(batch);
    }

    public void IkunoScreen() {
        Ikuno.setAlpha(alpha);
        Ikuno.setBounds(camX - (cam.viewportWidth / 2), camY - (cam.viewportHeight / 2), 300 / Pixels, 150 / Pixels);
        Ikuno.draw(batch);
        tiempoScreen += 1 * Gdx.graphics.getDeltaTime();

            if (alpha > 0) {
                if (tiempoScreen > 2) {
                    alpha -= .3 * Gdx.graphics.getDeltaTime();
                }
            } else {
                alpha = 0;
            }
        }


    public void Cinematica_Principal()
    {
        Gdx.app.log("Coordenadas del Personaje:","X:"+cam.zoom);
        ////////////////CASA///////////////////////////////////////////
        time += Gdx.graphics.getDeltaTime();
        TextureRegion casa = Acasa.getKeyFrame(time,true);

        for (MapObject object : map.getLayers().get(2).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            casaX = rect.x/Pixels;
            casaY = rect.y/Pixels;
        }
        batch.draw(casa,casaX,casaY,106/Pixels,106/Pixels);

        ///////////////////////////////////////////////////////
        ////////////////PERSONAJE///////////////////////////////////////////
        if(!iswake)
        {
        if(camX >= 17.818547f)
        {
            timeOficial += 1 *  Gdx.graphics.getDeltaTime();
            Gdx.app.log("Time",""+timeOficial);
            time2 += Gdx.graphics.getDeltaTime();//dormir
            if(timeOficial >= 4f)
            {
                time4 += Gdx.graphics.getDeltaTime();//arbol
                time5 += Gdx.graphics.getDeltaTime();//viento
            }
        }else
        {
            if(alpha == 0)
            {
                camX += (35/Pixels)*Gdx.graphics.getDeltaTime();
            }
        }
        TextureRegion mimido = Adormir.getKeyFrame(time2,false);
        for (MapObject object : map.getLayers().get(4).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            personajeX = rect.x/Pixels;
            personajeY = rect.y/Pixels;
        }

            batch.draw(mimido,personajeX,personajeY,PersonajeSize/Pixels,PersonajeSize/Pixels);
        }

        ///////////////////////////////////////////////////////
        ////////////////ARBOL///////////////////////////////////////////
        TextureRegion arbol = Aarbol.getKeyFrame(time4,false);
        for (MapObject object : map.getLayers().get(3).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            arbolX = rect.x/Pixels;
            arbolY = rect.y/Pixels;
        }
        batch.draw(arbol,arbolX,arbolY,135/Pixels,135/Pixels);
        ///////////////////////////////////////////////////////////
        ////////////////VIENTO///////////////////////////////////////////
        TextureRegion viento = Aviento.getKeyFrame(time5,false);
        for (MapObject object : map.getLayers().get(5).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            vientoX = rect.x/Pixels;
            vientoY = rect.y/Pixels;
        }
        batch.draw(viento,vientoX,vientoY,45/Pixels,45/Pixels);
        ///////////////////////////////////////////////////////////

        if(Adormir.isAnimationFinished(time2))
        {
            iswake = true;
        }

        if(iswake) {
            /********Mujer***********/
            TextureRegion Woman = Awoman.getKeyFrame(time8, true);
            time8 += Gdx.graphics.getDeltaTime();
            if(iterator == 0) {
                for (MapObject object : map.getLayers().get(9).getObjects().getByType(RectangleMapObject.class)) {
                    Rectangle rect = ((RectangleMapObject) object).getRectangle();
                    womanX = rect.x / Pixels;
                    womanY = rect.y / Pixels;
                }
                iterator++;
            }
            if(!womanllego) {
                batch.draw(Woman, womanX, womanY, 35 / Pixels, 35 / Pixels);
                womanX += (25 / Pixels) * Gdx.graphics.getDeltaTime();
            }else
            {
                batch.draw(womanpoint,womanX, womanY, 35 / Pixels, 35 / Pixels);
                batch.draw(pensamiento,womanX+1, womanY+1, 25/ Pixels, 25 / Pixels);
            }

            /*************************/

                time1 += Gdx.graphics.getDeltaTime();
                if(womanX >= 14)
                {
                    girarPersonajeIzq = true;
                }
            if (womanX >= 15.5f) {/******Woman*******/
                womanllego = true;
                time3 += 1 * Gdx.graphics.getDeltaTime();
            }
                if (time3 <= 3) {
                    TextureRegion staticP = Astatic.getKeyFrame(time1, true);
                    if(!girarPersonajeIzq) {
                        batch.draw(staticP, personajeX, personajeY, 35 / Pixels, 35 / Pixels);
                    }else
                    {
                        TextureRegion StaticL = Astatici.getKeyFrame(time9,true);
                        time9 += Gdx.graphics.getDeltaTime();
                        batch.draw(StaticL,personajeX, personajeY, 35 / Pixels, 35 / Pixels);
                    }
                } else {

                    if (!parar) {//LLEGANDO A 38
                        /**********/
                        time6 += Gdx.graphics.getDeltaTime();
                        TextureRegion walk = Awalk.getKeyFrame(time6, true);
                        batch.draw(walk, personajeX, personajeY, 35 / Pixels, 35 / Pixels);
                        personajeX += (45 / Pixels) * Gdx.graphics.getDeltaTime();
                        camX += (45 / Pixels) * Gdx.graphics.getDeltaTime();
                    } else {
                        batch.draw(caida, personajeX, personajeY, 35 / Pixels, 35 / Pixels);
                        personajeY -= (200 / Pixels) * Gdx.graphics.getDeltaTime();
                        music.stop();


                    }
                }
            }
            if (personajeX >= 18f) {
                Pantalla38 = true;
            }
            if (personajeX >= 39.4f) {
                time7 += Gdx.graphics.getDeltaTime();
                parar = true;
            }
            pantalla38(Pantalla38);

            for (MapObject object : map.getLayers().get(8).getObjects().getByType(RectangleMapObject.class)) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();
                Tx = rect.x;
                Ty = rect.y;
            }
            TextureRegion trampa = ATrampa.getKeyFrame(time7, false);
            batch.draw(trampa, Tx / Pixels, Ty / Pixels, 32 / Pixels, 16 / Pixels);
     //   }/*****woman*****/
    }

    public void pantalla38(boolean var)
    {
        if(var) {
            n.setBounds(camX - (cam.viewportWidth / 2)-(25/Pixels), camY - (cam.viewportHeight / 2), 350 / Pixels, 150 / Pixels);
            if(!pn) {
                if(alpha2 < .9f) {
                    alpha2 += .4f * Gdx.graphics.getDeltaTime();
                }else
                {
                    alpha2 = 1;
                }
            }else
            {
                if(alpha2 > .1f) {
                    alpha2 -= .4f * Gdx.graphics.getDeltaTime();
                }else
                {
                    alpha2 = 0;
                }
            }
            n.setAlpha(alpha2);
            n.draw(batch);

            if(alpha2 >= 1) {
                PersonajeSize = 24;
                cam.zoom = .9f;
                pn = true;
            }
                   }
        if(parar) //LEGANDO A 38
            /**********/
        {

            tiempoCaida += 1 * Gdx.graphics.getDeltaTime();
            if(w1 >= 200)
            {
                w1 = 0;
            }
            if(w2 >= 200)
            {
                w2 = 0;
            }
            if(w3 >= 200)
            {
                w3 = 0;
            }
            if(w4 >= 200)
            {
                w4 = 0;
            }
            if(w5 >= 200)
            {
                w5 = 0;
            }

            if(tiempoCaida >= 1.5f)
            {
                if(tiempoCaida >= 2)
                {
                    w1 += 10 * Gdx.graphics.getDeltaTime();
                }
                if(tiempoCaida >= 2.5f)
                {
                    w2 += 10 * Gdx.graphics.getDeltaTime();
                }
                if(tiempoCaida >= 3)
                {
                    w3 += 10 * Gdx.graphics.getDeltaTime();
                }
                if(tiempoCaida >= 3.5f)
                {
                    w4 += 10 * Gdx.graphics.getDeltaTime();
                }

                if(tiempoCaida >= 4)
                {
                    w5 += 10 * Gdx.graphics.getDeltaTime();
                }

                rotacion += 2  *Gdx.graphics.getDeltaTime();
                alpha2 = 1;
                s1.setBounds(camX - (cam.viewportWidth / 2), camY - (cam.viewportHeight / 2)+3.5f, w1 / Pixels, w1 / Pixels);
                s1.setRotation(rotacion);
                s1.draw(batch);
                s2.setBounds(camX - (cam.viewportWidth / 2)+2, camY - (cam.viewportHeight / 2)+2, w2 / Pixels, w2 / Pixels);
                s2.setRotation(rotacion);
                s2.draw(batch);
                s3.setBounds(camX - (cam.viewportWidth / 2)+3, camY - (cam.viewportHeight / 2)+3f, w3 / Pixels, w3 / Pixels);
                s3.setRotation(rotacion);
                s3.draw(batch);
                s4.setBounds(camX - (cam.viewportWidth / 2)+4, camY - (cam.viewportHeight / 2)+4, w4 / Pixels, w4 / Pixels);
                s4.setRotation(rotacion);
                s4.draw(batch);
                s5.setBounds(camX - (cam.viewportWidth / 2)+3, camY - (cam.viewportHeight / 2)+5f, w5 / Pixels, w5 / Pixels);
                s5.setRotation(rotacion);
                s5.draw(batch);

            }
        }
    }



    public void detachResources() {
        womanpoint.dispose();
        woman.dispose();
        statici.dispose();
        caida.dispose();
        negro.dispose();
        nube1.dispose();
        nube2.dispose();
        music.dispose();
        ikunotexture.dispose();
        arbol.dispose();
        casa.dispose();
        dormir.dispose();
        staticd.dispose();
        walk.dispose();
        viento.dispose();
        batch.dispose();
        stage.dispose();
        world.dispose();
        render.dispose();
        ray.dispose();
    }
}



