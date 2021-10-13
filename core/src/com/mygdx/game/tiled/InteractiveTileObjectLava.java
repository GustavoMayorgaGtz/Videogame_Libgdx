package com.mygdx.game.tiled;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
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
import com.mygdx.game.actors.Button1;
import com.mygdx.game.actors.Jugador;

import java.util.Random;

import static com.mygdx.game.MyGdxGame.Pixels;

public abstract class InteractiveTileObjectLava extends Actor implements Disposable {
    float time = 0;
    float x;
    Texture lava;
    Rectangle LavaR;
    public static float lavaX,lavaY;
    Animation<TextureRegion> lavaAnimation;
    int c1 = 1, r1 = 5;
    int iterator = 0;
    Rectangle bounds;
    float timeEmpezar = 0;
    Random r;
    public InteractiveTileObjectLava( Rectangle bounds)    {
        r = new Random();
        this.bounds = bounds;
        /**************************/
        lava = new Texture("LavaGrande.png");
        TextureRegion[][] TmpLava = TextureRegion.split(lava,lava.getWidth()/c1,lava.getHeight()/r1);
        TextureRegion[] FramesLava = new TextureRegion[c1 * r1];
        int index1 = 0;
        for (int i = 0; i < r1; i++)
        {
            for(int j = 0; j < c1; j++)
            {
                FramesLava[index1++] = TmpLava[i][j];
            }
        }
        lavaAnimation = new Animation<TextureRegion>(0.6f,FramesLava);
        LavaR = new Rectangle();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        time += Gdx.graphics.getDeltaTime();
        TextureRegion Lava = lavaAnimation.getKeyFrame(time,true);
        batch.draw(Lava,lavaX,lavaY-(75/Pixels),200/Pixels, 75/Pixels);
        batch.draw(Lava,lavaX-(200/Pixels),lavaY-(75/Pixels),200/Pixels, 75/Pixels);
        batch.draw(Lava,lavaX+(200/Pixels),lavaY-(75/Pixels),200/Pixels, 75/Pixels);
    }

    @Override
    public void act(float delta) {
        LavaR.set( Jugador.body.getPosition().x,lavaY-(75/Pixels),240/Pixels, 75/Pixels);

        timeEmpezar += 1*Gdx.graphics.getDeltaTime();
        if(!Jugador.Muerto&&timeEmpezar >= 5) {

            lavaY = lavaY + (40 / Pixels) * Gdx.graphics.getDeltaTime();
        }else if(timeEmpezar <= 5)
        {
            Gdx.input.vibrate(1000);
            int s = r.nextInt(2);
            Gdx.app.log("random",""+s);
            switch(s)
            {
                case 0:
                {
                    AddResources.cam.position.x -= .1f;
                    break;
                }
                case 1:
                {
                    AddResources.cam.position.x += .1f;
                    break;
                }
            }
        }
        if(iterator == 0)
        {
            AddResources.ConfigurarCamara = 0;
            lavaX = Jugador.body.getPosition().x;
            lavaY = bounds.y/Pixels;
            iterator++;
        }
        if(LavaR.overlaps(Jugador.jugador))
        {
            Jugador.Muerto = true;
        }
    }


    @Override
    public void dispose() {
    lava.dispose();
    }

}
