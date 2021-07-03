package com.mygdx.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.game.MyGdxGame;

import static com.mygdx.game.MyGdxGame.Pixels;

public class ArbolAzul extends Actor implements Disposable{
    private Body body;
    private Texture texture;
    private World world;
    private Fixture fixture;
    private BodyDef def;
    public static Rectangle rectangle;

    private BodyDef def1,def2,def3,def4,def5,def6,def7;
    private Body body1,body2,body3,body4,body5,body6,body7;
    private Fixture fixture1, fixture2,fixture3,fixture4,fixture5,fixture6,fixture7;
    /**********Animation************/
    float timeA2;
    float timeA3;
    float timeA4;
    float timeA5;
    float timeA6;
    float timeA7;
    Animation<TextureRegion> animation1;
    int c1 = 1, r1 = 4;
    float time1;
    Texture animationTexture1;

    Animation<TextureRegion> animation2;
    int c2 = 1, r2 = 4;
    float time2;
    Texture animationTexture2;


    Animation<TextureRegion> animation3;
    int c3 = 1, r3 = 4;
    float time3;
    Texture animationTexture3;

    Animation<TextureRegion> animation4;
    int c4 = 1, r4 = 4;
    float time4;
    Texture animationTexture4;

    Animation<TextureRegion> animation5;
    int c5 = 1, r5 = 4;
    float time5;
    Texture animationTexture5;

    Animation<TextureRegion> animation6;
    int c6 = 1, r6 = 4;
    float time6;
    Texture animationTexture6;

    Animation<TextureRegion> animation7;
    int c7 = 1, r7 = 4;
    float time7;
    Texture animationTexture7;
    /******************************/

    ParticleEffect particula;
    float timeiterator;
    boolean activarParticula;
    float tempo;

    public ArbolAzul(World world, Texture texture, float x, float y)
    {
        this.world = world;
        this.texture = texture;

        def = new BodyDef();
        def.position.set(x/Pixels, y/Pixels);
        def.fixedRotation = true;
        def.type = BodyDef.BodyType.KinematicBody;

        body = world.createBody(def);
        PolygonShape box = new PolygonShape();
        box.setAsBox(12/Pixels,12/Pixels);
        fixture = body.createFixture(box,20);
        fixture.setUserData("ArbolRosa");
        fixture.setSensor(true);
        box.dispose();
        setSize(24/Pixels,24/Pixels);
        rectangle = new Rectangle();

        /********Plataformas**********/
        def1 = new BodyDef();
        def1.position.set((x/Pixels)-1.3f,(y+65)/Pixels);
        def1.type = BodyDef.BodyType.KinematicBody;

        body1 = world.createBody(def1);
        body1.setGravityScale(0);
        PolygonShape box1 = new PolygonShape();
        box1.setAsBox(.5f,.5f/Pixels);
        fixture1 = body1.createFixture(box1,0);
        fixture1.setUserData("PisoBase");
        box1.dispose();

        def2 = new BodyDef();
        def2.position.set((x-10)/Pixels,(y+40)/Pixels);
        def2.type = BodyDef.BodyType.KinematicBody;

        body2 = world.createBody(def2);
        body2.setGravityScale(0);
        PolygonShape box2 = new PolygonShape();
        box2.setAsBox(.5f,.5f/Pixels);
        fixture2 = body2.createFixture(box2,0);
        fixture2.setUserData("PisoBase");
        box2.dispose();

        def3 = new BodyDef();
        def3.position.set((x-10)/Pixels,(y+90)/Pixels);
        def3.type = BodyDef.BodyType.KinematicBody;

        body3 = world.createBody(def3);
        body3.setGravityScale(0);
        PolygonShape box3 = new PolygonShape();
        box3.setAsBox(.5f,.5f/Pixels);
        fixture3 = body3.createFixture(box3,0);
        fixture3.setUserData("PisoBase");
        box3.dispose();


        def4 = new BodyDef();
        def4.position.set((x/Pixels)-1.3f,(y+120)/Pixels);
        def4.type = BodyDef.BodyType.KinematicBody;

        body4 = world.createBody(def4);
        body4.setGravityScale(0);
        PolygonShape box4 = new PolygonShape();
        box4.setAsBox(.5f,.5f/Pixels);
        fixture4 = body4.createFixture(box4,0);
        fixture4.setUserData("PisoBase");
        box4.dispose();

        def5 = new BodyDef();
        def5.position.set(((x-10)/Pixels),(y+155)/Pixels);

        def5.type = BodyDef.BodyType.KinematicBody;

        body5 = world.createBody(def5);
        body5.setGravityScale(0);
        PolygonShape box5 = new PolygonShape();
        box5.setAsBox(.5f,.5f/Pixels);
        fixture5 = body5.createFixture(box5,0);
        fixture5.setUserData("PisoBase");
        box5.dispose();

        def6 = new BodyDef();
        def6.position.set(((x-10)/Pixels),(y+215)/Pixels);
        def6.type = BodyDef.BodyType.KinematicBody;

        body6 = world.createBody(def6);
        body6.setGravityScale(0);
        PolygonShape box6 = new PolygonShape();
        box6.setAsBox(.7f,.5f/Pixels);
        fixture6 = body6.createFixture(box6,0);
        fixture6.setUserData("PisoBase");
        box6.dispose();

        def7 = new BodyDef();
        def7.position.set((x/Pixels)-1.2f,(y+279)/Pixels);
        def7.type = BodyDef.BodyType.KinematicBody;

        body7 = world.createBody(def7);
        body7.setGravityScale(0);
        PolygonShape box7 = new PolygonShape();
        box7.setAsBox(.7f,.5f/Pixels);
        fixture7 = body7.createFixture(box7,0);
        fixture7.setUserData("PisoBase");
        box7.dispose();

        particula = new ParticleEffect();
        particula.load(Gdx.files.internal("particles/fertilizer2.p"),Gdx.files.internal("images"));
        particula.scaleEffect(.2f/Pixels);

        /******Animation***********/
        animationTexture1 = new Texture("AnimationArbolA(1).png");
        TextureRegion[][]TmpAnimation1 = TextureRegion.split(animationTexture1,animationTexture1.getWidth()/c1,animationTexture1.getHeight()/r1);
        TextureRegion[] FramesAnimation1 = new TextureRegion[c1 * r1];
        int index1 = 0;
        for(int i = 0; i < r1; i++)
        {
            for(int j = 0; j < c1; j++)
            {
                FramesAnimation1[index1++]=TmpAnimation1[i][j];
            }
        }
        animation1 = new Animation<TextureRegion>(0.2f,FramesAnimation1);
        /**************************/
        /******Animation***********/
        animationTexture2 = new Texture("AnimationArbolA(2).png");
        TextureRegion[][]TmpAnimation2 = TextureRegion.split(animationTexture2,animationTexture2.getWidth()/c2,animationTexture2.getHeight()/r2);
        TextureRegion[] FramesAnimation2 = new TextureRegion[c2 * r2];
        int index2 = 0;
        for(int i = 0; i < r2; i++)
        {
            for(int j = 0; j < c2; j++)
            {
                FramesAnimation2[index2++]=TmpAnimation2[i][j];
            }
        }
        animation2 = new Animation<TextureRegion>(0.2f,FramesAnimation2);
        /**************************/
        /******Animation***********/
        animationTexture3 = new Texture("AnimationArbolA(3).png");
        TextureRegion[][]TmpAnimation3 = TextureRegion.split(animationTexture3,animationTexture3.getWidth()/c3,animationTexture3.getHeight()/r3);
        TextureRegion[] FramesAnimation3 = new TextureRegion[c3 * r3];
        int index3 = 0;
        for(int i = 0; i < r3; i++)
        {
            for(int j = 0; j < c3; j++)
            {
                FramesAnimation3[index3++]=TmpAnimation3[i][j];
            }
        }
        animation3 = new Animation<TextureRegion>(0.2f,FramesAnimation3);
        /**************************/
        /******Animation***********/
        animationTexture4 = new Texture("AnimationArbolA(4).png");
        TextureRegion[][]TmpAnimation4 = TextureRegion.split(animationTexture4,animationTexture4.getWidth()/c4,animationTexture4.getHeight()/r4);
        TextureRegion[] FramesAnimation4 = new TextureRegion[c4 * r4];
        int index4 = 0;
        for(int i = 0; i < r4; i++)
        {
            for(int j = 0; j < c4; j++)
            {
                FramesAnimation4[index4++]=TmpAnimation4[i][j];
            }
        }
        animation4 = new Animation<TextureRegion>(0.2f,FramesAnimation4);
        /**************************/
        /******Animation***********/
        animationTexture5 = new Texture("AnimationArbolA(5).png");
        TextureRegion[][]TmpAnimation5 = TextureRegion.split(animationTexture5,animationTexture5.getWidth()/c5,animationTexture5.getHeight()/r5);
        TextureRegion[] FramesAnimation5 = new TextureRegion[c5 * r5];
        int index5 = 0;
        for(int i = 0; i < r5; i++)
        {
            for(int j = 0; j < c5; j++)
            {
                FramesAnimation5[index5++]=TmpAnimation5[i][j];
            }
        }
        animation5 = new Animation<TextureRegion>(0.2f,FramesAnimation5);
        /**************************/
        /******Animation***********/
        animationTexture6 = new Texture("AnimationArbolA(6).png");
        TextureRegion[][]TmpAnimation6 = TextureRegion.split(animationTexture6,animationTexture6.getWidth()/c6,animationTexture6.getHeight()/r6);
        TextureRegion[] FramesAnimation6 = new TextureRegion[c6 * r6];
        int index6 = 0;
        for(int i = 0; i < r6; i++)
        {
            for(int j = 0; j < c6; j++)
            {
                FramesAnimation6[index6++]=TmpAnimation6[i][j];
            }
        }
        animation6 = new Animation<TextureRegion>(0.2f,FramesAnimation6);
        /**************************/
        /******Animation***********/
        animationTexture7 = new Texture("AnimationArbolA(7).png");
        TextureRegion[][]TmpAnimation7 = TextureRegion.split(animationTexture7,animationTexture7.getWidth()/c7,animationTexture7.getHeight()/r7);
        TextureRegion[] FramesAnimation7 = new TextureRegion[c7 * r7];
        int index7 = 0;
        for(int i = 0; i < r7; i++)
        {
            for(int j = 0; j < c7; j++)
            {
                FramesAnimation7[index7++]=TmpAnimation7[i][j];
            }
        }
        animation7 = new Animation<TextureRegion>(0.2f,FramesAnimation7);
        /**************************/
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        setPosition(body.getPosition().x-(12/Pixels),body.getPosition().y);

        batch.draw(texture, getX(),getY(),getWidth(),getHeight());
        if(MyGdxGame.HojaAzul.getInteger("HojaAzulA1") != 7) {
            rectangle.set(getX(), getY(), getWidth(), getHeight());
        }
        if(rectangle.overlaps(Jugador.jugador)&&MyGdxGame.HojaAzul.getInteger("HojaAzul")==1)
        {
            if (Gdx.input.isKeyPressed(Input.Keys.BUTTON_A) || Jugador.SaltoUp) {
                MyGdxGame.HojaAzul.putInteger("HojaAzulA1",1);
                MyGdxGame.HojaAzul.flush();
                activarParticula = true;
                MyGdxGame.HojaAzul.putInteger("HojaAzul",2);
                MyGdxGame.HojaAzul.flush();
            }
        }


/*******animation2**********/

if(timeA2 >= 1) {
    if (rectangle.overlaps(Jugador.jugador) && MyGdxGame.HojaAzul.getInteger("HojaAzulA1") == 1 && MyGdxGame.Fertilizantes.getInteger("Fertilizantes") >= 9) {

        if (Gdx.input.isKeyPressed(Input.Keys.BUTTON_A) || Jugador.SaltoUp) {
            MyGdxGame.HojaAzul.putInteger("HojaAzulA1", 2);
            MyGdxGame.HojaAzul.flush();
            activarParticula = true;
            int fertilizantes = MyGdxGame.Fertilizantes.getInteger("Fertilizantes");
            fertilizantes -= 9;
            MyGdxGame.Fertilizantes.putInteger("Fertilizantes", fertilizantes);
            MyGdxGame.Fertilizantes.flush();

        }
    }
}
        /********animation 3********/
        if(timeA3 >= 1) {
            if (rectangle.overlaps(Jugador.jugador) && MyGdxGame.HojaAzul.getInteger("HojaAzulA1") == 2 && MyGdxGame.Fertilizantes.getInteger("Fertilizantes") >= 9) {

                if (Gdx.input.isKeyPressed(Input.Keys.BUTTON_A) || Jugador.SaltoUp) {
                    MyGdxGame.HojaAzul.putInteger("HojaAzulA1", 3);
                    MyGdxGame.HojaAzul.flush();
                    activarParticula = true;
                    int fertilizantes = MyGdxGame.Fertilizantes.getInteger("Fertilizantes");
                    fertilizantes -= 9;
                    MyGdxGame.Fertilizantes.putInteger("Fertilizantes", fertilizantes);
                    MyGdxGame.Fertilizantes.flush();
                }
            }
        }
        /****************/
        /********animation 3********/
        if(timeA4 >= 1) {
            if (rectangle.overlaps(Jugador.jugador) && MyGdxGame.HojaAzul.getInteger("HojaAzulA1") == 3 && MyGdxGame.Fertilizantes.getInteger("Fertilizantes") >= 9) {

                if (Gdx.input.isKeyPressed(Input.Keys.BUTTON_A) || Jugador.SaltoUp) {
                    MyGdxGame.HojaAzul.putInteger("HojaAzulA1", 4);
                    MyGdxGame.HojaAzul.flush();
                    activarParticula = true;
                    int fertilizantes = MyGdxGame.Fertilizantes.getInteger("Fertilizantes");
                    fertilizantes -= 9;
                    MyGdxGame.Fertilizantes.putInteger("Fertilizantes", fertilizantes);
                    MyGdxGame.Fertilizantes.flush();
                }
            }
        }
        /****************/
        /********animation 3********/
        if(timeA5 >= 1) {
            if (rectangle.overlaps(Jugador.jugador) && MyGdxGame.HojaAzul.getInteger("HojaAzulA1") == 4 && MyGdxGame.Fertilizantes.getInteger("Fertilizantes") >= 9) {

                if (Gdx.input.isKeyPressed(Input.Keys.BUTTON_A) || Jugador.SaltoUp) {
                    MyGdxGame.HojaAzul.putInteger("HojaAzulA1", 5);
                    MyGdxGame.HojaAzul.flush();
                    activarParticula = true;
                    int fertilizantes = MyGdxGame.Fertilizantes.getInteger("Fertilizantes");
                    fertilizantes -= 9;
                    MyGdxGame.Fertilizantes.putInteger("Fertilizantes", fertilizantes);
                    MyGdxGame.Fertilizantes.flush();
                }
            }
        }
        /****************/
        /********animation 3********/
        if(timeA6 >= 1) {
            if (rectangle.overlaps(Jugador.jugador) && MyGdxGame.HojaAzul.getInteger("HojaAzulA1") == 5 && MyGdxGame.Fertilizantes.getInteger("Fertilizantes") >= 9) {

                if (Gdx.input.isKeyPressed(Input.Keys.BUTTON_A) || Jugador.SaltoUp) {
                    MyGdxGame.HojaAzul.putInteger("HojaAzulA1", 6);
                    MyGdxGame.HojaAzul.flush();
                    activarParticula = true;
                    int fertilizantes = MyGdxGame.Fertilizantes.getInteger("Fertilizantes");
                    fertilizantes -= 9;
                    MyGdxGame.Fertilizantes.putInteger("Fertilizantes", fertilizantes);
                    MyGdxGame.Fertilizantes.flush();
                }
            }
        }
        /****************/
        /********animation 3********/
        if(timeA7 >= 1) {
            if (rectangle.overlaps(Jugador.jugador) && MyGdxGame.HojaAzul.getInteger("HojaAzulA1") == 6 && MyGdxGame.Fertilizantes.getInteger("Fertilizantes") >= 9) {

                if (Gdx.input.isKeyPressed(Input.Keys.BUTTON_A) || Jugador.SaltoUp) {
                    MyGdxGame.HojaAzul.putInteger("HojaAzulA1", 7);
                    MyGdxGame.HojaAzul.flush();
                    activarParticula = true;
                    int fertilizantes = MyGdxGame.Fertilizantes.getInteger("Fertilizantes");
                    fertilizantes -= 9;
                    MyGdxGame.Fertilizantes.putInteger("Fertilizantes", fertilizantes);
                    MyGdxGame.Fertilizantes.flush();
                }
            }
        }

        if(ArbolAzul.rectangle.overlaps(Jugador.jugador)&&MyGdxGame.HojaAzul.getInteger("HojaAzul")==1||ArbolAzul.rectangle.overlaps(Jugador.jugador)&&MyGdxGame.HojaAzul.getInteger("HojaAzulA1")==1||ArbolAzul.rectangle.overlaps(Jugador.jugador)&&MyGdxGame.HojaAzul.getInteger("HojaAzulA1")==2||rectangle.overlaps(Jugador.jugador)&&MyGdxGame.HojaAzul.getInteger("HojaAzulA1")==3||ArbolAzul.rectangle.overlaps(Jugador.jugador)&&MyGdxGame.HojaAzul.getInteger("HojaAzulA1")==4||ArbolAzul.rectangle.overlaps(Jugador.jugador)&&MyGdxGame.HojaAzul.getInteger("HojaAzulA1")==5||ArbolAzul.rectangle.overlaps(Jugador.jugador)&&MyGdxGame.HojaAzul.getInteger("HojaAzulA1")==6)
        {
          //  Gdx.app.log("Arbol azul","Tocando y siendo 3");
           Jugador.istouchTienda4 = true;

        }else
        {
            Jugador.istouchTienda4 = false;
        }
        animaciones(batch);

        if(activarParticula) {
            particula.draw(batch, tempo);

        }else
        {
            particula.reset();
            particula.scaleEffect(.4f/Pixels);
        }
    }

    public void animaciones(Batch batch)
    {
        switch (MyGdxGame.HojaAzul.getInteger("HojaAzulA1"))
        {
            case  1:
            {
                time1 += Gdx.graphics.getDeltaTime();
                TextureRegion current = animation1.getKeyFrame(time1 ,false);
                batch.draw(current,getX()-5f,getY(),10,16);
                if(animation1.isAnimationFinished(time1))
                {
                    timeA2 += 1* Gdx.graphics.getDeltaTime();
                }

                break;
            }
            case 2:
            {

                time2 += Gdx.graphics.getDeltaTime();
                TextureRegion current = animation2.getKeyFrame(time2 ,false);
                batch.draw(current,getX()-5f,getY(),10,16);
                if(animation2.isAnimationFinished(time2))
                {
                    timeA3 += 1*Gdx.graphics.getDeltaTime();
                }
                break;
            }
            case 3:
            {

                time3 += Gdx.graphics.getDeltaTime();
                TextureRegion current = animation3.getKeyFrame(time3 ,false);
                batch.draw(current,getX()-5f,getY(),10,16);
                if(animation3.isAnimationFinished(time3))
                {
                    timeA4 += 1*Gdx.graphics.getDeltaTime();

                }
                break;
            }
            case 4:
            {

                time4 += Gdx.graphics.getDeltaTime();
                TextureRegion current = animation4.getKeyFrame(time4 ,false);
                batch.draw(current,getX()-5f,getY(),10,16);
                if(animation4.isAnimationFinished(time4))
                {
                    timeA5 += 1*Gdx.graphics.getDeltaTime();
                }
                break;
            }
            case 5:
            {

                time5 += Gdx.graphics.getDeltaTime();
                TextureRegion current = animation5.getKeyFrame(time5 ,false);
                batch.draw(current,getX()-5f,getY(),10,16);
                if(animation5.isAnimationFinished(time5))
                {
                    timeA6 += 1*Gdx.graphics.getDeltaTime();
                }
                break;
            }
            case 6:
            {

                time6 += Gdx.graphics.getDeltaTime();
                TextureRegion current = animation6.getKeyFrame(time6 ,false);
                batch.draw(current,getX()-5f,getY(),10,16);
                if(animation6.isAnimationFinished(time6))
                {
                    timeA7 += 1*Gdx.graphics.getDeltaTime();
                }
                break;
            }
            case 7:
            {
                rectangle.set(0,0,0,0);
                time7 += Gdx.graphics.getDeltaTime();
                TextureRegion current = animation7.getKeyFrame(time7 ,false);
                batch.draw(current,getX()-5f,getY(),10,16);

                break;
            }
        }

    }

    @Override
    public void act(float delta) {
        if(activarParticula) {
            tempo = Gdx.graphics.getDeltaTime();
            timeiterator += .5f * Gdx.graphics.getDeltaTime();
            if( timeiterator > 1)
            {
                activarParticula = false;
                timeiterator = 0;
            }
        }
        particula.update(delta);

        particula.setPosition(getX()-.5f,getY()+.1f);

        if (MyGdxGame.HojaAzul.getInteger("HojaAzulA1") == 2) {
            if (body1.getPosition().y <= Jugador.body.getPosition().y - (8 / Pixels)) {
                body1.setActive(true);
            } else {
                body1.setActive(false);
            }

            if (body2.getPosition().y <= Jugador.body.getPosition().y - (8 / Pixels)) {
                body2.setActive(true);
            } else {
                body2.setActive(false);
            }
            body3.setActive(false);
            body4.setActive(false);
            body5.setActive(false);
            body6.setActive(false);
            body7.setActive(false);
        } else if (MyGdxGame.HojaAzul.getInteger("HojaAzulA1") == 3) {
            if (body1.getPosition().y <= Jugador.body.getPosition().y - (8 / Pixels)) {
                body1.setActive(true);
            } else {
                body1.setActive(false);
            }

            if (body2.getPosition().y <= Jugador.body.getPosition().y - (8 / Pixels)) {
                body2.setActive(true);
            } else {
                body2.setActive(false);
            }

            if (body3.getPosition().y <= Jugador.body.getPosition().y - (8 / Pixels)) {
                body3.setActive(true);
            } else {
                body3.setActive(false);
            }

            body4.setActive(false);
            body5.setActive(false);
            body6.setActive(false);
            body7.setActive(false);
        } else if (MyGdxGame.HojaAzul.getInteger("HojaAzulA1") == 4) {
            if (body1.getPosition().y <= Jugador.body.getPosition().y - (8 / Pixels)) {
                body1.setActive(true);
            } else {
                body1.setActive(false);
            }

            if (body2.getPosition().y <= Jugador.body.getPosition().y - (8 / Pixels)) {
                body2.setActive(true);
            } else {
                body2.setActive(false);
            }

            if (body3.getPosition().y <= Jugador.body.getPosition().y - (8 / Pixels)) {
                body3.setActive(true);
            } else {
                body3.setActive(false);
            }
            if (body4.getPosition().y <= Jugador.body.getPosition().y - (8 / Pixels)) {
                body4.setActive(true);
            } else {
                body4.setActive(false);
            }

            body5.setActive(false);
            body6.setActive(false);
            body7.setActive(false);
        } else if (MyGdxGame.HojaAzul.getInteger("HojaAzulA1") == 5) {
            if (body1.getPosition().y <= Jugador.body.getPosition().y - (8 / Pixels)) {
                body1.setActive(true);
            } else {
                body1.setActive(false);
            }

            if (body2.getPosition().y <= Jugador.body.getPosition().y - (8 / Pixels)) {
                body2.setActive(true);
            } else {
                body2.setActive(false);
            }

            if (body3.getPosition().y <= Jugador.body.getPosition().y - (8 / Pixels)) {
                body3.setActive(true);
            } else {
                body3.setActive(false);
            }
            if (body4.getPosition().y <= Jugador.body.getPosition().y - (8 / Pixels)) {
                body4.setActive(true);
            } else {
                body4.setActive(false);
            }
            if (body5.getPosition().y <= Jugador.body.getPosition().y - (8 / Pixels)) {
                body5.setActive(true);
            } else {
                body5.setActive(false);
            }

            body6.setActive(false);
            body7.setActive(false);
        } else if (MyGdxGame.HojaAzul.getInteger("HojaAzulA1") == 6) {
            if (body1.getPosition().y <= Jugador.body.getPosition().y - (8 / Pixels)) {
                body1.setActive(true);
            } else {
                body1.setActive(false);
            }

            if (body2.getPosition().y <= Jugador.body.getPosition().y - (8 / Pixels)) {
                body2.setActive(true);
            } else {
                body2.setActive(false);
            }

            if (body3.getPosition().y <= Jugador.body.getPosition().y - (8 / Pixels)) {
                body3.setActive(true);
            } else {
                body3.setActive(false);
            }
            if (body4.getPosition().y <= Jugador.body.getPosition().y - (8 / Pixels)) {
                body4.setActive(true);
            } else {
                body4.setActive(false);
            }
            if (body5.getPosition().y <= Jugador.body.getPosition().y - (8 / Pixels)) {
                body5.setActive(true);
            } else {
                body5.setActive(false);
            }
            if (body6.getPosition().y <= Jugador.body.getPosition().y - (8 / Pixels)) {
                body6.setActive(true);
            } else {
                body6.setActive(false);
            }

            body7.setActive(false);
        } else if (MyGdxGame.HojaAzul.getInteger("HojaAzulA1") == 7) {
            if (body1.getPosition().y <= Jugador.body.getPosition().y - (8 / Pixels)) {
                body1.setActive(true);
            } else {
                body1.setActive(false);
            }

            if (body2.getPosition().y <= Jugador.body.getPosition().y - (8 / Pixels)) {
                body2.setActive(true);
            } else {
                body2.setActive(false);
            }

            if (body3.getPosition().y <= Jugador.body.getPosition().y - (8 / Pixels)) {
                body3.setActive(true);
            } else {
                body3.setActive(false);
            }
            if (body4.getPosition().y <= Jugador.body.getPosition().y - (8 / Pixels)) {
                body4.setActive(true);
            } else {
                body4.setActive(false);
            }
            if (body5.getPosition().y <= Jugador.body.getPosition().y - (8 / Pixels)) {
                body5.setActive(true);
            } else {
                body5.setActive(false);
            }
            if (body6.getPosition().y <= Jugador.body.getPosition().y - (8 / Pixels)) {
                body6.setActive(true);
            } else {
                body6.setActive(false);
            }
            if (body7.getPosition().y <= Jugador.body.getPosition().y - (8 / Pixels)) {
                body7.setActive(true);
            } else {
                body7.setActive(false);
            }

        } else {
            body1.setActive(false);
            body2.setActive(false);
            body3.setActive(false);
            body4.setActive(false);
            body5.setActive(false);
            body6.setActive(false);
            body7.setActive(false);
        }
    }

    @Override
    public void dispose() {
        animationTexture1.dispose();
        animationTexture2.dispose();
        animationTexture3.dispose();
        animationTexture4.dispose();
        body.destroyFixture(fixture);
        world.destroyBody(body);
        body1.destroyFixture(fixture1);
        world.destroyBody(body1);
        body2.destroyFixture(fixture2);
        world.destroyBody(body2);
        body3.destroyFixture(fixture3);
        world.destroyBody(body3);
        body4.destroyFixture(fixture4);
        world.destroyBody(body4);
        body5.destroyFixture(fixture5);
        world.destroyBody(body5);
        body6.destroyFixture(fixture6);
        world.destroyBody(body6);
        body7.destroyFixture(fixture7);
        world.destroyBody(body7);
        particula.dispose();
    }
}
