package com.mygdx.game.tiled;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.actors.Agua1;
import com.mygdx.game.actors.Agua2;
import com.mygdx.game.actors.Agua3;
import com.mygdx.game.actors.Agua4;
import com.mygdx.game.actors.MenuBuild;
import com.mygdx.game.actors.Tierra1;
import com.mygdx.game.actors.Tierra2;
import com.mygdx.game.actors.Tierra3;
import com.mygdx.game.actors.Tierra4;
import com.mygdx.game.actors.Tierra5;

public class addActors2 {
    Tierra1 tierra1;
    Tierra2 tierra2;
    Tierra3 tierra3;
    Tierra4 tierra4;
    Tierra5 tierra5;
    Agua1 agua1;
    Agua2 agua2;
    Agua3 agua3;
    Agua4 agua4;

    MenuBuild menuBuild;
    public addActors2(Stage stage)
    {
        tierra1 = new Tierra1();
        tierra2 = new Tierra2();
        tierra3 = new Tierra3();
        tierra4 = new Tierra4();
        tierra5 = new Tierra5();
        stage.addActor(tierra1);
        stage.addActor(tierra2);
        stage.addActor(tierra3);
        stage.addActor(tierra4);
        stage.addActor(tierra5);

        /********************************/

        agua1 = new Agua1();
        agua2 = new Agua2();
        agua3 = new Agua3();
        agua4 = new Agua4();

        stage.addActor(agua1);
        stage.addActor(agua2);
        stage.addActor(agua3);
        stage.addActor(agua4);
           menuBuild = new MenuBuild();
        stage.addActor(menuBuild );
    }
}
