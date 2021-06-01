package com.mygdx.game.tiled;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Menu;

public class Niveles extends InteractiveNiveles{
    public Niveles(Texture texture1, Texture texture2, Texture tres, Texture cuatro, Texture cinco, Rectangle bounds) {
        super(texture1, texture2,tres,cuatro,cinco,bounds);
        id= Menu.id;
        Menu.id++;
    }
}
