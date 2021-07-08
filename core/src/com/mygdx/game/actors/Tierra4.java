package com.mygdx.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.tiled.AddResources;

import static com.mygdx.game.MyGdxGame.Pixels;
import static com.mygdx.game.MyGdxGame.tierra2;
import static com.mygdx.game.MyGdxGame.tierra4;

public class Tierra4 extends Actor implements Disposable {

    public static Rectangle Cuerpo;
    public static Rectangle Cuerpo2;
    Texture tierra,tierra2;
    float x,y;
    Texture b;
    public static boolean noToca;
    Texture rango;
    Sprite rangoS;
    float timeDurationTouch;
    boolean cambiarPosicion;

    public static Rectangle range;
    public Tierra4()
    {
            rango = new Texture("cuadradoNegro.png");
            rangoS = new Sprite(rango);

        Cuerpo = new Rectangle(x,y,32/ Pixels,32/Pixels);
        Cuerpo2 = new Rectangle(x, y, 32 / Pixels, 32 / Pixels);
        tierra = new Texture("Tierral.png");
        tierra2 = new Texture("tierra2.png");
        b = new Texture("White.png");
        range = new Rectangle();

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {

        range.set(x-(32/Pixels),y,92/Pixels,32/Pixels);
        if(range.overlaps(Agua1.range)||range.overlaps(Agua2.range)||range.overlaps(Agua3.range)||range.overlaps(Agua4.range))
        {
            batch.draw(tierra2, x, y, 32 / Pixels, 32 / Pixels);
        }else {
            batch.draw(tierra, x, y, 32 / Pixels, 32 / Pixels);
        }

      for(Rectangle no: Tierra1.noBuild) {
          if (no.overlaps(Jugador.jugador)) {
              noToca = false;
          }
      }
        for(Rectangle yes:  Tierra1.Build) {
            if (yes.overlaps(Jugador.jugador)) {
                noToca = true;
            }
        }

    }

    @Override
    public void act(float delta) {
colisiones();
        if(MyGdxGame.TierrasColocadas.getInteger("Posiciones") == 3 && MenuBuild.BuildTierra) {
            for (Rectangle e :  Tierra1.rects) {
                if (Jugador.jugador.overlaps(e)) {
                    if (noToca) {
                        MyGdxGame.TierrasColocadas.putInteger("Posiciones",4);
                        tierra4.putFloat("X4", Jugador.body.getPosition().x);
                        if(AddResources.TouchConfirm) {
                            tierra4.flush();
                        }
                        tierra4.putFloat("Y4", (e.y + (5 / Pixels)) - 32 / Pixels);
                        if(AddResources.TouchConfirm) {
                            tierra4.flush();
                            MyGdxGame.TierrasColocadas.flush();
                            MenuBuild.BuildTierra = false;
                            AddResources.TouchConfirm = false;
                            AddResources.TouchCancel = false;
                        }
                    }
                }
            }
        }

if(MenuBuild.BuildTierra&&MyGdxGame.TierrasColocadas.getInteger("Posiciones") == 3 ) {
    for (Rectangle e :  Tierra1.rects) {
    if (Jugador.jugador.overlaps(e)) {
        y = (e.y + (5 / Pixels)) - 32 / Pixels;
        x = Jugador.body.getPosition().x;
        Cuerpo2.set(x, y, 32 / Pixels, 32 / Pixels);
    }
    }
}else
{
    x = tierra4.getFloat("X4");
    y = tierra4.getFloat("Y4");
    Cuerpo2.set(x, y, 32 / Pixels, 32 / Pixels);
    if(!MenuBuild.BuildTierra) {

        Cuerpo.set(x, y, 32 / Pixels, 32 / Pixels);
    }else
    {
        Cuerpo.set(3,0,0,0);
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
    for (Rectangle e :  Tierra1.rects) {
        if (Jugador.jugador.overlaps(e)) {
            if (noToca) {
                y = (e.y + (5 / Pixels)) - 32 / Pixels;
                x = Jugador.body.getPosition().x;
                Cuerpo2.set(x, y, 32 / Pixels, 32 / Pixels);
            }
        }
    }
    for (Rectangle e :  Tierra1.rects) {
        if (Jugador.jugador.overlaps(e)) {
            if (noToca) {
                tierra4.putFloat("X4", Jugador.body.getPosition().x);
                if(AddResources.TouchConfirm) {
                    tierra4.flush();
                }
                tierra4.putFloat("Y4", (e.y + (5 / Pixels)) - 32 / Pixels);
                if(AddResources.TouchConfirm) {
                    tierra4.flush();
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
        if(MyGdxGame.TierrasColocadas.getInteger("Posiciones") >= 3) {
            if (Cuerpo2.overlaps(Tierra2.Cuerpo2) || Cuerpo2.overlaps(Tierra3.Cuerpo2) || Cuerpo2.overlaps(Tierra1.Cuerpo2) || Cuerpo2.overlaps(Tierra5.Cuerpo2) || Cuerpo2.overlaps(Agua1.Cuerpo2) || Cuerpo2.overlaps(Agua2.Cuerpo2) || Cuerpo2.overlaps(Agua3.Cuerpo2) || Cuerpo2.overlaps(Agua4.Cuerpo2)) {
                AddResources.isFreeSpace4 = false;
            } else {
                AddResources.isFreeSpace4 = true;
            }
        }else
        {

            AddResources.isFreeSpace4 = true;
        }
    }

    @Override
    public void dispose() {
        tierra.dispose();
        tierra2.dispose();
        rango.dispose();
        b.dispose();
    }
}
