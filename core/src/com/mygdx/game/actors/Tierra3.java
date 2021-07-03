package com.mygdx.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;

import java.util.ArrayList;

import static com.mygdx.game.MyGdxGame.Pixels;
import static com.mygdx.game.MyGdxGame.tierra2;
import static com.mygdx.game.MyGdxGame.tierra3;

public class Tierra3 extends Actor implements Disposable {

    Rectangle Cuerpo;
    Texture tierra;
    float x,y;
    public static ArrayList<Rectangle> rects;
    Texture b;
    public Tierra3()
    {
        Cuerpo = new Rectangle(x,y,32/ Pixels,32/Pixels);
        tierra = new Texture("Tierral.png");
        b = new Texture("White.png");

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
      batch.draw(tierra,x,y,32/Pixels,32/Pixels);

      for(Rectangle e:  Tierra1.rects)
      {
        //  batch.draw(b, e.x,e.y,e.width,e.height);
          if(Jugador.jugador.overlaps(e)) {
              if (Gdx.input.isTouched()) {
                  tierra3.putFloat("X", Jugador.body.getPosition().x);
                  tierra3.flush();
                  tierra3.putFloat("Y", (e.y +(5/Pixels)) - 32 / Pixels);
                  tierra3.flush();
              }
          }
      }


    }

    @Override
    public void act(float delta) {

        x = tierra3.getFloat("X");
        y = tierra3.getFloat("Y");
        Cuerpo.set(x,y,32/ Pixels,32/Pixels);
    }

    @Override
    public void dispose() {
        tierra.dispose();
        b.dispose();
    }
}
