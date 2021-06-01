package com.mygdx.game.tiled;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Menu;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.actors.Jugador;

import java.util.ArrayList;
import java.util.Random;

import box2dLight.PointLight;
import box2dLight.RayHandler;

import static com.mygdx.game.MyGdxGame.Pixels;

public class AddResources {
    public static boolean CamaraY = false;
    public static SpriteBatch batch;
    public static OrthographicCamera cam;
    public static Stage stage;
    public static World world;
    public static boolean seguirCamaraY;
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
    float width,time,widthEntero = 50;
    float timethis = 0;
    int itcam = 0;
    public static Texture white;
    Texture moneda;
    MyGdxGame game;

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
    public static boolean tocoPiso = false;
    int ConfigurarCamara = 0;
    boolean camaraPersonaje = false;





    /*****************MENU DE TIENDA*****************/
    Texture fertilizante;
    Rectangle fertilizanteRect;
    Texture HojaVerde;
    Rectangle HojaVerdeRec;
    Sprite HojaV;
    float alphaHV = 1;

    Sprite blancoS;
    Texture tcero,tuno,tdos,ttres,tcuatro,tcinco,tseis,tsiete,tocho,tnueve;
    int iteratorBuy;
    Texture x;
    Rectangle salir;
    int iteratorBuyHV;
    public AddResources()
    {
        rectangulosY = new ArrayList<Rectangle>();
        rectangulosNoY = new ArrayList<Rectangle>();
        rectangulosNoX = new ArrayList<Rectangle>();
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

        relleno = new Texture("ProgressBar1.png");
        contorno= new Texture("ProgressBar2.png");
        Blanco = new Texture("Blanco.png");
        blancoS = new Sprite(Blanco);
        moneda = new Texture("MonedaR.png");
        whiteSprite = new Sprite(Blanco);
        puntero = new Rectangle();
        puntero2 = new Rectangle();
        punterot = new Texture("Punto.png");
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

                for (Rectangle camnoX: rectangulosNoX) {

                    if (camnoX.overlaps(Jugador.jugador)) {

                    }else
                    {

                        cam.position.x = (add.player.getX() + .4f);
                    }
                }

            for(Rectangle  camy: rectangulosY) {
                if (camy.overlaps(Jugador.jugador)) {

                    if(!camaraPersonaje) {
                        if (cam.position.y > add.player.getY() + .7f) {//.5f
                            cam.position.y -= 3f * Gdx.graphics.getDeltaTime();
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

    if (cam.position.y > add.player.getY() + .7f) {
        cam.position.y -= .5f * Gdx.graphics.getDeltaTime();
    } else if (cam.position.y < add.player.getY() + .3f) {
        cam.position.y += .5f * Gdx.graphics.getDeltaTime();
    } else {
        if (itcam == 0) {

            cam.position.y = add.player.getY() + .5f;
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
if(!Jugador.isMenu) {
    over();
}else
{
        AddActors.player.setRightActive(false);
        AddActors.player.setLeftActive(false);
        AddActors.player.setSaltoUp(false);
        AddActors.player.setAttackButton(false);
        AddActors.player.setSpeedButton(false);
}
        ray.update();
        ray.setCombinedMatrix(cam.combined);
        ray.render();
        //render.render(world,cam.combined);
        batch.begin();
if(add.player.Muerto){
    random = (int)Math.random()*50+1;
    if(iterator) {
        iterator = false;
    }else
    {
        iterator = true;
    }

}
       puntero.set(PunteroPosition.x-(5/Pixels),PunteroPosition.y-(5/Pixels),10/Pixels,10/Pixels);
        puntero2.set(PunteroPosition2.x-(5f/Pixels),PunteroPosition2.y-(5f/Pixels),10/Pixels,10/Pixels);



        batch.end();

    }

    public void batchFunctions()
    {
        batch.begin();
        if(!Jugador.isMenu) {
            if (MyGdxGame.Cinematica.getInteger("Cinematica") == 1) {
                if (!add.player.Muerto) {
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

                    batch.draw(relleno, cam.position.x - 3.8f, cam.position.y + 1.7f, widthEntero / Pixels, 15 / Pixels);
                    batch.draw(contorno, cam.position.x - 3.8f, cam.position.y + 1.7f, 50 / Pixels, 15 / Pixels);
                }
            }
            if (MyGdxGame.Cinematica.getInteger("Cinematica") == 1) {

                switch (MyGdxGame.CoinObjects) {
                    case 1: {
                        batch.draw(moneda, cam.position.x - 2f, cam.position.y + 1.7f, 15 / Pixels, 15 / Pixels);
                        break;
                    }
                    case 2: {
                        batch.draw(moneda, cam.position.x - 2f, cam.position.y + 1.7f, 15 / Pixels, 15 / Pixels);
                        batch.draw(moneda, cam.position.x - 2f + (15 / Pixels), cam.position.y + 1.7f, 15 / Pixels, 15 / Pixels);

                        break;
                    }
                    case 3: {
                        batch.draw(moneda, cam.position.x - 2, cam.position.y + 1.7f, 15 / Pixels, 15 / Pixels);
                        batch.draw(moneda, cam.position.x - 2f + (15 / Pixels), cam.position.y + 1.7f, 15 / Pixels, 15 / Pixels);
                        batch.draw(moneda, cam.position.x - 2f + (30 / Pixels), cam.position.y + 1.7f, 15 / Pixels, 15 / Pixels);

                        break;
                    }
                }
                DereRect.set(cam.position.x - 2.5f, cam.position.y - 2, 30 / Pixels, 30 / Pixels);
                IzqRect.set(cam.position.x - 3.8f, cam.position.y - 2, 30 / Pixels, 30 / Pixels);
                SaltoRect.set(cam.position.x + 3, cam.position.y - 2, 30 / Pixels, 30 / Pixels);
                AttackRect.set(cam.position.x + 2, cam.position.y - 2, 30 / Pixels, 30 / Pixels);
                SpeedRect.set(cam.position.x + 3, cam.position.y - 1, 30 / Pixels, 30 / Pixels);
                PauseRect.set(cam.position.x + 3, cam.position.y + 1.5f, 15 / Pixels, 15 / Pixels);
                if (!izq) {
                    batch.draw(BtnIzq, cam.position.x - 3.8f, cam.position.y - 2, 30 / Pixels, 30 / Pixels);
                } else {
                    batch.draw(BtnIzqHover, cam.position.x - 3.8f, cam.position.y - 2, 30 / Pixels, 30 / Pixels);
                }

                if (!dere) {
                    batch.draw(BtnDere, cam.position.x - 2.5f, cam.position.y - 2, 30 / Pixels, 30 / Pixels);
                } else {
                    batch.draw(BtnDereHover, cam.position.x - 2.5f, cam.position.y - 2, 30 / Pixels, 30 / Pixels);
                }

                if (!attack) {
                    batch.draw(BtnAttack, cam.position.x + 2, cam.position.y - 2, 30 / Pixels, 30 / Pixels);
                } else {
                    batch.draw(BtnAttackHover, cam.position.x + 2, cam.position.y - 2, 30 / Pixels, 30 / Pixels);
                }

                if (!salto) {
                    batch.draw(BtnSalto, cam.position.x + 3, cam.position.y - 2, 30 / Pixels, 30 / Pixels);
                } else {
                    batch.draw(BtnSaltoHover, cam.position.x + 3, cam.position.y - 2, 30 / Pixels, 30 / Pixels);
                }

                if (!speed) {
                    batch.draw(BtnSpeed, cam.position.x + 3, cam.position.y - 1, 30 / Pixels, 30 / Pixels);
                } else {
                    batch.draw(BtnSpeedHover, cam.position.x + 3, cam.position.y - 1, 30 / Pixels, 30 / Pixels);
                }
                if (!pause) {
                    batch.draw(BtnPause, cam.position.x + 3, cam.position.y + 1.5f, 15 / Pixels, 15 / Pixels);
                } else {
                    batch.draw(BtnPauseHover, cam.position.x + 3, cam.position.y + 1.5f, 15 / Pixels, 15 / Pixels);

                }
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
        if(Gdx.input.isTouched(2))
        {
            MyGdxGame.coins.putInteger("Coins", 99);
            MyGdxGame.coins.flush();
        }
        if(Gdx.input.isTouched(3))
        {
            MyGdxGame.HojaVerde.putInteger("HojaVerde", 0);
            MyGdxGame.HojaVerde.flush();

            MyGdxGame.Fertilizantes.putInteger("Fertilizantes", 0);
            MyGdxGame.Fertilizantes.flush();

        }
        if(Jugador.isMenu)
        {
            Jugador.fondoMenu.setBounds(AddResources.cam.position.x-3, AddResources.cam.position.y-2,(AddResources.cam.viewportWidth/2)+2,(AddResources.cam.viewportHeight/2)+1.5f);
            Jugador.fondoMenu.setAlpha(0.5f);
            Jugador.fondoMenu.draw(batch);

            blancoS.setBounds(AddResources.cam.position.x-3+(10/Pixels),(AddResources.cam.position.y-2)+((AddResources.cam.viewportHeight/2)+.5f)-(10/Pixels),30/Pixels,30/Pixels);
            blancoS.setAlpha(0.1f);
            blancoS.draw(batch);
            batch.draw(x,cam.position.x+2f+(15/Pixels), cam.position.y + 1.3f, 15 / Pixels, 15 / Pixels);
            salir.set(cam.position.x+2f+(15/Pixels), cam.position.y + 1.3f, 15 / Pixels, 15 / Pixels);
            if(salir.overlaps(puntero))
            {
                Jugador.isMenu = false;
                Gdx.input.vibrate(100);
            }
            CantFertilizante();
            CantHojaVerde();
            String[]recoleccion;
            if(MyGdxGame.coins.getInteger("Coins") > 99)
            {
                MyGdxGame.coins.putInteger("Coins",99);
                MyGdxGame.coins.flush();
            }
            String datos = ""+MyGdxGame.coins.getInteger("Coins");
            recoleccion = datos.split("");
            //   Gdx.app.log("Monedas",""+recoleccion[1]+" "+recoleccion[2]+" "+recoleccion[3]);
            batch.draw(moneda, cam.position.x + 2f-(10/Pixels), cam.position.y - 1.9f, 10 / Pixels, 10 / Pixels);
            if(recoleccion[0]== null) {
                recoleccion[0] = "0";
            }

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
            try { switch(recoleccion[1])
            {
                case "0":
                {
                    batch.draw(tcero,cam.position.x+2f,  cam.position.y-1.9f,10/Pixels,10/Pixels);
                    break;
                }
                case "1":
                {
                    batch.draw(tuno,cam.position.x+2f,  cam.position.y-1.9f,10/Pixels,10/Pixels);
                    break;
                }
                case "2":
                {
                    batch.draw(tdos,cam.position.x+2f,  cam.position.y-1.9f,10/Pixels,10/Pixels);
                    break;
                }
                case "3":
                {
                    batch.draw(ttres,cam.position.x+2f,  cam.position.y-1.9f,10/Pixels,10/Pixels);
                    break;
                }
                case "4":
                {
                    batch.draw(tcuatro,cam.position.x+2f,  cam.position.y-1.9f,10/Pixels,10/Pixels);
                    break;
                }
                case "5":
                {
                    batch.draw(tcinco,cam.position.x+2f,  cam.position.y-1.9f,10/Pixels,10/Pixels);
                    break;
                }
                case "6":
                {
                    batch.draw(tseis,cam.position.x+2f,  cam.position.y-1.9f,10/Pixels,10/Pixels);
                    break;
                }
                case "7":
                {
                    batch.draw(tsiete,cam.position.x+2f,  cam.position.y-1.9f,10/Pixels,10/Pixels);
                    break;
                }
                case "8":
                {
                    batch.draw(tocho,cam.position.x+2f,  cam.position.y-1.9f,10/Pixels,10/Pixels);
                    break;
                }
                case "9":
                {
                    batch.draw(tnueve,cam.position.x+2f,  cam.position.y-1.9f,10/Pixels,10/Pixels);
                    break;
                }
            }}catch(Exception e)
            {

            }
            try { switch(recoleccion[2])
            {
                case "0":
                {
                    batch.draw(tcero,cam.position.x+2f+(15f/Pixels),  cam.position.y-1.9f,10/Pixels,10/Pixels);
                    break;
                }
                case "1":
                {
                    batch.draw(tuno,cam.position.x+2f+(15f/Pixels),  cam.position.y-1.9f,10/Pixels,10/Pixels);
                    break;
                }
                case "2":
                {
                    batch.draw(tdos,cam.position.x+2f+(15f/Pixels),  cam.position.y-1.9f,10/Pixels,10/Pixels);
                    break;
                }
                case "3":
                {
                    batch.draw(ttres,cam.position.x+2f+(15f/Pixels),  cam.position.y-1.9f,10/Pixels,10/Pixels);
                    break;
                }
                case "4":
                {
                    batch.draw(tcuatro,cam.position.x+2f+(15f/Pixels),  cam.position.y-1.9f,10/Pixels,10/Pixels);
                    break;
                }
                case "5":
                {
                    batch.draw(tcinco,cam.position.x+2f+(15f/Pixels),  cam.position.y-1.9f,10/Pixels,10/Pixels);
                    break;
                }
                case "6":
                {
                    batch.draw(tseis,cam.position.x+2f+(15f/Pixels),  cam.position.y-1.9f,10/Pixels,10/Pixels);
                    break;
                }
                case "7":
                {
                    batch.draw(tsiete,cam.position.x+2f+(15f/Pixels),  cam.position.y-1.9f,10/Pixels,10/Pixels);
                    break;
                }
                case "8":
                {
                    batch.draw(tocho,cam.position.x+2f+(15f/Pixels),  cam.position.y-1.9f,10/Pixels,10/Pixels);
                    break;
                }
                case "9":
                {
                    batch.draw(tnueve,cam.position.x+2f+(15f/Pixels),  cam.position.y-1.9f,10/Pixels,10/Pixels);
                    break;
                }
            }}catch(Exception e)
            {

            }
        }
        batch.end();
    }

    public void CantFertilizante()
    {
        batch.draw(fertilizante,AddResources.cam.position.x-3+(10/Pixels),(AddResources.cam.position.y-2)+((AddResources.cam.viewportHeight/2)+.5f)-(10/Pixels),30/Pixels,30/Pixels);
        batch.draw(fertilizante,cam.position.x - 3.8f, cam.position.y + 1.9f,10/Pixels,10/Pixels);
        fertilizanteRect.set(AddResources.cam.position.x-3+(10/Pixels),(AddResources.cam.position.y-2)+((AddResources.cam.viewportHeight/2)+.5f)-(10/Pixels),30/Pixels,30/Pixels);
        if(puntero.overlaps(fertilizanteRect))
        {

            if(iteratorBuy == 0) {
                Gdx.input.vibrate(100);
                int monedasActuales = MyGdxGame.coins.getInteger("Coins");
                int fertilizante = MyGdxGame.Fertilizantes.getInteger("Fertilizantes");
                if(monedasActuales >= 10 && fertilizante < 99) {

                    fertilizante++;
                    MyGdxGame.Fertilizantes.putInteger("Fertilizantes", fertilizante);
                    MyGdxGame.Fertilizantes.flush();
                    monedasActuales -= 10;
                    MyGdxGame.coins.putInteger("Coins", monedasActuales);
                    MyGdxGame.coins.flush();
                    iteratorBuy++;
                }
            }
        }else
        {
            iteratorBuy = 0;
        }

        String[]recoleccion;
        if(MyGdxGame.Fertilizantes.getInteger("Fertilizantes") > 99)
        {
            MyGdxGame.Fertilizantes.putInteger("Fertilizantes",99);
            MyGdxGame.Fertilizantes.flush();
        }
        String datos = ""+MyGdxGame.Fertilizantes.getInteger("Fertilizantes");
        recoleccion = datos.split("");


        if(recoleccion[0]== null) {
            recoleccion[0] = "0";
        }

        switch (recoleccion[0]) {
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
        try { switch(recoleccion[1])
        {
            case "0":
            {
                batch.draw(tcero,(cam.position.x - 3.8f)+(15/Pixels), cam.position.y + 1.9f,10/Pixels,10/Pixels);
                break;
            }
            case "1":
            {
                batch.draw(tuno,(cam.position.x - 3.8f)+(15/Pixels), cam.position.y + 1.9f,10/Pixels,10/Pixels);
                break;
            }
            case "2":
            {
                batch.draw(tdos,(cam.position.x - 3.8f)+(15/Pixels), cam.position.y + 1.9f,10/Pixels,10/Pixels);
                break;
            }
            case "3":
            {
                batch.draw(ttres,(cam.position.x - 3.8f)+(15/Pixels), cam.position.y + 1.9f,10/Pixels,10/Pixels);
                break;
            }
            case "4":
            {
                batch.draw(tcuatro,(cam.position.x - 3.8f)+(15/Pixels), cam.position.y + 1.9f,10/Pixels,10/Pixels);
                break;
            }
            case "5":
            {
                batch.draw(tcinco,(cam.position.x - 3.8f)+(15/Pixels), cam.position.y + 1.9f,10/Pixels,10/Pixels);
                break;
            }
            case "6":
            {
                batch.draw(tseis,(cam.position.x - 3.8f)+(15/Pixels), cam.position.y + 1.9f,10/Pixels,10/Pixels);
                break;
            }
            case "7":
            {
                batch.draw(tsiete,(cam.position.x - 3.8f)+(15/Pixels), cam.position.y + 1.9f,10/Pixels,10/Pixels);
                break;
            }
            case "8":
            {
                batch.draw(tocho,(cam.position.x - 3.8f)+(15/Pixels), cam.position.y + 1.9f,10/Pixels,10/Pixels);
                break;
            }
            case "9":
            {
                batch.draw(tnueve,(cam.position.x - 3.8f)+(15/Pixels), cam.position.y + 1.9f,10/Pixels,10/Pixels);
                break;
            }
        }}catch(Exception e)
        {

        }
        try { switch(recoleccion[2])
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
        batch.draw(HojaVerde,(cam.position.x - 3.8f) + (50 / Pixels), cam.position.y + 1.9f, 10 / Pixels, 10 / Pixels);
        HojaVerdeRec.set(AddResources.cam.position.x - 3 + (10 / Pixels) + (40 / Pixels), (AddResources.cam.position.y - 2) + ((AddResources.cam.viewportHeight / 2) + .5f) - (10 / Pixels), 30 / Pixels, 30 / Pixels);
        int monedasActuales = MyGdxGame.coins.getInteger("Coins");
        int Hoja = MyGdxGame.HojaVerde.getInteger("HojaVerde");

        if (Hoja  == 0) {
            alphaHV = 1;
        }else if(Hoja == 1)
        {
            alphaHV = 0.5f;
        }

        if (puntero.overlaps(HojaVerdeRec)) {

            if (iteratorBuyHV == 0) {
                Gdx.input.vibrate(100);

                if (monedasActuales == 99&& Hoja < 1) {

                    Hoja++;
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
        if (MyGdxGame.HojaVerde.getInteger("HojaVerde") > 1) {
            MyGdxGame.HojaVerde.putInteger("HojaVerde", 1);
            MyGdxGame.HojaVerde.flush();
        }
        String datos = "" + MyGdxGame.HojaVerde.getInteger("HojaVerde");
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
    }
    public void over() {
        Gdx.input.setInputProcessor(stage);
        if(puntero.overlaps(DereRect)|| puntero2.overlaps(DereRect))
        {
            AddActors.player.setRightActive(true);
            dere = true;
        }else
        {

            AddActors.player.setRightActive(false);
            dere = false;
        }
        if(puntero.overlaps(IzqRect)|| puntero2.overlaps(IzqRect))
        {
            AddActors.player.setLeftActive(true);
            izq = true;
        }else
        {
            AddActors.player.setLeftActive(false);
            izq = false;
        }
        if(puntero.overlaps(SaltoRect)|| puntero2.overlaps(SaltoRect))
        {
             AddActors.player.setSaltoUp(true);
             salto = true;
        }else
        {
            AddActors.player.setSaltoUp(false);
            salto = false;
        }
        if(puntero.overlaps(AttackRect)|| puntero2.overlaps(AttackRect))
        {
            AddActors.player.setAttackButton(true);
            attack = true;
        }else
        {
            AddActors.player.setAttackButton(false);
            attack = false;
        }
        if(puntero.overlaps(SpeedRect)|| puntero2.overlaps(SpeedRect))
        {
            AddActors.player.setSpeedButton(true);
            speed = true;
        }else
        {
            AddActors.player.setSpeedButton(false);
            speed = false;
        }
        if(puntero.overlaps(PauseRect)|| puntero2.overlaps(PauseRect))
        {
            // game.setScreen(new Menu(game));
            pause = true;
        }else
        {
            pause = false;
        }
    }


}
