import org.json.JSONObject;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class ChampionStats implements Champion {

    private String championName;
    private double hp;
    private double hpperlevel;
    private double mana;
    private double manaperlevel;
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
    int level = 1;
    double attackspeed;
    double dps;
    double cdr;
    private JSONObject stats;
    private String[] itemArray = new String[6];
    double itemHP=0;
    double itemMana=0;
    double itemArmor=0;
    double itemSpellblock=0;
    double itemcdr=0;
    double itemMovespeed=0;
    double itemAttackDamage=0;
    double itemAttackSpeed=0;
    double itemCrit=0;
    double itemAP=0;
    double itemMovespeedPercentModifier=0;
    boolean hasInfinityEdge=false;
    int itemPrice=0;


    public ChampionStats(){
        try {
            callRiotGamesAPI();
        } catch (Exception e) {
            e.printStackTrace();
        }
        itemMap.put("No Item", () -> {});
        itemMap.put("Infinity Edge", () -> {itemAttackDamage += 80;itemPrice+=3700;hasInfinityEdge=true;});
        itemMap.put("Death's Dance",() -> {itemAttackDamage += 80;itemcdr+=10;itemPrice+=3500;});
        itemMap.put("The Bloodthirster",() -> {itemAttackDamage += 80;itemPrice+=3500;/*lifesteal 20*/});
        itemMap.put("Essence Reaver",() -> {itemAttackDamage += 70;itemcdr+=20;itemMana+=300;itemPrice+=3200;});
        itemMap.put("Stormrazor",() -> {itemAttackDamage += 70;itemAttackSpeed+=30;itemPrice+=3200 ;});
        itemMap.put("Mercurial Scimitar",() -> {itemAttackDamage += 65; itemSpellblock+=35;itemPrice+=3600 ;/*lifesteal 10*/});
        itemMap.put("The Black Cleaver",() -> {itemAttackDamage+=40;itemcdr+=20;itemHP+=400;itemPrice+=3000 ;});
        itemMap.put("B. F. Sword",() -> {itemAttackDamage+=40;itemPrice+=1300 ;});
        itemMap.put("Blade of the Ruined King",() -> {itemAttackDamage+=40;itemAttackSpeed+=25;itemPrice+=3200;/*lifesteal 12*/});
        itemMap.put("Guinsoo's Rageblade",() -> {itemAP+=25;itemAttackDamage+=25;itemAttackSpeed+=25;itemPrice+=3300;});
        itemMap.put("Nashor's Tooth",() -> {itemAP+=80;attackspeed+=50;itemcdr+=20;itemPrice+=3000;});
        itemMap.put("Phantom Dancer",() -> {itemAttackSpeed+=45;itemCrit+=30;itemMovespeedPercentModifier+=5;itemPrice+=2800;});
        itemMap.put("Trinity Force",() -> {itemAttackDamage+=25;itemAttackSpeed+=40;itemcdr+=20;itemMovespeedPercentModifier+=5;itemHP+=250;itemMana+=250;itemPrice+=3733;});
        itemMap.put("Berserker's Greaves",() -> {itemAttackSpeed+=35;itemMovespeed+=45;itemPrice+=1100;});
        itemMap.put("Guardian Angel",() -> {itemAttackDamage+=45;itemArmor+=40;itemPrice+=2800;});
    }

    public void callRiotGamesAPI() throws Exception {

        String s = "https://euw1.api.riotgames.com/lol/static-data/v3/champions?locale=en_US&champListData=stats&dataById=false&api_key=RGAPI-cc6257d5-b980-4a9a-9b10-eae3422eed61";
        URL url = new URL(s);

        Scanner scan = new Scanner(url.openStream());
        String str = new String();
        while (scan.hasNext()) {
            str += scan.nextLine();
        }
        scan.close();

        stats = new JSONObject(str);
    }

    private void getStatsFromJSON(){

        hp = stats.getJSONObject("data").getJSONObject(championName).getJSONObject("stats").getDouble("hp");
        mana = stats.getJSONObject("data").getJSONObject(championName).getJSONObject("stats").getDouble("mpperlevel");
        manaperlevel = stats.getJSONObject("data").getJSONObject(championName).getJSONObject("stats").getDouble("mp");
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
        cdr = 0; //neccessary! wizjout it cdr would stack up with each comparison
    }

    Map<String,Runnable> itemMap = new HashMap<>();

    private void calculateItemStats(){
        itemHP=0;
        itemMana=0;
        itemArmor=0;
        itemSpellblock=0;
        itemcdr=0;
        itemMovespeed=0;
        itemAttackDamage=0;
        itemAttackSpeed=0;
        itemCrit=0;
        itemPrice=0;
        itemAP=0;
        itemMovespeedPercentModifier=0;
        hasInfinityEdge=false;

        for (int i = 0;i<6;i++){
            if (itemArray[i]==null){itemArray[i]="No Item";}
            itemMap.get(itemArray[i]).run();
        }
    }

    //[HP,Mana,armor,spellblock,cdr,movespeed,AttackDamage,AttackSpeed,Crit%,DPS,Range]
    private void calculateStats(){
        hp = hp + hpperlevel * (level-1) * (0.7025+0.0175*(level-1))+itemAttackDamage;
        mana = mana + manaperlevel * (level-1) * (0.7025+0.0175*(level-1))+itemMana;
        armor = armor + armorperlevel * (level-1) * (0.7025+0.0175*(level-1))+itemArmor;
        spellblock = spellblock +(spellblockperlevel * (level-1) * (0.7025+0.0175*(level-1)))+itemSpellblock;
        cdr = cdr + itemcdr;
        if(cdr>40){cdr=40;}
        movespeed = movespeed+itemMovespeed+(movespeed*(itemMovespeedPercentModifier/100));
        if (movespeed>415 && movespeed<490){
            movespeed=movespeed*0.8+83;
        }
        if (movespeed>490){
            movespeed = movespeed * 0.5+230;
        }
        attackdamage = attackdamage + (attackdamageperlevel* (level-1) * (0.7025+0.0175*(level-1)))+itemAttackDamage;
        double bonusAttackSpeed = ((attackspeedperlevel/100) * (level-1) * (0.7025+0.0175*(level-1)))+(itemAttackSpeed/100);
        attackspeed =(0.625/1-attackspeedoffset)+(0.625/1-attackspeedoffset)*bonusAttackSpeed;
        if (hasInfinityEdge){
            crit = (crit + itemCrit)*2;
        }
        else {
            crit = crit + itemCrit;
        }
        double critDamageAmplifier = 1 + crit/100;
        dps = (attackdamage*attackspeed)* critDamageAmplifier;
        if(championName.equals("Tristana")){
            attackrange+= 8*(level-1);
        }
    }

    public void setLevel(int lvl){
        level = lvl;
    }

    public void addItem(String addedItem,int index) {
        itemArray[index-1] = addedItem;
    }

    //the array is ordered the following way
    //[HP,Mana,armor,spellblock,cdr,movespeed,AttackDamage,AttackSpeed,Crit%,DPS,Range]
    public double[] getStats(String champName){
        championName = champName;
        getStatsFromJSON();
        calculateItemStats();
        calculateStats();
        double[] statArray ={hp,mana,armor,spellblock,cdr,movespeed,attackdamage,attackspeed,crit,dps,attackrange,itemPrice};
       // final int[] intStatArray = Arrays.stream(statArray).mapToInt(i -> (int) i).toArray();
        return statArray;
    }

    public int getItemPrice(){
        return itemPrice;
    }
}
