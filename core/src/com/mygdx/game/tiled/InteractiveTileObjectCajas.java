package com.mygdx.game.tiled;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
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
import com.mygdx.game.actors.Jugador;

import java.util.ArrayList;

import static com.mygdx.game.MyGdxGame.Pixels;
public abstract class InteractiveTileObjectCajas extends Actor implements  Disposable{
    protected Body body,bodyLeft;
    private Texture texture;
    private World world;
    protected Fixture fixture,fixLeft;
    private BodyDef def;
    private FixtureDef fdef;
    public static float maxV = .5f,minV = -.5f;
    Rectangle caja;
    Texture negro;
    public static float xbody,yboyd;
    public static ArrayList<Rectangle> r = new ArrayList<Rectangle>();
    int iterator;

    public InteractiveTileObjectCajas(World world, Texture texture, float x, float y,int iterator)
    {
        this.world = world;
        this.texture = texture;
        this.iterator = iterator;
        def = new BodyDef();
        def.position.set((x-(12/2))/Pixels,( y-(12/2))/Pixels);
        def.fixedRotation = true;
        def.type = BodyDef.BodyType.DynamicBody;
        body = world.createBody(def);

        PolygonShape box = new PolygonShape();
        box.setAsBox((12)/Pixels,(12)/Pixels);

        fdef = new FixtureDef();

        EdgeShape Arriba = new EdgeShape();
        Arriba.set(new Vector2(-11/Pixels,12/Pixels), new Vector2( 11/Pixels,12/Pixels));
        EdgeShape Abajo = new EdgeShape();
        Abajo.set(new Vector2(-11/Pixels,-13/Pixels), new Vector2( 11f/Pixels,-13/Pixels));
        fdef.shape = Abajo;
        fdef.density= 0;
        fdef.friction = 0;
        body.createFixture(fdef).setUserData("Abajo");
        fdef.shape = box;
        fdef.density= 0;
        fdef.friction = 0;
        body.createFixture(fdef).setUserData("Caja");
        fdef.shape = Arriba;
        fdef.density= 100/Pixels;
        body.createFixture(fdef).setUserData("PisoBase");


        box.dispose();
        setSize(24/Pixels, 24/Pixels);//3
        negro = new Texture("White.png");
        setPosition(body.getPosition().x-(12)/Pixels,body.getPosition().y-(12)/Pixels);
        r.add( new Rectangle(getX(), getY(), getWidth(), getHeight()));
        caja = new Rectangle(getX(),getY(),getWidth(),getHeight());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {

        batch.draw(texture, getX(),getY(),getWidth(),getHeight());
        caja.set(getX(),getY(),getWidth(),getHeight());
       // batch.draw(negro,r.get(iterator).getX(),r.get(iterator).getY(),r.get(iterator).getWidth(),r.get(iterator).getHeight());
    }

    @Override
    public void act(float delta) {
        setPosition(body.getPosition().x-(12)/Pixels,body.getPosition().y-(12)/Pixels);
xbody = body.getLinearVelocity().x;
        r.get(iterator).set(getX(), getY(), getWidth(), getHeight());
        float velocidad = body.getLinearVelocity().x;
        if(velocidad >= maxV)
        {
            body.setLinearVelocity(maxV,body.getLinearVelocity().y);
        }
        if(velocidad <= minV)
        {
            body.setLinearVelocity(minV,body.getLinearVelocity().y);
        }
        if(body.getLinearVelocity().x != 0) {
            if (!caja.overlaps(Jugador.jugador)) {
                body.setLinearVelocity(0, body.getLinearVelocity().y);
            }
           /* try{

                if(AddActors.button.rect.overlaps(caja))
                {
                    AddActors.button.activeCaja = true;
                }else
                {
                    AddActors.button.activeCaja = false;
                    AddActors.button.active = false;
                }

            }catch(Exception e){};*/
        }
        try{
            if(Cajas.xbody != 0) {
                if (caja.overlaps(Jugador.jugador)){

                    Jugador.isCajaTouch = true;
                }else
                {
                    Jugador.isCajaTouch = false;
                }
            }else {
                Jugador.isCajaTouch = false;
            }

        }catch(Exception e)
        {};

    }

    public abstract void mover();

    @Override
    public void dispose() {
        negro.dispose();
        body.destroyFixture(fixture);
        world.destroyBody(body);
        bodyLeft.destroyFixture(fixLeft);
        world.destroyBody(bodyLeft);
    }
}
