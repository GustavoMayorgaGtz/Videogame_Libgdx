package com.mygdx.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;


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

          for (Rectangle e : rects) {
              //  batch.draw(b, e.x,e.y,e.width,e.height);
              if (Jugador.jugador.overlaps(e)) {
                  if (Gdx.input.isTouched()&& noToca) {
                      tierra1.putFloat("X", Jugador.body.getPosition().x);
                      tierra1.flush();
                      tierra1.putFloat("Y", (e.y + (5 / Pixels)) - 32 / Pixels);
                      tierra1.flush();
                  }
              }
          }



    }

    @Override
    public void act(float delta) {

        x = tierra1.getFloat("X");
        y = tierra1.getFloat("Y");
        Cuerpo.set(x,y,32/ Pixels,32/Pixels);
    }

    @Override
    public void dispose() {
        tierra.dispose();
        rango.dispose();
        b.dispose();
    }
}
