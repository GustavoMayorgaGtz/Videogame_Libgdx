package com.mygdx.game.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;

import static com.mygdx.game.MyGdxGame.Pixels;

public class Sierra3 extends Actor {
    private Body body;
    private TextureRegion region;
    private Texture texture;
    private Sprite sprite;
    private World world;
    public static Fixture fixture;
    private BodyDef def;
private float velocidad = 0.8f;
    private boolean RD,RU=true,LU,LD;
    private float rotacion = 0f;
    public static Rectangle r;

    public Sierra3(World world, Texture texture, float x, float y)
    {
        this.world = world;
        this.body = body;

       // this.texture = texture;
        region = new TextureRegion(texture);
        def = new BodyDef();
        def.position.set((x-(12/2))/Pixels,( y-(12/2))/Pixels);
        def.fixedRotation = true;
        def.gravityScale = 0.0f;
        def.type = BodyDef.BodyType.DynamicBody;
        body = world.createBody(def);
        body.setGravityScale(0);
        PolygonShape box = new PolygonShape();
       // box.setRadius(6/Pixels);
        box.setAsBox((12)/Pixels,(12)/Pixels);


        fixture = body.createFixture(box,1);
        fixture.setUserData("SierraL3");
        fixture.setSensor(true);
        box.dispose();


        setSize(24/Pixels, 24/Pixels);//3


    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        setPosition(body.getPosition().x-(12)/Pixels,body.getPosition().y-(12)/Pixels);
        batch.draw (region, getX(), getY(), getOriginX()+(getWidth()/2), getOriginY()+(getWidth()/2), getWidth(), getHeight(),
        getScaleX(), getScaleY(), rotacion);

    }

    @Override
    public void act(float delta) {
contacto();
            rotacion += 100 * delta;
            if(rotacion >= 360)
            {
                rotacion = 0;
            }

   //     body.setLinearVelocity(new Vector2(0,-.1f));//abajo

        if (RD) {
            body.setLinearVelocity(new Vector2(0,velocidad));//arriba
        }
        if (RU) {
            body.setLinearVelocity(new Vector2(-velocidad,0));//izquierda
        }
        if (LD) {
            body.setLinearVelocity(new Vector2(velocidad,0));//derecha

        }
        if (LU) {
            body.setLinearVelocity(new Vector2(0,-velocidad));//abajo

        }
    }
    public void contacto()
    {
       r = new Rectangle(getX(),getY(),getWidth(),getHeight());
        r.setX(getX());
        r.setY(getY());
        r.setWidth(getWidth());
        r.setHeight(getHeight());

    }

    public void setRU(boolean RU)
    {
        this.RU=RU;
        RD = false;
        LD = false;
        LU = false;
    }
    public void setRD(boolean RD)
    {
        this.RD=RD;
        RU = false;
        LD = false;
        LU = false;
    }
    public void setLD(boolean LD)
    {
        this.LD=LD;
        RU = false;
        RD = false;
        LU = false;
    }
    public void setLU(boolean LU)
    {
        this.LU=LU;
        RU = false;
        LD = false;
        RD = false;
    }

    public void detach()
    {
        body.destroyFixture(fixture);
        world.destroyBody(body);
    }

}


