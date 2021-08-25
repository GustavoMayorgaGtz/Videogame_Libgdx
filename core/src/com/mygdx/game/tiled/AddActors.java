package com.mygdx.game.tiled;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Nivel2;
import com.mygdx.game.actors.Agarradera;
import com.mygdx.game.actors.ArbolAzul;
import com.mygdx.game.actors.ArbolRosa;
import com.mygdx.game.actors.ArbolVerde;
import com.mygdx.game.actors.Button1;
import com.mygdx.game.actors.Button2;
import com.mygdx.game.actors.Fuego;
import com.mygdx.game.actors.Jugador;
import com.mygdx.game.actors.Pincho;
import com.mygdx.game.actors.PisoTime;
import com.mygdx.game.actors.RayoFuego;
import com.mygdx.game.actors.Sierra1;
import com.mygdx.game.actors.Sierra2;
import com.mygdx.game.actors.Sierra3;
import com.mygdx.game.actors.Sierra4;
import com.mygdx.game.actors.Sierra5;
import com.mygdx.game.actors.Tierra1;
import com.mygdx.game.actors.particulas;

import java.util.ArrayList;
import java.util.List;

import static com.mygdx.game.MyGdxGame.Pixels;
import static com.mygdx.game.MyGdxGame.tierra1;

public class AddActors {
    World world;
    TiledMap map;
    public static Jugador player;
    public static Button1 button;
    public static Button2 button2;
    public static Sierra1 s1;
    public static Sierra2 s2;
    public static Sierra3 s3;
    public static Sierra4 s4;
    public static Sierra5 s5;
    public static ArbolVerde arbolV;
    public static ArbolRosa arbolR;
    public static ArbolAzul arbolA;

    int index = 0;

    private List<BloquesRompibles> bloquesrompibles = new ArrayList<BloquesRompibles>();
    private List<Tienda> tienda = new ArrayList<Tienda>();
    int interatorBloques = 0;
    private List<CamaraY> cameraY = new ArrayList<CamaraY>();
    private List<CamaraNoY> cameraNoY = new ArrayList<CamaraNoY>();
    private List<CamaraNoX> cameraNoX = new ArrayList<CamaraNoX>();
    private List<CamaraX> cameraX = new ArrayList<CamaraX>();
    private List<PlataformaMovimiento> plataformaMov = new ArrayList<PlataformaMovimiento>();
    private List<Pincho> pincho = new ArrayList<Pincho>();
    private List<Agarradera> agarradera = new ArrayList<Agarradera>();
    private List<PisoAgarradera> pisoAgarradera = new ArrayList<PisoAgarradera>();
    private List<PisoTime> pisoTime = new ArrayList<PisoTime>();
    private List<particulas> p = new ArrayList<particulas>();
    private List<Fuego> fuego = new ArrayList<Fuego>();
    private List<Nemesis1> nemesis1 = new ArrayList<>();
    private List<EnemigoWalk> enemy1 = new ArrayList<EnemigoWalk>();
    private List<EnemigoJump> enemy2 = new ArrayList<EnemigoJump>();
    private List<EnemigoVolador> enemy3 = new ArrayList<EnemigoVolador>();
    private List<in>in = new ArrayList<in>();
    public static Vector2[] coordenadasPortal;
    private List<Coins>coin = new ArrayList<Coins>();
    private List<Aplastador> aplastador = new ArrayList<Aplastador>();
    private List<ButtonObjects> button1 = new ArrayList<ButtonObjects>();
    private List<ButtonObjects2> button3 = new ArrayList<ButtonObjects2>();
    private List<PinchosGravity> pinchoG = new ArrayList<PinchosGravity>();
    private List<PlataformaCirucularObject> agarraderaCircular = new ArrayList<PlataformaCirucularObject>();
    private List<RayoFuego> rayoDown = new ArrayList<RayoFuego>();
    private List<ScreenSend> setScreen = new ArrayList<ScreenSend>();
    private List<Parajo> P = new ArrayList<Parajo>();
    private List<LD2> ld2 = new ArrayList<LD2>();
    private List<LU2> lu2 = new ArrayList<LU2>();
    private List<RD2> rd2 = new ArrayList<RD2>();
    private List<RU2> ru2 = new ArrayList<RU2>();
    private List<PisoButton2> piso2 = new ArrayList<PisoButton2>();
    private List<ParedesButton2> pared2 = new ArrayList<ParedesButton2>();


    public static int i = 0;
    public static  MyGdxGame game;

    int iterator = 0;
    int iterator2 = 0;
    int iterator3 = 0;
    int iterator4 = 0;
    int iteratorCamY = 0;
    int iteratorNoCamY = 0;
    int iteratorNoCamX = 0;
    int iteratorCamX = 0;
    int iteratorNoBuild = 0;
    int iteratorBuild = 0;
    int itereratorNemesis1 = 0;
   public static int iteratorpisos = 0;
    List<Cajas> cajas = new ArrayList<Cajas>();
    public AddActors(World world, TiledMap map,MyGdxGame game)
    {
        this.game = game;
        this.map = map;
        Texture dere = MyGdxGame.getManager().get("WalkRight.png");
        Texture izq = MyGdxGame.getManager().get("WalkLeft.png");
        Texture SaltoIzq = MyGdxGame.getManager().get("SaltoL.png");
        Texture SaltoDere = MyGdxGame.getManager().get("SaltoR.png");
        Texture StaticLeft = MyGdxGame.getManager().get("PSL.png");
        Texture StaticRight = MyGdxGame.getManager().get("PSD.png");
        Texture EspadazoDereTexture = MyGdxGame.getManager().get("PersonajeEspadazoDerecho.png");
        Texture EspadazoIzqTexture = MyGdxGame.getManager().get("PersonajeEspadazoIzquierdo.png");
        Texture PersonajeKill = MyGdxGame.getManager().get("PersonajeKill.png");
        Texture Dormir = MyGdxGame.getManager().get("mimido.png");
        Texture sword = MyGdxGame.getManager().get("EspadazoEffect.png");
        Texture sword2 = MyGdxGame.getManager().get("EspadazoEffectIzq.png");
       try {
            /////Cosas hechas para los niveles de progresion
            Texture arbolVerde = MyGdxGame.getManager().get("HojaVerdeCartel.png");


           for (MapObject object : map.getLayers().get(50).getObjects().getByType(RectangleMapObject.class)) {
               Rectangle rect = ((RectangleMapObject) object).getRectangle();
               cameraNoX.add(new CamaraNoX(world, map, rect, iteratorNoCamX));
               iteratorNoCamX++;
           }

           for (CamaraNoX cam : cameraNoX) {
               AddResources.stage.addActor(cam);
           }
           for (MapObject object : map.getLayers().get(54).getObjects().getByType(RectangleMapObject.class)) {
               Rectangle rect = ((RectangleMapObject) object).getRectangle();
               cameraX.add(new CamaraX(world, map, rect, iteratorCamX));
               iteratorCamX++;
           }

           for (CamaraX cam : cameraX) {
               AddResources.stage.addActor(cam);
           }


            for (MapObject object : map.getLayers().get(4).getObjects().getByType(RectangleMapObject.class)) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();
                player = new Jugador(world, dere, izq, SaltoDere, SaltoIzq, StaticRight, StaticLeft, EspadazoDereTexture, EspadazoIzqTexture, PersonajeKill, Dormir,sword,sword2, rect.x, rect.y);//300 , 400

            }
           AddResources.stage.addActor(player);
            for (MapObject object : map.getLayers().get(1).getObjects().getByType(RectangleMapObject.class)) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();
                new Paredes(world, map, rect);
            }
            for (MapObject object : map.getLayers().get(2).getObjects().getByType(RectangleMapObject.class)) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();
                new Piso(world, map, rect);
            }
           if(MyGdxGame.isIsNivelProgress2) {
               Tierra1.rects = new ArrayList<Rectangle>();
               Tierra1.noBuild = new ArrayList<>();
               Tierra1.Build = new ArrayList<>();

               for (MapObject object : map.getLayers().get(2).getObjects().getByType(RectangleMapObject.class)) {
                   Rectangle rect = ((RectangleMapObject) object).getRectangle();
                   Tierra1.rects.add(iteratorpisos, new Rectangle(rect.x / Pixels, rect.y / Pixels, rect.width / Pixels, (rect.height +10f)  / Pixels));
                   //Gdx.app.log("Si paso por aqui", "trueeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
                   iteratorpisos++;
               }
               for (MapObject object : map.getLayers().get(55).getObjects().getByType(RectangleMapObject.class)) {
                   Rectangle rect = ((RectangleMapObject) object).getRectangle();
                   Tierra1.noBuild.add(iteratorNoBuild, new Rectangle(rect.x / Pixels, rect.y / Pixels, rect.width / Pixels, (rect.height +10f)  / Pixels));
                   iteratorNoBuild++;
               }
               for (MapObject object : map.getLayers().get(56).getObjects().getByType(RectangleMapObject.class)) {
                   Rectangle rect = ((RectangleMapObject) object).getRectangle();
                   Tierra1.Build.add(iteratorBuild, new Rectangle(rect.x / Pixels, rect.y / Pixels, rect.width / Pixels, (rect.height +10f)  / Pixels));
                   iteratorBuild++;
               }
           }
           try {
               Texture Nemesis1, Nemesis2, Nemesis3, Nemesis4, Nemesis5, Nemesis6;
               Nemesis1 = MyGdxGame.getManager().get("Nemesis1/Derecha.png");
               Nemesis2 = MyGdxGame.getManager().get("Nemesis1/Izquierda.png");
               Nemesis3 = MyGdxGame.getManager().get("Nemesis1/IzqAttack.png");
               Nemesis4 = MyGdxGame.getManager().get("Nemesis1/DereAttack.png");
               Nemesis5 = MyGdxGame.getManager().get("Nemesis1/MuerteIzq.png");
               Nemesis6 = MyGdxGame.getManager().get("Nemesis1/MuerteDere.png");
               for (MapObject object : map.getLayers().get(57).getObjects().getByType(RectangleMapObject.class)) {
                   Rectangle rect = ((RectangleMapObject) object).getRectangle();
                   nemesis1.add(new Nemesis1(world, map, rect, Nemesis2, Nemesis1, Nemesis3, Nemesis4, Nemesis5, Nemesis6, itereratorNemesis1));
               }
               for (Nemesis1 nemesis1 : nemesis1) {
                   AddResources.stage.addActor(nemesis1);
               }
           }catch(Exception e)
           {
    Gdx.app.log("Error Nemesis","Linea 205"+e.getMessage());
           }
            for (MapObject object : map.getLayers().get(3).getObjects().getByType(RectangleMapObject.class)) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();
                new Techo(world, map, rect);
            }

            Texture pico = MyGdxGame.getManager().get("pincho.png");
            for (MapObject object : map.getLayers().get(5).getObjects().getByType(RectangleMapObject.class)) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();
                pincho.add(new Pincho(world, pico, rect.x, rect.y));
            }


            for (Pincho p : pincho) {
                AddResources.stage.addActor(p);
            }

            Texture Aizq = MyGdxGame.getManager().get("AgarraderaIzq.png");
            Texture Adere = MyGdxGame.getManager().get("Adere.png");
            Texture Agarradera = MyGdxGame.getManager().get("Agarradera.png");

            for (MapObject object : map.getLayers().get(7).getObjects().getByType(RectangleMapObject.class)) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();
                agarradera.add(new Agarradera(world, Aizq, rect.x, rect.y));
            }


            for (MapObject object : map.getLayers().get(8).getObjects().getByType(RectangleMapObject.class)) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();
                agarradera.add(new Agarradera(world, Adere, rect.x, rect.y));
            }

            for (MapObject object : map.getLayers().get(36).getObjects().getByType(RectangleMapObject.class)) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();
                agarradera.add(new Agarradera(world, Agarradera, rect.x, rect.y));
            }

            for (Agarradera agarradera : agarradera) {
                AddResources.stage.addActor(agarradera);
            }

            Texture timeT = MyGdxGame.getManager().get("pisoTime.png");
            Texture timeT2 = MyGdxGame.getManager().get("pisoTimeDes.png");
            for (MapObject object : map.getLayers().get(9).getObjects().getByType(RectangleMapObject.class)) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();
                pisoTime.add(new PisoTime(world, timeT, timeT2, rect.x, rect.y));
            }
            for (PisoTime pisoTime : pisoTime) {
                AddResources.stage.addActor(pisoTime);
            }
            ////////////////////
            Music music1 = MyGdxGame.getManager().get("greatBeattle.ogg", Music.class);
            //music1.play();
            music1.setVolume(0.5f);
            music1.setLooping(true);
       /* for(MapObject object : map.getLayers().get(10).getObjects().getByType(RectangleMapObject.class))
        {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            p.add(new particulas("particles/ambiente.p","images",rect.x, rect.y,0.15f));

        }
        for(particulas p : p)
        {
          stage.addActor(p);
        }*/
            //////////////////

            Texture sierraTexture = MyGdxGame.getManager().get("sierra.png");

            for (MapObject object : map.getLayers().get(12).getObjects().getByType(RectangleMapObject.class)) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();
                switch (index) {
                    case 0: {
                        s1 = new Sierra1(world, sierraTexture, rect.x, rect.y);
                        AddResources.stage.addActor(s1);
                        break;
                    }
                    case 1: {
                        s2 = new Sierra2(world, sierraTexture, rect.x, rect.y);
                        AddResources.stage.addActor(s2);
                        break;
                    }
                    case 2: {
                        s3 = new Sierra3(world, sierraTexture, rect.x, rect.y);
                        AddResources.stage.addActor(s3);
                        break;
                    }
                    case 3: {
                        s4 = new Sierra4(world, sierraTexture, rect.x, rect.y);
                        AddResources.stage.addActor(s4);
                        break;
                    }
                    case 4: {
                        s5 = new Sierra5(world, sierraTexture, rect.x, rect.y);
                        AddResources.stage.addActor(s5);
                        break;
                    }
                }
                index++;
            }

            for (MapObject object : map.getLayers().get(13).getObjects().getByType(RectangleMapObject.class)) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();

                new RD(world, map, rect);
                new RD1(world, map, rect);
                new RD2Enemy(world, map, rect);
            }
            //////////////
            for (MapObject object : map.getLayers().get(14).getObjects().getByType(RectangleMapObject.class)) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();
                new RU(world, map, rect);
                new RU1(world, map, rect);
            }
            ////////////
            for (MapObject object : map.getLayers().get(15).getObjects().getByType(RectangleMapObject.class)) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();
                new LU(world, map, rect);
                new LU1(world, map, rect);
            }
            //////////
            for (MapObject object : map.getLayers().get(16).getObjects().getByType(RectangleMapObject.class)) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();
                new LD(world, map, rect);
                new LD1(world, map, rect);
                new LD2Enemy(world, map, rect);

            }
            /**********COLISIONES **********/
            for (MapObject object : map.getLayers().get(39).getObjects().getByType(RectangleMapObject.class)) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();
                ld2.add(new LD2(world, map, rect));
            }
            for (LD2 ld2 : ld2) {
                AddResources.stage.addActor(ld2);
            }

            for (MapObject object : map.getLayers().get(40).getObjects().getByType(RectangleMapObject.class)) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();
                lu2.add(new LU2(world, map, rect));
            }
            for (LU2 lu2 : lu2) {
                AddResources.stage.addActor(lu2);
            }
            for (MapObject object : map.getLayers().get(41).getObjects().getByType(RectangleMapObject.class)) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();
                rd2.add(new RD2(world, map, rect));
            }
            for (RD2 rd2 : rd2) {
                AddResources.stage.addActor(rd2);
            }
            for (MapObject object : map.getLayers().get(42).getObjects().getByType(RectangleMapObject.class)) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();
                ru2.add(new RU2(world, map, rect));
            }
            for (RU2 ru2 : ru2) {
                AddResources.stage.addActor(ru2);
            }
            /*********************************/
            /***********Pisos del Boton 2 (azul)**********/
            for (MapObject object : map.getLayers().get(43).getObjects().getByType(RectangleMapObject.class)) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();
                piso2.add(new PisoButton2(world, map, rect));
            }
            for (PisoButton2 piso2 : piso2) {
                AddResources.stage.addActor(piso2);
            }
            for (MapObject object : map.getLayers().get(44).getObjects().getByType(RectangleMapObject.class)) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();
                pared2.add(new ParedesButton2(world, map, rect));
            }
            for (ParedesButton2 pared2 : pared2) {
                AddResources.stage.addActor(pared2);
            }
            /********************************************/
            ////////////
            Texture fuegoTexture = MyGdxGame.getManager().get("Fuego.png");
            for (MapObject object : map.getLayers().get(18).getObjects().getByType(RectangleMapObject.class)) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();
                fuego.add(new Fuego(world, fuegoTexture, rect.x, rect.y));
            }
            for (Fuego fuego : fuego) {
                AddResources.stage.addActor(fuego);
            }
///////////////////
            for (MapObject object : map.getLayers().get(19).getObjects().getByType(RectangleMapObject.class)) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();
                new ParedED(world, map, rect);

            }
////////////////
            for (MapObject object : map.getLayers().get(20).getObjects().getByType(RectangleMapObject.class)) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();
                new ParedEI(world, map, rect);

            }
            //////////
            for (MapObject object : map.getLayers().get(21).getObjects().getByType(RectangleMapObject.class)) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();
                new ParedMuerte(world, map, rect);

            }
            ///////////
            Texture Enemy3Left = MyGdxGame.getManager().get("EnemigoVoladorDere.png");
            Texture Enemy3Right = MyGdxGame.getManager().get("EnemigoVoladorIzq.png");


            for (MapObject object : map.getLayers().get(45).getObjects().getByType(RectangleMapObject.class)) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();
                enemy3.add(new EnemigoVolador(world, rect, Enemy3Left, Enemy3Right, iterator2));
                iterator2++;
            }

            for (EnemigoVolador enemy3 : enemy3) {

                AddResources.stage.addActor(enemy3);
            }
            Texture Enemy1Left = MyGdxGame.getManager().get("EnemigoRight2.png");
            Texture Enemy1Right = MyGdxGame.getManager().get("EnemigoLeft.png");
            Texture Enemy2Left = MyGdxGame.getManager().get("Enemigo2Left.png");
            Texture Enemy2Right = MyGdxGame.getManager().get("Enemigo2Right.png");
            Texture Enemy1KillLeft = MyGdxGame.getManager().get("E1KL.png");
            Texture Enemy1KillRight = MyGdxGame.getManager().get("E1KR.png");
            Texture Enemy2KillLeft = MyGdxGame.getManager().get("E2KL.png");
            Texture Enemy2KillRight = MyGdxGame.getManager().get("E2KR.png");

            for (MapObject object : map.getLayers().get(22).getObjects().getByType(RectangleMapObject.class)) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();
                enemy1.add(new EnemigoWalk(world, map, rect, Enemy1Left, Enemy1Right, Enemy2Left, Enemy2Right, Enemy1KillLeft, Enemy1KillRight, Enemy2KillLeft, Enemy2KillRight, iterator));
                iterator++;
            }

            for (EnemigoWalk enemy1 : enemy1) {

                AddResources.stage.addActor(enemy1);
            }
            //////////////
            Texture ButtonObjectTexture = MyGdxGame.getManager().get("Cubo.png");
            Texture texture2 = MyGdxGame.getManager().get("CuboS(1).png");
            for (MapObject object : map.getLayers().get(23).getObjects().getByType(RectangleMapObject.class)) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();
                button1.add(new ButtonObjects(world, map, rect, ButtonObjectTexture, texture2));
            }
            for (ButtonObjects button1 : button1) {
                AddResources.stage.addActor(button1);
            }
            for (MapObject object : map.getLayers().get(34).getObjects().getByType(RectangleMapObject.class)) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();
                button3.add(new ButtonObjects2(world, map, rect, ButtonObjectTexture, texture2));
            }
            for (ButtonObjects2 button3 : button3) {
                AddResources.stage.addActor(button3);
            }
            //////////
            Texture ButtonOn = MyGdxGame.getManager().get("BotonM.png");
            Texture ButtonOff = MyGdxGame.getManager().get("BotonMP.png");
            Texture ButtonOn2 = MyGdxGame.getManager().get("BotonM(2).png");
            Texture ButtonOff2 = MyGdxGame.getManager().get("BotonMP(1).png");
            for (MapObject object : map.getLayers().get(24).getObjects().getByType(RectangleMapObject.class)) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();
                button = new Button1(world, ButtonOn, ButtonOff, rect.x, rect.y);
                AddResources.stage.addActor(button);
            }
            for (MapObject object : map.getLayers().get(33).getObjects().getByType(RectangleMapObject.class)) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();
                button2 = new Button2(world, ButtonOn2, ButtonOff2, rect.x, rect.y);//Boton azul
                AddResources.stage.addActor(button2);
            }
//////////
            Texture aplastadorGreen = MyGdxGame.getManager().get("PisoGreen/PisoGreenAplastador.png");
            for (MapObject object : map.getLayers().get(25).getObjects().getByType(RectangleMapObject.class)) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();
                aplastador.add(new Aplastador(world, rect, aplastadorGreen));
            }
            for (Aplastador aplastador : aplastador) {
                AddResources.stage.addActor(aplastador);

            }
            //////////
            Texture pinchosGravityTxture = MyGdxGame.getManager().get("PinchosGravity.png");
            for (MapObject object : map.getLayers().get(26).getObjects().getByType(RectangleMapObject.class)) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();
                pinchoG.add(new PinchosGravity(world, rect, pinchosGravityTxture));
            }
            for (PinchosGravity pinchoG : pinchoG) {
                AddResources.stage.addActor(pinchoG);
            }
            ///////////
            Texture plataformaCir = MyGdxGame.getManager().get("PlataformaCir.png");
            Texture Punto = MyGdxGame.getManager().get("Punto.png");
            Texture Center = MyGdxGame.getManager().get("center.png");
            for (MapObject object : map.getLayers().get(27).getObjects().getByType(RectangleMapObject.class)) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();
                agarraderaCircular.add(new PlataformaCirucularObject(world, rect.x, rect.y, plataformaCir, Punto, Center));
            }
            for (PlataformaCirucularObject pm : agarraderaCircular) {
                AddResources.stage.addActor(pm);
            }
            //////////////

            for (MapObject object : map.getLayers().get(28).getObjects().getByType(RectangleMapObject.class)) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();
                enemy2.add(new EnemigoJump(world, map, rect, Enemy1Left, Enemy1Right, Enemy2Left, Enemy2Right, Enemy1KillLeft, Enemy1KillRight, Enemy2KillLeft, Enemy2KillRight, iterator));
            }
            for (EnemigoJump enemy2 : enemy2) {

                AddResources.stage.addActor(enemy2);
            }
/////////
            for (MapObject object : map.getLayers().get(29).getObjects().getByType(RectangleMapObject.class)) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();
                rayoDown.add(new RayoFuego(world, rect.x, rect.y));

            }
            for (RayoFuego rayoDown : rayoDown) {
                AddResources.stage.addActor(rayoDown);
            }
            //////////
            Texture staticb = MyGdxGame.getManager().get("Bloquerompible.png");
            Texture animationbloque = MyGdxGame.getManager().get("BRAnimation.png");
            for (MapObject object : map.getLayers().get(48).getObjects().getByType(RectangleMapObject.class)) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();
                Gdx.app.log("Bloques rompibles on",""+rect.x);
                bloquesrompibles.add(new BloquesRompibles(world,staticb,animationbloque,interatorBloques,rect.x/ Pixels,rect.y/ Pixels));
                interatorBloques++;
            }
            for (BloquesRompibles br : bloquesrompibles) {
                AddResources. stage.addActor(br);
            }
            /**********/

/******************/

            Texture portal = MyGdxGame.getManager().get("Portal.png");
            for (MapObject object : map.getLayers().get(30).getObjects().getByType(RectangleMapObject.class)) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();
                // new in(world,map,rect,portal);
                in.add(new in(world, map, rect, portal));
            }

            for (in in : in) {
                AddResources.stage.addActor(in);
            }
            coordenadasPortal = new Vector2[i];
            int ite = 0;
            for (MapObject object : map.getLayers().get(31).getObjects().getByType(RectangleMapObject.class)) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();
                coordenadasPortal[ite] = new Vector2(rect.x, rect.y);
                //Gdx.app.log("Valoooooor de Arreglo",""+coordenadasPortal[ite].x);
                ite++;

            }
            //   Gdx.app.log("Valoooooor de Arreglo",""+coordenadasPortal.length);

/********************/
            Texture moneda = MyGdxGame.getManager().get("Coin.png");
            for (MapObject object : map.getLayers().get(32).getObjects().getByType(RectangleMapObject.class)) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();
                // new in(world,map,rect,portal);
                coin.add(new Coins(world, map, rect, moneda));
            }
            for (Coins coin : coin) {
                AddResources.stage.addActor(coin);
            }

            for (MapObject object : map.getLayers().get(35).getObjects().getByType(RectangleMapObject.class)) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();
                setScreen.add(new ScreenSend(world, rect));
                Gdx.app.log("Mensaje", "Se creo el rectangulo");
            }
            for(ScreenSend s : setScreen)
            {
                AddResources.stage.addActor(s);
            }


            for (MapObject object : map.getLayers().get(37).getObjects().getByType(RectangleMapObject.class)) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();
                pisoAgarradera.add(new PisoAgarradera(world, map, rect));
            }
            for (PisoAgarradera ps : pisoAgarradera) {
                AddResources.stage.addActor(ps);
            }

            // Gdx.app.log("Error"," No se creo el piso Agarradera #37");
            /*****************/

            Texture a = MyGdxGame.getManager().get("ParajoStaticD.png");
            Texture e = MyGdxGame.getManager().get("ParajoStaticL.png");
            Texture i = MyGdxGame.getManager().get("ParajoFlyR.png");
            Texture o = MyGdxGame.getManager().get("ParajoFlyL.png");
            for (MapObject object : map.getLayers().get(38).getObjects().getByType(RectangleMapObject.class)) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();
                P.add(new Parajo(world, rect.x, rect.y, a, e, i, o));
            }
            for (Parajo P : P) {
                AddResources.stage.addActor(P);
            }
///////////////////
            Texture PisoMovTexture = MyGdxGame.getManager().get("PisoMov.png");
            for (MapObject object : map.getLayers().get(17).getObjects().getByType(RectangleMapObject.class)) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();
                plataformaMov.add(new PlataformaMovimiento(world, PisoMovTexture, rect.x, rect.y, iterator3));
                iterator3++;
            }
            for (PlataformaMovimiento pm : plataformaMov) {
                AddResources.stage.addActor(pm);
            }///////////

            Texture cajaTex = MyGdxGame.getManager().get("c.png");

            for (MapObject object : map.getLayers().get(6).getObjects().getByType(RectangleMapObject.class)) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();
                cajas.add(new Cajas(world, cajaTex, rect.x, rect.y, iterator4));
                iterator4++;
            }
            for (Cajas ca : cajas) {
                AddResources.stage.addActor(ca);
            }
            for (MapObject object : map.getLayers().get(46).getObjects().getByType(RectangleMapObject.class)) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();
                cameraY.add(new CamaraY (world, map, rect,iteratorCamY));
                iteratorCamY++;
            }
            for (CamaraY cam: cameraY) {
                AddResources.stage.addActor(cam);
            }
            for (MapObject object : map.getLayers().get(47).getObjects().getByType(RectangleMapObject.class)) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();
                cameraNoY.add(new CamaraNoY(world, map, rect,iteratorNoCamY));
                iteratorNoCamY++;
            }
            for (CamaraNoY cam: cameraNoY) {
                AddResources. stage.addActor(cam);
            }







//////////////
/*****************/
            /***************/
        }catch (Exception e)
        {
Gdx.app.log("Mensaje de error de AddActor",""+e.getMessage()+"||"+e.getLocalizedMessage()+"||"+e.getCause());
        }


    }
    public void AddDetach()
    {
        player.detach();
        for(Pincho p : pincho)
        {
            p.detach();
        }

        for(Agarradera agarradera : agarradera)
        {
            agarradera.detach();
        }
        for(PisoTime pisoTime: pisoTime)
        {
            pisoTime.detach();
        }
        for(particulas p : p)
        {
            p.detachParticule();
        }
        for(Fuego fuego : fuego)
        {
         fuego.detach();
        }
        for(RayoFuego rayoDown: rayoDown)
        {
            rayoDown.detach();
        }
        button.ButtonDetach();
        button2.ButtonDetach();
        s1.detach();
        s2.detach();
        s3.detach();
        s4.detach();
        s5.detach();
        arbolV.dispose();
        arbolR.dispose();

    }
}
