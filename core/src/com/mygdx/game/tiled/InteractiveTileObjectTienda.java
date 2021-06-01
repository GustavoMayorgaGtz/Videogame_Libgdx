package com.mygdx.game.tiled;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
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

public abstract class InteractiveTileObjectTienda extends Actor implements Disposable {
    protected World world;
    protected TiledMap map;
    protected Rectangle bounds;
    protected Body body;
    Rectangle TiendaRectangle;
    BodyDef bdef  = new BodyDef();
    FixtureDef fdef = new FixtureDef();
    PolygonShape shape = new PolygonShape();
    Animation<TextureRegion> Tienda;
    float time1;
    protected Fixture fixture,fixture2;

    int c1=1,r1=9;
    int iterator;
    Texture negro;
    Sound pop;

    /*************SONIDO 3D*************/
    private float volumen;
    public static boolean stop;
    private Music sound;
    float getMiddle;
    float getInicio;
    float getFin;
    float getPX;

    float pan;

    public InteractiveTileObjectTienda(World world, Rectangle bounds, Texture Animation)    {
        this.world = world;
        this.bounds = bounds;
        bdef.type = BodyDef.BodyType.DynamicBody;
        bdef.position.set((bounds.getX() + bounds.getWidth()/2)/Pixels,( bounds.getY()+bounds.getHeight()/2)/Pixels);
        body = world.createBody(bdef);

        shape.setAsBox((bounds.getWidth()/2)/Pixels,(bounds.getHeight()/2)/Pixels);
        fdef.shape = shape;
        fixture = body.createFixture(fdef);
        fixture.setUserData("Tienda");
        this.iterator = iterator;
        fixture.setSensor(true);

        shape.dispose();
        body.setGravityScale(0);


        negro = new Texture("White.png");
        sound = Gdx.audio.newMusic(Gdx.files.internal("Fuego.mp3"));
        sound.play();
        sound.setLooping(true);



////////////////////////////////////////////////////////

            TextureRegion[][] LeftTmp = TextureRegion.split(Animation, Animation.getWidth() / c1, Animation.getHeight() / r1);
            TextureRegion[] LeftFrames = new TextureRegion[c1 * r1];
            int index1 = 0;
            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c1; j++) {
                    LeftFrames[index1++] = LeftTmp[i][j];
                }
            }
            Tienda = new Animation<TextureRegion>(0.3f, LeftFrames);
            ///////////////////////////////////

        setSize((bounds.getWidth()+2)/Pixels,(bounds.getHeight()+2)/Pixels);
        TiendaRectangle = new Rectangle();
            }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        setPosition(body.getPosition().x-(((bounds.getWidth()-1)/2)/Pixels),body.getPosition().y-((bounds.getHeight()/2)/Pixels));
        TextureRegion current = Tienda.getKeyFrame(time1 , true);
        batch.draw(current,getX(),getY(),getWidth(),getHeight());

}



    @Override
    public void act(float delta) {


        TiendaRectangle.set(getX(),getY(),getWidth(),getHeight());
       time1 += Gdx.graphics.getDeltaTime();
       sonido();
       if(Jugador.jugador.overlaps(TiendaRectangle))
       {
            Jugador.istouchTienda = true;
       }else
       {
           Jugador.istouchTienda = false;
       }
     }

     public void sonido()
     {
         if(stop||!body.isActive())
         {
             sound.setLooping(false);
             sound.stop();
         }
         getInicio = body.getPosition().x-3-(5/Pixels);
         getMiddle = body.getPosition().x-(5/Pixels);
         getFin = body.getPosition().x+3-(5/Pixels);
         getPX = Jugador.body.getPosition().x;
         if(getPX > getInicio && getPX < getFin) {
             if (getPX < getMiddle&&getPX >= getInicio) {
                 float width1 = getMiddle - getInicio;
                 float width2 = getMiddle - getPX;
                 pan = (width2 * 100) / width1;
                 pan = pan / 100;
                 if(pan > .5f)
                 {
                     volumen = 0.3f;
                 }else
                 {
                     volumen = 0.8f;
                 }
             }
             if (getPX > getMiddle && getPX <= getFin) {
                 float width1 = getFin - getMiddle;
                 float width2 = getFin - getPX;
                 pan = (width2 * 100) / width1;
                 pan = pan / 100;
                 pan = 1 - pan;
                 pan = pan * -1;
if(pan < -.8f)
{
    pan = -.8f;
}
                 if(pan < -.5f)
                 {
                     volumen = 0.3f;
                 }else
                 {
                     volumen = 0.8f;
                 }
             }

             sound.setPan(pan,volumen);

         }else
         {
         volumen = 0;
             sound.setVolume(volumen);
         }


     }

    @Override
    public void dispose() {
        negro.dispose();
        map.dispose();
        body.destroyFixture(fixture);
        body.destroyFixture(fixture2);
        world.destroyBody(body);
        pop.dispose();
    }

}
