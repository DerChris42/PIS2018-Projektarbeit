import org.json.JSONObject;

import java.net.URL;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.function.DoubleBinaryOperator;


public class ChampionStats implements Champion {

    private String championName;
    private double hp;
    private double hpperlevel;
    private double mp;
    private double mpperlevel;
    private double movespeed;
    private double armor;
    private double armorperlevel;
    private double spellblock;
    private double spellblockperlevel;
    private double attackrange;
    private double hpregen;
    private double hpregenperlevel;
    private double mpregen;
    private double mpregenperlevel;
    private double crit;
    private double critperlevel;
    private double attackdamage;
    private double attackdamageperlevel;
    private double attackspeedoffset;
    private double attackspeedperlevel;

    public ChampionStats(String championName){
        championName = this.championName;

    }



    public void champStatsViaAPI() throws Exception {
        // build a URL
        String s = "https://euw1.api.riotgames.com/lol/static-data/v3/champions?locale=en_US&champListData=stats&dataById=false&api_key=RGAPI-cc6257d5-b980-4a9a-9b10-eae3422eed61";
        URL url = new URL(s);

        // read from the URL
        Scanner scan = new Scanner(url.openStream());
        String str = new String();
      //  while (scan.hasNext())
            str += scan.nextLine();
        scan.close();

        // build a JSON object
        JSONObject stats = new JSONObject(str);
        if (!stats.optString("status").equals("OK")){
            System.out.println("status nicht korrekt");
        }


        hp = stats.getDouble("data."+championName+".stats.hp");//.getJSONObject(championName).getJSONObject("stats").getDouble("hp");
        System.out.println(championName+" hp sind " + hp);
        hpperlevel = stats.getJSONObject("data").getJSONObject(championName).getJSONObject("stats").getDouble("hpperlevel");
        mp = stats.getJSONObject("data").getJSONObject(championName).getJSONObject("stats").getDouble("mp");
        mpperlevel = stats.getJSONObject("data").getJSONObject(championName).getJSONObject("stats").getDouble("mpperlevel");
        movespeed = stats.getJSONObject("data").getJSONObject(championName).getJSONObject("stats").getDouble("movespeed");
        armor = stats.getJSONObject("data").getJSONObject(championName).getJSONObject("stats").getDouble("armor");
        armorperlevel = stats.getJSONObject("data").getJSONObject(championName).getJSONObject("stats").getDouble("armorperlevel");
        spellblock = stats.getJSONObject("data").getJSONObject(championName).getJSONObject("stats").getDouble("spellblock");
        spellblockperlevel = stats.getJSONObject("data").getJSONObject(championName).getJSONObject("stats").getDouble("spellblockperlevel");
        attackrange = stats.getJSONObject("data").getJSONObject(championName).getJSONObject("stats").getDouble("attackrange");
        hpregen = stats.getJSONObject("data").getJSONObject(championName).getJSONObject("stats").getDouble("hpregen");
        hpregenperlevel = stats.getJSONObject("data").getJSONObject(championName).getJSONObject("stats").getDouble("hpregenperlevel");
        mpregen = stats.getJSONObject("data").getJSONObject(championName).getJSONObject("stats").getDouble("mpregen");
        mpregenperlevel = stats.getJSONObject("data").getJSONObject(championName).getJSONObject("stats").getDouble("mpregenperlevel");
        crit = stats.getJSONObject("data").getJSONObject(championName).getJSONObject("stats").getDouble("crit");
        critperlevel = stats.getJSONObject("data").getJSONObject(championName).getJSONObject("stats").getDouble("critperlevel");
        attackdamage = stats.getJSONObject("data").getJSONObject(championName).getJSONObject("stats").getDouble("attackdamage");
        attackdamageperlevel = stats.getJSONObject("data").getJSONObject(championName).getJSONObject("stats").getDouble("attackdamageperlevel");
        attackspeedoffset = stats.getJSONObject("data").getJSONObject(championName).getJSONObject("stats").getDouble("attackspeedoffset");
        attackspeedperlevel = stats.getJSONObject("data").getJSONObject(championName).getJSONObject("stats").getDouble("attackspeedperlevel");
    }

    double level = 1;
    double attackspeed;
    double dps;
    double cdr;


    //[HP,armor,spellblock,cdr,movespeed,AttackDamage,AttackSpeed,Crit%,DPS,Range]
    private void calculateStats(){
        hp = hp + (hpperlevel * (0.65+0.035*level));// + item;
        spellblock = spellblock +(spellblockperlevel * (0.65+0.035*level));// + item;
        cdr = cdr;// + item;
        movespeed = movespeed;// +item;
        if (movespeed>415 && movespeed<490){
            movespeed=movespeed*0.8+83;
        }
        if (movespeed>490){
            movespeed = movespeed * 0.5+230;
        }
        attackdamage = attackdamage + (attackdamageperlevel*(0.65+0.035*level));// +item;
        double bonusAttackSpeed = (attackspeedperlevel*(0.65+0.035*level));//+item;
        attackspeed =(0.625/1+attackspeedoffset)+(0.625/1+attackspeedoffset)*bonusAttackSpeed;
        crit = crit;// + item;
        double critDamageAmplifier = 1 + crit/100;
        dps = (attackdamage*attackspeed)* critDamageAmplifier;
    }

    public void setLevel(double lvl){
       // level = lvl;
    }

    public void addItem(String addedItem) {
    //    item = addedItem;
    }

    //the array is ordered the following way
    //[HP,armor,spellblock,cdr,movespeed,AttackDamage,AttackSpeed,Crit%,DPS,Range]
    public double[] getStats() throws Exception {
        champStatsViaAPI();
                //calculateStats();
        double[] statArray ={hp,armor,spellblock,cdr,movespeed,attackdamage,attackspeed,crit,dps,attackrange};
        return statArray;
    }

    public int getWinrate() {
        int winRate = 0;
        // winRate =

        return winRate;
    }
}
