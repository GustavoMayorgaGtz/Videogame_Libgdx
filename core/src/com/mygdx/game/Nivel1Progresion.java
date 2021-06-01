 package com.mygdx.game;

 import com.badlogic.gdx.Gdx;
 import com.badlogic.gdx.Screen;
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

 public class Nivel1Progresion implements Screen {
     MyGdxGame game;
     private TmxMapLoader mapLoader,mapLoader2;
     private TiledMap map,map2;
     private OrthogonalTiledMapRenderer renderer,renderer2;

     AddActors add;
     AddResources addR;
     Texture fondoAnimado;
     SpriteBatch batch;
     Animation<TextureRegion> fondoAnimation;
     int c = 1, r = 3;
     float time = 0;
     float x;

     public Nivel1Progresion(MyGdxGame game) {
         this.game = game;
         mapLoader = new TmxMapLoader();
         map = mapLoader.load("Nivel1Progress.tmx");
         mapLoader2 = new TmxMapLoader();
         map2 = mapLoader2.load("Nivel1ProgressFondo.tmx");
         ///////////////////////////////////////////////////////////////////////////////////////////////
         addR = new AddResources();
         add = new AddActors(addR.world,map,game,addR.stage);
         renderer = new OrthogonalTiledMapRenderer(map,1/Pixels);
         renderer2 = new OrthogonalTiledMapRenderer(map2,1/Pixels);
         batch = new SpriteBatch();

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

     public void update()
     {
         renderer.setView(addR.cam);
         renderer2.setView(addR.cam);
     }

     @Override
     public void render(float delta) {
         time += Gdx.graphics.getDeltaTime();

         Gdx.gl.glClearColor(2/255f,13/255f,31/255f,1);//2/255f,13/255f,31/255f
         Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
         Gdx.gl.glBlendFunc(GL30.GL_SRC_ALPHA, GL30.GL_ONE_MINUS_SRC_ALPHA);
         batch.begin();
         TextureRegion fondoA = fondoAnimation.getKeyFrame(time,true);


         batch.draw(fondoA,(addR.cam.position.x-100)+x,addR.cam.position.y-50,Gdx.graphics.getWidth()+150,Gdx.graphics.getHeight()+50);
         batch.end();


         update();
         renderer.render();
         addR.addRender(delta);
         renderer2.render();
         addR.batchFunctions();
         update();
if(Jugador.body.getLinearVelocity().x >= 0.60f)
{
    x -= 15f * Gdx.graphics.getDeltaTime();
}else if(Jugador.body.getLinearVelocity().x <= -0.60f)
{
    x += 15f * Gdx.graphics.getDeltaTime();
}




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
      map2.dispose();
      renderer.dispose();
      renderer2.dispose();
      add.AddDetach();
      addR.detachResources();
      batch.dispose();
      fondoAnimado.dispose();
     }
 }
