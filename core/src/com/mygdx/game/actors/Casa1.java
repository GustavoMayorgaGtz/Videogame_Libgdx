package com.mygdx.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.tiled.AddResources;

import static com.mygdx.game.MyGdxGame.CasaDosPisos1;
import static com.mygdx.game.MyGdxGame.Pixels;
import static com.mygdx.game.MyGdxGame.Casa1;

public class Casa1 extends Actor implements Disposable {
    public static Texture logo;
    public static Rectangle Cuerpo,Cuerpo2;
    public static float x,y;
    boolean noToca;
    boolean cambiarPosicion = false;


    public Casa1()
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
        if(MyGdxGame.CasasColocadas.getInteger("Posiciones4") == 0 && MenuBuild.CasasBuild ) {
            for (Rectangle e : Tierra1.rects) {
                if (Jugador.jugador.overlaps(e)) {
                    if (noToca) {
                        MyGdxGame.CasasColocadas.putInteger("Posiciones4",1);
                        Casa1.putFloat("X12", Jugador.body.getPosition().x);
                        if(AddResources.TouchConfirm) {
                            Casa1.flush();
                        }
                        Casa1.putFloat("Y12", (e.y + (5 / Pixels))-5/Pixels);
                        if(AddResources.TouchConfirm) {
                            Casa1.flush();
                            MyGdxGame.CasasColocadas.flush();

                            MenuBuild.CasasBuild = false;
                            AddResources.TouchConfirm = false;
                            AddResources.TouchCancel = false;
                        }
                    }
                }
            }
        }

        if(MenuBuild.CasasBuild&&MyGdxGame.CasasColocadas.getInteger("Posiciones4") == 0 ) {
            for (Rectangle e : Tierra1.rects) {

                    if (Jugador.jugador.overlaps(e)) {
                        y =  (e.y + (5 / Pixels))-5/Pixels;
                        x = Jugador.body.getPosition().x;
                        Cuerpo2.set(x, y, 110/Pixels,170/Pixels);

                }
            }
        }else
        {
            if(!cambiarPosicion) {
                x = Casa1.getFloat("X12");
                y = Casa1.getFloat("Y12");
                Cuerpo2.set(x, y, 110/Pixels,170/Pixels);
            }
            if(!MenuBuild.CasasBuild) {

                Cuerpo.set(x, y, 110/Pixels,170/Pixels);
            }else
            {
                Cuerpo.set(0,0,0,0);
            }
            if(MenuBuild.isMenu)
            {
                Cuerpo.set(0,0,0,0);
            }
        }

    }

    @Override
    public void dispose() {
      logo.dispose();
    }
}
