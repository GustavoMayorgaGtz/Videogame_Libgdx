package com.mygdx.game.tiled;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;

import static com.mygdx.game.MyGdxGame.Pixels;
import static com.mygdx.game.tiled.AddActors.player;

public abstract class InteractiveTilePortal extends Actor implements Disposable {
    protected World world;
    protected TiledMap map;
    protected Rectangle bounds;
    protected Body body;
    BodyDef bdef  = new BodyDef();
    FixtureDef fdef = new FixtureDef();
    PolygonShape shape = new PolygonShape();
    protected Fixture fixture;

    /******/
    int c = 1, r = 8;
    Animation<TextureRegion> animation;
    float time;
    boolean isPortalActive = false;
    AddResources addr;
    boolean iterator3 = true;
    public static float wait;
    int iterator;
    public static int iterator2;
    /**********/

    public InteractiveTilePortal(World world, TiledMap map, Rectangle bounds,Texture texture)    {
        this.world = world;
        this.map = map;
        this.bounds = bounds;
        bdef.type = BodyDef.BodyType.DynamicBody;
        bdef.position.set((bounds.getX() + bounds.getWidth()/2)/Pixels,( bounds.getY()+bounds.getHeight()/2)/Pixels);
        body = world.createBody(bdef);
        body.setGravityScale(0.0f);
        shape.setAsBox((bounds.getWidth()/2)/Pixels,(bounds.getHeight()/2)/Pixels);
        fdef.shape = shape;
        fixture = body.createFixture(fdef);
        shape.dispose();
        setSize((bounds.getWidth()+2)/Pixels,(bounds.getHeight()+2)/Pixels);
        /*******/
        TextureRegion[][] frames = TextureRegion.split(texture,texture.getWidth()/c,texture.getHeight()/r);
        TextureRegion[] tmp= new TextureRegion[c * r];
        int index = 0;
        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                tmp[index++] = frames[i][j];
            }
        }
        animation = new Animation<TextureRegion>(0.1f,tmp);
        /*******/
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        TextureRegion portal = animation.getKeyFrame(time,true);
        setPosition(body.getPosition().x-(((bounds.getWidth()-1)/2)/Pixels),body.getPosition().y-((bounds.getHeight()/2)/Pixels));
        batch.draw (portal, getX(), getY(),  getWidth(), getHeight());
    }

    @Override
    public void act(float delta) {

        time += Gdx.graphics.getDeltaTime();
        if(isPortalActive)
        {
            wait += 1 *Gdx.graphics.getDeltaTime();

            /************/
            int random;
            random = (int)Math.random()*50+1;

            if(iterator3) {
                addr.cam.position.x = addr.cam.position.x + (random) / Pixels;
                addr.cam.position.y = addr.cam.position.y - (random) / Pixels;
                iterator3 = false;
            }else
            {
                addr.cam.position.x = addr.cam.position.x - (random) / Pixels;
                addr.cam.position.y = addr.cam.position.y + (random) / Pixels;
                iterator3 = true;
            }
            if(wait > 1) {

                    isPortalActive = false;
                   try {
                       Vector2 rect = new Vector2(AddActors.coordenadasPortal[iterator].x, AddActors.coordenadasPortal[iterator].y);
                       player.setTelePosition(rect.x, rect.y, true);
                       addr.ScreenWhite = true;
                          /*  Gdx.app.log("Key", "" + iterator2);
                            Gdx.app.log("Door", "" + iterator);*/
                       iterator2 = 0;
                   }catch(Exception e)
                   {
                       Vector2 rect = new Vector2(AddActors.coordenadasPortal[0].x, AddActors.coordenadasPortal[0].y);
                       player.setTelePosition(rect.x, rect.y, true);
                       addr.ScreenWhite = true;
                          /*  Gdx.app.log("Key", "" + iterator2);
                            Gdx.app.log("Door", "" + iterator);*/
                       iterator2 = 0;
                   }
                }
            }
            /*************/

    }

    public abstract void Sierra( );
    public abstract void PlataformaEnMovimiento();
    public abstract  void In();


    @Override
    public void dispose() {
        map.dispose();
        body.destroyFixture(fixture);
        world.destroyBody(body);
    }

}
