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

    /****MoverButton****/
    Texture mover;
    public static Rectangle moverR;
   public static Sprite moverS;
   public static boolean isMover;
    float moverTime;
    float alphaMover;
    /******Cultivos******/
    public static float timeCultivos;

    public static Texture flechaVerde;
    public static boolean isMenuSeedSelection;
    float abs;
    boolean sube= true,baja;
    public static float timeQuitar;

    public static boolean isTierra1,isTierra2,isTierra3,isTierra4,isTierra5;


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
        /**************************************/
        if(MyGdxGame.tierra1Enable.getBoolean("tierra1")) {
            if (Tierra1.isDamp) {
                if (Tierra1.Cuerpo.overlaps(Jugador.jugador)) {
                    float x = Tierra1.Cuerpo.x;
                    float y = (Tierra1.Cuerpo.y + Tierra1.Cuerpo.height) + (abs / Pixels);
                    batch.draw(flechaVerde, x, y, 32 / Pixels, 32 / Pixels);
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
    }
    public void MenuSeedsSelection(Batch batch)
    {
        if(isMenuSeedSelection) {
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
                      MyGdxGame.tierra1Trigo.putBoolean("tierra1",true);
                        MyGdxGame.tierra1Trigo.flush();
                    }
                    if(isTierra2)
                    {
                      //  Tierra1.Trigo = true;
                    }
                    if(isTierra3)
                    {

                    }
                    if(isTierra4)
                    {

                    }
                    if(isTierra5)
                    {

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
                        MyGdxGame.tierra1Maiz.putBoolean("tierra1",true);
                        MyGdxGame.tierra1Maiz.flush();
                    }
                    if(isTierra2)
                    {
                        //  Tierra1.Trigo = true;
                    }
                    if(isTierra3)
                    {

                    }
                    if(isTierra4)
                    {

                    }
                    if(isTierra5)
                    {

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
                        MyGdxGame.tierra1Soja.putBoolean("tierra1",true);
                        MyGdxGame.tierra1Soja.flush();
                    }
                    if(isTierra2)
                    {
                        //  Tierra1.Trigo = true;
                    }
                    if(isTierra3)
                    {

                    }
                    if(isTierra4)
                    {

                    }
                    if(isTierra5)
                    {

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
                        MyGdxGame.tierra1Zanahoria.putBoolean("tierra1",true);
                        MyGdxGame.tierra1Zanahoria.flush();
                    }
                    if(isTierra2)
                    {
                        //  Tierra1.Trigo = true;
                    }
                    if(isTierra3)
                    {

                    }
                    if(isTierra4)
                    {

                    }
                    if(isTierra5)
                    {

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
                        MyGdxGame.tierra1Cana.putBoolean("tierra1",true);
                        MyGdxGame.tierra1Cana.flush();
                    }
                    if(isTierra2)
                    {
                        //  Tierra1.Trigo = true;
                    }
                    if(isTierra3)
                    {

                    }
                    if(isTierra4)
                    {

                    }
                    if(isTierra5)
                    {

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
                        MyGdxGame.tierra1Algodon.putBoolean("tierra1",true);
                        MyGdxGame.tierra1Algodon.flush();
                    }
                    if(isTierra2)
                    {
                        //  Tierra1.Trigo = true;
                    }
                    if(isTierra3)
                    {

                    }
                    if(isTierra4)
                    {

                    }
                    if(isTierra5)
                    {

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
            tierraR.set(AddResources.cam.position.x - 3.8f+ (40 / Pixels), AddResources.cam.position.y - 2 + (20 / Pixels), 30 / Pixels, 30 / Pixels);
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
        if(isMenu3)
        {
            MenuBuild.timeCultivos = 0;
        }
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
        mover.dispose();
    }
}
