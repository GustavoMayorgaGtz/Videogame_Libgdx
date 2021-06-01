package com.mygdx.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.tiled.InteractiveTileObjectEnemies;

import static com.mygdx.game.MyGdxGame.Pixels;

public class Button2 extends Actor {
    protected World world;
    protected TiledMap map;
    protected Rectangle bounds;
    protected Body body;
    BodyDef def;
    protected Fixture fixture;
    Texture texture,texture2;
    public static boolean isTouch = true;
    public static  Rectangle rect;
    public static boolean active = false;
    int iterator = 0;
    Sound sound;

    public Button2(World world, Texture texture, Texture texture2, float x, float y)
    {

        this.world = world;
        this.texture = texture;
        this.texture2 = texture2;
        def = new BodyDef();
        def.position.set((x+(10/2))/Pixels,( y+(10/2))/Pixels);
        def.fixedRotation = true;
        def.type = BodyDef.BodyType.KinematicBody;
        body = world.createBody(def);
        PolygonShape box = new PolygonShape();
        box.setAsBox((10)/Pixels,(10)/Pixels);
        fixture = body.createFixture(box,1);
        fixture.setSensor(true);
        fixture.setUserData("Button2");
        box.dispose();
        rect = new Rectangle();
        setSize(20/Pixels, 20/Pixels);//3
        sound = Gdx.audio.newSound(Gdx.files.internal("boton.mp3"));
    }

    @Override

    public void draw(Batch batch, float parentAlpha) {
        setPosition(body.getPosition().x-(10)/Pixels,body.getPosition().y-(10)/Pixels);

        if(!isTouch)
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
//texture2 = off
    }

    @Override
    public void act(float delta) {

        rect.set(getX()+.3f,getY(),getWidth()-.3f,getHeight()+.1f);
    if (rect.overlaps(Jugador.jugador)) {
        isTouch = false;
    }
    if(!isTouch)
    {
        body.setActive(true);
    }else
    {
        body.setActive(false);
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
