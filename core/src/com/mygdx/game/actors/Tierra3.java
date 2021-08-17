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
import static com.mygdx.game.MyGdxGame.tierra3;
import static com.mygdx.game.actors.Tierra1.Build;
import static com.mygdx.game.actors.Tierra1.noBuild;

public class Tierra3 extends Actor implements Disposable {
    public static boolean var27= true;
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


    public Tierra3()
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
        if(!MyGdxGame.tierra3Enable.getBoolean("tierra3"))
        {
            if(isOld == 2)
            {
                CuerpoCortar.set(x,y+(32/Pixels),32/Pixels,32/Pixels);
                if(reiniciar)
                {
                    isOld = 0;
                    MyGdxGame.tierra3Iterator.putInteger("iteratorTierra3",0);
                    MyGdxGame.tierra3Enable.putBoolean("tierra3",true);
                    MyGdxGame.tierra3Trigo.putBoolean("tierra31",false);
                    MyGdxGame.tierra3Maiz.putBoolean("tierra32",false);
                    MyGdxGame.tierra3Soja.putBoolean("tierra33",false);
                    MyGdxGame.tierra3Zanahoria.putBoolean("tierra34",false);
                    MyGdxGame.tierra3Cana.putBoolean("tierra35",false);
                    MyGdxGame.tierra3Algodon.putBoolean("tierra36",false);
                    MyGdxGame.tierra3Iterator.flush();
                    MyGdxGame.tierra3Enable.flush();
                    MyGdxGame.tierra3Trigo.flush();
                    MyGdxGame.tierra3Maiz.flush();
                    MyGdxGame.tierra3Soja.flush();
                    MyGdxGame.tierra3Zanahoria.flush();
                    MyGdxGame.tierra3Cana.flush();
                    MyGdxGame.tierra3Algodon.flush();
                    reiniciarTime = 0;
                    reiniciar = false;
                    isOld = 0;
                }

            }
            if(MyGdxGame.tierra3Iterator.getInteger("iteratorTierra3")==0) {
                TimeZone t = new TimeZone();
                t.calcularHora = true;
                t.CalcularTiempo(2);
                MyGdxGame.tierra3Day.putInteger("DayTierra3",t.dayS);
                MyGdxGame.tierra3Year.putInteger("YearTierra3",t.yearS);
                MyGdxGame.tierra3Hour.putInteger("HourTierra3",t.hourS);
                MyGdxGame.tierra3Minute.putInteger("MinuteTierra3",t.minuteS);
                MyGdxGame.tierra3Day.flush();
                MyGdxGame.tierra3Year.flush();
                MyGdxGame.tierra3Hour.flush();
                MyGdxGame.tierra3Minute.flush();
                MyGdxGame.tierra3Iterator.putInteger("iteratorTierra3",1);
                MyGdxGame.tierra3Iterator.flush();
                TimeZone t2 = new TimeZone();
                t2.calcularHora = true;
                t2.CalcularTiempo(1);
                MyGdxGame.tierra3Day2.putInteger("Day2Tierra3",t2.dayS);
                MyGdxGame.tierra3Year2.putInteger("Year2Tierra3",t2.yearS);
                MyGdxGame.tierra3Hour2.putInteger("Hour2Tierra3",t2.hourS);
                MyGdxGame.tierra3Minute2.putInteger("Minute2Tierra3",t2.minuteS);
                MyGdxGame.tierra3Day2.flush();
                MyGdxGame.tierra3Year2.flush();
                MyGdxGame.tierra3Hour2.flush();
                MyGdxGame.tierra3Minute2.flush();
            }

            TimeZone t = new TimeZone();
            if(isOld == 0) {
                if (t.year > MyGdxGame.tierra3Year2.getInteger("Year2Tierra3")) {
                    isOld = 1;
                } else if (t.day > MyGdxGame.tierra3Day2.getInteger("Day2Tierra3")&&t.year >= MyGdxGame.tierra3Year2.getInteger("Year2Tierra3")) {
                    isOld = 1;
                } else if (t.hour > MyGdxGame.tierra3Hour2.getInteger("Hour2Tierra3")&&t.day >= MyGdxGame.tierra3Day2.getInteger("Day2Tierra3")&&t.year >= MyGdxGame.tierra3Year2.getInteger("Year2Tierra3")) {
                    isOld = 1;
                } else if (t.minute > MyGdxGame.tierra3Minute2.getInteger("Minute2Tierra3")&&t.hour >= MyGdxGame.tierra3Hour2.getInteger("Hour2Tierra3")&&t.day >= MyGdxGame.tierra3Day2.getInteger("Day2Tierra3")&&t.year >= MyGdxGame.tierra3Year2.getInteger("Year2Tierra3")) {
                    isOld = 1;
                }

            }

            if(t.year > MyGdxGame.tierra3Year.getInteger("YearTierra3"))
            {
                isOld = 2;
            }else if(t.day > MyGdxGame.tierra3Day.getInteger("DayTierra3")&&t.year >= MyGdxGame.tierra3Year.getInteger("YearTierra3"))
            {
                isOld = 2;
            }else if(t.hour > MyGdxGame.tierra3Hour.getInteger("HourTierra3")&&t.day >= MyGdxGame.tierra3Day.getInteger("DayTierra3")&&t.year >= MyGdxGame.tierra3Year.getInteger("YearTierra3"))
            {
                isOld = 2;
            }else if(t.minute > MyGdxGame.tierra3Minute.getInteger("MinuteTierra3")&&t.hour >= MyGdxGame.tierra3Hour.getInteger("HourTierra3")&&t.day >= MyGdxGame.tierra3Day.getInteger("DayTierra3")&&t.year >= MyGdxGame.tierra3Year.getInteger("YearTierra3"))
            {
                isOld = 2;
            }

        }

        if(MyGdxGame.tierra3Trigo.getBoolean("tierra31"))
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

            MyGdxGame.tierra3Enable.putBoolean("tierra3",false);
            MyGdxGame.tierra3Enable.flush();
        }

        if(MyGdxGame.tierra3Maiz.getBoolean("tierra32"))
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

            MyGdxGame.tierra3Enable.putBoolean("tierra3",false);
            MyGdxGame.tierra3Enable.flush();
        }

        if(MyGdxGame.tierra3Soja.getBoolean("tierra33"))
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
            MyGdxGame.tierra3Enable.putBoolean("tierra3",false);
            MyGdxGame.tierra3Enable.flush();
        }

        if(MyGdxGame.tierra3Zanahoria.getBoolean("tierra34"))
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
            MyGdxGame.tierra3Enable.putBoolean("tierra3",false);
            MyGdxGame.tierra3Enable.flush();
        }

        if(MyGdxGame.tierra3Cana.getBoolean("tierra35"))
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
            MyGdxGame.tierra3Enable.putBoolean("tierra3",false);
            MyGdxGame.tierra3Enable.flush();
        }

        if(MyGdxGame.tierra3Algodon.getBoolean("tierra36"))        {
            if(isOld == 2)
            {
                batch.draw(AlgoFase2,x,y+(32/Pixels),32/Pixels,32/Pixels);
            }else if(isOld == 1) {
                batch.draw(AlgoFase1,x,y+(32/Pixels),32/Pixels,32/Pixels);
            }else
            {
                batch.draw(brote, x, y + (32 / Pixels), 32 / Pixels, 32 / Pixels);
            }
            MyGdxGame.tierra3Enable.putBoolean("tierra3",false);
            MyGdxGame.tierra3Enable.flush();
        }


        for(Rectangle no: noBuild) {
            if (no.overlaps(Jugador.jugador)) {
                noToca = false;
            }
            if(no.overlaps(Cuerpo2))
            {
                var27 = false;
            }
        }
        for(Rectangle yes: Build) {
            if (yes.overlaps(Jugador.jugador)) {
                noToca = true;
            }
            if(yes.overlaps(Cuerpo2))
            {
                var27 = true;
            }
        }

        for(Rectangle no: noBuild) {
            for(Rectangle yes: Build) {
                if(no.overlaps(Cuerpo2)&& yes.overlaps(Cuerpo2))
                {
                    var27 = false;
                }
            }
        }

    }

    @Override
    public void act(float delta) {
colisiones();
        if(MyGdxGame.TierrasColocadas.getInteger("Posiciones") == 2 && MenuBuild.BuildTierra) {
            for (Rectangle e :  Tierra1.rects) {
                if (Jugador.jugador.overlaps(e)) {
                    if (noToca) {
                        MyGdxGame.TierrasColocadas.putInteger("Posiciones",3);
                        tierra3.putFloat("X3", Jugador.body.getPosition().x);
                        if(AddResources.TouchConfirm) {
                            tierra3.flush();
                        }
                        tierra3.putFloat("Y3", (e.y + (5 / Pixels)) - 32 / Pixels);
                        if(AddResources.TouchConfirm) {
                            tierra3.flush();
                            MyGdxGame.TierrasColocadas.flush();
                            MenuBuild.BuildTierra = false;
                            AddResources.TouchConfirm = false;
                            AddResources.TouchCancel = false;
                        }
                    }
                }
            }
        }

if(MenuBuild.BuildTierra&&MyGdxGame.TierrasColocadas.getInteger("Posiciones") == 2 ) {
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
        x = tierra3.getFloat("X3");
        y = tierra3.getFloat("Y3");
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
        if( cambiarPosicion&&  MyGdxGame.tierra3Enable.getBoolean("tierra3"))
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
                tierra3.putFloat("X3", Jugador.body.getPosition().x);
                if(AddResources.TouchConfirm) {
                    tierra3.flush();
                }
                tierra3.putFloat("Y3", (e.y + (5 / Pixels)) - 32 / Pixels);
                if(AddResources.TouchConfirm) {
                    tierra3.flush();
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

            if (Cuerpo2.overlaps(Tierra2.Cuerpo2) || Cuerpo2.overlaps(Tierra1.Cuerpo2) || Cuerpo2.overlaps(Tierra4.Cuerpo2) || Cuerpo2.overlaps(Tierra5.Cuerpo2) || Cuerpo2.overlaps(Agua1.Cuerpo2) || Cuerpo2.overlaps(Agua2.Cuerpo2) || Cuerpo2.overlaps(Agua3.Cuerpo2) || Cuerpo2.overlaps(Agua4.Cuerpo2)) {
                AddResources.isFreeSpace3 = false;
            } else {
                AddResources.isFreeSpace3 = true;
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
