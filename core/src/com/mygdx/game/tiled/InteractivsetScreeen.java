package com.mygdx.game.tiled;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
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
import com.mygdx.game.Menu;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.actors.Fuego;
import com.mygdx.game.actors.Jugador;

import static com.mygdx.game.MyGdxGame.Pixels;

public abstract class InteractivsetScreeen extends Actor implements Disposable {

    BodyDef bdef  = new BodyDef();
    FixtureDef fdef = new FixtureDef();
    PolygonShape shape = new PolygonShape();
    protected Fixture fixture;
    Rectangle touch;
    protected Body body;
    protected World world;
    protected TiledMap map;
    protected Rectangle bounds;
    protected  boolean Send = false;

    public InteractivsetScreeen(World world,Rectangle bounds)    {
        this.world = world;
        this.bounds = bounds;
        bdef.type = BodyDef.BodyType.StaticBody;
        bdef.position.set((bounds.getX() + bounds.getWidth()/2)/Pixels,( bounds.getY()+bounds.getHeight()/2)/Pixels);
        body = world.createBody(bdef);

        shape.setAsBox((bounds.getWidth()/2)/Pixels,(bounds.getHeight()/2)/Pixels);
        fdef.shape = shape;
        fixture = body.createFixture(fdef);

        EdgeShape LineaDeMuerte = new EdgeShape();
        LineaDeMuerte.set(new Vector2(bounds.getX(),bounds.getY()),new Vector2(bounds.getX()+bounds.getWidth(),bounds.getY()+bounds.getHeight()));
        fdef.shape = LineaDeMuerte;
        body.createFixture(fdef).setUserData("Menu");
        shape.dispose();
        this.bounds = new Rectangle();

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {

    }

    @Override
    public void act(float delta)
    {
        if(Send) {
            AddActors.i = 0;
            int actualLevelcomplet = MyGdxGame.NivelisComplete.getInteger("Level");//esta variable me dice que nivel ya hice para saber si guardar o no la variable
            Gdx.app.log("NivelIsComplete", "equals: " + MyGdxGame.NivelisComplete.getInteger("Level"));
            if (actualLevelcomplet < AddResourcesOfMenu.SelectLevel) {
                switch (AddResourcesOfMenu.SelectLevel) {
                    case 1: {
                        MyGdxGame.NivelisComplete.putInteger("Level", 1);
                        MyGdxGame.NivelisComplete.flush();
                        break;
                    }
                    case 2: {
                        MyGdxGame.NivelisComplete.putInteger("Level", 2);
                        MyGdxGame.NivelisComplete.flush();
                        break;
                    }
                    case 3: {
                        MyGdxGame.NivelisComplete.putInteger("Level", 3);
                        MyGdxGame.NivelisComplete.flush();
                        break;
                    }
                    case 4: {
                        MyGdxGame.NivelisComplete.putInteger("Level", 4);
                        MyGdxGame.NivelisComplete.flush();
                        break;
                    }
                    case 5: {
                        MyGdxGame.NivelisComplete.putInteger("Level", 5);
                        MyGdxGame.NivelisComplete.flush();
                        break;
                    }
                    case 6: {
                        MyGdxGame.NivelisComplete.putInteger("Level", 6);
                        MyGdxGame.NivelisComplete.flush();
                        break;
                    }
                }
            }
            Menu.id = 1;
            InteractiveTileObjectEnemies.stop = true;
            try {
                Fuego.sound.setLooping(false);

                Fuego.sound.stop();
            }catch(Exception e)
            {
                Gdx.app.log("Error",e.getMessage());
            }

           /* int monedasActuales = MyGdxGame.coins.getInteger("Coins");
            monedasActuales = monedasActuales + MyGdxGame.CoinObjects;
            MyGdxGame.coins.putInteger("Coins", monedasActuales);
            MyGdxGame.coins.flush();
           */
            MyGdxGame.CoinObjects = 0;
            AddActors.button.activeCaja = false;
            AddActors.button2.isTouch2 = false;
            AddActors.game.setScreen(new Menu(AddActors.game));
            Send = false;
        }
    }

    public abstract void menuSend();



    @Override
    public void dispose() {

    }

}
