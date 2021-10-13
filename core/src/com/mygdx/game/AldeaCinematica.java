 package com.mygdx.game;

 import com.badlogic.gdx.Gdx;
 import com.badlogic.gdx.Screen;
 import com.badlogic.gdx.graphics.GL20;
 import com.badlogic.gdx.graphics.Texture;
 import com.badlogic.gdx.graphics.g2d.Animation;
 import com.badlogic.gdx.graphics.g2d.SpriteBatch;
 import com.badlogic.gdx.graphics.g2d.TextureRegion;
 import com.badlogic.gdx.maps.tiled.TiledMap;
 import com.badlogic.gdx.maps.tiled.TmxMapLoader;
 import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
 import com.mygdx.game.tiled.AddActors;
 import com.mygdx.game.tiled.AddResources;

 import static com.mygdx.game.MyGdxGame.Pixels;

 public class AldeaCinematica implements Screen {

     MyGdxGame game;
     private TmxMapLoader mapLoader,mapLoader2;
     private TiledMap map,map2;
     private OrthogonalTiledMapRenderer renderer,renderer2;
    boolean Empezar;
     AddActors add;
     AddResources addR;
     SpriteBatch batch;
     Texture fondoAnimado;
     Animation<TextureRegion> fondoAnimation;
     int c = 1, r = 3;


     public AldeaCinematica(MyGdxGame game) {

         this.game = game;
         mapLoader = new TmxMapLoader();
         map = mapLoader.load("AldeaCinematica.tmx");
         mapLoader2 = new TmxMapLoader();
         map2 = mapLoader2.load("AldeaCinematicaFondo.tmx");
         ///////////////////////////////////////////////////////////////////////////////////////////////
         addR = new AddResources();

         add = new AddActors(addR.world,map,game);
         // add = new AddActors(addR.world,map2,game,addR.stage);
         renderer = new OrthogonalTiledMapRenderer(map,1/Pixels);
         renderer2 = new OrthogonalTiledMapRenderer(map2,1/Pixels);
         batch = new SpriteBatch();
         fondoAnimado = new Texture("Fondo(3).png");
         TextureRegion[][] TmpFondo = TextureRegion.split(fondoAnimado,fondoAnimado.getWidth()/c,fondoAnimado.getHeight()/r);
         TextureRegion[] FramesFondo = new TextureRegion[c * r];
         int index = 0;
         for (int i = 0; i < r; i++)
         {
             for(int j = 0; j < c; j++)
             {
                 FramesFondo[index++] = TmpFondo[i][j];
             }
         }
         fondoAnimation = new Animation<TextureRegion>(0.6f,FramesFondo);

 }

     @Override
     public void show() {
 Gdx.input.setCatchBackKey(true);
     }


     public void update(float d)
     {
         addR.cam.update();renderer.setView(addR.cam.combined,addR.cam.position.x-((240/Pixels)),addR.cam.position.y-(140/Pixels),(240/ Pixels)*2, (140/Pixels)*2);
         renderer2.setView(addR.cam.combined,addR.cam.position.x-((240/Pixels)),addR.cam.position.y-(140/Pixels),(240/ Pixels)*2, (140/Pixels)*2);
     }

     @Override
     public void render(float delta) {
         MyGdxGame.isAldeaCinematica = true;
         update(delta);
         Gdx.gl.glClearColor(.05f,.05f,.05f,1);
         Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
         batch.begin();
         MyGdxGame.isNivelProgress1 = false;
         MyGdxGame.isIsNivelProgress2 = false;
         batch.draw(fondoAnimado,(addR.cam.position.x-100),addR.cam.position.y-50,Gdx.graphics.getWidth()+150,Gdx.graphics.getHeight()+50);
        batch.end();

         update(delta);
         renderer2.render();
         AddResources.addRender(delta);
         AddResources.stage.draw();

         renderer.render();
         addR.batchFunctions();
         addR.stage2.draw();



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
         renderer2.dispose();
         add.AddDetach();
         fondoAnimado.dispose();
         addR.detachResources();

     }
 }
