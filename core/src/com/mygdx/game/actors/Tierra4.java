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
import static com.mygdx.game.actors.Tierra1.Build;
import static com.mygdx.game.actors.Tierra1.noBuild;

public class Tierra4 extends Actor implements Disposable {
    public static boolean var28= true;
    public static Rectangle Cuerpo;
    public static Rectangle Cuerpo2;
    Texture tierra,tierra2;
    float x,y;
    Texture b;
    public static boolean noToca;
    Texture rango;
    Sprite rangoS;
    public static float timeDurationTouch;
    public static boolean cambiarPosicion;

    public static Rectangle range;

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

    public Tierra4()
    {
            rango = new Texture("cuadradoNegro.png");
            rangoS = new Sprite(rango);

        Cuerpo = new Rectangle(x,y,32/ Pixels,32/Pixels);
        Cuerpo2 = new Rectangle();
        tierra = new Texture("Tierral.png");
        tierra2 = new Texture("tierra2.png");
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
            batch.draw(tierra2, x, y, 32 / Pixels, 32 / Pixels);
            isDamp = true;
        }else {
            batch.draw(tierra, x, y, 32 / Pixels, 32 / Pixels);
            isDamp = false;
        }
        if(!MyGdxGame.tierra4Enable.getBoolean("tierra4"))
        {
            if(isOld == 2)
            {
                CuerpoCortar.set(x,y+(32/Pixels),32/Pixels,32/Pixels);
                if(reiniciar)
                {
                    isOld = 0;
                    MyGdxGame.tierra4Iterator.putInteger("iteratorTierra4",0);
                    MyGdxGame.tierra4Enable.putBoolean("tierra4",true);
                    MyGdxGame.tierra4Trigo.putBoolean("tierra41",false);
                    MyGdxGame.tierra4Maiz.putBoolean("tierra42",false);
                    MyGdxGame.tierra4Soja.putBoolean("tierra43",false);
                    MyGdxGame.tierra4Zanahoria.putBoolean("tierra44",false);
                    MyGdxGame.tierra4Cana.putBoolean("tierra45",false);
                    MyGdxGame.tierra4Algodon.putBoolean("tierra46",false);
                    MyGdxGame.tierra4Iterator.flush();
                    MyGdxGame.tierra4Enable.flush();
                    MyGdxGame.tierra4Trigo.flush();
                    MyGdxGame.tierra4Maiz.flush();
                    MyGdxGame.tierra4Soja.flush();
                    MyGdxGame.tierra4Zanahoria.flush();
                    MyGdxGame.tierra4Cana.flush();
                    MyGdxGame.tierra4Algodon.flush();
                    reiniciarTime = 0;
                    reiniciar = false;
                    isOld = 0;
                }

            }
            if(MyGdxGame.tierra4Iterator.getInteger("iteratorTierra4")==0) {
                TimeZone t = new TimeZone();
                t.calcularHora = true;
                t.CalcularTiempo(2);
                MyGdxGame.tierra4Day.putInteger("DayTierra4",t.dayS);
                MyGdxGame.tierra4Year.putInteger("YearTierra4",t.yearS);
                MyGdxGame.tierra4Hour.putInteger("HourTierra4",t.hourS);
                MyGdxGame.tierra4Minute.putInteger("MinuteTierra4",t.minuteS);
                MyGdxGame.tierra4Day.flush();
                MyGdxGame.tierra4Year.flush();
                MyGdxGame.tierra4Hour.flush();
                MyGdxGame.tierra4Minute.flush();
                MyGdxGame.tierra4Iterator.putInteger("iteratorTierra4",1);
                MyGdxGame.tierra4Iterator.flush();
                TimeZone t2 = new TimeZone();
                t2.calcularHora = true;
                t2.CalcularTiempo(1);
                MyGdxGame.tierra4Day2.putInteger("Day2Tierra4",t2.dayS);
                MyGdxGame.tierra4Year2.putInteger("Year2Tierra4",t2.yearS);
                MyGdxGame.tierra4Hour2.putInteger("Hour2Tierra4",t2.hourS);
                MyGdxGame.tierra4Minute2.putInteger("Minute2Tierra4",t2.minuteS);
                MyGdxGame.tierra4Day2.flush();
                MyGdxGame.tierra4Year2.flush();
                MyGdxGame.tierra4Hour2.flush();
                MyGdxGame.tierra4Minute2.flush();
            }

            TimeZone t = new TimeZone();
            if(isOld == 0) {
                if (t.year > MyGdxGame.tierra4Year2.getInteger("Year2Tierra4")) {
                    isOld = 1;
                } else if (t.day > MyGdxGame.tierra4Day2.getInteger("Day2Tierra4")) {
                    isOld = 1;
                } else if (t.hour > MyGdxGame.tierra4Hour2.getInteger("Hour2Tierra4")) {
                    isOld = 1;
                } else if (t.minute > MyGdxGame.tierra4Minute2.getInteger("Minute2Tierra4")) {
                    isOld = 1;
                }

            }

            if(t.year > MyGdxGame.tierra4Year.getInteger("YearTierra4"))
            {
                isOld = 2;
            }else if(t.day > MyGdxGame.tierra4Day.getInteger("DayTierra4"))
            {
                isOld = 2;
            }else if(t.hour > MyGdxGame.tierra4Hour.getInteger("HourTierra4"))
            {
                isOld = 2;
            }else if(t.minute > MyGdxGame.tierra4Minute.getInteger("MinuteTierra4"))
            {
                isOld = 2;
            }

        }

        if(MyGdxGame.tierra4Trigo.getBoolean("tierra41"))
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

            MyGdxGame.tierra4Enable.putBoolean("tierra4",false);
            MyGdxGame.tierra4Enable.flush();
        }

        if(MyGdxGame.tierra4Maiz.getBoolean("tierra42"))
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
            MyGdxGame.tierra4Enable.putBoolean("tierra4",false);
            MyGdxGame.tierra4Enable.flush();
        }

        if(MyGdxGame.tierra4Soja.getBoolean("tierra43"))
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
            MyGdxGame.tierra4Enable.putBoolean("tierra4",false);
            MyGdxGame.tierra4Enable.flush();
        }

        if(MyGdxGame.tierra4Zanahoria.getBoolean("tierra44"))
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
            MyGdxGame.tierra4Enable.putBoolean("tierra4",false);
            MyGdxGame.tierra4Enable.flush();
        }

        if(MyGdxGame.tierra4Cana.getBoolean("tierra45"))
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
            MyGdxGame.tierra4Enable.putBoolean("tierra4",false);
            MyGdxGame.tierra4Enable.flush();
        }

        if(MyGdxGame.tierra4Algodon.getBoolean("tierra46"))        {
            if(isOld == 2)
            {
                batch.draw(AlgoFase2,x,y+(32/Pixels),32/Pixels,32/Pixels);
            }else if(isOld == 1) {
                batch.draw(AlgoFase1,x,y+(32/Pixels),32/Pixels,32/Pixels);
            }else
            {
                batch.draw(brote, x, y + (32 / Pixels), 32 / Pixels, 32 / Pixels);
            }
            MyGdxGame.tierra4Enable.putBoolean("tierra4",false);
            MyGdxGame.tierra4Enable.flush();
        }

        for(Rectangle no: noBuild) {
            if (no.overlaps(Jugador.jugador)) {
                noToca = false;
            }
            if(no.overlaps(Cuerpo2))
            {
                var28 = false;
            }
        }
        for(Rectangle yes: Build) {
            if (yes.overlaps(Jugador.jugador)) {
                noToca = true;
            }
            if(yes.overlaps(Cuerpo2))
            {
                var28 = true;
            }
        }

        for(Rectangle no: noBuild) {
            for(Rectangle yes: Build) {
                if(no.overlaps(Cuerpo2)&& yes.overlaps(Cuerpo2))
                {
                    var28 = false;
                }
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
{   if(!cambiarPosicion) {
    x = tierra4.getFloat("X4");
    y = tierra4.getFloat("Y4");
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
        if( cambiarPosicion&&  MyGdxGame.tierra4Enable.getBoolean("tierra4"))
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
                tierra4.putFloat("X4", Jugador.body.getPosition().x);
                if(AddResources.TouchConfirm) {
                    tierra4.flush();
                }
                tierra4.putFloat("Y4", (e.y + (5 / Pixels)) - 32 / Pixels);
                if(AddResources.TouchConfirm) {
                    tierra4.flush();
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

            if (Cuerpo2.overlaps(Tierra2.Cuerpo2) || Cuerpo2.overlaps(Tierra3.Cuerpo2) || Cuerpo2.overlaps(Tierra1.Cuerpo2) || Cuerpo2.overlaps(Tierra5.Cuerpo2) || Cuerpo2.overlaps(Agua1.Cuerpo2) || Cuerpo2.overlaps(Agua2.Cuerpo2) || Cuerpo2.overlaps(Agua3.Cuerpo2) || Cuerpo2.overlaps(Agua4.Cuerpo2)) {
                AddResources.isFreeSpace4 = false;
            } else {
                AddResources.isFreeSpace4 = true;
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
