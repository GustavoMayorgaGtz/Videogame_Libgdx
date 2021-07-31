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

import static com.mygdx.game.MyGdxGame.Maceta1_1;
import static com.mygdx.game.MyGdxGame.MaquinasComida1;
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
boolean isActive;

    public MaquinaComida1()
    {
        Cuerpo = new Rectangle();
        Cuerpo2 = new Rectangle();
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
        On = new Animation<TextureRegion>(0.4f,Tmp1);
        /******/
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        timeFree += Gdx.graphics.getDeltaTime();

        for(Rectangle no: noBuild) {
            if (no.overlaps(Jugador.jugador)) {
                noToca = false;
            }
            if(no.overlaps(Cuerpo2))
            {
                var30 = false;
            }
        }
        for(Rectangle yes: Build) {
            if (yes.overlaps(Jugador.jugador)) {
                noToca = true;
            }
            if(yes.overlaps(Cuerpo2))
            {
                var30 = true;
            }
        }

        for(Rectangle no: noBuild) {
            for(Rectangle yes: Build) {
                if(no.overlaps(Cuerpo2)&& yes.overlaps(Cuerpo2))
                {
                    var30 = false;
                }
            }
        }
        /******/
        if(isActive)
        {
            TextureRegion current = On.getKeyFrame(timeFree,true);
            batch.draw(current,x,y,64/Pixels,64/Pixels);
        }else
        {
            batch.draw(off,x,y,64/Pixels,64/Pixels);
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
                    Cuerpo2.set(x, y, 32/Pixels,32/Pixels);

                }
            }
        } else {
            if (!cambiarPosicion) {
                x = MaquinasComida1.getFloat("X30");
                y = MaquinasComida1.getFloat("Y30");
                Cuerpo2.set(x, y, 32/Pixels,32/Pixels);
            }
            if (!MenuBuild.buildMaquinaComida) {

                Cuerpo.set(x, y, 32/Pixels,32/Pixels);
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
                        Cuerpo2.set(x, y, 32/Pixels,32/Pixels);

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
        if(Cuerpo2.overlaps(Casa2Pisos.Cuerpo2)||Cuerpo2.overlaps(Casa2Pisos2.Cuerpo2)||Cuerpo2.overlaps(com.mygdx.game.actors.Casa1.Cuerpo2)||Cuerpo2.overlaps(Casa2.Cuerpo2)||Cuerpo2.overlaps(Maceta1_2.Cuerpo2)||Cuerpo2.overlaps(Maceta1_3.Cuerpo2)
                ||Cuerpo2.overlaps(Maceta2_1.Cuerpo2)||Cuerpo2.overlaps(Maceta2_2.Cuerpo2)||Cuerpo2.overlaps(Maceta2_3.Cuerpo2)
                ||Cuerpo2.overlaps(Arbusto1_1.Cuerpo2)||Cuerpo2.overlaps(Arbusto1_2.Cuerpo2)||Cuerpo2.overlaps(Arbusto1_3.Cuerpo2)
                ||Cuerpo2.overlaps(Arbusto2_1.Cuerpo2)||Cuerpo2.overlaps(Arbusto2_2.Cuerpo2)||Cuerpo2.overlaps(Arbusto2_3.Cuerpo2)
                ||Cuerpo2.overlaps(CorralVaca.Cuerpo2)||Cuerpo2.overlaps(CorralVaca2.Cuerpo2)||Cuerpo2.overlaps(CorralGallinas.Cuerpo2)||Cuerpo2.overlaps(CorralGallinas2.Cuerpo2))
        {
            AddResources.isFreeSpaceTop5 = false;
        }else
        {
            AddResources.isFreeSpaceTop5 = true;
        }
    }

    @Override
    public void dispose() {
     on.dispose();
     off.dispose();
    }
}
