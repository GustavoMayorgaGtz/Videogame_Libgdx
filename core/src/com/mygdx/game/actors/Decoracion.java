package com.mygdx.game.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Decoracion extends Actor {
    private Body body,bodyLeft;
    private Texture texture;
    private World world;
    private Fixture fixture,fixLeft;
    private BodyDef def,defLeft;
    float width, height;

    public Decoracion(World world, Texture texture, float x, float y,float width, float height)
    {
        this.world = world;
        this.body = body;
        this.bodyLeft = bodyLeft;
        this.texture = texture;
        this.width = width;
        this.height = height;

        def = new BodyDef();
        def.position.set(x, y);
        def.fixedRotation = true;
        def.type = BodyDef.BodyType.StaticBody;

        body = world.createBody(def);
        body.setActive(false);
        PolygonShape box = new PolygonShape();
        box.setAsBox(width / 2, height/ 2);
        fixture = body.createFixture(box,20);
        fixture.setUserData("PisoBase");
        box.dispose();
/*
        defLeft = new BodyDef();
        defLeft.position.set(x-0.10f, y);
        defLeft.type = BodyDef.BodyType.DynamicBody;
        bodyLeft = world.createBody(defLeft);
        PolygonShape box1 = new PolygonShape();
        box1.setAsBox(1f, 1f);
        fixLeft = bodyLeft.createFixture(box1,20);
        fixLeft.setUserData("Techo");
        box1.dispose();
*/


        setSize(width, height);//3
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        setPosition(body.getPosition().x-(width/2),body.getPosition().y-(height/2));
        batch.draw(texture, getX(),getY(),getWidth(),getHeight());
    }

    public void detach()
    {

        body.destroyFixture(fixture);
        world.destroyBody(body);
        bodyLeft.destroyFixture(fixLeft);
        world.destroyBody(bodyLeft);

    }

}
