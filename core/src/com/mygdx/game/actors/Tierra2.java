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

import static com.mygdx.game.MyGdxGame.tierra2;

public class Tierra2 extends Actor implements Disposable {

    public static Rectangle Cuerpo;
    public static Rectangle Cuerpo2;
    Texture tierra,Tierra2;
    float x,y;
    Texture b;
    public static boolean noToca;
    Texture rango;
    Sprite rangoS;
    public static float timeDurationTouch;
    public static boolean cambiarPosicion;

    Rectangle CuerpoCortar;
    public static boolean isDamp;
    public static boolean reiniciar = false;
    public static float reiniciarTime;



    Texture brote;
    Texture trigoPrueba,trigoPrueba0;
    Texture MaizFase1,MaizFase2;
    Texture SojaFase1,SojaFase2;
    Texture ZanaFase1,ZanaFase2;
    Texture CanaFase1,CanaFase2;
    Texture AlgoFase1,AlgoFase2;
    public static int isOld;

    public static Rectangle range;
    public Tierra2()
    {
            rango = new Texture("cuadradoNegro.png");
            rangoS = new Sprite(rango);

        Cuerpo = new Rectangle(x,y,32/ Pixels,32/Pixels);
        Cuerpo2 = new Rectangle();
        tierra = new Texture("Tierral.png");
        Tierra2 = new Texture("tierra2.png");
        b = new Texture("White.png");
        range = new Rectangle();

        CuerpoCortar = new Rectangle();
        brote = new Texture("Brote.png");
        trigoPrueba = new Texture("TrigoFase2.png");
        trigoPrueba0 = new Texture("TrigFase1.png");
        MaizFase1 = new Texture("MaizFase1.png");
        MaizFase2 = new Texture("MaizFase2.png");
        SojaFase1 = new Texture("SojaFase1.png");
        SojaFase2 = new Texture("SojaFase2.png");
        ZanaFase1 = new Texture("ZanaFase1.png");
        ZanaFase2 = new Texture("ZanaFase2.png");
        CanaFase1 = new Texture("CanaFase1.png");
        CanaFase2 = new Texture("CanaFase2.png");
        AlgoFase1 = new Texture("AlgodonFase1.png");
        AlgoFase2 = new Texture("AlgodonFase2.png");

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {

        if(reiniciar)
        {

        }else
        {
            reiniciarTime += 1 * Gdx.graphics.getDeltaTime();
        }
        range.set(x-(32/Pixels),y,92/Pixels,32/Pixels);
        if(range.overlaps(Agua1.range)||range.overlaps(Agua2.range)||range.overlaps(Agua3.range)||range.overlaps(Agua4.range))
        {
            batch.draw(Tierra2, x, y, 32 / Pixels, 32 / Pixels);
            isDamp = true;
        }else {
            batch.draw(tierra, x, y, 32 / Pixels, 32 / Pixels);
            isDamp = false;
        }
        if(!MyGdxGame.tierra2Enable.getBoolean("tierra2"))
        {
            if(isOld == 2)
            {
                CuerpoCortar.set(x,y+(32/Pixels),32/Pixels,32/Pixels);
                if(reiniciar)
                {
                    isOld = 0;
                    MyGdxGame.tierra2Iterator.putInteger("iteratorTierra2",0);
                    MyGdxGame.tierra2Enable.putBoolean("tierra2",true);
                    MyGdxGame.tierra2Trigo.putBoolean("tierra21",false);
                    MyGdxGame.tierra2Maiz.putBoolean("tierra22",false);
                    MyGdxGame.tierra2Soja.putBoolean("tierra23",false);
                    MyGdxGame.tierra2Zanahoria.putBoolean("tierra24",false);
                    MyGdxGame.tierra2Cana.putBoolean("tierra25",false);
                    MyGdxGame.tierra2Algodon.putBoolean("tierra26",false);
                    MyGdxGame.tierra2Iterator.flush();
                    MyGdxGame.tierra2Enable.flush();
                    MyGdxGame.tierra2Trigo.flush();
                    MyGdxGame.tierra2Maiz.flush();
                    MyGdxGame.tierra2Soja.flush();
                    MyGdxGame.tierra2Zanahoria.flush();
                    MyGdxGame.tierra2Cana.flush();
                    MyGdxGame.tierra2Algodon.flush();
                    reiniciarTime = 0;
                    reiniciar = false;
                    isOld = 0;
                }

            }
            if(MyGdxGame.tierra2Iterator.getInteger("iteratorTierra2")==0) {
                TimeZone t = new TimeZone();
                t.calcularHora = true;
                t.CalcularTiempo(2);
                MyGdxGame.tierra2Day.putInteger("DayTierra2",t.dayS);
                MyGdxGame.tierra2Year.putInteger("YearTierra2",t.yearS);
                MyGdxGame.tierra2Hour.putInteger("HourTierra2",t.hourS);
                MyGdxGame.tierra2Minute.putInteger("MinuteTierra2",t.minuteS);
                MyGdxGame.tierra2Day.flush();
                MyGdxGame.tierra2Year.flush();
                MyGdxGame.tierra2Hour.flush();
                MyGdxGame.tierra2Minute.flush();
                MyGdxGame.tierra2Iterator.putInteger("iteratorTierra2",1);
                MyGdxGame.tierra2Iterator.flush();
                TimeZone t2 = new TimeZone();
                t2.calcularHora = true;
                t2.CalcularTiempo(1);
                MyGdxGame.tierra2Day2.putInteger("Day2Tierra2",t2.dayS);
                MyGdxGame.tierra2Year2.putInteger("Year2Tierra2",t2.yearS);
                MyGdxGame.tierra2Hour2.putInteger("Hour2Tierra2",t2.hourS);
                MyGdxGame.tierra2Minute2.putInteger("Minute2Tierra2",t2.minuteS);
                MyGdxGame.tierra2Day2.flush();
                MyGdxGame.tierra2Year2.flush();
                MyGdxGame.tierra2Hour2.flush();
                MyGdxGame.tierra2Minute2.flush();
            }

            TimeZone t = new TimeZone();
            if(isOld == 0) {
                if (t.year > MyGdxGame.tierra2Year2.getInteger("Year2Tierra2")) {
                    isOld = 1;
                } else if (t.day > MyGdxGame.tierra2Day2.getInteger("Day2Tierra2")) {
                    isOld = 1;
                } else if (t.hour > MyGdxGame.tierra2Hour2.getInteger("Hour2Tierra2")) {
                    isOld = 1;
                } else if (t.minute > MyGdxGame.tierra2Minute2.getInteger("Minute2Tierra2")) {
                    isOld = 1;
                }

            }

            if(t.year > MyGdxGame.tierra2Year.getInteger("YearTierra2"))
            {
                isOld = 2;
            }else if(t.day > MyGdxGame.tierra2Day.getInteger("DayTierra2"))
            {
                isOld = 2;
            }else if(t.hour > MyGdxGame.tierra2Hour.getInteger("HourTierra2"))
            {
                isOld = 2;
            }else if(t.minute > MyGdxGame.tierra2Minute.getInteger("MinuteTierra2"))
            {
                isOld = 2;
            }

        }

        if(MyGdxGame.tierra2Trigo.getBoolean("tierra21"))
        {

            if(isOld == 2)
            {
                batch.draw(trigoPrueba,x,y+(32/Pixels),32/Pixels,32/Pixels);
            }else if(isOld == 1) {
                batch.draw(trigoPrueba0,x,y+(32/Pixels),32/Pixels,32/Pixels);
            }else
            {
                batch.draw(brote, x, y + (32 / Pixels), 32 / Pixels, 32 / Pixels);
            }

            MyGdxGame.tierra2Enable.putBoolean("tierra2",false);
            MyGdxGame.tierra2Enable.flush();
        }

        if(MyGdxGame.tierra2Maiz.getBoolean("tierra22"))
        {
            if(isOld == 2)
            {
                batch.draw(MaizFase2,x,y+(32/Pixels),32/Pixels,32/Pixels);
            }else if(isOld == 1) {
                batch.draw(MaizFase1,x,y+(32/Pixels),32/Pixels,32/Pixels);
            }else
            {
                batch.draw(brote, x, y + (32 / Pixels), 32 / Pixels, 32 / Pixels);
            }

            MyGdxGame.tierra2Enable.putBoolean("tierra2",false);
            MyGdxGame.tierra2Enable.flush();
        }

        if(MyGdxGame.tierra2Soja.getBoolean("tierra23"))
        {
            if(isOld == 2)
            {
                batch.draw(SojaFase2,x,y+(32/Pixels),32/Pixels,32/Pixels);
            }else if(isOld == 1) {
                batch.draw(SojaFase1,x,y+(32/Pixels),32/Pixels,32/Pixels);
            }else
            {
                batch.draw(brote, x, y + (32 / Pixels), 32 / Pixels, 32 / Pixels);
            }
            MyGdxGame.tierra2Enable.putBoolean("tierra2",false);
            MyGdxGame.tierra2Enable.flush();
        }

        if(MyGdxGame.tierra2Zanahoria.getBoolean("tierra24"))
        {
            if(isOld == 2)
            {
                batch.draw(ZanaFase2,x,y+(32/Pixels),32/Pixels,32/Pixels);
            }else if(isOld == 1) {
                batch.draw(ZanaFase1,x,y+(32/Pixels),32/Pixels,32/Pixels);
            }else
            {
                batch.draw(brote, x, y + (32 / Pixels), 32 / Pixels, 32 / Pixels);
            }
            MyGdxGame.tierra2Enable.putBoolean("tierra2",false);
            MyGdxGame.tierra2Enable.flush();
        }

        if(MyGdxGame.tierra2Cana.getBoolean("tierra25"))
        {
            if(isOld == 2)
            {
                batch.draw(CanaFase2,x,y+(32/Pixels),32/Pixels,32/Pixels);
            }else if(isOld == 1) {
                batch.draw(CanaFase1,x,y+(32/Pixels),32/Pixels,32/Pixels);
            }else
            {
                batch.draw(brote, x, y + (32 / Pixels), 32 / Pixels, 32 / Pixels);
            }
            MyGdxGame.tierra2Enable.putBoolean("tierra2",false);
            MyGdxGame.tierra2Enable.flush();
        }

        if(MyGdxGame.tierra2Algodon.getBoolean("tierra26"))        {
            if(isOld == 2)
            {
                batch.draw(AlgoFase2,x,y+(32/Pixels),32/Pixels,32/Pixels);
            }else if(isOld == 1) {
                batch.draw(AlgoFase1,x,y+(32/Pixels),32/Pixels,32/Pixels);
            }else
            {
                batch.draw(brote, x, y + (32 / Pixels), 32 / Pixels, 32 / Pixels);
            }
            MyGdxGame.tierra2Enable.putBoolean("tierra2",false);
            MyGdxGame.tierra2Enable.flush();
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
        if(MyGdxGame.TierrasColocadas.getInteger("Posiciones") == 1 && MenuBuild.BuildTierra) {
            for (Rectangle e :  Tierra1.rects) {
                if (Jugador.jugador.overlaps(e)) {
                    if (noToca) {
                        MyGdxGame.TierrasColocadas.putInteger("Posiciones",2);
                        tierra2.putFloat("X2", Jugador.body.getPosition().x);
                        if(AddResources.TouchConfirm) {
                            tierra2.flush();
                        }
                        tierra2.putFloat("Y2", (e.y + (5 / Pixels)) - 32 / Pixels);
                        if(AddResources.TouchConfirm) {
                            tierra2.flush();
                            MyGdxGame.TierrasColocadas.flush();
                            MenuBuild.BuildTierra = false;
                            AddResources.TouchConfirm = false;
                            AddResources.TouchCancel = false;
                        }
                    }
                }
            }
        }

if(MenuBuild.BuildTierra&&MyGdxGame.TierrasColocadas.getInteger("Posiciones") == 1 ) {
    for (Rectangle e :  Tierra1.rects) {
    if (Jugador.jugador.overlaps(e)) {
        y = (e.y + (5 / Pixels)) - 32 / Pixels;
        x = Jugador.body.getPosition().x;
        Cuerpo2.set(x, y, 32 / Pixels, 32 / Pixels);
    }
    }
}else
{
    if(!cambiarPosicion) {
        x = tierra2.getFloat("X2");
        y = tierra2.getFloat("Y2");
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
if( cambiarPosicion&&  MyGdxGame.tierra2Enable.getBoolean("tierra2"))

{
    MenuBuild.BuildMover = true;
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
                tierra2.putFloat("X2", Jugador.body.getPosition().x);
                if(AddResources.TouchConfirm) {
                    tierra2.flush();
                }
                tierra2.putFloat("Y2", (e.y + (5 / Pixels)) - 32 / Pixels);
                if(AddResources.TouchConfirm) {
                    tierra2.flush();
                    MenuBuild.BuildMover = false;
                    MenuBuild.isMenu = false;

                    cambiarPosicion = false;
                    timeDurationTouch = 0;
                }
            }
        }
    }
}else
{
    cambiarPosicion = false;
}

    }

    public void colisiones()
    {

            if (Cuerpo2.overlaps(Tierra1.Cuerpo2) || Cuerpo2.overlaps(Tierra3.Cuerpo2) || Cuerpo2.overlaps(Tierra4.Cuerpo2) || Cuerpo2.overlaps(Tierra5.Cuerpo2) || Cuerpo2.overlaps(Agua1.Cuerpo2) || Cuerpo2.overlaps(Agua2.Cuerpo2) || Cuerpo2.overlaps(Agua3.Cuerpo2) || Cuerpo2.overlaps(Agua4.Cuerpo2)) {
                AddResources.isFreeSpace2 = false;
            } else {
                AddResources.isFreeSpace2 = true;
            }



    }

    @Override
    public void dispose() {
        tierra.dispose();
        Tierra2.dispose();
        rango.dispose();
        b.dispose();
        brote.dispose();
        trigoPrueba.dispose();
        trigoPrueba0.dispose();
        MaizFase1.dispose();
        MaizFase2.dispose();
        SojaFase1.dispose();
        SojaFase2.dispose();
        ZanaFase1.dispose();
        ZanaFase2.dispose();
        CanaFase1.dispose();
        CanaFase2.dispose();
        AlgoFase2.dispose();
        AlgoFase1.dispose();
    }
}
