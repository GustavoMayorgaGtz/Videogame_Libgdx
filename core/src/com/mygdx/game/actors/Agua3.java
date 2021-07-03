package com.mygdx.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;

import static com.mygdx.game.MyGdxGame.Pixels;
import static com.mygdx.game.MyGdxGame.agua2;
import static com.mygdx.game.MyGdxGame.agua3;

public class Agua3 extends Actor implements Disposable {

    Rectangle Cuerpo;
    Texture agua;
    Animation<TextureRegion> AguaAnimation;
    int c = 1, r = 4;
    float x,y;
  //  public static ArrayList<Rectangle> rects;
    Texture b;
    float time;
    public Agua3()
    {
        Cuerpo = new Rectangle(x,y,32/ Pixels,32/Pixels);
      agua = new Texture("PozoDeAgua.png");
        TextureRegion[][] Frames = TextureRegion.split(agua,agua.getWidth()/c,agua.getHeight()/r);
        TextureRegion[] Tmp = new TextureRegion[c*r];
        int index = 0;
        for(int i = 0; i < r; i++)
        {
            for(int  j = 0; j < c ; j++)
            {
                Tmp[index++]= Frames[i][j];
            }
        }
        AguaAnimation = new Animation<TextureRegion>(0.2f,Tmp);

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {

      time += Gdx.graphics.getDeltaTime();
      TextureRegion awa = AguaAnimation.getKeyFrame(time,true);
        batch.draw(awa,x-(32/Pixels),y,32/Pixels,32/Pixels);
      for(Rectangle e: Tierra1.rects)
      {
        //  batch.draw(b, e.x,e.y,e.width,e.height);
          if(Jugador.jugador.overlaps(e)) {
              if (Gdx.input.isTouched()) {
                  agua3.putFloat("X", Jugador.body.getPosition().x);
                  agua3.flush();
                  agua3.putFloat("Y", (e.y +(5/Pixels)) - 32 / Pixels);
                  agua3.flush();
              }
          }
      }


    }

    @Override
    public void act(float delta) {

        x = agua3.getFloat("X");
        y = agua3.getFloat("Y");
        Cuerpo.set(x,y,32/ Pixels,32/Pixels);
    }

    @Override
    public void dispose() {
        agua.dispose();
        b.dispose();
    }
}
