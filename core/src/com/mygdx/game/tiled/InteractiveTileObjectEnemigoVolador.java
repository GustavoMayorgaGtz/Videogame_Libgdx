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

import java.util.ArrayList;

import static com.mygdx.game.MyGdxGame.Pixels;

public abstract class InteractiveTileObjectEnemigoVolador extends Actor implements Disposable {
    protected World world;
    protected Rectangle bounds;
    protected Body body;
    BodyDef bdef  = new BodyDef();
    FixtureDef fdef = new FixtureDef();
    PolygonShape shape = new PolygonShape();
    boolean izquierda = true,derecha = false;
    protected Fixture fixture;
    float MaxVelX = 1f;
    float MinVelX = -1f;
    Texture Left,Right;
    int c1=1,r1=15;
    int c2=1, r2=15;
    int iterator;
    float time,time2;
    public static Rectangle Enemies;
    /*********Probar**********/
    Texture negro;
    Rectangle enemigo;
    Animation<TextureRegion> WalkLeftA,WalkRightA;
    public static ArrayList<Rectangle> r = new ArrayList<Rectangle>();
    int iterator2 = 0;
    Sound pop;

    public InteractiveTileObjectEnemigoVolador(World world, Rectangle bounds, Texture WalkLeft, Texture WalkRight, int iterator)    {
        this.world = world;
        this.bounds = bounds;
        bdef.type = BodyDef.BodyType.DynamicBody;
        bdef.position.set((bounds.getX() + bounds.getWidth()/2)/Pixels,( bounds.getY()+bounds.getHeight()/2)/Pixels);
        body = world.createBody(bdef);
        body.setActive(true);
        body.setGravityScale(0f);
        shape.setAsBox((bounds.getWidth()/2)/Pixels,(bounds.getHeight()/2)/Pixels);
        fdef.shape = shape;
        fixture = body.createFixture(fdef);
        EdgeShape LineaDeMuerte = new EdgeShape();
        LineaDeMuerte.set(new Vector2(bounds.getX(),bounds.getY()),new Vector2(bounds.getX()+bounds.getWidth(),bounds.getY()+bounds.getHeight()));
        fdef.shape = LineaDeMuerte;
        this.iterator = iterator;
        body.createFixture(fdef).setUserData("spike");
        shape.dispose();
        enemigo = new Rectangle();
        ////
        this.Left = WalkLeft;
        this.Right = WalkRight;

        negro = new Texture("White.png");


////////////////////////////////////////////////////////

            TextureRegion[][] LeftTmp = TextureRegion.split(Left, Left.getWidth() / c1, Left.getHeight() / r1);
            TextureRegion[] LeftFrames = new TextureRegion[c1 * r1];
            int index1 = 0;
            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c1; j++) {
                    LeftFrames[index1++] = LeftTmp[i][j];
                }
            }
            WalkLeftA = new Animation<TextureRegion>(0.3f, LeftFrames);
            ///////////////////////////////////

            TextureRegion[][] RightTmp = TextureRegion.split(Right, Right.getWidth() / c2, Right.getHeight() / r2);
            TextureRegion[] RightFrames = new TextureRegion[c2 * r2];
            int index2 = 0;
            for (int i = 0; i < r2; i++) {
                for (int j = 0; j < c2; j++) {
                    RightFrames[index2++] = RightTmp[i][j];
                }
            }
            WalkRightA = new Animation<TextureRegion>(0.3f, RightFrames);



        setSize((bounds.getWidth()+2)/Pixels,(bounds.getHeight()+2)/Pixels);
        setPosition(body.getPosition().x-(((bounds.getWidth()-1)/2)/Pixels),body.getPosition().y-((bounds.getHeight()/2)/Pixels));
        Enemies = new Rectangle();

        r.add( new Rectangle(getX(), getY(), getWidth(), getHeight()));
        pop = Gdx.audio.newSound(Gdx.files.internal("Pop.mp3"));
            }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        setPosition(body.getPosition().x - (((bounds.getWidth() - 1) / 2) / Pixels), body.getPosition().y - ((bounds.getHeight() / 2) / Pixels));
        if (body.isActive()) {
            TextureRegion WL = WalkLeftA.getKeyFrame(time, true);
            TextureRegion WR = WalkRightA.getKeyFrame(time, true);

                if (izquierda) {
                    batch.draw(WL, getX(), getY(), getWidth(), getHeight());
                }
                if (derecha) {
                    batch.draw(WR, getX(), getY(), getWidth(), getHeight());
                }

        } else {

            if (iterator2 == 0) {
                pop.play(.5f);
                iterator2++;
            }

        }

    }


    @Override
    public void act(float delta) {

        if(body.isActive()) {
            r.get(iterator).set(getX(), getY(), getWidth(), getHeight());
        }else
        {
            time2 += Gdx.graphics.getDeltaTime();
            r.get(iterator).set(0,0,1,1);
        }
        enemigo.set(getX(),getY(),getWidth(),getHeight());


            if(enemigo.overlaps(AddActors.player.espadaRec))
            {

                if(AddActors.player.Espadazo)
                {
                    AddResources.ScreenWhite = true;
                    body.setActive(false);

                }
            }

        time += Gdx.graphics.getDeltaTime();
        Movimientos();
      }

    public void Movimientos()
    {
            if (izquierda) {
                body.setLinearVelocity(-1f, 0);
            } else {
                derecha = true;
            }
            if (derecha) {
                body.setLinearVelocity(1f, 0);
            } else {
                izquierda = true;
            }
    }

    public abstract void Izquierda();
    public abstract  void Derecha();
    public abstract  void Death();






    @Override
    public void dispose() {
        negro.dispose();
        Right.dispose();
        Left.dispose();
        body.destroyFixture(fixture);
        world.destroyBody(body);
        pop.dispose();
    }

}
