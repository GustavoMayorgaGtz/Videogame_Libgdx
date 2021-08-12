package com.mygdx.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.tiled.AddResources;

import static com.mygdx.game.MyGdxGame.Corral1Vacas;
import static com.mygdx.game.MyGdxGame.Maceta1_1;
import static com.mygdx.game.MyGdxGame.Maquina1Complete;
import static com.mygdx.game.MyGdxGame.MaquinasComida1;
import static com.mygdx.game.MyGdxGame.MaquinasComida1Iterator;
import static com.mygdx.game.MyGdxGame.Pixels;
import static com.mygdx.game.actors.Tierra1.Build;
import static com.mygdx.game.actors.Tierra1.noBuild;

public class MaquinaComida1 extends Actor implements Disposable {
    public static boolean var30= true;

    public static Rectangle Cuerpo,Cuerpo2;
    public static float x,y;
    boolean noToca;
    boolean cambiarPosicion = false;
float timeDurationTouch;

Texture on,off;
Animation<TextureRegion> On;
int c = 1, r = 4;
float timeFree;
public static boolean isActive;
/***/
    boolean sube = true,baja;
    float abs;
    Texture FlechaVerde;
/***/
Texture CostalGallina,CostalVaca;
Rectangle Costales;

    public MaquinaComida1()
    {
        CostalGallina = MyGdxGame.getManager().get("Almacen/ComidaGallina.png");
        CostalVaca = MyGdxGame.getManager().get("Almacen/ComidaVaca.png");
        Costales = new Rectangle();
        Cuerpo = new Rectangle();
        Cuerpo2 = new Rectangle();
        on = new Texture("MaquinaComidaOn.png");
        off = new Texture("MaquinaComida.png");
        FlechaVerde = new Texture("FlechaVerde.png");
        /*****/
        TextureRegion[][] Frame1 = TextureRegion.split(on,on.getWidth()/c,on.getHeight()/r);
        TextureRegion[] Tmp1 = new TextureRegion[c*r];
        int index0 = 0;
        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                Tmp1[index0++]=Frame1[i][j];
            }
        }
        On = new Animation<TextureRegion>(0.2f,Tmp1);
        /******/
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        timeFree += Gdx.graphics.getDeltaTime();
        /***************/
        if (sube) {
            if (abs < 5) {
                abs += 15 * Gdx.graphics.getDeltaTime();
            } else {
                baja = true;
                sube = false;
            }
        }
        if (baja) {
            if (abs > 1) {
                abs -= 15 * Gdx.graphics.getDeltaTime();
            } else {
                baja = false;
                sube = true;
            }
        }
/***************/
        for (Rectangle no : noBuild) {
            if (no.overlaps(Jugador.jugador)) {
                noToca = false;
            }
            if (no.overlaps(Cuerpo2)) {
                var30 = false;
            }
        }
        for (Rectangle yes : Build) {
            if (yes.overlaps(Jugador.jugador)) {
                noToca = true;
            }
            if (yes.overlaps(Cuerpo2)) {
                var30 = true;
            }
        }

        for (Rectangle no : noBuild) {
            for (Rectangle yes : Build) {
                if (no.overlaps(Cuerpo2) && yes.overlaps(Cuerpo2)) {
                    var30 = false;
                }
            }
        }
        /******/
        if(MyGdxGame.Maquina1Vaca.getBoolean("Maquina1Vaca")||MyGdxGame.Maquina1Gallina.getBoolean("Maquina1Gallina"))
        {
            TextureRegion current = On.getKeyFrame(timeFree, true);
            batch.draw(current, x, y, 64 / Pixels, 64 / Pixels);
            if(MyGdxGame.MaquinasComida1Iterator.getInteger("MaquinasComida1Iterator") == 0) {
                TimeZone t = new TimeZone();
                t.calcularHora = true;
                if(MyGdxGame.Maquina1Vaca.getBoolean("Maquina1Vaca"))
                {
                    t.CalcularTiempo(5);
                    MyGdxGame.Maquina1isVaca.putBoolean("Maquina1isVaca",true);
                    MyGdxGame.Maquina1isGallina.putBoolean("Maquina1isGallina",false);
                    MyGdxGame.Maquina1isVaca.flush();
                    MyGdxGame.Maquina1isGallina.flush();
                }
                if(MyGdxGame.Maquina1Gallina.getBoolean("Maquina1Gallina"))
                {
                    t.CalcularTiempo(4);
                    MyGdxGame.Maquina1isVaca.putBoolean("Maquina1isVaca",false);
                    MyGdxGame.Maquina1isGallina.putBoolean("Maquina1isGallina",true);
                    MyGdxGame.Maquina1isVaca.flush();
                    MyGdxGame.Maquina1isGallina.flush();
                }

                MyGdxGame.MaquinasComida1Day.putInteger("MaquinasComida1Day", t.dayS);
                MyGdxGame.MaquinasComida1Year.putInteger("MaquinasComida1Year", t.yearS);
                MyGdxGame.MaquinasComida1Hour.putInteger("MaquinasComida1Hour", t.hourS);
                MyGdxGame.MaquinasComida1Minute.putInteger("MaquinasComida1Minute", t.minuteS);
                MyGdxGame.MaquinasComida1Day.flush();
                MyGdxGame.MaquinasComida1Year.flush();
                MyGdxGame.MaquinasComida1Hour.flush();
                MyGdxGame.MaquinasComida1Minute.flush();
                MaquinasComida1Iterator.putInteger("MaquinasComida1Iterator", 1);
                MaquinasComida1Iterator.flush();
                Gdx.app.log("TimeYear",""+t.yearS);
                Gdx.app.log("TimeDay",""+t.dayS);
                Gdx.app.log("TimeHour",""+t.hourS);
                Gdx.app.log("TimeMinute",""+t.minuteS);
            }
                TimeZone t2 = new TimeZone();

                if (t2.year > MyGdxGame.MaquinasComida1Year.getInteger("MaquinasComida1Year")) {
                    MyGdxGame.Maquina1Vaca.putBoolean("Maquina1Vaca", false);
                    MyGdxGame.Maquina1Gallina.putBoolean("Maquina1Gallina", false);
                    MyGdxGame.Maquina1Vaca.flush();
                    MyGdxGame.Maquina1Gallina.flush();
                    MaquinasComida1Iterator.putInteger("MaquinasComida1Iterator", 0);
                    MaquinasComida1Iterator.flush();
                    isActive = false;
                    Maquina1Complete.putInteger("Maquina1Complete",1);
                    Maquina1Complete.flush();
                } else if (t2.day > MyGdxGame.MaquinasComida1Day.getInteger("MaquinasComida1Day")) {
                    MyGdxGame.Maquina1Vaca.putBoolean("Maquina1Vaca", false);
                    MyGdxGame.Maquina1Gallina.putBoolean("Maquina1Gallina", false);
                    MyGdxGame.Maquina1Vaca.flush();
                    MyGdxGame.Maquina1Gallina.flush();
                    MaquinasComida1Iterator.putInteger("MaquinasComida1Iterator", 0);
                    MaquinasComida1Iterator.flush();
                    isActive = false;
                    Maquina1Complete.putInteger("Maquina1Complete",1);
                    Maquina1Complete.flush();
                } else if (t2.hour > MyGdxGame.MaquinasComida1Hour.getInteger("MaquinasComida1Hour")) {
                    MyGdxGame.Maquina1Vaca.putBoolean("Maquina1Vaca", false);
                    MyGdxGame.Maquina1Gallina.putBoolean("Maquina1Gallina", false);
                    MyGdxGame.Maquina1Vaca.flush();
                    MyGdxGame.Maquina1Gallina.flush();
                    MaquinasComida1Iterator.putInteger("MaquinasComida1Iterator", 0);
                    MaquinasComida1Iterator.flush();
                    isActive = false;
                    Maquina1Complete.putInteger("Maquina1Complete",1);
                    Maquina1Complete.flush();
                } else if (t2.minute > MyGdxGame.MaquinasComida1Minute.getInteger("MaquinasComida1Minute")) {
                    MyGdxGame.Maquina1Vaca.putBoolean("Maquina1Vaca", false);
                    MyGdxGame.Maquina1Gallina.putBoolean("Maquina1Gallina", false);
                    MyGdxGame.Maquina1Vaca.flush();
                    MyGdxGame.Maquina1Gallina.flush();
                    MaquinasComida1Iterator.putInteger("MaquinasComida1Iterator", 0);
                    MaquinasComida1Iterator.flush();
                    isActive = false;
                    Maquina1Complete.putInteger("Maquina1Complete",1);
                    Maquina1Complete.flush();
                }
        }else
        {
            batch.draw(off, x, y, 64 / Pixels, 64 / Pixels);
            if(Maquina1Complete.getInteger("Maquina1Complete") == 1)
            {
                Costales.set(x+(24/Pixels),y + ((abs / Pixels)/2),40/Pixels,32/Pixels);
                if(MyGdxGame.Maquina1isVaca.getBoolean("Maquina1isVaca"))
                {
                batch.draw(CostalVaca,x+(24/Pixels),y + (((abs / Pixels)/2)*-1),15/Pixels,15/Pixels);
                batch.draw(CostalVaca,x+(32/Pixels),y + ((abs / Pixels)/2),15/Pixels,15/Pixels);
                    if(Costales.overlaps(Jugador.jugador)) {
                        MenuBuild.ComidaVacaB = true;
                        MenuBuild.MandarAlmacen = true;
                        MenuBuild.FiguraX =x + (30 / Pixels);
                        MenuBuild.FiguraY = y + (32 / Pixels);
                        int vaca = MyGdxGame.ComidaVacaStocks.getInteger("ComidaVacaStocks");
                        vaca += 2;
                        MyGdxGame.ComidaVacaStocks.putInteger("ComidaVacaStocks",vaca);
                        MyGdxGame.ComidaVacaStocks.flush();
                        Maquina1Complete.putInteger("Maquina1Complete",0);
                        Maquina1Complete.flush();
                    }
                }
                if(MyGdxGame.Maquina1isGallina.getBoolean("Maquina1isGallina"))
                {
                    batch.draw(CostalGallina,x+(24/Pixels),y + (((abs / Pixels)/2)*-1),15/Pixels,15/Pixels);
                    batch.draw(CostalGallina,x+(32/Pixels),y + ((abs / Pixels)/2),15/Pixels,15/Pixels);
                    if(Costales.overlaps(Jugador.jugador)) {
                        MenuBuild.ComidaGallinaB = true;
                        MenuBuild.MandarAlmacen = true;
                        MenuBuild.FiguraX = x + (30 / Pixels);
                        MenuBuild.FiguraY = y + (32 / Pixels);
                        int gallina = MyGdxGame.ComidaGallinaStocks.getInteger("ComidaGallinaStocks");
                        gallina += 2;
                        MyGdxGame.ComidaGallinaStocks.putInteger("ComidaGallinaStocks",gallina);
                        MyGdxGame.ComidaGallinaStocks.flush();
                        Maquina1Complete.putInteger("Maquina1Complete",0);
                        Maquina1Complete.flush();
                    }
                }


            }else
            {
                Costales.set(0,0,0,0);
                if (!isActive) {
                    if (Jugador.jugador.overlaps(Cuerpo) && !MenuBuild.isMenu) {
                        batch.draw(FlechaVerde, x + (16 / Pixels), y + (32 / Pixels) + (abs / Pixels), 32 / Pixels, 32 / Pixels);
                        if(AddResources.puntero.overlaps(Cuerpo2))
                        {
                            isActive = true;
                        }
                    }
                }
            }

        }


    }

    @Override
    public void act(float delta) {
        colisiones();
        if (MyGdxGame.MaquinaComidaColocadas.getInteger("MaquinaColocada") == 0 && MenuBuild.buildMaquinaComida) {
            for (Rectangle e : Tierra1.rects) {
                if (Jugador.jugador.overlaps(e)) {
                    if (noToca) {
                        MyGdxGame.MaquinaComidaColocadas.putInteger("MaquinaColocada", 1);
                        MaquinasComida1.putFloat("X30", Jugador.body.getPosition().x);
                        if (AddResources.TouchConfirm) {
                            MaquinasComida1.flush();
                        }
                        MaquinasComida1.putFloat("Y30", (e.y + (2 / Pixels)));
                        if (AddResources.TouchConfirm) {
                            MaquinasComida1.flush();
                            MyGdxGame.MaquinaComidaColocadas.flush();
                            MenuBuild.buildMaquinaComida = false;
                            AddResources.TouchConfirm = false;
                            AddResources.TouchCancel = false;
                        }
                    }
                }
            }
        }

        if (MyGdxGame.MaquinaComidaColocadas.getInteger("MaquinaColocada") == 0 && MenuBuild.buildMaquinaComida) {
            for (Rectangle e : Tierra1.rects) {

                if (Jugador.jugador.overlaps(e)) {
                    y = (e.y + (2 / Pixels));
                    x = Jugador.body.getPosition().x;
                    Cuerpo2.set(x, y, 64 / Pixels, 64 / Pixels);

                }
            }
        } else {
            if (!cambiarPosicion) {
                x = MaquinasComida1.getFloat("X30");
                y = MaquinasComida1.getFloat("Y30");
                Cuerpo2.set(x, y, 64 / Pixels, 64 / Pixels);
            }
            if (!MenuBuild.buildMaquinaComida&&!MenuBuild.isAlmacen&&!MenuBuild.isMenuSeedSelection&&!MenuBuild.isMenu&&!MenuBuild.isCorralGallinasBuild&&!MenuBuild.isCorralVacasBuild&&!MenuBuild.gallinaBuild&&!MenuBuild.vacaBuild
                    &&!MenuBuild.BuildTierra&&!MenuBuild.BuildAgua&&!MenuBuild.BuildMover&&!MenuBuild.Arbusto1Build&&!MenuBuild.Arbusto2Build
                    &&!MenuBuild.CasasBuild&&!MenuBuild.CasasDosPisosBuild&&!MenuBuild.Maceta1Build&&!MenuBuild.Maceta2Build) {

                Cuerpo.set(x, y, 64 / Pixels, 64 / Pixels);
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
            MenuBuild.BuildMover = true;
            for (Rectangle e : Tierra1.rects) {
                if (noToca) {
                    if (Jugador.jugador.overlaps(e)) {
                        y = (e.y + (2 / Pixels));
                        x = Jugador.body.getPosition().x;
                        Cuerpo2.set(x, y, 64 / Pixels, 64 / Pixels);

                        MaquinasComida1.putFloat("X30", Jugador.body.getPosition().x);
                        if (AddResources.TouchConfirm) {
                            Maceta1_1.flush();
                        }
                        MaquinasComida1.putFloat("Y30", (e.y + (2 / Pixels)));
                        if (AddResources.TouchConfirm) {
                            MaquinasComida1.flush();
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
        if(Cuerpo2.overlaps(Casa2Pisos.Cuerpo2)||Cuerpo2.overlaps(Casa2Pisos2.Cuerpo2)||Cuerpo2.overlaps(com.mygdx.game.actors.Casa1.Cuerpo2)||Cuerpo2.overlaps(Casa2.Cuerpo2)||Cuerpo2.overlaps(Maceta1_2.Cuerpo2)||Cuerpo2.overlaps(com.mygdx.game.actors.Maceta1_1.Cuerpo2)||Cuerpo2.overlaps(Maceta1_3.Cuerpo2)
                ||Cuerpo2.overlaps(Maceta2_1.Cuerpo2)||Cuerpo2.overlaps(Maceta2_2.Cuerpo2)||Cuerpo2.overlaps(Maceta2_3.Cuerpo2)
                ||Cuerpo2.overlaps(Arbusto1_1.Cuerpo2)||Cuerpo2.overlaps(Arbusto1_2.Cuerpo2)||Cuerpo2.overlaps(Arbusto1_3.Cuerpo2)
                ||Cuerpo2.overlaps(Arbusto2_1.Cuerpo2)||Cuerpo2.overlaps(Arbusto2_2.Cuerpo2)||Cuerpo2.overlaps(Arbusto2_3.Cuerpo2)
                ||Cuerpo2.overlaps(CorralVaca.Cuerpo2)||Cuerpo2.overlaps(CorralVaca2.Cuerpo2)||Cuerpo2.overlaps(CorralGallinas.Cuerpo2)||Cuerpo2.overlaps(CorralGallinas2.Cuerpo2)
                ||Cuerpo2.overlaps(MaquinaComida2.Cuerpo2))
        {
            AddResources.freeMaquina1 = false;
        }else
        {
            AddResources.freeMaquina1 = true;
        }
    }

    @Override
    public void dispose() {
     on.dispose();
     off.dispose();
     FlechaVerde.dispose();
    }
}
