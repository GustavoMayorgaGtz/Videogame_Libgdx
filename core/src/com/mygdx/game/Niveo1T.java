 package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthoCachedTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.mygdx.game.tiled.AddActors;
import com.mygdx.game.tiled.AddResources;


import box2dLight.PointLight;

import static com.mygdx.game.MyGdxGame.Pixels;

public class Niveo1T implements Screen {
    MyGdxGame game;
    private TmxMapLoader mapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;

    AddActors add;
    AddResources addR;

    public Niveo1T(MyGdxGame game) {
        this.game = game;
        mapLoader = new TmxMapLoader();
        map = mapLoader.load("Nivel2.tmx");
///////////////////////////////////////////////////////////////////////////////////////////////
        addR = new AddResources();
        add = new AddActors(addR.world,map,game);
        renderer = new OrthogonalTiledMapRenderer(map,1/Pixels);

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
        Gdx.gl.glClearColor(2/255f,13/255f,31/255f,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
   //     Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        addR.addRender(delta);
        renderer.render();
      /*  addR.stage2.act(delta);
        if(add.player.Muerto) {
        }else
        {
            addR.stage2.draw();
        }*/
        addR.batchFunctions();


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
     add.AddDetach();
     addR.detachResources();
    }
}
