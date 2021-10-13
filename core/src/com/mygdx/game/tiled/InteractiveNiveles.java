package com.mygdx.game.tiled;

import com.badlogic.gdx.Gdx;
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
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.game.AldeaCinematica;
import com.mygdx.game.Menu;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Nivel0;
import com.mygdx.game.Nivel1;
import com.mygdx.game.Nivel2;
import com.mygdx.game.Nivel5;
import com.mygdx.game.Nivel6;
import com.mygdx.game.Nivel7;
import com.mygdx.game.Nivel8;
import com.mygdx.game.Nivel9;
import com.mygdx.game.Niveo1T;

import static com.mygdx.game.MyGdxGame.Pixels;
import static com.mygdx.game.tiled.AddActors.player;

public abstract class InteractiveNiveles extends Actor implements Disposable {

    Rectangle rect;
    Texture uno,dos,tres,cuatro,cinco,seis,siete,ocho;
    Texture white,black;
    Sprite Select;
    float X,Y;
    int id;

    public InteractiveNiveles(Texture uno,Texture dos,Texture tres, Texture cuatro, Texture cinco,Texture seis,Texture siete,Texture ocho,Rectangle bounds)    {
        this.uno = uno;
        this.dos = dos;
        this.tres = tres;
        this.cuatro = cuatro;
        this.cinco = cinco;
        this.seis = seis;
        this.siete = siete;
        this.ocho = ocho;

      setSize(bounds.getWidth()/Pixels,bounds.getHeight()/Pixels);
      this.X = bounds.getX();
      this.Y = bounds.getY();
      rect = new Rectangle();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        setPosition(X/Pixels,Y/Pixels);
        int levelComplete = MyGdxGame.NivelisComplete.getInteger("Level");
        switch(id)
        {

            case 1: {
                batch.draw(uno,getX(),getY(),getWidth(),getHeight()); break;
            }

            case 2: {
                if (levelComplete >= 1) {
                    batch.draw(dos, getX(), getY(), getWidth(), getHeight());
                }
                break;
            }
            case 3: {
                if (levelComplete >= 2) {
                    batch.draw(tres, getX(), getY(), getWidth(), getHeight());
                }
                break;
            }
            case 4: {
                if (levelComplete >= 3) {
                    batch.draw(cuatro, getX(), getY(), getWidth(), getHeight());
                }
                break;
            }
            case 5: {
                if (levelComplete >= 4) {
                    batch.draw(cinco, getX(), getY(), getWidth(), getHeight());
                }
                break;
            }
            case 6:{
                if (levelComplete >= 5) {
                    batch.draw(seis, getX(), getY(), getWidth(), getHeight());
                }
                break;
            }
            case 7:{
                if (levelComplete >= 6) {
                    batch.draw(siete, getX(), getY(), getWidth(), getHeight());
                }
                break;
            }
            case 8:{
                if (levelComplete >= 7) {
                    batch.draw(ocho, getX(), getY(), getWidth(), getHeight());
                }
                break;
            }
           /* default:
            {
                batch.draw(uno,getX(),getY(),getWidth(),getHeight()); break;
            }*/
        }


    }

    @Override
    public void act(float delta)
    {
        rect.set(getX(),getY(),getWidth(),getHeight());
        int levelComplete = MyGdxGame.NivelisComplete.getInteger("Level");
if(rect.overlaps(Menu.Puntero))
{
    Menu.X = X;
    Menu.Y = Y;
}
if(Menu.Puntero.overlaps(rect))
{
    AddResourcesOfMenu.SelectLevel = id;

        switch(AddResourcesOfMenu.SelectLevel)
        {
            case -2:
            {
                AddResources.ConfigurarCamara = 0;
                AddResourcesOfMenu.game.setScreen(new AldeaCinematica(AddResourcesOfMenu.game));
                MyGdxGame.isIsNivelProgress2 = false;
                break;
            }
            case 1:
            {
                AddResources.ConfigurarCamara = 0;
                AddResourcesOfMenu.game.setScreen(new Nivel0(AddResourcesOfMenu.game));
                MyGdxGame.isIsNivelProgress2 = false;
                break;
            }
            case 2:
            {
                if(levelComplete >= 1) {
                    AddResources.ConfigurarCamara = 0;
                    AddResourcesOfMenu.game.setScreen(new Nivel1(AddResourcesOfMenu.game));
                    MyGdxGame.isIsNivelProgress2 = false;
                }
                break;
            }
            case 3:
            {
                if(levelComplete >= 2) {
                    AddResources.ConfigurarCamara = 0;
                    AddResourcesOfMenu.game.setScreen(new Nivel2(AddResourcesOfMenu.game));
                    MyGdxGame.isIsNivelProgress2 = false;
                }
                break;
            }
            case 4:
            {
                if(levelComplete >= 3) {
                    AddResources.ConfigurarCamara = 0;
                    AddResourcesOfMenu.game.setScreen(new Nivel5(AddResourcesOfMenu.game));
                    MyGdxGame.isIsNivelProgress2 = false;
                }
                break;
            }
            case 5:
            {
                if(levelComplete >= 4) {
                    AddResources.ConfigurarCamara = 0;
                    AddResourcesOfMenu.game.setScreen(new Nivel6(AddResourcesOfMenu.game));
                    MyGdxGame.isIsNivelProgress2 = false;
                }
                break;
            }
            case 6:
            {
                if(levelComplete >= 5) {
                    AddResources.ConfigurarCamara = 0;
                    AddResourcesOfMenu.game.setScreen(new Nivel7(AddResourcesOfMenu.game));
                    MyGdxGame.isIsNivelProgress2 = false;
                }
                break;
            }
            case 7:
            {
                if(levelComplete >= 6) {
                    AddResources.ConfigurarCamara = 0;
                    AddResourcesOfMenu.game.setScreen(new Nivel8(AddResourcesOfMenu.game));
                    MyGdxGame.isIsNivelProgress2 = false;
                }
                break;
            }
            case 8:
            {
                if(levelComplete >= 7) {
                    AddResources.ConfigurarCamara = 0;
                    AddResourcesOfMenu.game.setScreen(new Nivel9(AddResourcesOfMenu.game));
                    MyGdxGame.isIsNivelProgress2 = false;
                }
                break;
            }
        }

}
    }



    @Override
    public void dispose() {
     uno.dispose();
     dos.dispose();
     tres.dispose();
     cuatro.dispose();
     cinco.dispose();
     seis.dispose();
    }

}
