package com.mygdx.game.tiled;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;

public class Nemesis1 extends InteractiveTileObjectNemesis1{
AddActors add;

    public Nemesis1(World world, TiledMap map, Rectangle bounds, Texture WalkLeft, Texture WalkRight, Texture AttackL, Texture AttackR, Texture DL, Texture DR,int iterator) {
        super(world, map, bounds,WalkLeft,WalkRight,AttackL,AttackR,DL,DR,iterator);

        fixture.setUserData(this);

    }


    @Override
    public void Death() {
   add.player.Muerto = true;
  // AddResources.ScreenWhite = true;
    }



}
