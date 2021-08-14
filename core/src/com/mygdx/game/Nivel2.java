 package com.mygdx.game;

 import com.badlogic.gdx.Gdx;
 import com.badlogic.gdx.Screen;
 import com.badlogic.gdx.graphics.GL20;
 import com.badlogic.gdx.graphics.GL30;
 import com.badlogic.gdx.graphics.Texture;
 import com.badlogic.gdx.graphics.g2d.Animation;
 import com.badlogic.gdx.graphics.g2d.SpriteBatch;
 import com.badlogic.gdx.graphics.g2d.TextureRegion;
 import com.badlogic.gdx.maps.tiled.TiledMap;
 import com.badlogic.gdx.maps.tiled.TmxMapLoader;
 import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
 import com.mygdx.game.actors.Jugador;
 import com.mygdx.game.tiled.AddActors;
 import com.mygdx.game.tiled.AddResources;

 import static com.mygdx.game.MyGdxGame.Pixels;

 public class Nivel2 implements Screen {
     MyGdxGame game;
     private TmxMapLoader mapLoader,mapLoader2;
     private TiledMap map;
     private OrthogonalTiledMapRenderer renderer,renderer2;
     int iterator = 0;
     AddActors add;
     AddResources addR;
     Texture fondoAnimado;
     Animation<TextureRegion> fondoAnimation;
     int c = 1, r = 3;
     float time = 0;
     float x;
     SpriteBatch batch;
     public Nivel2(MyGdxGame game) {
         this.game = game;
         mapLoader = new TmxMapLoader();
         map = mapLoader.load("Nivel(3).tmx");
         batch = new SpriteBatch();
 ///////////////////////////////////////////////////////////////////////////////////////////////
         addR = new AddResources();
         add = new AddActors(addR.world,map,game,addR.stage);
         renderer = new OrthogonalTiledMapRenderer(map,1/Pixels);
         fondoAnimado = new Texture("FondoAnimado1.png");
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
     public void handleInput(float d)
     {
     }

     public void update(float d) {

         addR.cam.update();
         renderer.setView(addR.cam.combined,addR.cam.position.x-((240/Pixels)),addR.cam.position.y-(140/Pixels),(240/ Pixels)*2, (140/Pixels)*2);
        // renderer2.setView(addR.cam.combined,addR.cam.position.x-((240/Pixels)),addR.cam.position.y-(140/Pixels),(240/ Pixels)*2, (140/Pixels)*2);

     }
     @Override
     public void render(float delta) {
         time += Gdx.graphics.getDeltaTime();
         Gdx.gl.glClearColor(2/255f,13/255f,31/255f,1);
         Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
         batch.begin();
         MyGdxGame.isNivelProgress1 = false;
         MyGdxGame.isIsNivelProgress2 = false;
         TextureRegion fondoA = fondoAnimation.getKeyFrame(time,true);

         batch.draw(fondoA,(addR.cam.position.x-100)+x,addR.cam.position.y-50,Gdx.graphics.getWidth()+150,Gdx.graphics.getHeight()+50);
         batch.end();
         update(delta);
       //  renderer2.render();
         addR.addRender(delta);
         addR.stage.draw();
         renderer.render();
         addR.batchFunctions();
         addR.stage2.draw();

         if(!MyGdxGame.NoSeguirFondo&&!Jugador.Muerto) {
             if (Jugador.body.getLinearVelocity().x >= 0.60f) {
                 x -= 15f * Gdx.graphics.getDeltaTime();
             } else if (Jugador.body.getLinearVelocity().x <= -0.60f) {
                 x += 15f * Gdx.graphics.getDeltaTime();
             }
         }


     }

     @Override
     public void resize(int width, int height) {
      //   addR.viewport.update(width, height, false);
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
      batch.dispose();
      add.AddDetach();
         fondoAnimado.dispose();
      addR.detachResources();
     }
 }
