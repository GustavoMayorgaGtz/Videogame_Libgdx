package com.mygdx.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;
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
    Texture equis;
    Texture fondo,logo1,logo2,logo3,logo4;
    public static Rectangle Menu1,Menu2,Menu3,Menu4,Salir;
    public static Sprite Fondo,Logo1,Logo2,Logo3,Logo4;
    public static boolean isMenu1 = true,isMenu2,isMenu3,isMenu4;
    float alpha1,alpha2,alpha3,alpha4;

    /***Menu1***/
    float alphaTierra = 1,alphaAgua = 1,alphaTrigo = 1,alphaMaiz = 1,alphaSoja = 1,alphaZanahoria = 1,alphaCana = 1,alphaAlgodon = 1;
    Texture Tierra,Agua,Trigo,Maiz,Soja,Zanahoria,Cana,Algodon;
    Sprite  TierraS,AguaS,TrigoS,MaizS,SojaS,ZanahoriaS,CanaS,AlgodonS;
    public static Rectangle tierraR,aguaR,trigoR,maizR,sojaR,zanahoriaR,canaR,algodonR;
    public static boolean BuildTierra;

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

        tierraR = new Rectangle();
        aguaR  = new Rectangle();
        trigoR = new Rectangle();
        maizR = new Rectangle();
        sojaR = new Rectangle();
        zanahoriaR  = new Rectangle();
        canaR = new Rectangle();
        algodonR = new Rectangle();


    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        time += 1 * Gdx.graphics.getDeltaTime();
        Logo.setBounds(AddResources.cam.position.x - 3.8f, AddResources.cam.position.y , 20 / Pixels, 20 / Pixels);
        Logo.setAlpha(MyGdxGame.alpha);
        Cuadro.set(AddResources.cam.position.x - 3.8f, AddResources.cam.position.y , 20 / Pixels, 20 / Pixels);
        if(time > 1 && Cuadro.overlaps(AddResources.puntero))
        {

                Gdx.app.log("isMenu","true");
                isMenu = true;
                time = 0;

        }
    }

    public void MenuDraw(Batch batch, OrthographicCamera cam)
    {

        if(isMenu) {
           // time2 += 1 * Gdx.graphics.getDeltaTime();
            //if(time2 > 1) {

         //   }
            if(isMenu1)
            {
                alpha1 = 0.2f;
                alpha2 = 0.8f;
                alpha3 = 0.8f;
                alpha4 = 0.8f;
            }
            if(isMenu2)
            {
                alpha1 = 0.8f;
                alpha2 = 0.2f;
                alpha3 = 0.8f;
                alpha4 = 0.8f;
            }
            if(isMenu3)
            {
                alpha1 = 0.8f;
                alpha2 = 0.8f;
                alpha3 = 0.2f;
                alpha4 = 0.8f;
            }
            if(isMenu4)
            {
                alpha1 = 0.8f;
                alpha2 = 0.8f;
                alpha3 = 0.8f;
                alpha4 = 0.2f;
            }
            Fondo.setAlpha(alpha1);
            Menu1.set(cam.position.x - 3.8f, cam.position.y - 2 + (5 / Pixels), 25 / Pixels, 25 / Pixels);
            Fondo.setBounds(cam.position.x - 3.8f, cam.position.y - 2 + (5 / Pixels), 25 / Pixels, 25 / Pixels);
            Logo1.setBounds(cam.position.x - 3.8f, cam.position.y - 2 + (5 / Pixels), 25 / Pixels, 25 / Pixels);
            Logo1.draw(batch);
            Fondo.draw(batch);
            Fondo.setAlpha(alpha2);
            Menu2.set(cam.position.x - 3.8f, cam.position.y - 2 + (30 / Pixels), 25 / Pixels, 25 / Pixels);
            Fondo.setBounds(cam.position.x - 3.8f, cam.position.y - 2 + (30 / Pixels), 25 / Pixels, 25 / Pixels);
            Logo2.setBounds(cam.position.x - 3.8f, cam.position.y - 2 + (30 / Pixels), 25 / Pixels, 25 / Pixels);
            Logo2.draw(batch);
            Fondo.draw(batch);
            Fondo.setAlpha(alpha3);
            Menu3.set(cam.position.x - 3.8f, cam.position.y - 2 + (55 / Pixels), 25 / Pixels, 25 / Pixels);
            Fondo.setBounds(cam.position.x - 3.8f, cam.position.y - 2 + (55 / Pixels), 25 / Pixels, 25 / Pixels);
            Logo3.setBounds(cam.position.x - 3.8f, cam.position.y - 2 + (55 / Pixels), 25 / Pixels, 25 / Pixels);
            Logo3.draw(batch);
            Fondo.draw(batch);
            Fondo.setAlpha(alpha4);
            Menu4.set(cam.position.x - 3.8f, cam.position.y - 2 + (80 / Pixels), 25 / Pixels, 25 / Pixels);
            Fondo.setBounds(cam.position.x - 3.8f, cam.position.y - 2 + (80 / Pixels), 25 / Pixels, 25 / Pixels);
            Logo4.setBounds(cam.position.x - 3.8f, cam.position.y - 2 + (80 / Pixels), 25 / Pixels, 25 / Pixels);
            Logo4.draw(batch);
            Fondo.draw(batch);
            MenuItems(batch,AddResources.puntero);
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
            aguaR.set(AddResources.cam.position.x - 3.8f+ (80/ Pixels), AddResources.cam.position.y - 2 + (20 / Pixels), 30 / Pixels, 30 / Pixels);
            AguaS.setAlpha(alphaAgua);
            AguaS.setBounds(AddResources.cam.position.x - 3.8f+ (80/ Pixels), AddResources.cam.position.y - 2 + (20 / Pixels), 30 / Pixels, 30 / Pixels);
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

            if(tierraR.overlaps(puntero))
            {
               BuildTierra = true;
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

        }
        if(isMenu3)
        {

        }
        if(isMenu4)
        {

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
    }
}
