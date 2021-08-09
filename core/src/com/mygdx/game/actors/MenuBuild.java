package com.mygdx.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.game.Menu;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.tiled.AddResources;

import static com.mygdx.game.MyGdxGame.CasaDosPisos1;
import static com.mygdx.game.MyGdxGame.CorralGallinasColocadas;
import static com.mygdx.game.MyGdxGame.CorralVacaColocadas;
import static com.mygdx.game.MyGdxGame.Pixels;
import static com.mygdx.game.MyGdxGame.agua1;
import static com.mygdx.game.MyGdxGame.tierra1Maiz;

public class MenuBuild extends Actor implements Disposable
{

    Texture logo;
     public static Sprite Logo;
    public static Rectangle Cuadro;
    float time;
    public static boolean isMenu;

    /*****Menu****/
    public static float timeRetrasar; //retrasa la seleccion para no seleccionar un menu por accidente
    Texture equis;
    Texture fondo,logo1,logo2,logo3,logo4;
    public static Rectangle Menu1,Menu2,Menu3,Menu4,Salir;
    public static Sprite Fondo,Fondo2,Fondo3,Logo1,Logo2,Logo3,Logo4;
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
    float alphaMover = 0f;
    /****AlmacenButton****/
    Texture Almacen;
    public static Rectangle AlmacenR;
    public static Sprite AlmacenS;
    public static boolean isAlmacen;
    float AlmacenTime;
    float alphaAlmacen = 0f;
    /******Cultivos******/
    public static float timeCultivos;

    public static Texture flechaVerde,flechaRoja;
    public static boolean isMenuSeedSelection;
    float abs;
    boolean sube= true,baja;
    public static float timeQuitar;

    public static boolean isTierra1,isTierra2,isTierra3,isTierra4,isTierra5;
    /******Menu2******/
    public static float timeMenu2 = 0;
    float alphaCasa2 = 1,alphaCasa1 = 1,alphaMaceta1 = 1,alphaMaceta2 = 1,alphaArbusto1 = 1,alphaArbusto2 = 1;
    public static boolean CasasDosPisosBuild;
    public static boolean CasasBuild;
    public static boolean Maceta1Build;
    public static boolean Maceta2Build;
    public static boolean Arbusto1Build;
    public static boolean Arbusto2Build;
    public static Rectangle Casa2PisosR,CasaR,Maceta1R,Maceta2R,Arbusto1R,Arbusto2R;
    Texture Arbusto1,Arbusto2;
    Sprite Arbusto1S,Arbusto2S;
    Texture Maceta1,Maceta2;
    Sprite Maceta1S,Maceta2S;
    Texture Casa2Pisos,Casa;
    Sprite Casa2PisosS,CasaS;
    Texture negro;
    /******Menu3******/
    public static float timeMenu3 = 0;
    public static boolean isCorralVacasBuild,isCorralGallinasBuild;
    Texture Flecha;
    Rectangle FlechaR;
    public static boolean isSelectMenu3;
    public static float timeFlecha;
    Texture CorralVacas;
    Sprite CorralVacasS;
    Rectangle CorralVacasR;
    Texture CorralGallinas;
    Sprite CorralGallinasS;
    Rectangle CorralGallinasR;
    /**Menu4**/
    public static boolean buildMaquinaComida;
    float alphaMaquina = 1;
    Sprite MaquinaComidaS;
    Texture MaquinaComida;
    Rectangle MaquinaComidaR;

    /**ALmacen de Recursos**/
    public static Texture TrigoA,MaizA,SojaA,ZanahoriaA,CanaA,AlgodonA,LecheA,HuevosA,ComidaVaca,ComidaGallina;

    public static Sprite w;
    public static Texture Blanco;
    public static Container c1,c2,c3,c4,c5,c6,c7,c8,c9,c10;
    public static Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;


    public static boolean vacaBuild = false,gallinaBuild = false;

    Texture GallinitaUWU;
    Sprite GallinaS;
    Rectangle GallinaR;

    Texture Vaca;
    Sprite VacaS;
    Rectangle VacaR;

    /**MandarAlmacen**/
    public static float FiguraX,FiguraY,diferencia,AlmacenX = 4, EY;
    public static boolean TrigoB,MaizB,SojaB,ZanahoriaB,CanaB,AlgodonB,LecheB,HuevosB,ComidaVacaB,ComidaGallinaB;
    public static int iteratorAlmacen = 0;
    public static boolean MandarAlmacen;
    public static Rectangle Figura;

    public MenuBuild()
    {
        negro = new Texture("White.png");
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
        Fondo3 = new Sprite(fondo);


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
        Arbusto1 = new Texture("BoteAguaS.png");
        Arbusto1S = new Sprite(Arbusto1);
        Arbusto2 = new Texture("Arbusto2.png");
        Arbusto2S = new Sprite(Arbusto2);

        Casa2PisosR = new Rectangle();
        CasaR = new Rectangle();
        Maceta1R = new Rectangle();
        Maceta2R = new Rectangle();
        Arbusto1R = new Rectangle();
        Arbusto2R = new Rectangle();

        /***menu3***/
        CorralVacas =  new Texture("CorralVacas.png");
        CorralVacasS = new Sprite(CorralVacas);
        CorralVacasR = new Rectangle();

        CorralGallinas =  new Texture("CorralGallinas.png");
        CorralGallinasS = new Sprite(CorralGallinas);
        CorralGallinasR = new Rectangle();

        Flecha = new Texture("FlechaSiguiente.png");
        FlechaR = new Rectangle();
        GallinitaUWU = new Texture("Gallina.png");
        GallinaS = new Sprite(GallinitaUWU);
        GallinaR = new Rectangle();

        Vaca = new Texture("Vaca.png");
        VacaR = new Rectangle();
        VacaS = new Sprite(Vaca);

        /**Menu4**/
        MaquinaComida = new Texture("MaquinaComida.png");
        MaquinaComidaS = new Sprite(MaquinaComida);
        MaquinaComidaR = new Rectangle();
        /**AlmacenButton**/
        Almacen = new Texture("Almacen.png");
        AlmacenS = new Sprite(Almacen);
        AlmacenR = new Rectangle();
        TrigoA = new Texture("Almacen/TrigoS.png");
        MaizA = new Texture("Almacen/MaizS.png");
        SojaA = new Texture("Almacen/SojaS.png");
        ZanahoriaA = new Texture("Almacen/ZanahoriaS.png");
        CanaA = new Texture("Almacen/CañaS.png");
        AlgodonA = new Texture("Almacen/AlgodonS.png");
        LecheA = new Texture("Almacen/Leche.png");
        HuevosA = new Texture("Almacen/Huevos.png");
        ComidaVaca = new Texture("Almacen/ComidaVaca.png");
        ComidaGallina = new Texture("Almacen/ComidaGallina.png");
        Blanco = new Texture("Blanco.png");
         w = new Sprite(Blanco);
        l1 = new Label("",new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        l2 = new Label("",new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        l3 = new Label("",new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        l4 = new Label("",new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        l5 = new Label("",new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        l6 = new Label("",new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        l7 = new Label("",new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        l8 = new Label("",new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        l9 = new Label("",new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        l10= new Label("",new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        c1 = new Container<Label>(l1);
        c2 = new Container<Label>(l2);
        c3 = new Container<Label>(l3);
        c4 = new Container<Label>(l4);
        c5 = new Container<Label>(l5);
        c6 = new Container<Label>(l6);
        c7 = new Container<Label>(l7);
        c8 = new Container<Label>(l8);
        c9 = new Container<Label>(l9);
        c10 = new Container<Label>(l10);
        c1.setTransform(true);
        c2.setTransform(true);
        c3.setTransform(true);
        c4.setTransform(true);
        c5.setTransform(true);
        c6.setTransform(true);
        c7.setTransform(true);
        c8.setTransform(true);
        c9.setTransform(true);
       c10.setTransform(true);

       //MandarAlmacen//
        Figura = new Rectangle();

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        time += 1 * Gdx.graphics.getDeltaTime();
        timeMenu2 += 1 * Gdx.graphics.getDeltaTime();
        timeMenu3 += 1 * Gdx.graphics.getDeltaTime();
        Logo.setBounds(AddResources.cam.position.x - 3.8f, AddResources.cam.position.y , 20 / Pixels, 20 / Pixels);
        Logo.setAlpha(.8f);
        Fondo2.setBounds(AddResources.cam.position.x - 3.8f, AddResources.cam.position.y+(25/Pixels) , 20 / Pixels, 20 / Pixels);
        Fondo2.setAlpha(alphaMover);
        moverS.setBounds(AddResources.cam.position.x - 3.8f, AddResources.cam.position.y+(25/Pixels) , 20 / Pixels, 20 / Pixels);
        moverS.setAlpha(.8f);
        moverTime += 1 * Gdx.graphics.getDeltaTime();
        if(moverTime > 1) {
            if (moverR.overlaps(AddResources.puntero)) {
                if(isMover)
                {
                    isMover = false;
                    alphaMover = 0f;
                }else
                {
                    isMover = true;
                    alphaMover = 0.8f;
                }

                moverTime = 0;

            }
        }
        Fondo3.setBounds(AddResources.cam.position.x  +3, AddResources.cam.position.y+(25/Pixels) , 20 / Pixels, 20 / Pixels);
        Fondo3.setAlpha(alphaAlmacen);
        AlmacenS.setBounds(AddResources.cam.position.x +3, AddResources.cam.position.y+(25/Pixels) , 20 / Pixels, 20 / Pixels);
        AlmacenS.setAlpha(.8f);
        AlmacenTime += 1 * Gdx.graphics.getDeltaTime();
        if(AlmacenTime > 1) {
            if (AlmacenR.overlaps(AddResources.puntero)) {
                if(isAlmacen)
                {
                    isAlmacen = false;
                    alphaAlmacen = 0f;
                }else
                {
                    isAlmacen = true;
                    alphaAlmacen = 0.8f;
                }

                AlmacenTime = 0;

            }
        }
        if(!isMenuSeedSelection) {
            Cuadro.set(AddResources.cam.position.x - 3.8f, AddResources.cam.position.y, 20 / Pixels, 20 / Pixels);
        }
        if(time > 1 && Cuadro.overlaps(AddResources.puntero))
        {
                isMenu = true;
                time = 0;
        }

        if(isMenu) {
            timeCultivos += 1 * Gdx.graphics.getDeltaTime();
            timeRetrasar = timeRetrasar + 1 * Gdx.graphics.getDeltaTime();

        }else
        {
            timeRetrasar = 0;
        }
        if(MenuBuild.BuildTierra||MenuBuild.BuildAgua||MenuBuild.BuildMover||MenuBuild.CasasDosPisosBuild||MenuBuild.CasasBuild||MenuBuild.Maceta1Build||MenuBuild.Maceta2Build||MenuBuild.Arbusto1Build||MenuBuild.Arbusto2Build)
        {
            timeRetrasar = 0;
        }
        MenuSeeds(batch);
        /*if(Gdx.input.isTouched()) {
            MandarAlmacen = true;
            FiguraX = Tierra1.Cuerpo.x + (10 / Pixels);
            FiguraY = Tierra1.Cuerpo.y + (32 / Pixels);
        }*/
    }

    public static void MandarAlmacen(Batch batch,float Iy)
    {
        if(MenuBuild.FiguraX < AddResources.cam.position.x +3)
        {
            MenuBuild.FiguraX += (180/Pixels)*Gdx.graphics.getDeltaTime();
        }else
        {
            MenuBuild.FiguraX = AddResources.cam.position.x +3;
        }
        MenuBuild.AlmacenX = AlmacenX + (Gdx.graphics.getDeltaTime());
        MenuBuild.EY = (float) Math.pow(.90f*(MenuBuild.AlmacenX),2);
          if(MenuBuild.iteratorAlmacen == 0) {

              MenuBuild.diferencia = MenuBuild.EY - MenuBuild.FiguraY;
              MenuBuild.iteratorAlmacen++;
          }
        MenuBuild.EY = MenuBuild.EY - MenuBuild.diferencia;
          if(MenuBuild.EY < AddResources.cam.position.y+(25/Pixels) ) {

          }else
          {
              EY = AddResources.cam.position.y+(25/Pixels);
          }

          /*if(Gdx.input.isTouched()) {
              Gdx.app.log("EY", "" + EY);
              Gdx.app.log("AlmacenX", "" + MenuBuild.AlmacenX);
              Gdx.app.log("resources", "" + AddResources.cam.position.y + (25 / Pixels));
              Gdx.app.log("Diferencia", "" + MenuBuild.diferencia);
          }*/
          Figura.set(FiguraX,EY,5/Pixels,5/Pixels);
          if(TrigoB)
          {
              batch.draw(MenuBuild. TrigoA,FiguraX,EY,15/Pixels,15/Pixels);
          }else if(MaizB)
          {
              batch.draw(MenuBuild. MaizA,FiguraX,EY,15/Pixels,15/Pixels);
          }else if(SojaB)
          {
              batch.draw(MenuBuild. SojaA,FiguraX,EY,15/Pixels,15/Pixels);
          }else if(ZanahoriaB)
          {
              batch.draw(MenuBuild. ZanahoriaA,FiguraX,EY,15/Pixels,15/Pixels);
          }else if(CanaB)
          {
              batch.draw(MenuBuild. CanaA,FiguraX,EY,15/Pixels,15/Pixels);
          }else if(AlgodonB)
          {
              batch.draw(MenuBuild. AlgodonA,FiguraX,EY,15/Pixels,15/Pixels);
          }
          else if(LecheB)
          {
              batch.draw(MenuBuild. LecheA,FiguraX,EY,15/Pixels,15/Pixels);
          }
          else if(HuevosB)
          {
              batch.draw(MenuBuild. HuevosA,FiguraX,EY,15/Pixels,15/Pixels);
          }
          else if(ComidaVacaB)
          {
              batch.draw(MenuBuild. ComidaVaca,FiguraX,EY,15/Pixels,15/Pixels);
          }
          else if(ComidaGallinaB)
          {
              batch.draw(MenuBuild. ComidaGallina,FiguraX,EY,15/Pixels,15/Pixels);
          }

if(MenuBuild.Figura.overlaps(MenuBuild.AlmacenR))
{
    MenuBuild.MandarAlmacen = false;
}
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
                            if(MyGdxGame.tierra1Trigo.getBoolean("tierra11"))
                            {
                                TrigoB = true;
                                int actual  = MyGdxGame.TrigoStocks.getInteger("TrigoStocks");
                                actual += 3;
                                MyGdxGame.TrigoStocks.putInteger("TrigoStocks",actual);
                                MyGdxGame.TrigoStocks.flush();
                            }

                            if(MyGdxGame.tierra1Maiz.getBoolean("tierra12"))
                            {
                                MaizB = true;
                                int actual  = MyGdxGame.MaizStocks.getInteger("MaizStocks");
                                actual += 3;
                                MyGdxGame.MaizStocks.putInteger("MaizStocks",actual);
                                MyGdxGame.MaizStocks.flush();
                            }

                            if(MyGdxGame.tierra1Soja.getBoolean("tierra13"))
                            {
                                SojaB = true;
                                int actual  = MyGdxGame.SojaStocks.getInteger("SojaStocks");
                                actual += 3;
                                MyGdxGame.SojaStocks.putInteger("SojaStocks",actual);
                                MyGdxGame.SojaStocks.flush();
                            }

                            if(MyGdxGame.tierra1Zanahoria.getBoolean("tierra14"))
                            {
                                ZanahoriaB = true;
                                int actual  = MyGdxGame.ZanahoriaStocks.getInteger("ZanahoriaStocks");
                                actual += 3;
                                MyGdxGame.ZanahoriaStocks.putInteger("ZanahoriaStocks",actual);
                                MyGdxGame.ZanahoriaStocks.flush();
                            }

                            if(MyGdxGame.tierra1Cana.getBoolean("tierra15"))
                            {
                                CanaB = true;
                                int actual  = MyGdxGame.CanaStocks.getInteger("CanaStocks");
                                actual += 3;
                                MyGdxGame.CanaStocks.putInteger("CanaStocks",actual);
                                MyGdxGame.CanaStocks.flush();
                            }

                            if(MyGdxGame.tierra1Algodon.getBoolean("tierra16"))
                            {
                                AlgodonB = true;
                                int actual  = MyGdxGame.AlgodonStocks.getInteger("AlgodonStocks");
                                actual += 3;
                                MyGdxGame.AlgodonStocks.putInteger("AlgodonStocks",actual);
                                MyGdxGame.AlgodonStocks.flush();
                            }
                            MandarAlmacen = true;
                            FiguraX = Tierra1.Cuerpo.x+(10/Pixels);
                            FiguraY = Tierra1.Cuerpo.y+(32/Pixels);
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
                            if(MyGdxGame.tierra2Trigo.getBoolean("tierra21"))
                            {
                                TrigoB = true;
                                int actual  = MyGdxGame.TrigoStocks.getInteger("TrigoStocks");
                                actual += 3;
                                MyGdxGame.TrigoStocks.putInteger("TrigoStocks",actual);
                                MyGdxGame.TrigoStocks.flush();
                            }

                            if(MyGdxGame.tierra2Maiz.getBoolean("tierra22"))
                            {
                                MaizB = true;
                                int actual  = MyGdxGame.MaizStocks.getInteger("MaizStocks");
                                actual += 3;
                                MyGdxGame.MaizStocks.putInteger("MaizStocks",actual);
                                MyGdxGame.MaizStocks.flush();
                            }

                            if(MyGdxGame.tierra2Soja.getBoolean("tierra23"))
                            {
                                SojaB = true;
                                int actual  = MyGdxGame.SojaStocks.getInteger("SojaStocks");
                                actual += 3;
                                MyGdxGame.SojaStocks.putInteger("SojaStocks",actual);
                                MyGdxGame.SojaStocks.flush();
                            }

                            if(MyGdxGame.tierra2Zanahoria.getBoolean("tierra24"))
                            {
                                ZanahoriaB = true;
                                int actual  = MyGdxGame.ZanahoriaStocks.getInteger("ZanahoriaStocks");
                                actual += 3;
                                MyGdxGame.ZanahoriaStocks.putInteger("ZanahoriaStocks",actual);
                                MyGdxGame.ZanahoriaStocks.flush();
                            }

                            if(MyGdxGame.tierra2Cana.getBoolean("tierra25"))
                            {
                                CanaB = true;
                                int actual  = MyGdxGame.CanaStocks.getInteger("CanaStocks");
                                actual += 3;
                                MyGdxGame.CanaStocks.putInteger("CanaStocks",actual);
                                MyGdxGame.CanaStocks.flush();
                            }

                            if(MyGdxGame.tierra2Algodon.getBoolean("tierra26"))        {
                                AlgodonB = true;
                                int actual  = MyGdxGame.AlgodonStocks.getInteger("AlgodonStocks");
                                actual += 3;
                                MyGdxGame.AlgodonStocks.putInteger("AlgodonStocks",actual);
                                MyGdxGame.AlgodonStocks.flush();
                            }
                            MandarAlmacen = true;
                            FiguraX = Tierra2.Cuerpo.x+(10/Pixels);
                            FiguraY = Tierra2.Cuerpo.y+(32/Pixels);
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
                            if(MyGdxGame.tierra3Trigo.getBoolean("tierra31"))
                            {
                                TrigoB = true;
                                int actual  = MyGdxGame.TrigoStocks.getInteger("TrigoStocks");
                                actual += 3;
                                MyGdxGame.TrigoStocks.putInteger("TrigoStocks",actual);
                                MyGdxGame.TrigoStocks.flush();
                            }

                            if(MyGdxGame.tierra3Maiz.getBoolean("tierra32"))
                            {
                                MaizB = true;
                                int actual  = MyGdxGame.MaizStocks.getInteger("MaizStocks");
                                actual += 3;
                                MyGdxGame.MaizStocks.putInteger("MaizStocks",actual);
                                MyGdxGame.MaizStocks.flush();
                            }

                            if(MyGdxGame.tierra3Soja.getBoolean("tierra33"))
                            {
                                SojaB = true;
                                int actual  = MyGdxGame.SojaStocks.getInteger("SojaStocks");
                                actual += 3;
                                MyGdxGame.SojaStocks.putInteger("SojaStocks",actual);
                                MyGdxGame.SojaStocks.flush();
                            }

                            if(MyGdxGame.tierra3Zanahoria.getBoolean("tierra34"))
                            {
                                ZanahoriaB = true;
                                int actual  = MyGdxGame.ZanahoriaStocks.getInteger("ZanahoriaStocks");
                                actual += 3;
                                MyGdxGame.ZanahoriaStocks.putInteger("ZanahoriaStocks",actual);
                                MyGdxGame.ZanahoriaStocks.flush();
                            }

                            if(MyGdxGame.tierra3Cana.getBoolean("tierra35"))
                            {
                                CanaB = true;
                                int actual  = MyGdxGame.CanaStocks.getInteger("CanaStocks");
                                actual += 3;
                                MyGdxGame.CanaStocks.putInteger("CanaStocks",actual);
                                MyGdxGame.CanaStocks.flush();
                            }

                            if(MyGdxGame.tierra3Algodon.getBoolean("tierra36"))        {
                                AlgodonB = true;
                                int actual  = MyGdxGame.AlgodonStocks.getInteger("AlgodonStocks");
                                actual += 3;
                                MyGdxGame.AlgodonStocks.putInteger("AlgodonStocks",actual);
                                MyGdxGame.AlgodonStocks.flush();
                            }
                            MandarAlmacen = true;
                            FiguraX = Tierra3.Cuerpo.x+(10/Pixels);
                            FiguraY = Tierra3.Cuerpo.y+(32/Pixels);
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
                            if(MyGdxGame.tierra4Trigo.getBoolean("tierra41"))
                            {
                                TrigoB = true;
                                int actual  = MyGdxGame.TrigoStocks.getInteger("TrigoStocks");
                                actual += 3;
                                MyGdxGame.TrigoStocks.putInteger("TrigoStocks",actual);
                                MyGdxGame.TrigoStocks.flush();
                            }

                            if(MyGdxGame.tierra4Maiz.getBoolean("tierra42"))
                            {
                                MaizB = true;
                                int actual  = MyGdxGame.MaizStocks.getInteger("MaizStocks");
                                actual += 3;
                                MyGdxGame.MaizStocks.putInteger("MaizStocks",actual);
                                MyGdxGame.MaizStocks.flush();
                            }

                            if(MyGdxGame.tierra4Soja.getBoolean("tierra43"))
                            {
                                SojaB = true;
                                int actual  = MyGdxGame.SojaStocks.getInteger("SojaStocks");
                                actual += 3;
                                MyGdxGame.SojaStocks.putInteger("SojaStocks",actual);
                                MyGdxGame.SojaStocks.flush();
                            }

                            if(MyGdxGame.tierra4Zanahoria.getBoolean("tierra44"))
                            {
                                ZanahoriaB = true;
                                int actual  = MyGdxGame.ZanahoriaStocks.getInteger("ZanahoriaStocks");
                                actual += 3;
                                MyGdxGame.ZanahoriaStocks.putInteger("ZanahoriaStocks",actual);
                                MyGdxGame.ZanahoriaStocks.flush();
                            }

                            if(MyGdxGame.tierra4Cana.getBoolean("tierra45"))
                            {
                                CanaB = true;
                                int actual  = MyGdxGame.CanaStocks.getInteger("CanaStocks");
                                actual += 3;
                                MyGdxGame.CanaStocks.putInteger("CanaStocks",actual);
                                MyGdxGame.CanaStocks.flush();
                            }

                            if(MyGdxGame.tierra4Algodon.getBoolean("tierra46"))        {
                                AlgodonB = true;
                                int actual  = MyGdxGame.AlgodonStocks.getInteger("AlgodonStocks");
                                actual += 3;
                                MyGdxGame.AlgodonStocks.putInteger("AlgodonStocks",actual);
                                MyGdxGame.AlgodonStocks.flush();
                            }
                            MandarAlmacen = true;
                            FiguraX = Tierra4.Cuerpo.x+(10/Pixels);
                            FiguraY = Tierra4.Cuerpo.y+(32/Pixels);
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
                            if(MyGdxGame.tierra5Trigo.getBoolean("tierra51"))
                            {
                                TrigoB  = true;
                                int actual  = MyGdxGame.TrigoStocks.getInteger("TrigoStocks");
                                actual += 3;
                                MyGdxGame.TrigoStocks.putInteger("TrigoStocks",actual);
                                MyGdxGame.TrigoStocks.flush();
                            }

                            if(MyGdxGame.tierra5Maiz.getBoolean("tierra52"))
                            {
                                MaizB = true;
                                int actual  = MyGdxGame.MaizStocks.getInteger("MaizStocks");
                                actual += 3;
                                MyGdxGame.MaizStocks.putInteger("MaizStocks",actual);
                                MyGdxGame.MaizStocks.flush();
                            }

                            if(MyGdxGame.tierra5Soja.getBoolean("tierra53"))
                            {
                                SojaB = true;
                                int actual  = MyGdxGame.SojaStocks.getInteger("SojaStocks");
                                actual += 3;
                                MyGdxGame.SojaStocks.putInteger("SojaStocks",actual);
                                MyGdxGame.SojaStocks.flush();
                            }

                            if(MyGdxGame.tierra5Zanahoria.getBoolean("tierra54"))
                            {
                                ZanahoriaB = true;
                                int actual  = MyGdxGame.ZanahoriaStocks.getInteger("ZanahoriaStocks");
                                actual += 3;
                                MyGdxGame.ZanahoriaStocks.putInteger("ZanahoriaStocks",actual);
                                MyGdxGame.ZanahoriaStocks.flush();
                            }

                            if(MyGdxGame.tierra5Cana.getBoolean("tierra55"))
                            {
                                CanaB = true;
                                int actual  = MyGdxGame.CanaStocks.getInteger("CanaStocks");
                                actual += 3;
                                MyGdxGame.CanaStocks.putInteger("CanaStocks",actual);
                                MyGdxGame.CanaStocks.flush();
                            }

                            if(MyGdxGame.tierra5Algodon.getBoolean("tierra56"))        {
                                AlgodonB = true;
                                int actual  = MyGdxGame.AlgodonStocks.getInteger("AlgodonStocks");
                                actual += 3;
                                MyGdxGame.AlgodonStocks.putInteger("AlgodonStocks",actual);
                                MyGdxGame.AlgodonStocks.flush();
                            }
                            MandarAlmacen = true;
                            FiguraX = Tierra5.Cuerpo.x+(10/Pixels);
                            FiguraY = Tierra5.Cuerpo.y+(32/Pixels);
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
            Fondo.setBounds(AddResources.cam.position.x - 3.8f + (30 / Pixels), AddResources.cam.position.y - 2 + (5 / Pixels), 138 / Pixels, 100 / Pixels);
            Fondo.setAlpha(0.8f);
            Fondo.draw(batch);
            batch.draw(equis, AddResources.cam.position.x - 3.8f + (155 / Pixels), AddResources.cam.position.y - 2 + (90 / Pixels), 10 / Pixels, 10 / Pixels);
            Salir.set(AddResources.cam.position.x - 3.8f + (155/ Pixels), AddResources.cam.position.y - 2 + (90 / Pixels), 10 / Pixels, 10 / Pixels);

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

    public static void Almacen(Batch batch)
    {
        if(isAlmacen) {
            Fondo.setBounds(AddResources.cam.position.x - 3.8f + (10 / Pixels), AddResources.cam.position.y - 2 , 180 / Pixels, (110/ Pixels));
            Fondo.setAlpha(0.8f);
            Fondo.draw(batch);
            /****/
            w.setAlpha(0.2f);
            w.setBounds(AddResources.cam.position.x - 3.8f + (22 / Pixels),AddResources.cam.position.y - 2 + (10 / Pixels),28/Pixels,10/Pixels);
            w.draw(batch);
            batch.draw(TrigoA,AddResources.cam.position.x - 3.8f + (20 / Pixels),AddResources.cam.position.y - 2 + (20 / Pixels),32/Pixels,32/Pixels);
            l1.setText("X"+MyGdxGame.TrigoStocks.getInteger("TrigoStocks"));
            l1.setWrap(true);
            l1.setPosition(AddResources.cam.position.x - 3.8f + (29 / Pixels),AddResources.cam.position.y - 2 + (15/ Pixels));
            c1.setBounds(AddResources.cam.position.x - 3.8f + (29 / Pixels),AddResources.cam.position.y - 2 + (15 / Pixels),28/Pixels,10/Pixels);
            c1.setPosition(AddResources.cam.position.x - 3.8f + (29 / Pixels),AddResources.cam.position.y - 2 + (15 / Pixels));//+5,+3,7,5
            c1.setScale(.02f);
            AddResources.stage2.addActor(c1);
            /****/
            w.setAlpha(0.2f);
            w.setBounds(AddResources.cam.position.x - 3.8f + (54 / Pixels),AddResources.cam.position.y - 2 + (10 / Pixels),28/Pixels,10/Pixels);
            w.draw(batch);
            batch.draw(MaizA,AddResources.cam.position.x - 3.8f + (52 / Pixels),AddResources.cam.position.y - 2 + (20 / Pixels),32/Pixels,32/Pixels);
            l2.setText("X"+MyGdxGame.MaizStocks.getInteger("MaizStocks"));
            l2.setWrap(true);
            l2.setPosition((AddResources.cam.position.x - 3.8f) + (61 / Pixels),AddResources.cam.position.y - 2 + (15 / Pixels));
            c2.setBounds(AddResources.cam.position.x - 3.8f + (61 / Pixels),AddResources.cam.position.y - 2 + (15 / Pixels),28/Pixels,10/Pixels);
            c2.setPosition(AddResources.cam.position.x - 3.8f + (61 / Pixels),AddResources.cam.position.y - 2 + (15 / Pixels));//+5,+3,7,5
            c2.setScale(.02f);
            AddResources.stage2.addActor(c2);
            /****/
            w.setAlpha(0.2f);
            w.setBounds(AddResources.cam.position.x - 3.8f + (86 / Pixels),AddResources.cam.position.y - 2 + (10 / Pixels),28/Pixels,10/Pixels);
            w.draw(batch);
            batch.draw(SojaA,AddResources.cam.position.x - 3.8f + (84 / Pixels),AddResources.cam.position.y - 2 + (20 / Pixels),32/Pixels,32/Pixels);
            l3.setText("X"+MyGdxGame.SojaStocks.getInteger("SojaStocks"));
            l3.setWrap(true);
            l3.setPosition(AddResources.cam.position.x - 3.8f + (91 / Pixels),AddResources.cam.position.y - 2 + (15/ Pixels));
            c3.setBounds(AddResources.cam.position.x - 3.8f + (91 / Pixels),AddResources.cam.position.y - 2 + (15 / Pixels),28/Pixels,10/Pixels);
            c3.setPosition(AddResources.cam.position.x - 3.8f + (91 / Pixels),AddResources.cam.position.y - 2 + (15 / Pixels));//+5,+3,7,5
            c3.setScale(.02f);
            AddResources.stage2.addActor(c3);
            /****/
            w.setAlpha(0.2f);
            w.setBounds(AddResources.cam.position.x - 3.8f + (118 / Pixels),AddResources.cam.position.y - 2 + (10 / Pixels),28/Pixels,10/Pixels);
            w.draw(batch);
            batch.draw(ZanahoriaA,AddResources.cam.position.x - 3.8f + (116 / Pixels),AddResources.cam.position.y - 2 + (20 / Pixels),32/Pixels,32/Pixels);
            l4.setText("X"+MyGdxGame.ZanahoriaStocks.getInteger("ZanahoriaStocks"));
            l4.setWrap(true);
            l4.setPosition(AddResources.cam.position.x - 3.8f + (125 / Pixels),AddResources.cam.position.y - 2 + (15 / Pixels));
            c4.setBounds(AddResources.cam.position.x - 3.8f + (125 / Pixels),AddResources.cam.position.y - 2 + (15 / Pixels),28/Pixels,10/Pixels);
            c4.setPosition(AddResources.cam.position.x - 3.8f + (125 / Pixels),AddResources.cam.position.y - 2 + (15 / Pixels));//+5,+3,7,5
            c4.setScale(.02f);
            AddResources.stage2.addActor(c4);
            /****/
            w.setAlpha(0.2f);
            w.setBounds(AddResources.cam.position.x - 3.8f + (150 / Pixels),AddResources.cam.position.y - 2 + (10 / Pixels),28/Pixels,10/Pixels);
            w.draw(batch);
            batch.draw(CanaA,AddResources.cam.position.x - 3.8f + (148 / Pixels),AddResources.cam.position.y - 2 + (20 / Pixels),32/Pixels,32/Pixels);
            l5.setText("X"+MyGdxGame.CanaStocks.getInteger("CanaStocks"));
            l5.setWrap(true);
            l5.setPosition(AddResources.cam.position.x - 3.8f + (157 / Pixels),AddResources.cam.position.y - 2 + (15 / Pixels));
            c5.setBounds(AddResources.cam.position.x - 3.8f + (157 / Pixels),AddResources.cam.position.y - 2 + (15 / Pixels),28/Pixels,10/Pixels);
            c5.setPosition(AddResources.cam.position.x - 3.8f + (157 / Pixels),AddResources.cam.position.y - 2 + (15 / Pixels));//+5,+3,7,5
            c5.setScale(.02f);
            AddResources.stage2.addActor(c5);
            /****/
            w.setAlpha(0.2f);
            w.setBounds(AddResources.cam.position.x - 3.8f + (22 / Pixels),AddResources.cam.position.y - 2 + (58 / Pixels),28/Pixels,10/Pixels);
            w.draw(batch);
            batch.draw(AlgodonA,AddResources.cam.position.x - 3.8f + (20/ Pixels),AddResources.cam.position.y - 2 + (68 / Pixels),32/Pixels,32/Pixels);
            l6.setText("X"+MyGdxGame.AlgodonStocks.getInteger("AlgodonStocks"));
            l6.setWrap(true);
            l6.setPosition(AddResources.cam.position.x - 3.8f + (29 / Pixels),AddResources.cam.position.y - 2 + (63 / Pixels));
            c6.setBounds(AddResources.cam.position.x - 3.8f + (29 / Pixels),AddResources.cam.position.y - 2 + (63 / Pixels),28/Pixels,10/Pixels);
            c6.setPosition(AddResources.cam.position.x - 3.8f + (29 / Pixels),AddResources.cam.position.y - 2 + (63 / Pixels));//+5,+3,7,5
            c6.setScale(.02f);
            AddResources.stage2.addActor(c6);
            /****/
            w.setAlpha(0.2f);
            w.setBounds(AddResources.cam.position.x - 3.8f + (54 / Pixels),AddResources.cam.position.y - 2 + (58 / Pixels),28/Pixels,10/Pixels);
            w.draw(batch);
            batch.draw(HuevosA,AddResources.cam.position.x - 3.8f + (52 / Pixels),AddResources.cam.position.y - 2 + (68 / Pixels),32/Pixels,32/Pixels);
            l7.setText("X"+MyGdxGame.HuevosStocks.getInteger("HuevosStocks"));
            l7.setWrap(true);
            l7.setPosition(AddResources.cam.position.x - 3.8f + (61 / Pixels),AddResources.cam.position.y - 2 + (63 / Pixels));
            c7.setBounds(AddResources.cam.position.x - 3.8f + (61 / Pixels),AddResources.cam.position.y - 2 + (63 / Pixels),28/Pixels,10/Pixels);
            c7.setPosition(AddResources.cam.position.x - 3.8f + (61 / Pixels),AddResources.cam.position.y - 2 + (63 / Pixels));//+5,+3,7,5
            c7.setScale(.02f);
            AddResources.stage2.addActor(c7);
            /****/
            w.setAlpha(0.2f);
            w.setBounds(AddResources.cam.position.x - 3.8f + (86 / Pixels),AddResources.cam.position.y - 2 + (58 / Pixels),28/Pixels,10/Pixels);
            w.draw(batch);
            batch.draw(LecheA,AddResources.cam.position.x - 3.8f + (84 / Pixels),AddResources.cam.position.y - 2 + (70 / Pixels),32/Pixels,30/Pixels);
            l8.setText("X"+MyGdxGame.LecheStocks.getInteger("LecheStocks"));
            l8.setWrap(true);
            l8.setPosition(AddResources.cam.position.x - 3.8f + (93 / Pixels),AddResources.cam.position.y - 2 + (63 / Pixels));
            c8.setBounds(AddResources.cam.position.x - 3.8f + (93 / Pixels),AddResources.cam.position.y - 2 + (63 / Pixels),28/Pixels,10/Pixels);
            c8.setPosition(AddResources.cam.position.x - 3.8f + (93 / Pixels),AddResources.cam.position.y - 2 + (63 / Pixels));//+5,+3,7,5
            c8.setScale(.02f);
            AddResources.stage2.addActor(c8);
            /****/
            w.setAlpha(0.2f);
            w.setBounds(AddResources.cam.position.x - 3.8f + (118 / Pixels),AddResources.cam.position.y - 2 + (58 / Pixels),28/Pixels,10/Pixels);
            w.draw(batch);
            batch.draw(ComidaGallina,AddResources.cam.position.x - 3.8f + (116 / Pixels),AddResources.cam.position.y - 2 + (68 / Pixels),32/Pixels,32/Pixels);
            l9.setText("X"+MyGdxGame.ComidaGallinaStocks.getInteger("ComidaGallinaStocks"));
            l9.setWrap(true);
            l9.setPosition(AddResources.cam.position.x - 3.8f + (125 / Pixels),AddResources.cam.position.y - 2 + (63 / Pixels));
            c9.setBounds(AddResources.cam.position.x - 3.8f + (125 / Pixels),AddResources.cam.position.y - 2 + (63 / Pixels),28/Pixels,10/Pixels);
            c9.setPosition(AddResources.cam.position.x - 3.8f + (125 / Pixels),AddResources.cam.position.y - 2 + (63 / Pixels));//+5,+3,7,5
            c9.setScale(.02f);
            AddResources.stage2.addActor(c9);
            /****/
            w.setAlpha(0.2f);
            w.setBounds(AddResources.cam.position.x - 3.8f + (150 / Pixels),AddResources.cam.position.y - 2 + (58 / Pixels),28/Pixels,10/Pixels);
            w.draw(batch);
            batch.draw(ComidaVaca,AddResources.cam.position.x - 3.8f + (148 / Pixels),AddResources.cam.position.y - 2 + (68 / Pixels),32/Pixels,32/Pixels);
            l10.setText("X"+MyGdxGame.ComidaVacaStocks.getInteger("ComidaVacaStocks"));
            l10.setWrap(true);
            l10.setPosition(AddResources.cam.position.x - 3.8f + (157 / Pixels),AddResources.cam.position.y - 2 + (63 / Pixels));
            c10.setBounds(AddResources.cam.position.x - 3.8f + (157 / Pixels),AddResources.cam.position.y - 2 + (63 / Pixels),28/Pixels,10/Pixels);
            c10.setPosition(AddResources.cam.position.x - 3.8f + (157 / Pixels),AddResources.cam.position.y - 2 + (63 / Pixels));//+5,+3,7,5
            c10.setScale(.02f);
            AddResources.stage2.addActor(c10);
            /****/

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

            if(!MenuBuild.isSelectMenu3) {
                float alphacorralVacas;
                float alphacorralGallinas;
                if(CorralVacaColocadas.getInteger("Posiciones9") == 2)
                {
                    alphacorralVacas = .4f;
                    CorralVacasR.set(0,0,0,0);
                }else
                {
                    alphacorralVacas = 1f;
                    CorralVacasR.set(AddResources.cam.position.x - 3.8f + (40 / Pixels), AddResources.cam.position.y - 2 + (10 / Pixels), 150 / Pixels, 50 / Pixels);
                }
                if(CorralGallinasColocadas.getInteger("Posiciones10") == 2)
                {
                    alphacorralGallinas = 0.4f;
                    CorralGallinasR.set(0,0,0,0);
                }else
                {
                    alphacorralGallinas = 1f;
                    CorralGallinasR.set(AddResources.cam.position.x - 3.8f + (40 / Pixels), AddResources.cam.position.y - 2 + (60 / Pixels), 110 / Pixels, 50 / Pixels);
                }
                Fondo.setBounds(AddResources.cam.position.x - 3.8f + (40 / Pixels), AddResources.cam.position.y - 2 + (10 / Pixels), 150 / Pixels, 50 / Pixels);
                Fondo.setAlpha(0.8f);
                Fondo.draw(batch);
                CorralVacasS.setBounds(AddResources.cam.position.x - 3.8f + (40 / Pixels), AddResources.cam.position.y - 2 + (10 / Pixels), 150 / Pixels, 50 / Pixels);
                CorralVacasS.setAlpha(alphacorralVacas);
                CorralVacasS.draw(batch);

                Fondo.setBounds(AddResources.cam.position.x - 3.8f + (40 / Pixels), AddResources.cam.position.y - 2 + (60 / Pixels), 110 / Pixels, 40 / Pixels);
                Fondo.setAlpha(0.8f);
                Fondo.draw(batch);
                CorralGallinasS.setBounds(AddResources.cam.position.x - 3.8f + (40 / Pixels), AddResources.cam.position.y - 2 + (60 / Pixels), 110 / Pixels, 50 / Pixels);
                CorralGallinasS.setAlpha(alphacorralGallinas);
                CorralGallinasS.draw(batch);
            }else
            {
                float alphaGallina = 1;
                float alphaVaca;
                if(vacaBuild)
                {
                    alphaVaca = 0.4f;
                }else
                {
                    alphaVaca = 1;
                }

                if(gallinaBuild)
                {
                    alphaGallina = 0.4f;
                }else
                {
                    alphaGallina = 1;
                }


                GallinaR.set(AddResources.cam.position.x - 3.8f + (40 / Pixels), AddResources.cam.position.y - 2 + (10 / Pixels), 32/ Pixels, 32 / Pixels);
                GallinaS.setBounds(AddResources.cam.position.x - 3.8f + (40 / Pixels), AddResources.cam.position.y - 2 + (10 / Pixels), 32/ Pixels, 32 / Pixels);
                GallinaS.setAlpha(alphaGallina);
                GallinaS.draw(batch);

                VacaS.setBounds(AddResources.cam.position.x - 3.8f + (40 / Pixels), AddResources.cam.position.y - 2 + (50 / Pixels), 50/ Pixels, 35 / Pixels);
                VacaR.set(AddResources.cam.position.x - 3.8f + (40 / Pixels), AddResources.cam.position.y - 2 + (50 / Pixels), 50/ Pixels, 35 / Pixels);
                VacaS.setAlpha(alphaVaca);
                VacaS.draw(batch);

                if(VacaR.overlaps(puntero))
                {
                    MenuBuild.vacaBuild = true;
                }

                if(GallinaR.overlaps(puntero))
                {
                    MenuBuild.gallinaBuild = true;
                }


            }
            MenuBuild.timeFlecha += 1 * Gdx.graphics.getDeltaTime();
            batch.draw(Flecha,AddResources.cam.position.x - 3.8f+ (160/ Pixels), AddResources.cam.position.y - 2 + (60/ Pixels), 20 / Pixels, 20 / Pixels);
            FlechaR.set(AddResources.cam.position.x - 3.8f+ (160/ Pixels), AddResources.cam.position.y - 2 + (60/ Pixels), 20 / Pixels, 20 / Pixels);
            if(FlechaR.overlaps(puntero)&& MenuBuild.timeFlecha > 1) {
                if (isSelectMenu3) {
                    isSelectMenu3 = false;
                    MenuBuild.timeFlecha = 0;
                } else {
                    isSelectMenu3 = true;
                    MenuBuild.timeFlecha= 0;
                }
            }


            if(timeMenu3 >= 1) {
                if (CorralVacasR.overlaps(puntero)) {
                    MenuBuild.isCorralVacasBuild = true;
                    MenuBuild.timeMenu3 = 0;

                }
                if (CorralGallinasR.overlaps(puntero)) {
                    MenuBuild.isCorralGallinasBuild = true;
                    MenuBuild.timeMenu3 = 0;
                }
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
        /***************************************************************************/
        /***************************************************************************/
        /***************************************************************************/
        /***************************************************************************/
        if(isMenu3)
        {
            MenuBuild.timeCultivos = 0;
            if (MyGdxGame.CasasDosPisosColocadas.getInteger("Posiciones3") < 2) {
           } else {
                alphaCasa2 = 0.4f;

            }
            if (MyGdxGame.CasasColocadas.getInteger("Posiciones4") < 2) {
            } else {
                alphaCasa1 = 0.4f;
            }

            if (MyGdxGame.Maceta1Colocadas.getInteger("Posiciones5") < 3) {
            } else {
                alphaMaceta1 = 0.4f;
            }

            if (MyGdxGame.Maceta2Colocadas.getInteger("Posiciones6") < 3) {
            } else {
                alphaMaceta2 = 0.4f;
            }
            if (MyGdxGame.Arbusto1Colocadas.getInteger("Posiciones7") < 3) {
           } else {

                alphaArbusto1 = 0.4f;
            }
            if (MyGdxGame.Arbusto2Colocadas.getInteger("Posiciones8") < 3) {

            } else {
                alphaArbusto2 = 0.4f;
            }

            if(timeMenu2 > 1f) {
                if (MyGdxGame.CasasDosPisosColocadas.getInteger("Posiciones3") < 2) {
                    Casa2PisosR.set(AddResources.cam.position.x - 3.8f + (40 / Pixels), AddResources.cam.position.y - 2 + (10 / Pixels), 50 / Pixels, 90 / Pixels);
                } else {
                    alphaCasa2 = 0.4f;
                    Casa2PisosR.set(0, 0, 0, 0);
                }
                if (MyGdxGame.CasasColocadas.getInteger("Posiciones4") < 2) {
                    CasaR.set(AddResources.cam.position.x - 3.8f + (40 / Pixels), AddResources.cam.position.y - 2 + (10 / Pixels), 50 / Pixels, 90 / Pixels);
                } else {
                    alphaCasa1 = 0.4f;
                    CasaR.set(0, 0, 0, 0);
                }

                if (MyGdxGame.Maceta1Colocadas.getInteger("Posiciones5") < 3) {
                    Maceta1R.set(AddResources.cam.position.x - 3.8f + (95 / Pixels), AddResources.cam.position.y - 2 + (70 / Pixels), 32 / Pixels, 32 / Pixels);
                } else {
                    Maceta1R.set(0, 0, 0, 0);
                    alphaMaceta1 = 0.4f;
                }

                if (MyGdxGame.Maceta2Colocadas.getInteger("Posiciones6") < 3) {
                    Maceta2R.set(AddResources.cam.position.x - 3.8f + (130 / Pixels), AddResources.cam.position.y - 2 + (70 / Pixels), 32 / Pixels, 32 / Pixels);
                } else {
                    Maceta2R.set(0, 0, 0, 0);
                    alphaMaceta2 = 0.4f;
                }
                if (MyGdxGame.Arbusto1Colocadas.getInteger("Posiciones7") < 3) {
                    Arbusto1R.set(AddResources.cam.position.x - 3.8f + (160 / Pixels), AddResources.cam.position.y - 2 + (10 / Pixels), 32 / Pixels, 32 / Pixels);
                } else {
                    Arbusto1R.set(0, 0, 0, 0);
                    alphaArbusto1 = 0.4f;
                }
                if (MyGdxGame.Arbusto2Colocadas.getInteger("Posiciones8") < 3) {
                    Arbusto2R.set(AddResources.cam.position.x - 3.8f + (160 / Pixels), AddResources.cam.position.y - 2 + (64 / Pixels), 32 / Pixels, 32 / Pixels);

                } else {
                    alphaArbusto2 = 0.4f;
                    Arbusto2R.set(0, 0, 0, 0);

                }
            }
            Casa2PisosS.setAlpha(alphaCasa2);
            Casa2PisosS.setBounds(AddResources.cam.position.x - 3.8f+ (40 / Pixels), AddResources.cam.position.y - 2 + (10 / Pixels), 50 / Pixels, 90 / Pixels);
            Casa2PisosS.draw(batch);


            CasaS.setAlpha(alphaCasa1);
            CasaS.setBounds(AddResources.cam.position.x - 3.8f+ (105 / Pixels), AddResources.cam.position.y - 2 + (10 / Pixels), 50 / Pixels, 60 / Pixels);
            CasaR.set(AddResources.cam.position.x - 3.8f+ (105 / Pixels), AddResources.cam.position.y - 2 + (10 / Pixels), 50 / Pixels, 40 / Pixels);
            CasaS.draw(batch);

            Maceta1S.setBounds(AddResources.cam.position.x - 3.8f+ (95 / Pixels), AddResources.cam.position.y - 2 + (70 / Pixels), 32 / Pixels, 32 / Pixels);
            Maceta1S.setAlpha(alphaMaceta1);
            Maceta1S.draw(batch);

            Maceta2S.setAlpha(alphaMaceta2);
            Maceta2S.setBounds(AddResources.cam.position.x - 3.8f+ (130 / Pixels), AddResources.cam.position.y - 2 + (70 / Pixels), 32 / Pixels, 32 / Pixels);
            Maceta2R.set(AddResources.cam.position.x - 3.8f+ (130 / Pixels), AddResources.cam.position.y - 2 + (70 / Pixels), 32 / Pixels, 32 / Pixels);
            Maceta2S.draw(batch);

            Arbusto1S.setBounds(AddResources.cam.position.x - 3.8f+ (160 / Pixels), AddResources.cam.position.y - 2 + (10 / Pixels), 32 / Pixels, 32 / Pixels);
          Arbusto1S.setAlpha(alphaArbusto1);
            Arbusto1S.draw(batch);

            Arbusto2S.setBounds(AddResources.cam.position.x - 3.8f+ (160 / Pixels), AddResources.cam.position.y - 2 + (64 / Pixels), 50/ Pixels, 50/ Pixels);

            Arbusto2S .setAlpha(alphaArbusto2);
            Arbusto2S.draw(batch);

            if(Casa2PisosR.overlaps(puntero))
            {
                MenuBuild.CasasDosPisosBuild = true;
                MenuBuild.CasasBuild = false;
                MenuBuild.Maceta1Build = false;
                MenuBuild.Maceta2Build = false;
                MenuBuild.Arbusto1Build = false;
                MenuBuild.Arbusto2Build = false;
            }
            if(CasaR.overlaps(puntero))
            {
                MenuBuild.CasasDosPisosBuild = false;
                MenuBuild.CasasBuild = true;
                MenuBuild.Maceta1Build = false;
                MenuBuild.Maceta2Build = false;
                MenuBuild.Arbusto1Build = false;
                MenuBuild.Arbusto2Build = false;
            }
            if(Maceta1R.overlaps(puntero))
            {
                MenuBuild.CasasDosPisosBuild = false;
                MenuBuild.CasasBuild = false;
                MenuBuild.Maceta1Build = true;
                MenuBuild.Maceta2Build = false;
                MenuBuild.Arbusto1Build = false;
                MenuBuild.Arbusto2Build = false;
            }
            if(Maceta2R.overlaps(puntero))
            {
                MenuBuild.CasasDosPisosBuild = false;
                MenuBuild.CasasBuild = false;
                MenuBuild.Maceta1Build = false;
                MenuBuild.Maceta2Build = true;
                MenuBuild.Arbusto1Build = false;
                MenuBuild.Arbusto2Build = false;
            }

            if(Arbusto1R.overlaps(puntero))
            {
                MenuBuild.CasasDosPisosBuild = false;
                MenuBuild.CasasBuild = false;
                MenuBuild.Maceta1Build = false;
                MenuBuild.Maceta2Build = false;
                MenuBuild.Arbusto1Build = true;
                MenuBuild.Arbusto2Build = false;
            }
            if(Arbusto2R.overlaps(puntero))
            {
                MenuBuild.CasasDosPisosBuild = false;
                MenuBuild.CasasBuild = false;
                MenuBuild.Maceta1Build = false;
                MenuBuild.Maceta2Build = false;
                MenuBuild.Arbusto1Build = false;
                MenuBuild.Arbusto2Build = true;
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

            MaquinaComidaR.set(AddResources.cam.position.x - 3.8f + (40 / Pixels), AddResources.cam.position.y - 2 + (50 / Pixels), 50/ Pixels, 35 / Pixels);
            MaquinaComidaS.setBounds(AddResources.cam.position.x - 3.8f + (40 / Pixels), AddResources.cam.position.y - 2 + (50 / Pixels), 50/ Pixels, 35 / Pixels);
            MaquinaComidaS.setAlpha(alphaMaquina);
            MaquinaComidaS.draw(batch);
            if(MaquinaComidaR.overlaps(puntero))
            {
                buildMaquinaComida = true;
            }
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
        CorralVacas.dispose();
        CorralGallinas.dispose();
        Flecha.dispose();
        negro.dispose();
        TrigoA.dispose();
        MaizA.dispose();
        SojaA.dispose();
        ZanahoriaA.dispose();
        CanaA.dispose();
        AlgodonA.dispose();
        LecheA.dispose();
        HuevosA.dispose();
        ComidaVaca.dispose();
        ComidaGallina.dispose();
        Blanco.dispose();
    }
}
