package com.mygdx.game.tiled;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;

import org.omg.CORBA.PolicyOperations;

import static com.mygdx.game.MyGdxGame.Pixels;

public abstract class InteractivePinchos extends Actor implements Disposable {

    protected World world;
    protected TiledMap map;
    protected Rectangle bounds;
    protected Body body;
    FixtureDef fdef = new FixtureDef();
    PolygonShape shape = new PolygonShape();
    boolean abajo = false;
    protected Fixture fixture;
    float MaxVelX = 1f;
    float MinVelX = -1f;
    Texture texture;


    public InteractivePinchos(World world, Rectangle bounds, Texture texture)    {
        this.world = world;
        this.map = map;
        this.bounds = bounds;
        this.texture = texture;
        BodyDef def = new BodyDef();
        def.position.set(bounds.getX()/Pixels, (bounds.getY()+0.5f)/Pixels);
        def.type = BodyDef.BodyType.KinematicBody;
        body = world.createBody(def);
        body.setGravityScale(0.0f);
        Vector2[] vertices = new Vector2[3];
        vertices[0] =  new Vector2(-0.25f,0f);
        vertices[1] =  new Vector2(0.25f,0f);
        vertices[2] =  new Vector2(0,-0.25f);
       PolygonShape triangulos= new PolygonShape();
        triangulos.set(vertices);
       // fixture = body.createFixture(triangulos,50);
      //fixture.setUserData("spike");
        //fixture.setFriction(1000);

        fdef.shape = triangulos;
        fdef.isSensor = true;
        body.createFixture(fdef).setUserData("spike");
        PolygonShape LineaDetection = new PolygonShape();
        Vector2[] verticesDetection = new Vector2[5];
        verticesDetection[0] =  new Vector2(-0.25f,0f);
        verticesDetection[1] =  new Vector2(-0.25f,-3f);
        verticesDetection[2] =  new Vector2(0.25f,-3f);
        verticesDetection[3] =  new Vector2(0.25f,0f);
        verticesDetection[4] =  new Vector2(-0.25f,0f);
        LineaDetection.set(verticesDetection);
        fdef.shape = LineaDetection;
        fdef.isSensor = true;
        body.createFixture(fdef).setUserData("spikeDetector");
        fixture = body.createFixture(fdef);
        shape.dispose();
        triangulos.dispose();
        ////
        ////////////////////////////////
        setSize(12/Pixels,6/Pixels);

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        setPosition(body.getPosition().x-(6)/Pixels,body.getPosition().y-6/Pixels);
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
}

    @Override public void act(float delta) {
       Movimientos();

    }

    public void Movimientos()
    {
        if (abajo) {
            body.setLinearVelocity(0,-2f);
            }
    }


    public abstract  void Abajo();
    public abstract  void Death();


    @Override
    public void dispose() {
        texture.dispose();
        map.dispose();
        body.destroyFixture(fixture);
        world.destroyBody(body);
    }

}
