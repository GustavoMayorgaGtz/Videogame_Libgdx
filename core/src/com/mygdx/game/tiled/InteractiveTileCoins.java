package com.mygdx.game.tiled;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.game.MyGdxGame;

import static com.mygdx.game.MyGdxGame.Pixels;
import static com.mygdx.game.tiled.AddActors.player;

public abstract class InteractiveTileCoins extends Actor implements Disposable {
    protected World world;
    protected TiledMap map;
    protected Rectangle bounds;
    protected Body body;
    BodyDef bdef  = new BodyDef();
    FixtureDef fdef = new FixtureDef();
    PolygonShape shape = new PolygonShape();
    private TextureRegion region;
    Texture texture;
    protected Fixture fixture;

    /************/
    int c = 1, r = 6;
    Animation<TextureRegion> animation;
    float time;
    boolean isCoinAcive = true;
    /**********/

    int iterator = 0;
    Sound coin;

    public InteractiveTileCoins(World world, TiledMap map, Rectangle bounds, Texture texture)    {
        this.world = world;
        this.map = map;
        this.bounds = bounds;
        region = new TextureRegion(texture);
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
        coin = Gdx.audio.newSound(Gdx.files.internal("coin.mp3"));
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        TextureRegion coin = animation.getKeyFrame(time,true);
        setPosition(body.getPosition().x-(((bounds.getWidth()-1)/2)/Pixels),body.getPosition().y-((bounds.getHeight()/2)/Pixels));
        if(isCoinAcive) {
            batch.draw(coin, getX(), getY(), getWidth(), getHeight());
        }
    }

    @Override
    public void act(float delta) {
        time += Gdx.graphics.getDeltaTime();
        if(!isCoinAcive)
        {

            if (MyGdxGame.coins.getInteger("Coins") < 999) {
                if (iterator == 0) {
                    int coins = MyGdxGame.coins.getInteger("Coins");
                    coins = coins + 1;
                    MyGdxGame.coins.putInteger("Coins", coins);
                    MyGdxGame.coins.flush();
                    coin.play(0.08f);
                    MyGdxGame.CoinObjects++;
                    //     MyGdxGame.coins.putInteger("Coins",1);
                    iterator++;
                }
            }
        }
    }

    public abstract void Coin();

    @Override
    public void dispose() {
        coin.dispose();
        map.dispose();
        body.destroyFixture(fixture);
        world.destroyBody(body);
    }

}
