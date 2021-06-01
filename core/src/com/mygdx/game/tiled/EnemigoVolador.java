package com.mygdx.game.tiled;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;

public class EnemigoVolador extends InteractiveTileObjectEnemigoVolador {

    public EnemigoVolador(World world, Rectangle bounds, Texture WalkLeft, Texture WalkRight, int iterator) {
        super(world, bounds, WalkLeft, WalkRight, iterator);
        fixture.setUserData(this);
    }

    @Override
    public void Izquierda() {
        this.izquierda = false;
        this.derecha = true;
        Gdx.app.log("Se Toco Izquirda","Izquierda");
    }

    @Override
    public void Derecha() {
        this.izquierda = true;
        this.derecha = false;
        Gdx.app.log("Se Toco Derecha","Derecha");
    }

    @Override
    public void Death() {
        AddActors.player.Muerto = true;
        Gdx.app.log("MUEREEEEEE","Muerete puto");
    }
}
