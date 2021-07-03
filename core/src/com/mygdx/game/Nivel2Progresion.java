 package com.mygdx.game;

 import com.badlogic.gdx.Gdx;
 import com.badlogic.gdx.Screen;
 import com.badlogic.gdx.graphics.GL20;
 import com.badlogic.gdx.graphics.Texture;
 import com.badlogic.gdx.graphics.g2d.Animation;
 import com.badlogic.gdx.graphics.g2d.SpriteBatch;
 import com.badlogic.gdx.graphics.g2d.TextureRegion;
 import com.badlogic.gdx.graphics.glutils.ShaderProgram;
 import com.badlogic.gdx.maps.tiled.TiledMap;
 import com.badlogic.gdx.maps.tiled.TmxMapLoader;
 import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
 import com.mygdx.game.actors.Jugador;
 import com.mygdx.game.tiled.AddActors;
 import com.mygdx.game.tiled.AddResources;
 import com.mygdx.game.tiled.addActors2;

 import static com.mygdx.game.MyGdxGame.Pixels;

 public class Nivel2Progresion implements Screen {
     MyGdxGame game;
     private TmxMapLoader mapLoader,mapLoader2;
     private TiledMap map,map2;
     private OrthogonalTiledMapRenderer renderer,renderer2;

     AddActors add;
     addActors2 add2;
     AddResources addR;
     Texture fondoAnimado,fondoAnimado2,fondoAnimado3;
     SpriteBatch batch;
     Animation<TextureRegion> fondoAnimation;
     int c = 1, r = 3;
     float time = 0;
     float x,x2,x3;
     ShaderProgram shader;
     ShaderProgram shader2;


     public Nivel2Progresion(MyGdxGame game) {
         this.game = game;
         mapLoader = new TmxMapLoader();
         map = mapLoader.load("Nivel2Progress.tmx");
         mapLoader2 = new TmxMapLoader();
         map2 = mapLoader2.load("Nivel2ProgressFondo.tmx");
         ///////////////////////////////////////////////////////////////////////////////////////////////
         addR = new AddResources();
         add = new AddActors(addR.world,map,game,addR.stage);
         add2 = new addActors2(addR.stage);
         renderer = new OrthogonalTiledMapRenderer(map,1/Pixels);
         renderer2 = new OrthogonalTiledMapRenderer(map2,1/Pixels);
         batch = new SpriteBatch();

         fondoAnimado = new Texture("Fondo1.png");
         fondoAnimado2 = new Texture("Fondo2.png");
         fondoAnimado3 = new Texture("Fondo3.png");
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

         shader = new ShaderProgram(Gdx.files.internal("Shaders/vertex.glsl"),Gdx.files.internal("Shaders/fragment.glsl"));
         shader2 = new ShaderProgram(Gdx.files.internal("Shaders/vertex2.glsl"),Gdx.files.internal("Shaders/fragment2.glsl"));

 }

     @Override
     public void show() {
 Gdx.input.setCatchBackKey(true);
     }

     public void update()
     {
         addR.cam.update();
         renderer.setView(addR.cam.combined,addR.cam.position.x-((240/Pixels)),addR.cam.position.y-(140/Pixels),(240/ Pixels)*2, (140/Pixels)*2);
         renderer2.setView(addR.cam.combined,addR.cam.position.x-((240/Pixels)),addR.cam.position.y-(140/Pixels),(240/ Pixels)*2, (140/Pixels)*2);
     }

     @Override
     public void render(float delta) {
         time += Gdx.graphics.getDeltaTime();

         Gdx.gl.glClearColor(2/255f,13/255f,31/255f,1);
         Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
         MyGdxGame.isNivelProgress1 = true;
         batch.begin();
         game.isIsNivelProgress2 = true;
         if(Jugador.Espadazo) {
             renderer.getBatch().setShader(shader);
             renderer2.getBatch().setShader(shader);
             batch.setShader(shader);
         }
         else
             {
                 renderer.getBatch().setShader(shader2);
                 renderer2.getBatch().setShader(shader2);
                 batch.setShader(shader2);
             }
         TextureRegion fondoA = fondoAnimation.getKeyFrame(time,true);

         batch.draw(fondoAnimado3,(addR.cam.position.x-150)+x3,addR.cam.position.y-150,Gdx.graphics.getWidth()+150,Gdx.graphics.getHeight()+50);
         batch.draw(fondoAnimado3,(addR.cam.position.x-150-(Gdx.graphics.getWidth()+150))+x3,addR.cam.position.y-150,Gdx.graphics.getWidth()+150,Gdx.graphics.getHeight()+50);
         batch.draw(fondoAnimado2,(addR.cam.position.x-150)+x2,addR.cam.position.y-100,Gdx.graphics.getWidth()+150,Gdx.graphics.getHeight()+50);
         batch.draw(fondoAnimado2,(addR.cam.position.x-150-(Gdx.graphics.getWidth()+150))+x2,addR.cam.position.y-100,Gdx.graphics.getWidth()+150,Gdx.graphics.getHeight()+50);
         batch.draw(fondoAnimado,(addR.cam.position.x-250)+x,addR.cam.position.y-50,Gdx.graphics.getWidth()+150,Gdx.graphics.getHeight()+50);
         batch.draw(fondoAnimado,(addR.cam.position.x-250-(Gdx.graphics.getWidth()+150))+x,addR.cam.position.y-50,Gdx.graphics.getWidth()+150,Gdx.graphics.getHeight()+50);
         batch.end();


         update();
         renderer.render();
         addR.addRender(delta);
         renderer2.render();
         addR.batchFunctions();
         update();

         if(!MyGdxGame.NoSeguirFondo&&!Jugador.Muerto) {
             if (Jugador.body.getLinearVelocity().x >= 0.60f) {
                 x -= 15f * Gdx.graphics.getDeltaTime();
                 x2 -= 25f * Gdx.graphics.getDeltaTime();
                 x3 -= 35 * Gdx.graphics.getDeltaTime();
             } else if (Jugador.body.getLinearVelocity().x <= -0.60f) {
                 x += 15f * Gdx.graphics.getDeltaTime();
                 x2 += 25f * Gdx.graphics.getDeltaTime();
                 x3 += 35f * Gdx.graphics.getDeltaTime();
             }
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
      fondoAnimado2.dispose();
      fondoAnimado3.dispose();
      shader.dispose();
      shader2.dispose();

     }
 }
