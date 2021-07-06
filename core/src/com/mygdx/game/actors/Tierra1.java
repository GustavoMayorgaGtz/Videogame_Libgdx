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

    Rectangle Cuerpo;
    Texture tierra;
    float x,y;
    public static ArrayList<Rectangle> rects;
    public static ArrayList<Rectangle> noBuild ;
    public static ArrayList<Rectangle> Build;
    Texture b;
    public static boolean noToca;
    Texture rango;
    Sprite rangoS;
    public Tierra1()
    {
        rango = new Texture("cuadradoNegro.png");
        rangoS = new Sprite(rango);
        Cuerpo = new Rectangle(x,y,32/ Pixels,32/Pixels);
        tierra = new Texture("Tierral.png");
        b = new Texture("White.png");

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        rangoS.setBounds(x-(32/Pixels),y,92/Pixels,32/Pixels);
        rangoS.setAlpha(0.5f);
        rangoS.draw(batch);
   //   batch.draw(tierra,x,y,32/Pixels,32/Pixels);

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
if(MyGdxGame.TierrasColocadas.getInteger("Posiciones") == 0 && MenuBuild.BuildTierra) {
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
                    AddResources.TouchConfirm = false;
                    AddResources.TouchCancel = false;
                    MyGdxGame.TierrasColocadas.getInteger("Posiciones",1);
                    MyGdxGame.TierrasColocadas.flush();
                }
            }
        }
    }
}
    }

    @Override
    public void act(float delta) {
if(MenuBuild.BuildTierra&&MyGdxGame.TierrasColocadas.getInteger("Posiciones") == 0 ) {
    for (Rectangle e : rects) {
    if (Jugador.jugador.overlaps(e)) {
        y = (e.y + (5 / Pixels)) - 32 / Pixels;
        x = Jugador.body.getPosition().x;
    }
    }
}else
{
    x = tierra1.getFloat("X");
    y = tierra1.getFloat("Y");
    Cuerpo.set(x,y,32/ Pixels,32/Pixels);
}

    }

    @Override
    public void dispose() {
        tierra.dispose();
        rango.dispose();
        b.dispose();
    }
}
