package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.tiled.AddActors;
import com.mygdx.game.tiled.AddResources;

import Cinematicas.AddResourcesCinematica1;

import static com.mygdx.game.MyGdxGame.Pixels;

public class Cinematica1 implements Screen {
    MyGdxGame game;
    SpriteBatch batch;
    Texture arbol,piso,montaña,arbusto,casa1,casa2,casa3,casa4;
    Texture gordo,zorro,aldeano1L,aldeano2R,aldeano3L,aldeano4R,pajaro;
    Texture PersonajeWR;
    Animation<TextureRegion> Gordo,Zorro,Pajaro,Aldeano1,Aldeano2,Aldeano3,Aldeano4,PersonajeCaminaI;
    Sprite logo;
    float alpha;

    int c1 = 0,r1 = 0;
    int c2 = 0,r2 = 0;
    int c3 = 0,r3 = 0;
    int c4 = 0,r4 = 0;
    int c5 = 0,r5 = 0;
    int c6 = 0,r6 = 0;
    int c7 = 0,r7 = 0;
    Stage stage;
    OrthographicCamera cam;
    Rectangle Personaje;

    public  Cinematica1(MyGdxGame game)
    {
        this.game = game;
        batch = new SpriteBatch();
        cam = new OrthographicCamera();
        cam.setToOrtho(false,240/ Pixels, 140/Pixels);
        FitViewport viewport = new FitViewport(240/ Pixels, 140/Pixels, cam);//240,140
        stage = new Stage(viewport,batch);
        /**************/
        PersonajeWR = new Texture("WalkRight.png");
        arbol = new Texture("Cinematica/Arbol3.png");
        piso = new Texture("Cinematica/piso.png");
        montaña = new Texture("Cinematica/montaña.png");
        arbusto = new Texture("Cinematica/Arbustos.png");
        casa1 = new Texture("Cinematica/asa4.png");
        casa2 = new Texture("Cinematica/casa3.png");
        casa3 = new Texture("Cinematica/Casa.png");
        casa4 = new Texture("Cinematica/CasaDosPisos.png");
        gordo = new Texture("Cinematica/npc1.png");
        zorro = new Texture("Cinematica/zorro.png");
        aldeano1L = new Texture("Cinematica/Aldeana1WalkLeft.png");
        aldeano2R = new Texture("Cinematica/Aldeana2WalkRight.png");
        aldeano3L = new Texture("Cinematica/Aldeano2WalkLeft.png");
        aldeano4R = new Texture("Cinematica/Aldeano1WalkRight.png");
        pajaro = new Texture("Cinematica/pajaro.png");

    }
    @Override
    public void show() {
        Gdx.input.setCatchBackKey(true);
    }


    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0,0,0f,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
        stage.act();

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
     batch.dispose();
     arbol.dispose();
     piso.dispose();
     montaña.dispose();
     arbusto.dispose();
     casa1.dispose();
     casa2.dispose();
     casa3.dispose();
     casa4.dispose();
     gordo.dispose();
     zorro.dispose();
     aldeano1L.dispose();
     aldeano2R.dispose();
     aldeano3L.dispose();
     aldeano4R.dispose();
     pajaro.dispose();
    }
}


