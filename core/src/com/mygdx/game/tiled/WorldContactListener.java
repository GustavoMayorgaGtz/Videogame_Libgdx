package com.mygdx.game.tiled;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;

public class WorldContactListener implements ContactListener {
    public static int name;
    public static int nameMov;
    AddActors add;
    // MyGdxGame game;
    AddResources addR;

    private boolean areCollided(Contact contact, Object userA, Object userB) {

            return (contact.getFixtureA().getUserData().equals(userA) && contact.getFixtureB().getUserData().equals(userB) ||
                    contact.getFixtureA().getUserData().equals(userB) && contact.getFixtureB().getUserData().equals(userA));

    }

    @Override
    public void beginContact(Contact contact) {
try {
    if (areCollided(contact, "spike", "Jugador") || areCollided(contact, "SierraL1", "Jugador") || areCollided(contact, "SierraL2", "Jugador") || areCollided(contact, "SierraL3", "Jugador") ||
            areCollided(contact, "SierraL4", "Jugador") || areCollided(contact, "SierraL5", "Jugador")) {
        // add.game.setScreen(new Niveo1T(add.game));
        add.player.Muerto = true;
    }

    if (areCollided(contact, "PisoBase", "Jugador")) {
        add.player.setSaltar(true);
        add.player.setSpiderLeft(false);
        add.player.setSpiderRight(false);
        addR.tocoPiso = true;

    }
    try {

        if (areCollided(contact, "CamaraY", "Jugador")) {
            AddResources.CamaraY = true;
        } else {
            AddResources.CamaraY = true;
        }
    }catch(Exception e)
    {

    }




    /***********/
    if (areCollided(contact, "PisoBaseMov", "Jugador")) {
        add.player.setSaltar(true);
    }
    if (areCollided(contact, "PisoTime", "Jugador")) {
        add.player.setSaltar(true);
    }

    Fixture fixA = contact.getFixtureA();
    Fixture fixB = contact.getFixtureB();
    ///////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////
    if (fixA.getUserData() == "SierraL1" || fixB.getUserData() == "SierraL1") {
        Fixture Sierra2 = fixA.getUserData() == "SierraL1" ? fixA : fixB;
        Fixture object2 = Sierra2 == fixA ? fixB : fixA;

        if (object2.getUserData() != null && InteractiveTileObject.class.isAssignableFrom(object2.getUserData().getClass())) {
            name = 0;
            ((InteractiveTileObject) object2.getUserData()).Sierra();
        }
    }
    //////////////////////////////////////////////
    if (fixA.getUserData() == "SierraL2" || fixB.getUserData() == "SierraL2") {
        Fixture Sierra2 = fixA.getUserData() == "SierraL2" ? fixA : fixB;
        Fixture object2 = Sierra2 == fixA ? fixB : fixA;

        if (object2.getUserData() != null && InteractiveTileObject.class.isAssignableFrom(object2.getUserData().getClass())) {
            name = 1;
            ((InteractiveTileObject) object2.getUserData()).Sierra();
        }
    }
    //////////////////////////////////////////////
    if (fixA.getUserData() == "SierraL3" || fixB.getUserData() == "SierraL3") {
        Fixture Sierra2 = fixA.getUserData() == "SierraL3" ? fixA : fixB;
        Fixture object2 = Sierra2 == fixA ? fixB : fixA;

        if (object2.getUserData() != null && InteractiveTileObject.class.isAssignableFrom(object2.getUserData().getClass())) {
            name = 2;
            ((InteractiveTileObject) object2.getUserData()).Sierra();
        }
    }
    ///////////////////////////////////////////////
    if (fixA.getUserData() == "SierraL4" || fixB.getUserData() == "SierraL4") {
        Fixture Sierra2 = fixA.getUserData() == "SierraL4" ? fixA : fixB;
        Fixture object2 = Sierra2 == fixA ? fixB : fixA;

        if (object2.getUserData() != null && InteractiveTileObject.class.isAssignableFrom(object2.getUserData().getClass())) {
            name = 3;
            ((InteractiveTileObject) object2.getUserData()).Sierra();
        }
    }
    ////////////////////////////////////////////////////////
    if (fixA.getUserData() == "SierraL5" || fixB.getUserData() == "SierraL5") {
        Fixture Sierra2 = fixA.getUserData() == "SierraL5" ? fixA : fixB;
        Fixture object2 = Sierra2 == fixA ? fixB : fixA;

        if (object2.getUserData() != null && InteractiveTileObject.class.isAssignableFrom(object2.getUserData().getClass())) {
            name = 4;
            ((InteractiveTileObject) object2.getUserData()).Sierra();
        }
    }
    ///////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////
    /******/
    if (fixA.getUserData() == "LD" || fixB.getUserData() == "LD") {
        Fixture Sierra2 = fixA.getUserData() == "LD" ? fixA : fixB;
        Fixture object2 = Sierra2 == fixA ? fixB : fixA;

        if (object2.getUserData() != null && InteractivePlataformaMov.class.isAssignableFrom(object2.getUserData().getClass())) {
            ((InteractivePlataformaMov) object2.getUserData()).setLD();
        }
    }
    if (fixA.getUserData() == "RD" || fixB.getUserData() == "RD") {
        Fixture Sierra2 = fixA.getUserData() == "RD" ? fixA : fixB;
        Fixture object2 = Sierra2 == fixA ? fixB : fixA;

        if (object2.getUserData() != null && InteractivePlataformaMov.class.isAssignableFrom(object2.getUserData().getClass())) {
            ((InteractivePlataformaMov) object2.getUserData()).setRD();
        }
    }
    if (fixA.getUserData() == "LU" || fixB.getUserData() == "LU") {
        Fixture Sierra2 = fixA.getUserData() == "LU" ? fixA : fixB;
        Fixture object2 = Sierra2 == fixA ? fixB : fixA;

        if (object2.getUserData() != null && InteractivePlataformaMov.class.isAssignableFrom(object2.getUserData().getClass())) {
            ((InteractivePlataformaMov) object2.getUserData()).setLU();
        }
    }
    if (fixA.getUserData() == "RU" || fixB.getUserData() == "RU") {
        Fixture Sierra2 = fixA.getUserData() == "RU" ? fixA : fixB;
        Fixture object2 = Sierra2 == fixA ? fixB : fixA;

        if (object2.getUserData() != null && InteractivePlataformaMov.class.isAssignableFrom(object2.getUserData().getClass())) {
            ((InteractivePlataformaMov) object2.getUserData()).setRU();
        }
    }
    /********/


    ///////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////
    if (fixA.getUserData() == "Jugador" || fixB.getUserData() == "Jugador") {
        Fixture Sierra2 = fixA.getUserData() == "Jugador" ? fixA : fixB;
        Fixture object2 = Sierra2 == fixA ? fixB : fixA;

        if (object2.getUserData() != null && InteractiveTilePortal.class.isAssignableFrom(object2.getUserData().getClass())) {
            ((InteractiveTilePortal) object2.getUserData()).In();
        }
    }
    ///////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////
    if (fixA.getUserData() == "Jugador" || fixB.getUserData() == "Jugador") {
        Fixture Sierra2 = fixA.getUserData() == "Jugador" ? fixA : fixB;
        Fixture object2 = Sierra2 == fixA ? fixB : fixA;

        if (object2.getUserData() != null && InteractivsetScreeen.class.isAssignableFrom(object2.getUserData().getClass())) {
            if(!add.player.Muerto)
            ((InteractivsetScreeen) object2.getUserData()).menuSend();
        }
    }

    ///////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////
    if (fixA.getUserData() == "Jugador" || fixB.getUserData() == "Jugador") {
        Fixture Sierra2 = fixA.getUserData() == "Jugador" ? fixA : fixB;
        Fixture object2 = Sierra2 == fixA ? fixB : fixA;

        if (object2.getUserData() != null && InteractiveTileCoins.class.isAssignableFrom(object2.getUserData().getClass())) {
            ((InteractiveTileCoins) object2.getUserData()).Coin();
        }
    }
    ///////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////
    if (fixA.getUserData() == "Jugador" || fixB.getUserData() == "Jugador") {
        Fixture Sierra2 = fixA.getUserData() == "Jugador" ? fixA : fixB;
        Fixture object2 = Sierra2 == fixA ? fixB : fixA;

        if (object2.getUserData() != null && InteractivePisoAgarradera.class.isAssignableFrom(object2.getUserData().getClass())) {
            add.player.setSaltar(true);
        }
    }


    ///////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////
    if (fixA.getUserData() == "Jugador" || fixB.getUserData() == "Jugador") {
        Fixture Sierra2 = fixA.getUserData() == "Jugador" ? fixA : fixB;
        Fixture object2 = Sierra2 == fixA ? fixB : fixA;

        if (object2.getUserData() != null && InteractiveTileObject3.class.isAssignableFrom(object2.getUserData().getClass())) {
            ((InteractiveTileObject3) object2.getUserData()).ParedED();
        }
    }
    ////////////////////////////////////
    if (fixA.getUserData() == "Jugador" || fixB.getUserData() == "Jugador") {
        Fixture Sierra2 = fixA.getUserData() == "Jugador" ? fixA : fixB;
        Fixture object2 = Sierra2 == fixA ? fixB : fixA;

        if (object2.getUserData() != null && InteractiveTileObject3.class.isAssignableFrom(object2.getUserData().getClass())) {
            ((InteractiveTileObject3) object2.getUserData()).ParedEI();
        }
    }
    ///////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////
    if (fixA.getUserData() == "Jugador" || fixB.getUserData() == "Jugador") {
        Fixture Sierra2 = fixA.getUserData() == "Jugador" ? fixA : fixB;
        Fixture object2 = Sierra2 == fixA ? fixB : fixA;

        if (object2.getUserData() != null && InteractiveParajo.class.isAssignableFrom(object2.getUserData().getClass())) {
            ((InteractiveParajo) object2.getUserData()).detectar();
        }
    }


    /////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////
    if (fixA.getUserData() == "Enemigo" || fixB.getUserData() == "Enemigo") {
        Fixture Sierra2 = fixA.getUserData() == "Enemigo" ? fixA : fixB;
        Fixture object2 = Sierra2 == fixA ? fixB : fixA;

        if (object2.getUserData() != null && InteractiveTileObjectEnemies.class.isAssignableFrom(object2.getUserData().getClass())) {
            ((InteractiveTileObjectEnemies) object2.getUserData()).reverse();
        }
    }
  /*  if (fixA.getUserData() == "spike" || fixB.getUserData() == "spike") {
        Fixture Sierra2 = fixA.getUserData() == "spike" ? fixA : fixB;
        Fixture object2 = Sierra2 == fixA ? fixB : fixA;

        if (object2.getUserData() != null && InteractiveTileObjectEnemies.class.isAssignableFrom(object2.getUserData().getClass())) {
            ((InteractiveTileObjectEnemies) object2.getUserData()).Morir();
        }
    }*/
    /////////////////////////////////////////////////////////////
    if (fixA.getUserData() == "Caja" || fixB.getUserData() == "Caja") {
        Fixture Sierra2 = fixA.getUserData() == "Caja" ? fixA : fixB;
        Fixture object2 = Sierra2 == fixA ? fixB : fixA;

        if (object2.getUserData() != null && InteractiveTileObjectEnemies.class.isAssignableFrom(object2.getUserData().getClass())) {
            ((InteractiveTileObjectEnemies) object2.getUserData()).reverse();
        }
    }
    /////////////////////////////////////////////////////////////
    if (fixA.getUserData() == "left" || fixB.getUserData() == "left") {
        Fixture Sierra2 = fixA.getUserData() == "left" ? fixA : fixB;
        Fixture object2 = Sierra2 == fixA ? fixB : fixA;

        if (object2.getUserData() != null && InteractiveTileObjectEnemies.class.isAssignableFrom(object2.getUserData().getClass())) {
            ((InteractiveTileObjectEnemies) object2.getUserData()).Izquierda();
        }
    }
    //////////////////////////////////////////
    if (fixA.getUserData() == "right" || fixB.getUserData() == "right") {
        Fixture Sierra2 = fixA.getUserData() == "right" ? fixA : fixB;
        Fixture object2 = Sierra2 == fixA ? fixB : fixA;

        if (object2.getUserData() != null && InteractiveTileObjectEnemies.class.isAssignableFrom(object2.getUserData().getClass())) {
            ((InteractiveTileObjectEnemies) object2.getUserData()).Derecha();
        }
    }
    //////////////////////////////////////////
    if (fixA.getUserData() == "Jugador" || fixB.getUserData() == "Jugador") {
        Fixture Sierra2 = fixA.getUserData() == "Jugador" ? fixA : fixB;
        Fixture object2 = Sierra2 == fixA ? fixB : fixA;

        if (object2.getUserData() != null && InteractiveTileObjectEnemies.class.isAssignableFrom(object2.getUserData().getClass())) {
            ((InteractiveTileObjectEnemies) object2.getUserData()).Death();
        }
    }
    if (fixA.getUserData() == "Jugador" || fixB.getUserData() == "Jugador") {
        Fixture Sierra2 = fixA.getUserData() == "Jugador" ? fixA : fixB;
        Fixture object2 = Sierra2 == fixA ? fixB : fixA;

        if (object2.getUserData() != null && InteractiveTileObjectNemesis1.class.isAssignableFrom(object2.getUserData().getClass())) {
            ((InteractiveTileObjectNemesis1) object2.getUserData()).Death();
        }
    }
    //////////////////////////////////////////enemigo volador
    if (fixA.getUserData() == "left" || fixB.getUserData() == "left") {
        Fixture Sierra2 = fixA.getUserData() == "left" ? fixA : fixB;
        Fixture object2 = Sierra2 == fixA ? fixB : fixA;

        if (object2.getUserData() != null && InteractiveTileObjectEnemigoVolador.class.isAssignableFrom(object2.getUserData().getClass())) {
            ((InteractiveTileObjectEnemigoVolador) object2.getUserData()).Izquierda();
        }
    }
    //////////////////////////////////////////
    if (fixA.getUserData() == "right" || fixB.getUserData() == "right") {
        Fixture Sierra2 = fixA.getUserData() == "right" ? fixA : fixB;
        Fixture object2 = Sierra2 == fixA ? fixB : fixA;

        if (object2.getUserData() != null && InteractiveTileObjectEnemigoVolador.class.isAssignableFrom(object2.getUserData().getClass())) {
            ((InteractiveTileObjectEnemigoVolador) object2.getUserData()).Derecha();
        }
    }
    //////////////////////////////////////////
    if (fixA.getUserData() == "Jugador" || fixB.getUserData() == "Jugador") {
        Fixture Sierra2 = fixA.getUserData() == "Jugador" ? fixA : fixB;
        Fixture object2 = Sierra2 == fixA ? fixB : fixA;

        if (object2.getUserData() != null && InteractiveTileObjectEnemigoVolador.class.isAssignableFrom(object2.getUserData().getClass())) {
            ((InteractiveTileObjectEnemigoVolador) object2.getUserData()).Death();
        }
    }



    /////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////
    if (fixA.getUserData() == "left" || fixB.getUserData() == "left") {
        Fixture Sierra2 = fixA.getUserData() == "left" ? fixA : fixB;
        Fixture object2 = Sierra2 == fixA ? fixB : fixA;

        if (object2.getUserData() != null && InteractiveAplastador.class.isAssignableFrom(object2.getUserData().getClass())) {
            ((InteractiveAplastador) object2.getUserData()).Abajo();
        }
    }
    //////////////////////////////////////////
    if (fixA.getUserData() == "right" || fixB.getUserData() == "right") {
        Fixture Sierra2 = fixA.getUserData() == "right" ? fixA : fixB;
        Fixture object2 = Sierra2 == fixA ? fixB : fixA;

        if (object2.getUserData() != null && InteractiveAplastador.class.isAssignableFrom(object2.getUserData().getClass())) {
            ((InteractiveAplastador) object2.getUserData()).Arriba();
        }
    }
    if (fixA.getUserData() == "PisoBase" || fixB.getUserData() == "PisoBase") {
        Fixture Sierra2 = fixA.getUserData() == "PisoBase" ? fixA : fixB;
        Fixture object2 = Sierra2 == fixA ? fixB : fixA;

        if (object2.getUserData() != null && InteractiveAplastador.class.isAssignableFrom(object2.getUserData().getClass())) {
            ((InteractiveAplastador) object2.getUserData()).Arriba();
        }
    }
    /////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////
    if (fixA.getUserData() == "Jugador" || fixB.getUserData() == "Jugador") {
        Fixture Sierra2 = fixA.getUserData() == "Jugador" ? fixA : fixB;
        Fixture object2 = Sierra2 == fixA ? fixB : fixA;

        if (object2.getUserData() != null && InteractivePinchos.class.isAssignableFrom(object2.getUserData().getClass())) {
            ((InteractivePinchos) object2.getUserData()).Abajo();
        }
    }
}catch(Exception e)
{

}
    }

    @Override
    public void endContact(Contact contact) {
       /* try {
    if (areCollided(contact, "PisoBase", "Jugador")) {

        addR.tocoPiso = false;

    }
}catch(Exception e)
{
    addR.tocoPiso = false;
}*/
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
