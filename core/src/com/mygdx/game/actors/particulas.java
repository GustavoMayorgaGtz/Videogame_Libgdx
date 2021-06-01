package com.mygdx.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;

import static com.mygdx.game.MyGdxGame.Pixels;

public class particulas extends Actor{
    private float x, y;
    private float scale;
    private ParticleEffect p;
    private float tempo;

    public particulas(String locatioParticule, String locationImages, float x, float y, float scale)
    {
        this.x = x;
        this.y = y;
        this.scale = scale;
        p = new ParticleEffect();
        p.load(Gdx.files.internal(locatioParticule),Gdx.files.internal(locationImages));
        p.setPosition(x/Pixels,y/Pixels);
        p.scaleEffect(scale/Pixels);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        tempo = Gdx.graphics.getDeltaTime();
        p.draw(batch,tempo);
    }

    public void detachParticule()
    {
        p.dispose();
    }
}
