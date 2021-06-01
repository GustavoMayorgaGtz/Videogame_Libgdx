 package com.mygdx.game;

 import com.badlogic.gdx.Gdx;
 import com.badlogic.gdx.Screen;
 import com.badlogic.gdx.graphics.GL20;
 import com.badlogic.gdx.graphics.OrthographicCamera;
 import com.badlogic.gdx.graphics.Texture;
 import com.badlogic.gdx.graphics.g2d.Animation;
 import com.badlogic.gdx.graphics.g2d.Sprite;
 import com.badlogic.gdx.graphics.g2d.SpriteBatch;
 import com.badlogic.gdx.graphics.g2d.TextureRegion;
 import com.badlogic.gdx.maps.tiled.TiledMap;
 import com.badlogic.gdx.maps.tiled.TmxMapLoader;
 import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
 import com.badlogic.gdx.math.Vector2;
 import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
 import com.badlogic.gdx.physics.box2d.World;
 import com.badlogic.gdx.scenes.scene2d.Stage;
 import com.badlogic.gdx.utils.viewport.FitViewport;
 import com.badlogic.gdx.utils.viewport.Viewport;
 import com.mygdx.game.tiled.AddActors;
 import com.mygdx.game.tiled.AddResources;
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
     Texture t;
     int c = 1, r = 5;
     float time;
     Animation<TextureRegion> a;

     /****************/
     public static boolean isScreenUp= false;
     public static boolean isScreenDown = true;
     Texture PantallaSend;
     public static float posicionY = 500;
     int iteratorPantalla;
     float timePantalla;
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

         t = new Texture("Inicio.png");
           TextureRegion[][]FramesAnimation = TextureRegion.split(t,t.getWidth()/c,t.getHeight()/r);
           TextureRegion[]TmpAnimation = new TextureRegion[c * r];
           int index1 = 0;
           for(int i =0 ; i < r; i++)
           {
               for(int j = 0; j < c; j++)
               {
                   TmpAnimation[index1++] = FramesAnimation[i][j];
               }
           }
           a = new Animation<TextureRegion>(0.2f,TmpAnimation);


         PantallaSend = new Texture("ScreenSend.png");
     }

     @Override
     public void show() {
 Gdx.input.setCatchBackKey(true);
     }

     @Override
     public void render(float delta) {
         time += Gdx.graphics.getDeltaTime();
         Gdx.gl.glClearColor(1,1,1,1);
         Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
         Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
TextureRegion current = a.getKeyFrame(time,true);

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
         batch.draw(current,0,0,500/Pixels,250/Pixels);
         ScreenSend();
         isScreenDown = true;
         if(Gdx.input.isTouched()&&!isScreenUp)
         {
             isScreenUp = true;
         }
         batch.end();
/***************/
         if(Gdx.input.isTouched())
         {
             isScreenTouched = true;
         }
         if(isScreenTouched)
         {
             MyGdxGame.Cinematica.putInteger("Cinematica",1);
             MyGdxGame.Cinematica.flush();
             alpha -= .5f * Gdx.graphics.getDeltaTime();
         }else {
             alpha = 1;
                 MyGdxGame.Cinematica.putInteger("Cinematica",1);
                 MyGdxGame.Cinematica.flush();
             
         }
         if(alpha <= 0)
         {
             alpha = 0;
         }
/*****************/
     }

     public void ScreenSend()
     {
         if(!isScreenUp)
         {
             isScreenDown = true;
         }else
         {
             isScreenDown = false;
         }
         if(isScreenUp == true)
         {

             if(iteratorPantalla == 0) {
                 posicionY = 500;
                 iteratorPantalla++;
             }
             if(posicionY > 160)
             {
                 posicionY -= 250 *Gdx.graphics.getDeltaTime();
             }else
             {
                 game.setScreen(new Nivel1Progresion(game));
                 posicionY = 160;
                 isScreenUp = false;
             }
         }
         if(isScreenDown == true)
         {
             if(iteratorPantalla == 0) {
                 posicionY = 240;
                 iteratorPantalla++;
             }
             timePantalla += 1 *Gdx.graphics.getDeltaTime();
             if(timePantalla > 1) {
                 if (posicionY < 500) {
                     posicionY += 150 * Gdx.graphics.getDeltaTime();
                 } else {
                     timePantalla = 0;
                     posicionY = 500;
                     isScreenDown = false;
                 }
             }
         }
         batch.draw(PantallaSend,cam.position.x - 8.5f, cam.position.y - 2.5f-(posicionY/Pixels),700/Pixels,450/Pixels);
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
t.dispose();
         batch.dispose();
         stage.dispose();

         world.dispose();

         ray.dispose();

     }
 }
