package com.mygdx.game.tiled;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import com.mygdx.game.Casa;
import com.mygdx.game.MyGdxGame;

import box2dLight.RayHandler;

import static com.mygdx.game.MyGdxGame.Pixels;

public class Configuraciones implements Screen {
    MyGdxGame game;

    public SpriteBatch batch;

    public static OrthographicCamera cam;
    public static Stage stage;
    Rectangle Puntero;
    public static World world;
    private Viewport viewport;
    private RayHandler ray;
    Sprite Blanco;
    Texture blanco;
    Rectangle ControlColorR;
    Rectangle MuteR;
    boolean isMute;
    Texture MuteNo,MuteYes,ControlColor;
    float time;
    Texture equis;
    Rectangle Equis;

    Texture BlancoColor,Rojo,Azul,Verde,Amarillo,Morado;
    Sprite B,R,Az,Am,V,M;
    Rectangle BlancoR,RojoR,AzulR,VerdeR,AmarilloR,MoradoR;
    boolean isCuadroColor = false;
    float alpha;

    Texture trans,checkno,checkyes,grade;
    Rectangle bajo,medio,alto;
    boolean isSoft,isMedium,isStrong;

    public Configuraciones(MyGdxGame game)
    {
        this.game = game;
        batch = new SpriteBatch();
        ray = new RayHandler(world);
        ray.setAmbientLight(1f);
        cam = new OrthographicCamera();
        viewport = new FitViewport(500 / Pixels, 250 / Pixels, cam);//240,140
        stage = new Stage(viewport, batch);//65
        Puntero = new Rectangle();
        MuteNo = new Texture("MuteNo.png");
        MuteYes = new Texture("MuteYes.png");
        ControlColor = new Texture("ControlColor.png");
        blanco = new Texture("Blanco.png");
        Blanco = new Sprite(blanco);
        ControlColorR = new Rectangle();
        MuteR = new Rectangle();
        equis = new Texture("equis.png");
        Equis = new Rectangle();
        BlancoColor = new Texture("ColorBlanco.png");
        B = new Sprite(BlancoColor);
        Rojo = new Texture("ColorRojo.png");
        R = new Sprite(Rojo);
        Amarillo = new Texture("ColorAmarillo.png");
        Am = new Sprite(Amarillo);
        Verde = new Texture("ColorVerde.png");
        V = new Sprite(Verde);
        Morado = new Texture("ColorMorado.png");
        M = new Sprite(Morado);
        Azul = new Texture("ColorAzul.png");
        Az = new Sprite(Azul);
        BlancoR = new Rectangle();
        RojoR= new Rectangle();
        AzulR= new Rectangle();
        VerdeR= new Rectangle();
        AmarilloR= new Rectangle();
        MoradoR= new Rectangle();
        trans = new Texture("transparency.png");
        checkno = new Texture("CheckBoxNo.png");
        checkyes = new Texture("CheckBoxYes.png");
        grade = new Texture("grade.png");
        bajo = new Rectangle();
        medio = new Rectangle();
        alto = new Rectangle();


    }
    @Override
    public void show() {
        Gdx.input.setCatchBackKey(true);
    }

    @Override
    public void render(float delta) {
        time += .5f * Gdx.graphics.getDeltaTime();
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);


        batch.enableBlending();
        cam.update();
        stage.act(delta);
        cam.position.x = 0+(500/Pixels)/2;
        cam.position.y = 0+(250/Pixels)/2;
        cam.update();
        Gdx.input.setInputProcessor(stage);
        stage.draw();
        ray.update();
        ray.setCombinedMatrix(cam.combined);
        ray.render();
        batch.begin();
if(!isCuadroColor) {
    /**Control Color**/
    ControlColorR.set(10 / Pixels, 170 / Pixels, 300 / Pixels, 70 / Pixels);
    if (Puntero.overlaps(ControlColorR)) {
        Blanco.setAlpha(0.1f);
    } else {
        Blanco.setAlpha(0f);
    }
    Blanco.setBounds(10 / Pixels, 170 / Pixels, 300 / Pixels, 70 / Pixels);
    Blanco.draw(batch);
    batch.draw(ControlColor, 10 / Pixels, 170 / Pixels, 300 / Pixels, 70 / Pixels);
    /**************/

    /**Mute**/
    MuteR.set(10 / Pixels, 90 / Pixels, 300 / Pixels, 70 / Pixels);
    if (Puntero.overlaps(MuteR)) {
        Blanco.setAlpha(0.1f);
        if (time >= .3f) {
            if (game.Mute.getInteger("Mute") == 0) {
                game.Mute.putInteger("Mute", 1);
                game.Mute.flush();
                time = 0;
            } else {
                game.Mute.putInteger("Mute", 0);
                game.Mute.flush();
                time = 0;
            }
        }
    } else {
        Blanco.setAlpha(0f);
    }
    if (game.Mute.getInteger("Mute") == 0) {
        isMute = false;
    } else {
        isMute = true;
    }
    if (isMute) {
        Blanco.setBounds(10 / Pixels, 100 / Pixels, 300 / Pixels, 70 / Pixels);
        Blanco.draw(batch);
        batch.draw(MuteYes, 25 / Pixels, 100/ Pixels, 300 / Pixels, 70 / Pixels);
    } else {
        Blanco.setBounds(10 / Pixels, 100 / Pixels, 300 / Pixels, 70 / Pixels);
        Blanco.draw(batch);
        batch.draw(MuteNo, 25 / Pixels, 100 / Pixels, 300 / Pixels, 70 / Pixels);//90 y
    }
    /**************/
    /*****Transparencia*****/
    batch.draw(trans, 25 / Pixels, 20 / Pixels, 300 / Pixels, 70 / Pixels);
    batch.draw(grade, 260 / Pixels, 20 / Pixels, 200 / Pixels, 50 / Pixels);
    bajo.set(269 / Pixels, 10/ Pixels, 20 / Pixels, 20 / Pixels);
    medio.set(343 / Pixels, 10/ Pixels, 20 / Pixels, 20 / Pixels);
    alto.set(420/ Pixels, 10/ Pixels, 20 / Pixels, 20 / Pixels);
    if(Puntero.overlaps(bajo))
    {
       MyGdxGame.Alpha.putInteger("Alpha",0);
       MyGdxGame.Alpha.flush();
    }
    if(Puntero.overlaps(medio))
    {

        MyGdxGame.Alpha.putInteger("Alpha",1);
        MyGdxGame.Alpha.flush();
    }
    if(Puntero.overlaps(alto))
    {

        MyGdxGame.Alpha.putInteger("Alpha",2);
        MyGdxGame.Alpha.flush();
    }
    switch (MyGdxGame.Alpha.getInteger("Alpha"))
    {
        case 0:
        {
            MyGdxGame.alpha = 0.2f;
            isSoft = true;
            isMedium = false;
            isStrong = false;
            break;
        }
        case 1:
        {
            MyGdxGame.alpha = 0.5f;
            isSoft = false;
            isMedium = true;
            isStrong = false;
            break;
        }
        case 2:
        {
            MyGdxGame.alpha = 0.8f;
            isSoft = false;
            isMedium = false;
            isStrong = true;
            break;
        }
    }

    if(isSoft)
    {
        batch.draw(checkyes,269 / Pixels, 10/ Pixels, 20 / Pixels, 20 / Pixels);

    }else
    {
        batch.draw(checkno,269 / Pixels, 10/ Pixels, 20 / Pixels, 20 / Pixels);
    }
    if(isMedium)
    {
        batch.draw(checkyes,343 / Pixels, 10/ Pixels, 20 / Pixels, 20 / Pixels);
    }else
    {
        batch.draw(checkno,343 / Pixels, 10/ Pixels, 20 / Pixels, 20 / Pixels);
    }
    if(isStrong)
    {
        batch.draw(checkyes,420/ Pixels, 10/ Pixels, 20 / Pixels, 20 / Pixels);
    }else
    {
        batch.draw(checkno,420/ Pixels, 10/ Pixels, 20 / Pixels, 20 / Pixels);
    }
    /**********************/
}
else
{
    CuadroColores();
}

        /********equis (salida)**********/
        batch.draw(equis,440/ Pixels,190/Pixels,50/Pixels,50/Pixels);
        Equis.set(440/ Pixels,190/Pixels,50/Pixels,50/Pixels);
        if(Puntero.overlaps(Equis))
        {
            if(isCuadroColor)
            {
                alpha = 0;
                isCuadroColor = false;
                time = 0;
            }else {
                if(time > .3f) {
                    game.setScreen(new Casa(game));
                }
            }
        }
        /********************************/
        /*******CuadroColor********/
        if(Puntero.overlaps(ControlColorR))
        {
            isCuadroColor = true;
        }

puntero();

        batch.end();
    }

    public void puntero()
    {
        Vector2 PunteroPosition = new Vector2();
        float PosicionY;
        if(Gdx.input.isTouched())
        {
            Vector2 position = new Vector2(Gdx.input.getX(),Gdx.input.getY());
            Vector2 size = new Vector2(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

            PunteroPosition.x = (((position.x*500)/size.x)/Pixels)+cam.position.x-(cam.viewportWidth/2);
            PosicionY = Gdx.graphics.getHeight()-position.y;
            PunteroPosition.y = (((PosicionY*250)/size.y)/Pixels)+cam.position.y-(cam.viewportHeight/2);

        }else
        {
            PunteroPosition.set(-100,-100);

        }
        Puntero.set(PunteroPosition.x-(5/Pixels),PunteroPosition.y-(5/Pixels),10/Pixels,10/Pixels);



    }

    public void CuadroColores()
    {
        Blanco.setAlpha(0.1f);
        Blanco.setBounds(10/Pixels,10/Pixels,400/Pixels,230/Pixels);
        Blanco.draw(batch);
        alpha += .60 * Gdx.graphics.getDeltaTime();
        if(alpha >= 1)
        {
            alpha = 1;
        }
        B.setAlpha(alpha);
        R.setAlpha(alpha);
        Az.setAlpha(alpha);
        Am.setAlpha(alpha);
        M.setAlpha(alpha);
        V.setAlpha(alpha);
if(alpha >= 1) {

    if (Puntero.overlaps(BlancoR)) {
        game.ColorControl.putInteger("Color", 0);
        game.ColorControl.flush();
    }


    if (Puntero.overlaps(RojoR)) {
        game.ColorControl.putInteger("Color", 1);
        game.ColorControl.flush();
    }



    if (Puntero.overlaps(AzulR)) {
        game.ColorControl.putInteger("Color", 2);
        game.ColorControl.flush();
    }


    if (Puntero.overlaps(AmarilloR)) {
        game.ColorControl.putInteger("Color", 3);
        game.ColorControl.flush();
    }


    if (Puntero.overlaps(MoradoR)) {
        game.ColorControl.putInteger("Color", 4);
        game.ColorControl.flush();
    }


    if (Puntero.overlaps(VerdeR)) {
        game.ColorControl.putInteger("Color", 5);
        game.ColorControl.flush();
    }
}
        B.setBounds(20 / Pixels, 140 / Pixels, 80 / Pixels, 80 / Pixels);
        BlancoR.set(20 / Pixels, 140 / Pixels, 80 / Pixels, 80 / Pixels);
        R.setBounds(150 / Pixels, 140 / Pixels, 80 / Pixels, 80 / Pixels);
        RojoR.set(150 / Pixels, 140 / Pixels, 80 / Pixels, 80 / Pixels);
        Az.setBounds(280 / Pixels, 140 / Pixels, 80 / Pixels, 80 / Pixels);
        AzulR.set(280 / Pixels, 140 / Pixels, 80 / Pixels, 80 / Pixels);
        Am.setBounds(20 / Pixels, 30 / Pixels, 80 / Pixels, 80 / Pixels);
        AmarilloR.set(20 / Pixels, 30 / Pixels, 80 / Pixels, 80 / Pixels);
        M.setBounds(150 / Pixels, 30 / Pixels, 80 / Pixels, 80 / Pixels);
        MoradoR.set(150 / Pixels, 30 / Pixels, 80 / Pixels, 80 / Pixels);
        V.setBounds(280 / Pixels, 30 / Pixels, 80 / Pixels, 80 / Pixels);
        VerdeR.set(280 / Pixels, 30 / Pixels, 80 / Pixels, 80 / Pixels);
        B.draw(batch);
        R.draw(batch);
        Az.draw(batch);
        Am.draw(batch);
        M.draw(batch);
        V.draw(batch);

        switch (game.ColorControl.getInteger("Color"))
        {
            case 0:
            {
                Blanco.setAlpha(.4f);
                Blanco.setBounds(20/Pixels,140/Pixels,80/Pixels,80/Pixels);
                Blanco.draw(batch);
                break;
            }
            case 1:
            {
                Blanco.setAlpha(.4f);
                Blanco.setBounds(150/Pixels,140/Pixels,80/Pixels,80/Pixels);
                Blanco.draw(batch);
                break;
            }
            case 2:
            {
                Blanco.setAlpha(.4f);
                Blanco.setBounds(280/Pixels,140/Pixels,80/Pixels,80/Pixels);
                Blanco.draw(batch);
                break;
            }
            case 3:
            {
                Blanco.setAlpha(.4f);
                Blanco.setBounds(20/Pixels,30/Pixels,80/Pixels,80/Pixels);
                Blanco.draw(batch);
                break;
            }
            case 4:
            {
                Blanco.setAlpha(.4f);
                Blanco.setBounds(150/Pixels,30/Pixels,80/Pixels,80/Pixels);
                Blanco.draw(batch);
                break;
            }
            case 5:
            {
                Blanco.setAlpha(alpha-.6f);
                Blanco.setBounds(280/Pixels,30/Pixels,80/Pixels,80/Pixels);
                Blanco.draw(batch);
                break;
            }
        }
        /*colores:
        0 blanco
        1 rojo
        2 azul
        3 amarillo
        4 rosa
        5 morado
         */
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        stage.dispose();
        world.dispose();
        ray.dispose();
        MuteNo.dispose();
        MuteYes.dispose();
        ControlColor.dispose();
        blanco.dispose();
        equis.dispose();
        BlancoColor.dispose();
        Rojo.dispose();
        Amarillo.dispose();
        Verde.dispose();
        Morado.dispose();
        Azul.dispose();
        trans.dispose();
        checkno.dispose();
        checkyes.dispose();
        grade.dispose();
    }
}
