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
    public static boolean var25= true;
    public static Rectangle Cuerpo;
    public static Rectangle Cuerpo2;
    public static Rectangle range;
    Rectangle CuerpoCortar;
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

    public Tierra1()
    {
            rango = new Texture("cuadradoNegro.png");
            rangoS = new Sprite(rango);

        Cuerpo = new Rectangle(x,y,32/ Pixels,32/Pixels);
        Cuerpo2 = new Rectangle();
        CuerpoCortar = new Rectangle();
        tierra = new Texture("Tierral.png");
        tierra2 = new Texture("tierra2.png");
        b = new Texture("White.png");
        range = new Rectangle();
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
            batch.draw(tierra2, x, y, 32 / Pixels, 32 / Pixels);
            isDamp = true;
        }else {
            batch.draw(tierra, x, y, 32 / Pixels, 32 / Pixels);
            isDamp = false;
        }
        if(!MyGdxGame.tierra1Enable.getBoolean("tierra1"))
        {
            if(isOld == 2)
            {
                CuerpoCortar.set(x,y+(32/Pixels),32/Pixels,32/Pixels);
                if(reiniciar)
                {
                    isOld = 0;
                    MyGdxGame.tierra1Iterator.putInteger("iteratorTierra1",0);
                    MyGdxGame.tierra1Enable.putBoolean("tierra1",true);
                    MyGdxGame.tierra1Trigo.putBoolean("tierra11",false);
                    MyGdxGame.tierra1Maiz.putBoolean("tierra12",false);
                    MyGdxGame.tierra1Soja.putBoolean("tierra13",false);
                    MyGdxGame.tierra1Zanahoria.putBoolean("tierra14",false);
                    MyGdxGame.tierra1Cana.putBoolean("tierra15",false);
                    MyGdxGame.tierra1Algodon.putBoolean("tierra16",false);
                    MyGdxGame.tierra1Iterator.flush();
                    MyGdxGame.tierra1Enable.flush();
                    MyGdxGame.tierra1Trigo.flush();
                    MyGdxGame.tierra1Maiz.flush();
                    MyGdxGame.tierra1Soja.flush();
                    MyGdxGame.tierra1Zanahoria.flush();
                    MyGdxGame.tierra1Cana.flush();
                    MyGdxGame.tierra1Algodon.flush();
                    reiniciarTime = 0;
reiniciar = false;
isOld = 0;
                }

            }
            if(MyGdxGame.tierra1Iterator.getInteger("iteratorTierra1")==0) {
                TimeZone t = new TimeZone();
                t.calcularHora = true;
                t.CalcularTiempo(2);
                MyGdxGame.tierra1Day.putInteger("DayTierra1",t.dayS);
                MyGdxGame.tierra1Year.putInteger("YearTierra1",t.yearS);
                MyGdxGame.tierra1Hour.putInteger("HourTierra1",t.hourS);
                MyGdxGame.tierra1Minute.putInteger("MinuteTierra1",t.minuteS);
                MyGdxGame.tierra1Day.flush();
                MyGdxGame.tierra1Year.flush();
                MyGdxGame.tierra1Hour.flush();
                MyGdxGame.tierra1Minute.flush();
                MyGdxGame.tierra1Iterator.putInteger("iteratorTierra1",1);
                MyGdxGame.tierra1Iterator.flush();
TimeZone t2 = new TimeZone();
                t2.calcularHora = true;
                t2.CalcularTiempo(1);
                MyGdxGame.tierra1Day2.putInteger("Day2Tierra1",t2.dayS);
                MyGdxGame.tierra1Year2.putInteger("Year2Tierra1",t2.yearS);
                MyGdxGame.tierra1Hour2.putInteger("Hour2Tierra1",t2.hourS);
                MyGdxGame.tierra1Minute2.putInteger("Minute2Tierra1",t2.minuteS);
                MyGdxGame.tierra1Day2.flush();
                MyGdxGame.tierra1Year2.flush();
                MyGdxGame.tierra1Hour2.flush();
                MyGdxGame.tierra1Minute2.flush();
            }

            TimeZone t = new TimeZone();
if(isOld == 0) {
    if (t.year > MyGdxGame.tierra1Year2.getInteger("Year2Tierra1")) {
        isOld = 1;
    } else if (t.day > MyGdxGame.tierra1Day2.getInteger("Day2Tierra1")&&t.year >= MyGdxGame.tierra1Year2.getInteger("Year2Tierra1")) {
        isOld = 1;
    } else if (t.hour > MyGdxGame.tierra1Hour2.getInteger("Hour2Tierra1")&&t.day >= MyGdxGame.tierra1Day2.getInteger("Day2Tierra1")&&t.year >= MyGdxGame.tierra1Year2.getInteger("Year2Tierra1")) {
        isOld = 1;
    } else if (t.minute > MyGdxGame.tierra1Minute2.getInteger("Minute2Tierra1")&&t.hour >= MyGdxGame.tierra1Hour2.getInteger("Hour2Tierra1")&&t.day >= MyGdxGame.tierra1Day2.getInteger("Day2Tierra1")&&t.year >= MyGdxGame.tierra1Year2.getInteger("Year2Tierra1")) {
        isOld = 1;
    }

}

            if(t.year > MyGdxGame.tierra1Year.getInteger("YearTierra1"))
            {
                isOld = 2;
            }else if(t.day > MyGdxGame.tierra1Day.getInteger("DayTierra1")&&t.year >= MyGdxGame.tierra1Year.getInteger("YearTierra1"))
            {
                isOld = 2;
            }else if(t.hour > MyGdxGame.tierra1Hour.getInteger("HourTierra1")&&t.day >= MyGdxGame.tierra1Day.getInteger("DayTierra1")&&t.year >= MyGdxGame.tierra1Year.getInteger("YearTierra1"))
            {
                isOld = 2;
            }else if(t.minute > MyGdxGame.tierra1Minute.getInteger("MinuteTierra1")&&t.hour >= MyGdxGame.tierra1Hour.getInteger("HourTierra1")&&t.day >= MyGdxGame.tierra1Day.getInteger("DayTierra1")&&t.year >= MyGdxGame.tierra1Year.getInteger("YearTierra1"))
            {
                isOld = 2;
            }

        }

        if(MyGdxGame.tierra1Trigo.getBoolean("tierra11"))
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

           MyGdxGame.tierra1Enable.putBoolean("tierra1",false);
            MyGdxGame.tierra1Enable.flush();
        }

        if(MyGdxGame.tierra1Maiz.getBoolean("tierra12"))
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

            MyGdxGame.tierra1Enable.putBoolean("tierra1",false);
            MyGdxGame.tierra1Enable.flush();
        }

        if(MyGdxGame.tierra1Soja.getBoolean("tierra13"))
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
            MyGdxGame.tierra1Enable.putBoolean("tierra1",false);
            MyGdxGame.tierra1Enable.flush();
        }

        if(MyGdxGame.tierra1Zanahoria.getBoolean("tierra14"))
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
            MyGdxGame.tierra1Enable.putBoolean("tierra1",false);
            MyGdxGame.tierra1Enable.flush();
        }

        if(MyGdxGame.tierra1Cana.getBoolean("tierra15"))
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
            MyGdxGame.tierra1Enable.putBoolean("tierra1",false);
            MyGdxGame.tierra1Enable.flush();
        }

        if(MyGdxGame.tierra1Algodon.getBoolean("tierra16"))
        {
            if(isOld == 2)
            {
                batch.draw(AlgoFase2,x,y+(32/Pixels),32/Pixels,32/Pixels);
            }else if(isOld == 1) {
                batch.draw(AlgoFase1,x,y+(32/Pixels),32/Pixels,32/Pixels);
            }else
            {
                batch.draw(brote, x, y + (32 / Pixels), 32 / Pixels, 32 / Pixels);
            }
            MyGdxGame.tierra1Enable.putBoolean("tierra1",false);
            MyGdxGame.tierra1Enable.flush();
        }

        for(Rectangle no: noBuild) {
            if (no.overlaps(Jugador.jugador)) {
                noToca = false;
            }
            if(no.overlaps(Cuerpo2))
            {
                var25 = false;
            }
        }
        for(Rectangle yes: Build) {
            if (yes.overlaps(Jugador.jugador)) {
                noToca = true;
            }
            if(yes.overlaps(Cuerpo2))
            {
                var25 = true;
            }
        }

        for(Rectangle no: noBuild) {
            for(Rectangle yes: Build) {
                if(no.overlaps(Cuerpo2)&& yes.overlaps(Cuerpo2))
                {
                    var25 = false;
                }
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
}else {
    cambiarPosicion = false;
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
