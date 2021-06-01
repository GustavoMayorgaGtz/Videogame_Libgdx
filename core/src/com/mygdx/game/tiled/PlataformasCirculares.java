package com.mygdx.game.tiled;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.joints.DistanceJoint;
import com.badlogic.gdx.physics.box2d.joints.DistanceJointDef;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Disposable;

import javax.xml.soap.Text;

import static com.mygdx.game.MyGdxGame.Pixels;

public abstract class PlataformasCirculares extends Actor implements Disposable {

    Sprite sprite;
    Texture punto,center;
    TextureRegion CenterRegion;
    private Body body,body1;
    private Texture texture;
    private World world;
    private Fixture fixture,fixture1;
    private BodyDef def,def1;
    private DistanceJointDef dfd;
    private DistanceJoint Distance;
    private float x,y;
    float FuerzaX = 1, FuerzaY = 1;
    boolean IzquierdaArriba,IzquierdaAbajo,DerechaAbajo,DerechaArriba;
    Vector2 position1;
    Vector2[] position = new Vector2[78];
   int iterator = 0;
   float time =0;
   float  timeBegin = 0;
   float rotacion;
   Vector2 position2,Size2;

    public PlataformasCirculares(World world, float x, float y, Texture plataforma, Texture Punto, Texture Center) {
        this.world = world;
        this.x = x;
        this.y = y;
        this.texture = plataforma;
        this.punto = Punto;
        this.center = Center;
        CenterRegion = new TextureRegion(center);
        def = new BodyDef();
        def.position.set(x / Pixels, y / Pixels);
        def.fixedRotation = true;
        def.type = BodyDef.BodyType.StaticBody;

        body = world.createBody(def);
        body.setActive(false);
        PolygonShape box = new PolygonShape();
        box.setAsBox(12/ Pixels, 6f / Pixels);
        fixture = body.createFixture(box, 1);
        fixture.setUserData("PisoBase");

        /*****////
        def1 = new BodyDef();
        def1.position.set((x + 10) / Pixels, (y - 20) / Pixels);
        def1.fixedRotation = true;
        def1.type = BodyDef.BodyType.KinematicBody;
        body1 = world.createBody(def1);
        PolygonShape boxB = new PolygonShape();
        boxB.setAsBox(24 / Pixels, 12f / Pixels);
        fixture1 = body1.createFixture(boxB, 1);
        fixture1.setFriction(50);
        fixture1.setUserData("PisoBase");
/*************/

        /*////////////////*/
        dfd = new DistanceJointDef();

        dfd.bodyB = body1;
        dfd.bodyA = body;
        dfd.length = 1.5f;
        dfd.dampingRatio = 1f;
        dfd.frequencyHz = 60;
        Distance = (DistanceJoint) world.createJoint(dfd);



        boxB.dispose();
        box.dispose();

        Size2 = new Vector2(24/Pixels,24/Pixels);
        setSize(48/Pixels, 24f/Pixels);//3
        position1 = new Vector2(body1.getPosition().x-(12f)/Pixels,body1.getPosition().y-(12f)/Pixels);
        sprite = new Sprite(punto);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
if(timeBegin > 2) {
    if (iterator <= 77) {
      //  Gdx.app.log("Iterator valor: ", "" + iterator);

        if (time > .1f) {
            position[iterator] = new Vector2(body1.getPosition());
            iterator++;
            time = 0;
        }
    } else {
        for (int i = 0; i < position.length; i++) {
            batch.draw(punto, position[i].x - 2.5f / Pixels, position[i].y - 5f / Pixels, 5 / Pixels, 5 / Pixels);
        }
    }
    batch.draw(CenterRegion,position2.x,position2.y,getOriginX()+(Size2.x/2), getOriginY()+(Size2.x/2), Size2.x,Size2.y
            ,getScaleX(), getScaleY(), rotacion);
    batch.draw(texture,position1.x,position1.y,getWidth(),getHeight());
}

    }

    @Override
    public void act(float delta) {
        rotacion += 100 * delta;
        if(rotacion >= 360)
        {
            rotacion = 0;
        }
        time = time + 1 * Gdx.graphics.getDeltaTime();
        timeBegin = timeBegin + 1 * Gdx.graphics.getDeltaTime();
        position1 = new Vector2(body1.getPosition().x-(24f)/Pixels,body1.getPosition().y-(12f)/Pixels);
        position2  = new Vector2(body.getPosition().x-(30f)/Pixels,body.getPosition().y-(3f)/Pixels);//Center
        ActBody1();
    }

    public void ActBody1()
    {
        body1.setLinearVelocity(FuerzaX, FuerzaY);
        if(FuerzaX >= 1 && FuerzaY >= 1)
        {
            DerechaArriba = true;
            IzquierdaArriba = false;
            IzquierdaAbajo = false;
            DerechaAbajo = false;
        }
        if(FuerzaX <= -1 && FuerzaY >= 1)
        {

            DerechaArriba = false;
            IzquierdaArriba = true;
            IzquierdaAbajo = false;
            DerechaAbajo = false;
        }
        if(FuerzaX <= -1 && FuerzaY <= -1)
        {

            DerechaArriba = false;
            IzquierdaArriba = false;
            IzquierdaAbajo = true;
            DerechaAbajo = false;
        }
        if(FuerzaX >= 1 && FuerzaY <= -1)
        {

            DerechaArriba = false;
            IzquierdaArriba = false;
            IzquierdaAbajo = false;
            DerechaAbajo = true;
        }
        /**************/
        if (DerechaArriba) {
            if (FuerzaX > -1) {
                FuerzaX = FuerzaX - 1 * Gdx.graphics.getDeltaTime();
            }
        }
        if(IzquierdaArriba)
        {
            if (FuerzaY > -1) {
                FuerzaY= FuerzaY - 1 * Gdx.graphics.getDeltaTime();
            }
        }
        if(IzquierdaAbajo)
        {
            if (FuerzaX < 1) {
                FuerzaX = FuerzaX + 1 * Gdx.graphics.getDeltaTime();
            }
        }
        if(DerechaAbajo)
        {
            if (FuerzaY < 1) {
                FuerzaY = FuerzaY +  1 * Gdx.graphics.getDeltaTime();
            }
        }
    }




    @Override
    public void dispose() {
        texture.dispose();
        punto.dispose();
        body.destroyFixture(fixture);
        body1.destroyFixture(fixture1);
        world.destroyBody(body);
        world.destroyBody(body1);
    }
}
