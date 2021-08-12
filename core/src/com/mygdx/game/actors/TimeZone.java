package com.mygdx.game.actors;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TimeZone extends Actor {
    Calendar calendar;
    public static int year,day,hour,minute;
    public static int yearS,dayS,hourS,minuteS;
    int minuteTotal = 0;
    int dayinyear;
    public static boolean calcularHora = false;
    public TimeZone()
    {
        calendar = new GregorianCalendar();
        year = calendar.get(Calendar.YEAR);
        day =calendar.get(Calendar.DAY_OF_YEAR);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);

    }
    @Override
    public void act(float delta) {


    }

    public void CalcularTiempo(int time)
    {
        if(calcularHora) {
            if (minute < (60 - time)) {
               minuteS = minute + time;
               yearS = year;
               dayS = day;
               hourS = hour;

            }else
            {
                minuteTotal = minute+time;
                minuteS = minuteTotal - 60;
                if(hour < 23)
                {
                    hourS= hour+1;

                }else
                {
                    hourS = 0;
                    if(year % 4 == 0)
                    {
                        if(year % 100 == 0)
                        {
                            dayinyear = 365;
                        }else if(year % 400 == 0)
                        {
                            dayinyear = 366;
                        }else
                        {
                            dayinyear = 365;
                        }
                    }else
                    {
                        dayinyear = 365;
                }
                    if(day < dayinyear)
                    {
                        dayS=day+1;
                    }else
                    {
                        dayS= 0;
                        yearS = year+1;
                    }
                }

            }
            Gdx.app.log("year",""+year);
            Gdx.app.log("day",""+day);
            Gdx.app.log("hour",""+hour);
            Gdx.app.log("minute",""+minute);

            Gdx.app.log("yearS",""+yearS);
            Gdx.app.log("dayS",""+dayS);
            Gdx.app.log("hourS",""+hourS);
            Gdx.app.log("mminuteS",""+minuteS);
            calcularHora = false;
        }
    }
}
