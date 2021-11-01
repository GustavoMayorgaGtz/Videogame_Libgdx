package com.mygdx.game.tiled;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
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
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.actors.Jugador;

import java.util.ArrayList;

import static com.mygdx.game.MyGdxGame.Pixels;

public abstract class CinematicaNPC extends Actor implements Disposable {
    protected World world;
    protected Rectangle bounds;
    protected Body body;
    BodyDef bdef  = new BodyDef();
    FixtureDef fdef = new FixtureDef();
    PolygonShape shape = new PolygonShape();

    protected Fixture fixture,fixture2;
    int iterator;

    Texture A1L,A1R,A2L,A2R,A3L,A3R,A4L,A4R;
    Animation<TextureRegion> A1LA,A1RA;
    Animation<TextureRegion> A2LA,A2RA;
    Animation<TextureRegion> A3LA,A3RA;
    Animation<TextureRegion> A4LA,A4RA;
    int c1_1= 1,r1_1 = 8;
    int c2_1 = 1,r2_1 = 8;

    int c1_2 = 1,r1_2 = 8;
    int c2_2 = 1,r2_2 = 8;

    int c1_3 = 1,r1_3 = 8;
    int c2_3= 1,r2_3 = 8;

    int c1_4 = 1,r1_4 = 8;
    int c2_4 = 1,r2_4 = 8;
    float time = 0;

    boolean Right = false,Left = true;

    public CinematicaNPC(World world, Rectangle bounds, Texture A1L, Texture A1R, Texture A2L, Texture A2R, Texture A3L, Texture A3R, Texture A4L, Texture A4R, int iterator)    {
        this.world = world;
        this.bounds = bounds;
        this.iterator = iterator;

        bdef.type = BodyDef.BodyType.KinematicBody;
        bdef.position.set((bounds.getX() + bounds.getWidth()/2)/Pixels,( bounds.getY()+bounds.getHeight()/2)/Pixels);
        body = world.createBody(bdef);
        body.setActive(true);
        shape.setAsBox((bounds.getWidth()/2)/Pixels,(bounds.getHeight()/2)/Pixels);
        fdef.shape = shape;
        fixture = body.createFixture(fdef);
        fixture.setSensor(true);
        fixture2 = body.createFixture(fdef);
        fixture2.setSensor(true);
        fixture2.setUserData("NPC");
        fixture.setDensity(0);
        fixture.setFriction(0);
        fixture.setRestitution(0);
        fixture2.setDensity(0);
        fixture2.setFriction(0);
        fixture2.setRestitution(0);
        EdgeShape LineaDeMuerte = new EdgeShape();
        LineaDeMuerte.set(new Vector2(bounds.getX(),bounds.getY()),new Vector2(bounds.getX()+bounds.getWidth(),bounds.getY()+bounds.getHeight()));
        fdef.shape = LineaDeMuerte;
        setSize((bounds.getWidth()+15)/Pixels,(bounds.getHeight())/Pixels);
     //   setPosition((body.getPosition().x+15)/Pixels,body.getPosition().y-((bounds.getHeight()/2)/Pixels));
        /*********************************/
         this.A1L = A1L;
         this.A2L = A2L;
         this.A3L = A3L;
         this.A4L = A4L;
         this.A1R = A1R;
         this.A2R = A2R;
         this.A3R = A3R;
         this.A4R = A4R;
         /*******************************/
         switch(iterator)
         {
             case 0:
             {
                 AldeanoListAnimation a = new AldeanoListAnimation();
                 A1LA = a.animation(A1L,c1_1,r1_1,A1LA);
                 A1RA = a.animation(A1R,c2_1,r2_1,A1RA);
                 break;
             }
             case 1:
             {
                 AldeanoListAnimation a = new AldeanoListAnimation();
                 A2LA =a.animation(A2L,c1_2,r1_2,A2LA);
                 A2RA = a.animation(A2R,c2_2,r2_2,A2RA);
                 break;
             }
             case 2:
             {
                 AldeanoListAnimation a = new AldeanoListAnimation();
                 A3LA = a.animation(A3L,c1_3,r1_3,A3LA);
                 A3RA = a.animation(A3R,c2_3,r2_3,A3RA);
                 break;
             }
             case 3:
             {
                 AldeanoListAnimation a = new AldeanoListAnimation();
                 A4LA = a.animation(A4L,c1_4,r1_4,A4LA);
                 A4RA = a.animation(A4R,c2_4,r2_4,A4RA);
                 break;
             }
         }


            }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        time += Gdx.graphics.getDeltaTime();
        setPosition(body.getPosition().x-((bounds.getWidth()/2)/Pixels),body.getPosition().y-((bounds.getHeight()/2)/Pixels));

        switch(iterator)
        {
            case 0:
            {
                TextureRegion right = A1RA.getKeyFrame(time,true);
                TextureRegion left = A1LA.getKeyFrame(time,true);
                if(Right) {
                    batch.draw(right, getX(), getY(), getWidth(), getHeight());
                }else {
                    batch.draw(left, getX(), getY(), getWidth(), getHeight());
                }
                break;
            }
            case 1:
            {
                TextureRegion right = A2RA.getKeyFrame(time,true);
                TextureRegion left = A2LA.getKeyFrame(time,true);
                if(Right) {
                    batch.draw(right, getX(), getY(), getWidth(), getHeight());
                }else {
                    batch.draw(left, getX(), getY(), getWidth(), getHeight());
                }
                break;
            }
            case 2:
            {
                TextureRegion right = A3RA.getKeyFrame(time,true);
                TextureRegion left = A3LA.getKeyFrame(time,true);
                if(Right) {
                    batch.draw(right, getX(), getY(), getWidth(), getHeight());
                }else {
                    batch.draw(left, getX(), getY(), getWidth(), getHeight());
                }
                break;
            }
            case 3:
            {
                TextureRegion right = A4RA.getKeyFrame(time,true);
                TextureRegion left = A4LA.getKeyFrame(time,true);
                if(Right) {
                    batch.draw(right, getX(), getY(), getWidth(), getHeight());
                }else {
                    batch.draw(left, getX(), getY(), getWidth(), getHeight());
                }
                break;
            }
        }

}

public abstract void Reverse();


    @Override
    public void act(float delta) {
          if(Right)
          {
              body.setLinearVelocity(.5f,0);
          }else
          {
              body.setLinearVelocity(-.5f,0);
          }
      }
    @Override
    public void dispose() {

        body.destroyFixture(fixture);
        body.destroyFixture(fixture2);
        world.destroyBody(body);
    }

}
