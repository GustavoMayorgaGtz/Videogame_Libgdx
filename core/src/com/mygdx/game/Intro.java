package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Intro implements Screen
{

    OrthographicCamera camera;
    SpriteBatch batch;
    Animation<TextureRegion> Logo;
    Texture logo;
    int c = 2, r = 2;
    float state = 0f;
    Music intro;
    float time = 0;

    MyGdxGame game;
    public Intro(MyGdxGame game)
    {
        this.game = game;
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false,800,800*Gdx.graphics.getHeight()/Gdx.graphics.getWidth());
        intro = Gdx.audio.newMusic(Gdx.files.internal("Intro.ogg"));
        intro.play();
        logo = new Texture("Intro.png");
        TextureRegion[][]tmp = TextureRegion.split(logo,logo.getWidth()/c,logo.getHeight()/r);
        TextureRegion[]walkFrames = new TextureRegion[c * r];
        int index= 0;
        for(int i = 0; i < r; i++)
        {
            for(int j = 0;j < c; j++)
            {
                walkFrames[index++] = tmp[i][j];
            }
        }
        Logo = new Animation<TextureRegion>(0.1f,walkFrames);
    }


    @Override
    public void render(float p1)
    {
        MyGdxGame.Cinematica.putInteger("Cinematica",1);
        MyGdxGame.Cinematica.flush();
        state += Gdx.graphics.getDeltaTime();
        TextureRegion current = Logo.getKeyFrame(state,true);
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.draw(current,220,10,400,400);
        batch.end();
       
        //Control//
        time = time + Gdx.graphics.getDeltaTime();
        if(time >= 5)
        {
            intro.stop();
            game.setScreen(new Menu(game));
        }
    }

    @Override
    public void resize(int p1, int p2)
    {
        // TODO: Implement this method
    }

    @Override
    public void show()
    {
        // TODO: Implement this method
    }

    @Override
    public void hide()
    {
        // TODO: Implement this method
    }

    @Override
    public void pause()
    {
        // TODO: Implement this method
    }

    @Override
    public void resume()
    {
        // TODO: Implement this method
    }

    @Override
    public void dispose()
    {
        batch.dispose();
        logo.dispose();
        intro.dispose();
    }

}
