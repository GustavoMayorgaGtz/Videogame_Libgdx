package com.mygdx.game.tiled;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.actors.Agua1;
import com.mygdx.game.actors.Agua2;
import com.mygdx.game.actors.Agua3;
import com.mygdx.game.actors.Agua4;
import com.mygdx.game.actors.Casa1;
import com.mygdx.game.actors.Casa2;
import com.mygdx.game.actors.Casa2Pisos;
import com.mygdx.game.actors.Casa2Pisos2;
import com.mygdx.game.actors.Maceta1_1;
import com.mygdx.game.actors.Maceta1_2;
import com.mygdx.game.actors.Maceta1_3;
import com.mygdx.game.actors.Maceta2_1;
import com.mygdx.game.actors.Maceta2_2;
import com.mygdx.game.actors.Maceta2_3;
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

    Casa2Pisos casa2Pisos1;
    Casa2Pisos2 casa2Pisos2;

    Casa1 casa1 = new Casa1();
    Casa2 casa2 = new Casa2();

    Maceta1_1 maceta1_1 = new Maceta1_1();
    Maceta1_2 maceta1_2 = new Maceta1_2();
    Maceta1_3 maceta1_3 = new Maceta1_3();

    Maceta2_1 maceta2_1 = new Maceta2_1();
    Maceta2_2 maceta2_2 = new Maceta2_2();
    Maceta2_3 maceta2_3 = new Maceta2_3();

    MenuBuild menuBuild;
    public addActors2(Stage stage)
    {
        casa2Pisos1 = new Casa2Pisos();
        stage.addActor(casa2Pisos1);
        casa2Pisos2 = new Casa2Pisos2();
        stage.addActor(casa2Pisos2);
        stage.addActor(casa1);
        stage.addActor(casa2);

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

        stage.addActor(maceta1_1);
        stage.addActor(maceta1_2);
        stage.addActor(maceta1_3);

        stage.addActor(maceta2_1);
        stage.addActor(maceta2_2);
        stage.addActor(maceta2_3);

           menuBuild = new MenuBuild();
        stage.addActor(menuBuild );


    }
}
