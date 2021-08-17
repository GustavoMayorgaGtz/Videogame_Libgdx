package com.mygdx.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.tiled.AddResources;

import static com.mygdx.game.MyGdxGame.Corral1Gallinas;
import static com.mygdx.game.MyGdxGame.Corral1GallinasAlimentadas;
import static com.mygdx.game.MyGdxGame.Corral1Vacas;
import static com.mygdx.game.MyGdxGame.Corral2Gallinas;
import static com.mygdx.game.MyGdxGame.Corral2GallinasAlimentadas;
import static com.mygdx.game.MyGdxGame.CorralGallinas2;
import static com.mygdx.game.MyGdxGame.Pixels;
import static com.mygdx.game.actors.Tierra1.Build;
import static com.mygdx.game.actors.Tierra1.noBuild;

public class CorralGallinas2 extends Actor implements Disposable {
    public static boolean var16= true;
    public static Texture logo;
    public static Rectangle Cuerpo,Cuerpo2;
    public static float x,y;
    boolean noToca = true;
    boolean cambiarPosicion = false;
float timeDurationTouch;


    /*gallinas*/
    Rectangle Izq,Dere;
    Rectangle gallina1,gallina2;
    float x1,x2;
    boolean gallina1Izq = true,gallina1Dere = false,gallina2Izq = false,gallina2Dere = true;
    int iteraror1 = 0, iterator2 = 0;
    boolean sube = true,baja;
    float abs;
    Texture FlechaVerde;

    Texture gallinaL,gallinaR;
    Animation<TextureRegion> right,left;
    int c1 = 1,r1 = 4,c2 = 1,r2 = 4;
    float timeFree;


    Texture Costal;
    Texture Huevos;
    Rectangle HuevosR;

    float tiempoEspera; //esta variable me dice si el tiempo de espera es menor a 1 segundo si es asi se regresa a la fase 0 del iterator o sea colocar el tiempo correcto


    public CorralGallinas2()
    {
        Huevos = MyGdxGame.getManager().get("Almacen/Huevos.png");
        HuevosR = new Rectangle();
        Costal = MyGdxGame.getManager().get("Almacen/ComidaGallina.png");
        logo = new Texture("CorralGallinas.png");
        Cuerpo = new Rectangle();
        Cuerpo2 = new Rectangle();


        /***/
        Izq = new Rectangle();
        Dere = new Rectangle();
        gallina1 = new Rectangle();
        gallina2 = new Rectangle();
        FlechaVerde = new Texture("FlechaVerde.png");
        gallinaR= new Texture("GallinaWR.png");
        gallinaL= new Texture("GallinaWL.png");
        TextureRegion[][] FramesR = TextureRegion.split(gallinaR,gallinaR.getWidth()/c1,gallinaR.getHeight()/r1);
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
        TextureRegion[][] FramesL = TextureRegion.split(gallinaL,gallinaL.getWidth()/c2,gallinaL.getHeight()/r2);
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
        batch.draw(logo,x,y,100/Pixels,32/Pixels);
        for(Rectangle no: noBuild) {
            if (no.overlaps(Jugador.jugador)) {
                noToca = false;
            }
            if(no.overlaps(Cuerpo2))
            {
                var16 = false;
            }
        }
        for(Rectangle yes: Build) {
            if (yes.overlaps(Jugador.jugador)) {
                noToca = true;
            }
            if(yes.overlaps(Cuerpo2))
            {
                var16 = true;
            }
        }

        for(Rectangle no: noBuild) {
            for(Rectangle yes: Build) {
                if(no.overlaps(Cuerpo2)&& yes.overlaps(Cuerpo2))
                {
                    var16 = false;
                }
            }
        }
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
        /*************/
        Izq.set(x,y,5/Pixels,32/Pixels);
        Dere.set(x+(100/Pixels),y,10/Pixels,32/Pixels);
        if(Jugador.jugador.overlaps(Cuerpo2)&&MenuBuild.gallinaBuild&&!MenuBuild.isMenu&&Corral2Gallinas.getInteger("Corral2Gallinas")!=2)
        {
            batch.draw(FlechaVerde,x+(60/Pixels),y+(32/Pixels)+(abs/Pixels),32/Pixels,32/Pixels);
            if(AddResources.puntero.overlaps(Cuerpo2)) {
                if(MenuBuild.gallinaBuild) {
                    if (Corral2Gallinas.getInteger("Corral2Gallinas") == 0) {
                        Corral2Gallinas.putInteger("Corral2Gallinas", 1);
                        Corral2Gallinas.flush();
                        MenuBuild.gallinaBuild = false;
                    }
                }
                if(MenuBuild.gallinaBuild) {
                    if (Corral2Gallinas.getInteger("Corral2Gallinas") == 1) {
                        Corral2Gallinas.putInteger("Corral2Gallinas", 2);
                        Corral2Gallinas.flush();
                        MenuBuild.gallinaBuild = false;
                    }
                }
            }
        }
        if (Corral2Gallinas.getInteger("Corral2Gallinas") >= 1)
        {
            Gallina1(batch);
        }
        if (Corral2Gallinas.getInteger("Corral2Gallinas") >= 2)
        {
            Gallina2(batch);
        }
        if(Corral2Gallinas.getInteger("Corral2Gallinas") >= 1)
        {
            if(!Corral2GallinasAlimentadas.getBoolean("Corral2GallinasAlimentadas"))
            {
                tiempoEspera = 0;
                MyGdxGame.Corral2GallinaIterator.putInteger("Corral2GallinaIterator",0);
                MyGdxGame.Corral2GallinaIterator.flush();
                if(Jugador.jugador.overlaps(Cuerpo2)) {
                    if (Corral2Gallinas.getInteger("Corral2Gallinas") == 1)
                    {
                        batch.draw(Costal, x + (65 / Pixels), y + (32 / Pixels) + (abs / Pixels), 25 / Pixels, 25 / Pixels);
                    }else if(Corral2Gallinas.getInteger("Corral2Gallinas") == 2) {
                        batch.draw(Costal, x + (65 / Pixels), y + (32 / Pixels) + (abs / Pixels), 25 / Pixels, 25 / Pixels);
                        batch.draw(Costal, x + (85 / Pixels), y + (32 / Pixels) + (abs / Pixels), 25 / Pixels, 25 / Pixels);
                    }


                    if(AddResources.puntero.overlaps(Cuerpo2)&&MyGdxGame.ComidaGallinaStocks.getInteger("ComidaGallinaStocks") >=1&&Corral2Gallinas.getInteger("Corral2Gallinas") == 1)
                    {
                        int vaca = MyGdxGame.ComidaGallinaStocks.getInteger("ComidaGallinaStocks");
                        vaca -= 1;
                        MyGdxGame.ComidaGallinaStocks.putInteger("ComidaGallinaStocks",vaca);
                        MyGdxGame.ComidaGallinaStocks.flush();
                        Corral2GallinasAlimentadas.putBoolean("Corral2GallinasAlimentadas",true);
                        Corral2GallinasAlimentadas.flush();
                    }
                    if(AddResources.puntero.overlaps(Cuerpo2)&&MyGdxGame.ComidaGallinaStocks.getInteger("ComidaGallinaStocks") >=2&&Corral2Gallinas.getInteger("Corral2Gallinas") == 2)
                    {
                        int gallina = MyGdxGame.ComidaGallinaStocks.getInteger("ComidaGallinaStocks");
                        gallina -= 2;
                        MyGdxGame.ComidaGallinaStocks.putInteger("ComidaGallinaStocks",gallina);
                        MyGdxGame.ComidaGallinaStocks.flush();
                        Corral2GallinasAlimentadas.putBoolean("Corral2GallinasAlimentadas",true);
                        Corral2GallinasAlimentadas.flush();
                    }
                    HuevosR.set(0,0,0,0);
                }
            }else
            {

                if(MyGdxGame.Corral2GallinaIterator.getInteger("Corral2GallinaIterator")==0) {
                    tiempoEspera = 0;
                    TimeZone t = new TimeZone();
                    t.calcularHora = true;
                    t.CalcularTiempo(10);
                    MyGdxGame.CorralGallinas2Day.putInteger("CorralGallinas2Day",t.dayS);
                    MyGdxGame.CorralGallinas2Year.putInteger("CorralGallinas2Year",t.yearS);
                    MyGdxGame.CorralGallinas2Hour.putInteger("CorralGallinas2Hour",t.hourS);
                    MyGdxGame.CorralGallinas2Minute.putInteger("CorralGallinas2Minute",t.minuteS);
                    MyGdxGame.CorralGallinas2Year.flush();
                    MyGdxGame.CorralGallinas2Hour.flush();
                    MyGdxGame.CorralGallinas2Day.flush();
                    MyGdxGame.CorralGallinas2Minute.flush();
                   /* Gdx.app.log("Year",""+   MyGdxGame.CorralVacas1Year.getInteger("CorralVacas1Year"));
                    Gdx.app.log("Day",""+   MyGdxGame.CorralVacas1Day.getInteger("CorralVacas1Day"));
                    Gdx.app.log("Hour",""+   MyGdxGame.CorralVacas1Hour.getInteger("CorralVacas1Hour"));
                    Gdx.app.log("Minute",""+   MyGdxGame.CorralVacas1Minute.getInteger("CorralVacas1Minute")+" Minutes"+t.minuteS);*/
                    MyGdxGame.Corral2GallinaIterator.putInteger("Corral2GallinaIterator",1);
                    MyGdxGame.Corral2GallinaIterator.flush();
                }else if(MyGdxGame.Corral2GallinaIterator.getInteger("Corral2GallinaIterator")==1)
                {
                    tiempoEspera += 1 * Gdx.graphics.getDeltaTime();
                    TimeZone t = new TimeZone();
                    if(t.year > MyGdxGame.CorralGallinas2Year.getInteger("CorralGallinas2Year"))
                    {
                        MyGdxGame.Corral2GallinaIterator.putInteger("Corral2GallinaIterator",2);
                        MyGdxGame.Corral2GallinaIterator.flush();
                    }else if(t.day > MyGdxGame.CorralGallinas2Day.getInteger("CorralGallinas2Day"))
                    {
                        MyGdxGame.Corral2GallinaIterator.putInteger("Corral2GallinaIterator",2);
                        MyGdxGame.Corral2GallinaIterator.flush();
                    }else if(t.hour > MyGdxGame.CorralGallinas2Hour.getInteger("CorralGallinas2Hour"))
                    {
                        MyGdxGame.Corral2GallinaIterator.putInteger("Corral2GallinaIterator",2);
                        MyGdxGame.Corral2GallinaIterator.flush();
                    }else if(t.minute > MyGdxGame.CorralGallinas2Minute.getInteger("CorralGallinas2Minute"))
                    {
                        MyGdxGame.Corral2GallinaIterator.putInteger("Corral2GallinaIterator",2);
                        MyGdxGame.Corral2GallinaIterator.flush();
                    }
                }else if(MyGdxGame.Corral2GallinaIterator.getInteger("Corral2GallinaIterator")==2) {
                    if(MyGdxGame.CorralGallinas2Year.getInteger("CorralGallinas2Year")== 0 )
                    {
                        MyGdxGame.Corral2GallinaIterator.putInteger("Corral2GallinaIterator", 0);
                        MyGdxGame.Corral2GallinaIterator.flush();
                    } else {


                        if (MyGdxGame.Corral2Gallinas.getInteger("Corral2Gallinas") == 1) {
                            batch.draw(Huevos, x + (40 / Pixels), y + ((abs / Pixels) / 2), 15 / Pixels, 15 / Pixels);
                            HuevosR.set(x + (40 / Pixels), y + ((abs / Pixels) / 2), 12 / Pixels, 12 / Pixels);
                            if (HuevosR.overlaps(Jugador.jugador)) {
                                MenuBuild.HuevosB = true;
                                MenuBuild.FiguraX = x + (35 / Pixels);
                                MenuBuild.FiguraY = y + (32 / Pixels);
                                MenuBuild.MandarAlmacen = true;
                                int huevos = MyGdxGame.HuevosStocks.getInteger("HuevosStocks");
                                huevos += 3;
                                MyGdxGame.HuevosStocks.putInteger("HuevosStocks", huevos);
                                MyGdxGame.HuevosStocks.flush();
                                Corral2GallinasAlimentadas.putBoolean("Corral2GallinasAlimentadas", false);
                                Corral2GallinasAlimentadas.flush();
                            }
                        } else if (Corral2Gallinas.getInteger("Corral2Gallinas") == 2) {
                            batch.draw(Huevos, x + (40 / Pixels), y + ((abs / Pixels) / 2), 15 / Pixels, 15 / Pixels);
                            batch.draw(Huevos, x + (50 / Pixels), y + ((abs / Pixels) / 2), 15 / Pixels, 15 / Pixels);
                            HuevosR.set(x + (40 / Pixels), y + ((abs / Pixels) / 2), 20 / Pixels, 12 / Pixels);
                            if (HuevosR.overlaps(Jugador.jugador)) {
                                MenuBuild.HuevosB = true;
                                MenuBuild.FiguraX = x + (35 / Pixels);
                                MenuBuild.FiguraY = y + (32 / Pixels);
                                MenuBuild.MandarAlmacen = true;
                                int huevos = MyGdxGame.HuevosStocks.getInteger("HuevosStocks");
                                huevos += 6;
                                MyGdxGame.HuevosStocks.putInteger("HuevosStocks", huevos);
                                MyGdxGame.HuevosStocks.flush();
                                Corral2GallinasAlimentadas.putBoolean("Corral2GallinasAlimentadas", false);
                                Corral2GallinasAlimentadas.flush();

                            }
                        }
                    }
                }


            }
        }
        /************/
    }
    public void Gallina1(Batch batch)
    {
        TextureRegion Right = right.getKeyFrame(timeFree,true);
        TextureRegion Left = left.getKeyFrame(timeFree,true);
        gallina1.set(x1,y,16/Pixels,16/Pixels);
        if(gallina1.overlaps(gallina2))
        {
            if(gallina2Dere) {
                gallina2Dere = false;
                gallina2Izq = true;
            }else
            {
                gallina2Dere = true;
                gallina2Izq = false;
            }


            if(gallina1Dere) {
                gallina1Dere = false;
                gallina1Izq = true;
            }else
            {
                gallina1Dere = true;
                gallina1Izq = false;
            }
        }
        if(iteraror1 == 0)
        {
            x1 = x + (32/Pixels);
            iteraror1++;
        }
        if(gallina1Dere)
        {
            x1 += (10 * Gdx.graphics.getDeltaTime())/Pixels;
            batch.draw(Right,gallina1.x,gallina1.y,gallina1.width,gallina1.height);

            gallina1.setX(x1);
        }
        if(gallina1Izq)
        {
            x1 -= (10 * Gdx.graphics.getDeltaTime())/Pixels;
            batch.draw(Left,gallina1.x,gallina1.y,gallina1.width,gallina1.height);

            gallina1.setX(x1);
        }
        if(Izq.overlaps(gallina1))
        {
            gallina1Dere = true;
            gallina1Izq = false;
        }
        if(Dere.overlaps(gallina1))
        {
            gallina1Izq = true;
            gallina1Dere = false;
        }
    }

    public void Gallina2(Batch batch)
    {
        TextureRegion Right = right.getKeyFrame(timeFree,true);
        TextureRegion Left = left.getKeyFrame(timeFree,true);
        gallina2.set(x2,y,16/Pixels,16/Pixels);
        if(gallina1.overlaps(gallina2))
        {
            if(gallina2Dere) {
                gallina2Dere = false;
                gallina2Izq = true;
            }else
            {
                gallina2Dere = true;
                gallina2Izq = false;
            }


            if(gallina1Dere) {
                gallina1Dere = false;
                gallina1Izq = true;
            }else
            {
                gallina1Dere = true;
                gallina1Izq = false;
            }
        }
        if(iterator2 == 0)
        {
            x2 = x + (32/Pixels);
            iterator2++;
        }
        if(gallina2Dere)
        {
            x2 += (8 * Gdx.graphics.getDeltaTime())/Pixels;
            batch.draw(Right,gallina2.x,gallina2.y,gallina2.width,gallina2.height);
            gallina2.setX(x2);

        }
        if(gallina2Izq)
        {
            x2 -= (8 * Gdx.graphics.getDeltaTime())/Pixels;
            batch.draw(Left,gallina2.x,gallina2.y,gallina2.width,gallina2.height);
            gallina2.setX(x2);

        }
        if(Izq.overlaps(gallina2))
        {
            gallina2Dere = true;
            gallina2Izq = false;
        }
        if(Dere.overlaps(gallina2))
        {
            gallina2Izq = true;
            gallina2Dere = false;
        }
    }
    @Override
    public void act(float delta) {
        colisiones();
        if (MyGdxGame.CorralGallinasColocadas.getInteger("Posiciones10") == 1 && MenuBuild.isCorralGallinasBuild) {
            for (Rectangle e : Tierra1.rects) {
                if (Jugador.jugador.overlaps(e)) {
                    if (noToca) {
                        MyGdxGame.CorralGallinasColocadas.putInteger("Posiciones10", 2);
                        CorralGallinas2.putFloat("X29", Jugador.body.getPosition().x);
                        if (AddResources.TouchConfirm) {
                            CorralGallinas2.flush();
                        }
                           CorralGallinas2.putFloat("Y29", (e.y + (2 / Pixels)));
                        if (AddResources.TouchConfirm) {
                            CorralGallinas2.flush();
                            MyGdxGame.CorralGallinasColocadas.flush();
                            MenuBuild.isCorralGallinasBuild = false;
                            AddResources.TouchConfirm = false;
                            AddResources.TouchCancel = false;
                        }
                    }
                }
            }
        }

        if (MyGdxGame.CorralGallinasColocadas.getInteger("Posiciones10") == 1 && MenuBuild.isCorralGallinasBuild) {
            for (Rectangle e : Tierra1.rects) {

                if (Jugador.jugador.overlaps(e)) {
                    y = (e.y + (2 / Pixels));
                    x = Jugador.body.getPosition().x;
                    Cuerpo2.set(x, y, 100/Pixels,32/Pixels);

                }
            }
        } else {
            if (!cambiarPosicion) {
                x = CorralGallinas2.getFloat("X29");
                y = CorralGallinas2.getFloat("Y29");
                Cuerpo2.set(x, y, 100/Pixels,32/Pixels);
            }
            if (!MenuBuild.buildMaquinaComida&&!MenuBuild.isAlmacen&&!MenuBuild.isMenuSeedSelection&&!MenuBuild.isMenu&&!MenuBuild.isCorralGallinasBuild&&!MenuBuild.isCorralVacasBuild&&!MenuBuild.gallinaBuild&&!MenuBuild.vacaBuild
                    &&!MenuBuild.BuildTierra&&!MenuBuild.BuildAgua&&!MenuBuild.BuildMover&&!MenuBuild.Arbusto1Build&&!MenuBuild.Arbusto2Build
                    &&!MenuBuild.CasasBuild&&!MenuBuild.CasasDosPisosBuild&&!MenuBuild.Maceta1Build&&!MenuBuild.Maceta2Build) {

                Cuerpo.set(x, y, 100/Pixels,32/Pixels);
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
                        Cuerpo2.set(x, y, 100/Pixels,32/Pixels);

                        CorralGallinas2.putFloat("X29", Jugador.body.getPosition().x);
                        if (AddResources.TouchConfirm) {
                            CorralGallinas2.flush();
                        }
                        CorralGallinas2.putFloat("Y29", (e.y + (2 / Pixels)));
                        if (AddResources.TouchConfirm) {
                            iteraror1 = 0;
                            iterator2 = 0;
                            CorralGallinas2.flush();
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
                ||Cuerpo2.overlaps(CorralVaca.Cuerpo2)||Cuerpo2.overlaps(CorralVaca2.Cuerpo2)||Cuerpo2.overlaps(com.mygdx.game.actors.CorralGallinas.Cuerpo2))
        {
            AddResources.freeCorral4 = false;
        }else
        {
            AddResources.freeCorral4 = true;
        }
    }

    @Override
    public void dispose() {
      logo.dispose();
        FlechaVerde.dispose();
        gallinaL.dispose();
        gallinaR.dispose();
    }
}
