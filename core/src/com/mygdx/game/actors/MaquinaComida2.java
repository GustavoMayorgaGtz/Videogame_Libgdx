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

import static com.mygdx.game.MyGdxGame.Maceta1_1;

import static com.mygdx.game.MyGdxGame.MaquinasComida2;
import static com.mygdx.game.MyGdxGame.MaquinasComida2Iterator;
import static com.mygdx.game.MyGdxGame.Pixels;
import static com.mygdx.game.actors.Tierra1.Build;
import static com.mygdx.game.actors.Tierra1.noBuild;

public class MaquinaComida2 extends Actor implements Disposable {
    public static boolean var31 = true;

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
    public MaquinaComida2()
    {
        Cuerpo = new Rectangle();
        Cuerpo2 = new Rectangle();
        FlechaVerde = new Texture("FlechaVerde.png");
        on = new Texture("MaquinaComidaOn.png");
        off = new Texture("MaquinaComida.png");
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
        for(Rectangle no: noBuild) {
            if (no.overlaps(Jugador.jugador)) {
                noToca = false;
            }
            if(no.overlaps(Cuerpo2))
            {
                var31 = false;
            }
        }
        for(Rectangle yes: Build) {
            if (yes.overlaps(Jugador.jugador)) {
                noToca = true;
            }
            if(yes.overlaps(Cuerpo2))
            {
                var31 = true;
            }
        }

        for(Rectangle no: noBuild) {
            for(Rectangle yes: Build) {
                if(no.overlaps(Cuerpo2)&& yes.overlaps(Cuerpo2))
                {
                    var31 = false;
                }
            }
        }
        /******/
        if(MyGdxGame.Maquina2Vaca.getBoolean("Maquina2Vaca")||MyGdxGame.Maquina2Gallina.getBoolean("Maquina2Gallina"))
        {
            TextureRegion current = On.getKeyFrame(timeFree, true);
            batch.draw(current, x, y, 64 / Pixels, 64 / Pixels);
            if(MaquinasComida2Iterator.getInteger("MaquinasComida2Iterator") == 0) {
                TimeZone t = new TimeZone();
                t.calcularHora = true;
                if(MyGdxGame.Maquina2Vaca.getBoolean("Maquina2Vaca"))
                {
                    t.CalcularTiempo(5);
                }
                if(MyGdxGame.Maquina2Gallina.getBoolean("Maquina2Gallina"))
                {
                    t.CalcularTiempo(3);
                }

                MyGdxGame.MaquinasComida2Day.putInteger("MaquinasComida2Day", t.dayS);
                MyGdxGame.MaquinasComida2Year.putInteger("MaquinasComida2Year", t.yearS);
                MyGdxGame.MaquinasComida2Hour.putInteger("MaquinasComida2Hour", t.hourS);
                MyGdxGame.MaquinasComida2Minute.putInteger("MaquinasComida2Minute", t.minuteS);
                MyGdxGame.MaquinasComida2Day.flush();
                MyGdxGame.MaquinasComida2Year.flush();
                MyGdxGame.MaquinasComida2Hour.flush();
                MyGdxGame.MaquinasComida2Minute.flush();
                MaquinasComida2Iterator.putInteger("MaquinasComida2Iterator", 1);
                MaquinasComida2Iterator.flush();
                Gdx.app.log("TimeYear",""+t.yearS);
                Gdx.app.log("TimeDay",""+t.dayS);
                Gdx.app.log("TimeHour",""+t.hourS);
                Gdx.app.log("TimeMinute",""+t.minuteS);
            }
            TimeZone t2 = new TimeZone();

            if (t2.year > MyGdxGame.MaquinasComida2Year.getInteger("MaquinasComida2Year")) {
                MyGdxGame.Maquina2Vaca.putBoolean("Maquina2Vaca", false);
                MyGdxGame.Maquina2Gallina.putBoolean("Maquina2Gallina", false);
                MyGdxGame.Maquina2Vaca.flush();
                MyGdxGame.Maquina2Gallina.flush();
                MaquinasComida2Iterator.putInteger("MaquinasComida2Iterator", 0);
                MaquinasComida2Iterator.flush();
                isActive = false;
            } else if (t2.day > MyGdxGame.MaquinasComida2Day.getInteger("MaquinasComida2Day")) {
                MyGdxGame.Maquina2Vaca.putBoolean("Maquina2Vaca", false);
                MyGdxGame.Maquina2Gallina.putBoolean("Maquina2Gallina", false);
                MyGdxGame.Maquina2Vaca.flush();
                MyGdxGame.Maquina2Gallina.flush();
                MaquinasComida2Iterator.putInteger("MaquinasComida2Iterator", 0);
                MaquinasComida2Iterator.flush();
                isActive = false;
            } else if (t2.hour > MyGdxGame.MaquinasComida2Hour.getInteger("MaquinasComida2Hour")) {
                MyGdxGame.Maquina2Vaca.putBoolean("Maquina2Vaca", false);
                MyGdxGame.Maquina2Gallina.putBoolean("Maquina2Gallina", false);
                MyGdxGame.Maquina2Vaca.flush();
                MyGdxGame.Maquina2Gallina.flush();
                MaquinasComida2Iterator.putInteger("MaquinasComida2Iterator", 0);
                MaquinasComida2Iterator.flush();
                isActive = false;
            } else if (t2.minute > MyGdxGame.MaquinasComida2Minute.getInteger("MaquinasComida2Minute")) {
                MyGdxGame.Maquina2Vaca.putBoolean("Maquina2Vaca", false);
                MyGdxGame.Maquina2Gallina.putBoolean("Maquina2Gallina", false);
                MyGdxGame.Maquina2Vaca.flush();
                MyGdxGame.Maquina2Gallina.flush();
                MaquinasComida2Iterator.putInteger("MaquinasComida2Iterator", 0);
                MaquinasComida2Iterator.flush();
                isActive = false;
            }
        }else
        {
            batch.draw(off, x, y, 64 / Pixels, 64 / Pixels);

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

    @Override
    public void act(float delta) {
        colisiones();
        if (MyGdxGame.MaquinaComidaColocadas.getInteger("MaquinaColocada") == 1 && MenuBuild.buildMaquinaComida) {
            for (Rectangle e : Tierra1.rects) {
                if (Jugador.jugador.overlaps(e)) {
                    if (noToca) {
                        MyGdxGame.MaquinaComidaColocadas.putInteger("MaquinaColocada", 2);
                        MaquinasComida2.putFloat("X31", Jugador.body.getPosition().x);
                        if (AddResources.TouchConfirm) {
                            MaquinasComida2.flush();
                        }
                        MaquinasComida2.putFloat("Y31", (e.y + (2 / Pixels)));
                        if (AddResources.TouchConfirm) {
                            MaquinasComida2.flush();
                            MyGdxGame.MaquinaComidaColocadas.flush();
                            MenuBuild.buildMaquinaComida = false;
                            AddResources.TouchConfirm = false;
                            AddResources.TouchCancel = false;
                        }
                    }
                }
            }
        }

        if (MyGdxGame.MaquinaComidaColocadas.getInteger("MaquinaColocada") == 1 && MenuBuild.buildMaquinaComida) {
            for (Rectangle e : Tierra1.rects) {

                if (Jugador.jugador.overlaps(e)) {
                    y = (e.y + (2 / Pixels));
                    x = Jugador.body.getPosition().x;
                    Cuerpo2.set(x, y, 64 / Pixels, 64 / Pixels);

                }
            }
        } else {
            if (!cambiarPosicion) {
                x = MaquinasComida2.getFloat("X31");
                y = MaquinasComida2.getFloat("Y31");
                Cuerpo2.set(x, y, 64 / Pixels, 64 / Pixels);
            }
            if (!MenuBuild.buildMaquinaComida&&!MenuBuild.isAlmacen&&!MenuBuild.isMenuSeedSelection&&!MenuBuild.isMenu&&!MenuBuild.isCorralGallinasBuild&&!MenuBuild.isCorralVacasBuild&&!MenuBuild.gallinaBuild&&!MenuBuild.vacaBuild
                    &&!MenuBuild.BuildTierra&&!MenuBuild.BuildAgua&&!MenuBuild.BuildMover&&!MenuBuild.Arbusto1Build&&!MenuBuild.Arbusto2Build
                    &&!MenuBuild.CasasBuild&&!MenuBuild.CasasDosPisosBuild&&!MenuBuild.Maceta1Build&&!MenuBuild.Maceta2Build) {

                Cuerpo.set(x, y, 64 / Pixels, 64 / Pixels);
            } else {
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

                        MaquinasComida2.putFloat("X31", Jugador.body.getPosition().x);
                        if (AddResources.TouchConfirm) {
                            Maceta1_1.flush();
                        }
                        MaquinasComida2.putFloat("Y31", (e.y + (2 / Pixels)));
                        if (AddResources.TouchConfirm) {
                            MaquinasComida2.flush();
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
        if(Cuerpo2.overlaps(Casa2Pisos.Cuerpo2)||Cuerpo2.overlaps(Casa2Pisos2.Cuerpo2)||Cuerpo2.overlaps(Casa1.Cuerpo2)||Cuerpo2.overlaps(Casa2.Cuerpo2)||Cuerpo2.overlaps(com.mygdx.game.actors.Maceta1_1.Cuerpo2)||Cuerpo2.overlaps(Maceta1_2.Cuerpo2)||Cuerpo2.overlaps(Maceta1_3.Cuerpo2)
                ||Cuerpo2.overlaps(Maceta2_1.Cuerpo2)||Cuerpo2.overlaps(Maceta2_2.Cuerpo2)||Cuerpo2.overlaps(Maceta2_3.Cuerpo2)
                ||Cuerpo2.overlaps(Arbusto1_1.Cuerpo2)||Cuerpo2.overlaps(Arbusto1_2.Cuerpo2)||Cuerpo2.overlaps(Arbusto1_3.Cuerpo2)
                ||Cuerpo2.overlaps(Arbusto2_1.Cuerpo2)||Cuerpo2.overlaps(Arbusto2_2.Cuerpo2)||Cuerpo2.overlaps(Arbusto2_3.Cuerpo2)
                ||Cuerpo2.overlaps(CorralVaca.Cuerpo2)||Cuerpo2.overlaps(CorralVaca2.Cuerpo2)||Cuerpo2.overlaps(CorralGallinas.Cuerpo2)||Cuerpo2.overlaps(CorralGallinas2.Cuerpo2)
                ||Cuerpo2.overlaps(MaquinaComida1.Cuerpo2))
        {
            AddResources.freeMaquina2 = false;
        }else
        {
            AddResources.freeMaquina2 = true;
        }
    }

    @Override
    public void dispose() {
     on.dispose();
     off.dispose();
     FlechaVerde.dispose();
    }
}
