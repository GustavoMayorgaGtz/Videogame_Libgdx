package com.mygdx.game.tiled;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.actors.Button1;

public class EnemigoJump extends InteractiveTileObjectEnemies{
AddActors add;

    public EnemigoJump(World world, TiledMap map, Rectangle bounds, Texture WalkLeft, Texture WalkRight, Texture WalkLeft2, Texture WalkRight2,Texture uno,Texture dos,Texture tres,Texture cuatro,int iterator) {
        super(world, map, bounds,WalkLeft,WalkRight,WalkLeft2,WalkRight2,uno,dos,tres,cuatro,iterator);
        fixture.setUserData(this);
        isJump = true;

    }

    @Override
    public void Izquierda() {
        this.izquierda = false;
        this.derecha = true;
    }

    @Override
    public void Derecha() {
        this.izquierda = true;
        this.derecha = false;
    }

    @Override
    public void Death() {
   add.player.Muerto = true;

    }

    @Override
    public void reverse() {
        reverse = true;
    }

    @Override
    public void Morir() {
      //  AddResources.ScreenWhite = true;
        body.setActive(false);
    }


}
