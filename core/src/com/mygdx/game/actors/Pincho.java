package com.mygdx.game.actors;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;

import static com.mygdx.game.MyGdxGame.Pixels;

public class Pincho extends Actor {
    private Texture texture;
    private Body body;
    private Fixture fixture;
    private World world;
    PolygonShape triangulos;


    public Pincho(World world, Texture texture,float x, float y)
    {
        this.world = world;
        this.texture = texture;

        BodyDef def = new BodyDef();
        def.position.set(x/Pixels, (y+0.5f)/Pixels);
        def.type = BodyDef.BodyType.DynamicBody;
        body = world.createBody(def);
        Vector2[] vertices = new Vector2[3];
        vertices[0] =  new Vector2(-0.25f,0f);
        vertices[1] =  new Vector2(0.25f,0f);
        vertices[2] =  new Vector2(0,0.25f);
        triangulos = new PolygonShape();
        triangulos.set(vertices);
        fixture = body.createFixture(triangulos,50);
        fixture.setUserData("spike");
        fixture.setFriction(1000);
        triangulos.dispose();

        setSize(12/Pixels,6/Pixels);

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        setPosition(body.getPosition().x-(6)/Pixels,body.getPosition().y);
        batch.draw(texture, getX(),getY(),getWidth(),getHeight());
    }

    public  void detach()
    {
        body.destroyFixture(fixture);
        world.destroyBody(body);
    }
}
