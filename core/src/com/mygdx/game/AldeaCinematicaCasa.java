 package com.mygdx.game;

 import com.badlogic.gdx.Gdx;
 import com.badlogic.gdx.Screen;
 import com.badlogic.gdx.graphics.Color;
 import com.badlogic.gdx.graphics.GL20;
 import com.badlogic.gdx.graphics.Texture;
 import com.badlogic.gdx.graphics.g2d.Animation;
 import com.badlogic.gdx.graphics.g2d.BitmapFont;
 import com.badlogic.gdx.graphics.g2d.Sprite;
 import com.badlogic.gdx.graphics.g2d.SpriteBatch;
 import com.badlogic.gdx.graphics.g2d.TextureRegion;
 import com.badlogic.gdx.maps.tiled.TiledMap;
 import com.badlogic.gdx.maps.tiled.TmxMapLoader;
 import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
 import com.badlogic.gdx.scenes.scene2d.ui.Container;
 import com.badlogic.gdx.scenes.scene2d.ui.Label;
 import com.mygdx.game.actors.Jugador;
 import com.mygdx.game.tiled.AddActors;
 import com.mygdx.game.tiled.AddResources;
 import com.mygdx.game.tiled.AddResourcesOfMenu;

 import static com.mygdx.game.MyGdxGame.Pixels;

 public class AldeaCinematicaCasa implements Screen {


     MyGdxGame game;
     private TmxMapLoader mapLoader;
     private TiledMap map;
     private OrthogonalTiledMapRenderer renderer;

     AddActors add;
     AddResources addR;
     SpriteBatch batch;
     Texture fondoAnimado;
     Animation<TextureRegion> fondoAnimation;
     int c = 1, r = 3;

     Texture Dormir;
     Animation<TextureRegion> dormirAnimation;
     int c1 = 1, r1 = 32;
     float time;

     Sprite PantallaNegra;
     Texture Negro;
     float AlphaPantallaNegro = 1;

     float empezar = 0;
     public static Container container;
     public static Label label;
     BitmapFont b = new BitmapFont();
     float charla;
     int seleccionarCharla;


     public AldeaCinematicaCasa(MyGdxGame game) {

         this.game = game;
         mapLoader = new TmxMapLoader();
         map = mapLoader.load("AldeaCinematicaCasa.tmx");

         ///////////////////////////////////////////////////////////////////////////////////////////////
         addR = new AddResources();

         add = new AddActors(addR.world,map,game);
         // add = new AddActors(addR.world,map2,game,addR.stage);
         renderer = new OrthogonalTiledMapRenderer(map,1/Pixels);

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
/////////////////////
         Dormir = new Texture("mimido.png");
         TextureRegion[][] TmpMimir = TextureRegion.split(Dormir,Dormir.getWidth()/c1,Dormir.getHeight()/r1);
         TextureRegion[] FramesMimir = new TextureRegion[c1 * r1];
         int index1 = 0;
         for(int i = 0; i < r1; i++)
         {
             for(int j = 0; j < c1; j++)
             {
                 FramesMimir[index1++] = TmpMimir[i][j];
             }
         }
         dormirAnimation = new Animation<TextureRegion>(0.3f,FramesMimir);
         Negro = MyGdxGame.getManager().get("Negro.png");
         PantallaNegra = new Sprite(Negro);
         label = new Label("",new Label.LabelStyle(new BitmapFont(), Color.WHITE));
         container = new Container<Label>(label);
         container.setTransform(true);
         b.setColor(Color.WHITE);
         b.getData().setScale(2);
 }

     @Override
     public void show() {
 Gdx.input.setCatchBackKey(true);
     }


     public void update(float d)
     {
         addR.cam.update();renderer.setView(addR.cam.combined,addR.cam.position.x-((240/Pixels)),addR.cam.position.y-(140/Pixels),(240/ Pixels)*2, (140/Pixels)*2);

     }

     @Override
     public void render(float delta) {

         MyGdxGame.isAldeaCinematica = true;
         update(delta);
         Gdx.gl.glClearColor(.0f,.0f,.0f,1);
         Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
         MyGdxGame.isNivelProgress1 = false;
         MyGdxGame.isIsNivelProgress2 = false;
         update(delta);
         AddResources.addRender(delta);
         renderer.render();
         AddResources.stage.draw();
         addR.batchFunctions();
         TextureRegion current = dormirAnimation.getKeyFrame(time,false);
         AddResourcesOfMenu.SelectLevel = -2;

         batch.begin();
         if(empezar >= 10) {
             time += Gdx.graphics.getDeltaTime();

             float x = Jugador.body.getPosition().x * 30;
             float y = Jugador.body.getPosition().y * 30;


             if (dormirAnimation.isAnimationFinished(time)) {
                 //Gdx.app.log("Tiempo","false");
                 Jugador.noDibujar = false;
                 AddResources.EsconderControles = false;
              /*   label.setText("Desperte...");
                 label.setWrap(true);
                 //label.setPosition(x,y);
                 //container.setBounds(x,y,28,10);
                 container.setPosition(x + 175, y - 40);//+5,+3,7,5
                 container.setScale(.5f);
                 addR.stage2.addActor(container);*/
                 charla += 1 * Gdx.graphics.getDeltaTime();
                 if(charla <= 1.5f)
                 {
                     b.draw(batch,"Desperté...",x + 175, y+150);
                 }else if(charla <= 3)
                 {
                     b.draw(batch,"¿Estoy solo en casa?",x + 175, y+150);
                 } else if (charla <= 4.5f) {

                     b.draw(batch,"Debería salir a buscar a Olivia, puede que necesite ayuda",x + 100, y+150);
                 }


             } else {
                 batch.draw(current, x + 175, y - 75, 160f, 120);
                 Jugador.noDibujar = true;
                 AddResources.EsconderControles = true;
             }
             PantallaNegra.setBounds(0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
             PantallaNegra.setAlpha(AlphaPantallaNegro);
             PantallaNegra.draw(batch);
             if (AlphaPantallaNegro > 0) {
                 AlphaPantallaNegro -= .4f * Gdx.graphics.getDeltaTime();
             } else {
                 AlphaPantallaNegro = 0;
             }

         }else
         {
             empezar += .90 * Gdx.graphics.getDeltaTime();
             batch.draw(Negro,0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
         } 

         batch.end();
         addR.stage2.draw();
/*******************************ACT******************************/



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
b.dispose();
         add.AddDetach();
         fondoAnimado.dispose();
         addR.detachResources();
        batch.dispose();
     }
 }
