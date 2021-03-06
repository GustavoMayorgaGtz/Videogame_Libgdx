package com.mygdx.game.tiled;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Menu;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Niveo1T;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

import box2dLight.PointLight;
import box2dLight.RayHandler;

import static com.mygdx.game.MyGdxGame.Pixels;

public class AddResourcesOfMenu {
    public static SpriteBatch batch;
    public static OrthographicCamera cam;
    public static Stage stage;
    public static World world;
    private Box2DDebugRenderer render;
    private RayHandler ray;
    private Viewport viewport;
    float scale = 1;
    int i = 0;
   // Texture cuadroNegro;
    public static boolean isTouchNivel = false;
  //  public static Rectangle ButtonA;
    public static int SelectLevel;
    public static MyGdxGame game;
    public static float camX = 3.5555568f,camY = 54.3f;
    BitmapFont numeros;
    Texture tcero,tuno,tdos,ttres,tcuatro,tcinco,tseis,tsiete,tocho,tnueve;


    public AddResourcesOfMenu(MyGdxGame game ,TiledMap map) {
        this.game = game;
        batch = new SpriteBatch();
        cam = new OrthographicCamera();
        viewport = new FitViewport(500 / Pixels, 250 / Pixels, cam);//240,140
        stage = new Stage(viewport, batch);//65
        world = new World(new Vector2(0, -12), true);
        world.setContactListener(new WorldContactListener());
        render = new Box2DDebugRenderer();
        ray = new RayHandler(world);
        ray.setAmbientLight(1f);
    //    cuadroNegro = new Texture("BotonA.png");
        //ButtonA = new Rectangle();
numeros = new BitmapFont();
numeros.setColor(Color.WHITE);
numeros.getData().scale(1/Pixels);


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

    }

    public void addRender(float delta) {

        Vector2 PunteroPosition = new Vector2();
        float PosicionY;
        if(Gdx.input.isTouched())
        {
            Vector2 position = new Vector2(Gdx.input.getX(),Gdx.input.getY());
            Vector2 size = new Vector2(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

            PunteroPosition.x = (((position.x*500)/size.x)/Pixels)+cam.position.x-(cam.viewportWidth/2);
            PosicionY = Gdx.graphics.getHeight()-position.y;
            PunteroPosition.y = (((PosicionY*250)/size.y)/Pixels)+cam.position.y-(cam.viewportHeight/2);

        }
        camX = Menu.position.x;
        camY = Menu.position.y;
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
        batch.draw(Menu.puntero,PunteroPosition.x-(5f/Pixels),PunteroPosition.y-(5f/Pixels),10/Pixels,10/Pixels);
        batch.draw(Menu.Monedas,cam.position.x+4f+(35/Pixels)*2,  cam.position.y+2f,30/Pixels,30/Pixels);


        Menu.Puntero.set(PunteroPosition.x-(5/Pixels),PunteroPosition.y-(5/Pixels),10/Pixels,10/Pixels);
        String[]recoleccion;
        if(MyGdxGame.coins.getInteger("Coins") > 99)
        {
            MyGdxGame.coins.putInteger("Coins",99);
            MyGdxGame.coins.flush();
        }
        String datos = ""+MyGdxGame.coins.getInteger("Coins");
        recoleccion = datos.split("");
     //   Gdx.app.log("Monedas",""+recoleccion[1]+" "+recoleccion[2]+" "+recoleccion[3]);
        if(recoleccion[0]== null) {
            recoleccion[0] = "0";
        }

            switch (recoleccion[0]) {
                case "0": {
                    batch.draw(tcero, cam.position.x + 4f, cam.position.y + 2f, 30 / Pixels, 30 / Pixels);
                    break;
                }
                case "1": {
                    batch.draw(tuno, cam.position.x + 4f, cam.position.y + 2f, 30 / Pixels, 30 / Pixels);
                    break;
                }
                case "2": {
                    batch.draw(tdos, cam.position.x + 4f, cam.position.y + 2f, 30 / Pixels, 30 / Pixels);
                    break;
                }
                case "3": {
                    batch.draw(ttres, cam.position.x + 4f, cam.position.y + 2f, 30 / Pixels, 30 / Pixels);
                    break;
                }
                case "4": {
                    batch.draw(tcuatro, cam.position.x + 4f, cam.position.y + 2f, 30 / Pixels, 30 / Pixels);
                    break;
                }
                case "5": {
                    batch.draw(tcinco, cam.position.x + 4f, cam.position.y + 2f, 30 / Pixels, 30 / Pixels);
                    break;
                }
                case "6": {
                    batch.draw(tseis, cam.position.x + 4f, cam.position.y + 2f, 30 / Pixels, 30 / Pixels);
                    break;
                }
                case "7": {
                    batch.draw(tsiete, cam.position.x + 4f, cam.position.y + 2f, 30 / Pixels, 30 / Pixels);
                    break;
                }
                case "8": {
                    batch.draw(tocho, cam.position.x + 4f, cam.position.y + 2f, 30 / Pixels, 30 / Pixels);
                    break;
                }
                case "9": {
                    batch.draw(tnueve, cam.position.x + 4f, cam.position.y + 2f, 30 / Pixels, 30 / Pixels);
                    break;
                }
            }


       try { switch(recoleccion[1])
        {
            case "0":
            {
                batch.draw(tcero,(cam.position.x+4f),cam.position.y+2f,30/Pixels,30/Pixels);
                break;
            }
            case "1":
            {
                batch.draw(tuno,cam.position.x+4f,cam.position.y+2f,30/Pixels,30/Pixels);
                break;
            }
            case "2":
            {
                batch.draw(tdos,cam.position.x+4f,cam.position.y+2f,30/Pixels,30/Pixels);
                break;
            }
            case "3":
            {
                batch.draw(ttres,cam.position.x+4f,cam.position.y+2f,30/Pixels,30/Pixels);
                break;
            }
            case "4":
            {
                batch.draw(tcuatro,cam.position.x+4f,cam.position.y+2f,30/Pixels,30/Pixels);
                break;
            }
            case "5":
            {
                batch.draw(tcinco,cam.position.x+4f, cam.position.y+2f,30/Pixels,30/Pixels);
                break;
            }
            case "6":
            {
                batch.draw(tseis,cam.position.x+4f,  cam.position.y+2f,30/Pixels,30/Pixels);
                break;
            }
            case "7":
            {
                batch.draw(tsiete,cam.position.x+4f,  cam.position.y+2f,30/Pixels,30/Pixels);
                break;
            }
            case "8":
            {
                batch.draw(tocho,cam.position.x+4f,   cam.position.y+2f,30/Pixels,30/Pixels);
                break;
            }
            case "9":
            {
                batch.draw(tnueve,cam.position.x+4f,  cam.position.y+2f,30/Pixels,30/Pixels);
                break;
            }
        }}catch(Exception e)
       {

       }
        try { switch(recoleccion[2])
        {
            case "0":
            {
                batch.draw(tcero,(cam.position.x+4f)+(35/Pixels),cam.position.y+2f,30/Pixels,30/Pixels);
                break;
            }
            case "1":
            {
                batch.draw(tuno,cam.position.x+4f+(35/Pixels),cam.position.y+2f,30/Pixels,30/Pixels);
                break;
            }
            case "2":
            {
                batch.draw(tdos,cam.position.x+4f+(35/Pixels),cam.position.y+2f,30/Pixels,30/Pixels);
                break;
            }
            case "3":
            {
                batch.draw(ttres,cam.position.x+4f+(35/Pixels),cam.position.y+2f,30/Pixels,30/Pixels);
                break;
            }
            case "4":
            {
                batch.draw(tcuatro,cam.position.x+4f+(35/Pixels),cam.position.y+2f,30/Pixels,30/Pixels);
                break;
            }
            case "5":
            {
                batch.draw(tcinco,cam.position.x+4f+(35/Pixels), cam.position.y+2f,30/Pixels,30/Pixels);
                break;
            }
            case "6":
            {
                batch.draw(tseis,cam.position.x+4f+(35/Pixels),  cam.position.y+2f,30/Pixels,30/Pixels);
                break;
            }
            case "7":
            {
                batch.draw(tsiete,cam.position.x+4f+(35/Pixels),  cam.position.y+2f,30/Pixels,30/Pixels);
                break;
            }
            case "8":
            {
                batch.draw(tocho,cam.position.x+4f+(35/Pixels),   cam.position.y+2f,30/Pixels,30/Pixels);
                break;
            }
            case "9":
            {
                batch.draw(tnueve,cam.position.x+4f+(35/Pixels),  cam.position.y+2f,30/Pixels,30/Pixels);
                break;
            }
        }}catch(Exception e)
        {

        }
        batch.end();
    }


    public void detachResources() {
        batch.dispose();
        stage.dispose();
        numeros.dispose();
        world.dispose();
        render.dispose();
        ray.dispose();
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
}

