package com.mygdx.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.game.Menu;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.tiled.AddResources;


import java.util.ArrayList;

import static com.mygdx.game.MyGdxGame.Pixels;
import static com.mygdx.game.MyGdxGame.tierra1;

public class Tierra1 extends Actor implements Disposable {

    public static Rectangle Cuerpo;
    public static Rectangle Cuerpo2;
    Texture tierra;
    float x,y;
    public static ArrayList<Rectangle> rects;
    public static ArrayList<Rectangle> noBuild ;
    public static ArrayList<Rectangle> Build;
    Texture b;
    public static boolean noToca;
    Texture rango;
    Sprite rangoS;


    float timeDurationTouch;
    boolean cambiarPosicion;
    public Tierra1()
    {
            rango = new Texture("cuadradoNegro.png");
            rangoS = new Sprite(rango);

        Cuerpo = new Rectangle(x,y,32/ Pixels,32/Pixels);
        Cuerpo2 = new Rectangle(x,y,32/ Pixels,32/Pixels);
        tierra = new Texture("Tierral.png");
        b = new Texture("White.png");

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {

        if(MenuBuild.BuildTierra) {
        rangoS.setBounds(x-(32/Pixels),y,92/Pixels,32/Pixels);
        rangoS.setAlpha(0.5f);
        rangoS.draw(batch);
        }
        batch.draw(tierra,x,y,32/Pixels,32/Pixels);

      for(Rectangle no: noBuild) {
          if (no.overlaps(Jugador.jugador)) {
              noToca = false;
          }
      }
        for(Rectangle yes: Build) {
            if (yes.overlaps(Jugador.jugador)) {
                noToca = true;
            }
        }

    }

    @Override
    public void act(float delta) {
colisiones();
        if(MyGdxGame.TierrasColocadas.getInteger("Posiciones") == 0 && MenuBuild.BuildTierra) {
            for (Rectangle e : rects) {
                if (Jugador.jugador.overlaps(e)) {
                    if (noToca) {
                        MyGdxGame.TierrasColocadas.putInteger("Posiciones",1);
                        tierra1.putFloat("X", Jugador.body.getPosition().x);
                        if(AddResources.TouchConfirm) {
                            tierra1.flush();
                        }
                        tierra1.putFloat("Y", (e.y + (5 / Pixels)) - 32 / Pixels);
                        if(AddResources.TouchConfirm) {
                            tierra1.flush();
                            MyGdxGame.TierrasColocadas.flush();
                            MenuBuild.BuildTierra = false;
                            AddResources.TouchConfirm = false;
                            AddResources.TouchCancel = false;
                        }
                    }
                }
            }
        }

if(MenuBuild.BuildTierra&&MyGdxGame.TierrasColocadas.getInteger("Posiciones") == 0 ) {
    for (Rectangle e : rects) {
    if (Jugador.jugador.overlaps(e)) {
        y = (e.y + (5 / Pixels)) - 32 / Pixels;
        x = Jugador.body.getPosition().x;
        Cuerpo2.set(x, y, 32 / Pixels, 32 / Pixels);
    }
    }
}else
{
    x = tierra1.getFloat("X");
    y = tierra1.getFloat("Y");
    Cuerpo2.set(x, y, 32 / Pixels, 32 / Pixels);
    if(!MenuBuild.BuildTierra) {

        Cuerpo.set(x, y, 32 / Pixels, 32 / Pixels);
    }else
    {
        Cuerpo.set(0,0,0,0);
    }
}

if(MenuBuild.isMover) {
    if (Cuerpo.overlaps(AddResources.puntero)) {
        timeDurationTouch += 1 * Gdx.graphics.getDeltaTime();
        if (timeDurationTouch > 2) {
            cambiarPosicion = true;
        }
    }
}

if(cambiarPosicion)
{
    MenuBuild.BuildTierra = true;
    for (Rectangle e : rects) {
        if (noToca) {
            if (Jugador.jugador.overlaps(e)) {
                y = (e.y + (5 / Pixels)) - 32 / Pixels;
                x = Jugador.body.getPosition().x;
                Cuerpo2.set(x, y, 32 / Pixels, 32 / Pixels);
            }
        }
    }
    for (Rectangle e : rects) {
        if (Jugador.jugador.overlaps(e)) {
            if (noToca) {
                tierra1.putFloat("X", Jugador.body.getPosition().x);
                if(AddResources.TouchConfirm) {
                    tierra1.flush();
                }
                tierra1.putFloat("Y", (e.y + (5 / Pixels)) - 32 / Pixels);
                if(AddResources.TouchConfirm) {
                    tierra1.flush();
                    MenuBuild.BuildTierra = false;
                    MenuBuild.isMenu = false;
                    AddResources.TouchConfirm = false;
                    AddResources.TouchCancel = false;
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
        if(Cuerpo2.overlaps(Tierra2.Cuerpo2))
        {
            AddResources.isFreeSpace = false;
        }else
        {
            AddResources.isFreeSpace = true;
        }
    }

    @Override
    public void dispose() {
        tierra.dispose();
        rango.dispose();
        b.dispose();
    }
}
