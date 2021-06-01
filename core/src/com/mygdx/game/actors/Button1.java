package com.mygdx.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
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
import com.mygdx.game.tiled.EnemigoWalk;
import com.mygdx.game.tiled.InteractiveTileObjectCajas;
import com.mygdx.game.tiled.InteractiveTileObjectEnemies;

import static com.mygdx.game.MyGdxGame.Pixels;

public class Button1 extends Actor {
    protected World world;
    protected TiledMap map;
    protected Rectangle bounds;
    protected Body body;
    BodyDef def;
    FixtureDef fdef;
    protected Fixture fixture;
    Texture texture,texture2;
   public static boolean isTouch;
  public static  Rectangle rect;
  //  ShapeRenderer shape = null;
    float time;
    public static boolean active = false, activeCaja=false;
    int iterator = 0;
    Sound sound;
    boolean desactivarTime = false;
    float time2;

    public Button1(World world, Texture texture,Texture texture2, float x, float y)
    {
        this.world = world;
        this.texture = texture;
        this.texture2 = texture2;
        def = new BodyDef();
        def.position.set((x-(10/2))/Pixels,( y-(10/2))/Pixels);
        def.fixedRotation = true;
        def.type = BodyDef.BodyType.KinematicBody;
        body = world.createBody(def);
        PolygonShape box = new PolygonShape();
        box.setAsBox((10)/Pixels,(10)/Pixels);
        fixture = body.createFixture(box,1);
        fixture.setSensor(true);
        //fixture.getBody();
        fixture.setUserData("Button");
        box.dispose();
        rect = new Rectangle();
        setSize(20/Pixels, 20/Pixels);//3
    //    shape = new ShapeRenderer();
        sound = Gdx.audio.newSound(Gdx.files.internal("boton.mp3"));
    }

    @Override

    public void draw(Batch batch, float parentAlpha) {
        setPosition(body.getPosition().x-(10)/Pixels,body.getPosition().y-(10)/Pixels);

        if(isTouch)
        {
            if(iterator == 0) {
                sound.play();
                iterator++;
            }
            batch.draw(texture2,getX(),getY(),getWidth(),getHeight());
        }else
        {
            iterator = 0;
            batch.draw(texture,getX(),getY(),getWidth(),getHeight());
        }

    }

    @Override
    public void act(float delta) {
        if (rect.overlaps(Jugador.jugador)) {
            isTouch = true;
        } else {
            if (!active) {
                isTouch = false;
            } else {
                isTouch = true;
            }

            {
                for (Rectangle r : InteractiveTileObjectEnemies.r) {
                    if (r.overlaps(rect)) {
                        active = true;
                    }
                }
                for (Rectangle r : InteractiveTileObjectCajas.r) {
                    if (r.overlaps(rect)) {
                        activeCaja = true;
                        time2 = 0;
                    } else {
                        desactivarTime = true;
                    }
                }
                rect.set(getX(), getY(), getWidth(), getHeight() + .1f);
                if (!activeCaja) {
                    if (active) {
                        time += 1 * Gdx.graphics.getDeltaTime();
                    }
                    if (time >= 1.8f) {
                        active = false;
                        time = 0;
                    }

   /* if (rect.overlaps(Jugador.jugador)) {
        isTouch = true;

    } else {
        if (!active) {
            isTouch = false;
        } else {
            isTouch = true;
        }
    }*/
                } else {
                    isTouch = true;
                }
                if (desactivarTime) {
                    time2 += 1 * Gdx.graphics.getDeltaTime();
                    for (Rectangle r : InteractiveTileObjectCajas.r) {
                        if (r.overlaps(rect)) {
                            activeCaja = true;
                            desactivarTime = false;
                            time2 = 0;
                        } else {
                            if (time2 >= 2) {
                                isTouch = false;
                            }
                        }
                    }

                }
            }
        }
    }
    public void ButtonDetach()
    {
        sound.dispose();
        texture.dispose();
        texture2.dispose();
        body.destroyFixture(fixture);
        world.destroyBody(body);

    }
}
