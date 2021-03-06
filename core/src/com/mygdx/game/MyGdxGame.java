package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationLogger;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends Game{
	private AssetManager manager;
	public static Preferences coins;
 	public static  int CoinObjects;
    public static Preferences NivelisComplete;
    public static Preferences Fertilizantes;
    public static Preferences Cinematica;
    public static Preferences HojaVerde;
    public static boolean ApagarMusica = false;

	MyGdxGame game;
	public static final float Pixels = 30;


	@Override
	public void create() {
		Cinematica = Gdx.app.getPreferences("Cinematica");
		NivelisComplete = Gdx.app.getPreferences("Level");
		coins = Gdx.app.getPreferences("Coins");
		Fertilizantes = Gdx.app.getPreferences("Fertilizantes");
		HojaVerde = Gdx.app.getPreferences("HojaVerde");
		HojaVerde = Gdx.app.getPreferences("HojaVerdeA1");
		HojaVerde = Gdx.app.getPreferences("HojaVerdeA2");
		manager = new AssetManager();

Gdx.app.getGraphics().getFramesPerSecond();
		//manager.load("correrizq.p", ParticleEffect.class);
		manager.load("greatBeattle.ogg", Music.class);
		manager.load("Fuego.mp3", Music.class);
		manager.load("PisoTime.mp3",Music.class);
		manager.load("fondo.png",Texture.class);
		manager.load("pincho.png",Texture.class);
		manager.load("llanurafondo.png",Texture.class);
		manager.load("pisoTime.png",Texture.class);
		manager.load("pisoTimeDes.png",Texture.class);
		manager.load("PisoMov.png",Texture.class);
		manager.load("Agarradera.png",Texture.class);
		manager.load("AgarraderaIzq.png",Texture.class);
		manager.load("Adere.png",Texture.class);
		manager.load("WalkRight.png",Texture.class);
		manager.load("PSD.png",Texture.class);
        manager.load("Cubo.png",Texture.class);
		manager.load("CuboS(1).png",Texture.class);
		manager.load("SaltoL.png",Texture.class);
		manager.load("PSL.png",Texture.class);
		manager.load("SaltoR.png",Texture.class);
		manager.load("WalkLeft.png",Texture.class);
        manager.load("c.png",Texture.class);
		manager.load("Caja(2).png",Texture.class);
		manager.load("decoracion(1).png",Texture.class);
		manager.load("decoracion(2).png",Texture.class);
        manager.load("Fuego.png",Texture.class);
        manager.load("sierra.png",Texture.class);
		manager.load("PersonajeEspadazoDerecho.png",Texture.class);
		manager.load("PersonajeEspadazoIzquierdo.png",Texture.class);
		manager.load("EnemigoLeft.png",Texture.class);
		manager.load("EnemigoRight.png",Texture.class);
		manager.load("Enemigo2Left.png",Texture.class);
		manager.load("Enemigo2Right.png",Texture.class);
		manager.load("EnemigoVoladorDere.png",Texture.class);
		manager.load("EnemigoVoladorIzq.png",Texture.class);
		manager.load("BotonM.png",Texture.class);
		manager.load("BotonMP.png",Texture.class);
		manager.load("BotonM(2).png",Texture.class);
		manager.load("BotonMP(1).png",Texture.class);
        manager.load("PisoGreen/PisoGreenAplastador.png",Texture.class);
        manager.load("PinchosGravity.png",Texture.class);
		manager.load("PlataformaCir.png",Texture.class);
        manager.load("PersonajeKill.png",Texture.class);
        manager.load("White.png",Texture.class);
        manager.load("Punto.png",Texture.class);
        manager.load("center.png",Texture.class);
        manager.load("E1KR.png",Texture.class);
		manager.load("E1KL.png",Texture.class);
		manager.load("E2KR.png",Texture.class);
		manager.load("E2KL.png",Texture.class);
		manager.load("ProgressBar1.png",Texture.class);
		manager.load("ProgressBar2.png",Texture.class);
		manager.load("Portal.png",Texture.class);
		manager.load("Coin.png",Texture.class);
		manager.load("mimido.png",Texture.class);
		manager.load("ParajoFlyL.png",Texture.class);
		manager.load("ParajoFlyR.png",Texture.class);
		manager.load("ParajoStaticL.png",Texture.class);
		manager.load("ParajoStaticD.png",Texture.class);
		manager.load("Bloquerompible.png", Texture.class);
		manager.load("BRAnimation.png", Texture.class);
		manager.load("Tienda.png", Texture.class);
		manager.load("Fertilizante.png", Texture.class);
		manager.load("HojaVerdeCartel.png", Texture.class);

		manager.finishLoading();
		this.setScreen(new Intro(this));
	}

	@Override
	public void render () {
	super.render();
	}

	public AssetManager getManager()
	{
		return manager;
	}

	@Override
	public void dispose () {
		manager.dispose();

	}
}
