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

import java.util.ArrayList;

import static com.mygdx.game.MyGdxGame.Pixels;
import static com.mygdx.game.MyGdxGame.tierra1;
import static com.mygdx.game.MyGdxGame.tierra2;

public class Tierra2 extends Actor implements Disposable {

    Rectangle Cuerpo;
    Texture tierra;
    float x,y;
    Texture b;
    public static boolean noToca;

    Texture rango;
    Sprite rangoS;
    public Tierra2()
    {
        rango = new Texture("cuadradoNegro.png");
        rangoS = new Sprite(rango);
        Cuerpo = new Rectangle(x,y,32/ Pixels,32/Pixels);
        tierra = new Texture("Tierral.png");
        b = new Texture("White.png");

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        rangoS.setBounds(x - (32 / Pixels), y, 92 / Pixels, 32 / Pixels);
        rangoS.setAlpha(0.5f);
        rangoS.draw(batch);
        batch.draw(tierra, x, y, 32 / Pixels, 32 / Pixels);

        if (MyGdxGame.TierrasColocadas.getInteger("Posiciones") == 1 && MenuBuild.BuildTierra) {
            for (Rectangle e : Tierra1.rects) {
                //  batch.draw(b, e.x,e.y,e.width,e.height);
                if (Jugador.jugador.overlaps(e)) {
                    if (noToca) {


                        tierra2.putFloat("X", Jugador.body.getPosition().x);
                        if (AddResources.TouchConfirm) {
                            tierra2.flush();
                            //  MenuBuild.BuildTierra = false;
                        }

                        tierra2.putFloat("Y", (e.y + (5 / Pixels)) - 32 / Pixels);
                        if (AddResources.TouchConfirm) {
                            tierra2.flush();
                            MyGdxGame.TierrasColocadas.getInteger("Posiciones", 2);
                            MyGdxGame.TierrasColocadas.flush();
                            MenuBuild.BuildTierra = false;
                            AddResources.TouchConfirm = false;
                            AddResources.TouchCancel = false;
                        }
                    }
                }
            }
        }
    }

    @Override
    public void act(float delta) {
if(MenuBuild.BuildTierra&&MyGdxGame.TierrasColocadas.getInteger("Posiciones") == 1 ) {
    for (Rectangle e :  Tierra1.rects) {
    if (Jugador.jugador.overlaps(e)) {
        Gdx.app.log("Hi","yes i am here");
        y = (e.y + (5 / Pixels)) - 32 / Pixels;
        x = Jugador.body.getPosition().x;
    }
    }
}else
{
    x = tierra2.getFloat("X");
    y = tierra2.getFloat("Y");
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
