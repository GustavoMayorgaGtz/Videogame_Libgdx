package com.mygdx.game.tiled;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
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
import com.mygdx.game.actors.Jugador;

import java.util.ArrayList;

import static com.mygdx.game.MyGdxGame.Pixels;

public abstract class InteractivePlataformaMov extends Actor implements Disposable {
    private Body body;

    private Texture texture;
    private World world;
    private float velocidad = 1.5f;
    private BodyDef def;
    public static FixtureDef fdef = new FixtureDef();
    Fixture fixture;
    protected boolean RD,LD,RU,LU;
    Rectangle cuerpo;
    public static ArrayList<Rectangle> r = new ArrayList<Rectangle>();
    int iterator;
    Texture white;

    public InteractivePlataformaMov(World world, Texture texture, float x, float y,int iterator)
    {
        this.world = world;
        this.body = body;
        this.texture = texture;
        this.iterator = iterator;
        def = new BodyDef();
        def.position.set((x-(24/2))/Pixels,( y-(6/2))/Pixels);
        def.fixedRotation = true;
        def.gravityScale = 0.0f;
        def.type = BodyDef.BodyType.KinematicBody;
        body = world.createBody(def);
        body.setGravityScale(0);
        PolygonShape box = new PolygonShape();
        box.setAsBox((24)/Pixels,(6)/Pixels);
        EdgeShape Arriba = new EdgeShape();
        Arriba.set(new Vector2(-23/Pixels,6.5f/Pixels), new Vector2( 24/Pixels,6.5f/Pixels));
        fdef.shape = Arriba;
        fdef.density = 1;
        fdef.friction = 00;//50
        body.createFixture(fdef).setUserData("PisoBase");
        fixture = body.createFixture(box,0);
        fixture.setFriction(0);
       // fixture.setUserData();
        box.dispose();
        setSize(48/Pixels, 12/Pixels);//3
        cuerpo = new Rectangle();
        setPosition(body.getPosition().x-(24)/Pixels,body.getPosition().y-(6)/Pixels);

        r.add(iterator, new Rectangle(getX(), getY(), getWidth(), getHeight()+50));
        white = new Texture("White.png");
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        setPosition(body.getPosition().x-(24)/Pixels,body.getPosition().y-(6)/Pixels);
        cuerpo.set(getX(), getY(),getWidth(),getHeight()+(10/Pixels));//+(10/Pixels) - (20/Pixels)
        batch.draw (texture, getX(), getY(),getWidth(),getHeight());
      /* if(Gdx.input.isTouched()) {
            batch.draw(white, r.get(iterator).getX(),r.get(iterator).getY(), r.get(iterator).getWidth(),r.get(iterator).getHeight());
        }*/
    }

    @Override
    public void act(float delta) {
        cuerpo.set(getX(), getY(),getWidth(),getHeight()+(10/Pixels));
        r.get(iterator).set(getX(), getY(), getWidth(), getHeight()+(10/Pixels));
        if (RD) {
            body.setLinearVelocity(new Vector2(-velocidad, 0));//Izquierda
            if (cuerpo.overlaps(Jugador.jugador)) {
                ////////////////////////////////////
                if (Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT) || Jugador.leftActive) {
                    if(Jugador.body.getLinearVelocity().x < -1.3f)
                    {
                        Jugador.body.setLinearVelocity(-1.3f,Jugador.body.getLinearVelocity().y);
                    }
                }
                /////////////////////////////////////////
                if (Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT) || Jugador.rightActive) {
                    Jugador.body.setLinearVelocity(Jugador.body.getLinearVelocity().x + 1.5f/*.2f*/, Jugador.body.getLinearVelocity().y);
                }
                /*******************************/
                if (!Jugador.Espadazo) {
                    if (Gdx.input.isKeyPressed(Input.Keys.BUTTON_B) || Jugador.AttackButton||Gdx.input.isKeyPressed(Input.Keys.BUTTON_B)) {

                        Jugador.body.setLinearVelocity( -velocidad, Jugador.body.getLinearVelocity().y);
                    } else {
                        Jugador.body.setLinearVelocity(Jugador.body.getLinearVelocity().x - velocidad, Jugador.body.getLinearVelocity().y);

                    }
                }
                /*********************************/
            }
        }
        if (LD) {

            body.setLinearVelocity(new Vector2(velocidad, 0));//Derecha
            if (cuerpo.overlaps(Jugador.jugador)) {
                ////////////////////////////////////////
                if (Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT) || Jugador.rightActive) {
                      if(Jugador.body.getLinearVelocity().x > 1.3f)
                      {
                          Jugador.body.setLinearVelocity(1.3f,Jugador.body.getLinearVelocity().y);
                      }
                }
                ////////////////////////////////////////
                if (Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT) || Jugador.leftActive) {

                    Jugador.body.setLinearVelocity(Jugador.body.getLinearVelocity().x - 1.5f/*.2f*/, Jugador.body.getLinearVelocity().y);
                }
                /******************************/
                if (!Jugador.Espadazo) {
                    if (Gdx.input.isKeyPressed(Input.Keys.BUTTON_B) || Jugador.AttackButton) {

                        Jugador.body.setLinearVelocity(velocidad, Jugador.body.getLinearVelocity().y);
                    } else {
                        Jugador.body.setLinearVelocity(Jugador.body.getLinearVelocity().x + velocidad, Jugador.body.getLinearVelocity().y);
                    }
                }
                /*********************************/
            }
        }
        if (LU) {
            body.setLinearVelocity(new Vector2(0,velocidad));//Izquierda

        }

        if (RU) {
            body.setLinearVelocity(new Vector2(0,-velocidad));//Derecha
        }

    }



    public abstract void setRD();
    public abstract void setLD();
    public abstract void setRU();
    public abstract void setLU();

    @Override
    public void dispose() {
        white.dispose();
    body.destroyFixture(fixture);
    world.destroyBody(body);
    }
}
