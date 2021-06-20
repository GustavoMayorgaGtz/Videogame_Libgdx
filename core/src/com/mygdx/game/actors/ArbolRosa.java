package com.mygdx.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
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

public class ArbolRosa extends Actor implements Disposable{
    private Body body;
    private Texture texture;
    private World world;
    private Fixture fixture;
    private BodyDef def;
    public static Rectangle rectangle;

    private BodyDef def1,def2,def3;
    private Body body1,body2,body3;
    private Fixture fixture1, fixture2,fixture3;
    /**********Animation************/
    float timeA2;
    float timeA3;

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
    /******************************/

    Texture HojaAzul;
    Rectangle HojaAzulRec;
    int iteratorAzul = 0;
    public ArbolRosa(World world, Texture texture, float x, float y)
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

        /******Animation***********/
        animationTexture1 = new Texture("AnimationArbolR(1).png");
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
        animationTexture2 = new Texture("AnimationArbolR(2).png");
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
        animationTexture3 = new Texture("AnimationArbolR(3).png");
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
        HojaAzul = new Texture("HojaAzul.png");
        HojaAzulRec = new Rectangle();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        setPosition(body.getPosition().x-(12/Pixels),body.getPosition().y);
        if(iteratorAzul == 0&&   MyGdxGame.HojaAzul.getInteger("HojaAzul") < 1) {
            batch.draw(HojaAzul, getX() + 3, getY() + 6, 25 / Pixels, 25 / Pixels);
            HojaAzulRec.set(getX() + 3, getY() + 6, 25 / Pixels, 25 / Pixels);
            if (HojaAzulRec.overlaps(Jugador.jugador)) {
                MyGdxGame.HojaAzul.putInteger("HojaAzul", 1);
                MyGdxGame.HojaAzul.flush();
                iteratorAzul++;
            }

        }
        batch.draw(texture, getX(),getY(),getWidth(),getHeight());
        if(MyGdxGame.HojaRosa.getInteger("HojaRosaA1") != 3) {
            rectangle.set(getX(), getY(), getWidth(), getHeight());
        }
        if(rectangle.overlaps(Jugador.jugador)&&MyGdxGame.HojaRosa.getInteger("HojaRosa")==1)
        {

            if (Gdx.input.isKeyPressed(Input.Keys.BUTTON_A) || Jugador.SaltoUp) {
                MyGdxGame.HojaRosa.putInteger("HojaRosaA1",1);
                MyGdxGame.HojaRosa.flush();
                MyGdxGame.HojaRosa.putInteger("HojaRosa",2);
                MyGdxGame.HojaRosa.flush();
            }
        }
        if(rectangle.overlaps(Jugador.jugador)&&MyGdxGame.HojaRosa.getInteger("HojaRosa")==1||rectangle.overlaps(Jugador.jugador)&&MyGdxGame.HojaRosa.getInteger("HojaRosa")==2||rectangle.overlaps(Jugador.jugador)&&MyGdxGame.HojaRosa.getInteger("HojaRosa")==3)
        {
            Jugador.istouchTienda3 = true;
        }else
        {

            Jugador.istouchTienda3 = false;
        }

/*******animation2**********/

if(timeA2 >= 3) {
    if (rectangle.overlaps(Jugador.jugador) && MyGdxGame.HojaRosa.getInteger("HojaRosaA1") == 1 && MyGdxGame.Fertilizantes.getInteger("Fertilizantes") >= 9) {

        if (Gdx.input.isKeyPressed(Input.Keys.BUTTON_A) || Jugador.SaltoUp) {
            MyGdxGame.HojaRosa.putInteger("HojaRosaA1", 2);
            MyGdxGame.HojaRosa.flush();
            int fertilizantes = MyGdxGame.Fertilizantes.getInteger("Fertilizantes");
            fertilizantes -= 9;
            MyGdxGame.Fertilizantes.putInteger("Fertilizantes", fertilizantes);
            MyGdxGame.Fertilizantes.flush();

        }
    }
}
        /****************/
        if(timeA3 >= 3) {
            if (rectangle.overlaps(Jugador.jugador) && MyGdxGame.HojaRosa.getInteger("HojaRosaA1") == 2 && MyGdxGame.Fertilizantes.getInteger("Fertilizantes") >= 9) {

                if (Gdx.input.isKeyPressed(Input.Keys.BUTTON_A) || Jugador.SaltoUp) {
                    MyGdxGame.HojaRosa.putInteger("HojaRosaA1", 3);
                    MyGdxGame.HojaRosa.flush();
                    int fertilizantes = MyGdxGame.Fertilizantes.getInteger("Fertilizantes");
                    fertilizantes -= 9;
                    MyGdxGame.Fertilizantes.putInteger("Fertilizantes", fertilizantes);
                    MyGdxGame.Fertilizantes.flush();
                }
            }
        }
        /****************/

        if(ArbolRosa.rectangle.overlaps(Jugador.jugador)&&MyGdxGame.HojaRosa.getInteger("HojaRosa")==1||ArbolRosa.rectangle.overlaps(Jugador.jugador)&&MyGdxGame.HojaRosa.getInteger("HojaRosa")==2||ArbolRosa.rectangle.overlaps(Jugador.jugador)&&MyGdxGame.HojaRosa.getInteger("HojaRosa")==3)
        {
Jugador.istouchTienda3 = true;
        }else
        {
            Jugador.istouchTienda3 = false;
        }

        animaciones(batch);

    }

    public void animaciones(Batch batch)
    {
        switch (MyGdxGame.HojaRosa.getInteger("HojaRosaA1"))
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
                rectangle.set(0,0,0,0);
                time3 += Gdx.graphics.getDeltaTime();
                TextureRegion current = animation3.getKeyFrame(time3 ,false);
                batch.draw(current,getX()-5f,getY(),10,16);
                break;
            }
        }

    }

    @Override
    public void act(float delta) {
        if(MyGdxGame.HojaRosa.getInteger("HojaRosaA1") == 2) {
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
        }else if(MyGdxGame.HojaRosa.getInteger("HojaRosaA1") == 3) {
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
        }else {
            body1.setActive(false);
            body2.setActive(false);
            body3.setActive(false);

        }
    }

    @Override
    public void dispose() {
        animationTexture1.dispose();
        animationTexture2.dispose();
        animationTexture3.dispose();
        body.destroyFixture(fixture);
        world.destroyBody(body);
        body1.destroyFixture(fixture1);
        world.destroyBody(body1);
        body2.destroyFixture(fixture2);
        world.destroyBody(body2);
        body3.destroyFixture(fixture3);
        world.destroyBody(body3);
        HojaAzul.dispose();

    }
}
