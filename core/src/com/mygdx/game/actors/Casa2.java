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
import static com.mygdx.game.MyGdxGame.Casa2;
import static com.mygdx.game.MyGdxGame.Pixels;

public class Casa2 extends Actor implements Disposable {
    public static Texture logo;
    public static Rectangle Cuerpo,Cuerpo2;
    public static float x,y;
    boolean noToca;
    boolean cambiarPosicion = false;
float timeDurationTouch;

    public Casa2()
    {
        logo = new Texture("Casa.png");
        Cuerpo = new Rectangle();
        Cuerpo2 = new Rectangle();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {

        batch.draw(logo,x,y,110/Pixels,110/Pixels);
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
        if (MyGdxGame.CasasColocadas.getInteger("Posiciones4") == 1 && MenuBuild.CasasBuild) {
            for (Rectangle e : Tierra1.rects) {
                if (Jugador.jugador.overlaps(e)) {
                    if (noToca) {
                        MyGdxGame.CasasColocadas.putInteger("Posiciones4", 2);
                        Casa2.putFloat("X13", Jugador.body.getPosition().x);
                        if (AddResources.TouchConfirm) {
                            Casa2.flush();
                        }
                        Casa2.putFloat("Y13", (e.y + (5 / Pixels)) - 5 / Pixels);
                        if (AddResources.TouchConfirm) {
                            Casa2.flush();
                            MyGdxGame.CasasColocadas.flush();

                            MenuBuild.CasasBuild = false;
                            AddResources.TouchConfirm = false;
                            AddResources.TouchCancel = false;
                        }
                    }
                }
            }
        }

        if (MenuBuild.CasasBuild && MyGdxGame.CasasColocadas.getInteger("Posiciones4") == 1) {
            for (Rectangle e : Tierra1.rects) {

                if (Jugador.jugador.overlaps(e)) {
                    y = (e.y + (5 / Pixels)) - 5 / Pixels;
                    x = Jugador.body.getPosition().x;
                    Cuerpo2.set(x, y, 110 / Pixels, 170 / Pixels);

                }
            }
        } else {
            if (!cambiarPosicion) {
                x = Casa2.getFloat("X13");
                y = Casa2.getFloat("Y13");
                Cuerpo2.set(x, y, 110 / Pixels, 170 / Pixels);
            }
            if (!MenuBuild.CasasBuild) {

                Cuerpo.set(x, y, 110 / Pixels, 170 / Pixels);
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
                        y = (e.y + (5 / Pixels)) - 5 / Pixels;
                        x = Jugador.body.getPosition().x;
                        Cuerpo2.set(x, y, 110 / Pixels, 170 / Pixels);

                        Casa2.putFloat("X13", Jugador.body.getPosition().x);
                        if (AddResources.TouchConfirm) {
                            Casa2.flush();
                        }
                        Casa2.putFloat("Y13", (e.y + (5 / Pixels)) - 5 / Pixels);
                        if (AddResources.TouchConfirm) {
                            Casa2.flush();
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
        if(Cuerpo2.overlaps(Casa2Pisos.Cuerpo2)||Cuerpo2.overlaps(Casa2Pisos2.Cuerpo2)||Cuerpo2.overlaps(com.mygdx.game.actors.Casa1.Cuerpo2))
        {
            AddResources.isFreeSpaceTop4 = false;
        }else
        {
            AddResources.isFreeSpaceTop4 = true;
        }
    }

    @Override
    public void dispose() {
      logo.dispose();
    }
}
