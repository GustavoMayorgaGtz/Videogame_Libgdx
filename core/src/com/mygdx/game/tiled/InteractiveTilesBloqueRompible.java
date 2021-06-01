package com.mygdx.game.tiled;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation;
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

public abstract class InteractiveTilesBloqueRompible extends Actor implements Disposable {
    World world;
   // protected Rectangle bounds;
    protected Body body;
    protected Fixture fixture;
    AddResources res;

    BodyDef bdef  = new BodyDef();
    FixtureDef fdef = new FixtureDef();
    PolygonShape shape = new PolygonShape();

    Texture staticb;
    Animation<TextureRegion> romper;
    int c = 1, r = 6;
    float time = 0;
    boolean rompio = false;
    int iterator;
    Rectangle p;
    public static ArrayList<Rectangle> bloques = new ArrayList<Rectangle>();
    public InteractiveTilesBloqueRompible(World world, Texture staticB, Texture Animation, int iterator,float x, float y)    {
        this.world = world;
        this.staticb = staticB;
        this.iterator = iterator;
        bdef.type = BodyDef.BodyType.KinematicBody;
        bdef.position.set((x+( (8/Pixels)/2)), y+ (8/Pixels)/2);
        body = world.createBody(bdef);
        body.setActive(true);

        EdgeShape Arriba = new EdgeShape();
        Arriba.set(new Vector2(-8/Pixels,9/Pixels),new Vector2(8/Pixels,9/Pixels));
        fdef.shape = Arriba;
        fdef.density= 0;
        fdef.friction = 0;
        body.createFixture(fdef).setUserData("PisoBase");
        shape.setAsBox(8/Pixels,8/Pixels);
        fdef.shape = shape;
        fixture = body.createFixture(fdef);
        fixture.setDensity(0);
        fixture.setFriction(0);
        fixture.setUserData("Bloquerompible");
        shape.dispose();

        /***************Animacion*********/
        TextureRegion[][] TmpBloque = TextureRegion.split(Animation,Animation.getWidth()/c, Animation.getHeight()/r);
        TextureRegion[] FramesBloques = new TextureRegion[c * r];
        int index = 0;
        for(int i  = 0 ; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                FramesBloques[index++] = TmpBloque[i][j];
            }
        }
        romper = new Animation<TextureRegion>(0.2f,FramesBloques);


        setSize((16)/Pixels,(16)/Pixels);
        setPosition(body.getPosition().x-((16/2)/Pixels),body.getPosition().y-((16/2)/Pixels));
        p = new Rectangle(getX(),getY(),getWidth(),getHeight());
        bloques.add(iterator,new Rectangle(getX(),getY(),getWidth(),getHeight()));
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        setPosition(body.getPosition().x-((16/2)/Pixels),body.getPosition().y-((16/2)/Pixels));

        if(!rompio)
        {
            batch.draw(staticb,getX(),getY(),getWidth(),getHeight());
        }else
        {

            TextureRegion current = romper.getKeyFrame(time,false);
            time += Gdx.graphics.getDeltaTime();
            batch.draw(current,getX(),getY(),getWidth(),getHeight());
        }

    }



    @Override
    public void act(float delta) {
        bloques.get(iterator).set(getX(),getY(),getWidth(),getHeight());

          if (bloques.get(iterator).overlaps(Jugador.espadaRec)) {
              if(Jugador.Espadazo) {
                  body.setActive(false);
                  rompio = true;
              }
          }

    }

    @Override
    public void dispose() {
        staticb.dispose();
        body.destroyFixture(fixture);
        world.destroyBody(body);
    }
}
