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
import com.badlogic.gdx.graphics.Color;
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
    public static Preferences HojaRosa;
    public static Preferences HojaAzul;
    public static Preferences Mute;
    public static boolean ApagarMusica = false;
    public static boolean isNivelProgress1;
    public static Preferences ColorControl;
    public static Preferences Alpha;
    public static boolean NoSeguirFondo;
    public static boolean isIsNivelProgress2;

    /*Tierras*/
	public static Preferences TierrasColocadas;
	public static Preferences tierra1;
	public static Preferences tierra2;
	public static Preferences tierra3;
	public static Preferences tierra4;
	public static Preferences tierra5;
	/*Agua*/
	public static Preferences AguasColocadas;
	public static Preferences agua1;
	public static Preferences agua2;
	public static Preferences agua3;
	public static Preferences agua4;
	public static Preferences agua5;

	MyGdxGame game;
	public static final float Pixels = 30;
	public static float alpha;

	/*Cultivos*/
	public static Preferences Trigo;
	public static Preferences Maiz;
	public static Preferences Soja;
	public static Preferences Zanahoria;
	public static Preferences Cana;
	public static Preferences Algodon;

	/**Tierra1**/
	public static Preferences tierra1Year,tierra1Day,tierra1Hour,tierra1Minute,tierra1Iterator;
	public static Preferences tierra1Trigo;
	public static Preferences tierra1Maiz;
	public static Preferences tierra1Soja;
	public static Preferences tierra1Zanahoria;
	public static Preferences tierra1Cana;
	public static Preferences tierra1Algodon;
	public static Preferences tierra1Enable;


	@Override
	public void create() {
		Cinematica = Gdx.app.getPreferences("Cinematica");
		NivelisComplete = Gdx.app.getPreferences("Level");
		coins = Gdx.app.getPreferences("Coins");
		Fertilizantes = Gdx.app.getPreferences("Fertilizantes");
		HojaVerde = Gdx.app.getPreferences("HojaVerde");
		HojaRosa = Gdx.app.getPreferences("HojaRosa");
		HojaAzul = Gdx.app.getPreferences("HojaAzul");
		HojaAzul = Gdx.app.getPreferences("HojaAzulA1");
		HojaAzul = Gdx.app.getPreferences("HojaAzulA2");
		HojaRosa = Gdx.app.getPreferences("HojaRosaA1");
		HojaRosa = Gdx.app.getPreferences("HojaRosaA2");
		HojaVerde = Gdx.app.getPreferences("HojaVerdeA1");
		HojaVerde = Gdx.app.getPreferences("HojaVerdeA2");
		Mute = Gdx.app.getPreferences("Mute");
		ColorControl = Gdx.app.getPreferences("Color");
		Alpha = Gdx.app.getPreferences("Alpha");
		/********************Tierras****************/
		TierrasColocadas = Gdx.app.getPreferences("Posicion");
		tierra1 = Gdx.app.getPreferences("X");
		tierra1 = Gdx.app.getPreferences("Y");
		tierra2 = Gdx.app.getPreferences("X2");
		tierra2 = Gdx.app.getPreferences("Y2");
		tierra3 = Gdx.app.getPreferences("X3");
		tierra3 = Gdx.app.getPreferences("Y3");
		tierra4 = Gdx.app.getPreferences("X4");
		tierra4 = Gdx.app.getPreferences("Y4");
		tierra5 = Gdx.app.getPreferences("X5");
		tierra5 = Gdx.app.getPreferences("Y5");
		/******************Aguas******************/
		AguasColocadas = Gdx.app.getPreferences("Posiciones2");
		agua1 = Gdx.app.getPreferences("X6");
		agua1 = Gdx.app.getPreferences("Y6");
		agua2 = Gdx.app.getPreferences("X7");
		agua2 = Gdx.app.getPreferences("Y7");
		agua3 = Gdx.app.getPreferences("X8");
		agua3 = Gdx.app.getPreferences("Y8");
		agua4 = Gdx.app.getPreferences("X9");
		agua4 = Gdx.app.getPreferences("Y9");

		/*****************Cultivos******************/
		Trigo = Gdx.app.getPreferences("Trigo");
		Maiz = Gdx.app.getPreferences("Maiz");
		Soja = Gdx.app.getPreferences("Soja");
		Zanahoria = Gdx.app.getPreferences("Zanahoria");
		Cana = Gdx.app.getPreferences("Cana");
		Algodon = Gdx.app.getPreferences("Algodon");
		/***Tierra1*****/
		tierra1Trigo = Gdx.app.getPreferences("tierra11");
		tierra1Maiz = Gdx.app.getPreferences("tierra12");
		tierra1Soja = Gdx.app.getPreferences("tierra13");
		tierra1Zanahoria = Gdx.app.getPreferences("tierra14");
		tierra1Cana = Gdx.app.getPreferences("tierra15");
		tierra1Algodon = Gdx.app.getPreferences("tierra16");
		tierra1Enable = Gdx.app.getPreferences("tierra1");
		tierra1Year = Gdx.app.getPreferences("YearTierra1");
		tierra1Day = Gdx.app.getPreferences("DayTierra1");
		tierra1Hour = Gdx.app.getPreferences("HourTierra1");
		tierra1Minute = Gdx.app.getPreferences("MinuteTierra1");
		tierra1Iterator = Gdx.app.getPreferences("iteratorTierra1");


		if(Cinematica.getInteger("Cinematica")==0)
		{
			tierra1Enable.putBoolean("tierra1",true);
			tierra1Enable.flush();
			tierra1Trigo.putBoolean("tierra11",false);
			tierra1Trigo.flush();
			tierra1Maiz.putBoolean("tierra12",false);
			tierra1Maiz.flush();
			tierra1Soja.putBoolean("tierra13",false);
			tierra1Soja.flush();
			tierra1Zanahoria.putBoolean("tierra14",false);
			tierra1Zanahoria.flush();
			tierra1Cana.putBoolean("tierra15",false);
			tierra1Cana.flush();
			tierra1Algodon.putBoolean("tierra16",false);
			tierra1Algodon.flush();
			tierra1.putFloat("X",0.0f);
			tierra1.putFloat("Y",0.0f);
			tierra2.putFloat("X2",100.0f);
			tierra2.putFloat("Y2",100.0f);
			tierra3.putFloat("X3",200.0f);
			tierra3.putFloat("Y3",200.0f);
			tierra4.putFloat("X4",300.0f);
			tierra4.putFloat("Y4",300.0f);
			tierra5.putFloat("X5",400.0f);
			tierra5.putFloat("Y5",400.0f);
			tierra1.flush();
			tierra2.flush();
			tierra3.flush();
			tierra4.flush();
			tierra5.flush();

			agua1.putFloat("X6",500.0f);
			agua1.putFloat("Y6",500.0f);

			agua2.putFloat("X7",600.0f);
			agua2.putFloat("Y7",600.0f);

			agua3.putFloat("X8",700.0f);
			agua3.putFloat("Y8",700.0f);

			agua4.putFloat("X9",800.0f);
			agua4.putFloat("Y9",800.0f);

			agua1.flush();
			agua2.flush();
			agua3.flush();
			agua4.flush();
		}


		manager = new AssetManager();

Gdx.app.getGraphics().getFramesPerSecond();

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
		manager.load("EnemigoRight2.png",Texture.class);
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
		manager.load("HojaRosaCartel.png", Texture.class);
		manager.load("HojaAzulCartel.png", Texture.class);
		manager.load("EspadazoEffect.png",Texture.class);
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
