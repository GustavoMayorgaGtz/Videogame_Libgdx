package com.mygdx.game.tiled;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Casa;
import com.mygdx.game.Menu;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.actors.Agua1;
import com.mygdx.game.actors.Agua2;
import com.mygdx.game.actors.Agua3;
import com.mygdx.game.actors.Agua4;
import com.mygdx.game.actors.Arbusto1_1;
import com.mygdx.game.actors.Arbusto1_2;
import com.mygdx.game.actors.Arbusto1_3;
import com.mygdx.game.actors.Arbusto2_1;
import com.mygdx.game.actors.Arbusto2_2;
import com.mygdx.game.actors.Arbusto2_3;
import com.mygdx.game.actors.Casa1;
import com.mygdx.game.actors.Casa2;
import com.mygdx.game.actors.Casa2Pisos;
import com.mygdx.game.actors.Casa2Pisos2;
import com.mygdx.game.actors.CorralGallinas;
import com.mygdx.game.actors.CorralGallinas2;
import com.mygdx.game.actors.CorralVaca;
import com.mygdx.game.actors.CorralVaca2;
import com.mygdx.game.actors.Jugador;
import com.mygdx.game.actors.Maceta1_1;
import com.mygdx.game.actors.Maceta1_2;
import com.mygdx.game.actors.Maceta1_3;
import com.mygdx.game.actors.Maceta2_1;
import com.mygdx.game.actors.Maceta2_2;
import com.mygdx.game.actors.Maceta2_3;
import com.mygdx.game.actors.MenuBuild;
import com.mygdx.game.actors.Tierra1;
import com.mygdx.game.actors.Tierra2;
import com.mygdx.game.actors.Tierra3;
import com.mygdx.game.actors.Tierra4;
import com.mygdx.game.actors.Tierra5;
import com.mygdx.game.actors.TimeZone;


import java.io.Console;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import box2dLight.PointLight;
import box2dLight.RayHandler;

import static com.mygdx.game.MyGdxGame.Arbusto1_1;
import static com.mygdx.game.MyGdxGame.Maceta1_2;
import static com.mygdx.game.MyGdxGame.Pixels;

public class AddResources {
    boolean confirmbool;
    public static boolean CamaraY = false;
    public static SpriteBatch batch;
    public static OrthographicCamera cam;
    public static Stage stage;
    public static World world;
    private Box2DDebugRenderer render;
    private int iterator2 = 0;
    private RayHandler ray;
    private ShapeRenderer shape;
    public static PointLight point1;
    public static Viewport viewport;
    AddActors add;
    Random r;
    boolean iterator = true;
    int random;
    Texture relleno,contorno,Blanco;
    Sprite whiteSprite;
    float alpha = 1;
    public static boolean ScreenWhite = true;
    float width,widthEntero = 50;

    int itcam = 0;
    public static Texture white;
    Texture moneda,monedas;

    public static boolean isFreeSpace1;
    public static boolean isFreeSpace2;
    public static boolean isFreeSpace3;
    public static boolean isFreeSpace4;
    public static boolean isFreeSpace5;
    public static boolean isFreeSpace6;
    public static boolean isFreeSpace7;
    public static boolean isFreeSpace8;
    public static boolean isFreeSpace9;

    public static boolean isFreeSpaceTop1,isFreeSpaceTop2,isFreeSpaceTop3,isFreeSpaceTop4,isFreeSpaceTop5,isFreeSpaceTop6,isFreeSpaceTop7;
    public static boolean isFreeSpaceTop8,isFreeSpaceTop9,isFreeSpaceTop10;
    public static boolean free1,free2,free3,free4,free5,free6;
    public static boolean freeCorral1,freeCorral2,freeCorral3,freeCorral4 = true;


    /*****Controles*****/
    public static Rectangle puntero, puntero2;
    public static Texture punterot;
    public static Texture BtnDere,BtnDereHover;
    public static Rectangle DereRect;
    public static Texture BtnIzq,BtnIzqHover;
    public static Rectangle IzqRect;
    public static Texture BtnSalto,BtnSaltoHover;
    public static Rectangle SaltoRect;
    public static Texture BtnAttack,BtnAttackHover;
    public static Rectangle AttackRect;
    public static Texture BtnSpeed,BtnSpeedHover;
    public static Rectangle SpeedRect;
    public static Texture BtnPause,BtnPauseHover;
    public static Rectangle PauseRect;
    boolean dere,izq,salto,attack,speed,pause;
    Sprite dereS,dereHoverS,izqS,izqHoverS,saltoS,saltoHoverS,speedS,speedHoverS,attackS,attackHoverS,pauseS,pauseHoverS;

    //Controles Escondidos
    public static boolean TouchConfirm,TouchCancel;
    public static Rectangle confirm,cancel;
    public static Texture Confirmar,Cancelar;
    public static Sprite ConfirmarS,CancelarS;
    /**********/

    /****************/
    Texture ScreenTexture;

    int c = 1, f = 35;

    /****************/
    /****************/
    public static boolean isScreenUp= false;
    public static boolean isScreenDown = true;
    Texture PantallaSend;
    public static float posicionY = 500;
    int iteratorPantalla;
    float timePantalla;
    /*****************/
    public static ArrayList<Rectangle> rectangulosY;
    public static ArrayList<Rectangle> rectangulosNoY;
    public static ArrayList<Rectangle> rectangulosNoX;
    public static ArrayList<Rectangle> rectangulosX;

    public static boolean tocoPiso = false;
    int ConfigurarCamara = 0;
    boolean camaraPersonaje = false;





    /*****************MENU DE TIENDA*****************/
    float timeHome = 0;
    Texture costo1,costo2;
    Sprite costo2S;
    Texture fertilizante;
    Rectangle fertilizanteRect;
    Texture HojaVerde;
    Rectangle HojaVerdeRec;
    Sprite HojaV;
    float alphaHV = 1;
    int iteratorBuyHV;
    Texture HojaRosa;
    Rectangle HojaRosaRec;
    Sprite HojaR;
    float alphaHR = 1;
    int iteratorBuyHR;

    Sprite blancoS;
    Texture tcero,tuno,tdos,ttres,tcuatro,tcinco,tseis,tsiete,tocho,tnueve;
    int iteratorBuy;
    Texture x;
    Rectangle salir;
    ShaderProgram shader;

    Sprite progress;
    String[] numeros = new String[3];
    String[] recoleccion = new String[2];
    int iteratorSplit1;
    boolean is0,is1,is2;
    int valoractual;

    String[] numeros2 = new String[3];
    String[] recoleccion2 = new String[2];
    int iteratorSplit2;
    boolean is02,is12,is22;
    int valoractual2;





    public AddResources()
    {
        rectangulosY = new ArrayList<Rectangle>();
        rectangulosNoY = new ArrayList<Rectangle>();
        rectangulosNoX = new ArrayList<Rectangle>();
        rectangulosX = new ArrayList<Rectangle>();
        batch = new SpriteBatch();
        cam = new OrthographicCamera();
        viewport = new FitViewport(240/ Pixels, 140/Pixels, cam);//240,140
        stage = new Stage(viewport,batch);//65
        world = new World(new Vector2(0, -12), true);
        world.setContactListener(new WorldContactListener());
        shape = new ShapeRenderer();
        render = new Box2DDebugRenderer();
        ray = new RayHandler(world);
        ray.setAmbientLight(1f);

        white =new Texture("White.png");
        r = new Random();


        contorno= new Texture("ProgressBar2.png");
        Blanco = new Texture("Blanco.png");
        blancoS = new Sprite(Blanco);
        moneda = new Texture("MonedaR.png");
        monedas = new Texture("Monedas.png");
        whiteSprite = new Sprite(Blanco);
        puntero = new Rectangle();
        puntero2 = new Rectangle();
        punterot = new Texture("Punto.png");
        switch(MyGdxGame.ColorControl.getInteger("Color")) {
            case 0: {
                relleno = new Texture("controles/Blanco/ProgressBar1.png");
                BtnDere = new Texture("controles/Blanco/BtnDere.png");
                BtnDereHover = new Texture("controles/Blanco/BtnDereHover.png");
                BtnIzq = new Texture("controles/Blanco/BtnIzq.png");
                BtnIzqHover = new Texture("controles/Blanco/BtnIzqHover.png");
                BtnSalto = new Texture("controles/Blanco/BtnSalto.png");
                BtnSaltoHover = new Texture("controles/Blanco/BtnSaltoHover.png");
                BtnAttack = new Texture("controles/Blanco/Espada.png");
                BtnAttackHover = new Texture("controles/Blanco/EspadaHover.png");
                BtnSpeed = new Texture("controles/Blanco/BtnSpeed.png");
                BtnSpeedHover = new Texture("controles/Blanco/BtnSpeedHover.png");
                BtnPause = new Texture("controles/Blanco/BtnPause.png");
                BtnPauseHover = new Texture("controles/Blanco/BtnPauseHover.png");
                break;
            }
            case 1:
            {
                relleno = new Texture("ProgressBar1.png");
                BtnDere = new Texture("controles/BtnDere.png");
                BtnDereHover = new Texture("controles/BtnDereHover.png");
                BtnIzq = new Texture("controles/BtnIzq.png");
                BtnIzqHover = new Texture("controles/BtnIzqHover.png");
                BtnSalto = new Texture("controles/BtnSalto.png");
                BtnSaltoHover = new Texture("controles/BtnSaltoHover.png");
                BtnAttack = new Texture("controles/Espada.png");
                BtnAttackHover = new Texture("controles/EspadaHover.png");
                BtnSpeed = new Texture("controles/BtnSpeed.png");
                BtnSpeedHover = new Texture("controles/BtnSpeedHover.png");
                BtnPause = new Texture("controles/BtnPause.png");
                BtnPauseHover = new Texture("controles/BtnPauseHover.png");
                break;
            }
            case 2: {
                relleno = new Texture("controles/Azul/ProgressBar1.png");
                BtnDere = new Texture("controles/Azul/BtnDere.png");
                BtnDereHover = new Texture("controles/Azul/BtnDereHover.png");
                BtnIzq = new Texture("controles/Azul/BtnIzq.png");
                BtnIzqHover = new Texture("controles/Azul/BtnIzqHover.png");
                BtnSalto = new Texture("controles/Azul/BtnSalto.png");
                BtnSaltoHover = new Texture("controles/Azul/BtnSaltoHover.png");
                BtnAttack = new Texture("controles/Azul/Espada.png");
                BtnAttackHover = new Texture("controles/Azul/EspadaHover.png");
                BtnSpeed = new Texture("controles/Azul/BtnSpeed.png");
                BtnSpeedHover = new Texture("controles/Azul/BtnSpeedHover.png");
                BtnPause = new Texture("controles/Azul/BtnPause.png");
                BtnPauseHover = new Texture("controles/Azul/BtnPauseHover.png");
                break;
            }
            case 3: {
                relleno = new Texture("controles/Amarillo/ProgressBar1.png");
                BtnDere = new Texture("controles/Amarillo/BtnDere.png");
                BtnDereHover = new Texture("controles/Amarillo/BtnDereHover.png");
                BtnIzq = new Texture("controles/Amarillo/BtnIzq.png");
                BtnIzqHover = new Texture("controles/Amarillo/BtnIzqHover.png");
                BtnSalto = new Texture("controles/Amarillo/BtnSalto.png");
                BtnSaltoHover = new Texture("controles/Amarillo/BtnSaltoHover.png");
                BtnAttack = new Texture("controles/Amarillo/Espada.png");
                BtnAttackHover = new Texture("controles/Amarillo/EspadaHover.png");
                BtnSpeed = new Texture("controles/Amarillo/BtnSpeed.png");
                BtnSpeedHover = new Texture("controles/Amarillo/BtnSpeedHover.png");
                BtnPause = new Texture("controles/Amarillo/BtnPause.png");
                BtnPauseHover = new Texture("controles/Amarillo/BtnPauseHover.png");
                break;
            }
            case 4: {
                relleno = new Texture("controles/Rosa/ProgressBar1.png");
                BtnDere = new Texture("controles/Rosa/BtnDere.png");
                BtnDereHover = new Texture("controles/Rosa/BtnDereHover.png");
                BtnIzq = new Texture("controles/Rosa/BtnIzq.png");
                BtnIzqHover = new Texture("controles/Rosa/BtnIzqHover.png");
                BtnSalto = new Texture("controles/Rosa/BtnSalto.png");
                BtnSaltoHover = new Texture("controles/Rosa/BtnSaltoHover.png");
                BtnAttack = new Texture("controles/Rosa/Espada.png");
                BtnAttackHover = new Texture("controles/Rosa/EspadaHover.png");
                BtnSpeed = new Texture("controles/Rosa/BtnSpeed.png");
                BtnSpeedHover = new Texture("controles/Rosa/BtnSpeedHover.png");
                BtnPause = new Texture("controles/Rosa/BtnPause.png");
                BtnPauseHover = new Texture("controles/Rosa/BtnPauseHover.png");
                break;
            }
            case 5: {
                relleno = new Texture("controles/Verde/ProgressBar1.png");
                BtnDere = new Texture("controles/Verde/BtnDere.png");
                BtnDereHover = new Texture("controles/Verde/BtnDereHover.png");
                BtnIzq = new Texture("controles/Verde/BtnIzq.png");
                BtnIzqHover = new Texture("controles/Verde/BtnIzqHover.png");
                BtnSalto = new Texture("controles/Verde/BtnSalto.png");
                BtnSaltoHover = new Texture("controles/Verde/BtnSaltoHover.png");
                BtnAttack = new Texture("controles/Verde/Espada.png");
                BtnAttackHover = new Texture("controles/Verde/EspadaHover.png");
                BtnSpeed = new Texture("controles/Verde/BtnSpeed.png");
                BtnSpeedHover = new Texture("controles/Verde/BtnSpeedHover.png");
                BtnPause = new Texture("controles/Verde/BtnPause.png");
                BtnPauseHover = new Texture("controles/Verde/BtnPauseHover.png");
                break;
            }

        }
        dereS = new Sprite(BtnDere);
        dereHoverS = new Sprite(BtnDereHover);
        izqS = new Sprite(BtnIzq);
        izqHoverS = new Sprite(BtnIzqHover);
        saltoS = new Sprite(BtnSalto);
        saltoHoverS = new Sprite(BtnSaltoHover);
        speedS = new Sprite(BtnSpeed);
        speedHoverS = new Sprite(BtnSpeedHover);
        attackS = new Sprite(BtnAttack);
        attackHoverS = new Sprite(BtnAttackHover);
        pauseS = new Sprite(BtnPause);
        pauseHoverS = new Sprite(BtnPauseHover);

        PantallaSend = new Texture("ScreenSend.png");
        DereRect = new Rectangle();
        IzqRect = new Rectangle();
        SaltoRect = new Rectangle();
        AttackRect = new Rectangle();
        SpeedRect = new Rectangle();
        PauseRect = new Rectangle();

        /*************/
        ScreenTexture = new Texture("Screen.png");
        TextureRegion[][] frames = TextureRegion.split(ScreenTexture,ScreenTexture.getWidth()/c,ScreenTexture.getHeight()/f);
        TextureRegion[]tmp = new TextureRegion[c * f];
        int index = 0;
        for(int i = 0; i < f; i++)
        {
            for(int j = 0; j < c; j++)
            {
                tmp[index++] = frames[i][j];
            }
        }

        /**************/


        /*****************Menu tienda*************/
        costo1 = new Texture("3Moneda.png");
        costo2 = new Texture("99Moneda.png");
        fertilizante = new Texture("Fertilizante.png");
        fertilizanteRect = new Rectangle();
        tcero = new Texture("cero.png");
        tuno = new Texture("uno.png");
        tdos = new Texture("dos.png");
        ttres = new Texture("tres.png");
        tcuatro = new Texture("cuatro.png");
        tcinco = new Texture("cinco.png");
        tseis = new Texture("seis.png");
        tsiete = new Texture("siete.png");
        tocho = new Texture("ocho.png");
        tnueve = new Texture("nueve.png");
        x = new Texture("X.png");
        salir = new Rectangle();
        HojaVerde = new Texture("HojaVerde.png");
        HojaVerdeRec = new Rectangle();
        HojaV = new Sprite(HojaVerde);
        HojaRosa = new Texture("HojaRosa.png");
        HojaRosaRec = new Rectangle();
        HojaR = new Sprite(HojaRosa);
        progress = new Sprite(relleno);


        shader = new ShaderProgram(Gdx.files.internal("Shaders/vertex.glsl"),Gdx.files.internal("Shaders/fragment.glsl"));
        confirm = new Rectangle();
        cancel = new Rectangle();
        Confirmar = new Texture("Confirmar.png");
        Cancelar = new Texture("Cancelar.png");
        ConfirmarS = new Sprite(Confirmar);
        CancelarS = new Sprite(Cancelar);



    }
    public void addRender(float delta)
    {


        batch.enableBlending();
        if (iterator2 == 0) {
            MyGdxGame.CoinObjects = 0;
            iterator2++;
        }
        Vector2 PunteroPosition = new Vector2();
        float PosicionY;
        Vector2 PunteroPosition2 = new Vector2();
        float PosicionY2;
        if(Gdx.input.isTouched(0))
        {
            Vector2 position = new Vector2(Gdx.input.getX(),Gdx.input.getY());
            Vector2 size = new Vector2(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

            PunteroPosition.x = (((position.x*240)/size.x)/Pixels)+cam.position.x-(cam.viewportWidth/2);
            PosicionY = Gdx.graphics.getHeight()-position.y;
            PunteroPosition.y = (((PosicionY*140)/size.y)/Pixels)+cam.position.y-(cam.viewportHeight/2);
        }else
        {
            PunteroPosition.x = -10000;
            PunteroPosition.y = -10000;
        }
        if(Gdx.input.isTouched(1))
        {
            Vector2 position2 = new Vector2(Gdx.input.getX(1),Gdx.input.getY(1));
            Vector2 size2 = new Vector2(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

            PunteroPosition2.x = (((position2.x*240)/size2.x)/Pixels)+cam.position.x-(cam.viewportWidth/2);
            PosicionY2 = Gdx.graphics.getHeight()-position2.y;
            PunteroPosition2.y = (((PosicionY2*140)/size2.y)/Pixels)+cam.position.y-(cam.viewportHeight/2);
        }else {

            PunteroPosition2.x = -10000;
            PunteroPosition2.y = -10000;
        }
        cam.update();
        if(ConfigurarCamara <= 50) {
            try {
                cam.position.x = (add.player.getX() + .4f);
                cam.position.y = add.player.getY() + .5f;
                ConfigurarCamara++;
            }catch(Exception e)
            {

            }
        }
        if(!add.player.Muerto) {

                for (Rectangle camnoX : rectangulosNoX) {

                    if (camnoX.overlaps(Jugador.jugador)) {
                       MyGdxGame.NoSeguirFondo = true;
                    }
                }
                for(Rectangle camX : rectangulosX)
                {
                    if(camX.overlaps(Jugador.jugador)){
                        MyGdxGame.NoSeguirFondo = false;
                    cam.position.x = (add.player.getX() + .4f);
                }
                }


            for(Rectangle  camy: rectangulosY) {
                if (camy.overlaps(Jugador.jugador)) {

                    if(!camaraPersonaje) {
                        if (cam.position.y > add.player.getY() + .7f) {//.5f
                            cam.position.y -= 5f * Gdx.graphics.getDeltaTime();
                        } else if (cam.position.y < add.player.getY() + .3f) {
                            cam.position.y += 3f * Gdx.graphics.getDeltaTime();
                        }
                    }
                    if(!camaraPersonaje) {
                        if (cam.position.y == add.player.getY() + .5f) {

                            camaraPersonaje = true;
                            cam.position.y = add.player.getY() + .5f;
                        }
                    }else
                    {
                        cam.position.y = add.player.getY() + .5f;
                    }
                }



                for (Rectangle camnoy : rectangulosNoY) {

                    if (camnoy.overlaps(Jugador.jugador)) {
                        camaraPersonaje = false;
if(tocoPiso) {
    itcam = 0;
    if (cam.position.y > add.player.getY() + .7f) {
        cam.position.y -= .5f * Gdx.graphics.getDeltaTime();
    } else if (cam.position.y < add.player.getY() + .3f) {
        cam.position.y += .5f * Gdx.graphics.getDeltaTime();
    } else {
        if (itcam == 0) {
        //    Gdx.app.log("SE activooooo","HIHIHOIJOI");
            cam.position.y = add.player.getY() + .5f;
            tocoPiso = false;
            itcam = 1;
        }
    }
}
                    }
                }

            }
        }
        cam.update();
        stage.act(delta);
        world.step(delta,6,2);
        stage.draw();

            if (!Jugador.isMenu) {
                over();
            } else {
                AddActors.player.setRightActive(false);
                AddActors.player.setLeftActive(false);
                AddActors.player.setSaltoUp(false);
                AddActors.player.setAttackButton(false);
                AddActors.player.setSpeedButton(false);
            }
            ray.update();
            ray.setCombinedMatrix(cam.combined);
            ray.render();
          //  render.render(world, cam.combined);
            batch.begin();
            //batch.setShader(shader);
            if (add.player.Muerto) {
                random = (int) Math.random() * 50 + 1;
                if (iterator) {
                    iterator = false;
                } else {
                    iterator = true;
                }

            }

       puntero.set(PunteroPosition.x-(5/Pixels),PunteroPosition.y-(5/Pixels),10/Pixels,10/Pixels);
        puntero2.set(PunteroPosition2.x-(5f/Pixels),PunteroPosition2.y-(5f/Pixels),10/Pixels,10/Pixels);



        batch.end();

    }

    public void batchFunctions()
    {

        actualizarDatos();
batch.begin();
        if(!Jugador.isMenu) {

            if (MyGdxGame.Cinematica.getInteger("Cinematica") == 1) {
/************************************************/

                if (MyGdxGame.coins.getInteger("Coins") > 99) {
                    MyGdxGame.coins.putInteger("Coins", 99);
                    MyGdxGame.coins.flush();
                }


                switch (recoleccion[0]) {

                    case "0": {
                        batch.draw(tcero, cam.position.x - 2, cam.position.y + 1.9f, 10 / Pixels, 10 / Pixels);
                        break;
                    }
                    case "1": {
                        batch.draw(tuno, cam.position.x - 2, cam.position.y + 1.9f, 10 / Pixels, 10 / Pixels);
                        break;
                    }
                    case "2": {
                        batch.draw(tdos, cam.position.x - 2, cam.position.y + 1.9f, 10 / Pixels, 10 / Pixels);
                        break;
                    }
                    case "3": {
                        batch.draw(ttres, cam.position.x - 2, cam.position.y + 1.9f, 10 / Pixels, 10 / Pixels);
                        break;
                    }
                    case "4": {
                        batch.draw(tcuatro, cam.position.x - 2, cam.position.y + 1.9f, 10 / Pixels, 10 / Pixels);
                        break;
                    }
                    case "5": {
                        batch.draw(tcinco, cam.position.x - 2, cam.position.y + 1.9f, 10 / Pixels, 10 / Pixels);
                        break;
                    }
                    case "6": {
                        batch.draw(tseis, cam.position.x - 2, cam.position.y + 1.9f, 10 / Pixels, 10 / Pixels);
                        break;
                    }
                    case "7": {
                        batch.draw(tsiete, cam.position.x - 2, cam.position.y + 1.9f, 10 / Pixels, 10 / Pixels);
                        break;
                    }
                    case "8": {
                        batch.draw(tocho, cam.position.x - 2, cam.position.y + 1.9f, 10 / Pixels, 10 / Pixels);
                        break;
                    }
                    case "9": {
                        batch.draw(tnueve, cam.position.x - 2, cam.position.y + 1.9f, 10 / Pixels, 10 / Pixels);
                        break;
                    }
                    default: {

                    }
                }

                try {
                    switch (recoleccion[1]) {
                        case "0": {
                            batch.draw(tcero, cam.position.x - 2f + (13 / Pixels), cam.position.y + 1.9f, 10 / Pixels, 10 / Pixels);
                            break;
                        }
                        case "1": {
                            batch.draw(tuno, cam.position.x - 2f + (13 / Pixels), cam.position.y + 1.9f, 10 / Pixels, 10 / Pixels);
                            break;
                        }
                        case "2": {
                            batch.draw(tdos, cam.position.x - 2f + (13 / Pixels), cam.position.y + 1.9f, 10 / Pixels, 10 / Pixels);
                            break;
                        }
                        case "3": {
                            batch.draw(ttres, cam.position.x - 2f + (13 / Pixels), cam.position.y + 1.9f, 10 / Pixels, 10 / Pixels);
                            break;
                        }
                        case "4": {
                            batch.draw(tcuatro, cam.position.x - 2f + (13 / Pixels), cam.position.y + 1.9f, 10 / Pixels, 10 / Pixels);
                            break;
                        }
                        case "5": {
                            batch.draw(tcinco, cam.position.x - 2f + (13 / Pixels), cam.position.y + 1.9f, 10 / Pixels, 10 / Pixels);
                            break;
                        }
                        case "6": {
                            batch.draw(tseis, cam.position.x - 2f + (13 / Pixels), cam.position.y + 1.9f, 10 / Pixels, 10 / Pixels);
                            break;
                        }
                        case "7": {
                            batch.draw(tsiete, cam.position.x - 2f + (13 / Pixels), cam.position.y + 1.9f, 10 / Pixels, 10 / Pixels);
                            break;
                        }
                        case "8": {
                            batch.draw(tocho, cam.position.x - 2f + (13 / Pixels), cam.position.y + 1.9f, 10 / Pixels, 10 / Pixels);
                            break;
                        }
                        case "9": {
                            batch.draw(tnueve, cam.position.x - 2f + (13 / Pixels), cam.position.y + 1.9f, 10 / Pixels, 10 / Pixels);
                            break;
                        }
                        default: {

                        }
                    }
                } catch (Exception e) {

                }
                batch.draw(moneda, cam.position.x - 2f + (26 / Pixels), cam.position.y + 1.9f, 10 / Pixels, 10 / Pixels);
/************************************************/


                switch (MyGdxGame.Alpha.getInteger("Alpha")) {
                    case 0: {
                        MyGdxGame.alpha = 0.2f;
                        break;
                    }
                    case 1: {
                        MyGdxGame.alpha = 0.5f;
                        break;
                    }
                    case 2: {
                        MyGdxGame.alpha = 0.8f;
                        break;
                    }
                }

                /**************************/
                /**************************/
                /**************************/
                /**************************/
                /**************************/
                /**************************/
                /**************************/
                if (!MenuBuild.BuildTierra&&!MenuBuild.BuildAgua&&!MenuBuild.BuildMover&&!MenuBuild.CasasDosPisosBuild
                        &&!MenuBuild.CasasBuild&&!MenuBuild.Maceta1Build&&!MenuBuild.Maceta2Build&&!MenuBuild.Arbusto1Build
                        &&!MenuBuild.Arbusto2Build&&!MenuBuild.isCorralVacasBuild&&!MenuBuild.isCorralGallinasBuild) {
                    if (!MenuBuild.isMenu&&!MenuBuild.isMenuSeedSelection) {
                        if (MyGdxGame.Cinematica.getInteger("Cinematica") == 1) {
                            cancel.set(0,0,0,0);
                            confirm.set(0,0,0,0);
                            TouchCancel = false;
                            TouchConfirm = false;

                            if (!add.player.Muerto) {
                                if (add.player.Espadazo) {
                                    add.player.time1 = 0;
                                    widthEntero = 0;
                                }
                                if (Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT) && Gdx.input.isKeyPressed(Input.Keys.BUTTON_R2) || add.player.rightActive && Gdx.input.isKeyPressed(Input.Keys.BUTTON_R2) || add.player.rightActive && add.player.SpeedButton) {
                                    width = (add.player.time3 * 50) / 1;
                                    widthEntero = widthEntero - (width * Gdx.graphics.getDeltaTime() * 2);
                                }
                                if (Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT) && Gdx.input.isKeyPressed(Input.Keys.BUTTON_R2) || add.player.leftActive && Gdx.input.isKeyPressed(Input.Keys.BUTTON_R2) || add.player.leftActive && add.player.SpeedButton) {
                                    width = (add.player.time3 * 50) / 1;
                                    widthEntero = widthEntero - (width * Gdx.graphics.getDeltaTime() * 2);
                                }
                                if (widthEntero <= 5 || add.player.time3 >= 1) {
                                    widthEntero = 0;
                                }

                                if (add.player.time1 > 3 && add.player.time3 <= 0.1f) {
                                    widthEntero = 50;
                                }

                                progress.setAlpha(MyGdxGame.alpha);
                                progress.setBounds(cam.position.x - 3.8f, cam.position.y + 1.7f, widthEntero / Pixels, 15 / Pixels);
                                progress.draw(batch);
                                batch.draw(contorno, cam.position.x - 3.8f, cam.position.y + 1.7f, 50 / Pixels, 15 / Pixels);
                            }
                        }

                        DereRect.set(cam.position.x - 2.5f, cam.position.y - 2, 30 / Pixels, 30 / Pixels);
                        IzqRect.set(cam.position.x - 3.8f, cam.position.y - 2, 30 / Pixels, 30 / Pixels);
                        SaltoRect.set(cam.position.x + 3, cam.position.y - 2, 30 / Pixels, 30 / Pixels);
                        AttackRect.set(cam.position.x + 2, cam.position.y - 2, 30 / Pixels, 30 / Pixels);
                        SpeedRect.set(cam.position.x + 3, cam.position.y - 1, 30 / Pixels, 30 / Pixels);
                        PauseRect.set(cam.position.x + 3, cam.position.y + 1.8f, 15 / Pixels, 15 / Pixels);
                        if (!izq) {
                            // batch.draw(BtnIzq, cam.position.x - 3.8f, cam.position.y - 2, 30 / Pixels, 30 / Pixels);
                            izqS.setAlpha(MyGdxGame.alpha);
                            izqS.setBounds(cam.position.x - 3.8f, cam.position.y - 2, 30 / Pixels, 30 / Pixels);
                            izqS.draw(batch);
                        } else {
                            // batch.draw(BtnIzqHover, cam.position.x - 3.8f, cam.position.y - 2, 30 / Pixels, 30 / Pixels);
                            izqHoverS.setAlpha(MyGdxGame.alpha);
                            izqHoverS.setBounds(cam.position.x - 3.8f, cam.position.y - 2, 30 / Pixels, 30 / Pixels);
                            izqHoverS.draw(batch);
                        }

                        if (!dere) {
                            //batch.draw(BtnDere, cam.position.x - 2.5f, cam.position.y - 2, 30 / Pixels, 30 / Pixels);
                            dereS.setAlpha(MyGdxGame.alpha);
                            dereS.setBounds(cam.position.x - 2.5f, cam.position.y - 2, 30 / Pixels, 30 / Pixels);
                            dereS.draw(batch);
                        } else {
                            //  batch.draw(BtnDereHover, cam.position.x - 2.5f, cam.position.y - 2, 30 / Pixels, 30 / Pixels);
                            dereHoverS.setAlpha(MyGdxGame.alpha);
                            dereHoverS.setBounds(cam.position.x - 2.5f, cam.position.y - 2, 30 / Pixels, 30 / Pixels);
                            dereHoverS.draw(batch);
                        }

                        if (!attack) {
                            //batch.draw(BtnAttack, cam.position.x + 2, cam.position.y - 2, 30 / Pixels, 30 / Pixels);
                            attackS.setAlpha(MyGdxGame.alpha);
                            attackS.setBounds(cam.position.x + 2, cam.position.y - 2, 30 / Pixels, 30 / Pixels);
                            attackS.draw(batch);
                        } else {
                            //batch.draw(BtnAttackHover, cam.position.x + 2, cam.position.y - 2, 30 / Pixels, 30 / Pixels);
                            attackHoverS.setAlpha(MyGdxGame.alpha);
                            attackHoverS.setBounds(cam.position.x + 2, cam.position.y - 2, 30 / Pixels, 30 / Pixels);
                            attackHoverS.draw(batch);
                        }

                        if (!salto) {
                            // batch.draw(BtnSalto, cam.position.x + 3, cam.position.y - 2, 30 / Pixels, 30 / Pixels);
                            saltoS.setAlpha(MyGdxGame.alpha);
                            saltoS.setBounds(cam.position.x + 3, cam.position.y - 2, 30 / Pixels, 30 / Pixels);
                            saltoS.draw(batch);
                        } else {
                            //batch.draw(BtnSaltoHover, cam.position.x + 3, cam.position.y - 2, 30 / Pixels, 30 / Pixels);
                            saltoHoverS.setAlpha(MyGdxGame.alpha);
                            saltoHoverS.setBounds(cam.position.x + 3, cam.position.y - 2, 30 / Pixels, 30 / Pixels);
                            saltoHoverS.draw(batch);
                        }

                        if (!speed) {
                            //batch.draw(BtnSpeed, cam.position.x + 3, cam.position.y - 1, 30 / Pixels, 30 / Pixels);
                            speedS.setAlpha(MyGdxGame.alpha);
                            speedS.setBounds(cam.position.x + 3, cam.position.y - 1, 30 / Pixels, 30 / Pixels);
                            speedS.draw(batch);
                        } else {
                            //  bat
                            //  ch.draw(BtnSpeedHover, cam.position.x + 3, cam.position.y - 1, 30 / Pixels, 30 / Pixels);
                            saltoHoverS.setAlpha(MyGdxGame.alpha);
                            speedHoverS.setBounds(cam.position.x + 3, cam.position.y - 1, 30 / Pixels, 30 / Pixels);
                            speedHoverS.draw(batch);
                        }
                        if (!pause) {
                            // batch.draw(BtnPause, cam.position.x + 3, cam.position.y + 1.5f, 15 / Pixels, 15 / Pixels);
                            pauseS.setAlpha(MyGdxGame.alpha);
                            pauseS.setBounds(cam.position.x + 3, cam.position.y + 1.8f, 15 / Pixels, 15 / Pixels);
                            pauseS.draw(batch);
                        } else {
                            //  batch.draw(BtnPauseHover, cam.position.x + 3, cam.position.y + 1.5f, 15 / Pixels, 15 / Pixels);
                            pauseHoverS.setAlpha(MyGdxGame.alpha);
                            pauseHoverS.setBounds(cam.position.x + 3, cam.position.y + 1.8f, 15 / Pixels, 15 / Pixels);
                            pauseHoverS.draw(batch);

                        }

                        if (MyGdxGame.isIsNivelProgress2) {
                            MenuBuild.Logo.draw(batch);
                            MenuBuild.Fondo2.draw(batch);
                            MenuBuild.moverS.draw(batch);
                            MenuBuild.moverR.set(AddResources.cam.position.x - 3.8f, AddResources.cam.position.y+(25/Pixels) , 20 / Pixels, 20 / Pixels);

                        }
                    } else {
                        if (MenuBuild.isMenu) {
                            MenuBuild m = new MenuBuild();
                            m.MenuDraw(batch, cam);
                            MenuBuild.moverR.set(0, 0, 0, 0);
                            if (AddResources.puntero.overlaps(MenuBuild.Menu1)) {
                                MenuBuild.isMenu1 = true;
                                MenuBuild.isMenu2 = false;
                                MenuBuild.isMenu3 = false;
                                MenuBuild.isMenu4 = false;

                            }
                            if (AddResources.puntero.overlaps(MenuBuild.Menu2)) {
                                MenuBuild.isMenu1 = false;
                                MenuBuild.isMenu2 = true;
                                MenuBuild.isMenu3 = false;
                                MenuBuild.isMenu4 = false;

                            }
                            if (AddResources.puntero.overlaps(MenuBuild.Menu3)) {
                                MenuBuild.isMenu1 = false;
                                MenuBuild.isMenu2 = false;
                                MenuBuild.isMenu3 = true;
                                MenuBuild.isMenu4 = false;

                            }
                            if (AddResources.puntero.overlaps(MenuBuild.Menu4)) {
                                MenuBuild.isMenu1 = false;
                                MenuBuild.isMenu2 = false;
                                MenuBuild.isMenu3 = false;
                                MenuBuild.isMenu4 = true;

                            }
                            if (AddResources.puntero.overlaps(MenuBuild.Salir)) {
                                MenuBuild.isMenu = false;
                                MenuBuild.isMenuSeedSelection = false;
                            }
                            if (!MenuBuild.BuildTierra || !MenuBuild.BuildAgua) {
                                DereRect.set(0, 0, 0, 0);
                                IzqRect.set(0, 0, 0, 0);
                            }
                            SaltoRect.set(0, 0, 0, 0);
                            AttackRect.set(0, 0, 0, 0);
                            SpeedRect.set(0, 0, 0, 0);
                            PauseRect.set(0, 0, 0, 0);
                        }
                    }
                    if (MenuBuild.isMenuSeedSelection) {
                        MenuBuild m = new MenuBuild();
                        m.MenuSeedsSelection(batch);
                        MenuBuild.moverR.set(0, 0, 0, 0);
                        DereRect.set(0, 0, 0, 0);
                        IzqRect.set(0, 0, 0, 0);
                        SaltoRect.set(0, 0, 0, 0);
                        AttackRect.set(0, 0, 0, 0);
                        SpeedRect.set(0, 0, 0, 0);
                        PauseRect.set(0, 0, 0, 0);
                        if (AddResources.puntero.overlaps(MenuBuild.Salir)) {
                            MenuBuild.isMenu = false;
                            MenuBuild.isMenuSeedSelection = false;
                        }
                    }
                }else {
/**********TIERRAS**************/
                   MenuBuild.timeMenu2=0;
                   botonesConfirm();
                }
/*****************************/
                /**************************/
                /**************************/
                /**************************/
                /**************************/
                /**************************/
                /**************************/
            }
            if (ScreenWhite) {
                whiteSprite.draw(batch);
                whiteSprite.setBounds(cam.position.x - 5, cam.position.y - 5f, 1000 / Pixels, 1000 / Pixels);
                whiteSprite.setAlpha(alpha);
                alpha -= 1f * Gdx.graphics.getDeltaTime();
                //  activarAnimacionOut = true;
                if (alpha <= 0) {
                    ScreenWhite = false;
                    alpha = 1;
                }
            }
/**************************/

            if (!isScreenUp) {
                isScreenDown = true;
            } else {
                isScreenDown = false;
            }
            if (isScreenUp == true) {

                if (iteratorPantalla == 0) {
                    posicionY = 500;
                    iteratorPantalla++;
                }
                if (posicionY > 160) {
                    posicionY -= 100 * Gdx.graphics.getDeltaTime();
                } else {
                    posicionY = 160;
                    isScreenUp = false;
                }
            }
            if (isScreenDown == true) {
                if (iteratorPantalla == 0) {
                    posicionY = 160;
                    iteratorPantalla++;
                }
                timePantalla += 1 * Gdx.graphics.getDeltaTime();
                if (timePantalla > 1) {
                    if (posicionY < 500) {
                        posicionY += 100 * Gdx.graphics.getDeltaTime();
                    } else {
                        timePantalla = 0;
                        posicionY = 500;
                        isScreenDown = false;
                    }
                }
            }
            batch.draw(PantallaSend, cam.position.x - 4.2f, cam.position.y - 2.3f - (posicionY / Pixels), 440 / Pixels, 340 / Pixels);
        }
        /*********MENUUUUUUUUUUUUUUUUUUUUUUUUUUU********/
        if(MyGdxGame.isNivelProgress1) {
            try {

                if (Jugador.isMenu) {
                    timeHome = 0;
                    Jugador.fondoMenu.setBounds(AddResources.cam.position.x - 3, AddResources.cam.position.y - 2, (AddResources.cam.viewportWidth / 2) + 2, (AddResources.cam.viewportHeight / 2) + 1.5f);
                    Jugador.fondoMenu.setAlpha(0.5f);
                    Jugador.fondoMenu.draw(batch);

                    blancoS.setBounds(AddResources.cam.position.x - 3 + (10 / Pixels), (AddResources.cam.position.y - 2) + ((AddResources.cam.viewportHeight / 2) + .5f) - (10 / Pixels), 30 / Pixels, 30 / Pixels);
                    blancoS.setAlpha(0.1f);
                    blancoS.draw(batch);
                    batch.draw(x, cam.position.x + 2f + (15 / Pixels), cam.position.y + 1.3f, 15 / Pixels, 15 / Pixels);
                    salir.set(cam.position.x + 2f + (15 / Pixels), cam.position.y + 1.3f, 15 / Pixels, 15 / Pixels);
                    if (salir.overlaps(puntero)) {
                        Jugador.isMenu = false;
                        Gdx.input.vibrate(100);
                    }
                    CantFertilizante();
                    CantHojaVerde();

                    if (MyGdxGame.coins.getInteger("Coins") > 99) {
                        MyGdxGame.coins.putInteger("Coins", 99);
                        MyGdxGame.coins.flush();
                    }


                    //   Gdx.app.log("Monedas",""+recoleccion[1]+" "+recoleccion[2]+" "+recoleccion[3]);
                    batch.draw(moneda, cam.position.x + 2f - (10 / Pixels), cam.position.y - 1.9f, 10 / Pixels, 10 / Pixels);

                    switch (recoleccion[0]) {
                        case "0": {
                            batch.draw(tcero, cam.position.x + 2f, cam.position.y - 1.9f, 10 / Pixels, 10 / Pixels);
                            break;
                        }
                        case "1": {
                            batch.draw(tuno, cam.position.x + 2f, cam.position.y - 1.9f, 10 / Pixels, 10 / Pixels);
                            break;
                        }
                        case "2": {
                            batch.draw(tdos, cam.position.x + 2f, cam.position.y - 1.9f, 10 / Pixels, 10 / Pixels);
                            break;
                        }
                        case "3": {
                            batch.draw(ttres, cam.position.x + 2f, cam.position.y - 1.9f, 10 / Pixels, 10 / Pixels);
                            break;
                        }
                        case "4": {
                            batch.draw(tcuatro, cam.position.x + 2f, cam.position.y - 1.9f, 10 / Pixels, 10 / Pixels);
                            break;
                        }
                        case "5": {
                            batch.draw(tcinco, cam.position.x + 2f, cam.position.y - 1.9f, 10 / Pixels, 10 / Pixels);
                            break;
                        }
                        case "6": {
                            batch.draw(tseis, cam.position.x + 2f, cam.position.y - 1.9f, 10 / Pixels, 10 / Pixels);
                            break;
                        }
                        case "7": {
                            batch.draw(tsiete, cam.position.x + 2f, cam.position.y - 1.9f, 10 / Pixels, 10 / Pixels);
                            break;
                        }
                        case "8": {
                            batch.draw(tocho, cam.position.x + 2f, cam.position.y - 1.9f, 10 / Pixels, 10 / Pixels);
                            break;
                        }
                        case "9": {
                            batch.draw(tnueve, cam.position.x + 2f, cam.position.y - 1.9f, 10 / Pixels, 10 / Pixels);
                            break;
                        }
                    }

                    try {
                        switch (recoleccion[1]) {
                            case "0": {
                                batch.draw(tcero, cam.position.x + 2f + (15f / Pixels), cam.position.y - 1.9f, 10 / Pixels, 10 / Pixels);
                                break;
                            }
                            case "1": {
                                batch.draw(tuno, cam.position.x + 2f + (15f / Pixels), cam.position.y - 1.9f, 10 / Pixels, 10 / Pixels);
                                break;
                            }
                            case "2": {
                                batch.draw(tdos, cam.position.x + 2f + (15f / Pixels), cam.position.y - 1.9f, 10 / Pixels, 10 / Pixels);
                                break;
                            }
                            case "3": {
                                batch.draw(ttres, cam.position.x + 2f + (15f / Pixels), cam.position.y - 1.9f, 10 / Pixels, 10 / Pixels);
                                break;
                            }
                            case "4": {
                                batch.draw(tcuatro, cam.position.x + 2f + (15f / Pixels), cam.position.y - 1.9f, 10 / Pixels, 10 / Pixels);
                                break;
                            }
                            case "5": {
                                batch.draw(tcinco, cam.position.x + 2f + (15f / Pixels), cam.position.y - 1.9f, 10 / Pixels, 10 / Pixels);
                                break;
                            }
                            case "6": {
                                batch.draw(tseis, cam.position.x + 2f + (15f / Pixels), cam.position.y - 1.9f, 10 / Pixels, 10 / Pixels);
                                break;
                            }
                            case "7": {
                                batch.draw(tsiete, cam.position.x + 2f + (15f / Pixels), cam.position.y - 1.9f, 10 / Pixels, 10 / Pixels);
                                break;
                            }
                            case "8": {
                                batch.draw(tocho, cam.position.x + 2f + (15f / Pixels), cam.position.y - 1.9f, 10 / Pixels, 10 / Pixels);
                                break;
                            }
                            case "9": {
                                batch.draw(tnueve, cam.position.x + 2f + (15f / Pixels), cam.position.y - 1.9f, 10 / Pixels, 10 / Pixels);
                                break;
                            }
                        }
                    } catch (Exception e) {

                    }
                } else {
                    UI(3.8f);
                    timeHome += .2f *Gdx.graphics.getDeltaTime();
                }

            } catch (Exception e) {
                Gdx.app.log("Error en resources", "" + e.getMessage());
            }
        }else
        {
            timeHome += 1f *Gdx.graphics.getDeltaTime();
        }
        batch.end();
    }

    public void actualizarDatos()
    {
        /********Monedas******************/
        int datos0 =  MyGdxGame.coins.getInteger("Coins");
        String datos = String.valueOf(datos0);
        if(datos0 != valoractual)
        {
            iteratorSplit1 = 0;
        }
        if(iteratorSplit1 == 0)
        {
            valoractual = MyGdxGame.coins.getInteger("Coins");
            numeros = datos.split("");
            iteratorSplit1++;
        }
        if(numeros[0] != null)
        {
            is0 = true;
         //   Gdx.app.log("boolean","is0"+numeros[0]);
        }else {
            is0 = false;
        }
        try {
            if (numeros[1] != null) {
            //    Gdx.app.log("boolean", "is1" + numeros[1]);
                is1 = true;
            } else {
                is1 = false;
            }
        }catch(Exception e){
            is1 = false;
        }
        try {
            if (numeros[2] != null) {
          //      Gdx.app.log("boolean","is2"+numeros[2]);
                is2 = true;
            }else
            {
                is2 = false;
            }
        }catch(Exception e){
            is2 = false;
        }

        if(is0 && is1&&!is2)
        {
            recoleccion[0]= numeros[0];
            try {
                recoleccion[1] = numeros[1];
            }catch(Exception e){}
        } else if (is0 && !is1 && !is2) {
            recoleccion[0] = numeros[0];
            recoleccion[1] = "";
        }else if(is0&&is1&&is2)
        {
            recoleccion[0]= numeros[1];
            try
            {

                recoleccion[1] = numeros[2];

            }catch(Exception e)
            {
                recoleccion[1]=null;
            }

        }
        /******************************/
        /********Fertilizantes******************/
        int datos02 =  MyGdxGame.Fertilizantes.getInteger("Fertilizantes");
        String datos2 = String.valueOf(datos02);
        if(datos02!= valoractual2)
        {
            iteratorSplit2 = 0;
        }
        if(iteratorSplit2 == 0)
        {
            valoractual2 = MyGdxGame.Fertilizantes.getInteger("Fertilizantes");
            numeros2 = datos2.split("");
            iteratorSplit2++;
        }
        if(numeros2[0] != null)
        {
            is02 = true;
          //  Gdx.app.log("boolean","is0"+numeros[0]);
        }else {
            is02 = false;
        }
        try {
            if (numeros2[1] != null) {
             //   Gdx.app.log("boolean", "is1" + numeros[1]);
                is12 = true;
            } else {
                is12 = false;
            }
        }catch(Exception e){
            is12 = false;
        }
        try {
            if (numeros2[2] != null) {
                //Gdx.app.log("boolean","is2"+numeros[2]);
                is22 = true;
            }else
            {
                is22 = false;
            }
        }catch(Exception e){
            is22 = false;
        }

        if(is02 && is12&&!is22)
        {
            recoleccion2[0]= numeros2[0];
            try {
                recoleccion2[1] = numeros2[1];
            }catch(Exception e){}
        } else if (is02 && !is12 && !is22) {
            recoleccion2[0] = numeros2[0];
            recoleccion2[1] = "";
        }else if(is02&&is12&&is22)
        {
            recoleccion2[0]= numeros2[1];
            try
            {

                recoleccion2[1] = numeros2[2];

            }catch(Exception e)
            {
                recoleccion2[1]=null;
            }

        }
        /******************************/
    }


    public void UI(float X)
    {
        batch.draw(fertilizante,cam.position.x - 3.8f+X, cam.position.y + 1.9f,10/Pixels,10/Pixels);

        if(MyGdxGame.Fertilizantes.getInteger("Fertilizantes") > 99)
        {
            MyGdxGame.Fertilizantes.putInteger("Fertilizantes",99);
            MyGdxGame.Fertilizantes.flush();
        }




        switch (recoleccion2[0]) {
            case "0": {
                batch.draw(tcero, (cam.position.x - 3.8f)+(15/Pixels)+X, cam.position.y + 1.9f, 10 / Pixels, 10 / Pixels);
                break;
            }
            case "1": {
                batch.draw(tuno, (cam.position.x - 3.8f)+(15/Pixels)+X, cam.position.y + 1.9f, 10 / Pixels, 10 / Pixels);
                break;
            }
            case "2": {
                batch.draw(tdos, (cam.position.x - 3.8f)+(15/Pixels)+X, cam.position.y + 1.9f, 10 / Pixels, 10 / Pixels);
                break;
            }
            case "3": {
                batch.draw(ttres, (cam.position.x - 3.8f)+(15/Pixels)+X, cam.position.y + 1.9f, 10 / Pixels, 10 / Pixels);
                break;
            }
            case "4": {
                batch.draw(tcuatro, (cam.position.x - 3.8f)+(15/Pixels)+X, cam.position.y + 1.9f, 10 / Pixels, 10 / Pixels);
                break;
            }
            case "5": {
                batch.draw(tcinco, (cam.position.x - 3.8f)+(15/Pixels)+X, cam.position.y + 1.9f, 10 / Pixels, 10 / Pixels);
                break;
            }
            case "6": {
                batch.draw(tseis, (cam.position.x - 3.8f)+(15/Pixels)+X, cam.position.y + 1.9f, 10 / Pixels, 10 / Pixels);
                break;
            }
            case "7": {
                batch.draw(tsiete, (cam.position.x - 3.8f)+(15/Pixels)+X, cam.position.y + 1.9f, 10 / Pixels, 10 / Pixels);
                break;
            }
            case "8": {
                batch.draw(tocho, (cam.position.x - 3.8f)+(15/Pixels)+X, cam.position.y + 1.9f, 10 / Pixels, 10 / Pixels);
                break;
            }
            case "9": {
                batch.draw(tnueve, (cam.position.x - 3.8f)+(15/Pixels)+X, cam.position.y + 1.9f, 10 / Pixels, 10 / Pixels);
                break;
            }
        }

        try { switch(recoleccion2[1])
        {
            case "0":
            {
                batch.draw(tcero,(cam.position.x - 3.8f)+(30/Pixels)+X, cam.position.y + 1.9f,10/Pixels,10/Pixels);
                break;
            }
            case "1":
            {
                batch.draw(tuno,(cam.position.x - 3.8f)+(30/Pixels)+X, cam.position.y + 1.9f,10/Pixels,10/Pixels);
                break;
            }
            case "2":
            {
                batch.draw(tdos,(cam.position.x - 3.8f)+(30/Pixels)+X, cam.position.y + 1.9f,10/Pixels,10/Pixels);
                break;
            }
            case "3":
            {
                batch.draw(ttres,(cam.position.x - 3.8f)+(30/Pixels)+X, cam.position.y + 1.9f,10/Pixels,10/Pixels);
                break;
            }
            case "4":
            {
                batch.draw(tcuatro,(cam.position.x - 3.8f)+(30/Pixels)+X, cam.position.y + 1.9f,10/Pixels,10/Pixels);
                break;
            }
            case "5":
            {
                batch.draw(tcinco,(cam.position.x - 3.8f)+(30/Pixels)+X, cam.position.y + 1.9f,10/Pixels,10/Pixels);
                break;
            }
            case "6":
            {
                batch.draw(tseis,(cam.position.x - 3.8f)+(30/Pixels)+X, cam.position.y + 1.9f,10/Pixels,10/Pixels);
                break;
            }
            case "7":
            {
                batch.draw(tsiete,(cam.position.x - 3.8f)+(30/Pixels)+X, cam.position.y + 1.9f,10/Pixels,10/Pixels);
                break;
            }
            case "8":
            {
                batch.draw(tocho,(cam.position.x - 3.8f)+(30/Pixels)+X, cam.position.y + 1.9f,10/Pixels,10/Pixels);
                break;
            }
            case "9":
            {
                batch.draw(tnueve,(cam.position.x - 3.8f)+(30/Pixels)+X, cam.position.y + 1.9f,10/Pixels,10/Pixels);
                break;
            }
        }
        }catch(Exception e)
        {

        }
    }

    public void CantFertilizante()
    {
        batch.draw(fertilizante,AddResources.cam.position.x-3+(10/Pixels),(AddResources.cam.position.y-2)+((AddResources.cam.viewportHeight/2)+.5f)-(10/Pixels),30/Pixels,30/Pixels);
        batch.draw(costo1,AddResources.cam.position.x-3+(15/Pixels),(AddResources.cam.position.y-2)+((AddResources.cam.viewportHeight/2)+.5f)-(20/Pixels),20/Pixels,10/Pixels);

        batch.draw(fertilizante,cam.position.x - 3.8f, cam.position.y + 1.9f,10/Pixels,10/Pixels);
        fertilizanteRect.set(AddResources.cam.position.x-3+(10/Pixels),(AddResources.cam.position.y-2)+((AddResources.cam.viewportHeight/2)+.5f)-(10/Pixels),30/Pixels,30/Pixels);
        if(puntero.overlaps(fertilizanteRect))
        {

            if(iteratorBuy == 0) {
                Gdx.input.vibrate(100);
                int monedasActuales = MyGdxGame.coins.getInteger("Coins");
                int fertilizante = MyGdxGame.Fertilizantes.getInteger("Fertilizantes");
                if(monedasActuales >= 3 && fertilizante < 99) {

                    fertilizante++;
                    MyGdxGame.Fertilizantes.putInteger("Fertilizantes", fertilizante);
                    MyGdxGame.Fertilizantes.flush();
                    monedasActuales -= 3;
                    MyGdxGame.coins.putInteger("Coins", monedasActuales);
                    MyGdxGame.coins.flush();
                    iteratorBuy++;
                }
            }
        }else
        {
            iteratorBuy = 0;
        }


        if(MyGdxGame.Fertilizantes.getInteger("Fertilizantes") > 99)
        {
            MyGdxGame.Fertilizantes.putInteger("Fertilizantes",99);
            MyGdxGame.Fertilizantes.flush();
        }


        switch (recoleccion2[0]) {
            case "0": {
                batch.draw(tcero, (cam.position.x - 3.8f)+(15/Pixels), cam.position.y + 1.9f, 10 / Pixels, 10 / Pixels);
                break;
            }
            case "1": {
                batch.draw(tuno, (cam.position.x - 3.8f)+(15/Pixels), cam.position.y + 1.9f, 10 / Pixels, 10 / Pixels);
                break;
            }
            case "2": {
                batch.draw(tdos, (cam.position.x - 3.8f)+(15/Pixels), cam.position.y + 1.9f, 10 / Pixels, 10 / Pixels);
                break;
            }
            case "3": {
                batch.draw(ttres, (cam.position.x - 3.8f)+(15/Pixels), cam.position.y + 1.9f, 10 / Pixels, 10 / Pixels);
                break;
            }
            case "4": {
                batch.draw(tcuatro, (cam.position.x - 3.8f)+(15/Pixels), cam.position.y + 1.9f, 10 / Pixels, 10 / Pixels);
                break;
            }
            case "5": {
                batch.draw(tcinco, (cam.position.x - 3.8f)+(15/Pixels), cam.position.y + 1.9f, 10 / Pixels, 10 / Pixels);
                break;
            }
            case "6": {
                batch.draw(tseis, (cam.position.x - 3.8f)+(15/Pixels), cam.position.y + 1.9f, 10 / Pixels, 10 / Pixels);
                break;
            }
            case "7": {
                batch.draw(tsiete, (cam.position.x - 3.8f)+(15/Pixels), cam.position.y + 1.9f, 10 / Pixels, 10 / Pixels);
                break;
            }
            case "8": {
                batch.draw(tocho, (cam.position.x - 3.8f)+(15/Pixels), cam.position.y + 1.9f, 10 / Pixels, 10 / Pixels);
                break;
            }
            case "9": {
                batch.draw(tnueve, (cam.position.x - 3.8f)+(15/Pixels), cam.position.y + 1.9f, 10 / Pixels, 10 / Pixels);
                break;
            }
        }

        try { switch(recoleccion2[1])
        {
            case "0":
            {
                batch.draw(tcero,(cam.position.x - 3.8f)+(30/Pixels), cam.position.y + 1.9f,10/Pixels,10/Pixels);
                break;
            }
            case "1":
            {
                batch.draw(tuno,(cam.position.x - 3.8f)+(30/Pixels), cam.position.y + 1.9f,10/Pixels,10/Pixels);
                break;
            }
            case "2":
            {
                batch.draw(tdos,(cam.position.x - 3.8f)+(30/Pixels), cam.position.y + 1.9f,10/Pixels,10/Pixels);
                break;
            }
            case "3":
            {
                batch.draw(ttres,(cam.position.x - 3.8f)+(30/Pixels), cam.position.y + 1.9f,10/Pixels,10/Pixels);
                break;
            }
            case "4":
            {
                batch.draw(tcuatro,(cam.position.x - 3.8f)+(30/Pixels), cam.position.y + 1.9f,10/Pixels,10/Pixels);
                break;
            }
            case "5":
            {
                batch.draw(tcinco,(cam.position.x - 3.8f)+(30/Pixels), cam.position.y + 1.9f,10/Pixels,10/Pixels);
                break;
            }
            case "6":
            {
                batch.draw(tseis,(cam.position.x - 3.8f)+(30/Pixels), cam.position.y + 1.9f,10/Pixels,10/Pixels);
                break;
            }
            case "7":
            {
                batch.draw(tsiete,(cam.position.x - 3.8f)+(30/Pixels), cam.position.y + 1.9f,10/Pixels,10/Pixels);
                break;
            }
            case "8":
            {
                batch.draw(tocho,(cam.position.x - 3.8f)+(30/Pixels), cam.position.y + 1.9f,10/Pixels,10/Pixels);
                break;
            }
            case "9":
            {
                batch.draw(tnueve,(cam.position.x - 3.8f)+(30/Pixels), cam.position.y + 1.9f,10/Pixels,10/Pixels);
                break;
            }
        }
        }catch(Exception e)
            {

            }
    }
    public void CantHojaVerde() {
        HojaV.setBounds(AddResources.cam.position.x - 3 + (10 / Pixels) + (40 / Pixels), (AddResources.cam.position.y - 2) + ((AddResources.cam.viewportHeight / 2) + .5f) - (10 / Pixels), 30 / Pixels, 30 / Pixels);
        HojaV.setAlpha(alphaHV);
        HojaV.draw(batch);
        costo2S = new Sprite(costo2);
        costo2S.setBounds(AddResources.cam.position.x - 3 + (55 / Pixels), (AddResources.cam.position.y - 2) + ((AddResources.cam.viewportHeight / 2) + .5f) - (20 / Pixels), 20/ Pixels, 10 / Pixels);
        costo2S.setAlpha(alphaHV);
        costo2S.draw(batch);
        batch.draw(HojaVerde,(cam.position.x - 3.8f) + (50 / Pixels), cam.position.y + 1.9f, 10 / Pixels, 10 / Pixels);
        HojaVerdeRec.set(AddResources.cam.position.x - 3 + (10 / Pixels) + (40 / Pixels), (AddResources.cam.position.y - 2) + ((AddResources.cam.viewportHeight / 2) + .5f) - (10 / Pixels), 30 / Pixels, 30 / Pixels);
        int monedasActuales = MyGdxGame.coins.getInteger("Coins");
        int Hoja = MyGdxGame.HojaVerde.getInteger("HojaVerde");

        if (Hoja  == 0) {
            alphaHV = 1;
        }else if(Hoja == 1 || Hoja == 2)
        {
            alphaHV = 0.5f;
        }

        if (puntero.overlaps(HojaVerdeRec)) {

            if (iteratorBuyHV == 0) {
                Gdx.input.vibrate(100);

                if (monedasActuales == 99&& Hoja < 1) {

                    Hoja  ++;
                    MyGdxGame.HojaVerde.putInteger("HojaVerde", Hoja);
                    MyGdxGame.HojaVerde.flush();
                    monedasActuales -= 99;
                    MyGdxGame.coins.putInteger("Coins", monedasActuales);
                    MyGdxGame.coins.flush();
                    iteratorBuyHV++;
                }
            }
        } else {
            iteratorBuyHV = 0;
        }

        String[] recoleccion;
      /*  if (MyGdxGame.HojaVerde.getInteger("HojaVerde") > 1) {
            MyGdxGame.HojaVerde.putInteger("HojaVerde", 1);
            MyGdxGame.HojaVerde.flush();
        }*/
        String datos =String.valueOf(MyGdxGame.HojaVerde.getInteger("HojaVerde"));
        recoleccion = datos.split("");


        if (recoleccion[0] == null) {
            recoleccion[0] = "0";
        }

        switch (recoleccion[0]) {
            case "0": {
                batch.draw(tcero, (cam.position.x - 3.8f) + (65 / Pixels), cam.position.y + 1.9f, 10 / Pixels, 10 / Pixels);
                break;
            }
            case "1": {
                batch.draw(tuno, (cam.position.x - 3.8f) + (65 / Pixels), cam.position.y + 1.9f, 10 / Pixels, 10 / Pixels);
                break;
            }
        }
        try {
            switch (recoleccion[1]) {
                case "0": {
                    batch.draw(tcero, (cam.position.x - 3.8f) + (65 / Pixels), cam.position.y + 1.9f, 10 / Pixels, 10 / Pixels);
                    break;
                }
                case "1": {
                    batch.draw(tuno, (cam.position.x - 3.8f) + (65 / Pixels), cam.position.y + 1.9f, 10 / Pixels, 10 / Pixels);
                    break;
                }
            }
        }catch(Exception e){}

    }

   
    public void detachResources()
    {
        batch.dispose();
        stage.dispose();
        world.dispose();
        render.dispose();
        ray.dispose();
        white.dispose();
        relleno.dispose();
        contorno.dispose();
        Blanco.dispose();
        moneda.dispose();
        monedas.dispose();
        punterot.dispose();
        BtnDere.dispose();
        BtnDereHover.dispose();
        BtnIzq.dispose();
        BtnIzqHover.dispose();
        BtnSalto.dispose();
        BtnSaltoHover.dispose();
        BtnAttack.dispose();
        BtnAttackHover.dispose();
        BtnSpeed.dispose();
        BtnSpeedHover.dispose();
        BtnPause.dispose();
        BtnPauseHover.dispose();
        ScreenTexture.dispose();
        PantallaSend.dispose();
        fertilizante.dispose();
        HojaVerde.dispose();
        HojaRosa.dispose();
        tcero.dispose();
        tuno.dispose();
        tdos.dispose();
        ttres.dispose();
        tcuatro.dispose();
        tcinco.dispose();
        tseis.dispose();
        tsiete.dispose();
        tocho.dispose();
        tnueve.dispose();
        shader.dispose();
        costo1.dispose();
        costo2.dispose();
        Confirmar.dispose();
        Cancelar.dispose();

    }
    public void over() {
        try {
            Gdx.input.setInputProcessor(stage);
            if (puntero.overlaps(DereRect) || puntero2.overlaps(DereRect)) {
                AddActors.player.setRightActive(true);
                dere = true;
            } else {

                AddActors.player.setRightActive(false);
                dere = false;
            }
            if (puntero.overlaps(IzqRect) || puntero2.overlaps(IzqRect)) {
                AddActors.player.setLeftActive(true);
                izq = true;
            } else {
                AddActors.player.setLeftActive(false);
                izq = false;
            }
            if (puntero.overlaps(SaltoRect) || puntero2.overlaps(SaltoRect)) {
                AddActors.player.setSaltoUp(true);
                salto = true;
            } else {
                AddActors.player.setSaltoUp(false);
                salto = false;
            }
            if (puntero.overlaps(AttackRect) || puntero2.overlaps(AttackRect)) {
                AddActors.player.setAttackButton(true);
                attack = true;
            } else {
                AddActors.player.setAttackButton(false);
                attack = false;
            }
            if (puntero.overlaps(SpeedRect) || puntero2.overlaps(SpeedRect)) {
                AddActors.player.setSpeedButton(true);
                speed = true;
            } else {
                AddActors.player.setSpeedButton(false);
                speed = false;
            }
            if(timeHome >= 1) {
                if (puntero.overlaps(PauseRect) || puntero2.overlaps(PauseRect)) {
                    Jugador.isMenu = false;
                    Jugador.istouchTienda = false;
                    Jugador.istouchTienda2 = false;
                    Jugador.istouchTienda3 = false;
                    Jugador.istouchTienda4 = false;

                    Menu.id = 1;
                    MyGdxGame.isNivelProgress1 = false
                    ;
                    Tienda.stop = true;
                    AddResourcesOfMenu.game.setScreen(new Menu(AddResourcesOfMenu.game));
                    pause = true;
                } else {
                    pause = false;
                }
            }
        }catch(Exception e){}
    }

    public void botonesConfirm()
    {
        SaltoRect.set(0, 0, 0, 0);
        AttackRect.set(0, 0, 0, 0);
        SpeedRect.set(0, 0, 0, 0);
        PauseRect.set(0, 0, 0, 0);
        DereRect.set(cam.position.x + 3, cam.position.y, 30 / Pixels, 30 / Pixels);
        IzqRect.set(cam.position.x - 3.8f, cam.position.y, 30 / Pixels, 30 / Pixels);
        if (!izq) {
            // batch.draw(BtnIzq, cam.position.x - 3.8f, cam.position.y - 2, 30 / Pixels, 30 / Pixels);
            izqS.setAlpha(MyGdxGame.alpha);
            izqS.setBounds(cam.position.x - 3.8f, cam.position.y, 30 / Pixels, 30 / Pixels);
            izqS.draw(batch);
        } else {
            // batch.draw(BtnIzqHover, cam.position.x - 3.8f, cam.position.y - 2, 30 / Pixels, 30 / Pixels);
            izqHoverS.setAlpha(MyGdxGame.alpha);
            izqHoverS.setBounds(cam.position.x - 3.8f, cam.position.y, 30 / Pixels, 30 / Pixels);
            izqHoverS.draw(batch);
        }

        if (!dere) {
            //batch.draw(BtnDere, cam.position.x - 2.5f, cam.position.y - 2, 30 / Pixels, 30 / Pixels);
            dereS.setAlpha(MyGdxGame.alpha);
            dereS.setBounds(cam.position.x + 3, cam.position.y, 30 / Pixels, 30 / Pixels);
            dereS.draw(batch);
        } else {
            //  batch.draw(BtnDereHover, cam.position.x - 2.5f, cam.position.y - 2, 30 / Pixels, 30 / Pixels);
            dereHoverS.setAlpha(MyGdxGame.alpha);
            dereHoverS.setBounds(cam.position.x + 3, cam.position.y, 30 / Pixels, 30 / Pixels);
            dereHoverS.draw(batch);
        }

     /**************************/
        CancelarS.setBounds(cam.position.x + 2, cam.position.y - 2, 30 / Pixels, 30 / Pixels);
        cancel.set(cam.position.x + 2, cam.position.y - 2, 30 / Pixels, 30 / Pixels);

        if (cancel.overlaps(puntero)) {
            Tierra1.cambiarPosicion = false;
            Tierra2.cambiarPosicion = false;
            Tierra3.cambiarPosicion = false;
            Tierra4.cambiarPosicion = false;
            Tierra5.cambiarPosicion = false;

            Agua1.cambiarPosicion = false;
            Agua2.cambiarPosicion = false;
            Agua3.cambiarPosicion = false;
            Agua4.cambiarPosicion = false;

            Tierra1.timeDurationTouch= 0;
            Tierra2.timeDurationTouch= 0;
            Tierra3.timeDurationTouch= 0;
            Tierra4.timeDurationTouch= 0;
            Tierra5.timeDurationTouch= 0;

            Agua1.timeDurationTouch = 0;
            Agua2.timeDurationTouch = 0;
            Agua3.timeDurationTouch = 0;
            Agua4.timeDurationTouch = 0;
            MenuBuild.BuildTierra = false;
            MenuBuild.BuildAgua = false;
            MenuBuild.BuildMover = false;
            MenuBuild.CasasDosPisosBuild = false;
            MenuBuild.CasasBuild = false;
            MenuBuild.Maceta1Build = false;
            MenuBuild.Maceta2Build = false;
            MenuBuild.Arbusto1Build = false;
            MenuBuild.Arbusto2Build = false;
            MenuBuild.isCorralVacasBuild = false;
            MenuBuild.isCorralGallinasBuild = false;
        }
freeSpace();
       ConfirmarS.draw(batch);
        CancelarS.draw(batch);
        if (confirm.overlaps(puntero)) {
            TouchConfirm = true;

        } else {
            TouchConfirm =false;
        }

    }

    public void freeSpace()
    {
        if(Gdx.input.isTouched(1))
        {
            Gdx.app.log("-----","-------");
            Gdx.app.log("val1:",""+isFreeSpace1);
            Gdx.app.log("val2:",""+isFreeSpace2);
            Gdx.app.log("val3:",""+isFreeSpace3);
            Gdx.app.log("val4:",""+isFreeSpace4);
            Gdx.app.log("val5:",""+isFreeSpace5);
            Gdx.app.log("val6:",""+isFreeSpace6);
            Gdx.app.log("val7:",""+isFreeSpace7);
            Gdx.app.log("val8:",""+isFreeSpace8);
            Gdx.app.log("val9:",""+isFreeSpace9);
            Gdx.app.log("val10:",""+isFreeSpaceTop1);
            Gdx.app.log("val11:",""+isFreeSpaceTop2);
            Gdx.app.log("val12:",""+isFreeSpaceTop3);
            Gdx.app.log("val13:",""+isFreeSpaceTop4);
            Gdx.app.log("val14:",""+isFreeSpaceTop5);
            Gdx.app.log("val15:",""+isFreeSpaceTop6);
            Gdx.app.log("val16:",""+isFreeSpaceTop7);
            Gdx.app.log("val17:",""+free1);
            Gdx.app.log("val18:",""+free2);
            Gdx.app.log("val19:",""+free3);
            Gdx.app.log("val20:",""+free4);
            Gdx.app.log("val:21",""+free5);
            Gdx.app.log("val:22",""+free6);
            Gdx.app.log("val:23",""+freeCorral1);
            Gdx.app.log("val:24",""+freeCorral2);
            Gdx.app.log("val:25",""+freeCorral3);
            Gdx.app.log("val:26",""+freeCorral4);
            Gdx.app.log("-----","-------");
        }
     /*/   if(Agua1.var1&&Agua2.var2&&Agua3.var3&&Agua4.var4&& com.mygdx.game.actors.Arbusto1_1.var5&& Arbusto1_2.var6&& Arbusto1_3.var7
        && Arbusto2_1.var8&& Arbusto2_2.var9&& Arbusto2_3.var10
        && Casa1.var11&& Casa2.var12&& Casa2Pisos.var13&& Casa2Pisos2.var14
        && CorralGallinas.var15&& CorralGallinas2.var16
        && CorralVaca.var17&& CorralVaca2.var18
        && Maceta1_1.var19&& com.mygdx.game.actors.Maceta1_2.var20&& Maceta1_3.var21
        && Maceta2_1.var22&& Maceta2_2.var23&& Maceta2_3.var24
        &&Tierra1.var25&&Tierra2.var26&&Tierra3.var27&&Tierra4.var28&&Tierra5.var29)*/

        if(!isFreeSpace1||!isFreeSpace2||!isFreeSpace3||!isFreeSpace4||!isFreeSpace5||!isFreeSpace6||!isFreeSpace7||!isFreeSpace8||!isFreeSpace9
                ||!isFreeSpaceTop1||!isFreeSpaceTop2||!isFreeSpaceTop3||!isFreeSpaceTop4
                ||!isFreeSpaceTop5||!isFreeSpaceTop6||!isFreeSpaceTop7
                ||!isFreeSpaceTop8||!isFreeSpaceTop9||!isFreeSpaceTop10
                ||!free1||!free2||!free3||!free4||!free5||!free6
                ||!freeCorral1||!freeCorral2||!freeCorral3||!freeCorral4||!Agua1.var1||!Agua2.var2||!Agua3.var3||!Agua4.var4||! com.mygdx.game.actors.Arbusto1_1.var5||!Arbusto1_2.var6||!Arbusto1_3.var7
                ||! Arbusto2_1.var8||!Arbusto2_2.var9||! Arbusto2_3.var10
                ||! Casa1.var11||! Casa2.var12||! Casa2Pisos.var13||! Casa2Pisos2.var14
                ||! CorralGallinas.var15||! CorralGallinas2.var16
                ||! CorralVaca.var17||!CorralVaca2.var18
                ||! Maceta1_1.var19||! com.mygdx.game.actors.Maceta1_2.var20||!Maceta1_3.var21
                ||! Maceta2_1.var22||!Maceta2_2.var23||! Maceta2_3.var24
                ||!Tierra1.var25||!Tierra2.var26||!Tierra3.var27||!Tierra4.var28||!Tierra5.var29){

            confirm.set(0,0,0,0);
            ConfirmarS.setBounds(0,0,0,0);

        }else
        {
            ConfirmarS.setAlpha(1);
            CancelarS.setAlpha(1);
            ConfirmarS.setBounds(cam.position.x + 3, cam.position.y - 2, 30 / Pixels, 30 / Pixels);
            confirm.set(cam.position.x + 3, cam.position.y - 2, 30 / Pixels, 30 / Pixels);
        }


    }


}
