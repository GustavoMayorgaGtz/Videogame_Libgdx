package com.mygdx.game.tiled;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.World;

import javax.xml.soap.Text;

public class PlataformaCirucularObject extends PlataformasCirculares {
    public PlataformaCirucularObject(World world, float x, float y, Texture plataforma, Texture Punto, Texture Center) {
        super(world, x, y, plataforma, Punto,Center);
    }
}
