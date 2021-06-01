package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.mygdx.game.tiled.AddActors;
import com.mygdx.game.tiled.AddResources;

import Cinematicas.AddResourcesCinematica1;

import static com.mygdx.game.MyGdxGame.Pixels;

public class Cinematica1 implements Screen {
    MyGdxGame game;
    private TmxMapLoader mapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;


    AddResourcesCinematica1 addR;
    public  Cinematica1(MyGdxGame game)
    {
        this.game = game;
        mapLoader = new TmxMapLoader();
        map = mapLoader.load("Casa.tmx");

        ///////////////////////////////////////////////////////////////////////////////////////////////
        addR = new AddResourcesCinematica1(game,map);

        renderer = new OrthogonalTiledMapRenderer(map,1/Pixels);

    }
    @Override
    public void show() {
        Gdx.input.setCatchBackKey(true);
    }
    public void update(float d)
    {

        renderer.setView(addR.cam);
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0,0,0f,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        renderer.render();
        addR.addRender(delta);
        update(delta);
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
    }
}


