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

import static com.mygdx.game.MyGdxGame.Alpha;
import static com.mygdx.game.MyGdxGame.Pixels;
import static com.mygdx.game.MyGdxGame.tierra1;
import static com.mygdx.game.MyGdxGame.tierra2;

public class Tierra1 extends Actor implements Disposable {

    public static Rectangle Cuerpo;
    public static Rectangle Cuerpo2;
    public static Rectangle range;
    Texture tierra,tierra2;
    float x,y;
    public static ArrayList<Rectangle> rects;
    public static ArrayList<Rectangle> noBuild ;
    public static ArrayList<Rectangle> Build;
    Texture b;
    public static boolean noToca;
    Texture rango;
    Sprite rangoS;
    public static float timeDurationTouch;
    public static boolean cambiarPosicion;

    public static boolean isDamp;
    public static boolean Trigo,Maiz,Soja,Zanahoria,Cana,Algodon;

    Texture brote;
    public Tierra1()
    {
            rango = new Texture("cuadradoNegro.png");
            rangoS = new Sprite(rango);

        Cuerpo = new Rectangle(x,y,32/ Pixels,32/Pixels);
        Cuerpo2 = new Rectangle();
        tierra = new Texture("Tierral.png");
        tierra2 = new Texture("tierra2.png");
        b = new Texture("White.png");
        range = new Rectangle();
        brote = new Texture("Brote.png");
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {


        range.set(x-(32/Pixels),y,92/Pixels,32/Pixels);
        if(range.overlaps(Agua1.range)||range.overlaps(Agua2.range)||range.overlaps(Agua3.range)||range.overlaps(Agua4.range))
        {
            batch.draw(tierra2, x, y, 32 / Pixels, 32 / Pixels);
            isDamp = true;
        }else {
            batch.draw(tierra, x, y, 32 / Pixels, 32 / Pixels);
            isDamp = false;
        }

        if(MyGdxGame.tierra1Trigo.getBoolean("tierra11"))
        {
            batch.draw(brote,x,y+(32/Pixels),32/Pixels,32/Pixels);
           MyGdxGame.tierra1Enable.putBoolean("tierra1",false);
            MyGdxGame.tierra1Enable.flush();
        }

        if(MyGdxGame.tierra1Maiz.getBoolean("tierra12"))
        {
            batch.draw(brote,x,y+(32/Pixels),32/Pixels,32/Pixels);
            MyGdxGame.tierra1Enable.putBoolean("tierra1",false);
            MyGdxGame.tierra1Enable.flush();
        }

        if(MyGdxGame.tierra1Soja.getBoolean("tierra13"))
        {
            batch.draw(brote,x,y+(32/Pixels),32/Pixels,32/Pixels);
            MyGdxGame.tierra1Enable.putBoolean("tierra1",false);
            MyGdxGame.tierra1Enable.flush();
        }

        if(MyGdxGame.tierra1Zanahoria.getBoolean("tierra14"))
        {
            batch.draw(brote,x,y+(32/Pixels),32/Pixels,32/Pixels);
            MyGdxGame.tierra1Enable.putBoolean("tierra1",false);
            MyGdxGame.tierra1Enable.flush();
        }

        if(MyGdxGame.tierra1Cana.getBoolean("tierra15"))
        {
            batch.draw(brote,x,y+(32/Pixels),32/Pixels,32/Pixels);
            MyGdxGame.tierra1Enable.putBoolean("tierra1",false);
            MyGdxGame.tierra1Enable.flush();
        }

        if(MyGdxGame.tierra1Algodon.getBoolean("tierra16"))
        {
            batch.draw(brote,x,y+(32/Pixels),32/Pixels,32/Pixels);
            MyGdxGame.tierra1Enable.putBoolean("tierra1",false);
            MyGdxGame.tierra1Enable.flush();
        }

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
    if(!cambiarPosicion) {
        x = tierra1.getFloat("X");
        y = tierra1.getFloat("Y");
        Cuerpo2.set(x, y, 32 / Pixels, 32 / Pixels);
    }
    if(!MenuBuild.BuildTierra) {

        Cuerpo.set(x, y, 32 / Pixels, 40 / Pixels);
    }else
    {
        Cuerpo.set(0,0,0,0);
    }
    if(MenuBuild.isMenu)
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

if(cambiarPosicion&&  MyGdxGame.tierra1Enable.getBoolean("tierra1"))
{
    MenuBuild.BuildMover = true;
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

            if (Cuerpo2.overlaps(Tierra2.Cuerpo2) || Cuerpo2.overlaps(Tierra3.Cuerpo2) || Cuerpo2.overlaps(Tierra4.Cuerpo2) || Cuerpo2.overlaps(Tierra5.Cuerpo2) || Cuerpo2.overlaps(Agua1.Cuerpo2) || Cuerpo2.overlaps(Agua2.Cuerpo2) || Cuerpo2.overlaps(Agua3.Cuerpo2) || Cuerpo2.overlaps(Agua4.Cuerpo2)) {
                AddResources.isFreeSpace1 = false;
            } else {
                AddResources.isFreeSpace1 = true;
            }

    }

    @Override
    public void dispose() {
        tierra.dispose();
        tierra2.dispose();
        rango.dispose();
        b.dispose();
        brote.dispose();
    }
}
