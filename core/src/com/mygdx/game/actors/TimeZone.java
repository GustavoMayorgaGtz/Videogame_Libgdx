package com.mygdx.game.actors;
import com.badlogic.gdx.scenes.scene2d.Actor;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TimeZone extends Actor {
    Calendar calendar;
    public static int dia, horas, minutos,segundos;

    public TimeZone()
    {
        calendar = new GregorianCalendar();
        dia =calendar.get(Calendar.DAY_OF_YEAR);
        horas = calendar.get(Calendar.HOUR_OF_DAY);
        minutos = calendar.get(Calendar.MINUTE);
        segundos = calendar.get(Calendar.SECOND);
    }
    @Override
    public void act(float delta) {


    }
}
