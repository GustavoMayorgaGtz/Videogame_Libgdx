 package com.mygdx.game;

 import com.badlogic.gdx.Gdx;
 import com.badlogic.gdx.Screen;
 import com.badlogic.gdx.graphics.GL20;
 import com.badlogic.gdx.graphics.OrthographicCamera;
 import com.badlogic.gdx.graphics.Texture;
 import com.badlogic.gdx.graphics.g2d.Animation;
 import com.badlogic.gdx.graphics.g2d.ParticleEffect;
 import com.badlogic.gdx.graphics.g2d.Sprite;
 import com.badlogic.gdx.graphics.g2d.SpriteBatch;
 import com.badlogic.gdx.graphics.g2d.TextureRegion;
 import com.badlogic.gdx.maps.tiled.TiledMap;
 import com.badlogic.gdx.maps.tiled.TmxMapLoader;
 import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
 import com.badlogic.gdx.math.Rectangle;
 import com.badlogic.gdx.math.Vector2;
 import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
 import com.badlogic.gdx.physics.box2d.World;
 import com.badlogic.gdx.scenes.scene2d.Stage;
 import com.badlogic.gdx.utils.viewport.FitViewport;
 import com.badlogic.gdx.utils.viewport.Viewport;
 import com.mygdx.game.tiled.AddActors;
 import com.mygdx.game.tiled.AddResources;
 import com.mygdx.game.tiled.Configuraciones;
 import com.mygdx.game.tiled.WorldContactListener;

 import box2dLight.RayHandler;

 import static com.mygdx.game.MyGdxGame.Pixels;

 public class Casa implements Screen {
     MyGdxGame game;

     public SpriteBatch batch;

     public static OrthographicCamera cam;
     public static Stage stage;
     public static float alpha = 1;
     public static World world;
     private RayHandler ray;
     boolean isScreenTouched = false;
     private Viewport viewport;
     float time,Alpha;
     float Alpha2;
     float y = 0;
     Rectangle play,confi,Puntero;


     /****************/
          Texture ikuno;
          Sprite ikunoS;
          ParticleEffect ambiente,ambiente2,ambiente3;
          Texture Play,Configuration;
          Sprite PlayS,ConfigurationS;

     /*****************/
     public Casa(MyGdxGame game) {
         this.game = game;
         batch = new SpriteBatch();
         world = new World(new Vector2(0, -12), true);
         world.setContactListener(new WorldContactListener());

         ray = new RayHandler(world);
         ray.setAmbientLight(1f);
         cam = new OrthographicCamera();
         viewport = new FitViewport(500 / Pixels, 250 / Pixels, cam);//240,140
         stage = new Stage(viewport, batch);//65
         ///////////////////////////////////////////////////////////////////////////////////////////////
         ikuno = new Texture("Ikuno2.png");
         ikunoS = new Sprite(ikuno);
         ambiente = new ParticleEffect();
         ambiente.load(Gdx.files.internal("particles/ambiente.p"),Gdx.files.internal("images"));
         ambiente.scaleEffect(.3f/Pixels);
         ambiente2 = new ParticleEffect();
         ambiente2.load(Gdx.files.internal("particles/ambiente.p"),Gdx.files.internal("images"));
         ambiente2.scaleEffect(.4f/Pixels);
         ambiente3 = new ParticleEffect();
         ambiente3.load(Gdx.files.internal("particles/ambiente.p"),Gdx.files.internal("images"));
         ambiente3.scaleEffect(.3f/Pixels);
         Play = new Texture("Play.png");
         PlayS = new Sprite(Play);
         Configuration = new Texture("Configuration.png");
         ConfigurationS = new Sprite(Configuration);
         play = new Rectangle();
         confi = new Rectangle();
         Puntero = new Rectangle();
     }

     @Override
     public void show() {
 Gdx.input.setCatchBackKey(true);
     }

     @Override
     public void render(float delta) {
         time = Gdx.graphics.getDeltaTime();
         Gdx.gl.glClearColor(0,0,0,1);
         Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
         Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);


         batch.enableBlending();
         cam.update();
         stage.act(delta);
         cam.position.x = 0+(500/Pixels)/2;
         cam.position.y = 0+(250/Pixels)/2;
         cam.update();
         Gdx.input.setInputProcessor(stage);
         stage.draw();
         ray.update();
         ray.setCombinedMatrix(cam.combined);
         ray.render();
         batch.begin();
         
         if(y < 49)
         {
             Alpha2 = 0;
             if(Gdx.input.isTouched())
             {
                 y = y + 50 * Gdx.graphics.getDeltaTime();
             }else {
                 y = y + 10 * Gdx.graphics.getDeltaTime();
             }
         }else
         {
             Alpha2 += .25f*Gdx.graphics.getDeltaTime();
             if(Alpha2 > .2f && Gdx.input.isTouched())
             {
                 Alpha2 = 1.1f;
             }
             if(Alpha2 > 1)
             {
                 Alpha2 = 1;
                 play.set(150/Pixels,25/Pixels,50/Pixels,50/Pixels);
                 confi.set(300/Pixels,25/Pixels,50/Pixels,50/Pixels);
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
                 Puntero.set(PunteroPosition.x-(5/Pixels),PunteroPosition.y-(5/Pixels),10/Pixels,10/Pixels);

                 if(Puntero.overlaps(play))
                 {
                     game.setScreen(new AldeaCinematicaCasa(game));
                 }
                 if(Puntero.overlaps(confi))
                 {
                     game.setScreen(new Configuraciones(game));
                 }
             }
         }
         ikunoS.setBounds(0,y/Pixels,500/Pixels,250/Pixels);
         if(Gdx.input.isTouched())
         {

         }else
         {
             Alpha += .50f*Gdx.graphics.getDeltaTime();
         }

         if(Alpha > 1)
         {
             Alpha = 1;
         }

         ambiente.setPosition(350/Pixels,50/Pixels);
         ambiente.draw(batch,time);
         ambiente2.setPosition(150/Pixels,0);
         ambiente2.draw(batch,time);
         ambiente3.setPosition(80/Pixels,0);
         ambiente3.draw(batch,time);
         ambiente.update(delta);
         ambiente2.update(delta);
         ambiente3.update(delta);
         ikunoS.setAlpha(Alpha);
         ikunoS.draw(batch);

         PlayS.setBounds(150/Pixels,25/Pixels,50/Pixels,50/Pixels);
         PlayS.setAlpha(Alpha2);
         PlayS.draw(batch);
         ConfigurationS.setBounds(300/Pixels,25/Pixels,50/Pixels,50/Pixels);
         ConfigurationS.setAlpha(Alpha2);
         ConfigurationS.draw(batch);
         batch.end();


     }

     public void ScreenSend()
     {

         /*****************/
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
         stage.dispose();
         world.dispose();
         ray.dispose();
         ikuno.dispose();
         ambiente.dispose();
         ambiente2.dispose();
         ambiente3.dispose();
         Play.dispose();
         Configuration.dispose();

     }
 }
