package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.Shader;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.actors.Jugador;
import com.mygdx.game.tiled.AddActors;
import com.mygdx.game.tiled.AddResources;
import com.mygdx.game.tiled.AddResourcesOfMenu;
import com.mygdx.game.tiled.Niveles;

import java.util.ArrayList;

import static com.mygdx.game.MyGdxGame.Pixels;

public class Menu implements Screen {
    MyGdxGame game;
    private TmxMapLoader mapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    AddResourcesOfMenu addR;

    public static Texture  puntero;
    Texture uno, dos,tres,cuatro,cinco,seis;
    public static Texture Home;
    public static Texture Monedas;
    private ArrayList<Niveles> NivelesMenu = new ArrayList<Niveles>();
    public static Vector2 position;//Cordenadas del icono
    public static float X, Y;
    public static Rectangle Puntero;

    public static int id = 1;

    public static Rectangle vec4;

    public Menu(MyGdxGame game) {
        this.game = game;
        mapLoader = new TmxMapLoader();
        map = mapLoader.load("Menu.tmx");
///////////////////////////////////////////////////////////////////////////////////////////////
        addR = new AddResourcesOfMenu(game, map);
        renderer = new OrthogonalTiledMapRenderer(map, 1 / Pixels);
        for (MapObject object : map.getLayers().get(1).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            position = new Vector2(rect.x / Pixels, rect.y / Pixels);
        }

        uno = new Texture("Menu1.png");
        dos = new Texture("Menu2.png");
        tres = new Texture("Menu3.png");
        cuatro = new Texture("Menu4.png");
        cinco = new Texture("Menu5.png");
        seis = new Texture("Menu6.png");
        Home = new Texture("MenuHome.png");
        Monedas = new Texture("MonedaR.png");
        puntero = new Texture("Punto.png");



        for (MapObject object : map.getLayers().get(2).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            NivelesMenu.add(new Niveles(uno, dos,tres,cuatro,cinco,seis, rect));
        }
        for (Niveles NivelesMenu : NivelesMenu) {
            addR.stage.addActor(NivelesMenu);
        }

        for (MapObject object : map.getLayers().get(3).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            vec4 = new Rectangle(rect.getX()/Pixels,rect.getY()/Pixels,rect.getWidth()/Pixels,rect.getHeight()/Pixels);
        }

        Puntero = new Rectangle();
    }

    @Override
    public void show() {
        Gdx.input.setCatchBackKey(true);
    }

    public void handleInput(float d)
    {
    }

    public void update(float d)
    {
        handleInput(d);
        renderer.setView(addR.cam);
    }

    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        renderer.render();
        addR.addRender(delta);

                }


    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        map.dispose();
        renderer.dispose();
        addR.detachResources();
        puntero.dispose();
        Monedas.dispose();
        Home.dispose();
        uno.dispose();
        dos.dispose();
        tres.dispose();
        cuatro.dispose();
        cinco.dispose();
        seis.dispose();
    }
}
