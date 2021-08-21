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
import com.mygdx.game.actors.Casa2Pisos;

public class MyGdxGame extends Game{
	public static AssetManager manager;
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

	/*CasasDosPisos*/
	public static Preferences CasasDosPisosColocadas;
	public static Preferences CasaDosPisos1;
	public static Preferences CasaDosPisos2;

	/*Casas*/
	public static Preferences CasasColocadas;
	public static Preferences Casa1;
	public static Preferences Casa2;


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
	public static Preferences tierra1Year2,tierra1Day2,tierra1Hour2,tierra1Minute2;
	public static Preferences tierra1Trigo;
	public static Preferences tierra1Maiz;
	public static Preferences tierra1Soja;
	public static Preferences tierra1Zanahoria;
	public static Preferences tierra1Cana;
	public static Preferences tierra1Algodon;
	public static Preferences tierra1Enable;

	/**Tierra2**/
	public static Preferences tierra2Year,tierra2Day,tierra2Hour,tierra2Minute,tierra2Iterator;
	public static Preferences tierra2Year2,tierra2Day2,tierra2Hour2,tierra2Minute2;
	public static Preferences tierra2Trigo;
	public static Preferences tierra2Maiz;
	public static Preferences tierra2Soja;
	public static Preferences tierra2Zanahoria;
	public static Preferences tierra2Cana;
	public static Preferences tierra2Algodon;
	public static Preferences tierra2Enable;

	/**Tierra3**/
	public static Preferences tierra3Year,tierra3Day,tierra3Hour,tierra3Minute,tierra3Iterator;
	public static Preferences tierra3Year2,tierra3Day2,tierra3Hour2,tierra3Minute2;
	public static Preferences tierra3Trigo;
	public static Preferences tierra3Maiz;
	public static Preferences tierra3Soja;
	public static Preferences tierra3Zanahoria;
	public static Preferences tierra3Cana;
	public static Preferences tierra3Algodon;
	public static Preferences tierra3Enable;


	/**Tierra4**/
	public static Preferences tierra4Year,tierra4Day,tierra4Hour,tierra4Minute,tierra4Iterator;
	public static Preferences tierra4Year2,tierra4Day2,tierra4Hour2,tierra4Minute2;
	public static Preferences tierra4Trigo;
	public static Preferences tierra4Maiz;
	public static Preferences tierra4Soja;
	public static Preferences tierra4Zanahoria;
	public static Preferences tierra4Cana;
	public static Preferences tierra4Algodon;
	public static Preferences tierra4Enable;
	/**Tierra5**/
	public static Preferences tierra5Year,tierra5Day,tierra5Hour,tierra5Minute,tierra5Iterator;
	public static Preferences tierra5Year2,tierra5Day2,tierra5Hour2,tierra5Minute2;
	public static Preferences tierra5Trigo;
	public static Preferences tierra5Maiz;
	public static Preferences tierra5Soja;
	public static Preferences tierra5Zanahoria;
	public static Preferences tierra5Cana;
	public static Preferences tierra5Algodon;
	public static Preferences tierra5Enable;

	/**Macetas1**/
	public static Preferences Maceta1Colocadas;
	public static Preferences Maceta1_1;
	public static Preferences Maceta1_2;
	public static Preferences Maceta1_3;
	/**Macetas2**/
	public static Preferences Maceta2Colocadas;
	public static Preferences Maceta2_1;
	public static Preferences Maceta2_2;
	public static Preferences Maceta2_3;

	/**Arbusto1**/
	public static Preferences Arbusto1Colocadas;
	public static Preferences Arbusto1_1;
	public static Preferences Arbusto1_2;
	public static Preferences Arbusto1_3;
	/**Arbusto2**/
	public static Preferences Arbusto2Colocadas;
	public static Preferences Arbusto2_1;
	public static Preferences Arbusto2_2;
	public static Preferences Arbusto2_3;

	/**CorralVaca**/
	public static Preferences Corral1Vacas,Corral2Vacas;
	public static Preferences CorralVacaColocadas;
	public static Preferences CorralVacas1;
	public static Preferences CorralVacas2;
	public static Preferences Corral1VacasAlimentadas;
	public static Preferences Corral2VacasAlimentadas;
	public static Preferences CorralVacas1Year,CorralVacas1Day,CorralVacas1Hour,CorralVacas1Minute;
	public static Preferences CorralVacas2Year,CorralVacas2Day,CorralVacas2Hour,CorralVacas2Minute;
	public static Preferences Corral1Iterator,Corral2Iterator;
	/**CorralGallinas**/
	public static Preferences Corral1Gallinas,Corral2Gallinas;
	public static Preferences CorralGallinasColocadas;
	public static Preferences CorralGallinas1;
	public static Preferences CorralGallinas2;
	public static Preferences Corral1GallinasAlimentadas;
	public static Preferences Corral2GallinasAlimentadas;
	public static Preferences CorralGallinas1Year,CorralGallinas1Day,CorralGallinas1Hour,CorralGallinas1Minute;
	public static Preferences CorralGallinas2Year,CorralGallinas2Day,CorralGallinas2Hour,CorralGallinas2Minute;
	public static Preferences Corral1GallinaIterator,Corral2GallinaIterator;
	/**Maquina de Comida**/
	public static Preferences Maquina1Gallina,Maquina1Vaca,Maquina2Gallina,Maquina2Vaca;
	public static Preferences MaquinaComidaColocadas;
	public static Preferences MaquinasComida1;
	public static Preferences MaquinasComida2;
	public static Preferences MaquinasComida1Year,MaquinasComida1Day,MaquinasComida1Hour,MaquinasComida1Minute,MaquinasComida1Iterator;
	public static Preferences MaquinasComida2Year,MaquinasComida2Day,MaquinasComida2Hour,MaquinasComida2Minute,MaquinasComida2Iterator;
	public static Preferences Maquina1Complete, Maquina2Complete;
	public static Preferences Maquina1isGallina,Maquina1isVaca,Maquina2isGallina,Maquina2isVaca;
	/**Almacen**/
	public static Preferences ComidaVacaStocks;
	public static Preferences ComidaGallinaStocks;
	public static Preferences LecheStocks;
	public static Preferences HuevosStocks;
	public static Preferences TrigoStocks;
	public static Preferences MaizStocks;
	public static Preferences SojaStocks;
	public static Preferences ZanahoriaStocks;
	public static Preferences CanaStocks;
	public static Preferences AlgodonStocks;
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
		tierra1Year2 = Gdx.app.getPreferences("Year2Tierra1");
		tierra1Day2 = Gdx.app.getPreferences("Day2Tierra1");
		tierra1Hour2 = Gdx.app.getPreferences("Hour2Tierra1");
		tierra1Minute2 = Gdx.app.getPreferences("Minute2Tierra1");
		/***Tierra2*****/
		tierra2Trigo = Gdx.app.getPreferences("tierra21");
		tierra2Maiz = Gdx.app.getPreferences("tierra22");
		tierra2Soja = Gdx.app.getPreferences("tierra23");
		tierra2Zanahoria = Gdx.app.getPreferences("tierra24");
		tierra2Cana = Gdx.app.getPreferences("tierra25");
		tierra2Algodon = Gdx.app.getPreferences("tierra26");
		tierra2Enable = Gdx.app.getPreferences("tierra2");
		tierra2Year = Gdx.app.getPreferences("YearTierra2");
		tierra2Day = Gdx.app.getPreferences("DayTierra2");
		tierra2Hour = Gdx.app.getPreferences("HourTierra2");
		tierra2Minute = Gdx.app.getPreferences("MinuteTierra2");
		tierra2Iterator = Gdx.app.getPreferences("iteratorTierra2");
		tierra2Year2 = Gdx.app.getPreferences("Year2Tierra2");
		tierra2Day2 = Gdx.app.getPreferences("Day2Tierra2");
		tierra2Hour2 = Gdx.app.getPreferences("Hour2Tierra2");
		tierra2Minute2 = Gdx.app.getPreferences("Minute2Tierra2");

		/***Tierra3*****/
		tierra3Trigo = Gdx.app.getPreferences("tierra31");
		tierra3Maiz = Gdx.app.getPreferences("tierra32");
		tierra3Soja = Gdx.app.getPreferences("tierra33");
		tierra3Zanahoria = Gdx.app.getPreferences("tierra34");
		tierra3Cana = Gdx.app.getPreferences("tierra35");
		tierra3Algodon = Gdx.app.getPreferences("tierra36");
		tierra3Enable = Gdx.app.getPreferences("tierra3");
		tierra3Year = Gdx.app.getPreferences("YearTierra3");
		tierra3Day = Gdx.app.getPreferences("DayTierra3");
		tierra3Hour = Gdx.app.getPreferences("HourTierra3");
		tierra3Minute = Gdx.app.getPreferences("MinuteTierra3");
		tierra3Iterator = Gdx.app.getPreferences("iteratorTierra3");
		tierra3Year2 = Gdx.app.getPreferences("Year2Tierra3");
		tierra3Day2 = Gdx.app.getPreferences("Day2Tierra3");
		tierra3Hour2 = Gdx.app.getPreferences("Hour2Tierra3");
		tierra3Minute2 = Gdx.app.getPreferences("Minute2Tierra3");

		/***Tierra4*****/
		tierra4Trigo = Gdx.app.getPreferences("tierra41");
		tierra4Maiz = Gdx.app.getPreferences("tierra42");
		tierra4Soja = Gdx.app.getPreferences("tierra43");
		tierra4Zanahoria = Gdx.app.getPreferences("tierra44");
		tierra4Cana = Gdx.app.getPreferences("tierra45");
		tierra4Algodon = Gdx.app.getPreferences("tierra46");
		tierra4Enable = Gdx.app.getPreferences("tierra4");
		tierra4Year = Gdx.app.getPreferences("YearTierra4");
		tierra4Day = Gdx.app.getPreferences("DayTierra4");
		tierra4Hour = Gdx.app.getPreferences("HourTierra4");
		tierra4Minute = Gdx.app.getPreferences("MinuteTierra4");
		tierra4Iterator = Gdx.app.getPreferences("iteratorTierra4");
		tierra4Year2 = Gdx.app.getPreferences("Year2Tierra4");
		tierra4Day2 = Gdx.app.getPreferences("Day2Tierra4");
		tierra4Hour2 = Gdx.app.getPreferences("Hour2Tierra4");
		tierra4Minute2 = Gdx.app.getPreferences("Minute2Tierra4");

		/***Tierra5*****/
		tierra5Trigo = Gdx.app.getPreferences("tierra51");
		tierra5Maiz = Gdx.app.getPreferences("tierra52");
		tierra5Soja = Gdx.app.getPreferences("tierra53");
		tierra5Zanahoria = Gdx.app.getPreferences("tierra54");
		tierra5Cana = Gdx.app.getPreferences("tierra55");
		tierra5Algodon = Gdx.app.getPreferences("tierra56");
		tierra5Enable = Gdx.app.getPreferences("tierra5");
		tierra5Year = Gdx.app.getPreferences("YearTierra5");
		tierra5Day = Gdx.app.getPreferences("DayTierra5");
		tierra5Hour = Gdx.app.getPreferences("HourTierra5");
		tierra5Minute = Gdx.app.getPreferences("MinuteTierra5");
		tierra5Iterator = Gdx.app.getPreferences("iteratorTierra5");
		tierra5Year2 = Gdx.app.getPreferences("Year2Tierra5");
		tierra5Day2 = Gdx.app.getPreferences("Day2Tierra5");
		tierra5Hour2 = Gdx.app.getPreferences("Hour2Tierra5");
		tierra5Minute2 = Gdx.app.getPreferences("Minute2Tierra5");

		/***CasasDosPisos***/
		CasasDosPisosColocadas = Gdx.app.getPreferences("Posiciones3");
		CasaDosPisos1 = Gdx.app.getPreferences("X10");
		CasaDosPisos1 = Gdx.app.getPreferences("Y10");
		CasaDosPisos2 = Gdx.app.getPreferences("X11");
		CasaDosPisos2 = Gdx.app.getPreferences("Y11");

		/***Casas***/
		CasasColocadas = Gdx.app.getPreferences("Posiciones4");
		Casa1 = Gdx.app.getPreferences("X12");
		Casa1 = Gdx.app.getPreferences("Y12");
		Casa2 = Gdx.app.getPreferences("X13");
		Casa2 = Gdx.app.getPreferences("Y13");

		/**Maceta1**/
		Maceta1Colocadas = Gdx.app.getPreferences("Posiciones5");
		Maceta1_1 = Gdx.app.getPreferences("X14");
		Maceta1_1 = Gdx.app.getPreferences("Y14");
		Maceta1_2 = Gdx.app.getPreferences("X15");
		Maceta1_2 = Gdx.app.getPreferences("Y15");
		Maceta1_3 = Gdx.app.getPreferences("X16");
		Maceta1_3 = Gdx.app.getPreferences("Y16");

		/**Maceta2**/
		Maceta2Colocadas = Gdx.app.getPreferences("Posiciones6");
		Maceta2_1 = Gdx.app.getPreferences("X17");
		Maceta2_1 = Gdx.app.getPreferences("Y17");
		Maceta2_2 = Gdx.app.getPreferences("X18");
		Maceta2_2 = Gdx.app.getPreferences("Y18");
		Maceta2_3 = Gdx.app.getPreferences("X19");
		Maceta2_3 = Gdx.app.getPreferences("Y19");
		/**Arbusto1**/
		Arbusto1Colocadas = Gdx.app.getPreferences("Posiciones7");
		Arbusto1_1 = Gdx.app.getPreferences("X20");
		Arbusto1_1 = Gdx.app.getPreferences("Y20");
		Arbusto1_2 = Gdx.app.getPreferences("X21");
		Arbusto1_2 = Gdx.app.getPreferences("Y21");
		Arbusto1_3 = Gdx.app.getPreferences("X22");
		Arbusto1_3 = Gdx.app.getPreferences("Y22");
		/**Arbusto2**/
		Arbusto2Colocadas = Gdx.app.getPreferences("Posiciones8");
		Arbusto2_1 = Gdx.app.getPreferences("X23");
		Arbusto2_1 = Gdx.app.getPreferences("Y23");
		Arbusto2_2 = Gdx.app.getPreferences("X24");
		Arbusto2_2 = Gdx.app.getPreferences("Y24");
		Arbusto2_3 = Gdx.app.getPreferences("X25");
		Arbusto2_3 = Gdx.app.getPreferences("Y25");
		/**Corral Vacas**/
		CorralVacaColocadas = Gdx.app.getPreferences("Posiciones9");
		CorralVacas1 = Gdx.app.getPreferences("X26");
		CorralVacas1 = Gdx.app.getPreferences("Y26");
		CorralVacas2 = Gdx.app.getPreferences("X27");
		CorralVacas2 = Gdx.app.getPreferences("Y27");
		Corral1Vacas = Gdx.app.getPreferences("Corral1Vacas");
		Corral2Vacas = Gdx.app.getPreferences("Corral2Vacas");
		Corral1VacasAlimentadas = Gdx.app.getPreferences("Corral1VacasAlimentadas");
		Corral2VacasAlimentadas = Gdx.app.getPreferences("Corral2VacasAlimentadas");
		CorralVacas1Year = Gdx.app.getPreferences("CorralVacas1Year");
		CorralVacas1Day= Gdx.app.getPreferences("CorralVacas1Day");
		CorralVacas1Hour= Gdx.app.getPreferences("CorralVacas1Hour");
		CorralVacas1Minute= Gdx.app.getPreferences("CorralVacas1Minute");
		CorralVacas2Year= Gdx.app.getPreferences("CorralVacas2Year");
		CorralVacas2Day= Gdx.app.getPreferences("CorralVacas2Day");
		CorralVacas2Hour= Gdx.app.getPreferences("CorralVacas2Hour");
		CorralVacas2Minute= Gdx.app.getPreferences("CorralVacas2Minute");
		Corral1Iterator = Gdx.app.getPreferences("Corral1Iterator");
		Corral2Iterator = Gdx.app.getPreferences("Corral2Iterator");

		/**Corral Gallinas**/
		CorralGallinasColocadas = Gdx.app.getPreferences("Posiciones10");
		CorralGallinas1 = Gdx.app.getPreferences("X28");
		CorralGallinas1 = Gdx.app.getPreferences("Y28");
		CorralGallinas2 = Gdx.app.getPreferences("X29");
		CorralGallinas2 = Gdx.app.getPreferences("Y29");
		Corral1Gallinas = Gdx.app.getPreferences("Corral1Gallinas");
		Corral2Gallinas = Gdx.app.getPreferences("Corral2Gallinas");
		Corral1GallinasAlimentadas = Gdx.app.getPreferences("Corral1GallinasAlimentadas");
		Corral2GallinasAlimentadas = Gdx.app.getPreferences("Corral2GallinasAlimentadas");
		CorralGallinas1Year = Gdx.app.getPreferences("CorralGallinas1Year");
		CorralGallinas1Day= Gdx.app.getPreferences("CorralGallinas1Day");
		CorralGallinas1Hour= Gdx.app.getPreferences("CorralGallinas1Hour");
		CorralGallinas1Minute= Gdx.app.getPreferences("CorralGallinas1Minute");
		CorralGallinas2Year= Gdx.app.getPreferences("CorralGallinas2Year");
		CorralGallinas2Day= Gdx.app.getPreferences("CorralGallinas2Day");
		CorralGallinas2Hour= Gdx.app.getPreferences("CorralGallinas2Hour");
		CorralGallinas2Minute= Gdx.app.getPreferences("CorralGallinas2Minute");
		Corral1GallinaIterator = Gdx.app.getPreferences("Corral1GallinaIterator");
		Corral2GallinaIterator = Gdx.app.getPreferences("Corral2GallinaIterator");
		/**Maquinas**/
		MaquinaComidaColocadas = Gdx.app.getPreferences("MaquinaComida");
		MaquinasComida1 = Gdx.app.getPreferences("X30");
		MaquinasComida1 = Gdx.app.getPreferences("Y30");
		MaquinasComida2 = Gdx.app.getPreferences("X31");
		MaquinasComida2 = Gdx.app.getPreferences("Y31");
		Maquina1Gallina = Gdx.app.getPreferences("Maquina1Gallina");
		Maquina2Gallina = Gdx.app.getPreferences("Maquina2Gallina");
		Maquina1Vaca = Gdx.app.getPreferences("Maquina1Vaca");
		Maquina2Vaca = Gdx.app.getPreferences("Maquina2Vaca");
		Maquina1isGallina = Gdx.app.getPreferences("Maquina1isGallina");
		Maquina2isGallina = Gdx.app.getPreferences("Maquina2isGallina");
		Maquina1isVaca = Gdx.app.getPreferences("Maquina1isVaca");
		Maquina2isVaca = Gdx.app.getPreferences("Maquina2isVaca");
		MaquinasComida1Year = Gdx.app.getPreferences("MaquinasComida1Year");
		MaquinasComida1Day = Gdx.app.getPreferences("MaquinasComida1Day");
		MaquinasComida1Hour = Gdx.app.getPreferences("MaquinasComida1Hour");
		MaquinasComida1Minute = Gdx.app.getPreferences("MaquinasComida1Minute");
		MaquinasComida1Iterator = Gdx.app.getPreferences("MaquinasComida1Iterator");
		MaquinasComida2Year = Gdx.app.getPreferences("MaquinasComida2Year");
		MaquinasComida2Day = Gdx.app.getPreferences("MaquinasComida2Day");
		MaquinasComida2Hour = Gdx.app.getPreferences("MaquinasComida2Hour");
		MaquinasComida2Minute = Gdx.app.getPreferences("MaquinasComida2Minute");
		MaquinasComida2Iterator = Gdx.app.getPreferences("MaquinasComida2Iterator");
		Maquina1Complete = Gdx.app.getPreferences("Maquina1Complete");
		Maquina2Complete = Gdx.app.getPreferences("Maquina2Complete");

		/**Alamcen**/
		ComidaVacaStocks = Gdx.app.getPreferences("ComidaVacaStocks");
		ComidaGallinaStocks = Gdx.app.getPreferences("ComidaGallinaStock");
		LecheStocks = Gdx.app.getPreferences("LecheStock");
		HuevosStocks  = Gdx.app.getPreferences("HuevosStocks");
		TrigoStocks = Gdx.app.getPreferences("TrigoStocks");
		MaizStocks = Gdx.app.getPreferences("MaizStocks");
		SojaStocks = Gdx.app.getPreferences("SojaStocks");
		ZanahoriaStocks = Gdx.app.getPreferences("ZanahoriaStocks");
		CanaStocks = Gdx.app.getPreferences("CanaStocks");
		AlgodonStocks = Gdx.app.getPreferences("AlgodonStocks");


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

			tierra2Enable.putBoolean("tierra2",true);
			tierra2Enable.flush();
			tierra2Trigo.putBoolean("tierra21",false);
			tierra2Trigo.flush();
			tierra2Maiz.putBoolean("tierra22",false);
			tierra2Maiz.flush();
			tierra2Soja.putBoolean("tierra23",false);
			tierra2Soja.flush();
			tierra2Zanahoria.putBoolean("tierra24",false);
			tierra2Zanahoria.flush();
			tierra2Cana.putBoolean("tierra25",false);
			tierra2Cana.flush();
			tierra2Algodon.putBoolean("tierra26",false);
			tierra2Algodon.flush();

			tierra3Enable.putBoolean("tierra3",true);
			tierra3Enable.flush();
			tierra3Trigo.putBoolean("tierra31",false);
			tierra3Trigo.flush();
			tierra3Maiz.putBoolean("tierra32",false);
			tierra3Maiz.flush();
			tierra3Soja.putBoolean("tierra33",false);
			tierra3Soja.flush();
			tierra3Zanahoria.putBoolean("tierra34",false);
			tierra3Zanahoria.flush();
			tierra3Cana.putBoolean("tierra35",false);
			tierra3Cana.flush();
			tierra3Algodon.putBoolean("tierra36",false);
			tierra3Algodon.flush();


			tierra4Enable.putBoolean("tierra4",true);
			tierra4Enable.flush();
			tierra4Trigo.putBoolean("tierra41",false);
			tierra4Trigo.flush();
			tierra4Maiz.putBoolean("tierra42",false);
			tierra4Maiz.flush();
			tierra4Soja.putBoolean("tierra43",false);
			tierra4Soja.flush();
			tierra4Zanahoria.putBoolean("tierra44",false);
			tierra4Zanahoria.flush();
			tierra4Cana.putBoolean("tierra45",false);
			tierra4Cana.flush();
			tierra4Algodon.putBoolean("tierra46",false);
			tierra4Algodon.flush();



			tierra5Enable.putBoolean("tierra5",true);
			tierra5Enable.flush();
			tierra5Trigo.putBoolean("tierra51",false);
			tierra5Trigo.flush();
			tierra5Maiz.putBoolean("tierra52",false);
			tierra5Maiz.flush();
			tierra5Soja.putBoolean("tierra53",false);
			tierra5Soja.flush();
			tierra5Zanahoria.putBoolean("tierra54",false);
			tierra5Zanahoria.flush();
			tierra5Cana.putBoolean("tierra55",false);
			tierra5Cana.flush();
			tierra5Algodon.putBoolean("tierra56",false);
			tierra5Algodon.flush();

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

			Casa1.putFloat("X12",900);
			Casa1.putFloat("Y12",900);
			Casa2.putFloat("X13",1000);
			Casa2.putFloat("Y13",1000);
			CasaDosPisos1.putFloat("X10",1100);
			CasaDosPisos1.putFloat("Y10",1100);
			CasaDosPisos2.putFloat("X11",1200);
			CasaDosPisos2.putFloat("Y11",1200);

			Casa1.flush();
			Casa2.flush();
			CasaDosPisos1.flush();
			CasaDosPisos2.flush();
			Maceta1_1.putFloat("X14",1300);
			Maceta1_1.putFloat("Y14",1300);
			Maceta1_1.flush();
			Maceta1_2.putFloat("X15",1400);
			Maceta1_2.putFloat("Y15",1400);
			Maceta1_2.flush();
			Maceta1_3.putFloat("X16",1500);
			Maceta1_3.putFloat("Y16",1500);
			Maceta1_3.flush();

			Maceta2_1.putFloat("X17",1600);
			Maceta2_1.putFloat("Y17",1600);
			Maceta2_1.flush();
			Maceta2_2.putFloat("X18",1700);
			Maceta2_2.putFloat("Y18",1700);
			Maceta2_2.flush();
			Maceta2_3.putFloat("X19",1800);
			Maceta2_3.putFloat("Y19",1800);
			Maceta2_3.flush();

			Arbusto1_1.putFloat("X20",1900);
			Arbusto1_1.putFloat("Y20",1900);
			Arbusto1_1.flush();
			Arbusto1_2.putFloat("X21",2000);
			Arbusto1_2.putFloat("Y21",2000);
			Arbusto1_2.flush();
			Arbusto1_3.putFloat("X22",2100);
			Arbusto1_3.putFloat("Y22",2100);
			Arbusto1_3.flush();

			Arbusto2_1.putFloat("X23",2200);
			Arbusto2_1.putFloat("Y23",2200);
			Arbusto2_1.flush();
			Arbusto2_2.putFloat("X24",2300);
			Arbusto2_2.putFloat("Y24",2300);
			Arbusto2_2.flush();
			Arbusto2_3.putFloat("X25",2400);
			Arbusto2_3.putFloat("Y25",2400);
			Arbusto2_3.flush();

			CorralVacas1.putFloat("X26",2500);
			CorralVacas1.putFloat("Y26",2500);
			CorralVacas1.flush();
			CorralVacas2.putFloat("X27",2600);
			CorralVacas2.putFloat("Y27",2600);
			CorralVacas2.flush();

			CorralGallinas1.putFloat("X28",2700);
			CorralGallinas1.putFloat("Y28",2700);
			CorralGallinas1.flush();
			CorralGallinas2.putFloat("X29",2800);
			CorralGallinas2.putFloat("Y29",2800);
			CorralGallinas2.flush();


			MaquinasComida1.putFloat("X30",2900);
			MaquinasComida1.putFloat("Y30",2900);
			MaquinasComida1.flush();
			MaquinasComida2.putFloat("X31",3000);
			MaquinasComida2.putFloat("Y31",3000);
			MaquinasComida2.flush();
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
		manager.load("EspadazoEffectIzq.png",Texture.class);
		manager.load("White.png",Texture.class);
		manager.load("X.png",Texture.class);
		manager.load("Inicia.png",Texture.class);
		manager.load("Logo1.png",Texture.class);
		manager.load("Logo2.png",Texture.class);
		manager.load("Logo3.png",Texture.class);
		manager.load("Logo4.png",Texture.class);
		manager.load("cuadradoNegro.png",Texture.class);
		manager.load("Tierral.png",Texture.class);
		manager.load("Agua.png",Texture.class);
		manager.load("Trigo.png",Texture.class);
		manager.load("Maiz.png",Texture.class);
		manager.load("Soja.png",Texture.class);
		manager.load("Zanahoria.png",Texture.class);
		manager.load("Caña.png",Texture.class);
		manager.load("Algodon.png",Texture.class);
		manager.load("FlechaVerde.png",Texture.class);
		manager.load("FlechaRoja.png",Texture.class);
		manager.load("MoveOn.png",Texture.class);
		manager.load("Maceta1.png",Texture.class);
		manager.load("Maceta2.png",Texture.class);
		manager.load("CasaDosPisos.png",Texture.class);
		manager.load("Casa.png",Texture.class);
		manager.load("BoteAguaS.png",Texture.class);
		manager.load("Arbusto2.png",Texture.class);
		manager.load("CorralVacas.png",Texture.class);
		manager.load("CorralGallinas.png",Texture.class);
		manager.load("FlechaSiguiente.png",Texture.class);
		manager.load("Gallina.png",Texture.class);
		manager.load("Vaca.png",Texture.class);
		manager.load("MaquinaComida.png",Texture.class);
		manager.load("Almacen.png",Texture.class);
		manager.load("Almacen/TrigoS.png",Texture.class);
		manager.load("Almacen/MaizS.png",Texture.class);
		manager.load("Almacen/SojaS.png",Texture.class);
		manager.load("Almacen/ZanahoriaS.png",Texture.class);
		manager.load("Almacen/CañaS.png",Texture.class);
		manager.load("Almacen/AlgodonS.png",Texture.class);
		manager.load("Almacen/Leche.png",Texture.class);
		manager.load("Almacen/Huevos.png",Texture.class);
		manager.load("Almacen/ComidaVaca.png",Texture.class);
		manager.load("Almacen/ComidaGallina.png",Texture.class);
		manager.load("Blanco.png",Texture.class);
		manager.load("Nemesis1/DereAttack.png",Texture.class);
		manager.load("Nemesis1/Derecha.png",Texture.class);
		manager.load("Nemesis1/IzqAttack.png",Texture.class);
		manager.load("Nemesis1/Izquierda.png",Texture.class);
		manager.load("Nemesis1/MuerteIzq.png",Texture.class);
		manager.load("Nemesis1/MuerteDere.png",Texture.class);
		manager.finishLoading();

		this.setScreen(new Intro(this));
	}

	@Override
	public void render () {
	super.render();
	}

	public static  AssetManager getManager()
	{
		return MyGdxGame.manager;
	}

	@Override
	public void dispose () {
		manager.dispose();

	}
}
