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

 import static com.mygdx.game.MyGdxGame.Pixels;

 public class Nivel0 implements Screen {
     MyGdxGame game;
     private TmxMapLoader mapLoader,mapLoader2;
     private TiledMap map,map2;
     private OrthogonalTiledMapRenderer renderer,renderer2;

     AddActors add;
     AddResources addR;
     SpriteBatch batch;
     Texture fondoAnimado;
     Animation<TextureRegion> fondoAnimation;
     int c = 1, r = 3;
     float time = 0;
     float x;
     ShaderProgram shader;
     ShaderProgram shader2;

     public Nivel0(MyGdxGame game) {
         this.game = game;
         mapLoader = new TmxMapLoader();
         map = mapLoader.load("Nivel0.tmx");
         mapLoader2 = new TmxMapLoader();
         map2 = mapLoader2.load("Nivel0Fondo.tmx");
         ///////////////////////////////////////////////////////////////////////////////////////////////
         addR = new AddResources();
         add = new AddActors(addR.world,map,game,addR.stage);
         //  add = new AddActors(addR.world,map2,game,addR.stage);
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
         shader = new ShaderProgram(Gdx.files.internal("Shaders/vertex.glsl"),Gdx.files.internal("Shaders/fragment.glsl"));
         shader2 = new ShaderProgram(Gdx.files.internal("Shaders/vertex2.glsl"),Gdx.files.internal("Shaders/fragment2.glsl"));
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
         renderer2.setView(addR.cam);
     }

     @Override
     public void render(float delta) {
         time += Gdx.graphics.getDeltaTime();
         update(delta);
         Gdx.gl.glClearColor(.05f,.05f,.05f,1);
         Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
         batch.begin();
         MyGdxGame.isNivelProgress1 = false;
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


         batch.draw(fondoA,(addR.cam.position.x-100)+x,addR.cam.position.y-50,Gdx.graphics.getWidth()+150,Gdx.graphics.getHeight()+50);
         batch.end();
         update(delta);
         renderer2.render();
         addR.addRender(delta);
         renderer.render();
         addR.batchFunctions();
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
         shader.dispose();
         shader2.dispose();
     }
 }
