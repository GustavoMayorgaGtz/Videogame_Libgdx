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

import java.util.Random;

import static com.mygdx.game.MyGdxGame.Casa1;
import static com.mygdx.game.MyGdxGame.CasaDosPisos1;
import static com.mygdx.game.MyGdxGame.CasaDosPisos2;
import static com.mygdx.game.MyGdxGame.Pixels;
import static com.mygdx.game.actors.Tierra1.Build;
import static com.mygdx.game.actors.Tierra1.noBuild;

public class Casa2Pisos2 extends Actor implements Disposable {
    public static boolean var14= true;
    public static Texture logo;
    public static Rectangle Cuerpo,Cuerpo2;
    public static float x,y;
    boolean noToca;
    boolean cambiarPosicion = false;
    public static boolean isCasa2Pisos1Activate = false;
    float timeDurationTouch;

    /**Bloque Aldeana**/
    int iterator = 0,iterator2 = 0;
    float A1X,A1Y;
    Animation<TextureRegion> A1Right;
    int c1 = 1,r1 = 8;
    Animation<TextureRegion> A1Left;
    int c2 = 1,r2 = 8;
    Rectangle Aldeana1R;
    float timeAnimation1;
    Texture AldeanaRight,AldeanaLeft;
    boolean isLeft = false,isRight = true;
    boolean noToca2;
    float espera;
    Random random;
    /**Bloque Aldeana**/
    public Casa2Pisos2()
    {
        logo = new Texture("CasaDosPisos.png");
        Cuerpo = new Rectangle();
        Cuerpo2 = new Rectangle();

        /**Bloque Aldeana**/
        random = new Random();
        Aldeana1R = new Rectangle();
        AldeanaRight = new Texture("Aldeano2WalkRight.png");
        AldeanaLeft = new Texture("Aldeano2WalkLeft.png");
        TextureRegion[][] FramesRight = TextureRegion.split(AldeanaRight,AldeanaRight.getWidth()/c1,AldeanaRight.getHeight()/r1);
        TextureRegion[] TmpRight = new TextureRegion[c1 * r1];
        int index0 = 0;
        for(int i = 0; i < r1; i++)
        {
            for(int j = 0; j < c1; j++)
            {
                TmpRight[index0++] = FramesRight[i][j];
            }
        }
        A1Right = new Animation<TextureRegion>(0.2f,TmpRight);
        /////////////////////////////////////
        TextureRegion[][] FramesLeft = TextureRegion.split(AldeanaLeft,AldeanaLeft.getWidth()/c2,AldeanaLeft.getHeight()/r2);
        TextureRegion[] TmpLeft = new TextureRegion[c2 * r2];
        int index1 = 0;
        for(int i = 0; i < r2; i++)
        {
            for(int j = 0; j < c2; j++)
            {
                TmpLeft[index1++] = FramesLeft[i][j];
            }
        }
        A1Left = new Animation<TextureRegion>(0.2f,TmpLeft);
        /**Bloque Aldeana**/
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {

        batch.draw(logo,x,y,110/Pixels,190/Pixels);
        for(Rectangle no: noBuild) {
            if (no.overlaps(Jugador.jugador)) {
                noToca = false;
            }
            if(no.overlaps(Cuerpo2))
            {
                var14 = false;
            }
        }
        for(Rectangle yes: Build) {
            if (yes.overlaps(Jugador.jugador)) {
                noToca = true;
            }
            if(yes.overlaps(Cuerpo2))
            {
                var14 = true;
            }
        }

        for(Rectangle no: noBuild) {
            for(Rectangle yes: Build) {
                if(no.overlaps(Cuerpo2)&& yes.overlaps(Cuerpo2))
                {
                    var14 = false;
                }
            }
        }

        /**Bloque Aldeana**/
        if(MyGdxGame.CasasDosPisosColocadas.getInteger("Posiciones3") >= 2)
        {
            for(Rectangle yes: Tierra1.Build) {
                if (yes.overlaps(Aldeana1R)) {
                    noToca2 = true;
                }
            }
            for(Rectangle no: Tierra1.noBuild) {
                if (no.overlaps(Aldeana1R)) {
                    noToca2 = false;
                }
            }

            if(iterator == 0) {
                A1X = x;
                A1Y = y;
                iterator++;
            }

            if(isLeft)
            {
                espera += 1 * Gdx.graphics.getDeltaTime();
                A1X = A1X - (10 * Gdx.graphics.getDeltaTime() / Pixels);
            }
            if(isRight )
            {
                espera += 1 * Gdx.graphics.getDeltaTime();
                A1X = A1X + (10 * Gdx.graphics.getDeltaTime() / Pixels);
            }
            if(espera > 1f) {
                if (!noToca2) {
                    if (!isRight) {
                        espera = 0;
                        iterator2  = 0;
                        isRight = true;
                        isLeft = false;
                    } else {
                        espera = 0;
                        iterator2  = 0;
                        isRight = false;
                        isLeft = true;
                    }
                }
            }
            timeAnimation1 += Gdx.graphics.getDeltaTime();
            TextureRegion derecha = A1Right.getKeyFrame(timeAnimation1,true);
            TextureRegion izquierda = A1Left.getKeyFrame(timeAnimation1,true);
            if(espera > 10)
            {
                if(iterator2 == 0) {
                    int a = random.nextInt(2);
                   // Gdx.app.log("valor a",""+a);
                    if (a == 0) {
                        isLeft = true;
                        isRight = false;
                    }
                    if (a == 1) {
                        isLeft = false;
                        isRight = true;
                    }
                    iterator2++;
                }
            }

            Aldeana1R.set(A1X+(5/Pixels),A1Y,18/Pixels,24/Pixels);
            if(isLeft)
            {
                batch.draw(izquierda, A1X,A1Y,28/Pixels,24/Pixels);
            }
            if(isRight)
            {
                batch.draw(derecha, A1X,A1Y,28/Pixels,24/Pixels);
            }
        }
        /**Bloque Aldeana**/
    }

    @Override
    public void act(float delta) {
        colisiones();
        if (MyGdxGame.CasasDosPisosColocadas.getInteger("Posiciones3") == 1 && MenuBuild.CasasDosPisosBuild) {
            for (Rectangle e : Tierra1.rects) {
                if (Jugador.jugador.overlaps(e)) {
                    if (noToca) {
                        MyGdxGame.CasasDosPisosColocadas.putInteger("Posiciones3", 2);
                        CasaDosPisos2.putFloat("X11", Jugador.body.getPosition().x);
                        if (AddResources.TouchConfirm) {
                            CasaDosPisos2.flush();
                        }
                        CasaDosPisos2.putFloat("Y11", (e.y + (2 / Pixels)));
                        if (AddResources.TouchConfirm) {
                            CasaDosPisos2.flush();
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

        if (MenuBuild.CasasDosPisosBuild && MyGdxGame.CasasDosPisosColocadas.getInteger("Posiciones3") == 1) {
            for (Rectangle e : Tierra1.rects) {

                if (Jugador.jugador.overlaps(e)) {
                    y = (e.y + (2 / Pixels));
                    x = Jugador.body.getPosition().x;
                    Cuerpo2.set(x, y, 110 / Pixels, 170 / Pixels);

                }
            }
        } else {
            if (!cambiarPosicion) {
                x = CasaDosPisos2.getFloat("X11");
                y = CasaDosPisos2.getFloat("Y11");
                Cuerpo2.set(x, y, 110 / Pixels, 170 / Pixels);
            }
                if (!MenuBuild.buildMaquinaComida&&!MenuBuild.isAlmacen&&!MenuBuild.isMenuSeedSelection&&!MenuBuild.isMenu&&!MenuBuild.isCorralGallinasBuild&&!MenuBuild.isCorralVacasBuild&&!MenuBuild.gallinaBuild&&!MenuBuild.vacaBuild
                        &&!MenuBuild.BuildTierra&&!MenuBuild.BuildAgua&&!MenuBuild.BuildMover&&!MenuBuild.Arbusto1Build&&!MenuBuild.Arbusto2Build
                        &&!MenuBuild.CasasBuild&&!MenuBuild.CasasDosPisosBuild&&!MenuBuild.Maceta1Build&&!MenuBuild.Maceta2Build) {
                Cuerpo.set(x, y, 110 / Pixels, 170 / Pixels);
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
            MenuBuild.BuildMover = true;
            for (Rectangle e : Tierra1.rects) {
                if (noToca) {
                    if (Jugador.jugador.overlaps(e)) {
                        y =(e.y + (2 / Pixels));
                        x = Jugador.body.getPosition().x;
                        Cuerpo2.set(x, y, 110 / Pixels, 170 / Pixels);

                        CasaDosPisos2.putFloat("X11", Jugador.body.getPosition().x);
                        if (AddResources.TouchConfirm) {
                            CasaDosPisos2.flush();
                        }
                        CasaDosPisos2.putFloat("Y11", (e.y + (2 / Pixels)));
                        if (AddResources.TouchConfirm) {
                            CasaDosPisos2.flush();
                            iterator = 0;
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
        if(Cuerpo2.overlaps(Casa2Pisos.Cuerpo2)||Cuerpo2.overlaps(com.mygdx.game.actors.Casa1.Cuerpo2)||Cuerpo2.overlaps(Casa2.Cuerpo2)||Cuerpo2.overlaps(Maceta1_1.Cuerpo2)||Cuerpo2.overlaps(Maceta1_2.Cuerpo2)||Cuerpo2.overlaps(Maceta1_3.Cuerpo2)
                ||Cuerpo2.overlaps(Maceta2_1.Cuerpo2)||Cuerpo2.overlaps(Maceta2_2.Cuerpo2)||Cuerpo2.overlaps(Maceta2_3.Cuerpo2)
                ||Cuerpo2.overlaps(Arbusto1_1.Cuerpo2)||Cuerpo2.overlaps(Arbusto1_2.Cuerpo2)||Cuerpo2.overlaps(Arbusto1_3.Cuerpo2)
                ||Cuerpo2.overlaps(Arbusto2_1.Cuerpo2)||Cuerpo2.overlaps(Arbusto2_2.Cuerpo2)||Cuerpo2.overlaps(Arbusto2_3.Cuerpo2)
                ||Cuerpo2.overlaps(CorralVaca.Cuerpo2)||Cuerpo2.overlaps(CorralVaca2.Cuerpo2)||Cuerpo2.overlaps(CorralGallinas.Cuerpo2)||Cuerpo2.overlaps(CorralGallinas2.Cuerpo2))
        {
            AddResources.isFreeSpaceTop2 = false;
        }else
        {
            AddResources.isFreeSpaceTop2 = true;
        }
    }

    @Override
    public void dispose() {
      logo.dispose();
        /**Bloque Aldeana**/
        AldeanaRight.dispose();
        AldeanaLeft.dispose();
        /**Bloque Aldeana**/
    }
}
