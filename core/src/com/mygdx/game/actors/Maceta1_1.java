package com.mygdx.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.tiled.AddResources;

import static com.mygdx.game.MyGdxGame.Casa1;
import static com.mygdx.game.MyGdxGame.Maceta1_1;
import static com.mygdx.game.MyGdxGame.Pixels;

public class Maceta1_1 extends Actor implements Disposable {
    public static Texture logo;
    public static Rectangle Cuerpo,Cuerpo2;
    public static float x,y;
    boolean noToca;
    boolean cambiarPosicion = false;
float timeDurationTouch;

    public Maceta1_1()
    {
        logo = new Texture("Maceta1.png");
        Cuerpo = new Rectangle();
        Cuerpo2 = new Rectangle();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {

        batch.draw(logo,x,y,32/Pixels,32/Pixels);
        for(Rectangle no: Tierra1.noBuild) {
            if (no.overlaps(Jugador.jugador)) {
                noToca = false;
            }
        }
        for(Rectangle yes: Tierra1.Build) {
            if (yes.overlaps(Jugador.jugador)) {
                noToca = true;
            }
        }
    }

    @Override
    public void act(float delta) {
        colisiones();
        if (MyGdxGame.Maceta1Colocadas.getInteger("Posiciones5") == 0 && MenuBuild.Maceta1Build) {
            for (Rectangle e : Tierra1.rects) {
                if (Jugador.jugador.overlaps(e)) {
                    if (noToca) {
                        MyGdxGame.Maceta1Colocadas.putInteger("Posiciones5", 1);
                        Maceta1_1.putFloat("X14", Jugador.body.getPosition().x);
                        if (AddResources.TouchConfirm) {
                            Maceta1_1.flush();
                        }
                        Maceta1_1.putFloat("Y14", (e.y + (5 / Pixels)) - 5 / Pixels);
                        if (AddResources.TouchConfirm) {
                            Maceta1_1.flush();
                            MyGdxGame.Maceta1Colocadas.flush();
                            MenuBuild.Maceta1Build = false;
                            AddResources.TouchConfirm = false;
                            AddResources.TouchCancel = false;
                        }
                    }
                }
            }
        }

        if (MyGdxGame.Maceta1Colocadas.getInteger("Posiciones5") == 0 && MenuBuild.Maceta1Build) {
            for (Rectangle e : Tierra1.rects) {

                if (Jugador.jugador.overlaps(e)) {
                    y = (e.y + (5 / Pixels)) - 5 / Pixels;
                    x = Jugador.body.getPosition().x;
                    Cuerpo2.set(x, y, 32/Pixels,32/Pixels);

                }
            }
        } else {
            if (!cambiarPosicion) {
                x = Maceta1_1.getFloat("X14");
                y = Maceta1_1.getFloat("Y14");
                Cuerpo2.set(x, y, 32/Pixels,32/Pixels);
            }
            if (!MenuBuild.Maceta1Build) {

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
                        y = (e.y + (5 / Pixels)) - 3 / Pixels;
                        x = Jugador.body.getPosition().x;
                        Cuerpo2.set(x, y, 32/Pixels,32/Pixels);

                        Maceta1_1.putFloat("X14", Jugador.body.getPosition().x);
                        if (AddResources.TouchConfirm) {
                            Maceta1_1.flush();
                        }
                        Maceta1_1.putFloat("Y14", (e.y + (5 / Pixels)) - 3 / Pixels);
                        if (AddResources.TouchConfirm) {
                            Maceta1_1.flush();
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
        if(Cuerpo2.overlaps(Casa2Pisos.Cuerpo2)||Cuerpo2.overlaps(Casa2Pisos2.Cuerpo2)||Cuerpo2.overlaps(com.mygdx.game.actors.Casa1.Cuerpo2)||Cuerpo2.overlaps(Casa2.Cuerpo2)||Cuerpo2.overlaps(Maceta1_2.Cuerpo2)||Cuerpo2.overlaps(Maceta1_3.Cuerpo2))
        {
            AddResources.isFreeSpaceTop5 = false;
        }else
        {
            AddResources.isFreeSpaceTop5 = true;
        }
    }

    @Override
    public void dispose() {
      logo.dispose();
    }
}