package com.mygdx.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.tiled.AddResources;

import java.util.ArrayList;

import static com.mygdx.game.MyGdxGame.Pixels;
import static com.mygdx.game.MyGdxGame.agua1;
import static com.mygdx.game.actors.Tierra1.Build;
import static com.mygdx.game.actors.Tierra1.noBuild;

public class Agua1 extends Actor implements Disposable {
    public static boolean var1= true;
    Rectangle Cuerpo;
    Texture agua;
    Animation<TextureRegion> AguaAnimation;
    int c = 1, r = 4;
    float x,y;
  //  public static ArrayList<Rectangle> rects;
    Texture b;
    float time;


    public static Rectangle Cuerpo2;
    public static Rectangle range;



    public static boolean noToca;
    Texture rango;
    Sprite rangoS;


    public static float timeDurationTouch;
    public static boolean cambiarPosicion;
    public Agua1()
    {
        Cuerpo = new Rectangle(x,y,32/ Pixels,32/Pixels);
      agua = new Texture("PozoDeAgua.png");
        TextureRegion[][] Frames = TextureRegion.split(agua,agua.getWidth()/c,agua.getHeight()/r);
        TextureRegion[] Tmp = new TextureRegion[c*r];
        int index = 0;
        for(int i = 0; i < r; i++)
        {
            for(int  j = 0; j < c ; j++)
            {
                Tmp[index++]= Frames[i][j];
            }
        }
        AguaAnimation = new Animation<TextureRegion>(0.2f,Tmp);
        rango = new Texture("cuadradoNegro.png");
        rangoS = new Sprite(rango);
        Cuerpo2 = new Rectangle();
        b = new Texture("White.png");
        range = new Rectangle();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {

      time += Gdx.graphics.getDeltaTime();
      TextureRegion awa = AguaAnimation.getKeyFrame(time,true);
        batch.draw(awa,x,y,32/Pixels,32/Pixels);

        if(MenuBuild.BuildAgua) {
            rangoS.setBounds(x-(32/Pixels),y,92/Pixels,32/Pixels);
            rangoS.setAlpha(0.5f);
            rangoS.draw(batch);
        }
        range.set(x-(32/Pixels),y,92/Pixels,32/Pixels);


        for(Rectangle no: noBuild) {
            if (no.overlaps(Jugador.jugador)) {
                noToca = false;
            }
            if(no.overlaps(Cuerpo2))
            {
                var1 = false;
            }
        }
        for(Rectangle yes: Build) {
            if (yes.overlaps(Jugador.jugador)) {
                noToca = true;
            }
            if(yes.overlaps(Cuerpo2))
            {
                var1 = true;
            }
        }


        for(Rectangle no: noBuild) {
            for(Rectangle yes: Build) {
                if(no.overlaps(Cuerpo2)&& yes.overlaps(Cuerpo2))
                {
                    var1 = false;
                }
            }
        }

    }

    @Override
    public void act(float delta) {
        colisiones();
      //  Gdx.app.log("Esta activo",""+MenuBuild.BuildAgua);
        if(MyGdxGame.AguasColocadas.getInteger("Posiciones2") == 0 && MenuBuild.BuildAgua) {
            for (Rectangle e : Tierra1.rects) {
                if (Jugador.jugador.overlaps(e)) {
                    if (noToca) {
                        MyGdxGame.AguasColocadas.putInteger("Posiciones2",1);
                        agua1.putFloat("X6", Jugador.body.getPosition().x);
                        if(AddResources.TouchConfirm) {
                            agua1.flush();
                        }
                        agua1.putFloat("Y6", (e.y + (5 / Pixels)) - 32 / Pixels);
                        if(AddResources.TouchConfirm) {
                            agua1.flush();
                            MyGdxGame.AguasColocadas.flush();
                            MenuBuild.BuildAgua = false;
                            AddResources.TouchConfirm = false;
                            AddResources.TouchCancel = false;
                        }
                    }
                }
            }
        }

        if(MenuBuild.BuildAgua&&MyGdxGame.AguasColocadas.getInteger("Posiciones2") == 0 ) {
            for (Rectangle e : Tierra1.rects) {
                if (Jugador.jugador.overlaps(e)) {
                    y = (e.y + (5 / Pixels)) - 32 / Pixels;
                    x = Jugador.body.getPosition().x;
                    Cuerpo2.set(x, y, 32 / Pixels, 32 / Pixels);
                }
            }
        }else
        {
            if(!cambiarPosicion) {

                x = agua1.getFloat("X6");
                y = agua1.getFloat("Y6");
                Cuerpo2.set(x, y, 32 / Pixels, 32 / Pixels);
            }
            if(!MenuBuild.BuildAgua) {

                Cuerpo.set(x, y, 32 / Pixels, 32 / Pixels);
            }else
            {

                Cuerpo.set(5,0,0,0);
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
            MenuBuild.BuildMover = true;
            for (Rectangle e : Tierra1.rects) {
                if (noToca) {
                    if (Jugador.jugador.overlaps(e)) {
                        y = (e.y + (5 / Pixels)) - 32 / Pixels;
                        x = Jugador.body.getPosition().x;
                        Cuerpo2.set(x, y, 32 / Pixels, 32 / Pixels);

                        agua1.putFloat("X6", Jugador.body.getPosition().x);
                        if(AddResources.TouchConfirm) {
                            agua1.flush();
                        }
                        agua1.putFloat("Y6", (e.y + (5 / Pixels)) - 32 / Pixels);
                        if(AddResources.TouchConfirm) {
                            agua1.flush();
                            MenuBuild.BuildMover= false;
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

            if (Cuerpo2.overlaps(Tierra1.Cuerpo2) || Cuerpo2.overlaps(Tierra2.Cuerpo2) || Cuerpo2.overlaps(Tierra3.Cuerpo2) || Cuerpo2.overlaps(Tierra4.Cuerpo2) || Cuerpo2.overlaps(Tierra5.Cuerpo2) || Cuerpo2.overlaps(Agua2.Cuerpo2) || Cuerpo2.overlaps(Agua3.Cuerpo2) || Cuerpo2.overlaps(Agua4.Cuerpo2)) {
                AddResources.isFreeSpace6 = false;

            } else {
                AddResources.isFreeSpace6 = true;
            }

    }

    @Override
    public void dispose() {
        agua.dispose();
        b.dispose();
        rango.dispose();

    }
}
