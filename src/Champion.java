public interface Champion {

    void addItem(String item);

    //the array is ordered the following way
    //[HP,armor,spellblock,cdr,movespeed,AttackDamage,AttackSpeed,Crit%,DPS,Range]
    double[] getStats(String champName) throws Exception;

    void setLevel(int lvl);

}