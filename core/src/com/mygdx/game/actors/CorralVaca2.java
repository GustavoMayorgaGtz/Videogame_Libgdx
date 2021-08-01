package com.mygdx.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.tiled.AddResources;

import static com.mygdx.game.MyGdxGame.Corral1Vacas;
import static com.mygdx.game.MyGdxGame.Corral2Vacas;
import static com.mygdx.game.MyGdxGame.CorralVacas2;
import static com.mygdx.game.MyGdxGame.Pixels;
import static com.mygdx.game.actors.Tierra1.Build;
import static com.mygdx.game.actors.Tierra1.noBuild;

public class CorralVaca2 extends Actor implements Disposable {
    public static boolean var18= true;
    public static Texture logo;
    public static Rectangle Cuerpo,Cuerpo2;
    public static float x,y;
    boolean noToca;
    boolean cambiarPosicion = false;
float timeDurationTouch;
    /*vacas*/
    Rectangle Izq,Dere;
    Rectangle vaca1,vaca2;
    float x1,x2;
    boolean vaca1Izq = true,vaca1Dere = false,vaca2Izq = false,vaca2Dere = true;
    int iteraror1 = 0, iterator2 = 0;
    boolean sube = true,baja;
    float abs;
    Texture FlechaVerde;

    Texture vacaL,vacaR;
    Texture vacaL2,vacaR2;
    Animation<TextureRegion> right,left;
    Animation<TextureRegion> right2,left2;
    int c1 = 1,r1 = 6,c2 = 1,r2 = 6;
    int c3 = 1,r3 = 6,c4 = 1,r4 = 6;

    float timeFree;
    public CorralVaca2()
    {
        logo = new Texture("CorralVacas.png");
        Cuerpo = new Rectangle();
        Cuerpo2 = new Rectangle();

        Izq = new Rectangle();
        Dere = new Rectangle();
        vaca1 = new Rectangle();
        vaca2 = new Rectangle();
        FlechaVerde = new Texture("FlechaVerde.png");
        vacaR= new Texture("Vaca3WR.png");
        vacaL= new Texture("Vaca3WL.png");
        vacaR2= new Texture("Vaca2WR.png");
        vacaL2= new Texture("Vaca2WL.png");
        TextureRegion[][] FramesR = TextureRegion.split(vacaR,vacaR.getWidth()/c1,vacaR.getHeight()/r1);
        TextureRegion[] TmpR = new TextureRegion[c1 * r1];
        int index1 = 0;
        for(int i= 0; i < r1; i++)
        {
            for(int j = 0; j < c1; j++)
            {
                TmpR[index1++] = FramesR[i][j] ;
            }
        }
        right = new Animation<TextureRegion>(0.6f,TmpR);
        /*******************************/
        TextureRegion[][] FramesL = TextureRegion.split(vacaL,vacaL.getWidth()/c2,vacaL.getHeight()/r2);
        TextureRegion[] TmpL = new TextureRegion[c2* r2];
        int index2 = 0;
        for(int i= 0; i < r2; i++)
        {
            for(int j = 0; j < c2; j++)
            {
                TmpL[index2++] = FramesL[i][j] ;
            }
        }
        left = new Animation<TextureRegion>(0.6f,TmpL);
/*****************************************************************************/
        TextureRegion[][] FramesR2 = TextureRegion.split(vacaR2,vacaR2.getWidth()/c3,vacaR2.getHeight()/r3);
        TextureRegion[] TmpR2 = new TextureRegion[c3 * r3];
        int index3 = 0;
        for(int i= 0; i < r3; i++)
        {
            for(int j = 0; j < c3; j++)
            {
                TmpR2[index3++] = FramesR2[i][j] ;
            }
        }
        right2 = new Animation<TextureRegion>(0.6f,TmpR2);
        /*******************************/
        TextureRegion[][] FramesL2 = TextureRegion.split(vacaL2,vacaL2.getWidth()/c4,vacaL2.getHeight()/r4);
        TextureRegion[] TmpL2 = new TextureRegion[c4* r4];
        int index4 = 0;
        for(int i= 0; i < r4; i++)
        {
            for(int j = 0; j < c4; j++)
            {
                TmpL2[index4++] = FramesL2[i][j] ;
            }
        }
        left2= new Animation<TextureRegion>(0.6f,TmpL2);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        timeFree += Gdx.graphics.getDeltaTime();
        batch.draw(logo,x,y,128/Pixels,32/Pixels);
        /***************/
        if(sube) {
            if (abs < 5) {
                abs += 15 * Gdx.graphics.getDeltaTime();
            }else {
                baja = true;
                sube = false;
            }
        }
        if(baja) {
            if (abs > 1) {
                abs -= 15 * Gdx.graphics.getDeltaTime();
            }else
            {
                baja = false;
                sube = true;
            }
        }
/***************/
        for(Rectangle no: noBuild) {
            if (no.overlaps(Jugador.jugador)) {
                noToca = false;
            }
            if(no.overlaps(Cuerpo2))
            {
                var18 = false;
            }
        }
        for(Rectangle yes: Build) {
            if (yes.overlaps(Jugador.jugador)) {
                noToca = true;
            }
            if(yes.overlaps(Cuerpo2))
            {
                var18 = true;
            }
        }

        for(Rectangle no: noBuild) {
            for(Rectangle yes: Build) {
                if(no.overlaps(Cuerpo2)&& yes.overlaps(Cuerpo2))
                {
                    var18 = false;
                }
            }
        }
        /*************/
        Izq.set(x,y,5/Pixels,32/Pixels);
        Dere.set(x+(128/Pixels),y,10/Pixels,32/Pixels);
        if(Jugador.jugador.overlaps(Cuerpo2)&&MenuBuild.vacaBuild&&!MenuBuild.isMenu&&Corral2Vacas.getInteger("Corral2Vacas")!=2)
        {
            batch.draw(FlechaVerde,x+(60/Pixels),y+(32/Pixels)+(abs/Pixels),32/Pixels,32/Pixels);
            if(AddResources.puntero.overlaps(Cuerpo2)) {
                if(MenuBuild.vacaBuild) {
                    if (Corral2Vacas.getInteger("Corral2Vacas") == 0) {
                        Corral2Vacas.putInteger("Corral2Vacas", 1);
                        Corral2Vacas.flush();
                        MenuBuild.vacaBuild = false;
                    }
                }
                if(MenuBuild.vacaBuild) {
                    if (Corral2Vacas.getInteger("Corral2Vacas") == 1) {
                        Corral2Vacas.putInteger("Corral2Vacas", 2);
                        Corral2Vacas.flush();
                        MenuBuild.vacaBuild = false;
                    }
                }
            }
        }
        if (Corral2Vacas.getInteger("Corral2Vacas") >= 1)
        {
            Vaca1(batch);
        }
        if (Corral2Vacas.getInteger("Corral2Vacas") >= 2)
        {
            Vaca2(batch);
        }
        /************/
    }
    public void Vaca1(Batch batch)
    {
        TextureRegion Right = right.getKeyFrame(timeFree,true);
        TextureRegion Left = left.getKeyFrame(timeFree,true);
        vaca1.set(x1,y,40/Pixels,32/Pixels);
        if(vaca1.overlaps(vaca2))
        {
            if(vaca2Dere) {
                vaca2Dere = false;
                vaca2Izq = true;
            }else
            {
                vaca2Dere = true;
                vaca2Izq = false;
            }


            if(vaca1Dere) {
                vaca1Dere = false;
                vaca1Izq = true;
            }else
            {
                vaca1Dere = true;
                vaca1Izq = false;
            }
        }
        if(iteraror1 == 0)
        {
            x1 = x + (32/Pixels);
            iteraror1++;
        }
        if(vaca1Dere)
        {
            x1 += (10 * Gdx.graphics.getDeltaTime())/Pixels;
            batch.draw(Right,vaca1.x,vaca1.y,vaca1.width,vaca1.height);

            vaca1.setX(x1);
        }
        if(vaca1Izq)
        {
            x1 -= (10 * Gdx.graphics.getDeltaTime())/Pixels;
            batch.draw(Left,vaca1.x,vaca1.y,vaca1.width,vaca1.height);

            vaca1.setX(x1);
        }
        if(Izq.overlaps(vaca1))
        {
            vaca1Dere = true;
            vaca1Izq = false;
        }
        if(Dere.overlaps(vaca1))
        {
            vaca1Izq = true;
            vaca1Dere = false;
        }
    }

    public void Vaca2(Batch batch)
    {
        TextureRegion Right = right2.getKeyFrame(timeFree,true);
        TextureRegion Left = left2.getKeyFrame(timeFree,true);
        vaca2.set(x2,y,40/Pixels,32/Pixels);
        if(vaca1.overlaps(vaca2))
        {
            if(vaca2Dere) {
                vaca2Dere = false;
                vaca2Izq = true;
            }else
            {
                vaca2Dere = true;
                vaca2Izq = false;
            }


            if(vaca1Dere) {
                vaca1Dere = false;
                vaca1Izq = true;
            }else
            {
                vaca1Dere = true;
                vaca1Izq = false;
            }
        }
        if(iterator2 == 0)
        {
            x2 = x + (32/Pixels);
            iterator2++;
        }
        if(vaca2Dere)
        {
            x2 += (8 * Gdx.graphics.getDeltaTime())/Pixels;
            batch.draw(Right,vaca2.x,vaca2.y,vaca2.width,vaca2.height);
            vaca2.setX(x2);

        }
        if(vaca2Izq)
        {
            x2 -= (8 * Gdx.graphics.getDeltaTime())/Pixels;
            batch.draw(Left,vaca2.x,vaca2.y,vaca2.width,vaca2.height);
            vaca2.setX(x2);

        }
        if(Izq.overlaps(vaca2))
        {
            vaca2Dere = true;
            vaca2Izq = false;
        }
        if(Dere.overlaps(vaca2))
        {
            vaca2Izq = true;
            vaca2Dere = false;
        }
    }

    @Override
    public void act(float delta) {
        colisiones();
        if (MyGdxGame.CorralVacaColocadas.getInteger("Posiciones9") == 1 && MenuBuild.isCorralVacasBuild) {
            for (Rectangle e : Tierra1.rects) {
                if (Jugador.jugador.overlaps(e)) {
                    if (noToca) {
                        MyGdxGame.CorralVacaColocadas.putInteger("Posiciones9", 2);
                        CorralVacas2.putFloat("X27", Jugador.body.getPosition().x);
                        if (AddResources.TouchConfirm) {
                            CorralVacas2.flush();
                        }
                        CorralVacas2.putFloat("Y27", (e.y + (2 / Pixels)));
                        if (AddResources.TouchConfirm) {
                            CorralVacas2.flush();
                            MyGdxGame.CorralVacaColocadas.flush();
                            MenuBuild.isCorralVacasBuild = false;
                            AddResources.TouchConfirm = false;
                            AddResources.TouchCancel = false;
                        }
                    }
                }
            }
        }

        if (MyGdxGame.CorralVacaColocadas.getInteger("Posiciones9") == 1 && MenuBuild.isCorralVacasBuild) {
            for (Rectangle e : Tierra1.rects) {

                if (Jugador.jugador.overlaps(e)) {
                    y = (e.y + (2 / Pixels));
                    x = Jugador.body.getPosition().x;
                    Cuerpo2.set(x, y, 128/Pixels,32/Pixels);

                }
            }
        } else {
            if (!cambiarPosicion) {
                x = CorralVacas2.getFloat("X27");
                y = CorralVacas2.getFloat("Y27");
                Cuerpo2.set(x, y, 128/Pixels,32/Pixels);
            }
            if (!MenuBuild.isCorralVacasBuild) {

                Cuerpo.set(x, y, 128/Pixels,32/Pixels);
            } else {
                Cuerpo.set(0, 0, 0, 0);
            }
            if (MenuBuild.isMenu) {
                Cuerpo.set(0, 0, 0, 0);
            }
        }

        if (MenuBuild.isMover) {
            if (Cuerpo.overlaps(AddResources.puntero)) {
                timeDurationTouch += 1 * Gdx.graphics.getDeltaTime();
                if (timeDurationTouch > 2) {
                    cambiarPosicion = true;
                }
            }
        }

        if (cambiarPosicion) {
            iteraror1 = 0;
            iterator2 = 0;
            MenuBuild.BuildMover = true;
            for (Rectangle e : Tierra1.rects) {
                if (noToca) {
                    if (Jugador.jugador.overlaps(e)) {
                        y = (e.y + (2 / Pixels));
                        x = Jugador.body.getPosition().x;
                        Cuerpo2.set(x, y, 128/Pixels,32/Pixels);

                        CorralVacas2.putFloat("X27", Jugador.body.getPosition().x);
                        if (AddResources.TouchConfirm) {
                            CorralVacas2.flush();
                        }
                        CorralVacas2.putFloat("Y27", (e.y + (2 / Pixels)));
                        if (AddResources.TouchConfirm) {
                            iteraror1 = 0;
                            iterator2 = 0;
                            CorralVacas2.flush();
                            MenuBuild.BuildMover = false;
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
        if(Cuerpo2.overlaps(Casa2Pisos.Cuerpo2)||Cuerpo2.overlaps(Casa2Pisos2.Cuerpo2)||Cuerpo2.overlaps(Casa1.Cuerpo2)||Cuerpo2.overlaps(Casa2.Cuerpo2)||Cuerpo2.overlaps(Maceta1_1.Cuerpo2)||Cuerpo2.overlaps(Maceta1_2.Cuerpo2)||Cuerpo2.overlaps(Maceta1_3.Cuerpo2)
                ||Cuerpo2.overlaps(Maceta2_1.Cuerpo2)||Cuerpo2.overlaps(Maceta2_2.Cuerpo2)||Cuerpo2.overlaps(Maceta2_3.Cuerpo2)
                ||Cuerpo2.overlaps(Arbusto1_1.Cuerpo2)||Cuerpo2.overlaps(Arbusto1_2.Cuerpo2)||Cuerpo2.overlaps(Arbusto1_3.Cuerpo2)
                ||Cuerpo2.overlaps(Arbusto2_1.Cuerpo2)||Cuerpo2.overlaps(Arbusto2_2.Cuerpo2)||Cuerpo2.overlaps(Arbusto2_3.Cuerpo2)
                ||Cuerpo2.overlaps(CorralVaca.Cuerpo2)||Cuerpo2.overlaps(CorralGallinas.Cuerpo2)||Cuerpo2.overlaps(CorralGallinas2.Cuerpo2))
        {
            AddResources.freeCorral2 = false;
        }else
        {
            AddResources.freeCorral2 = true;
        }
    }

    @Override
    public void dispose() {
      logo.dispose();
        FlechaVerde.dispose();
        vacaL.dispose();
        vacaR.dispose();
        vacaL2.dispose();
        vacaR2.dispose();
    }
}
