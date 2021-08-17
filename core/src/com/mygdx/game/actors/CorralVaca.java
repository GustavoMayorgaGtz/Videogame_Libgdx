package com.mygdx.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.maps.tiled.tiles.AnimatedTiledMapTile;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.tiled.AddResources;

import static com.mygdx.game.MyGdxGame.Corral1Vacas;
import static com.mygdx.game.MyGdxGame.Corral1VacasAlimentadas;
import static com.mygdx.game.MyGdxGame.CorralVacas1;
import static com.mygdx.game.MyGdxGame.Pixels;
import static com.mygdx.game.actors.Tierra1.Build;
import static com.mygdx.game.actors.Tierra1.noBuild;

public class CorralVaca extends Actor implements Disposable {
    public static boolean var17= true;
    public static Texture logo;

    public static Rectangle Cuerpo,Cuerpo2;
    public static float x,y;
    boolean noToca;
    boolean cambiarPosicion = false;
    float timeDurationTouch;

    /*vacas*/
    Rectangle Izq,Dere;
    Rectangle vaca1,vaca2;
    float x1,x2;
    boolean vaca1Izq = true,vaca1Dere = false,vaca2Izq = false,vaca2Dere = true;
    int iteraror1 = 0, iterator2 = 0;
    boolean sube = true,baja;
    float abs;
    Texture FlechaVerde;

    Texture vacaL,vacaR;
    Animation<TextureRegion> right,left;
    int c1 = 1,r1 = 6,c2 = 1,r2 = 6;
    float timeFree;

    Texture Costal;
    Texture Leche;
    Rectangle LecheR;
    float tiempoEspera; //esta variable me dice si el tiempo de espera es menor a 1 segundo si es asi se regresa a la fase 0 del iterator o sea colocar el tiempo correcto

    public CorralVaca()
    {
        Leche = MyGdxGame.getManager().get("Almacen/Leche.png");
        LecheR = new Rectangle();
        Costal = MyGdxGame.getManager().get("Almacen/ComidaVaca.png");
        logo = new Texture("CorralVacas.png");
        Cuerpo = new Rectangle();
        Cuerpo2 = new Rectangle();
        Izq = new Rectangle();
        Dere = new Rectangle();
        vaca1 = new Rectangle();
        vaca2 = new Rectangle();
        FlechaVerde = new Texture("FlechaVerde.png");
        vacaR= new Texture("VacaWR.png");
        vacaL= new Texture("VacaWL.png");
        TextureRegion[][] FramesR = TextureRegion.split(vacaR,vacaR.getWidth()/c1,vacaR.getHeight()/r1);
        TextureRegion[] TmpR = new TextureRegion[c1 * r1];
        int index1 = 0;
        for(int i= 0; i < r1; i++)
        {
            for(int j = 0; j < c1; j++)
            {
                TmpR[index1++] = FramesR[i][j] ;
            }
        }
        right = new Animation<TextureRegion>(0.6f,TmpR);
        /*******************************/
        TextureRegion[][] FramesL = TextureRegion.split(vacaL,vacaL.getWidth()/c2,vacaL.getHeight()/r2);
        TextureRegion[] TmpL = new TextureRegion[c2* r2];
        int index2 = 0;
        for(int i= 0; i < r2; i++)
        {
            for(int j = 0; j < c2; j++)
            {
                TmpL[index2++] = FramesL[i][j] ;
            }
        }
        left = new Animation<TextureRegion>(0.6f,TmpL);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        timeFree += Gdx.graphics.getDeltaTime();

        batch.draw(logo,x,y,128/Pixels,32/Pixels);
        /***************/
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
/***************/

        for(Rectangle no: noBuild) {
            if (no.overlaps(Jugador.jugador)) {
                noToca = false;
            }
            if(no.overlaps(Cuerpo2))
            {
                var17 = false;
            }
        }
        for(Rectangle yes: Build) {
            if (yes.overlaps(Jugador.jugador)) {
                noToca = true;
            }
            if(yes.overlaps(Cuerpo2))
            {
                var17 = true;
            }
        }

        for(Rectangle no: noBuild) {
            for(Rectangle yes: Build) {
                if(no.overlaps(Cuerpo2)&& yes.overlaps(Cuerpo2))
                {
                    var17 = false;
                }
            }
        }
        /*************/
        Izq.set(x,y,5/Pixels,32/Pixels);
        Dere.set(x+(128/Pixels),y,10/Pixels,32/Pixels);
        if(Jugador.jugador.overlaps(Cuerpo2)&&MenuBuild.vacaBuild&&!MenuBuild.isMenu&&Corral1Vacas.getInteger("Corral1Vacas")!=2)
        {
            batch.draw(FlechaVerde,x+(50/Pixels),y+(32/Pixels)+(abs/Pixels),32/Pixels,32/Pixels);
            if(AddResources.puntero.overlaps(Cuerpo2)) {
                if(MenuBuild.vacaBuild) {
                    if (Corral1Vacas.getInteger("Corral1Vacas") == 0) {
                        Corral1Vacas.putInteger("Corral1Vacas", 1);
                        Corral1Vacas.flush();
                        MenuBuild.vacaBuild = false;
                    }
                }
                if(MenuBuild.vacaBuild) {
                    if (Corral1Vacas.getInteger("Corral1Vacas") == 1) {
                        Corral1Vacas.putInteger("Corral1Vacas", 2);
                        Corral1Vacas.flush();
                        MenuBuild.vacaBuild = false;
                    }
                }
            }
        }
        if (Corral1Vacas.getInteger("Corral1Vacas") >= 1)
        {
             Vaca1(batch);
        }
        if (Corral1Vacas.getInteger("Corral1Vacas") >= 2)
        {
             Vaca2(batch);
        }
        if(Corral1Vacas.getInteger("Corral1Vacas") >= 1)
        {
            if(!MyGdxGame.Corral1VacasAlimentadas.getBoolean("Corral1VacasAlimentadas"))
            {
   tiempoEspera = 0;
                if(Jugador.jugador.overlaps(Cuerpo2)) {
                    if (Corral1Vacas.getInteger("Corral1Vacas") == 1)
                    {
                        batch.draw(Costal, x + (65 / Pixels), y + (32 / Pixels) + (abs / Pixels), 25 / Pixels, 25 / Pixels);
                }else if(Corral1Vacas.getInteger("Corral1Vacas") == 2) {
                    batch.draw(Costal, x + (65 / Pixels), y + (32 / Pixels) + (abs / Pixels), 25 / Pixels, 25 / Pixels);
                    batch.draw(Costal, x + (85 / Pixels), y + (32 / Pixels) + (abs / Pixels), 25 / Pixels, 25 / Pixels);
                }


                    if(AddResources.puntero.overlaps(Cuerpo2)&&MyGdxGame.ComidaVacaStocks.getInteger("ComidaVacaStocks") >=1&&Corral1Vacas.getInteger("Corral1Vacas") == 1)
                    {
                        int vaca = MyGdxGame.ComidaVacaStocks.getInteger("ComidaVacaStocks");
                        vaca -= 1;
                        MyGdxGame.Corral1Iterator.putInteger("Corral1Iterator",0);
                        MyGdxGame.Corral1Iterator.flush();
                        MyGdxGame.ComidaVacaStocks.putInteger("ComidaVacaStocks",vaca);
                        MyGdxGame.ComidaVacaStocks.flush();
                        Corral1VacasAlimentadas.putBoolean("Corral1VacasAlimentadas",true);
                        Corral1VacasAlimentadas.flush();
                    }
                    if(AddResources.puntero.overlaps(Cuerpo2)&&MyGdxGame.ComidaVacaStocks.getInteger("ComidaVacaStocks") >=2&&Corral1Vacas.getInteger("Corral1Vacas") == 2)
                    {
                        int vaca = MyGdxGame.ComidaVacaStocks.getInteger("ComidaVacaStocks");
                        vaca -= 2;
                        MyGdxGame.Corral1Iterator.putInteger("Corral1Iterator",0);
                        MyGdxGame.Corral1Iterator.flush();
                        MyGdxGame.ComidaVacaStocks.putInteger("ComidaVacaStocks",vaca);
                        MyGdxGame.ComidaVacaStocks.flush();
                        Corral1VacasAlimentadas.putBoolean("Corral1VacasAlimentadas",true);
                        Corral1VacasAlimentadas.flush();
                    }
                    LecheR.set(0,0,0,0);
                }
            }else
            {
                //tiempoEspera += 1 * Gdx.graphics.getDeltaTime();
                if(MyGdxGame.Corral1Iterator.getInteger("Corral1Iterator")==0) {
                 //   tiempoEspera = 0;
                    TimeZone t = new TimeZone();
                    t.calcularHora = true;
                    t.CalcularTiempo(30);
                    MyGdxGame.CorralVacas1Day.putInteger("CorralVacas1Day",t.dayS);
                    MyGdxGame.CorralVacas1Year.putInteger("CorralVacas1Year",t.yearS);
                    MyGdxGame.CorralVacas1Hour.putInteger("CorralVacas1Hour",t.hourS);
                    MyGdxGame.CorralVacas1Minute.putInteger("CorralVacas1Minute",t.minuteS);
                    MyGdxGame.CorralVacas1Year.flush();
                    MyGdxGame.CorralVacas1Hour.flush();
                    MyGdxGame.CorralVacas1Day.flush();
                    MyGdxGame.CorralVacas1Minute.flush();
                    Gdx.app.log("Year",""+   MyGdxGame.CorralVacas1Year.getInteger("CorralVacas1Year")+" year"+t.year);
                    Gdx.app.log("Day",""+   MyGdxGame.CorralVacas1Day.getInteger("CorralVacas1Day")+" day"+t.day);
                    Gdx.app.log("Hour",""+   MyGdxGame.CorralVacas1Hour.getInteger("CorralVacas1Hour")+" hour"+t.hour);
                    Gdx.app.log("Minute",""+   MyGdxGame.CorralVacas1Minute.getInteger("CorralVacas1Minute")+" Minutes"+t.minute);
                    MyGdxGame.Corral1Iterator.putInteger("Corral1Iterator",1);
                    MyGdxGame.Corral1Iterator.flush();
                    t.clear();
                }else if(MyGdxGame.Corral1Iterator.getInteger("Corral1Iterator")==1)
                {
                    /***********/
                    TimeZone t = new TimeZone();
                  /*  Gdx.app.log("Year",""+  t.year);
                    Gdx.app.log("Day",""+   t.day);
                    Gdx.app.log("Hour",""+  t.hour);
                    Gdx.app.log("Minute",""+t.minute);*/
                    if(t.year > MyGdxGame.CorralVacas1Year.getInteger("CorralVacas1Year"))
                    {
                        Gdx.app.log("error time","time1");
                        MyGdxGame.Corral1Iterator.putInteger("Corral1Iterator",2);
                        MyGdxGame.Corral1Iterator.flush();
                    }else if(t.day > MyGdxGame.CorralVacas1Day.getInteger("CorralVacas1Day") &&t.year >= MyGdxGame.CorralVacas1Year.getInteger("CorralVacas1Year") )
                    {
                        Gdx.app.log("error time","time2");
                        MyGdxGame.Corral1Iterator.putInteger("Corral1Iterator",2);
                        MyGdxGame.Corral1Iterator.flush();
                    }else if(t.hour > MyGdxGame.CorralVacas1Hour.getInteger("CorralVacas1Hour")&&t.day >= MyGdxGame.CorralVacas1Day.getInteger("CorralVacas1Day") &&t.year >= MyGdxGame.CorralVacas1Year.getInteger("CorralVacas1Year") )
                    {
                        Gdx.app.log("error time","time3");
                        MyGdxGame.Corral1Iterator.putInteger("Corral1Iterator",2);
                        MyGdxGame.Corral1Iterator.flush();

                    }else if(t.minute >= MyGdxGame.CorralVacas1Minute.getInteger("CorralVacas1Minute")&&t.hour >= MyGdxGame.CorralVacas1Hour.getInteger("CorralVacas1Hour")&&t.day >= MyGdxGame.CorralVacas1Day.getInteger("CorralVacas1Day") &&t.year >= MyGdxGame.CorralVacas1Year.getInteger("CorralVacas1Year") )
                    {
                        Gdx.app.log("error time","time4");
                        MyGdxGame.Corral1Iterator.putInteger("Corral1Iterator",2);
                        MyGdxGame.Corral1Iterator.flush();
                    }
                    /***********/
                }else if(MyGdxGame.Corral1Iterator.getInteger("Corral1Iterator")==2)
                {
               //     Gdx.app.log("Hora de la vaca 1",""+MyGdxGame.CorralVacas1Year.getInteger("CorralVacas1Year"));
                    if(MyGdxGame.CorralVacas1Year.getInteger("CorralVacas1Year")== 0 )
                    {
                        MyGdxGame.Corral1Iterator.putInteger("Corral1Iterator",0);
                        MyGdxGame.Corral1Iterator.flush();
                    }else
                    {
                    if(MyGdxGame.Corral1Vacas.getInteger("Corral1Vacas")==1) {
                        batch.draw(Leche, x+(40/Pixels), y+((abs/Pixels)/2), 15 / Pixels, 15 / Pixels);
                        LecheR.set(x+(40/Pixels), y+((abs/Pixels)/2), 12 / Pixels, 12 / Pixels);
                        if(LecheR.overlaps(Jugador.jugador))
                        {
                            MenuBuild.LecheB =  true;
                            MenuBuild.FiguraX = x+(35/Pixels);
                            MenuBuild.FiguraY = y+(32/Pixels);
                            MenuBuild.MandarAlmacen = true;
                            int leche =  MyGdxGame.LecheStocks.getInteger("LecheStocks");
                            leche += 1;
                            MyGdxGame.LecheStocks.putInteger("LecheStocks",leche);
                            MyGdxGame.LecheStocks.flush();
                            Corral1VacasAlimentadas.putBoolean("Corral1VacasAlimentadas",false);
                            Corral1VacasAlimentadas.flush();
                        }
                    }else if (MyGdxGame.Corral1Vacas.getInteger("Corral1Vacas")==2) {
                        batch.draw(Leche, x + (40 / Pixels), y + ((abs / Pixels) / 2), 15 / Pixels, 15 / Pixels);
                        batch.draw(Leche, x + (50 / Pixels), y + ((abs / Pixels) / 2), 15 / Pixels, 15 / Pixels);
                        LecheR.set(x + (40 / Pixels), y + ((abs / Pixels) / 2), 20 / Pixels, 12 / Pixels);
                        if (LecheR.overlaps(Jugador.jugador)) {
                            MenuBuild.LecheB = true;
                            MenuBuild.FiguraX = x + (35 / Pixels);
                            MenuBuild.FiguraY = y + (32 / Pixels);
                            MenuBuild.MandarAlmacen = true;
                            int leche = MyGdxGame.LecheStocks.getInteger("LecheStocks");
                            leche += 2;
                            MyGdxGame.LecheStocks.putInteger("LecheStocks", leche);
                            MyGdxGame.LecheStocks.flush();
                            Corral1VacasAlimentadas.putBoolean("Corral1VacasAlimentadas", false);
                            Corral1VacasAlimentadas.flush();

                        }
                    }
                    }
                }


            }
        }
        /************/
    }

    public void Vaca1(Batch batch)
    {
        TextureRegion Right = right.getKeyFrame(timeFree,true);
        TextureRegion Left = left.getKeyFrame(timeFree,true);
        vaca1.set(x1,y,30/Pixels,24/Pixels);
        if(vaca1.overlaps(vaca2))
        {
            if(vaca2Dere) {
                vaca2Dere = false;
                vaca2Izq = true;
            }else
            {
                vaca2Dere = true;
                vaca2Izq = false;
            }


            if(vaca1Dere) {
                vaca1Dere = false;
                vaca1Izq = true;
            }else
            {
                vaca1Dere = true;
                vaca1Izq = false;
            }
        }
        if(iteraror1 == 0)
        {
            x1 = x + (32/Pixels);
            iteraror1++;
        }
        if(vaca1Dere)
        {
            x1 += (10 * Gdx.graphics.getDeltaTime())/Pixels;
            batch.draw(Right,vaca1.x,vaca1.y,vaca1.width,vaca1.height);

            vaca1.setX(x1);
        }
        if(vaca1Izq)
        {
            x1 -= (10 * Gdx.graphics.getDeltaTime())/Pixels;
            batch.draw(Left,vaca1.x,vaca1.y,vaca1.width,vaca1.height);

            vaca1.setX(x1);
        }
        if(Izq.overlaps(vaca1))
        {
            vaca1Dere = true;
            vaca1Izq = false;
        }
        if(Dere.overlaps(vaca1))
        {
            vaca1Izq = true;
            vaca1Dere = false;
        }
    }

    public void Vaca2(Batch batch)
    {
        TextureRegion Right = right.getKeyFrame(timeFree,true);
        TextureRegion Left = left.getKeyFrame(timeFree,true);
        vaca2.set(x2,y,40/Pixels,32/Pixels);
        if(vaca1.overlaps(vaca2))
        {
            if(vaca2Dere) {
                vaca2Dere = false;
                vaca2Izq = true;
            }else
            {
                vaca2Dere = true;
                vaca2Izq = false;
            }


            if(vaca1Dere) {
                vaca1Dere = false;
                vaca1Izq = true;
            }else
            {
                vaca1Dere = true;
                vaca1Izq = false;
            }
        }
        if(iterator2 == 0)
        {
            x2 = x + (32/Pixels);
            iterator2++;
        }
        if(vaca2Dere)
        {
            x2 += (8 * Gdx.graphics.getDeltaTime())/Pixels;
            batch.draw(Right,vaca2.x,vaca2.y,vaca2.width,vaca2.height);
            vaca2.setX(x2);

        }
        if(vaca2Izq)
        {
            x2 -= (8 * Gdx.graphics.getDeltaTime())/Pixels;
            batch.draw(Left,vaca2.x,vaca2.y,vaca2.width,vaca2.height);
            vaca2.setX(x2);

        }
        if(Izq.overlaps(vaca2))
        {
            vaca2Dere = true;
            vaca2Izq = false;
        }
        if(Dere.overlaps(vaca2))
        {
            vaca2Izq = true;
            vaca2Dere = false;
        }
    }

    @Override
    public void act(float delta) {
        colisiones();
        if (MyGdxGame.CorralVacaColocadas.getInteger("Posiciones9") == 0 && MenuBuild.isCorralVacasBuild) {
            for (Rectangle e : Tierra1.rects) {
                if (Jugador.jugador.overlaps(e)) {
                    if (noToca) {
                        MyGdxGame.CorralVacaColocadas.putInteger("Posiciones9", 1);
                        CorralVacas1.putFloat("X26", Jugador.body.getPosition().x);
                        if (AddResources.TouchConfirm) {
                            CorralVacas1.flush();
                        }
                        CorralVacas1.putFloat("Y26", (e.y + (2 / Pixels)));
                        if (AddResources.TouchConfirm) {
                            CorralVacas1.flush();
                            MyGdxGame.CorralVacaColocadas.flush();
                            MenuBuild.isCorralVacasBuild = false;
                            AddResources.TouchConfirm = false;
                            AddResources.TouchCancel = false;
                        }
                    }
                }
            }
        }

        if (MyGdxGame.CorralVacaColocadas.getInteger("Posiciones9") == 0 && MenuBuild.isCorralVacasBuild) {
            for (Rectangle e : Tierra1.rects) {

                if (Jugador.jugador.overlaps(e)) {
                    y = (e.y + (2 / Pixels));
                    x = Jugador.body.getPosition().x;
                    Cuerpo2.set(x, y, 128/Pixels,32/Pixels);

                }
            }
        } else {
            if (!cambiarPosicion) {
                x = CorralVacas1.getFloat("X26");
                y = CorralVacas1.getFloat("Y26");
                Cuerpo2.set(x, y, 128/Pixels,32/Pixels);
            }
            if (!MenuBuild.buildMaquinaComida&&!MenuBuild.isAlmacen&&!MenuBuild.isMenuSeedSelection&&!MenuBuild.isMenu&&!MenuBuild.isCorralGallinasBuild&&!MenuBuild.isCorralVacasBuild&&!MenuBuild.gallinaBuild&&!MenuBuild.vacaBuild
                    &&!MenuBuild.BuildTierra&&!MenuBuild.BuildAgua&&!MenuBuild.BuildMover&&!MenuBuild.Arbusto1Build&&!MenuBuild.Arbusto2Build
                    &&!MenuBuild.CasasBuild&&!MenuBuild.CasasDosPisosBuild&&!MenuBuild.Maceta1Build&&!MenuBuild.Maceta2Build) {

                Cuerpo.set(x, y, 128/Pixels,32/Pixels);
            } else {
                Cuerpo.set(0, 0, 0, 0);
            }
            if (MenuBuild.isMenu) {
                Cuerpo.set(0, 0, 0, 0);
            }
        }

        if (MenuBuild.isMover) {
            if (Cuerpo.overlaps(AddResources.puntero)) {
                timeDurationTouch += 1 * Gdx.graphics.getDeltaTime();
                if (timeDurationTouch > 2) {
                    cambiarPosicion = true;
                }
            }
        }

        if (cambiarPosicion) {
            iteraror1 = 0;
            iterator2 = 0;
            MenuBuild.BuildMover = true;
            for (Rectangle e : Tierra1.rects) {
                if (noToca) {
                    if (Jugador.jugador.overlaps(e)) {
                        y = (e.y + (2 / Pixels));
                        x = Jugador.body.getPosition().x;
                        Cuerpo2.set(x, y, 128/Pixels,32/Pixels);

                        CorralVacas1.putFloat("X26", Jugador.body.getPosition().x);
                        if (AddResources.TouchConfirm) {
                            CorralVacas1.flush();
                        }
                        CorralVacas1.putFloat("Y26", (e.y + (2 / Pixels)));
                        if (AddResources.TouchConfirm) {
                            iteraror1 = 0;
                            iterator2 = 0;
                            CorralVacas1.flush();
                            MenuBuild.BuildMover = false;
                            MenuBuild.isMenu = false;
                            cambiarPosicion = false;
                            timeDurationTouch = 0;
                        }
                    }
                }
            }
        }

    }

    public void colisiones()
    {
        if(Cuerpo2.overlaps(Casa2Pisos.Cuerpo2)||Cuerpo2.overlaps(Casa2Pisos2.Cuerpo2)||Cuerpo2.overlaps(Casa1.Cuerpo2)||Cuerpo2.overlaps(Casa2.Cuerpo2)||Cuerpo2.overlaps(Maceta1_1.Cuerpo2)||Cuerpo2.overlaps(Maceta1_2.Cuerpo2)||Cuerpo2.overlaps(Maceta1_3.Cuerpo2)
                ||Cuerpo2.overlaps(Maceta2_1.Cuerpo2)||Cuerpo2.overlaps(Maceta2_2.Cuerpo2)||Cuerpo2.overlaps(Maceta2_3.Cuerpo2)
                ||Cuerpo2.overlaps(Arbusto1_1.Cuerpo2)||Cuerpo2.overlaps(Arbusto1_2.Cuerpo2)||Cuerpo2.overlaps(Arbusto1_3.Cuerpo2)
                ||Cuerpo2.overlaps(Arbusto2_1.Cuerpo2)||Cuerpo2.overlaps(Arbusto2_2.Cuerpo2)||Cuerpo2.overlaps(Arbusto2_3.Cuerpo2)
                ||Cuerpo2.overlaps(CorralGallinas.Cuerpo2)||Cuerpo2.overlaps(CorralVaca2.Cuerpo2)||Cuerpo2.overlaps(CorralGallinas2.Cuerpo2))
        {
            AddResources.freeCorral1 = false;
        }else
        {
            AddResources.freeCorral1 = true;
        }
    }

    @Override
    public void dispose() {
      logo.dispose();
      FlechaVerde.dispose();
      vacaL.dispose();
      vacaR.dispose();
    }
}
