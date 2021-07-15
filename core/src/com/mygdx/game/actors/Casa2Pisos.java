package com.mygdx.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.game.Casa;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.tiled.AddResources;


import static com.mygdx.game.MyGdxGame.CasaDosPisos1;
import static com.mygdx.game.MyGdxGame.Pixels;
import static com.mygdx.game.MyGdxGame.tierra1;

public class Casa2Pisos extends Actor implements Disposable {
    public static Texture logo;
    public static Rectangle Cuerpo,Cuerpo2;
    public static float x,y;
    boolean noToca;
    boolean cambiarPosicion = false;
    public static boolean isCasa2Pisos1Activate = false;

    public Casa2Pisos()
    {
        logo = new Texture("CasaDosPisos.png");
        Cuerpo = new Rectangle();
        Cuerpo2 = new Rectangle();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {

        batch.draw(logo,x,y,110/Pixels,190/Pixels);
        for(com.badlogic.gdx.math.Rectangle no: Tierra1.noBuild) {
            if (no.overlaps(Jugador.jugador)) {
                noToca = false;
            }
        }
        for(com.badlogic.gdx.math.Rectangle yes: Tierra1.Build) {
            if (yes.overlaps(Jugador.jugador)) {
                noToca = true;
            }
        }
    }

    @Override
    public void act(float delta) {
        if(MyGdxGame.CasasDosPisosColocadas.getInteger("Posiciones3") == 0 && MenuBuild.CasasDosPisosBuild ) {
            for (Rectangle e : Tierra1.rects) {
                if (Jugador.jugador.overlaps(e)) {
                    if (noToca) {
                        MyGdxGame.CasasDosPisosColocadas.putInteger("Posiciones3",1);
                        CasaDosPisos1.putFloat("X10", Jugador.body.getPosition().x);
                        Gdx.app.log("lookerewr","eqrew");
                        if(AddResources.TouchConfirm) {
                            CasaDosPisos1.flush();
                        }
                        CasaDosPisos1.putFloat("Y10", (e.y + (5 / Pixels))-5/Pixels);
                        if(AddResources.TouchConfirm) {
                            CasaDosPisos1.flush();
                            MyGdxGame.CasasDosPisosColocadas.flush();
                            isCasa2Pisos1Activate = true;
                            MenuBuild.CasasDosPisosBuild = false;
                            AddResources.TouchConfirm = false;
                            AddResources.TouchCancel = false;
                        }
                    }
                }
            }
        }

        if(MenuBuild.CasasDosPisosBuild&&MyGdxGame.CasasDosPisosColocadas.getInteger("Posiciones3") == 0 ) {
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
                x = CasaDosPisos1.getFloat("X10");
                y = CasaDosPisos1.getFloat("Y10");
                Cuerpo2.set(x, y, 110/Pixels,170/Pixels);
            }
            if(!MenuBuild.CasasDosPisosBuild) {

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
