package com.mygdx.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.game.Menu;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.tiled.AddResources;

import static com.mygdx.game.MyGdxGame.CasaDosPisos1;
import static com.mygdx.game.MyGdxGame.Pixels;
import static com.mygdx.game.MyGdxGame.agua1;

public class MenuBuild extends Actor implements Disposable
{

    Texture logo;
     public static Sprite Logo;
    Rectangle Cuadro;
    float time,time2;
    public static boolean isMenu;

    /*****Menu****/
    public static float timeRetrasar; //retrasa la seleccion para no seleccionar un menu por accidente
    Texture equis;
    Texture fondo,logo1,logo2,logo3,logo4;
    public static Rectangle Menu1,Menu2,Menu3,Menu4,Salir;
    public static Sprite Fondo,Fondo2,Logo1,Logo2,Logo3,Logo4;
    public static boolean isMenu1 = true,isMenu2,isMenu3,isMenu4;
    float alpha1,alpha2,alpha3,alpha4;

    /***Menu1***/
    float alphaTierra = 1,alphaAgua = 1,alphaTrigo = 1,alphaMaiz = 1,alphaSoja = 1,alphaZanahoria = 1,alphaCana = 1,alphaAlgodon = 1;
    float alphaTrigo2 = 1,alphaMaiz2 = 1,alphaSoja2 = 1,alphaZanahoria2 = 1,alphaCana2 = 1,alphaAlgodon2 = 1;
    Texture Tierra,Agua,Trigo,Maiz,Soja,Zanahoria,Cana,Algodon;
    Sprite  TierraS,AguaS,TrigoS,MaizS,SojaS,ZanahoriaS,CanaS,AlgodonS;
    public static Rectangle tierraR,aguaR,trigoR,maizR,sojaR,zanahoriaR,canaR,algodonR;
    public static Rectangle trigoR2,maizR2,sojaR2,zanahoriaR2,canaR2,algodonR2;
    public static boolean BuildTierra;
    public static boolean BuildAgua;
    public static boolean BuildMover;

    /****MoverButton****/
    Texture mover;
    public static Rectangle moverR;
   public static Sprite moverS;
   public static boolean isMover;
    float moverTime;
    float alphaMover;
    /******Cultivos******/
    public static float timeCultivos;

    public static Texture flechaVerde,flechaRoja;
    public static boolean isMenuSeedSelection;
    float abs;
    boolean sube= true,baja;
    public static float timeQuitar;

    public static boolean isTierra1,isTierra2,isTierra3,isTierra4,isTierra5;
    /******Menu2******/
    float alphaCasa2 = 1,alphaCasa1 = 1,alphaMaceta1 = 1,alphaMaceta2 = 1,alphaArbusto1 = 1,alphaArbusto2 = 1;
    public static boolean CasasDosPisosBuild;
    public static boolean CasasBuild;
    public static boolean Maceta1Build;
    public static boolean Maceta2Build;
    public static Rectangle Casa2PisosR,CasaR,Maceta1R,Maceta2R,Arbusto1R,Arbusto2R;
    Texture Arbusto1,Arbusto2;
    Sprite Arbusto1S,Arbusto2S;
    Texture Maceta1,Maceta2;
    Sprite Maceta1S,Maceta2S;
    Texture Casa2Pisos,Casa;
    Sprite Casa2PisosS,CasaS;

    public MenuBuild()
    {
        equis= new Texture("X.png");
        switch(MyGdxGame.ColorControl.getInteger("Color")) {
            case 0: {
                logo = new Texture("controles/Blanco/Inicia.png");
                break;
            }
            case 1:
            {
                logo = new Texture("controles/Inicia.png");
                break;
            }
            case 2: {
                logo = new Texture("controles/Azul/Inicia.png");

                break;
            }
            case 3: {
                logo = new Texture("controles/Amarillo/Inicia.png");
                break;
            }
            case 4: {
                logo = new Texture("controles/Rosa/Inicia.png");
                break;
            }
            case 5: {
                logo = new Texture("controles/Verde/Inicia.png");
                break;
            }
        }
        Cuadro = new Rectangle();
        Logo = new Sprite(logo);

        /*****Menu*****/
        logo1 = new Texture("Logo1.png");
        Logo1 = new Sprite(logo1);
        logo2 = new Texture("Logo2.png");
        Logo2 = new Sprite(logo2);
        logo3 = new Texture("Logo3.png");
        Logo3 = new Sprite(logo3);
        logo4 = new Texture("Logo4.png");
        Logo4 = new Sprite(logo4);
        fondo = new Texture("cuadradoNegro.png");
        Fondo = new Sprite(fondo);
        Fondo2 = new Sprite(fondo);


        Menu1 = new Rectangle();
        Menu2 = new Rectangle();
        Menu3 = new Rectangle();
        Menu4 = new Rectangle();
        Salir = new Rectangle();

        Tierra = new Texture("Tierral.png");
        Agua = new Texture("Agua.png");
        Trigo = new Texture("Trigo.png");
        Maiz = new Texture("Maiz.png");
        Soja = new Texture("Soja.png");
        Zanahoria = new Texture("Zanahoria.png");
        Cana = new Texture("Caña.png");
        Algodon = new Texture("Algodon.png");

        TierraS = new Sprite(Tierra);
        AguaS = new Sprite(Agua);
        TrigoS = new Sprite(Trigo);
        MaizS = new Sprite(Maiz);
        SojaS = new Sprite(Soja);
        ZanahoriaS= new Sprite(Zanahoria);
        CanaS = new Sprite(Cana);
        AlgodonS = new Sprite(Algodon);

        flechaVerde = new Texture("FlechaVerde.png");
        flechaRoja = new Texture("FlechaRoja.png");

        tierraR = new Rectangle();
        aguaR  = new Rectangle();
        trigoR = new Rectangle();
        maizR = new Rectangle();
        sojaR = new Rectangle();
        zanahoriaR  = new Rectangle();
        canaR = new Rectangle();
        algodonR = new Rectangle();


        trigoR2 = new Rectangle();
        maizR2 = new Rectangle();
        sojaR2 = new Rectangle();
        zanahoriaR2  = new Rectangle();
        canaR2 = new Rectangle();
        algodonR2 = new Rectangle();

        mover = new Texture("MoveOn.png");
        moverR = new Rectangle();
        moverS = new Sprite(mover);

        Maceta1 = new Texture("Maceta1.png");
        Maceta2 = new Texture("Maceta2.png");
        Maceta1S = new Sprite(Maceta1);
        Maceta2S = new Sprite(Maceta2);
        Casa2Pisos = new Texture("CasaDosPisos.png");
        Casa = new Texture("Casa.png");
        Casa2PisosS = new Sprite(Casa2Pisos);
        CasaS = new Sprite(Casa);
        Arbusto1 = new Texture("Arbusto1.png");
        Arbusto1S = new Sprite(Arbusto1);
        Arbusto2 = new Texture("Arbusto2.png");
        Arbusto2S = new Sprite(Arbusto2);

        Casa2PisosR = new Rectangle();
        CasaR = new Rectangle();
        Maceta1R = new Rectangle();
        Maceta2R = new Rectangle();
        Arbusto1R = new Rectangle();
        Arbusto2R = new Rectangle();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        time += 1 * Gdx.graphics.getDeltaTime();

        Logo.setBounds(AddResources.cam.position.x - 3.8f, AddResources.cam.position.y , 20 / Pixels, 20 / Pixels);
        Logo.setAlpha(MyGdxGame.alpha);
        Fondo2.setBounds(AddResources.cam.position.x - 3.8f, AddResources.cam.position.y+(25/Pixels) , 20 / Pixels, 20 / Pixels);
        Fondo2.setAlpha(alphaMover);
        moverS.setBounds(AddResources.cam.position.x - 3.8f, AddResources.cam.position.y+(25/Pixels) , 20 / Pixels, 20 / Pixels);
        moverS.setAlpha(MyGdxGame.alpha+.2f);
        moverTime += 1 * Gdx.graphics.getDeltaTime();
        if(moverTime > 1) {
            if (moverR.overlaps(AddResources.puntero)) {
                if(isMover)
                {
                    isMover = false;
                    alphaMover = 0.4f;
                }else
                {
                    isMover = true;
                    alphaMover = 0.8f;
                }

                moverTime = 0;
            }
        }
        Cuadro.set(AddResources.cam.position.x - 3.8f, AddResources.cam.position.y , 20 / Pixels, 20 / Pixels);
        if(time > 1 && Cuadro.overlaps(AddResources.puntero))
        {
                isMenu = true;
                time = 0;
        }

        if(isMenu) {
            timeCultivos += 1 * Gdx.graphics.getDeltaTime();
            timeRetrasar = timeRetrasar + 1 * Gdx.graphics.getDeltaTime();
          //   Gdx.app.log("timeCultivos", "" + timeCultivos);
        }else
        {
            timeRetrasar = 0;
        }
        MenuSeeds(batch);
    }

    public void MenuSeeds(Batch batch) {
        if(sube) {
            if (abs < 5) {
                abs += 15 * Gdx.graphics.getDeltaTime();
            }else {
                baja = true;
                sube = false;
            }
        }
        if(baja) {
            if (abs > 1) {
                abs -= 15 * Gdx.graphics.getDeltaTime();
            }else
            {
                baja = false;
                sube = true;
            }
        }
        if(!isMenuSeedSelection) {
        /**************************************/

            if (MyGdxGame.tierra1Enable.getBoolean("tierra1")) {
                if (Tierra1.isDamp) {
                    if (Tierra1.Cuerpo.overlaps(Jugador.jugador)) {
                        float x = Tierra1.Cuerpo.x;
                        float y = (Tierra1.Cuerpo.y + Tierra1.Cuerpo.height) + (abs / Pixels);

                        batch.draw(flechaVerde, x, y, 32 / Pixels, 32 / Pixels);
                        if (Tierra1.reiniciarTime > 1) {
                            if (AddResources.puntero.overlaps(Tierra1.Cuerpo)) {
                                isTierra1 = true;
                                isTierra2 = false;
                                isTierra3 = false;
                                isTierra4 = false;
                                isTierra5 = false;
                                isMenuSeedSelection = true;
                            }
                        }
                    }
                }
            } else {
                if (Tierra1.Cuerpo.overlaps(Jugador.jugador)) {
                    if (Tierra1.isOld == 2) {
                        float x = Tierra1.Cuerpo.x;
                        float y = (Tierra1.Cuerpo.y + Tierra1.Cuerpo.height) + (abs / Pixels);
                        batch.draw(flechaRoja, x, y, 32 / Pixels, 32 / Pixels);
                        if (Tierra1.Cuerpo.overlaps(AddResources.puntero)) {
                            Tierra1.reiniciar = true;

                        }
                    }
                }
            }
            /**************************************/
            /**************************************/
            if (MyGdxGame.tierra2Enable.getBoolean("tierra2")) {
                if (Tierra2.isDamp) {
                    if (Tierra2.Cuerpo.overlaps(Jugador.jugador)) {
                        float x = Tierra2.Cuerpo.x;
                        float y = (Tierra2.Cuerpo.y + Tierra2.Cuerpo.height) + (abs / Pixels);
                        batch.draw(flechaVerde, x, y, 32 / Pixels, 32 / Pixels);
                        if (Tierra2.reiniciarTime > 1) {
                            if (AddResources.puntero.overlaps(Tierra2.Cuerpo)) {
                                isTierra1 = false;
                                isTierra2 = true;
                                isTierra3 = false;
                                isTierra4 = false;
                                isTierra5 = false;
                                isMenuSeedSelection = true;
                            }
                        }
                    }
                }
            } else {
                if (Tierra2.Cuerpo.overlaps(Jugador.jugador)) {
                    if (Tierra2.isOld == 2) {
                        float x = Tierra2.Cuerpo.x;
                        float y = (Tierra2.Cuerpo.y + Tierra2.Cuerpo.height) + (abs / Pixels);
                        batch.draw(flechaRoja, x, y, 32 / Pixels, 32 / Pixels);
                        if (Tierra2.Cuerpo.overlaps(AddResources.puntero)) {
                            Tierra2.reiniciar = true;

                        }
                    }
                }
            }
            /**************************************/
            /**************************************/
            if (MyGdxGame.tierra3Enable.getBoolean("tierra3")) {
                if (Tierra3.isDamp) {
                    if (Tierra3.Cuerpo.overlaps(Jugador.jugador)) {
                        float x = Tierra3.Cuerpo.x;
                        float y = (Tierra3.Cuerpo.y + Tierra3.Cuerpo.height) + (abs / Pixels);
                        batch.draw(flechaVerde, x, y, 32 / Pixels, 32 / Pixels);
                        if (Tierra3.reiniciarTime > 1) {
                            if (AddResources.puntero.overlaps(Tierra3.Cuerpo)) {
                                isTierra1 = false;
                                isTierra2 = false;
                                isTierra3 = true;
                                isTierra4 = false;
                                isTierra5 = false;
                                isMenuSeedSelection = true;
                            }
                        }
                    }
                }
            } else {
                if (Tierra3.Cuerpo.overlaps(Jugador.jugador)) {
                    if (Tierra3.isOld == 2) {
                        float x = Tierra3.Cuerpo.x;
                        float y = (Tierra3.Cuerpo.y + Tierra3.Cuerpo.height) + (abs / Pixels);
                        batch.draw(flechaRoja, x, y, 32 / Pixels, 32 / Pixels);
                        if (Tierra3.Cuerpo.overlaps(AddResources.puntero)) {
                            Tierra3.reiniciar = true;
                        }
                    }
                }
            }
            /**************************************/
            /**************************************/
            if (MyGdxGame.tierra4Enable.getBoolean("tierra4")) {
                if (Tierra4.isDamp) {
                    if (Tierra4.Cuerpo.overlaps(Jugador.jugador)) {
                        float x = Tierra4.Cuerpo.x;
                        float y = (Tierra4.Cuerpo.y + Tierra4.Cuerpo.height) + (abs / Pixels);
                        Gdx.app.log("y",""+Tierra4.Cuerpo.height+" Y2: "+Tierra4.Cuerpo2.y);
                        batch.draw(flechaVerde, x, y, 32 / Pixels, 32 / Pixels);
                        if (Tierra4.reiniciarTime > 1) {
                            if (AddResources.puntero.overlaps(Tierra4.Cuerpo)) {
                                isTierra1 = false;
                                isTierra2 = false;
                                isTierra3 = false;
                                isTierra4 = true;
                                isTierra5 = false;
                                isMenuSeedSelection = true;
                            }
                        }
                    }
                }
            } else {
                if (Tierra4.Cuerpo.overlaps(Jugador.jugador)) {
                    if (Tierra4.isOld == 2) {
                        float x = Tierra4.Cuerpo.x;
                        float y = (Tierra4.Cuerpo.y + Tierra4.Cuerpo.height) + (abs / Pixels);
                        batch.draw(flechaRoja, x, y, 32 / Pixels, 32 / Pixels);
                        if (Tierra4.Cuerpo.overlaps(AddResources.puntero)) {
                            Tierra4.reiniciar = true;
                        }
                    }
                }
            }
            /**************************************/
            /**************************************/
            if (MyGdxGame.tierra5Enable.getBoolean("tierra5")) {
                if (Tierra5.isDamp) {
                    if (Tierra5.Cuerpo.overlaps(Jugador.jugador)) {
                        float x = Tierra5.Cuerpo.x;
                        float y = (Tierra5.Cuerpo.y + Tierra5.Cuerpo.height) + (abs / Pixels);
                        batch.draw(flechaVerde, x, y, 32 / Pixels, 32 / Pixels);
                        if (Tierra5.reiniciarTime > 1) {
                            if (AddResources.puntero.overlaps(Tierra5.Cuerpo)) {
                                isTierra1 = false;
                                isTierra2 = false;
                                isTierra3 = false;
                                isTierra4 = false;
                                isTierra5 = true;
                                isMenuSeedSelection = true;
                            }
                        }
                    }
                }
            } else {
                if (Tierra5.Cuerpo.overlaps(Jugador.jugador)) {
                    if (Tierra5.isOld == 2) {
                        float x = Tierra5.Cuerpo.x;
                        float y = (Tierra5.Cuerpo.y + Tierra5.Cuerpo.height) + (abs / Pixels);
                        batch.draw(flechaRoja, x, y, 32 / Pixels, 32 / Pixels);
                        if (Tierra5.Cuerpo.overlaps(AddResources.puntero)) {
                            Tierra5.reiniciar = true;
                        }
                    }
                }
            }
            /**************************************/

        }
    }
    public void MenuSeedsSelection(Batch batch)
    {
        if(isMenuSeedSelection) {
            MenuBuild.isMenu = false;
            MenuBuild.timeQuitar += 1 * Gdx.graphics.getDeltaTime();
            Fondo.setBounds(AddResources.cam.position.x - 3.8f + (30 / Pixels), AddResources.cam.position.y - 2 + (5 / Pixels), 190 / Pixels, 100 / Pixels);
            Fondo.setAlpha(0.8f);
            Fondo.draw(batch);
            batch.draw(equis, AddResources.cam.position.x - 3.8f + (205 / Pixels), AddResources.cam.position.y - 2 + (90 / Pixels), 10 / Pixels, 10 / Pixels);
            Salir.set(AddResources.cam.position.x - 3.8f + (205 / Pixels), AddResources.cam.position.y - 2 + (90 / Pixels), 10 / Pixels, 10 / Pixels);

            if(MyGdxGame.Trigo.getInteger("Trigo")>0)
            {
                alphaTrigo2 = 1;
                trigoR2.set(AddResources.cam.position.x - 3.8f+ (40/ Pixels), AddResources.cam.position.y - 2 + (20 / Pixels), 30 / Pixels, 30 / Pixels);
            }else
            {
                alphaTrigo2 = .4f;
                trigoR2.set(0,0,0,0);
            }
            if(MyGdxGame.Maiz.getInteger("Maiz")>0)
            {
                maizR2.set(AddResources.cam.position.x - 3.8f+ (80/ Pixels), AddResources.cam.position.y - 2 + (20 / Pixels), 30 / Pixels, 30 / Pixels);
                alphaMaiz2 = 1;
            }else
            {
                maizR2.set(0,0,0,0);
                alphaMaiz2 = .4f;
            }
            if(MyGdxGame.Soja.getInteger("Soja")>0)
            {
                sojaR2.set(AddResources.cam.position.x - 3.8f+ (40/ Pixels), AddResources.cam.position.y - 2 + (65 / Pixels), 30 / Pixels, 30 / Pixels);
                alphaSoja2 = 1;
            }else
            {
                alphaSoja2 = .4f;
                sojaR2.set(0,0,0,0);
            }
            if(MyGdxGame.Zanahoria.getInteger("Zanahoria")>0)
            {
                zanahoriaR2.set(AddResources.cam.position.x - 3.8f+ (80/ Pixels), AddResources.cam.position.y - 2 + (65 / Pixels), 30 / Pixels, 30 / Pixels);
                alphaZanahoria2 = 1;
            }else
            {
                alphaZanahoria2 = .4f;
                zanahoriaR2.set(0,0,0,0);
            }
            if(MyGdxGame.Cana.getInteger("Cana")>0)
            {
                canaR2.set(AddResources.cam.position.x - 3.8f+ (120/ Pixels), AddResources.cam.position.y - 2 + (65 / Pixels), 30 / Pixels, 30 / Pixels);
                alphaCana2 = 1;
            }else
            {
                alphaCana2 = .4f;
                canaR2.set(0,0,0,0);
            }
            if(MyGdxGame.Algodon.getInteger("Algodon")>0)
            {
                algodonR2.set(AddResources.cam.position.x - 3.8f+ (120/ Pixels), AddResources.cam.position.y - 2 + (20/ Pixels), 30 / Pixels, 30 / Pixels);
                alphaAlgodon2 = 1;
            }else
            {
                alphaAlgodon2 = .4f;
                algodonR2.set(0,0,0,0);
            }




            TrigoS.setAlpha(alphaTrigo2);
            TrigoS.setBounds(AddResources.cam.position.x - 3.8f+ (40/ Pixels), AddResources.cam.position.y - 2 + (20 / Pixels), 30 / Pixels, 30 / Pixels);
            TrigoS.draw(batch);

            MaizS.setAlpha(alphaMaiz2);
            MaizS.setBounds(AddResources.cam.position.x - 3.8f+ (80/ Pixels), AddResources.cam.position.y - 2 + (20 / Pixels), 30 / Pixels, 30 / Pixels);
            MaizS.draw(batch);

            SojaS.setAlpha(alphaSoja2);
            SojaS.setBounds(AddResources.cam.position.x - 3.8f+ (40/ Pixels), AddResources.cam.position.y - 2 + (65 / Pixels), 30 / Pixels, 30 / Pixels);
            SojaS.draw(batch);

            ZanahoriaS.setAlpha(alphaZanahoria2);
            ZanahoriaS.setBounds(AddResources.cam.position.x - 3.8f+ (80/ Pixels), AddResources.cam.position.y - 2 + (65 / Pixels), 30 / Pixels, 30 / Pixels);
            ZanahoriaS.draw(batch);

            CanaS.setAlpha(alphaCana2);
            CanaS.setBounds(AddResources.cam.position.x - 3.8f+ (120/ Pixels), AddResources.cam.position.y - 2 + (65 / Pixels), 30 / Pixels, 30 / Pixels);
            CanaS.draw(batch);

            AlgodonS.setAlpha(alphaAlgodon2);
            AlgodonS.setBounds(AddResources.cam.position.x - 3.8f+ (120/ Pixels), AddResources.cam.position.y - 2 + (20/ Pixels), 30 / Pixels, 30 / Pixels);
            AlgodonS.draw(batch);
            if(MenuBuild.timeQuitar > 1)
            {
                if (trigoR2.overlaps(AddResources.puntero)) {
                    int valorActual = MyGdxGame.Trigo.getInteger("Trigo");
                    valorActual--;
                    MyGdxGame.Trigo.putInteger("Trigo", valorActual);
                    MyGdxGame.Trigo.flush();
                    Gdx.app.log("Valor de trigo",""+MyGdxGame.Trigo.getInteger("Trigo"));
                    if(isTierra1)
                    {
                      MyGdxGame.tierra1Trigo.putBoolean("tierra11",true);
                        MyGdxGame.tierra1Trigo.flush();
                    }
                    if(isTierra2)
                    {
                        MyGdxGame.tierra2Trigo.putBoolean("tierra21",true);
                        MyGdxGame.tierra2Trigo.flush();
                    }
                    if(isTierra3)
                    {
                        MyGdxGame.tierra3Trigo.putBoolean("tierra31",true);
                        MyGdxGame.tierra3Trigo.flush();
                    }
                    if(isTierra4)
                    {
                        MyGdxGame.tierra4Trigo.putBoolean("tierra41",true);
                        MyGdxGame.tierra4Trigo.flush();
                    }
                    if(isTierra5)
                    {
                        MyGdxGame.tierra5Trigo.putBoolean("tierra51",true);
                        MyGdxGame.tierra5Trigo.flush();
                    }

                    MenuBuild.isMenuSeedSelection = false;
                    MenuBuild.timeQuitar = 0;
                }
                if (maizR2.overlaps(AddResources.puntero)) {
                    int valorActual = MyGdxGame.Maiz.getInteger("Maiz");
                    valorActual--;
                    MyGdxGame.Maiz.putInteger("Maiz", valorActual);
                    MyGdxGame.Maiz.flush();
                    Gdx.app.log("Valor de maiz",""+MyGdxGame.Maiz.getInteger("Maiz"));
                    if(isTierra1)
                    {
                        MyGdxGame.tierra1Maiz.putBoolean("tierra12",true);
                        MyGdxGame.tierra1Maiz.flush();
                    }
                    if(isTierra2)
                    {
                        MyGdxGame.tierra2Maiz.putBoolean("tierra22",true);
                        MyGdxGame.tierra2Maiz.flush();
                    }
                    if(isTierra3)
                    {
                        MyGdxGame.tierra3Maiz.putBoolean("tierra32",true);
                        MyGdxGame.tierra3Maiz.flush();

                    }
                    if(isTierra4)
                    {
                        MyGdxGame.tierra4Maiz.putBoolean("tierra42",true);
                        MyGdxGame.tierra4Maiz.flush();
                    }
                    if(isTierra5)
                    {
                        MyGdxGame.tierra5Maiz.putBoolean("tierra52",true);
                        MyGdxGame.tierra5Maiz.flush();
                    }
                    MenuBuild.isMenuSeedSelection = false;
                    MenuBuild.timeQuitar = 0;
                }
                if (sojaR2.overlaps(AddResources.puntero)) {
                    int valorActual = MyGdxGame.Soja.getInteger("Soja");
                    valorActual--;
                    MyGdxGame.Soja.putInteger("Soja", valorActual);
                    MyGdxGame.Soja.flush();
                    Gdx.app.log("Valor de soja",""+MyGdxGame.Soja.getInteger("Soja"));
                    MenuBuild.timeQuitar = 0;
                    if(isTierra1)
                    {
                        MyGdxGame.tierra1Soja.putBoolean("tierra13",true);
                        MyGdxGame.tierra1Soja.flush();
                    }
                    if(isTierra2)
                    {
                        MyGdxGame.tierra2Soja.putBoolean("tierra23",true);
                        MyGdxGame.tierra2Soja.flush();
                    }
                    if(isTierra3)
                    {
                        MyGdxGame.tierra3Soja.putBoolean("tierra33",true);
                        MyGdxGame.tierra3Soja.flush();
                    }
                    if(isTierra4)
                    {
                        MyGdxGame.tierra4Soja.putBoolean("tierra43",true);
                        MyGdxGame.tierra4Soja.flush();
                    }
                    if(isTierra5)
                    {
                        MyGdxGame.tierra5Soja.putBoolean("tierra53",true);
                        MyGdxGame.tierra5Soja.flush();
                    }
                    MenuBuild.isMenuSeedSelection = false;
                }
                if (zanahoriaR2.overlaps(AddResources.puntero)) {
                    int valorActual = MyGdxGame.Zanahoria.getInteger("Zanahoria");
                    valorActual--;
                    MyGdxGame.Zanahoria.putInteger("Zanahoria", valorActual);
                    MyGdxGame.Zanahoria.flush();
                    Gdx.app.log("Valor de zanahoria",""+MyGdxGame.Zanahoria.getInteger("Zanahoria"));
                    MenuBuild.timeQuitar = 0;
                    if(isTierra1)
                    {
                        MyGdxGame.tierra1Zanahoria.putBoolean("tierra14",true);
                        MyGdxGame.tierra1Zanahoria.flush();
                    }
                    if(isTierra2)
                    {
                        MyGdxGame.tierra2Zanahoria.putBoolean("tierra24",true);
                        MyGdxGame.tierra2Zanahoria.flush();
                    }
                    if(isTierra3)
                    {
                        MyGdxGame.tierra3Zanahoria.putBoolean("tierra34",true);
                        MyGdxGame.tierra3Zanahoria.flush();
                    }
                    if(isTierra4)
                    {
                        MyGdxGame.tierra4Zanahoria.putBoolean("tierra44",true);
                        MyGdxGame.tierra4Zanahoria.flush();
                    }
                    if(isTierra5)
                    {
                        MyGdxGame.tierra5Zanahoria.putBoolean("tierra54",true);
                        MyGdxGame.tierra5Zanahoria.flush();
                    }
                    MenuBuild.isMenuSeedSelection = false;
                }
                if (canaR2.overlaps(AddResources.puntero)) {
                    int valorActual = MyGdxGame.Cana.getInteger("Cana");
                    valorActual--;
                    MyGdxGame.Cana.putInteger("Cana", valorActual);
                    MyGdxGame.Cana.flush();
                    Gdx.app.log("Valor de cana",""+MyGdxGame.Cana.getInteger("Cana"));
                    MenuBuild.timeQuitar = 0;
                    if(isTierra1)
                    {
                        MyGdxGame.tierra1Cana.putBoolean("tierra15",true);
                        MyGdxGame.tierra1Cana.flush();
                    }
                    if(isTierra2)
                    {
                        MyGdxGame.tierra2Cana.putBoolean("tierra25",true);
                        MyGdxGame.tierra2Cana.flush();
                    }
                    if(isTierra3)
                    {
                        MyGdxGame.tierra3Cana.putBoolean("tierra35",true);
                        MyGdxGame.tierra3Cana.flush();
                    }
                    if(isTierra4)
                    {
                        MyGdxGame.tierra4Cana.putBoolean("tierra45",true);
                        MyGdxGame.tierra4Cana.flush();
                    }
                    if(isTierra5)
                    {
                        MyGdxGame.tierra5Cana.putBoolean("tierra55",true);
                        MyGdxGame.tierra5Cana.flush();
                    }
                    MenuBuild.isMenuSeedSelection = false;
                }
                if (algodonR2.overlaps(AddResources.puntero)) {
                    int valorActual = MyGdxGame.Algodon.getInteger("Algodon");
                    valorActual--;
                    MyGdxGame.Algodon.putInteger("Algodon", valorActual);
                    MyGdxGame.Algodon.flush();
                    Gdx.app.log("Valor de Algodon",""+MyGdxGame.Algodon.getInteger("Algodon"));
                    if(isTierra1)
                    {
                        MyGdxGame.tierra1Algodon.putBoolean("tierra16",true);
                        MyGdxGame.tierra1Algodon.flush();
                    }
                    if(isTierra2)
                    {
                        MyGdxGame.tierra2Algodon.putBoolean("tierra26",true);
                        MyGdxGame.tierra2Algodon.flush();
                    }
                    if(isTierra3)
                    {
                        MyGdxGame.tierra3Algodon.putBoolean("tierra36",true);
                        MyGdxGame.tierra3Algodon.flush();
                    }
                    if(isTierra4)
                    {
                        MyGdxGame.tierra4Algodon.putBoolean("tierra46",true);
                        MyGdxGame.tierra4Algodon.flush();
                    }
                    if(isTierra5)
                    {
                        MyGdxGame.tierra5Algodon.putBoolean("tierra56",true);
                        MyGdxGame.tierra5Algodon.flush();
                    }
                    MenuBuild.timeQuitar = 0;
                    MenuBuild.isMenuSeedSelection = false;
                }
            }


        }else
        {
            trigoR2.set(0,0,0,0);
            maizR2.set(0,0,0,0);
            sojaR2.set(0,0,0,0);
            zanahoriaR2.set(0,0,0,0);
            canaR2.set(0,0,0,0);
            algodonR2.set(0,0,0,0);
        }
    }


    public void MenuDraw(Batch batch, OrthographicCamera cam)
    {

        if(isMenu) {
       if(MenuBuild.timeRetrasar > 1) {
           Menu1.set(cam.position.x - 3.8f, cam.position.y - 2 + (5 / Pixels), 25 / Pixels, 25 / Pixels);
           Menu2.set(cam.position.x - 3.8f, cam.position.y - 2 + (30 / Pixels), 25 / Pixels, 25 / Pixels);
           Menu3.set(cam.position.x - 3.8f, cam.position.y - 2 + (55 / Pixels), 25 / Pixels, 25 / Pixels);
           Menu4.set(cam.position.x - 3.8f, cam.position.y - 2 + (80 / Pixels), 25 / Pixels, 25 / Pixels);
       }
           if (isMenu1) {
               alpha1 = 0.2f;
               alpha2 = 0.8f;
               alpha3 = 0.8f;
               alpha4 = 0.8f;
           }
           if (isMenu2) {
               alpha1 = 0.8f;
               alpha2 = 0.2f;
               alpha3 = 0.8f;
               alpha4 = 0.8f;
           }
           if (isMenu3) {
               alpha1 = 0.8f;
               alpha2 = 0.8f;
               alpha3 = 0.2f;
               alpha4 = 0.8f;
           }
           if (isMenu4) {
               alpha1 = 0.8f;
               alpha2 = 0.8f;
               alpha3 = 0.8f;
               alpha4 = 0.2f;
           }
           Fondo.setAlpha(alpha1);

           Fondo.setBounds(cam.position.x - 3.8f, cam.position.y - 2 + (5 / Pixels), 25 / Pixels, 25 / Pixels);
           Logo1.setBounds(cam.position.x - 3.8f, cam.position.y - 2 + (5 / Pixels), 25 / Pixels, 25 / Pixels);
           Logo1.draw(batch);
           Fondo.draw(batch);
           Fondo.setAlpha(alpha2);
          Fondo.setBounds(cam.position.x - 3.8f, cam.position.y - 2 + (30 / Pixels), 25 / Pixels, 25 / Pixels);
           Logo2.setBounds(cam.position.x - 3.8f, cam.position.y - 2 + (30 / Pixels), 25 / Pixels, 25 / Pixels);
           Logo2.draw(batch);
           Fondo.draw(batch);
           Fondo.setAlpha(alpha3);
           Fondo.setBounds(cam.position.x - 3.8f, cam.position.y - 2 + (55 / Pixels), 25 / Pixels, 25 / Pixels);
           Logo3.setBounds(cam.position.x - 3.8f, cam.position.y - 2 + (55 / Pixels), 25 / Pixels, 25 / Pixels);
           Logo3.draw(batch);
           Fondo.draw(batch);
           Fondo.setAlpha(alpha4);

           Fondo.setBounds(cam.position.x - 3.8f, cam.position.y - 2 + (80 / Pixels), 25 / Pixels, 25 / Pixels);
           Logo4.setBounds(cam.position.x - 3.8f, cam.position.y - 2 + (80 / Pixels), 25 / Pixels, 25 / Pixels);
           Logo4.draw(batch);
           Fondo.draw(batch);

           MenuItems(batch, AddResources.puntero);

        }else
        {
            Menu1.set(0,0,0,0);
            Menu2.set(0,0,0,0);
            Menu3.set(0,0,0,0);
            Menu4.set(0,0,0,0);
        }
    }

    public void MenuItems(Batch batch,Rectangle puntero)
    {
        Fondo.setBounds(AddResources.cam.position.x - 3.8f+ (30 / Pixels), AddResources.cam.position.y - 2 + (5 / Pixels), 190 / Pixels, 100 / Pixels);
        Fondo.setAlpha(0.8f);
        Fondo.draw(batch);
        batch.draw(equis,AddResources.cam.position.x - 3.8f+ (205 / Pixels), AddResources.cam.position.y - 2 + (90 / Pixels), 10 / Pixels, 10 / Pixels);
        Salir.set(AddResources.cam.position.x - 3.8f+ (205 / Pixels), AddResources.cam.position.y - 2 + (90 / Pixels), 10 / Pixels, 10 / Pixels);
        /**********************************************************************************************************************************************************************/
        if(isMenu1)
        {
            if(MyGdxGame.TierrasColocadas.getInteger("Posiciones") < 5)
            {
                tierraR.set(AddResources.cam.position.x - 3.8f+ (40 / Pixels), AddResources.cam.position.y - 2 + (20 / Pixels), 30 / Pixels, 30 / Pixels);
            }else
            {
                alphaTierra = 0.4f;
                tierraR.set(0,0,0,0);
            }

            TierraS.setAlpha(alphaTierra);
            TierraS.setBounds(AddResources.cam.position.x - 3.8f+ (40 / Pixels), AddResources.cam.position.y - 2 + (20 / Pixels), 30 / Pixels, 30 / Pixels);
            TierraS.draw(batch);
            if(MyGdxGame.AguasColocadas.getInteger("Posiciones2") < 4) {
                aguaR.set(AddResources.cam.position.x - 3.8f + (80 / Pixels), AddResources.cam.position.y - 2 + (20 / Pixels), 30 / Pixels, 30 / Pixels);
            }else
            {
                alphaAgua = 0.4f;
                aguaR.set(0,0,0,0);
            }
                AguaS.setAlpha(alphaAgua);
                AguaS.setBounds(AddResources.cam.position.x - 3.8f + (80 / Pixels), AddResources.cam.position.y - 2 + (20 / Pixels), 30 / Pixels, 30 / Pixels);
                AguaS.draw(batch);

            trigoR.set(AddResources.cam.position.x - 3.8f+ (120/ Pixels), AddResources.cam.position.y - 2 + (20 / Pixels), 30 / Pixels, 30 / Pixels);
            TrigoS.setAlpha(alphaTrigo);
            TrigoS.setBounds(AddResources.cam.position.x - 3.8f+ (120/ Pixels), AddResources.cam.position.y - 2 + (20 / Pixels), 30 / Pixels, 30 / Pixels);
            TrigoS.draw(batch);
            maizR.set(AddResources.cam.position.x - 3.8f+ (160/ Pixels), AddResources.cam.position.y - 2 + (20 / Pixels), 30 / Pixels, 30 / Pixels);
            MaizS.setAlpha(alphaMaiz);
            MaizS.setBounds(AddResources.cam.position.x - 3.8f+ (160/ Pixels), AddResources.cam.position.y - 2 + (20 / Pixels), 30 / Pixels, 30 / Pixels);
            MaizS.draw(batch);
            sojaR.set(AddResources.cam.position.x - 3.8f+ (40/ Pixels), AddResources.cam.position.y - 2 + (65 / Pixels), 30 / Pixels, 30 / Pixels);
            SojaS.setAlpha(alphaSoja);
            SojaS.setBounds(AddResources.cam.position.x - 3.8f+ (40/ Pixels), AddResources.cam.position.y - 2 + (65 / Pixels), 30 / Pixels, 30 / Pixels);
            SojaS.draw(batch);
            zanahoriaR.set(AddResources.cam.position.x - 3.8f+ (80/ Pixels), AddResources.cam.position.y - 2 + (65 / Pixels), 30 / Pixels, 30 / Pixels);
            ZanahoriaS.setAlpha(alphaZanahoria);
            ZanahoriaS.setBounds(AddResources.cam.position.x - 3.8f+ (80/ Pixels), AddResources.cam.position.y - 2 + (65 / Pixels), 30 / Pixels, 30 / Pixels);
            ZanahoriaS.draw(batch);
            canaR.set(AddResources.cam.position.x - 3.8f+ (120/ Pixels), AddResources.cam.position.y - 2 + (65 / Pixels), 30 / Pixels, 30 / Pixels);
            CanaS.setAlpha(alphaCana);
            CanaS.setBounds(AddResources.cam.position.x - 3.8f+ (120/ Pixels), AddResources.cam.position.y - 2 + (65 / Pixels), 30 / Pixels, 30 / Pixels);
            CanaS.draw(batch);
            algodonR.set(AddResources.cam.position.x - 3.8f+ (160/ Pixels), AddResources.cam.position.y - 2 + (65 / Pixels), 30 / Pixels, 30 / Pixels);
            AlgodonS.setAlpha(alphaAlgodon);
            AlgodonS.setBounds(AddResources.cam.position.x - 3.8f+ (160/ Pixels), AddResources.cam.position.y - 2 + (65 / Pixels), 30 / Pixels, 30 / Pixels);
            AlgodonS.draw(batch);

            if(aguaR.overlaps(puntero))
            {
                BuildAgua = true;
                BuildTierra = false;
            }

            if(tierraR.overlaps(puntero))
            {
               BuildTierra = true;
                BuildAgua = false;
            }
            if(MenuBuild.timeCultivos > 1) {

                if (trigoR.overlaps(puntero)) {
                    int valorActual = MyGdxGame.Trigo.getInteger("Trigo");
                    valorActual++;
                    MyGdxGame.Trigo.putInteger("Trigo", valorActual);
                    MyGdxGame.Trigo.flush();
                    Gdx.app.log("Valor de trigo",""+MyGdxGame.Trigo.getInteger("Trigo"));
                    MenuBuild.timeCultivos=0;
                }
                if (maizR.overlaps(puntero)) {
                    int valorActual = MyGdxGame.Maiz.getInteger("Maiz");
                    valorActual++;
                    MyGdxGame.Maiz.putInteger("Maiz", valorActual);
                    MyGdxGame.Maiz.flush();
                    Gdx.app.log("Valor de maiz",""+MyGdxGame.Maiz.getInteger("Maiz"));
                    MenuBuild.timeCultivos=0;
                }
                if (sojaR.overlaps(puntero)) {
                    int valorActual = MyGdxGame.Soja.getInteger("Soja");
                    valorActual++;
                    MyGdxGame.Soja.putInteger("Soja", valorActual);
                    MyGdxGame.Soja.flush();
                    Gdx.app.log("Valor de soja",""+MyGdxGame.Soja.getInteger("Soja"));
                    MenuBuild.timeCultivos=0;
                }
                if (zanahoriaR.overlaps(puntero)) {
                    int valorActual = MyGdxGame.Zanahoria.getInteger("Zanahoria");
                    valorActual++;
                    MyGdxGame.Zanahoria.putInteger("Zanahoria", valorActual);
                    MyGdxGame.Zanahoria.flush();
                    Gdx.app.log("Valor de zanahoria",""+MyGdxGame.Zanahoria.getInteger("Zanahoria"));
                    MenuBuild.timeCultivos=0;
                }
                if (canaR.overlaps(puntero)) {
                    int valorActual = MyGdxGame.Cana.getInteger("Cana");
                    valorActual++;
                    MyGdxGame.Cana.putInteger("Cana", valorActual);
                    MyGdxGame.Cana.flush();
                    Gdx.app.log("Valor de cana",""+MyGdxGame.Cana.getInteger("Cana"));
                    MenuBuild.timeCultivos=0;
                }
                if (algodonR.overlaps(puntero)) {
                    int valorActual = MyGdxGame.Algodon.getInteger("Algodon");
                    valorActual++;
                    MyGdxGame.Algodon.putInteger("Algodon", valorActual);
                    MyGdxGame.Algodon.flush();
                    Gdx.app.log("Valor de Algodon",""+MyGdxGame.Algodon.getInteger("Algodon"));
                    MenuBuild.timeCultivos=0;
                }
            }

        }else
        {
            tierraR.set(0,0,0,0);
            aguaR.set(0,0,0,0);
            trigoR.set(0,0,0,0);
            maizR.set(0,0,0,0);
            sojaR.set(0,0,0,0);
            zanahoriaR.set(0,0,0,0);
            canaR.set(0,0,0,0);
            algodonR.set(0,0,0,0);
        }
        /**********************************************************************************************************************************************************************/
        if(isMenu2)
        {
            MenuBuild.timeCultivos = 0;


        }
        /***************************************************************************/
        /***************************************************************************/
        /***************************************************************************/
        /***************************************************************************/
        /***************************************************************************/
        /***************************************************************************/
        /***************************************************************************/
        /***************************************************************************/
        /***************************************************************************/
        /***************************************************************************/
        /***************************************************************************/
        /***************************************************************************/
        /***************************************************************************/
        /***************************************************************************/
        /***************************************************************************/
        /***************************************************************************/
        if(isMenu3)
        {
            MenuBuild.timeCultivos = 0;
            if(MyGdxGame.CasasDosPisosColocadas.getInteger("Posiciones3") < 2)
            {
                Casa2PisosR.set(AddResources.cam.position.x - 3.8f+ (40 / Pixels), AddResources.cam.position.y - 2 + (10 / Pixels), 50 / Pixels, 90 / Pixels);
            }else
            {
                alphaCasa2 = 0.4f;
                Casa2PisosR.set(0,0,0,0);
            }
            Casa2PisosS.setAlpha(alphaCasa2);
            Casa2PisosS.setBounds(AddResources.cam.position.x - 3.8f+ (40 / Pixels), AddResources.cam.position.y - 2 + (10 / Pixels), 50 / Pixels, 90 / Pixels);
            Casa2PisosS.draw(batch);
            if(MyGdxGame.CasasColocadas.getInteger("Posiciones4") < 2)
            {
                CasaR.set(AddResources.cam.position.x - 3.8f+ (40 / Pixels), AddResources.cam.position.y - 2 + (10 / Pixels), 50 / Pixels, 90 / Pixels);
            }else
            {
                alphaCasa1 = 0.4f;
                CasaR.set(0,0,0,0);
            }

            CasaS.setAlpha(alphaCasa1);
            CasaS.setBounds(AddResources.cam.position.x - 3.8f+ (105 / Pixels), AddResources.cam.position.y - 2 + (10 / Pixels), 50 / Pixels, 60 / Pixels);
            CasaR.set(AddResources.cam.position.x - 3.8f+ (105 / Pixels), AddResources.cam.position.y - 2 + (10 / Pixels), 50 / Pixels, 40 / Pixels);
            CasaS.draw(batch);
            if(MyGdxGame.Maceta1Colocadas.getInteger("Posiciones5") < 3)
            {
                Maceta1R.set(AddResources.cam.position.x - 3.8f+ (95 / Pixels), AddResources.cam.position.y - 2 + (70 / Pixels), 32 / Pixels, 32 / Pixels);
            }else
            {
                Maceta1R.set(0,0,0,0);
                alphaMaceta1 = 0.4f;
            }
            Maceta1S.setBounds(AddResources.cam.position.x - 3.8f+ (95 / Pixels), AddResources.cam.position.y - 2 + (70 / Pixels), 32 / Pixels, 32 / Pixels);
            Maceta1S.setAlpha(alphaMaceta1);
            Maceta1S.draw(batch);
            Maceta2S.setBounds(AddResources.cam.position.x - 3.8f+ (130 / Pixels), AddResources.cam.position.y - 2 + (70 / Pixels), 32 / Pixels, 32 / Pixels);
            Maceta2R.set(AddResources.cam.position.x - 3.8f+ (130 / Pixels), AddResources.cam.position.y - 2 + (70 / Pixels), 32 / Pixels, 32 / Pixels);
            Maceta2S.draw(batch);
            Arbusto1S.setBounds(AddResources.cam.position.x - 3.8f+ (160 / Pixels), AddResources.cam.position.y - 2 + (10 / Pixels), 32 / Pixels, 32 / Pixels);
            Arbusto1R.set(AddResources.cam.position.x - 3.8f+ (160 / Pixels), AddResources.cam.position.y - 2 + (10 / Pixels), 32 / Pixels, 32 / Pixels);
            Arbusto1S.draw(batch);
            Arbusto2S.setBounds(AddResources.cam.position.x - 3.8f+ (160 / Pixels), AddResources.cam.position.y - 2 + (64 / Pixels), 50/ Pixels, 50/ Pixels);
            Arbusto2R.set(AddResources.cam.position.x - 3.8f+ (160 / Pixels), AddResources.cam.position.y - 2 + (64 / Pixels), 50/ Pixels, 50/ Pixels);
            Arbusto2S.draw(batch);

            if(Casa2PisosR.overlaps(puntero))
            {
                MenuBuild.CasasDosPisosBuild = true;
                MenuBuild.CasasBuild = false;
                MenuBuild.Maceta1Build = false;
                MenuBuild.Maceta2Build = false;
            }
            if(CasaR.overlaps(puntero))
            {
                MenuBuild.CasasDosPisosBuild = false;
                MenuBuild.CasasBuild = true;
                MenuBuild.Maceta1Build = false;
                MenuBuild.Maceta2Build = false;
            }
            if(Maceta1R.overlaps(puntero))
            {
                MenuBuild.CasasDosPisosBuild = false;
                MenuBuild.CasasBuild = false;
                MenuBuild.Maceta1Build = true;
                MenuBuild.Maceta2Build = false;
            }
            if(Maceta2R.overlaps(puntero))
            {
                MenuBuild.CasasDosPisosBuild = false;
                MenuBuild.CasasBuild = false;
                MenuBuild.Maceta1Build = false;
                MenuBuild.Maceta2Build = true;
            }
        }
        /***************************************************************************/
        /***************************************************************************/
        /***************************************************************************/
        /***************************************************************************/
        /***************************************************************************/
        /***************************************************************************/
        /***************************************************************************/
        /***************************************************************************/
        /***************************************************************************/
        /***************************************************************************/
        /***************************************************************************/
        /***************************************************************************/

        if(isMenu4)
        {
            MenuBuild.timeCultivos = 0;
        }
    }

    @Override
    public void act(float delta) {

    }

    @Override
    public void dispose() {
        logo.dispose();
        fondo.dispose();
        logo1.dispose();
        logo2.dispose();
        logo3.dispose();
        logo4.dispose();
        equis.dispose();
        Tierra.dispose();
        Agua.dispose();
        Trigo.dispose();
        Maiz.dispose();
        Soja.dispose();
        Zanahoria.dispose();
        Cana.dispose();
        Algodon.dispose();
        flechaVerde.dispose();
        flechaRoja.dispose();
        mover.dispose();
        Casa2Pisos.dispose();
        Casa.dispose();
        Maceta1.dispose();
        Maceta2.dispose();
        Arbusto1.dispose();
        Arbusto2.dispose();
    }
}
