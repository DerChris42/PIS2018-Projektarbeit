interface Champion {

    void addItem(String item,int index);

    int getItemPrice();

    //the array is ordered the following way
    //[HP,Mana,armor,spellblock,cdr,movespeed,AttackDamage,AttackSpeed,Crit%,DPS,Range]
    double[] getStats(String champName);

    void setLevel(int lvl);

}